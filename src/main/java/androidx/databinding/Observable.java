/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.Observable$OnPropertyChangedCallback;

public interface Observable {
    public void addOnPropertyChangedCallback(Observable$OnPropertyChangedCallback var1);

    public void removeOnPropertyChangedCallback(Observable$OnPropertyChangedCallback var1);
}

