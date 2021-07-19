/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.MissingNativeComponent$1;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import java.io.File;

public final class MissingNativeComponent$MissingNativeSessionFileProvider
implements NativeSessionFileProvider {
    private MissingNativeComponent$MissingNativeSessionFileProvider() {
    }

    public /* synthetic */ MissingNativeComponent$MissingNativeSessionFileProvider(MissingNativeComponent$1 missingNativeComponent$1) {
        this();
    }

    public File getAppFile() {
        return null;
    }

    public File getBinaryImagesFile() {
        return null;
    }

    public File getDeviceFile() {
        return null;
    }

    public File getMetadataFile() {
        return null;
    }

    public File getMinidumpFile() {
        return null;
    }

    public File getOsFile() {
        return null;
    }

    public File getSessionFile() {
        return null;
    }
}

