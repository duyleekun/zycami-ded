/*
 * Decompiled with CFR 0.151.
 */
package f.z1;

import f.h2.s.a;
import f.h2.t.f0;
import f.z1.b$a;

public final class b {
    private static final Object a(ThreadLocal threadLocal, a a10) {
        Object object = threadLocal.get();
        if (object == null) {
            object = a10.invoke();
            threadLocal.set(object);
        }
        return object;
    }

    public static final Thread b(boolean bl2, boolean bl3, ClassLoader classLoader, String string2, int n10, a a10) {
        f0.p(a10, "block");
        b$a b$a = new b$a(a10);
        if (bl3) {
            bl3 = true;
            b$a.setDaemon(bl3);
        }
        if (n10 > 0) {
            b$a.setPriority(n10);
        }
        if (string2 != null) {
            b$a.setName(string2);
        }
        if (classLoader != null) {
            b$a.setContextClassLoader(classLoader);
        }
        if (bl2) {
            b$a.start();
        }
        return b$a;
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ Thread c(boolean bl2, boolean bl3, ClassLoader classLoader, String string2, int n10, a a10, int n11, Object object) {
        void var5_10;
        int n12;
        void var3_8;
        void var2_7;
        boolean bl4;
        boolean bl5;
        void var6_11;
        int n13 = var6_11 & 1;
        if (n13 != 0) {
            bl5 = true;
        }
        void var9_14 = bl5;
        int n14 = var6_11 & 2;
        if (n14 != 0) {
            bl4 = false;
        }
        void var10_15 = bl4;
        int n15 = var6_11 & 4;
        bl4 = false;
        Object object2 = n15 != 0 ? null : var2_7;
        int n16 = var6_11 & 8;
        Object object3 = n16 != 0 ? null : var3_8;
        int n17 = var6_11 & 0x10;
        if (n17 != 0) {
            n12 = -1;
        }
        return b.b((boolean)var9_14, (boolean)var10_15, object2, object3, n12, (a)var5_10);
    }
}

