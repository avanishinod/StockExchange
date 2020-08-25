package com.example.stocks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView BestSelling, TotalTaxView, DPChargesView,ProfitView, GainPercentView, NetGainPercentView;
    EditText buytext, selltext, quantitytext;
    Button buttonsubmit;

    private static DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BestSelling = (TextView) findViewById(R.id.BestSPTextView);
        TotalTaxView= (TextView) findViewById(R.id.TotalTaxTextView);
        DPChargesView = (TextView) findViewById(R.id.DPGainTextView);
        ProfitView= (TextView) findViewById(R.id.ProfitTextView);
        GainPercentView = (TextView) findViewById((R.id.GainPercentTextView));
        NetGainPercentView = (TextView) findViewById(R.id.NetGainPercentTextView);
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
                double DPCharges = 15.93;
                double Costing = buyDouble*quantityDouble;
                double Revenue = sellDouble*quantityDouble;
                double Profit = Revenue - Costing;
                double NetProfit = Profit - DPCharges - TotalTaxAndCharges;
                double GainPercent =(((sellDouble-buyDouble)/buyDouble)*10000)/100;
                double NetGainPercent = ((NetProfit/Costing)*10000)/100;
                double BestSP = (buyDouble*(6.05/100))+buyDouble;

               // Display Part

                String BestSPString = Double.toString(TotalTaxAndCharges);
                BestSelling.setText("Best Selling Price : "+ BestSPString);
                String TotalTaxString = Double.toString(TotalTaxAndCharges);
                TotalTaxView.setText("Total Tax and Charges : "+TotalTaxString);
                String DPString = Double.toString(DPCharges);
                DPChargesView.setText("DP Charges : "+DPString);
                String ProfitString = Double.toString(Profit);
                ProfitView.setText("Profit : "+ProfitString);
                String GainPercentString = Double.toString(GainPercent);
                GainPercentView.setText("Gain% : "+GainPercentString);
                String NetGainString = Double.toString(NetGainPercent);
                NetGainPercentView.setText("Net Gain% : "+NetGainString);




            }
        });
    }
}