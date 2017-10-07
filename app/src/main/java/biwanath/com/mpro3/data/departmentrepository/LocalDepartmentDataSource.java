package biwanath.com.mpro3.data.departmentrepository;

import biwanath.com.mpro3.department.DepartmentDataSource;
import io.reactivex.Flowable;

/**
 * Created by Biswanath Maity on 10/5/2017.
 */
public class LocalDepartmentDataSource implements DepartmentDataSource {

    private final DepartmentDao mDepartmentDao;

    public LocalDepartmentDataSource(DepartmentDao depDao) {
        mDepartmentDao = depDao;
    }

    @Override
    public Flowable<Department> getDepartment() {
        return mDepartmentDao.getDepartment();
    }

    @Override
    public void insertOrUpdateDepartment(Department dep) {
        mDepartmentDao.insertDepartment(dep);
    }

    @Override
    public void deleteAllDepartment() {
        mDepartmentDao.deleteAllDepartment();
    }
}
