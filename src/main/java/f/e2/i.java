/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import kotlin.io.FileWalkDirection;

public final class i {
    public static final /* synthetic */ int[] a;

    static {
        int[] nArray = new int[FileWalkDirection.values().length];
        a = nArray;
        int n10 = FileWalkDirection.TOP_DOWN.ordinal();
        nArray[n10] = 1;
        n10 = FileWalkDirection.BOTTOM_UP.ordinal();
        nArray[n10] = 2;
    }
}

