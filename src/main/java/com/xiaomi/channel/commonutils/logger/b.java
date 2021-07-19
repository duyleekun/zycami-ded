/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.channel.commonutils.logger;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class b {
    private static int a = 2;
    private static LoggerInterface a;
    private static final Integer a;
    private static final HashMap a;
    private static AtomicInteger a;
    private static final HashMap b;

    static {
        Serializable serializable = new Serializable();
        a = serializable;
        a = serializable = new Serializable();
        b = serializable = new Serializable();
        a = -1;
        serializable = new Serializable(1);
        a = serializable;
    }

    public static int a() {
        return a;
    }

    public static Integer a(String string2) {
        int n10 = a;
        int n11 = 1;
        if (n10 <= n11) {
            Integer n12 = a.incrementAndGet();
            Object object = a;
            Comparable<Long> comparable = System.currentTimeMillis();
            ((HashMap)object).put(n12, comparable);
            b.put(n12, string2);
            object = a;
            comparable = new Comparable<Long>();
            ((StringBuilder)comparable).append(string2);
            ((StringBuilder)comparable).append(" starts");
            string2 = ((StringBuilder)comparable).toString();
            object.log(string2);
            return n12;
        }
        return a;
    }

    public static void a(int n10) {
        int n11;
        if (n10 < 0 || n10 > (n11 = 5)) {
            n11 = 2;
            CharSequence charSequence = new StringBuilder();
            String string2 = "set log level as ";
            charSequence.append(string2);
            charSequence.append(n10);
            charSequence = charSequence.toString();
            com.xiaomi.channel.commonutils.logger.b.a(n11, (String)charSequence);
        }
        a = n10;
    }

    public static void a(int n10, String string2) {
        int n11 = a;
        if (n10 >= n11) {
            LoggerInterface loggerInterface = a;
            loggerInterface.log(string2);
        }
    }

    public static void a(int n10, String string2, Throwable throwable) {
        int n11 = a;
        if (n10 >= n11) {
            LoggerInterface loggerInterface = a;
            loggerInterface.log(string2, throwable);
        }
    }

    public static void a(int n10, Throwable throwable) {
        int n11 = a;
        if (n10 >= n11) {
            LoggerInterface loggerInterface = a;
            String string2 = "";
            loggerInterface.log(string2, throwable);
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        a = loggerInterface;
    }

    public static void a(Integer object) {
        int n10 = a;
        int n11 = 1;
        if (n10 <= n11) {
            Object object2 = a;
            n11 = (int)(((HashMap)object2).containsKey(object) ? 1 : 0);
            if (n11 == 0) {
                return;
            }
            long l10 = (Long)((HashMap)object2).remove(object);
            HashMap hashMap = b;
            object = (String)hashMap.remove(object);
            long l11 = System.currentTimeMillis() - l10;
            object2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(" ends in ");
            stringBuilder.append(l11);
            stringBuilder.append(" ms");
            object = stringBuilder.toString();
            object2.log((String)object);
        }
    }

    public static void a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Thread:");
        long l10 = Thread.currentThread().getId();
        stringBuilder.append(l10);
        stringBuilder.append("] ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        com.xiaomi.channel.commonutils.logger.b.a(2, string2);
    }

    public static void a(String string2, Throwable throwable) {
        com.xiaomi.channel.commonutils.logger.b.a(4, string2, throwable);
    }

    public static void a(Throwable throwable) {
        com.xiaomi.channel.commonutils.logger.b.a(4, throwable);
    }

    public static void b(String string2) {
        com.xiaomi.channel.commonutils.logger.b.a(0, string2);
    }

    public static void c(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Thread:");
        long l10 = Thread.currentThread().getId();
        stringBuilder.append(l10);
        stringBuilder.append("] ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        com.xiaomi.channel.commonutils.logger.b.a(1, string2);
    }

    public static void d(String string2) {
        com.xiaomi.channel.commonutils.logger.b.a(4, string2);
    }
}

