package com.example.parinaz.chainstoresapp.roomdb;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.parinaz.chainstoresapp.Runnable;
import com.example.parinaz.chainstoresapp.activity.ProductDetailsActivity;

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

    public void insert(markedEntity markedEntity , java.lang.Runnable runnable){

      markedRepository.insert(markedEntity,runnable);

    }

    public void delete(int code , int branchid , java.lang.Runnable runnable){

      markedRepository.delete(code, branchid ,runnable);



    }


    public void ismarked(int code, int branchid ,Runnable runnable){
      markedRepository.ismarked(code,branchid,runnable);

     /*  markedRepository.ismarked(code, branchid, new Runnable() {;
          @Override
          public void run(Boolean b) {

          }
      });*/



    }



    }

