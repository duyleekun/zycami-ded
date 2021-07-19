/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ObservableList;

public abstract class ObservableList$OnListChangedCallback {
    public abstract void onChanged(ObservableList var1);

    public abstract void onItemRangeChanged(ObservableList var1, int var2, int var3);

    public abstract void onItemRangeInserted(ObservableList var1, int var2, int var3);

    public abstract void onItemRangeMoved(ObservableList var1, int var2, int var3, int var4);

    public abstract void onItemRangeRemoved(ObservableList var1, int var2, int var3);
}

