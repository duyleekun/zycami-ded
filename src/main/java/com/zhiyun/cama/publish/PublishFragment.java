/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.media.MediaMetadataRetriever
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.InputFilter
 *  android.text.TextUtils
 *  android.util.Size
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.webkit.URLUtil
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package com.zhiyun.cama.publish;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Size;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.internal.FlowLayout;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.me.account.AccountActivity;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.PublishState;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.data.me.remote.KWaiManager;
import com.zhiyun.cama.data.me.remote.data.KwaiTokenInfo;
import com.zhiyun.cama.main.EditorMainActivity;
import com.zhiyun.cama.publish.CreationActivity;
import com.zhiyun.cama.publish.PublishFragment$a;
import com.zhiyun.cama.publish.PublishFragment$b;
import com.zhiyun.cama.publish.PublishFragment$c;
import com.zhiyun.cama.publish.PublishFragment$d;
import com.zhiyun.cama.publish.PublishFragment$e;
import com.zhiyun.cama.publish.PublishFragment$f;
import com.zhiyun.cama.publish.PublishFragment$g;
import com.zhiyun.cama.publish.PublishWorksService;
import com.zhiyun.cama.splash.SplashActivity;
import com.zhiyun.common.util.Windows;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import com.zhiyun.editortemplate.data.api.entity.template.Description;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import com.zhiyun.image.Images;
import com.zhiyun.permission.Permission;
import d.v.c.n1.a1;
import d.v.c.n1.b0;
import d.v.c.n1.b1;
import d.v.c.n1.c0;
import d.v.c.n1.c1;
import d.v.c.n1.d0;
import d.v.c.n1.d1;
import d.v.c.n1.e0;
import d.v.c.n1.e1;
import d.v.c.n1.f0;
import d.v.c.n1.f1;
import d.v.c.n1.g0;
import d.v.c.n1.g1;
import d.v.c.n1.h1;
import d.v.c.n1.i1;
import d.v.c.n1.i2;
import d.v.c.n1.j1;
import d.v.c.n1.j2;
import d.v.c.n1.k1;
import d.v.c.n1.k2$b;
import d.v.c.n1.l1;
import d.v.c.n1.s0;
import d.v.c.n1.t0;
import d.v.c.n1.u0;
import d.v.c.n1.v0;
import d.v.c.n1.w0;
import d.v.c.n1.x0;
import d.v.c.n1.y;
import d.v.c.n1.y0;
import d.v.c.n1.z0;
import d.v.c.s0.d7.a0;
import d.v.c.w0.gg;
import d.v.c.w0.yf;
import d.v.c.x1.l;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.e.l.b2;
import d.v.e.l.h2;
import d.v.e.l.k2;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.e.l.s1;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.n$a;
import d.v.g0.s;
import d.v.p.a;
import d.v.p.a$c;
import d.v.x.b;
import d.v.x.c$b;
import java.util.Locale;

