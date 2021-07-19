/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import java.util.ArrayList;

public class RecyclerView$RecycledViewPool$ScrapData {
    public long mBindRunningAverageNs;
    public long mCreateRunningAverageNs;
    public int mMaxScrap;
    public final ArrayList mScrapHeap;

    public RecyclerView$RecycledViewPool$ScrapData() {
        long l10;
        ArrayList arrayList;
        this.mScrapHeap = arrayList = new ArrayList();
        this.mMaxScrap = 5;
        this.mCreateRunningAverageNs = l10 = 0L;
        this.mBindRunningAverageNs = l10;
    }
}

