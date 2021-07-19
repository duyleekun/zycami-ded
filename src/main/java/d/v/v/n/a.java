/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.v.n;

import android.text.TextUtils;
import com.meicam.sdk.NvsClip;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.e.d;
import d.v.v.g.h;
import d.v.v.n.a$a;
import d.v.v.p.b;

public class a {
    private void b(NvsVideoClip object, int n10, double d10) {
        boolean bl2 = true;
        ((NvsClip)object).changeSpeed(d10, bl2);
        object = d.v.v.j.h.t().v(n10);
        if (object != null) {
            object = ((d)object).j0(d10).V("");
            n10 = 0;
            ((d)object).p0(false);
        }
    }

    public static a f() {
        return a$a.a();
    }

    private double h(int n10) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (nvsVideoClip == null) {
            return 0.0;
        }
        long l10 = d.v.v.q.h.n();
        long l11 = nvsVideoClip.getInPoint();
        long l12 = nvsVideoClip.getOutPoint();
        double d10 = l10 - l11;
        double d11 = l12 - l11;
        return d10 / d11;
    }

    private NvsTimelineData i() {
        return d.v.v.j.h.t().n();
    }

    private void j(int n10, double d10, boolean bl2) {
        Object object = d.v.v.q.h.W(n10);
        if (object == null) {
            return;
        }
        long l10 = ((NvsClip)object).getInPoint();
        long l11 = ((NvsClip)object).getOutPoint();
        double d11 = l10;
        double d12 = (double)(l11 -= l10) * d10;
        long l12 = (long)(d11 += d12);
        h h10 = h.k();
        h10.H(l12);
        if (bl2) {
            object = h.k();
            ((h)object).C();
        }
    }

    public boolean a(int n10, String string2, boolean bl2) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        d d10 = d.v.v.j.h.t().v(n10);
        if (nvsVideoClip != null && d10 != null) {
            double d11;
            long l10 = d.v.v.q.h.n();
            String string3 = nvsVideoClip.getClipVariableSpeedCurvesString();
            boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl3) {
                l10 = nvsVideoClip.GetClipPosByTimelinePosCurvesVariableSpeed(l10);
            } else {
                long l11 = d10.J();
                d11 = nvsVideoClip.getSpeed();
                double d12 = l10;
                d11 *= d12;
                d12 = nvsVideoClip.getInPoint();
                l10 = (long)(d11 -= d12) + l11;
            }
            bl3 = true;
            boolean bl4 = nvsVideoClip.changeCurvesVariableSpeed(string2, bl3);
            if (bl4) {
                Object object;
                long l12 = -1;
                d11 = 0.0 / 0.0;
                Object object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                if (object2 != false && bl2) {
                    b b10 = b.j();
                    b10.h(n10);
                    l10 = nvsVideoClip.GetTimelinePosByClipPosCurvesVariableSpeed(l10);
                    h.k().H(l10);
                    object = d.v.v.j.h.t();
                    ((d.v.v.j.h)object).l();
                }
                object = d10.V(string2);
                double d13 = nvsVideoClip.getSpeed();
                object = ((d)object).j0(d13);
                ((d)object).p0(bl3);
            }
            return bl4;
        }
        return false;
    }

    public boolean c() {
        boolean bl2;
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return false;
        }
        h h10 = h.k();
        boolean bl3 = h10.r();
        int n10 = d.v.v.q.h.p();
        double d10 = this.h(n10);
        int n11 = nvsVideoTrack.getClipCount();
        int n12 = 0;
        while (true) {
            bl2 = true;
            if (n12 >= n11) break;
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(n12);
            d d11 = d.v.v.j.h.t().v(n12);
            if (nvsVideoClip != null && d11 != null) {
                double d12;
                double d13 = d11.I();
                double d14 = d13 - (d12 = 0.0);
                Object object = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
                double d15 = object < 0 ? 1.0 : d11.I();
                nvsVideoClip.changeSpeed(d15, bl2);
            }
            ++n12;
        }
        this.j(n10, d10, bl3);
        this.i().setGlobalSpeedEnable(false);
        return bl2;
    }

    public String d(int n10) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (nvsVideoClip == null) {
            return "";
        }
        return nvsVideoClip.getClipVariableSpeedCurvesString();
    }

    public double e() {
        return this.i().getGlobalSpeed();
    }

    public double g(int n10) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (nvsVideoClip == null) {
            return -1.0;
        }
        long l10 = nvsVideoClip.getTrimIn();
        return (double)(nvsVideoClip.getTrimOut() - l10) / 1000000.0 / 0.5;
    }

    public boolean k(double d10) {
        boolean bl2;
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        int n10 = 0;
        if (nvsVideoTrack == null) {
            return false;
        }
        h h10 = h.k();
        boolean bl3 = h10.r();
        int n11 = d.v.v.q.h.p();
        double d11 = this.h(n11);
        int n12 = nvsVideoTrack.getClipCount();
        while (true) {
            bl2 = true;
            if (n10 >= n12) break;
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(n10);
            if (nvsVideoClip != null) {
                nvsVideoClip.changeSpeed(d10, bl2);
                b b10 = b.j();
                b10.h(n10);
            }
            ++n10;
        }
        this.j(n11, d11, bl3);
        this.i().setGlobalSpeedEnable(bl2);
        this.i().setGlobalSpeed(d10);
        return bl2;
    }

    public boolean l(int n10, double d10) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (nvsVideoClip == null) {
            return false;
        }
        boolean bl2 = h.k().r();
        int n11 = d.v.v.q.h.p();
        double d11 = this.h(n11);
        this.b(nvsVideoClip, n10, d10);
        b.j().h(n10);
        this.j(n11, d11, bl2);
        d.v.v.j.h.t().l();
        return true;
    }

    public boolean m(boolean bl2) {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return false;
        }
        if (bl2) {
            NvsTimelineData nvsTimelineData = this.i();
            double d10 = nvsTimelineData.getGlobalSpeed();
            this.k(d10);
        } else {
            this.c();
        }
        return true;
    }
}

