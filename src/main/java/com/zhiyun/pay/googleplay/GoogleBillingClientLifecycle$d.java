/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.pay.googleplay;

import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle;
import d.b.a.b.f;
import d.b.a.b.h;

public class GoogleBillingClientLifecycle$d
implements f {
    public final /* synthetic */ f a;
    public final /* synthetic */ GoogleBillingClientLifecycle b;

    public GoogleBillingClientLifecycle$d(GoogleBillingClientLifecycle googleBillingClientLifecycle, f f10) {
        this.b = googleBillingClientLifecycle;
        this.a = f10;
    }

    public void a(h h10) {
        GoogleBillingClientLifecycle.b(this.b).a(h10);
        f f10 = this.a;
        if (f10 != null) {
            f10.a(h10);
        }
    }

    public void b() {
        GoogleBillingClientLifecycle.b(this.b).b();
        f f10 = this.a;
        if (f10 != null) {
            f10.b();
        }
    }
}

