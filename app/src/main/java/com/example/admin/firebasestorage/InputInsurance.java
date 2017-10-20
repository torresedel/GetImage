package com.example.admin.firebasestorage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputInsurance extends AppCompatActivity {

    @BindView(R.id.spinnerInsuranceInput_type)
    Spinner spinnerInsuranceInputType;
    @BindView(R.id.etInsuranceInput_companyName)
    EditText etInsuranceInputCompanyName;
    @BindView(R.id.etInsuranceInput_packageName)
    EditText etInsuranceInputPackageName;
    @BindView(R.id.etInsuranceInput_packageDetailsUrl)
    EditText etInsuranceInputPackageDetailsUrl;
    @BindView(R.id.btnInsertInsurance_submitInsurance)
    Button btnInsertInsuranceSubmitInsurance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_insurance);
        ButterKnife.bind(this);

        setView();
    }

    private void setView() {
        btnInsertInsuranceSubmitInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etInsuranceInputCompanyName.getText().toString().isEmpty() &&
                        etInsuranceInputPackageName.getText().toString().isEmpty() &&
                        etInsuranceInputPackageDetailsUrl.getText().toString().isEmpty()) {
                    InsuranceInfoClass insuranceInfo = new InsuranceInfoClass(
                            spinnerInsuranceInputType.getSelectedItem().toString(),
                            etInsuranceInputCompanyName.getText().toString(),
                            etInsuranceInputPackageName.getText().toString(),
                            etInsuranceInputPackageDetailsUrl.getText().toString());
                }
            }
        });

    }
}
