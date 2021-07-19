/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public interface LifecycleFragment {
    public void addCallback(String var1, LifecycleCallback var2);

    public LifecycleCallback getCallbackOrNull(String var1, Class var2);

    public Activity getLifecycleActivity();

    public boolean isCreated();

    public boolean isStarted();

    public void startActivityForResult(Intent var1, int var2);
}

