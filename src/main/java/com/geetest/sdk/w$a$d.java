/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.bb;
import com.geetest.sdk.w;
import com.geetest.sdk.w$a;

public class w$a$d
implements Runnable {
    public final /* synthetic */ w$a a;

    public w$a$d(w$a w$a) {
        this.a = w$a;
    }

    public void run() {
        Object object = this.a;
        w w10 = ((w$a)object).b;
        object = ((w$a)object).a;
        w10.e((bb)object);
        object = this.a;
        w10 = ((w$a)object).b;
        object = ((w$a)object).a;
        w10.b((bb)object);
    }
}

