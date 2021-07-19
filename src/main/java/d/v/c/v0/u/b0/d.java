/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.b0;

import androidx.lifecycle.LiveData;
import com.zhiyun.account.data.database.AccountDatabase;
import com.zhiyun.account.data.database.AccountDatabaseHelper;
import com.zhiyun.account.data.database.dao.UserInfoDao;
import com.zhiyun.account.data.database.model.UserInfo;

public class d {
    private static volatile d c;
    private AccountDatabase a;
    private UserInfoDao b;

    private d() {
        Object object = AccountDatabaseHelper.getInstance().getDataBase();
        this.a = object;
        this.b = object = ((AccountDatabase)object).userInfoDao();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d a() {
        Object object = c;
        if (object != null) return c;
        object = d.class;
        synchronized (object) {
            d d10 = c;
            if (d10 != null) return c;
            c = d10 = new d();
            return c;
        }
    }

    public LiveData b(int n10) {
        return this.b.loadUserInfo(n10);
    }

    public void c(UserInfo userInfo) {
        if (userInfo != null) {
            Object object = this.b;
            int n10 = userInfo.getId();
            if ((object = object.loadUserInfoData(n10)) != null) {
                n10 = ((UserInfo)object).getMemberId();
                userInfo.setMemberId(n10);
                n10 = ((UserInfo)object).getApplicantId();
                userInfo.setApplicantId(n10);
                n10 = ((UserInfo)object).getActivity();
                userInfo.setActivity(n10);
                n10 = ((UserInfo)object).getRank();
                userInfo.setRank(n10);
                n10 = (int)(((UserInfo)object).isAgree() ? 1 : 0);
                userInfo.setAgree(n10 != 0);
                n10 = ((UserInfo)object).getBlocked();
                userInfo.setBlocked(n10);
                object = ((UserInfo)object).getToken();
                userInfo.setToken((String)object);
            }
            object = this.b;
            n10 = 1;
            UserInfo[] userInfoArray = new UserInfo[n10];
            userInfoArray[0] = userInfo;
            object.insertUserInfo(userInfoArray);
        }
    }
}

