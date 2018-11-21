package com.caesar.aptsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.caesar.aptannotation.TestAnno;

@TestAnno
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
