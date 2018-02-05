package com.example.sidkathuria14.healthcare.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sidkathuria14.healthcare.R;
import com.example.sidkathuria14.healthcare.models.Suggestion;

public class MedicineInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.truemd_suggestion_layout);
       Suggestion suggestion =  getIntent().getParcelableExtra("med");

        ((TextView)findViewById(R.id.tvName)).setText(suggestion.getName());
        ((TextView)findViewById(R.id.tvManufacturer)).setText(suggestion.getManufacturer());
        ((TextView)findViewById(R.id.tvMRP)).setText(Integer.parseInt(String.valueOf(suggestion.getMrp())));


    }
}
