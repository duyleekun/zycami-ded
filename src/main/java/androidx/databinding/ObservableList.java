/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ObservableList$OnListChangedCallback;
import java.util.List;

public interface ObservableList
extends List {
    public void addOnListChangedCallback(ObservableList$OnListChangedCallback var1);

    public void removeOnListChangedCallback(ObservableList$OnListChangedCallback var1);
}

