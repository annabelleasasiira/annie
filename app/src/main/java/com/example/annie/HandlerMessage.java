package com.example.annie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerMessage extends AppCompatActivity {

    private Button handlerButton;

    private TextView handlerTextView;

    private Handler mainThreadHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_message);


        mainThreadHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 1)
                {

                    handlerTextView.setText("Above button has been clicked.");
                }
            }
        };


        handlerButton = (Button)findViewById(R.id.handlerButton);
        handlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WorkerThread workerThread = new WorkerThread();
                workerThread.start();
            }
        });


        handlerTextView = (TextView)findViewById(R.id.handlerTextView);
    }


    private class WorkerThread extends Thread{
        @Override
        public void run() {

            Message childThreadMessage = new Message();
            childThreadMessage.what = 1;

            mainThreadHandler.sendMessage(childThreadMessage);
        }
    }
}

