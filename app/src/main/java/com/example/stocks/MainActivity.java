package com.example.stocks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView Turnoverdisplay;
    EditText buytext, selltext, quantitytext;
    Button buttonsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Turnoverdisplay = (TextView) findViewById(R.id.Turn);
        buytext=(EditText) findViewById(R.id.buyTextEdit);
        selltext=(EditText) findViewById(R.id.sellEditText);
        quantitytext=(EditText) findViewById(R.id.quantityEditText);
        buttonsubmit=(Button) findViewById(R.id.submit);

        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String buy = buytext.getText().toString();
                String sell = selltext.getText().toString();
                String quantity = quantitytext.getText().toString();

                Double buyDouble = Double.parseDouble(buy);
                Double sellDouble = Double.parseDouble(sell);
                Double quantityDouble = Double.parseDouble(quantity);

                Double Turnover = (buyDouble*quantityDouble) + (sellDouble*quantityDouble);
                String TurnoverString = Double.toString(Turnover);

                Turnoverdisplay.setText("TurnOver "+ TurnoverString);


            }
        });
    }
}