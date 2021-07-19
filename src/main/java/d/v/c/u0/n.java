/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 *  android.widget.ImageView
 */
package d.v.c.u0;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.image.Images;
import d.v.c.q0.d;
import d.v.c.u0.h;
import d.v.c.u0.i;
import d.v.c.u0.m;
import d.v.c.u0.n$a;
import d.v.c.w0.l4;
import d.v.c.x1.q.c;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.f.i.g;
import d.v.i0.b;

public class n
extends d {
    public static final String m = "video_path";
    public static final String n = "from_type";
    private l4 j;
    private m k;
    private ConstraintSet l;

    public n() {
        ConstraintSet constraintSet;
        this.l = constraintSet = new ConstraintSet();
    }

    private void A() {
        this.getParentFragmentManager().beginTransaction().remove(this).commit();
    }

    public static Bundle B(String string2, int n10) {
        Bundle bundle = new Bundle();
        bundle.putString(m, string2);
        bundle.putInt(n, n10);
        return bundle;
    }

    private int C() {
        Configuration configuration = this.getResources().getConfiguration();
        int n10 = configuration.orientation;
        int n11 = 1;
        int n12 = 2;
        if (n10 != n12) {
            configuration = this.getResources().getConfiguration();
            n10 = configuration.orientation;
            n11 = 0;
        }
        return n11;
    }

    private void D() {
        MutableLiveData mutableLiveData = this.k.i();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        h h10 = new h(this);
        mutableLiveData.observe(lifecycleOwner, h10);
    }

    private void E() {
        Bundle bundle = this.getArguments();
        if (bundle == null) {
            return;
        }
        Object object = bundle.getString(m);
        Object object2 = this.k;
        ((m)object2).t((String)object);
        int n10 = this.C();
        this.K(n10);
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        object2 = this.j.f;
        long l10 = 1000000L;
        int n11 = -1;
        ((ThumbnailView)object2).U((String)object, l10, n11);
        object = this.k;
        long l11 = 0L;
        ImageView imageView = this.j.b;
        int n12 = imageView.getHeight();
        ((m)object).s(l11, n12);
        object = n;
        boolean bl2 = bundle.getInt((String)object);
        boolean bl3 = true;
        if (bl2 == bl3) {
            bundle = this.j.c.getRoot();
            int n13 = 8;
            bundle.setVisibility(n13);
        } else {
            bundle = this.j.c.a;
            object2 = o1.o(this.getResources(), 2131231036);
            bundle.setImageDrawable((Drawable)object2);
            bundle = this.j.c.c;
            object2 = d.v.f.i.g.o(this.getResources(), 2131951887);
            bundle.setText((CharSequence)object2);
            bundle = this.j.c.c;
            n10 = o1.c(this.getResources(), 2131099756);
            bundle.setTextColor(n10);
            bundle = this.j.c.c;
            object2 = this.getResources();
            int n14 = 2131165276;
            n10 = h2.e(o1.j((Resources)object2, n14));
            float f10 = n10;
            bundle.setTextSize(f10);
            this.j.getRoot().setFocusableInTouchMode(bl3);
            this.j.getRoot().requestFocus();
            bundle = this.j.getRoot();
            object = new i(this);
            bundle.setOnKeyListener((View.OnKeyListener)object);
        }
    }

    private /* synthetic */ void F(c c10) {
        if (c10 == null) {
            return;
        }
        Context context = this.j.b.getContext();
        ImageView imageView = this.j.b;
        Images.t(context, c10, imageView, true);
    }

    private /* synthetic */ boolean H(View view, int n10, KeyEvent keyEvent) {
        int n11;
        int n12 = keyEvent.getAction();
        if (n12 == (n11 = 1) && n10 == (n12 = 4)) {
            this.A();
            return n11 != 0;
        }
        return false;
    }

    public static n J(Bundle bundle) {
        n n10 = new n();
        n10.setArguments(bundle);
        return n10;
    }

    private void K(int n10) {
        Object object = this.l;
        ConstraintLayout constraintLayout = this.j.a;
        object.clone(constraintLayout);
        Object object2 = this.k.g(n10);
        this.l.setDimensionRatio(2131362635, (String)object2);
        object2 = this.l;
        object = this.j.a;
        ((ConstraintSet)object2).applyTo((ConstraintLayout)((Object)object));
    }

    public static /* synthetic */ void x(n n10) {
        n10.A();
    }

    public static /* synthetic */ m y(n n10) {
        return n10.k;
    }

    public static /* synthetic */ l4 z(n n10) {
        return n10.j;
    }

    public /* synthetic */ void G(c c10) {
        this.F(c10);
    }

    public /* synthetic */ boolean I(View view, int n10, KeyEvent keyEvent) {
        return this.H(view, n10, keyEvent);
    }

    public int h() {
        return 2131558530;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (l4)object;
        this.j = object;
        n$a n$a = new n$a(this);
        ((l4)object).A(n$a);
        this.k = object = (m)d.v.i0.b.c(this.requireActivity()).get(m.class);
        this.j.B((m)object);
        this.E();
        this.D();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int n10 = this.C();
        this.K(n10);
    }
}

