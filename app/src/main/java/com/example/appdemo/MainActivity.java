package com.example.appdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_a, edt_b;
    Button btn_kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btn_kq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edt_a.getText().toString().equals("") && !edt_b.getText().toString().equals("")){
                    int a = Integer.parseInt(edt_a.getText().toString());
                    int b = Integer.parseInt(edt_b.getText().toString());
                    final String kq;

                    if(a==0){
                        if(b==0){
                            kq  = "Phương trình có vô số nghiệm";
                        } else {
                            kq = "Phương trinh vô nghiệm";
                        }
                    } else {
                        kq = String.valueOf(-b*1.0/a);
                    }

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("ketqua", kq);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, kq, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void addControls() {
        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        btn_kq = findViewById(R.id.btn_kq);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edt_a.setText("");
        edt_b.setText("");
    }
}
