/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.g0;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.zhiyun.common.widget.RotateTextView;
import d.v.g0.n;
import d.v.g0.t.i;

public class m {
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 0;
    public static final int s = 1;
    public View a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h = -1;
    public int i;
    public int j;
    public float k;
    public boolean l;
    public PopupWindow.OnDismissListener m;

    private void c(i i10, float f10, int n10) {
        ConstraintLayout constraintLayout;
        int n11;
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout2 = i10.a;
        constraintSet.clone(constraintLayout2);
        int n12 = 0;
        constraintLayout2 = null;
        int n13 = Float.compare(f10, 0.0f);
        int n14 = 1;
        n13 = n13 > 0 ? n14 : 0;
        int n15 = 1065353216;
        float f11 = 1.0f;
        if (n13 != 0) {
            n12 = this.i;
            if (n12 == n14) {
                f10 = f11 - f10;
            }
        } else {
            n11 = this.i;
            if (n11 == n14) {
                n11 = n15;
                f10 = f11;
            } else {
                n11 = 0;
                constraintLayout = null;
                f10 = 0.0f;
            }
        }
        n12 = this.g;
        n13 = 3;
        n15 = 2;
        f11 = 2.8E-45f;
        if (n12 != 0) {
            if (n12 != n14) {
                if (n12 != n15) {
                    if (n12 == n13) {
                        constraintLayout2 = i10.d;
                        n12 = constraintLayout2.getId();
                        constraintSet.setVerticalBias(n12, f10);
                    }
                } else {
                    constraintLayout2 = i10.c;
                    n12 = constraintLayout2.getId();
                    constraintSet.setHorizontalBias(n12, f10);
                }
            } else {
                constraintLayout2 = i10.e;
                n12 = constraintLayout2.getId();
                constraintSet.setVerticalBias(n12, f10);
            }
        } else {
            constraintLayout2 = i10.f;
            n12 = constraintLayout2.getId();
            constraintSet.setHorizontalBias(n12, f10);
        }
        constraintLayout = i10.a;
        constraintSet.applyTo(constraintLayout);
        n11 = this.g;
        if (n11 != 0) {
            if (n11 != n14) {
                if (n11 != n15) {
                    if (n11 == n13) {
                        i10 = i10.d;
                        n11 = this.i;
                        this.e((View)i10, n11);
                    }
                } else {
                    i10 = i10.c;
                    n11 = this.i;
                    this.d((View)i10, n11);
                }
            } else {
                i10 = i10.e;
                n11 = this.i;
                this.e((View)i10, n11);
            }
        } else {
            i10 = i10.f;
            n11 = this.i;
            this.d((View)i10, n11);
        }
    }

    private void d(View view, int n10) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n11 = 1;
        if (n10 == n11) {
            marginLayoutParams.rightMargin = n10 = this.j;
        } else {
            marginLayoutParams.leftMargin = n10 = this.j;
        }
        view.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    }

    private void e(View view, int n10) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n11 = 1;
        if (n10 == n11) {
            marginLayoutParams.bottomMargin = n10 = this.j;
        } else {
            marginLayoutParams.topMargin = n10 = this.j;
        }
        view.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    }

    public void a(n n10) {
        Object object = this.a;
        n10.a((View)object);
        object = this.b;
        n10.r((String)object);
        int bl2 = this.c;
        n10.k(bl2);
        int n11 = this.d;
        n10.o(n11);
        int n12 = this.e;
        n10.t(n12);
        int n13 = this.f;
        n10.u(n13);
        int n14 = this.g;
        n10.n(n14);
        int n15 = this.h;
        n10.s(n15);
        int n16 = this.i;
        n10.j(n16);
        int n17 = this.j;
        n10.m(n17);
        float f10 = this.k;
        n10.l(f10);
        boolean bl3 = this.l;
        n10.p(bl3);
        object = this.m;
        n10.q((PopupWindow.OnDismissListener)object);
    }

    public void b(i i10) {
        Object object = i10.b;
        Object object2 = this.b;
        object.setText((CharSequence)object2);
        int n10 = this.h;
        if (n10 >= 0) {
            object2 = i10.b;
            ((RotateTextView)object2).setDirection(n10);
        }
        object = this.g;
        i10.z((Integer)object);
        float f10 = this.k;
        int n11 = this.j;
        this.c(i10, f10, n11);
    }
}

