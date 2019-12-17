package com.example.parinaz.chainstoresapp.roomdb;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

public class MarkedRepository {
    private markedDAO mDAO;
    private LiveData<List<markedEntity>> mAllmarked;
    Context context;

    public MarkedRepository(Application application) {
        markedDatabase db =  markedDatabase.getInstance(application);
        mDAO=db.markedDAO();
        mAllmarked=mDAO.getAll();

    }

    LiveData<List<markedEntity>> getmAllmarked(){
        return mAllmarked;
    }

    void  insert(markedEntity markedEntity){
        markedDatabase.getInstance(context).markedDAO().insert(markedEntity);

    }

    void delete(int code , int branchid){
        markedDatabase.getInstance(context).markedDAO().deleteAll(code, branchid);
    }

    boolean ismarked(int code , int branchid){
       return markedDatabase.getInstance(context).markedDAO().isMarked(code, branchid);
    }
}
