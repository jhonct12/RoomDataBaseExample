package com.example.roomdatabaseexample.roomDB.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdatabaseexample.model.ExampleModel;
import com.example.roomdatabaseexample.roomDB.dao.ExampleDao;
import com.example.roomdatabaseexample.utils.GlobalVariables;

@androidx.room.Database(entities =
        {ExampleModel.class},
        version = GlobalVariables.ROOM_DB_VERSION, exportSchema = GlobalVariables.EXPORT_SCHEMA)
@TypeConverters(DatabaseConverters.class)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    private static RoomDatabase INSTANCE;

    static final Migration MIGRATION_19_20 = new Migration(21,22) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE 'example' ADD COLUMN 'example2masss' TEXT");
        }
    };


    public static RoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabase.class, GlobalVariables.DATABASE_NAME)
                            .allowMainThreadQueries()
                            //.fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .addMigrations(MIGRATION_19_20)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    public abstract ExampleDao exampleDao();
}
