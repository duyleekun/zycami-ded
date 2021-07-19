/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.FileUtil$a;
import com.huawei.hms.utils.HEX;
import com.huawei.hms.utils.SHA256;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240L;
    public static boolean a = false;
    public static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    public static boolean verifyHash(String string2, File object) {
        boolean bl2;
        object = SHA256.digest((File)object);
        boolean bl3 = true;
        if (object == null || !(bl2 = ((String)(object = HEX.encodeHexString((byte[])object, bl3))).equalsIgnoreCase(string2))) {
            bl3 = false;
        }
        return bl3;
    }

    public static void writeFile(File file, String string2, long l10) {
        ScheduledExecutorService scheduledExecutorService = b;
        FileUtil$a fileUtil$a = new FileUtil$a(file, l10, string2);
        scheduledExecutorService.execute(fileUtil$a);
    }

    public static void writeFileReport(Context object, File object2, File file, String string2, long l10, int n10) {
        boolean bl2;
        if (object2 != null && (bl2 = ((File)object2).isFile()) && (bl2 = ((File)object2).exists())) {
            bl2 = a;
            if (!bl2) {
                if (file != null && (bl2 = file.exists()) && !(bl2 = file.delete())) {
                    object = "FileUtil";
                    object2 = "file delete failed.";
                    HMSLog.e((String)object, (String)object2);
                }
                a = bl2 = true;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            object2 = "|";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(l10);
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            long l11 = 10240L;
            FileUtil.writeFile(file, (String)object, l11);
        }
    }
}

