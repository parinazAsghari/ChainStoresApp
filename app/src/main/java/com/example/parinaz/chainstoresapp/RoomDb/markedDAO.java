package com.example.parinaz.chainstoresapp.RoomDb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by parinaz on 11/18/19.
 */
@Dao
public interface markedDAO {

    @Query("SELECT * FROM marked_products")
    List<markedEntity> getAll();

    @Query("SELECT * FROM marked_products WHERE code LIKE :code " + "  AND branchid LIKE :branchid LIMIT 1")
  boolean isMarked(int code , int branchid);


    @Insert
    void insert(markedEntity...markedEntities);




    @Delete
    void delete(markedEntity... markedEntities);
    @Query("DELETE FROM marked_products WHERE code == :code AND branchid == :branchid")
    void deleteAll(int code , int branchid);

}
