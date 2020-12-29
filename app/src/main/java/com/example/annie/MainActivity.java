package com.example.annie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Annabelle Asasiira - 2018/BIT/027/PS

    //annie application


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(receive,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }


    private MyReceiver receive = new MyReceiver() {

        public void onReceive(Context c, Intent i) {
            int r = i.getIntExtra("level", 0);
            ProgressBar bar = findViewById(R.id.Bar);
            bar.setProgress(r);
            TextView view = findViewById(R.id.textView6);
            view.setText("charge the phone" + Integer.toString(r) + "%");

        }




        public void sendMessage(View view) {
            EditText message = (EditText) findViewById(R.id.message);
            Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
            intent.putExtra("MESSAGE", message.getText().toString());
            startActivity(intent);
            message.setText("");

        }

        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();

            inflater.inflate(R.menu.menuannie, menu);

            return true;

        }

        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.menu_one) {
                Intent myintent = new Intent(MainActivity.this, four.class);
                startActivity(myintent);
                return true;
            }

            if (id == R.id.menu_Two) {
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setData(Uri.parse("mailto:"));
                String to[] = {"edithna@yahoo.com", "pearln@gmail.com", "rkimera@must.ac.ug"};
                intent2.putExtra(Intent.EXTRA_EMAIL, to);
                intent2.putExtra(Intent.EXTRA_SUBJECT, "deadline");
                intent2.putExtra(Intent.EXTRA_TEXT, "Finish the work by Morning");
                intent2.setType("message/rfc822");
                startActivity(intent2);
                return true;
            }

                return MainActivity.super.onOptionsItemSelected(item);



            }




    };

}
