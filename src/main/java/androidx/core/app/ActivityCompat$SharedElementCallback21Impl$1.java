/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.SharedElementCallback$OnSharedElementsReadyListener
 */
package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat$SharedElementCallback21Impl;
import androidx.core.app.SharedElementCallback$OnSharedElementsReadyListener;

public class ActivityCompat$SharedElementCallback21Impl$1
implements SharedElementCallback$OnSharedElementsReadyListener {
    public final /* synthetic */ ActivityCompat$SharedElementCallback21Impl this$0;
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener val$listener;

    public ActivityCompat$SharedElementCallback21Impl$1(ActivityCompat$SharedElementCallback21Impl activityCompat$SharedElementCallback21Impl, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.this$0 = activityCompat$SharedElementCallback21Impl;
        this.val$listener = onSharedElementsReadyListener;
    }

    public void onSharedElementsReady() {
        this.val$listener.onSharedElementsReady();
    }
}

