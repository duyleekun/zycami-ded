/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.l;

import com.zhiyun.nvseditor.record.AudioRecorder$a;

public final class a
implements Runnable {
    public final /* synthetic */ AudioRecorder$a a;
    public final /* synthetic */ Exception b;

    public /* synthetic */ a(AudioRecorder$a audioRecorder$a, Exception exception) {
        this.a = audioRecorder$a;
        this.b = exception;
    }

    public final void run() {
        AudioRecorder$a audioRecorder$a = this.a;
        Exception exception = this.b;
        audioRecorder$a.e(exception);
    }
}

