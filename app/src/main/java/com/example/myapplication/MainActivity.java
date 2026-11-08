package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.btnOpenDrawer.setOnClickListener(view -> {
            binding.drawerLayout.openDrawer(GravityCompat.START);
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                return true;
            }
            else if (id == R.id.nav_dashboard) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new DashboardFragment()).commit();
                return true;
            }
            else if (id == R.id.nav_social) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new SocialFragment()).commit();
                return true;
            }
            else if (id == R.id.nav_setting) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new SettingFragment()).commit();
                return true;
            }
            return false;
        });
    }
}