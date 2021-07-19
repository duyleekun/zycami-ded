/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import kotlin.collections.State;

public final class a {
    public static final /* synthetic */ int[] a;

    static {
        int[] nArray = new int[State.values().length];
        a = nArray;
        int n10 = State.Done.ordinal();
        nArray[n10] = 1;
        n10 = State.Ready.ordinal();
        nArray[n10] = 2;
    }
}

