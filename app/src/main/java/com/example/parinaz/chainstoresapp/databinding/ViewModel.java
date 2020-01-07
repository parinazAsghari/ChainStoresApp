package com.example.parinaz.chainstoresapp.databinding;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.parinaz.chainstoresapp.roomdb.MarkedRepository;

import java.util.List;

public class ViewModel extends android.arch.lifecycle.ViewModel  {
    public MutableLiveData<Account> accountData;

    public ViewModel() {
        if(accountData == null){
            accountData = new MutableLiveData<>();
        }
        Account accountObject = new Account();
        accountObject.setLastName("asghari");
        accountObject.setUserName("parinaz");
        accountObject.setEmailAddress("parinazasghari@gmail.com");
        accountObject.setTime(System.currentTimeMillis()/1000);
        accountData.setValue(accountObject);

    }

    public LiveData<Account> getAccountData(){

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
    public long gettime(){
        return accountData.getValue().gettime();
    }
}
