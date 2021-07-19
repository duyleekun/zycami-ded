/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.xiaoying.jni;

public class XYSignJni {
    public static Boolean libLoadSuccess;
    public static UnsatisfiedLinkError s_Error;

    static {
        Object object = "xyviva-lib";
        System.loadLibrary((String)object);
        object = Boolean.TRUE;
        try {
            libLoadSuccess = object;
        }
        catch (UnsatisfiedLinkError XYSignJni.s_Error) {
            libLoadSuccess = object = Boolean.FALSE;
        }
    }

    public native String getReqSign(String var1, String var2, String var3, String var4, String var5);
}

