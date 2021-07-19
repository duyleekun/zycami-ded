/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsUnityPluginHelper$EventCallback;
import java.util.concurrent.atomic.AtomicReference;

public class NvsUnityPluginHelper {
    private static AtomicReference m_eventCallback;

    static {
        AtomicReference<Object> atomicReference;
        m_eventCallback = atomicReference = new AtomicReference<Object>(null);
    }

    public static void onPluginEvent(int n10) {
        NvsUnityPluginHelper$EventCallback nvsUnityPluginHelper$EventCallback = (NvsUnityPluginHelper$EventCallback)m_eventCallback.get();
        if (nvsUnityPluginHelper$EventCallback != null) {
            try {
                nvsUnityPluginHelper$EventCallback.onPluginEvent(n10);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void setEventCallback(NvsUnityPluginHelper$EventCallback nvsUnityPluginHelper$EventCallback) {
        m_eventCallback.set(nvsUnityPluginHelper$EventCallback);
    }
}

