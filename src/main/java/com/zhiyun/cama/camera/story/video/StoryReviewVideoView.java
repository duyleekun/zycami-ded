/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ProgressBar
 */
package com.zhiyun.cama.camera.story.video;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.image.Images;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.h7.v0.a;
import d.v.c.s0.h7.v0.b;
import d.v.c.s0.h7.v0.c;
import d.v.c.s0.h7.v0.d;
import d.v.c.w0.ci;
import d.v.e.l.m2;
import d.v.e.l.m2$b;
import d.v.e.l.n2;
import d.v.f.i.g;
import d.v.j0.d$b;
import d.v.j0.d$c;

public class StoryReviewVideoView
extends FrameLayout {
    private ci a;
    private String b;

    public StoryReviewVideoView(Context context) {
        this(context, null);
    }

    public StoryReviewVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoryReviewVideoView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.c();
        this.b();
    }

    private void b() {
        ExoVideoView exoVideoView = this.a.a;
        Object object = new c(this);
        exoVideoView.setOnInfoListener((d$c)object);
        exoVideoView = this.a.a;
        object = new b(this);
        exoVideoView.setOnErrorListener((d$b)object);
    }

    private void c() {
        ci ci2;
        FragmentActivity fragmentActivity = (FragmentActivity)this.getContext();
        this.a = ci2 = (ci)DataBindingUtil.inflate(LayoutInflater.from((Context)this.getContext()), 2131558792, (ViewGroup)this, true);
        ci2 = ci2.g;
        d d10 = new d(this, fragmentActivity);
        ci2.setOnClickListener(d10);
    }

    private /* synthetic */ boolean d(d.v.j0.d d10, int n10, int n11) {
        int n12 = 3;
        int n13 = 8;
        if (n10 != n12) {
            n12 = 701;
            if (n10 != n12) {
                n12 = 702;
                if (n10 == n12) {
                    d10 = this.a.f;
                    d10.setVisibility(n13);
                }
            } else {
                this.a.e.setVisibility(n13);
                d10 = this.a.f;
                d10.setVisibility(0);
            }
        } else {
            this.a.e.setVisibility(n13);
            this.a.f.setVisibility(n13);
            this.a.c.setVisibility(n13);
            d10 = this.a.d;
            d10.setVisibility(n13);
        }
        return false;
    }

    private /* synthetic */ boolean f(d.v.j0.d d10, int n10, int n11) {
        n2.e(g.o(this.getResources(), 2131952827));
        d10 = this.a.f;
        n10 = 8;
        d10.setVisibility(n10);
        this.a.c.setVisibility(0);
        this.a.e.setVisibility(0);
        this.a.d.setVisibility(n10);
        return true;
    }

    private /* synthetic */ void h(LifecycleOwner object, View object2) {
        object2 = this.a.a;
        boolean bl2 = ((ExoVideoView)object2).isPlaying();
        int n10 = 8;
        if (bl2) {
            this.a.e.setVisibility(0);
            this.a.d.setVisibility(n10);
            object = this.a.a;
            ((ExoVideoView)object).E();
        } else {
            this.a.e.setVisibility(n10);
            this.a.a.start();
            this.a.d.setVisibility(0);
            long l10 = 1000L;
            object2 = new a(this);
            m2.X(l10, (LifecycleOwner)object, (m2$b)object2);
        }
    }

    private /* synthetic */ void j() {
        this.a.d.setVisibility(8);
    }

    public void a() {
        ProgressBar progressBar = this.a.f;
        int n10 = 8;
        progressBar.setVisibility(n10);
        this.a.e.setVisibility(n10);
        this.a.d.setVisibility(n10);
    }

    public /* synthetic */ boolean e(d.v.j0.d d10, int n10, int n11) {
        return this.d(d10, n10, n11);
    }

    public /* synthetic */ boolean g(d.v.j0.d d10, int n10, int n11) {
        return this.f(d10, n10, n11);
    }

    public /* synthetic */ void i(LifecycleOwner lifecycleOwner, View view) {
        this.h(lifecycleOwner, view);
    }

    public /* synthetic */ void k() {
        this.j();
    }

    public void l() {
        this.a.e.setVisibility(0);
        ProgressBar progressBar = this.a.f;
        int n10 = 8;
        progressBar.setVisibility(n10);
        this.a.d.setVisibility(n10);
        this.a.a.E();
    }

    public void m() {
        String string2;
        Object object = this.b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        this.a.c.setVisibility(0);
        object = this.a.e;
        int bl3 = 8;
        object.setVisibility(bl3);
        this.a.f.setVisibility(0);
        this.a.d.setVisibility(bl3);
        this.a.a.L(false);
        this.a.a.setMediaControllerDefault(false);
        this.a.a.A();
        object = this.a.a;
        boolean bl4 = true;
        String[] stringArray = new String[bl4];
        stringArray[0] = string2 = this.b;
        ((ExoVideoView)object).setVideoPath(stringArray);
        this.a.a.setLoopPlay(bl4);
        this.a.a.start();
    }

    public void n(String string2) {
        String string3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = string2.equals(string3 = this.b))) {
            this.b = string2;
            this.m();
        }
    }

    public void o(boolean n10) {
        View view = this.a.g;
        n10 = n10 != 0 ? 0 : 8;
        view.setVisibility(n10);
    }

    public void p() {
        this.b = "";
        this.a.a.F(true);
        ProgressBar progressBar = this.a.f;
        int n10 = 8;
        progressBar.setVisibility(n10);
        this.a.e.setVisibility(0);
        this.a.d.setVisibility(n10);
        this.a.c.setVisibility(0);
    }

    public void setCornerBackground(int n10) {
        this.a.g.setBackgroundResource(n10);
    }

    public void setCoverBackground(int n10) {
        this.a.a.setBackgroundResource(n10);
        this.a.c.setBackgroundResource(n10);
    }

    public void setCoverPath(String string2) {
        Images.e(this.a.c, string2);
    }

    public void setVideoMargin(int n10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.a.getLayoutParams();
        layoutParams.setMargins(n10, n10, n10, n10);
        this.a.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        layoutParams = (FrameLayout.LayoutParams)this.a.c.getLayoutParams();
        layoutParams.setMargins(n10, n10, n10, n10);
        this.a.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }
}

