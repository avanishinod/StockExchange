package com.example.stocks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view)
    {
        EditText buyTextEdit = (EditText) findViewById(R.id.buyTextEdit);
        EditText sellEditText = (EditText) findViewById(R.id.sellEditText);
        EditText quantityEditText = (EditText) findViewById(R.id.quantityEditText);
        TextView TurnoverTextView = (TextView) findViewById(R.id.TurnoverTextView);

        Log.i( "info","Button pressed");

       // Toast.makeText(this, "Data Entered", Toast.LENGTH_LONG).show();

        String buy = buyTextEdit.getText().toString();
        String sell = sellEditText.getText().toString();
        String quantity = quantityEditText.getText().toString();

        Double buyDouble = Double.parseDouble(buy);
        Double sellDouble = Double.parseDouble(sell);
        Double quantityDouble = Double.parseDouble(quantity);

        Double Turnover = (buyDouble*quantityDouble) + (sellDouble*quantityDouble);
        String TurnoverString = Double.toString(Turnover);

        Log.i("turnover",TurnoverString);

        //TurnoverTextView.setText(String.valueOf(Turnover));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}