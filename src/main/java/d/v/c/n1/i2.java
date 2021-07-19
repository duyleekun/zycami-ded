/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.WindowManager$LayoutParams
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 */
package d.v.c.n1;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.api.entity.HotTag;
import d.v.c.n1.i2$a;
import d.v.c.n1.i2$b;
import d.v.c.n1.i2$c;
import d.v.c.n1.j2;
import d.v.c.n1.t;
import d.v.c.n1.u;
import d.v.c.n1.v;
import d.v.c.n1.w;
import d.v.c.n1.x;
import d.v.c.w0.ig;
import d.v.e.l.b2;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.e.l.v1;
import d.v.f.g.a;
import d.v.f.i.g;
import d.v.i0.b;
import java.util.List;

public class i2
extends a {
    private static final String j = "from_type";
    private j2 f;
    private ig g;
    private int h;
    private i2$c i;

    private TextView A(String string2) {
        Context context = this.requireContext();
        TextView textView = new TextView(context);
        textView.setBackgroundResource(2131232147);
        int n10 = 17;
        textView.setGravity(n10);
        int n11 = o1.c(this.getResources(), 2131099739);
        textView.setTextColor(n11);
        float f10 = 12.0f;
        textView.setTextSize(f10);
        Object object = new Object[]{string2};
        object = String.format("#%s", object);
        textView.setText((CharSequence)object);
        int n12 = h2.b(f10);
        n11 = h2.b(f10);
        textView.setPadding(n12, 0, n11, 0);
        w w10 = new w(this, string2);
        textView.setOnClickListener((View.OnClickListener)w10);
        n11 = h2.b(24.0f);
        string2 = new LinearLayout.LayoutParams(-2, n11);
        ((LinearLayout.LayoutParams)string2).rightMargin = n11 = h2.b(10.0f);
        ((LinearLayout.LayoutParams)string2).gravity = n10;
        textView.setLayoutParams((ViewGroup.LayoutParams)string2);
        return textView;
    }

    private TextView B(int n10) {
        Context context = this.requireContext();
        TextView textView = new TextView(context);
        int n11 = (int)o1.j(this.getResources(), 2131165486);
        textView.setHeight(n11);
        textView.setGravity(17);
        n11 = o1.c(this.getResources(), 2131099736);
        textView.setTextColor(n11);
        textView.setTextSize(16.0f);
        String string2 = d.v.f.i.g.q((View)textView, n10);
        textView.setText((CharSequence)string2);
        n10 = h2.b(20.0f);
        n11 = h2.b(10.0f);
        textView.setPadding(n10, 0, n11, 0);
        return textView;
    }

    private TextView C(HotTag object) {
        Object object2 = this.requireContext();
        TextView textView = new TextView(object2);
        textView.setBackgroundResource(2131232147);
        textView.setGravity(17);
        int n10 = o1.c(this.getResources(), 2131099739);
        textView.setTextColor(n10);
        float f10 = 12.0f;
        textView.setTextSize(f10);
        object = ((HotTag)object).name;
        Object object3 = new Object[]{object};
        object3 = String.format("#%s", object3);
        textView.setText((CharSequence)object3);
        int n11 = h2.b(f10);
        n10 = h2.b(f10);
        textView.setPadding(n11, 0, n10, 0);
        object2 = new t(this, (String)object);
        textView.setOnClickListener((View.OnClickListener)object2);
        n10 = h2.b(24.0f);
        object = new ViewGroup.MarginLayoutParams(-2, n10);
        ((ViewGroup.MarginLayoutParams)object).rightMargin = n10 = h2.b(10.0f);
        textView.setLayoutParams((ViewGroup.LayoutParams)object);
        return textView;
    }

    private void D() {
        MutableLiveData mutableLiveData = this.f.r();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new u(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.f.w();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new v(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void E() {
        LiveData liveData = this.f.v();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        x x10 = new x(this);
        liveData.observe(lifecycleOwner, x10);
    }

    private void F() {
        int n10;
        Object object;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            object = j;
            this.h = n10 = bundle.getInt((String)object);
        }
        if ((n10 = this.h) == 0) {
            return;
        }
        bundle = this.g.a;
        object = d.v.f.i.g.s(this, 2131952783);
        bundle.setHint((CharSequence)object);
        bundle = this.g.f;
        int n11 = 8;
        bundle.setVisibility(n11);
        this.g.h.setVisibility(n11);
        bundle = this.g.g;
        object = d.v.f.i.g.s(this, 2131952770);
        bundle.setText((CharSequence)object);
        bundle = this.g.a;
        object = new i2$a(this);
        bundle.addTextChangedListener((TextWatcher)object);
    }

    private /* synthetic */ void G(String string2, View view) {
        this.y(string2);
    }

    private /* synthetic */ void I(String string2, View view) {
        this.z(string2);
    }

    private /* synthetic */ void K(List object) {
        int n10;
        Object object2 = this.g.d;
        object2.removeAllViews();
        int n11 = 8;
        LinearLayout linearLayout = null;
        if (object != null && (n10 = object.size()) != 0) {
            float f10;
            TextView textView = this.g.i;
            textView.setVisibility(n11);
            this.g.e.setVisibility(0);
            object2 = this.g.a.getText();
            n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            if (n10 == 0 && (n11 = (int)(TextUtils.isEmpty((CharSequence)(object2 = object2.toString().trim())) ? 1 : 0)) == 0) {
                object2 = this.g.d;
                f10 = 10.0f;
                n10 = h2.b(f10);
                object2.setPadding(n10, 0, 0, 0);
            } else {
                object2 = this.g.d;
                n10 = 2131952772;
                f10 = 1.9541996E38f;
                textView = this.B(n10);
                object2.addView((View)textView);
                object2 = this.g.d;
                object2.setPadding(0, 0, 0, 0);
            }
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (String)object.next();
                linearLayout = this.g.d;
                object2 = this.A((String)object2);
                linearLayout.addView((View)object2);
            }
            return;
        }
        this.g.i.setVisibility(0);
        this.g.e.setVisibility(n11);
    }

    private /* synthetic */ void M(PagingRequestHelper$Status object) {
        PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.RUNNING;
        if (object == pagingRequestHelper$Status) {
            this.g.i.setVisibility(8);
            return;
        }
        pagingRequestHelper$Status = PagingRequestHelper$Status.FAILED;
        if (object == pagingRequestHelper$Status) {
            object = this.requireContext();
            int n10 = b2.m((Context)object);
            n10 = n10 != 0 ? 2131952770 : 2131952771;
            pagingRequestHelper$Status = this.g.g;
            object = d.v.f.i.g.s(this, n10);
            pagingRequestHelper$Status.setText((CharSequence)object);
        }
    }

    private /* synthetic */ void O(List object) {
        this.g.d.removeAllViews();
        Object object2 = this.g.d;
        int n10 = 2131952781;
        TextView textView = this.B(n10);
        object2.addView((View)textView);
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (HotTag)object.next();
                textView = this.g.d;
                object2 = this.C((HotTag)object2);
                textView.addView((View)object2);
            }
        }
    }

    public static i2 Q(int n10) {
        i2 i22 = new i2();
        Bundle bundle = new Bundle();
        bundle.putInt(j, n10);
        i22.setArguments(bundle);
        return i22;
    }

    private void R() {
        int n10 = this.h;
        if (n10 == 0) {
            j2 j22 = this.f;
            j22.h0();
        } else {
            int n11 = 1;
            if (n10 == n11) {
                Object object = this.g.a.getText();
                j2 j23 = this.f;
                object = object == null ? "" : object.toString();
                j23.g0((String)object);
            }
        }
    }

    public static /* synthetic */ j2 u(i2 i22) {
        return i22.f;
    }

    public static /* synthetic */ ig v(i2 i22) {
        return i22.g;
    }

    public static /* synthetic */ void w(i2 i22, String string2) {
        i22.z(string2);
    }

    public static /* synthetic */ void x(i2 i22) {
        i22.R();
    }

    private void y(String string2) {
        this.z(string2);
    }

    private void z(String string2) {
        Object object = this.i;
        if (object != null) {
            this.dismissAllowingStateLoss();
            object = this.getActivity();
            EditText editText = this.g.a;
            v1.d((Context)object, (View)editText);
            object = this.i;
            object.a(string2);
        }
    }

    public /* synthetic */ void H(String string2, View view) {
        this.G(string2, view);
    }

    public /* synthetic */ void J(String string2, View view) {
        this.I(string2, view);
    }

    public /* synthetic */ void L(List list) {
        this.K(list);
    }

    public /* synthetic */ void N(PagingRequestHelper$Status pagingRequestHelper$Status) {
        this.M(pagingRequestHelper$Status);
    }

    public /* synthetic */ void P(List list) {
        this.O(list);
    }

    public void S(i2$c i2$c) {
        this.i = i2$c;
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (j2)b.c(this.requireActivity()).get(j2.class);
        this.f = object;
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            int n10;
            int n11;
            dialog = this.getDialog().getWindow();
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams layoutParams = dialog.getAttributes();
            layoutParams.gravity = 80;
            layoutParams.width = n11 = -1;
            layoutParams.height = n10 = h2.b(112.0f);
            n10 = 0;
            layoutParams.dimAmount = 0.0f;
            dialog.setAttributes(layoutParams);
            int n12 = 5;
            dialog.setSoftInputMode(n12);
            layoutParams = new ColorDrawable(n11);
            dialog.setBackgroundDrawable((Drawable)layoutParams);
        }
        this.g.a.requestFocus();
        this.R();
    }

    public void onViewCreated(View view, Bundle bundle) {
        int n10 = this.h;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                this.D();
            }
        } else {
            this.E();
        }
    }

    public int s() {
        return 2131558748;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (ig)viewDataBinding;
        this.g = viewDataBinding;
        Object object = new i2$b(this);
        ((ig)viewDataBinding).A((i2$b)object);
        viewDataBinding = this.g;
        object = this.f;
        ((ig)viewDataBinding).B((j2)object);
        this.F();
    }
}

