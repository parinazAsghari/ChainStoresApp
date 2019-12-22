package com.example.parinaz.chainstoresapp.roomdb;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.AnyThread;
import android.support.annotation.MainThread;
import android.support.annotation.RequiresApi;
import android.support.annotation.WorkerThread;

import java.util.List;

//singleton
public class MarkedRepository {

    private static MarkedRepository instance;
    private markedDAO mDAO;
    private LiveData<List<markedEntity>> mAllmarked;
    Context context;

    private MarkedRepository() {

        if (instance != null) {
            throw new RuntimeException("getinstance()");
        }
    }

    public static MarkedRepository getinstance() {
        if (instance == null) {
            instance = new MarkedRepository();

        }
        return instance;
    }


    public void init(Context context) {
        markedDatabase db = markedDatabase.getInstance(context);
        mDAO = db.markedDAO();
        mAllmarked = mDAO.getAll();
    }


    LiveData<List<markedEntity>> getmAllmarked() {
        return mAllmarked;
    }


    //@WorkerThread
    //@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    void insert(markedEntity markedEntity) {


        //  new AsyncTask() {

        //       @Override
        //     protected Object doInBackground(Object[] objects) {
        markedDatabase.getInstance(context).markedDAO().insert(markedEntity);
    }
        //}
        //}.execute();
        // print time;
        //}

        //@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
       // void insert (markedEntity markedEntity){
         //   markedDatabase.getInstance(context).markedDAO().insert(markedEntity);
            //  print time;
            //}*/

            void delete ( int code, int branchid){
                markedDatabase.getInstance(context).markedDAO().deleteAll(code, branchid);
            }

            boolean ismarked ( int code, int branchid){
                return markedDatabase.getInstance(context).markedDAO().isMarked(code, branchid);
            }
        }

