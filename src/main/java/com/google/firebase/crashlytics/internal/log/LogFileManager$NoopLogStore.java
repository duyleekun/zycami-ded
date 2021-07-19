/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.log;

import com.google.firebase.crashlytics.internal.log.FileLogStore;
import com.google.firebase.crashlytics.internal.log.LogFileManager$1;

public final class LogFileManager$NoopLogStore
implements FileLogStore {
    private LogFileManager$NoopLogStore() {
    }

    public /* synthetic */ LogFileManager$NoopLogStore(LogFileManager$1 logFileManager$1) {
        this();
    }

    public void closeLogFile() {
    }

    public void deleteLogFile() {
    }

    public byte[] getLogAsBytes() {
        return null;
    }

    public String getLogAsString() {
        return null;
    }

    public void writeToLog(long l10, String string2) {
    }
}

