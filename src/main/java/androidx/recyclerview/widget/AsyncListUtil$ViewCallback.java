/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public abstract class AsyncListUtil$ViewCallback {
    public static final int HINT_SCROLL_ASC = 2;
    public static final int HINT_SCROLL_DESC = 1;
    public static final int HINT_SCROLL_NONE;

    public void extendRangeInto(int[] nArray, int[] nArray2, int n10) {
        int n11 = 1;
        int n12 = nArray[n11];
        int n13 = 0;
        int n14 = nArray[0];
        n12 = n12 - n14 + n11;
        n14 = n12 / 2;
        int n15 = nArray[0];
        int n16 = n10 == n11 ? n12 : n14;
        nArray2[0] = n15 -= n16;
        int n17 = nArray[n11];
        n13 = 2;
        if (n10 != n13) {
            n12 = n14;
        }
        nArray2[n11] = n17 += n12;
    }

    public abstract void getItemRangeInto(int[] var1);

    public abstract void onDataRefresh();

    public abstract void onItemLoaded(int var1);
}

