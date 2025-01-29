package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // Find views by ID
        Spinner scoreSpinner = findViewById(R.id.score_spinner);
        Spinner degreeSpinner = findViewById(R.id.degree_spinner);
        Button saveButton = findViewById(R.id.save_changes_button);

        // Set up options for the score spinner
        String[] scoreOptions = {"Select your score", "6", "6.5", "7", "7.5", "8", "8.5", "9"};
        ArrayAdapter<String> scoreAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                scoreOptions
        );
        scoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scoreSpinner.setAdapter(scoreAdapter);

        // Set up options for the degree spinner
        String[] degreeOptions = {"Select your degree", "Bachelor", "Master"};
        ArrayAdapter<String> degreeAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                degreeOptions
        );
        degreeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        degreeSpinner.setAdapter(degreeAdapter);

        // Save button click listener
        saveButton.setOnClickListener(v -> {
            String selectedScore = scoreSpinner.getSelectedItem().toString();
            String selectedDegree = degreeSpinner.getSelectedItem().toString();

            // Validate selections
            if (selectedScore.equals("Select your score")) {
                Toast.makeText(this, "Please select a valid score!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedDegree.equals("Select your degree")) {
                Toast.makeText(this, "Please select a valid degree!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Successful validation
            Toast.makeText(
                    this,
                    "Profile Updated Successfully!\nScore: " + selectedScore + "\nDegree: " + selectedDegree,
                    Toast.LENGTH_LONG
            ).show();

            // Save to database or shared preferences (logic to be added here)
        });
    }
}
