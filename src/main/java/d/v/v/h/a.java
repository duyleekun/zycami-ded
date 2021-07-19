/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.SparseArray
 */
package d.v.v.h;

import android.text.TextUtils;
import android.util.SparseArray;
import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoFx;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.nvseditor.data.NvsAssetInfo;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.e.d;
import d.v.h.f.b;
import d.v.v.g.h;
import d.v.v.h.a$a;
import d.v.v.h.a$b;
import d.v.v.q.f;
import d.v.v.q.i;

public class a
implements b {
    private a() {
    }

    public /* synthetic */ a(a$a a$a) {
        this();
    }

    private NvsVideoFx A(NvsVideoClip nvsVideoClip, String string2) {
        NvsVideoFx nvsVideoFx = null;
        if (nvsVideoClip == null) {
            return null;
        }
        int n10 = nvsVideoClip.getFxCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3;
            int n11;
            NvsVideoFx nvsVideoFx2 = nvsVideoClip.getFxByIndex(i10);
            if (nvsVideoFx2 == null || (n11 = (string3 = nvsVideoFx2.getVideoFxPackageId()).compareTo(string2)) != 0) continue;
            nvsVideoFx = nvsVideoFx2;
            break;
        }
        return nvsVideoFx;
    }

    private NvsVideoFx B(NvsVideoClip nvsVideoClip) {
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
            if (nvsVideoFx2 == null || (n11 = (string3 = nvsVideoFx2.getBuiltinVideoFxName()).compareTo(string2 = "Sharpen")) != 0) continue;
            nvsVideoFx = nvsVideoFx2;
            break;
        }
        return nvsVideoFx;
    }

    private NvsTimelineData C() {
        return d.v.v.j.h.t().n();
    }

    private NvsVideoFx D(NvsVideoClip nvsVideoClip) {
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
            if (nvsVideoFx2 == null || (n11 = (string3 = nvsVideoFx2.getBuiltinVideoFxName()).compareTo(string2 = "Vignette")) != 0) continue;
            nvsVideoFx = nvsVideoFx2;
            break;
        }
        return nvsVideoFx;
    }

    private boolean E(NvsVideoFx object) {
        boolean bl2;
        String string2;
        boolean bl3 = ((String)(object = ((NvsVideoFx)object).getBuiltinVideoFxName())).equals(string2 = "Color Property");
        if (!(bl3 || (bl3 = ((String)object).equals(string2 = "Vignette")) || (bl3 = ((String)object).equals(string2 = "Sharpen")) || (bl2 = ((String)object).equals(string2 = "Transform 2D")))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private boolean I(NvsVideoFx nvsVideoFx) {
        return nvsVideoFx.getBuiltinVideoFxName().equals("Lut");
    }

    private boolean J(NvsVideoFx object, d.v.h.f.a object2) {
        int n10 = ((NvsVideoFx)object).getVideoFxType();
        if (n10 != 0) {
            return false;
        }
        object = ((NvsVideoFx)object).getBuiltinVideoFxName();
        object2 = ((d.v.h.f.a)object2).i();
        return ((String)object).equals(object2);
    }

    private boolean L(NvsVideoFx object, d.v.h.f.a object2) {
        String string2;
        int n10 = ((NvsVideoFx)object).getVideoFxType();
        if (n10 != 0) {
            return false;
        }
        String string3 = ((NvsVideoFx)object).getBuiltinVideoFxName();
        n10 = (int)(string3.equals(string2 = "Lut") ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        object = ((NvsFx)object).getStringVal("Data File Path");
        object2 = ((d.v.h.f.a)object2).j();
        return ((String)object).equals(object2);
    }

    private boolean M(NvsVideoFx nvsVideoFx, d.v.h.f.a object) {
        int n10;
        int n11 = nvsVideoFx.getVideoFxType();
        if (n11 != (n10 = 1)) {
            return false;
        }
        object = ((d.v.h.f.a)object).j();
        String string2 = "/";
        n11 = ((String)object).lastIndexOf(string2) + n10;
        if ((n11 = (int)(TextUtils.isEmpty((CharSequence)(object = ((String)object).substring(n11))) ? 1 : 0)) != 0) {
            return false;
        }
        object = ((String)object).split("\\.")[0];
        return nvsVideoFx.getVideoFxPackageId().equals(object);
    }

    private boolean N(NvsVideoFx nvsVideoFx, d.v.h.f.a a10) {
        int n10;
        int n11;
        if (a10 != null && (n11 = a10.f()) != (n10 = -1)) {
            n11 = a10.l();
            if (n11 != 0) {
                n10 = 1;
                if (n11 != n10) {
                    n10 = 2;
                    if (n11 != n10) {
                        return false;
                    }
                    return this.L(nvsVideoFx, a10);
                }
                return this.M(nvsVideoFx, a10);
            }
            return this.J(nvsVideoFx, a10);
        }
        return false;
    }

    private boolean P(NvsVideoClip nvsVideoClip) {
        int n10;
        int n11 = 0;
        if (nvsVideoClip == null) {
            return false;
        }
        int n12 = nvsVideoClip.getFxCount();
        while (true) {
            boolean bl2;
            n10 = 1;
            if (n11 >= n12) break;
            NvsVideoFx nvsVideoFx = nvsVideoClip.getFxByIndex(n11);
            if (nvsVideoFx != null && !(bl2 = this.E(nvsVideoFx))) {
                nvsVideoClip.removeFx(n11);
                n11 += -1;
            }
            n11 += n10;
        }
        return n10 != 0;
    }

    private boolean Q(NvsVideoClip nvsVideoClip, d.v.h.f.a a10) {
        int n10;
        int n11 = 0;
        if (nvsVideoClip == null) {
            return false;
        }
        int n12 = nvsVideoClip.getFxCount();
        while (true) {
            boolean bl2;
            boolean bl3;
            n10 = 1;
            if (n11 >= n12) break;
            NvsVideoFx nvsVideoFx = nvsVideoClip.getFxByIndex(n11);
            if (nvsVideoFx != null && !(bl3 = this.N(nvsVideoFx, a10)) && !(bl2 = this.E(nvsVideoFx))) {
                nvsVideoClip.removeFx(n11);
                n11 += -1;
            }
            n11 += n10;
        }
        return n10 != 0;
    }

    private void R() {
        h h10 = h.k();
        boolean bl2 = h10.r();
        if (!bl2) {
            long l10 = d.v.v.q.h.n();
            h h11 = h.k();
            h11.H(l10);
        }
    }

    private boolean b(NvsVideoClip nvsVideoClip, d.v.h.f.a a10) {
        boolean bl2;
        String string2;
        if (nvsVideoClip != null && a10 != null && (string2 = a10.i()) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = a10.i())))) {
            return this.h(nvsVideoClip, a10);
        }
        return false;
    }

    private boolean c(NvsVideoClip nvsVideoClip, d.v.h.f.a a10) {
        boolean bl2;
        String string2;
        if (nvsVideoClip != null && a10 != null && (string2 = a10.j()) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = a10.j())))) {
            return this.i(nvsVideoClip, a10);
        }
        return false;
    }

    private boolean d(NvsVideoClip nvsVideoClip, d.v.h.f.a a10) {
        boolean bl2;
        Object object;
        String string2 = null;
        if (nvsVideoClip != null && a10 != null && (object = a10.j()) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = a10.j())))) {
            int n10;
            int n11;
            object = f.d();
            String string3 = a10.j();
            if ((object = ((f)object).m(string3)) != null && (n11 = ((NvsAssetInfo)object).getStatus()) == (n10 = 1)) {
                string2 = ((NvsAssetInfo)object).getUuid();
                a10.w(string2);
                return this.h(nvsVideoClip, a10);
            }
        }
        return false;
    }

    private boolean h(NvsVideoClip nvsVideoClip, d.v.h.f.a a10) {
        NvsVideoFx nvsVideoFx;
        if (a10 == null) {
            return false;
        }
        String string2 = a10.i();
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return false;
        }
        n10 = a10.l();
        float f10 = a10.g();
        if (n10 == 0) {
            nvsVideoFx = this.u(nvsVideoClip, string2);
            if (nvsVideoFx == null) {
                nvsVideoFx = nvsVideoClip.appendBuiltinFx(string2);
            }
        } else {
            nvsVideoFx = this.A(nvsVideoClip, string2);
            if (nvsVideoFx == null) {
                nvsVideoFx = nvsVideoClip.appendPackagedFx(string2);
            }
        }
        if (nvsVideoFx != null) {
            nvsVideoFx.setFilterIntensity(f10);
            return true;
        }
        return false;
    }

    private boolean i(NvsVideoClip object, d.v.h.f.a a10) {
        if (object == null) {
            return false;
        }
        NvsVideoFx nvsVideoFx = this.y((NvsVideoClip)object);
        if (nvsVideoFx == null) {
            nvsVideoFx = ((NvsVideoClip)object).appendBuiltinFx("Lut");
        }
        if (nvsVideoFx == null) {
            return false;
        }
        object = a10.j();
        nvsVideoFx.setStringVal("Data File Path", (String)object);
        double d10 = a10.g();
        nvsVideoFx.setFloatVal("Intensity", d10);
        return true;
    }

    private boolean l(int n10, float f10) {
        int n11;
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return false;
        }
        NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(n10);
        if (nvsVideoClip == null) {
            return false;
        }
        int n12 = nvsVideoClip.getFxCount();
        int n13 = 0;
        while (true) {
            n11 = 1;
            if (n13 >= n12) break;
            NvsVideoFx nvsVideoFx = nvsVideoClip.getFxByIndex(n13);
            boolean bl2 = this.E(nvsVideoFx);
            if (!bl2) {
                Object object;
                Object object2 = new Object[n11];
                object2[0] = object = Float.valueOf(f10);
                object = "intensity = %s";
                m.a.a.b((String)object, object2);
                n11 = (int)(this.I(nvsVideoFx) ? 1 : 0);
                if (n11 != 0) {
                    double d10 = f10;
                    object2 = "Intensity";
                    nvsVideoFx.setFloatVal((String)object2, d10);
                } else {
                    nvsVideoFx.setFilterIntensity(f10);
                }
            }
            ++n13;
        }
        return n11 != 0;
    }

    private boolean m(NvsVideoClip nvsVideoClip, String string2, float f10) {
        if (nvsVideoClip == null) {
            return false;
        }
        NvsVideoFx nvsVideoFx = this.v(nvsVideoClip);
        if (nvsVideoFx == null) {
            nvsVideoFx = nvsVideoClip.appendBuiltinFx("Color Property");
        }
        if (nvsVideoFx == null) {
            return false;
        }
        double d10 = f10;
        nvsVideoFx.setFloatVal(string2, d10);
        return true;
    }

    private boolean n(float f10) {
        Object object = d.v.v.q.h.h0();
        if (object == null) {
            return false;
        }
        int n10 = ((NvsTrack)object).getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            this.l(i10, f10);
        }
        object = this.C().getGlobalFrameEffectInfo();
        int n11 = (int)(f10 * 100.0f);
        ((d.v.h.f.a)object).y(n11);
        this.R();
        return true;
    }

    private boolean o(NvsVideoClip nvsVideoClip, String string2, float f10) {
        if (nvsVideoClip == null) {
            return false;
        }
        NvsVideoFx nvsVideoFx = this.B(nvsVideoClip);
        if (nvsVideoFx == null) {
            nvsVideoFx = nvsVideoClip.appendBuiltinFx("Sharpen");
        }
        if (nvsVideoFx == null) {
            return false;
        }
        double d10 = f10;
        nvsVideoFx.setFloatVal(string2, d10);
        return true;
    }

    private boolean p(NvsVideoClip nvsVideoClip, String string2, float f10) {
        if (nvsVideoClip == null) {
            return false;
        }
        NvsVideoFx nvsVideoFx = this.D(nvsVideoClip);
        if (nvsVideoFx == null) {
            nvsVideoFx = nvsVideoClip.appendBuiltinFx("Vignette");
        }
        if (nvsVideoFx == null) {
            return false;
        }
        double d10 = f10;
        nvsVideoFx.setFloatVal(string2, d10);
        return true;
    }

    private void t() {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return;
        }
        int n10 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            d.v.h.f.a a10;
            Object object;
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
            if (nvsVideoClip == null || (object = d.v.v.j.h.t().v(i10)) == null || (a10 = ((d)object).w()) == null) continue;
            object = ((d)object).w();
            i.f(nvsVideoClip, (d.v.h.f.a)object);
        }
        this.R();
        this.C().setGlobalFrameEffectEnable(false);
    }

    private NvsVideoFx u(NvsVideoClip nvsVideoClip, String string2) {
        NvsVideoFx nvsVideoFx = null;
        if (nvsVideoClip == null) {
            return null;
        }
        int n10 = nvsVideoClip.getFxCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3;
            int n11;
            NvsVideoFx nvsVideoFx2 = nvsVideoClip.getFxByIndex(i10);
            if (nvsVideoFx2 == null || (n11 = (string3 = nvsVideoFx2.getBuiltinVideoFxName()).compareTo(string2)) != 0) continue;
            nvsVideoFx = nvsVideoFx2;
            break;
        }
        return nvsVideoFx;
    }

    private NvsVideoFx v(NvsVideoClip nvsVideoClip) {
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
            if (nvsVideoFx2 == null || (n11 = (string3 = nvsVideoFx2.getBuiltinVideoFxName()).compareTo(string2 = "Color Property")) != 0) continue;
            nvsVideoFx = nvsVideoFx2;
            break;
        }
        return nvsVideoFx;
    }

    public static a x() {
        return a$b.a();
    }

    private NvsVideoFx y(NvsVideoClip nvsVideoClip) {
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
            if (nvsVideoFx2 == null || (n11 = (string3 = nvsVideoFx2.getBuiltinVideoFxName()).compareTo(string2 = "Lut")) != 0) continue;
            nvsVideoFx = nvsVideoFx2;
            break;
        }
        return nvsVideoFx;
    }

    public boolean F(int n10, int n11) {
        float f10 = n11;
        float f11 = 100.0f;
        boolean bl2 = this.l(n10, f10 /= f11);
        if (bl2) {
            d.v.v.j.h h10 = d.v.v.j.h.t();
            Object object = h10.v(n10);
            if (object != null) {
                object = ((d)object).w();
                ((d.v.h.f.a)object).y(n11);
            }
            this.R();
        }
        return bl2;
    }

    public boolean G(boolean bl2) {
        Object object = d.v.v.q.h.h0();
        if (object == null) {
            return false;
        }
        boolean bl3 = true;
        if (bl2) {
            d.v.h.f.a a10 = this.C().getGlobalFrameEffectInfo();
            if (a10 == null) {
                return false;
            }
            bl2 = i.e((NvsVideoTrack)object, a10);
            if (bl2) {
                object = this.C();
                ((NvsTimelineData)object).setGlobalFrameEffectEnable(bl3);
                this.R();
            }
            return bl2;
        }
        this.t();
        return bl3;
    }

    public boolean H(int n10) {
        float f10 = (float)n10 / 100.0f;
        return this.n(f10);
    }

    public boolean K(int n10, boolean bl2) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (nvsVideoClip == null) {
            return false;
        }
        boolean bl3 = this.P(nvsVideoClip);
        if (bl3) {
            Object object = d.v.v.j.h.t();
            Object object2 = ((d.v.v.j.h)object).v(n10);
            if (object2 != null) {
                object = ((d)object2).w();
                if (object == null) {
                    object = new d.v.h.f.a();
                }
                d.v.h.f.a a10 = new d.v.h.f.a();
                ((d.v.h.f.a)object).v(a10);
                ((d)object2).Z((d.v.h.f.a)object);
            }
            if (bl2) {
                object2 = h.k();
                ((h)object2).E();
            }
        }
        return bl3;
    }

    public boolean O(d.v.h.f.a object, boolean bl2) {
        boolean bl3;
        boolean bl4;
        if (object != null && (bl4 = ((d.v.h.f.a)object).f()) != (bl3 = -1 != 0)) {
            NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
            bl4 = this.f(nvsVideoTrack, (d.v.h.f.a)object);
            if (bl4) {
                NvsTimelineData nvsTimelineData = this.C();
                nvsTimelineData.setGlobalFrameEffectInfo((d.v.h.f.a)object);
                object = this.C();
                bl3 = true;
                ((NvsTimelineData)object).setGlobalFilterEnable(bl3);
                if (bl2) {
                    object = h.k();
                    ((h)object).E();
                }
            }
            return bl4;
        }
        return false;
    }

    public boolean a(NvsVideoClip nvsVideoClip, d.v.h.f.a a10) {
        int n10;
        int n11;
        if (nvsVideoClip != null && a10 != null && (n11 = a10.f()) != (n10 = -1)) {
            this.Q(nvsVideoClip, a10);
            n11 = a10.l();
            if (n11 != 0) {
                n10 = 1;
                if (n11 != n10) {
                    n10 = 2;
                    if (n11 != n10) {
                        return false;
                    }
                    return this.c(nvsVideoClip, a10);
                }
                return this.d(nvsVideoClip, a10);
            }
            return this.b(nvsVideoClip, a10);
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    public boolean e(NvsVideoClip var1_1, int var2_2, float var3_3) {
        block9: {
            block10: {
                block8: {
                    if (var1_1 == null) {
                        return false;
                    }
                    var4_4 = 6;
                    var5_5 = 5;
                    if (var2_2 != var5_5) break block8;
                    var3_3 = Math.abs(var3_3);
                    break block9;
                }
                if (var2_2 != var4_4) break block10;
                var3_3 = Math.abs(var3_3);
                var6_6 = 0x40A00000;
                var7_7 = 5.0f;
                ** GOTO lbl25
            }
            var7_7 = 0.0f;
            cfr_temp_0 = var3_3 - 0.0f;
            var6_6 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1));
            if (var6_6 <= 0) {
                var6_6 = 1065353216;
                var7_7 = 1.0f;
                var3_3 += var7_7;
            } else {
                var6_6 = 1092616192;
                var7_7 = 10.0f;
lbl25:
                // 2 sources

                var3_3 *= var7_7;
            }
        }
        if (var2_2 != 0) {
            var6_6 = 1;
            var7_7 = 1.4E-45f;
            if (var2_2 != var6_6) {
                var8_8 = 2;
                if (var2_2 != var8_8) {
                    if (var2_2 != var5_5) {
                        if (var2_2 != var4_4) {
                            return var6_6;
                        }
                        return this.o(var1_1, "Amount", var3_3);
                    }
                    return this.p(var1_1, "Degree", var3_3);
                }
                return this.m(var1_1, "Saturation", var3_3);
            }
            return this.m(var1_1, "Contrast", var3_3);
        }
        return this.m(var1_1, "Brightness", var3_3);
    }

    public boolean f(NvsVideoTrack nvsVideoTrack, d.v.h.f.a a10) {
        int n10;
        if (nvsVideoTrack != null && a10 != null && (n10 = a10.f()) >= 0) {
            for (int i10 = 0; i10 < (n10 = nvsVideoTrack.getClipCount()); ++i10) {
                boolean bl2;
                NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
                d d10 = d.v.v.j.h.t().v(i10);
                if (nvsVideoClip == null || d10 == null || (bl2 = d10.P())) continue;
                this.a(nvsVideoClip, a10);
            }
            return true;
        }
        return false;
    }

    public boolean g(NvsVideoTrack nvsVideoTrack, int n10, float f10) {
        if (nvsVideoTrack == null) {
            return false;
        }
        int n11 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
            if (nvsVideoClip == null) continue;
            this.e(nvsVideoClip, n10, f10);
        }
        return true;
    }

    public d.v.h.f.a j() {
        return this.C().getGlobalFrameEffectInfo();
    }

    public boolean k(int n10, d.v.h.f.a a10, boolean bl2) {
        boolean bl3;
        boolean bl4;
        if (a10 != null && (bl4 = a10.f()) != (bl3 = -1 != 0)) {
            NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
            bl4 = this.a(nvsVideoClip, a10);
            if (bl4) {
                d.v.v.j.h h10 = d.v.v.j.h.t();
                Object object = h10.v(n10);
                if (object != null) {
                    h10 = ((d)object).w().m();
                    ((d)object).Z(a10);
                    object = ((d)object).w();
                    ((d.v.h.f.a)object).B((SparseArray)h10);
                }
                if (bl2) {
                    object = h.k();
                    ((h)object).E();
                }
            }
            return bl4;
        }
        return false;
    }

    public boolean q(boolean bl2) {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return false;
        }
        boolean bl3 = true;
        if (bl2) {
            Object object = this.C();
            bl2 = ((NvsTimelineData)object).isGlobalFilterEnable();
            if (bl2) {
                h.k().E();
                return bl3;
            }
            object = this.C().getGlobalFrameEffectInfo();
            return this.O((d.v.h.f.a)object, bl3);
        }
        this.r();
        return bl3;
    }

    public void r() {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return;
        }
        int n10 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12;
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
            if (nvsVideoClip == null) continue;
            Object object = d.v.v.j.h.t().v(i10);
            if (object == null) {
                this.P(nvsVideoClip);
                continue;
            }
            d.v.h.f.a a10 = ((d)object).w();
            this.Q(nvsVideoClip, a10);
            a10 = ((d)object).w();
            if (a10 == null || (n12 = (a10 = ((d)object).w()).f()) == (n11 = -1)) continue;
            object = ((d)object).w();
            this.a(nvsVideoClip, (d.v.h.f.a)object);
        }
        this.R();
        this.C().setGlobalFilterEnable(false);
    }

    public boolean s(int n10, float f10, boolean bl2) {
        Object object = d.v.v.q.h.h0();
        boolean bl3 = this.g((NvsVideoTrack)object, n10, f10);
        boolean bl4 = true;
        if (bl3) {
            object = this.C().getGlobalFrameEffectInfo();
            ((d.v.h.f.a)object).A(n10, f10);
            Object object2 = this.C();
            ((NvsTimelineData)object2).setGlobalFrameEffectEnable(bl4);
            if (bl2) {
                object2 = h.k();
                ((h)object2).E();
            }
        }
        return bl4;
    }

    public boolean w(int n10, int n11, float f10, boolean bl2) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (nvsVideoClip == null) {
            return false;
        }
        boolean bl3 = this.e(nvsVideoClip, n11, f10);
        if (bl3) {
            d.v.v.j.h h10 = d.v.v.j.h.t();
            Object object = h10.v(n10).w();
            ((d.v.h.f.a)object).A(n11, f10);
            if (bl2) {
                object = h.k();
                ((h)object).E();
            }
        }
        return bl3;
    }

    public boolean z(boolean bl2) {
        Object object;
        Object object2 = d.v.v.q.h.h0();
        if (object2 == null) {
            return false;
        }
        int n10 = ((NvsTrack)object2).getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            NvsVideoClip nvsVideoClip = ((NvsVideoTrack)object2).getClipByIndex(i10);
            if (nvsVideoClip == null) continue;
            this.P(nvsVideoClip);
        }
        if (bl2) {
            object = h.k();
            ((h)object).E();
        }
        if ((object = this.C().getGlobalFrameEffectInfo()) == null) {
            object = new d.v.h.f.a();
        }
        object2 = new d.v.h.f.a();
        ((d.v.h.f.a)object).v((d.v.h.f.a)object2);
        this.C().setGlobalFrameEffectInfo((d.v.h.f.a)object);
        return true;
    }
}

