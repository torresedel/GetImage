package com.example.admin.firebasestorage;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputInterviewInfo extends AppCompatActivity {
    private static final String TAG = "InputInterviewInfoTag";

    @BindView(R.id.etInterview_title)
    EditText etInterviewTitle;
    @BindView(R.id.etInterview_date)
    EditText etInterviewDate;
    @BindView(R.id.etInterview_time)
    EditText etInterviewTime;
    @BindView(R.id.etInterview_interviewerNames)
    EditText etInterviewInterviewerNames;
    @BindView(R.id.etInterview_clientName)
    EditText etInterviewClientName;
    @BindView(R.id.etInterview_vendorName)
    EditText etInterviewVendorName;
    @BindView(R.id.etInterview_projectCity)
    EditText etInterviewProjectCity;
    @BindView(R.id.etInterview_projectState)
    EditText etInterviewProjectState;
    @BindView(R.id.etInterview_projectDuration)
    EditText etInterviewProjectDuration;
    @BindView(R.id.etInterview_availabilityDate)
    EditText etInterviewAvailabilityDate;
    @BindView(R.id.etInterview_clientWebsite)
    EditText etInterviewClientWebsite;
    @BindView(R.id.btnInputInterviewInfo)
    Button btnInputInterviewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_interview_info);
        ButterKnife.bind(this);

        btnInputInterviewInfo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                setBtn();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setBtn() {
        if (!etInterviewTitle.getText().toString().isEmpty() &&
                !etInterviewDate.getText().toString().isEmpty() &&
                !etInterviewTime.getText().toString().isEmpty() &&
                !etInterviewInterviewerNames.getText().toString().isEmpty() &&
                !etInterviewClientName.getText().toString().isEmpty() &&
                !etInterviewVendorName.getText().toString().isEmpty() &&
                !etInterviewProjectCity.getText().toString().isEmpty() &&
                !etInterviewProjectState.getText().toString().isEmpty() &&
                !etInterviewProjectDuration.getText().toString().isEmpty() &&
                !etInterviewAvailabilityDate.getText().toString().isEmpty() &&
                !etInterviewClientWebsite.getText().toString().isEmpty()) {
            Log.d(TAG, "setBtn: ");

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            boolean flag = true;
            Calendar interviewCalendar = null;

            try {

                interviewCalendar = Calendar.getInstance();
                interviewCalendar.setTime(df.parse(etInterviewDate.getText().toString() + " "
                        + etInterviewTime.getText().toString()));

            } catch (ParseException e) {
                e.printStackTrace();
                Toast.makeText(this, "Wrong Date", Toast.LENGTH_SHORT).show();
                flag = false;
            }

            if (flag) {
                Log.d(TAG, "setBtn: INSIDE FLAG");
                InterviewInfoClass interviewInfo = new InterviewInfoClass(etInterviewTitle.getText().toString(),
                        interviewCalendar.getTime(), etInterviewInterviewerNames.getText().toString(),
                        etInterviewVendorName.getText().toString(), etInterviewVendorName.getText().toString(),
                        etInterviewProjectCity.getText().toString() + ", " + etInterviewProjectState.getText().toString(),
                        etInterviewProjectDuration.getText().toString(), etInterviewAvailabilityDate.getText().toString(),
                        etInterviewClientWebsite.getText().toString());
                Log.d(TAG, "setBtn: " + interviewInfo.getClientName());

                Toast.makeText(this, "Interview Info Submitted", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(this, "Error Submitting", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Empty Fields", Toast.LENGTH_LONG).show();
    }
}
