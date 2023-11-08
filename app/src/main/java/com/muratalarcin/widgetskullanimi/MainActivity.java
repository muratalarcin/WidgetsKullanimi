package com.muratalarcin.widgetskullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.muratalarcin.widgetskullanimi.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean kontrol = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonOku.setOnClickListener(view -> {
            String alinanVeri = binding.editTextGirdi.getText().toString();
            binding.textViewSonuc.setText(alinanVeri);
        });

        binding.buttonResim1.setOnClickListener(view -> {
            binding.imageView.setImageResource(R.drawable.rerim1);
        });

        binding.buttonResim2.setOnClickListener(view -> {
            binding.imageView.setImageResource(
                    getResources().getIdentifier("resim2", "drawable", getPackageName()));
        });

        binding.buttonBasla.setOnClickListener(view -> {
            binding.progressBar.setVisibility(View.VISIBLE);
        });

        binding.buttonDur.setOnClickListener(view -> {
            binding.progressBar.setVisibility(View.INVISIBLE);
        });

        binding.switch1.setOnCheckedChangeListener((mSwitch, isChecked) -> {
            if(isChecked) {
                Log.e("Sonuç", "Switch : ON");
            } else {
                Log.e("Sonuç", "Switch : OFF");
            }
        });

        binding.toggleButton.addOnButtonCheckedListener(((group, checkedId, isChecked) -> {//kotrol olmasa hata alabiliyoruz. buttona bastım, tekrar basınca seçim kalkıyor, ancak ben tekrar seçince bişiler bişiler
            kontrol = isChecked;
            if(kontrol) {
                Button secilenButton = findViewById(binding.toggleButton.getCheckedButtonId());
                String buttonYazi = secilenButton.getText().toString();
                Log.e("Sonuç", buttonYazi);
            }

        }));

        ArrayList<String> ulkeler = new ArrayList<>();
        ulkeler.add("Türkiye");
        ulkeler.add("İtalya");
        ulkeler.add("Japonya");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ulkeler);
        binding.autoTextView.setAdapter(arrayAdapter);

        binding.textViewSlider.setText("Slider : " + binding.slider.getProgress());

        binding.buttonGoster.setOnClickListener(view -> {
            Log.e("Sonuç", "Switch Durum : " + binding.switch1.isChecked());
            if(kontrol) {
                Button secilenButton = findViewById(binding.toggleButton.getCheckedButtonId());
                String buttonYazi = secilenButton.getText().toString();
                Log.e("Sonuç", "Toggle Durum : " + buttonYazi);
            }
            String ulke = binding.autoTextView.getText().toString();
            Log.e("Sonuç", "Ülke : " + ulke);
        });

    }
}