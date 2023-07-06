package com.auroralab.landcalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class uzunluk_hesapla extends AppCompatActivity {
    private EditText editTextOlcekliUzunluk;
    private EditText editTextOlcek;
    private Button buttonHesapla;
    private TextView textViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uzunluk_hesapla);

        editTextOlcekliUzunluk = findViewById(R.id.editTextOlcekliUzunluk);
        editTextOlcek = findViewById(R.id.editTextOlcek);
        buttonHesapla = findViewById(R.id.buttonHesapla);
        textViewSonuc = findViewById(R.id.textViewSonuc);

        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesaplaGercekUzunluk();
            }
        });
    }

    private void hesaplaGercekUzunluk() {
        if (editTextOlcekliUzunluk.getText().toString().trim().length() < 1 || editTextOlcek.getText().toString().trim().length() < 1) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.alanlarbosbirakilamaz), Toast.LENGTH_SHORT).show();
        } else {
            String olcekliUzunlukString = editTextOlcekliUzunluk.getText().toString();
            String olcekString = editTextOlcek.getText().toString();

            double olcekliUzunluk = Double.parseDouble(olcekliUzunlukString);
            double olcek = Double.parseDouble(olcekString);

            double gercekUzunluk = olcekliUzunluk / olcek;

            textViewSonuc.setText(getResources().getString(R.string.ger_ek_uzunluk) + gercekUzunluk);
        }
    }
}