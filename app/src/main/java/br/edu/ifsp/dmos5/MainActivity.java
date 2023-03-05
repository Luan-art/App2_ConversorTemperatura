package br.edu.ifsp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText valueEditText;

    private Button converter;
    private TextView convertedValueTextView;

    private Spinner menu;

    private RadioGroup opcoesConversao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueEditText = findViewById(R.id.edittext_value);
        convertedValueTextView = findViewById(R.id.text_view_converted);
        converter = findViewById(R.id.button_convert_kelvin);
        menu = findViewById(R.id.temperature_spinner);
        opcoesConversao = findViewById(R.id.convert_options);
        converter.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperatura_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        menu.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

        double value = getValue();
        double temp;
        int escolhaTempOri;
        int opConversao;

        escolhaTempOri = menu.getSelectedItemPosition();
        opConversao = opcoesConversao.getCheckedRadioButtonId();

        switch (opConversao){
            case R.id.convert_para_celsius:
                temp = FahrenheitStrategy.getInstance().getConversion(value, escolhaTempOri);
                convertedValueTextView.setText(String.format("%.2f °C", temp));
            break;
            case R.id.convert_para_Fahrenheit:
                temp = CelsiusStrategy.getInstance().getConversion(value, escolhaTempOri);
                convertedValueTextView.setText(String.format("%.2f °F", temp));
            break;
            case R.id.convert_para_Kelvin:
                temp = KelvinStrategy.getInstance().getConversion(value, escolhaTempOri);
                convertedValueTextView.setText(String.format("%.2f °K", temp));
             break;
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