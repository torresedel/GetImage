package com.example.admin.firebasestorage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComposeEmailActivity extends AppCompatActivity {

    private static final String TAG = "ComposeEmailActivityTag";
    @BindView(R.id.tvRecipient)
    TextView tvRecipient;
    @BindView(R.id.etBody)
    EditText etBody;
    @BindView(R.id.btnSendEmail)
    Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_email_ativity);
        ButterKnife.bind(this);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etBody.getText().toString().isEmpty()) {
                    etBody.setText("");
                } else {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, tvRecipient.getText().toString());
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email Test");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, etBody.getText().toString());

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                        finish();
                        Log.d(TAG, "onClick: Email Sent");
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(v.getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
