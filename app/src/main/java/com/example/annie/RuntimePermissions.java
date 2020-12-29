package com.example.annie;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.annie.R;

public class RuntimePermissions extends AppCompatActivity {


    TextView textView;
    EditText editTextPhone;
    EditText editTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permissions);

        textView = (TextView) findViewById(R.id.textView);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(
                        editTextPhone.getText().toString(),
                        null,
                        editTextMessage.getText().toString(),
                        null,
                        null);

                textView.setText("SMS sent");
            }
        });
    }



}
