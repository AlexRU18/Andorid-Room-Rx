package biwanath.com.mpro3;

import android.content.Context;

import biwanath.com.mpro3.data.AppDatabase;
import biwanath.com.mpro3.data.departmentrepository.LocalDepartmentDataSource;
import biwanath.com.mpro3.department.DepartmentDataSource;

/**
 * Created by Biswanath Maity on 10/5/2017.
 */

public class Injection {
    public static DepartmentDataSource provideExpenseDataSource(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new LocalDepartmentDataSource(database.departmentDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        DepartmentDataSource dataSource = provideExpenseDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}
