/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelProvider$OnRequeryFactory;

public abstract class ViewModelProvider$KeyedFactory
extends ViewModelProvider$OnRequeryFactory
implements ViewModelProvider$Factory {
    public ViewModel create(Class serializable) {
        serializable = new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        throw serializable;
    }

    public abstract ViewModel create(String var1, Class var2);
}

