package com.example.parinaz.chainstoresapp.roomdb;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by parinaz on 11/18/19.
 */
@Dao
public interface markedDAO {

    @Query("SELECT * FROM marked_products")
    LiveData<List<markedEntity>> getAll();

    @Query("SELECT * FROM marked_products WHERE code LIKE :code " + "  AND branchid LIKE :branchid LIMIT 1")
  boolean isMarked(int code , int branchid);


    @Insert(onConflict = REPLACE)
    void insert(markedEntity...markedEntities);




    @Delete
    void delete(markedEntity... markedEntities);
    @Query("DELETE FROM marked_products WHERE code == :code AND branchid == :branchid")
    void deleteAll(int code , int branchid);

}
