package com.example.admin.firebasestorage;

import android.app.Dialog;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivityTag";

    @BindView(R.id.btnInsertInsuranceInfo)
    Button btnInsertInsuranceInfo;
    @BindView(R.id.btnInsertPtoInfo)
    Button btnInsertPtoInfo;
    @BindView(R.id.btnRequestPto)
    Button btnRequestPto;

    EditText etDateFrom;
    EditText etDateTo;
    private Calendar calendarFrom;
    private Calendar calendarTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setView();

    }

    private void setView() {
        btnInsertInsuranceInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), InputInsurance.class);
                startActivity(intent);
            }
        });
        btnInsertPtoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), InputPtoInfo.class);
                startActivity(intent);
            }
        });
        btnRequestPto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtnRequestListener(v);
            }
        });

    }

    private void setBtnRequestListener(View v) {
        final Dialog[] datepicker_dialog = new Dialog[2];
        final Dialog requestpto_dialog = new Dialog(v.getContext());
        requestpto_dialog.setTitle("Request PTO");
        requestpto_dialog.setContentView(R.layout.alert_dialog_request_pto);

        etDateFrom = requestpto_dialog.findViewById(R.id.etDateFrom);
        etDateFrom.setKeyListener(null);
        etDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepicker_dialog[0] = new Dialog(v.getContext());

                datepicker_dialog[0].setTitle("Date Picker");
                datepicker_dialog[0].setContentView(R.layout.date_picker_layout);

                final DatePicker datePicker = datepicker_dialog[0].findViewById(R.id.datePicker);
                datePicker.setMinDate(System.currentTimeMillis() - 1000);
                Button setDate = datepicker_dialog[0].findViewById(R.id.setDate);
                setDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        datepicker_dialog[0].dismiss();
                        calendarFrom = Calendar.getInstance();
                        calendarFrom.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                        etDateFrom.setText(sdf.format(calendarFrom.getTime()));
                        etDateTo.setText("");
                        calendarTo = null;
                    }
                });
                datepicker_dialog[0].show();
            }
        });
        etDateTo = requestpto_dialog.findViewById(R.id.etDateTo);
        etDateTo.setKeyListener(null);
        etDateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepicker_dialog[1] = new Dialog(v.getContext());

                datepicker_dialog[1].setTitle("Date Picker");
                datepicker_dialog[1].setContentView(R.layout.date_picker_layout);

                final DatePicker datePicker = datepicker_dialog[1].findViewById(R.id.datePicker);
                Calendar maxTo = calendarFrom;
                maxTo.add(Calendar.DAY_OF_MONTH, 1);
                datePicker.setMinDate(maxTo.getTime().getTime());
                Button setDate = datepicker_dialog[1].findViewById(R.id.setDate);
                setDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        datepicker_dialog[1].dismiss();

                        calendarTo = Calendar.getInstance();
                        calendarTo.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                        etDateTo.setText(sdf.format(calendarTo.getTime()));
                    }
                });
                datepicker_dialog[1].show();
            }
        });
        final EditText etDescription = requestpto_dialog.findViewById(R.id.etRequestPto_description);

        Button btnSubmit = requestpto_dialog.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        if(etDateFrom.getText().toString().isEmpty() ||
                                etDateTo.getText().toString().isEmpty() ||
                                etDescription.getText().toString().isEmpty()){
                            Toast.makeText(requestpto_dialog.getContext(), "Empty Fields", Toast.LENGTH_SHORT).show();
                        }else{
                            PTORequestInfoClass ptoRequestInfo = new PTORequestInfoClass(calendarFrom.getTime(),
                                    calendarTo.getTime(), etDescription.getText().toString(), "Pending");
                        }
            }
        });
        Button btnCancel = requestpto_dialog.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestpto_dialog.dismiss();
            }
        });

        requestpto_dialog.show();
    }
}
