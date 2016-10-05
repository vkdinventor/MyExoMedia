package com.vikash.example.myexoplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnPreparedListener{
    EMVideoView emPlayer;
    Button play,online;
    EditText urtText;
    String uri="http://ic1bLDDa:NoVNx7nC@172.16.12.101:80/openhome/streaming/channels/0/flv";
    String url2="https://archive.org/download/Popeye_forPresident/Popeye_forPresident_512kb.mp4";
    String url=uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main);
         play= (Button)findViewById(R.id.button);
        online=(Button)findViewById(R.id.button2);
        // urtText= (EditText) findViewById(R.id.http_url);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String uri=urtText.getText().toString().trim();
//                if(uri.startsWith("http"))
                    url=uri;
                playVideo();
            }
        });

        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url=url2;
                playVideo();
            }
        });



        playVideo();
    }

    private void playVideo() {
        emPlayer = (EMVideoView)findViewById(R.id.video_view);
        emPlayer.setOnPreparedListener(this);
        Log.v("TAG", "Exoplayer is playing "+ url);
        Toast.makeText(MainActivity.this, "playing :"+url, Toast.LENGTH_LONG).show();
//
//        Method setVideoURIMethod = videoView.getClass().getMethod("setVideoURI", Uri.class, Map.class);
//        Map<String, String> params = new HashMap<String, String>(1);
//        final String cred = login + ":" + pwd;
//        final String auth = "Basic " + Base64.encodeBytes(cred.getBytes("UTF-8"));
//        params.put("Authorization", auth);
//        setVideoURIMethod.invoke(videoView, uri, params);
        emPlayer.setVideoURI(Uri.parse(url));
        MediaPlayer mediaPlayer=new MediaPlayer();
    }

    @Override
    public void onPrepared() {
        emPlayer.start();
        Log.v("TAG","video is playing");
    }
}
