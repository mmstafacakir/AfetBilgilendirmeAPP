package com.samet.mobilproje;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.samet.mobilproje.databinding.ActivityMainBinding;

public class MainPage extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MediaPlayer player;
    private SharedPreferences sharedPref;
    private Handler handler = new Handler();
    private int repeatCount = 0;
    private static final int MAX_REPEAT_COUNT = 10;
    private static final long DELAY_BETWEEN_REPEATS = 1500; // 1,5 second delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        boolean isNightMode = sharedPref.getBoolean("nightMode", false);
        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        binding.btnBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransitionBefore();
            }
        });

        binding.btnAfter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransitionAfter();
            }
        });

        binding.whistle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playWhistle();
            }
        });

        binding.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });
    }
    public void openSettingsPage(){
        Intent intent = new Intent(this, settingsPage.class);
        startActivity(intent);
    }
    public void openTransitionBefore() {
        Intent intent = new Intent(this, transitionBeforePage.class);
        startActivity(intent);
    }
    public void openTransitionAfter() {
        Intent intent = new Intent(this, transitionPage.class);
        startActivity(intent);
    }
    public void playWhistle() {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.whistle);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    repeatCount++;
                    if (repeatCount < MAX_REPEAT_COUNT) {
                        // Delay before playing the sound again
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                player.start();
                            }
                        }, DELAY_BETWEEN_REPEATS);
                    } else {
                        stopWhistle();
                    }
                }
            });
        }

        repeatCount = 0; // Reset repeat count
        player.start();
    }
    public void stopWhistle() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Release MediaPlayer resources when the activity is destroyed
        if (player != null) {
            player.release();
            player = null;
        }
    }
}
