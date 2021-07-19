/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Size
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ProgressBar
 */
package d.v.c.s0.a7;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.common.util.StatusBarUtil;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.a7.b1$a;
import d.v.c.s0.a7.b1$b;
import d.v.c.s0.a7.r0;
import d.v.c.w0.p9;
import d.v.c.x1.n;
import d.v.c.x1.n$b;
import d.v.e.l.n2;
import d.v.f.g.a;
import d.v.f.i.g;
import d.v.i0.b;
import java.io.File;

public class b1
extends a {
    private static final String j = "recordVideoPath";
    private p9 f;
    private DynamicZoomViewModel g;
    private String h;
    private final n$b i;

    public b1() {
        b1$a b1$a = new b1$a(this);
        this.i = b1$a;
    }

    public static /* synthetic */ DynamicZoomViewModel u(b1 b12) {
        return b12.g;
    }

    public static /* synthetic */ void v(b1 b12) {
        b12.w();
    }

    private void w() {
        String string2;
        boolean bl2;
        n.c();
        Object object = this.h;
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3 && (bl2 = ((File)(object = new File(string2 = this.h))).exists())) {
            ((File)object).delete();
        }
        this.dismiss();
    }

    private void x() {
        MutableLiveData mutableLiveData = this.g.c;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        r0 r02 = new r0(this);
        mutableLiveData.observe(lifecycleOwner, r02);
    }

    public static b1 y(String string2) {
        b1 b12 = new b1();
        Bundle bundle = new Bundle();
        bundle.putString(j, string2);
        b12.setArguments(bundle);
        return b12;
    }

    private void z() {
        Object object = this.getContext();
        if (object != null && (object = this.getDialog()) != null && (object = this.getDialog().getWindow()) != null) {
            float f10;
            int n10;
            float f11;
            int n11;
            object = this.getDialog().getWindow();
            View view = object.getDecorView();
            View view2 = null;
            view.setPadding(0, 0, 0, 0);
            view = object.getAttributes();
            int n12 = 2;
            float f12 = 2.8E-45f;
            object.addFlags(n12);
            view.gravity = 48;
            int n13 = this.k();
            if (n13 != 0 && n13 != n12) {
                n11 = 0;
                f11 = 0.0f;
            } else {
                n11 = -90;
                f11 = 0.0f / 0.0f;
            }
            Size size = Windows.l(this.requireContext());
            view.height = n10 = size.getHeight();
            int n14 = size.getWidth();
            Context context = this.getContext();
            n10 = StatusBarUtil.b(context);
            view.width = n14 -= n10;
            n14 = 1062836634;
            view.dimAmount = f10 = 0.85f;
            object.setAttributes((WindowManager.LayoutParams)view);
            size = new ColorDrawable(0);
            object.setBackgroundDrawable((Drawable)size);
            view2 = this.getView();
            if (view2 != null) {
                f11 = n11;
                view2.setRotation(f11);
                if (n13 != 0 && n13 != n12) {
                    int n15;
                    n12 = -1;
                    f12 = 0.0f / 0.0f;
                    view.width = n12;
                    object.setAttributes((WindowManager.LayoutParams)view);
                    view2.getLayoutParams().width = n12;
                    object = view2.getLayoutParams();
                    object.height = n12 = view.height;
                    object = view2.getLayoutParams();
                    view2.setLayoutParams((ViewGroup.LayoutParams)object);
                    boolean bl2 = false;
                    float f13 = 0.0f;
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    object = (ConstraintLayout$LayoutParams)this.f.a.getLayoutParams();
                    double d10 = view.width;
                    double d11 = 0.5;
                    object.width = n15 = (int)(d10 *= d11);
                    view = this.f.a;
                    view.setLayoutParams((ViewGroup.LayoutParams)object);
                } else {
                    int n16;
                    object = view2.getLayoutParams();
                    object.width = n13 = view.height;
                    object = view2.getLayoutParams();
                    object.height = n13 = view.width;
                    object = view2.getLayoutParams();
                    view2.setLayoutParams((ViewGroup.LayoutParams)object);
                    int n17 = view.width / n12;
                    n13 = view.height / n12;
                    f12 = n17 -= n13;
                    view2.setTranslationX(f12);
                    n17 = -n17;
                    float f14 = n17;
                    view2.setTranslationY(f14);
                    object = (ConstraintLayout$LayoutParams)this.f.a.getLayoutParams();
                    double d12 = view.height;
                    double d13 = 0.889;
                    object.width = n16 = (int)(d12 *= d13);
                    view = this.f.a;
                    view.setLayoutParams((ViewGroup.LayoutParams)object);
                }
            }
        }
    }

    public void A(int n10) {
        ProgressBar progressBar = this.f.a;
        progressBar.setProgress(n10);
        int n11 = 100;
        if (n10 >= n11) {
            String string2 = d.v.f.i.g.m(this.requireContext(), 2131952005);
            n11 = this.k();
            n2.f(string2, n11);
            this.dismiss();
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (DynamicZoomViewModel)b.c(this.requireActivity()).get(DynamicZoomViewModel.class);
        this.g = object;
    }

    public void onResume() {
        super.onResume();
        this.z();
    }

    public void onStop() {
        super.onStop();
        boolean bl2 = n.d();
        if (bl2) {
            this.w();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.setCancelable(false);
        this.x();
        n.e(this.i);
    }

    public void p(int n10) {
        super.p(n10);
        this.z();
    }

    public int s() {
        return 2131558612;
    }

    public void t(ViewDataBinding object) {
        super.t((ViewDataBinding)object);
        object = (p9)object;
        this.f = object;
        Object object2 = new b1$b(this);
        ((p9)object).z((b1$b)object2);
        object = this.getArguments();
        if (object != null) {
            object2 = j;
            this.h = object = object.getString((String)object2);
        }
    }
}

