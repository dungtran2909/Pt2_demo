package com.example.appdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txt_kq;
    Button btn_back;

    String ketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        ketqua = intent.getStringExtra("ketqua");

        addControls();
        addEvents();
    }

    private void addEvents() {
        txt_kq.setText(ketqua);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void addControls() {
        txt_kq = findViewById(R.id.txt_kq);
        btn_back = findViewById(R.id.btn_back);
    }
}
