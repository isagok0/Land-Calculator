package com.auroralab.landcalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class toplam_egim extends AppCompatActivity {
    private EditText editTextToplamYFarki;
    private EditText editTextToplamYatayMesafe;
    private Button buttonHesapla;
    private TextView textViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toplam_egim);

        editTextToplamYFarki = findViewById(R.id.editTextToplamYFarki);
        editTextToplamYatayMesafe = findViewById(R.id.editTextToplamYatayMesafe);
        buttonHesapla = findViewById(R.id.buttonHesapla);
        textViewSonuc = findViewById(R.id.textViewSonuc);

        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesaplaToplamYuzdeEgim();
            }
        });
    }

    private void hesaplaToplamYuzdeEgim() {
        if (editTextToplamYFarki.getText().toString().trim().length() < 1 || editTextToplamYatayMesafe.getText().toString().trim().length() < 1) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.alanlarbosbirakilamaz), Toast.LENGTH_SHORT).show();
        } else {
            String toplamYFarkiString = editTextToplamYFarki.getText().toString();
            String toplamYatayMesafeString = editTextToplamYatayMesafe.getText().toString();

            double toplamYFarki = Double.parseDouble(toplamYFarkiString);
            double toplamYatayMesafe = Double.parseDouble(toplamYatayMesafeString);
            double a = 100;
            double ToplamYuzdeEgim = (toplamYFarki / toplamYatayMesafe) * a;

            textViewSonuc.setText(getResources().getString(R.string.ger_ek_uzunluk) + ToplamYuzdeEgim);
        }
    }
}