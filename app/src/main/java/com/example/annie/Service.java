package com.example.annie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Service extends AppCompatActivity implements View.OnClickListener {

    Button Start, Stop,Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Start = findViewById(R.id.Start);
        Stop = findViewById(R.id.Stop);
        Next =  findViewById(R.id.Next);

        Start.setOnClickListener(this);
        Stop.setOnClickListener(this);
        Next.setOnClickListener(this);


    }
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.Start:

                startService(new Intent(this, MyService.class));
                break;
            case R.id.Stop:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.Next:
                Intent intent=new Intent(this,Additional.class);
                startActivity(intent);
                break;
        }
    }
}
