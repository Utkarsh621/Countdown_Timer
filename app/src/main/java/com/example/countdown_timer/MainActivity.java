package com.example.countdown_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = (TextView) findViewById(R.id.textView2);
        Button btn = (Button) findViewById(R.id.button);
        EditText edt = (EditText)findViewById(R.id.number);
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sss);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int a = Integer.parseInt(edt.getText().toString());
                new CountDownTimer(a*1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        txt.setText("Seconds Remaining: " + l/1000);
                    }

                    @Override
                    public void onFinish() {
                        txt.setText("Done!!");
                        mediaPlayer.start();
                    }
                }.start();
            }
        });
    }
}