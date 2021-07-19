/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Process
 */
package com.mob.tools.log;

import android.content.Context;
import android.os.Process;
import com.mob.tools.log.LogCollector;
import com.mob.tools.log.MobUncaughtExceptionHandler;
import com.mob.tools.log.NLog$1;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.util.HashMap;

public abstract class NLog {
    private static LogCollector defaultCollector;
    private static boolean disable;
    private static HashMap loggers;
    private LogCollector collector;

    static {
        HashMap hashMap;
        loggers = hashMap = new HashMap();
        MobUncaughtExceptionHandler.register();
    }

    public static void disable() {
        disable = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static NLog getInstance(String string2) {
        HashMap hashMap = loggers;
        synchronized (hashMap) {
            Object object = loggers;
            object = ((HashMap)object).get(string2);
            object = (NLog)object;
            if (object == null) {
                object = new NLog$1(string2);
                HashMap hashMap2 = loggers;
                hashMap2.put(string2, object);
            }
            return object;
        }
    }

    public static NLog getInstanceForSDK(String string2, boolean bl2) {
        return NLog.getInstance(string2);
    }

    private String getStackTraceString(Throwable object) {
        Object object2;
        Object object3 = "";
        if (object == null) {
            return object3;
        }
        for (object2 = object; object2 != null; object2 = ((Throwable)object2).getCause()) {
            boolean bl2 = object2 instanceof UnknownHostException;
            if (bl2) {
                return object3;
            }
            continue;
        }
        try {
            object3 = new StringWriter();
        }
        catch (Throwable throwable) {
            boolean bl3 = throwable instanceof OutOfMemoryError;
            if (bl3) {
                return "getStackTraceString oom";
            }
            return throwable.getMessage();
        }
        object2 = new PrintWriter((Writer)object3);
        ((Throwable)object).printStackTrace((PrintWriter)object2);
        ((PrintWriter)object2).flush();
        object = ((StringWriter)object3).toString();
        ((StringWriter)object3).close();
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int println(int n10, int n11, String object) {
        Object object2;
        Object object3;
        try {
            object3 = new StringBuilder();
            int n12 = Process.myPid();
            ((StringBuilder)object3).append(n12);
            object2 = "-";
            ((StringBuilder)object3).append((String)object2);
            n12 = Process.myTid();
            ((StringBuilder)object3).append(n12);
            object2 = "(";
            ((StringBuilder)object3).append((String)object2);
            object2 = Thread.currentThread();
            object2 = ((Thread)object2).getName();
            ((StringBuilder)object3).append((String)object2);
            object2 = ") ";
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
        }
        catch (Throwable throwable) {}
        Object object4 = object;
        object2 = this.getSDKTag();
        object = this.collector;
        if (object == null) {
            object = defaultCollector;
        }
        object3 = object;
        if (object != null) {
            object.log((String)object2, n10, n11, null, (String)object4);
        }
        return 0;
    }

    public static void setCollector(String string2, LogCollector logCollector) {
        NLog.getInstance(string2).setCollector(logCollector);
    }

    public static void setContext(Context context) {
    }

    public static LogCollector setDefaultCollector(LogCollector logCollector) {
        defaultCollector = logCollector;
        return logCollector;
    }

    public final int crash(Throwable object) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object = this.getStackTraceString((Throwable)object);
        return this.println(6, 1, (String)object);
    }

    public final int d(Object object, Object ... objectArray) {
        int n10 = disable;
        if (n10 != 0) {
            return 0;
        }
        object = object.toString();
        n10 = objectArray.length;
        if (n10 > 0) {
            object = String.format((String)object, objectArray);
        }
        return this.println(3, 0, (String)object);
    }

    public final int d(Throwable object) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object = this.getStackTraceString((Throwable)object);
        return this.println(3, 0, (String)object);
    }

