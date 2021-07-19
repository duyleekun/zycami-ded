/*
 * Decompiled with CFR 0.151.
 */
package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

public interface SavedStateRegistryOwner
extends LifecycleOwner {
    public SavedStateRegistry getSavedStateRegistry();
}

