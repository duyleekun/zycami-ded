/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public interface FullLifecycleObserver
extends LifecycleObserver {
    public void onCreate(LifecycleOwner var1);

    public void onDestroy(LifecycleOwner var1);

    public void onPause(LifecycleOwner var1);

    public void onResume(LifecycleOwner var1);

    public void onStart(LifecycleOwner var1);

    public void onStop(LifecycleOwner var1);
}