    public final int d(Throwable object, Object object2, Object ... objectArray) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object2 = object2.toString();
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = objectArray.length;
        if (n10 > 0) {
            object2 = String.format((String)object2, objectArray);
        }
        stringBuilder.append((String)object2);
        stringBuilder.append('\n');
        object = this.getStackTraceString((Throwable)object);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        return this.println(3, 0, (String)object);
    }

    public final int e(Object object, Object ... objectArray) {
        int n10 = disable;
        if (n10 != 0) {
            return 0;
        }
        object = object.toString();
        n10 = objectArray.length;
        if (n10 > 0) {
            object = String.format((String)object, objectArray);
        }
        return this.println(6, 0, (String)object);
    }

    public final int e(Throwable object) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object = this.getStackTraceString((Throwable)object);
        return this.println(6, 0, (String)object);
    }

    public final int e(Throwable object, Object object2, Object ... objectArray) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object2 = object2.toString();
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = objectArray.length;
        if (n10 > 0) {
            object2 = String.format((String)object2, objectArray);
        }
        stringBuilder.append((String)object2);
        stringBuilder.append('\n');
        object = this.getStackTraceString((Throwable)object);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        return this.println(6, 0, (String)object);
    }

    public abstract String getSDKTag();

    public final int i(Object object, Object ... objectArray) {
        int n10 = disable;
        if (n10 != 0) {
            return 0;
        }
        object = object.toString();
        n10 = objectArray.length;
        if (n10 > 0) {
            object = String.format((String)object, objectArray);
        }
        return this.println(4, 0, (String)object);
    }

    public final int i(Throwable object) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object = this.getStackTraceString((Throwable)object);
        return this.println(4, 0, (String)object);
    }

    public final int i(Throwable object, Object object2, Object ... objectArray) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object2 = object2.toString();
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = objectArray.length;
        if (n10 > 0) {
            object2 = String.format((String)object2, objectArray);
        }
        stringBuilder.append((String)object2);
        stringBuilder.append('\n');
        object = this.getStackTraceString((Throwable)object);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        return this.println(4, 0, (String)object);
    }

    public final int sdkErr(Object object, Object ... objectArray) {
        int n10 = disable;
        if (n10 != 0) {
            return 0;
        }
        object = object.toString();
        n10 = objectArray.length;
        if (n10 > 0) {
            object = String.format((String)object, objectArray);
        }
        return this.println(6, 3, (String)object);
    }

    public final int sdkErr(Throwable object) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object = this.getStackTraceString((Throwable)object);
        return this.println(6, 3, (String)object);
    }

    public final int sdkErr(Throwable object, Object object2, Object ... objectArray) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object2 = object2.toString();
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = objectArray.length;
        if (n10 > 0) {
            object2 = String.format((String)object2, objectArray);
        }
        stringBuilder.append((String)object2);
        stringBuilder.append('\n');
        object = this.getStackTraceString((Throwable)object);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        return this.println(6, 3, (String)object);
    }

    public NLog setCollector(LogCollector logCollector) {
        this.collector = logCollector;
        return this;
    }

    public final int v(Object object, Object ... objectArray) {
        int n10 = disable;
        if (n10 != 0) {
            return 0;
        }
        object = object.toString();
        n10 = objectArray.length;
        if (n10 > 0) {
            object = String.format((String)object, objectArray);
        }
        return this.println(2, 0, (String)object);
    }

    public final int v(Throwable object) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object = this.getStackTraceString((Throwable)object);
        return this.println(2, 0, (String)object);
    }

    public final int v(Throwable object, Object object2, Object ... objectArray) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object2 = object2.toString();
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = objectArray.length;
        if (n10 > 0) {
            object2 = String.format((String)object2, objectArray);
        }
        stringBuilder.append((String)object2);
        stringBuilder.append('\n');
        object = this.getStackTraceString((Throwable)object);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        return this.println(2, 0, (String)object);
    }

    public final int w(Object object, Object ... objectArray) {
        int n10 = disable;
        if (n10 != 0) {
            return 0;
        }
        object = object.toString();
        n10 = objectArray.length;
        if (n10 > 0) {
            object = String.format((String)object, objectArray);
        }
        return this.println(5, 0, (String)object);
    }

    public final int w(String string2) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        return this.println(5, 0, string2);
    }

    public final int w(Throwable object) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object = this.getStackTraceString((Throwable)object);
        return this.println(5, 0, (String)object);
    }

    public final int w(Throwable object, Object object2, Object ... objectArray) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object2 = object2.toString();
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = objectArray.length;
        if (n10 > 0) {
            object2 = String.format((String)object2, objectArray);
        }
        stringBuilder.append((String)object2);
        stringBuilder.append('\n');
        object = this.getStackTraceString((Throwable)object);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        return this.println(5, 0, (String)object);
    }

    public int wtf(Throwable object) {
        boolean bl2 = disable;
        if (bl2) {
            return 0;
        }
        object = this.getStackTraceString((Throwable)object);
        return this.println(6, 0, (String)object);
    }
}

