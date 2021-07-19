/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

public interface LifecycleRegistryOwner
extends LifecycleOwner {
    public LifecycleRegistry getLifecycle();
}

