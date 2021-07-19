/*
 * Decompiled with CFR 0.151.
 */
package d.v.h0;

import d.v.h0.i$a;

public final class a
implements Runnable {
    public final /* synthetic */ i$a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Exception c;

    public /* synthetic */ a(i$a a10, String string2, Exception exception) {
        this.a = a10;
        this.b = string2;
        this.c = exception;
    }

    public final void run() {
        i$a i$a = this.a;
        String string2 = this.b;
        Exception exception = this.c;
        i$a.g(string2, exception);
    }
}

