/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.RectF
 *  android.graphics.drawable.AnimationDrawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.s0.c7;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.data.CameraSet$Guide;
import com.zhiyun.cama.camera.data.CameraSet$HitchcockGuide;
import com.zhiyun.common.util.Windows;
import com.zhiyun.common.widget.RotateTextView;
import d.v.c.s0.c7.a;
import d.v.c.s0.c7.b;
import d.v.c.s0.c7.c;
import d.v.c.s0.c7.d;
import d.v.c.s0.c7.e;
import d.v.c.s0.c7.f;
import d.v.c.s0.c7.g;
import d.v.c.s0.c7.h;
import d.v.c.s0.c7.i;
import d.v.c.s0.c7.j;
import d.v.c.s0.c7.k;
import d.v.c.s0.c7.l;
import d.v.c.s0.c7.m;
import d.v.c.s0.c7.n;
import d.v.c.s0.c7.o;
import d.v.c.s0.c7.p$a;
import d.v.c.s0.s6;
import d.v.c.w0.x0;
import d.v.e.l.h2;
import d.v.g0.n$a;

public class p {
    private n$a a;
    private n$a b;

    public static /* synthetic */ void a(s6 object) {
        object = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.TWO;
        ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
    }

    public static /* synthetic */ void b(s6 object) {
        object = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.TWO;
        ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
    }

    public static /* synthetic */ void c(s6 object) {
        ((s6)object).V(true);
        object = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.FINISH;
        ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
    }

    public static /* synthetic */ void d(s6 object) {
        object = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.THREE;
        ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
    }

    public static /* synthetic */ void e(s6 object) {
        object = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.FOUR;
        ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
    }

    public static /* synthetic */ void f(s6 object) {
        object = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.FIVE;
        ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
    }

    public static /* synthetic */ void g(s6 object) {
        object = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.SIX;
        ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
    }

    public static /* synthetic */ void h(AnimationDrawable object, s6 object2) {
        object.stop();
        object = object2.o;
        object2 = CameraSet$Guide.SEVEN;
        ((MutableLiveData)object).setValue(object2);
    }

    private /* synthetic */ void i(s6 object) {
        this.a = null;
        ((s6)object).L(true);
        Object object2 = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.FINISH;
        ((MutableLiveData)object2).setValue((Object)cameraSet$Guide);
        object = ((s6)object).p;
        object2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(object2);
    }

    public static /* synthetic */ void k(s6 object) {
        ((s6)object).W(true);
        object = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.FINISH;
        ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
    }

    public static /* synthetic */ void l(s6 object) {
        object = ((s6)object).o;
        CameraSet$Guide cameraSet$Guide = CameraSet$Guide.STORY_CUSTOM_TWO;
        ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
    }

    public static /* synthetic */ void m(s6 object) {
        object = ((s6)object).q;
        CameraSet$HitchcockGuide cameraSet$HitchcockGuide = CameraSet$HitchcockGuide.TWO;
        ((MutableLiveData)object).setValue((Object)cameraSet$HitchcockGuide);
    }

    public static /* synthetic */ void n(s6 object) {
        object = ((s6)object).q;
        CameraSet$HitchcockGuide cameraSet$HitchcockGuide = CameraSet$HitchcockGuide.TWO;
        ((MutableLiveData)object).setValue((Object)cameraSet$HitchcockGuide);
    }

    public static /* synthetic */ void o(s6 object) {
        object = ((s6)object).q;
        CameraSet$HitchcockGuide cameraSet$HitchcockGuide = CameraSet$HitchcockGuide.THREE;
        ((MutableLiveData)object).setValue((Object)cameraSet$HitchcockGuide);
    }

    public static /* synthetic */ void p(s6 s62) {
        MutableLiveData mutableLiveData = s62.q;
        CameraSet$HitchcockGuide cameraSet$HitchcockGuide = CameraSet$HitchcockGuide.FINISH;
        mutableLiveData.setValue((Object)cameraSet$HitchcockGuide);
        s62.Q(true);
    }

    public /* synthetic */ void j(s6 s62) {
        this.i(s62);
    }

