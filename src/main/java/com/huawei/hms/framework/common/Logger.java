/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.huawei.hms.framework.common;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ExtLogger;
import com.huawei.hms.framework.common.Logger$ThrowableWrapper;
import com.huawei.hms.framework.common.StringUtils;
import java.util.IllegalFormatException;

public class Logger {
    private static final boolean DEBUG = false;
    private static final int MAX_STACK_DEEP_LENGTH = 20;
    private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    private static final String SPLIT = "|";
    private static final String TAG = "NetworkKit_Logger";
    private static final String TAG_NETWORKKIT_PRE = "NetworkKit_";
    private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    private static ExtLogger extLogger;
    private static boolean println = true;

    private static String complexAppTag(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG_NETWORK_SDK_PRE);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static String complexMsg(String string2, int n10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = Logger.getCallMethodInfo(n10);
            stringBuilder.append(string3);
            stringBuilder.append(SPLIT);
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        return Logger.getCallMethodInfo(n10);
    }

    private static String complexTag(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG_NETWORKKIT_PRE);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static void d(String string2, Object object) {
        Logger.println(3, string2, object);
    }

    public static void d(String string2, String string3, Object ... objectArray) {
        Logger.println(3, string2, string3, objectArray);
    }

    public static void e(String string2, Object object) {
        Logger.println(6, string2, object);
    }

