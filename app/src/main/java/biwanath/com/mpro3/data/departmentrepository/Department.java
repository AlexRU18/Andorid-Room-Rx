package biwanath.com.mpro3.data.departmentrepository;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.UUID;

/**
 * Created by Biswanath Maity on 10/5/2017.
 */
@Entity(tableName = "tblDepartment")
public class Department {
    @PrimaryKey
    @ColumnInfo(name = "DepartmentId")
    private String mId;

    @ColumnInfo(name = "DepartmentName")
    private String mDepartmentName;

    @Ignore
    public Department(String name) {
        mId = UUID.randomUUID().toString();
        this.mDepartmentName = name;
    }
    public Department(String id, String dep) {
        this.mId = id;
        this.mDepartmentName =dep;
    }

    public String getDepartmentId() {
        return mId;
    }

    public String getDepartmentName() {
        return mDepartmentName;
    }
}


