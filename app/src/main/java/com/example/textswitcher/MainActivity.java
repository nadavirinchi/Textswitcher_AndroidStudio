package com.example.textswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextSwitcher txtswitch1;
    ImageButton btnnext;
    ImageButton btnprev;

    TextSwitcher txtswitch2;
    ImageButton btnnext1;
    ImageButton btnprev1;

    TextSwitcher txtswitch3;
    ImageButton btnnext2;
    ImageButton btnprev2;

    String[] values1 = {"asdad","safdsrtfs"};
    String[] values2 = {"asdad","safdsrtfs"};
    String[] values3 = {"asdad","safdsrtfs"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtswitch1 = findViewById(R.id.txtswitch1);
        btnnext = findViewById(R.id.btnnext);
        btnprev = findViewById(R.id.btnprev);
        txtswitch2 = findViewById(R.id.txtswitch2);
        btnnext1 = findViewById(R.id.btnnext1);
        btnprev1 = findViewById(R.id.btnprev1);
        txtswitch3 = findViewById(R.id.txtswitch3);
        btnnext2 = findViewById(R.id.btnnext2);
        btnprev2 = findViewById(R.id.btnprev2);

        useanimationfortextswitcher(txtswitch1);
        useanimationfortextswitcher(txtswitch2);
        useanimationfortextswitcher(txtswitch3);

        createtextviewtoswitch(values1,txtswitch1);
        createtextviewtoswitch(values2,txtswitch2);
        createtextviewtoswitch(values3,txtswitch3);

        btnnext.setOnClickListener(MainActivity.this);
        btnprev.setOnClickListener(MainActivity.this);
        btnnext1.setOnClickListener(MainActivity.this);
        btnprev1.setOnClickListener(MainActivity.this);
        btnnext2.setOnClickListener(MainActivity.this);
        btnprev2.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnnext:
                txtswitch1.showNext();
                break;
            case R.id.btnprev:
                txtswitch1.showPrevious();
                break;
            case R.id.btnnext1:
                txtswitch2.showNext();
                break;
            case R.id.btnprev1:
                txtswitch2.showPrevious();
                break;
            case R.id.btnnext2:
                txtswitch3.showNext();
                break;
            case R.id.btnprev2:
                txtswitch3.showPrevious();
                break;
        }
    }

    private void useanimationfortextswitcher(TextSwitcher textSwitcher){
        textSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_in_left));
        textSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_out_right));
    }
    private void createtextviewtoswitch(String[] stringvalues,TextSwitcher textSwitcher){
        for (int index = 0;index<stringvalues.length;index++){
            TextView textView = new TextView(MainActivity.this);
            textView.setText(stringvalues[index]);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(50);
            textSwitcher.addView(textView);
        }
    }
}