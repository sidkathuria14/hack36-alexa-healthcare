package com.example.sidkathuria14.healthcare.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sidkathuria14.healthcare.R;
import com.example.sidkathuria14.healthcare.api.TruemdApi;
import com.example.sidkathuria14.healthcare.models.Truemd_model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestActivity extends AppCompatActivity {
Retrofit retrofit;Button btn;
    EditText etInput;
    String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        etInput = (EditText)findViewById(R.id.etInput);
        btn = (Button)findViewById(R.id.btn);

//        etInput.addTextChangedListener();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = etInput.getText().toString();

                retrofit = new Retrofit.Builder()
                        .baseUrl("http://www.truemd.in/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                TruemdApi truemdApi = retrofit.create(TruemdApi.class);


                Callback<Truemd_model> callback = new Callback<Truemd_model>() {
                    @Override
                    public void onResponse(Call<Truemd_model> call, Response<Truemd_model> response) {
                        if (response.isSuccessful()) {
                            Log.d("test", "onResponse: " + response.body().getSuggestions().get(0).getName());
                        } else Log.d("test", "onResponse: " + response.isSuccessful());
                    }
                    @Override
                    public void onFailure(Call<Truemd_model> call, Throwable t) {
                        Log.d("test", "onFailure: ");
                    }
                };
                truemdApi.getMedicines(input).enqueue(callback);


            }
        });

    }
}
