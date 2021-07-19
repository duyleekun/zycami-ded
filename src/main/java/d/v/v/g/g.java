/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.util.Size
 *  android.view.MotionEvent
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.v.g;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Size;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import com.meicam.sdk.NvsAnimatedSticker;
import com.meicam.sdk.NvsCaption;
import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsLiveWindow;
import com.meicam.sdk.NvsMaskRegionInfo;
import com.meicam.sdk.NvsMaskRegionInfo$Ellipse2D;
import com.meicam.sdk.NvsMaskRegionInfo$RegionInfo;
import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsPosition2D;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTimelineAnimatedSticker;
import com.meicam.sdk.NvsTimelineCaption;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsTrackVideoFx;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoResolution;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.nvseditor.R$id;
import com.zhiyun.nvseditor.R$layout;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import com.zhiyun.nvseditor.widget.NvsDrawRect;
import com.zhiyun.nvseditor.widget.NvsDrawRect$b;
import com.zhiyun.nvseditor.widget.NvsTouchRect;
import com.zhiyun.nvseditor.widget.NvsTouchRect$a;
import d.v.h.d.c;
import d.v.h.d.d;
import d.v.h.e.f;
import d.v.v.g.a;
import d.v.v.g.b;
import d.v.v.g.g$a;
import d.v.v.g.g$b;
import d.v.v.g.h;
import d.v.v.q.i;
import d.v.v.q.j;
import d.v.v.q.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
extends f {
    private static final int A = 2;
    public static final double B = 10.0;
    public static final int C = 200;
    private static final int y = 0;
    private static final int z = 1;
    private NvsLiveWindow c;
    private NvsStreamingContext d;
    private d.v.v.j.g e;
    private NvsDrawRect f;
    private NvsTouchRect g;
    private NvsTimelineAnimatedSticker h;
    private c i;
    private NvsTimelineCaption j;
    private d k;
    private int l = 0;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private int s;
    private boolean t;
    private boolean u;
    private String v;
    private long w;
    private PointF x;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        boolean bl2;
        this.m = bl2 = true;
        this.n = bl2;
        this.o = false;
        this.p = false;
        this.r = false;
        this.t = bl2;
        this.u = bl2;
        this.L();
        this.J();
        this.K();
    }

    private void B() {
        NvsFx nvsFx = this.getCurrentPositionMaxCaption();
        if (nvsFx != null) {
            this.setDrawRectVisible(0);
            this.c0((NvsTimelineCaption)nvsFx);
        } else {
            boolean bl2 = this.n;
            int n10 = 8;
            if (!bl2) {
                nvsFx = this.getCurrentPositionMaxSticker();
                if (nvsFx == null) {
                    this.setDrawRectVisible(n10);
                    return;
                }
                this.setDrawRectVisible(0);
                this.e0((NvsTimelineAnimatedSticker)nvsFx);
            } else {
                this.setDrawRectVisible(n10);
            }
        }
    }

    private void C() {
        NvsFx nvsFx = this.getCurrentPositionMaxSticker();
        if (nvsFx != null) {
            this.setDrawRectVisible(0);
            this.e0((NvsTimelineAnimatedSticker)nvsFx);
        } else {
            boolean bl2 = this.m;
            int n10 = 8;
            if (!bl2) {
                nvsFx = this.getCurrentPositionMaxCaption();
                if (nvsFx == null) {
                    this.setDrawRectVisible(n10);
                    return;
                }
                this.setDrawRectVisible(0);
                this.c0((NvsTimelineCaption)nvsFx);
            } else {
                this.setDrawRectVisible(n10);
            }
        }
    }

    private void D(NvsTimelineCaption nvsTimelineCaption, NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        if (nvsTimelineCaption != null) {
            this.c0(nvsTimelineCaption);
            return;
        }
        if (nvsTimelineAnimatedSticker != null) {
            this.e0(nvsTimelineAnimatedSticker);
        }
    }

    private int H(NvsTimelineCaption nvsTimelineCaption) {
        int n10;
        block2: {
            int n11;
            List list = this.getTimelineData().getTextInfoList();
            for (n10 = 0; n10 < (n11 = list.size()); ++n10) {
                long l10;
                Object object;
                long l11;
                long l12;
                Object object2;
                Object object3 = (d)list.get(n10);
                if (object3 == null || (object2 = (l12 = (l11 = ((Long)(object = ((d.v.h.d.a)object3).e())).longValue()) - (l10 = nvsTimelineCaption.getInPoint())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) continue;
                l11 = ((d.v.h.d.a)object3).i();
                l10 = nvsTimelineCaption.getOutPoint();
                long l13 = nvsTimelineCaption.getInPoint();
                long l14 = l11 - (l10 -= l13);
                object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 != false || (n11 = (int)(((String)(object3 = ((d)object3).y())).equals(object = nvsTimelineCaption.getText()) ? 1 : 0)) == 0) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    private int I(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        int n10;
        block2: {
            int n11;
            List list = d.v.v.j.h.t().n().getPasteInfoList();
            for (n10 = 0; n10 < (n11 = list.size()); ++n10) {
                long l10;
                Long l11;
                long l12;
                long l13;
                long l14;
                c c10 = (c)list.get(n10);
                if (c10 == null || (l14 = (l13 = (l12 = (l11 = c10.e()).longValue()) - (l10 = nvsTimelineAnimatedSticker.getInPoint())) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) continue;
                long l15 = c10.i();
                long l16 = nvsTimelineAnimatedSticker.getOutPoint();
                long l17 = nvsTimelineAnimatedSticker.getInPoint();
                long l18 = l15 - (l16 -= l17);
                n11 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
                if (n11 != 0) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    private void J() {
        Object object = NvsStreamingContext.getInstance();
        this.d = object;
        this.e = object = d.v.v.j.g.c();
        this.d.setDefaultCaptionFade(false);
    }

    private void K() {
        Object object = this.f;
        Object object2 = new g$a(this);
        ((NvsDrawRect)((Object)object)).setOnTouchListener((NvsDrawRect$b)object2);
        object = this.c;
        object2 = new a(this);
        object.setOnTouchListener((View.OnTouchListener)object2);
        object = this.g;
        object2 = new g$b(this);
        ((NvsTouchRect)((Object)object)).setScaleCallback((NvsTouchRect$a)object2);
    }

    private void L() {
        Object object = this.a;
        int n10 = R$id.nvs_live_window;
        object = (NvsLiveWindow)object.findViewById(n10);
        this.c = object;
        object = this.a;
        n10 = R$id.nvs_draw_rect;
        object = (NvsDrawRect)object.findViewById(n10);
        this.f = object;
        object = this.a;
        n10 = R$id.nvs_touch_rect;
        object = (NvsTouchRect)object.findViewById(n10);
        this.g = object;
        this.c.setFillMode(1);
    }

    private NvsTimelineCaption M(float f10, float f11) {
        boolean bl2;
        Iterator iterator2 = this.getTimeline();
        long l10 = d.v.v.q.h.n();
        iterator2 = ((NvsTimeline)((Object)iterator2)).getCaptionsByTimelinePosition(l10);
        NvsTimelineCaption nvsTimelineCaption = null;
        if (iterator2 != null && !(bl2 = iterator2.isEmpty())) {
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                List list;
                boolean bl3;
                NvsTimelineCaption nvsTimelineCaption2 = (NvsTimelineCaption)iterator2.next();
                if (nvsTimelineCaption2 == null || !(bl3 = this.N(list = nvsTimelineCaption2.getBoundingRectangleVertices(), f10, f11))) continue;
                nvsTimelineCaption = nvsTimelineCaption2;
                break;
            }
        }
        return nvsTimelineCaption;
    }

    private boolean N(List list, float f10, float f11) {
        int n10;
        int n11;
        int n12 = 0;
        if (list != null && (n11 = list.size()) >= (n10 = 4)) {
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            list = this.G(list);
            PointF pointF = (PointF)list.get(0);
            n10 = 1;
            PointF pointF2 = (PointF)list.get(n10);
            int n13 = 2;
            PointF pointF3 = (PointF)list.get(n13);
            int n14 = 3;
            list = (PointF)list.get(n14);
            float f19 = pointF2.x;
            float f20 = pointF.x;
            float f21 = f19 - f20;
            float f22 = pointF.y;
            float f23 = f11 - f22;
            f21 *= f23;
            float f24 = pointF2.y;
            f23 = f24 - f22;
            float f25 = f10 - f20;
            f21 -= (f23 *= f25);
            f23 = pointF3.x;
            f25 = f23 - f19;
            float f26 = f11 - f24;
            f25 *= f26;
            float f27 = pointF3.y;
            f24 = f27 - f24;
            f19 = f10 - f19;
            f25 -= (f24 *= f19);
            f24 = ((PointF)list).x;
            f19 = f24 - f23;
            f26 = f11 - f27;
            f19 *= f26;
            float f28 = ((PointF)list).y;
            f27 = f28 - f27;
            f23 = f10 - f23;
            f20 -= f24;
            f20 *= (f11 -= f28);
            f22 -= f28;
            int n15 = 0;
            f28 = 0.0f;
            list = null;
            float f29 = f21 - 0.0f;
            Object object = f29 == 0.0f ? 0 : (f29 > 0.0f ? 1 : -1);
            if (object > 0 && (object = (f18 = f25 - 0.0f) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1)) > 0 && (object = (f17 = (f19 -= (f27 *= f23)) - 0.0f) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1)) > 0 && (object = (f16 = (f20 -= (f22 *= (f10 -= f24))) - 0.0f) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) > 0 || (object = (f15 = f21 - 0.0f) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) < 0 && (object = (f14 = f25 - 0.0f) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1)) < 0 && (object = (f13 = f19 - 0.0f) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1)) < 0 && (n15 = (f12 = f20 - 0.0f) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1)) < 0) {
                n12 = n10;
            }
        }
        return n12 != 0;
    }

    private boolean O() {
        return d.v.v.j.i.e().l();
    }

    private NvsTimelineAnimatedSticker P(float f10, float f11) {
        boolean bl2;
        Iterator iterator2 = this.getTimeline();
        long l10 = d.v.v.q.h.n();
        iterator2 = ((NvsTimeline)((Object)iterator2)).getAnimatedStickersByTimelinePosition(l10);
        NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker = null;
        if (iterator2 != null && !(bl2 = iterator2.isEmpty())) {
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                List list;
                boolean bl3;
                NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker2 = (NvsTimelineAnimatedSticker)iterator2.next();
                if (nvsTimelineAnimatedSticker2 == null || !(bl3 = this.N(list = nvsTimelineAnimatedSticker2.getBoundingRectangleVertices(), f10, f11))) continue;
                nvsTimelineAnimatedSticker = nvsTimelineAnimatedSticker2;
                break;
            }
        }
        return nvsTimelineAnimatedSticker;
    }

    private boolean Q(float f10, float f11) {
        int n10 = this.c.getWidth();
        int n11 = this.c.getHeight();
        Size size = d.v.v.q.h.d0(n10, n11);
        int n12 = size.getWidth();
        float f12 = n10 - n12 >> 1;
        int n13 = size.getHeight();
        float f13 = n11 - n13 >> 1;
        int n14 = size.getWidth();
        float f14 = n10 + n14 >> 1;
        int n15 = size.getHeight();
        float f15 = n11 + n15 >> 1;
        RectF rectF = new RectF(f12, f13, f14, f15);
        return rectF.contains(f10, f11);
    }

    private /* synthetic */ boolean R(View view, MotionEvent motionEvent) {
        boolean bl2 = this.O();
        boolean bl3 = true;
        if (!bl2) {
            return bl3;
        }
        this.m0(motionEvent);
        return bl3;
    }

    private /* synthetic */ void T() {
        List list = this.j.getBoundingRectangleVertices();
        list = this.G(list);
        this.f.g(list, 1);
    }

    private void Z() {
        long l10;
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        Object object = nvsVideoTrack.getTrackVideoFxByPosition(l10 = 40000L);
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                String string2;
                String string3;
                boolean bl3;
                NvsTrackVideoFx nvsTrackVideoFx = (NvsTrackVideoFx)object.next();
                if (nvsTrackVideoFx == null || !(bl3 = (string3 = nvsTrackVideoFx.getBuiltinTrackVideoFxName()).equals(string2 = "Mask Generator"))) continue;
                nvsVideoTrack.removeTrackVideoFx(nvsTrackVideoFx);
                break;
            }
        }
    }

    private void a0(long l10, int n10) {
        d.v.v.g.h.k().I(l10, n10);
    }

    public static /* synthetic */ NvsLiveWindow b(g g10) {
        return g10.c;
    }

    public static /* synthetic */ int c(g g10) {
        return g10.l;
    }

    private void c0(NvsTimelineCaption object) {
        int n10;
        int n11;
        float f10;
        float f11;
        Object object2 = this.getCurrentPositionMaxCaption();
        float f12 = -1.0f;
        if (object2 != null) {
            f11 = ((NvsCaption)object2).getZValue();
            f10 = ((NvsCaption)object).getZValue();
            ((NvsCaption)object2).setZValue(f10);
            object2 = d.v.v.g.h.k();
            n11 = (int)(((h)object2).r() ? 1 : 0);
            if (n11 == 0) {
                object2 = d.v.v.g.h.k();
                n10 = 2;
                f10 = 2.8E-45f;
                ((h)object2).F(n10);
            }
        } else {
            f11 = f12;
        }
        this.l = n11 = 1;
        this.j = object;
        int n12 = this.H((NvsTimelineCaption)object);
        n10 = -1;
        f10 = 0.0f / 0.0f;
        if (n12 != n10) {
            d.v.v.j.h h10 = d.v.v.j.h.t();
            this.k = object = h10.z(n12);
        }
        if ((n12 = (int)(f11 == f12 ? 0 : (f11 > f12 ? 1 : -1))) != 0) {
            object = this.j;
            ((NvsCaption)object).setZValue(f11);
        }
        if ((n12 = (object = this.c).getWidth()) == 0) {
            object = this.c;
            object2 = new b(this);
            object.post((Runnable)object2);
        } else {
            object = this.j.getBoundingRectangleVertices();
            object = this.G((List)object);
            NvsDrawRect nvsDrawRect = this.f;
            nvsDrawRect.g((List)object, n11);
        }
    }

    public static /* synthetic */ d.v.v.j.g d(g g10) {
        return g10.e;
    }

    public static /* synthetic */ int e(g g10, NvsTimelineCaption nvsTimelineCaption) {
        return g10.H(nvsTimelineCaption);
    }

    private void e0(NvsTimelineAnimatedSticker object) {
        int n10;
        int n11;
        float f10;
        float f11;
        Object object2 = this.getCurrentPositionMaxSticker();
        float f12 = -1.0f;
        if (object2 != null) {
            f11 = ((NvsAnimatedSticker)object2).getZValue();
            f10 = ((NvsAnimatedSticker)object).getZValue();
            ((NvsAnimatedSticker)object2).setZValue(f10);
            object2 = d.v.v.g.h.k();
            n11 = (int)(((h)object2).r() ? 1 : 0);
            if (n11 == 0) {
                object2 = d.v.v.g.h.k();
                n10 = 4;
                f10 = 5.6E-45f;
                ((h)object2).F(n10);
            }
        } else {
            f11 = f12;
        }
        this.l = n11 = 2;
        this.h = object;
        int n12 = this.I((NvsTimelineAnimatedSticker)object);
        n10 = -1;
        f10 = 0.0f / 0.0f;
        if (n12 != n10) {
            d.v.v.j.h h10 = d.v.v.j.h.t();
            this.i = object = h10.x(n12);
        }
        if ((n12 = (int)(f11 == f12 ? 0 : (f11 > f12 ? 1 : -1))) != 0) {
            object = this.h;
            ((NvsAnimatedSticker)object).setZValue(f11);
        }
        object = this.h.getBoundingRectangleVertices();
        object = this.G((List)object);
        this.f.g((List)object, n11);
    }

    public static /* synthetic */ void f(g g10) {
        g10.B();
    }

    private void f0(int n10) {
        int n11 = this.l;
        int n12 = -1;
        int n13 = 1;
        if (n11 == n13) {
            NvsTimelineCaption nvsTimelineCaption = this.j;
            n11 = this.H(nvsTimelineCaption);
            if (n11 != n12) {
                d.v.v.j.g g10 = this.e;
                DecorationType decorationType = DecorationType.CAPTION;
                g10.j(n11, decorationType, n10);
            }
        } else {
            NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker;
            n13 = 2;
            if (n11 == n13 && (n11 = this.I(nvsTimelineAnimatedSticker = this.h)) != n12) {
                d.v.v.j.g g11 = this.e;
                DecorationType decorationType = DecorationType.IMAGE_PASTER;
                g11.j(n11, decorationType, n10);
            }
        }
    }

    public static /* synthetic */ boolean g(g g10) {
        return g10.m;
    }

    private void g0(float f10, float f11) {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return;
        }
        int n10 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
            nvsVideoClip.setPanAndScan(f10, f11);
        }
    }

    private NvsTimelineCaption getCurrentPositionMaxCaption() {
        Object object = this.d;
        NvsTimeline nvsTimeline = this.getTimeline();
        long l10 = ((NvsStreamingContext)object).getTimelineCurrentPosition(nvsTimeline);
        NvsTimeline nvsTimeline2 = this.getTimeline();
        object = nvsTimeline2.getCaptionsByTimelinePosition(l10);
        int n10 = object.size();
        if (n10 > 0) {
            int n11;
            nvsTimeline = null;
            float f10 = ((NvsTimelineCaption)object.get(0)).getZValue();
            int n12 = 0;
            nvsTimeline2 = null;
            for (n10 = 0; n10 < (n11 = object.size()); ++n10) {
                NvsTimelineCaption nvsTimelineCaption = (NvsTimelineCaption)object.get(n10);
                float f11 = nvsTimelineCaption.getZValue();
                float f12 = f11 - f10;
                Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
                if (object2 <= 0) continue;
                n12 = n10;
                f10 = f11;
            }
            object = (NvsTimelineCaption)object.get(n12);
        } else {
            object = null;
        }
        return object;
    }

    private NvsTimelineAnimatedSticker getCurrentPositionMaxSticker() {
        Object object = this.d;
        NvsTimeline nvsTimeline = this.getTimeline();
        long l10 = ((NvsStreamingContext)object).getTimelineCurrentPosition(nvsTimeline);
        NvsTimeline nvsTimeline2 = this.getTimeline();
        object = nvsTimeline2.getAnimatedStickersByTimelinePosition(l10);
        int n10 = object.size();
        if (n10 > 0) {
            int n11;
            nvsTimeline = null;
            float f10 = ((NvsTimelineAnimatedSticker)object.get(0)).getZValue();
            int n12 = 0;
            nvsTimeline2 = null;
            for (n10 = 0; n10 < (n11 = object.size()); ++n10) {
                NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker = (NvsTimelineAnimatedSticker)object.get(n10);
                float f11 = nvsTimelineAnimatedSticker.getZValue();
                float f12 = f11 - f10;
                Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
                if (object2 <= 0) continue;
                n12 = n10;
                f10 = f11;
            }
            object = (NvsTimelineAnimatedSticker)object.get(n12);
        } else {
            object = null;
        }
        return object;
    }

    private NvsTimeline getTimeline() {
        return d.v.v.j.i.e().f();
    }

    private NvsTimelineData getTimelineData() {
        return d.v.v.j.h.t().n();
    }

    public static /* synthetic */ boolean h(g g10) {
        return g10.n;
    }

    public static /* synthetic */ void i(g g10, NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        g10.e0(nvsTimelineAnimatedSticker);
    }

    public static /* synthetic */ void j(g g10, NvsTimelineCaption nvsTimelineCaption) {
        g10.c0(nvsTimelineCaption);
    }

    public static /* synthetic */ void k(g g10, NvsTimelineCaption nvsTimelineCaption, NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        g10.D(nvsTimelineCaption, nvsTimelineAnimatedSticker);
    }

    public static /* synthetic */ void l(g g10, int n10) {
        g10.f0(n10);
    }

    public static /* synthetic */ boolean m(g g10) {
        return g10.O();
    }

    private void m0(MotionEvent object) {
        int n10 = object.getAction();
        int n11 = 1;
        float f10 = Float.MIN_VALUE;
        if (n10 != 0) {
            if (n10 == n11) {
                long l10 = System.currentTimeMillis();
                long l11 = this.w;
                long l12 = (l10 -= l11) - (l11 = 200L);
                n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n10 <= 0) {
                    f10 = object.getX();
                    float f11 = object.getY();
                    PointF pointF = new PointF(f10, f11);
                    f11 = pointF.x;
                    PointF pointF2 = this.x;
                    f10 = pointF2.x;
                    double d10 = Math.sqrt(f11 - f10);
                    f11 = pointF.x;
                    PointF pointF3 = this.x;
                    float f12 = pointF3.x;
                    double d11 = f11 - f12;
                    d10 *= d11;
                    f11 = pointF.y;
                    float f13 = pointF3.y;
                    float f14 = f11 - f13;
                    double d12 = f14 *= (f11 -= f13);
                    double d13 = (d10 += d12) - (d12 = 10.0);
                    Object object2 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
                    if (object2 <= 0) {
                        object2 = this.o;
                        if (object2 != false && (object2 = (Object)this.t) != false) {
                            object = this.e;
                            ((d.v.v.j.g)object).w();
                        }
                        if ((object2 = (Object)this.p) == false && (n10 = (int)(this.r ? 1 : 0)) == 0) {
                            object = this.e;
                            ((d.v.v.j.g)object).k();
                        } else {
                            n10 = 0;
                            f13 = 0.0f;
                            pointF = null;
                            if (object2 != false) {
                                object = this.e;
                                n11 = this.q;
                                DecorationType decorationType = DecorationType.CAPTION;
                                ((d.v.v.j.g)object).i(n11, decorationType);
                                this.p = false;
                                this.r = false;
                            } else {
                                object = this.e;
                                n11 = this.s;
                                DecorationType decorationType = DecorationType.IMAGE_PASTER;
                                ((d.v.v.j.g)object).i(n11, decorationType);
                                this.r = false;
                            }
                        }
                    }
                }
            }
        } else {
            float f15;
            Object object3;
            long l13;
            this.w = l13 = System.currentTimeMillis();
            float f16 = object.getX();
            float f17 = object.getY();
            this.x = object3 = new PointF(f16, f17);
            float f18 = object.getX();
            f16 = object.getY();
            n10 = (int)(this.Q(f18, f16) ? 1 : 0);
            this.o = n10;
            f18 = object.getX();
            object3 = this.P(f18, f16 = object.getY());
            if (object3 != null) {
                this.r = n11;
                this.s = n10 = this.I((NvsTimelineAnimatedSticker)object3);
            }
            if ((object = this.M(f18 = object.getX(), f15 = object.getY())) != null) {
                int n12;
                this.p = n11;
                this.q = n12 = this.H((NvsTimelineCaption)object);
            }
        }
    }

    public static /* synthetic */ NvsTimelineAnimatedSticker n(g g10) {
        return g10.h;
    }

    public static /* synthetic */ void o(g g10, MotionEvent motionEvent) {
        g10.m0(motionEvent);
    }

    public static /* synthetic */ NvsTimelineAnimatedSticker p(g g10, NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        g10.h = nvsTimelineAnimatedSticker;
        return nvsTimelineAnimatedSticker;
    }

    public static /* synthetic */ NvsTouchRect q(g g10) {
        return g10.g;
    }

    public static /* synthetic */ c r(g g10) {
        return g10.i;
    }

    public static /* synthetic */ void s(g g10, long l10, int n10) {
        g10.a0(l10, n10);
    }

    public static /* synthetic */ NvsTimelineCaption t(g g10) {
        return g10.j;
    }

    public static /* synthetic */ NvsTimelineCaption u(g g10, NvsTimelineCaption nvsTimelineCaption) {
        g10.j = nvsTimelineCaption;
        return nvsTimelineCaption;
    }

    public static /* synthetic */ d v(g g10) {
        return g10.k;
    }

    public static /* synthetic */ int w(g g10, NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        return g10.I(nvsTimelineAnimatedSticker);
    }

    public static /* synthetic */ NvsTimeline x(g g10) {
        return g10.getTimeline();
    }

    public static /* synthetic */ void y(g g10) {
        g10.C();
    }

    private void z(float f10) {
        NvsObject nvsObject = d.v.v.q.h.h0();
        long l10 = ((NvsTrack)nvsObject).getDuration();
        nvsObject = ((NvsVideoTrack)nvsObject).addBuiltinTrackVideoFx(0L, l10, "Mask Generator");
        NvsMaskRegionInfo nvsMaskRegionInfo = new NvsMaskRegionInfo();
        NvsMaskRegionInfo$RegionInfo nvsMaskRegionInfo$RegionInfo = new NvsMaskRegionInfo$RegionInfo(2);
        NvsMaskRegionInfo$Ellipse2D nvsMaskRegionInfo$Ellipse2D = new NvsMaskRegionInfo$Ellipse2D();
        NvsPosition2D nvsPosition2D = new NvsPosition2D(0.0f, 0.0f);
        nvsMaskRegionInfo$Ellipse2D.setCenter(nvsPosition2D);
        nvsMaskRegionInfo$Ellipse2D.setA(f10);
        nvsMaskRegionInfo$Ellipse2D.setB(f10);
        nvsMaskRegionInfo$RegionInfo.setEllipse2D(nvsMaskRegionInfo$Ellipse2D);
        nvsMaskRegionInfo.addRegionInfo(nvsMaskRegionInfo$RegionInfo);
        boolean bl2 = true;
        ((NvsFx)nvsObject).setIntVal("Region Coordinate System Type", (int)(bl2 ? 1 : 0));
        ((NvsFx)nvsObject).setBooleanVal("Reverse Region", false);
        ((NvsFx)nvsObject).setBooleanVal("Ignore Region Background", bl2);
        ((NvsFx)nvsObject).setBooleanVal("Enable Region", bl2);
        ((NvsFx)nvsObject).setArbDataVal("Region Data", nvsMaskRegionInfo);
    }

    public boolean A(int n10) {
        int n11;
        int n12;
        Object object = d.v.v.q.j.i(n10);
        h h10 = d.v.v.g.h.k();
        boolean bl2 = h10.r();
        NvsTimeline nvsTimeline = this.getTimeline();
        boolean bl3 = nvsTimeline.changeVideoSize(n12 = ((NvsVideoResolution)object).imageWidth, n11 = ((NvsVideoResolution)object).imageHeight);
        if (bl3) {
            float f10;
            float f11;
            int n13;
            String string2;
            Object object2;
            n12 = (int)(this.u ? 1 : 0);
            if (n12 != 0) {
                object2 = this.getTimeline();
                string2 = this.v;
                d.v.v.q.k.b((NvsTimeline)object2, string2);
            }
            d.v.v.q.i.u();
            object2 = this.getTimelineData();
            int n14 = ((NvsVideoResolution)object).imageWidth;
            int n15 = ((NvsVideoResolution)object).imageHeight;
            string2 = new Size(n14, n15);
            ((NvsTimelineData)object2).setResolutionSize((Size)string2);
            object2 = this.getTimelineData();
            ((NvsTimelineData)object2).setAspectRadio(n10);
            n12 = 6;
            float f12 = 8.4E-45f;
            if (n10 == n12) {
                n13 = ((NvsVideoResolution)object).imageHeight;
                f11 = n13;
                n12 = 0x40000000;
                f12 = 2.0f;
                this.z(f11 /= f12);
            } else {
                this.Z();
            }
            n13 = 4;
            f11 = 5.6E-45f;
            n12 = 0;
            f12 = 0.0f;
            object2 = null;
            if (n10 == n13) {
                this.g0(0.0f, 0.0f);
            } else {
                n10 = 1065353216;
                f10 = 1.0f;
                this.g0(0.0f, f10);
            }
            d.v.v.q.i.C();
            Object object3 = this.d;
            object = this.getTimeline();
            long l10 = ((NvsStreamingContext)object3).getTimelineCurrentPosition((NvsTimeline)object);
            if (bl2) {
                object3 = d.v.v.g.h.k();
                ((h)object3).C();
            } else {
                n10 = 0;
                f10 = 0.0f;
                object3 = null;
                this.a0(l10, 0);
            }
        }
        return bl3;
    }

    public void E() {
        this.c.clearVideoFrame();
    }

    public void F() {
        this.g.setVisibility(8);
    }

    public List G(List list) {
        int n10;
        ArrayList<NvsLiveWindow> arrayList = new ArrayList<NvsLiveWindow>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            NvsLiveWindow nvsLiveWindow = this.c;
            PointF pointF = (PointF)list.get(i10);
            nvsLiveWindow = nvsLiveWindow.mapCanonicalToView(pointF);
            arrayList.add(nvsLiveWindow);
        }
        return arrayList;
    }

    public /* synthetic */ boolean S(View view, MotionEvent motionEvent) {
        return this.R(view, motionEvent);
    }

    public /* synthetic */ void U() {
        this.T();
    }

    public void V() {
        this.n = true;
        int n10 = this.l;
        int n11 = 2;
        if (n10 == n11) {
            n10 = 0;
            this.l = 0;
        }
        if ((n10 = (int)(this.m ? 1 : 0)) != 0) {
            n10 = 8;
            this.setDrawRectVisible(n10);
        } else {
            this.B();
        }
    }

    public void W() {
        int n10;
        this.m = n10 = 1;
        int n11 = this.l;
        if (n11 == n10) {
            n10 = 0;
            this.l = 0;
        }
        if ((n10 = (int)(this.n ? 1 : 0)) != 0) {
            n10 = 8;
            this.setDrawRectVisible(n10);
        } else {
            this.C();
        }
    }

    public void X() {
        this.g.setVisibility(0);
        Object object = this.g;
        Object object2 = d.v.v.m.a.h();
        int n10 = d.v.v.q.h.p();
        float f10 = ((d.v.v.m.a)object2).e(n10);
        object.setInitScale(f10);
        object = this.getTimeline().getVideoRes();
        object2 = this.g;
        float f11 = ((NvsVideoResolution)object).imageWidth;
        float f12 = ((NvsVideoResolution)object).imageHeight;
        ((NvsTouchRect)((Object)object2)).setRatio(f11 /= f12);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void Y() {
        long l10;
        int n10 = this.l;
        int n11 = 2;
        int n12 = 8;
        if (n10 == n11) {
            long l11;
            Object object = this.h;
            if (object == null) {
                this.setDrawRectVisible(n12);
                return;
            }
            long l12 = d.v.v.q.h.n();
            object = this.h;
            long l13 = ((NvsTimelineAnimatedSticker)object).getInPoint();
            long l14 = l13 - l12;
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 <= 0 && (n10 = (int)((l11 = (l13 = ((NvsTimelineAnimatedSticker)(object = this.h)).getOutPoint()) - l12) == 0L ? 0 : (l11 < 0L ? -1 : 1))) >= 0) {
                object = this.h.getBoundingRectangleVertices();
                if (object == null) {
                    this.setDrawRectVisible(n12);
                    return;
                }
                object = this.G((List)object);
                NvsDrawRect nvsDrawRect = this.f;
                nvsDrawRect.g((List)object, n11);
                this.C();
                return;
            }
            this.setDrawRectVisible(n12);
            return;
        }
        n11 = 1;
        if (n10 != n11) return;
        Object object = this.j;
        if (object == null) {
            this.setDrawRectVisible(n12);
            return;
        }
        long l15 = d.v.v.q.h.n();
        object = this.j;
        long l16 = ((NvsTimelineCaption)object).getInPoint();
        long l17 = l16 - l15;
        n10 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
        if (n10 <= 0 && (n10 = (int)((l10 = (l16 = ((NvsTimelineCaption)(object = this.j)).getOutPoint()) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1))) >= 0) {
            object = this.j.getBoundingRectangleVertices();
            if (object == null) {
                this.setDrawRectVisible(n12);
                return;
            }
            object = this.G((List)object);
            NvsDrawRect nvsDrawRect = this.f;
            nvsDrawRect.g((List)object, n11);
            this.B();
            return;
        }
        this.setDrawRectVisible(n12);
    }

    public int a() {
        return R$layout.nvs_player_view;
    }

    public NvsTimelineAnimatedSticker b0(PointF pointF) {
        boolean bl2 = this.O();
        NvsObject nvsObject = null;
        if (!bl2) {
            return null;
        }
        Object object = this.d;
        NvsObject nvsObject2 = this.getTimeline();
        long l10 = ((NvsStreamingContext)object).getTimelineCurrentPosition((NvsTimeline)nvsObject2);
        object = this.getTimeline().getAnimatedStickersByTimelinePosition(l10);
        int n10 = object.size();
        if (n10 <= 0) {
            return null;
        }
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            float f10;
            float f11;
            float f12;
            float f13;
            int n11;
            float f14;
            int n12;
            nvsObject2 = (NvsTimelineAnimatedSticker)object.next();
            List list = ((NvsAnimatedSticker)nvsObject2).getBoundingRectangleVertices();
            NvsDrawRect nvsDrawRect = this.f;
            int n13 = nvsDrawRect.c(list = this.G(list), n12 = (int)(f14 = pointF.x), n11 = (int)(f13 = pointF.y));
            if (n13 == 0 || nvsObject != null && (n13 = (f12 = (f11 = ((NvsAnimatedSticker)nvsObject2).getZValue()) - (f10 = ((NvsAnimatedSticker)nvsObject).getZValue())) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) <= 0) continue;
            nvsObject = nvsObject2;
        }
        return nvsObject;
    }

    public NvsTimelineCaption d0(PointF pointF) {
        boolean bl2 = this.O();
        NvsObject nvsObject = null;
        if (!bl2) {
            return null;
        }
        Object object = this.d;
        NvsObject nvsObject2 = this.getTimeline();
        long l10 = ((NvsStreamingContext)object).getTimelineCurrentPosition((NvsTimeline)nvsObject2);
        object = this.getTimeline().getCaptionsByTimelinePosition(l10);
        int n10 = object.size();
        if (n10 <= 0) {
            return null;
        }
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            float f10;
            float f11;
            float f12;
            float f13;
            int n11;
            float f14;
            int n12;
            nvsObject2 = (NvsTimelineCaption)object.next();
            List list = ((NvsCaption)nvsObject2).getBoundingRectangleVertices();
            NvsDrawRect nvsDrawRect = this.f;
            int n13 = nvsDrawRect.c(list = this.G(list), n12 = (int)(f14 = pointF.x), n11 = (int)(f13 = pointF.y));
            if (n13 == 0 || nvsObject != null && (n13 = (f12 = (f11 = ((NvsCaption)nvsObject2).getZValue()) - (f10 = ((NvsCaption)nvsObject).getZValue())) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) <= 0) continue;
            nvsObject = nvsObject2;
        }
        return nvsObject;
    }

    public SurfaceView getDisplayView() {
        return this.c;
    }

    public NvsLiveWindow getNvsLiveWindow() {
        return this.c;
    }

    public void h0(boolean bl2, String string2) {
        this.v = string2;
        this.u = bl2;
        if (bl2) {
            Object object = this.getTimeline();
            string2 = this.v;
            d.v.v.q.k.b((NvsTimeline)object, string2);
            object = d.v.v.g.h.k();
            ((h)object).E();
        }
    }

    public void i0() {
        this.n = false;
        this.C();
    }

    public void j0() {
        this.m = false;
        this.B();
    }

    public void k0(NvsTimelineAnimatedSticker object) {
        int n10;
        int n11;
        if (object != null && (object = ((NvsAnimatedSticker)object).getBoundingRectangleVertices()) != null && (n11 = object.size()) >= (n10 = 4)) {
            object = this.G((List)object);
            NvsDrawRect nvsDrawRect = this.f;
            n10 = 2;
            nvsDrawRect.g((List)object, n10);
        }
    }

    public void l0(NvsTimelineCaption object) {
        int n10;
        int n11;
        if (object != null && (object = ((NvsCaption)object).getBoundingRectangleVertices()) != null && (n11 = object.size()) >= (n10 = 4)) {
            object = this.G((List)object);
            NvsDrawRect nvsDrawRect = this.f;
            n10 = 1;
            nvsDrawRect.g((List)object, n10);
        }
    }

    public void setDrawRectVisible(int n10) {
        this.f.setVisibility(n10);
    }

    public void setPlayViewBackground(int n10) {
        NvsColor nvsColor = d.v.v.q.j.c(d.v.v.q.j.a(n10));
        NvsLiveWindow nvsLiveWindow = this.c;
        float f10 = nvsColor.r;
        float f11 = nvsColor.g;
        float f12 = nvsColor.b;
        nvsLiveWindow.setBackgroundColor(f10, f11, f12);
    }

    public void setSendPlayAreaClickEnable(boolean bl2) {
        this.t = bl2;
    }
}

