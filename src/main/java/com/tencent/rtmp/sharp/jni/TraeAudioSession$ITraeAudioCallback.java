/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

public interface TraeAudioSession$ITraeAudioCallback {
    public void onAudioRouteSwitchEnd(String var1, long var2);

    public void onAudioRouteSwitchStart(String var1, String var2);

    public void onConnectDeviceRes(int var1, String var2, boolean var3);

    public void onDeviceChangabledUpdate(boolean var1);

    public void onDeviceListUpdate(String[] var1, String var2, String var3, String var4);

    public void onGetConnectedDeviceRes(int var1, String var2);

    public void onGetConnectingDeviceRes(int var1, String var2);

    public void onGetDeviceListRes(int var1, String[] var2, String var3, String var4, String var5);

    public void onGetStreamTypeRes(int var1, int var2);

    public void onIsDeviceChangabledRes(int var1, boolean var2);

    public void onRingCompletion(int var1, String var2);

    public void onServiceStateUpdate(boolean var1);

    public void onStreamTypeUpdate(int var1);

    public void onVoicecallPreprocessRes(int var1);
}

