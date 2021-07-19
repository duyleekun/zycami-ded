/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.PrimeInfoDao;
import com.zhiyun.cama.data.me.remote.PrimeManager$1;
import com.zhiyun.cama.data.me.remote.PrimeManager$2;
import com.zhiyun.cama.data.me.remote.PrimeManager$3;
import com.zhiyun.cama.data.me.remote.PrimeManager$4;
import com.zhiyun.cama.prime.model.PrimeInfo;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.c.v0.u.c0.h;
import d.v.e.l.c1;
import java.util.concurrent.Executor;
import k.d;
import k.f;

public class PrimeManager {
    public static /* synthetic */ void a(PrimeInfo primeInfo) {
        PrimeInfoDao primeInfoDao = DatabaseHelper.getInstance().getDataBase().primeInfoDao();
        PrimeInfo[] primeInfoArray = new PrimeInfo[]{primeInfo};
        primeInfoDao.insertPrimeInfoInfo(primeInfoArray);
    }

    public static PrimeInfo getLocalPrimeInfo(int n10) {
        return DatabaseHelper.getInstance().getDataBase().primeInfoDao().loadPrimeInfoData(n10);
    }

    public static void requestActivatePrime(String object, String object2, a a10) {
        object = d.v.c.v0.l.h.a.a((String)object, (String)object2);
        object2 = new PrimeManager$3(a10);
        object.h((f)object2);
    }

    public static void requestPrime(String string2) {
        PrimeManager$1 primeManager$1 = new PrimeManager$1();
        PrimeManager.requestPrime(string2, primeManager$1);
    }

    public static void requestPrime(String object, a a10) {
        object = d.v.c.v0.l.h.a.b((String)object);
        PrimeManager$2 primeManager$2 = new PrimeManager$2(a10);
        object.h(primeManager$2);
    }

    public static void savePrimeInfo(PrimeInfo primeInfo) {
        Executor executor = c1.b().a();
        h h10 = new h(primeInfo);
        executor.execute(h10);
    }

    public static void uploadCloudLog(String string2, String string3, String string4, String string5, int n10, int n11, int n12, a a10) {
        Object object = b.N().i().getToken();
        d d10 = d.v.c.v0.l.h.a.c((String)object, string2, "1.2.6", string3, string4, string5, n10, n11, n12);
        object = a10;
        PrimeManager$4 primeManager$4 = new PrimeManager$4(a10);
        d10.h(primeManager$4);
    }
}

