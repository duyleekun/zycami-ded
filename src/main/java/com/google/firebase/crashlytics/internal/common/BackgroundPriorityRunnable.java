/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package com.google.firebase.crashlytics.internal.common;

import android.os.Process;

public abstract class BackgroundPriorityRunnable
implements Runnable {
    public abstract void onRun();

    public final void run() {
        Process.setThreadPriority((int)10);
        this.onRun();
    }
}

