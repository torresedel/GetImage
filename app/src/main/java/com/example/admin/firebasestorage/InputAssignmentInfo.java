package com.example.admin.firebasestorage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputAssignmentInfo extends AppCompatActivity {
    private static final String TAG = "InputAssignmentInfoTag";

    @BindView(R.id.etAssignment_title)
    EditText etAssignmentTitle;
    @BindView(R.id.etAssignment_grade)
    EditText etAssignmentGrade;
    @BindView(R.id.etAssignment_totalGrade)
    EditText etAssignmentTotalGrade;
    @BindView(R.id.etAssignment_feedback)
    EditText etAssignmentFeedback;
    @BindView(R.id.btnAssignment_submit)
    Button btnAssignmentSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_assignment_info);
        ButterKnife.bind(this);

        btnAssignmentSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //IF Fields not empty
                if(!etAssignmentTitle.getText().toString().isEmpty() &&
                        !etAssignmentGrade.getText().toString().isEmpty() &&
                        !etAssignmentTotalGrade.getText().toString().isEmpty() &&
                        !etAssignmentFeedback.getText().toString().isEmpty()){
                    //IF Grade > Total || Total > 1000
                    if(Integer.valueOf(etAssignmentGrade.getText().toString()) >
                            Integer.valueOf(etAssignmentTotalGrade.getText().toString()) ||
                            Integer.valueOf(etAssignmentTotalGrade.getText().toString()) > 1000){
                        Toast.makeText(InputAssignmentInfo.this, "Incorrect Fields", Toast.LENGTH_SHORT).show();
                    }else{
                        AssignmentInfoClass assignmentInfo = new AssignmentInfoClass();
                        assignmentInfo.setTitleAssignment(etAssignmentTitle.getText().toString());
                        assignmentInfo.setGrade(Float.valueOf(etAssignmentGrade.getText().toString())
                        / Float.valueOf(etAssignmentTotalGrade.getText().toString()));
                        assignmentInfo.setFeedback(etAssignmentFeedback.getText().toString());
                        Log.d(TAG, "onClick: " + assignmentInfo.toString());
                    }
                }else{
                    Toast.makeText(InputAssignmentInfo.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
