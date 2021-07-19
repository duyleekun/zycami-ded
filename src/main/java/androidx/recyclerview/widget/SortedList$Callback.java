/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.Comparator;

public abstract class SortedList$Callback
implements Comparator,
ListUpdateCallback {
    public abstract boolean areContentsTheSame(Object var1, Object var2);

    public abstract boolean areItemsTheSame(Object var1, Object var2);

    public abstract int compare(Object var1, Object var2);

    public Object getChangePayload(Object object, Object object2) {
        return null;
    }

    public abstract void onChanged(int var1, int var2);

    public void onChanged(int n10, int n11, Object object) {
        this.onChanged(n10, n11);
    }
}

