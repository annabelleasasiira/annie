package com.example.annie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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


    private MyReceiver receive = new MyReceiver() {

        public void onReceive(Context c, Intent i) {
            int r = i.getIntExtra("level", 0);
            ProgressBar bar = findViewById(R.id.Bar);
            bar.setProgress(r);
            TextView view = findViewById(R.id.textView6);
            view.setText("charge the phone" + Integer.toString(r) + "%");

        }


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public void sendMessage(View view) {
            EditText message = (EditText) findViewById(R.id.message);
            Intent intent = new Intent(this, DisplayMessageActivity.class);
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
                Intent myintent = new Intent(this, four.class);
                this.startActivity(myintent);
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


                return super.onOptionsItemSelected(item);
            }

            public void onClick (View view){
                EditText editText = findViewById(R.id.alar);
                int b = Integer.parseInt(editText.getText().toString());
                Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (b * 1000), pendingIntent);
                Toast.makeText(this, "alarm set in" + b + "seconds", Toast.LENGTH_LONG).show();
            }

        }
    };

}
