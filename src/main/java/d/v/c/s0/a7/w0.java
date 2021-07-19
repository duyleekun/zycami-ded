/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package d.v.c.s0.a7;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.a7.t0;
import d.v.c.s0.a7.w0$a;
import d.v.c.s0.a7.w0$b;
import d.v.c.w0.l0;
import d.v.c.w0.n0;
import d.v.e.l.h2;
import d.v.f.i.g;
import java.util.ArrayList;

public class w0
extends t0 {
    private static final int g = 0;
    private static final int h = 1;
    private w0$b f;

    private void A() {
        int n10;
        int n11;
        View view;
        int n12;
        ViewGroup viewGroup;
        Context context = this.getContext();
        int n13 = 0;
        if (context != null && (context = this.getDialog()) != null && (context = this.getDialog().getWindow()) != null) {
            context = this.getDialog().getWindow();
            context.getDecorView().setPadding(0, 0, 0, 0);
            viewGroup = context.getAttributes();
            viewGroup.gravity = 0x800003;
            viewGroup.width = n12 = h2.b(56.0f);
            viewGroup.height = n12 = Windows.l(this.requireContext()).getHeight();
            n12 = 0;
            view = null;
            viewGroup.dimAmount = 0.0f;
            context.setAttributes((WindowManager.LayoutParams)viewGroup);
            viewGroup = new ColorDrawable(0);
            context.setBackgroundDrawable((Drawable)viewGroup);
        }
        if ((n11 = this.k()) != 0 && (n11 = this.k()) != (n10 = 2)) {
            n11 = 0;
            context = null;
        } else {
            n11 = -90;
        }
        viewGroup = (ViewGroup)this.getView();
        while (n13 < (n12 = viewGroup.getChildCount())) {
            view = viewGroup.getChildAt(n13);
            float f10 = n11;
            view.setRotation(f10);
            ++n13;
        }
    }

    public static /* synthetic */ w0$b w(w0 w02) {
        return w02.f;
    }

    private void x(LinearLayout linearLayout) {
        block6: {
            float f10;
            int n10;
            Object object;
            block7: {
                int n11;
                object = this.getArguments();
                if (object == null) break block6;
                String string2 = "choose_type";
                n10 = object.getInt(string2, -1);
                f10 = 1.0f;
                if (n10 != 0) break block7;
                ArrayList arrayList = object.getStringArrayList("choose_list");
                String string3 = "choose_text";
                object = object.getString(string3);
                if (arrayList == null || (n11 = arrayList.size()) <= 0) break block6;
                n11 = arrayList.size();
                Object var10_13 = null;
                for (int i10 = 0; i10 < n11; ++i10) {
                    Object object2 = LayoutInflater.from((Context)linearLayout.getContext());
                    int n12 = 2131558459;
                    object2 = (l0)DataBindingUtil.inflate((LayoutInflater)object2, n12, (ViewGroup)linearLayout, false);
                    int n13 = object2.a.getLayoutParams().width;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n13, 0);
                    String string4 = (String)arrayList.get(i10);
                    n13 = (int)(string4.equals(object) ? 1 : 0);
                    ((l0)object2).a.setSelected(n13 != 0);
                    layoutParams.weight = f10;
                    ((l0)object2).D(i10);
                    Object object3 = (String)arrayList.get(i10);
                    ((l0)object2).B((String)object3);
                    object3 = new w0$a(this);
                    ((l0)object2).C((w0$a)object3);
                    n13 = n13 != 0 ? 2131099694 : 2131099692;
                    object3 = ((l0)object2).a;
                    int n14 = h2.b(2.0f);
                    float f11 = n14;
                    n13 = d.v.f.i.g.c(this.getContext(), n13);
                    object3.setShadowLayer(f11, 0.0f, 0.0f, n13);
                    object2 = ((ViewDataBinding)object2).getRoot();
                    linearLayout.addView((View)object2, (ViewGroup.LayoutParams)layoutParams);
                }
                break block6;
            }
            int n15 = 1;
            if (n10 == n15) {
                int n16;
                ArrayList arrayList = object.getIntegerArrayList("choose_drawable_res_list");
                String string5 = "choose_position";
                int n17 = object.getInt(string5);
                if (arrayList != null && (n16 = arrayList.size()) > 0) {
                    n16 = arrayList.size();
                    Object var11_16 = null;
                    for (int i11 = 0; i11 < n16; ++i11) {
                        Object object4 = LayoutInflater.from((Context)linearLayout.getContext());
                        int n18 = 2131558460;
                        object4 = (n0)DataBindingUtil.inflate((LayoutInflater)object4, n18, (ViewGroup)linearLayout, false);
                        Object object5 = ((n0)object4).a.getLayoutParams();
                        int n19 = object5.width;
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n19, 0);
                        if (n17 == i11) {
                            n19 = n15;
                        } else {
                            n19 = 0;
                            object5 = null;
                        }
                        ImageView imageView = ((n0)object4).a;
                        imageView.setSelected(n19 != 0);
                        layoutParams.weight = f10;
                        ((n0)object4).D(i11);
                        n19 = (Integer)arrayList.get(i11);
                        object5 = d.v.f.i.g.h(this, n19);
                        ((n0)object4).C((Drawable)object5);
                        object5 = new w0$a(this);
                        ((n0)object4).B((w0$a)object5);
                        object4 = ((ViewDataBinding)object4).getRoot();
                        linearLayout.addView((View)object4, (ViewGroup.LayoutParams)layoutParams);
                    }
                }
            }
        }
    }

    public static w0 y(ArrayList arrayList, int n10) {
        w0 w02 = new w0();
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("choose_drawable_res_list", arrayList);
        bundle.putInt("choose_position", n10);
        bundle.putInt("choose_type", 1);
        w02.setArguments(bundle);
        return w02;
    }

    public static w0 z(ArrayList arrayList, String string2) {
        w0 w02 = new w0();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("choose_list", arrayList);
        bundle.putString("choose_text", string2);
        bundle.putInt("choose_type", 0);
        w02.setArguments(bundle);
        return w02;
    }

    public void B(w0$b w0$b) {
        this.f = w0$b;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        viewGroup = this.getContext();
        layoutInflater = new LinearLayout((Context)viewGroup);
        layoutInflater.setOrientation(1);
        viewGroup = new ViewGroup.LayoutParams(-1, -2);
        layoutInflater.setLayoutParams((ViewGroup.LayoutParams)viewGroup);
        this.x((LinearLayout)layoutInflater);
        return layoutInflater;
    }

    public void onResume() {
        super.onResume();
        this.A();
    }

    public void p(int n10) {
        this.A();
    }

    public int s() {
        return 0;
    }
}

