/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.cdv.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class NvAndroidHandler
implements Handler.Callback {
    private Handler m_handler = null;
    private int m_id;

    private NvAndroidHandler(int n10, Looper looper) {
        Object object = null;
        this.m_id = 0;
        if (looper == null) {
            super((Handler.Callback)this);
            this.m_handler = looper;
        }
        object = new Handler(looper, (Handler.Callback)this);
        try {
            this.m_handler = object;
        }
        catch (Exception exception) {
            super();
            String string2 = "";
            ((StringBuilder)object).append(string2);
            String string3 = exception.getMessage();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            object = "NvAndroidHandler";
            Log.e((String)object, (String)string3);
        }
        this.m_id = n10;
    }

    private static native void notifyHandlerMessage(int var0, int var1, int var2, int var3);

    public boolean handleMessage(Message message) {
        int n10 = this.m_id;
        int n11 = message.what;
        int n12 = message.arg1;
        int n13 = message.arg2;
        NvAndroidHandler.notifyHandlerMessage(n10, n11, n12, n13);
        return true;
    }

    public boolean sendMessage(int n10, int n11, int n12) {
        Handler handler = this.m_handler;
        if (handler == null) {
            return false;
        }
        handler = Message.obtain();
        if (handler == null) {
            return false;
        }
        handler.what = n10;
        handler.arg1 = n11;
        handler.arg2 = n12;
        return this.m_handler.sendMessage((Message)handler);
    }
}

