/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;

public class TXLog {
    public static void d(String string2, String string3) {
        TXLog.wrietLogMessage(1, string2, string3);
    }

    public static void e(String string2, String string3) {
        TXLog.wrietLogMessage(4, string2, string3);
    }

    public static void i(String string2, String string3) {
        TXLog.wrietLogMessage(2, string2, string3);
    }

    public static void w(String string2, String string3) {
        TXLog.wrietLogMessage(3, string2, string3);
    }

    private static void wrietLogMessage(int n10, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("thread ID:");
        long l10 = Thread.currentThread().getId();
        stringBuilder.append(l10);
        stringBuilder.append("|line:");
        stringBuilder.append(-1);
        stringBuilder.append("|");
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        TXCLog.log(n10, string2, string3);
    }
}

