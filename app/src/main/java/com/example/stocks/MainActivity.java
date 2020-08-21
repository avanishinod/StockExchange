package com.example.stocks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view)
    {
        EditText buyTextEdit = (EditText) findViewById(R.id.buyTextEdit);
        EditText sellEditText = (EditText) findViewById(R.id.sellEditText);
        EditText quantityEditText = (EditText) findViewById(R.id.quantityEditText);

        Log.i( "info","Button pressed");

        Log.i( "buy",buyTextEdit.getText().toString());
        Log.i( "sell ", sellEditText.getText().toString());
        Log.i("quantity",quantityEditText.getText().toString());

        Toast.makeText(this, "Data Entered", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}