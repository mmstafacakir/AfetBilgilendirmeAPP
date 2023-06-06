package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityTransitionBeforePageBinding;

public class transitionBeforePage extends AppCompatActivity {

    private ActivityTransitionBeforePageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTransitionBeforePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.AvalancheInfoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAvalancheInfoPage();
            }
        });

        binding.EQInfoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEarthQuakeInfoPage();
            }
        });

        binding.floodInfoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFloodsInfoPage();
            }
        });
        binding.StormsInfoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStormsInfoPage();
            }
        });

        binding.fireInfoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFiresInfoPage();
            }
        });
        binding.tsunamiInfoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTsunamiInfoPage();
            }
        });

        binding.transitionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainPage();
            }
        });

        binding.transitionSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });

    }

    public void openMainPage(){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    public void openAvalancheInfoPage(){
        Intent intent = new Intent(this, AvalancheBeforeInfoPage.class);
        startActivity(intent);
    }
    public void openFiresInfoPage(){
        Intent intent = new Intent(this, FiresBeforeInfoPage.class);
        startActivity(intent);
    }
    public void openEarthQuakeInfoPage(){
        Intent intent = new Intent(this, EQBeforeInfoPage.class);
        startActivity(intent);
    }
    public void openTsunamiInfoPage(){
        Intent intent = new Intent(this, TsunamiBeforaInfoPage.class);
        startActivity(intent);
    }
    public void openFloodsInfoPage(){
        Intent intent = new Intent(this, FloodBeforeInfoPage.class);
        startActivity(intent);
    }

    public void openSettingsPage(){
        Intent intent = new Intent(this, settingsPage.class);
        startActivity(intent);
    }

    public void openStormsInfoPage(){
        Intent intent = new Intent(this, StormsBeforeInfoPage.class);
        startActivity(intent);
    }
}
