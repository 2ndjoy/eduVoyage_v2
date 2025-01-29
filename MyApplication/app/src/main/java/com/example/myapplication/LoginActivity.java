package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize EditText fields
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);

        // Login button click listener with validation
        findViewById(R.id.loginButton).setOnClickListener(view -> {
            String username = usernameField.getText().toString().trim();
            String password = passwordField.getText().toString().trim();

            if (validateLogin(username, password)) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Navigation to Register Activity
        findViewById(R.id.goToRegister).setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // Logo navigation to MainActivity (if needed)
        findViewById(R.id.logoImage).setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private boolean validateLogin(String username, String password) {
        // Basic validation
        if (username.isEmpty()) {
            usernameField.setError("Username cannot be empty");
            return false;
        }

        if (password.isEmpty()) {
            passwordField.setError("Password cannot be empty");
            return false;
        }

        // More advanced validation (replace with your actual authentication logic)
        if (username.length() < 3) {
            usernameField.setError("Username must be at least 3 characters");
            return false;
        }

        if (password.length() < 6) {
            passwordField.setError("Password must be at least 6 characters");
            return false;
        }

        // TODO: Replace with actual authentication logic
        // For now, just a simple example validation
        if (!username.equals("admin") || !password.equals("password")) {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}