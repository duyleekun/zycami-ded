/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.a.f.c.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.account.data.database.AccountDatabase;
import com.zhiyun.account.data.database.AccountDatabaseHelper;
import com.zhiyun.account.data.database.dao.UserInfoDao;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.a.f.c.d.a;
import d.v.a.f.c.d.b;
import d.v.a.f.c.d.c;
import d.v.e.f;
import d.v.e.i.h;
import d.v.e.l.c1;
import java.util.concurrent.Executor;

public class d
extends d.v.e.d {
    private static final String f = "account_preference";
    private static final String g = "id";
    private static final String h = "token";
    private static volatile d i;
    public static final String j = "push_installation_id";
    private static final String k = "needSignOut";
    private static final String l = "is_entered_register";
    private static final String m = "main_bg_video_path";
    private UserInfoDao a;
    private AccountDatabase b;
    private d.v.a.f.b.b c;
    private UserInfo d;
    private final MutableLiveData e;

    private d() {
        Object object = new MutableLiveData();
        this.e = object;
        this.b = object = AccountDatabaseHelper.getInstance().getDataBase();
        this.a = object = ((AccountDatabase)object).userInfoDao();
        this.d = object = this.M();
        this.i0();
    }

    private static Context E() {
        return d.v.e.f.a().c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d F() {
        Object object = i;
        if (object != null) return i;
        object = d.class;
        synchronized (object) {
            d d10 = i;
            if (d10 != null) return i;
            i = d10 = new d();
            return i;
        }
    }

    public static String H() {
        return d.v.e.d.l(d.v.a.f.c.d.d.E(), f, m);
    }

    private UserInfo M() {
        Object object = d.v.a.f.c.d.d.E();
        String string2 = f;
        object = d.v.e.d.l(object, string2, h);
        Object object2 = d.v.a.f.c.d.d.E();
        String string3 = g;
        int n10 = -1;
        int n11 = d.v.e.d.h((Context)object2, string2, string3, n10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && n11 != n10) {
            object2 = this.a.loadUserInfoData(n11);
            if (object2 == null) {
                object2 = new UserInfo();
                ((UserInfo)object2).setId(n11);
                ((UserInfo)object2).setToken((String)object);
            }
            return object2;
        }
        object = new UserInfo();
        return object;
    }

    public static boolean N() {
        return d.v.e.d.d(d.v.a.f.c.d.d.E(), f, l, false);
    }

    private /* synthetic */ LiveData S(String string2) {
        Context context = d.v.a.f.c.d.d.E();
        String string3 = f;
        String string4 = g;
        int n10 = -1;
        int n11 = d.v.e.d.h(context, string3, string4, n10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && n11 > 0) {
            return this.a.loadUserInfo(n11);
        }
        return d.v.e.i.d.create();
    }

    private /* synthetic */ void U() {
        UserInfoDao userInfoDao = this.a;
        UserInfo userInfo = this.d;
        UserInfo[] userInfoArray = new UserInfo[]{userInfo};
        userInfoDao.insertUserInfo(userInfoArray);
    }

    private /* synthetic */ void W() {
        AccountDatabase accountDatabase = this.b;
        c c10 = new c(this);
        accountDatabase.runInTransaction(c10);
    }

    public static void Y(boolean bl2) {
        d.v.e.d.s(d.v.a.f.c.d.d.E(), f, l, bl2);
    }

    public static void Z(String string2) {
        d.v.e.d.x(d.v.a.f.c.d.d.E(), f, m, string2);
    }

    private void b0() {
        Executor executor = c1.b().a();
        a a10 = new a(this);
        executor.execute(a10);
    }

    private void i0() {
        MutableLiveData mutableLiveData = this.e;
        String string2 = d.v.e.d.l(d.v.a.f.c.d.d.E(), f, h);
        d.v.e.i.h.e(mutableLiveData, string2);
    }

    public boolean A(int n10) {
        d.v.a.f.b.b b10;
        int n11 = 10140;
        if (n10 != n11 && n10 != (n11 = 10142) && n10 != (n11 = 10143)) {
            return false;
        }
        n10 = (int)(this.Q() ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            b10 = null;
            this.c0(null);
        }
        if ((b10 = this.c) != null) {
            b10.b();
        }
        return true;
    }

    public int B() {
        return this.d.getAdnotification();
    }

    public String C() {
        return this.d.getMail();
    }

    public String D() {
        return this.d.getMobile();
    }

    public LiveData G() {
        MutableLiveData mutableLiveData = this.e;
        b b10 = new b(this);
        return Transformations.switchMap(mutableLiveData, b10);
    }

    public d.v.a.f.b.b I() {
        return this.c;
    }

    public String J() {
        return d.v.e.d.l(d.v.a.f.c.d.d.E(), f, j);
    }

    public String K() {
        String string2 = this.d.getToken();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        string2 = bl2 ? "" : this.d.getToken();
        return string2;
    }

    public UserInfo L() {
        return this.d;
    }

    public boolean O() {
        return d.v.e.d.d(d.v.a.f.c.d.d.E(), f, k, false);
    }

    public boolean P() {
        return TextUtils.isEmpty((CharSequence)this.d.getToken()) ^ true;
    }

    public boolean Q() {
        String string2 = this.d.getToken();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!(bl2 || (bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.d.getMobile()))) && (bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.d.getMail()))))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public boolean R() {
        String string2 = this.d.getToken();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.d.getMail()))) && (bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.d.getMobile())))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public /* synthetic */ LiveData T(String string2) {
        return this.S(string2);
    }

    public /* synthetic */ void V() {
        this.U();
    }

    public /* synthetic */ void X() {
        this.W();
    }

    public void a0(String string2) {
        d.v.e.d.x(d.v.a.f.c.d.d.E(), f, j, string2);
    }

    public void c0(UserInfo object) {
        Object object2 = this.d;
        boolean bl2 = ((UserInfo)object2).equals(object);
        if (bl2) {
            return;
        }
        if (object == null) {
            object = new UserInfo();
        } else {
            object2 = ((UserInfo)object).getToken();
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                object2 = this.K();
                ((UserInfo)object).setToken((String)object2);
            }
        }
        this.d = object;
        object2 = d.v.a.f.c.d.d.E();
        int n10 = ((UserInfo)object).getId();
        String string2 = f;
        d.v.e.d.u((Context)object2, string2, g, n10);
        object2 = d.v.a.f.c.d.d.E();
        object = ((UserInfo)object).getToken();
        d.v.e.d.x((Context)object2, string2, h, (String)object);
        this.b0();
        this.i0();
    }

    public void d0(int n10) {
        this.d.setAdnotification(n10);
        this.b0();
    }

    public void e0(String string2) {
        this.d.setMail(string2);
        this.b0();
    }

    public void f0(String string2) {
        this.d.setMobile(string2);
        this.b0();
    }

    public void g0(boolean bl2) {
        d.v.e.d.s(d.v.a.f.c.d.d.E(), f, k, bl2);
    }

    public void h0(d.v.a.f.b.b b10) {
        this.c = b10;
    }

    public void j0(int n10) {
        this.d.setFollows_count(n10);
        this.b0();
    }

    public void k0(String string2) {
        this.d.setStatus(string2);
        this.b0();
    }

    public void z(int n10) {
        UserInfo userInfo = this.d;
        int n11 = userInfo.getShare_post_count() + n10;
        userInfo.setShare_post_count(n11);
        this.b0();
    }
}

