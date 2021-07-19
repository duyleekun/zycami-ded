/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper$UpdateOp;

public interface OpReorderer$Callback {
    public AdapterHelper$UpdateOp obtainUpdateOp(int var1, int var2, int var3, Object var4);

    public void recycleUpdateOp(AdapterHelper$UpdateOp var1);
}

