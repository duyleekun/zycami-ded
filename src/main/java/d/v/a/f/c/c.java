/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.f.c;

import androidx.lifecycle.LiveData;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$OnThirdCallback;
import d.v.a.f.b.a;

public interface c {
    public void A(String var1, a var2);

    public boolean B();

    public void C();

    public boolean D();

    public void E(String var1, String var2, String var3, boolean var4, a var5);

    public void F(a var1);

    public void G(a var1);

    public boolean H();

    public void I(String var1, String var2, String var3, String var4, boolean var5, a var6);

    public void J(String var1, String var2, String var3, a var4);

    public void K(String var1, String var2, String var3, String var4, String var5, boolean var6, a var7);

    public void L(int var1, a var2);

    public void a();

    public String b();

    public LiveData c();

    public void d(String var1);

    public void e(boolean var1);

    public void f(String var1, String var2, String var3, a var4);

    public boolean g(int var1);

    public void h(boolean var1, a var2);

    public UserInfo i();

    public boolean j();

    public void k(String var1, a var2);

    public void l(boolean var1);

    public int m();

    public void n(String var1, String var2, String var3, a var4);

    public void o(ThirdPlatform var1, ThirdLoginManager$OnThirdCallback var2);

    public void p();

    public void q(boolean var1, a var2);

    public void r(UserInfo var1);

    public boolean s();

    public void t(String var1, String var2, String var3, a var4);

    public void u(String var1, String var2, String var3, String var4, String var5, a var6);

    public String v();

    public LiveData w();

    public void x(ThirdPlatform var1, AccountManager$AuthData var2, a var3);

    public void y(String var1, String var2, String var3, String var4, a var5);

    public void z(ThirdPlatform var1, AccountManager$AuthData var2, a var3);
}

