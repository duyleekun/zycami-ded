/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.MotionEvent
 */
package d.v.v.g;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.meicam.sdk.NvsAnimatedSticker;
import com.meicam.sdk.NvsCaption;
import com.meicam.sdk.NvsLiveWindow;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTimelineAnimatedSticker;
import com.meicam.sdk.NvsTimelineCaption;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.nvseditor.widget.NvsDrawRect$b;
import d.v.h.d.a;
import d.v.h.d.a$a;
import d.v.h.d.c;
import d.v.h.d.d;
import d.v.v.g.g;
import d.v.v.j.h;

public class g$a
implements NvsDrawRect$b {
    public final /* synthetic */ g a;

    public g$a(g g10) {
        this.a = g10;
    }

    public void b(float f10) {
        long l10 = d.v.v.q.h.n();
        Object object = this.a;
        int n10 = g.c((g)((Object)object));
        int n11 = 1;
        int n12 = 2;
        if (n10 != n11) {
            if (n10 == n12 && (object = g.n(this.a)) != null) {
                float f11;
                object = g.n(this.a);
                ((NvsAnimatedSticker)object).rotateAnimatedSticker(f10);
                Object object2 = g.r(this.a);
                if (object2 != null) {
                    object2 = g.r(this.a);
                    object = g.n(this.a);
                    f11 = ((NvsAnimatedSticker)object).getRotationZ();
                    object2.l(f11);
                }
                object2 = this.a;
                object = g.n((g)((Object)object2));
                ((g)((Object)object2)).k0((NvsTimelineAnimatedSticker)object);
                object2 = this.a;
                n10 = 4;
                f11 = 5.6E-45f;
                g.s((g)((Object)object2), l10, n10);
            }
        } else {
            object = g.t(this.a);
            if (object != null) {
                object = g.t(this.a);
                ((NvsCaption)object).rotateCaption(f10);
                Object object3 = g.v(this.a);
                if (object3 != null) {
                    object3 = g.v(this.a);
                    object = g.t(this.a);
                    float f12 = ((NvsCaption)object).getRotationZ();
                    object3.l(f12);
                }
                object3 = this.a;
                object = g.t((g)((Object)object3));
                ((g)((Object)object3)).l0((NvsTimelineCaption)object);
                object3 = this.a;
                g.s((g)((Object)object3), l10, n12);
            }
        }
    }

    public void c(PointF pointF, PointF pointF2) {
        pointF = g.b(this.a).mapViewToCanonical(pointF);
        pointF2 = g.b(this.a).mapViewToCanonical(pointF2);
        float f10 = pointF2.x;
        float f11 = pointF.x;
        float f12 = pointF2.y;
        float f13 = pointF.y;
        Object object = new PointF(f10 -= f11, f12 -= f13);
        long l10 = d.v.v.q.h.n();
        Object object2 = this.a;
        int n10 = g.c((g)((Object)object2));
        int n11 = 1;
        f11 = Float.MIN_VALUE;
        int n12 = 2;
        if (n10 != n11) {
            if (n10 == n12 && (object2 = g.n(this.a)) != null) {
                object2 = g.n(this.a);
                ((NvsAnimatedSticker)object2).translateAnimatedSticker((PointF)object);
                object = g.r(this.a);
                if (object != null) {
                    object = g.r(this.a);
                    object2 = g.n(this.a).getTranslation();
                    ((c)object).O((PointF)object2);
                    object = g.r(this.a);
                    object2 = d.v.v.q.h.l(g.r(this.a).B());
                    ((a)object).n((a$a)object2);
                }
                object = this.a;
                object2 = g.n((g)((Object)object));
                ((g)((Object)object)).k0((NvsTimelineAnimatedSticker)object2);
                object = this.a;
                n10 = 4;
                f10 = 5.6E-45f;
                g.s((g)((Object)object), l10, n10);
            }
        } else {
            object2 = g.t(this.a);
            if (object2 != null) {
                object2 = g.t(this.a);
                ((NvsCaption)object2).translateCaption((PointF)object);
                object = g.v(this.a);
                if (object != null) {
                    object = g.v(this.a);
                    object2 = g.t(this.a).getCaptionTranslation();
                    ((d)object).K((PointF)object2);
                    object = g.t(this.a).getBoundingRectangleVertices();
                    object2 = new PointF();
                    n11 = 0;
                    PointF pointF3 = (PointF)object.get(0);
                    float f14 = pointF3.x;
                    PointF pointF4 = (PointF)object.get(n12);
                    float f15 = pointF4.x;
                    f14 += f15;
                    f15 = 2.0f;
                    ((PointF)object2).x = f14 /= f15;
                    PointF pointF5 = (PointF)object.get(0);
                    f11 = pointF5.y;
                    float f16 = ((PointF)object.get((int)n12)).y;
                    ((PointF)object2).y = f11 = (f11 + f16) / f15;
                    object = g.v(this.a);
                    object2 = d.v.v.q.h.l((PointF)object2);
                    ((a)object).n((a$a)object2);
                }
                object = this.a;
                object2 = g.t((g)((Object)object));
                ((g)((Object)object)).l0((NvsTimelineCaption)object2);
                object = this.a;
                g.s((g)((Object)object), l10, n12);
            }
        }
    }

    public void d(PointF object) {
        Object object2 = this.a;
        boolean bl2 = g.g(object2);
        if (bl2 && (bl2 = g.h(object2 = this.a))) {
            return;
        }
        object2 = this.a;
        bl2 = g.g(object2);
        if (bl2) {
            object2 = this.a;
            if ((object = object2.b0((PointF)object)) != null) {
                object2 = this.a;
                g.i(object2, (NvsTimelineAnimatedSticker)object);
            }
            return;
        }
        object2 = this.a;
        bl2 = g.h(object2);
        if (bl2) {
            object2 = this.a;
            if ((object = object2.d0((PointF)object)) != null) {
                object2 = this.a;
                g.j(object2, (NvsTimelineCaption)object);
            }
            return;
        }
        object2 = this.a.b0((PointF)object);
        object = this.a.d0((PointF)object);
        g.k(this.a, (NvsTimelineCaption)object, (NvsTimelineAnimatedSticker)object2);
    }

    public void e() {
        g.l(this.a, 1);
    }

    public void f() {
    }

    public void g() {
        int n10;
        g g10 = this.a;
        int n11 = g.c(g10);
        if (n11 == (n10 = 2)) {
            g10 = this.a;
            Object object = g.n(g10);
            n11 = g.w(g10, (NvsTimelineAnimatedSticker)object);
            object = g.d(this.a);
            DecorationType decorationType = DecorationType.IMAGE_PASTER;
            ((d.v.v.j.g)object).i(n11, decorationType);
        } else {
            g10 = this.a;
            n11 = g.c(g10);
            if (n11 == (n10 = 1)) {
                g10 = this.a;
                Object object = g.t(g10);
                n11 = g.e(g10, (NvsTimelineCaption)object);
                object = g.d(this.a);
                DecorationType decorationType = DecorationType.FONT;
                ((d.v.v.j.g)object).i(n11, decorationType);
            }
        }
    }

    public void h(float f10, PointF object) {
        NvsLiveWindow nvsLiveWindow = g.b(this.a);
        object = nvsLiveWindow.mapViewToCanonical((PointF)object);
        long l10 = d.v.v.q.h.n();
        Object object2 = this.a;
        int n10 = g.c((g)((Object)object2));
        int n11 = 1;
        int n12 = 2;
        if (n10 != n11) {
            if (n10 == n12 && (object2 = g.n(this.a)) != null) {
                object2 = g.n(this.a);
                ((NvsAnimatedSticker)object2).scaleAnimatedSticker(f10, (PointF)object);
                Object object3 = g.r(this.a);
                if (object3 != null) {
                    object3 = g.n(this.a);
                    f10 = ((NvsAnimatedSticker)object3).getScale();
                    object = g.r(this.a);
                    ((c)object).s(f10);
                }
                object3 = this.a;
                object = g.n((g)((Object)object3));
                ((g)((Object)object3)).k0((NvsTimelineAnimatedSticker)object);
                object3 = this.a;
                int n13 = 4;
                float f11 = 5.6E-45f;
                g.s((g)((Object)object3), l10, n13);
            }
        } else {
            object2 = g.t(this.a);
            if (object2 != null) {
                object2 = g.t(this.a);
                ((NvsCaption)object2).scaleCaption(f10, (PointF)object);
                Object object4 = g.v(this.a);
                if (object4 != null) {
                    object4 = g.t(this.a);
                    f10 = ((NvsCaption)object4).getScaleX();
                    object = g.t(this.a);
                    float f12 = ((NvsCaption)object).getScaleY();
                    object2 = g.v(this.a);
                    float[] fArray = new float[n12];
                    fArray[0] = f10;
                    fArray[n11] = f12;
                    ((a)object2).q(fArray);
                }
                object4 = this.a;
                object = g.t((g)((Object)object4));
                ((g)((Object)object4)).l0((NvsTimelineCaption)object);
                object4 = this.a;
                g.s((g)((Object)object4), l10, n12);
            }
        }
    }

    public void i() {
        g.l(this.a, 0);
    }

    public void j() {
        g.l(this.a, 2);
    }

    public void k() {
        long l10 = d.v.v.q.h.n();
        Object object = this.a;
        int n10 = g.c(object);
        int n11 = 1;
        int n12 = 0;
        int n13 = 2;
        if (n10 != n11) {
            if (n10 == n13 && (object = g.n(this.a)) != null) {
                object = this.a;
                Object object2 = g.n(object);
                n10 = g.w(object, object2);
                if (n10 == (n11 = -1)) {
                    return;
                }
                object2 = g.x(this.a);
                NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker = g.n(this.a);
                ((NvsTimeline)object2).removeAnimatedSticker(nvsTimelineAnimatedSticker);
                h.t().L(n10);
                g.p(this.a, null);
                object2 = this.a;
                n12 = 4;
                g.s((g)((Object)object2), l10, n12);
                g.y(this.a);
                d.v.v.j.g g10 = g.d(this.a);
                DecorationType decorationType = DecorationType.IMAGE_PASTER;
                g10.l(n10, decorationType);
            }
        } else {
            object = g.t(this.a);
            if (object != null) {
                object = this.a;
                Object object3 = g.t(object);
                n10 = g.e(object, object3);
                object3 = g.x(this.a);
                NvsTimelineCaption nvsTimelineCaption = g.t(this.a);
                ((NvsTimeline)object3).removeCaption(nvsTimelineCaption);
                h.t().P(n10);
                g.u(this.a, null);
                object3 = this.a;
                g.s((g)((Object)object3), l10, n13);
                g.f(this.a);
                d.v.v.j.g g11 = g.d(this.a);
                DecorationType decorationType = DecorationType.FONT;
                g11.l(n10, decorationType);
            }
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        g g10 = this.a;
        boolean bl2 = g.m(g10);
        if (!bl2) {
            return;
        }
        g.o(this.a, motionEvent);
    }
}

