/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.voice.music;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.music.EditorAudioBeatFragment$a;
import com.zhiyun.cama.voice.music.EditorAudioBeatFragment$b;
import com.zhiyun.cama.voice.music.EditorAudioBeatFragment$c;
import com.zhiyun.cama.widget.AudioBeatView;
import com.zhiyun.cama.widget.AudioBeatView$a;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.d;
import d.v.c.w0.r8;
import d.v.c.y1.f.b;
import d.v.c.y1.f.c;
import d.v.c.y1.f.o;
import d.v.v.q.h;
import java.util.HashMap;

public class EditorAudioBeatFragment
extends d {
    private r8 j;
    private o k;
    private long l;
    private long m;

    public static /* synthetic */ long A(EditorAudioBeatFragment editorAudioBeatFragment) {
        return editorAudioBeatFragment.m;
    }

    public static /* synthetic */ g B(EditorAudioBeatFragment editorAudioBeatFragment) {
        return editorAudioBeatFragment.g;
    }

    public static /* synthetic */ g C(EditorAudioBeatFragment editorAudioBeatFragment) {
        return editorAudioBeatFragment.g;
    }

    public static /* synthetic */ g D(EditorAudioBeatFragment editorAudioBeatFragment) {
        return editorAudioBeatFragment.g;
    }

    public static /* synthetic */ g E(EditorAudioBeatFragment editorAudioBeatFragment) {
        return editorAudioBeatFragment.g;
    }

    private void F() {
        AudioBeatView audioBeatView = this.j.a;
        long l10 = this.g.U0();
        long l11 = this.l;
        audioBeatView.d(l10 -= l11);
    }

    private void G() {
        long l10;
        int n10;
        int n11 = h.m();
        if (n11 == (n10 = -1)) {
            this.r();
            return;
        }
        Cloneable cloneable = (d.v.h.h.b)this.g.H1().get(n11);
        this.k.n((d.v.h.h.b)cloneable);
        this.k.c();
        this.l = l10 = h.F(n11);
        this.m = l10 = h.D(n11);
        Object object = this.j.a;
        long l11 = cloneable.m();
        ((AudioBeatView)((Object)object)).setMusicStartTime(l11);
        object = this.j.a;
        l11 = this.l;
        long l12 = this.m - l11;
        ((AudioBeatView)((Object)object)).v(l11, l12);
        object = this.j.a;
        cloneable = this.k.g();
        ((AudioBeatView)((Object)object)).setMusicBeats((HashMap)cloneable);
        object = this.g;
        l11 = this.l;
        l12 = this.m;
        ((i2)object).x3(l11, l12);
    }

    private void H() {
        Object object = this.g.T0();
        Object object2 = this.getViewLifecycleOwner();
        Observer observer = new c(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.j.a;
        object2 = new EditorAudioBeatFragment$b(this);
        ((AudioBeatView)((Object)object)).setOnScrollListener((AudioBeatView$a)object2);
        object = this.k.e();
        object2 = this.getViewLifecycleOwner();
        observer = new b(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private void I() {
        ViewTreeObserver viewTreeObserver = this.j.a.getViewTreeObserver();
        EditorAudioBeatFragment$a editorAudioBeatFragment$a = new EditorAudioBeatFragment$a(this);
        viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)editorAudioBeatFragment$a);
    }

    private /* synthetic */ void J(Long l10) {
        long l11 = h.n();
        long l12 = this.l;
        int n10 = (int)((double)(l11 - l12) * 4.0E-4);
        this.j.a.u(n10);
    }

    private /* synthetic */ void L(Integer n10) {
        int n11 = n10;
        int n12 = 1;
        if (n11 != 0) {
            if (n11 != n12) {
                n12 = 2;
                if (n11 == n12) {
                    this.j.c.setBackgroundResource(2131231210);
                    n10 = this.j.c;
                    n12 = 0;
                    n10.setClickable(false);
                }
            } else {
                this.j.c.setClickable(n12 != 0);
                n10 = this.j.c;
                n12 = 2131231919;
                n10.setBackgroundResource(n12);
            }
        } else {
            this.j.c.setClickable(n12 != 0);
            n10 = this.j.c;
            n12 = 2131231918;
            n10.setBackgroundResource(n12);
        }
    }

    public static /* synthetic */ r8 x(EditorAudioBeatFragment editorAudioBeatFragment) {
        return editorAudioBeatFragment.j;
    }

    public static /* synthetic */ o y(EditorAudioBeatFragment editorAudioBeatFragment) {
        return editorAudioBeatFragment.k;
    }

    public static /* synthetic */ long z(EditorAudioBeatFragment editorAudioBeatFragment) {
        return editorAudioBeatFragment.l;
    }

    public /* synthetic */ void K(Long l10) {
        this.J(l10);
    }

    public /* synthetic */ void M(Integer n10) {
        this.L(n10);
    }

    public int h() {
        return 2131558596;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (r8)viewDataBinding;
        this.j = viewDataBinding;
        Object object = this.k;
        ((r8)viewDataBinding).B((o)object);
        viewDataBinding = this.j;
        object = this.g;
        ((r8)viewDataBinding).D((i2)object);
        viewDataBinding = this.j;
        object = new EditorAudioBeatFragment$c(this);
        ((r8)viewDataBinding).C((EditorAudioBeatFragment$c)object);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (o)d.v.i0.b.a(this).get(o.class);
        this.k = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.I();
        this.G();
        this.H();
        this.F();
    }

    public boolean s(int n10) {
        this.j.v().g(n10);
        return true;
    }
}

