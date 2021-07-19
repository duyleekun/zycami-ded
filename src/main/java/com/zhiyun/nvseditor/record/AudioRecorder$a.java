/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.nvseditor.record;

import com.zhiyun.nvseditor.record.AudioRecorder;
import com.zhiyun.nvseditor.record.AudioRecorder$b;
import d.v.e.l.s1;
import d.v.v.l.a;
import d.v.v.l.b;
import d.v.v.q.e$a;

public class AudioRecorder$a
implements e$a {
    public final /* synthetic */ AudioRecorder a;

    public AudioRecorder$a(AudioRecorder audioRecorder) {
        this.a = audioRecorder;
    }

    private /* synthetic */ void b() {
        AudioRecorder$b audioRecorder$b = AudioRecorder.c(this.a);
        if (audioRecorder$b != null) {
            audioRecorder$b = AudioRecorder.c(this.a);
            String string2 = AudioRecorder.b(this.a);
            String string3 = AudioRecorder.d(this.a);
            audioRecorder$b.c(string2, string3);
        }
    }

    private /* synthetic */ void d(Exception exception) {
        AudioRecorder$b audioRecorder$b = AudioRecorder.c(this.a);
        if (audioRecorder$b != null) {
            audioRecorder$b = AudioRecorder.c(this.a);
            audioRecorder$b.d(exception);
        }
    }

    public void a(Exception exception) {
        a a10 = new a(this, exception);
        d.v.h.l.a.g(a10);
    }

    public /* synthetic */ void c() {
        this.b();
    }

    public void complete() {
        s1.h(AudioRecorder.b(this.a));
        b b10 = new b(this);
        d.v.h.l.a.g(b10);
    }

    public /* synthetic */ void e(Exception exception) {
        this.d(exception);
    }
}

