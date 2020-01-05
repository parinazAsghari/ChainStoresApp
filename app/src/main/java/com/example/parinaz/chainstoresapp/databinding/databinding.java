package com.example.parinaz.chainstoresapp.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.parinaz.chainstoresapp.R;

public class databinding extends AppCompatActivity {
ActivityDataBindingBinding dataBindingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBindingBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding);
        ViewModel model= new ViewModel();
        model.setUserName("parinaz");
        model.setLastName("asghari");
        model.setEmailAddress("parinazasghari@gmail.com");

       dataBindingBinding.setViewModel(model);

    }
}
