package com.example.largepicload;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BigImageView bigImageView = findViewById(R.id.iv_big);
        InputStream is = null;
        try {
            is = getAssets().open("big.png");
//            is = getAssets().open("world.jpg");

            bigImageView.setImage(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
