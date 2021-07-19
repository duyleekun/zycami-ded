/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.l;

import com.zhiyun.nvseditor.record.AudioRecorder;

public final class d
implements Runnable {
    public final /* synthetic */ AudioRecorder a;

    public /* synthetic */ d(AudioRecorder audioRecorder) {
        this.a = audioRecorder;
    }

    public final void run() {
        AudioRecorder.l(this.a);
    }
}

