package com.example.abhishek.birthday;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button b;
    TextView t1, t2, t3;
    VideoView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        i = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse(getString(R.string.pkg) + R.raw.video);
        i.setVideoURI(uri);
        i.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                i.start();
            }
        });
        t2.setVisibility(View.INVISIBLE);
        t1.setVisibility(View.INVISIBLE);
        i.setVisibility(View.INVISIBLE);
    }

    public void countt(View view) {
        if (t3.getText().toString().equals("1")) {
            b.setText("The Wait is Over!");
            t3.setText("Wishing you..");
            t1.setVisibility(View.VISIBLE);
            MediaPlayer mp;
            t2.setVisibility(View.VISIBLE);
            i.setVisibility(View.VISIBLE);
            i.start();
            b.setClickable(false);
            mp = MediaPlayer.create(this, R.raw.music);
            mp.start();
        } else {
            t3.setText((Integer.parseInt(t3.getText().toString()) - 1) + "");
        }
    }
}
