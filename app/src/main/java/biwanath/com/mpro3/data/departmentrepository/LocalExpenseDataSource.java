package biwanath.com.mpro3.data.departmentrepository;

import biwanath.com.mpro3.department.DepartmentDataSource;
import io.reactivex.Flowable;

/**
 * Created by Biswanath Maity on 10/5/2017.
 */
public class LocalExpenseDataSource implements DepartmentDataSource {

    private final DepartmentDao mExpenseDao;

    public LocalExpenseDataSource(DepartmentDao expenseDao) {
        mExpenseDao = expenseDao;
    }

    @Override
    public Flowable<Department> getDepartment() {
        return mExpenseDao.getDepartment();
    }

    @Override
    public void insertOrUpdateDepartment(Department exp) {
        mExpenseDao.insertDepartment(exp);
    }

    @Override
    public void deleteAllDepartment() {
        mExpenseDao.deleteAllDepartment();
    }
}
