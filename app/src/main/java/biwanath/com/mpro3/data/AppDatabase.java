package biwanath.com.mpro3.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import biwanath.com.mpro3.data.departmentrepository.Department;
import biwanath.com.mpro3.data.departmentrepository.DepartmentDao;

/**
 * Created by Biswanath Maity on 10/5/2017.
 */
@Database(entities = {Department.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    private static  AppDatabase INSTANCE;

    public abstract DepartmentDao departmentDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "Department.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
