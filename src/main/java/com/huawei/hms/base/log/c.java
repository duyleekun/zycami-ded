/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.util.Log
 */
package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class c {
    public final StringBuilder a;
    public String b;
    public String c;
    public int d;
    public long e;
    public long f;
    public String g;
    public int h;
    public int i;
    public int j;

    public c(int n10, String string2, int n11, String string3) {
        long l10;
        StringBuilder stringBuilder;
        this.a = stringBuilder = new StringBuilder();
        this.b = null;
        this.c = "HMS";
        stringBuilder = null;
        this.d = 0;
        this.e = l10 = 0L;
        this.f = l10;
        this.j = 0;
        this.j = n10;
        this.b = string2;
        this.d = n11;
        if (string3 != null) {
            this.c = string3;
        }
        this.b();
    }

    public static String a(int n10) {
        int n11 = 3;
        if (n10 != n11) {
            n11 = 4;
            if (n10 != n11) {
                n11 = 5;
                if (n10 != n11) {
                    n11 = 6;
                    if (n10 != n11) {
                        return String.valueOf(n10);
                    }
                    return "E";
                }
                return "W";
            }
            return "I";
        }
        return "D";
    }

    public c a(Object object) {
        this.a.append(object);
        return this;
    }

    public c a(Throwable object) {
        Object object2 = Character.valueOf('\n');
        object2 = this.a(object2);
        object = Log.getStackTraceString((Throwable)object);
        ((c)object2).a(object);
        return this;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        this.a(stringBuilder);
        return stringBuilder.toString();
    }

    public final StringBuilder a(StringBuilder stringBuilder) {
        stringBuilder.append(' ');
        String string2 = this.a.toString();
        stringBuilder.append(string2);
        return stringBuilder;
    }

    public final c b() {
        int n10;
        int n11;
        long l10;
        long l11;
        this.e = l11 = System.currentTimeMillis();
        Object object = Thread.currentThread();
        this.f = l10 = ((Thread)object).getId();
        this.h = n11 = Process.myPid();
        n11 = ((StackTraceElement[])(object = ((Thread)object).getStackTrace())).length;
        if (n11 > (n10 = this.j)) {
            int n12;
            String string2;
            object = object[n10];
            this.g = string2 = ((StackTraceElement)object).getFileName();
            this.i = n12 = ((StackTraceElement)object).getLineNumber();
        }
        return this;
    }

    public final StringBuilder b(StringBuilder stringBuilder) {
        Object object = Locale.getDefault();
        Object object2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", (Locale)object);
        stringBuilder.append('[');
        object = this.e;
        object2 = ((Format)object2).format(object);
        stringBuilder.append((String)object2);
        object2 = com.huawei.hms.base.log.c.a(this.d);
        char c10 = ' ';
        stringBuilder.append(c10);
        stringBuilder.append((String)object2);
        int n10 = 47;
        stringBuilder.append((char)n10);
        String string2 = this.c;
        stringBuilder.append(string2);
        stringBuilder.append((char)n10);
        object2 = this.b;
        stringBuilder.append((String)object2);
        stringBuilder.append(c10);
        n10 = this.h;
        stringBuilder.append(n10);
        n10 = 58;
        stringBuilder.append((char)n10);
        long l10 = this.f;
        stringBuilder.append(l10);
        stringBuilder.append(c10);
        object = this.g;
        stringBuilder.append((String)object);
        stringBuilder.append((char)n10);
        n10 = this.i;
        stringBuilder.append(n10);
        stringBuilder.append(']');
        return stringBuilder;
    }

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        this.b(stringBuilder);
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.b(stringBuilder);
        this.a(stringBuilder);
        return stringBuilder.toString();
    }
}

