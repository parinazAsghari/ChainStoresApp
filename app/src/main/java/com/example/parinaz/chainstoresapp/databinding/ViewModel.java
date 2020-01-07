package com.example.parinaz.chainstoresapp.databinding;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.parinaz.chainstoresapp.roomdb.MarkedRepository;

import java.util.List;

public class ViewModel extends android.arch.lifecycle.ViewModel  {
    public MutableLiveData<Account> accountData;


    public LiveData<Account> getAccountData(){
        if(accountData == null){
            accountData = new MutableLiveData<>();
        }
        return accountData;
    }
    

    public String getUsername() {
        return accountData.getValue().getUserName();
    }


    public String getLastname() {
        return accountData.getValue().getLastName();
    }


    public String getEmail() {
        return accountData.getValue().getEmailAddress();
    }
}
