/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.MissingNativeComponent$MissingNativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;

public final class MissingNativeComponent
implements CrashlyticsNativeComponent {
    private static final NativeSessionFileProvider MISSING_NATIVE_SESSION_FILE_PROVIDER;

    static {
        MissingNativeComponent$MissingNativeSessionFileProvider missingNativeComponent$MissingNativeSessionFileProvider = new MissingNativeComponent$MissingNativeSessionFileProvider(null);
        MISSING_NATIVE_SESSION_FILE_PROVIDER = missingNativeComponent$MissingNativeSessionFileProvider;
    }

    public boolean finalizeSession(String string2) {
        return true;
    }

    public NativeSessionFileProvider getSessionFileProvider(String string2) {
        return MISSING_NATIVE_SESSION_FILE_PROVIDER;
    }

    public boolean hasCrashDataForSession(String string2) {
        return false;
    }

    public boolean openSession(String string2) {
        return true;
    }

    public void writeBeginSession(String string2, String string3, long l10) {
    }

    public void writeSessionApp(String string2, String string3, String string4, String string5, String string6, int n10, String string7) {
    }

    public void writeSessionDevice(String string2, int n10, String string3, int n11, long l10, long l11, boolean bl2, int n12, String string4, String string5) {
    }

    public void writeSessionOs(String string2, String string3, String string4, boolean bl2) {
    }
}

