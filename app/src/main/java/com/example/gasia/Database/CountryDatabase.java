package com.example.gasia.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.gasia.Dao.CountryDao;
import com.example.gasia.Utils.TypeConverter1;
import com.example.gasia.Utils.TypeConverter2;
import com.example.gasia.models.Country;

@Database(entities = {Country.class},version = 1,exportSchema = false)
@TypeConverters({TypeConverter1.class, TypeConverter2.class})
public abstract class CountryDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="Country";
    public abstract CountryDao countryDao();
    public static volatile CountryDatabase INSTANCE=null;
    public static CountryDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized(CountryDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, CountryDatabase.class, DATABASE_NAME)
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }

        }
        return INSTANCE;
    }
    public static Callback callback=new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyn(INSTANCE);
        }
    };

    static  class  PopulateDbAsyn extends AsyncTask<Void,Void,Void> {
        private final CountryDao countryDao;
        public PopulateDbAsyn(CountryDatabase countryDatabase)
        {
            countryDao=countryDatabase.countryDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            countryDao.deleteAll();

            return null;
        }
    }
}
