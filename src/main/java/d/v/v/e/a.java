/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package d.v.v.e;

import android.graphics.RectF;
import com.meicam.sdk.NvsClip;
import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsPanAndScan;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoFx;
import com.meicam.sdk.NvsVideoTrack;
import com.meicam.sdk.NvsVolume;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.e.d;
import d.v.h.k.b;
import d.v.v.e.a$a;
import d.v.v.g.h;
import d.v.v.j.g;
import java.util.List;

public class a {
    private void a(NvsVideoFx nvsVideoFx, NvsVideoClip nvsObject) {
        String string2 = nvsVideoFx.getBuiltinVideoFxName();
        string2.hashCode();
        int n10 = string2.hashCode();
        String string3 = "Color Property";
        String string4 = "Vignette";
        String string5 = "Lut";
        String string6 = "Sharpen";
        String string7 = "Transform 2D";
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 1877040690: {
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n11 = 4;
                break;
            }
            case 1309953370: {
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n11 = 3;
                break;
            }
            case 76779: {
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n11 = 2;
                break;
            }
            case -576085517: {
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n11 = 1;
                break;
            }
            case -1692229722: {
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                break;
            }
            case 4: {
                string2 = "Brightness";
                float f10 = (float)nvsVideoFx.getFloatVal(string2);
                string4 = "Contrast";
                double d10 = nvsVideoFx.getFloatVal(string4);
                float f11 = (float)d10;
                string5 = "Saturation";
                double d11 = nvsVideoFx.getFloatVal(string5);
                float f12 = (float)d11;
                nvsObject = ((NvsVideoClip)nvsObject).appendBuiltinFx(string3);
                if (nvsObject == null) break;
                double d12 = f10;
                ((NvsFx)nvsObject).setFloatVal(string2, d12);
                double d13 = f11;
                ((NvsFx)nvsObject).setFloatVal(string5, d13);
                d13 = f12;
                ((NvsFx)nvsObject).setFloatVal(string5, d13);
                break;
            }
            case 3: {
                string2 = "Degree";
                double d14 = nvsVideoFx.getFloatVal(string2);
                float f13 = (float)d14;
                nvsObject = ((NvsVideoClip)nvsObject).appendBuiltinFx(string4);
                if (nvsObject == null) break;
                d14 = f13;
                ((NvsFx)nvsObject).setFloatVal(string2, d14);
                break;
            }
            case 2: {
                string2 = "Data File Path";
                String string8 = nvsVideoFx.getStringVal(string2);
                string3 = "Intensity";
                double d15 = nvsVideoFx.getFloatVal(string3);
                float f14 = (float)d15;
                nvsObject = ((NvsVideoClip)nvsObject).appendBuiltinFx(string5);
                if (nvsObject == null) break;
                ((NvsFx)nvsObject).setStringVal(string2, string8);
                double d16 = f14;
                ((NvsFx)nvsObject).setFloatVal(string3, d16);
                break;
            }
            case 1: {
                string2 = "Amount";
                double d17 = nvsVideoFx.getFloatVal(string2);
                float f15 = (float)d17;
                nvsObject = ((NvsVideoClip)nvsObject).appendBuiltinFx(string6);
                if (nvsObject == null) break;
                d17 = f15;
                ((NvsFx)nvsObject).setFloatVal(string2, d17);
                break;
            }
            case 0: {
                string2 = "Scale X";
                double d18 = nvsVideoFx.getFloatVal(string2);
                float f16 = (float)d18;
                string3 = "Scale Y";
                double d19 = nvsVideoFx.getFloatVal(string3);
                float f17 = (float)d19;
                nvsObject = ((NvsVideoClip)nvsObject).appendBuiltinFx(string7);
                if (nvsObject == null) break;
                d19 = f16;
                ((NvsFx)nvsObject).setFloatVal(string2, d19);
                double d20 = f17;
                ((NvsFx)nvsObject).setFloatVal(string3, d20);
            }
        }
    }

    public static a f() {
        return a$a.a();
    }

    private NvsTimelineData g() {
        return d.v.v.j.h.t().n();
    }

    private void k(int n10) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (nvsVideoClip == null) {
            return;
        }
        int n11 = nvsVideoClip.getFxCount();
        if (n11 == 0) {
            return;
        }
        int n12 = 1;
        NvsVideoClip nvsVideoClip2 = d.v.v.q.h.W(n10 += n12);
        if (nvsVideoClip2 == null) {
            return;
        }
        float f10 = nvsVideoClip.getVolumeGain().leftVolume;
        Object object = nvsVideoClip.getVolumeGain();
        float f11 = ((NvsVolume)object).rightVolume;
        nvsVideoClip2.setVolumeGain(f10, f11);
        f10 = 0.0f;
        for (int i10 = 0; i10 < n11; ++i10) {
            object = nvsVideoClip.getFxByIndex(i10);
            if (object == null) continue;
            int n13 = ((NvsVideoFx)object).getVideoFxType();
            if (n13 != 0) {
                if (n13 != n12) continue;
                Object object2 = ((NvsVideoFx)object).getVideoFxPackageId();
                f11 = ((NvsFx)object).getFilterIntensity();
                if ((object2 = nvsVideoClip2.appendPackagedFx((String)object2)) == null) continue;
                ((NvsFx)object2).setFilterIntensity(f11);
                continue;
            }
            this.a((NvsVideoFx)object, nvsVideoClip2);
        }
    }

    public boolean b(int n10, long l10) {
        long l11;
        long l12 = d.v.v.q.h.g0(n10);
        long l13 = l12 - (l11 = (long)-1);
        if ((n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1))) == 0) {
            return false;
        }
        return this.c(l12 += l10);
    }

    public boolean c(long l10) {
        Object object = d.v.v.q.h.X(l10);
        int n10 = 0;
        float f10 = 0.0f;
        Object object2 = null;
        if (object == null) {
            return false;
        }
        int n11 = this.i(l10);
        if (n11 == 0) {
            return false;
        }
        n11 = ((NvsClip)object).getIndex();
        NvsObject nvsObject = d.v.v.q.h.h0();
        int n12 = d.v.v.q.h.p();
        boolean bl2 = ((NvsTrack)nvsObject).splitClip(n11, l10);
        if (bl2) {
            d.v.v.m.a a10;
            Object object3;
            this.k(n11);
            int n13 = n11 + 1;
            nvsObject = ((NvsVideoTrack)nvsObject).getClipByIndex(n13);
            if (nvsObject != null) {
                object3 = ((NvsVideoClip)object).getPanAndScan();
                float f11 = ((NvsPanAndScan)object3).pan;
                float f12 = ((NvsPanAndScan)object3).scan;
                ((NvsVideoClip)nvsObject).setPanAndScan(f11, f12);
                object3 = ((NvsVideoClip)object).getStartROI();
                a10 = ((NvsVideoClip)object).getEndROI();
                ((NvsVideoClip)nvsObject).setImageMotionROI((RectF)object3, (RectF)a10);
                int bl3 = ((NvsVideoClip)object).getImageMotionMode();
                ((NvsVideoClip)nvsObject).setImageMotionMode(bl3);
                boolean bl4 = ((NvsVideoClip)object).getImageMotionAnimationEnabled();
                ((NvsVideoClip)nvsObject).setImageMotionAnimationEnabled(bl4);
                boolean bl5 = ((NvsVideoClip)object).isVideoClipROIEnabled();
                ((NvsVideoClip)nvsObject).enableVideoClipROI(bl5);
            }
            if ((object3 = d.v.v.j.h.t().v(n11)) != null) {
                int n14 = ((d)object3).y();
                if (n14 != 0) {
                    object2 = d.v.v.m.a.h();
                    n14 = ((d)object3).y();
                    ((d.v.v.m.a)object2).r((NvsVideoClip)nvsObject, n14);
                } else {
                    a10 = d.v.v.m.a.h();
                    int n15 = ((d)object3).F();
                    a10.t(n13, n15, false);
                    n15 = ((d)object3).B();
                    a10.l(n13, n15, false);
                    f10 = ((d)object3).G();
                    float f11 = ((d)object3).H();
                    a10.u(n13, f10, f11);
                    f10 = ((d)object3).L();
                    f11 = ((d)object3).M();
                    a10.v(n13, f10, f11);
                }
                object2 = ((NvsClip)object).getClipVariableSpeedCurvesString();
                object2 = ((d)object3).V((String)object2);
                double d10 = ((NvsClip)object).getSpeed();
                ((d)object2).j0(d10);
                d10 = ((d)object3).I();
                double d11 = 0.0;
                n10 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
                d10 = n10 <= 0 ? 1.0 : ((d)object3).I();
                long l11 = ((NvsClip)object).getInPoint();
                double d12 = (double)(l10 - l11) * d10;
                l10 = (long)d12;
                l11 = ((d)object3).J();
                object = ((d)object3).q();
                ((d)object3).W(l10 += l11);
                object2 = new b();
                ((d)object3).o0((b)object2);
                Object object4 = ((d)object).k0(l10);
                Object object5 = ((NvsClip)nvsObject).getClipVariableSpeedCurvesString();
                object4 = ((d)object4).V((String)object5);
                double d13 = ((NvsClip)nvsObject).getSpeed();
                ((d)object4).j0(d13);
                d.v.v.j.h.t().a(n13, (d)object);
                d.v.v.p.b.j().h(n11);
                object4 = d.v.v.p.b.j();
                ((d.v.v.p.b)object4).h(n13);
                int n16 = d.v.v.q.h.p();
                object5 = g.c();
                ((g)object5).p(n12, n16);
            }
        }
        return bl2;
    }

    public boolean d(int n10, long l10, long l11) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        d d10 = d.v.v.j.h.t().v(n10);
        int n11 = 0;
        Object object = null;
        if (nvsVideoClip != null && d10 != null) {
            double d11 = nvsVideoClip.getSpeed();
            int n12 = 1;
            Object[] objectArray = new Object[n12];
            Double d12 = d11;
            objectArray[0] = d12;
            object = "-----speed = %s";
            m.a.a.b((String)object, objectArray);
            double d13 = 0.0;
            n11 = d11 == d13 ? 0 : (d11 < d13 ? -1 : 1);
            if (n11 <= 0) {
                d11 = 1.0;
            }
            long l12 = (long)((double)l10 * d11);
            long l13 = (long)((double)l11 * d11);
            object = this;
            n12 = n10;
            return this.e(n10, l12, l13);
        }
        return false;
    }

    public boolean e(int n10, long l10, long l11) {
        long l12;
        long l13;
        long l14;
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        d d10 = d.v.v.j.h.t().v(n10);
        if (nvsVideoClip != null && d10 != null && (l14 = (l13 = l10 - (l12 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0 && (l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) <= 0) {
            l14 = d.v.v.q.h.p();
            long l15 = nvsVideoClip.getTrimOut();
            long l16 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1);
            boolean bl2 = true;
            if (l16 < 0) {
                l10 = nvsVideoClip.changeTrimInPoint(l10, bl2);
                l11 = nvsVideoClip.changeTrimOutPoint(l11, bl2);
            } else {
                l11 = nvsVideoClip.changeTrimOutPoint(l11, bl2);
                l10 = nvsVideoClip.changeTrimInPoint(l10, bl2);
            }
            d10.k0(l10);
            d10.W(l11);
            Object[] objectArray = new Object[2];
            Long l17 = nvsVideoClip.getInPoint();
            objectArray[0] = l17;
            l17 = nvsVideoClip.getOutPoint();
            objectArray[bl2] = l17;
            m.a.a.b("-----crop finish inPoint = %s,outPoint = %s", objectArray);
            d.v.v.p.b.j().h(n10);
            d.v.v.j.h.t().l();
            h.k().E();
            n10 = d.v.v.q.h.p();
            g.c().p((int)l14, n10);
            return bl2;
        }
        return false;
    }

    public boolean h(int n10, long l10) {
        long l11;
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        boolean bl2 = false;
        if (nvsVideoClip == null) {
            return false;
        }
        long l12 = d.v.v.q.h.Y(n10);
        long l13 = 500000L;
        long l14 = l10 - l13;
        n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n10 >= 0 && (n10 = (int)((l11 = (l12 -= l10) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1))) >= 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean i(long l10) {
        long l11;
        long l12;
        NvsVideoClip nvsVideoClip = d.v.v.q.h.X(l10);
        boolean bl2 = false;
        if (nvsVideoClip == null) {
            return false;
        }
        long l13 = nvsVideoClip.getInPoint();
        long l14 = 500000L;
        long l15 = (l13 = l10 - l13) - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object >= 0 && (l12 = (l11 = (l13 = nvsVideoClip.getOutPoint() - l10) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean j(int n10, int n11, boolean bl2) {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        int n12 = 0;
        if (nvsVideoTrack == null) {
            return false;
        }
        int n13 = nvsVideoTrack.getClipCount();
        if (n10 < n13 && n11 < n13 && n10 >= 0 && n11 >= 0) {
            n12 = d.v.v.q.h.p();
            boolean bl3 = nvsVideoTrack.moveClip(n10, n11);
            if (bl3) {
                List list = this.g().getMediaInfoList();
                d d10 = (d)list.get(n10);
                d.v.v.j.h.t().H(n10);
                Object object = d.v.v.j.h.t();
                ((d.v.v.j.h)object).a(n11, d10);
                int n14 = d.v.v.q.h.p();
                if (n12 != n14) {
                    object = g.c();
                    ((g)object).p(n12, n14);
                }
                if (bl2) {
                    d.v.v.p.b b10;
                    if (n11 > 0) {
                        b10 = d.v.v.p.b.j();
                        n12 = n11 + -1;
                        b10.h(n12);
                    }
                    if (n11 < (n13 += -1)) {
                        b10 = d.v.v.p.b.j();
                        b10.h(n11);
                    }
                    if (n10 != n13) {
                        if (n11 < n10) {
                            d.v.v.p.b b11 = d.v.v.p.b.j();
                            b11.h(n10);
                        } else if (n10 > 0) {
                            d.v.v.p.b b12 = d.v.v.p.b.j();
                            b12.h(n10 += -1);
                        }
                    } else {
                        d d11 = (d)list.get(n10);
                        b b13 = new b();
                        d11.o0(b13);
                    }
                }
            }
            return bl3;
        }
        return false;
    }
}

