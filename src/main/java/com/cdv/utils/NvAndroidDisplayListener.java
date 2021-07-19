/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.display.DisplayManager
 *  android.hardware.display.DisplayManager$DisplayListener
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 */
package com.cdv.utils;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class NvAndroidDisplayListener
implements DisplayManager.DisplayListener {
    private int m_id = 0;

    private NvAndroidDisplayListener(int n10) {
        this.m_id = n10;
    }

    private static native void notifyDisplayChanged(int var0, int var1);

    public boolean Register(Context object) {
        Looper looper;
        if (object == null) {
            return false;
        }
        CharSequence charSequence = "display";
        if ((object = object.getSystemService((String)charSequence)) == null) {
            return false;
        }
        object = (DisplayManager)object;
        try {
            looper = Looper.getMainLooper();
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("");
            String string2 = exception.getMessage();
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            Log.e((String)"NvAndroidDisplayListener", (String)string2);
            return false;
        }
        charSequence = new Handler(looper);
        object.registerDisplayListener((DisplayManager.DisplayListener)this, (Handler)charSequence);
        return true;
    }

    public void Unregister(Context object) {
        if (object == null) {
            return;
        }
        String string2 = "display";
        if ((object = object.getSystemService(string2)) == null) {
            return;
        }
        ((DisplayManager)object).unregisterDisplayListener((DisplayManager.DisplayListener)this);
    }

    public void onDisplayAdded(int n10) {
    }

    public void onDisplayChanged(int n10) {
        NvAndroidDisplayListener.notifyDisplayChanged(this.m_id, n10);
    }

    public void onDisplayRemoved(int n10) {
    }
}

