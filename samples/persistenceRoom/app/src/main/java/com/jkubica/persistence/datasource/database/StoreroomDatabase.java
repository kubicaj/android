package com.jkubica.persistence.datasource.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jkubica.persistence.datasource.dao.DaoStoreroom;
import com.jkubica.persistence.datasource.entities.EntityCategory;
import com.jkubica.persistence.datasource.entities.EntityItem;

/**
 * The Store room database implementation
 *
 * version = 1
 *
 * Created by jkubica on 13.01.2018.
 */
@Database(
        entities = {EntityCategory.class, EntityItem.class},
        version = 1
)
public abstract class StoreroomDatabase extends RoomDatabase {

    // =============================================================================================
    // Attributes
    // =============================================================================================

    private static StoreroomDatabase storeroomDatabaseSingletonInstance;
    public static final String DATABASE_NAME = "STOREROOM-DATABASE";


    // =============================================================================================
    // Abstract methods
    // =============================================================================================

    public abstract DaoStoreroom daoStoreroom();


    // =============================================================================================
    // Methods
    // =============================================================================================

    /**
     * create singleton instance of database
     *
     * @param context - doc see in {@link Context}
     *
     * @return - singleton database.
     */
    public static StoreroomDatabase createDatabase(Context context) {
        // check if exists
        if (storeroomDatabaseSingletonInstance == null) {
            // allow access only one thread
            synchronized (StoreroomDatabase.class) {
                // check again because other thread should create instance while
                // current thread wait for processing
                if (storeroomDatabaseSingletonInstance == null) {
                    storeroomDatabaseSingletonInstance = Room.databaseBuilder(context.getApplicationContext(), StoreroomDatabase.class, "user-database").build();
                }
            }
        }
        return storeroomDatabaseSingletonInstance;
    }

    /**
     * close database and remove instance
     */
    public static void clear(){
        if(storeroomDatabaseSingletonInstance != null){
            storeroomDatabaseSingletonInstance.close();
        }
        storeroomDatabaseSingletonInstance = null;
    }

}
