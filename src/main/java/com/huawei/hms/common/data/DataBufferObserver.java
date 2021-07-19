/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.data;

public interface DataBufferObserver {
    public void onDataChanged();

    public void onDataRangeChanged(int var1, int var2);

    public void onDataRangeInserted(int var1, int var2);

    public void onDataRangeMoved(int var1, int var2, int var3);

    public void onDataRangeRemoved(int var1, int var2);
}

