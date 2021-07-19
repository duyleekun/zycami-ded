/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.l;

import com.meicam.sdk.NvsAudioClip;
import com.meicam.sdk.NvsAudioTrack;
import com.meicam.sdk.NvsClip;
import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsStreamingContext;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import com.zhiyun.nvseditor.record.AudioRecorder;
import com.zhiyun.nvseditor.record.AudioRecorder$b;
import d.v.h.h.a;
import d.v.h.h.a$a;
import d.v.h.h.b;
import d.v.v.g.h;
import d.v.v.l.e$a;
import d.v.v.l.e$b;
import d.v.v.l.e$c;
import java.io.File;
import java.util.List;
import java.util.UUID;

public class e
implements a {
    private a$a a;
    private b b;
    private boolean c;
    private final AudioRecorder$b d;

    public e() {
        Object object = new e$b(this);
        this.d = object;
        object = NvsStreamingContext.getInstance();
        e$a e$a = new e$a(this);
        ((NvsStreamingContext)object).setStreamingEngineCallback(e$a);
    }

    public static /* synthetic */ boolean j(e e10) {
        return e10.c;
    }

    public static /* synthetic */ boolean k(e e10, boolean bl2) {
        e10.c = bl2;
        return bl2;
    }

    public static /* synthetic */ b q(e e10) {
        return e10.b;
    }

    public static /* synthetic */ a$a s(e e10) {
        return e10.a;
    }

    public static e t() {
        return e$c.a();
    }

    private NvsTimelineData v() {
        return d.v.v.j.h.t().n();
    }

    public boolean B(long l10) {
        b b10;
        NvsAudioClip nvsAudioClip = d.v.v.q.h.J(l10);
        if (nvsAudioClip == null) {
            return false;
        }
        int n10 = nvsAudioClip.getIndex();
        NvsAudioTrack nvsAudioTrack = d.v.v.q.h.M();
        boolean bl2 = nvsAudioTrack.splitClip(n10, l10);
        if (bl2 && (b10 = d.v.v.j.h.t().y(n10)) != null) {
            b b11 = b10.c();
            String string2 = UUID.randomUUID().toString();
            b11.b(string2);
            long l11 = nvsAudioClip.getInPoint();
            l11 = l10 - l11;
            long l12 = b10.m() + l11;
            b10.r(l12);
            b11.x(l12);
            Object object = l10;
            b11.p((Long)object);
            object = d.v.v.j.h.t();
            ((d.v.v.j.h)object).e(++n10, b11);
        }
        return bl2;
    }

    public void C(a$a a$a) {
        this.a = a$a;
    }

    public boolean D() {
        return AudioRecorder.j().k();
    }

    public boolean E() {
        NvsAudioTrack nvsAudioTrack = d.v.v.q.h.M();
        boolean bl2 = nvsAudioTrack.removeAllClips();
        if (bl2) {
            List list = this.v().getRecordInfoList();
            list.clear();
        }
        return bl2;
    }

    public boolean J() {
        return this.v().isGlobalRecordMute();
    }

    public boolean L(int n10, long l10) {
        NvsAudioClip nvsAudioClip = d.v.v.q.h.I(n10);
        if (nvsAudioClip == null) {
            return false;
        }
        long l11 = nvsAudioClip.getInPoint() + l10;
        return this.B(l11);
    }

    public boolean N() {
        AudioRecorder.j().e();
        return true;
    }

    public boolean a() {
        AudioRecorder.j().s();
        return true;
    }

    public boolean b(boolean bl2) {
        NvsAudioTrack nvsAudioTrack = d.v.v.q.h.M();
        if (nvsAudioTrack == null) {
            return false;
        }
        if (bl2) {
            float f10 = 0.0f;
            Object var4_5 = null;
            nvsAudioTrack.setVolumeGain(0.0f, 0.0f);
        } else {
            NvsTimelineData nvsTimelineData = this.v();
            float f11 = nvsTimelineData.getGlobalRecordVolume();
            float f12 = 1.0f;
            nvsAudioTrack.setVolumeGain(f11 *= f12, f11);
        }
        this.v().setGlobalRecordMute(bl2);
        return true;
    }

    public void c() {
        NvsAudioTrack nvsAudioTrack = d.v.v.q.h.M();
        if (nvsAudioTrack == null) {
            return;
        }
        int n10 = nvsAudioTrack.getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = nvsAudioTrack.getClipByIndex(i10);
            if (object == null || (object = d.v.v.j.h.t().y(i10)) == null) continue;
            float f10 = ((b)object).n();
            this.h(i10, f10);
        }
        this.v().setGlobalRecordVolumeEnable(false);
    }

    public boolean d(b object) {
        Comparable<File> comparable;
        Object object2 = this.b.d();
        if (object2 == null) {
            object2 = this.b;
            long l10 = d.v.v.q.h.n();
            comparable = l10;
            ((b)object2).p((Long)comparable);
        }
        object2 = AudioRecorder.j();
        String string2 = ((b)object).k();
        comparable = new Comparable<File>(string2);
        boolean bl2 = ((File)comparable).exists();
        if (!bl2) {
            ((File)comparable).mkdirs();
        }
        comparable = new Comparable<File>();
        object = ((b)object).k();
        ((StringBuilder)comparable).append((String)object);
        ((StringBuilder)comparable).append("/");
        long l11 = System.currentTimeMillis();
        ((StringBuilder)comparable).append(l11);
        ((StringBuilder)comparable).append(".pcm");
        object = ((StringBuilder)comparable).toString();
        ((AudioRecorder)object2).g((String)object);
        object = this.d;
        ((AudioRecorder)object2).r((AudioRecorder$b)object);
        return true;
    }

    public boolean e(boolean bl2) {
        NvsAudioTrack nvsAudioTrack = d.v.v.q.h.M();
        if (nvsAudioTrack == null) {
            return false;
        }
        if (bl2) {
            NvsTimelineData nvsTimelineData = this.v();
            float f10 = nvsTimelineData.getGlobalRecordVolume();
            this.setVolume(f10);
        } else {
            this.c();
        }
        return true;
    }

    public boolean f(int n10, boolean bl2) {
        NvsAudioClip nvsAudioClip = d.v.v.q.h.I(n10);
        float f10 = 0.0f;
        if (nvsAudioClip == null) {
            return false;
        }
        d.v.v.j.h h10 = d.v.v.j.h.t();
        b b10 = h10.y(n10);
        if (b10 == null) {
            return false;
        }
        if (bl2) {
            f10 = 0.0f;
            nvsAudioClip.setVolumeGain(0.0f, 0.0f);
        } else {
            f10 = b10.n();
            float f11 = 1.0f;
            nvsAudioClip.setVolumeGain(f10 *= f11, f10);
        }
        b10.w(bl2);
        return true;
    }

    public boolean g(long l10) {
        long l11;
        long l12;
        NvsAudioClip nvsAudioClip = d.v.v.q.h.J(l10);
        boolean bl2 = false;
        if (nvsAudioClip == null) {
            return false;
        }
        long l13 = nvsAudioClip.getInPoint();
        long l14 = 500000L;
        long l15 = (l13 = l10 - l13) - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object >= 0 && (l12 = (l11 = (l13 = nvsAudioClip.getOutPoint() - l10) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean h(int n10, float f10) {
        NvsAudioClip nvsAudioClip = d.v.v.q.h.I(n10);
        if (nvsAudioClip == null) {
            return false;
        }
        float f11 = 0.0f;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            f10 = 0.0f;
        }
        f11 = 1.0f * f10;
        nvsAudioClip.setVolumeGain(f11, f11);
        d.v.v.j.h.t().y(n10).y(f10);
        return true;
    }

    public void i() {
        d.v.v.j.h h10 = d.v.v.j.h.t();
        List list = this.v().getRecordInfoList();
        h10.S(list);
    }

    public boolean l(b object) {
        long l10;
        long l11;
        Long l12;
        long l13;
        NvsObject nvsObject = d.v.v.q.h.M();
        boolean bl2 = false;
        if (nvsObject == null) {
            return false;
        }
        long l14 = ((b)object).f();
        long l15 = ((b)object).m();
        long l16 = (l14 -= l15) - (l15 = 500000L);
        Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object2 < 0) {
            return false;
        }
        Object object3 = ((b)object).k();
        if ((nvsObject = ((NvsAudioTrack)nvsObject).addClip((String)object3, l13 = (l12 = ((b)object).d()).longValue(), l11 = ((b)object).m(), l10 = ((b)object).f())) != null) {
            float f10 = ((b)object).n();
            float f11 = 1.0f;
            float f12 = ((b)object).n() * f11;
            ((NvsClip)nvsObject).setVolumeGain(f10 *= f11, f12);
            object3 = d.v.v.j.h.t();
            ((d.v.v.j.h)object3).f((b)object);
            object = this.a;
            if (object != null) {
                object.e();
            }
        }
        if (nvsObject != null) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean m(int n10, long l10, long l11, long l12, boolean bl2) {
        NvsAudioTrack nvsAudioTrack = d.v.v.q.h.M();
        boolean bl3 = false;
        if (nvsAudioTrack == null) {
            return false;
        }
        Object object = d.v.v.q.h.I(n10);
        if (object == null) {
            return false;
        }
        b b10 = d.v.v.j.h.t().y(n10);
        float f10 = b10.n();
        boolean bl4 = true;
        nvsAudioTrack.removeClip(n10, bl4);
        object = b10.k();
        Object object2 = nvsAudioTrack;
        NvsAudioClip nvsAudioClip = nvsAudioTrack.addClip((String)object, l10, l11, l12);
        float f11 = 1.0f;
        if (nvsAudioClip != null) {
            object2 = l10;
            object2 = b10.p((Long)object2).x(l11);
            ((b)object2).r(l12);
            nvsAudioClip.setVolumeGain(f10 *= f11, f10);
            if (bl2) {
                object2 = h.k();
                long l13 = nvsAudioClip.getInPoint();
                long l14 = nvsAudioClip.getOutPoint();
                ((h)object2).n(l13, l14);
            }
        } else {
            object = b10.k();
            object2 = nvsAudioTrack.addClip((String)object, l10, l11, l12);
            if (object2 != null) {
                ((NvsClip)object2).setVolumeGain(f10 *= f11, f10);
            }
        }
        if (nvsAudioClip != null) {
            bl3 = bl4;
        }
        return bl3;
    }

    public boolean n(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            b b10 = (b)object.next();
            this.l(b10);
        }
        return true;
    }

    public boolean o(int n10, long l10) {
        long l11;
        NvsAudioClip nvsAudioClip = d.v.v.q.h.I(n10);
        boolean bl2 = false;
        if (nvsAudioClip == null) {
            return false;
        }
        long l12 = d.v.v.q.h.K(n10);
        long l13 = d.v.v.q.h.L(n10);
        l12 -= l13;
        l13 = 500000L;
        long l14 = l10 - l13;
        n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n10 >= 0 && (n10 = (int)((l11 = (l12 -= l10) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1))) >= 0) {
            bl2 = true;
        }
        return bl2;
    }

    public List p() {
        return this.v().getRecordInfoList();
    }

    public boolean r(int n10, long l10, long l11, boolean bl2) {
        NvsAudioTrack nvsAudioTrack = d.v.v.q.h.M();
        boolean bl3 = false;
        if (nvsAudioTrack == null) {
            return false;
        }
        NvsObject nvsObject = d.v.v.q.h.I(n10);
        if (nvsObject == null) {
            return false;
        }
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object > 0) {
            return false;
        }
        long l12 = ((NvsClip)nvsObject).getTrimIn();
        long l13 = ((NvsClip)nvsObject).getTrimOut() - l12;
        l12 = l11 - l10;
        object = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
        boolean bl4 = true;
        if (object == false) {
            b b10 = d.v.v.j.h.t().y(n10);
            Object object2 = b10.k();
            nvsObject = nvsAudioTrack;
            long l14 = l10;
            long l15 = l11;
            nvsObject = nvsAudioTrack.insertClip((String)object2, l10, l11, n10);
            if (nvsObject != null) {
                object = n10 + 1;
                nvsAudioTrack.removeClip((int)object, false);
                b10.x(l10);
                b10.r(l11);
                float f10 = b10.n();
                float f11 = 1.0f;
                ((NvsClip)nvsObject).setVolumeGain(f10 *= f11, f10);
                if (bl2) {
                    object2 = h.k();
                    l14 = ((NvsClip)nvsObject).getInPoint();
                    l15 = ((NvsClip)nvsObject).getOutPoint();
                    ((h)object2).n(l14, l15);
                }
            }
            if (nvsObject != null) {
                bl3 = bl4;
            }
            return bl3;
        }
        ((NvsClip)nvsObject).changeTrimInPoint(l10, false);
        ((NvsClip)nvsObject).changeTrimOutPoint(l11, false);
        Object object3 = d.v.v.j.h.t().y(n10);
        ((b)object3).x(l10);
        ((b)object3).r(l11);
        if (bl2) {
            object3 = h.k();
            long l16 = ((NvsClip)nvsObject).getInPoint();
            long l17 = ((NvsClip)nvsObject).getOutPoint();
            ((h)object3).n(l16, l17);
        }
        return bl4;
    }

    public void release() {
        this.a = null;
        AudioRecorder.j().p();
    }

    public boolean setVolume(float f10) {
        NvsAudioTrack nvsAudioTrack = d.v.v.q.h.M();
        if (nvsAudioTrack == null) {
            return false;
        }
        float f11 = 1.0f * f10;
        nvsAudioTrack.setVolumeGain(f11, f11);
        this.v().setGlobalRecordVolume(f10);
        NvsTimelineData nvsTimelineData = this.v();
        boolean bl2 = true;
        nvsTimelineData.setGlobalRecordVolumeEnable(bl2);
        return bl2;
    }

    public float u() {
        return this.v().getGlobalRecordVolume();
    }

    public void w(String string2, Long l10) {
        b b10;
        this.b = b10 = new b();
        b10.p(l10);
        this.b.v(string2);
        this.c = true;
        h.k().C();
    }

    public boolean x(int n10, Long object) {
        Object object2 = d.v.v.q.h.M();
        boolean bl2 = false;
        if (object2 == null) {
            return false;
        }
        Object object3 = d.v.v.q.h.I(n10);
        if (object3 == null) {
            return false;
        }
        b b10 = d.v.v.j.h.t().y(n10).c();
        b10.p((Long)object);
        this.y(n10);
        object3 = b10.k();
        long l10 = b10.d();
        long l11 = b10.m();
        long l12 = b10.f();
        object = ((NvsAudioTrack)object2).addClip((String)object3, l10, l11, l12);
        if (object != null) {
            float f10 = b10.n();
            float f11 = 1.0f;
            ((NvsClip)object).setVolumeGain(f10 *= f11, f10);
            object2 = d.v.v.j.h.t();
            ((d.v.v.j.h)object2).e(n10, b10);
        }
        if (object != null) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean y(int n10) {
        NvsAudioTrack nvsAudioTrack = d.v.v.q.h.M();
        boolean bl2 = false;
        d.v.v.j.h h10 = null;
        if (nvsAudioTrack == null) {
            return false;
        }
        int n11 = nvsAudioTrack.getClipCount();
        if (n10 >= 0 && n10 < n11) {
            bl2 = true;
            boolean bl3 = nvsAudioTrack.removeClip(n10, bl2);
            if (bl3) {
                h10 = d.v.v.j.h.t();
                h10.N(n10);
            }
            return bl3;
        }
        return false;
    }
}

