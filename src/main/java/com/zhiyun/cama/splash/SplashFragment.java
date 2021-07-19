/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnSystemUiVisibilityChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.VideoView
 */
package com.zhiyun.cama.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.account.me.account.AccountActivity;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.cama.data.database.model.SplashAd;
import com.zhiyun.cama.splash.SplashActivity;
import com.zhiyun.cama.splash.SplashFragment$a;
import com.zhiyun.cama.splash.SplashFragment$b;
import com.zhiyun.cama.splash.SplashFragment$c;
import com.zhiyun.image.Images;
import d.v.c.i0;
import d.v.c.i1.r2;
import d.v.c.t1.c;
import d.v.c.t1.d;
import d.v.c.t1.e;
import d.v.c.t1.j;
import d.v.c.t1.k;
import d.v.c.t1.l;
import d.v.c.t1.m;
import d.v.c.t1.n;
import d.v.c.t1.o;
import d.v.c.t1.p;
import d.v.c.t1.q;
import d.v.c.t1.r;
import d.v.c.t1.s;
import d.v.c.w0.ah;
import d.v.c.z0.h;
import d.v.c.z0.i;
import d.v.c.z0.i$c;
import d.v.e.j.a;
import d.v.e.j.b;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.o1;
import d.v.e.l.s1;
import d.v.f.i.g;
import java.util.ArrayList;
import java.util.List;

