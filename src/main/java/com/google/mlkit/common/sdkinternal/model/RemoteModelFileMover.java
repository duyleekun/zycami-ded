/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

import java.io.File;

public interface RemoteModelFileMover {
    public File getModelFileDestination();

    public File moveAllFilesFromPrivateTempToPrivateDestination(File var1);
}

