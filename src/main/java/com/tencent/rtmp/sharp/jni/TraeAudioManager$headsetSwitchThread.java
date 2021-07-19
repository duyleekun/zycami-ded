/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$switchThread;

public class TraeAudioManager$headsetSwitchThread
extends TraeAudioManager$switchThread {
    public final /* synthetic */ TraeAudioManager this$0;

    public TraeAudioManager$headsetSwitchThread(TraeAudioManager traeAudioManager) {
        this.this$0 = traeAudioManager;
        super(traeAudioManager);
    }

    public void _quit() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void _run() {
        Object object;
        int n10 = TraeAudioManager.IsMusicScene;
        int n11 = 1;
        if (n10 == 0 && (n10 = TraeAudioManager.IsUpdateSceneFlag) != 0 && (n10 = TraeAudioManager.enableDeviceSwitchFlag) != 0) {
            TraeAudioManager traeAudioManager = this.this$0;
            object = traeAudioManager._context;
            traeAudioManager.InternalSetSpeaker((Context)object, false);
            AudioManager audioManager = this.this$0._am;
            audioManager.setWiredHeadsetOn(n11 != 0);
        }
        this.updateStatus();
        n10 = TraeAudioManager.IsMusicScene;
        int n12 = 2;
        String string2 = "TRAE";
        if (n10 == 0 && (n10 = TraeAudioManager.IsUpdateSceneFlag) != 0) {
            n10 = TraeAudioManager.enableDeviceSwitchFlag;
            if (n10 == 0) {
                n10 = QLog.isColorLevel();
                if (n10 != 0) {
                    String string3 = "connect headset: disableDeviceSwitchFlag";
                    QLog.w(string2, n12, string3);
                }
                return;
            }
        } else {
            n10 = QLog.isColorLevel();
            if (n10 != 0) {
                String string4 = "connect headset: do nothing";
                QLog.w(string2, n12, string4);
            }
            return;
        }
        n10 = 0;
        Object var3_6 = null;
        while ((n12 = (int)(this._running ? 1 : 0)) == n11) {
            object = this.this$0._am;
            n12 = (int)(object.isSpeakerphoneOn() ? 1 : 0);
            if (n12 != 0) {
                object = this.this$0;
                string2 = ((TraeAudioManager)object)._context;
                ((TraeAudioManager)((Object)object)).InternalSetSpeaker((Context)string2, false);
            }
            long l10 = n10 < (n12 = 5) ? 1000L : 4000L;
            try {
                Thread.sleep(l10);
            }
            catch (InterruptedException interruptedException) {}
            ++n10;
        }
        return;
    }

    public String getDeviceName() {
        return "DEVICE_WIREDHEADSET";
    }
}

