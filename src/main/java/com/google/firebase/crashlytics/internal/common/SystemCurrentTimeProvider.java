/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;

public class SystemCurrentTimeProvider
implements CurrentTimeProvider {
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}

