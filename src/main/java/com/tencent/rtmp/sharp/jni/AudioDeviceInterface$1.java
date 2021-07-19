/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.AudioDeviceInterface;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioSession$ITraeAudioCallback;
import java.util.concurrent.locks.ReentrantLock;

public class AudioDeviceInterface$1
implements TraeAudioSession$ITraeAudioCallback {
    public final /* synthetic */ AudioDeviceInterface this$0;

    public AudioDeviceInterface$1(AudioDeviceInterface audioDeviceInterface) {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceStateUpdate(boolean bl2) {
        if (bl2) return;
        try {
            Object object = this.this$0;
            object = AudioDeviceInterface.access$000((AudioDeviceInterface)object);
            ((ReentrantLock)object).lock();
            object = this.this$0;
            int n10 = 1;
            AudioDeviceInterface.access$102((AudioDeviceInterface)object, n10 != 0);
            bl2 = QLog.isColorLevel();
            if (bl2) {
                object = "TRAE";
                n10 = 2;
                String string2 = "onServiceStateUpdate signalAll";
                QLog.e((String)object, n10, string2);
            }
            object = this.this$0;
            object = AudioDeviceInterface.access$200((AudioDeviceInterface)object);
            object.signalAll();
            object = this.this$0;
            object = AudioDeviceInterface.access$000((AudioDeviceInterface)object);
            ((ReentrantLock)object).unlock();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public void onStreamTypeUpdate(int n10) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onVoicecallPreprocessRes(int n10) {
        try {
            Object object = this.this$0;
            object = AudioDeviceInterface.access$000((AudioDeviceInterface)object);
            ((ReentrantLock)object).lock();
            object = this.this$0;
            int n11 = 1;
            AudioDeviceInterface.access$102((AudioDeviceInterface)object, n11 != 0);
            n10 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n10 != 0) {
                object = "TRAE";
                n11 = 2;
                String string2 = "onVoicecallPreprocessRes signalAll";
                QLog.e((String)object, n11, string2);
            }
            object = this.this$0;
            object = AudioDeviceInterface.access$200((AudioDeviceInterface)object);
            object.signalAll();
            object = this.this$0;
            object = AudioDeviceInterface.access$000((AudioDeviceInterface)object);
            ((ReentrantLock)object).unlock();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

