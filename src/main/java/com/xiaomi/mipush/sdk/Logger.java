/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.u;
import com.xiaomi.push.ai;
import com.xiaomi.push.dl;
import com.xiaomi.push.dm;
import java.io.File;

public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        Logger.setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        Logger.setPushLog(context);
    }

    public static File getLogFile(String fileArray) {
        block17: {
            block16: {
                int n10;
                File file = new File((String)fileArray);
                boolean bl2 = file.exists();
                if (!bl2) break block16;
                bl2 = file.isDirectory();
                if (!bl2) break block16;
                try {
                    fileArray = file.listFiles();
                    n10 = 0;
                    file = null;
                }
                catch (NullPointerException nullPointerException) {
                    fileArray = "null pointer exception while retrieve file.";
                    b.d((String)fileArray);
                }
                while (true) {
                    block18: {
                        int n11 = fileArray.length;
                        if (n10 >= n11) break block17;
                        Object object = fileArray[n10];
                        n11 = (int)(((File)object).isFile() ? 1 : 0);
                        if (n11 == 0) break block18;
                        object = fileArray[n10];
                        object = ((File)object).getName();
                        String string2 = "lock";
                        n11 = (int)(((String)object).contains(string2) ? 1 : 0);
                        if (n11 != 0) break block18;
                        object = fileArray[n10];
                        object = ((File)object).getName();
                        string2 = "log";
                        n11 = (int)(((String)object).contains(string2) ? 1 : 0);
                        if (n11 == 0) break block18;
                        return fileArray[n10];
                    }
                    ++n10;
                }
            }
            return null;
        }
        return null;
    }

    public static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    private static boolean hasWritePermission(Context stringArray) {
        block9: {
            PackageManager packageManager = stringArray.getPackageManager();
            stringArray = stringArray.getPackageName();
            int n10 = 4096;
            stringArray = packageManager.getPackageInfo((String)stringArray, n10);
            stringArray = stringArray.requestedPermissions;
            if (stringArray == null) break block9;
            int n11 = stringArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                String string2;
                String string3;
                try {
                    string3 = stringArray[n10];
                    string2 = "android.permission.WRITE_EXTERNAL_STORAGE";
                }
                catch (Exception exception) {}
                boolean bl2 = string2.equals(string3);
                if (!bl2) continue;
                return true;
                break;
            }
        }
        return false;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        Logger.setPushLog(context);
    }

    public static void setPushLog(Context context) {
        boolean bl2;
        LoggerInterface loggerInterface = sUserLogger;
        boolean bl3 = false;
        LoggerInterface loggerInterface2 = null;
        boolean bl4 = true;
        float f10 = Float.MIN_VALUE;
        if (loggerInterface != null) {
            bl2 = bl4;
        } else {
            bl2 = false;
            loggerInterface = null;
        }
        boolean bl5 = sDisablePushLog;
        if (bl5) {
            bl2 = false;
            loggerInterface = null;
        } else {
            bl5 = Logger.hasWritePermission(context);
            if (bl5) {
                bl3 = bl2;
                bl2 = bl4;
            } else {
                bl3 = bl2;
                bl2 = false;
                loggerInterface = null;
            }
        }
        dm dm2 = null;
        if (bl3 == bl4) {
            loggerInterface2 = sUserLogger;
        } else {
            bl3 = false;
            loggerInterface2 = null;
        }
        if (bl2 == bl4) {
            dm2 = new dm(context);
        }
        dl dl2 = new dl(loggerInterface2, dm2);
        b.a(dl2);
    }

    public static void uploadLogFile(Context context, boolean bl2) {
        ai ai2 = ai.a(context);
        u u10 = new u(context, bl2);
        ai2.a(u10);
    }
}

