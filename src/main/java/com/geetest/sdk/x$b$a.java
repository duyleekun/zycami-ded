/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.bb;
import com.geetest.sdk.g;
import com.geetest.sdk.g$f;
import com.geetest.sdk.model.beans.i;
import com.geetest.sdk.x$b;

public class x$b$a
implements Runnable {
    public final /* synthetic */ x$b a;

    public x$b$a(x$b b10) {
        this.a = b10;
    }

    public void run() {
        Object object;
        this.a.b.b.e().b();
        Object object2 = this.a.b.b;
        int n10 = ((bb)object2).g();
        int n11 = 2;
        if (n10 == n11 && (object2 = this.a.b.b.a()) != null) {
            object = i.b();
            String string2 = "";
            object2.a((String)object, string2);
        }
        object2 = this.a.b.b.e();
        object = g$f.NUMBER_ONE_CLOSE;
        ((g)object2).a((g$f)((Object)object));
        this.a.b.d.getListener().onClosed(1);
    }
}

