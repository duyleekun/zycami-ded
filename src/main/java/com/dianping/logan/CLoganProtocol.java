/*
 * Decompiled with CFR 0.151.
 */
package com.dianping.logan;

import d.e.a.c;
import d.e.a.g;
import d.e.a.i;
import java.util.Collections;
import java.util.Set;

public class CLoganProtocol
implements g {
    private static final String e = "logan";
    private static CLoganProtocol f;
    private static boolean g;
    private boolean a;
    private boolean b;
    private i c;
    private Set d;

    static {
        String string2 = e;
        System.loadLibrary(string2);
        boolean bl2 = true;
        try {
            g = bl2;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            bl2 = false;
            string2 = null;
            g = false;
        }
    }

    public CLoganProtocol() {
        Set set = new Set();
        this.d = set = Collections.synchronizedSet(set);
    }

    private native void clogan_debug(boolean var1);

    private native void clogan_flush();

    private native int clogan_init(String var1, String var2, int var3, String var4, String var5);

    private native int clogan_open(String var1);

    private native int clogan_write(int var1, String var2, long var3, String var5, long var6, int var8);

    public static boolean g() {
        return g;
    }

    private void h(String string2, int n10) {
        if (n10 < 0) {
            int n11;
            Object object = "clogan_write";
            boolean n112 = ((String)object).endsWith(string2);
            if (n112 && n10 != (n11 = -4060)) {
                object = this.d;
                Integer n12 = n10;
                boolean bl2 = object.contains(n12);
                if (bl2) {
                    return;
                }
                object = this.d;
                n12 = n10;
                object.add(n12);
            }
            if ((object = this.c) != null) {
                object.a(string2, n10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static CLoganProtocol i() {
        Object object = f;
        if (object != null) return f;
        object = CLoganProtocol.class;
        synchronized (object) {
            CLoganProtocol cLoganProtocol = f;
            if (cLoganProtocol != null) return f;
            f = cLoganProtocol = new CLoganProtocol();
            return f;
        }
    }

    public void a() {
        boolean bl2 = this.b;
        if (bl2 && (bl2 = g)) {
            try {
                this.clogan_flush();
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                unsatisfiedLinkError.printStackTrace();
            }
        }
    }

    public void b(String string2, String string3, int n10, String string4, String string5) {
        String string6 = "clogan_init";
        boolean bl2 = this.a;
        if (bl2) {
            return;
        }
        bl2 = g;
        if (!bl2) {
            this.h("logan_loadso", -5020);
            return;
        }
        int n11 = this.clogan_init(string2, string3, n10, string4, string5);
        boolean bl3 = true;
        this.a = bl3;
        try {
            this.h(string6, n11);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
            n11 = -1060;
            this.h(string6, n11);
        }
    }

    public void c(i i10) {
        this.c = i10;
    }

    public void d(int n10, String string2, long l10, String string3, long l11, boolean bl2) {
        block8: {
            String string4 = "clogan_write";
            int n11 = (int)(this.b ? 1 : 0);
            if (n11 != 0 && (n11 = g) != 0) {
                block7: {
                    if (bl2) {
                        n11 = 1;
                    } else {
                        n11 = 0;
                        Object var11_9 = null;
                    }
                    n11 = this.clogan_write(n10, string2, l10, string3, l11, n11);
                    int n12 = -4010;
                    if (n11 != n12) break block7;
                    n12 = (int)(d.e.a.c.c ? 1 : 0);
                    if (n12 == 0) break block8;
                }
                try {
                    this.h(string4, n11);
                }
                catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                    unsatisfiedLinkError.printStackTrace();
                    n11 = -4060;
                    this.h(string4, n11);
                }
            }
        }
    }

    public void e(String string2) {
        String string3 = "clogan_open";
        boolean bl2 = this.a;
        if (bl2 && (bl2 = g)) {
            int n10 = this.clogan_open(string2);
            bl2 = true;
            this.b = bl2;
            try {
                this.h(string3, n10);
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                unsatisfiedLinkError.printStackTrace();
                n10 = -2070;
                this.h(string3, n10);
            }
        }
    }

    public void f(boolean bl2) {
        boolean bl3 = this.a;
        if (bl3 && (bl3 = g)) {
            try {
                this.clogan_debug(bl2);
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                unsatisfiedLinkError.printStackTrace();
            }
        }
    }
}

