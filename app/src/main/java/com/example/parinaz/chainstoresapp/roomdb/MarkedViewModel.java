package com.example.parinaz.chainstoresapp.roomdb;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

public class MarkedViewModel extends AndroidViewModel {
    private MarkedRepository markedRepository;
private LiveData<List<markedEntity>> mAllmarked;




  public MarkedViewModel(Application application) {
        super(application);
        markedRepository = MarkedRepository.getinstance();
        markedRepository.init(application.getApplicationContext());
        mAllmarked=markedRepository.getmAllmarked();
    }

   public LiveData<List<markedEntity>> getmAllmarked(){
        return mAllmarked;
    }
    public void insert(markedEntity markedEntity){
        markedRepository.insert(markedEntity);
    }

    public void delete(int code , int branchid){
      markedRepository.delete(code, branchid);
    }


    public boolean ismarked(int code, int branchid){
     return markedRepository.ismarked(code, branchid);
    }
}
