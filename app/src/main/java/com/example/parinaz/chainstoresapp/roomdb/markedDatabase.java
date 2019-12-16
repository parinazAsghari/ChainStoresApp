package com.example.parinaz.chainstoresapp.roomdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by parinaz on 11/18/19.
 */


@Database(entities = {markedEntity.class},version = 2)
public abstract class markedDatabase extends RoomDatabase {
    private static markedDatabase instance;
    public abstract markedDAO markedDAO();
    public static markedDatabase getInstance(Context context){
        //singleton repository(یک نفر میتونه تغییر بده.. با... get instance میتونیم بهش دسترسی پیدا کنیم)
        if(instance==null){
            //ینی تا حالا دیتابیس ایجاد نشده
            instance= Room.databaseBuilder(context,markedDatabase.class,"marked_products_db").allowMainThreadQueries().build();

        }
        return instance;
    }
/*static final Migration  MIGRATION_1_2 = new Migration(1 ,2 ) {
    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {

    }
};*/
//.addMigrations(MIGRATION_1_2 )

}
