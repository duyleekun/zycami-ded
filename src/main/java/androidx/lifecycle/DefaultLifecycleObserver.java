/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.FullLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public interface DefaultLifecycleObserver
extends FullLifecycleObserver {
    default public void onCreate(LifecycleOwner lifecycleOwner) {
    }

    default public void onDestroy(LifecycleOwner lifecycleOwner) {
    }

    default public void onPause(LifecycleOwner lifecycleOwner) {
    }

    default public void onResume(LifecycleOwner lifecycleOwner) {
    }

    default public void onStart(LifecycleOwner lifecycleOwner) {
    }

    default public void onStop(LifecycleOwner lifecycleOwner) {
    }
}

