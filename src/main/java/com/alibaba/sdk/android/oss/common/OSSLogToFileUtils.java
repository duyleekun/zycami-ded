/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 *  android.os.StatFs
 */
package com.alibaba.sdk.android.oss.common;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.common.LogThreadPoolManager;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.OSSLogToFileUtils$1;
import com.alibaba.sdk.android.oss.common.OSSLogToFileUtils$WriteCall;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OSSLogToFileUtils {
    private static final String LOG_DIR_NAME = "OSSLog";
    private static long LOG_MAX_SIZE;
    private static OSSLogToFileUtils instance;
    private static LogThreadPoolManager logService;
    private static Context sContext;
    private static File sLogFile;
    private static SimpleDateFormat sLogSDF;
    private boolean useSdCard = true;

    static {
        SimpleDateFormat simpleDateFormat;
        logService = LogThreadPoolManager.newInstance();
        sLogSDF = simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LOG_MAX_SIZE = 0x500000L;
    }

    private OSSLogToFileUtils() {
    }

    public static /* synthetic */ File access$000() {
        return sLogFile;
    }

    public static /* synthetic */ File access$002(File file) {
        sLogFile = file;
        return file;
    }

    public static /* synthetic */ OSSLogToFileUtils access$100() {
        return instance;
    }

    public static /* synthetic */ File access$200(OSSLogToFileUtils oSSLogToFileUtils) {
        return oSSLogToFileUtils.getLogFile();
    }

    public static /* synthetic */ long access$300() {
        return LOG_MAX_SIZE;
    }

    public static /* synthetic */ String access$400(OSSLogToFileUtils oSSLogToFileUtils, StackTraceElement[] stackTraceElementArray) {
        return oSSLogToFileUtils.getFunctionInfo(stackTraceElementArray);
    }

    public static /* synthetic */ SimpleDateFormat access$500() {
        return sLogSDF;
    }

    private String getFunctionInfo(StackTraceElement[] object) {
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("[");
            Object object2 = sLogSDF;
            Date date = new Date();
            object2 = ((DateFormat)object2).format(date);
            ((StringBuilder)object).append((String)object2);
            object2 = "]";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
        } else {
            object = null;
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static OSSLogToFileUtils getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = OSSLogToFileUtils.class;
        synchronized (object) {
            OSSLogToFileUtils oSSLogToFileUtils = instance;
            if (oSSLogToFileUtils != null) return instance;
            instance = oSSLogToFileUtils = new OSSLogToFileUtils();
            return instance;
        }
    }

    public static long getLocalLogFileSize() {
        return OSSLogToFileUtils.getLogFileSize(sLogFile);
    }

    private File getLogFile() {
        StringBuilder stringBuilder;
        String string2;
        Object object;
        Object object2 = this.useSdCard;
        Object object3 = LOG_DIR_NAME;
        boolean bl2 = true;
        StringBuilder stringBuilder2 = null;
        long l10 = 1024L;
        if (object2 != 0 && (object2 = ((String)(object = Environment.getExternalStorageState())).equals(string2 = "mounted")) != 0) {
            long l11;
            long l12 = this.readSDCardSpace();
            long l13 = l12 - (l11 = LOG_MAX_SIZE / l10);
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 <= 0) {
                bl2 = false;
                stringBuilder = null;
            }
            stringBuilder2 = new StringBuilder();
            String string3 = Environment.getExternalStorageDirectory().getPath();
            stringBuilder2.append(string3);
            string3 = File.separator;
            stringBuilder2.append(string3);
            stringBuilder2.append((String)object3);
            object3 = stringBuilder2.toString();
            object = new File((String)object3);
        } else {
            long l14;
            long l15 = this.readSystemSpace();
            long l16 = l15 - (l14 = LOG_MAX_SIZE / l10);
            object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 <= 0) {
                bl2 = false;
                stringBuilder = null;
            }
            stringBuilder2 = new StringBuilder();
            String string4 = sContext.getFilesDir().getPath();
            stringBuilder2.append(string4);
            string4 = File.separator;
            stringBuilder2.append(string4);
            stringBuilder2.append((String)object3);
            object3 = stringBuilder2.toString();
            object = new File((String)object3);
        }
        boolean bl3 = false;
        object3 = null;
        if (bl2) {
            bl3 = ((File)object).exists();
            if (!bl3) {
                ((File)object).mkdirs();
            }
            stringBuilder = new StringBuilder();
            object = ((File)object).getPath();
            stringBuilder.append((String)object);
            stringBuilder.append("/logs.csv");
            object = stringBuilder.toString();
            object3 = new File((String)object);
            object2 = ((File)object3).exists();
            if (object2 == 0) {
                this.createNewFile((File)object3);
            }
        }
        return object3;
    }

    public static long getLogFileSize(File file) {
        boolean bl2;
        long l10 = file != null && (bl2 = file.exists()) ? file.length() : 0L;
        return l10;
    }

    public static void init(Context object, ClientConfiguration object2) {
        boolean bl2;
        String string2 = "init ...";
        OSSLog.logDebug(string2, false);
        if (object2 != null) {
            long l10;
            LOG_MAX_SIZE = l10 = ((ClientConfiguration)object2).getMaxLogSize();
        }
        if ((object2 = sContext) != null && (object2 = instance) != null && (object2 = sLogFile) != null && (bl2 = ((File)object2).exists())) {
            object = "LogToFileUtils has been init ...";
            OSSLog.logDebug((String)object, false);
        } else {
            sContext = object.getApplicationContext();
            instance = OSSLogToFileUtils.getInstance();
            object = logService;
            object2 = new OSSLogToFileUtils$1();
            ((LogThreadPoolManager)object).addExecuteTask((Runnable)object2);
        }
    }

    private long readSDCardSpace() {
        long l10;
        String string2 = "mounted";
        Object object = Environment.getExternalStorageState();
        int n10 = string2.equals(object);
        if (n10 != 0) {
            object = Environment.getExternalStorageDirectory();
            object = ((File)object).getPath();
            string2 = new StatFs((String)object);
            long l11 = string2.getBlockSize();
            n10 = string2.getAvailableBlocks();
            l10 = (long)n10 * l11;
        } else {
            l10 = 0L;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sd\u5361\u5b58\u50a8\u7a7a\u95f4:");
        String string3 = String.valueOf(l10);
        stringBuilder.append(string3);
        stringBuilder.append("kb");
        OSSLog.logDebug(stringBuilder.toString(), false);
        return l10;
    }

    private long readSystemSpace() {
        Object object = Environment.getRootDirectory();
        object = ((File)object).getPath();
        StatFs statFs = new StatFs((String)object);
        long l10 = statFs.getBlockSize();
        long l11 = (long)statFs.getAvailableBlocks() * l10 / 1024L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\u5185\u90e8\u5b58\u50a8\u7a7a\u95f4:");
        String string2 = String.valueOf(l11);
        stringBuilder.append(string2);
        stringBuilder.append("kb");
        OSSLog.logDebug(stringBuilder.toString(), false);
        return l11;
    }

    public static void reset() {
        sContext = null;
        instance = null;
        sLogFile = null;
    }

    public void createNewFile(File file) {
        try {
            file.createNewFile();
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Create log file failure !!! ";
            stringBuilder.append(string2);
            String string3 = exception.toString();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            stringBuilder = null;
            OSSLog.logError(string3, false);
        }
    }

    public void deleteLogFile() {
        CharSequence charSequence = new StringBuilder();
        String string2 = sLogFile.getParent();
        charSequence.append(string2);
        string2 = "/logs.csv";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        File file = new File((String)charSequence);
        boolean bl2 = file.exists();
        if (bl2) {
            bl2 = false;
            charSequence = null;
            string2 = "delete Log File ... ";
            OSSLog.logDebug(string2, false);
            file.delete();
        }
    }

    public void deleteLogFileDir() {
        this.deleteLogFile();
        CharSequence charSequence = new StringBuilder();
        String string2 = Environment.getExternalStorageDirectory().getPath();
        charSequence.append(string2);
        string2 = File.separator;
        charSequence.append(string2);
        string2 = LOG_DIR_NAME;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        File file = new File((String)charSequence);
        boolean bl2 = file.exists();
        if (bl2) {
            bl2 = false;
            charSequence = null;
            string2 = "delete Log FileDir ... ";
            OSSLog.logDebug(string2, false);
            file.delete();
        }
    }

    public void resetLogFile() {
        boolean bl2 = false;
        CharSequence charSequence = null;
        OSSLog.logDebug("Reset Log File ... ", false);
        File file = sLogFile.getParentFile();
        boolean bl3 = file.exists();
        if (!bl3) {
            OSSLog.logDebug("Reset Log make File dir ... ", false);
            file = sLogFile.getParentFile();
            file.mkdir();
        }
        charSequence = new StringBuilder();
        String string2 = sLogFile.getParent();
        charSequence.append(string2);
        string2 = "/logs.csv";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        file = new File((String)charSequence);
        bl2 = file.exists();
        if (bl2) {
            file.delete();
        }
        this.createNewFile(file);
    }

    public void setUseSdCard(boolean bl2) {
        this.useSdCard = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(Object object) {
        synchronized (this) {
            boolean bl2 = OSSLog.isEnableLog();
            if (bl2) {
                Object object2 = sContext;
                if (object2 != null && (object2 = instance) != null && (object2 = sLogFile) != null) {
                    bl2 = ((File)object2).exists();
                    if (!bl2) {
                        this.resetLogFile();
                    }
                    object2 = new OSSLogToFileUtils$WriteCall(object);
                    object = logService;
                    ((LogThreadPoolManager)object).addExecuteTask((Runnable)object2);
                } else {
                    return;
                }
            }
            return;
        }
    }
}

