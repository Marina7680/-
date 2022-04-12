package com.example.whatcharacterareyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Activity_Character_Multiplication extends AppCompatActivity {

    private TextView tv;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private QandAs[] data;
    private int showNumQ;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_multiplication);
        initView();
        initQuestions();
    }
    @Override
    protected void onStart() {
        super.onStart();
        setupView();
    }
    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
    }
    private void setupView() {
        setQ(showNumQ);
        button1.setOnClickListener(view -> {
            Toast.makeText(this, "ответ зачтен", Toast.LENGTH_LONG).show();
            data[showNumQ].setUserAnswer(1);
            QandAs.answ=QandAs.answ +"1";
        });
        button2.setOnClickListener(view -> {
            Toast.makeText(this, "ответ зачтен", Toast.LENGTH_LONG).show();
            data[showNumQ].setUserAnswer(2);
            QandAs.answ=QandAs.answ +"2";
        });
        button3.setOnClickListener(view -> {
            Toast.makeText(this, "ответ зачтен", Toast.LENGTH_LONG).show();
            data[showNumQ].setUserAnswer(3);
            QandAs.answ=QandAs.answ +"3";
        });
        button4.setOnClickListener(view -> {
            showNumQ++;
            if (showNumQ < 3) setQ(showNumQ);
            else {
                if(QandAs.answ=="111")
                { Intent intent = new Intent(getApplicationContext(), Result.class);
                    startActivity(intent);
                    textView3.setText("Вы-");
                }}

        });
    }




    private void setQ(int n) {
        tv.setText(data[n].getQ());
        button1.setText(data[n].getA1());
        button2.setText(data[n].getA2());
        button3.setText(data[n].getA3());
    }
    private void initQuestions() {
        showNumQ = 0;
        data = new QandAs[3];
        for (int i = 0; i < data.length; i++)
            data[i] = new QandAs();
        data[0].setQ("ты общительный?");
        data[0].setA1("очень");
        data[0].setA2("нет");
        data[0].setA3("не совсем");
        data[1].setQ("ты целеустремленный?");
        data[1].setA1("очень");
        data[1].setA2("нет");
        data[1].setA3("не совсем");
        data[2].setQ("ты общительный?");
        data[2].setA1("очень");
        data[2].setA2("нет");
        data[2].setA3("не совсем");
    }
}
