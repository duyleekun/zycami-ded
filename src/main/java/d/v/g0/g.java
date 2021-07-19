/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.g0;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.zhiyun.ui.R$color;
import com.zhiyun.ui.R$drawable;
import com.zhiyun.ui.R$layout;
import com.zhiyun.ui.R$style;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.g0.t.a;

public class g
extends FrameLayout {
    private a a;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a();
    }

    private void a() {
        Object object = LayoutInflater.from((Context)this.getContext());
        int n10 = R$layout.zyui_appbars;
        object = (a)DataBindingUtil.inflate(object, n10, (ViewGroup)this, true);
        this.a = object;
    }

    /*
     * WARNING - void declaration
     */
    public void b(boolean bl2, int n10, String string2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        void var6_10;
        void var5_9;
        void var4_8;
        void var3_7;
        int n11;
        void var1_4;
        this.a.z(bl2);
        ImageView imageView = this.a.a;
        if (bl2) {
            int n12 = R$drawable.ic_zf_xj_back_white;
        } else {
            int n13 = R$drawable.ic_zf_zhxt_return_black;
        }
        imageView.setImageResource((int)var1_4);
        this.a.f.setVisibility(4);
        this.a.b.setVisibility(0);
        this.a.b.setImageResource(n11);
        this.a.e.setVisibility(0);
        TextView textView = this.a.e;
        n11 = R$drawable.selector_btn_small_blue_gradients;
        textView.setBackgroundResource(n11);
        this.a.e.setText((CharSequence)var3_7);
        this.a.e.setGravity(17);
        textView = this.a.e;
        n11 = h2.b(92.0f);
        textView.setMaxWidth(n11);
        int n14 = h2.b(6.0f);
        this.a.e.setPadding(n14, n14, n14, n14);
        textView = this.a.e;
        Context context = this.getContext();
        int n15 = R$style.btn_small_blue_gradients;
        textView.setTextAppearance(context, n15);
        this.a.a.setOnClickListener((View.OnClickListener)var4_8);
        this.a.b.setOnClickListener((View.OnClickListener)var5_9);
        this.a.e.setOnClickListener((View.OnClickListener)var6_10);
    }

    /*
     * WARNING - void declaration
     */
    public void c(boolean bl2, String string2, View.OnClickListener onClickListener) {
        void var3_6;
        void var2_5;
        void var1_4;
        this.a.z(bl2);
        ImageView imageView = this.a.a;
        if (bl2) {
            int n10 = R$drawable.ic_zf_xj_back_white;
        } else {
            int n11 = R$drawable.ic_zf_zhxt_return_black;
        }
        imageView.setImageResource((int)var1_4);
        this.a.f.setVisibility(0);
        this.a.f.setText((CharSequence)var2_5);
        this.a.a.setOnClickListener((View.OnClickListener)var3_6);
    }

    /*
     * WARNING - void declaration
     */
    public void d(boolean bl2, String string2, int n10, int n11, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        void var7_10;
        void var6_9;
        void var5_8;
        void var4_7;
        void var3_6;
        void var2_5;
        void var1_4;
        this.a.z(bl2);
        ImageView imageView = this.a.a;
        if (bl2) {
            int n12 = R$drawable.ic_zf_xj_back_white;
        } else {
            int n13 = R$drawable.ic_zf_zhxt_return_black;
        }
        imageView.setImageResource((int)var1_4);
        this.a.f.setVisibility(0);
        this.a.f.setText((CharSequence)var2_5);
        this.a.b.setVisibility(0);
        this.a.b.setImageResource((int)var3_6);
        this.a.c.setVisibility(0);
        this.a.c.setImageResource((int)var4_7);
        this.a.a.setOnClickListener((View.OnClickListener)var5_8);
        this.a.b.setOnClickListener((View.OnClickListener)var6_9);
        this.a.b.setOnClickListener((View.OnClickListener)var7_10);
    }

    /*
     * WARNING - void declaration
     */
    public void e(boolean bl2, int n10, String string2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        void var5_9;
        void var4_8;
        void var1_4;
        Resources resources;
        void var2_6;
        this.a.z(bl2);
        this.a.a.setImageResource((int)var2_6);
        this.a.f.setVisibility(4);
        TextView textView = this.a.e;
        textView.setVisibility(0);
        this.a.e.setText((CharSequence)resources);
        textView = this.a.e;
        resources = this.getResources();
        if (bl2) {
            int n11 = R$color.zyui_colour_2;
        } else {
            int n12 = R$color.zyui_colour_1;
        }
        int n13 = o1.c(resources, (int)var1_4);
        textView.setTextColor(n13);
        this.a.a.setOnClickListener((View.OnClickListener)var4_8);
        this.a.e.setOnClickListener((View.OnClickListener)var5_9);
    }

    /*
     * WARNING - void declaration
     */
    public void f(boolean bl2, String string2, View.OnClickListener onClickListener) {
        void var3_7;
        void var1_4;
        TextView textView;
        this.a.z(bl2);
        ImageView imageView = this.a.a;
        int n10 = bl2 ? R$drawable.ic_zf_xj_back_white : R$drawable.ic_zf_zhxt_return_black;
        imageView.setImageResource(n10);
        imageView = this.a.e;
        n10 = 0;
        imageView.setVisibility(0);
        this.a.e.setText((CharSequence)textView);
        textView = this.a.e;
        imageView = this.getResources();
        if (bl2) {
            int n11 = R$color.zyui_text_6;
        } else {
            int n12 = R$color.zyui_text_1;
        }
        int n13 = o1.c((Resources)imageView, (int)var1_4);
        textView.setTextColor(n13);
        this.a.a.setOnClickListener((View.OnClickListener)var3_7);
    }

    /*
     * WARNING - void declaration
     */
    public void g(boolean bl2, String string2, String string3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        void var5_9;
        void var4_8;
        void var1_4;
        Resources resources;
        TextView textView;
        this.a.z(bl2);
        ImageView imageView = this.a.a;
        int n10 = bl2 ? R$drawable.ic_zf_xj_back_white : R$drawable.ic_zf_zhxt_return_black;
        imageView.setImageResource(n10);
        imageView = this.a.f;
        n10 = 0;
        imageView.setVisibility(0);
        imageView = this.a.f;
        imageView.setText((CharSequence)textView);
        this.a.e.setVisibility(0);
        this.a.e.setText((CharSequence)resources);
        textView = this.a.e;
        resources = this.getResources();
        if (bl2) {
            int n11 = R$color.zyui_text_6;
        } else {
            int n12 = R$color.zyui_text_1;
        }
        int n13 = o1.c(resources, (int)var1_4);
        textView.setTextColor(n13);
        this.a.a.setOnClickListener((View.OnClickListener)var4_8);
        this.a.e.setOnClickListener((View.OnClickListener)var5_9);
    }
}

