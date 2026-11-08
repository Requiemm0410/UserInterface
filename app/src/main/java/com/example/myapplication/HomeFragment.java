package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHomeBinding.bind(view);

        binding.btnMusic.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new DashboardFragment())
                    .commit();
        });
        binding.btnOtt.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new SocialFragment())
                    .commit();
        });
    }
}
