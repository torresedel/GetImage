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
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputTodayAssignment extends AppCompatActivity {
    private static final String TAG = "InputTodayAssignmentTag";
    List<String> assignmentLinks;

    @BindView(R.id.etTodayAssignment_title)
    EditText etTodayAssignmentTitle;
    @BindView(R.id.etTodayAssignment_description)
    EditText etTodayAssignmentDescription;
    @BindView(R.id.etTodayAssignment_links)
    EditText etTodayAssignmentLinks;
    @BindView(R.id.etTodayAssignment_date)
    EditText etTodayAssignmentDate;
    @BindView(R.id.etTodayAssignment_dueDate)
    EditText etTodayAssignmentDueDate;
    @BindView(R.id.btnAddLink)
    Button btnAddLink;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_today_assignment);
        ButterKnife.bind(this);

        assignmentLinks = new ArrayList<>();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                setSubmit();
            }
        });
        btnAddLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etTodayAssignmentLinks.getText().toString().isEmpty()) {
                    assignmentLinks.add(etTodayAssignmentLinks.getText().toString());
                    Toast.makeText(InputTodayAssignment.this, Integer.toString(assignmentLinks.size()), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(InputTodayAssignment.this, "Empty Link", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setSubmit() {

        if (!etTodayAssignmentTitle.getText().toString().isEmpty() &&
                !etTodayAssignmentDescription.getText().toString().isEmpty() &&
                !etTodayAssignmentDate.getText().toString().isEmpty() &&
                !etTodayAssignmentDueDate.getText().toString().isEmpty()) {

            if (assignmentLinks.size() == 0) {
                Log.d(TAG, "setSubmit: assignmentLinks.size() == 0");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                try {//////////////////////////////////////////////////////////////SET OBJECT WITHOUT LINKS
                    TodayAssignment todayAssignment = new TodayAssignment(etTodayAssignmentTitle.getText().toString(),
                            etTodayAssignmentDescription.getText().toString(), df.parse(etTodayAssignmentDate.getText().toString()),
                            df.parse(etTodayAssignmentDueDate.getText().toString()));
                    Toast.makeText(this, "Submit Success", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "setSubmit: " + todayAssignment.toString());

                } catch (ParseException e) {
                    e.printStackTrace();
                    if (e.getErrorOffset() == 0) {
                        Toast.makeText(this, "Wrong Date", Toast.LENGTH_SHORT).show();
                    }
                    Log.d(TAG, "setSubmit: " + e);
                }
            } else {
                java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("MM/dd/yyyy");
                try {///////////////////////////////////////////////////////////////SET OBJECT WITH LINKS
                    TodayAssignment todayAssignment = new TodayAssignment(etTodayAssignmentTitle.getText().toString(),
                            etTodayAssignmentDescription.getText().toString(), assignmentLinks,
                            df.parse(etTodayAssignmentDate.getText().toString()),
                            df.parse(etTodayAssignmentDueDate.getText().toString()));
                    Toast.makeText(this, "Submit Success", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "setSubmit: " + todayAssignment.toString());
                    Log.d(TAG, "setSubmit: "+df.format(todayAssignment.getAssignDate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                    Log.d(TAG, "onClick: " + e);
                }
            }
        } else {
            Log.d(TAG, "setSubmit: ERROR");
        }
    }
}