    public void q(CameraSet$Guide cameraSet$Guide, Context context, x0 x02, boolean n10, s6 s62, int n11, int n12, int n13) {
        float f10;
        int n14;
        Object object;
        p p10 = this;
        Object object2 = context;
        Object object3 = x02;
        int n15 = n10;
        s6 s63 = s62;
        int n16 = Windows.r(context);
        int n17 = 0;
        AnimationDrawable animationDrawable = null;
        n16 = n16 != 0 ? n13 : 0;
        int n18 = 3;
        float f11 = 4.2E-45f;
        int n19 = n15 != 0 ? 0 : n18;
        Object object4 = p10.a;
        int n20 = 1115947008;
        float f12 = 66.0f;
        int n21 = 8388629;
        int n22 = 0x3F000000;
        float f13 = 0.5f;
        int n23 = 1;
        if (object4 == null) {
            object4 = new n$a();
            object = ((x0)object3).d;
            object4 = ((n$a)object4).c((View)object);
            n14 = cameraSet$Guide.getStringRes();
            object = d.v.f.i.g.m((Context)object2, n14);
            object4 = ((n$a)object4).k((String)object);
            f10 = 1.967379E38f;
            object4 = ((n$a)object4).d(2132017751).h(n21).g(n23).l(n19);
            n14 = h2.b(f12);
            object4 = ((n$a)object4).m(n14).n(0).e(f13).f(0).i(n23 != 0);
            object = new h(s63);
            p10.a = object4 = ((n$a)object4).j((PopupWindow.OnDismissListener)object).o();
        }
        object4 = p$a.a;
        n14 = cameraSet$Guide.ordinal();
        Object object5 = object4[n14];
        float f14 = 60.0f;
        n20 = 8388661;
        f12 = 1.1755018E-38f;
        float f15 = 18.0f;
        float f16 = 14.0f;
        n21 = 2;
        float f17 = 11.0f;
        float f18 = 50.0f;
        n22 = 0x800033;
        f13 = 1.1755015E-38f;
        n14 = 0;
        f10 = 0.0f;
        object = null;
        switch (object5) {
            default: {
                break;
            }
            case 10: {
                object3 = p10.a;
                n15 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, n15);
                object2 = ((n$a)object3).k((String)object2).h(n22).g(0).l(n19);
                int n24 = h2.b(62.0f);
                object2 = ((n$a)object2).m(n16 += n24);
                float f19 = 58.0f;
                n24 = h2.b(f19);
                object2 = ((n$a)object2).n(n24).b(0).e(0.0f);
                n24 = h2.b(f17);
                object2 = ((n$a)object2).f(n24);
                object3 = new k(s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
                break;
            }
            case 9: {
                object3 = p10.a;
                n15 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, n15);
                object2 = ((n$a)object3).k((String)object2).h(8388691).g(n21).l(n19);
                int n25 = n11 / 2;
                n16 += n25;
                n25 = h2.b(160.0f);
                object2 = ((n$a)object2).m(n16 -= n25);
                float f20 = 200.0f;
                n25 = h2.b(f20);
                object2 = ((n$a)object2).n(n25).b(0).e(0.0f);
                n25 = h2.b(f17);
                object2 = ((n$a)object2).f(n25);
                object3 = new b(s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
                break;
            }
            case 8: {
                object3 = p10.a;
                n15 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, n15);
                object2 = ((n$a)object3).k((String)object2).h(n20).g(0).l(n19);
                float f21 = 220.0f;
                int n26 = h2.b(f21);
                object2 = ((n$a)object2).m(n26);
                n26 = h2.b(f18);
                object2 = ((n$a)object2).n(n26).b(n23).e(0.0f);
                n26 = h2.b(f17);
                object2 = ((n$a)object2).f(n26);
                object3 = new m(s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
                break;
            }
            case 7: {
                int n27;
                if (n15 != 0) {
                    n27 = h2.b(f16);
                } else {
                    n27 = h2.b(f14);
                    n27 = n12 - n27;
                }
                if (n15 != 0) {
                    n15 = h2.b(f15);
                } else {
                    float f22 = 16.0f;
                    n15 = h2.b(f22);
                }
                object4 = p10.a;
                n20 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, n20);
                object2 = ((n$a)object4).k((String)object2).h(n22).g(n18).l(n19);
                n18 = h2.b(f18);
                object2 = ((n$a)object2).m(n16 += n18).n(n27).b(0).e(0.0f).f(n15);
                object3 = new d(p10, s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
                break;
            }
            case 6: {
                animationDrawable = (AnimationDrawable)((x0)object3).n.getBackground();
                animationDrawable.start();
                if (n15 == 0) {
                    n23 = n21;
                }
                n$a n$a = p10.a;
                object5 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, (int)object5);
                object2 = n$a.k((String)object2).h(n22).g(n23).l(n19);
                n$a = ((x0)object3).H;
                n18 = n$a.getLeft();
                object2 = ((n$a)object2).m(n16 += n18);
                int n28 = ((x0)object3).H.getTop();
                object2 = ((n$a)object2).n(n28).b(n15).e(0.0f);
                float f23 = 22.0f;
                n28 = h2.b(f23);
                object2 = ((n$a)object2).f(n28);
                object3 = new g(animationDrawable, s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
                break;
            }
            case 5: {
                float f24;
                int n29;
                if (n15 != 0) {
                    n17 = n18;
                }
                if (n15 != 0) {
                    n29 = 1119879168;
                    f24 = 96.0f;
                } else {
                    n29 = 1112539136;
                    f24 = 52.0f;
                }
                n29 = h2.b(f24);
                if (n15 != 0) {
                    f11 = 237.0f;
                    n18 = h2.b(f11);
                    n18 = n12 - n18;
                } else {
                    n18 = h2.b(f14);
                }
                object4 = p10.a;
                n20 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, n20);
                object2 = ((n$a)object4).k((String)object2).h(n22).g(n17).l(n19);
                object2 = ((n$a)object2).m(n16 += n29).n(n18).b(n15).e(0.0f);
                n29 = h2.b(f15);
                object2 = ((n$a)object2).f(n29);
                object3 = new o(s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
                break;
            }
            case 4: {
                float f25;
                int n30 = n15 != 0 ? h2.b(f16) : h2.b(f17);
                if (n15 != 0) {
                    n22 = 0;
                    f13 = 0.0f;
                } else {
                    n22 = 0x3F000000;
                    f13 = 0.5f;
                }
                if (n15 != 0) {
                    n15 = 1102053376;
                    f25 = 22.0f;
                    n17 = h2.b(f25);
                }
                n$a n$a = p10.a;
                n16 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, n16);
                object2 = n$a.k((String)object2).h(n20).g(n23).l(n19);
                f25 = 150.0f;
                n15 = h2.b(f25);
                object2 = ((n$a)object2).m(n15).n(n30).e(f13).f(n17);
                object3 = new j(s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
                break;
            }
            case 3: {
                int n31;
                if (n15 != 0) {
                    n31 = h2.b(f16);
                } else {
                    float f26 = 70.0f;
                    n31 = h2.b(f26);
                    n31 = n12 - n31;
                }
                if (n15 == 0) {
                    n14 = 0x3F000000;
                    f10 = 0.5f;
                }
                if (n15 != 0) {
                    n17 = h2.b(f15);
                }
                n$a n$a = p10.a;
                object5 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, (int)object5);
                object2 = n$a.k((String)object2).h(n22).g(n18).l(n19);
                n15 = h2.b(f18);
                object2 = ((n$a)object2).m(n16 += n15).n(n31).e(f10).f(n17);
                object3 = new c(s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
                break;
            }
            case 2: {
                object3 = p10.a;
                n15 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, n15);
                object2 = ((n$a)object3).k((String)object2).h(8388627).g(n18).l(n19);
                int n32 = h2.b(f18);
                object2 = ((n$a)object2).m(n16 += n32).n(0);
                n32 = 0x3F000000;
                float f27 = 0.5f;
                object2 = ((n$a)object2).e(f27).f(0);
                object3 = new f(s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
                break;
            }
            case 1: {
                object3 = p10.a;
                n15 = cameraSet$Guide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, n15);
                object2 = ((n$a)object3).k((String)object2).h(8388629).g(n23).l(n19);
                int n33 = h2.b(66.0f);
                object2 = ((n$a)object2).m(n33).n(0);
                n33 = 0x3F000000;
                float f28 = 0.5f;
                object2 = ((n$a)object2).e(f28).f(0);
                object3 = new i(s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
            }
        }
    }

