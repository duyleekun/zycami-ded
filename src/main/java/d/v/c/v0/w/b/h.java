/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.v0.w.b;

import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.AbsentLiveData;
import com.zhiyun.cama.data.database.AppDatabase;
import com.zhiyun.cama.data.database.dao.SplashAdDao;
import com.zhiyun.cama.data.database.model.SplashAd;
import com.zhiyun.cama.data.database.model.SplashAdWatch;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;
import d.v.c.v0.w.b.a;
import d.v.c.v0.w.b.b;
import d.v.c.v0.w.b.c;
import d.v.c.v0.w.b.d;
import d.v.c.v0.w.b.e;
import d.v.c.v0.w.b.f;
import d.v.c.v0.w.b.g;
import d.v.c.v0.w.b.h$a;
import d.v.e.l.c1;
import d.v.e.l.k2;
import d.v.e.l.m1;
import d.v.e.l.s1;
import d.v.e.l.w1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executor;

public class h {
    private static volatile h c;
    private final c1 a;
    private final SplashAdDao b;

    private h(AppDatabase object, c1 c12) {
        this.b = object = ((AppDatabase)object).splashAdDao();
        Objects.requireNonNull(c12);
        this.a = c12;
    }

    private void A(int n10) {
        Executor executor = this.a.a();
        b b10 = new b(this, n10);
        executor.execute(b10);
    }

    public static /* synthetic */ void a(h h10, SplashAd splashAd, String string2) {
        h10.y(splashAd, string2);
    }

    private void b(SplashAd splashAd) {
        synchronized (this) {
            block20: {
                if (splashAd != null) {
                    String string2 = splashAd.getImage();
                    boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                    if (bl2) break block20;
                    string2 = splashAd.getImage();
                    string2 = s1.J(string2);
                    DownLoadHelper downLoadHelper = DownLoadHelper.getInstance();
                    String string3 = splashAd.getImage();
                    Object object = k2.R();
                    object = ((File)object).getAbsolutePath();
                    Object object2 = new StringBuilder();
                    String string4 = "splash";
                    ((StringBuilder)object2).append(string4);
                    int n10 = splashAd.getId();
                    ((StringBuilder)object2).append(n10);
                    string4 = ".";
                    ((StringBuilder)object2).append(string4);
                    ((StringBuilder)object2).append(string2);
                    string2 = ((StringBuilder)object2).toString();
                    object2 = new h$a(this, splashAd);
                    downLoadHelper.startThreadPoolDownLoad(string3, (String)object, string2, (DownLoadHelper$OnDownloadCallback)object2);
                    return;
                }
            }
            return;
        }
    }

    public static h c(AppDatabase appDatabase, c1 c12) {
        h h10 = c;
        if (h10 == null) {
            c = h10 = new h(appDatabase, c12);
        }
        return c;
    }

    private String d() {
        return w1.a();
    }

    private LiveData e(List list) {
        int n10 = list.size();
        Random random = new Random();
        n10 = random.nextInt(n10);
        int n11 = ((SplashAd)list.get(n10)).getId();
        this.A(n11);
        return this.b.loadSplashAd(n11);
    }

    private long f() {
        long l10 = System.currentTimeMillis();
        long l11 = 1000L;
        long l12 = (28800L + (l10 /= l11)) % 86400L;
        return (l10 - l12) * l11;
    }