public class PublishFragment
extends d.v.f.h.a {
    private static final long m = 1801000L;
    private static final int n = 150;
    public static final int o = 690;
    private gg b;
    private j2 c;
    private d.v.c.q1.g0 d;
    private PublishState e;
    private a f;
    private a$c g = null;
    private d.v.c.u0.l h;
    private PublishWorks i;
    private n$a j;
    private KWaiManager k;
    private d.v.c.n1.k2 l;

    public static /* synthetic */ void A(PublishFragment publishFragment, String string2) {
        publishFragment.j1(string2);
    }

    public static /* synthetic */ boolean A0(View view, int n10, KeyEvent keyEvent) {
        return true;
    }

    public static /* synthetic */ void B(PublishFragment publishFragment) {
        publishFragment.g1();
    }

    private /* synthetic */ void B0(LiveData liveData, Draft object) {
        if (object == null) {
            object = null;
        } else {
            long l10 = ((Draft)object).getDraftId();
            object = l10;
        }
        this.J((Long)object);
        object = this.getViewLifecycleOwner();
        liveData.removeObservers((LifecycleOwner)object);
    }

    public static /* synthetic */ void C(PublishFragment publishFragment) {
        publishFragment.q1();
    }

    public static /* synthetic */ void D(PublishFragment publishFragment, String string2, String string3) {
        publishFragment.b1(string2, string3);
    }

    private /* synthetic */ void D0(int[] nArray) {
        this.l1(nArray);
    }

    private FrameLayout E(int n10, String object, boolean bl2) {
        Context context = this.requireContext();
        FrameLayout frameLayout = new FrameLayout(context);
        float f10 = o1.j(this.getResources(), 2131165486);
        int n11 = (int)f10;
        frameLayout.setMinimumHeight(n11);
        Context context2 = this.requireContext();
        context = new TextView(context2);
        int n12 = h2.b(24.0f);
        context.setHeight(n12);
        n12 = 17;
        float f11 = 2.4E-44f;
        context.setGravity(n12);
        context2 = this.getResources();
        int n13 = bl2 ? 2131099758 : 2131099739;
        n12 = o1.c((Resources)context2, n13);
        context.setTextColor(n12);
        f11 = 12.0f;
        context.setTextSize(f11);
        n13 = 1;
        Object[] objectArray = new Object[n13];
        objectArray[0] = object;
        object = String.format("#%s", objectArray);
        context.setText((CharSequence)object);
        int n14 = h2.b(f11);
        n12 = h2.b(f11);
        context.setPadding(n14, 0, n12, 0);
        object = o1.o(this.getResources(), 2131232143);
        context.setBackground((Drawable)object);
        n12 = -2;
        object = new FrameLayout.LayoutParams(n12, n12);
        ((FrameLayout.LayoutParams)object).gravity = 16;
        f11 = 16.0f;
        ((FrameLayout.LayoutParams)object).rightMargin = n12 = h2.b(f11);
        frameLayout.addView((View)context, (ViewGroup.LayoutParams)object);
        if (bl2) {
            Object object2 = this.requireContext();
            object = new ImageView(object2);
            int n15 = 2131231143;
            object.setImageResource(n15);
            f10 = 20.0f;
            n12 = h2.b(f10);
            n11 = h2.b(f10);
            object2 = new FrameLayout.LayoutParams(n12, n11);
            object2.gravity = 0x800005;
            object2.rightMargin = n11 = h2.b(8.0f);
            f10 = 6.0f;
            object2.topMargin = n11 = h2.b(f10);
            frameLayout.addView((View)object, (ViewGroup.LayoutParams)object2);
            object2 = new l1(this, frameLayout, n10);
            object.setOnClickListener((View.OnClickListener)object2);
        } else {
            object = new u0(this, n10, frameLayout);
            context.setOnClickListener((View.OnClickListener)object);
        }
        return frameLayout;
    }

    private TextView F(int n10) {
        Context context = this.requireContext();
        TextView textView = new TextView(context);
        int n11 = (int)o1.j(this.getResources(), 2131165486);
        textView.setHeight(n11);
        textView.setGravity(17);
        n11 = o1.c(this.getResources(), 2131099739);
        textView.setTextColor(n11);
        textView.setTextSize(16.0f);
        String string2 = d.v.f.i.g.o(this.getResources(), n10);
        textView.setText((CharSequence)string2);
        n10 = h2.b(10.0f);
        textView.setPadding(0, 0, n10, 0);
        return textView;
    }

    private /* synthetic */ void F0(Integer object) {
        int n10;
        if (object == null) {
            return;
        }
        int n11 = (Integer)object;
        if (n11 != (n10 = 1)) {
            n10 = 2;
            int n12 = 8;
            if (n11 != n10) {
                n10 = 3;
                if (n11 == n10) {
                    this.b.g.setVisibility(n12);
                    n11 = 2131952844;
                    object = d.v.f.i.g.s(this, n11);
                    n2.e((String)object);
                }
            } else {
                this.b.g.setVisibility(n12);
                n11 = 2131952800;
                object = d.v.f.i.g.s(this, n11);
                n2.e((String)object);
                this.a1();
            }
        } else {
            object = this.b.g;
            n10 = 0;
            object.setVisibility(0);
            object = this.b.g;
            v0 v02 = v0.a;
            object.setOnKeyListener((View.OnKeyListener)v02);
        }
    }

    private String G(String stringArray) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)stringArray);
        String string2 = "";
        if (n11 != 0) {
            return string2;
        }
        String string3 = ",";
        if ((stringArray = TextUtils.split((String)stringArray, (String)string3)) != null && (n11 = stringArray.length) == (n10 = 3)) {
            return stringArray[2];
        }
        return string2;
    }

    private void H(boolean n10) {
        j2 j22 = this.c;
        int n11 = j22.V();
        if (n11 != 0) {
            d.v.c.x1.l.h(this);
            return;
        }
        n11 = 0;
        j22 = null;
        if (n10 != 0) {
            this.h.j();
            FragmentActivity fragmentActivity = this.requireActivity();
            j2 j23 = this.c;
            int n12 = j23.A();
            int n13 = 5;
            if (n12 == n13) {
                n11 = 690;
            }
            fragmentActivity.setResult(n11);
        } else {
            int n14;
            Object object = this.c;
            n10 = ((j2)object).A();
            if (n10 == (n14 = 7)) {
                object = this.requireActivity();
                object.setResult(0);
            } else {
                object = this.requireActivity();
                n11 = -1;
                object.setResult(n11);
            }
        }
        ActivityCompat.finishAfterTransition(this.requireActivity());
    }

    public static /* synthetic */ void H0(DialogFragment dialogFragment) {
    }

    private void I() {
        Object object = this.c.s();
        if (object != null) {
            this.J((Long)object);
        } else {
            object = d.v.c.i1.k2.e();
            boolean bl2 = ((d.v.c.i1.k2)object).b();
            if (bl2) {
                this.d1();
            } else {
                bl2 = false;
                object = null;
                this.J(null);
            }
        }
    }

    private /* synthetic */ void I0(DialogFragment object) {
        object = this.c;
        int n10 = ((j2)object).A();
        int n11 = 0;
        int n12 = 1;
        if (n12 == n10) {
            this.requireActivity().setResult(0);
            ActivityCompat.finishAfterTransition(this.requireActivity());
            return;
        }
        n10 = 4;
        j2 j22 = this.c;
        int n13 = j22.A();
        if (n10 == n13) {
            n11 = n12;
        }
        this.H(n11 != 0);
    }

    private void J(Long object) {
        Object object2 = d.v.c.i1.k2.e();
        ((d.v.c.i1.k2)object2).j(false);
        if (object == null) {
            object2 = Permission.STORAGE_GROUP;
            object = new c$b((Permission)((Object)object2));
            object2 = new g1(this);
            object = ((c$b)object).a((b)object2);
            object2 = this.getChildFragmentManager();
            ((c$b)object).b((FragmentManager)object2);
        } else {
            object2 = this.requireActivity();
            long l10 = (Long)object;
            EditorMainActivity.S((Activity)object2, l10);
        }
        ActivityCompat.finishAfterTransition(this.requireActivity());
    }

    private void K() {
        j2 j22;
        int n10 = 1;
        Object object = this.c;
        int n11 = ((j2)object).A();
        if (n10 != n11 && (n11 = 4) != (n10 = (j22 = this.c).A())) {
            object = this.requireActivity();
            SplashActivity.m((Activity)object);
        }
    }

    private /* synthetic */ void K0(DialogFragment dialogFragment) {
        this.J(null);
    }

    private void L() {
        AccountActivity.h(this.getActivity());
    }

    private void M() {
        boolean bl2 = this.Y();
        if (!bl2) {
            n2.e(d.v.f.i.g.m(this.requireContext(), 2131951801));
            return;
        }
        this.f1();
        this.b.h.setEnabled(false);
        j2 j22 = this.c;
        PublishFragment$d publishFragment$d = new PublishFragment$d(this);
        j22.e0(publishFragment$d);
    }

    private /* synthetic */ void M0(DialogFragment object) {
        object = d.v.j.e.g.y.q().getLatestDraft();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        z0 z02 = new z0(this, (LiveData)object);
        ((LiveData)object).observe(lifecycleOwner, z02);
    }

    private void N() {
        s.j();
    }

    private void O() {
        this.b.r.setVisibility(8);
    }

    private /* synthetic */ void O0() {
        int n10 = 2;
        int[] nArray = new int[n10];
        this.b.w.getLocationInWindow(nArray);
        int n11 = Windows.l(this.requireContext()).getHeight();
        int n12 = nArray[1];
        n11 -= n12;
        n12 = this.b.w.getHeight();
        n11 -= n12;
        n12 = h2.b(6.0f);
        n$a n$a = new n$a();
        Object object = this.b.h;
        n$a = n$a.c((View)object);
        object = d.v.f.i.g.m(this.requireContext(), 2131952780);
        n$a n$a2 = n$a.k((String)object).d(2132017750).h(81).g(n10).m(0).n(n11 += n12).e(0.5f);
        y0 y02 = new y0(this, nArray);
        this.j = n$a2 = n$a2.j(y02).o();
        this.r1();
    }

    private void P() {
        this.b.s.setVisibility(8);
    }

    private void Q() {
        Object object = this.h.w();
        Object object2 = this.getViewLifecycleOwner();
        Observer observer = new c0(this);
        object.observe((LifecycleOwner)object2, observer);
        object = this.h.A();
        object2 = this.getViewLifecycleOwner();
        observer = new g0(this);
        object.observe((LifecycleOwner)object2, observer);
        object = this.h.p();
        object2 = this.getViewLifecycleOwner();
        observer = x0.a;
        object.observe((LifecycleOwner)object2, observer);
        object = this.l;
        object2 = new d1(this);
        ((d.v.c.n1.k2)((Object)object)).f((k2$b)object2);
        object = this.l;
        object2 = new b1(this);
        object.setOnDismissListener((PopupWindow.OnDismissListener)object2);
    }

    public static /* synthetic */ void Q0(DialogFragment dialogFragment) {
    }

    /*
     * WARNING - void declaration
     */
    private void R() {
        void var5_12;
        boolean bl2;
        Object object = KWaiManager.getInstance();
        this.k = object;
        ((KWaiManager)object).setNormalStatus();
        object = d.v.i0.b.c(this.requireActivity());
        Object object2 = (j2)((ViewModelProvider)object).get(j2.class);
        this.c = object2;
        this.b.E((j2)object2);
        object2 = (d.v.c.q1.g0)((ViewModelProvider)object).get(d.v.c.q1.g0.class);
        this.d = object2;
        Object object3 = this.b;
        ((gg)object3).F((d.v.c.q1.g0)object2);
        this.h = object = (d.v.c.u0.l)((ViewModelProvider)object).get(d.v.c.u0.l.class);
        object2 = this.b;
        ((gg)object2).D((d.v.c.u0.l)object);
        object = this.c;
        boolean n10 = ((j2)object).V();
        if (n10) {
            boolean bl3;
            object = this.h.z();
            object2 = this.c;
            ((j2)object2).m0((String)object);
            if (object != null) {
                object2 = this.b.k;
                Images.e((ImageView)object2, object);
            }
            if (bl3 = s1.q((String)(object = (String)this.h.A().getValue()))) {
                object = this.c;
                object2 = (String)this.h.A().getValue();
                ((j2)object).u0((String)object2);
            }
            this.X0();
        }
        object = this.c.Q();
        object2 = this.getViewLifecycleOwner();
        object3 = new k1(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.c;
        int n11 = ((j2)object).A();
        if (n11 == 0) {
            this.T();
        } else {
            this.W();
            object = this.c;
            boolean bl4 = ((j2)object).F();
            if (!bl4) {
                this.e1();
            }
            this.f = object = a.c((Context)this.getActivity());
            object = this.b.a;
            object2 = new a1(this);
            object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        }
        this.V();
        object = this.c.J();
        object2 = this.c;
        int n12 = ((j2)object2).A();
        int n13 = 5;
        if (n12 != n13 && (bl2 = ((KWaiManager)(object2 = this.k)).isKwaiInstall((Context)(object3 = this.requireContext())))) {
            boolean bl5 = true;
        } else {
            boolean bl6 = false;
            object2 = null;
        }
        object2 = (boolean)var5_12;
        ((MutableLiveData)object).setValue(object2);
        object = this.l;
        object2 = this.c;
        ((d.v.c.n1.k2)((Object)object)).g((j2)object2);
    }

    private /* synthetic */ void R0(DialogFragment dialogFragment) {
        this.c.v0(true);
        this.M();
    }

    private void S() {
        Object object = this.b.d;
        boolean bl2 = true;
        Object object2 = new InputFilter[bl2];
        Object object3 = new PublishFragment$g(this, 150);
        object2[0] = object3;
        object.setFilters(object2);
        object = this.requireActivity().getOnBackPressedDispatcher();
        object2 = this.getViewLifecycleOwner();
        object3 = new PublishFragment$a(this, bl2);
        ((OnBackPressedDispatcher)object).addCallback((LifecycleOwner)object2, (OnBackPressedCallback)object3);
        object = this.k.getKwaiTokenInfo();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        object2 = new e0(this);
        ((LiveData)object).observe(lifecycleOwner, (Observer)object2);
        object = this.k.getStatus();
        lifecycleOwner = this.getViewLifecycleOwner();
        object2 = new c1(this);
        ((LiveData)object).observe(lifecycleOwner, (Observer)object2);
    }

    private void T() {
        this.b.F.setVisibility(0);
        LiveData liveData = this.c.G();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        f0 f02 = new f0(this);
        liveData.observe(lifecycleOwner, f02);
    }

    private /* synthetic */ void T0() {
        this.c.r0(true);
    }

    private void U() {
        d.v.c.n1.k2 k22;
        yf yf2 = yf.s(LayoutInflater.from((Context)this.requireContext()).inflate(2131558741, null, false));
        yf2.setLifecycleOwner(this);
        Context context = this.requireContext();
        this.l = k22 = new d.v.c.n1.k2(context, yf2);
    }

    private void V() {
        FlowLayout flowLayout = this.b.i;
        Object object = this.F(2131952816);
        flowLayout.addView((View)object);
        flowLayout = this.b.i;
        object = d.v.f.i.g.m(this.requireContext(), 2131952817);
        object = this.E(0, (String)object, false);
        flowLayout.addView((View)object);
        flowLayout = this.b.f;
        object = this.F(2131952768);
        flowLayout.addView((View)object);
        flowLayout = this.b.f;
        object = d.v.f.i.g.m(this.requireContext(), 2131952769);
        object = this.E(1, (String)object, false);
        flowLayout.addView((View)object);
    }

    private /* synthetic */ void V0() {
        Object object = new int[2];
        this.b.w.getLocationOnScreen((int[])object);
        Size size = Windows.l(this.requireContext());
        int n10 = size.getHeight();
        int n11 = 1;
        int n12 = object[n11];
        n10 -= n12;
        n12 = this.b.w.getHeight();
        n10 -= n12;
        float f10 = 6.0f;
        n12 = h2.b(f10);
        n10 += n12;
        object = this.j;
        if (object != null) {
            object = ((n$a)object).n(n10);
            ((n$a)object).p();
        }
    }

    private void W() {
        int n10;
        int n11;
        this.Q();
        Object object = this.h.A();
        Object object2 = this.c.R();
        ((MutableLiveData)object).setValue(object2);
        object = this.h.s();
        int n102 = 100;
        object2 = n102;
        ((MutableLiveData)object).setValue(object2);
        object = this.c;
        boolean n112 = ((j2)object).U();
        if (n112 || (n11 = ((j2)(object = this.c)).A()) == (n102 = 7) || (n10 = ((j2)(object = this.c)).A()) == (n102 = 4)) {
            object = this.h.w();
            object2 = "";
            ((MutableLiveData)object).setValue(object2);
        }
    }

    private boolean X(String object) {
        Context context;
        Object object2;
        try {
            object2 = new MediaMetadataRetriever();
            context = this.requireContext();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        object = Uri.parse((String)object);
        object2.setDataSource(context, (Uri)object);
        int n10 = 9;
        object = object2.extractMetadata(n10);
        long l10 = Long.parseLong((String)object);
        long l11 = 1801000L;
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n10 >= 0) {
            return false;
        }
        object = this.c;
        l11 = 1000L;
        l10 /= l11;
        object2 = String.valueOf(l10);
        ((j2)object).o0((String)object2);
        return true;
    }

    private void X0() {
        j j10 = this.c.I();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        f1 f12 = new f1(this);
        j10.observe(lifecycleOwner, f12);
    }

    private boolean Y() {
        Object object;
        Object object2 = this.c.H();
        boolean bl2 = true;
        if (object2 != null && (object2 = this.c.H()) != (object = ComposeParams$Resolution.RESOLUTION_ORIGINAL)) {
            long l10;
            object2 = this.c.u();
            boolean bl3 = ((String)object2).startsWith((String)(object = "content://"));
            if (bl3) {
                object2 = Uri.parse((String)object2);
                l10 = s1.M((Uri)object2);
            } else {
                l10 = s1.x((String)object2);
            }
            long l11 = k2.e();
            long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (l12 < 0) {
                bl2 = false;
            }
        }
        return bl2;
    }

    private void Y0(PublishWorks object) {
        boolean bl2 = this.Y();
        if (!bl2) {
            n2.e(d.v.f.i.g.m(this.requireContext(), 2131951801));
            return;
        }
        Context context = this.requireContext();
        PublishWorksService.a(context, (PublishWorks)object);
        this.K();
        object = this.c;
        boolean bl3 = ((j2)object).V();
        if (!bl3) {
            bl3 = false;
            object = null;
            this.H(false);
        }
    }

    private /* synthetic */ void Z(FrameLayout object, int n10, View view) {
        view = (ViewGroup)object.getParent();
        if (view != null) {
            j2 j22 = this.c;
            boolean bl2 = j22.Z(n10) ^ true;
            int n11 = view.indexOfChild((View)object) + -1;
            j2 j23 = this.c;
            j23.i0(n10, n11);
            view.removeView((View)object);
            int n12 = n10 == 0 ? 2131952817 : 2131952769;
            if (!bl2) {
                object = d.v.f.i.g.m(this.requireContext(), n12);
                bl2 = false;
                j22 = null;
                object = this.E(n10, (String)object, false);
                view.addView((View)object);
            }
        }
    }

    private void Z0() {
        Object object = Permission.LOCATION;
        c$b c$b = new c$b((Permission)((Object)object));
        object = new PublishFragment$b(this);
        c$b = c$b.a((b)object);
        object = this.getChildFragmentManager();
        c$b.b((FragmentManager)object);
    }

    private void a1() {
        Object object = this.c;
        boolean bl2 = ((j2)object).U();
        if (bl2) {
            return;
        }
        object = this.b.b;
        bl2 = object.isChecked();
        if (bl2) {
            object = d.v.j.e.g.y.q();
            String string2 = this.c.R();
            String string3 = (String)this.b.C.getTag();
            Object object2 = this.h;
            Context context = this.requireContext();
            object2 = ((d.v.c.u0.l)object2).x(context);
            ((d.v.j.e.g.y)object).i(string2, string3, (Description)object2);
        }
    }

    private /* synthetic */ void b0(int n10, FrameLayout frameLayout, View object) {
        object = i2.Q(n10);
        t0 t02 = new t0(this, frameLayout, n10);
        ((i2)object).S(t02);
        FragmentManager fragmentManager = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q(fragmentManager);
    }

    private void b1(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            this.g1();
        } else {
            this.j1(string3);
            j2 j22 = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(",");
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
            j22.k0(string2);
        }
    }

    private boolean c1() {
        Object object = this.c;
        boolean bl2 = ((j2)object).Y();
        if (bl2) {
            Object object2 = this.getContext();
            object = new k$b((Context)object2);
            object = (k$b)((k$a)object).A(2131952764);
            object2 = w0.a;
            object = (k$b)((k$a)object).p((d.v.f.f.a)object2);
            object2 = new j1(this);
            object = (k$b)((k$a)object).w((d.v.f.f.a)object2);
            object2 = this.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
            return true;
        }
        return false;
    }

    private /* synthetic */ void d0() {
        CreationActivity.d((Context)this.requireActivity());
    }

    private void d1() {
        Object object = this.requireContext();
        k$b k$b = new k$b((Context)object);
        k$b = (k$b)((k$b)k$b.A(2131952125)).s();
        object = new d0(this);
        k$b = (k$b)k$b.p((d.v.f.f.a)object);
        object = new i1(this);
        k$b = (k$b)k$b.w((d.v.f.f.a)object);
        object = this.getParentFragmentManager();
        k$b.D((FragmentManager)object);
    }

    private void e1() {
        ScrollView scrollView = this.b.w;
        h1 h12 = new h1(this);
        scrollView.post((Runnable)h12);
    }

    private /* synthetic */ void f0() {
        MutableLiveData mutableLiveData = this.c.M();
        Boolean bl2 = Boolean.FALSE;
        d.v.e.i.h.g(mutableLiveData, bl2);
    }

    private void f1() {
        s.t(this.getActivity());
    }

    private void g1() {
        this.b.y.setEnabled(true);
        TextView textView = this.b.y;
        String string2 = d.v.f.i.g.o(this.getResources(), 2131952787);
        textView.setText((CharSequence)string2);
        this.b.o.setImageResource(2131231142);
        this.b.o.clearAnimation();
    }

    private /* synthetic */ void h0(String string2) {
        this.c.l0(string2);
    }

    private void h1() {
        this.b.y.setEnabled(false);
        TextView textView = this.b.y;
        String string2 = d.v.f.i.g.m(this.requireContext(), 2131952778);
        textView.setText((CharSequence)string2);
        this.b.o.setImageResource(2131231131);
        textView = AnimationUtils.loadAnimation((Context)this.requireContext(), (int)2130771985);
        this.b.o.startAnimation((Animation)textView);
    }

    private void i1() {
        this.b.y.setEnabled(false);
        TextView textView = this.b.y;
        String string2 = d.v.f.i.g.o(this.getResources(), 2131952786);
        textView.setText((CharSequence)string2);
        this.b.o.setImageResource(2131232234);
        this.b.o.clearAnimation();
    }

    public static /* synthetic */ boolean j(PublishFragment publishFragment) {
        return publishFragment.c1();
    }

    private /* synthetic */ void j0(String string2) {
        j2 j22;
        boolean bl2 = s1.q(string2);
        if (bl2) {
            this.c.p0(string2);
            j22 = this.c;
            bl2 = j22.V();
            if (!bl2) {
                j22 = this.b.k;
                Images.e((ImageView)j22, string2);
            }
        }
        if ((bl2 = URLUtil.isHttpsUrl((String)string2)) || (bl2 = URLUtil.isHttpUrl((String)string2))) {
            j22 = this.b.m;
            int n10 = 8;
            j22.setVisibility(n10);
            j22 = this.b.k;
            Images.e((ImageView)j22, string2);
        }
    }

    private void j1(String string2) {
        CheckBox checkBox = this.b.a;
        boolean bl2 = checkBox.isChecked();
        if (!bl2) {
            this.i1();
            return;
        }
        this.b.y.setEnabled(false);
        this.b.y.setText((CharSequence)string2);
        this.b.o.setImageResource(2131232234);
        this.b.o.clearAnimation();
    }

    public static /* synthetic */ void k(PublishFragment publishFragment, boolean bl2) {
        publishFragment.H(bl2);
    }

    private void k1() {
        Object object = this.getContext();
        k$b k$b = new k$b((Context)object);
        k$b = (k$b)k$b.A(2131952796);
        object = s0.a;
        k$b = (k$b)k$b.p((d.v.f.f.a)object);
        object = new e1(this);
        k$b = (k$b)k$b.v(2131952767, (d.v.f.f.a)object);
        object = this.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public static /* synthetic */ void l(PublishFragment publishFragment) {
        publishFragment.N();
    }

    public static /* synthetic */ void l0(Exception exception) {
    }

    private void l1(int[] object) {
        this.j = null;
        Object object2 = new n$a();
        Object object3 = this.b.l;
        object2 = ((n$a)object2).c((View)object3);
        object3 = d.v.f.i.g.m(this.requireContext(), 2131952779);
        object2 = ((n$a)object2).k((String)object3).d(2132017753).h(8388661).g(0);
        int n10 = h2.b(20.0f);
        object2 = ((n$a)object2).m(n10);
        int n11 = object[1];
        n10 = h2.b(4.0f);
        object = ((n$a)object2).n(n11 -= n10).e(0.9f);
        object2 = new b0(this);
        ((n$a)object).j((PopupWindow.OnDismissListener)object2).o();
    }

    public static /* synthetic */ gg m(PublishFragment publishFragment) {
        return publishFragment.b;
    }

    private /* synthetic */ void m0() {
        KWaiManager kWaiManager = this.k;
        FragmentActivity fragmentActivity = this.requireActivity();
        kWaiManager.getKwaiAccessToken(fragmentActivity);
    }

    private void m1(PublishWorks publishWorks) {
        this.b.r.setVisibility(0);
    }

    public static /* synthetic */ void n(PublishFragment publishFragment, PublishWorks publishWorks) {
        publishFragment.Y0(publishWorks);
    }

    private void n1() {
        this.b.s.setVisibility(0);
    }

    public static /* synthetic */ void o(PublishFragment publishFragment) {
        publishFragment.Z0();
    }

    private /* synthetic */ void o0(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            n2.e((String)object);
            object = this.c;
            bl2 = false;
            ((j2)object).t0(null);
        }
    }

    private void o1(PublishWorks object) {
        if (object != null) {
            j2 j22 = this.c;
            String string2 = ((PublishWorks)object).getFilePath();
            j22.p0(string2);
            j22 = this.c;
            string2 = ((PublishWorks)object).getCoverPath();
            j22.m0(string2);
            j22 = this.c;
            string2 = ((PublishWorks)object).getFileDuration();
            j22.o0(string2);
            j22 = this.b.k;
            string2 = ((PublishWorks)object).getCoverPath();
            Images.e((ImageView)j22, string2);
            j22 = this.b.d;
            string2 = ((PublishWorks)object).getWorksDes();
            j22.setText(string2);
            object = ((PublishWorks)object).getAddress();
            j22 = this.c;
            j22.k0((String)object);
            object = this.G((String)object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                object = this.b.a;
                bl2 = false;
                j22 = null;
                object.setChecked(false);
                this.i1();
            } else {
                j22 = this.b.a;
                boolean bl3 = true;
                j22.setChecked(bl3);
                this.j1((String)object);
            }
        } else {
            this.I();
        }
    }

    public static /* synthetic */ boolean p(PublishFragment publishFragment, String string2) {
        return publishFragment.X(string2);
    }

    private void p1() {
        Object object = this.f;
        if (object != null) {
            object = this.g;
            if (object == null) {
                this.g = object = new PublishFragment$c(this);
            }
            object = this.f;
            a$c a$c = this.g;
            ((a)object).e(a$c);
        }
    }

    public static /* synthetic */ void q(PublishFragment publishFragment) {
        publishFragment.k1();
    }

    private /* synthetic */ void q0(CompoundButton object, boolean bl2) {
        object = this.d;
        ((d.v.c.q1.g0)object).T(bl2);
        if (bl2) {
            this.Z0();
        } else {
            this.i1();
        }
    }

    private void q1() {
        a a10 = this.f;
        if (a10 != null) {
            a$c a$c = this.g;
            a10.f(a$c);
        }
    }

    public static /* synthetic */ void r(PublishFragment publishFragment) {
        publishFragment.M();
    }

    private void r1() {
        n$a n$a = this.j;
        if (n$a != null) {
            n$a = this.b.w;
            y y10 = new y(this);
            long l10 = 600L;
            n$a.postDelayed(y10, l10);
        }
    }

    public static /* synthetic */ void s(PublishFragment publishFragment) {
        publishFragment.L();
    }

    private /* synthetic */ void s0(KwaiTokenInfo object) {
        Object object2 = null;
        if (object != null) {
            Object object3;
            int n10 = 1;
            Object object4 = new Object[n10];
            object4[0] = object3 = ((KwaiTokenInfo)object).getAccess_token();
            m.a.a.b("kwaiTokenInfo = %s", object4);
            object2 = this.c.x();
            object4 = ((KwaiTokenInfo)object).getAccess_token();
            d.v.e.i.h.g((MutableLiveData)object2, object4);
            String string2 = ((KwaiTokenInfo)object).getOpen_id();
            String string3 = ((KwaiTokenInfo)object).getAccess_token();
            String string4 = "";
            String string5 = "";
            String string6 = "";
            object3 = object2;
            object2 = new AccountManager$AuthData(string2, string3, string4, string5, string6);
            long l10 = System.currentTimeMillis() / 1000L;
            int n11 = ((KwaiTokenInfo)object).getExpires_in();
            long l11 = n11;
            ((AccountManager$AuthData)object2).expires_at = l10 += l11;
            object = a0.e();
            object4 = "kuaishou";
            ((a0)object).g((String)object4, (AccountManager$AuthData)object2);
            object = this.k;
            ((KWaiManager)object).clearKwaiTokenInfo();
        } else {
            object = new Object[]{};
            object2 = "kwaiTokenInfo == null";
            m.a.a.b((String)object2, (Object[])object);
        }
    }

    public static /* synthetic */ PublishWorks t(PublishFragment publishFragment) {
        return publishFragment.i;
    }

    public static /* synthetic */ d.v.c.n1.k2 u(PublishFragment publishFragment) {
        return publishFragment.l;
    }

    private /* synthetic */ void u0(PagingRequestHelper$Status object) {
        if (object != null) {
            Object object2 = PublishFragment$e.b;
            int n10 = object.ordinal();
            int n11 = 3;
            if ((n10 = object2[n10]) == n11) {
                object = this.c.K();
                object2 = Boolean.FALSE;
                d.v.e.i.h.g((MutableLiveData)object, object2);
                object = this.requireContext();
                object2 = this.requireContext();
                n11 = (int)(b2.m((Context)object2) ? 1 : 0);
                n11 = n11 != 0 ? 2131951873 : 2131953261;
                object = d.v.f.i.g.m((Context)object, n11);
                n2.e((String)object);
            }
        }
    }

    public static /* synthetic */ j2 v(PublishFragment publishFragment) {
        return publishFragment.c;
    }

    public static /* synthetic */ d.v.c.u0.l w(PublishFragment publishFragment) {
        return publishFragment.h;
    }

    private /* synthetic */ void w0(PublishWorks object) {
        this.i = object;
        Object object2 = null;
        if (object != null) {
            Object object3;
            this.b.F.setVisibility(8);
            Object object4 = this.b.u;
            int n10 = object.getPercent();
            object4.setProgress(n10);
            object4 = this.b.t;
            n10 = object.getPercent();
            object4.setProgress(n10);
            object4 = this.b.x;
            Object object5 = Locale.getDefault();
            Object object6 = 1;
            Object[] objectArray = new Object[object6];
            int n11 = object.getPercent();
            objectArray[0] = object3 = Integer.valueOf(n11);
            object3 = "%d%%";
            object5 = String.format((Locale)object5, (String)object3, objectArray);
            object4.setText((CharSequence)object5);
            object4 = object.getState();
            this.e = object4;
            object5 = PublishFragment$e.a;
            Object object7 = ((Enum)object4).ordinal();
            object7 = object5[object7];
            if (object7 != object6) {
                n10 = 2;
                if (object7 != n10) {
                    Object object8 = 3;
                    if (object7 != object8) {
                        object8 = 4;
                        if (object7 == object8 || object7 == (object8 = 5)) {
                            this.P();
                            this.O();
                            this.o1(null);
                        }
                    } else {
                        this.P();
                        object = this.c;
                        object2 = this.requireContext();
                        object7 = 2131952813;
                        object2 = d.v.f.i.g.m(object2, object7);
                        ((j2)object).t0((String)object2);
                        this.H(false);
                    }
                } else {
                    this.P();
                    this.m1((PublishWorks)object);
                    this.o1((PublishWorks)object);
                }
            } else {
                this.n1();
                this.o1((PublishWorks)object);
            }
        } else {
            object = this.e;
            if (object == null) {
                this.o1(null);
            }
        }
    }

    public static /* synthetic */ String x(PublishFragment publishFragment, String string2) {
        return publishFragment.G(string2);
    }

    public static /* synthetic */ void y(PublishFragment publishFragment) {
        publishFragment.h1();
    }

    private /* synthetic */ void y0(FrameLayout frameLayout, int n10, String object) {
        if ((frameLayout = (ViewGroup)frameLayout.getParent()) != null) {
            j2 j22 = this.c;
            j22.i(n10, (String)object);
            int n11 = 1;
            object = this.E(n10, (String)object, n11 != 0);
            int n12 = frameLayout.getChildCount() - n11;
            frameLayout.addView((View)object, n12);
            object = this.c;
            n10 = (int)(((j2)object).Z(n10) ? 1 : 0);
            if (n10 != 0) {
                n10 = frameLayout.getChildCount() - n11;
                View view = frameLayout.getChildAt(n10);
                frameLayout.removeView(view);
            }
        }
    }

    public static /* synthetic */ void z(PublishFragment publishFragment) {
        publishFragment.p1();
    }

    public /* synthetic */ void C0(LiveData liveData, Draft draft) {
        this.B0(liveData, draft);
    }

    public /* synthetic */ void E0(int[] nArray) {
        this.D0(nArray);
    }

    public /* synthetic */ void G0(Integer n10) {
        this.F0(n10);
    }

    public /* synthetic */ void J0(DialogFragment dialogFragment) {
        this.I0(dialogFragment);
    }

    public /* synthetic */ void L0(DialogFragment dialogFragment) {
        this.K0(dialogFragment);
    }

    public /* synthetic */ void N0(DialogFragment dialogFragment) {
        this.M0(dialogFragment);
    }

    public /* synthetic */ void P0() {
        this.O0();
    }

    public /* synthetic */ void S0(DialogFragment dialogFragment) {
        this.R0(dialogFragment);
    }

    public /* synthetic */ void U0() {
        this.T0();
    }

    public /* synthetic */ void W0() {
        this.V0();
    }

    public /* synthetic */ void a0(FrameLayout frameLayout, int n10, View view) {
        this.Z(frameLayout, n10, view);
    }

    public /* synthetic */ void c0(int n10, FrameLayout frameLayout, View view) {
        this.b0(n10, frameLayout, view);
    }

    public /* synthetic */ void e0() {
        this.d0();
    }

    public /* synthetic */ void g0() {
        this.f0();
    }

    public int h() {
        return 2131558747;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (gg)viewDataBinding;
        this.b = viewDataBinding;
        PublishFragment$f publishFragment$f = new PublishFragment$f(this);
        ((gg)viewDataBinding).C(publishFragment$f);
    }

    public /* synthetic */ void i0(String string2) {
        this.h0(string2);
    }

    public /* synthetic */ void k0(String string2) {
        this.j0(string2);
    }

    public /* synthetic */ void n0() {
        this.m0();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.r1();
    }

    public void onPause() {
        this.q1();
        super.onPause();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.U();
        this.R();
        this.S();
    }

    public /* synthetic */ void p0(String string2) {
        this.o0(string2);
    }

    public /* synthetic */ void r0(CompoundButton compoundButton, boolean bl2) {
        this.q0(compoundButton, bl2);
    }

    public /* synthetic */ void t0(KwaiTokenInfo kwaiTokenInfo) {
        this.s0(kwaiTokenInfo);
    }

    public /* synthetic */ void v0(PagingRequestHelper$Status pagingRequestHelper$Status) {
        this.u0(pagingRequestHelper$Status);
    }

    public /* synthetic */ void x0(PublishWorks publishWorks) {
        this.w0(publishWorks);
    }

    public /* synthetic */ void z0(FrameLayout frameLayout, int n10, String string2) {
        this.y0(frameLayout, n10, string2);
    }
}

