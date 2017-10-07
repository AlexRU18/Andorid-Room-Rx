package biwanath.com.mpro3.data.departmentrepository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import io.reactivex.Flowable;

/**
 * Created by Biswanath Maity on 10/5/2017.
 */

@Dao
public interface DepartmentDao {

    @Query("SELECT * FROM Department LIMIT 1")
    Flowable<Department> getDepartment();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDepartment(Department dep);

    @Query("DELETE FROM Department")
    void deleteAllDepartment();
}
