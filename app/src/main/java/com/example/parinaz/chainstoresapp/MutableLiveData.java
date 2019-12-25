package com.example.parinaz.chainstoresapp;

import android.arch.lifecycle.LiveData;

public class MutableLiveData<T> extends LiveData<T> {

    @Override
    public void postValue(T value) {
        super.postValue(value);
    }
}
