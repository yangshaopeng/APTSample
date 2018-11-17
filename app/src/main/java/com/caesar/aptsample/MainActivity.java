package com.caesar.aptsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.caesar.aptannotation.TestAnno;

import butterknife.BindView;
import butterknife.ButterKnife;

@TestAnno
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text)
    //@TestAnno
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ButterKnife.bind(this);
        textView.setText("aaa");


    }
}