    public void r(CameraSet$HitchcockGuide cameraSet$HitchcockGuide, Context context, x0 x02, DynamicZoomViewModel dynamicZoomViewModel, int n10, boolean bl2, s6 s62, int n11, int n12) {
        float f10;
        int n13;
        Object object;
        p p10 = this;
        Object object2 = context;
        Object object3 = x02;
        int n14 = n10;
        s6 s63 = s62;
        int n15 = n12;
        Object object4 = this.b;
        int n16 = 1;
        float f11 = Float.MIN_VALUE;
        int n17 = 0x3F000000;
        float f12 = 0.5f;
        if (object4 == null) {
            object4 = new n$a();
            object = x02.b;
            object4 = ((n$a)object4).c((View)object);
            n13 = cameraSet$HitchcockGuide.getStringRes();
            object = d.v.f.i.g.m(context, n13);
            object4 = ((n$a)object4).k((String)object).d(2132017751).h(8388627).g(0).l(n10).m(0);
            f10 = 53.0f;
            n13 = h2.b(f10);
            object4 = ((n$a)object4).n(n13).e(f12).f(0).i(n16 != 0);
            object = new a(s62);
            object4 = ((n$a)object4).j((PopupWindow.OnDismissListener)object).o();
            this.b = object4;
        }
        object4 = object3.k.h;
        object = LayoutInflater.from((Context)context).inflate(2131558823, null);
        float f13 = 1.8346884E38f;
        object = (RotateTextView)object.findViewById(2131363536);
        int[] nArray = p$a.b;
        int n18 = cameraSet$HitchcockGuide.ordinal();
        int n19 = nArray[n18];
        float f14 = 40.0f;
        float f15 = 2.0f;
        int n20 = 3;
        n18 = 2;
        if (n19 != n16) {
            n16 = 8388629;
            f11 = 1.1754973E-38f;
            if (n19 != n18) {
                if (n19 == n20) {
                    int n21;
                    object3 = dynamicZoomViewModel.r();
                    if (object3 == null) {
                        object3 = new RectF();
                    }
                    int n22 = cameraSet$HitchcockGuide.getStringRes();
                    object4 = d.v.f.i.g.m((Context)object2, n22);
                    object.setText((CharSequence)object4);
                    object.measure(0, 0);
                    if (!bl2) {
                        n20 = 0;
                    }
                    if (bl2) {
                        n22 = h2.b(f15);
                    } else {
                        float f16 = ((RectF)object3).bottom;
                        f13 = ((RectF)object3).top;
                        f16 = -(f16 - f13) / f15;
                        f13 = object.getMeasuredHeight() / n18;
                        f16 += f13;
                        n19 = h2.b(4.0f);
                        f13 = n19;
                        n22 = (int)(f16 += f13);
                    }
                    if (bl2) {
                        float f17 = n15;
                        float f18 = ((RectF)object3).left;
                        f10 = object.getMeasuredHeight();
                        f18 += f10;
                        n13 = h2.b(60.0f);
                        f10 = n13;
                        n21 = (int)(f17 -= (f18 += f10));
                    } else {
                        n21 = n15 / 2;
                        n15 = object.getMeasuredWidth() / n18;
                        n21 -= n15;
                    }
                    n$a n$a = p10.b;
                    n13 = cameraSet$HitchcockGuide.getStringRes();
                    object2 = d.v.f.i.g.m((Context)object2, n13);
                    object2 = n$a.k((String)object2).h(n16).g(n20).l(n14).m(n21).n(n22).e(f12).f(0);
                    object3 = new l(s63);
                    object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                    ((n$a)object2).p();
                }
            } else {
                float f19;
                int n23;
                int n24;
                n17 = cameraSet$HitchcockGuide.getStringRes();
                String string2 = d.v.f.i.g.m((Context)object2, n17);
                object.setText((CharSequence)string2);
                object.measure(0, 0);
                object4.measure(0, 0);
                if (!bl2) {
                    n20 = 0;
                }
                if (bl2) {
                    n17 = -object4.getMeasuredWidth();
                    f13 = 23.0f;
                    n19 = h2.b(f13);
                    double d10 = n17 - n19;
                    n17 = object.getMeasuredWidth();
                    double d11 = n17;
                    double d12 = 0.4;
                    n16 = (int)(d10 += (d11 *= d12));
                } else {
                    n16 = h2.b(f14);
                    n17 = object4.getMeasuredHeight();
                    n16 += n17;
                    n17 = object.getMeasuredHeight() / n18;
                    n16 += n17;
                    n17 = n11 / 2;
                    n16 -= n17;
                }
                if (bl2) {
                    n17 = 1121714176;
                    f12 = 110.0f;
                    n24 = h2.b(f12);
                    n15 -= n24;
                    object3 = object3.k.h;
                    n23 = object3.getMeasuredHeight();
                    n15 -= n23;
                    n23 = object.getMeasuredHeight();
                    n15 -= n23;
                } else {
                    n23 = n15 / 2;
                    n15 = object4.getMeasuredWidth();
                    n23 -= n15;
                    float f20 = 25.0f;
                    n15 = h2.b(f20);
                    double d13 = n23 - n15;
                    n23 = object.getMeasuredWidth();
                    double d14 = n23;
                    double d15 = 0.1;
                    n15 = (int)(d13 -= (d14 *= d15));
                }
                if (bl2) {
                    n23 = 0x3DCCCCCD;
                    f19 = 0.1f;
                } else {
                    n23 = 0x3F666666;
                    f19 = 0.9f;
                }
                object4 = p10.b;
                n17 = cameraSet$HitchcockGuide.getStringRes();
                object2 = d.v.f.i.g.m((Context)object2, n17);
                object2 = ((n$a)object4).k((String)object2);
                n24 = 8388629;
                float f21 = 1.1754973E-38f;
                object2 = ((n$a)object2).h(n24).g(n20).l(n14).m(n15).n(n16).e(f19).f(0);
                object3 = new n(s63);
                object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
                ((n$a)object2).p();
            }
        } else {
            int n25;
            int n26 = cameraSet$HitchcockGuide.getStringRes();
            object3 = d.v.f.i.g.m((Context)object2, n26);
            object.setText((CharSequence)object3);
            object.measure(0, 0);
            object4.measure(0, 0);
            if (!bl2) {
                n20 = 0;
            }
            if (bl2) {
                n26 = h2.b(f15);
            } else {
                n26 = h2.b(f14);
                n16 = object4.getMeasuredHeight();
                n26 += n16;
                n16 = object.getMeasuredHeight() / n18;
                n26 += n16;
                n16 = n11 / 2;
                n26 -= n16;
            }
            if (bl2) {
                f11 = 110.0f;
                n16 = h2.b(f11);
                n25 = object4.getMeasuredHeight();
                n16 += n25;
                n25 = object.getMeasuredHeight();
                n15 -= (n16 += n25);
            } else {
                n15 /= n18;
                n25 = object.getMeasuredWidth() / n18;
                n15 -= n25;
            }
            object4 = p10.b;
            n16 = cameraSet$HitchcockGuide.getStringRes();
            object2 = d.v.f.i.g.m((Context)object2, n16);
            object2 = ((n$a)object4).k((String)object2);
            n25 = 0x800005;
            float f22 = 1.175495E-38f;
            object2 = ((n$a)object2).h(n25).g(n20).l(n14).m(n15).n(n26).e(f12).f(0);
            object3 = new e(s63);
            object2 = ((n$a)object2).j((PopupWindow.OnDismissListener)object3);
            ((n$a)object2).p();
        }
    }
}

