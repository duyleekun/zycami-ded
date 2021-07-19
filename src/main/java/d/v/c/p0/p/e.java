/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.Size
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.RelativeLayout$LayoutParams
 */
package d.v.c.p0.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.common.util.Windows;
import com.zhiyun.image.Images;
import d.v.c.p0.p.a;
import d.v.c.p0.p.e$a;
import d.v.c.p0.p.g;
import d.v.c.p0.p.g$a;
import d.v.e.l.h2;
import d.v.e.l.o1;

public class e
extends g {
    private static final int f = 1;
    private int b = 0;
    private int c = 6;
    private View.OnClickListener d;
    private e$a e;

    private /* synthetic */ void n(int n10, View view) {
        this.e.a(n10);
    }

    public int g(int n10) {
        return 2131558811;
    }

    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    public int getItemViewType(int n10) {
        int n11 = this.getItemCount();
        int n12 = 1;
        if (n10 == (n11 -= n12)) {
            return n12;
        }
        return super.getItemViewType(n10);
    }

    public View h(int n10, Context context) {
        return null;
    }

    public /* synthetic */ void o(int n10, View view) {
        this.n(n10, view);
    }

    public void p(g$a object, int n10) {
        int n11;
        int n12 = 2131362447;
        ImageView imageView = (ImageView)((g$a)object).getView(n12);
        int n13 = 2131362446;
        ImageView imageView2 = (ImageView)((g$a)object).getView(n13);
        int n14 = this.b;
        if (n14 == 0) {
            Size size = Windows.l(imageView.getContext());
            n14 = size.getWidth();
        }
        this.b = n14;
        int n15 = h2.b(64.0f);
        float f10 = (float)(n14 - n15) * 1.0f;
        n15 = 0x40400000;
        float f11 = 3.0f;
        n14 = (int)(f10 / f11);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)imageView.getLayoutParams();
        layoutParams.height = n14;
        f10 = 10.0f;
        layoutParams.topMargin = n14 = h2.b(f10);
        n14 = this.getItemViewType(n10);
        if (n14 != (n11 = 1)) {
            imageView2.setVisibility(0);
            imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            object = ImageView.ScaleType.FIT_XY;
            imageView.setScaleType((ImageView.ScaleType)object);
            object = this.getItem(n10);
            f10 = 8.0f;
            n14 = h2.b(f10);
            n15 = 2131232156;
            f11 = 1.8080413E38f;
            Images.H(imageView, object, n14, n15);
            object = this.e;
            if (object != null) {
                object = new a(this, n10);
                imageView2.setOnClickListener((View.OnClickListener)object);
            }
        } else {
            View view;
            n14 = this.c;
            n11 = 8;
            if (n10 == n14) {
                layoutParams.height = 0;
                layoutParams.topMargin = 0;
                view = ((RecyclerView$ViewHolder)object).itemView;
                view.setVisibility(n11);
            } else {
                view = ((RecyclerView$ViewHolder)object).itemView;
                view.setVisibility(0);
            }
            imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            view = ((RecyclerView$ViewHolder)object).itemView;
            n14 = 2131231278;
            f10 = 1.8078633E38f;
            view = o1.q(view, n14);
            imageView.setImageDrawable((Drawable)view);
            imageView2.setVisibility(n11);
            view = ImageView.ScaleType.CENTER;
            imageView.setScaleType((ImageView.ScaleType)view);
            object = ((RecyclerView$ViewHolder)object).itemView;
            n10 = 2131232117;
            object = o1.q((View)object, n10);
            imageView.setBackground((Drawable)object);
            object = this.d;
            if (object != null) {
                imageView.setOnClickListener((View.OnClickListener)object);
            }
        }
    }

    public void q(int n10) {
        this.c = n10;
    }

    public void r(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void s(e$a e$a) {
        this.e = e$a;
    }

    public void t(int n10) {
        this.b = n10;
    }
}

