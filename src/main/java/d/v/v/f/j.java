/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.text.TextUtils
 *  android.util.Size
 */
package d.v.v.f;

import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Size;
import com.meicam.sdk.NvsAnimatedSticker;
import com.meicam.sdk.NvsCaption;
import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsFontInfo;
import com.meicam.sdk.NvsSize;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTimelineAnimatedSticker;
import com.meicam.sdk.NvsTimelineCaption;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.nvseditor.data.CustomerAssetInfo;
import com.zhiyun.nvseditor.data.NvsAssetInfo;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.e.l.c1;
import d.v.h.d.a$a;
import d.v.h.d.d$a;
import d.v.v.f.a;
import d.v.v.f.b;
import d.v.v.f.c;
import d.v.v.f.d;
import d.v.v.f.j$a;
import d.v.v.f.j$b;
import d.v.v.j.h;
import d.v.v.j.i;
import d.v.v.q.f;
import java.util.List;
import java.util.concurrent.Executor;

public class j {
    private f a;

    public j() {
        f f10;
        this.a = f10 = f.d();
    }

    private float A() {
        NvsTimelineCaption nvsTimelineCaption = this.D().getFirstCaption();
        float f10 = 0.0f;
        while (nvsTimelineCaption != null) {
            float f11 = nvsTimelineCaption.getZValue();
            float f12 = f11 - f10;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object > 0) {
                f10 = f11;
            }
            NvsTimeline nvsTimeline = this.D();
            nvsTimelineCaption = nvsTimeline.getNextCaption(nvsTimelineCaption);
        }
        return (float)((double)f10 + 1.0);
    }

    private float B() {
        NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker = this.D().getFirstAnimatedSticker();
        float f10 = 0.0f;
        while (nvsTimelineAnimatedSticker != null) {
            float f11 = nvsTimelineAnimatedSticker.getZValue();
            float f12 = f11 - f10;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object > 0) {
                f10 = f11;
            }
            NvsTimeline nvsTimeline = this.D();
            nvsTimelineAnimatedSticker = nvsTimeline.getNextAnimatedSticker(nvsTimelineAnimatedSticker);
        }
        return (float)((double)f10 + 1.0);
    }

    private float C(NvsTimelineAnimatedSticker object, float f10) {
        if (object == null) {
            return f10;
        }
        if ((object = ((NvsAnimatedSticker)object).getBoundingRectangleVertices()) != null) {
            int n10 = object.size();
            int n11 = 4;
            float f11 = 5.6E-45f;
            if (n10 == n11) {
                NvsSize nvsSize = d.v.v.q.h.S();
                PointF pointF = (PointF)object.get(3);
                f11 = pointF.x;
                PointF pointF2 = (PointF)object.get(0);
                float f12 = pointF2.x;
                f11 -= f12;
                PointF pointF3 = (PointF)object.get(0);
                float f13 = pointF3.y;
                int n12 = 1;
                f12 = Float.MIN_VALUE;
                object = (PointF)object.get(n12);
                float f14 = ((PointF)object).y;
                f13 -= f14;
                int n13 = nvsSize.width;
                f14 = (float)n13 / f11;
                n10 = nvsSize.height;
                float f15 = (float)n10 / f13;
                n11 = 1065353216;
                f11 = 1.0f;
                float f16 = f14 - f11;
                Object object2 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
                if (object2 <= 0 || (object2 = f15 == f11 ? 0 : (f15 < f11 ? -1 : 1)) <= 0) {
                    f11 = Math.min(f14, f15);
                }
                return f11 * f10;
            }
        }
        return f10;
    }

    private NvsTimeline D() {
        return i.e().f();
    }

    private NvsTimelineData E() {
        return h.t().n();
    }

    private void G(d.v.h.d.c c10, String object, long l10) {
        int n10;
        int n11;
        f f10 = this.a;
        if ((object = f10.k((String)object)) != null && (n11 = ((NvsAssetInfo)object).getStatus()) == (n10 = 1)) {
            long l11;
            long l12 = c10.i();
            long l13 = l12 - (l11 = 0L);
            n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n11 == 0) {
                c10.p(l10);
            }
            String string2 = ((CustomerAssetInfo)object).getCustomerPath();
            c10.H(string2);
            object = ((NvsAssetInfo)object).getUuid();
            c10.I((String)object);
            this.a(c10);
        }
    }

    private void H(d.v.h.d.c c10) {
        int n10;
        int n11;
        String string2;
        Object object;
        boolean bl2 = c10.F();
        if (bl2) {
            object = this.a;
            string2 = c10.x();
            object = ((f)object).l(string2);
        } else {
            object = this.a;
            string2 = c10.x();
            object = ((f)object).n(string2);
        }
        if (object != null && (n11 = ((NvsAssetInfo)object).getStatus()) == (n10 = 1)) {
            string2 = ((CustomerAssetInfo)object).getCustomerPath();
            c10.H(string2);
            object = ((NvsAssetInfo)object).getUuid();
            c10.I((String)object);
            this.a(c10);
        }
    }

    private /* synthetic */ void I(String object, d.v.h.d.c c10) {
        Object object2 = f.d();
        boolean bl2 = ((f)object2).a((String)object);
        if (bl2) {
            long l10;
            String string2 = f.d().b((String)object);
            object2 = ".caf";
            bl2 = ((String)object).endsWith((String)object2);
            if (bl2) {
                l10 = 3000000L;
            } else {
                object2 = f.d();
                l10 = ((f)object2).c((String)object);
            }
            object = c1.b().c();
            Object object3 = object2;
            object2 = new a(this, c10, string2, l10);
            object.execute((Runnable)object2);
        } else {
            object2 = this.a;
            c c11 = new c(this, c10);
            ((f)object2).g((String)object, c11);
        }
    }

    private /* synthetic */ void K(d.v.h.d.c c10, String string2, long l10) {
        this.G(c10, string2, l10);
    }

    private /* synthetic */ void M(boolean bl2, d.v.h.d.c c10, String string2, long l10) {
        if (bl2) {
            this.G(c10, string2, l10);
        }
    }

    private /* synthetic */ void O(d.v.h.d.c c10, String string2, long l10, boolean bl2) {
        Object object = i.e();
        boolean bl3 = ((i)object).k();
        if (bl3) {
            return;
        }
        object = c1.b().c();
        b b10 = new b(this, bl2, c10, string2, l10);
        object.execute(b10);
    }

    private void T(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker, a$a a$a) {
        if (nvsTimelineAnimatedSticker != null && a$a != null) {
            NvsSize nvsSize = d.v.v.q.h.S();
            int n10 = nvsSize.width;
            int n11 = nvsSize.height;
            float f10 = a$a.a;
            float f11 = 0.5f;
            f10 -= f11;
            float f12 = n10;
            float f13 = a$a.b;
            f11 -= f13;
            f13 = n11;
            a$a = new PointF(f10 *= f12, f11 *= f13);
            nvsTimelineAnimatedSticker.setTranslation((PointF)a$a);
        }
    }

    private void U(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker, float f10, float[] fArray) {
        int n10;
        int n11;
        if (nvsTimelineAnimatedSticker != null && fArray != null && (n11 = fArray.length) == (n10 = 2)) {
            n11 = 0;
            float f11 = fArray[0];
            nvsTimelineAnimatedSticker.setScale(f10 *= f11);
        }
    }

    private void V(NvsTimelineCaption nvsTimelineCaption, int n10) {
        if (n10 != 0 && nvsTimelineCaption != null) {
            NvsColor nvsColor = d.v.v.q.j.c(d.v.v.q.j.a(n10));
            if (nvsColor == null) {
                return;
            }
            nvsTimelineCaption.setTextColor(nvsColor);
        }
    }

    private void W(NvsTimelineCaption nvsTimelineCaption, String string2) {
        if (nvsTimelineCaption == null) {
            return;
        }
        if (string2 == null) {
            string2 = "";
        }
        nvsTimelineCaption.setFontByFilePath(string2);
    }

    private void X(NvsTimelineCaption nvsTimelineCaption, float f10) {
        float f11;
        float f12;
        if (nvsTimelineCaption != null && (f12 = (f11 = f10 - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
            nvsTimelineCaption.setFontSize(f10);
        }
    }

    private void Y(NvsTimelineCaption nvsTimelineCaption, a$a object) {
        if (nvsTimelineCaption != null && object != null) {
            Size size = this.E().getResolutionSize();
            int n10 = size.getWidth();
            int n11 = size.getHeight();
            float f10 = ((a$a)object).a;
            float f11 = 0.5f;
            f10 -= f11;
            float f12 = n10;
            f10 *= f12;
            float f13 = ((a$a)object).b;
            f11 -= f13;
            f13 = n11;
            f11 *= f13;
            object = nvsTimelineCaption.getBoundingRectangleVertices();
            size = new PointF();
            n10 = 0;
            PointF pointF = (PointF)object.get(0);
            float f14 = pointF.x;
            int n12 = 2;
            PointF pointF2 = (PointF)object.get(n12);
            float f15 = pointF2.x;
            f14 += f15;
            f15 = 2.0f;
            size.x = f14 /= f15;
            PointF pointF3 = (PointF)object.get(0);
            f12 = pointF3.y;
            f13 = ((PointF)object.get((int)n12)).y;
            size.y = f12 = (f12 + f13) / f15;
            f12 = size.x;
            float f16 = size.y;
            object = new PointF(f10 -= f12, f11 -= f16);
            nvsTimelineCaption.translateCaption((PointF)object);
        }
    }

    private void Z(NvsTimelineCaption nvsTimelineCaption, float[] fArray) {
        if (nvsTimelineCaption != null && fArray != null) {
            int n10 = fArray.length;
            int n11 = 2;
            float f10 = 2.8E-45f;
            if (n10 == n11) {
                n10 = 0;
                float f11 = 0.0f;
                f10 = fArray[0];
                float f12 = f10 - 0.0f;
                n11 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
                int n12 = 1065353216;
                float f13 = 1.0f;
                if (n11 == 0) {
                    n10 = n12;
                    f11 = f13;
                } else {
                    f11 = fArray[0];
                }
                nvsTimelineCaption.setScaleX(f11);
                n10 = 1;
                f11 = Float.MIN_VALUE;
                f10 = fArray[n10];
                float f14 = f10 - 0.0f;
                n11 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
                if (n11 != 0) {
                    f13 = fArray[n10];
                }
                nvsTimelineCaption.setScaleY(f13);
            }
        }
    }

    private void a0(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d object) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        boolean bl2;
        boolean bl3;
        Object object2 = ((d.v.h.d.d)object).t();
        if (nvsTimelineCaption == null) {
            return;
        }
        PointF pointF = nvsTimelineCaption.getCaptionTranslation();
        List list = nvsTimelineCaption.getBoundingRectangleVertices();
        PointF pointF2 = new PointF();
        float f15 = ((PointF)list.get((int)0)).x;
        int n10 = 2;
        PointF pointF3 = (PointF)list.get(n10);
        float f16 = pointF3.x;
        f15 += f16;
        f16 = 2.0f;
        pointF2.x = f15 /= f16;
        Object object3 = (PointF)list.get(0);
        f15 = object3.y;
        list = (PointF)list.get(n10);
        float f17 = ((PointF)list).y;
        pointF2.y = f15 = (f15 + f17) / f16;
        f17 = nvsTimelineCaption.getScaleX();
        if (object2 != null && !(bl3 = TextUtils.isEmpty((CharSequence)(object3 = ((d$a)object2).b())))) {
            object3 = DecorationType.CAPTION;
            ((d.v.h.d.a)object).o((DecorationType)((Object)object3));
            object2 = ((d$a)object2).b();
            object3 = ((d.v.h.d.d)object).u();
            boolean bl4 = TextUtils.isEmpty((CharSequence)object3);
            if (bl4) {
                object3 = this.x((String)object2);
                ((d.v.h.d.d)object).E((String)object3);
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)object3))) {
                nvsTimelineCaption.applyCaptionStyle((String)object3);
            }
        } else {
            object2 = DecorationType.FONT;
            ((d.v.h.d.a)object).o((DecorationType)((Object)object2));
            object2 = "";
            nvsTimelineCaption.applyCaptionStyle((String)object2);
            ((d.v.h.d.d)object).E((String)object2);
            object2 = new d$a();
            ((d.v.h.d.d)object).B((d$a)object2);
        }
        nvsTimelineCaption.setScaleX(f17);
        nvsTimelineCaption.setScaleY(f17);
        float f18 = pointF.x;
        float f19 = 0.0f;
        object2 = null;
        float f20 = f18 - 0.0f;
        bl2 = f20 == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1);
        if (bl2 || (bl2 = (f14 = (f18 = pointF.y) - 0.0f) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) || (bl2 = (f13 = (f18 = nvsTimelineCaption.getScaleX()) - (f12 = 1.0f)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) || (bl2 = (f11 = (f18 = nvsTimelineCaption.getScaleY()) - f12) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) || (bl2 = (f10 = (f18 = nvsTimelineCaption.getRotationZ()) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) {
            object = nvsTimelineCaption.getBoundingRectangleVertices();
            object2 = new PointF();
            f12 = ((PointF)object.get((int)0)).x;
            list = (PointF)object.get(n10);
            f17 = ((PointF)list).x;
            ((PointF)object2).x = f12 = (f12 + f17) / f16;
            pointF = (PointF)object.get(0);
            f12 = pointF.y;
            f18 = ((PointF)object.get((int)n10)).y;
            ((PointF)object2).y = f12 = (f12 + f18) / f16;
            f12 = pointF2.x;
            f17 = ((PointF)object2).x;
            f12 -= f17;
            f17 = pointF2.y;
            f19 = ((PointF)object2).y;
            object = new PointF(f12, f17 -= f19);
            nvsTimelineCaption.translateCaption((PointF)object);
        }
    }

    private boolean s(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker, d.v.h.d.c c10) {
        if (nvsTimelineAnimatedSticker != null && c10 != null) {
            NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker2 = this.D().getNextAnimatedSticker(nvsTimelineAnimatedSticker);
            if (nvsTimelineAnimatedSticker2 != null) {
                long l10 = nvsTimelineAnimatedSticker2.getInPoint();
                long l11 = nvsTimelineAnimatedSticker.getInPoint();
                l10 -= l11;
                l11 = c10.i();
                long l12 = l11 - l10;
                Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object > 0) {
                    l11 = nvsTimelineAnimatedSticker2.getInPoint();
                    long l13 = 1L;
                    nvsTimelineAnimatedSticker.changeOutPoint(l11 -= l13);
                    c10.p(l10);
                }
            }
            return true;
        }
        return false;
    }

    private void u(d.v.h.d.c c10) {
        String string2 = c10.x();
        Executor executor = c1.b().d();
        d d10 = new d(this, string2, c10);
        executor.execute(d10);
    }

    private String x(String object) {
        int n10;
        f f10;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        object = n11 == 0 && (n11 = ((NvsAssetInfo)(object = (f10 = this.a).j((String)object))).getStatus()) == (n10 = 1) ? ((NvsAssetInfo)object).getUuid() : null;
        return object;
    }

    private long y(long l10, long l11) {
        long l12 = l10 + l11;
        long l13 = d.v.v.q.h.z();
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object > 0) {
            l11 = l13 - l10;
        }
        return l11;
    }

    public static j z() {
        return j$b.a();
    }

    public boolean F(d.v.h.d.c c10) {
        long l10;
        Object object = c10.x();
        Object object2 = "\\.";
        int n10 = ((String[])(object = ((String)object).split((String)object2))).length;
        if (n10 == 0) {
            return false;
        }
        n10 = ((String[])object).length;
        int n11 = 1;
        object2 = "animatedsticker";
        Object object3 = ((String)(object = object[n10 -= n11])).equalsIgnoreCase((String)object2);
        if (object3 != 0) {
            c10.G(false);
        }
        float f10 = c10.w();
        n10 = 0;
        float f11 = 0.0f;
        object2 = null;
        float f12 = f10 - 0.0f;
        object3 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object3 == 0) {
            object3 = 1065353216;
            f10 = 1.0f;
        } else {
            f10 = c10.w();
        }
        object2 = c10.e();
        if (object2 == null) {
            l10 = d.v.v.q.h.n();
        } else {
            object2 = c10.e();
            l10 = (Long)object2;
        }
        c10.J(f10);
        object = l10;
        c10.m((Long)object);
        f10 = this.B();
        c10.r(f10);
        object = c10.f();
        if (object == null) {
            n10 = 0x3F000000;
            f11 = 0.5f;
            object = new a$a(f11, f11);
            c10.n((a$a)object);
        }
        return n11 != 0;
    }

    public /* synthetic */ void J(String string2, d.v.h.d.c c10) {
        this.I(string2, c10);
    }

    public /* synthetic */ void L(d.v.h.d.c c10, String string2, long l10) {
        this.K(c10, string2, l10);
    }

    public /* synthetic */ void N(boolean bl2, d.v.h.d.c c10, String string2, long l10) {
        this.M(bl2, c10, string2, l10);
    }

    public /* synthetic */ void P(d.v.h.d.c c10, String string2, long l10, boolean bl2) {
        this.O(c10, string2, l10, bl2);
    }

    public boolean Q(int n10) {
        NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker = this.v(n10);
        if (nvsTimelineAnimatedSticker == null) {
            return false;
        }
        this.D().removeAnimatedSticker(nvsTimelineAnimatedSticker);
        return true;
    }

    public boolean R(int n10) {
        NvsTimelineCaption nvsTimelineCaption = this.w(n10);
        if (nvsTimelineCaption == null) {
            return false;
        }
        this.D().removeCaption(nvsTimelineCaption);
        return true;
    }

    public void S(NvsTimelineCaption object, d.v.h.d.d d10) {
        object = ((NvsCaption)object).getBoundingRectangleVertices();
        PointF pointF = new PointF();
        float f10 = ((PointF)object.get((int)0)).x;
        int n10 = 2;
        float f11 = ((PointF)object.get((int)n10)).x;
        f10 += f11;
        f11 = 2.0f;
        pointF.x = f10 /= f11;
        float f12 = ((PointF)object.get((int)0)).y;
        float f13 = ((PointF)object.get((int)n10)).y;
        pointF.y = f12 = (f12 + f13) / f11;
        object = d.v.v.q.h.l(pointF);
        d10.n((a$a)object);
    }

    public boolean a(d.v.h.d.c c10) {
        Object object;
        Object object2 = c10.e();
        long l10 = (Long)object2;
        long l11 = c10.i();
        l10 = this.y(l10, l11);
        c10.p(l10);
        boolean bl2 = c10.F();
        if (bl2) {
            object = this.D();
            l11 = c10.e();
            long l12 = c10.i();
            String string2 = c10.v();
            String string3 = c10.u();
            object2 = ((NvsTimeline)object).addCustomAnimatedSticker(l11, l12, string2, string3);
        } else {
            object = this.D();
            l11 = c10.e();
            long l13 = c10.i();
            String string4 = c10.v();
            object2 = ((NvsTimeline)object).addAnimatedSticker(l11, l13, string4);
        }
        float f10 = 0.0f;
        object = null;
        if (object2 == null) {
            return false;
        }
        ((NvsTimelineAnimatedSticker)object2).setClipAffinityEnabled(false);
        this.s((NvsTimelineAnimatedSticker)object2, c10);
        object = c10.f();
        this.T((NvsTimelineAnimatedSticker)object2, (a$a)object);
        f10 = c10.E();
        ((NvsAnimatedSticker)object2).setZValue(f10);
        f10 = c10.w();
        f10 = this.C((NvsTimelineAnimatedSticker)object2, f10);
        c10.L(f10);
        f10 = c10.y();
        float[] fArray = c10.j();
        this.U((NvsTimelineAnimatedSticker)object2, f10, fArray);
        f10 = c10.d();
        ((NvsAnimatedSticker)object2).setRotationZ(f10);
        object2 = ((NvsAnimatedSticker)object2).getTranslation();
        c10.O((PointF)object2);
        return true;
    }

    public void b(d.v.h.d.c c10) {
        long l10;
        Object object = this.F(c10);
        if (!object) {
            return;
        }
        long l11 = c10.i();
        long l12 = l11 - (l10 = 0L);
        object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        l11 = !object ? 3000000L : c10.i();
        int[] nArray = j$a.a;
        DecorationType decorationType = c10.g();
        int n10 = decorationType.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                c10.p(l11);
                this.H(c10);
            }
        } else {
            object = c10.F();
            if (object) {
                this.u(c10);
            } else {
                this.H(c10);
            }
        }
    }

    public NvsTimelineCaption c(String string2, long l10, long l11) {
        return this.D().addCaption(string2, l10, l11, null);
    }

    public boolean d(d.v.h.d.d d10) {
        long l10;
        long l11;
        String string2;
        long l12 = d10.e();
        long l13 = d10.i();
        l12 = this.y(l12, l13);
        d10.p(l12);
        float f10 = this.A();
        d10.r(f10);
        Object object = d10.t();
        if (object != null) {
            object = d10.t().b();
            object = this.x((String)object);
            d10.E((String)object);
        }
        if ((object = d10.f()) == null) {
            float f11 = 0.5f;
            object = new a$a(f11, f11);
            d10.n((a$a)object);
        }
        if ((object = this.c(string2 = d10.y(), l11 = d10.e().longValue(), l10 = d10.i())) == null) {
            return false;
        }
        this.t((NvsTimelineCaption)object, d10);
        return true;
    }

    public boolean e(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d d10, float f10) {
        if (d10 != null && nvsTimelineCaption != null) {
            float f11 = d10.d();
            float f12 = f11 - f10;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object != false) {
                nvsTimelineCaption.setRotationZ(f10);
                d10.l(f10);
            }
            return true;
        }
        return false;
    }

    public boolean f(NvsTimelineCaption object, d.v.h.d.d d10, Long l10, long l11) {
        long l12;
        long l13;
        long l14;
        long l15;
        boolean bl2 = false;
        Long l16 = null;
        if (d10 != null && object != null && l10 != null && (l15 = (l14 = (l13 = l10.longValue()) - (l12 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) >= 0 && (l15 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) >= 0) {
            l16 = d10.e();
            long l17 = l16;
            long l18 = d10.i();
            long l19 = l10;
            bl2 = l17 == l19 ? 0 : (l17 < l19 ? -1 : 1);
            l15 = 1;
            if (!bl2 && !(bl2 = l18 == l11 ? 0 : (l18 < l11 ? -1 : 1))) {
                return (boolean)l15;
            }
            l18 = l10;
            l11 = this.y(l18, l11);
            l18 = l10 + l11;
            l11 = ((NvsTimelineCaption)object).getOutPoint();
            l19 = l10;
            long l20 = l19 - l11;
            Object object2 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
            if (object2 > 0) {
                l11 = ((NvsTimelineCaption)object).changeOutPoint(l18);
                l18 = l10;
                l18 = ((NvsTimelineCaption)object).changeInPoint(l18);
            } else {
                l11 = l10;
                l11 = ((NvsTimelineCaption)object).changeInPoint(l11);
                l18 = ((NvsTimelineCaption)object).changeOutPoint(l18);
                long l21 = l11;
                l11 = l18;
                l18 = l21;
            }
            object = d10.m(l10);
            ((d.v.h.d.a)object).p(l11 -= l18);
            return (boolean)l15;
        }
        return false;
    }

    public boolean g(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d d10, String string2) {
        if (d10 != null && nvsTimelineCaption != null) {
            String string3 = d10.y();
            boolean bl2 = string3.equals(string2);
            if (!bl2) {
                nvsTimelineCaption.setText(string2);
                d10.J(string2);
            }
            return true;
        }
        return false;
    }

    public boolean h(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d d10, String string2, int n10) {
        int n11 = 0;
        float f10 = 0.0f;
        NvsFontInfo nvsFontInfo = null;
        if (d10 != null && nvsTimelineCaption != null) {
            boolean bl2;
            Object object = d10.v();
            int n12 = d10.w();
            String string3 = "";
            if (object == null) {
                object = string3;
            }
            if (string2 == null) {
                string2 = string3;
            }
            if (!(bl2 = ((String)object).equals(string2))) {
                boolean bl3;
                object = NvsStreamingContext.getInstance().getFontInfoByFilePath(string2);
                if (object != null && !(bl3 = object.isEmpty())) {
                    nvsFontInfo = (NvsFontInfo)object.get(0);
                    n11 = nvsFontInfo.weight;
                }
                nvsTimelineCaption.setFontByFilePath(string2);
                float f11 = n10;
                nvsTimelineCaption.setFontSize(f11);
                if (n11 != 0) {
                    nvsTimelineCaption.setWeight(n11);
                }
            }
            if (n12 != n10) {
                f10 = n10;
                nvsTimelineCaption.setFontSize(f10);
            }
            d10.G(string2);
            d10.H(n10);
            return true;
        }
        return false;
    }

    public boolean i(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d d10, a$a a$a) {
        if (d10 != null && nvsTimelineCaption != null && a$a != null) {
            float f10;
            float f11;
            float f12;
            a$a a$a2 = d10.f();
            float f13 = a$a2.a;
            float f14 = a$a.a;
            float f15 = f13 - f14;
            Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (object != false || (f12 = (f11 = (f10 = a$a2.b) - (f13 = a$a.b)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
                this.Y(nvsTimelineCaption, a$a);
                d10.n(a$a);
            }
            return true;
        }
        return false;
    }

    public boolean j(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d d10, float[] fArray) {
        float f10 = 0.0f;
        if (d10 != null && nvsTimelineCaption != null) {
            float f11;
            float f12;
            float f13;
            float[] fArray2 = d10.j();
            float f14 = fArray2[0];
            float f15 = fArray[0];
            float f16 = f14 == f15 ? 0 : (f14 > f15 ? 1 : -1);
            boolean bl2 = true;
            f15 = Float.MIN_VALUE;
            if (f16 != false || (f13 = (f12 = (f11 = fArray2[bl2]) - (f14 = fArray[bl2])) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) != false) {
                f10 = fArray[0];
                nvsTimelineCaption.setScaleX(f10);
                f10 = fArray[bl2];
                nvsTimelineCaption.setScaleY(f10);
                d10.q(fArray);
            }
            return bl2;
        }
        return false;
    }

    public boolean k(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d d10, d$a d$a) {
        if (d10 != null && nvsTimelineCaption != null) {
            boolean bl2;
            String string2;
            Object object = d10.t();
            String string3 = "";
            object = object != null && (string2 = ((d$a)object).b()) != null ? ((d$a)object).b() : string3;
            if (d$a != null && (string2 = d$a.b()) != null) {
                string3 = d$a.b();
            }
            if (!(bl2 = ((String)object).equals(string3))) {
                object = this.x(string3);
                d10.E((String)object);
                d10.B(d$a);
                this.a0(nvsTimelineCaption, d10);
            }
            return true;
        }
        return false;
    }

    public boolean l(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d d10, int n10) {
        if (d10 != null && nvsTimelineCaption != null) {
            int n11 = d10.x();
            if (n11 != n10) {
                NvsColor nvsColor = d.v.v.q.j.c(d.v.v.q.j.a(n10));
                nvsTimelineCaption.setTextColor(nvsColor);
                d10.I(n10);
            }
            return true;
        }
        return false;
    }

    public boolean m(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker, d.v.h.d.c c10, float f10) {
        if (c10 != null && nvsTimelineAnimatedSticker != null) {
            float f11 = c10.d();
            float f12 = f11 - f10;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object != false) {
                nvsTimelineAnimatedSticker.setRotationZ(f10);
                c10.l(f10);
            }
            return true;
        }
        return false;
    }

    public boolean n(NvsTimelineAnimatedSticker object, d.v.h.d.c c10, Long l10, long l11) {
        long l12;
        long l13;
        long l14;
        long l15;
        boolean bl2 = false;
        Long l16 = null;
        if (object != null && c10 != null && l10 != null && (l15 = (l14 = (l13 = l10.longValue()) - (l12 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) >= 0 && (l15 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) >= 0) {
            l16 = c10.e();
            long l17 = l16;
            long l18 = c10.i();
            long l19 = l10;
            bl2 = l17 == l19 ? 0 : (l17 < l19 ? -1 : 1);
            l15 = 1;
            if (!bl2 && !(bl2 = l18 == l11 ? 0 : (l18 < l11 ? -1 : 1))) {
                return (boolean)l15;
            }
            l18 = l10;
            l11 = this.y(l18, l11);
            l18 = l10 + l11;
            l11 = ((NvsTimelineAnimatedSticker)object).getOutPoint();
            l19 = l10;
            long l20 = l19 - l11;
            Object object2 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
            if (object2 > 0) {
                l11 = ((NvsTimelineAnimatedSticker)object).changeOutPoint(l18);
                l18 = l10;
                l18 = ((NvsTimelineAnimatedSticker)object).changeInPoint(l18);
            } else {
                l11 = l10;
                l11 = ((NvsTimelineAnimatedSticker)object).changeInPoint(l11);
                l18 = ((NvsTimelineAnimatedSticker)object).changeOutPoint(l18);
                long l21 = l11;
                l11 = l18;
                l18 = l21;
            }
            object = c10.m(l10);
            ((d.v.h.d.a)object).p(l11 -= l18);
            return (boolean)l15;
        }
        return false;
    }

    public boolean o(int n10, long l10) {
        d.v.h.d.c c10 = h.t().x(n10);
        NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker = this.v(n10);
        if (c10 != null && nvsTimelineAnimatedSticker != null) {
            long l11 = nvsTimelineAnimatedSticker.changeOutPoint(l10);
            long l12 = c10.e();
            c10.p(l11 -= l12);
            return true;
        }
        return false;
    }

    public boolean p(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker, d.v.h.d.c c10, a$a a$a) {
        if (c10 != null && nvsTimelineAnimatedSticker != null) {
            float f10;
            float f11;
            float f12;
            a$a a$a2 = c10.f();
            float f13 = a$a.a;
            float f14 = a$a2.a;
            float f15 = f13 - f14;
            Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (object != false || (f12 = (f11 = (f13 = a$a.b) - (f10 = a$a2.b)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
                this.T(nvsTimelineAnimatedSticker, a$a);
                c10.n(a$a);
                nvsTimelineAnimatedSticker = c10.B();
                c10.O((PointF)nvsTimelineAnimatedSticker);
            }
            return true;
        }
        return false;
    }

    public boolean q(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker, d.v.h.d.c c10, float f10, float[] fArray) {
        boolean bl2 = false;
        float f11 = 0.0f;
        float[] fArray2 = null;
        if (c10 != null && nvsTimelineAnimatedSticker != null) {
            float f12;
            float f13;
            float[] fArray3 = c10.j();
            float f14 = fArray3[0];
            f11 = fArray[0];
            bl2 = f14 == f11 ? 0 : (f14 > f11 ? 1 : -1);
            boolean bl3 = true;
            f14 = Float.MIN_VALUE;
            if (bl2 || (bl2 = (f13 = (f11 = fArray3[bl3]) - (f12 = fArray[bl3])) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) {
                f10 = this.C(nvsTimelineAnimatedSticker, f10);
                c10.L(f10);
                f10 = c10.y();
                fArray2 = c10.j();
                this.U(nvsTimelineAnimatedSticker, f10, fArray2);
                c10.q(fArray);
            }
            return bl3;
        }
        return false;
    }

    public boolean r(int n10, long l10) {
        d.v.h.d.d d10 = h.t().z(n10);
        NvsTimelineCaption nvsTimelineCaption = this.w(n10);
        if (nvsTimelineCaption != null && d10 != null) {
            long l11 = nvsTimelineCaption.changeOutPoint(l10);
            long l12 = d10.e();
            d10.p(l11 -= l12);
            return true;
        }
        return false;
    }

    public boolean t(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d d10) {
        int n10 = 0;
        float f10 = 0.0f;
        Object object = null;
        if (nvsTimelineCaption == null) {
            return false;
        }
        nvsTimelineCaption.setClipAffinityEnabled(false);
        n10 = d10.x();
        this.V(nvsTimelineCaption, n10);
        object = d10.v();
        this.W(nvsTimelineCaption, (String)object);
        n10 = d10.w();
        f10 = n10;
        this.X(nvsTimelineCaption, f10);
        f10 = d10.k();
        nvsTimelineCaption.setZValue(f10);
        object = d10.j();
        this.Z(nvsTimelineCaption, (float[])object);
        f10 = d10.d();
        nvsTimelineCaption.setRotationZ(f10);
        object = d10.f();
        this.Y(nvsTimelineCaption, (a$a)object);
        object = d10.g();
        DecorationType decorationType = DecorationType.CAPTION;
        if (object == decorationType) {
            this.a0(nvsTimelineCaption, d10);
        }
        nvsTimelineCaption = nvsTimelineCaption.getCaptionTranslation();
        d10.K((PointF)nvsTimelineCaption);
        return true;
    }

    public NvsTimelineAnimatedSticker v(int n10) {
        Object object = h.t().x(n10);
        if (object == null) {
            return null;
        }
        long l10 = ((d.v.h.d.a)object).e();
        object = this.D().getAnimatedStickersByTimelinePosition(l10);
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            return (NvsTimelineAnimatedSticker)object.get(0);
        }
        return null;
    }

    public NvsTimelineCaption w(int n10) {
        Object object = h.t().z(n10);
        if (object == null) {
            return null;
        }
        long l10 = ((d.v.h.d.a)object).e();
        object = this.D().getCaptionsByTimelinePosition(l10);
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            return (NvsTimelineCaption)object.get(0);
        }
        return null;
    }
}

