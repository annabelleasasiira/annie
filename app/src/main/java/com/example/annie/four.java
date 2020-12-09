package com.example.annie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class four extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        TextView textView=findViewById(R.id.textView2);
        AssetManager assetManager = getAssets();
        InputStream files;

        {
            try{
                files= assetManager.open("ann.c");

            } catch (IOException e){
                e.printStackTrace();
            }


            textView.setText((CharSequence) textView);
        }
    }
}
