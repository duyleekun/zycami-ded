/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.tencent.liteav.basic.log;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog$a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.g;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class TXCLog {
    public static final int LOG_ASYNC = 0;
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 4;
    public static final int LOG_FATAL = 5;
    public static final int LOG_INFO = 2;
    public static final int LOG_NONE = 6;
    public static final int LOG_SYNC = 1;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARNING = 3;
    private static boolean mEnableCallback = false;
    private static boolean mEnableCompress = true;
    private static boolean mEnableConsole = true;
    private static boolean mHasInit = false;
    private static TXCLog$a mListener;
    private static String mLogCacheDir = "";
    public static String mLogDir = "";
    private static int mLogLevel;
    private static final Object mLogLock;

    static {
        Object object;
        mLogLock = object = new Object();
    }

    public static void d(String string2, String string3) {
        TXCLog.log(1, string2, string3);
    }

    public static void d(String string2, String string3, Object ... objectArray) {
        string3 = String.format(string3, objectArray);
        TXCLog.log(1, string2, string3);
    }

    public static void e(String string2, String string3) {
        TXCLog.log(4, string2, string3);
    }

    public static void e(String string2, String string3, Throwable serializable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ((Throwable)serializable).printStackTrace(printWriter);
        for (serializable = ((Throwable)serializable).getCause(); serializable != null; serializable = ((Throwable)serializable).getCause()) {
            ((Throwable)serializable).printStackTrace(printWriter);
        }
        printWriter.close();
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string3);
        ((StringBuilder)serializable).append("\n");
        string3 = ((Object)stringWriter).toString();
        ((StringBuilder)serializable).append(string3);
        string3 = ((StringBuilder)serializable).toString();
        TXCLog.e(string2, string3);
    }

    public static void e(String string2, String string3, Object ... objectArray) {
        string3 = String.format(string3, objectArray);
        TXCLog.log(4, string2, string3);
    }

    public static void i(String string2, String string3) {
        TXCLog.log(2, string2, string3);
    }

    public static void i(String string2, String string3, Object ... objectArray) {
        string3 = String.format(string3, objectArray);
        TXCLog.log(2, string2, string3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean init() {
        boolean bl2 = mHasInit;
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        Object object = mLogLock;
        synchronized (object) {
            boolean bl4 = mHasInit;
            if (bl4) {
                return bl3;
            }
            bl4 = g.f();
            Object object2 = TXCCommonUtil.getAppContext();
            if (bl4 && object2 != null) {
                CharSequence charSequence;
                Object object3 = mLogDir;
                bl4 = TextUtils.isEmpty((CharSequence)object3);
                if (bl4) {
                    bl4 = false;
                    object3 = null;
                    object3 = object2.getExternalFilesDir(null);
                    if (object3 != null) {
                        charSequence = new StringBuilder();
                        object3 = ((File)object3).getAbsolutePath();
                        charSequence.append((String)object3);
                        object3 = "/log/tencent/liteav";
                        charSequence.append((String)object3);
                        mLogDir = object3 = charSequence.toString();
                    }
                }
                object3 = new StringBuilder();
                object2 = object2.getFilesDir();
                object2 = ((File)object2).getAbsolutePath();
                ((StringBuilder)object3).append((String)object2);
                object2 = "/log/tencent/liteav";
                ((StringBuilder)object3).append((String)object2);
                mLogCacheDir = object3 = ((StringBuilder)object3).toString();
                object3 = "TXCLog";
                object2 = new StringBuilder();
                charSequence = "TXCLog init log file path : ";
                ((StringBuilder)object2).append((String)charSequence);
                charSequence = mLogDir;
                ((StringBuilder)object2).append((String)charSequence);
                charSequence = ", cache : ";
                ((StringBuilder)object2).append((String)charSequence);
                charSequence = mLogCacheDir;
                ((StringBuilder)object2).append((String)charSequence);
                object2 = ((StringBuilder)object2).toString();
                Log.i((String)object3, (String)object2);
                TXCLog.nativeLogInit();
                bl4 = mLogLevel;
                TXCLog.nativeLogSetLevel((int)(bl4 ? 1 : 0));
                bl4 = mEnableConsole;
                TXCLog.nativeLogSetConsole(bl4);
                bl4 = false;
                object3 = null;
                object2 = mLogDir;
                charSequence = mLogCacheDir;
                String string2 = "LiteAV";
                boolean bl5 = mEnableCompress;
                TXCLog.nativeLogOpen(0, (String)object2, (String)charSequence, string2, bl5);
                bl4 = mEnableCallback;
                TXCLog.nativeEnableCallback(bl4);
                mHasInit = bl3;
            }
            return mHasInit;
        }
    }

    public static void log(int n10, String string2, String string3) {
        boolean bl2 = TXCLog.init();
        if (bl2) {
            String string4 = "";
            String string5 = "";
            TXCLog.nativeLog(n10, string2, string4, 0, string5, string3);
        }
        TXCLog.log_callback(n10, string2, string3);
    }

    private static void log_callback(int n10, String string2, String string3) {
        TXCLog$a tXCLog$a = mListener;
        if (tXCLog$a != null) {
            tXCLog$a.a(n10, string2, string3);
        }
    }

    private static native void nativeEnableCallback(boolean var0);

    private static native void nativeLog(int var0, String var1, String var2, int var3, String var4, String var5);

    private static native void nativeLogClose();

    private static native void nativeLogInit();

    private static native void nativeLogOpen(int var0, String var1, String var2, String var3, boolean var4);

    private static native void nativeLogSetConsole(boolean var0);

    private static native void nativeLogSetLevel(int var0);

    public static void setConsoleEnabled(boolean bl2) {
        mEnableConsole = bl2;
        boolean bl3 = mHasInit;
        if (bl3) {
            TXCLog.nativeLogSetConsole(bl2);
        }
    }

    public static void setLevel(int n10) {
        mLogLevel = n10;
        boolean bl2 = mHasInit;
        if (bl2) {
            TXCLog.nativeLogSetLevel(n10);
        }
    }

    public static void setListener(TXCLog$a tXCLog$a) {
        boolean bl2;
        mListener = tXCLog$a;
        if (tXCLog$a != null) {
            bl2 = true;
        } else {
            bl2 = false;
            tXCLog$a = null;
        }
        mEnableCallback = bl2;
        boolean bl3 = mHasInit;
        if (bl3) {
            TXCLog.nativeEnableCallback(bl2);
        }
    }

    public static void setLogCompressEnabled(boolean bl2) {
        boolean bl3 = mEnableCompress;
        if (bl3 != bl2) {
            mEnableCompress = bl2;
            bl2 = mHasInit;
            if (bl2) {
                TXCLog.nativeLogClose();
                bl2 = false;
                String string2 = mLogDir;
                String string3 = mLogCacheDir;
                boolean bl4 = mEnableCompress;
                String string4 = "LiteAV";
                TXCLog.nativeLogOpen(0, string2, string3, string4, bl4);
            }
        }
    }

    public static void setLogDirPath(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        CharSequence charSequence = mLogDir;
        bl2 = string2.equalsIgnoreCase((String)charSequence);
        if (!bl2) {
            mLogDir = string2;
            bl2 = mHasInit;
            if (bl2) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("TXCLog setLogDirPath ");
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                Log.i((String)"TXCLog", (String)string2);
                TXCLog.nativeLogClose();
                string2 = null;
                charSequence = mLogDir;
                String string3 = mLogCacheDir;
                boolean bl3 = mEnableCompress;
                String string4 = "LiteAV";
                TXCLog.nativeLogOpen(0, (String)charSequence, string3, string4, bl3);
            }
        }
    }

    public static void sliceLogFile() {
        boolean bl2 = mHasInit;
        if (bl2) {
            Log.i((String)"TXCLog", (String)"TXCLog sliceLogFile");
            bl2 = false;
            String string2 = mLogDir;
            String string3 = mLogCacheDir;
            boolean bl3 = mEnableCompress;
            String string4 = "LiteAV";
            TXCLog.nativeLogOpen(0, string2, string3, string4, bl3);
        }
    }

    public static void v(String string2, String string3) {
        TXCLog.log(0, string2, string3);
    }

    public static void v(String string2, String string3, Object ... objectArray) {
        string3 = String.format(string3, objectArray);
        TXCLog.log(0, string2, string3);
    }

    public static void w(String string2, String string3) {
        TXCLog.log(3, string2, string3);
    }

    public static void w(String string2, String string3, Object ... objectArray) {
        string3 = String.format(string3, objectArray);
        TXCLog.log(3, string2, string3);
    }
}

