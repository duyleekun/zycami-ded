/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.s.a;
import f.h2.t.f0;
import f.t;
import f.u;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SafePublicationLazyImpl;
import kotlin.SynchronizedLazyImpl;
import kotlin.UnsafeLazyImpl;

public class w {
    public static final t a(Object object, a a10) {
        f0.p(a10, "initializer");
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(a10, object);
        return synchronizedLazyImpl;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static final t b(LazyThreadSafetyMode object, a a10) {
        void var0_5;
        void var1_6;
        f0.p(object, "mode");
        f0.p(var1_6, "initializer");
        int[] nArray = u.a;
        int n10 = ((Enum)object).ordinal();
        n10 = nArray[n10];
        int n11 = 1;
        int n12 = 2;
        if (n10 == n11) {
            n11 = 0;
            nArray = null;
            SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl((a)var1_6, null, n12, null);
            return var0_5;
        }
        if (n10 == n12) {
            SafePublicationLazyImpl safePublicationLazyImpl = new SafePublicationLazyImpl((a)var1_6);
            return var0_5;
        }
        n11 = 3;
        if (n10 == n11) {
            UnsafeLazyImpl unsafeLazyImpl = new UnsafeLazyImpl((a)var1_6);
            return var0_5;
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }

    public static final t c(a a10) {
        f0.p(a10, "initializer");
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(a10, null, 2, null);
        return synchronizedLazyImpl;
    }
}

