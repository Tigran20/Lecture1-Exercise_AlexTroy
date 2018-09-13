package com.example.system.aam_alextroy_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.system.aam_alextroy_1.MainActivity.MESSAGE;

public class SecondActivity extends AppCompatActivity {

    public static final String SUBJECT = "Hello, Android Academy MSK!";
    public static final String BODY = "We love Android!";
    public static final String TO = "andr.academy.msk@gmail.com";

    private TextView textView;
    private Button emailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tv_message);
        emailBtn = findViewById(R.id.btn_email);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MESSAGE);
        textView.setText(text);

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", TO, null));

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, SUBJECT);
                emailIntent.putExtra(Intent.EXTRA_TEXT, BODY);

                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.no_email_app_found, Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
