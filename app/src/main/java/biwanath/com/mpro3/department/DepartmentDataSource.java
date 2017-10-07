package biwanath.com.mpro3.department;

import biwanath.com.mpro3.data.departmentrepository.Department;
import io.reactivex.Flowable;

/**
 * Created by Biswanath Maity on 10/5/2017.
 */

public interface DepartmentDataSource {
    Flowable<Department> getDepartment();
    void insertOrUpdateDepartment(Department exp);
    void deleteAllDepartment();
}
