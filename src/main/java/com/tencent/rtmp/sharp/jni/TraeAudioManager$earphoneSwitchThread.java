/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$switchThread;

public class TraeAudioManager$earphoneSwitchThread
extends TraeAudioManager$switchThread {
    public final /* synthetic */ TraeAudioManager this$0;

    public TraeAudioManager$earphoneSwitchThread(TraeAudioManager traeAudioManager) {
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
        int n10 = TraeAudioManager.IsUpdateSceneFlag;
        if (n10 != 0 && (n10 = TraeAudioManager.enableDeviceSwitchFlag) != 0) {
            TraeAudioManager traeAudioManager = this.this$0;
            object = traeAudioManager._context;
            traeAudioManager.InternalSetSpeaker((Context)object, false);
        }
        this.updateStatus();
        n10 = TraeAudioManager.IsUpdateSceneFlag;
        int n11 = 2;
        String string2 = "TRAE";
        if (n10 == 0) {
            n10 = QLog.isColorLevel();
            if (n10 != 0) {
                String string3 = "connect earphone: do nothing";
                QLog.w(string2, n11, string3);
            }
            return;
        }
        n10 = TraeAudioManager.enableDeviceSwitchFlag;
        if (n10 == 0) {
            n10 = QLog.isColorLevel();
            if (n10 != 0) {
                String string4 = "connect earphone: disableDeviceSwitchFlag";
                QLog.w(string2, n11, string4);
            }
            return;
        }
        n10 = 0;
        Object var2_5 = null;
        int n12;
        while ((n11 = (int)(this._running ? 1 : 0)) == (n12 = 1)) {
            object = this.this$0._am;
            n11 = (int)(object.isSpeakerphoneOn() ? 1 : 0);
            if (n11 != 0) {
                object = this.this$0;
                string2 = ((TraeAudioManager)object)._context;
                ((TraeAudioManager)((Object)object)).InternalSetSpeaker((Context)string2, false);
            }
            long l10 = n10 < (n11 = 5) ? 1000L : 4000L;
            try {
                Thread.sleep(l10);
            }
            catch (InterruptedException interruptedException) {}
            ++n10;
        }
        return;
    }

    public String getDeviceName() {
        return "DEVICE_EARPHONE";
    }
}

