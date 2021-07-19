/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.log.LogFileManager$DirectoryProvider;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

public final class CrashlyticsCore$LogFileDirectoryProvider
implements LogFileManager$DirectoryProvider {
    private static final String LOG_FILES_DIR = "log-files";
    private final FileStore rootFileStore;

    public CrashlyticsCore$LogFileDirectoryProvider(FileStore fileStore) {
        this.rootFileStore = fileStore;
    }

    public File getLogFileDir() {
        String string2;
        File file = this.rootFileStore.getFilesDir();
        File file2 = new File(file, string2 = LOG_FILES_DIR);
        boolean bl2 = file2.exists();
        if (!bl2) {
            file2.mkdirs();
        }
        return file2;
    }
}

