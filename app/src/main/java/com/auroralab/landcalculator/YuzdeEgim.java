package com.auroralab.landcalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class YuzdeEgim extends AppCompatActivity {
    private EditText editTextIlkSayi;
    private EditText editTextIkinciSayi;
    private Button buttonHesapla;
    private TextView textViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yuzde_egim);

        editTextIlkSayi = findViewById(R.id.editTextIlkSayi);
        editTextIkinciSayi = findViewById(R.id.editTextIkinciSayi);
        buttonHesapla = findViewById(R.id.buttonHesapla);
        textViewSonuc = findViewById(R.id.textViewSonuc);

        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesaplaYuzdeEgim();
            }
        });
    }

    private void hesaplaYuzdeEgim() {
        if (editTextIlkSayi.getText().toString().trim().length() < 1 || editTextIkinciSayi.getText().toString().trim().length() < 1) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.alanlarbosbirakilamaz), Toast.LENGTH_SHORT).show();
        } else {
            String IlkSayiString = editTextIlkSayi.getText().toString();
            String IkinciSayiString = editTextIkinciSayi.getText().toString();

            double IlkSayi = Double.parseDouble(IlkSayiString);
            double IkinciSayi = Double.parseDouble(IkinciSayiString);
            double a = 100;
            double YuzdeEgim = (IlkSayi / IkinciSayi) * a;

            textViewSonuc.setText(getResources().getString(R.string.yuzde_egim) + YuzdeEgim);
        }
    }
}