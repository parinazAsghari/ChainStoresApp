package com.example.parinaz.chainstoresapp.roomdb;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class MarkedViewModel extends AndroidViewModel {
    private MarkedRepository markedRepository;
private LiveData<List<markedEntity>> mAllmarked;


    public MarkedViewModel(@NonNull Application application) {
        super(application);
        markedRepository = new MarkedRepository(application);
        mAllmarked=markedRepository.getmAllmarked();
    }

    LiveData<List<markedEntity>> getmAllmarked(){
        return mAllmarked;
    }
    public void insert(markedEntity markedEntity){
        markedRepository.insert(markedEntity);
    }
}
