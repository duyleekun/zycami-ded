/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.EmptyActivityLifecycleCallbacks;
import androidx.lifecycle.ReportFragment;

public class LifecycleDispatcher$DispatcherActivityCallback
extends EmptyActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        ReportFragment.injectIfNeededIn(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStopped(Activity activity) {
    }
}

