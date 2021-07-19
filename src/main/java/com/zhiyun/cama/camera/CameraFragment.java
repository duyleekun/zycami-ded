/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.Size
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.CheckedTextView
 *  android.widget.Chronometer
 *  android.widget.Chronometer$OnChronometerTickListener
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.SeekBar$OnSeekBarChangeListener
 *  android.widget.TextView
 */
package com.zhiyun.cama.camera;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckedTextView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Pair;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.zhiyun.android.CameraView;
import com.zhiyun.cama.album.AlbumActivity;
import com.zhiyun.cama.camera.CameraFragment$a;
import com.zhiyun.cama.camera.CameraFragment$b;
import com.zhiyun.cama.camera.CameraFragment$c;
import com.zhiyun.cama.camera.CameraFragment$d;
import com.zhiyun.cama.camera.CameraFragment$e;
import com.zhiyun.cama.camera.CameraFragment$f;
import com.zhiyun.cama.camera.CameraFragment$g;
import com.zhiyun.cama.camera.CameraFragment$h;
import com.zhiyun.cama.camera.CameraFragment$i;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$f;
import com.zhiyun.cama.camera.StackLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.ble.BleViewModel$MoveState;
import com.zhiyun.cama.camera.ble.BleViewModel$PanoramaState;
import com.zhiyun.cama.camera.data.CameraSet$CountDownTime;
import com.zhiyun.cama.camera.data.CameraSet$DelayInterval;
import com.zhiyun.cama.camera.data.CameraSet$DelayTime;
import com.zhiyun.cama.camera.data.CameraSet$Exception;
import com.zhiyun.cama.camera.data.CameraSet$Guide;
import com.zhiyun.cama.camera.data.CameraSet$HitchcockGuide;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$Panorama;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.camera.data.CameraSet$Theme;
import com.zhiyun.cama.camera.widget.HintLayout;
import com.zhiyun.cama.camera.widget.HintLayout$b;
import com.zhiyun.cama.camera.widget.ModeSwitch;
import com.zhiyun.cama.camera.widget.ModeSwitch$b;
import com.zhiyun.cama.camera.widget.MutiNodeProgress;
import com.zhiyun.cama.camera.widget.PartitionSeekBar;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import com.zhiyun.cama.camera.widget.TrackView;
import com.zhiyun.cama.camera.widget.TrackView$b;
import com.zhiyun.cama.camera.widget.TrackView$c;
import com.zhiyun.cama.data.database.model.CameraParam;
import com.zhiyun.common.util.Windows;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.image.Images;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.b.c0.e$a;
import d.v.c.i1.s2.q;
import d.v.c.m1.b;
import d.v.c.s0.a1;
import d.v.c.s0.a3;
import d.v.c.s0.a4;
import d.v.c.s0.a5;
import d.v.c.s0.a7.b1;
import d.v.c.s0.a7.d1;
import d.v.c.s0.a7.e1;
import d.v.c.s0.a7.i1;
import d.v.c.s0.a7.n1.a$a;
import d.v.c.s0.b0;
import d.v.c.s0.b2;
import d.v.c.s0.b3;
import d.v.c.s0.b4;
import d.v.c.s0.b5;
import d.v.c.s0.c0;
import d.v.c.s0.c2;
import d.v.c.s0.c3;
import d.v.c.s0.c4;
import d.v.c.s0.c5;
import d.v.c.s0.d0;
import d.v.c.s0.d2;
import d.v.c.s0.d3;
import d.v.c.s0.d4;
import d.v.c.s0.d5;
import d.v.c.s0.d7.u;
import d.v.c.s0.e2;
import d.v.c.s0.e3;
import d.v.c.s0.e4;
import d.v.c.s0.e5;
import d.v.c.s0.f;
import d.v.c.s0.f1;
import d.v.c.s0.f2;
import d.v.c.s0.f3;
import d.v.c.s0.f4;
import d.v.c.s0.f5;
import d.v.c.s0.g1;
import d.v.c.s0.g2;
import d.v.c.s0.g3;
import d.v.c.s0.g4;
import d.v.c.s0.g5;
import d.v.c.s0.h;
import d.v.c.s0.h1;
import d.v.c.s0.h2;
import d.v.c.s0.h3;
import d.v.c.s0.h4;
import d.v.c.s0.h5;
import d.v.c.s0.h7.i0;
import d.v.c.s0.h7.k0;
import d.v.c.s0.h7.k0$d;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.p0.p;
import d.v.c.s0.h7.r0.r;
import d.v.c.s0.h7.s0.y;
import d.v.c.s0.i;
import d.v.c.s0.i2;
import d.v.c.s0.i3;
import d.v.c.s0.i4;
import d.v.c.s0.i5;
import d.v.c.s0.j1;
import d.v.c.s0.j2;
import d.v.c.s0.j3;
import d.v.c.s0.j4;
import d.v.c.s0.j5;
import d.v.c.s0.k1;
import d.v.c.s0.k2;
import d.v.c.s0.k3;
import d.v.c.s0.k4;
import d.v.c.s0.k5;
import d.v.c.s0.l;
import d.v.c.s0.l1;
import d.v.c.s0.l2;
import d.v.c.s0.l3;
import d.v.c.s0.l4;
import d.v.c.s0.l5;
import d.v.c.s0.m;
import d.v.c.s0.m1;
import d.v.c.s0.m2;
import d.v.c.s0.m3;
import d.v.c.s0.m4;
import d.v.c.s0.m5;
import d.v.c.s0.n;
import d.v.c.s0.n1;
import d.v.c.s0.n2;
import d.v.c.s0.n3;
import d.v.c.s0.n4;
import d.v.c.s0.n5;
import d.v.c.s0.n6;
import d.v.c.s0.o;
import d.v.c.s0.o1;
import d.v.c.s0.o2;
import d.v.c.s0.o3;
import d.v.c.s0.o4;
import d.v.c.s0.o5;
import d.v.c.s0.p1;
import d.v.c.s0.p2;
import d.v.c.s0.p3;
import d.v.c.s0.p4;
import d.v.c.s0.p5;
import d.v.c.s0.q1;
import d.v.c.s0.q2;
import d.v.c.s0.q3;
import d.v.c.s0.q4;
import d.v.c.s0.q5;
import d.v.c.s0.r1;
import d.v.c.s0.r2;
import d.v.c.s0.r3;
import d.v.c.s0.r4;
import d.v.c.s0.r5;
import d.v.c.s0.r6;
import d.v.c.s0.s;
import d.v.c.s0.s1;
import d.v.c.s0.s2;
import d.v.c.s0.s3;
import d.v.c.s0.s4;
import d.v.c.s0.s5;
import d.v.c.s0.s6;
import d.v.c.s0.t;
import d.v.c.s0.t1;
import d.v.c.s0.t2;
import d.v.c.s0.t3;
import d.v.c.s0.t4;
import d.v.c.s0.t5;
import d.v.c.s0.t6;
import d.v.c.s0.u0;
import d.v.c.s0.u1;
import d.v.c.s0.u2;
import d.v.c.s0.u3;
import d.v.c.s0.u4;
import d.v.c.s0.u6;
import d.v.c.s0.v0;
import d.v.c.s0.v1;
import d.v.c.s0.v2;
import d.v.c.s0.v3;
import d.v.c.s0.v4;
import d.v.c.s0.v6;
import d.v.c.s0.w0;
import d.v.c.s0.w1;
import d.v.c.s0.w2;
import d.v.c.s0.w3;
import d.v.c.s0.w4;
import d.v.c.s0.w6;
import d.v.c.s0.x;
import d.v.c.s0.x1;
import d.v.c.s0.x2;
import d.v.c.s0.x3;
import d.v.c.s0.x4;
import d.v.c.s0.x6;
import d.v.c.s0.y0;
import d.v.c.s0.y1;
import d.v.c.s0.y2;
import d.v.c.s0.y3;
import d.v.c.s0.y4;
import d.v.c.s0.z0;
import d.v.c.s0.z1;
import d.v.c.s0.z2;
import d.v.c.s0.z3;
import d.v.c.s0.z4;
import d.v.c.v0.n.d;
import d.v.c.v0.u.z;
import d.v.c.w0.p0;
import d.v.c.w0.si;
import d.v.c.w0.x0;
import d.v.c.w0.yh;
import d.v.d.i.a.c$a;
import d.v.d.i.b.e;
import d.v.d.i.c.c;
import d.v.e.i.f$a;
import d.v.e.l.a2;
import d.v.e.l.m2$b;
import d.v.e.l.m2$d;
import d.v.f.g.b$b;
import d.v.f.g.b$c;
import d.v.f.i.g;
import d.v.g.g.c1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import e.a.a0;
import e.a.h0;
import e.a.j;
import e.a.k;
import e.a.q0.c.a;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CameraFragment
extends d.v.f.h.a {
    private static final String r0 = "1.3333";
    private static final String s0 = "1.7778";
    private static final int t0 = 2;
    private static final int u0 = 1000;
    private k0 A;
    private d.v.c.s0.h7.u0.j B;
    private i0 C;
    private e.a.s0.b D;
    private e.a.s0.b E;
    private e.a.s0.b F;
    private m2$d G;
    private m2$d H;
    private m2$d I;
    private CameraFragment$j J;
    private m2$d K;
    private e.a.s0.b L;
    private List M;
    private long N;
    private String O;
    private float P;
    private d.v.g0.k Q;
    private m2$d R;
    private String S;
    private d.v.c.s0.c7.p T;
    private u U;
    private si V;
    private p0 W;
    private d.v.c.s0.b7.k X;
    private yh Y;
    private boolean Z;
    private x0 b;
    private CameraView c;
    private TextView d;
    private int e;
    private int f;
    private int g;
    private int h;
    private d.v.f.f.e i;
    private int j = 3;
    private boolean k;
    private boolean k0;
    private u6 l;
    private m0 m;
    private d.v.c.s0.h7.u0.l n;
    private w6 o;
    private String o0;
    private BleViewModel p;
    private final DynamicZoomViewModel$f p0;
    private DeviceViewModel q;
    private Uri q0;
    private s6 r;
    private d.v.c.s0.a7.j1 s;
    private c1 t;
    private d.v.c.s0.d7.z u;
    private DynamicZoomViewModel v;
    private v6 w;
    private d.v.c.s0.f7.d x;
    private final d.v.c.s0.g7.e y;
    private final d.v.c.s0.g7.e z;

    public CameraFragment() {
        Object object = new d.v.c.s0.g7.e();
        this.y = object;
        object = new d.v.c.s0.g7.e();
        this.z = object;
        object = new ArrayList();
        this.M = object;
        this.P = 1.0f;
        this.T = object = new d.v.c.s0.c7.p();
        this.p0 = object = new CameraFragment$e(this);
    }

    public static /* synthetic */ BleViewModel A(CameraFragment cameraFragment) {
        return cameraFragment.p;
    }

    public static /* synthetic */ void A1(Boolean bl2) {
    }

    private /* synthetic */ void A4(DialogFragment dialogFragment) {
        this.S5();
    }

    private /* synthetic */ void A5(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2 && !(bl2 = ((w6)(object = this.o)).m()) && !(bl2 = ((d.v.c.s0.g7.e)(object = this.y)).c())) {
            RectF rectF;
            object = this.o;
            int n10 = this.j;
            Object object2 = this.b.L.getTrackArea();
            if ((object = ((w6)object).Q(n10, (RectF)object2, rectF = this.b.L.getCenterArea())) == null) {
                return;
            }
            Object object3 = (Integer)this.l.g0().getValue();
            n10 = d.v.e.h.d.c((Integer)object3);
            object2 = (CameraSet$Mode)((Object)this.l.H().getValue());
            if (n10 == 0 && object2 != (object3 = CameraSet$Mode.panorama)) {
                object3 = this.b.L;
                boolean bl3 = true;
                ((TrackView)((Object)object3)).f(bl3);
                object3 = this.b.L;
                ((TrackView)((Object)object3)).p();
                this.z6((RectF)object);
            }
        }
    }

    private void A6() {
        Chronometer chronometer = this.b.k.f;
        long l10 = SystemClock.elapsedRealtime();
        chronometer.setBase(l10);
        this.b.k.f.setFormat("00:%s");
        this.b.k.f.start();
        chronometer = this.b.k.f;
        b4 b42 = new b4(this);
        chronometer.setOnChronometerTickListener((Chronometer.OnChronometerTickListener)b42);
        chronometer = this.b.k.G;
        b42 = AnimationUtils.loadAnimation((Context)this.requireContext(), (int)2130771986);
        chronometer.startAnimation((Animation)b42);
    }

    public static /* synthetic */ void B(CameraFragment cameraFragment, CameraSet$Mode cameraSet$Mode) {
        cameraFragment.N6(cameraSet$Mode);
    }

    public static /* synthetic */ void B0(CameraFragment cameraFragment, RectF rectF) {
        cameraFragment.P6(rectF);
    }

    private /* synthetic */ void B1(Pair object) {
        Comparable<Boolean> comparable;
        int n10;
        if (object != null && (n10 = (comparable = (Boolean)((Pair)object).second).booleanValue()) != 0) {
            n10 = 1;
            Integer n11 = (Integer)((Pair)object).first;
            int n12 = n11;
            if (n10 == n12) {
                object = this.x.g;
                n10 = 2131953267;
                comparable = n10;
                ((d.v.e.i.j)object).setValue(comparable);
            } else {
                n10 = 2;
                object = (Integer)((Pair)object).first;
                int n13 = (Integer)object;
                if (n10 == n13) {
                    object = this.x.g;
                    n10 = 2131953269;
                    comparable = n10;
                    ((d.v.e.i.j)object).setValue(comparable);
                }
            }
            this.R5();
            object = this.x.f;
            n10 = 0;
            comparable = null;
            ((MutableLiveData)object).setValue(null);
        }
    }

    private /* synthetic */ void B2(Boolean object) {
        object = this.l;
        Object object2 = this.X;
        boolean bl2 = d.v.c.s0.b7.j.a((u6)object, (d.v.c.s0.b7.k)object2);
        if (bl2) {
            return;
        }
        object = this.l;
        bl2 = ((u6)object).o1();
        if (!bl2) {
            return;
        }
        object = this.o;
        bl2 = ((w6)object).o();
        if (bl2) {
            bl2 = true;
            this.J6(bl2, bl2);
        } else {
            object = s6.o((View)this.b.J);
            object2 = this.b.L;
            ((TrackView)((Object)object2)).setTrackArea((RectF)object);
        }
    }

    private /* synthetic */ void B3(Integer n10) {
        v6 v62 = this.w;
        int n11 = n10;
        v62.V(n11);
    }

    private void B6() {
        int n10;
        Object object = this.F;
        if (object != null) {
            object.dispose();
            n10 = 0;
            object = null;
            this.F = null;
        }
        if ((n10 = ((BleViewModel)(object = this.p)).G()) > 0) {
            object = this.r.i;
            Object object2 = this.getResources();
            int n11 = 2131951790;
            object2 = d.v.f.i.g.o(object2, n11);
            ((MutableLiveData)object).setValue(object2);
            object = this.r.j;
            object2 = Boolean.TRUE;
            ((MutableLiveData)object).setValue(object2);
        }
        this.p.i();
        this.b.k.F.clearAnimation();
        object = this.l;
        n10 = (int)(((u6)object).d1() ? 1 : 0);
        if (n10 != 0) {
            d.v.e.l.m2.a(this.G);
            this.b.k.q.h();
            object = this.p;
            ((BleViewModel)object).z1();
        }
    }

    public static /* synthetic */ yh C(CameraFragment cameraFragment) {
        return cameraFragment.Y;
    }

    private /* synthetic */ void C0(CameraSet$Guide cameraSet$Guide) {
        d.v.c.s0.c7.p p10;
        CameraSet$Guide cameraSet$Guide2;
        if (cameraSet$Guide != null && (cameraSet$Guide2 = CameraSet$Guide.FINISH) != cameraSet$Guide && (p10 = this.T) != null) {
            Context context = this.requireContext();
            x0 x02 = this.b;
            boolean bl2 = this.k;
            s6 s62 = this.r;
            int n10 = this.f;
            int n11 = this.e;
            int n12 = this.h;
            p10.q(cameraSet$Guide, context, x02, bl2, s62, n10, n11, n12);
        }
    }

    private /* synthetic */ void C4(DialogFragment object) {
        object = this.l.i0();
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
    }

    private /* synthetic */ void C5(Long number) {
        int n10;
        number = (Integer)this.s.b.getValue();
        int n11 = d.v.e.h.d.c((Integer)number);
        if (n11 < (n10 = 75)) {
            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
            int n12 = 5;
            int n13 = 15;
            n10 = threadLocalRandom.nextInt(n12, n13);
            MutableLiveData mutableLiveData = this.s.b;
            number = n11 += n10;
            mutableLiveData.setValue(number);
        }
    }

    private void C6() {
        LiveData liveData = this.l.f0();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        liveData.removeObservers(lifecycleOwner);
    }

    public static /* synthetic */ i0 D(CameraFragment cameraFragment) {
        return cameraFragment.C;
    }

    private /* synthetic */ void D1(Boolean object) {
        Boolean bl2 = Boolean.FALSE;
        boolean bl3 = (Boolean)object;
        if (bl3) {
            object = this.r;
            bl3 = ((s6)object).f();
            if (!bl3) {
                object = this.r.o;
                CameraSet$Guide cameraSet$Guide = CameraSet$Guide.START;
                ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
            } else {
                object = this.r;
                bl3 = ((s6)object).g();
                if (!bl3) {
                    object = this.r.o;
                    CameraSet$Guide cameraSet$Guide = CameraSet$Guide.SEVEN;
                    ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
                } else {
                    object = this.r.o;
                    CameraSet$Guide cameraSet$Guide = CameraSet$Guide.FINISH;
                    ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
                    object = this.r.p;
                    ((MutableLiveData)object).setValue(bl2);
                }
            }
            object = this.r.l;
            ((MutableLiveData)object).setValue(bl2);
        }
    }

    private /* synthetic */ void D2(Boolean bl2) {
        Object object = this.l;
        boolean bl3 = ((u6)object).M0();
        if (bl3 || (bl3 = ((u6)(object = this.l)).L0())) {
            object = this.c.getPreviewWt();
            ((d.v.d.i.f.z)object).s(bl2);
        }
    }

    public static /* synthetic */ void D3(CameraSet$Theme object) {
        CameraSet$Theme cameraSet$Theme;
        if (object != null && (cameraSet$Theme = CameraSet$Theme.DEFAULT) != object) {
            object = object.getSkinName();
            cameraSet$Theme = null;
            d.v.f.i.g.E((String)object, null);
        } else {
            d.v.f.i.g.F();
        }
    }

    private void D6() {
        e.a.s0.b b10 = this.D;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            this.D = null;
        }
    }

    public static /* synthetic */ c1 E(CameraFragment cameraFragment) {
        return cameraFragment.t;
    }

    private /* synthetic */ void E0(List list, int n10) {
        this.o.e(list);
    }

    private /* synthetic */ void E3(Boolean bl2) {
        v6 v62 = this.w;
        boolean bl3 = bl2;
        boolean bl4 = d.v.e.h.a.c((Boolean)this.l.T().getValue());
        v62.X(bl3, bl4);
    }

    private /* synthetic */ void E4(int n10) {
        this.z.g(n10);
    }

    private /* synthetic */ void E5() {
        this.w.g.setValue(null);
    }

    private void E6() {
        this.l.h2(false);
        this.b.b.setChecked(false);
        Object object = this.l.Y;
        Object object2 = CameraSet$Mode.story;
        int n10 = object.indexOf(object2);
        object2 = this.b.E;
        int n11 = ((ModeSwitch)object2).getSelected();
        if (n11 != n10) {
            object = this.b.E;
            n11 = 1;
            ((ModeSwitch)object).setScrollEnable(n11 != 0);
        }
    }

    public static /* synthetic */ si F(CameraFragment cameraFragment) {
        return cameraFragment.V;
    }

    private /* synthetic */ void F1(Integer n10) {
        int n11 = n10;
        if (n11 > 0) {
            TextView textView = this.b.k.h;
            int n12 = n10;
            textView.setMaxWidth(n12);
            textView = this.b.k.i;
            int n13 = n10;
            textView.setMaxWidth(n13);
        }
    }

    private /* synthetic */ void F2(Boolean bl2) {
        Object object = this.l;
        boolean bl3 = ((u6)object).M0();
        if (bl3 || (bl3 = ((u6)(object = this.l)).L0())) {
            object = this.c.getPreviewWt();
            ((d.v.d.i.f.z)object).t(bl2);
        }
    }

    private void F6() {
        d.v.d.i.g.f f10 = this.c.getRecordControl();
        Integer n10 = 2;
        f10.n(n10);
    }

    public static /* synthetic */ boolean G(CameraFragment cameraFragment) {
        return cameraFragment.k;
    }

    private /* synthetic */ void G0(MotionEvent motionEvent, int n10) {
        this.b.L.onTouchEvent(motionEvent);
    }

    private /* synthetic */ void G3(Boolean bl2) {
        v6 v62 = this.w;
        boolean bl3 = this.l.L();
        boolean bl4 = bl2;
        v62.X(bl3, bl4);
    }

    private /* synthetic */ void G4(DialogFragment dialogFragment) {
        this.b.s.performClick();
    }

    private /* synthetic */ void G5(Chronometer object) {
        long l10 = SystemClock.elapsedRealtime();
        long l11 = object.getBase();
        l10 = (l10 - l11) / 1000L;
        object = this.b.k.A;
        Object object2 = this.l;
        int n10 = ((u6)object2).z0();
        object2 = ((u6)object2).x0(n10, l10);
        object.setText((CharSequence)object2);
        object = this.w;
        int n11 = this.l.z0();
        ((v6)object).e0(l10, n11);
        object = this.w;
        int n12 = (int)l10;
        ((v6)object).V(n12);
    }

    private void G6() {
        m2$d m2$d = this.K;
        if (m2$d != null) {
            m2$d.a();
        }
    }

    public static /* synthetic */ u6 H(CameraFragment cameraFragment) {
        return cameraFragment.l;
    }

    private /* synthetic */ void H1(Boolean bl2) {
        ModeSwitch modeSwitch = this.b.E;
        boolean bl3 = bl2;
        modeSwitch.setTouchable(bl3);
    }

    private /* synthetic */ void H2(Boolean object) {
        object = this.l;
        d.v.c.s0.b7.k k10 = this.X;
        boolean bl2 = d.v.c.s0.b7.j.a((u6)object, k10);
        if (bl2) {
            return;
        }
        this.M6();
    }

    private void H6() {
        this.b.k.e.stop();
        this.b.k.E.clearAnimation();
    }

    public static /* synthetic */ k0 I(CameraFragment cameraFragment) {
        return cameraFragment.A;
    }

    private /* synthetic */ void I0(Float f10, int n10) {
        float f11;
        d.v.d.i.f.z z10 = this.c.getPreviewWt();
        Object object = this.w;
        float f12 = f10.floatValue();
        ((v6)object).R(f12);
        object = this.w;
        f12 = ((Float)z10.e()).floatValue();
        float f13 = ((Float)z10.f()).floatValue();
        ((v6)object).T(f12, f13);
        object = this.l.a;
        Object object2 = (Float)z10.get();
        float f14 = ((Float)z10.e()).floatValue();
        float[] fArray = new float[]{f14, f11 = ((Float)z10.f()).floatValue()};
        ((x6)object).s((Float)object2, fArray);
        n10 = (int)(d.v.e.h.a.c((Boolean)this.w.c.getValue()) ? 1 : 0);
        object = this.r;
        object2 = this.l.I();
        float f15 = f10.floatValue();
        ((s6)object).c(n10 != 0, (CameraSet$Mode)((Object)object2), f15);
    }

    private /* synthetic */ void I3(CameraSet$DelayInterval cameraSet$DelayInterval) {
        v6 v62 = this.w;
        CameraSet$DelayTime cameraSet$DelayTime = this.l.b0();
        int n10 = this.l.Q().c();
        v62.i0(cameraSet$DelayInterval, cameraSet$DelayTime, n10);
    }

    private /* synthetic */ void I4() {
        Object object = this.getContext();
        k$b k$b = new k$b((Context)object);
        object = d.v.f.i.g.o(this.requireActivity().getResources(), 2131952626);
        k$b = (k$b)k$b.B((String)object);
        object = new x4(this);
        k$b = (k$b)((k$b)((k$b)k$b.w((d.v.f.f.a)object)).c()).s();
        object = this.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public static /* synthetic */ void I5(DialogFragment dialogFragment) {
    }

    private void I6() {
        k0 k02 = this.A;
        if (k02 != null) {
            k02.i0();
        }
    }

    public static /* synthetic */ d.v.c.s0.h7.u0.j J(CameraFragment cameraFragment) {
        return cameraFragment.B;
    }

    private /* synthetic */ void J1(CameraSet$Mode object) {
        int n10;
        int n11;
        Object object2;
        Object object3;
        Object object4 = CameraSet$Mode.live;
        if (object4 == object) {
            object4 = this.b.k0;
            boolean n12 = ((ViewStubProxy)object4).isInflated();
            if (!n12) {
                this.b.k0.getViewStub().inflate();
                object4 = (si)this.b.k0.getBinding();
                this.V = object4;
                object3 = this.getViewLifecycleOwner();
                ((ViewDataBinding)object4).setLifecycleOwner((LifecycleOwner)object3);
                object4 = this.U;
                object3 = this.b;
                object2 = this.J;
                ((u)object4).p((x0)object3, (CameraFragment$j)object2);
                this.X5();
            }
        } else {
            object4 = CameraSet$Mode.story;
            if (object4 == object) {
                object4 = this.b.K;
                boolean bl2 = ((ViewStubProxy)object4).isInflated();
                if (!bl2) {
                    this.b.K.getViewStub().inflate();
                    object4 = (yh)this.b.K.getBinding();
                    this.Y = object4;
                    object3 = this.getViewLifecycleOwner();
                    ((ViewDataBinding)object4).setLifecycleOwner((LifecycleOwner)object3);
                    object4 = this.B;
                    object3 = this.Y;
                    ((d.v.c.s0.h7.u0.j)object4).e((yh)object3);
                }
            } else {
                object4 = CameraSet$Mode.dolly_zoom;
                if (object4 == object && (object4 = this.X) == null) {
                    object4 = d.v.c.s0.b7.k.l();
                    this.X = object4;
                    object4 = this.getChildFragmentManager().beginTransaction();
                    n11 = 2131362465;
                    object2 = this.X;
                    object4 = ((FragmentTransaction)object4).add(n11, (Fragment)object2);
                    ((FragmentTransaction)object4).commit();
                }
            }
        }
        object4 = this.r.j;
        object3 = Boolean.TRUE;
        ((MutableLiveData)object4).setValue(object3);
        object4 = this.w;
        n11 = (int)(d.v.e.h.a.c((Boolean)this.r.j.getValue()) ? 1 : 0);
        ((v6)object4).Y((CameraSet$Mode)((Object)object), n11 != 0);
        object4 = this.l.Y;
        object3 = this.b.E;
        n11 = ((ModeSwitch)object3).getSelected();
        object4 = object4.get(n11);
        if (object != object4) {
            this.N6((CameraSet$Mode)((Object)object));
        }
        object4 = CameraSet$Mode.photograph;
        n11 = 0;
        object3 = null;
        if (object != object4 && object != (object4 = CameraSet$Mode.video) && (object != (object4 = CameraSet$Mode.panorama) || (object4 = this.l.k0().getValue()) == (object2 = CameraSet$Panorama.P_CLONE))) {
            object4 = this.l;
            ((u6)object4).c2(false);
        }
        if (object != (object4 = CameraSet$Mode.story)) {
            object4 = this.m;
            object2 = CameraSet$StoryState.NONE;
            ((m0)object4).g0((CameraSet$StoryState)((Object)object2));
        } else {
            object4 = this.p;
            ((BleViewModel)object4).q1(false);
        }
        boolean bl3 = d.v.e.h.a.c((Boolean)this.l.i0().getValue());
        boolean bl4 = true;
        boolean bl5 = bl3 ^ bl4;
        this.J6(bl4, bl5);
        object4 = this.b.k.w;
        object2 = CameraSet$Mode.panorama;
        if (object == object2) {
            object2 = this.getResources();
            n10 = 2131953257;
            object2 = d.v.f.i.g.o((Resources)object2, n10);
        } else {
            object2 = this.getResources();
            n10 = 2131953256;
            object2 = d.v.f.i.g.o((Resources)object2, n10);
        }
        object4.setText((CharSequence)object2);
        object4 = this.c.getMaskScale();
        object2 = this.l;
        Object object5 = this.c.getPreviewId();
        n10 = (int)(((d.v.d.i.f.l)object5).r() ? 1 : 0);
        boolean bl6 = ((u6)object2).n1((CameraSet$Mode)((Object)object), n10 != 0);
        ((d.v.b.c0.b)object4).l(bl6);
        object4 = this.l.I();
        object2 = CameraSet$Mode.dolly_zoom;
        if (object4 == object2) {
            int n12 = 3;
            this.h0(n12);
            object4 = this.v;
            int n13 = this.c.getWidth();
            object5 = this.c;
            n10 = object5.getHeight();
            ((DynamicZoomViewModel)object4).G(n13, n10);
            this.v.K();
            object4 = this.l;
            object2 = this.v;
            boolean bl7 = ((DynamicZoomViewModel)object2).S();
            boolean bl8 = ((u6)object4).T0((CameraSet$Mode)((Object)object), bl7);
            if (!bl8 && !(bl8 = ((s6)(object = this.r)).k())) {
                object = this.r.q;
                object4 = CameraSet$HitchcockGuide.START;
                ((MutableLiveData)object).setValue(object4);
            }
        } else {
            this.v.H(false);
            object = this.v.g;
            object4 = Boolean.FALSE;
            ((MutableLiveData)object).postValue(object4);
        }
        this.b.L.setSelectRectRed(false);
        this.g6();
    }

    private /* synthetic */ void J2(Boolean object) {
        CameraSet$Mode cameraSet$Mode;
        object = this.l.I();
        if (object == (cameraSet$Mode = CameraSet$Mode.dolly_zoom)) {
            return;
        }
        this.L6();
    }

    private /* synthetic */ void J5(Chronometer chronometer) {
        long l10 = SystemClock.elapsedRealtime();
        long l11 = chronometer.getBase();
        int n10 = (int)((l10 - l11) / 1000L);
        this.w.V(n10);
    }

    private void J6(boolean bl2, boolean bl3) {
        Object object;
        AndroidViewModel androidViewModel = this.l;
        boolean bl4 = ((u6)androidViewModel).j0();
        if (bl4) {
            this.q6();
        }
        androidViewModel = this.o;
        ((w6)androidViewModel).Y();
        if (bl2) {
            object = this.b.L;
            ((TrackView)((Object)object)).a();
        }
        if (bl2 = ((w6)(object = this.o)).m()) {
            object = this.o;
            ((w6)object).V();
        }
        this.o.X();
        object = this.p;
        ((BleViewModel)object).B1();
        if (bl3) {
            object = this.c.getPreviewFace();
            bl3 = false;
            ((d.v.d.i.f.h)object).m(false);
        }
    }

    public static /* synthetic */ boolean K(CameraFragment cameraFragment) {
        return cameraFragment.Y5();
    }

    private /* synthetic */ void K0(Integer object, int n10) {
        n10 = 5;
        int n11 = d.v.e.h.d.c((Integer)object);
        if (n10 == n11) {
            object = this.requireActivity();
            n n12 = new n(this);
            object.runOnUiThread((Runnable)n12);
        }
    }

    private /* synthetic */ void K3(CameraSet$DelayTime cameraSet$DelayTime) {
        v6 v62 = this.w;
        CameraSet$DelayInterval cameraSet$DelayInterval = this.l.Z();
        int n10 = this.l.Q().c();
        v62.i0(cameraSet$DelayInterval, cameraSet$DelayTime, n10);
    }

    private /* synthetic */ void K4() {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(null);
            textView = this.d;
            int n10 = 8;
            textView.setVisibility(n10);
        }
    }

    private void K6() {
        this.b.k.f.stop();
        this.b.k.G.clearAnimation();
    }

    public static /* synthetic */ int L(CameraFragment cameraFragment) {
        return cameraFragment.j;
    }

    private /* synthetic */ void L1(Boolean object) {
        object = CameraSet$Mode.delay_video;
        CameraSet$Mode cameraSet$Mode = this.l.I();
        if (object == cameraSet$Mode) {
            object = this.w;
            cameraSet$Mode = this.l.I();
            Boolean bl2 = (Boolean)this.r.j.getValue();
            boolean bl3 = d.v.e.h.a.c(bl2);
            ((v6)object).Y(cameraSet$Mode, bl3);
        }
    }

    private /* synthetic */ void L2(Boolean object) {
        object = this.l;
        d.v.c.s0.b7.k k10 = this.X;
        boolean bl2 = d.v.c.s0.b7.j.a((u6)object, k10);
        if (bl2) {
            return;
        }
        this.R();
    }

    private /* synthetic */ void L5() {
        this.b.L.setSelectRectRed(false);
        boolean bl2 = true;
        this.J6(bl2, bl2);
    }

    private void L6() {
        u6 u62 = this.l;
        int n10 = (int)(u62.L() ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        n10 = this.c.getPreviewId().r();
        this.l.J1(n10);
    }

    public static /* synthetic */ x0 M(CameraFragment cameraFragment) {
        return cameraFragment.b;
    }

    private /* synthetic */ void M0(CompoundButton compoundButton, boolean bl2) {
        this.l.c2(bl2);
    }

    private /* synthetic */ void M3(Pair pair) {
        this.w.W(pair);
    }

    public static /* synthetic */ void M4(DialogFragment dialogFragment) {
    }

    private void M6() {
        Object object = this.l;
        boolean bl2 = ((u6)object).N0();
        if (bl2) {
            return;
        }
        object = this.U;
        bl2 = ((u)object).b0();
        if (bl2) {
            return;
        }
        object = this.l;
        bl2 = ((u6)object).L();
        if (bl2) {
            return;
        }
        this.r.d();
        object = this.l.I();
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.video;
        if (object == cameraSet$Mode) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        if (bl2) {
            cameraSet$Mode = CameraSet$Mode.photograph;
        }
        this.N6(cameraSet$Mode);
    }

    public static /* synthetic */ void N(CameraFragment cameraFragment) {
        cameraFragment.Q5();
    }

    private /* synthetic */ void N1(Integer object) {
        u6 u62;
        boolean bl2 = true;
        CameraSet$Mode cameraSet$Mode = null;
        this.J6(bl2, false);
        this.c.getPreviewId().y((Integer)object);
        v6 v62 = this.w;
        boolean bl3 = ((Integer)object).intValue();
        if (bl2 != bl3) {
            bl2 = false;
            u62 = null;
        }
        v62.S(bl2);
        object = this.c.getMaskScale();
        u62 = this.l;
        cameraSet$Mode = u62.I();
        boolean bl4 = this.c.getPreviewId().r();
        bl2 = u62.n1(cameraSet$Mode, bl4);
        ((d.v.b.c0.b)object).l(bl2);
    }

    private /* synthetic */ void N2(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        n10 = n10 != 0 ? 2131231582 : 2131231575;
        ImageView imageView = this.b.w;
        Context context = this.requireContext();
        Drawable drawable2 = d.v.f.i.g.f(context, n10);
        imageView.setBackground(drawable2);
        drawable2 = this.b.v;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            string2 = null;
        }
        n11 = d.v.e.l.h2.b(4.0f);
        Images.H((ImageView)drawable2, string2, n11, 2131232234);
    }

    private /* synthetic */ void N4() {
        this.p.t.setValue("");
        MutableLiveData mutableLiveData = this.s.b;
        Constable constable = 100;
        mutableLiveData.setValue(constable);
        this.c0();
        mutableLiveData = this.s.a;
        constable = Boolean.FALSE;
        mutableLiveData.setValue(constable);
        this.T5();
    }

    private /* synthetic */ void N5(d.v.c.s0.z6.a a10) {
        this.l.I1(a10);
    }

    private void N6(CameraSet$Mode cameraSet$Mode) {
        this.U.g0(cameraSet$Mode);
        int n10 = this.l.Y.indexOf((Object)cameraSet$Mode);
        this.b.E.setSelected(n10);
    }

    public static /* synthetic */ void O(CameraFragment cameraFragment, int n10) {
        cameraFragment.h0(n10);
    }

    private /* synthetic */ void O0(View view) {
        this.b.b.performClick();
    }

    private /* synthetic */ void O3(Pair pair) {
        this.w.f0(pair);
    }

    private void O6() {
        Object object = this.p;
        boolean bl2 = ((BleViewModel)object).K();
        if (bl2) {
            this.p.e();
            object = this.z;
            ((d.v.c.s0.g7.e)object).a();
        } else {
            CameraSet$Panorama cameraSet$Panorama;
            bl2 = this.i6();
            if (bl2) {
                return;
            }
            object = this.l.k0().getValue();
            if (object == (cameraSet$Panorama = CameraSet$Panorama.P_CLONE)) {
                this.b6();
            } else {
                this.o6();
            }
        }
    }

    public static /* synthetic */ s6 P(CameraFragment cameraFragment) {
        return cameraFragment.r;
    }

    private /* synthetic */ void P1(Integer object, int n10) {
        object = this.l;
        n10 = (int)(this.c.getPreviewId().r() ? 1 : 0);
        ((u6)object).t1(n10 != 0);
        object = this.l;
        CameraSet$Mode cameraSet$Mode = (CameraSet$Mode)((Object)((u6)object).H().getValue());
        ((u6)object).N1(cameraSet$Mode);
    }

    private /* synthetic */ void P2(String object) {
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0) {
            n10 = this.u.l;
            d.v.e.l.n2.f((String)object, n10);
            object = this.l;
            n10 = 0;
            ((u6)object).o2(null);
        }
    }

    private /* synthetic */ void P4() {
        this.l.k2(false);
    }

    public static /* synthetic */ void P5(CameraFragment cameraFragment, String string2) {
        cameraFragment.S6(string2);
    }

    private void P6(RectF rectF) {
        int[] nArray = CameraFragment$i.a;
        CameraSet$Mode cameraSet$Mode = this.l.I();
        int n10 = cameraSet$Mode.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1)) {
            if (rectF == null) {
                this.Q6();
            }
        } else {
            this.Y(rectF);
        }
    }

    public static /* synthetic */ d.v.c.s0.d7.z Q(CameraFragment cameraFragment) {
        return cameraFragment.u;
    }

    private /* synthetic */ void Q0(View object) {
        object = this.v;
        if (object != null) {
            ((DynamicZoomViewModel)object).P();
        }
    }

    private /* synthetic */ void Q3(Boolean bl2) {
        v6 v62 = this.w;
        boolean bl3 = bl2;
        v62.s(bl3);
    }

    private void Q5() {
        boolean bl2 = true;
        this.J6(bl2, bl2);
        Object object = this.b.L;
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel = null;
        object.i(false);
        object = this.l.I();
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.dolly_zoom;
        if (object == cameraSet$Mode) {
            object = this.o;
            bl2 = ((w6)object).m();
            if (bl2) {
                object = this.o;
                ((w6)object).V();
            }
            this.v.H(false);
            this.v.l();
            object = this.c.getRecordStatus();
            bl2 = ((d.v.d.i.g.l)object).q();
            if (!bl2) {
                object = this.v.p();
                if (object == (dynamicZoomViewModel$TargetModel = DynamicZoomViewModel$TargetModel.FAR)) {
                    object = this.v;
                    ((DynamicZoomViewModel)object).P();
                } else {
                    object = this.v;
                    ((DynamicZoomViewModel)object).Q();
                }
            }
        }
    }

    private void Q6() {
        this.b.L.r();
        Object object = TimeUnit.MILLISECONDS;
        object = e.a.a.T0(1500L, (TimeUnit)((Object)object));
        Object object2 = a.c();
        object = ((e.a.a)object).t0((h0)object2);
        object2 = d.q.a.d.a(d.q.a.f0.f.b.h(this));
        object = (d.q.a.t)((e.a.a)object).s((e.a.b)object2);
        object2 = new r3(this);
        object.k((e.a.v0.a)object2);
    }

    private void R() {
        Object object = (Boolean)this.l.K().getValue();
        Object object2 = this.l.I();
        if (object != null && object2 != null) {
            Object object3 = CameraFragment$i.a;
            int n10 = object2.ordinal();
            n10 = object3[n10];
            long l10 = 1000L;
            int n11 = 1;
            switch (n10) {
                default: {
                    break;
                }
                case 9: {
                    object2 = this.y;
                    n10 = (int)(((d.v.c.s0.g7.e)object2).c() ? 1 : 0);
                    if (n10 != 0) {
                        this.y.a();
                        return;
                    }
                    boolean object4 = (Boolean)object;
                    if (object4) {
                        boolean bl2;
                        boolean n15;
                        int n12;
                        long l11 = System.currentTimeMillis();
                        long l12 = this.N;
                        long l13 = (l11 -= l12) - l10;
                        Object bl22 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                        if (bl22 < 0) {
                            return;
                        }
                        object = this.c.getRecordStatus();
                        boolean object5 = ((d.v.d.i.g.l)object).q();
                        if (object5) {
                            this.F6();
                            this.K6();
                        }
                        if ((n12 = d.v.e.h.d.c((Integer)(object = (Integer)this.l.g0().getValue()))) == n11 && (n15 = d.v.e.h.a.c((Boolean)(object = (Boolean)this.l.i0().getValue())))) {
                            object = this.b.k.w;
                            object.setVisibility(0);
                        }
                        if (!(bl2 = ((w6)(object = this.o)).m())) break;
                        this.J6(n11 != 0, false);
                        object = this.o;
                        ((w6)object).V();
                        break;
                    }
                    this.s6();
                    break;
                }
                case 8: {
                    object = this.l;
                    boolean bl3 = ((u6)object).U();
                    if (bl3) {
                        return;
                    }
                    object = this.m;
                    object2 = CameraSet$Mode.story;
                    object3 = (Object)((m0)object).v();
                    boolean bl4 = ((m0)object).K((CameraSet$Mode)((Object)object2), (CameraSet$StoryState)((Object)object3));
                    if (!bl4) break;
                    this.X();
                    break;
                }
                case 7: {
                    object = this.U;
                    ((u)object).Q();
                    break;
                }
                case 6: {
                    boolean bl5 = (Boolean)object;
                    if (bl5) {
                        long l14 = System.currentTimeMillis();
                        long l15 = this.N;
                        long l16 = (l14 -= l15) - l10;
                        Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                        if (object4 < 0) {
                            return;
                        }
                        this.F6();
                        this.H6();
                        break;
                    }
                    boolean bl6 = this.i6();
                    if (bl6) {
                        return;
                    }
                    this.x6();
                    this.u6();
                    break;
                }
                case 5: {
                    boolean bl7 = (Boolean)object;
                    if (bl7) {
                        long l17 = System.currentTimeMillis();
                        long l18 = this.N;
                        long l19 = (l17 -= l18) - l10;
                        Object object5 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                        if (object5 < 0) {
                            return;
                        }
                        this.F6();
                        this.B6();
                        break;
                    }
                    boolean bl8 = this.i6();
                    if (bl8) {
                        return;
                    }
                    object = this.p;
                    int n12 = ((BleViewModel)object).G();
                    if (n11 == n12) {
                        object = this.l;
                        object2 = this.getResources();
                        int n13 = 2131951826;
                        object2 = d.v.f.i.g.o((Resources)object2, n13);
                        ((u6)object).o2((String)object2);
                        break;
                    }
                    object = this.p;
                    int n14 = ((BleViewModel)object).G();
                    if (n14 > n11) {
                        object = this.p;
                        object2 = this.l.b0();
                        long l20 = ((CameraSet$DelayTime)((Object)object2)).getTime();
                        ((BleViewModel)object).v1(l20);
                        break;
                    }
                    this.p6();
                    this.u6();
                    break;
                }
                case 3: {
                    this.o6();
                    break;
                }
                case 2: {
                    this.O6();
                    break;
                }
                case 1: {
                    n10 = (int)(d.v.c.x1.n.d() ? 1 : 0);
                    if (n10 != 0) {
                        return;
                    }
                    object2 = this.v;
                    n10 = (int)(((DynamicZoomViewModel)object2).u() ? 1 : 0);
                    if (n10 == 0 && (n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0)) == 0) {
                        object = this.requireContext();
                        object3 = new Object[n11];
                        Integer n15 = this.j;
                        object3[0] = n15;
                        object = d.v.e.l.o1.M((Context)object, 2131952649, object3);
                        n10 = this.j;
                        d.v.e.l.n2.f((String)object, n10);
                        return;
                    }
                    object2 = this.v.g;
                    Boolean bl9 = Boolean.FALSE;
                    ((MutableLiveData)object2).postValue(bl9);
                    boolean bl10 = (Boolean)object;
                    if (bl10) {
                        long l21 = System.currentTimeMillis();
                        long l22 = this.N;
                        long l23 = (l21 -= l22) - l10;
                        Object object6 = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
                        if (object6 < 0) {
                            return;
                        }
                        object = this.c.getRecordStatus();
                        boolean bl11 = ((d.v.d.i.g.l)object).q();
                        if (bl11) {
                            this.F6();
                            this.K6();
                        }
                        boolean bl12 = this.l.j0() ^ n11;
                        this.J6(n11 != 0, bl12);
                        object = this.o;
                        boolean bl13 = ((w6)object).m();
                        if (bl13) {
                            object = this.o;
                            ((w6)object).V();
                        }
                        if ((object = this.l.I()) == (object2 = CameraSet$Mode.dolly_zoom)) {
                            object = this.v;
                            ((DynamicZoomViewModel)object).H(false);
                        }
                        this.v.A();
                        object = this.c.getPreviewWt();
                        object2 = Float.valueOf(this.P);
                        ((d.v.d.i.f.z)object).x((Float)object2);
                        object = this.c.getPreviewFocus();
                        object2 = n11;
                        ((d.v.d.i.f.j)object).o((Integer)object2);
                        object = this.v.t();
                        object2 = Float.valueOf(this.P);
                        ((MutableLiveData)object).postValue(object2);
                        object = this.v;
                        float f10 = this.P;
                        ((DynamicZoomViewModel)object).J(f10);
                        object = b1.y(this.S);
                        object2 = this.getChildFragmentManager();
                        ((d.v.f.g.b)object).q((FragmentManager)object2);
                        object = this.v.c;
                        object2 = 0;
                        ((MutableLiveData)object).postValue(object2);
                        break;
                    }
                    object = this.v.h;
                    object2 = Boolean.TRUE;
                    ((MutableLiveData)object).postValue(object2);
                    object = this.v.c;
                    object2 = 0;
                    ((MutableLiveData)object).postValue(object2);
                    object = this.l;
                    ((u6)object).j2(n11 != 0);
                    this.u6();
                    this.A6();
                }
            }
        }
    }

    private /* synthetic */ void R1(Integer constable) {
        d.v.b.b0.k.h h10 = this.c.getBeautySwitch();
        int n10 = constable;
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            constable = null;
        }
        constable = Boolean.valueOf(n10 != 0);
        h10.p((Boolean)constable);
    }

    private /* synthetic */ void R2(Integer object) {
        int n10;
        Object object2 = this.getResources();
        object = d.v.f.i.g.o(object2, n10 = ((Integer)object).intValue());
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 == 0) {
            object2 = this.u;
            n11 = object2.l;
            d.v.e.l.n2.f((String)object, n11);
        }
    }

    private /* synthetic */ void R4() {
        this.l.k2(true);
    }

    private void R5() {
        CameraSet$Mode cameraSet$Mode;
        d.v.c.s0.f7.d d10 = this.x;
        u6 u62 = this.l;
        boolean bl2 = u62.L();
        boolean bl3 = d10.f(bl2, cameraSet$Mode = this.l.I());
        if (bl3) {
            d10 = this.b.b;
            d10.performClick();
        }
    }

    private void R6() {
        d.v.c.s0.z6.a a10 = new d.v.c.s0.z6.a();
        Object object = this.c.getPhotoSize().p();
        a10.d = object;
        object = this.c.getRecordSize().q();
        a10.c = object;
        object = this.c.getPreviewWbType().o();
        a10.a = object;
        object = this.c.getPreviewFlash().n();
        a10.b = object;
        object = this.requireActivity();
        p1 p12 = new p1(this, a10);
        object.runOnUiThread((Runnable)p12);
    }

    private void S() {
        e.a.s0.b b10 = this.E;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            this.E = null;
        }
    }

    private /* synthetic */ void S0(View object) {
        object = this.v;
        if (object != null) {
            ((DynamicZoomViewModel)object).Q();
        }
    }

    private /* synthetic */ void S3(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.w;
            CameraView cameraView = this.c;
            ((v6)object).k0(cameraView);
        } else {
            object = this.w.d;
            Object object2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(object2);
            object = this.w;
            object2 = this.c;
            ((v6)object).m0((CameraView)object2);
            object = this.getLifecycle().getCurrentState();
            object2 = Lifecycle$State.RESUMED;
            bl2 = ((Lifecycle$State)((Object)object)).isAtLeast((Lifecycle$State)((Object)object2));
            if (bl2) {
                object = this.w;
                object2 = (Boolean)((v6)object).y().getValue();
                boolean bl3 = d.v.e.h.a.c((Boolean)object2);
                boolean bl4 = d.v.c.m1.b.a();
                ((v6)object).o(bl3, bl4);
            }
        }
    }

    private void S5() {
        this.S();
        Object object = TimeUnit.MINUTES;
        object = e.a.z.O6(5, (TimeUnit)((Object)object));
        Object object2 = e.a.c1.b.d();
        object = ((e.a.z)object).L5((h0)object2);
        object2 = a.c();
        object = ((e.a.z)object).i4((h0)object2);
        object2 = d.q.a.d.a(d.q.a.f0.f.b.h(this));
        object = (d.q.a.y)((e.a.z)object).q((a0)object2);
        object2 = new o5(this);
        this.E = object = object.d((e.a.v0.g)object2);
    }

    private void S6(String object) {
        Object object2 = this.c.getPreviewStatus();
        boolean n10 = ((d.v.d.i.f.u)object2).o();
        if (n10) {
            this.c.getPhotoSize().t((String)object);
            object = this.c.getCameraUpdate();
            int n11 = 4;
            object2 = n11;
            ((e)object).n((Integer)object2);
            this.c.a();
            object = this.c;
            ((CameraView)object).c();
        }
    }

    private void T() {
        p2 p22 = new p2(this);
        d.v.e.l.m2.Y(500L, p22);
    }

    private /* synthetic */ void T1(Float f10) {
        this.c.getBeautyCheek().o(f10);
    }

    private /* synthetic */ void T2(Integer object) {
        int n10;
        Object object2 = this.getResources();
        object = d.v.f.i.g.o(object2, n10 = ((Integer)object).intValue());
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 == 0) {
            object2 = this.u;
            n11 = object2.l;
            d.v.e.l.n2.f((String)object, n11);
        }
    }

    private /* synthetic */ void T4() {
        MutableLiveData mutableLiveData = this.r.n;
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
    }

    private void T5() {
        this.E6();
        this.D6();
        this.l.s1();
    }

    private void U(CameraSet$Mode cameraSet$Mode) {
        int n10;
        this.l.N1(cameraSet$Mode);
        d.v.e.l.m2.a(this.I);
        Object object = this.r.n;
        Object object2 = CameraSet$Mode.story;
        int n11 = 1;
        if (object2 != cameraSet$Mode && (object2 = CameraSet$Mode.live) != cameraSet$Mode) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        object2 = n10 != 0;
        ((MutableLiveData)object).setValue(object2);
        object = this.r.m;
        object2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(object2);
        long l10 = 2000L;
        h1 h12 = new h1(this, cameraSet$Mode);
        this.I = object = d.v.e.l.m2.Y(l10, h12);
        this.p.i();
        object = this.u;
        object2 = CameraSet$Mode.live;
        if (object2 != cameraSet$Mode) {
            n11 = 0;
        }
        ((d.v.c.s0.d7.z)object).y0(n11);
    }

    private /* synthetic */ void U0(View object) {
        object = this.v;
        if (object != null) {
            ((DynamicZoomViewModel)object).l();
        }
    }

    private /* synthetic */ void U3(Boolean object) {
        boolean bl2 = (Boolean)object;
        this.d6(bl2);
        ViewModel viewModel = this.w;
        boolean bl3 = (Boolean)object;
        ((v6)viewModel).U(bl3);
        viewModel = this.p;
        bl3 = (Boolean)object;
        boolean bl4 = true;
        ((BleViewModel)viewModel).r1(bl3 ^= bl4);
        boolean bl5 = (Boolean)object;
        if (bl5) {
            this.J6(bl4, bl4);
            object = this.l;
            bl2 = false;
            viewModel = null;
            ((u6)object).c2(false);
            object = this.r;
            ((s6)object).d();
        }
    }

    private void U5(String string2) {
        this.d.setVisibility(0);
        this.d.setText((CharSequence)string2);
        string2 = this.d;
        float f10 = 1.0f;
        string2.setAlpha(f10);
        this.d.setScaleX(f10);
        this.d.setScaleY(f10);
        string2 = this.d.animate().alpha(0.4f);
        f10 = 0.67f;
        string2 = string2.scaleX(f10).scaleY(f10).setDuration(900L).withLayer();
        s s10 = new s(this);
        string2.withEndAction((Runnable)s10);
    }

    private void V() {
        int n10 = this.Z;
        if (n10 == 0) {
            return;
        }
        Object object = this.x;
        Object object2 = this.requireActivity();
        ((d.v.c.s0.f7.d)object).p((FragmentActivity)object2);
        object = r6.b();
        object2 = this.getContext();
        ((r6)object).d((Context)object2);
        object = this.l;
        object2 = ((u6)object).Y;
        object = ((u6)object).I();
        n10 = object2.indexOf(object);
        int n11 = -1;
        if (n10 > n11) {
            object2 = this.b.E;
            l l10 = new l(this, n10);
            object2.post((Runnable)l10);
        }
        object = this.l.I();
        object2 = CameraSet$Mode.story;
        boolean bl2 = true;
        if (object != object2) {
            object = this.i;
            object.enable();
        } else {
            Object object3;
            object = this.m;
            n10 = (int)(((m0)object).z() ? 1 : 0);
            if (n10 != 0 && (n10 = (int)(((m0)(object = this.m)).K((CameraSet$Mode)((Object)object2), (CameraSet$StoryState)((Object)(object3 = ((m0)object).v()))) ? 1 : 0)) != 0) {
                object = this.C;
                object2 = this.Y;
                object3 = this.m;
                int n12 = ((m0)object3).j();
                ((i0)object).o((yh)object2, n12, bl2);
            }
        }
        object = this.w;
        object2 = this.c;
        ((v6)object).k0((CameraView)object2);
        this.p.u1();
        this.r.I();
        object = this.b.k0;
        n10 = (int)(((ViewStubProxy)object).isInflated() ? 1 : 0);
        if (n10 != 0) {
            object = this.U;
            object2 = this.V.c.b.getText().toString();
            ((u)object).Z((String)object2);
            object = this.U;
            ((u)object).V();
        }
        if ((object = CameraSet$Guide.FINISH) == (object2 = this.r.o.getValue())) {
            object = this.w;
            ((v6)object).s(bl2);
        }
    }

    private /* synthetic */ void V1(Float f10) {
        this.c.getBeautySkin().o(f10);
    }

    private /* synthetic */ void V2(Integer object) {
        int n10;
        Object object2 = this.getResources();
        object = d.v.f.i.g.o(object2, n10 = ((Integer)object).intValue());
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 == 0) {
            object2 = this.u;
            n11 = object2.l;
            d.v.e.l.n2.f((String)object, n11);
        }
    }

    private /* synthetic */ void V4(Integer n10) {
        u6 u62 = this.l;
        int n11 = n10;
        u62.p2(n11);
    }

    private void V5(View view, int n10, int n11) {
        float f10 = n10;
        f10 = n11;
        float[] fArray = new float[]{f10, f10};
        ObjectAnimator.ofFloat((Object)view, (String)"rotation", (float[])fArray).setDuration(0L).start();
    }

    private void W() {
        this.Z5();
        this.a6();
        this.X5();
        this.r.J();
    }

    private /* synthetic */ void W0(d.v.n.j.b b10) {
        int n10;
        if (b10 == null) {
            return;
        }
        int n11 = b10.g();
        int n12 = b10.z();
        if (n12 == (n10 = 480)) {
            return;
        }
        d.v.d.i.g.k k10 = this.c.getRecordSize();
        Size size = new Size(n11, n12);
        d.v.d.i.g.k$a k$a = new d.v.d.i.g.k$a(size, "");
        k10.z(k$a);
    }

    private /* synthetic */ void W3(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.w6();
        } else {
            this.G6();
        }
    }

    private void W5(ViewGroup viewGroup, int n10, int n11) {
        int n12;
        for (int i10 = 0; i10 < (n12 = viewGroup.getChildCount()); ++i10) {
            Object object;
            int n13;
            View view = viewGroup.getChildAt(i10);
            int n14 = view.getId();
            if (n14 == (n13 = (object = this.b.a).getId()) || (n14 = view.getId()) == (n13 = (object = this.b.E).getId()) || (n14 = view.getId()) == (n13 = (object = this.b.C).getId()) || (n14 = view.getId()) == (n13 = (object = this.b.Q).getId()) || (n14 = view.getId()) == (n13 = (object = this.b.e).getId()) || (n14 = view.getId()) == (n13 = (object = this.b.f).getId()) || (n14 = view.getId()) == (n13 = (object = this.b.R).getId()) || (n14 = view.getId()) == (n13 = (object = this.b.X).getId()) || (n14 = view.getId()) == (n13 = (object = this.b.h).getId()) || (n14 = view.getId()) == (n13 = (object = this.b.L).getId())) continue;
            n14 = view instanceof ViewGroup;
            if (n14 != 0) {
                n14 = view.getId();
                if (n14 != (n13 = (object = this.b.A).getId()) && (n14 = view.getId()) != (n13 = (object = this.b.k.getRoot()).getId()) && (n14 = view.getId()) != (n13 = (object = this.b.D).getId()) && (n14 = view.getId()) != (n13 = (object = this.b.B).getId())) {
                    n14 = view.getId();
                    if ((n14 = (int)(this.n0(n14) ? 1 : 0)) == 0 && (n14 = view.getId()) != (n13 = (object = this.b.H).getId()) && (n14 = view.getId()) != (n13 = (object = this.b.j).getId()) && (n14 = view.getId()) != (n13 = (object = this.b.k.g).getId())) {
                        view = (ViewGroup)view;
                        this.W5((ViewGroup)view, n10, n11);
                        continue;
                    }
                }
                this.V5(view, n10, n11);
                u u10 = this.U;
                object = this.b;
                u10.h((x0)object, view, n10, n11);
                continue;
            }
            this.V5(view, n10, n11);
        }
    }

    private void X() {
        boolean bl2 = this.m0();
        if (bl2) {
            this.I6();
        } else {
            this.y6();
        }
    }

    private /* synthetic */ void X1(Float f10) {
        this.c.getBeautyWhite().o(f10);
    }

    private /* synthetic */ void X2(Integer object) {
        int n10;
        int n11 = (Integer)object;
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                this.b.L.i(false);
                object = this.c.getPreviewFocus();
                n10 = 6;
                Integer n12 = n10;
                ((d.v.d.i.f.j)object).o(n12);
            }
        } else {
            object = this.c.getPreviewFocus();
            n10 = 5;
            Integer n13 = n10;
            ((d.v.d.i.f.j)object).o(n13);
        }
    }

    private /* synthetic */ void X4(DialogFragment dialogFragment) {
        this.w.n();
    }

    private void X5() {
        ConstraintLayout constraintLayout;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14 = this.k;
        int n15 = 90;
        int n16 = 0;
        if (n14 != 0) {
            n14 = -90;
            n13 = n15;
            n15 = 0;
            n12 = 0;
            n11 = -180;
            n10 = 0;
        } else {
            n10 = n15;
            n12 = n15;
            n13 = 0;
            n11 = 0;
            n15 = 180;
            n14 = 0;
            constraintLayout = null;
        }
        ConstraintLayout constraintLayout2 = this.b.d;
        this.W5(constraintLayout2, n10, n14);
        constraintLayout = this.b.C;
        this.V5((View)constraintLayout, n15, n11);
        while (n16 < (n14 = (constraintLayout = this.b.C).getChildCount())) {
            constraintLayout = this.b.C.getChildAt(n16);
            this.V5((View)constraintLayout, n12, n13);
            ++n16;
        }
    }

    private void Y(RectF object) {
        if (object == null) {
            object = this.b.L;
            boolean bl2 = true;
            object.setSelectRectRed(bl2);
            this.v.z();
            object = this.b.L;
            object.invalidate();
        } else {
            boolean bl3 = this.v.g((RectF)object);
            TrackView trackView = this.b.L;
            trackView.setSelectRectRed(bl3);
            Object object2 = this.v;
            object = ((DynamicZoomViewModel)object2).W((RectF)object);
            bl3 = object.c;
            if (bl3) {
                bl3 = object.a();
                if (bl3) {
                    object2 = this.v;
                    float f10 = object.d;
                    float f11 = object.e;
                    object = object.a;
                    d.v.c.s0.a a10 = new d.v.c.s0.a(this);
                    ((DynamicZoomViewModel)object2).V(f10, f11, (DynamicZoomViewModel$TargetModel)((Object)object), a10);
                } else {
                    object2 = object.a;
                    float f12 = object.e;
                    this.n6((DynamicZoomViewModel$TargetModel)((Object)object2), f12);
                }
            }
        }
    }

    private /* synthetic */ void Y0() {
        CameraSet$Mode cameraSet$Mode;
        boolean bl2 = d.v.e.h.a.c((Boolean)this.l.i0().getValue());
        boolean bl3 = true;
        this.J6(bl3, bl2 ^= bl3);
        Object object = this.o;
        bl2 = object.m();
        if (bl2) {
            object = this.o;
            object.V();
        }
        if ((object = this.l.I()) == (cameraSet$Mode = CameraSet$Mode.dolly_zoom)) {
            this.Q5();
        }
    }

    private /* synthetic */ void Y3(String object) {
        int n10;
        Object object2 = this.R;
        if (object2 != null) {
            ((m2$d)object2).a();
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)object)) == 0) {
            Object object3 = this.getContext();
            object2 = new k$b((Context)object3);
            object3 = this.getResources();
            int n11 = 2131951810;
            int n12 = 1;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object;
            object = d.v.f.i.g.p((Resources)object3, n11, objectArray);
            object = (k$b)((k$a)object2).B((String)object);
            n10 = 2131951811;
            object3 = new v2(this);
            object = (k$b)((k$a)object).v(n10, (d.v.f.f.a)object3);
            object2 = new c2(this);
            object = (k$b)((k$b)((k$b)((k$a)object).p((d.v.f.f.a)object2)).c()).s();
            object2 = this.getChildFragmentManager();
            this.Q = object = ((k$a)object).D((FragmentManager)object2);
            this.v6();
        } else {
            object = this.Q;
            if (object != null) {
                try {
                    ((DialogFragment)object).dismissAllowingStateLoss();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    private boolean Y5() {
        Object object = (Size)this.c.getPreviewSize().get();
        double d10 = object.getWidth();
        double d11 = object.getHeight();
        object = Locale.getDefault();
        Object[] objectArray = new Object[1];
        Double d12 = d10 /= d11;
        objectArray[0] = d12;
        return String.format((Locale)object, "%.4f", objectArray).equals(s0);
    }

    private boolean Z() {
        Object object = CameraSet$Mode.photograph;
        Object object2 = (CameraSet$Mode)((Object)this.l.H().getValue());
        if (object == object2) {
            object2 = (String)this.l.F().getValue();
            object = this.c.getPhotoSize().n();
            boolean bl2 = ((String)object).equals(object2);
            if (!bl2) {
                this.S6((String)object2);
                return true;
            }
        }
        return false;
    }

    private /* synthetic */ void Z1(Float f10) {
        this.c.getBeautyEye().o(f10);
    }

    private /* synthetic */ void Z2(Integer object) {
        int n10;
        TextView textView = this.b.k.w;
        int n11 = (Integer)object;
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                CameraSet$Mode cameraSet$Mode;
                object = this.l.H().getValue();
                if (object == (cameraSet$Mode = CameraSet$Mode.panorama)) {
                    object = this.getResources();
                    n10 = 2131953257;
                    object = d.v.f.i.g.o((Resources)object, n10);
                } else {
                    object = this.getResources();
                    n10 = 2131953256;
                    object = d.v.f.i.g.o((Resources)object, n10);
                }
                textView.setText((CharSequence)object);
                textView.setVisibility(0);
                object = this.c.getRecordStatus();
                n11 = (int)(((d.v.d.i.g.l)object).q() ? 1 : 0);
                if (n11 != 0) {
                    return;
                }
                this.S5();
            }
        } else {
            CameraSet$Panorama cameraSet$Panorama;
            int n12;
            this.S();
            object = this.c.getRecordStatus();
            n11 = (int)(((d.v.d.i.g.l)object).q() ? 1 : 0);
            if (n11 == 0 && (n11 = (int)(((BleViewModel)(object = this.p)).K() ? 1 : 0)) == 0) {
                object = this.y;
                n12 = 3;
                ((d.v.c.s0.g7.e)object).g(n12);
            }
            if ((object = this.l.k0().getValue()) != (cameraSet$Panorama = CameraSet$Panorama.P_CLONE)) {
                textView.setVisibility(4);
                return;
            }
            object = (Integer)this.l.g0().getValue();
            n11 = d.v.e.h.d.d((Integer)object, n12 = -1);
            if (n11 == 0) {
                object = this.getResources();
                n10 = 2131953174;
                object = d.v.f.i.g.o((Resources)object, n10);
                textView.setText((CharSequence)object);
            } else if (n11 == n10) {
                object = this.getResources();
                n10 = 2131952366;
                object = d.v.f.i.g.o((Resources)object, n10);
                textView.setText((CharSequence)object);
            }
        }
    }

    private /* synthetic */ void Z4(DialogFragment dialogFragment) {
        this.w.M();
    }

    private void Z5() {
        float f10;
        int n10;
        int n11;
        Object object;
        int n12 = this.k;
        int n13 = 1104150528;
        float f11 = 26.0f;
        int n14 = 0;
        float f12 = 0.0f;
        LinearLayout linearLayout = null;
        if (n12 != 0) {
            object = this.b.m;
            n11 = this.e;
            n10 = object.getHeight() * 2;
            n11 -= n10;
            n10 = d.v.e.l.h2.b(f11);
            f10 = n11 -= n10;
            object.setTranslationY(f10);
        } else {
            object = this.b.m;
            object.setTranslationY(0.0f);
        }
        n12 = this.k;
        if (n12 != 0) {
            n12 = this.b.B.getWidth() / 2;
            LinearLayout linearLayout2 = this.b.B;
            n11 = linearLayout2.getHeight() / 2;
            n12 -= n11;
            f10 = 62.0f;
            n11 = d.v.e.l.h2.b(f10);
            n10 = this.b.B.getLeft();
            n11 = n11 - n10 - n12;
            n12 = this.e / 2;
            LinearLayout linearLayout3 = this.b.B;
            n10 = linearLayout3.getHeight();
            n12 -= n10;
            n13 = d.v.e.l.h2.b(f11);
            LinearLayout linearLayout4 = this.b.B;
            float f13 = n12 -= n13;
            linearLayout4.setTranslationY(f13);
            object = this.b.B;
            f11 = n11;
            object.setTranslationX(f11);
        } else {
            this.b.B.setTranslationY(0.0f);
            object = this.b.B;
            object.setTranslationX(0.0f);
        }
        object = (Boolean)this.w.c.getValue();
        n12 = (int)(d.v.e.h.a.c((Boolean)object) ? 1 : 0);
        this.d6(n12 != 0);
        n12 = this.k;
        if (n12 != 0) {
            object = this.b.A;
            n13 = object.getWidth();
            n14 = this.b.A.getHeight();
            f11 = -(n13 - n14) >> 1;
            object.setTranslationX(f11);
            object = this.b.A;
            n13 = this.e;
            f12 = 4.0f;
            n14 = d.v.e.l.h2.b(f12);
            n13 += n14;
            n14 = this.b.A.getWidth();
            n13 -= n14;
            linearLayout = this.b.A;
            n14 = linearLayout.getHeight();
            f11 = n13 - n14;
            object.setTranslationY(f11);
            object = this.b.j;
            f11 = d.v.e.l.h2.b(38.0f);
            object.setTranslationX(f11);
            object = this.b.j;
            n13 = -d.v.e.l.h2.b(22.0f);
            f11 = n13;
            object.setTranslationY(f11);
        } else {
            this.b.A.setTranslationX(0.0f);
            this.b.A.setTranslationY(0.0f);
            this.b.j.setTranslationX(0.0f);
            object = this.b.j;
            object.setTranslationY(0.0f);
        }
        object = this.b.D;
        this.c6((View)object);
        object = this.b.k.m;
        this.e6((View)object, 70);
    }

    private float a0() {
        return ((Float)this.c.getPreviewWt().get()).floatValue();
    }

    private /* synthetic */ void a1(View view) {
        this.R();
    }

    private /* synthetic */ void a4(Boolean bl2) {
        this.b.b.performClick();
    }

    private void a6() {
        int n10 = this.k;
        n10 = n10 != 0 ? this.e * 2 / 3 : this.e;
        this.b.k.z.setMaxWidth(n10);
    }

    private Bitmap b0() {
        float f10 = this.o.l();
        int n10 = this.c.getTextureSize().o();
        int n11 = (int)((float)this.c.getTextureSize().p() * f10);
        int n12 = (int)((float)n10 * f10);
        return this.c.e(n11, n12);
    }

    private /* synthetic */ void b2(Float f10) {
        this.c.getBeautyLight().o(f10);
    }

    private /* synthetic */ void b3(RectF rectF) {
        this.b.L.t(rectF);
    }

    private /* synthetic */ void b5(View object) {
        if (object == null) {
            return;
        }
        Object object2 = this.r.a;
        Object object3 = this.getViewLifecycleOwner();
        ((LiveData)object2).removeObservers((LifecycleOwner)object3);
        this.W.c.removeAllViews();
        this.W.c.addView((View)object);
        this.J = object2 = new CameraFragment$j(this);
        object = x0.s((View)object);
        this.b = object;
        object2 = this.l;
        ((x0)object).X((u6)object2);
        object = this.b;
        object2 = this.r;
        ((x0)object).W((s6)object2);
        object = this.b;
        object2 = this.m;
        ((x0)object).U((m0)object2);
        object = this.b;
        object2 = this.n;
        ((x0)object).T((d.v.c.s0.h7.u0.l)object2);
        object = this.b;
        object2 = this.p;
        ((x0)object).L((BleViewModel)object2);
        object = this.b;
        object2 = this.q;
        ((x0)object).N((DeviceViewModel)object2);
        object = this.b;
        object2 = this.t;
        ((x0)object).Q((c1)object2);
        object = this.b;
        object2 = this.J;
        ((x0)object).M((CameraFragment$j)object2);
        object = this.b;
        object2 = this.u;
        ((x0)object).R((d.v.c.s0.d7.z)object2);
        object = this.b;
        object2 = this.w;
        ((x0)object).S((v6)object2);
        object = this.b;
        object2 = this.o;
        ((x0)object).V((w6)object2);
        object = this.b;
        object2 = this.v;
        ((x0)object).P((DynamicZoomViewModel)object2);
        object2 = this.getViewLifecycleOwner();
        object3 = this.u;
        ViewModel viewModel = this.q;
        this.U = object = new u(this, (LifecycleOwner)object2, (d.v.c.s0.d7.z)object3, (DeviceViewModel)viewModel);
        object2 = this.l;
        object3 = this.m;
        viewModel = this.n;
        this.C = object = new i0((u6)object2, (m0)object3, (d.v.c.s0.h7.u0.l)viewModel);
        Context context = this.getContext();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        BleViewModel bleViewModel = this.p;
        m0 m02 = this.m;
        d.v.c.s0.h7.u0.l l10 = this.n;
        this.B = object = new d.v.c.s0.h7.u0.j(context, lifecycleOwner, bleViewModel, m02, l10);
        this.b.setLifecycleOwner(this);
        this.k0();
        this.d0();
        this.f0();
        this.g0();
        this.Z = true;
        this.V();
        object = this.b.b;
        object2 = new s1(this);
        object.post((Runnable)object2);
    }

    private void b6() {
        int n10 = this.i6();
        if (n10 != 0) {
            return;
        }
        Object object = t6.h();
        this.q0 = object;
        String string2 = d.v.e.l.s1.G((Uri)object);
        this.p.t.setValue(string2);
        object = (CameraSet$Panorama)((Object)this.l.k0().getValue());
        if (object == null) {
            return;
        }
        boolean bl2 = this.c.getPreviewId().s();
        int n11 = d.v.e.h.d.c((Integer)this.l.l0().getValue());
        Object object2 = CameraFragment$i.b;
        n10 = ((Enum)object).ordinal();
        n10 = object2[n10];
        int n12 = 3;
        int n13 = 2;
        int n14 = 1;
        if (n10 != n14) {
            if (n10 != n13) {
                if (n10 != n12) {
                    n10 = 0;
                    object = null;
                    n13 = 0;
                } else {
                    n13 = n14;
                }
            }
        } else {
            n13 = n12;
        }
        this.l.r1();
        object2 = this.p;
        o4 o42 = new o4(this);
        q1 q12 = new q1(this);
        ((BleViewModel)object2).C1(n13, n11, string2, bl2, o42, q12);
    }

    private void c0() {
        AlbumActivity.i((Context)this.requireActivity());
    }

    private /* synthetic */ void c1(Integer n10, int n11) {
        FragmentActivity fragmentActivity = this.requireActivity();
        g4 g42 = new g4(this, n10);
        fragmentActivity.runOnUiThread(g42);
    }

    private /* synthetic */ void c4(Boolean bl2) {
        this.b.r.performClick();
    }

    private void c6(View view) {
        int n10 = this.k;
        if (n10 != 0) {
            CheckedTextView checkedTextView = this.b.b;
            n10 = checkedTextView.getLeft();
            int n11 = view.getRight();
            n10 -= n11;
            float f10 = 20.0f;
            n11 = d.v.e.l.h2.b(f10);
            n10 -= n11;
            n11 = view.getWidth() / 2;
            n10 += n11;
            n11 = view.getHeight() / 2;
            float f11 = n10 - n11;
            view.setTranslationX(f11);
            n10 = this.e;
            n11 = view.getHeight();
            n10 = (n10 + n11) / 2;
            n11 = view.getBottom();
            f11 = n10 -= n11;
            view.setTranslationY(f11);
        } else {
            n10 = 0;
            float f12 = 0.0f;
            Object var3_4 = null;
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }
    }

    private /* synthetic */ void d2(Float f10) {
        this.c.getBeautyRosy().o(f10);
    }

    private /* synthetic */ void d3(Integer object) {
        this.s.b.setValue(object);
        Object object2 = this.s.c;
        Object object3 = this.getResources();
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        int n11 = 2131952372;
        object3 = d.v.f.i.g.p(object3, n11, objectArray);
        ((MutableLiveData)object2).setValue(object3);
        int n12 = (Integer)object;
        int n13 = 100;
        if (n12 >= n13) {
            int n14 = (Integer)object;
            n14 = n14 == n13 ? 2131952729 : 2131952726;
            object3 = this.getContext();
            object2 = new k$b((Context)object3);
            object3 = this.getResources();
            object = d.v.f.i.g.o(object3, n14);
            object = (k$b)((k$a)object2).B((String)object);
            object2 = b3.a;
            object = (k$b)((k$b)((k$a)object).w((d.v.f.f.a)object2)).c();
            object2 = this.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
            this.T();
        }
    }

    private /* synthetic */ void d5(Long object) {
        object = (Boolean)this.l.i0().getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (!bl2) {
            return;
        }
        object = new a$a();
        Object object2 = d.v.f.i.g.o(this.getResources(), 2131952227);
        object = ((a$a)object).j((String)object2);
        int n10 = d.v.e.l.h2.b(143.0f);
        object = ((a$a)object).k(n10);
        object2 = d.v.f.i.g.o(this.getResources(), 2131951833);
        d.v.f.f.a a10 = new x2(this);
        object = ((a$a)object).l((String)object2, a10);
        object2 = d.v.f.i.g.o(this.getResources(), 2131951851);
        a10 = new d.v.c.s0.g(this);
        object = ((a$a)object).n((String)object2, a10);
        object2 = new d.v.c.s0.a7.n1.a((a$a)object);
        object = this.getChildFragmentManager();
        int n11 = this.j;
        ((d.v.f.g.b)object2).r((FragmentManager)object, n11);
    }

    private void d6(boolean bl2) {
        int n10 = this.k;
        if (n10 != 0) {
            ImageView imageView = this.b.x;
            int n11 = imageView.getHeight() * 2;
            float f10 = 12.0f;
            int n12 = d.v.e.l.h2.b(f10);
            n11 += n12;
            n12 = this.e;
            float f11 = n11 -= n12;
            imageView.setTranslationY(f11);
        } else {
            ImageView imageView = this.b.x;
            imageView.setTranslationY(0.0f);
        }
        if (bl2) {
            ImageView imageView = this.b.x;
            n10 = -d.v.e.l.h2.b(46.0f);
            float f12 = n10;
            imageView.setTranslationX(f12);
        } else {
            ImageView imageView = this.b.x;
            imageView.setTranslationX(0.0f);
        }
    }

    private void e0() {
        MutableLiveData mutableLiveData = this.r.o;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        d4 d42 = new d4(this);
        mutableLiveData.observe(lifecycleOwner, d42);
    }

    private /* synthetic */ void e1(Size object, int n10) {
        Object object2;
        n10 = object.getWidth();
        int n11 = object.getHeight();
        v6 v62 = this.w;
        int n12 = v62.x();
        if (n12 != n10 || (n10 = ((v6)(object2 = this.w)).w()) != n11) {
            object = this.w;
            object2 = this.c;
            ((v6)object).m0((CameraView)object2);
        }
    }

    private /* synthetic */ void e4(Float f10) {
        this.c.getPreviewWt().x(f10);
    }

    private void e6(View view, int n10) {
        int n11 = this.k;
        if (n11 != 0) {
            n11 = view.getWidth() / 2;
            int n12 = view.getHeight() / 2;
            n11 += n12;
            n12 = view.getRight();
            n10 = d.v.e.l.h2.b(n10);
            float f10 = (n11 -= n12) + n10;
            view.setTranslationX(f10);
            n10 = this.e;
            n11 = view.getHeight();
            n10 = (n10 - n11) / 2;
            n11 = view.getTop();
            f10 = n10 -= n11;
            view.setTranslationY(f10);
        } else {
            n10 = 0;
            float f11 = 0.0f;
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }
    }

    private void f0() {
        Object object = this.b.L;
        Object object2 = new CameraFragment$a(this);
        ((TrackView)((Object)object)).setOnAreaSelectedListener((TrackView$b)object2);
        object = this.b.L;
        object2 = new d.v.c.s0.a2(this);
        ((TrackView)((Object)object)).setOnCloseClickListener((TrackView$c)object2);
        object = this.b.b;
        object2 = new h2(this);
        object.setOnClickListener((View.OnClickListener)object2);
        object2 = this.getContext();
        object = new CameraFragment$b(this, (Context)object2);
        this.i = object;
        object = this.c.getRecordVolume();
        object2 = new f(this);
        ((d.v.d.i.a.a)object).g((c$a)object2);
        object = this.c.getPreviewFace();
        object2 = new r4(this);
        ((d.v.d.i.a.a)object).g((c$a)object2);
        object = this.c.getMaskMotion();
        object2 = new d.v.c.s0.c1(this);
        ((d.v.b.c0.b)object).h((e$a)object2);
        object = this.c.getPreviewWt();
        object2 = new v3(this);
        ((d.v.d.i.a.a)object).g((c$a)object2);
        object = this.c.getDeviceStatus();
        object2 = new d.v.c.s0.i1(this);
        ((d.v.d.i.a.a)object).g((c$a)object2);
        object = this.b.I;
        object2 = new CameraFragment$c(this);
        ((PartitionSeekBar)((Object)object)).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)object2);
        object = this.b.c;
        object2 = new d.v.c.s0.e(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.b.g;
        object2 = new j3(this);
        object.setOnClickListener((View.OnClickListener)object2);
        object = this.b.k.h;
        object2 = new d5(this);
        object.setOnClickListener((View.OnClickListener)object2);
        object = this.b.k.i;
        object2 = new y2(this);
        object.setOnClickListener((View.OnClickListener)object2);
        object = this.b.k.j;
        object2 = new i2(this);
        object.setOnClickListener((View.OnClickListener)object2);
        object = this.u.p;
        object2 = this.getViewLifecycleOwner();
        Object object3 = new t5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.requireActivity().getOnBackPressedDispatcher();
        object2 = this.getViewLifecycleOwner();
        object3 = new CameraFragment$d(this, true);
        ((OnBackPressedDispatcher)object).addCallback((LifecycleOwner)object2, (OnBackPressedCallback)object3);
    }

    private /* synthetic */ void f2(Integer object) {
        Object object2 = this.o;
        Object object3 = object2.m();
        int n10 = (Integer)object;
        int n11 = -3;
        String string2 = "";
        boolean bl2 = true;
        if (n10 != n11) {
            n11 = -2;
            if (n10 != n11) {
                n11 = -1;
                if (n10 != n11) {
                    int n12 = d.v.e.h.d.c((Integer)object);
                    this.j6(n12);
                } else {
                    if (object3 != 0 && (object = this.l.I()) == (object2 = CameraSet$Mode.video)) {
                        this.l.j2(false);
                        this.l.h2(bl2);
                        object = this.b.E;
                        ((ModeSwitch)object).setScrollEnable(false);
                    } else {
                        this.t6();
                    }
                    d.v.e.l.m2.a(this.H);
                    object = this.d;
                    object.setVisibility(0);
                }
            } else {
                this.l.W1(false);
                this.E6();
                this.d.setVisibility(8);
                this.d.setText((CharSequence)string2);
                object = this.l.I();
                object2 = CameraFragment$i.a;
                Object object4 = ((Enum)object).ordinal();
                object4 = object2[object4];
                object3 = 2;
                if (object4 != object3) {
                    object3 = 3;
                    if (object4 != object3) {
                        object3 = 9;
                        if (object4 == object3) {
                            this.s6();
                        }
                    } else {
                        object = this.c.getPhotoControl();
                        object2 = (int)(bl2 ? 1 : 0);
                        ((d.v.d.i.e.a)object).n((Integer)object2);
                        object = (Boolean)this.l.i0().getValue();
                        object4 = d.v.e.h.a.c((Boolean)object);
                        if (object4 != 0) {
                            this.J6(bl2, false);
                            object = this.o;
                            ((w6)object).V();
                        }
                    }
                } else {
                    this.b6();
                }
            }
        } else {
            int n13;
            if (object3 != 0 || (n13 = d.v.e.h.d.c((Integer)(object = (Integer)this.l.g0().getValue()))) == 0) {
                this.J6(bl2, false);
            }
            this.l.W1(false);
            this.E6();
            this.d.setText((CharSequence)string2);
            long l10 = 900L;
            object = new k5(this);
            this.H = object = d.v.e.l.m2.X(l10, this, (m2$b)object);
        }
    }

    private /* synthetic */ void f3(BleViewModel$PanoramaState object) {
        Object object2 = Boolean.FALSE;
        Object object3 = CameraFragment$i.d;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if ((n10 = object3[n10]) != n11) {
            int n12 = 2;
            String string2 = "";
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    n12 = 4;
                    if (n10 != n12) {
                        n11 = 5;
                        if (n10 == n11) {
                            object = (String)this.p.t.getValue();
                            if (object != null) {
                                object3 = this.requireContext();
                                a2.e((Context)object3, (String)object);
                            }
                            this.p.t.setValue(string2);
                            this.s.a.setValue(object2);
                            object = this.l;
                            object2 = this.getResources();
                            n11 = 2131952376;
                            object2 = d.v.f.i.g.o((Resources)object2, n11);
                            ((u6)object).o2((String)object2);
                            this.T5();
                        }
                    } else {
                        object = (String)this.p.t.getValue();
                        object2 = d.v.c.v0.n.d.s();
                        boolean bl2 = ((d)object2).A();
                        if (bl2) {
                            object = t6.e("PIC");
                            d.v.e.l.s1.o0(this.q0, (String)object);
                            object = this.requireContext();
                            object2 = d.v.e.l.s1.G(this.q0);
                            a2.f((Context)object, (String)object2);
                        } else {
                            object2 = this.r;
                            ((s6)object2).f0(n11 != 0, (String)object);
                        }
                        long l10 = 500L;
                        object = new l1(this);
                        d.v.e.l.m2.X(l10, this, (m2$b)object);
                    }
                } else {
                    object = this.M;
                    n10 = (int)(object.isEmpty() ? 1 : 0);
                    if (n10 == 0) {
                        object = this.M.iterator();
                        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                            object3 = (Uri)object.next();
                            d.v.e.l.s1.i((Uri)object3);
                        }
                    }
                    if ((object = this.q0) != null) {
                        d.v.e.l.s1.i((Uri)object);
                    }
                    this.p.t.setValue(string2);
                    object = this.s.a;
                    ((MutableLiveData)object).setValue(object2);
                    this.T5();
                }
            } else {
                object = this.getResources();
                int n13 = 2131952375;
                object = d.v.f.i.g.o((Resources)object, n13);
                object2 = this.s.e;
                object3 = n11;
                ((MutableLiveData)object2).setValue(object3);
                object2 = this.s.b;
                n11 = 0;
                object3 = 0;
                ((MutableLiveData)object2).setValue(object3);
                this.s.c.setValue(object);
                this.s.d.setValue(string2);
                object = this.s.a;
                object2 = Boolean.TRUE;
                ((MutableLiveData)object).setValue(object2);
                this.r6();
            }
        } else {
            this.M.clear();
            this.t6();
            this.D6();
            object = this.b.k.w;
            n10 = object.getVisibility();
            if (n10 == 0) {
                object = this.b.k.w;
                int n14 = 8;
                object.setVisibility(n14);
            }
        }
    }

    private /* synthetic */ void f5() {
        this.d.setVisibility(8);
    }

    private void f6() {
        int n10;
        int n11;
        d.v.f.f.e e10 = this.i;
        if (e10 != null && (n11 = this.j) != (n10 = e10.a())) {
            e10 = this.i;
            n10 = e10.a();
            this.h0(n10);
        }
    }

    private void g0() {
        Object object = this.r.l;
        Object object2 = this.getViewLifecycleOwner();
        Observer observer = new d.v.c.s0.k(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.r.e;
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.s0.b1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.r.m;
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.s0.d1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.H();
        object2 = this.getViewLifecycleOwner();
        observer = new u3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.r.j;
        object2 = this.getViewLifecycleOwner();
        observer = new t1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.z();
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.s0.x0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.c.getPreviewId();
        object2 = new e2(this);
        ((d.v.d.i.a.a)object).g((c$a)object2);
        object = this.l.t();
        object2 = this.getViewLifecycleOwner();
        observer = new i4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.w();
        object2 = this.getViewLifecycleOwner();
        observer = new c3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.r();
        object2 = this.getViewLifecycleOwner();
        observer = new k1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.x();
        object2 = this.getViewLifecycleOwner();
        observer = new f3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.s();
        object2 = this.getViewLifecycleOwner();
        observer = new g5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.u();
        object2 = this.getViewLifecycleOwner();
        observer = new m3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.v();
        object2 = this.getViewLifecycleOwner();
        observer = new n3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.y;
        object2 = this.getViewLifecycleOwner();
        observer = new u0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.z;
        object2 = this.getViewLifecycleOwner();
        observer = new k4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.m.u();
        object2 = this.getViewLifecycleOwner();
        observer = new s3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.m.i();
        object2 = this.getViewLifecycleOwner();
        observer = new e3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.m.n();
        object2 = this.getViewLifecycleOwner();
        observer = new d0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.J();
        object2 = this.getViewLifecycleOwner();
        observer = new q5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.A();
        object2 = this.getViewLifecycleOwner();
        observer = new d2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.G();
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.s0.z(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.i0();
        object2 = this.getViewLifecycleOwner();
        observer = new h(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.L;
        object2 = this.getViewLifecycleOwner();
        observer = new x(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.k;
        object2 = this.getViewLifecycleOwner();
        f$a f$a = new c0(this);
        observer = new d.v.e.i.f(f$a);
        ((StackLiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.h;
        object2 = this.getViewLifecycleOwner();
        observer = new h3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.i;
        object2 = this.getViewLifecycleOwner();
        observer = new r5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.j;
        object2 = this.getViewLifecycleOwner();
        observer = new z4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.l;
        object2 = this.getViewLifecycleOwner();
        observer = new b5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.n;
        object2 = this.getViewLifecycleOwner();
        observer = new n1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.m;
        object2 = this.getViewLifecycleOwner();
        f$a = new n5(this);
        observer = new d.v.e.i.f(f$a);
        ((StackLiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.r.k;
        object2 = this.getViewLifecycleOwner();
        observer = new w2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.D0();
        object2 = this.getViewLifecycleOwner();
        observer = new h4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.D;
        object2 = this.getViewLifecycleOwner();
        observer = new w1(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.w.e;
        object2 = this.getViewLifecycleOwner();
        observer = new t3(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.x.g;
        object2 = this.getViewLifecycleOwner();
        observer = new f2(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.o.a;
        object2 = this.getViewLifecycleOwner();
        observer = new a4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.o.b;
        object2 = this.getViewLifecycleOwner();
        observer = new l3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.o.c;
        object2 = this.getViewLifecycleOwner();
        observer = new d3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.s.a;
        object2 = this.getViewLifecycleOwner();
        observer = new x3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.q;
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.s0.j(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.r;
        object2 = this.getViewLifecycleOwner();
        observer = new u2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.x;
        object2 = this.getViewLifecycleOwner();
        observer = new g2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.A;
        object2 = this.getViewLifecycleOwner();
        observer = new e5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.r.g;
        object2 = this.getViewLifecycleOwner();
        observer = new z3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.r.h;
        object2 = this.getViewLifecycleOwner();
        observer = new l2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.r.i;
        object2 = this.getViewLifecycleOwner();
        observer = new t2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.H0();
        object2 = this.getViewLifecycleOwner();
        observer = new z0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.r;
        boolean bl2 = ((s6)object).s();
        if (!bl2) {
            this.m6();
        } else {
            this.e0();
        }
        object = this.r.q;
        object2 = this.getViewLifecycleOwner();
        observer = new q4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.u.a0();
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.s0.a0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.q.c;
        object2 = this.getViewLifecycleOwner();
        observer = new n4(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.u.G();
        object2 = this.getViewLifecycleOwner();
        observer = new j2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.u.m;
        object2 = this.getViewLifecycleOwner();
        observer = new i5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.u;
        object2 = this.getViewLifecycleOwner();
        observer = m5.a;
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.K();
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.s0.r(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.T();
        object2 = this.getViewLifecycleOwner();
        observer = new b2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.Y();
        object2 = this.getViewLifecycleOwner();
        observer = new y1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.a0();
        object2 = this.getViewLifecycleOwner();
        observer = new l4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.q.b;
        object2 = this.getViewLifecycleOwner();
        observer = new m2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.O;
        object2 = this.getViewLifecycleOwner();
        observer = new s5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.w.y();
        object2 = this.getViewLifecycleOwner();
        observer = new a3(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.w.b;
        object2 = this.getViewLifecycleOwner();
        observer = new j1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.w.c;
        object2 = this.getViewLifecycleOwner();
        observer = new p5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.w.d;
        object2 = this.getViewLifecycleOwner();
        observer = new p4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.w.g;
        object2 = this.getViewLifecycleOwner();
        observer = new o1(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.w.h;
        object2 = this.getViewLifecycleOwner();
        observer = new o3(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.w.i;
        object2 = this.getViewLifecycleOwner();
        observer = new g1(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.w.j;
        object2 = this.getViewLifecycleOwner();
        observer = new k3(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.w.k;
        object2 = this.getViewLifecycleOwner();
        observer = new w4(this);
        ((d.v.e.i.j)object).observe((LifecycleOwner)object2, observer);
        object = this.c.getPreviewSize();
        object2 = new v0(this);
        ((d.v.d.i.a.a)object).g((c$a)object2);
        object = this.c.getPreviewStatus();
        object2 = new m4(this);
        ((d.v.d.i.a.a)object).g((c$a)object2);
        object = this.c.getPhotoData();
        object2 = new k2(this);
        ((d.v.d.i.a.a)object).g((c$a)object2);
        object = this.c.getRecordStatus();
        object2 = new CameraFragment$f(this);
        ((d.v.d.i.a.a)object).g((c$a)object2);
        object = this.v.t();
        object2 = this.getViewLifecycleOwner();
        observer = new v1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.v.o();
        object2 = this.getViewLifecycleOwner();
        observer = new z2(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.v.g;
        object2 = this.getViewLifecycleOwner();
        observer = new f4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.v.s();
        object2 = this.getViewLifecycleOwner();
        observer = new j5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.C0();
        object2 = this.getViewLifecycleOwner();
        observer = new c4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.l.F();
        object2 = this.getViewLifecycleOwner();
        observer = new l5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.t.r();
        object2 = this.getViewLifecycleOwner();
        observer = new h5(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.t.a;
        object2 = this.getViewLifecycleOwner();
        observer = new a1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.p.P;
        object2 = this.getViewLifecycleOwner();
        observer = new z1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.x.d;
        object2 = this.getViewLifecycleOwner();
        observer = w3.a;
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.x.f;
        object2 = this.getViewLifecycleOwner();
        observer = new j4(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private /* synthetic */ void g1(Integer object, int n10) {
        int n11 = (Integer)object;
        n10 = 3;
        float f10 = 4.2E-45f;
        if (n11 == n10) {
            float f11;
            float f12;
            Object object2;
            n11 = (int)(this.Z() ? 1 : 0);
            if (n11 != 0) {
                return;
            }
            object = (Boolean)this.l.i0().getValue();
            n11 = (int)(d.v.e.h.a.c((Boolean)object) ? 1 : 0);
            if (n11 != 0) {
                object = this.getActivity();
                object2 = new r1(this);
                object.runOnUiThread((Runnable)object2);
            }
            object = this.c.getPreviewFace();
            n10 = (int)(d.v.e.h.a.c((Boolean)this.l.i0().getValue()) ? 1 : 0);
            ((d.v.d.i.f.h)object).m(n10 != 0);
            this.R6();
            object = this.requireActivity();
            object2 = new t(this);
            object.runOnUiThread((Runnable)object2);
            object = this.c.getPreviewWt();
            object2 = this.w;
            float f13 = ((Float)((d.v.d.i.a.a)object).get()).floatValue();
            ((v6)object2).R(f13);
            object2 = this.w;
            f13 = ((Float)((d.v.d.i.a.a)object).e()).floatValue();
            float f14 = ((Float)((d.v.d.i.a.a)object).f()).floatValue();
            ((v6)object2).T(f13, f14);
            object2 = this.l.a;
            Float f15 = (Float)((d.v.d.i.a.a)object).get();
            int n12 = 2;
            f14 = 2.8E-45f;
            float[] fArray = new float[n12];
            Float f16 = (Float)((d.v.d.i.a.a)object).e();
            fArray[0] = f12 = f16.floatValue();
            int n13 = 1;
            fArray[n13] = f11 = ((Float)((d.v.d.i.a.a)object).f()).floatValue();
            ((x6)object2).s(f15, fArray);
            object = this.v;
            if (object != null && (object = this.l.I()) == (object2 = CameraSet$Mode.dolly_zoom)) {
                object = this.v;
                object2 = (Float)this.c.getPreviewWt().e();
                f10 = ((Float)object2).floatValue();
                f15 = (Float)this.c.getPreviewWt().f();
                f13 = f15.floatValue();
                ((DynamicZoomViewModel)object).R(f10, f13);
                object = this.v;
                ((DynamicZoomViewModel)object).K();
            }
        }
    }

    private /* synthetic */ void g4(Integer[] object) {
        int n10;
        int n11;
        if (object != null && (n11 = ((Integer[])object).length) >= (n10 = 3)) {
            BleViewModel bleViewModel = this.p;
            Integer n12 = object[0];
            n10 = n12;
            Integer n13 = object[1];
            int n14 = n13;
            int n15 = 2;
            object = object[n15];
            int n16 = (Integer)object;
            bleViewModel.Z0(n10, n14, n16);
        }
    }

    private void g6() {
        Object object = this.l.I();
        if (object == null) {
            return;
        }
        Object object2 = CameraFragment$i.a;
        int n10 = object.ordinal();
        n10 = object2[n10];
        switch (n10) {
            default: {
                break;
            }
            case 9: {
                object = this.c.getCameraMode();
                int n11 = 2;
                object2 = n11;
                ((d.v.d.i.b.b)object).t((Integer)object2);
                break;
            }
            case 8: {
                object = this.c.getCameraMode();
                int n12 = 18;
                object2 = n12;
                ((d.v.d.i.b.b)object).t((Integer)object2);
                break;
            }
            case 7: {
                object = this.c.getCameraMode();
                int n13 = 17;
                object2 = n13;
                ((d.v.d.i.b.b)object).t((Integer)object2);
                break;
            }
            case 5: 
            case 6: {
                object = this.c.getCameraMode();
                int n14 = 16;
                object2 = n14;
                ((d.v.d.i.b.b)object).t((Integer)object2);
                break;
            }
            case 3: {
                object = this.c.getPhotoSize();
                object2 = (String)this.l.F().getValue();
                ((d.v.d.i.e.f)object).t((String)object2);
                object = this.c.getCameraMode();
                int n15 = 1;
                object2 = n15;
                ((d.v.d.i.b.b)object).t((Integer)object2);
                break;
            }
            case 2: {
                object = this.c.getPhotoSize();
                object2 = r0;
                ((d.v.d.i.e.f)object).t((String)object2);
                object = this.l.o0();
                d.v.d.i.f.t t10 = this.c.getPreviewSize();
                CameraSet$Panorama cameraSet$Panorama = CameraSet$Panorama.P_CLONE;
                if (object == cameraSet$Panorama) {
                    object2 = s0;
                }
                t10.w((String)object2);
                object = this.c.getCameraMode();
                int n16 = 8;
                object2 = n16;
                ((d.v.d.i.b.b)object).t((Integer)object2);
                break;
            }
            case 1: {
                object = this.c.getCameraMode();
                int n17 = 19;
                object2 = n17;
                ((d.v.d.i.b.b)object).t((Integer)object2);
            }
        }
    }

    private void h0(int n10) {
        this.i0(n10, false);
    }

    private /* synthetic */ void h2(Integer n10) {
        int n11 = n10;
        if (n11 > 0) {
            int n12 = d.v.e.h.d.c(n10);
            this.j6(n12);
        }
    }

    private /* synthetic */ void h3(List object) {
        object = this.p;
        int n10 = ((BleViewModel)object).F();
        BleViewModel bleViewModel = this.p;
        int n11 = bleViewModel.G();
        if (n11 == 0) {
            object = this.p;
            ((BleViewModel)object).g();
        } else if (n11 > n10) {
            object = this.c;
            n11 = 0x3F000000;
            float f10 = 0.5f;
            int n12 = this.j;
            object = t6.l((CameraView)object, f10, n12, false);
            bleViewModel = this.p;
            bleViewModel.c((Bitmap)object);
        } else if (n10 > n11) {
            object = this.p;
            ((BleViewModel)object).b1();
        }
    }

    private /* synthetic */ Bitmap h5() {
        Object object = this.requireActivity();
        Object object2 = this.z;
        object2.getClass();
        Context context = new n6((d.v.c.s0.g7.e)object2);
        object.runOnUiThread((Runnable)context);
        object = this.c;
        float f10 = 1.0f;
        int n10 = 3;
        int n11 = 1;
        object = t6.l((CameraView)object, f10, n10, n11 != 0);
        object2 = d.v.c.v0.n.d.s();
        boolean bl2 = ((d)object2).A();
        if (bl2) {
            object2 = t6.r((Bitmap)object);
            context = new Object[n11];
            n11 = 0;
            context[0] = object2;
            String string2 = "---path = %s";
            m.a.a.b(string2, (Object[])context);
            if (object2 != null) {
                this.M.add(object2);
                context = this.requireContext();
                string2 = d.v.e.l.s1.G((Uri)object2);
                a2.f(context, string2);
                context = this.requireContext();
                t6.a(context, (Uri)object2);
            }
        }
        return object;
    }

    private void h6(CameraSet$Mode object) {
        Object object2 = CameraSet$Mode.story;
        if (object != object2) {
            object = t6.c();
            int n10 = 1;
            object2 = new Object[n10];
            object2[0] = object;
            String string2 = "----path = %s";
            m.a.a.b(string2, (Object[])object2);
            this.S = object;
            object2 = this.c.getRecordPath();
            ((d.v.d.i.g.j)object2).q((String)object);
        }
    }

    private void i0(int n10, boolean n11) {
        if (n11 != 0 || (n11 = this.j) != n10) {
            this.l.i2(n10);
            Object object = this.b.L;
            float f10 = n10;
            ((TrackView)((Object)object)).setRotation(f10);
            this.j = n10;
            if (n10 != 0 && n10 != (n11 = 2)) {
                n11 = 0;
                object = null;
            } else {
                n11 = 1;
            }
            this.k = n11;
            this.u.w0(n10);
            this.W();
            object = this.r.b;
            int n12 = this.j;
            Integer n13 = n12;
            ((MutableLiveData)object).setValue(n13);
        }
        this.w.Z(n10);
    }

    private /* synthetic */ void i1(d.v.d.i.a.b object, int n10) {
        object = t6.s(((d.v.d.i.a.b)object).b());
        Object[] objectArray = new s2(this);
        c5 c52 = c5.a;
        object = ((j)object).c((e.a.v0.g)objectArray, c52);
        objectArray = new Object[]{object = Boolean.valueOf(object.isDisposed())};
        m.a.a.b("imageSaver isDisposed =%s", objectArray);
    }

    private /* synthetic */ void i4() {
        int n10;
        int[] nArray = new int[2];
        this.b.d.getLocationOnScreen(nArray);
        this.h = n10 = nArray[0];
        this.g = n10 = this.b.d.getWidth();
    }

    private boolean i6() {
        Object object = (Boolean)this.p.L.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (!bl2) {
            object = this.l;
            String string2 = d.v.f.i.g.o(this.getResources(), 2131951950);
            ((u6)object).o2(string2);
            return true;
        }
        return false;
    }

    public static /* synthetic */ w6 j(CameraFragment cameraFragment) {
        return cameraFragment.o;
    }

    private void j0() {
        this.e();
        Object object = this.m;
        boolean bl2 = true;
        ((m0)object).h0(bl2);
        object = this.m.o();
        if (object == null) {
            return;
        }
        int n10 = ((TemplatePOJO)object).getTemplateVideoList().size();
        StoryProgressBar storyProgressBar = this.Y.r;
        int n11 = this.m.j();
        int[] nArray = this.m.r();
        long[] lArray = this.m.p();
        storyProgressBar.o(n10, n11, true, nArray, lArray);
    }

    private /* synthetic */ void j2(CameraSet$StoryState object) {
        boolean bl2;
        Object object2;
        Object object3;
        block14: {
            CameraSet$StoryState cameraSet$StoryState;
            object3 = this.C;
            object2 = this.getChildFragmentManager();
            object3.k((FragmentManager)object2);
            object3 = this.l.I();
            object2 = CameraSet$Mode.story;
            if (object3 != object2) {
                this.i.enable();
                this.f6();
                return;
            }
            object3 = this.m;
            object2 = this.l.I();
            boolean n10 = ((m0)object3).K((CameraSet$Mode)((Object)object2), cameraSet$StoryState = this.m.v());
            if (n10) {
                object3 = this.b.m;
                object3.clearAnimation();
            } else {
                object3 = this.b.m;
                int n11 = object3.getVisibility();
                if (n11 == 0) {
                    object3 = this.requireContext();
                    int n12 = 2130771980;
                    object3 = AnimationUtils.loadAnimation((Context)object3, (int)n12);
                    object2 = this.b.m;
                    object2.startAnimation((Animation)object3);
                }
            }
            this.i.disable();
            this.h0(3);
            object3 = this.C;
            object2 = this.Y;
            bl2 = false;
            cameraSet$StoryState = null;
            object3.o((yh)object2, 0, false);
            object3 = CameraFragment$i.e;
            Object object4 = ((Enum)object).ordinal();
            object4 = object3[object4];
            boolean bl3 = false;
            object3 = null;
            boolean bl4 = true;
            switch (object4) {
                default: {
                    object = CameraSet$Mode.video;
                    this.N6((CameraSet$Mode)((Object)object));
                    object = this.i;
                    object.enable();
                    this.f6();
                    break;
                }
                case 8: {
                    object3 = d.v.c.s0.h7.t0.b.y();
                    break;
                }
                case 7: {
                    object3 = d.v.c.s0.h7.q0.y.P();
                    object = this.m;
                    ((m0)object).b0();
                    break;
                }
                case 6: {
                    this.B.s(bl4);
                    object3 = d.v.c.s0.h7.r0.r.B();
                    object = this.m;
                    ((m0)object).b0();
                    break;
                }
                case 5: {
                    object3 = d.v.c.s0.h7.o0.v0.B();
                    break;
                }
                case 3: 
                case 4: {
                    object3 = d.v.c.s0.h7.s0.y.u();
                    break;
                }
                case 2: {
                    s6 s62;
                    object = this.m;
                    int n13 = ((m0)object).j();
                    ((m0)object).c0(n13);
                    object = this.n;
                    object4 = ((d.v.c.s0.h7.u0.l)object).r();
                    if (object4 != 0 && (object4 = (Object)((d.v.c.s0.h7.u0.j)(object = this.B)).t((FragmentManager)(object2 = this.getChildFragmentManager()), s62 = this.r)) == 0) {
                        object = this.r;
                        ((s6)object).b0();
                    }
                    this.j0();
                    break block14;
                }
                case 1: {
                    this.r.c0();
                    this.B.s(false);
                    object3 = d.v.c.s0.h7.p0.p.v();
                    object = this.m;
                    ((m0)object).b0();
                }
            }
            bl2 = bl4;
        }
        object = this.C;
        object2 = this.getChildFragmentManager();
        ((i0)object).l((FragmentManager)object2, (Fragment)object3);
        this.b.E.setScrollEnable(bl2);
    }

    private /* synthetic */ void j3(BleViewModel$MoveState bleViewModel$MoveState) {
        int[] nArray = CameraFragment$i.c;
        int n10 = bleViewModel$MoveState.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 5;
            if (n10 == n11) {
                this.B6();
                this.F6();
            }
        } else {
            this.p6();
            this.u6();
        }
    }

    private /* synthetic */ void j5(int n10) {
        FragmentActivity fragmentActivity = this.requireActivity();
        f5 f52 = new f5(this, n10);
        fragmentActivity.runOnUiThread(f52);
    }

    private void j6(int n10) {
        int n11 = 2;
        if (n10 > n11) {
            r6 r62 = r6.b();
            boolean bl2 = false;
            r62.f(0);
        } else if (n11 == n10) {
            r6 r63 = r6.b();
            int n12 = 1;
            r63.f(n12);
        }
        String string2 = String.valueOf(n10);
        this.U5(string2);
    }

    public static /* synthetic */ void k(CameraFragment cameraFragment, boolean bl2, boolean bl3) {
        cameraFragment.J6(bl2, bl3);
    }

    private void k0() {
        boolean bl2;
        boolean bl3;
        Object object;
        int n10;
        int n11;
        Object object2 = this.x;
        Object object3 = this.requireActivity();
        ((d.v.c.s0.f7.d)object2).d((FragmentActivity)object3);
        object2 = Windows.l(this.requireContext());
        int n102 = object2.getWidth();
        int n112 = object2.getHeight();
        this.e = n102 = Math.min(n102, n112);
        n102 = object2.getWidth();
        int bl22 = object2.getHeight();
        this.f = n11 = Math.max(n102, bl22);
        object3 = this.r;
        ((s6)object3).d = n11;
        ((s6)object3).c = n10 = this.e;
        object2 = this.b.j.getLayoutParams();
        n102 = this.e;
        float f10 = 62.0f;
        int n12 = d.v.e.l.h2.b(f10);
        ((ViewGroup.LayoutParams)object2).width = n102 -= n12;
        n102 = this.e;
        n112 = d.v.e.l.h2.b(f10);
        ((ViewGroup.LayoutParams)object2).height = n102 -= n112;
        this.b.j.setLayoutParams((ViewGroup.LayoutParams)object2);
        object2 = this.b.d;
        object3 = new x1(this);
        object2.post((Runnable)object3);
        object2 = this.b;
        this.c = object3 = ((x0)object2).a;
        object2 = ((x0)object2).M;
        this.d = object2;
        object2 = this.getLifecycle();
        ((CameraView)object3).d((Lifecycle)object2);
        object2 = new ArrayList();
        object3 = this.l.Y.iterator();
        while ((n112 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            object = (CameraSet$Mode)((Object)object3.next());
            Resources resources = this.getResources();
            n112 = object.getStringRes();
            object = d.v.f.i.g.o(resources, n112);
            object2.add(object);
        }
        object3 = this.b.E.getLayoutParams();
        ((ViewGroup.LayoutParams)object3).width = n112 = this.e;
        object = this.b.E;
        object.setLayoutParams((ViewGroup.LayoutParams)object3);
        object3 = this.b.E;
        f10 = this.e;
        float f11 = 1.0f;
        f10 *= f11;
        float f12 = 2.0f;
        f10 /= f12;
        int n13 = d.v.e.l.h2.b(50.0f);
        float f13 = n13;
        object3.setTranslationX(f10 -= f13);
        object3 = this.b.E;
        n112 = this.e;
        f10 = (float)n112 * f11 / f12;
        n12 = d.v.e.l.h2.b(25.0f);
        f11 = n12;
        object3.setTranslationY(f10 -= f11);
        this.b.E.setData((List)object2);
        object2 = this.l;
        n102 = 3;
        ((u6)object2).i2(n102);
        object2 = this.b.E;
        object3 = new d.v.c.s0.y(this);
        ((ModeSwitch)object2).setOnSelectListener((ModeSwitch$b)object3);
        object2 = this.l.I();
        this.N6((CameraSet$Mode)((Object)object2));
        object2 = this.b;
        object3 = this.l;
        ((x0)object2).X((u6)object3);
        object2 = BleConnection.W();
        boolean bl4 = ((BleConnection)object2).c0();
        if (bl4 && ((object2 = (Boolean)this.t.a.getValue()) == null || !(bl3 = ((Boolean)object2).booleanValue())) && (bl2 = d.v.g.g.e1.f())) {
            object2 = d.v.c.v0.u.z.m();
            boolean bl5 = ((z)object2).B();
            object3 = this.t;
            object = BleConnection.W().T();
            ((c1)object3).M((Stabilizer)object, bl5);
        }
        object2 = this.u;
        object3 = this.getContext();
        object = this.c;
        ((d.v.c.s0.d7.z)object2).l0((Context)object3, (CameraView)object);
    }

    private /* synthetic */ void k1(Float object) {
        float f10;
        float f11;
        float f12;
        float f13;
        DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel;
        Boolean bl2 = Boolean.TRUE;
        Boolean bl3 = Boolean.FALSE;
        Object object2 = this.v.p();
        if (object2 == (dynamicZoomViewModel$TargetModel = DynamicZoomViewModel$TargetModel.FAR) && (f13 = (f12 = (f11 = ((Float)object).floatValue()) - (f10 = 4.0f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) >= 0 && (f13 = (float)((d.v.d.i.g.l)(object2 = this.c.getRecordStatus())).q()) != false) {
            object2 = (Boolean)this.v.h.getValue();
            f13 = (float)((Boolean)object2).booleanValue();
            if (f13 != false) {
                object2 = this.v.h;
                ((MutableLiveData)object2).postValue(bl3);
            }
            if ((f13 = (float)((Boolean)(object2 = (Boolean)this.v.g.getValue())).booleanValue()) == false) {
                object2 = this.v.g;
                ((MutableLiveData)object2).postValue(bl2);
            }
        }
        if ((object2 = this.v.p()) == (dynamicZoomViewModel$TargetModel = DynamicZoomViewModel$TargetModel.NEAR)) {
            float f14 = ((Float)object).floatValue();
            f13 = 1065353216;
            f11 = 1.0f;
            float f15 = f14 - f11;
            Object object3 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            if (object3 <= 0 && (object3 = (Object)((d.v.d.i.g.l)(object = this.c.getRecordStatus())).q()) != false) {
                object = (Boolean)this.v.h.getValue();
                object3 = (Boolean)object;
                if (object3 != false) {
                    object = this.v.h;
                    ((MutableLiveData)object).postValue(bl3);
                }
                if ((object3 = (Object)((Boolean)(object = (Boolean)this.v.g.getValue()))) == false) {
                    object = this.v.g;
                    ((MutableLiveData)object).postValue(bl2);
                }
            }
        }
    }

    private /* synthetic */ void k4(int n10) {
        CameraSet$Mode cameraSet$Mode = (CameraSet$Mode)((Object)this.l.Y.get(n10));
        CameraSet$Mode cameraSet$Mode2 = this.l.I();
        if (cameraSet$Mode2 != null && cameraSet$Mode == cameraSet$Mode2) {
            return;
        }
        this.U(cameraSet$Mode);
    }

    private void k6() {
        Object object = this.l;
        Object object2 = this.X;
        boolean bl2 = d.v.c.s0.b7.j.a((u6)object, (d.v.c.s0.b7.k)object2);
        if (bl2) {
            return;
        }
        object = this.l;
        bl2 = ((u6)object).N0();
        if (bl2) {
            object = this.l;
            object2 = d.v.f.i.g.o(this.getResources(), 2131953166);
            ((u6)object).o2((String)object2);
            return;
        }
        object = this.U;
        bl2 = ((u)object).b0();
        if (bl2) {
            return;
        }
        object = this.l;
        bl2 = ((u6)object).L();
        if (bl2) {
            object = this.l;
            object2 = d.v.f.i.g.o(this.getResources(), 2131953167);
            ((u6)object).o2((String)object2);
            return;
        }
        this.r.d();
        object = e1.r0();
        object2 = new t4(this);
        ((d.v.f.g.b)object).o((b$c)object2);
        object2 = new p3(this);
        ((d.v.f.g.b)object).n((b$b)object2);
        object2 = this.getChildFragmentManager();
        int n10 = this.j;
        ((d.v.f.g.b)object).r((FragmentManager)object2, n10);
    }

    public static /* synthetic */ u l(CameraFragment cameraFragment) {
        return cameraFragment.U;
    }

    private boolean l0() {
        return this.c.getPreviewId().s();
    }

    private /* synthetic */ void l2(Integer object) {
        Object object2;
        Object object3 = this.m;
        Object object4 = this.l.I();
        boolean bl2 = ((m0)object3).K((CameraSet$Mode)((Object)object4), (CameraSet$StoryState)((Object)(object2 = this.m.v())));
        if (!bl2) {
            return;
        }
        object3 = this.m;
        object4 = this.n;
        object3 = d.v.c.s0.h7.k0.n((m0)object3, (d.v.c.s0.h7.u0.l)object4);
        object4 = ((Pair)object3).first;
        if (object4 != null) {
            object2 = this.p;
            object4 = (Boolean)object4;
            boolean n10 = (Boolean)object4;
            ((BleViewModel)object2).q1(n10);
        }
        if ((object4 = ((Pair)object3).second) != null) {
            object4 = this.c.getPreviewZoom();
            object3 = (Float)((Pair)object3).second;
            ((d.v.d.i.f.a0)object4).v((Float)object3);
        }
        if ((bl2 = d.v.e.l.s1.q((String)(object3 = this.m.k()))) && !(bl2 = d.v.e.h.a.c((Boolean)(object3 = (Boolean)this.n.e.getValue())))) {
            object = this.m;
            object3 = CameraSet$StoryState.STORY_REVIEW;
            ((m0)object).g0((CameraSet$StoryState)((Object)object3));
        } else {
            object3 = this.Y.r;
            int n10 = (Integer)object;
            boolean bl3 = true;
            ((StoryProgressBar)object3).q(n10, bl3);
            object3 = this.C;
            object4 = this.Y;
            int n11 = (Integer)object;
            ((i0)object3).o((yh)object4, n11, bl3);
            object = this.m;
            ((m0)object).h0(bl3);
        }
    }

    private /* synthetic */ void l3(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.r.d();
            object = d.v.c.s0.a7.z0.B();
            Object object2 = new s4(this);
            ((d.v.f.g.b)object).o((b$c)object2);
            object2 = new m(this);
            ((d.v.f.g.b)object).n((b$b)object2);
            object2 = this.getChildFragmentManager();
            int n10 = this.j;
            ((d.v.f.g.b)object).r((FragmentManager)object2, n10);
            object = this.r.g;
            object2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(object2);
        }
    }

    public static /* synthetic */ boolean l5(CameraFragment cameraFragment) {
        return cameraFragment.o0();
    }

    private void l6(boolean bl2) {
        if (bl2) {
            Object object = this.getChildFragmentManager();
            int n10 = this.j;
            object = i1.E((FragmentManager)object, n10);
            Object object2 = new g3(this);
            ((d.v.f.g.b)object).o((b$c)object2);
            object2 = new n2(this);
            ((d.v.f.g.b)object).n((b$b)object2);
        } else {
            d.v.c.s0.a7.j1 j12 = this.s;
            j12.c();
            i1.B();
        }
    }

    public static /* synthetic */ DynamicZoomViewModel m(CameraFragment cameraFragment) {
        return cameraFragment.v;
    }

    private boolean m0() {
        boolean bl2;
        k0 k02 = this.A;
        if (k02 != null && (bl2 = k02.u())) {
            bl2 = true;
        } else {
            bl2 = false;
            k02 = null;
        }
        return bl2;
    }

    private /* synthetic */ void m1(DynamicZoomViewModel$TargetModel object) {
        float f10;
        Object object2 = DynamicZoomViewModel$TargetModel.FAR;
        if (object == object2) {
            object2 = this.v;
            float f11 = 1.0f;
            this.P = f10 = ((DynamicZoomViewModel)object2).j(f11);
        }
        if (object == (object2 = DynamicZoomViewModel$TargetModel.NEAR)) {
            float f12;
            object = this.v;
            f10 = 4.0f;
            this.P = f12 = ((DynamicZoomViewModel)object).j(f10);
        }
        object = this.c.getPreviewWt();
        object2 = Float.valueOf(this.P);
        ((d.v.d.i.f.z)object).x((Float)object2);
        object = this.c.getPreviewFocus();
        object2 = 1;
        ((d.v.d.i.f.j)object).o((Integer)object2);
        object = this.v.t();
        object2 = Float.valueOf(this.P);
        ((MutableLiveData)object).postValue(object2);
        object = this.v;
        f10 = this.P;
        ((DynamicZoomViewModel)object).J(f10);
    }

    public static /* synthetic */ void m4(CameraFragment cameraFragment, boolean bl2) {
        cameraFragment.l6(bl2);
    }

    private /* synthetic */ void m5() {
        this.l.k2(false);
    }

    private void m6() {
        Object object = new d.v.c.z0.k$b();
        Object object2 = d.v.f.i.g.o(this.getResources(), 2131953291);
        object = ((d.v.c.z0.k$b)object).J((String)object2).B(true);
        object2 = d.v.f.i.g.o(this.getResources(), 2131951828);
        object = ((d.v.c.z0.k$b)object).y((String)object2).z(false);
        object2 = d.v.f.i.g.o(this.getResources(), 2131951887);
        d.v.c.s0.e1 e12 = new d.v.c.s0.e1(this);
        object = ((d.v.c.z0.k$b)object).G((String)object2, e12);
        int n10 = d.v.e.l.h2.b(180.0f);
        object = ((d.v.c.z0.k$b)object).N(n10);
        n10 = d.v.e.l.o1.e(this.requireView(), 2131099787);
        object = ((d.v.c.z0.k$b)object).L(n10).M(0x800003).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    public static /* synthetic */ String n(CameraFragment cameraFragment) {
        return cameraFragment.o0;
    }

    private boolean n0(int n10) {
        int n11;
        si si2 = this.V;
        n10 = si2 != null && (n10 == (n11 = (si2 = si2.b.getRoot()).getId()) || n10 == (n11 = (si2 = this.V.e.getRoot()).getId()) || n10 == (n11 = (si2 = this.V.d.getRoot()).getId()) || n10 == (n11 = (si2 = this.V.g.getRoot()).getId()) || n10 == (n11 = (si2 = this.V.c.getRoot()).getId()) || n10 == (n11 = (si2 = this.V.i.getRoot()).getId()) || n10 == (n11 = (si2 = this.V.f.getRoot()).getId()) || n10 == (n11 = (si2 = this.V.h.getRoot()).getId())) ? 1 : 0;
        return n10 != 0;
    }

    private /* synthetic */ void n2(TemplatePOJO object) {
        Object object2 = this.C;
        Object object3 = this.requireContext();
        boolean bl2 = ((i0)object2).c((Context)object3, (TemplatePOJO)object);
        if (!bl2) {
            return;
        }
        object2 = this.C;
        object3 = this.Y;
        m0 m02 = this.m;
        int n10 = m02.j();
        boolean bl3 = true;
        ((i0)object2).o((yh)object3, n10, bl3);
        Object object4 = this.getViewLifecycleOwner();
        u6 u62 = this.l;
        BleViewModel bleViewModel = this.p;
        m0 m03 = this.m;
        d.v.c.s0.h7.u0.l l10 = this.n;
        Object object5 = object2;
        this.A = object2 = new k0((LifecycleOwner)object4, u62, bleViewModel, m03, l10);
        object2 = this.m;
        bl2 = ((m0)object2).I();
        if (bl2) {
            object2 = this.m;
            object3 = CameraSet$StoryState.STORY_DRAFT_TO_REVIEW;
            ((m0)object2).g0((CameraSet$StoryState)((Object)object3));
        }
        int n11 = ((TemplatePOJO)object).getTemplateVideoList().size();
        object = this.Y;
        if (object != null) {
            object2 = ((yh)object).r;
            n10 = this.m.j();
            bl3 = true;
            object5 = this.m.r();
            object = this.m;
            object4 = ((m0)object).p();
            ((StoryProgressBar)object2).o(n11, n10, bl3, (int[])object5, (long[])object4);
        }
    }

    private /* synthetic */ void n3(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.r.d();
            object = d.v.c.s0.a7.l1.O();
            Object object2 = this.getChildFragmentManager();
            int n10 = this.j;
            ((d.v.f.g.b)object).r((FragmentManager)object2, n10);
            object = this.r.h;
            object2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(object2);
        }
    }

    private /* synthetic */ void n4() {
        int n10 = this.j;
        if (n10 == 0) {
            boolean bl2 = true;
            this.i0(n10, bl2);
        }
    }

    public static /* synthetic */ String o(CameraFragment cameraFragment, String string2) {
        cameraFragment.o0 = string2;
        return string2;
    }

    private boolean o0() {
        return this.k;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void o1(Boolean object) {
        void var3_6;
        LottieAnimationView lottieAnimationView = this.b.g;
        boolean n10 = (Boolean)object;
        if (n10) {
            boolean bl2 = false;
        } else {
            int n11 = 4;
        }
        lottieAnimationView.setVisibility((int)var3_6);
        boolean bl3 = (Boolean)object;
        if (bl3) {
            object = this.b.g;
            ((LottieAnimationView)object).playAnimation();
        } else {
            object = this.b.g;
            ((LottieAnimationView)object).cancelAnimation();
        }
    }

    private /* synthetic */ void o5() {
        this.l.k2(true);
    }

    private void o6() {
        int n10;
        Object object;
        Enum enum_ = this.l.I();
        if (enum_ == (object = CameraSet$Mode.panorama)) {
            enum_ = d.v.c.v0.n.d.s().y();
            n10 = ((CameraSet$CountDownTime)enum_).getTime();
        } else {
            enum_ = d.v.c.v0.n.d.s().m();
            n10 = ((CameraSet$CountDownTime)enum_).getTime();
        }
        if (n10 > 0) {
            object = this.l;
            boolean bl2 = true;
            ((u6)object).W1(bl2);
        }
        this.y.g(n10);
    }

    public static /* synthetic */ void p(CameraFragment cameraFragment) {
        cameraFragment.E6();
    }

    public static /* synthetic */ Bitmap p0(CameraFragment cameraFragment) {
        return cameraFragment.b0();
    }

    private /* synthetic */ void p2(CameraParam object) {
        if (object != null) {
            Object object2 = this.c.getRecordSize();
            Object object3 = ((CameraParam)object).getVideoResolution();
            ((d.v.d.i.g.k)object2).z((d.v.d.i.g.k$a)object3);
            object2 = this.c.getPreviewWbType();
            int n10 = ((CameraParam)object).getWhiteBalance();
            object3 = n10;
            ((d.v.d.i.f.y)object2).q((Integer)object3);
            object2 = this.l;
            object = ((CameraParam)object).getVideoResolution();
            int n11 = ((u6)object2).l((d.v.d.i.g.k$a)object);
            ((u6)object2).Z1(n11);
        }
    }

    private /* synthetic */ void p3(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.b.N.setText((CharSequence)object);
            object = this.r.n;
            Object object2 = Boolean.TRUE;
            ((MutableLiveData)object).setValue(object2);
            object = this.r.i;
            object2 = "";
            ((MutableLiveData)object).setValue(object2);
            d.v.e.l.m2.a(this.I);
            long l10 = 2000L;
            object = new i3(this);
            this.I = object = d.v.e.l.m2.Y(l10, (m2$b)object);
        }
    }

    private /* synthetic */ void p4(Integer object) {
        object = this.w;
        CameraView cameraView = this.c;
        ((v6)object).k0(cameraView);
    }

    private void p6() {
        this.r.d();
        d.v.e.l.m2.a(this.G);
        Object object = this.l.b0();
        long l10 = ((CameraSet$DelayTime)((Object)object)).getTime();
        Object object2 = this.b.k.u;
        Object object3 = this.l.b0().getFormatStr();
        object2.setText((CharSequence)object3);
        object2 = TimeUnit.SECONDS;
        long l11 = 0L;
        double d10 = 0.0;
        long l12 = 1L;
        object2 = e.a.j.u3(l11, l12, (TimeUnit)((Object)object2));
        object3 = a.c();
        object2 = ((j)object2).s4((h0)object3);
        object3 = d.q.a.d.a(d.q.a.f0.f.b.h(this));
        object2 = (d.q.a.u)((j)object2).r((k)object3);
        object3 = new y4(this);
        this.F = object2 = object2.d((e.a.v0.g)object3);
        object2 = this.b.k.F;
        object3 = this.getContext();
        int n10 = 2130771986;
        object3 = AnimationUtils.loadAnimation((Context)object3, (int)n10);
        object2.startAnimation((Animation)object3);
        object2 = this.l;
        boolean n11 = ((u6)object2).d1();
        if (n11) {
            int n12 = this.p.G();
            this.b.k.q.setNodeNum(n12);
            object2 = this.b.k.q;
            object3 = this.p;
            List list = (List)((BleViewModel)object3).x.getValue();
            object3 = ((BleViewModel)object3).l(list);
            ((MutiNodeProgress)((Object)object2)).setNode((List)object3);
            this.b.k.q.e(l10);
            this.b.k.q.f();
            object2 = new u1(this);
            this.G = object = d.v.e.l.m2.X(l10, this, (m2$b)object2);
        }
        object = this.c.getRecordCapture();
        d10 = this.l.Z().getTime();
        Double d11 = 1000.0 / d10;
        ((d.v.d.i.g.e)object).n(d11);
    }

    public static /* synthetic */ void q(CameraFragment cameraFragment) {
        cameraFragment.t6();
    }

    public static /* synthetic */ Bitmap q0(CameraFragment cameraFragment) {
        return cameraFragment.b0();
    }

    private /* synthetic */ void q1(Boolean object) {
        Boolean bl2 = Boolean.FALSE;
        Boolean bl3 = Boolean.TRUE;
        boolean bl4 = (Boolean)object;
        if (bl4) {
            this.v.f.postValue(bl2);
            object = this.c.getRecordStatus();
            bl4 = ((d.v.d.i.g.l)object).q();
            if (!bl4) {
                object = this.v.g;
                ((MutableLiveData)object).postValue(bl3);
            } else {
                object = this.v.h;
                ((MutableLiveData)object).postValue(bl3);
            }
        } else {
            this.v.f.postValue(bl3);
            this.v.g.postValue(bl2);
            object = this.v.h;
            ((MutableLiveData)object).postValue(bl2);
        }
    }

    private /* synthetic */ void q5() {
        this.l.k2(false);
    }

    private void q6() {
        LiveData liveData = this.l.f0();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        o2 o22 = new o2(this);
        liveData.observe(lifecycleOwner, o22);
    }

    public static /* synthetic */ void r(CameraFragment cameraFragment, String string2) {
        cameraFragment.U5(string2);
    }

    public static /* synthetic */ float r0(CameraFragment cameraFragment) {
        return cameraFragment.a0();
    }

    private /* synthetic */ void r2(Integer n10) {
        this.c.getPreviewFlash().s(n10);
    }

    private /* synthetic */ void r3(Integer n10) {
        d.v.d.i.f.z z10 = this.c.getPreviewWt();
        int n11 = n10 * 3;
        n11 = 40 - n11;
        z10.y(n11);
    }

    private /* synthetic */ void r4() {
        Object object = this.c.getTextureSize();
        int n10 = ((d.v.b.f0.l.f)object).p();
        Object object2 = this.c.getTextureSize();
        int n11 = ((d.v.b.f0.l.f)object2).o();
        this.w.a0(n10, n11);
        v6 v62 = this.w;
        boolean bl2 = v62.z();
        if (bl2) {
            v62 = this.w;
            v62.c0(n10);
            this.w.b0(n11);
            object = this.L;
            if (object != null) {
                object.dispose();
            }
            n10 = 0;
            object = e.a.z.t3(0);
            object2 = e.a.c1.b.d();
            object = ((e.a.z)object).L5((h0)object2);
            object2 = a.c();
            object = ((e.a.z)object).i4((h0)object2);
            object2 = new q2(this);
            this.L = object = ((e.a.z)object).f2((e.a.v0.g)object2).a();
        }
    }

    private void r6() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h0 h02 = e.a.c1.b.d();
        Object object = e.a.z.m3(500L, 1000L, timeUnit, h02);
        Object object2 = a.c();
        object = ((e.a.z)object).i4((h0)object2);
        object2 = d.q.a.d.a(d.q.a.f0.f.b.h(this));
        object = (d.q.a.y)((e.a.z)object).q((a0)object2);
        object2 = new f1(this);
        this.D = object = object.d((e.a.v0.g)object2);
    }

    public static /* synthetic */ v6 s(CameraFragment cameraFragment) {
        return cameraFragment.w;
    }

    public static /* synthetic */ boolean s0(CameraFragment cameraFragment) {
        return cameraFragment.l0();
    }

    private /* synthetic */ void s1(Boolean comparable) {
        d.v.d.i.e.c c10 = this.c.getPhotoMirror();
        int n10 = comparable.booleanValue();
        n10 = n10 != 0 ? 1 : 2;
        comparable = n10;
        c10.o((Integer)comparable);
    }

    private /* synthetic */ void s5() {
        Boolean bl2;
        Object object = this.s;
        int n10 = ((d.v.c.s0.a7.j1)object).b();
        if (n10 == 0) {
            object = this.p;
            bl2 = null;
            ((BleViewModel)object).a1(false);
        }
        this.l.k2(true);
        object = this.s.a;
        bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
    }

    private void s6() {
        Object object = this.l;
        int n10 = 1;
        ((u6)object).j2(n10 != 0);
        this.u6();
        this.A6();
        object = (Integer)this.l.g0().getValue();
        int n11 = d.v.e.h.d.c((Integer)object);
        if (n11 == n10) {
            object = this.b.k.w;
            n10 = 8;
            object.setVisibility(n10);
        }
    }

    public static /* synthetic */ m2$d t(CameraFragment cameraFragment, m2$d m2$d) {
        cameraFragment.K = m2$d;
        return m2$d;
    }

    public static /* synthetic */ void t0(CameraFragment cameraFragment) {
        cameraFragment.q6();
    }

    private /* synthetic */ void t2(Integer n10) {
        this.c.getMaskGrid().o(n10);
    }

    private /* synthetic */ void t3(CameraSet$HitchcockGuide cameraSet$HitchcockGuide) {
        d.v.c.s0.c7.p p10;
        Object object;
        if (cameraSet$HitchcockGuide != null && (object = CameraSet$HitchcockGuide.FINISH) != cameraSet$HitchcockGuide && (p10 = this.T) != null) {
            Context context = this.requireContext();
            x0 x02 = this.b;
            DynamicZoomViewModel dynamicZoomViewModel = this.v;
            object = this.u;
            int n10 = ((d.v.c.s0.d7.z)object).l;
            boolean bl2 = this.k;
            s6 s62 = this.r;
            int n11 = this.e;
            int n12 = this.g;
            p10.r(cameraSet$HitchcockGuide, context, x02, dynamicZoomViewModel, n10, bl2, s62, n11, n12);
        }
    }

    private /* synthetic */ void t4(Uri uri) {
        boolean bl2 = true;
        Context context = new Object[bl2];
        context[0] = uri;
        m.a.a.i("ImageSaver: %s", (Object[])context);
        context = this.requireContext();
        String string2 = d.v.e.l.s1.G(uri);
        a2.f(context, string2);
        this.r.g0(bl2, uri);
    }

    private void t6() {
        u6 u62 = this.l;
        boolean bl2 = true;
        u62.h2(bl2);
        this.b.b.setChecked(bl2);
        this.b.E.setScrollEnable(false);
    }

    public static /* synthetic */ void u(CameraFragment cameraFragment, int n10) {
        cameraFragment.j6(n10);
    }

    public static /* synthetic */ void u0(CameraFragment cameraFragment) {
        cameraFragment.e0();
    }

    private /* synthetic */ void u1(String string2) {
        this.O = string2;
    }

    private /* synthetic */ void u5(DialogFragment object) {
        ((DialogFragment)object).dismiss();
        object = this.r;
        boolean bl2 = true;
        ((s6)object).Y(bl2);
        object = (Boolean)this.p.L.getValue();
        boolean bl3 = d.v.e.h.a.c((Boolean)object);
        if (bl3) {
            object = d1.A();
            Object object2 = new r2(this);
            ((d.v.f.g.b)object).n((b$b)object2);
            object2 = this.getChildFragmentManager();
            ((d.v.f.g.b)object).q((FragmentManager)object2);
        } else {
            this.e0();
        }
    }

    private void u6() {
        long l10;
        this.N = l10 = System.currentTimeMillis();
        Object object = (CameraSet$Mode)((Object)this.l.H().getValue());
        this.h6((CameraSet$Mode)((Object)object));
        object = this.c.getRecordControl();
        Integer n10 = 0;
        ((d.v.d.i.g.f)object).n(n10);
        this.w.Q();
    }

    public static /* synthetic */ void v(CameraFragment cameraFragment) {
        cameraFragment.u6();
    }

    private /* synthetic */ void v0() {
        MutableLiveData mutableLiveData = this.s.a;
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
    }

    private /* synthetic */ void v2(Boolean bl2) {
        boolean bl3;
        Object object;
        Object object2 = this.b.L;
        int n10 = bl2.booleanValue();
        int n11 = 1;
        ((TrackView)((Object)object2)).f((n10 ^= n11) != 0);
        object2 = this.b.L;
        n10 = bl2 ^ n11;
        ((TrackView)((Object)object2)).e(n10 != 0);
        this.J6(n11 != 0, false);
        object2 = this.c.getDeviceStatus();
        boolean bl4 = ((c)object2).r();
        if (bl4) {
            object = this.c.getPreviewFace();
            n11 = bl2.booleanValue();
            object.m(n11 != 0);
        }
        if (bl3 = bl2.booleanValue()) {
            if (bl4) {
                this.q6();
            }
            bl2 = this.b.k.w;
            object2 = this.l.H().getValue();
            if (object2 == (object = CameraSet$Mode.panorama)) {
                object2 = this.getResources();
                n10 = 2131953257;
                object2 = d.v.f.i.g.o((Resources)object2, n10);
            } else {
                object2 = this.getResources();
                n10 = 2131953256;
                object2 = d.v.f.i.g.o((Resources)object2, n10);
            }
            bl2.setText((CharSequence)object2);
            this.S5();
        } else if (bl4) {
            this.C6();
        }
    }

    private /* synthetic */ void v3(Integer object) {
        boolean bl2 = ((Integer)object).intValue();
        boolean bl3 = true;
        if (bl2) {
            if (bl2 != bl3) {
                boolean bl4 = 2 != 0;
                if (bl2 != bl4) {
                    boolean bl5 = 3 != 0;
                    if (bl2 == bl5) {
                        this.w.X(bl3, bl3);
                        object = this.b.E;
                        ((ModeSwitch)object).setTouchable(false);
                    }
                } else {
                    object = this.b.E;
                    ((ModeSwitch)object).setTouchable(false);
                }
            } else {
                this.w.Q();
                object = this.w;
                ((v6)object).X(bl3, false);
                this.t6();
            }
        } else {
            this.w.X(false, false);
            object = this.b.E;
            ((ModeSwitch)object).setTouchable(bl3);
            this.E6();
        }
    }

    public static /* synthetic */ void v4(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "ImageSaver", objectArray);
    }

    private void v6() {
        Object object = this.getViewLifecycleOwner();
        y0 y02 = new y0(this);
        this.R = object = d.v.e.l.m2.X(9000L, (LifecycleOwner)object, y02);
    }

    public static /* synthetic */ CameraView w(CameraFragment cameraFragment) {
        return cameraFragment.c;
    }

    private /* synthetic */ void w1(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.b.j;
            HintLayout$b hintLayout$b = CameraSet$Exception.FW_UPDATE.getHint();
            int n10 = 1;
            Object object2 = new Object[n10];
            String string2 = this.O;
            object2[0] = string2;
            hintLayout$b = hintLayout$b.w(object2);
            object2 = new u4(this);
            hintLayout$b = hintLayout$b.n((View.OnClickListener)object2);
            object2 = new y3(this);
            hintLayout$b = hintLayout$b.p((View.OnClickListener)object2);
            ((HintLayout)((Object)object)).a(hintLayout$b);
        } else {
            object = this.b.j;
            String string3 = CameraSet$Exception.FW_UPDATE.getHint().i();
            ((HintLayout)((Object)object)).d(string3);
        }
    }

    private /* synthetic */ void w4(View view) {
        this.J.r0();
    }

    private /* synthetic */ void w5(Long l10) {
        long l11 = l10;
        long l12 = 1000L;
        long l13 = this.l.Z().getTime();
        TextView textView = this.b.k.C;
        String string2 = this.l.X(l13, l11 *= l12);
        textView.setText((CharSequence)string2);
        string2 = this.b.k.u;
        Object object = u6.e(l11 / l12);
        string2.setText((CharSequence)object);
        object = this.w;
        int n10 = this.l.Q().c();
        ((v6)object).h0(l11, n10);
        v6 v62 = this.w;
        int n11 = l10.intValue();
        v62.V(n11);
    }

    private void w6() {
        m2$d m2$d = this.K;
        if (m2$d != null) {
            m2$d.a();
        }
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        CameraFragment$g cameraFragment$g = new CameraFragment$g(this);
        this.K = m2$d = d.v.e.l.m2.b(0L, 1000L, 30, lifecycleOwner, cameraFragment$g);
    }

    public static /* synthetic */ void x(CameraFragment cameraFragment) {
        cameraFragment.F6();
    }

    private /* synthetic */ void x0(CameraSet$Mode object) {
        boolean bl2;
        Object object2 = this.r.n;
        Boolean bl3 = Boolean.FALSE;
        object2.setValue(bl3);
        object2 = this.r.m;
        bl3 = Boolean.TRUE;
        object2.setValue(bl3);
        object2 = CameraSet$Mode.delay_video;
        if (object2 == object && (bl2 = ((Lifecycle$State)((Object)(object = this.getLifecycle().getCurrentState()))).isAtLeast((Lifecycle$State)((Object)(object2 = Lifecycle$State.RESUMED))))) {
            object = this.l;
            object2 = this.getResources();
            int n10 = 2131951825;
            object2 = d.v.f.i.g.o((Resources)object2, n10);
            ((u6)object).o2((String)object2);
        }
    }

    private /* synthetic */ void x2(Boolean object) {
        Object object2 = this.w;
        boolean bl2 = (Boolean)object;
        object2.g0(bl2);
        boolean bl3 = (Boolean)object;
        if (bl3) {
            object = this.r;
            bl3 = ((s6)object).s();
            if (bl3 && !(bl3 = ((s6)(object = this.r)).m())) {
                object = d1.A();
                object2 = this.getChildFragmentManager();
                ((d.v.f.g.b)object).q((FragmentManager)object2);
            }
            object = ((Stabilizer)this.p.N.getValue()).w2();
            this.b.m.clearAnimation();
            this.l.c();
            object2 = this.r;
            ((s6)object2).M((Model)((Object)object));
        } else {
            object = this.m.v();
            if (object != (object2 = CameraSet$StoryState.STORY_RECORD)) {
                object = this.requireContext();
                int n10 = 2130771980;
                object = AnimationUtils.loadAnimation((Context)object, (int)n10);
                this.b.m.startAnimation((Animation)object);
                this.t.R();
                object = this.l.I();
                object2 = CameraSet$Mode.panorama;
                if (object == object2 && (bl3 = ((d.v.c.s0.g7.e)(object = this.y)).c())) {
                    object = this.y;
                    ((d.v.c.s0.g7.e)object).a();
                }
                if (bl3 = ((BleViewModel)(object = this.p)).K()) {
                    object = this.p;
                    ((BleViewModel)object).e();
                }
            }
        }
        object = this.B;
        object2 = this.getChildFragmentManager();
        s6 s62 = this.r;
        bl3 = ((d.v.c.s0.h7.u0.j)object).t((FragmentManager)object2, s62);
        if (bl3 && (bl3 = this.m0())) {
            object = this.b.b;
            object.performClick();
        }
    }

    private /* synthetic */ void x3(DeviceViewModel$NetWorkEvent object) {
        this.U.R((DeviceViewModel$NetWorkEvent)((Object)object));
        Object object2 = d.v.a0.m1.o();
        boolean bl2 = object2.g();
        if (bl2) {
            return;
        }
        object2 = DeviceViewModel$NetWorkEvent.NET_WORK_WIFI_CONNECTED;
        if (object2 == object) {
            object2 = this.w;
            boolean bl3 = true;
            ((v6)object2).s(bl3);
        }
        if ((object2 = DeviceViewModel$NetWorkEvent.NET_WORK_WIFI_DISCONNECTED) == object) {
            object = this.w;
            bl2 = false;
            object2 = null;
            ((v6)object).s(false);
        }
    }

    private void x6() {
        Object object = this.b.k.e;
        long l10 = SystemClock.elapsedRealtime();
        object.setBase(l10);
        this.b.k.e.setFormat("00:%s");
        this.b.k.e.start();
        object = this.b.k.e;
        Object object2 = new v4(this);
        object.setOnChronometerTickListener((Chronometer.OnChronometerTickListener)object2);
        object = this.b.k.E;
        object2 = AnimationUtils.loadAnimation((Context)this.getContext(), (int)2130771986);
        object.startAnimation((Animation)object2);
        int n10 = this.l.z0();
        object2 = this.c.getRecordCapture();
        double d10 = n10;
        object = 30.0 / d10;
        ((d.v.d.i.g.e)object2).n((Double)object);
    }

    public static /* synthetic */ m0 y(CameraFragment cameraFragment) {
        return cameraFragment.m;
    }

    private /* synthetic */ void y1(Pair object) {
        Object object2;
        if (object != null && (object2 = ((Pair)object).first) != null && (object2 = ((CameraSet$Exception)((Object)object2)).getHint()) != null) {
            object2 = (Boolean)((Pair)object).second;
            boolean bl2 = d.v.e.h.a.c((Boolean)object2);
            if (bl2) {
                object2 = this.b.j;
                object = ((CameraSet$Exception)((Object)((Pair)object).first)).getHint();
                ((HintLayout)((Object)object2)).a((HintLayout$b)object);
            } else {
                object2 = this.b.j;
                object = ((CameraSet$Exception)((Object)((Pair)object).first)).getHint().i();
                ((HintLayout)((Object)object2)).d((String)object);
            }
        }
    }

    private /* synthetic */ void y4(View view) {
        this.J.g();
    }

    private /* synthetic */ void y5() {
        this.b.b.performClick();
    }

    private void y6() {
        Object object = this.A;
        Object object2 = new CameraFragment$h(this);
        boolean bl2 = ((k0)object).h0((k0$d)object2);
        if (bl2) {
            object = this.Y.a;
            boolean bl3 = false;
            object2 = null;
            object.setChecked(false);
        } else {
            object = this.n;
            bl2 = ((d.v.c.s0.h7.u0.l)object).r();
            if (bl2) {
                object = this.p.D;
                int n10 = 2131953153;
                object2 = n10;
                ((d.v.e.i.j)object).setValue(object2);
            } else {
                object2 = this.getContext();
                object = new k$b((Context)object2);
                object2 = this.getResources();
                int n11 = 2131953151;
                object2 = d.v.f.i.g.o((Resources)object2, n11);
                object = (k$b)((k$a)object).B((String)object2);
                object2 = d.v.c.s0.i.a;
                object = (k$b)((k$a)object).w((d.v.f.f.a)object2);
                object2 = this.getChildFragmentManager();
                ((k$a)object).D((FragmentManager)object2);
            }
        }
    }

    public static /* synthetic */ void z(CameraFragment cameraFragment) {
        cameraFragment.L6();
    }

    private /* synthetic */ void z0(int n10) {
        this.b.E.setSelected(n10);
    }

    private /* synthetic */ void z2(Boolean bl2) {
        this.k6();
    }

    private /* synthetic */ void z3(Boolean bl2) {
        ModeSwitch modeSwitch = this.b.E;
        boolean bl3 = bl2 ^ true;
        modeSwitch.setScrollEnable(bl3);
    }

    public /* synthetic */ void A0(int n10) {
        this.z0(n10);
    }

    public /* synthetic */ void A2(Boolean bl2) {
        this.z2(bl2);
    }

    public /* synthetic */ void A3(Boolean bl2) {
        this.z3(bl2);
    }

    public /* synthetic */ void B4(DialogFragment dialogFragment) {
        this.A4(dialogFragment);
    }

    public /* synthetic */ void B5(Boolean bl2) {
        this.A5(bl2);
    }

    public /* synthetic */ void C1(Pair pair) {
        this.B1(pair);
    }

    public /* synthetic */ void C2(Boolean bl2) {
        this.B2(bl2);
    }

    public /* synthetic */ void C3(Integer n10) {
        this.B3(n10);
    }

    public /* synthetic */ void D0(CameraSet$Guide cameraSet$Guide) {
        this.C0(cameraSet$Guide);
    }

    public /* synthetic */ void D4(DialogFragment dialogFragment) {
        this.C4(dialogFragment);
    }

    public /* synthetic */ void D5(Long l10) {
        this.C5(l10);
    }

    public /* synthetic */ void E1(Boolean bl2) {
        this.D1(bl2);
    }

    public /* synthetic */ void E2(Boolean bl2) {
        this.D2(bl2);
    }

    public /* synthetic */ void F0(List list, int n10) {
        this.E0(list, n10);
    }

    public /* synthetic */ void F3(Boolean bl2) {
        this.E3(bl2);
    }

    public /* synthetic */ void F4(int n10) {
        this.E4(n10);
    }

    public /* synthetic */ void F5() {
        this.E5();
    }

    public /* synthetic */ void G1(Integer n10) {
        this.F1(n10);
    }

    public /* synthetic */ void G2(Boolean bl2) {
        this.F2(bl2);
    }

    public /* synthetic */ void H0(MotionEvent motionEvent, int n10) {
        this.G0(motionEvent, n10);
    }

    public /* synthetic */ void H3(Boolean bl2) {
        this.G3(bl2);
    }

    public /* synthetic */ void H4(DialogFragment dialogFragment) {
        this.G4(dialogFragment);
    }

    public /* synthetic */ void H5(Chronometer chronometer) {
        this.G5(chronometer);
    }

    public /* synthetic */ void I1(Boolean bl2) {
        this.H1(bl2);
    }

    public /* synthetic */ void I2(Boolean bl2) {
        this.H2(bl2);
    }

    public /* synthetic */ void J0(Float f10, int n10) {
        this.I0(f10, n10);
    }

    public /* synthetic */ void J3(CameraSet$DelayInterval cameraSet$DelayInterval) {
        this.I3(cameraSet$DelayInterval);
    }

    public /* synthetic */ void J4() {
        this.I4();
    }

    public /* synthetic */ void K1(CameraSet$Mode cameraSet$Mode) {
        this.J1(cameraSet$Mode);
    }

    public /* synthetic */ void K2(Boolean bl2) {
        this.J2(bl2);
    }

    public /* synthetic */ void K5(Chronometer chronometer) {
        this.J5(chronometer);
    }

    public /* synthetic */ void L0(Integer n10, int n11) {
        this.K0(n10, n11);
    }

    public /* synthetic */ void L3(CameraSet$DelayTime cameraSet$DelayTime) {
        this.K3(cameraSet$DelayTime);
    }

    public /* synthetic */ void L4() {
        this.K4();
    }

    public /* synthetic */ void M1(Boolean bl2) {
        this.L1(bl2);
    }

    public /* synthetic */ void M2(Boolean bl2) {
        this.L2(bl2);
    }

    public /* synthetic */ void M5() {
        this.L5();
    }

    public /* synthetic */ void N0(CompoundButton compoundButton, boolean bl2) {
        this.M0(compoundButton, bl2);
    }

    public /* synthetic */ void N3(Pair pair) {
        this.M3(pair);
    }

    public /* synthetic */ void O1(Integer n10) {
        this.N1(n10);
    }

    public /* synthetic */ void O2(String string2) {
        this.N2(string2);
    }

    public /* synthetic */ void O4() {
        this.N4();
    }

    public /* synthetic */ void O5(d.v.c.s0.z6.a a10) {
        this.N5(a10);
    }

    public /* synthetic */ void P0(View view) {
        this.O0(view);
    }

    public /* synthetic */ void P3(Pair pair) {
        this.O3(pair);
    }

    public /* synthetic */ void Q1(Integer n10, int n11) {
        this.P1(n10, n11);
    }

    public /* synthetic */ void Q2(String string2) {
        this.P2(string2);
    }

    public /* synthetic */ void Q4() {
        this.P4();
    }

    public /* synthetic */ void R0(View view) {
        this.Q0(view);
    }

    public /* synthetic */ void R3(Boolean bl2) {
        this.Q3(bl2);
    }

    public /* synthetic */ void S1(Integer n10) {
        this.R1(n10);
    }

    public /* synthetic */ void S2(Integer n10) {
        this.R2(n10);
    }

    public /* synthetic */ void S4() {
        this.R4();
    }

    public /* synthetic */ void T0(View view) {
        this.S0(view);
    }

    public /* synthetic */ void T3(Boolean bl2) {
        this.S3(bl2);
    }

    public /* synthetic */ void U1(Float f10) {
        this.T1(f10);
    }

    public /* synthetic */ void U2(Integer n10) {
        this.T2(n10);
    }

    public /* synthetic */ void U4() {
        this.T4();
    }

    public /* synthetic */ void V0(View view) {
        this.U0(view);
    }

    public /* synthetic */ void V3(Boolean bl2) {
        this.U3(bl2);
    }

    public /* synthetic */ void W1(Float f10) {
        this.V1(f10);
    }

    public /* synthetic */ void W2(Integer n10) {
        this.V2(n10);
    }

    public /* synthetic */ void W4(Integer n10) {
        this.V4(n10);
    }

    public /* synthetic */ void X0(d.v.n.j.b b10) {
        this.W0(b10);
    }

    public /* synthetic */ void X3(Boolean bl2) {
        this.W3(bl2);
    }

    public /* synthetic */ void Y1(Float f10) {
        this.X1(f10);
    }

    public /* synthetic */ void Y2(Integer n10) {
        this.X2(n10);
    }

    public /* synthetic */ void Y4(DialogFragment dialogFragment) {
        this.X4(dialogFragment);
    }

    public /* synthetic */ void Z0() {
        this.Y0();
    }

    public /* synthetic */ void Z3(String string2) {
        this.Y3(string2);
    }

    public /* synthetic */ void a2(Float f10) {
        this.Z1(f10);
    }

    public /* synthetic */ void a3(Integer n10) {
        this.Z2(n10);
    }

    public /* synthetic */ void a5(DialogFragment dialogFragment) {
        this.Z4(dialogFragment);
    }

    public /* synthetic */ void b1(View view) {
        this.a1(view);
    }

    public /* synthetic */ void b4(Boolean bl2) {
        this.a4(bl2);
    }

    public /* synthetic */ void c2(Float f10) {
        this.b2(f10);
    }

    public /* synthetic */ void c3(RectF rectF) {
        this.b3(rectF);
    }

    public /* synthetic */ void c5(View view) {
        this.b5(view);
    }

    public void d0() {
        d.v.c.i1.s2.q.h().k();
        q q10 = d.v.c.i1.s2.q.h();
        boolean bl2 = q10.p();
        if (bl2) {
            q10 = d.v.c.i1.s2.q.h();
            q10.c();
        }
    }

    public /* synthetic */ void d1(Integer n10, int n11) {
        this.c1(n10, n11);
    }

    public /* synthetic */ void d4(Boolean bl2) {
        this.c4(bl2);
    }

    public void e() {
        Object object = this.b;
        if (object != null) {
            object = ((x0)object).b;
            Context context = this.requireContext();
            int n10 = this.l.I().getActionDrawableRes();
            context = d.v.f.i.g.f(context, n10);
            object.setBackground((Drawable)context);
            object = this.b.p;
            context = this.requireContext();
            Object object2 = this.l.I();
            CameraSet$Mode cameraSet$Mode = CameraSet$Mode.panorama;
            if (object2 == cameraSet$Mode) {
                object2 = this.l.q0();
                n10 = ((CameraSet$CountDownTime)((Object)object2)).getDrawableRes();
            } else {
                object2 = this.l.S();
                n10 = ((CameraSet$CountDownTime)((Object)object2)).getDrawableRes();
            }
            context = d.v.f.i.g.f(context, n10);
            object.setImageDrawable((Drawable)context);
            object = this.b.u;
            context = this.requireContext();
            n10 = this.l.o0().getDrawableRes();
            context = d.v.f.i.g.f(context, n10);
            object.setImageDrawable((Drawable)context);
            object = this.b.q;
            context = this.requireContext();
            object2 = (Integer)this.l.c0().getValue();
            n10 = d.v.e.h.d.c((Integer)object2);
            context = d.v.f.i.g.f(context, n10);
            object.setImageDrawable((Drawable)context);
            object = (CharSequence)this.r.k.getValue();
            int n11 = TextUtils.isEmpty((CharSequence)object);
            n11 = n11 != 0 ? 2131231582 : 2131231575;
            context = this.b.w;
            object2 = this.requireContext();
            object = d.v.f.i.g.f((Context)object2, n11);
            context.setBackground((Drawable)object);
        }
        super.e();
    }

    public /* synthetic */ void e2(Float f10) {
        this.d2(f10);
    }

    public /* synthetic */ void e3(Integer n10) {
        this.d3(n10);
    }

    public /* synthetic */ void e5(Long l10) {
        this.d5(l10);
    }

    public /* synthetic */ void f1(Size size, int n10) {
        this.e1(size, n10);
    }

    public /* synthetic */ void f4(Float f10) {
        this.e4(f10);
    }

    public /* synthetic */ void g2(Integer n10) {
        this.f2(n10);
    }

    public /* synthetic */ void g3(BleViewModel$PanoramaState bleViewModel$PanoramaState) {
        this.f3(bleViewModel$PanoramaState);
    }

    public /* synthetic */ void g5() {
        this.f5();
    }

    public int h() {
        return 2131558461;
    }

    public /* synthetic */ void h1(Integer n10, int n11) {
        this.g1(n10, n11);
    }

    public /* synthetic */ void h4(Integer[] integerArray) {
        this.g4(integerArray);
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (p0)viewDataBinding;
        this.W = viewDataBinding;
        viewDataBinding.setLifecycleOwner(this);
        viewDataBinding = this.W;
        ViewModel viewModel = this.l;
        ((p0)viewDataBinding).X((u6)viewModel);
        viewDataBinding = this.W;
        viewModel = this.r;
        ((p0)viewDataBinding).W((s6)viewModel);
        viewDataBinding = this.W;
        viewModel = this.m;
        ((p0)viewDataBinding).U((m0)viewModel);
        viewDataBinding = this.W;
        viewModel = this.n;
        ((p0)viewDataBinding).T((d.v.c.s0.h7.u0.l)viewModel);
        viewDataBinding = this.W;
        viewModel = this.p;
        ((p0)viewDataBinding).L((BleViewModel)viewModel);
        viewDataBinding = this.W;
        viewModel = this.q;
        ((p0)viewDataBinding).N((DeviceViewModel)viewModel);
        viewDataBinding = this.W;
        viewModel = this.t;
        ((p0)viewDataBinding).Q((c1)viewModel);
        viewDataBinding = this.W;
        viewModel = this.u;
        ((p0)viewDataBinding).R((d.v.c.s0.d7.z)viewModel);
        viewDataBinding = this.W;
        viewModel = this.w;
        ((p0)viewDataBinding).S((v6)viewModel);
        viewDataBinding = this.W;
        viewModel = this.o;
        ((p0)viewDataBinding).V((w6)viewModel);
        viewDataBinding = this.W;
        viewModel = this.v;
        ((p0)viewDataBinding).P((DynamicZoomViewModel)viewModel);
    }

    public /* synthetic */ void i2(Integer n10) {
        this.h2(n10);
    }

    public /* synthetic */ void i3(List list) {
        this.h3(list);
    }

    public /* synthetic */ Bitmap i5() {
        return this.h5();
    }

    public /* synthetic */ void j1(d.v.d.i.a.b b10, int n10) {
        this.i1(b10, n10);
    }

    public /* synthetic */ void j4() {
        this.i4();
    }

    public /* synthetic */ void k2(CameraSet$StoryState cameraSet$StoryState) {
        this.j2(cameraSet$StoryState);
    }

    public /* synthetic */ void k3(BleViewModel$MoveState bleViewModel$MoveState) {
        this.j3(bleViewModel$MoveState);
    }

    public /* synthetic */ void k5(int n10) {
        this.j5(n10);
    }

    public /* synthetic */ void l1(Float f10) {
        this.k1(f10);
    }

    public /* synthetic */ void l4(int n10) {
        this.k4(n10);
    }

    public /* synthetic */ void m2(Integer n10) {
        this.l2(n10);
    }

    public /* synthetic */ void m3(Boolean bl2) {
        this.l3(bl2);
    }

    public /* synthetic */ void n1(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel) {
        this.m1(dynamicZoomViewModel$TargetModel);
    }

    public /* synthetic */ void n5() {
        this.m5();
    }

    public void n6(DynamicZoomViewModel$TargetModel object, float f10) {
        d.v.d.i.a.a a10 = this.c.getPreviewWt();
        Float f11 = Float.valueOf(f10);
        ((d.v.d.i.f.z)a10).x(f11);
        a10 = this.c.getPreviewFocus();
        boolean bl2 = true;
        Integer n10 = (int)(bl2 ? 1 : 0);
        ((d.v.d.i.f.j)a10).o(n10);
        float f12 = this.v.U((DynamicZoomViewModel$TargetModel)((Object)object), bl2, f10);
        MutableLiveData mutableLiveData = this.v.t();
        object = Float.valueOf(this.v.j(f12));
        mutableLiveData.postValue(object);
    }

    public /* synthetic */ void o2(TemplatePOJO templatePOJO) {
        this.n2(templatePOJO);
    }

    public /* synthetic */ void o3(Boolean bl2) {
        this.n3(bl2);
    }

    public /* synthetic */ void o4() {
        this.n4();
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        if (intent != null) {
            u u10 = this.U;
            u10.S(n10, intent);
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        Object object2 = d.v.i0.b.a(this);
        Object object3 = (u6)((ViewModelProvider)object).get(u6.class);
        this.l = object3;
        b0 b02 = new b0(this);
        ((u6)object3).a2(b02);
        object3 = (m0)((ViewModelProvider)object).get(m0.class);
        this.m = object3;
        object3 = (d.v.c.s0.h7.u0.l)((ViewModelProvider)object).get(d.v.c.s0.h7.u0.l.class);
        this.n = object3;
        object3 = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
        this.p = object3;
        object3 = (s6)((ViewModelProvider)object).get(s6.class);
        this.r = object3;
        object3 = (d.v.c.s0.a7.j1)((ViewModelProvider)object).get(d.v.c.s0.a7.j1.class);
        this.s = object3;
        object3 = (DeviceViewModel)((ViewModelProvider)object2).get(DeviceViewModel.class);
        this.q = object3;
        this.o = object2 = (w6)((ViewModelProvider)object2).get(w6.class);
        this.t = object2 = (c1)((ViewModelProvider)object).get(c1.class);
        this.u = object2 = (d.v.c.s0.d7.z)((ViewModelProvider)object).get(d.v.c.s0.d7.z.class);
        this.v = object2 = (DynamicZoomViewModel)((ViewModelProvider)object).get(DynamicZoomViewModel.class);
        object3 = this.p0;
        ((DynamicZoomViewModel)object2).L((DynamicZoomViewModel$f)object3);
        this.v.H(false);
        this.w = object2 = (v6)((ViewModelProvider)object).get(v6.class);
        this.x = object = (d.v.c.s0.f7.d)((ViewModelProvider)object).get(d.v.c.s0.f7.d.class);
    }

    public void onDestroy() {
        d.v.c.i1.s2.q.h().d();
        this.v.A();
        this.B = null;
        super.onDestroy();
    }

    public void onPause() {
        Object object;
        Object object2 = this.x;
        Object object3 = this.requireActivity();
        ((d.v.c.s0.f7.d)object2).r((FragmentActivity)object3);
        object2 = this.w;
        object3 = null;
        ((v6)object2).s(false);
        r6.b().g();
        object2 = this.b;
        if (object2 != null) {
            object2 = ((x0)object2).m;
            object2.clearAnimation();
        }
        if ((object2 = this.l.I()) != (object = CameraSet$Mode.story)) {
            object2 = this.i;
            object2.disable();
        } else {
            object2 = this.C;
            object = this.Y;
            m0 m02 = this.m;
            int n10 = m02.j();
            ((i0)object2).o((yh)object, n10, false);
        }
        this.J6(true, false);
        this.S();
        this.C6();
        object2 = this.w;
        object3 = this.c;
        ((v6)object2).m0((CameraView)object3);
        this.p.y1();
        this.v.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        boolean bl2 = this.k0;
        if (!bl2) {
            this.k0 = bl2 = true;
            MutableLiveData mutableLiveData = this.r.a;
            LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
            e4 e42 = new e4(this);
            mutableLiveData.observe(lifecycleOwner, e42);
        }
        this.V();
    }

    public void onStop() {
        this.w.s(false);
        this.r.b();
        super.onStop();
    }

    public /* synthetic */ void p1(Boolean bl2) {
        this.o1(bl2);
    }

    public /* synthetic */ void p5() {
        this.o5();
    }

    public /* synthetic */ void q2(CameraParam cameraParam) {
        this.p2(cameraParam);
    }

    public /* synthetic */ void q3(String string2) {
        this.p3(string2);
    }

    public /* synthetic */ void q4(Integer n10) {
        this.p4(n10);
    }

    public /* synthetic */ void r1(Boolean bl2) {
        this.q1(bl2);
    }

    public /* synthetic */ void r5() {
        this.q5();
    }

    public /* synthetic */ void s2(Integer n10) {
        this.r2(n10);
    }

    public /* synthetic */ void s3(Integer n10) {
        this.r3(n10);
    }

    public /* synthetic */ void s4() {
        this.r4();
    }

    public /* synthetic */ void t1(Boolean bl2) {
        this.s1(bl2);
    }

    public /* synthetic */ void t5() {
        this.s5();
    }

    public /* synthetic */ void u2(Integer n10) {
        this.t2(n10);
    }

    public /* synthetic */ void u3(CameraSet$HitchcockGuide cameraSet$HitchcockGuide) {
        this.t3(cameraSet$HitchcockGuide);
    }

    public /* synthetic */ void u4(Uri uri) {
        this.t4(uri);
    }

    public /* synthetic */ void v1(String string2) {
        this.u1(string2);
    }

    public /* synthetic */ void v5(DialogFragment dialogFragment) {
        this.u5(dialogFragment);
    }

    public /* synthetic */ void w0() {
        this.v0();
    }

    public /* synthetic */ void w2(Boolean bl2) {
        this.v2(bl2);
    }

    public /* synthetic */ void w3(Integer n10) {
        this.v3(n10);
    }

    public /* synthetic */ void x1(Boolean bl2) {
        this.w1(bl2);
    }

    public /* synthetic */ void x4(View view) {
        this.w4(view);
    }

    public /* synthetic */ void x5(Long l10) {
        this.w5(l10);
    }

    public /* synthetic */ void y0(CameraSet$Mode cameraSet$Mode) {
        this.x0(cameraSet$Mode);
    }

    public /* synthetic */ void y2(Boolean bl2) {
        this.x2(bl2);
    }

    public /* synthetic */ void y3(DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent) {
        this.x3(deviceViewModel$NetWorkEvent);
    }

    public /* synthetic */ void z1(Pair pair) {
        this.y1(pair);
    }

    public /* synthetic */ void z4(View view) {
        this.y4(view);
    }

    public /* synthetic */ void z5() {
        this.y5();
    }

    public void z6(RectF object) {
        Object object2 = this.l;
        boolean bl2 = ((u6)object2).j0();
        if (bl2) {
            this.C6();
        }
        Object object3 = this.o;
        o o10 = new o(this);
        w0 w02 = new w0(this);
        m1 m12 = new m1(this);
        a5 a52 = new a5(this);
        q3 q32 = new q3(this);
        Object object4 = object;
        ((w6)object3).S((RectF)object, o10, w02, m12, a52, q32);
        object2 = this.l.I();
        object3 = CameraSet$Mode.dolly_zoom;
        if (object2 == object3) {
            object2 = this.v;
            int n10 = this.c.getWidth();
            int n11 = this.c.getHeight();
            ((DynamicZoomViewModel)object2).G(n10, n11);
            object2 = this.v;
            object3 = (Float)this.c.getPreviewWt().e();
            float f10 = ((Float)object3).floatValue();
            object4 = (Float)this.c.getPreviewWt().f();
            float f11 = ((Float)object4).floatValue();
            ((DynamicZoomViewModel)object2).R(f10, f11);
            object2 = this.v;
            f10 = this.P;
            ((DynamicZoomViewModel)object2).w((RectF)object, f10);
            object = this.b.L;
            bl2 = false;
            object2 = null;
            ((TrackView)((Object)object)).setSelectRectRed(false);
        }
    }
}

