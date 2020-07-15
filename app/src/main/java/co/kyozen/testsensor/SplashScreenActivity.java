package co.kyozen.testsensor;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class SplashScreenActivity extends AppCompatActivity {
    ImageView GambarGif;
    private int waktu_loading=5000; // 2000 = 2 detik
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pindah = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(pindah);
                finish();
            }
        },waktu_loading);
        GambarGif = (ImageView) findViewById(R.id.splash);
        Glide.with(this)
                .load(R.drawable.splash_black)
                .into(GambarGif);
    }
}
