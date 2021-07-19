/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.voice.music;

import com.zhiyun.cama.voice.music.EditorAudioBeatFragment;
import com.zhiyun.cama.widget.AudioBeatView$a;
import d.v.c.b1.t.g;
import d.v.c.y1.f.o;

public class EditorAudioBeatFragment$b
implements AudioBeatView$a {
    public final /* synthetic */ EditorAudioBeatFragment a;

    public EditorAudioBeatFragment$b(EditorAudioBeatFragment editorAudioBeatFragment) {
        this.a = editorAudioBeatFragment;
    }

    public void a(int n10) {
        EditorAudioBeatFragment.y(this.a).m(n10);
    }

    public void b(boolean bl2, boolean bl3) {
        EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.a).e.setEnabled(bl2);
        EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.a).d.setEnabled(bl3);
    }

    public void c(int n10, boolean bl2) {
        if (bl2) {
            o o10 = EditorAudioBeatFragment.y(this.a);
            long l10 = o10.i(n10);
            long l11 = EditorAudioBeatFragment.z(this.a);
            l10 += l11;
            l11 = EditorAudioBeatFragment.A(this.a);
            l10 = Math.min(l10, l11);
            g g10 = EditorAudioBeatFragment.B(this.a);
            g10.a3(l10);
        }
    }
}

