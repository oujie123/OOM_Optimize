package com.gacrnd.gcs.leakcanarytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gacrnd.gcs.leakcanarytest.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements ComponentCallbacks2 {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener( view -> {
            startActivity(new Intent(MainActivity.this,TestActivity.class));
        });

        binding.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    //内存不够
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        //主动去释放一些内存

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //低内存 -> app 被杀
        //尽可能的释放内存
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("JackOu",this.getClass().getSimpleName() + " onStart...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("JackOu",this.getClass().getSimpleName() + " onRestart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("JackOu",this.getClass().getSimpleName() + " onResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("JackOu",this.getClass().getSimpleName() + " onPause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("JackOu",this.getClass().getSimpleName() + " onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("JackOu",this.getClass().getSimpleName() + " onDestroy...");
    }
}
