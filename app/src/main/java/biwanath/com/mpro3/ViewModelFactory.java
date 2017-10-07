package biwanath.com.mpro3;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import biwanath.com.mpro3.department.DepartmentDataSource;
import biwanath.com.mpro3.department.DepartmentViewModel;

/**
 * Created by Biswanath Maity on 10/5/2017.
 */

public class ViewModelFactory  implements ViewModelProvider.Factory{

    private final DepartmentDataSource mDepartmentDataSource;

    public ViewModelFactory(DepartmentDataSource departmentDataSource) {
        mDepartmentDataSource = departmentDataSource;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DepartmentViewModel.class)) {
            return (T) new DepartmentViewModel(mDepartmentDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
