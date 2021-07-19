/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package androidx.core.app;

import android.app.Activity;
import androidx.core.app.ActivityRecreator;

public class ActivityCompat$2
implements Runnable {
    public final /* synthetic */ Activity val$activity;

    public ActivityCompat$2(Activity activity) {
        this.val$activity = activity;
    }

    public void run() {
        Activity activity = this.val$activity;
        boolean bl2 = activity.isFinishing();
        if (!bl2 && !(bl2 = ActivityRecreator.recreate(activity = this.val$activity))) {
            activity = this.val$activity;
            activity.recreate();
        }
    }
}

