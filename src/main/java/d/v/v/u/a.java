/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.util.Size
 */
package d.v.v.u;

import android.graphics.RectF;
import android.util.Size;
import com.meicam.sdk.NvsSize;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoFx;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.e.d;
import d.v.v.g.h;
import java.util.List;

public class a {
    private static final RectF a;
    private static final RectF b;
    private static final RectF c;
    private static final RectF d;
    private static final RectF e;
    private static final RectF f;

    static {
        RectF rectF;
        float f10 = -1.0f;
        float f11 = 1.0f;
        a = rectF = new RectF(f10, f11, f11, f10);
        float f12 = -0.8f;
        float f13 = 0.8f;
        b = rectF = new RectF(f12, f13, f13, f12);
        float f14 = 0.9f;
        float f15 = -0.9f;
        c = rectF = new RectF(f10, f14, f13, f15);
        d = rectF = new RectF(f12, f14, f11, f15);
        e = rectF = new RectF(f15, f11, f14, f12);
        f = rectF = new RectF(f15, f13, f14, f10);
    }

    private a() {
    }

    private static void a() {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return;
        }
        int n10 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            d d10;
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
            if (nvsVideoClip == null || (d10 = d.v.v.j.h.t().v(i10)) == null) continue;
            int n11 = d10.A();
            d10 = d10.z();
            d.v.v.u.a.h(nvsVideoClip, n11, (Size)d10);
        }
        d.v.v.u.a.d();
        d.v.v.u.a.c().setGlobalZoomModeEnable(false);
    }

    public static RectF b(RectF rectF, Size size) {
        NvsSize nvsSize = d.v.v.q.h.S();
        float f10 = nvsSize.width;
        float f11 = 1.0f;
        f10 *= f11;
        float f12 = nvsSize.height;
        f10 /= f12;
        int n10 = size.getWidth();
        f12 = (float)n10 * f11;
        int n11 = size.getHeight();
        float f13 = n11;
        float f14 = (f12 /= f13) - f10;
        Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object < 0) {
            f10 = nvsSize.height;
            float f15 = (float)nvsSize.width * f11;
            f11 = size.getWidth();
            f15 /= f11;
            float f16 = size.getHeight();
            f15 = rectF.left;
            f11 = rectF.top * (f10 /= (f15 *= f16));
            f12 = rectF.right;
            float f17 = rectF.bottom * f10;
            size = new RectF(f15, f11, f12, f17);
            return size;
        }
        f10 = nvsSize.width;
        float f18 = (float)nvsSize.height * f11;
        f11 = size.getHeight();
        f18 /= f11;
        float f19 = size.getWidth();
        f18 = rectF.left * (f10 /= (f18 *= f19));
        f11 = rectF.top;
        f12 = rectF.right * f10;
        float f20 = rectF.bottom;
        size = new RectF(f18, f11, f12, f20);
        return size;
    }

    private static NvsTimelineData c() {
        return d.v.v.j.h.t().n();
    }

    private static void d() {
        h.k().E();
    }

    public static boolean e(boolean bl2) {
        boolean bl3 = true;
        if (bl2) {
            NvsTimelineData nvsVideoTrack = d.v.v.u.a.c();
            int n10 = nvsVideoTrack.getGlobalZoomMode();
            d.v.v.u.a.g(n10, bl3);
        } else {
            NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
            if (nvsVideoTrack == null) {
                return false;
            }
            d.v.v.u.a.a();
        }
        return bl3;
    }

    public static boolean f(int n10, int n11, boolean bl2) {
        Object object;
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        boolean bl3 = d.v.v.u.a.h(nvsVideoClip, n11, (Size)(object = d.v.v.j.h.t().v(n10).z()));
        if (bl3) {
            object = d.v.v.j.h.t();
            d d10 = ((d.v.v.j.h)object).v(n10);
            d10.d0(n11);
            if (bl2) {
                d.v.v.u.a.d();
            }
        }
        return bl3;
    }

    public static boolean g(int n10, boolean bl2) {
        int n11;
        Object object = d.v.v.q.h.h0();
        if (object == null) {
            return false;
        }
        List list = d.v.v.u.a.c().getMediaInfoList();
        int n12 = ((NvsTrack)object).getClipCount();
        for (n11 = 0; n11 < n12; n11 += 1) {
            NvsVideoClip nvsVideoClip = ((NvsVideoTrack)object).getClipByIndex(n11);
            if (nvsVideoClip == null) continue;
            Size size = ((d)list.get(n11)).z();
            d.v.v.u.a.h(nvsVideoClip, n10, size);
        }
        object = d.v.v.u.a.c();
        n11 = 1;
        ((NvsTimelineData)object).setGlobalZoomModeEnable(n11 != 0);
        object = d.v.v.u.a.c();
        ((NvsTimelineData)object).setGlobalZoomMode(n10);
        if (bl2) {
            d.v.v.u.a.d();
        }
        return n11 != 0;
    }

    public static boolean h(NvsVideoClip nvsVideoClip, int n10, Size size) {
        int n11;
        if (nvsVideoClip == null) {
            return false;
        }
        NvsTimelineData nvsTimelineData = d.v.v.u.a.c();
        int n12 = nvsTimelineData.getAspectRadio();
        if (n12 == (n11 = 4)) {
            nvsVideoClip.setImageMotionAnimationEnabled(false);
            nvsVideoClip.enableVideoClipROI(false);
            return d.v.v.u.a.i(nvsVideoClip, n10, size);
        }
        return d.v.v.u.a.j(nvsVideoClip, n10, size);
    }

    private static boolean i(NvsVideoClip nvsVideoClip, int n10, Size size) {
        Object object;
        String string2;
        int n11;
        NvsSize nvsSize = d.v.v.q.h.S();
        int n12 = nvsSize.width;
        int n13 = nvsSize.height;
        int n14 = size.getWidth();
        float f10 = n14;
        float f11 = n12;
        float f12 = n13;
        f11 = f11 / f12 * f10;
        n13 = 0;
        f12 = 0.0f;
        nvsSize = null;
        int n15 = 0;
        NvsVideoFx nvsVideoFx = null;
        while (true) {
            n11 = nvsVideoClip.getRawFxCount();
            string2 = "Transform 2D";
            if (n15 >= n11) break;
            object = nvsVideoClip.getRawFxByIndex(n15).getBuiltinVideoFxName();
            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
            if (n11 != 0) {
                nvsVideoClip.removeRawFx(n15);
                break;
            }
            ++n15;
        }
        nvsVideoFx = nvsVideoClip.appendRawBuiltinFx(string2);
        n11 = 0x40000000;
        float f13 = 2.0f;
        float f14 = 0.2f;
        String string3 = "Scale Y";
        String string4 = "Scale X";
        long l10 = 0x3FF3333333333333L;
        double d10 = 1.2;
        switch (n10) {
            default: {
                return false;
            }
            case 6: {
                nvsVideoFx.setFloatVal(string4, d10);
                nvsVideoFx.setFloatVal(string3, d10);
                f11 = f11 * f14 / f13;
                l10 = 0L;
                d10 = 0.0;
                object = nvsVideoFx;
                nvsVideoFx.setFloatValAtTime("Trans X", 0.0, l10);
                double d11 = f11;
                nvsVideoFx.setFloatValAtTime("Trans Y", d11, l10);
                long l11 = nvsVideoClip.getOutPoint();
                long l12 = nvsVideoClip.getInPoint();
                l10 = l11 - l12;
                nvsVideoFx.setFloatValAtTime("Trans X", 0.0, l10);
                float f15 = -f11;
                d11 = f15;
                l11 = nvsVideoClip.getOutPoint();
                long l13 = nvsVideoClip.getInPoint();
                l10 = l11 - l13;
                string2 = "Trans Y";
                nvsVideoFx.setFloatValAtTime(string2, d11, l10);
                break;
            }
            case 5: {
                nvsVideoFx.setFloatVal(string4, d10);
                nvsVideoFx.setFloatVal(string3, d10);
                f11 = f11 * f14 / f13;
                l10 = 0L;
                d10 = 0.0;
                object = nvsVideoFx;
                nvsVideoFx.setFloatValAtTime("Trans X", 0.0, l10);
                float f16 = -f11;
                double d12 = f16;
                nvsVideoFx.setFloatValAtTime("Trans Y", d12, l10);
                long l14 = nvsVideoClip.getOutPoint();
                long l15 = nvsVideoClip.getInPoint();
                l10 = l14 - l15;
                nvsVideoFx.setFloatValAtTime("Trans X", 0.0, l10);
                d12 = f11;
                l14 = nvsVideoClip.getOutPoint();
                long l16 = nvsVideoClip.getInPoint();
                l10 = l14 - l16;
                string2 = "Trans Y";
                nvsVideoFx.setFloatValAtTime(string2, d12, l10);
                break;
            }
            case 4: {
                nvsVideoFx.setFloatVal(string4, d10);
                nvsVideoFx.setFloatVal(string3, d10);
                f10 = f10 * f14 / f13;
                float f17 = -f10;
                double d13 = f17;
                l10 = 0L;
                d10 = 0.0;
                object = nvsVideoFx;
                nvsVideoFx.setFloatValAtTime("Trans X", d13, l10);
                nvsVideoFx.setFloatValAtTime("Trans Y", 0.0, l10);
                d13 = f10;
                long l17 = nvsVideoClip.getOutPoint();
                long l18 = nvsVideoClip.getInPoint();
                l10 = l17 - l18;
                nvsVideoFx.setFloatValAtTime("Trans X", d13, l10);
                d13 = 0.0;
                l17 = nvsVideoClip.getOutPoint();
                l18 = nvsVideoClip.getInPoint();
                l10 = l17 - l18;
                string2 = "Trans Y";
                nvsVideoFx.setFloatValAtTime(string2, d13, l10);
                break;
            }
            case 3: {
                nvsVideoFx.setFloatVal(string4, d10);
                nvsVideoFx.setFloatVal(string3, d10);
                f10 = f10 * f14 / f13;
                double d14 = f10;
                l10 = 0L;
                d10 = 0.0;
                object = nvsVideoFx;
                nvsVideoFx.setFloatValAtTime("Trans X", d14, l10);
                nvsVideoFx.setFloatValAtTime("Trans Y", 0.0, l10);
                float f18 = -f10;
                d14 = f18;
                long l19 = nvsVideoClip.getOutPoint();
                long l20 = nvsVideoClip.getInPoint();
                l10 = l19 - l20;
                nvsVideoFx.setFloatValAtTime("Trans X", d14, l10);
                d14 = 0.0;
                l19 = nvsVideoClip.getOutPoint();
                l20 = nvsVideoClip.getInPoint();
                l10 = l19 - l20;
                string2 = "Trans Y";
                nvsVideoFx.setFloatValAtTime(string2, d14, l10);
                break;
            }
            case 2: {
                double d15 = 1.2;
                l10 = 0L;
                d10 = 0.0;
                object = nvsVideoFx;
                nvsVideoFx.setFloatValAtTime("Scale X", d15, l10);
                nvsVideoFx.setFloatValAtTime("Scale Y", d15, l10);
                d15 = 1.0;
                long l21 = nvsVideoClip.getOutPoint();
                long l22 = nvsVideoClip.getInPoint();
                l10 = l21 - l22;
                nvsVideoFx.setFloatValAtTime("Scale X", d15, l10);
                l21 = nvsVideoClip.getOutPoint();
                l22 = nvsVideoClip.getInPoint();
                l10 = l21 - l22;
                string2 = "Scale Y";
                nvsVideoFx.setFloatValAtTime(string2, d15, l10);
                break;
            }
            case 1: {
                double d16 = 1.0;
                l10 = 0L;
                d10 = 0.0;
                object = nvsVideoFx;
                nvsVideoFx.setFloatValAtTime("Scale X", d16, l10);
                nvsVideoFx.setFloatValAtTime("Scale Y", d16, l10);
                d16 = 1.2;
                long l23 = nvsVideoClip.getOutPoint();
                long l24 = nvsVideoClip.getInPoint();
                l10 = l23 - l24;
                nvsVideoFx.setFloatValAtTime("Scale X", d16, l10);
                l23 = nvsVideoClip.getOutPoint();
                l24 = nvsVideoClip.getInPoint();
                l10 = l23 - l24;
                string2 = "Scale Y";
                nvsVideoFx.setFloatValAtTime(string2, d16, l10);
            }
            case 0: 
        }
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private static boolean j(NvsVideoClip var0, int var1_1, Size var2_2) {
        block9: {
            var3_3 = false;
            var4_4 = null;
            var5_5 = true;
            switch (var1_1) {
                default: {
                    return false;
                }
                case 6: {
                    var6_6 = d.v.v.u.a.b(d.v.v.u.a.f, var2_2);
                    var4_4 = d.v.v.u.a.e;
                    var2_2 = d.v.v.u.a.b(var4_4, var2_2);
                    var0.setImageMotionROI(var6_6, (RectF)var2_2);
                    ** GOTO lbl42
                }
                case 5: {
                    var6_7 = d.v.v.u.a.b(d.v.v.u.a.e, var2_2);
                    var4_4 = d.v.v.u.a.f;
                    var2_2 = d.v.v.u.a.b(var4_4, var2_2);
                    var0.setImageMotionROI(var6_7, (RectF)var2_2);
                    ** GOTO lbl42
                }
                case 4: {
                    var6_8 = d.v.v.u.a.b(d.v.v.u.a.d, var2_2);
                    var4_4 = d.v.v.u.a.c;
                    var2_2 = d.v.v.u.a.b(var4_4, var2_2);
                    var0.setImageMotionROI(var6_8, (RectF)var2_2);
                    ** GOTO lbl42
                }
                case 3: {
                    var6_9 = d.v.v.u.a.b(d.v.v.u.a.c, var2_2);
                    var4_4 = d.v.v.u.a.d;
                    var2_2 = d.v.v.u.a.b(var4_4, var2_2);
                    var0.setImageMotionROI(var6_9, (RectF)var2_2);
                    ** GOTO lbl42
                }
                case 2: {
                    var6_10 = d.v.v.u.a.b(d.v.v.u.a.b, var2_2);
                    var4_4 = d.v.v.u.a.a;
                    var2_2 = d.v.v.u.a.b(var4_4, var2_2);
                    var0.setImageMotionROI(var6_10, (RectF)var2_2);
                    ** GOTO lbl42
                }
                case 1: {
                    var6_11 = d.v.v.u.a.b(d.v.v.u.a.a, var2_2);
                    var4_4 = d.v.v.u.a.b;
                    var2_2 = d.v.v.u.a.b(var4_4, var2_2);
                    var0.setImageMotionROI(var6_11, (RectF)var2_2);
lbl42:
                    // 6 sources

                    var3_3 = var5_5;
                    break block9;
                }
                case 0: 
            }
            var6_12 = d.v.v.u.a.a;
            var7_13 = d.v.v.u.a.b(var6_12, var2_2);
            var6_12 = d.v.v.u.a.b(var6_12, var2_2);
            var0.setImageMotionROI(var7_13, var6_12);
        }
        var0.setImageMotionMode(2);
        var0.setImageMotionAnimationEnabled(var3_3);
        var0.enableVideoClipROI(var3_3);
        h.k().C();
        h.k().B();
        return var5_5;
    }
}

