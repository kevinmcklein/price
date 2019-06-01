package com.eurekatech.uber;

import android.content.Context;
import android.content.Intent;
import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText horas,kilo;
    TextView pasaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horas= findViewById(R.id.txtCantHoras3);
        kilo= findViewById(R.id.txtCantKil);

        pasaje= findViewById(R.id.txtPasaje);
        pasaje.setText("");


    }

    public void calcular(View view){
        Double ch,ck,total;

        if (horas.getText().toString().isEmpty() || kilo.getText().toString().isEmpty() ){

            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Digite las cantidades", Toast.LENGTH_SHORT);

            toast1.show();
        }

        else
        {
            ch= Double.valueOf(horas.getText().toString());
            ck= Double.valueOf(kilo.getText().toString());

            total=15*ch+40*ck;
            pasaje.setText("Su pasaje es " + total.toString() + " pesos");
            pasaje.setBackgroundColor(getResources().getColor(android.R.color.black));
            pasaje.setTextColor(getResources().getColor(android.R.color.white));

          /*  horas.clearFocus();
            kilo.clearFocus();*/
            /* pasaje.setFocusableInTouchMode(true);
            pasaje.requestFocus();
            pasaje.clearFocus();*/

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(pasaje.getWindowToken(), 0);
        }



    }

    public void acercade(View view){
        Intent i = null;
        try {
            i = new Intent(this, AcercaDe.class );
        } catch (Exception e) {
            e.printStackTrace();
        }
        startActivity(i);
    }


}
