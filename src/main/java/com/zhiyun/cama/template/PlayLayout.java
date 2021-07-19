/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Size
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 */
package com.zhiyun.cama.template;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import com.zhiyun.cama.template.PlayLayout$a;
import com.zhiyun.cama.template.PlayLayout$b;
import com.zhiyun.cama.template.PlayState;
import com.zhiyun.cama.widget.LineProgressBar;
import com.zhiyun.image.Images;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.u1.a;
import d.v.c.u1.b;
import d.v.c.u1.c;
import d.v.c.u1.d;
import d.v.c.u1.g;
import d.v.c.u1.j;
import d.v.c.w0.ae;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.j0.d$a;
import d.v.j0.d$b;
import d.v.j0.d$c;
import d.v.j0.d$d;

public class PlayLayout
extends FrameLayout {
    private ExoVideoView a;
    private ImageView b;
    private ProgressBar c;
    private LineProgressBar d;
    private ae e;
    private PlayState f;
    private boolean g;
    private String h;
    private int i;
    public m2$d j;
    private boolean k;
    private boolean l;
    private g m;

    public PlayLayout(Context object) {
        super(object);
        object = PlayState.STATE_IDLE;
        this.f = object;
        this.g = true;
        this.i = 0;
        this.k = false;
        this.l = false;
        this.b();
    }

    public PlayLayout(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        object = PlayState.STATE_IDLE;
        this.f = object;
        this.g = true;
        this.i = 0;
        this.k = false;
        this.l = false;
        this.b();
    }

    public PlayLayout(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        object = PlayState.STATE_IDLE;
        this.f = object;
        this.g = true;
        this.i = 0;
        this.k = false;
        this.l = false;
        this.b();
    }

    public PlayLayout(Context object, AttributeSet attributeSet, int n10, int n11) {
        super(object, attributeSet, n10, n11);
        object = PlayState.STATE_IDLE;
        this.f = object;
        this.g = true;
        this.i = 0;
        this.k = false;
        this.l = false;
        this.b();
    }

    private void B() {
        this.H(false);
        this.F(false);
        this.G(false);
    }

    private void G(boolean n10) {
        ProgressBar progressBar = this.c;
        n10 = n10 != 0 ? 0 : 8;
        progressBar.setVisibility(n10);
    }

    private void H(boolean bl2) {
    }

    private void d() {
        String[] stringArray;
        this.a.L(false);
        this.a.setMediaControllerDefault(false);
        ExoVideoView exoVideoView = this.a;
        exoVideoView.A();
        boolean bl2 = this.k;
        if (bl2) {
            stringArray = this.a;
            stringArray.setLoopPlay(bl2);
        }
        exoVideoView = this.a;
        String string2 = this.h;
        stringArray = new String[]{string2};
        exoVideoView.setVideoPath(stringArray);
    }

    private /* synthetic */ void k(d.v.j0.d d10) {
        Object object = new Object[]{};
        m.a.a.b("videoView OnPrepared", object);
        object = this.getPlayState();
        PlayState playState = PlayState.STATE_PLAY_PREPARE;
        if (object == playState) {
            object = PlayState.STATE_PLAYING;
            this.setPlayState((PlayState)((Object)object));
            this.D(d10);
        }
    }

    private /* synthetic */ boolean m(d.v.j0.d objectArray, int n10, int n11) {
        objectArray = new Object[2];
        Integer n12 = n10;
        objectArray[0] = n12;
        Object object = n11;
        int n13 = 1;
        objectArray[n13] = object;
        object = "videoView OnInfo,  what: %s, extra: %s";
        m.a.a.b((String)object, objectArray);
        int n14 = 3;
        if (n10 == n14) {
            this.B();
        }
        return false;
    }

    private /* synthetic */ boolean o(d.v.j0.d object, int n10, int n11) {
        Object object2;
        object = new Object[2];
        object[0] = object2 = Integer.valueOf(n10);
        object2 = n11;
        int n12 = 1;
        object[n12] = object2;
        object2 = "videoView OnError,  what: %s, extra: %s";
        m.a.a.b((String)object2, object);
        int n13 = -1004;
        if (n11 == n13) {
            this.A();
            object = PlayState.STATE_ERROR_IO;
            this.setPlayState((PlayState)((Object)object));
        }
        return false;
    }

    private /* synthetic */ void q(d.v.j0.d object) {
        object = new Object[]{};
        m.a.a.b("videoView OnCompletion", object);
        this.setVideoProgress(100);
        this.E();
        this.z();
        this.F(true);
        object = PlayState.STATE_COMPLETED;
        this.setPlayState((PlayState)((Object)object));
    }

    private void y() {
        this.H(false);
        boolean bl2 = true;
        this.F(bl2);
        this.G(bl2);
    }

    private void z() {
        this.H(true);
        this.F(false);
        this.G(false);
    }

    public void A() {
        boolean bl2 = true;
        this.H(bl2);
        this.F(bl2);
        this.G(false);
    }

    public void C(String object) {
        PlayState playState = this.f;
        PlayState playState2 = PlayState.STATE_IDLE;
        if (playState != playState2 && playState != (playState2 = PlayState.STATE_ERROR_IO)) {
            return;
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        bl2 = this.g((String)object);
        if (!bl2) {
            this.setCurPlayPath((String)object);
            this.d();
        }
        this.y();
        this.a.start();
        object = PlayState.STATE_PLAY_PREPARE;
        this.setPlayState((PlayState)((Object)object));
    }

    public void D(d.v.j0.d object) {
        boolean bl2 = this.l;
        if (bl2) {
            return;
        }
        m2$d m2$d = this.j;
        if (m2$d != null && !(bl2 = m2$d.b())) {
            return;
        }
        PlayLayout$a playLayout$a = new PlayLayout$a(this, (d.v.j0.d)object);
        this.j = object = m2.i(0L, 1000L, playLayout$a);
    }

    public void E() {
        m2.a(this.j);
        this.j = null;
    }

    public void F(boolean n10) {
        ImageView imageView = this.b;
        n10 = n10 != 0 ? 0 : 8;
        imageView.setVisibility(n10);
    }

    public void a() {
        Object object = this.f;
        PlayState playState = PlayState.STATE_PAUSE;
        if (object != playState) {
            return;
        }
        object = this.h;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        object = PlayState.STATE_PLAYING;
        this.setPlayState((PlayState)((Object)object));
        this.a.start();
        this.B();
    }

    public void b() {
        ExoVideoView exoVideoView;
        Object object;
        this.e = object = (ae)DataBindingUtil.inflate(LayoutInflater.from((Context)this.getContext()), 2131558678, (ViewGroup)this, true);
        this.a = exoVideoView = object.a;
        exoVideoView = object.c;
        this.b = exoVideoView;
        exoVideoView = object.e;
        this.c = exoVideoView;
        object = object.d;
        this.d = object;
        this.c();
    }

    public void c() {
        ExoVideoView exoVideoView = this.a;
        Object object = new d(this);
        exoVideoView.setOnPreparedListener((d$d)object);
        exoVideoView = this.a;
        object = new c(this);
        exoVideoView.setOnInfoListener((d$c)object);
        exoVideoView = this.a;
        object = new a(this);
        exoVideoView.setOnErrorListener((d$b)object);
        exoVideoView = this.a;
        object = new b(this);
        exoVideoView.setOnCompletionListener((d$a)object);
    }

    public boolean e() {
        return this.k;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g(String string2) {
        String string3 = this.h;
        return TextUtils.equals((CharSequence)string2, (CharSequence)string3);
    }

    public String getCurPlayPath() {
        return this.h;
    }

    public g getOnPlayStateChangeListener() {
        return this.m;
    }

    public PlayState getPlayState() {
        return this.f;
    }

    public boolean h() {
        boolean bl2;
        PlayState playState;
        PlayState playState2 = this.getPlayState();
        if (playState2 == (playState = PlayState.STATE_COMPLETED)) {
            bl2 = true;
        } else {
            bl2 = false;
            playState2 = null;
        }
        return bl2;
    }

    public boolean i() {
        return PlayState.isPlaying(this.f);
    }

    public boolean j() {
        return this.a.isPlaying();
    }

    public /* synthetic */ void l(d.v.j0.d d10) {
        this.k(d10);
    }

    public /* synthetic */ boolean n(d.v.j0.d d10, int n10, int n11) {
        return this.m(d10, n10, n11);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.E();
    }

    public /* synthetic */ boolean p(d.v.j0.d d10, int n10, int n11) {
        return this.o(d10, n10, n11);
    }

    public /* synthetic */ void r(d.v.j0.d d10) {
        this.q(d10);
    }

    public void s() {
        boolean bl2 = this.i();
        if (!bl2) {
            return;
        }
        PlayState playState = PlayState.STATE_PAUSE;
        this.setPlayState(playState);
        this.a.E();
        this.z();
    }

    public void setCurPlayPath(String string2) {
        this.h = string2;
    }

    /*
     * WARNING - void declaration
     */
    public void setHideProgress(boolean bl2) {
        void var1_4;
        this.l = bl2;
        if (bl2) {
            this.E();
        }
        LineProgressBar lineProgressBar = this.d;
        if (bl2) {
            int n10 = 8;
        } else {
            boolean bl3 = false;
        }
        lineProgressBar.setVisibility((int)var1_4);
    }

    public void setLoop(boolean bl2) {
        this.k = bl2;
    }

    public void setNeedRestorePlay(boolean bl2) {
        this.g = bl2;
    }

    public void setOnPlayStateChangeListener(g g10) {
        this.m = g10;
    }

    public void setPlayState(PlayState playState) {
        int n10 = 1;
        Object object = new Object[n10];
        object[0] = playState;
        String string2 = "setPlayState: %s";
        m.a.a.b(string2, (Object[])object);
        this.f = playState;
        object = this.m;
        if (object != null) {
            object.a(playState);
        }
    }

    public void setVideoProgress(int n10) {
        this.i = n10;
        this.d.setProgress(n10);
    }

    public void t(String string2) {
        int[] nArray = PlayLayout$b.a;
        PlayState playState = this.f;
        int n10 = playState.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1) && n11 != (n10 = 2)) {
            n10 = 3;
            if (n11 != n10) {
                n10 = 4;
                if (n11 != n10) {
                    this.C(string2);
                } else {
                    this.v();
                }
            } else {
                this.a();
            }
        }
    }

    public void u() {
        PlayState playState;
        Object object = this.getPlayState();
        if (object == (playState = PlayState.STATE_COMPLETED)) {
            object = this.a;
            playState = null;
            ((ExoVideoView)object).F(false);
        }
        this.a.pause();
        object = PlayState.STATE_IDLE;
        this.setPlayState((PlayState)((Object)object));
    }

    public void v() {
        Object object = this.f;
        PlayState playState = PlayState.STATE_COMPLETED;
        if (object != playState) {
            return;
        }
        object = this.h;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        object = PlayState.STATE_PLAY_PREPARE;
        this.setPlayState((PlayState)((Object)object));
        this.d();
        this.a.G();
        this.setVideoProgress(0);
        this.B();
    }

    public void w(Size size, String string2) {
        Images.E(this.b, size, string2, 2131231978);
    }

    public Size x(String string2) {
        int n10;
        int n11 = this.getHeight();
        string2 = d.v.c.u1.j.a(this.getContext(), n11, string2);
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        layoutParams.height = n10 = string2.getHeight();
        layoutParams.width = n10 = string2.getWidth();
        this.setLayoutParams(layoutParams);
        return string2;
    }
}

