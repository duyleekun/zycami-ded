/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 */
package com.mob.tools.utils;

import android.app.Activity;
import android.os.Bundle;

public interface ActivityTracker$Tracker {
    public void onCreated(Activity var1, Bundle var2);

    public void onDestroyed(Activity var1);

    public void onPaused(Activity var1);

    public void onResumed(Activity var1);

    public void onSaveInstanceState(Activity var1, Bundle var2);

    public void onStarted(Activity var1);

    public void onStopped(Activity var1);
}

