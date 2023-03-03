package br.edu.ifsp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText valueEditText;
    private Button converterParaCelsius;
    private TextView convertedValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueEditText = findViewById(R.id.edittext_value);
        convertedValueTextView = findViewById(R.id.text_view_converted);
        converterParaCelsius = findViewById(R.id.button_convert_celsius);
        converterParaCelsius.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == converterParaCelsius){
            double value = getValue();
            double temp = 0;

            temp = FahrenheitStrategy.getInstance().getConversion(value);
            convertedValueTextView.setText(String.format("%.2f Graus Celsiu", temp));
        }
    }

    private double getValue(){
        double value;
        String valueString;

        valueString = valueEditText.getText().toString();

        try {
            value = Double.valueOf(valueString);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Valor digitado é inválido.", Toast.LENGTH_SHORT).show();
            value = 0;
        }
        return value;
    }
}