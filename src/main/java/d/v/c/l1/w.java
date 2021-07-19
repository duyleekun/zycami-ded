/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.account.data.database.model.UserInfo;
import d.v.c.l1.d0;
import e.a.k0;
import e.a.m0;
import java.util.concurrent.atomic.AtomicBoolean;

public final class w
implements m0 {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ UserInfo b;
    public final /* synthetic */ String c;
    public final /* synthetic */ AtomicBoolean d;
    public final /* synthetic */ AtomicBoolean e;

    public /* synthetic */ w(d0 d02, UserInfo userInfo, String string2, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2) {
        this.a = d02;
        this.b = userInfo;
        this.c = string2;
        this.d = atomicBoolean;
        this.e = atomicBoolean2;
    }

    public final void subscribe(k0 k02) {
        d0 d02 = this.a;
        UserInfo userInfo = this.b;
        String string2 = this.c;
        AtomicBoolean atomicBoolean = this.d;
        AtomicBoolean atomicBoolean2 = this.e;
        d02.t(userInfo, string2, atomicBoolean, atomicBoolean2, k02);
    }
}

