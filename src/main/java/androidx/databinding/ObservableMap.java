/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ObservableMap$OnMapChangedCallback;
import java.util.Map;

public interface ObservableMap
extends Map {
    public void addOnMapChangedCallback(ObservableMap$OnMapChangedCallback var1);

    public void removeOnMapChangedCallback(ObservableMap$OnMapChangedCallback var1);
}

