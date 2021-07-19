/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.account.data.database.model.UserInfo;
import d.v.c.l1.d0;
import d.v.w.c0.e;
import e.a.k0;
import e.a.m0;

public final class u
implements m0 {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ UserInfo b;
    public final /* synthetic */ int c;
    public final /* synthetic */ e d;

    public /* synthetic */ u(d0 d02, UserInfo userInfo, int n10, e e10) {
        this.a = d02;
        this.b = userInfo;
        this.c = n10;
        this.d = e10;
    }

    public final void subscribe(k0 k02) {
        d0 d02 = this.a;
        UserInfo userInfo = this.b;
        int n10 = this.c;
        e e10 = this.d;
        d02.r(userInfo, n10, e10, k02);
    }
}

