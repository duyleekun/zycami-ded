/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package d.v.v.m;

import android.graphics.PointF;
import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoFx;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.e.d;
import d.v.v.g.h;
import d.v.v.m.a$a;

public class a {
    private void a() {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return;
        }
        int n10 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            d d10;
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
            if (nvsVideoClip == null || (d10 = d.v.v.j.h.t().v(i10)) == null) continue;
            int n11 = d10.y();
            this.r(nvsVideoClip, n11);
        }
        this.i().setGlobalRotationModeEnable(false);
    }

    public static a h() {
        return a$a.a();
    }

    private NvsTimelineData i() {
        return d.v.v.j.h.t().n();
    }

    private NvsVideoFx j(int n10) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (nvsVideoClip == null) {
            return null;
        }
        NvsVideoFx nvsVideoFx = this.k(nvsVideoClip);
        if (nvsVideoFx == null) {
            nvsVideoFx = nvsVideoClip.appendBuiltinFx("Transform 2D");
        }
        return nvsVideoFx;
    }

    private NvsVideoFx k(NvsVideoClip nvsVideoClip) {
        NvsVideoFx nvsVideoFx = null;
        if (nvsVideoClip == null) {
            return null;
        }
        int n10 = nvsVideoClip.getFxCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            String string3;
            int n11;
            NvsVideoFx nvsVideoFx2 = nvsVideoClip.getFxByIndex(i10);
            if (nvsVideoFx2 == null || (n11 = (string3 = nvsVideoFx2.getBuiltinVideoFxName()).compareTo(string2 = "Transform 2D")) != 0) continue;
            nvsVideoFx = nvsVideoFx2;
            break;
        }
        return nvsVideoFx;
    }

    private boolean m(NvsVideoClip nvsVideoClip) {
        if (nvsVideoClip == null) {
            return false;
        }
        int n10 = -1;
        NvsVideoFx nvsVideoFx = this.k(nvsVideoClip);
        if (nvsVideoFx == null) {
            nvsVideoFx = nvsVideoClip.appendBuiltinFx("Transform 2D");
        }
        if (nvsVideoFx == null) {
            return false;
        }
        double d10 = n10;
        nvsVideoFx.setFloatVal("Scale X", d10);
        return true;
    }

    private boolean n(NvsVideoClip nvsVideoClip) {
        if (nvsVideoClip == null) {
            return false;
        }
        NvsVideoFx nvsVideoFx = this.k(nvsVideoClip);
        String string2 = "Transform 2D";
        if (nvsVideoFx == null) {
            nvsVideoFx = nvsVideoClip.appendBuiltinFx(string2);
        }
        if (nvsVideoFx == null) {
            return false;
        }
        String string3 = "Scale X";
        double d10 = 1.0;
        nvsVideoFx.setFloatVal(string3, d10);
        nvsVideoFx = this.k(nvsVideoClip);
        if (nvsVideoFx == null) {
            nvsVideoFx = nvsVideoClip.appendBuiltinFx(string2);
        }
        if (nvsVideoFx == null) {
            return false;
        }
        nvsVideoFx.setFloatVal("Scale Y", d10);
        return true;
    }

    private boolean o(NvsVideoClip nvsVideoClip) {
        if (nvsVideoClip == null) {
            return false;
        }
        int n10 = -1;
        NvsVideoFx nvsVideoFx = this.k(nvsVideoClip);
        if (nvsVideoFx == null) {
            nvsVideoFx = nvsVideoClip.appendBuiltinFx("Transform 2D");
        }
        if (nvsVideoFx == null) {
            return false;
        }
        double d10 = n10;
        nvsVideoFx.setFloatVal("Scale Y", d10);
        return true;
    }

    public boolean b(int n10) {
        double d10;
        a a10 = this;
        int n11 = n10;
        Object[] objectArray = d.v.v.j.h.t().v(n10);
        if (objectArray == null) {
            return false;
        }
        objectArray = null;
        this.v(n10, 0.0f, 0.0f);
        int n12 = this.d(n10);
        float f10 = Math.abs((float)n12);
        int n13 = 0x43340000;
        float f11 = 180.0f;
        float f12 = 90.0f;
        float f13 = (f10 %= f11) - f12;
        float f14 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (f14 > 0) {
            f10 = f11 - f10;
        }
        Object object = d.v.v.q.h.c0();
        f14 = object.getWidth();
        f12 = f14;
        n13 = object.getHeight();
        f11 = n13;
        float f15 = f11 / f12;
        double d11 = Math.atan(f15);
        double d12 = 57.29577951308232;
        d11 *= d12;
        Object object2 = f12 == f11 ? 0 : (f12 > f11 ? 1 : -1);
        if (object2 > 0) {
            d10 = 90.0;
            d11 = d10 - d11;
        }
        d10 = f10;
        d11 = Math.abs(d11 - d10);
        d10 = f12;
        double d13 = 2.0;
        double d14 = Math.pow(d10, d13);
        double d15 = f11;
        double d16 = Math.pow(d15, d13);
        d14 = Math.sqrt(d14 + d16) / d13;
        d11 /= 180.0;
        d16 = Math.PI;
        d11 = Math.cos(d11 * d16) * d14 * d13;
        d11 = object2 > 0 ? (d11 /= d15) : (d11 /= d10);
        objectArray = new Object[1];
        object = d11;
        objectArray[0] = object;
        m.a.a.b("-----scale  = %s", objectArray);
        f10 = (float)d11;
        return a10.u(n11, f10, f10);
    }

    public int c(int n10) {
        NvsVideoFx nvsVideoFx = this.j(n10);
        int n11 = 0;
        if (nvsVideoFx == null) {
            return 0;
        }
        String string2 = "Scale X";
        double d10 = nvsVideoFx.getFloatVal(string2);
        float f10 = (float)d10;
        double d11 = nvsVideoFx.getFloatVal("Scale Y");
        float f11 = (float)d11;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            float f13 = f11 - 0.0f;
            n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            n11 = n10 > 0 ? 2 : 3;
        } else {
            float f14 = f11 - 0.0f;
            n10 = (int)(f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1));
            if (n10 < 0) {
                n11 = 1;
            }
        }
        return n11;
    }

    public int d(int n10) {
        int n11;
        NvsVideoFx nvsVideoFx = this.j(n10);
        if (nvsVideoFx == null) {
            return 0;
        }
        String string2 = "Rotation";
        double d10 = nvsVideoFx.getFloatVal(string2);
        n10 = (int)d10 % 360;
        if (n10 > (n11 = 180)) {
            n10 += -360;
        } else {
            n11 = -180;
            if (n10 < n11) {
                n10 += 360;
            }
        }
        return n10;
    }

    public float e(int n10) {
        NvsVideoFx nvsVideoFx = this.j(n10);
        if (nvsVideoFx == null) {
            return 1.0f;
        }
        return (float)Math.abs(nvsVideoFx.getFloatVal("Scale X"));
    }

    public float f(int n10) {
        NvsVideoFx nvsVideoFx = this.j(n10);
        if (nvsVideoFx == null) {
            return 1.0f;
        }
        return (float)Math.abs(nvsVideoFx.getFloatVal("Scale Y"));
    }

    public PointF g(int n10) {
        NvsVideoFx nvsVideoFx = this.j(n10);
        if (nvsVideoFx == null) {
            nvsVideoFx = new PointF(0.0f, 0.0f);
            return nvsVideoFx;
        }
        double d10 = nvsVideoFx.getFloatVal("Trans X");
        double d11 = nvsVideoFx.getFloatVal("Trans Y");
        float f10 = (float)d10;
        float f11 = (float)d11;
        nvsVideoFx = new PointF(f10, f11);
        return nvsVideoFx;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public boolean l(int n10, int n11, boolean bl2) {
        void var8_13;
        Object object = this.j(n10);
        int n12 = 0;
        if (object == null) {
            return false;
        }
        int n13 = 1;
        float f10 = Float.MIN_VALUE;
        if (n11 != n13) {
            int n14 = 2;
            if (n11 != n14) {
                int n15 = 3;
                if (n11 == n15) {
                    n12 = n13;
                }
                int n16 = n12;
            } else {
                boolean bl3 = false;
                n12 = n13;
            }
        } else {
            int n17 = n13;
        }
        String string2 = "Scale X";
        double d10 = ((NvsFx)object).getFloatVal(string2);
        float f11 = (float)d10;
        String string3 = "Scale Y";
        double d11 = ((NvsFx)object).getFloatVal(string3);
        float f12 = (float)d11;
        if (n12) {
            float f13 = f11 - 0.0f;
            n12 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n12 > 0) {
                f11 = -f11;
            }
        } else {
            f11 = Math.abs(f11);
        }
        if (var8_13 != false) {
            float f14 = f12 - 0.0f;
            n12 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
            if (n12 > 0) {
                f12 = -f12;
            }
        } else {
            f12 = Math.abs(f12);
        }
        double d12 = f11;
        ((NvsFx)object).setFloatVal(string2, d12);
        double d13 = f12;
        ((NvsFx)object).setFloatVal(string3, d13);
        object = d.v.v.j.h.t();
        Object object2 = ((d.v.v.j.h)object).v(n10);
        if (object2 != null) {
            ((d)object2).e0(n11);
        }
        if (bl2) {
            object2 = h.k();
            ((h)object2).E();
        }
        return n13;
    }

    public boolean p(int n10, int n11, boolean bl2) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        boolean bl3 = this.r(nvsVideoClip, n11);
        if (bl3) {
            d.v.v.j.h h10 = d.v.v.j.h.t();
            Object object = h10.v(n10);
            ((d)object).b0(n11);
            if (bl2) {
                object = h.k();
                ((h)object).E();
            }
        }
        return bl3;
    }

    public boolean q(int n10, boolean bl2) {
        int n11;
        Object object = d.v.v.q.h.h0();
        if (object == null) {
            return false;
        }
        int n12 = ((NvsTrack)object).getClipCount();
        for (n11 = 0; n11 < n12; n11 += 1) {
            NvsVideoClip nvsVideoClip = ((NvsVideoTrack)object).getClipByIndex(n11);
            if (nvsVideoClip == null) continue;
            this.r(nvsVideoClip, n10);
        }
        object = this.i();
        n11 = 1;
        ((NvsTimelineData)object).setGlobalRotationModeEnable(n11 != 0);
        object = this.i();
        ((NvsTimelineData)object).setGlobalRotationMode(n10);
        if (bl2) {
            h h10 = h.k();
            h10.E();
        }
        return n11 != 0;
    }

    public boolean r(NvsVideoClip nvsVideoClip, int n10) {
        if (nvsVideoClip == null) {
            return false;
        }
        boolean bl2 = true;
        int n11 = 3;
        switch (n10) {
            default: {
                return false;
            }
            case 7: {
                this.n(nvsVideoClip);
                n10 = 2;
                nvsVideoClip.setExtraVideoRotation(n10);
                break;
            }
            case 6: {
                this.m(nvsVideoClip);
                nvsVideoClip.setExtraVideoRotation(n11);
                break;
            }
            case 5: {
                this.o(nvsVideoClip);
                nvsVideoClip.setExtraVideoRotation(n11);
                break;
            }
            case 4: {
                nvsVideoClip.setExtraVideoRotation(0);
                this.m(nvsVideoClip);
                break;
            }
            case 3: {
                nvsVideoClip.setExtraVideoRotation(0);
                this.o(nvsVideoClip);
                break;
            }
            case 2: {
                this.n(nvsVideoClip);
                nvsVideoClip.setExtraVideoRotation((int)(bl2 ? 1 : 0));
                break;
            }
            case 1: {
                this.n(nvsVideoClip);
                nvsVideoClip.setExtraVideoRotation(n11);
                break;
            }
            case 0: {
                this.n(nvsVideoClip);
                nvsVideoClip.setExtraVideoRotation(0);
            }
        }
        return bl2;
    }

    public boolean s(int n10, int n11, boolean bl2) {
        NvsVideoFx nvsVideoFx = this.j(n10);
        if (nvsVideoFx != null) {
            int n12;
            String string2 = "Rotation";
            double d10 = nvsVideoFx.getFloatVal(string2);
            double d11 = (double)n11 + d10;
            if ((n11 = (int)d11) > (n12 = 180)) {
                n11 = n11 % 180 - n12;
            } else {
                int n13 = -180;
                if (n11 < n13) {
                    n11 = n11 % 180 + n12;
                }
            }
        }
        return this.t(n10, n11, bl2);
    }

    public boolean t(int n10, int n11, boolean bl2) {
        Object object = this.j(n10);
        if (object == null) {
            return false;
        }
        double d10 = n11;
        String string2 = "Rotation";
        ((NvsFx)object).setFloatVal(string2, d10);
        object = d.v.v.j.h.t();
        Object object2 = ((d.v.v.j.h)object).v(n10);
        if (object2 != null) {
            ((d)object2).g0(n11);
        }
        if (bl2) {
            object2 = h.k();
            ((h)object2).E();
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean u(int n10, float f10, float f11) {
        int n11;
        Object object;
        block11: {
            block12: {
                int n12;
                block8: {
                    block9: {
                        float f12;
                        block10: {
                            object = this.j(n10);
                            if (object == null) {
                                return false;
                            }
                            n12 = this.c(n10);
                            if (n12 == (n11 = 1)) break block8;
                            int n13 = 2;
                            if (n12 == n13) break block9;
                            n13 = 3;
                            if (n12 == n13) break block10;
                            f10 = Math.abs(f10);
                            f11 = Math.abs(f11);
                            break block11;
                        }
                        float f13 = f10 - 0.0f;
                        n12 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
                        if (n12 > 0) {
                            f10 = -f10;
                        }
                        if ((n12 = (int)((f12 = f11 - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) <= 0) break block11;
                        break block12;
                    }
                    float f14 = f10 - 0.0f;
                    n12 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
                    if (n12 > 0) {
                        f10 = -f10;
                    }
                    break block11;
                }
                float f15 = f11 - 0.0f;
                n12 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1));
                if (n12 <= 0) break block11;
            }
            f11 = -f11;
        }
        double d10 = f10;
        ((NvsFx)object).setFloatVal("Scale X", d10);
        d10 = f11;
        String string2 = "Scale Y";
        ((NvsFx)object).setFloatVal(string2, d10);
        h.k().E();
        object = d.v.v.j.h.t();
        d d11 = ((d.v.v.j.h)object).v(n10);
        if (d11 != null) {
            d11 = d11.h0(f10);
            d11.i0(f11);
        }
        return n11 != 0;
    }

    public boolean v(int n10, float f10, float f11) {
        Object object = this.j(n10);
        if (object == null) {
            return false;
        }
        double d10 = f10;
        ((NvsFx)object).setFloatVal("Trans X", d10);
        d10 = f11;
        String string2 = "Trans Y";
        ((NvsFx)object).setFloatVal(string2, d10);
        h.k().E();
        object = d.v.v.j.h.t();
        d d11 = ((d.v.v.j.h)object).v(n10);
        if (d11 != null) {
            object = this.i().getResolutionSize();
            int n11 = object.getWidth();
            float f12 = n11;
            float f13 = 2.0f;
            f12 = f12 / f13 + f10;
            float f14 = object.getWidth();
            f12 /= f14;
            int n12 = object.getHeight();
            f14 = (float)n12 / f13 + f11;
            int n13 = object.getHeight();
            float f15 = n13;
            d11 = d11.m0(f10).n0(f11);
            CharSequence charSequence = new StringBuilder();
            charSequence.append(f12);
            String string3 = ",";
            charSequence.append(string3);
            charSequence.append(f14 /= f15);
            charSequence = charSequence.toString();
            d11.U((String)charSequence);
        }
        return true;
    }

    public boolean w(boolean bl2) {
        boolean bl3 = true;
        if (bl2) {
            NvsTimelineData nvsVideoTrack = this.i();
            int n10 = nvsVideoTrack.getGlobalRotationMode();
            this.q(n10, bl3);
        } else {
            NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
            if (nvsVideoTrack == null) {
                return false;
            }
            this.a();
        }
        return bl3;
    }

    public boolean x(int n10, float f10, float f11) {
        NvsVideoFx nvsVideoFx = this.j(n10);
        if (nvsVideoFx == null) {
            return false;
        }
        double d10 = nvsVideoFx.getFloatVal("Trans X");
        double d11 = nvsVideoFx.getFloatVal("Trans Y");
        float f12 = (float)d10 + f10;
        f10 = (float)d11 + f11;
        return this.v(n10, f12, f10);
    }
}

