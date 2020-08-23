package com.example.stocks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView BestSelling;
    EditText buytext, selltext, quantitytext;
    Button buttonsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BestSelling = (TextView) findViewById(R.id.BestSPTextView);
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

                Double BestSP = (buyDouble*(6.05/100))+buyDouble;
                String BestSPString = Double.toString(BestSP);

                BestSelling.setText("Best Selling Price "+ BestSPString);


            }
        });
    }
}