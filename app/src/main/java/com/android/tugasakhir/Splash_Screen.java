package com.android.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {
    private static final int SPLASH_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent untuk memulai aktivitas berikutnya setelah splash screen
                Intent intent = new Intent(Splash_Screen.this, LoginActivity.class);
                startActivity(intent);

                // Menutup splash screen agar tidak dapat dikembalikan
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
    }
