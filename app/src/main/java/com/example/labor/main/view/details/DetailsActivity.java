package com.example.labor.main.view.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.labor.R;
import com.example.labor.main.model.Civilization;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DetailsActivity extends AppCompatActivity {

    Civilization civilization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Intent intent = getIntent();
        civilization = gson.fromJson(intent.getSerializableExtra("civilization").toString(), Civilization.class);

        TextView textView = (TextView) findViewById(R.id.details);
        textView.setText(civilization.getName());

        configureBackButton();
    }

    private void configureBackButton(){
        Button backButton = (Button) findViewById(R.id.back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
