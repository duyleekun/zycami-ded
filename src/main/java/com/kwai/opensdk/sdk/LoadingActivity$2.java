/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.kwai.opensdk.sdk;

import android.app.Activity;
import java.lang.ref.WeakReference;

public final class LoadingActivity$2
implements Runnable {
    public final /* synthetic */ WeakReference val$ref;

    public LoadingActivity$2(WeakReference weakReference) {
        this.val$ref = weakReference;
    }

    public void run() {
        Object object = this.val$ref.get();
        if (object != null) {
            object = (Activity)this.val$ref.get();
            object.finish();
        }
    }
}

