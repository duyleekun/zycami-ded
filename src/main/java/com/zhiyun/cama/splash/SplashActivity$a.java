/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.splash;

import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.cama.splash.SplashActivity;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.b;
import d.v.a.f.c.d.d;
import d.v.c.p0.o.f;
import d.v.c.x1.h;
import d.v.e.i.j;

public class SplashActivity$a
implements b {
    public final /* synthetic */ SplashActivity a;

    public SplashActivity$a(SplashActivity splashActivity) {
        this.a = splashActivity;
    }

    public void a(BaseEntity baseEntity) {
        j j10 = SplashActivity.d((SplashActivity)this.a).k;
        Boolean bl2 = Boolean.TRUE;
        j10.setValue(bl2);
        f.e(h.e().f(), baseEntity);
    }

    public void b() {
        Object object = d.v.a.f.c.b.N();
        boolean bl2 = ((d.v.a.f.c.b)object).s();
        if (bl2) {
            AccountManager.requestLogout();
            object = d.F();
            ((d)object).c0(null);
        }
    }
}

