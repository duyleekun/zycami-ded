/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public abstract class DiffUtil$Callback {
    public abstract boolean areContentsTheSame(int var1, int var2);

    public abstract boolean areItemsTheSame(int var1, int var2);

    public Object getChangePayload(int n10, int n11) {
        return null;
    }

    public abstract int getNewListSize();

    public abstract int getOldListSize();
}

