/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.al$b;
import com.xiaomi.push.gw;

public class gv {
    private static al a;

    static {
        al al2;
        a = al2 = new al(true, 20);
    }

    public static void a(al$b al$b) {
        a.a(al$b);
    }

    public static void a(al$b al$b, long l10) {
        a.a(al$b, l10);
    }

    public static void a(Runnable runnable) {
        al al2 = a;
        gw gw2 = new gw(runnable);
        al2.a(gw2);
    }
}

