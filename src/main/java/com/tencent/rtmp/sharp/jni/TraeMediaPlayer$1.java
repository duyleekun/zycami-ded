/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeMediaPlayer;
import java.util.TimerTask;

public class TraeMediaPlayer$1
extends TimerTask {
    public final /* synthetic */ TraeMediaPlayer this$0;

    public TraeMediaPlayer$1(TraeMediaPlayer traeMediaPlayer) {
        this.this$0 = traeMediaPlayer;
    }

    public void run() {
        Object object = TraeMediaPlayer.access$000(this.this$0);
        if (object != null) {
            int n10 = QLog.isColorLevel();
            if (n10 != 0) {
                n10 = 2;
                String string2 = "TRAE";
                String string3 = "TraeMediaPlay | play timeout";
                QLog.e(string2, n10, string3);
            }
            if ((object = TraeMediaPlayer.access$100(this.this$0)) != null) {
                object = TraeMediaPlayer.access$100(this.this$0);
                object.onCompletion();
            }
        }
    }
}

