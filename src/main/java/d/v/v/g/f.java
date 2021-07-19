/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Size
 */
package d.v.v.g;

import android.text.TextUtils;
import android.util.Size;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsClip;
import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsTrackVideoFx;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.e.l.s1;
import d.v.h.d.c;
import d.v.h.e.d;
import d.v.h.k.b;
import d.v.v.e.a;
import d.v.v.f.j;
import d.v.v.g.f$a;
import d.v.v.g.f$b;
import d.v.v.g.h;
import d.v.v.j.i;
import d.v.v.q.g;
import java.util.List;

public class f {
    private g a;

    public f() {
        g g10;
        this.a = g10 = g.k();
    }

    public static /* synthetic */ boolean a(f f10, int n10) {
        return f10.n(n10);
    }

    private void e(int n10) {
        Object object = d.v.v.j.h.t().v(n10);
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (object != null && nvsVideoClip != null) {
            float f10;
            int n11;
            Object object2;
            NvsTimelineData nvsTimelineData = this.m();
            boolean bl2 = nvsTimelineData.isGlobalFrameEffectEnable();
            if (bl2) {
                object2 = nvsTimelineData.getGlobalFrameEffectInfo();
                d.v.v.q.i.f(nvsVideoClip, (d.v.h.f.a)object2);
            }
            if (bl2 = nvsTimelineData.isGlobalFilterEnable()) {
                object2 = d.v.v.h.a.x();
                d.v.h.f.a a10 = nvsTimelineData.getGlobalFrameEffectInfo();
                ((d.v.v.h.a)object2).a(nvsVideoClip, a10);
            }
            if (bl2 = nvsTimelineData.isGlobalRotationModeEnable()) {
                object2 = d.v.v.m.a.h();
                n11 = nvsTimelineData.getGlobalRotationMode();
                ((d.v.v.m.a)object2).r(nvsVideoClip, n11);
            }
            if (bl2 = nvsTimelineData.isGlobalVideoVolumeEnable()) {
                f10 = nvsTimelineData.getGlobalVideoVolume();
                n11 = 1065353216;
                float f11 = 1.0f;
                float f12 = nvsTimelineData.getGlobalVideoVolume() * f11;
                nvsVideoClip.setVolumeGain(f10 *= f11, f12);
            }
            if (bl2 = nvsTimelineData.isGlobalSpeedEnable()) {
                double d10 = nvsTimelineData.getGlobalSpeed();
                nvsVideoClip.changeSpeed(d10);
                d10 = nvsTimelineData.getGlobalSpeed();
                double d11 = 1.0;
                bl2 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
                if (bl2) {
                    bl2 = false;
                    f10 = 0.0f;
                    object2 = null;
                    nvsVideoClip.setVolumeGain(0.0f, 0.0f);
                }
            }
            if (bl2 = nvsTimelineData.isGlobalZoomModeEnable()) {
                int n12 = nvsTimelineData.getGlobalZoomMode();
                object = ((d)object).z();
                d.v.v.u.a.h(nvsVideoClip, n12, (Size)object);
            }
            if ((object = d.v.v.q.h.h0().getFirstTrackVideoFx()) != null) {
                long l10 = ((NvsTrackVideoFx)object).getOutPoint();
                long l11 = nvsVideoClip.getOutPoint();
                l10 += l11;
                l11 = nvsVideoClip.getInPoint();
                ((NvsTrackVideoFx)object).changeOutPoint(l10 -= l11);
            }
        }
    }

