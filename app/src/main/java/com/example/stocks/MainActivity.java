package com.example.stocks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView BestSelling;
    EditText buytext, selltext, quantitytext;
    Button buttonsubmit;

    private static DecimalFormat df = new DecimalFormat("0.00");

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

                double buyDouble = Double.parseDouble(buy);
                double sellDouble = Double.parseDouble(sell);
                double quantityDouble = Double.parseDouble(quantity);

                //calculation part

                double TurnOver = (buyDouble*quantityDouble)+(sellDouble*quantityDouble);
                double BrokerageNSE = 0.0;
                double STTTotalNSE = Math.round(TurnOver *0.001);
               double ExchangeTXNCharge = Math.round(((0.00325/100)*TurnOver)*100.0)/100.0;
               double ClearingCharge = Math.round(((0.0002/100)*TurnOver)*100.0)/100.0;
               double GST = Math.round((0.18*(BrokerageNSE+ExchangeTXNCharge))*100.0)/100.0;
               double SEBICharges = Math.round(((0.0001/100)*TurnOver)*100.0)/100.0;
               double StampDuty = Math.round((0.00015*(buyDouble*quantityDouble))*100.0)/100.0;
               double TotalTaxAndCharges = BrokerageNSE+STTTotalNSE+ClearingCharge+GST+SEBICharges+StampDuty;


               // Display Part

                double BestSP = (buyDouble*(6.05/100))+buyDouble;
                String BestSPString = Double.toString(BestSP);

                BestSelling.setText("Best Selling Price "+ BestSPString);


            }
        });
    }
}