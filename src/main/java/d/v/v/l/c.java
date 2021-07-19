/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.l;

import com.zhiyun.nvseditor.record.AudioRecorder;

public final class c
implements Runnable {
    public final /* synthetic */ AudioRecorder a;

    public /* synthetic */ c(AudioRecorder audioRecorder) {
        this.a = audioRecorder;
    }

    public final void run() {
        this.a.n();
    }
}

