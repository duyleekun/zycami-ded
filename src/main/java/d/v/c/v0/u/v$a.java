/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import androidx.lifecycle.LiveData;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.cama.data.me.remote.CommunityManager;
import d.v.c.v0.u.a;
import d.v.c.v0.u.b0.d;
import d.v.c.v0.u.v;
import d.v.e.l.c1;
import d.v.j.e.h.j;

public class v$a
extends j {
    public final /* synthetic */ boolean d;
    public final /* synthetic */ int e;
    public final /* synthetic */ v f;

    public v$a(v v10, c1 c12, boolean bl2, int n10) {
        this.f = v10;
        this.d = bl2;
        this.e = n10;
        super(c12);
    }

    public static /* synthetic */ void t(UserInfo userInfo) {
        d.v.a.f.c.d.d d10 = d.v.a.f.c.d.d.F();
        userInfo = AccountManager.convertUserInfoResponse(userInfo);
        d10.c0(userInfo);
    }

    public k.d e() {
        CommunityManager communityManager = v.K(this.f);
        int n10 = this.e;
        return communityManager.createUserDetail(n10);
    }

    public LiveData n() {
        d d10 = v.I(this.f);
        int n10 = this.e;
        return d10.b(n10);
    }

    public void u(UserInfo userInfo) {
        Object object = v.I(this.f);
        ((d)object).c(userInfo);
        int n10 = userInfo.getId();
        Object object2 = d.v.a.f.c.d.d.F().L();
        int n11 = ((UserInfo)object2).getId();
        if (n10 == n11) {
            object = v.J(this.f).c();
            object2 = new a(userInfo);
            object.execute((Runnable)object2);
        }
    }

    public boolean v(UserInfo userInfo) {
        return this.d;
    }
}