    private /* synthetic */ LiveData g(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            return this.e(list);
        }
        return this.x();
    }

    private /* synthetic */ LiveData i(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            return this.e(list);
        }
        return AbsentLiveData.create();
    }

    private /* synthetic */ LiveData k(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            return this.e(list);
        }
        return this.w();
    }

    private /* synthetic */ void m(ArrayList object) {
        boolean bl2;
        if (object != null && !(bl2 = ((ArrayList)object).isEmpty())) {
            object = ((ArrayList)object).iterator();
            while (bl2 = object.hasNext()) {
                SplashAd splashAd = (SplashAd)object.next();
                this.b(splashAd);
            }
        }
    }

    private /* synthetic */ void o(ArrayList arrayList) {
        this.b.deleteAllSplashAd();
        Executor executor = this.a.c();
        a a10 = new a(this, arrayList);
        executor.execute(a10);
    }

    private /* synthetic */ void q(SplashAd splashAd, String object) {
        splashAd.setFilePath((String)object);
        int n10 = s1.b0((String)object);
        splashAd.setVideo(n10 != 0);
        n10 = splashAd.getPeriod();
        int n11 = 1;
        if (n10 > 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        splashAd.setAutoDisappear(n10 != 0);
        object = this.d();
        splashAd.setLang((String)object);
        long l10 = m1.V(splashAd.getStartAt());
        splashAd.setStartUnix(l10);
        l10 = m1.V(splashAd.getEndAt());
        splashAd.setEndUnix(l10);
        object = this.b;
        int n12 = splashAd.getId();
        object = object.loadSplashAdWatchData(n12);
        if (object == null) {
            n12 = splashAd.getId();
            object = new SplashAdWatch(n12);
            ((SplashAdWatch)object).setWatched(false);
        }
        this.b.insertSplashAdWatch((SplashAdWatch)object);
        splashAd.setSplashAdWatch((SplashAdWatch)object);
        object = this.b;
        SplashAd[] splashAdArray = new SplashAd[n11];
        splashAdArray[0] = splashAd;
        object.insertSplashAd(splashAdArray);
    }

    private /* synthetic */ void s(int n10) {
        SplashAdWatch splashAdWatch = this.b.loadSplashAdWatchData(n10);
        if (splashAdWatch == null) {
            splashAdWatch = new SplashAdWatch(n10);
        }
        splashAdWatch.setWatched(true);
        long l10 = System.currentTimeMillis();
        splashAdWatch.setWatchTime(l10);
        this.b.insertSplashAdWatch(splashAdWatch);
    }

    private LiveData v() {
        Object object = this.b;
        Object object2 = this.d();
        long l10 = System.currentTimeMillis();
        object = object.loadTypeOneSplashAd((String)object2, l10);
        object2 = new g(this);
        return Transformations.switchMap((LiveData)object, (Function)object2);
    }

    private LiveData w() {
        Object object = this.b;
        Object object2 = this.d();
        long l10 = System.currentTimeMillis();
        object = object.loadTypeThreeSplashAd((String)object2, l10);
        object2 = new f(this);
        return Transformations.switchMap((LiveData)object, (Function)object2);
    }

    private LiveData x() {
        Object object = this.b;
        Object object2 = this.d();
        long l10 = System.currentTimeMillis();
        long l11 = this.f();
        object = object.loadTypeTwoSplashAd((String)object2, l10, l11);
        object2 = new e(this);
        return Transformations.switchMap((LiveData)object, (Function)object2);
    }

    private void y(SplashAd splashAd, String string2) {
        Executor executor = this.a.a();
        c c10 = new c(this, splashAd, string2);
        executor.execute(c10);
    }

    public /* synthetic */ LiveData h(List list) {
        return this.g(list);
    }

    public /* synthetic */ LiveData j(List list) {
        return this.i(list);
    }

    public /* synthetic */ LiveData l(List list) {
        return this.k(list);
    }

    public /* synthetic */ void n(ArrayList arrayList) {
        this.m(arrayList);
    }

    public /* synthetic */ void p(ArrayList arrayList) {
        this.o(arrayList);
    }

    public /* synthetic */ void r(SplashAd splashAd, String string2) {
        this.q(splashAd, string2);
    }

    public /* synthetic */ void t(int n10) {
        this.s(n10);
    }

    public LiveData u() {
        return this.v();
    }

    public void z(ArrayList arrayList) {
        Executor executor = this.a.a();
        d d10 = new d(this, arrayList);
        executor.execute(d10);
    }
}

