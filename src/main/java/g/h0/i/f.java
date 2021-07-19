/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import java.net.Proxy;

public final class f {
    public static final /* synthetic */ int[] a;

    static {
        int[] nArray = new int[Proxy.Type.values().length];
        a = nArray;
        int n10 = Proxy.Type.DIRECT.ordinal();
        nArray[n10] = 1;
        n10 = Proxy.Type.HTTP.ordinal();
        nArray[n10] = 2;
    }
}

