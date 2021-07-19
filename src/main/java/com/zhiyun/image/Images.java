/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.Size
 *  android.widget.ImageView
 */
package com.zhiyun.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Size;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.zhiyun.image.Images$CacheStrategy;
import com.zhiyun.image.Images$ResourceType;
import com.zhiyun.image.Images$ScaleType;
import com.zhiyun.image.Images$a;
import com.zhiyun.image.Images$b;
import com.zhiyun.image.Images$c;
import com.zhiyun.image.Images$d;
import d.c.a.j;
import d.c.a.o.c;
import d.c.a.o.i;
import d.c.a.o.k.h;
import d.c.a.o.m.d.b0;
import d.c.a.o.m.d.l;
import d.c.a.o.m.d.m;
import d.c.a.o.m.d.n;
import d.c.a.o.m.d.s;
import d.c.a.o.m.d.t;
import d.c.a.s.a;
import d.c.a.s.d;
import d.c.a.s.g;
import d.c.a.s.j.p;
import d.v.l.b;
import d.v.l.e;
import d.v.l.f;
import java.util.ArrayList;

public class Images {
    public static void A(ImageView imageView, Object object, int n10) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).A0(n10);
        i[] iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new n();
        iArray[1] = h10;
        ((d.c.a.h)((a)object).S0(iArray)).m1(imageView);
    }

    public static void B(ImageView imageView, Object object, Drawable iArray) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).B0((Drawable)iArray);
        iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new n();
        iArray[1] = h10;
        ((d.c.a.h)((a)object).S0(iArray)).m1(imageView);
    }

    public static void C(ImageView imageView, Object object, float f10, float f11, float f12, float f13, int n10) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).A0(n10);
        i[] iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new t(f10, f11, f12, f13);
        iArray[1] = h10;
        ((d.c.a.h)((a)object).S0(iArray)).m1(imageView);
    }

    public static void D(ImageView imageView, Object object, float f10, float f11, float f12, float f13, Drawable iArray) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).B0((Drawable)iArray);
        iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new t(f10, f11, f12, f13);
        iArray[1] = h10;
        ((d.c.a.h)((a)object).S0(iArray)).m1(imageView);
    }

    public static void E(ImageView imageView, Size size, Object object, int n10) {
        object = (d.c.a.h)((d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).i()).A0(n10);
        n10 = size.getWidth();
        int n11 = size.getHeight();
        ((d.c.a.h)((a)object).z0(n10, n11)).m1(imageView);
    }

    public static void F(ImageView imageView, Object object, int n10, int n11) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).A0(n11);
        i[] iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new b0(n10);
        n10 = 1;
        iArray[n10] = h10;
        object = (d.c.a.h)((d.c.a.h)((a)object).S0(iArray)).K0(n10 != 0);
        h h11 = h.b;
        ((d.c.a.h)((a)object).s(h11)).m1(imageView);
    }

    public static void G(ImageView imageView, Object object, int n10) {
        object = d.c.a.c.D(imageView.getContext()).L(object);
        i[] iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new b0(n10);
        iArray[1] = h10;
        ((d.c.a.h)((a)object).S0(iArray)).m1(imageView);
    }

    public static void H(ImageView imageView, Object object, int n10, int n11) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).A0(n11);
        i[] iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new b0(n10);
        iArray[1] = h10;
        ((d.c.a.h)((a)object).S0(iArray)).m1(imageView);
    }

    public static void I(ImageView imageView, Object object, int n10, Drawable iArray) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).B0((Drawable)iArray);
        iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new b0(n10);
        iArray[1] = h10;
        ((d.c.a.h)((a)object).S0(iArray)).m1(imageView);
    }

    public static void a(Context context) {
        d.c.a.c.d(context).c();
        System.gc();
    }

    private static d.c.a.s.j.e b(f f10) {
        Images$a images$a = new Images$a(f10);
        if (f10 != null) {
            d d10 = images$a.h();
            f10.d(d10);
        }
        return images$a;
    }

    public static void c(Context context, Object object, f f10) {
        Images$b images$b = new Images$b(f10);
        if (f10 != null) {
            d d10 = images$b.h();
            f10.d(d10);
        }
        d.c.a.c.D(context).w().u1(object).j1(images$b);
    }

    private static d.c.a.h d(Context object, Object object2, Images$d object3, e e10) {
        if (object3 != null) {
            int n10;
            Object object4;
            int n11;
            g g10 = new g();
            int n12 = ((Images$d)object3).f();
            if (n12 != (n11 = -1)) {
                n12 = ((Images$d)object3).f();
                g10.A0(n12);
            }
            if ((object4 = ((Images$d)object3).c()) != null) {
                object4 = ((Images$d)object3).c();
                g10.B0((Drawable)object4);
            }
            if ((n12 = ((Images$d)object3).d()) != n11) {
                n12 = ((Images$d)object3).d();
                g10.A(n12);
            }
            if ((object4 = ((Images$d)object3).b()) != null) {
                object4 = ((Images$d)object3).b();
                g10.z((Drawable)object4);
            }
            object4 = new ArrayList();
            Object object5 = ((Images$d)object3).i();
            if (object5 != null) {
                object5 = Images$ScaleType.CENTER_CROP;
                Images$ScaleType images$ScaleType = ((Images$d)object3).i();
                if (object5 == images$ScaleType) {
                    object5 = new l();
                    object4.add(object5);
                } else {
                    object5 = Images$ScaleType.FIT_CENTER;
                    images$ScaleType = ((Images$d)object3).i();
                    if (object5 == images$ScaleType) {
                        object5 = new s();
                        object4.add(object5);
                    } else {
                        object5 = Images$ScaleType.CENTER_INSIDE;
                        images$ScaleType = ((Images$d)object3).i();
                        if (object5 == images$ScaleType) {
                            object5 = new m();
                            object4.add(object5);
                        }
                    }
                }
            }
            if ((n11 = (int)(((Images$d)object3).l() ? 1 : 0)) != 0) {
                n10 = 25;
                int n13 = 4;
                object5 = new b(n10, n13);
                object4.add(object5);
            }
            if ((n11 = ((Images$d)object3).h()) > 0) {
                n10 = ((Images$d)object3).h();
                object5 = new b0(n10);
                object4.add(object5);
            }
            if ((n11 = (int)(((Images$d)object3).m() ? 1 : 0)) != 0) {
                object5 = new n();
                object4.add(object5);
            }
            if ((n11 = object4.size()) > 0) {
                object5 = new i[n11];
                object4 = object4.toArray((T[])object5);
                g10.S0((i[])object4);
            }
            if ((object4 = Images$CacheStrategy.DEFAULT) != (object5 = ((Images$d)object3).a())) {
                object4 = Images$CacheStrategy.NONE;
                object5 = ((Images$d)object3).a();
                if (object4 == object5) {
                    object4 = h.b;
                    g10.s((h)object4);
                    n12 = 1;
                    g10.K0(n12 != 0);
                } else {
                    object4 = Images$CacheStrategy.All;
                    object5 = ((Images$d)object3).a();
                    if (object4 == object5) {
                        object4 = h.a;
                        g10.s((h)object4);
                    } else {
                        object4 = Images$CacheStrategy.SOURCE;
                        object5 = ((Images$d)object3).a();
                        if (object4 == object5) {
                            object4 = h.d;
                            g10.s((h)object4);
                        } else {
                            object4 = Images$CacheStrategy.RESULT;
                            object5 = ((Images$d)object3).a();
                            if (object4 == object5) {
                                object4 = h.c;
                                g10.s((h)object4);
                            }
                        }
                    }
                }
            }
            if ((object4 = ((Images$d)object3).e()) != null) {
                object4 = ((Images$d)object3).e();
                n12 = object4.getWidth();
                object5 = ((Images$d)object3).e();
                n11 = object5.getHeight();
                g10.z0(n12, n11);
            }
            if ((n12 = ((Images$d)object3).k()) > 0) {
                n12 = ((Images$d)object3).k();
                g10.M0(n12);
            }
            if ((n12 = (int)(TextUtils.isEmpty((CharSequence)(object4 = ((Images$d)object3).j())) ? 1 : 0)) == 0) {
                object5 = ((Images$d)object3).j();
                object4 = new d.c.a.t.e(object5);
                g10.I0((c)object4);
            }
            object = (object4 = Images$ResourceType.GIT) == (object5 = ((Images$d)object3).g()) ? d.c.a.c.D((Context)object).x() : ((object4 = Images$ResourceType.BITMAP) == (object5 = ((Images$d)object3).g()) ? d.c.a.c.D((Context)object).u() : d.c.a.c.D((Context)object).v());
            boolean bl2 = ((Images$d)object3).n();
            if (bl2) {
                object3 = d.c.a.o.m.f.c.n();
                ((d.c.a.h)object).H1((j)object3);
            }
            if (e10 != null) {
                object3 = new Images$c(e10);
                ((d.c.a.h)object).o1((d.c.a.s.f)object3);
            }
            return ((d.c.a.h)object).X0(g10).u1(object2);
        }
        return d.c.a.c.D((Context)object).L(object2);
    }

    public static void e(ImageView imageView, Object object) {
        object = d.c.a.c.D(imageView.getContext()).L(object);
        l l10 = new l();
        ((d.c.a.h)((a)object).N0(l10)).m1(imageView);
    }

    public static void f(ImageView imageView, Object object, int n10) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).A0(n10);
        l l10 = new l();
        ((d.c.a.h)((a)object).N0(l10)).m1(imageView);
    }

    public static void g(ImageView imageView, Object object, int n10, boolean bl2) {
        d.c.a.i i10 = d.c.a.c.D(imageView.getContext());
        object = i10.L(object);
        if (bl2) {
            d.c.a.o.m.f.c c10 = d.c.a.o.m.f.c.n();
            ((d.c.a.h)object).H1(c10);
        }
        object = (d.c.a.h)((a)object).A0(n10);
        l l10 = new l();
        ((d.c.a.h)((a)object).N0(l10)).m1(imageView);
    }

    public static void h(ImageView imageView, Object object, Drawable object2) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).B0((Drawable)object2);
        object2 = new l();
        ((d.c.a.h)((a)object).N0((i)object2)).m1(imageView);
    }

    public static void i(ImageView imageView, Object object, Drawable object2, boolean bl2) {
        d.c.a.i i10 = d.c.a.c.D(imageView.getContext());
        object = i10.L(object);
        if (bl2) {
            d.c.a.o.m.f.c c10 = d.c.a.o.m.f.c.n();
            ((d.c.a.h)object).H1(c10);
        }
        object = (d.c.a.h)((a)object).B0((Drawable)object2);
        object2 = new l();
        ((d.c.a.h)((a)object).N0((i)object2)).m1(imageView);
    }

    public static void j(ImageView imageView, Object object, Images$d images$d) {
        Images.d(imageView.getContext(), object, images$d, null).m1(imageView);
    }

    public static void k(ImageView imageView, Object object, Images$d images$d, d.c.a.s.j.j j10) {
        Images.d(imageView.getContext(), object, images$d, null).j1(j10);
    }

    public static void l(ImageView imageView, Object object, Images$d images$d, e e10) {
        Images.d(imageView.getContext(), object, images$d, e10).m1(imageView);
    }

    public static void m(ImageView object, Object object2, Images$d images$d, f f10) {
        object = Images.d(object.getContext(), object2, images$d, null);
        object2 = Images.b(f10);
        ((d.c.a.h)object).j1((p)object2);
    }

    public static Bitmap n(Context object, Object object2) {
        object = d.c.a.c.D((Context)object).u().u1(object2);
        object2 = h.b;
        object = (d.c.a.h)((a)object).s((h)object2);
        int n10 = -1 << -1;
        return (Bitmap)((d.c.a.h)object).D1(n10, n10).get();
    }

    public static void o(Context context, Object object, int n10, int n11, int n12, p p10) {
        ((d.c.a.h)((d.c.a.h)d.c.a.c.D(context).u().u1(object).A0(n12)).z0(n10, n11)).j1(p10);
    }

    public static void p(Context context, Object object, int n10, int n11, Priority priority, p p10) {
        ((d.c.a.h)((d.c.a.h)d.c.a.c.D(context).u().C0(priority)).u1(object).z0(n10, n11)).j1(p10);
    }

    public static void q(Context context, Object object, int n10, int n11, p p10) {
        ((d.c.a.h)d.c.a.c.D(context).u().u1(object).z0(n10, n11)).j1(p10);
    }

    public static void r(Context context, Object object, int n10, ImageView imageView) {
        ((d.c.a.h)d.c.a.c.D(context).u().u1(object).A0(n10)).m1(imageView);
    }

    public static void s(Context context, Object object, ImageView imageView) {
        d.c.a.c.D(context).u().u1(object).m1(imageView);
    }

    public static void t(Context object, Object object2, ImageView imageView, boolean bl2) {
        Drawable drawable2;
        if (bl2 && (drawable2 = imageView.getDrawable()) != null) {
            object = d.c.a.c.D((Context)object).u().u1(object2);
            object2 = imageView.getDrawable();
            object = (d.c.a.h)((a)object).B0((Drawable)object2);
            ((d.c.a.h)object).m1(imageView);
        } else {
            Images.s((Context)object, object2, imageView);
        }
    }

    public static void u(Context context, Object object, Priority priority, p p10) {
        ((d.c.a.h)d.c.a.c.D(context).u().C0(priority)).u1(object).j1(p10);
    }

    public static void v(Context context, Object object, p p10) {
        d.c.a.c.D(context).u().u1(object).j1(p10);
    }

    public static void w(Context object, Object object2, f f10) {
        object = d.c.a.c.D((Context)object).u().u1(object2);
        object2 = Images.b(f10);
        ((d.c.a.h)object).j1((p)object2);
    }

    public static void x(Context object, Object object2, f f10) {
        object = d.c.a.c.D((Context)object).u();
        i[] iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new n();
        iArray[1] = h10;
        object = ((d.c.a.h)((a)object).S0(iArray)).u1(object2);
        object2 = Images.b(f10);
        ((d.c.a.h)object).j1((p)object2);
    }

    public static void y(ImageView imageView, Object object, int n10) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).A0(n10);
        i[] iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new b(25, 4);
        iArray[1] = h10;
        ((d.c.a.h)((a)object).S0(iArray)).m1(imageView);
    }

    public static void z(ImageView imageView, Object object, Drawable iArray) {
        object = (d.c.a.h)d.c.a.c.D(imageView.getContext()).L(object).B0((Drawable)iArray);
        iArray = new i[2];
        d.c.a.o.m.d.h h10 = new l();
        iArray[0] = h10;
        h10 = new b(25, 4);
        iArray[1] = h10;
        ((d.c.a.h)((a)object).S0(iArray)).m1(imageView);
    }
}

