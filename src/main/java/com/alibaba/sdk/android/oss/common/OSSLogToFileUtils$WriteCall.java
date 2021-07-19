/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common;

import com.alibaba.sdk.android.oss.common.OSSLogToFileUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Date;

public class OSSLogToFileUtils$WriteCall
implements Runnable {
    private Object mStr;

    public OSSLogToFileUtils$WriteCall(Object object) {
        this.mStr = object;
    }

    private PrintWriter printEx(PrintWriter printWriter) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("crash_time\uff1a");
        Object object = OSSLogToFileUtils.access$500();
        Date date = new Date();
        object = ((DateFormat)object).format(date);
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        printWriter.println((String)charSequence);
        ((Throwable)this.mStr).printStackTrace(printWriter);
        return printWriter;
    }

    public void run() {
        Object object = OSSLogToFileUtils.access$000();
        if (object != null) {
            OSSLogToFileUtils.getInstance();
            object = OSSLogToFileUtils.access$000();
            long l10 = OSSLogToFileUtils.getLogFileSize((File)object);
            long l11 = OSSLogToFileUtils.access$300();
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 > 0) {
                object = OSSLogToFileUtils.getInstance();
                ((OSSLogToFileUtils)object).resetLogFile();
            }
            Object object2 = OSSLogToFileUtils.access$000();
            boolean bl2 = true;
            Object object3 = new FileWriter((File)object2, bl2);
            object = new PrintWriter((Writer)object3, bl2);
            object3 = this.mStr;
            boolean bl3 = object3 instanceof Throwable;
            if (bl3) {
                this.printEx((PrintWriter)object);
            } else {
                object3 = new StringBuilder();
                object2 = OSSLogToFileUtils.getInstance();
                bl2 = false;
                object2 = OSSLogToFileUtils.access$400((OSSLogToFileUtils)object2, null);
                ((StringBuilder)object3).append((String)object2);
                object2 = " - ";
                ((StringBuilder)object3).append((String)object2);
                object2 = this.mStr;
                object2 = object2.toString();
                ((StringBuilder)object3).append((String)object2);
                object3 = ((StringBuilder)object3).toString();
                ((PrintWriter)object).println((String)object3);
            }
            object3 = "------>end of log";
            try {
                ((PrintWriter)object).println((String)object3);
                ((PrintWriter)object).println();
                ((PrintWriter)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

