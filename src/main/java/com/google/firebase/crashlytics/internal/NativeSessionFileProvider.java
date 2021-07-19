/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal;

import java.io.File;

public interface NativeSessionFileProvider {
    public File getAppFile();

    public File getBinaryImagesFile();

    public File getDeviceFile();

    public File getMetadataFile();

    public File getMinidumpFile();

    public File getOsFile();

    public File getSessionFile();
}

