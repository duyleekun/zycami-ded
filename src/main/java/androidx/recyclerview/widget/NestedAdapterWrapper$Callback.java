/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.NestedAdapterWrapper;

public interface NestedAdapterWrapper$Callback {
    public void onChanged(NestedAdapterWrapper var1);

    public void onItemRangeChanged(NestedAdapterWrapper var1, int var2, int var3);

    public void onItemRangeChanged(NestedAdapterWrapper var1, int var2, int var3, Object var4);

    public void onItemRangeInserted(NestedAdapterWrapper var1, int var2, int var3);

    public void onItemRangeMoved(NestedAdapterWrapper var1, int var2, int var3);

    public void onItemRangeRemoved(NestedAdapterWrapper var1, int var2, int var3);

    public void onStateRestorationPolicyChanged(NestedAdapterWrapper var1);
}

