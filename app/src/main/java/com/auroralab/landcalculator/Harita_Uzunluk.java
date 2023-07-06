package com.auroralab.landcalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Harita_Uzunluk extends AppCompatActivity {
    private EditText editTextGercekUzunluk;
    private EditText editTextOlcek;
    private Button buttonHesapla;
    private TextView textViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Action bar(ekranın üstündeki bar) gizlenir.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.harita_uzunluk);

        editTextGercekUzunluk = findViewById(R.id.editTextGercekUzunluk);
        editTextOlcek = findViewById(R.id.editTextOlcek);
        buttonHesapla = findViewById(R.id.buttonHesapla);
        textViewSonuc = findViewById(R.id.textViewSonuc);

        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesaplaHaritaUzunluk();
            }
        });
    }

    private void hesaplaHaritaUzunluk() {

        if (editTextGercekUzunluk.getText().toString().trim().length()<1 || editTextOlcek.getText().toString().trim().length()<1) {
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.alanlarbosbirakilamaz),Toast.LENGTH_SHORT).show();
        } else {
            String GercekUzunlukString = editTextGercekUzunluk.getText().toString();
            String OlcekString = editTextOlcek.getText().toString();

            double GercekUzunluk = Double.parseDouble(GercekUzunlukString);
            double Olcek = Double.parseDouble(OlcekString);

            double GercekHarita = (GercekUzunluk * Olcek);

            textViewSonuc.setText(getResources().getString(R.string.gercekharita) + GercekHarita);
        }
    }

}