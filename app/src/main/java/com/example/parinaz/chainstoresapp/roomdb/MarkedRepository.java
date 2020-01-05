package com.example.parinaz.chainstoresapp.roomdb;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.annotation.BinderThread;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;

import com.example.parinaz.chainstoresapp.Runnable;

import java.util.List;
import java.util.concurrent.ExecutionException;

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

  /* void insert(markedEntity markedEntity) {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                markedDatabase.getInstance(context).markedDAO().insert(markedEntity);
                return null;
            }
        }.execute();

    }*/
@MainThread
    public void insert(final markedEntity markedEntity, java.lang.Runnable runnable) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                markedDatabase.getInstance(context).markedDAO().insert(markedEntity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                runnable.run();
            }

        }.execute();

        
    }


    public void delete(final int code , final int branchid , java.lang.Runnable runnable) {

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                   // noteDatabase.daoAccess().deleteTask(task.getValue());
                    markedDatabase.getInstance(context).markedDAO().deleteAll(code, branchid);
                    return null;
            }
                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    runnable.run();
                }
        }.execute();
    }


   /* void delete ( int code, int branchid){
                new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] objects) {
                        markedDatabase.getInstance(context).markedDAO().deleteAll(code, branchid);
                        return  null;
                    }
                }.execute();


                    }*/



           void ismarked (int code, int branchid , Runnable runnable) {
             //  ,Runnable runnable
                new AsyncTask<Void,Void,Boolean>() {

                    @Override
                    protected Boolean doInBackground(Void... voids) {

                      return markedDatabase.getInstance(context).markedDAO().isMarked(code, branchid);

                    }

                    @Override
                    protected void onPostExecute(Boolean aBoolean) {
                        super.onPostExecute(aBoolean);
                        runnable.run(aBoolean);
                    }
                }.execute();

            // return markedDatabase.getInstance(context).markedDAO().isMarked(code, branchid);
            }

        }

