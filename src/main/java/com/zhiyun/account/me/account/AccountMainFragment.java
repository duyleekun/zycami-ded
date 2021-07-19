/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.VideoView
 */
package com.zhiyun.account.me.account;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.account.AccountMainFragment$a;
import com.zhiyun.account.me.account.AccountMainFragment$b;
import d.v.a.g.i;
import d.v.a.i.a.b;
import d.v.a.i.a.c;
import d.v.a.i.a.d;
import d.v.a.i.a.e;
import d.v.a.i.a.f;
import d.v.a.i.a.h;
import d.v.a.i.a.l0;
import d.v.a.i.a.m0;
import d.v.a.k.a;
import d.v.e.i.j;
import d.v.e.l.h2;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;

public class AccountMainFragment
extends d.v.f.h.a {
    private i b;
    private m0 c;
    private int d;

    public static /* synthetic */ m0 j(AccountMainFragment accountMainFragment) {
        return accountMainFragment.c;
    }

    private void k() {
        Object object;
        Object object2;
        boolean bl2 = d.v.a.c.e();
        int n10 = 8;
        float f10 = 1.1E-44f;
        if (!bl2) {
            this.b.a.setVisibility(n10);
            this.b.k.setVisibility(0);
            object2 = this.b.k;
            n10 = 0;
            f10 = 0.0f;
            object2.setMediaController(null);
            object2 = this.b.k;
            object = new d.v.a.i.a.a(this);
            object2.setOnPreparedListener((MediaPlayer.OnPreparedListener)object);
            object2 = this.b.k;
            object = d.v.a.i.a.b.a;
            object2.setOnErrorListener((MediaPlayer.OnErrorListener)object);
            object2 = d.v.a.c.c();
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                object2 = this.b.k;
                object = d.v.a.c.c();
                object2.setVideoPath((String)object);
                object2 = this.b.k;
                object2.start();
            }
        } else {
            this.b.a.setVisibility(0);
            object2 = this.b.k;
            object2.setVisibility(n10);
        }
        if (!(bl2 = d.v.a.c.d()) && (object2 = (ViewGroup.MarginLayoutParams)this.b.j.getLayoutParams()) != null) {
            n10 = (int)(d.v.a.c.d() ? 1 : 0);
            if (n10 != 0) {
                n10 = 1101004800;
                f10 = 20.0f;
            } else {
                n10 = 0x42000000;
                f10 = 32.0f;
            }
            object2.bottomMargin = n10 = h2.b(f10);
            object = this.b.j;
            object.setLayoutParams((ViewGroup.LayoutParams)object2);
        }
    }

    private void l() {
        this.c.k.setValue("86");
    }

    private void m() {
        MutableLiveData mutableLiveData = this.c.b;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new AccountMainFragment$a(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.v;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new c(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.A;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = h.a;
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.x;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new e(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.C;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.w;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new f(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
    }

    private /* synthetic */ void n(MediaPlayer mediaPlayer) {
        this.y(mediaPlayer);
        mediaPlayer.setLooping(true);
    }

    public static /* synthetic */ boolean p(MediaPlayer mediaPlayer, int n10, int n11) {
        return true;
    }

    private /* synthetic */ void q(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void s(String object) {
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private /* synthetic */ void u(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2 && (object = this.getActivity()) != null) {
            object = this.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    private /* synthetic */ void w(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = l0.c();
            a.f(this, (NavDirections)object);
        }
    }

    private void y(MediaPlayer mediaPlayer) {
        int n10 = mediaPlayer.getVideoWidth();
        float f10 = n10;
        float f11 = mediaPlayer.getVideoHeight();
        f10 /= f11;
        mediaPlayer = this.b.k;
        f11 = mediaPlayer.getWidth();
        VideoView videoView = this.b.k;
        float f12 = videoView.getHeight();
        f11 /= f12;
        float f13 = (f10 /= f11) - (f11 = 1.0f);
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0) {
            mediaPlayer = this.b.k;
            mediaPlayer.setScaleX(f10);
        } else {
            videoView = this.b.k;
            videoView.setScaleY(f11 /= f10);
        }
    }

    public int h() {
        return R$layout.me_account_main_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (i)viewDataBinding;
        this.b = viewDataBinding;
        AccountMainFragment$b accountMainFragment$b = new AccountMainFragment$b(this);
        ((i)viewDataBinding).z(accountMainFragment$b);
    }

    public /* synthetic */ void o(MediaPlayer mediaPlayer) {
        this.n(mediaPlayer);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (m0)d.v.i0.b.c(this.requireActivity()).get(m0.class);
        this.c = object;
    }

    public void onDestroyView() {
        boolean bl2 = d.v.a.c.e();
        if (!bl2) {
            VideoView videoView = this.b.k;
            videoView.stopPlayback();
        }
        super.onDestroyView();
    }

    public void onPause() {
        int n10 = d.v.a.c.e();
        if (n10 == 0) {
            this.d = n10 = this.b.k.getCurrentPosition();
            VideoView videoView = this.b.k;
            videoView.pause();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        boolean bl2 = d.v.a.c.e();
        if (!bl2) {
            VideoView videoView = this.b.k;
            int n10 = this.d;
            videoView.seekTo(n10);
            videoView = this.b.k;
            videoView.start();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.k();
        this.l();
        this.m();
    }

    public /* synthetic */ void r(Boolean bl2) {
        this.q(bl2);
    }

    public /* synthetic */ void t(String string2) {
        this.s(string2);
    }

    public /* synthetic */ void v(Boolean bl2) {
        this.u(bl2);
    }

    public /* synthetic */ void x(Boolean bl2) {
        this.w(bl2);
    }
}

