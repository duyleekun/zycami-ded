/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b2.w.l;

import java.util.List;

public interface b {
    public static void c(b b10) {
        boolean bl2;
        if (b10 != null && (bl2 = b10.f())) {
            b10.b();
        }
    }

    public static boolean d(List object) {
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                bl2 = b.e(b10);
                if (bl2) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean e(b b10) {
        boolean bl2;
        if (b10 != null && (bl2 = b10.f())) {
            bl2 = true;
        } else {
            bl2 = false;
            b10 = null;
        }
        return bl2;
    }

    public static void k(List object) {
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b.c(b10);
            }
        }
    }

    public void b();

    public boolean f();
}

