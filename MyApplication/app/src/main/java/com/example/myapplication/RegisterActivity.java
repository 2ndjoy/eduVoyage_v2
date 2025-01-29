package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        EditText fullNameField = findViewById(R.id.fullNameField);
        EditText emailField = findViewById(R.id.emailField);
        EditText usernameField = findViewById(R.id.usernameField);
        EditText passwordField = findViewById(R.id.passwordField);
        EditText confirmPasswordField = findViewById(R.id.confirmPasswordField);
        Button registerButton = findViewById(R.id.registerButton);
        TextView goToLogin = findViewById(R.id.goToLogin);

        // Handle register button click
        registerButton.setOnClickListener(v -> {
            String fullName = fullNameField.getText().toString().trim();
            String email = emailField.getText().toString().trim();
            String username = usernameField.getText().toString().trim();
            String password = passwordField.getText().toString().trim();
            String confirmPassword = confirmPasswordField.getText().toString().trim();

            // Validate inputs
            if (TextUtils.isEmpty(fullName)) {
                fullNameField.setError("Full name is required");
                return;
            }

            if (TextUtils.isEmpty(email)) {
                emailField.setError("Email is required");
                return;
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailField.setError("Enter a valid email");
                return;
            }

            if (TextUtils.isEmpty(username)) {
                usernameField.setError("Username is required");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                passwordField.setError("Password is required");
                return;
            }

            if (password.length() < 6) {
                passwordField.setError("Password must be at least 6 characters");
                return;
            }

            if (!password.equals(confirmPassword)) {
                confirmPasswordField.setError("Passwords do not match");
                return;
            }

            // Proceed with registration logic (e.g., save data to database)
            Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();

            // Navigate to LoginActivity
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Optional: finish the current activity
        });

        // Handle "Go to Login" link click
        goToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
