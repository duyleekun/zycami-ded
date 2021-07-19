/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package d.v.c.m1;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.PrimeInfoDao;
import com.zhiyun.cama.prime.model.PrimeInfo;
import com.zhiyun.cama.prime.web.PrimeWebActivity;

public class b {
    public static final int a = 4097;

    public static boolean a() {
        boolean bl2;
        int bl22 = d.v.a.f.c.b.N().O();
        PrimeInfoDao primeInfoDao = DatabaseHelper.getInstance().getDataBase().primeInfoDao();
        PrimeInfo primeInfo = primeInfoDao.loadPrimeInfoData(bl22);
        boolean bl3 = true;
        if (primeInfo == null || (bl2 = primeInfo.getStatus()) != bl3) {
            bl3 = false;
            primeInfoDao = null;
        }
        return bl3;
    }

    public static boolean b(Context context) {
        boolean bl2;
        boolean bl3;
        int bl32 = d.v.a.f.c.b.N().O();
        PrimeInfoDao primeInfoDao = DatabaseHelper.getInstance().getDataBase().primeInfoDao();
        PrimeInfo primeInfo = primeInfoDao.loadPrimeInfoData(bl32);
        if (primeInfo != null && (bl3 = primeInfo.getStatus()) == (bl2 = true)) {
            return bl2;
        }
        PrimeWebActivity.d(context);
        return false;
    }

    public static boolean c(Fragment fragment) {
        boolean bl2;
        boolean bl3;
        int bl32 = d.v.a.f.c.b.N().O();
        PrimeInfoDao primeInfoDao = DatabaseHelper.getInstance().getDataBase().primeInfoDao();
        PrimeInfo primeInfo = primeInfoDao.loadPrimeInfoData(bl32);
        if (primeInfo != null && (bl3 = primeInfo.getStatus()) == (bl2 = true)) {
            return bl2;
        }
        PrimeWebActivity.h(fragment, 4097);
        return false;
    }

    public static void d(Activity activity) {
        PrimeWebActivity.f(activity, 4097);
    }

    public static void e(Fragment fragment) {
        PrimeWebActivity.h(fragment, 4097);
    }
}

