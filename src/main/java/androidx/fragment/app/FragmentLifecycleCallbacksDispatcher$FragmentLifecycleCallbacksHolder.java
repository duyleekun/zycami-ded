/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;

public final class FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder {
    public final FragmentManager.FragmentLifecycleCallbacks mCallback;
    public final boolean mRecursive;

    public FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean bl2) {
        this.mCallback = fragmentLifecycleCallbacks;
        this.mRecursive = bl2;
    }
}

