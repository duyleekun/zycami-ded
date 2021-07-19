/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.a0;
import com.geetest.sdk.ay;

public class a0$b
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ a0 d;

    public a0$b(a0 a02, int n10, String string2, Object object) {
        this.d = a02;
        this.a = n10;
        this.b = string2;
        this.c = object;
    }

    public void run() {
        ay ay2 = this.d;
        ay2 = a0.a((a0)ay2);
        int n10 = this.a;
        String string2 = this.b;
        Object object = this.c;
        try {
            ay2.a(n10, string2, object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

