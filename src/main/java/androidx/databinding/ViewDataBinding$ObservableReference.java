/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ViewDataBinding$WeakListener;
import androidx.lifecycle.LifecycleOwner;

public interface ViewDataBinding$ObservableReference {
    public void addListener(Object var1);

    public ViewDataBinding$WeakListener getListener();

    public void removeListener(Object var1);

    public void setLifecycleOwner(LifecycleOwner var1);
}

