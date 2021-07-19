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

public class TraeAudioManager$speakerSwitchThread
extends TraeAudioManager$switchThread {
    public final /* synthetic */ TraeAudioManager this$0;

    public TraeAudioManager$speakerSwitchThread(TraeAudioManager traeAudioManager) {
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
        Object object2;
        int n10 = TraeAudioManager.IsMusicScene;
        int n11 = 1;
        if (n10 == 0 && (n10 = TraeAudioManager.IsUpdateSceneFlag) != 0 && (n10 = TraeAudioManager.enableDeviceSwitchFlag) != 0) {
            object2 = this.this$0;
            object = ((TraeAudioManager)object2)._context;
            ((TraeAudioManager)((Object)object2)).InternalSetSpeaker((Context)object, n11 != 0);
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
                    object2 = "connect speakerPhone: disableDeviceSwitchFlag";
                    QLog.w(string2, n12, (String)object2);
                }
                return;
            }
            n10 = QLog.isColorLevel();
            if (n10 != 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(" _run:");
                String string3 = this.getDeviceName();
                ((StringBuilder)object2).append(string3);
                string3 = " _running:";
                ((StringBuilder)object2).append(string3);
                boolean bl2 = this._running;
                ((StringBuilder)object2).append(bl2);
                object2 = ((StringBuilder)object2).toString();
                QLog.w(string2, n12, (String)object2);
            }
        } else {
            n10 = QLog.isColorLevel();
            if (n10 != 0) {
                object2 = "connect speakerPhone: do nothing";
                QLog.w(string2, n12, (String)object2);
            }
            return;
        }
        n10 = 0;
        object2 = null;
        while ((n12 = (int)(this._running ? 1 : 0)) == n11) {
            object = this.this$0._am;
            n12 = (int)(object.isSpeakerphoneOn() ? 1 : 0);
            if (n12 != n11) {
                object = this.this$0;
                string2 = ((TraeAudioManager)object)._context;
                ((TraeAudioManager)((Object)object)).InternalSetSpeaker((Context)string2, n11 != 0);
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
        return "DEVICE_SPEAKERPHONE";
    }
}

