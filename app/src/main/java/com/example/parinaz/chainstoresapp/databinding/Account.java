package com.example.parinaz.chainstoresapp.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

public class Account {
    private String userName;
    private String lastName;
    private String emailAddress;
    private long time;

    public String getUserName() {
        return this.userName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
       // notifyPropertyChanged(BR.);
    }



    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public long gettime(){
        return this.time;
    }
}
