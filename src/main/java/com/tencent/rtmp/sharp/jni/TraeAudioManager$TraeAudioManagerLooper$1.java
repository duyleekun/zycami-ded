/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper;
import com.tencent.rtmp.sharp.jni.TraeMediaPlayer$OnCompletionListener;
import java.util.HashMap;

public class TraeAudioManager$TraeAudioManagerLooper$1
implements TraeMediaPlayer$OnCompletionListener {
    public final /* synthetic */ TraeAudioManager$TraeAudioManagerLooper this$1;

    public TraeAudioManager$TraeAudioManagerLooper$1(TraeAudioManager$TraeAudioManagerLooper traeAudioManager$TraeAudioManagerLooper) {
        this.this$1 = traeAudioManager$TraeAudioManagerLooper;
    }

    public void onCompletion() {
        Object object;
        int n10 = QLog.isColorLevel();
        if (n10 != 0) {
            n10 = 2;
            object = new StringBuilder();
            ((StringBuilder)object).append("_ringPlayer onCompletion _activeMode:");
            int n11 = this.this$1.this$0._activeMode;
            ((StringBuilder)object).append(n11);
            ((StringBuilder)object).append(" _preRingMode:");
            n11 = this.this$1._preRingMode;
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            String string2 = "TRAE";
            QLog.w(string2, n10, (String)object);
        }
        HashMap<String, Comparable<StringBuilder>> hashMap = new HashMap<String, Comparable<StringBuilder>>();
        object = Boolean.TRUE;
        hashMap.put("PARAM_ISHOSTSIDE", (Comparable<StringBuilder>)object);
        this.this$1.sendMessage(32783, hashMap);
        this.this$1.notifyRingCompletion();
    }
}

