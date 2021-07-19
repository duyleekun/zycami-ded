/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.media.MediaMetadataRetriever
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Rational
 *  android.view.View
 *  android.widget.ProgressBar
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.util.Rational;
import android.view.View;
import android.widget.ProgressBar;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.cama.publish.VideoCropFragment$a;
import com.zhiyun.cama.publish.VideoCropFragment$b;
import com.zhiyun.cama.publish.VideoCropFragment$c;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.zyplayer.ExoVideoView;
import com.zhiyun.zyplayer.ExoVideoView$d;
import d.v.c.m0;
import d.v.c.n1.a2;
import d.v.c.n1.b2;
import d.v.c.n1.e2;
import d.v.c.n1.n2;
import d.v.c.n1.u1;
import d.v.c.n1.v1;
import d.v.c.n1.w1;
import d.v.c.n1.x1;
import d.v.c.n1.y1;
import d.v.c.n1.z1;
import d.v.c.s0.a7.j1;
import d.v.c.w0.oi;
import d.v.c.z0.j;
import d.v.c.z0.j$b;
import d.v.e.l.h2;
import d.v.f.e.c;
import d.v.f.i.g;
import d.v.h.e.a;
import d.v.i0.b;
import d.v.j0.d;
import d.v.j0.d$a;
import d.v.j0.d$d;
import d.v.v.q.h;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class VideoCropFragment
extends d.v.f.h.a {
    private final int b;
    private oi c;
    private VideoCropFragment$c d;
    private ObservableBoolean e;
    private e.a.s0.b f;
    private j1 g;
    private String h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;

    public VideoCropFragment() {
        int n10;
        this.b = n10 = 300000;
        Object object = new VideoCropFragment$c(this);
        this.d = object;
        this.e = object = new ObservableBoolean();
        this.j = n10;
        this.l = -1;
    }

    public static /* synthetic */ String A(VideoCropFragment videoCropFragment, String string2) {
        videoCropFragment.h = string2;
        return string2;
    }

    private void B() {
        this.e.set(false);
        this.k = true;
        d.v.v.q.h.g();
    }

    private void C(ComposeParams$Resolution composeParams$Resolution) {
        int n10;
        Object object = d.v.v.q.h.e0(this.h);
        int n11 = composeParams$Resolution.getHeight();
        if (n11 >= (n10 = object.getHeight())) {
            composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_ORIGINAL;
        }
        object = this.h;
        PublishActivity.m(this, (String)object, composeParams$Resolution);
    }

    private void D() {
        this.c.i.L(false);
        this.c.i.setMediaControllerDefault(false);
        ExoVideoView exoVideoView = this.c.i;
        Object object = new x1(this);
        exoVideoView.setOnPlayWhenReadyListener((ExoVideoView$d)object);
        exoVideoView = this.c.i;
        object = new z1(this);
        exoVideoView.setOnPreparedListener((d$d)object);
        exoVideoView = this.c.i;
        object = new b2(this);
        exoVideoView.setOnCompletionListener((d$a)object);
    }

    private void E(UploadCEMediaInfo object) {
        float f10 = 27.0f;
        int n10 = h2.b(f10);
        ThumbnailView thumbnailView = this.c.f;
        float f11 = (float)thumbnailView.getWidth() * 1.0f;
        int n11 = m0.l;
        float f12 = n11;
        double d10 = Math.ceil(f11 /= f12);
        int n12 = (int)d10;
        if (n12 == 0) {
            return;
        }
        long l10 = 300000000 / n12;
        Object object2 = this.c.i;
        String string2 = ((UploadCEMediaInfo)object).a().e();
        String[] stringArray = new String[]{string2};
        ((ExoVideoView)object2).setVideoPath(stringArray);
        object2 = this.c.f;
        object = ((UploadCEMediaInfo)object).a().i();
        ((ThumbnailView)object2).U((String)object, l10, n10);
        object = (LinearLayoutManager)this.c.f.getLayoutManager();
        ThumbnailView thumbnailView2 = this.c.f;
        object2 = new VideoCropFragment$b(this, (LinearLayoutManager)object, l10);
        thumbnailView2.addOnScrollListener((RecyclerView$OnScrollListener)object2);
    }

    private boolean F(MediaMetadataRetriever object) {
        boolean bl2;
        String string2 = "0";
        boolean bl3 = string2.equals(object = object.extractMetadata(24));
        if (!bl3 && !(bl2 = (string2 = "180").equals(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ void G(VideoCropFragment videoCropFragment, ComposeParams$Resolution composeParams$Resolution) {
        videoCropFragment.C(composeParams$Resolution);
    }

    private /* synthetic */ void H(boolean bl2) {
        if (bl2) {
            this.V();
        } else {
            this.X();
        }
    }

    private /* synthetic */ void J(d d10) {
        int n10 = this.l;
        int n11 = -1;
        if (n10 == n11) {
            d10 = this.c.i;
            a2 a22 = new a2(this);
            long l10 = 50;
            d10.postDelayed(a22, l10);
        }
    }

    private /* synthetic */ void L(d d10) {
        this.m = false;
    }

    private /* synthetic */ Integer N(Long l10) {
        int n10 = this.c.i.getCurrentPosition();
        int n11 = this.i;
        return (int)((float)(n10 - n11) * 1.0f / 300000.0f * 100.0f);
    }

    private /* synthetic */ void P(Integer object) {
        ProgressBar progressBar = this.c.k;
        int n10 = (Integer)object;
        progressBar.setProgress(n10);
        int n11 = (Integer)object;
        int n12 = 100;
        if (n11 >= n12) {
            object = this.d;
            ((VideoCropFragment$c)object).c();
        }
    }

    private /* synthetic */ void R() {
        this.l = 0;
        this.d.c();
        this.c.i.c(1);
    }

    private /* synthetic */ void T(UploadCEMediaInfo uploadCEMediaInfo) {
        this.E(uploadCEMediaInfo);
    }

    private void V() {
        this.X();
        Object object = TimeUnit.MILLISECONDS;
        Object object2 = e.a.q0.c.a.c();
        object = z.o3(500L, (TimeUnit)((Object)object), (h0)object2);
        object2 = new v1(this);
        object = ((z)object).H3((o)object2);
        object2 = new y1(this);
        e2 e22 = e2.a;
        this.f = object = ((z)object).c((e.a.v0.g)object2, e22);
    }

    private void W() {
        j j10 = new j();
        Object object = new u1(this);
        j10 = j10.y((j$b)object);
        object = this.getChildFragmentManager();
        j10.q((FragmentManager)object);
    }

    private void X() {
        boolean bl2;
        e.a.s0.b b10 = this.f;
        if (b10 != null && !(bl2 = b10.isDisposed())) {
            b10 = this.f;
            b10.dispose();
        }
    }

    public static /* synthetic */ VideoCropFragment$c j(VideoCropFragment videoCropFragment) {
        return videoCropFragment.d;
    }

    public static /* synthetic */ oi k(VideoCropFragment videoCropFragment) {
        return videoCropFragment.c;
    }

    public static /* synthetic */ boolean l(VideoCropFragment videoCropFragment) {
        return videoCropFragment.k;
    }

    public static /* synthetic */ boolean m(VideoCropFragment videoCropFragment, boolean bl2) {
        videoCropFragment.k = bl2;
        return bl2;
    }

    public static /* synthetic */ j1 n(VideoCropFragment videoCropFragment) {
        return videoCropFragment.g;
    }

    public static /* synthetic */ void o(VideoCropFragment videoCropFragment) {
        videoCropFragment.W();
    }

    public static /* synthetic */ int p(VideoCropFragment videoCropFragment) {
        return videoCropFragment.i;
    }

    public static /* synthetic */ int q(VideoCropFragment videoCropFragment, int n10) {
        videoCropFragment.i = n10;
        return n10;
    }

    public static /* synthetic */ int r(VideoCropFragment videoCropFragment) {
        return videoCropFragment.j;
    }

    public static /* synthetic */ int s(VideoCropFragment videoCropFragment, int n10) {
        videoCropFragment.j = n10;
        return n10;
    }

    public static /* synthetic */ boolean t(VideoCropFragment videoCropFragment) {
        return videoCropFragment.m;
    }

    public static /* synthetic */ boolean u(VideoCropFragment videoCropFragment, boolean bl2) {
        videoCropFragment.m = bl2;
        return bl2;
    }

    public static /* synthetic */ ObservableBoolean v(VideoCropFragment videoCropFragment) {
        return videoCropFragment.e;
    }

    public static /* synthetic */ void w(VideoCropFragment videoCropFragment) {
        videoCropFragment.B();
    }

    public static /* synthetic */ void x(VideoCropFragment videoCropFragment) {
        videoCropFragment.X();
    }

    public static /* synthetic */ void y(VideoCropFragment videoCropFragment) {
        videoCropFragment.V();
    }

    public static /* synthetic */ String z(VideoCropFragment videoCropFragment) {
        return videoCropFragment.h;
    }

    public /* synthetic */ void I(boolean bl2) {
        this.H(bl2);
    }

    public /* synthetic */ void K(d d10) {
        this.J(d10);
    }

    public /* synthetic */ void M(d d10) {
        this.L(d10);
    }

    public /* synthetic */ Integer O(Long l10) {
        return this.N(l10);
    }

    public /* synthetic */ void Q(Integer n10) {
        this.P(n10);
    }

    public /* synthetic */ void S() {
        this.R();
    }

    public /* synthetic */ void U(UploadCEMediaInfo uploadCEMediaInfo) {
        this.T(uploadCEMediaInfo);
    }

    public int h() {
        return 2131558809;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (oi)viewDataBinding;
        this.c = viewDataBinding;
        Object object = this.e;
        ((oi)viewDataBinding).F((ObservableBoolean)object);
        viewDataBinding = this.c;
        object = this.g;
        ((oi)viewDataBinding).E((j1)object);
        viewDataBinding = this.c;
        object = new VideoCropFragment$c(this);
        ((oi)viewDataBinding).C((VideoCropFragment$c)object);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        if (n11 == 0) {
            NavController navController = NavHostFragment.findNavController(this);
            navController.popBackStack();
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (j1)d.v.i0.b.c(this.requireActivity()).get(j1.class);
        this.g = object;
    }

    public void onCreate(Bundle object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2;
        super.onCreate((Bundle)object);
        object = n2.b(this.getArguments()).c();
        this.h = object2 = object.a().e();
        object2 = object.a().f();
        MediaType mediaType = MediaType.VIDEO;
        if (object2 == mediaType && (l13 = (l12 = (l11 = (object = object.a()).d()) - (l10 = 300000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
            object = ComposeParams$Resolution.RESOLUTION_ORIGINAL;
            this.C((ComposeParams$Resolution)((Object)object));
        }
    }

    public void onDestroy() {
        this.c.i.F(true);
        this.X();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.B();
        this.d.c();
        this.g.c();
    }

    public void onStart() {
        super.onStart();
        MutableLiveData mutableLiveData = this.g.c;
        String string2 = d.v.f.i.g.m(this.requireContext(), 2131952579);
        mutableLiveData.setValue(string2);
        mutableLiveData = this.g.d;
        string2 = d.v.f.i.g.m(this.requireContext(), 2131951837);
        mutableLiveData.setValue(string2);
    }

    public void onViewCreated(View object, Bundle object2) {
        block28: {
            super.onViewCreated((View)object, (Bundle)object2);
            object = n2.b(this.getArguments()).c();
            this.c.D((UploadCEMediaInfo)object);
            object2 = ((UploadCEMediaInfo)object).a();
            long l10 = ((a)object2).d();
            long l11 = 300000L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 <= 0) {
                return;
            }
            this.D();
            object2 = this.c.f;
            Object object3 = new w1(this, (UploadCEMediaInfo)object);
            object2.post((Runnable)object3);
            object = ((UploadCEMediaInfo)object).a().e();
            object2 = new MediaMetadataRetriever();
            object3 = this.requireContext();
            object3 = object3.getContentResolver();
            object = Uri.parse((String)object);
            String string2 = "r";
            object = object3.openFileDescriptor((Uri)object, string2);
            if (object == null) break block28;
            object = object.getFileDescriptor();
            object2.setDataSource((FileDescriptor)object);
            boolean bl2 = this.F((MediaMetadataRetriever)object2);
            int n10 = 18;
            object3 = object2.extractMetadata(n10);
            n10 = Integer.parseInt((String)object3);
            int bl3 = 19;
            object2 = object2.extractMetadata(bl3);
            l12 = Integer.parseInt((String)object2);
            int n11 = bl2 ? n10 : (int)l12;
            if (bl2) {
                n10 = (int)l12;
            }
            string2 = new Rational(n11, n10);
            object = new StringBuilder();
            l12 = string2.getNumerator();
            ((StringBuilder)object).append((int)l12);
            object2 = ":";
            ((StringBuilder)object).append((String)object2);
            l12 = string2.getDenominator();
            ((StringBuilder)object).append((int)l12);
            object = ((StringBuilder)object).toString();
            object2 = this.c;
            object2 = ((oi)object2).i;
            d.v.f.e.c.d((View)object2, (String)object);
            object = this.requireActivity();
            object = ((ComponentActivity)object).getOnBackPressedDispatcher();
            object2 = this.getViewLifecycleOwner();
            boolean bl4 = true;
            object3 = new VideoCropFragment$a(this, bl4);
            try {
                ((OnBackPressedDispatcher)object).addCallback((LifecycleOwner)object2, (OnBackPressedCallback)object3);
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }
}

