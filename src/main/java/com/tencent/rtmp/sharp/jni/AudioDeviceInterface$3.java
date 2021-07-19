/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.AudioDeviceInterface;
import com.tencent.rtmp.sharp.jni.TraeAudioSession$ITraeAudioCallback;

public class AudioDeviceInterface$3
implements TraeAudioSession$ITraeAudioCallback {
    public final /* synthetic */ AudioDeviceInterface this$0;

    public AudioDeviceInterface$3(AudioDeviceInterface audioDeviceInterface) {
        this.this$0 = audioDeviceInterface;
    }

    public void onAudioRouteSwitchEnd(String string2, long l10) {
    }

    public void onAudioRouteSwitchStart(String string2, String string3) {
    }

    public void onConnectDeviceRes(int n10, String string2, boolean bl2) {
    }

    public void onDeviceChangabledUpdate(boolean bl2) {
    }

    public void onDeviceListUpdate(String[] object, String string2, String string3, String string4) {
        AudioDeviceInterface.access$302(object);
        object = this.this$0;
        boolean bl2 = AudioDeviceInterface.access$400((AudioDeviceInterface)object);
        if (bl2) {
            object = this.this$0;
            AudioDeviceInterface.access$500((AudioDeviceInterface)object, string2);
        }
    }

    public void onGetConnectedDeviceRes(int n10, String string2) {
        if (n10 == 0) {
            AudioDeviceInterface audioDeviceInterface = this.this$0;
            AudioDeviceInterface.access$500(audioDeviceInterface, string2);
        }
    }

    public void onGetConnectingDeviceRes(int n10, String string2) {
    }

    public void onGetDeviceListRes(int n10, String[] stringArray, String string2, String string3, String string4) {
        AudioDeviceInterface.access$302(stringArray);
    }

    public void onGetStreamTypeRes(int n10, int n11) {
    }

    public void onIsDeviceChangabledRes(int n10, boolean bl2) {
    }

    public void onRingCompletion(int n10, String string2) {
    }

    public void onServiceStateUpdate(boolean bl2) {
    }

    public void onStreamTypeUpdate(int n10) {
    }

    public void onVoicecallPreprocessRes(int n10) {
    }
}

