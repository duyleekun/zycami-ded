/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.voice.music;

import com.zhiyun.cama.voice.music.EditorAudioBeatFragment;
import com.zhiyun.cama.widget.AudioBeatView;
import d.v.c.b1.t.g;
import d.v.c.q0.d$a;
import d.v.c.y1.f.o;
import d.v.v.q.h;
import java.util.HashMap;

public class EditorAudioBeatFragment$c
extends d$a {
    public final /* synthetic */ EditorAudioBeatFragment c;

    public EditorAudioBeatFragment$c(EditorAudioBeatFragment editorAudioBeatFragment) {
        this.c = editorAudioBeatFragment;
        super(editorAudioBeatFragment);
    }

    public void c() {
        super.c();
    }

    public void d() {
        super.d();
        HashMap hashMap = EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.c).a.getBeatData();
        EditorAudioBeatFragment.y(this.c).l(hashMap);
        EditorAudioBeatFragment.C(this.c).a4();
    }

    public void h(int n10) {
        long l10 = h.n();
        AudioBeatView audioBeatView = EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.c).a;
        long l11 = EditorAudioBeatFragment.z(this.c);
        l11 = l10 - l11;
        long l12 = audioBeatView.m(l11);
        AudioBeatView audioBeatView2 = EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.c).a;
        long l13 = EditorAudioBeatFragment.z(this.c);
        l10 -= l13;
        l13 = n10;
        audioBeatView2.s(l10, l13);
        g g10 = EditorAudioBeatFragment.E(this.c);
        l10 = EditorAudioBeatFragment.z(this.c) + l12 + l13;
        g10.a3(l10);
    }

    public void i() {
        long l10;
        long l11;
        Object object = EditorAudioBeatFragment.y(this.c);
        int n10 = ((o)object).f();
        if (n10 == 0) {
            object = EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.c).a;
            l11 = h.n();
            EditorAudioBeatFragment editorAudioBeatFragment = this.c;
            l10 = EditorAudioBeatFragment.z(editorAudioBeatFragment);
            ((AudioBeatView)((Object)object)).a(l11 -= l10);
        } else {
            int n11 = 1;
            if (n10 == n11) {
                object = EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.c).a;
                l11 = h.n();
                EditorAudioBeatFragment editorAudioBeatFragment = this.c;
                l10 = EditorAudioBeatFragment.z(editorAudioBeatFragment);
                ((AudioBeatView)((Object)object)).e(l11 -= l10);
            }
        }
        object = EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.c).a;
        l11 = EditorAudioBeatFragment.D(this.c).U0();
        l10 = EditorAudioBeatFragment.z(this.c);
        ((AudioBeatView)((Object)object)).d(l11 -= l10);
    }

    public void j() {
        EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.c).a.t();
    }
}

