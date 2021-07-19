/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.a.f.c;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.ThirdLoginManager;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$OnThirdCallback;
import d.v.a.f.c.a;
import d.v.a.f.c.b$a;
import d.v.a.f.c.b$b;
import d.v.a.f.c.b$c;
import d.v.a.f.c.b$d;
import d.v.a.f.c.b$e;
import d.v.a.f.c.b$f;
import d.v.a.f.c.b$g;
import d.v.a.f.c.b$h;
import d.v.a.f.c.b$i;
import d.v.a.f.c.c;
import d.v.a.f.c.d.d;
import d.v.e.l.w1;
import java.util.Objects;

public class b
implements c {
    private static volatile b b;
    private final d a;

    private b() {
        d d10;
        this.a = d10 = d.F();
    }

    public static /* synthetic */ d M(b b10) {
        return b10.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b N() {
        Object object = b;
        if (object != null) return b;
        object = b.class;
        synchronized (object) {
            b b10 = b;
            if (b10 != null) return b;
            b = b10 = new b();
            return b;
        }
    }

    public static /* synthetic */ void Q(MediatorLiveData object, MediatorLiveData mediatorLiveData, UserInfo object2) {
        int n10;
        int n11 = -1;
        Integer n12 = n11;
        if (object2 != null) {
            n10 = ((UserInfo)object2).getId();
            n12 = n10;
        }
        if ((n10 = (int)(Objects.equals(object2 = ((LiveData)object).getValue(), n12) ? 1 : 0)) == 0) {
            ((MutableLiveData)object).setValue(n12);
            int n13 = n12;
            if (n13 > 0) {
                object = Boolean.TRUE;
                mediatorLiveData.setValue(object);
            } else {
                object = Boolean.FALSE;
                mediatorLiveData.setValue(object);
            }
        }
    }

    public void A(String string2, d.v.a.f.b.a a10) {
        AccountManager.webLogin(this.a.K(), string2, a10);
    }

    public boolean B() {
        return d.N();
    }

    public void C() {
        AccountManager.requestLogout();
        this.a.c0(null);
    }

    public boolean D() {
        return this.a.P();
    }

    public void E(String string2, String string3, String string4, boolean bl2, d.v.a.f.b.a a10) {
        AccountManager.requestVerifyVCode(string2, string3, string4, bl2, a10);
    }

    public void F(d.v.a.f.b.a a10) {
        AccountManager.getBindThirdList(this.a.K(), a10);
    }

    public void G(d.v.a.f.b.a a10) {
        b$d b$d = new b$d(this, a10);
        AccountManager.loginByImei(b$d);
    }

    public boolean H() {
        return this.a.O();
    }

    public void I(String string2, String string3, String string4, String string5, boolean bl2, d.v.a.f.b.a a10) {
        AccountManager.requestSignUp(string2, string3, string4, string5, bl2, a10);
    }

    public void J(String string2, String string3, String string4, d.v.a.f.b.a a10) {
        b$a b$a = new b$a(this, a10);
        AccountManager.requestSignIn(string2, string3, string4, b$a);
    }

    public void K(String string2, String string3, String string4, String string5, String string6, boolean bl2, d.v.a.f.b.a a10) {
        AccountManager.requestCode(string2, string3, string4, string5, string6, bl2, a10);
    }

    public void L(int n10, d.v.a.f.b.a a10) {
        String string2 = this.a.K();
        AccountManager.removeThird(n10, string2, a10);
    }

    public int O() {
        UserInfo userInfo = this.i();
        if (userInfo != null) {
            return userInfo.getId();
        }
        return -1;
    }

    public String P() {
        UserInfo userInfo = this.i();
        if (userInfo != null) {
            return userInfo.getToken();
        }
        return "";
    }

    public void a() {
        String string2 = this.a.K();
        String string3 = this.a.J();
        AccountManager.bindLeanCloudPush(string2, "android", string3);
    }

    public String b() {
        return this.a.C();
    }

    public LiveData c() {
        return this.a.G();
    }

    public void d(String string2) {
        this.a.k0(string2);
    }

    public void e(boolean bl2) {
        this.a.g0(bl2);
    }

    public void f(String string2, String string3, String string4, d.v.a.f.b.a a10) {
        b$b b$b = new b$b(this, a10);
        AccountManager.quickLogin(string2, string3, string4, b$b);
    }

    public boolean g(int n10) {
        return this.a.A(n10);
    }

    public void h(boolean bl2, d.v.a.f.b.a a10) {
        String string2;
        int n10 = this.s();
        if (n10 != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(string2 = this.b())) ? 1 : 0)) == 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(string2 = this.v())) ? 1 : 0)) == 0) {
            string2 = this.i().getToken();
            b$i b$i = new b$i(this, bl2, a10);
            AccountManager.removeBind(bl2, string2, b$i);
        } else {
            bl2 = false;
            n10 = -1;
            String string3 = "";
            a10.onError(null, n10, string3);
        }
    }

    public UserInfo i() {
        return this.a.L();
    }

    public boolean j() {
        return this.a.R();
    }

    public void k(String string2, d.v.a.f.b.a a10) {
        String string3 = this.a.K();
        b$e b$e = new b$e(this, a10);
        AccountManager.initPassword(string2, string3, b$e);
    }

    public void l(boolean bl2) {
        d.Y(bl2);
    }

    public int m() {
        return this.a.B();
    }

    public void n(String string2, String string3, String string4, d.v.a.f.b.a a10) {
        b$f b$f = new b$f(this, a10);
        AccountManager.bindVerify(string2, string3, string4, b$f);
    }

    public void o(ThirdPlatform thirdPlatform, ThirdLoginManager$OnThirdCallback thirdLoginManager$OnThirdCallback) {
        ThirdLoginManager.getInstance().thirdLogin(thirdPlatform, thirdLoginManager$OnThirdCallback);
    }

    public void p() {
        String string2 = this.a.K();
        String string3 = this.a.J();
        String string4 = w1.a();
        AccountManager.updateLangLeanCloudPush(string2, "android", string3, string4);
    }

    public void q(boolean bl2, d.v.a.f.b.a a10) {
        b$h b$h = new b$h(this, (int)(bl2 ? 1 : 0), a10);
        AccountManager.setAdnotification((int)(bl2 ? 1 : 0), b$h);
    }

    public void r(UserInfo userInfo) {
        this.a.c0(userInfo);
    }

    public boolean s() {
        return this.a.Q();
    }

    public void t(String string2, String string3, String string4, d.v.a.f.b.a a10) {
        String string5 = this.a.K();
        b$g b$g = new b$g(this, string2, string3, a10);
        AccountManager.bindAccount(string5, string2, string3, string4, b$g);
    }

    public void u(String string2, String string3, String string4, String string5, String string6, d.v.a.f.b.a a10) {
        AccountManager.requestPasswordReset(string2, string3, string4, string5, string6, a10);
    }

    public String v() {
        return this.a.D();
    }

    public LiveData w() {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        MediatorLiveData mediatorLiveData2 = new MediatorLiveData();
        LiveData liveData = this.a.G();
        a a10 = new a(mediatorLiveData, mediatorLiveData2);
        mediatorLiveData2.addSource(liveData, a10);
        return mediatorLiveData2;
    }

    public void x(ThirdPlatform object, AccountManager$AuthData accountManager$AuthData, d.v.a.f.b.a a10) {
        String string2 = this.a.K();
        object = object.getApiName();
        AccountManager.bindThird(string2, (String)object, accountManager$AuthData, a10);
    }

    public void y(String string2, String string3, String string4, String string5, d.v.a.f.b.a a10) {
        AccountManager.resetPassword(string2, string3, string4, string5, a10);
    }

    public void z(ThirdPlatform object, AccountManager$AuthData accountManager$AuthData, d.v.a.f.b.a a10) {
        object = object.getApiName();
        b$c b$c = new b$c(this, a10);
        AccountManager.bindThirdPartyAccount((String)object, accountManager$AuthData, b$c);
    }
}

