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

    private Department mExpense;

    public DepartmentViewModel(DepartmentDataSource expDataSource) {
        mExpenseDataSource= expDataSource;
    }

    public Flowable<String> getExpenseId() {
        return mExpenseDataSource.getDepartment()
                // for every emission of the user, get the user name
                .map(exp -> {
                    mExpense = exp;
                    return exp.getDepartmentId();
                });

    }

    public Completable updateExpenseType(final String expType) {
        return new CompletableFromAction(() -> {
            // if there's no use, create a new user.
            // if we already have a user, then, since the user object is immutable,
            // create a new user, with the id of the previous user and the updated user name.
            mExpense = mExpense == null
                    ? new Department(expType) // TODO: to be update accordingly
                    : new Department(mExpense.getDepartmentId(), expType);

            mExpenseDataSource.insertOrUpdateDepartment(mExpense);
        });
    }
}
