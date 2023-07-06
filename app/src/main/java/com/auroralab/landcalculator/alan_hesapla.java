package com.auroralab.landcalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class alan_hesapla extends AppCompatActivity {
    private EditText editTextOlcekliAlan, editTextOlcek;
    private Button buttonHesapla;
    private TextView textViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alan_hesapla);

        editTextOlcekliAlan = findViewById(R.id.editTextOlcekliAlan);
        editTextOlcek = findViewById(R.id.editTextOlcek);
        buttonHesapla = findViewById(R.id.buttonHesapla);
        textViewSonuc = findViewById(R.id.textViewSonuc);

        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesaplaGercekAlan();
            }
        });
    }

    private void hesaplaGercekAlan() {

        // YA KULLANICI INPUT ALANLARINA HİÇ BİR  ŞEY YAZMADAN HESAPLAYA BASARSA???

        if (editTextOlcekliAlan.getText().toString().trim().length()<1 || editTextOlcek.getText().toString().trim().length()<1) {
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.alanlarbosbirakilamaz),Toast.LENGTH_SHORT).show();
        } else {

            String olcekliAlanString = editTextOlcekliAlan.getText().toString();
            String olcekString = editTextOlcek.getText().toString();
            double olcekliAlan = Double.parseDouble(olcekliAlanString);
            double olcek = Double.parseDouble(olcekString);

            double gercekAlan = olcekliAlan / (olcek * olcek);

            // ÇEVİRİ İÇİN HER METNİ STRING DOSYASINDAN ÇEKMEMİZ GEREK
            textViewSonuc.setText(getResources().getString(R.string.ger_ek_alan) + gercekAlan);
        }


    }

}