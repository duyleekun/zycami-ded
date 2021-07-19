/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public abstract class AsyncListUtil$DataCallback {
    public abstract void fillData(Object[] var1, int var2, int var3);

    public int getMaxCachedTiles() {
        return 10;
    }

    public void recycleData(Object[] objectArray, int n10) {
    }

    public abstract int refreshData();
}

