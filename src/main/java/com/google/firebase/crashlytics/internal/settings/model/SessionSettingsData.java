/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.settings.model;

public class SessionSettingsData {
    public final int maxCompleteSessionsCount;
    public final int maxCustomExceptionEvents;

    public SessionSettingsData(int n10, int n11) {
        this.maxCustomExceptionEvents = n10;
        this.maxCompleteSessionsCount = n11;
    }
}