public class SplashFragment
extends d.v.f.h.a {
    private s b;
    private r2 c;
    private ah d;
    private boolean e;

    private /* synthetic */ void B(SplashAd splashAd) {
        LiveData liveData = this.b.g();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        liveData.removeObservers(lifecycleOwner);
        this.b.k();
        this.Z(splashAd);
    }

    private /* synthetic */ void D(MediaPlayer mediaPlayer) {
        VideoView videoView = this.d.j;
        this.Y(videoView, mediaPlayer);
    }

    private /* synthetic */ boolean F(MediaPlayer mediaPlayer, int n10, int n11) {
        this.a0();
        return true;
    }

    private /* synthetic */ void H(MediaPlayer mediaPlayer) {
        this.a0();
    }

    private /* synthetic */ void J(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            bl2 = this.d.j;
            int n10 = 8;
            bl2.setVisibility(n10);
            bl2 = this.d.j.getParent();
            if (bl2 != null) {
                bl2 = (ViewGroup)bl2;
                VideoView videoView = this.d.j;
                bl2.removeView((View)videoView);
            }
        }
    }

    public static /* synthetic */ void L(SplashFragment splashFragment) {
        splashFragment.a0();
    }

    private /* synthetic */ void M(MediaPlayer mediaPlayer) {
        VideoView videoView = this.d.i;
        this.Y(videoView, mediaPlayer);
    }

    private /* synthetic */ boolean O(MediaPlayer object, int n10, int n11) {
        int n12 = 3;
        if (n10 == n12 && (n12 = (int)(d.v.e.h.a.c((Boolean)(object = (Boolean)this.b.k.getValue())) ? 1 : 0)) == 0) {
            object = this.d.i;
            object.pause();
        }
        return true;
    }

    private /* synthetic */ boolean Q(MediaPlayer object, int n10, int n11) {
        this.b.d.setValue(null);
        object = this.b.e;
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
        return true;
    }

    public static /* synthetic */ void S(View view, int n10) {
        if ((n10 &= 4) == 0) {
            n10 = 5894;
            view.setSystemUiVisibility(n10);
        }
    }

    private /* synthetic */ void T(SplashAd object) {
        boolean bl2;
        Object object2 = this.b.d;
        FragmentActivity fragmentActivity = this.requireActivity();
        ((LiveData)object2).removeObservers(fragmentActivity);
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((SplashAd)object).getUrl())))) {
            object2 = this.b;
            int n10 = ((SplashAd)object).getId();
            ((s)object2).i(n10);
            this.e = bl2 = true;
            object = ((SplashAd)object).getUrl();
            this.q((String)object);
        }
    }

    private /* synthetic */ void V(View object) {
        object = this.b;
        boolean bl2 = true;
        ((s)object).l(bl2);
        object = this.b;
        boolean bl3 = ((s)object).d();
        if (bl3) {
            this.r();
        }
    }

    private void X() {
        NavDirections navDirections = r.d();
        d.v.c.x1.l.f(this, navDirections);
    }

    private void Y(VideoView videoView, MediaPlayer mediaPlayer) {
        int n10 = mediaPlayer.getVideoWidth();
        float f10 = n10;
        float f11 = mediaPlayer.getVideoHeight();
        f10 /= f11;
        f11 = videoView.getWidth();
        float f12 = videoView.getHeight();
        f11 /= f12;
        float f13 = (f10 /= f11) - (f11 = 1.0f);
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0) {
            videoView.setScaleX(f10);
        } else {
            videoView.setScaleY(f11 /= f10);
        }
    }

    private void Z(SplashAd object) {
        Object object2;
        boolean bl2;
        Object object3 = Boolean.TRUE;
        if (object != null && (bl2 = s1.q((String)(object2 = ((SplashAd)object).getFilePath())))) {
            this.b.d.setValue(object);
            object2 = this.b.f;
            boolean bl3 = ((SplashAd)object).isVideo();
            Boolean bl4 = bl3;
            ((MutableLiveData)object2).setValue(bl4);
            bl2 = ((SplashAd)object).isVideo();
            if (bl2) {
                object2 = this.b.e;
                ((MutableLiveData)object2).setValue(object3);
                object3 = this.d.i;
                object = Uri.parse((String)((SplashAd)object).getFilePath());
                object3.setVideoURI((Uri)object);
                this.d.i.start();
                object = this.d.i;
                object3 = new d(this);
                object.setOnPreparedListener((MediaPlayer.OnPreparedListener)object3);
                object = this.d.i;
                object3 = new j(this);
                object.setOnInfoListener((MediaPlayer.OnInfoListener)object3);
                object = this.d.i;
                object3 = new e(this);
                object.setOnErrorListener((MediaPlayer.OnErrorListener)object3);
            } else {
                object2 = this.b.e;
                ((MutableLiveData)object2).setValue(object3);
                object3 = this.d.a;
                object = ((SplashAd)object).getFilePath();
                Images.e((ImageView)object3, object);
            }
        } else {
            this.b.d.setValue(null);
            object = this.b.e;
            object3 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(object3);
        }
    }

    private void a0() {
        Object object = i0.e();
        boolean bl2 = ((i0)object).D();
        if (!bl2) {
            this.f0();
            return;
        }
        d.v.a.c.m(true);
        object = ResConfig$AppResType.APP_ASSETS;
        Object object2 = "video_zf_dl_bg_5s.mp4";
        object = d.v.e.j.b.h((a)object, (String)object2);
        d.v.a.c.k((String)object);
        bl2 = this.w();
        if (bl2) {
            this.t();
            return;
        }
        object = this.b;
        bl2 = ((s)object).d();
        if (bl2 && (bl2 = ((s)(object = this.b)).b())) {
            this.s();
            return;
        }
        object = this.b.k;
        object2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(object2);
        object = this.b;
        bl2 = ((s)object).d();
        if (!bl2) {
            this.e0();
        }
        if (!(bl2 = ((s)(object = this.b)).b())) {
            this.d0();
        }
    }

    private void b0() {
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity == null) {
            return;
        }
        fragmentActivity = this.getActivity().getWindow();
        Object object = fragmentActivity.getAttributes();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            object.layoutInDisplayCutoutMode = n10 = 1;
            fragmentActivity.setAttributes((WindowManager.LayoutParams)object);
        }
        fragmentActivity.getDecorView().setSystemUiVisibility(5894);
        fragmentActivity = fragmentActivity.getDecorView();
        object = new c((View)fragmentActivity);
        fragmentActivity.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)object);
    }

    private void c0() {
        MutableLiveData mutableLiveData = this.b.d;
        FragmentActivity fragmentActivity = this.requireActivity();
        q q10 = new q(this);
        mutableLiveData.observe(fragmentActivity, q10);
    }

    private void d0() {
        Object object = this.getChildFragmentManager();
        Object object2 = "AgreePrivateDialog";
        if ((object = (h)((FragmentManager)object).findFragmentByTag((String)object2)) == null) {
            object = h.z();
        }
        object2 = new k(this);
        ((h)object).B((View.OnClickListener)object2);
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    private void e0() {
        boolean bl2;
        Object object;
        Object object2 = this.d.k.getAdapter();
        if (object2 != null) {
            return;
        }
        object2 = new ArrayList();
        int n10 = 5;
        int[] nArray = object = new int[n10];
        int[] nArray2 = object;
        nArray[0] = 2131952256;
        nArray2[1] = 2131952258;
        nArray[2] = 2131952257;
        nArray2[3] = 2131952255;
        nArray2[4] = 2131952254;
        Object object3 = this.getResources().obtainTypedArray(2130903046);
        int n11 = 0;
        d.v.c.n0.d d10 = null;
        while (true) {
            View view;
            int n12 = object3.length();
            bl2 = true;
            if (n11 >= n12) break;
            Context context = this.getContext();
            ImageView imageView = new ImageView(context);
            int n13 = -1;
            context = new ViewGroup.LayoutParams(n13, n13);
            imageView.setLayoutParams((ViewGroup.LayoutParams)context);
            context = object3.getDrawable(n11);
            imageView.setImageDrawable((Drawable)context);
            object2.add(imageView);
            imageView = this.d.d;
            if (n11 != 0) {
                bl2 = false;
                view = null;
            }
            view = this.o(bl2);
            imageView.addView(view);
            ++n11;
        }
        object3.recycle();
        object3 = this.d.k;
        d10 = new d.v.c.n0.d((List)object2);
        ((ViewPager)((Object)object3)).setAdapter(d10);
        object2 = this.d.k;
        object3 = new SplashFragment$b(this, (int[])object);
        ((ViewPager)((Object)object2)).addOnPageChangeListener((ViewPager$OnPageChangeListener)object3);
        object2 = this.b;
        object3 = this.requireContext();
        n10 = object[0];
        object = g.m((Context)object3, n10);
        ((s)object2).r((String)object);
        this.b.p(bl2);
    }

    private void f0() {
        i i10 = new i();
        Object object = new o(this);
        i10.E((i$c)object);
        object = this.getChildFragmentManager();
        i10.q((FragmentManager)object);
    }

    private void g0(SplashAd object) {
        Object object2 = this.d.i;
        int n10 = 0;
        object2.setMediaController(null);
        object2 = this.b.k;
        Object object3 = Boolean.TRUE;
        ((MutableLiveData)object2).setValue(object3);
        boolean bl2 = ((SplashAd)object).isVideo();
        if (bl2) {
            object2 = this.d.i;
            object2.start();
        }
        bl2 = ((SplashAd)object).isAutoDisappear();
        n10 = 2131952253;
        if (bl2) {
            object2 = this.b;
            int n11 = ((s)object2).h;
            if (n11 <= 0) {
                int n12;
                ((s)object2).h = n12 = ((SplashAd)object).getPeriod();
            }
            object = this.b.g;
            object2 = new StringBuilder();
            Context context = this.requireContext();
            object3 = g.m(context, n10);
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(" ");
            object3 = this.b;
            n10 = ((s)object3).h;
            ((StringBuilder)object2).append(n10);
            object2 = ((StringBuilder)object2).toString();
            ((MutableLiveData)object).setValue(object2);
            long l10 = 0L;
            long l11 = 1000L;
            object = this.b;
            int n13 = ((s)object).h;
            SplashFragment$a splashFragment$a = new SplashFragment$a(this);
            m2.b(l10, l11, n13, this, splashFragment$a);
        } else {
            object = this.b.g;
            object2 = g.m(this.requireContext(), n10);
            ((MutableLiveData)object).setValue(object2);
        }
    }

    public static /* synthetic */ s j(SplashFragment splashFragment) {
        return splashFragment.b;
    }

    public static /* synthetic */ void k(SplashFragment splashFragment) {
        splashFragment.r();
    }

    public static /* synthetic */ void l(SplashFragment splashFragment, int n10) {
        splashFragment.n(n10);
    }

    public static /* synthetic */ void m(SplashFragment splashFragment) {
        splashFragment.c0();
    }

    private void n(int n10) {
        LinearLayout linearLayout = this.d.d;
        int n11 = linearLayout.getChildCount() + -1;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            float f10;
            View view = this.d.d.getChildAt(i10);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
            if (i10 == n10) {
                view.setBackgroundResource(2131232130);
                f10 = 18.0f;
                layoutParams.width = n12 = h2.b(f10);
            } else {
                view.setBackgroundResource(2131232045);
                f10 = 6.0f;
                layoutParams.width = n12 = h2.b(f10);
            }
            view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
    }

    private View o(boolean bl2) {
        int n10;
        float f10;
        Context context = this.getContext();
        View view = new View(context);
        float f11 = 6.0f;
        int n11 = h2.b(f11);
        int n12 = h2.b(f11);
        context = new LinearLayout.LayoutParams(n11, n12);
        if (bl2) {
            int n13;
            context.width = n13 = h2.b(18.0f);
            int n14 = 2131232130;
            f10 = 1.808036E38f;
            view.setBackgroundResource(n14);
        } else {
            int n15 = 2131232045;
            f10 = 1.8080188E38f;
            view.setBackgroundResource(n15);
        }
        f10 = 5.0f;
        context.leftMargin = n12 = h2.b(f10);
        context.rightMargin = n10 = h2.b(f10);
        view.setLayoutParams((ViewGroup.LayoutParams)context);
        return view;
    }

    private void p(VideoView videoView) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            n10 = 0;
            videoView.setAudioFocusRequest(0);
        }
    }

    private void q(String string2) {
        SimpleWebViewActivity.h(this.getActivity(), "", string2);
    }

    private void r() {
        VideoView videoView = this.d.j;
        int n10 = videoView.getVisibility();
        if (n10 == 0) {
            videoView = this.d.c;
            videoView.setVisibility(0);
            long l10 = 100;
            LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
            m m10 = new m(this);
            m2.X(l10, lifecycleOwner, m10);
        } else {
            this.X();
        }
    }

    private void s() {
        MutableLiveData mutableLiveData = this.b.d;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        l l10 = new l(this);
        mutableLiveData.observe(lifecycleOwner, l10);
    }

    private void t() {
        Object object = d.v.a.f.c.b.N();
        boolean bl2 = ((d.v.a.f.c.b)object).s();
        if (bl2) {
            object = r.b();
            d.v.c.x1.l.f(this, (NavDirections)object);
        } else {
            object = this.requireActivity();
            AccountActivity.l((Activity)object);
        }
    }

    private void u() {
        LiveData liveData = this.b.g();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        d.v.c.t1.h h10 = new d.v.c.t1.h(this);
        liveData.observe(lifecycleOwner, h10);
    }

    private void v() {
        Object object = this.d.j;
        Object object2 = o1.f0(2131886084);
        object.setVideoURI(object2);
        this.d.j.setZOrderOnTop(true);
        this.d.j.setMediaController(null);
        object = this.d.j;
        this.p((VideoView)object);
        this.d.j.start();
        object = this.d.j;
        object2 = new d.v.c.t1.i(this);
        object.setOnPreparedListener((MediaPlayer.OnPreparedListener)object2);
        object = this.d.j;
        object2 = new n(this);
        object.setOnErrorListener((MediaPlayer.OnErrorListener)object2);
        object = this.d.j;
        object2 = new d.v.c.t1.g(this);
        object.setOnCompletionListener((MediaPlayer.OnCompletionListener)object2);
        object = this.b.k;
        object2 = this.getViewLifecycleOwner();
        p p10 = new p(this);
        ((LiveData)object).observe((LifecycleOwner)object2, p10);
        this.u();
    }

    private boolean w() {
        FragmentActivity fragmentActivity = this.getActivity();
        boolean bl2 = fragmentActivity instanceof SplashActivity;
        if (!bl2) {
            return false;
        }
        return ((s)d.v.i0.b.c(this.requireActivity()).get(s.class)).j();
    }

    private /* synthetic */ void x() {
        MutableLiveData mutableLiveData = this.b.k;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
        this.X();
    }

    private /* synthetic */ void z(SplashAd splashAd) {
        if (splashAd != null) {
            this.g0(splashAd);
        } else {
            this.r();
        }
    }

    public /* synthetic */ void A(SplashAd splashAd) {
        this.z(splashAd);
    }

    public /* synthetic */ void C(SplashAd splashAd) {
        this.B(splashAd);
    }

    public /* synthetic */ void E(MediaPlayer mediaPlayer) {
        this.D(mediaPlayer);
    }

    public /* synthetic */ boolean G(MediaPlayer mediaPlayer, int n10, int n11) {
        return this.F(mediaPlayer, n10, n11);
    }

    public /* synthetic */ void I(MediaPlayer mediaPlayer) {
        this.H(mediaPlayer);
    }

    public /* synthetic */ void K(Boolean bl2) {
        this.J(bl2);
    }

    public /* synthetic */ void N(MediaPlayer mediaPlayer) {
        this.M(mediaPlayer);
    }

    public /* synthetic */ boolean P(MediaPlayer mediaPlayer, int n10, int n11) {
        return this.O(mediaPlayer, n10, n11);
    }

    public /* synthetic */ boolean R(MediaPlayer mediaPlayer, int n10, int n11) {
        return this.Q(mediaPlayer, n10, n11);
    }

    public /* synthetic */ void U(SplashAd splashAd) {
        this.T(splashAd);
    }

    public /* synthetic */ void W(View view) {
        this.V(view);
    }

    public int h() {
        return 2131558778;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (ah)viewDataBinding;
        this.d = viewDataBinding;
        Object object = this.b;
        ((ah)viewDataBinding).B((s)object);
        viewDataBinding = this.d;
        object = new SplashFragment$c(this);
        ((ah)viewDataBinding).A((SplashFragment$c)object);
    }

    public void onAttach(Context object) {
        s s10;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.b = s10 = (s)((ViewModelProvider)object).get(s.class);
        this.c = object = (r2)((ViewModelProvider)object).get(r2.class);
    }

    public void onDestroy() {
        this.d.j.suspend();
        this.d.i.suspend();
        this.c.n();
        super.onDestroy();
    }

    public void onPause() {
        int n10;
        VideoView videoView;
        Object object = this.d.i;
        int n11 = object.getVisibility();
        if (n11 == 0) {
            object = this.b;
            videoView = this.d.i;
            object.i = n10 = videoView.getCurrentPosition();
            object = this.d.i;
            object.pause();
        }
        if ((n11 = (object = this.d.j).getVisibility()) == 0) {
            object = this.b;
            videoView = this.d.j;
            object.j = n10 = videoView.getCurrentPosition();
            object = this.d.j;
            object.pause();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        int n10 = this.e;
        if (n10 != 0) {
            this.r();
        } else {
            int n11;
            s s10;
            this.b0();
            Object object = this.d.i;
            n10 = object.getVisibility();
            if (n10 == 0 && (n10 = (int)(d.v.e.h.a.c((Boolean)(object = (Boolean)this.b.k.getValue())) ? 1 : 0)) != 0) {
                object = this.d.i;
                s10 = this.b;
                n11 = s10.i;
                object.seekTo(n11);
                object = this.d.i;
                object.start();
            }
            if ((n10 = (object = this.d.j).getVisibility()) == 0 && (n10 = (int)(d.v.e.h.a.c((Boolean)(object = (Boolean)this.b.k.getValue())) ? 1 : 0)) == 0) {
                object = this.d.j;
                s10 = this.b;
                n11 = s10.j;
                object.seekTo(n11);
                object = this.d.j;
                object.start();
            }
        }
    }

    public void onStop() {
        super.onStop();
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity == null) {
            return;
        }
        this.getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.v();
    }

    public /* synthetic */ void y() {
        this.x();
    }
}

