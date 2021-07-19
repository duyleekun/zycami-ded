/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.AudioSessionDuplicate;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioSession$ITraeAudioCallback;
import java.util.concurrent.locks.ReentrantLock;

public final class AudioSessionDuplicate$1
implements TraeAudioSession$ITraeAudioCallback {
    public void onAudioRouteSwitchEnd(String string2, long l10) {
    }

    public void onAudioRouteSwitchStart(String string2, String string3) {
    }

    public void onConnectDeviceRes(int n10, String string2, boolean bl2) {
    }

    public void onDeviceChangabledUpdate(boolean bl2) {
    }

    public void onDeviceListUpdate(String[] stringArray, String string2, String string3, String string4) {
        AudioSessionDuplicate.access$302(stringArray);
        boolean bl2 = AudioSessionDuplicate.access$400();
        if (bl2) {
            AudioSessionDuplicate.access$500(string2);
        }
    }

    public void onGetConnectedDeviceRes(int n10, String string2) {
        if (n10 == 0) {
            AudioSessionDuplicate.access$500(string2);
        }
    }

    public void onGetConnectingDeviceRes(int n10, String string2) {
    }

    public void onGetDeviceListRes(int n10, String[] stringArray, String string2, String string3, String string4) {
        AudioSessionDuplicate.access$302(stringArray);
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
            Object object = AudioSessionDuplicate.access$000();
            ((ReentrantLock)object).lock();
            bl2 = true;
            AudioSessionDuplicate.access$102(bl2);
            bl2 = QLog.isColorLevel();
            if (bl2) {
                object = "TRAE";
                int n10 = 2;
                String string2 = "onServiceStateUpdate signalAll";
                QLog.e((String)object, n10, string2);
            }
            object = AudioSessionDuplicate.access$200();
            object.signalAll();
            object = AudioSessionDuplicate.access$000();
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
            Object object = AudioSessionDuplicate.access$000();
            ((ReentrantLock)object).lock();
            n10 = 1;
            AudioSessionDuplicate.access$102(n10 != 0);
            n10 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n10 != 0) {
                object = "TRAE";
                int n11 = 2;
                String string2 = "onVoicecallPreprocessRes signalAll";
                QLog.e((String)object, n11, string2);
            }
            object = AudioSessionDuplicate.access$200();
            object.signalAll();
            object = AudioSessionDuplicate.access$000();
            ((ReentrantLock)object).unlock();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

