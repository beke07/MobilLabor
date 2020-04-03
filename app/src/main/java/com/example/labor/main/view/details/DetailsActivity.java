package com.example.labor.main.view.details;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        setEditText(R.id.name, civilization.getName());
        setEditText(R.id.expansion, civilization.getExpansion());
        setEditText(R.id.arm_type, civilization.getArmy_type());
        setEditText(R.id.team_bonus, civilization.getTeam_bonus());

        configureBackButton();
    }

    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setEditText(@IdRes int id, String text) {
        EditText field = (EditText) findViewById(id);
        field.setText(text);
    }
}
