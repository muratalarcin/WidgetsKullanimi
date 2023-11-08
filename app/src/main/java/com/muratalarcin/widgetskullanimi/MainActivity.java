package com.muratalarcin.widgetskullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.muratalarcin.widgetskullanimi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
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

        binding.buttonGoster.setOnClickListener(view -> {
            Log.e("Sonuç", "Switch Durum : " + binding.switch1.isChecked());
        });

    }
}