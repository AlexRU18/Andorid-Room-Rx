package biwanath.com.mpro3.department;

import android.arch.lifecycle.ViewModel;

import biwanath.com.mpro3.data.departmentrepository.Department;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.internal.operators.completable.CompletableFromAction;

/**
 * Created by Biswanath Maity on 10/5/2017.
 */

public class DepartmentViewModel extends ViewModel {

    private final DepartmentDataSource mExpenseDataSource;

    private Department mDeapartment;

    public DepartmentViewModel(DepartmentDataSource expDataSource) {
        mExpenseDataSource= expDataSource;
    }

    public Flowable<String> getDepartmentId() {
        return mExpenseDataSource.getDepartment()
                // for every emission of the user, get the user name
                .map(dep -> {
                    mDeapartment = dep;
                    return dep.getDepartmentName();
                });

    }

    public Completable updateDepartmentName(final String depName) {
        return new CompletableFromAction(() -> {
            // if there's no use, create a new user.
            // if we already have a user, then, since the user object is immutable,
            // create a new user, with the id of the previous user and the updated user name.
            mDeapartment = mDeapartment == null
                    ? new Department(depName) // TODO: to be update accordingly
                    : new Department(mDeapartment.getDepartmentId(), depName);

            mExpenseDataSource.insertOrUpdateDepartment(mDeapartment);
        });
    }
}
