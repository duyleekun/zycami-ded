/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public abstract class DiffUtil$ItemCallback {
    public abstract boolean areContentsTheSame(Object var1, Object var2);

    public abstract boolean areItemsTheSame(Object var1, Object var2);

    public Object getChangePayload(Object object, Object object2) {
        return null;
    }
}

