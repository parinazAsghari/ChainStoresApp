package com.example.parinaz.chainstoresapp.databinding;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.parinaz.chainstoresapp.R;

import java.util.List;

public class databinding extends AppCompatActivity {
ActivityDataBindingBinding dataBindingBinding;
    private ViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBindingBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding);
        Account accountObject = new Account();
        accountObject.setLastName("asghari");
        accountObject.setUserName("parinaz");
        accountObject.setEmailAddress("parinazasghari@gmail.com");
       model= ViewModelProviders.of(this).get(ViewModel.class);
       model.accountData.postValue(accountObject);
        model.getAccountData().observe(this, new Observer<Account>() {
            @Override
            public void onChanged(@Nullable Account accounts) {
                //dataBindingBinding.setViewModel(model);


            }
        });
      dataBindingBinding.setViewmodel(model);

    }
}
