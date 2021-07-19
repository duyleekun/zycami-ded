/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.bb;
import com.geetest.sdk.g;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.u;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.x$b;

public class x
extends u {
    private static final String f = "x";

    public static /* synthetic */ void a(x x10, String string2, String string3, String string4, boolean bl2) {
        x10.a(string2, string3, string4, bl2);
    }

    private void a(String object, String object2, String string2, boolean bl2) {
        l.b(f, (String)object2);
        object2 = new a();
        ((a)object2).c(string2);
        ((a)object2).b((String)object);
        long l10 = System.currentTimeMillis();
        long l11 = this.b.j();
        ((a)object2).a(l10 -= l11);
        object = this.b.d().c();
        ((a)object2).a((String)object);
        ((a)object2).a(bl2);
        this.b.a((a)object2);
        object = this.b;
        this.b((bb)object);
    }

    public int a() {
        return 20;
    }

    public void a(bb object) {
        g g10 = ((bb)object).e();
        x$b x$b = new x$b(this, null);
        object = ((bb)object).d();
        g10.a((b)object, x$b);
    }
}

