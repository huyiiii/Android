package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btnBack;
    private EditText edtA,edtB,edtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator_activity);
        btn1 = (Button) findViewById(R.id.btn1) ;
        btn2 = (Button) findViewById(R.id.btn2) ;
        btn3 = (Button) findViewById(R.id.btn3) ;
        btn4 = (Button) findViewById(R.id.btn4) ;
        btnBack = (Button) findViewById(R.id.btnBack);

        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        edtKQ = (EditText) findViewById(R.id.edtKQ);

        OnClickButton();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculatorActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void OnClickButton()
    {
        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                float kq = Integer.parseInt("0" + edtA.getText()) + Integer.parseInt("0" + edtB.getText());
                edtKQ.setText(String.valueOf(kq));
            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                float kq = Integer.parseInt("0" + edtA.getText()) - Integer.parseInt("0" + edtB.getText());
                edtKQ.setText(String.valueOf(kq));
            }

        });
        btn3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                float kq = Integer.parseInt("0" + edtA.getText()) * Integer.parseInt("0" + edtB.getText());
                edtKQ.setText(String.valueOf(kq));
            }

        });
        btn4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {

                    float a = Float.parseFloat("0" + edtA.getText().toString().trim());
                    float b = Float.parseFloat("0" + edtB.getText().toString().trim());


                    if (b != 0) {
                        float kq = a / b;
                        edtKQ.setText(String.valueOf(kq));
                    } else {
                        edtKQ.setText("Không thể chia cho 0");
                    }
                } catch (NumberFormatException e) {
                    edtKQ.setText("Lỗi: Nhập số hợp lệ");
                }
            }

        });
        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myIntent = new Intent(CalculatorActivity.this,MainActivity.class);
                startActivity(myIntent);
            }

        });
    }
}
