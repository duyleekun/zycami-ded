/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import androidx.lifecycle.LiveData;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.api.entity.ShareInfo;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.data.me.remote.SharePlatformManager$OnShareCallback;
import com.zhiyun.net.Punish;
import d.v.a.f.b.a;
import d.v.c.v0.g;
import java.util.List;

public interface x {
    public void A(MessagePageType var1);

    public void B(int var1);

    public void C();

    public void D(String var1, a var2);

    public void E(String var1, Approval var2, Punish var3, String var4, List var5, a var6);

    public void F(a var1);

    public LiveData G();

    public void H(int var1);

    public void a(a var1);

    public void b(String var1, String var2, String var3, a var4);

    public void c(ThirdPlatform var1, ShareInfo var2, SharePlatformManager$OnShareCallback var3);

    public void d(String var1, a var2);

    public void e(String var1, int var2);

    public void f();

    public void g(int var1, a var2);

    public LiveData h();

    public LiveData i();

    public void j();

    public void k(Feedback var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, a var12);

    public LiveData l();

    public g loadFeedbackList();

    public g loadMessageLike();

    public g loadMessageSystem();

    public g loadMessageViolation();

    public g m(int var1);

    public void n(a var1);

    public void o(a var1);

    public void p(a var1);

    public void q(String var1, a var2);

    public void r();

    public LiveData s(int var1, boolean var2);

    public void t(UserInfo var1, a var2);

    public g u(int var1);

    public void v(int var1);

    public void w();

    public void x(MessagePageType var1);

    public void y(MessagePageType var1, int var2, a var3);

    public void z(String var1, a var2);
}

