package com.example.admin.firebasestorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnInsertInsuranceInfo)
    Button btnInsertInsuranceInfo;
    @BindView(R.id.btnInsertPtoInfo)
    Button btnInsertPtoInfo;

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
    }
}
