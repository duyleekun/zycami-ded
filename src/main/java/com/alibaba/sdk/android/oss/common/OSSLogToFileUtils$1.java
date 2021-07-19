/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.OSSLogToFileUtils;
import java.io.File;

public final class OSSLogToFileUtils$1
implements Runnable {
    public void run() {
        OSSLogToFileUtils.access$002(OSSLogToFileUtils.access$200(OSSLogToFileUtils.access$100()));
        Object object = OSSLogToFileUtils.access$000();
        if (object != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("LogFilePath is: ");
            String string2 = OSSLogToFileUtils.access$000().getPath();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            string2 = null;
            OSSLog.logInfo((String)object, false);
            object = OSSLogToFileUtils.access$000();
            long l10 = OSSLogToFileUtils.getLogFileSize((File)object);
            long l11 = OSSLogToFileUtils.access$300();
            long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (l12 < 0) {
                OSSLog.logInfo("init reset log file", false);
                object = OSSLogToFileUtils.access$100();
                ((OSSLogToFileUtils)object).resetLogFile();
            }
        }
    }
}

