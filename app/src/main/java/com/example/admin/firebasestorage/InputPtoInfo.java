package com.example.admin.firebasestorage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputPtoInfo extends AppCompatActivity {

    @BindView(R.id.etPtoInput_totalPto)
    EditText etPtoInputTotalPto;
    @BindView(R.id.etPtoInput_usedPto)
    EditText etPtoInputUsedPto;
    @BindView(R.id.etPtoInput_remainingPto)
    EditText etPtoInputRemainingPto;
    @BindView(R.id.btnSubmitPtoInfo)
    Button btnSubmitPtoInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pto_info);
        ButterKnife.bind(this);

        setView();
    }

    private void setView() {
        btnSubmitPtoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPtoInputTotalPto.getText().toString().isEmpty() &&
                        etPtoInputUsedPto.getText().toString().isEmpty() &&
                        etPtoInputUsedPto.getText().toString().isEmpty()) {
                    PtoInfoClass ptoInfo = new PtoInfoClass(
                            Float.valueOf(etPtoInputTotalPto.getText().toString()),
                            Float.valueOf(etPtoInputUsedPto.getText().toString()),
                            Float.valueOf(etPtoInputRemainingPto.getText().toString()));
                }
            }
        });
    }
}
