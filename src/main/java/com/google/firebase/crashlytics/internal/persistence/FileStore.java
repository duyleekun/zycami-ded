/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;

public interface FileStore {
    public File getFilesDir();

    public String getFilesDirPath();
}