    public static void e(String string2, String string3, Throwable throwable) {
        boolean bl2 = Logger.isAPPLoggable(6);
        int n10 = 5;
        if (bl2) {
            ExtLogger extLogger = Logger.extLogger;
            String string4 = Logger.complexAppTag(string2);
            String string5 = Logger.complexMsg(string3, n10);
            Throwable throwable2 = Logger.getNewThrowable(throwable);
            extLogger.e(string4, string5, throwable2);
        }
        if (bl2 = println) {
            string2 = Logger.complexTag(string2);
            string3 = Logger.complexMsg(string3, n10);
            throwable = Logger.getNewThrowable(throwable);
            Log.e((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void e(String string2, String string3, Object ... objectArray) {
        Logger.println(6, string2, string3, objectArray);
    }

    private static void extLogPrintln(int n10, String string2, String string3) {
        int n11 = 2;
        if (n10 != n11) {
            n11 = 3;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 5;
                    if (n10 != n11) {
                        n11 = 6;
                        if (n10 == n11) {
                            ExtLogger extLogger = Logger.extLogger;
                            extLogger.e(string2, string3);
                        }
                    } else {
                        ExtLogger extLogger = Logger.extLogger;
                        extLogger.w(string2, string3);
                    }
                } else {
                    ExtLogger extLogger = Logger.extLogger;
                    extLogger.i(string2, string3);
                }
            } else {
                ExtLogger extLogger = Logger.extLogger;
                extLogger.d(string2, string3);
            }
        } else {
            ExtLogger extLogger = Logger.extLogger;
            extLogger.v(string2, string3);
        }
    }

    private static String getCallMethodInfo(int n10) {
        Object object = Thread.currentThread().getStackTrace();
        int n11 = ((StackTraceElement[])object).length;
        if (n11 > n10) {
            StackTraceElement stackTraceElement = object[n10];
            object = new StringBuilder();
            String string2 = Thread.currentThread().getName();
            ((StringBuilder)object).append(string2);
            string2 = SPLIT;
            ((StringBuilder)object).append(string2);
            String string3 = stackTraceElement.getFileName();
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string3 = stackTraceElement.getClassName();
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string3 = stackTraceElement.getMethodName();
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            n10 = stackTraceElement.getLineNumber();
            ((StringBuilder)object).append(n10);
            return ((StringBuilder)object).toString();
        }
        return "";
    }

    private static Throwable getNewThrowable(Throwable throwable) {
        boolean bl2 = Logger.isLoggable(3);
        if (bl2) {
            return throwable;
        }
        bl2 = false;
        if (throwable == null) {
            return null;
        }
        Logger$ThrowableWrapper logger$ThrowableWrapper = new Logger$ThrowableWrapper(throwable, null);
        Logger$ThrowableWrapper logger$ThrowableWrapper2 = logger$ThrowableWrapper;
        for (throwable = throwable.getCause(); throwable != null; throwable = throwable.getCause()) {
            Logger$ThrowableWrapper logger$ThrowableWrapper3 = new Logger$ThrowableWrapper(throwable, null);
            Logger$ThrowableWrapper.access$100(logger$ThrowableWrapper2, logger$ThrowableWrapper3);
            logger$ThrowableWrapper2 = logger$ThrowableWrapper3;
        }
        return logger$ThrowableWrapper;
    }

    public static void i(String string2, Object object) {
        Logger.println(4, string2, object);
    }

    public static void i(String string2, String string3, Object ... objectArray) {
        Logger.println(4, string2, string3, objectArray);
    }

    public static boolean isAPPLoggable(int n10) {
        ExtLogger extLogger = Logger.extLogger;
        if (extLogger != null) {
            return Log.isLoggable((String)TAG_NETWORK_SDK_PRE, (int)n10);
        }
        return false;
    }

    public static boolean isLoggable(int n10) {
        return Log.isLoggable((String)TAG_NETWORKKIT_PRE, (int)n10);
    }

    private static int logPrintln(int n10, String string2, String string3) {
        boolean bl2 = Logger.isAPPLoggable(n10);
        int n11 = 7;
        if (bl2) {
            String string4 = Logger.complexAppTag(string2);
            String string5 = Logger.complexMsg(string3, n11);
            Logger.extLogPrintln(n10, string4, string5);
        }
        if (bl2 = println) {
            string2 = Logger.complexTag(string2);
            string3 = Logger.complexMsg(string3, n11);
            return Log.println((int)n10, (String)string2, (String)string3);
        }
        return 1;
    }

    public static void println(int n10, String string2, Object object) {
        int n11 = 3;
        if (n10 < n11) {
            return;
        }
        n11 = (int)(Logger.isLoggable(n10) ? 1 : 0);
        if (n11 != 0) {
            object = object == null ? "null" : object.toString();
            Logger.logPrintln(n10, string2, (String)object);
        }
    }

    public static void println(int n10, String charSequence, String string2, Object ... object) {
        block6: {
            int n11 = 3;
            if (n10 < n11) {
                return;
            }
            String string3 = TAG;
            if (string2 == null) {
                Log.w((String)string3, (String)"format is null, not log");
                return;
            }
            boolean bl2 = Logger.isLoggable(n10);
            if (!bl2) break block6;
            object = StringUtils.format(string2, object);
            try {
                Logger.logPrintln(n10, (String)charSequence, (String)object);
            }
            catch (IllegalFormatException illegalFormatException) {
                charSequence = new StringBuilder();
                object = "log format error";
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                Logger.w(string3, (String)charSequence, illegalFormatException);
            }
        }
    }

    public static void setExtLogger(ExtLogger object, boolean bl2) {
        extLogger = object;
        println = bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("logger = ");
        stringBuilder.append(object);
        stringBuilder.append(bl2);
        object = stringBuilder.toString();
        Logger.i(TAG, object);
    }

    public static void v(String string2, Object object) {
        Logger.println(2, string2, object);
    }

    public static void v(String string2, String string3, Object ... objectArray) {
        Logger.println(2, string2, string3, objectArray);
    }

    public static void w(String string2, Object object) {
        Logger.println(5, string2, object);
    }

    public static void w(String string2, String string3, Throwable throwable) {
        int n10 = 5;
        boolean bl2 = Logger.isAPPLoggable(n10);
        if (bl2) {
            ExtLogger extLogger = Logger.extLogger;
            String string4 = Logger.complexAppTag(string2);
            String string5 = Logger.complexMsg(string3, n10);
            Throwable throwable2 = Logger.getNewThrowable(throwable);
            extLogger.w(string4, string5, throwable2);
        }
        if (bl2 = println) {
            string2 = Logger.complexTag(string2);
            string3 = Logger.complexMsg(string3, n10);
            throwable = Logger.getNewThrowable(throwable);
            Log.w((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void w(String string2, String string3, Object ... objectArray) {
        Logger.println(5, string2, string3, objectArray);
    }
}