    private void f(int n10) {
        Object object = d.v.v.j.h.t().v(n10);
        Object object2 = d.v.v.q.h.W(n10);
        if (object != null && object2 != null) {
            float f10;
            Object object3 = ((d)object).w();
            if (object3 != null) {
                d.v.v.q.i.f((NvsVideoClip)object2, (d.v.h.f.a)object3);
                int bl3 = ((d.v.h.f.a)object3).f();
                int n11 = -1;
                f10 = 0.0f / 0.0f;
                if (bl3 != n11) {
                    d.v.v.q.i.g((NvsVideoClip)object2, (d.v.h.f.a)object3);
                }
            }
            float f11 = ((d)object).O();
            float f12 = 1.0f;
            f10 = ((d)object).O() * f12;
            ((NvsClip)object2).setVolumeGain(f11 *= f12, f10);
            boolean bl2 = ((d)object).R();
            boolean bl3 = true;
            f12 = Float.MIN_VALUE;
            boolean bl4 = false;
            f10 = 0.0f;
            if (bl2) {
                object3 = ((d)object).t();
                if (object3 != null) {
                    d.v.v.n.a a10 = d.v.v.n.a.f();
                    a10.a(n10, (String)object3, bl3);
                    ((NvsClip)object2).setVolumeGain(0.0f, 0.0f);
                }
            } else {
                double d10;
                double d11;
                double d12;
                double d13 = ((d)object).I();
                double d14 = d13 - (d12 = 0.0);
                Object object4 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
                if (object4 > 0 && (d11 = (d10 = d13 - (d12 = 1.0)) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1)) != false) {
                    ((NvsClip)object2).changeSpeed(d13, bl3);
                    ((NvsClip)object2).setVolumeGain(0.0f, 0.0f);
                }
            }
            int n12 = ((d)object).A();
            Size size = ((d)object).z();
            d.v.v.u.a.h((NvsVideoClip)object2, n12, size);
            int n13 = ((d)object).y();
            if (n13 != 0) {
                object3 = d.v.v.m.a.h();
                int n14 = ((d)object).y();
                ((d.v.v.m.a)object3).r((NvsVideoClip)object2, n14);
            } else {
                object2 = d.v.v.m.a.h();
                int n15 = ((d)object).F();
                boolean bl5 = false;
                size = null;
                ((d.v.v.m.a)object2).t(n10, n15, false);
                int n16 = ((d)object).B();
                ((d.v.v.m.a)object2).l(n10, n16, false);
                f11 = ((d)object).G();
                f12 = ((d)object).H();
                ((d.v.v.m.a)object2).u(n10, f11, f12);
                f11 = ((d)object).L();
                float f13 = ((d)object).M();
                ((d.v.v.m.a)object2).v(n10, f11, f13);
            }
            object = d.v.v.p.b.j();
            ((d.v.v.p.b)object).h(n10);
        }
    }

    private void i() {
        Object object;
        Object object2 = d.v.v.j.h.t().u();
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (object2 != null && (object = ((NvsTimelineData)object2).getMediaInfoList()) != null && nvsVideoTrack != null) {
            boolean bl2;
            object2 = ((NvsTimelineData)object2).getMediaInfoList();
            object = object2.iterator();
            while (bl2 = object.hasNext()) {
                d d10 = (d)object.next();
                boolean bl3 = d10.P();
                if (!bl3 || (bl2 = object2.indexOf(d10)) == (bl3 = -1 != 0)) continue;
                bl3 = true;
                nvsVideoTrack.removeClip((int)(bl2 ? 1 : 0), bl3);
                object.remove();
            }
            d.v.v.j.h.t().l();
            object2 = h.k();
            ((h)object2).E();
        }
    }

    public static f k() {
        return f$b.a();
    }

    private NvsTimeline l() {
        return i.e().f();
    }

    private NvsTimelineData m() {
        return d.v.v.j.h.t().n();
    }

    private boolean n(int n10) {
        d d10 = d.v.v.j.h.t().v(n10);
        Object object = d.v.v.q.h.W(n10);
        if (d10 != null && object != null) {
            int n11 = (int)(d10.j() ? 1 : 0);
            String string2 = n11 != 0 ? d10.e() : d10.g();
            ((NvsClip)object).changeFilePath(string2);
            long l10 = ((NvsClip)object).getTrimIn();
            long l11 = ((NvsClip)object).getTrimOut();
            long l12 = d10.d();
            long l13 = 0L;
            long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
            if (l14 != false || (l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) != false) {
                object = d.v.v.e.a.f();
                l11 = l12 - l11;
                ((a)object).e(n10, l11, l12 -= l10);
            }
            l14 = n11 ^ 1;
            d10.n((boolean)l14);
            object = d.v.v.r.a.c();
            boolean bl2 = n11 ^ true;
            ((d.v.v.r.a)object).h(n10, bl2);
            h.k().E();
            return true;
        }
        return false;
    }

    public boolean b(int n10, d d10) {
        return this.c(n10, d10, true);
    }

    public boolean c(int n10, d object, boolean bl2) {
        float f10;
        Object object2;
        boolean bl3 = false;
        MediaType mediaType = null;
        if (object == null) {
            return false;
        }
        NvsObject nvsObject = d.v.v.q.h.h0();
        if (nvsObject == null) {
            return false;
        }
        String string2 = ((d)object).E();
        boolean bl4 = TextUtils.isEmpty((CharSequence)string2);
        if (bl4) {
            return false;
        }
        MediaType mediaType2 = ((d.v.h.e.a)object).f();
        if (mediaType2 == (object2 = MediaType.VIDEO)) {
            nvsObject = ((NvsVideoTrack)nvsObject).insertClip(string2, n10);
        } else {
            object2 = NvsStreamingContext.getInstance().getAVFileInfo(string2);
            long l10 = ((NvsAVFileInfo)object2).getDuration();
            long l11 = ((d.v.h.e.a)object).d();
            l11 = Math.max(l10, l11);
            l10 = 0L;
            nvsObject = ((NvsVideoTrack)nvsObject).insertClip(string2, l10, l11, n10);
        }
        if (nvsObject == null) {
            return false;
        }
        d.v.v.j.h.t().a(n10, (d)object);
        mediaType = MediaType.GIF;
        if (mediaType2 == mediaType) {
            int n11 = 2;
            ((NvsVideoClip)nvsObject).setClipWrapMode(n11);
        }
        long l12 = ((d)object).J();
        boolean bl5 = true;
        ((NvsClip)nvsObject).changeTrimInPoint(l12, bl5);
        l12 = ((d)object).u();
        long l13 = 0L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 != false) {
            l12 = ((d)object).u();
            ((NvsClip)nvsObject).changeTrimOutPoint(l12, bl5);
        }
        object = this.m();
        int n12 = ((NvsTimelineData)object).getAspectRadio();
        l14 = 4;
        bl4 = false;
        object2 = null;
        if (n12 == l14) {
            n12 = 0;
            object = null;
            f10 = 0.0f;
        } else {
            n12 = 1065353216;
            f10 = 1.0f;
        }
        ((NvsVideoClip)nvsObject).setPanAndScan(0.0f, f10);
        ((NvsVideoClip)nvsObject).setSoftWareDecoding(bl5);
        this.f(n10);
        if (bl2) {
            this.e(n10);
        }
        return bl5;
    }

    public boolean d(List iterator2, List object) {
        boolean bl2;
        Object object2;
        int n10;
        this.i();
        long l10 = d.v.v.q.h.z();
        iterator2 = iterator2.iterator();
        while (true) {
            boolean bl3 = iterator2.hasNext();
            n10 = 1;
            if (!bl3) break;
            object2 = (d)iterator2.next();
            d.v.v.q.j.k((d)object2);
            ((d)object2).X(n10 != 0);
            List list = this.m().getMediaInfoList();
            n10 = list.size();
            this.c(n10, (d)object2, false);
        }
        iterator2 = object.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (c)iterator2.next();
            long l11 = ((d.v.h.d.a)object).e() + l10;
            object2 = l11;
            ((d.v.h.d.a)object).m((Long)object2);
            j.z().b((c)object);
            object2 = d.v.v.j.h.t();
            ((d.v.v.j.h)object2).d((c)object);
        }
        return n10 != 0;
    }

    public void g() {
        this.a.u();
    }

    public boolean h(int n10) {
        d d10 = d.v.v.j.h.t().v(n10).q();
        b b10 = new b();
        d10.o0(b10);
        return this.b(n10, d10);
    }

    public boolean j(int n10) {
        Object object = d.v.v.q.h.h0();
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        bl2 = ((NvsTrack)object).removeClip(n10, false);
        if (bl2) {
            d.v.v.j.h h10 = d.v.v.j.h.t();
            h10.H(n10);
            int n11 = ((NvsTrack)object).getClipCount();
            if (n10 != 0 && n10 <= n11) {
                object = d.v.v.p.b.j();
                ((d.v.v.p.b)object).f(n10 += -1);
            }
        }
        d.v.v.j.h.t().l();
        h.k().E();
        return bl2;
    }

    public void o(int n10, d.v.h.e.g g10) {
        boolean bl2;
        int n11;
        h.k().B();
        Object object = d.v.v.j.h.t();
        d d10 = ((d.v.v.j.h)object).v(n10);
        if (d10 == null) {
            if (g10 != null) {
                String string2 = "\u5a92\u4f53\u7247\u6bb5\u4e0d\u5b58\u5728";
                g10.a(string2);
            }
            return;
        }
        if (g10 != null) {
            g10.start();
        }
        boolean bl3 = d10.j();
        object = d10.e();
        Object object2 = d10.g();
        if (bl3 && ((n11 = TextUtils.isEmpty((CharSequence)object)) != 0 || (n11 = s1.q((String)object)) == 0)) {
            object = object2;
        } else if (bl3 || (n11 = TextUtils.isEmpty((CharSequence)object2)) == 0 && (bl2 = s1.q((String)object2))) {
            boolean bl4 = this.n(n10);
            if (g10 != null) {
                if (bl4) {
                    object = d10.E();
                    g10.b((String)object);
                } else {
                    object = "unKnow error";
                    g10.a((String)object);
                }
            }
            bl4 = false;
            object = null;
        }
        bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            f$a f$a;
            this.a.l();
            g g11 = this.a;
            object2 = f$a;
            n11 = n10;
            f$a = new f$a(this, bl3, d10, n10, g10);
            g11.z(f$a);
            g g12 = this.a;
            g12.x((String)object);
        }
    }

    public boolean p(int n10, boolean bl2) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        int n11 = 0;
        if (nvsVideoClip == null) {
            return false;
        }
        if (bl2) {
            n11 = 2;
        }
        nvsVideoClip.setClipWrapMode(n11);
        return true;
    }

    public boolean q(boolean bl2) {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return false;
        }
        int n10 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
            int n11 = bl2 ? 2 : 0;
            nvsVideoClip.setClipWrapMode(n11);
        }
        return true;
    }

    public boolean r(int n10, String string2) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        d.v.v.j.h h10 = d.v.v.j.h.t();
        d d10 = h10.v(n10);
        if (nvsVideoClip != null && d10 != null) {
            long l10 = nvsVideoClip.getOutPoint();
            long l11 = nvsVideoClip.getInPoint();
            double d11 = l10 - l11;
            double d12 = nvsVideoClip.getSpeed();
            l10 = (long)(d11 *= d12);
            boolean bl2 = nvsVideoClip.changeFilePath(string2);
            if (bl2) {
                long l12 = 0L;
                boolean bl3 = true;
                nvsVideoClip.changeTrimInPoint(l12, bl3);
                nvsVideoClip.changeTrimOutPoint(l10, bl3);
                d10 = d10.k0(l12).W(l10);
                d10.l(string2);
            }
            return bl2;
        }
        return false;
    }
}

