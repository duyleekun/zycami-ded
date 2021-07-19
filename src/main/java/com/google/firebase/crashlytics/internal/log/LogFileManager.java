/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.crashlytics.internal.log;

import android.content.Context;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.log.FileLogStore;
import com.google.firebase.crashlytics.internal.log.LogFileManager$DirectoryProvider;
import com.google.firebase.crashlytics.internal.log.LogFileManager$NoopLogStore;
import com.google.firebase.crashlytics.internal.log.QueueFileLogStore;
import java.io.File;
import java.util.Set;

public class LogFileManager {
    private static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
    private static final String LOGFILE_EXT = ".temp";
    private static final String LOGFILE_PREFIX = "crashlytics-userlog-";
    public static final int MAX_LOG_SIZE = 65536;
    private static final LogFileManager$NoopLogStore NOOP_LOG_STORE;
    private final Context context;
    private FileLogStore currentLog;
    private final LogFileManager$DirectoryProvider directoryProvider;

    static {
        LogFileManager$NoopLogStore logFileManager$NoopLogStore;
        NOOP_LOG_STORE = logFileManager$NoopLogStore = new LogFileManager$NoopLogStore(null);
    }

    public LogFileManager(Context context, LogFileManager$DirectoryProvider logFileManager$DirectoryProvider) {
        this(context, logFileManager$DirectoryProvider, null);
    }

    public LogFileManager(Context object, LogFileManager$DirectoryProvider logFileManager$DirectoryProvider, String string2) {
        this.context = object;
        this.directoryProvider = logFileManager$DirectoryProvider;
        object = NOOP_LOG_STORE;
        this.currentLog = object;
        this.setCurrentSession(string2);
    }

    private String getSessionIdForFile(File object) {
        int n10;
        String string2;
        int n11 = ((String)(object = ((File)object).getName())).lastIndexOf(string2 = LOGFILE_EXT);
        if (n11 == (n10 = -1)) {
            return object;
        }
        return ((String)object).substring(20, n11);
    }

    private File getWorkingFileForSession(String string2) {
        Comparable<StringBuilder> comparable = new StringBuilder();
        comparable.append(LOGFILE_PREFIX);
        comparable.append(string2);
        comparable.append(LOGFILE_EXT);
        string2 = comparable.toString();
        File file = this.directoryProvider.getLogFileDir();
        comparable = new File(file, string2);
        return comparable;
    }

    public void clearLog() {
        this.currentLog.deleteLogFile();
    }

    public void discardOldLogFiles(Set set) {
        File[] fileArray = this.directoryProvider.getLogFileDir().listFiles();
        if (fileArray != null) {
            for (File file : fileArray) {
                String string2 = this.getSessionIdForFile(file);
                boolean bl2 = set.contains(string2);
                if (bl2) continue;
                file.delete();
            }
        }
    }

    public byte[] getBytesForLog() {
        return this.currentLog.getLogAsBytes();
    }

    public String getLogString() {
        return this.currentLog.getLogAsString();
    }

    public final void setCurrentSession(String object) {
        this.currentLog.closeLogFile();
        LogFileManager$NoopLogStore logFileManager$NoopLogStore = NOOP_LOG_STORE;
        this.currentLog = logFileManager$NoopLogStore;
        if (object == null) {
            return;
        }
        logFileManager$NoopLogStore = this.context;
        String string2 = COLLECT_CUSTOM_LOGS;
        boolean bl2 = true;
        boolean bl3 = CommonUtils.getBooleanResourceValue((Context)logFileManager$NoopLogStore, string2, bl2);
        if (!bl3) {
            Logger.getLogger().d("Preferences requested no custom logs. Aborting log file creation.");
            return;
        }
        object = this.getWorkingFileForSession((String)object);
        this.setLogFile((File)object, 65536);
    }

    public void setLogFile(File file, int n10) {
        QueueFileLogStore queueFileLogStore = new QueueFileLogStore(file, n10);
        this.currentLog = queueFileLogStore;
    }

    public void writeToLog(long l10, String string2) {
        this.currentLog.writeToLog(l10, string2);
    }
}

