package com.dxd.androidx.mvvm_java;

import android.os.Bundle;

import com.dxd.androidx.mvvm_java.databinding.ActivityMainBinding;
import com.dxd.androidx.mvvm_java.viewmodel.MainViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getMpData();
        mainBinding.rvMain.setAdapter(mainViewModel.mainAdapter);
        mainViewModel.getLiveData().observe(this, mpBeans -> mainViewModel.mainAdapter.setList(mpBeans));

    }
}