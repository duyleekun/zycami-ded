/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.g;

import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsStreamingContext$PlaybackCallback;
import com.meicam.sdk.NvsStreamingContext$PlaybackCallback2;
import com.meicam.sdk.NvsStreamingContext$SeekingCallback;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsVideoClip;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.v.g.c;
import d.v.v.g.d;
import d.v.v.g.h$a;
import d.v.v.g.h$b;
import d.v.v.j.g;
import d.v.v.j.i;
import java.util.List;
import m.a.a;

public class h {
    private final NvsStreamingContext a;
    private final g b;
    private boolean c;
    private boolean d = true;
    private boolean e;
    private long f;
    private long g;
    private boolean h;
    private int i = -1;

    public h() {
        Object object = NvsStreamingContext.getInstance();
        this.a = object;
        this.b = object = d.v.v.j.g.c();
        this.h();
    }

    private void A() {
        g g10 = this.b;
        g10.u();
        int n10 = d.v.v.q.h.p();
        int n11 = this.i;
        if (n11 != n10) {
            g g11;
            if (n11 >= 0) {
                g g12 = this.b;
                g12.o(n11);
                g11 = d.v.v.j.g.c();
                int n12 = this.i;
                g11.p(n12, n10);
            }
            g11 = this.b;
            g11.r(n10);
            this.i = n10;
        }
    }

    public static /* synthetic */ g a(h h10) {
        return h10.b;
    }

    public static /* synthetic */ boolean b(h h10) {
        return h10.c;
    }

    public static /* synthetic */ long c(h h10) {
        return h10.f;
    }

    public static /* synthetic */ long d(h h10) {
        return h10.g;
    }

    public static /* synthetic */ boolean e(h h10) {
        return h10.d;
    }

    public static /* synthetic */ boolean f(h h10) {
        return h10.e;
    }

    public static /* synthetic */ NvsTimelineData g(h h10) {
        return h10.m();
    }

    private void h() {
        NvsStreamingContext nvsStreamingContext = this.a;
        Object object = new h$a(this);
        nvsStreamingContext.setPlaybackCallback((NvsStreamingContext$PlaybackCallback)object);
        nvsStreamingContext = this.a;
        object = new d(this);
        nvsStreamingContext.setPlaybackCallback2((NvsStreamingContext$PlaybackCallback2)object);
        nvsStreamingContext = this.a;
        object = new c(this);
        nvsStreamingContext.setSeekingCallback((NvsStreamingContext$SeekingCallback)object);
    }

    public static h k() {
        return h$b.a();
    }

    private NvsTimeline l() {
        return d.v.v.j.i.e().f();
    }

    private NvsTimelineData m() {
        return d.v.v.j.h.t().n();
    }

    private void u(long l10) {
        boolean bl2 = this.r();
        this.I(l10, 0);
        if (bl2) {
            this.C();
        }
    }

    private /* synthetic */ void w(NvsTimeline nvsTimeline, long l10) {
        this.A();
    }

    private /* synthetic */ void y(NvsTimeline nvsTimeline, long l10) {
        this.A();
    }

    public void B() {
        boolean bl2 = this.r();
        if (bl2) {
            NvsStreamingContext nvsStreamingContext = this.a;
            nvsStreamingContext.stop();
        }
    }

    public void C() {
        long l10;
        long l11;
        long l12 = this.j();
        long l13 = l12 - (l11 = (long)-1);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        object = this.c;
        long l14 = 40000L;
        if (object != false) {
            l10 = this.g;
            long l15 = l10 - l12;
            long l16 = l15 - l14;
            object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object <= 0) {
                l12 = this.f;
            }
        } else {
            object = this.d;
            if (object == false) {
                int n10;
                object = d.v.v.q.h.p();
                if (object == (n10 = -1)) {
                    return;
                }
                l10 = d.v.v.q.h.a0((int)object);
                long l17 = l10 - l12;
                long l18 = l17 - l14;
                Object object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                if (object2 <= 0) {
                    l12 = d.v.v.q.h.g0((int)object);
                }
            } else {
                l10 = d.v.v.q.h.z() - 1L;
                long l19 = l10 - l12;
                long l20 = l19 - l14;
                object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                if (object <= 0) {
                    l12 = 0L;
                }
            }
        }
        this.D(l12, l10);
    }

    public void D(long l10, long l11) {
        Object[] objectArray = new Object[2];
        Long l12 = l10;
        objectArray[0] = l12;
        l12 = l11;
        objectArray[1] = l12;
        m.a.a.b("playVideo startTime = %s,endTime = %s", objectArray);
        NvsStreamingContext nvsStreamingContext = this.a;
        NvsTimeline nvsTimeline = this.l();
        nvsStreamingContext.playbackTimeline(nvsTimeline, l10, l11, 1, true, 64);
    }

    public void E() {
        boolean bl2 = this.r();
        if (!bl2) {
            long l10 = this.j();
            this.I(l10, 0);
        }
    }

    public void F(int n10) {
        long l10 = this.j();
        this.I(l10, n10);
    }

    public void G() {
        long l10;
        this.c = false;
        this.d = true;
        this.e = false;
        this.i = -1;
        this.f = l10 = 0L;
        this.g = l10;
    }

    public boolean H(long l10) {
        return this.I(l10, 0);
    }

    public boolean I(long l10, int n10) {
        long l11 = d.v.v.q.h.z();
        long l12 = 1L;
        long l13 = Math.min(l10, l11 -= l12);
        long l14 = l13 - (l10 = 0L);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object < 0) {
            return false;
        }
        this.h = true;
        NvsStreamingContext nvsStreamingContext = this.a;
        NvsTimeline nvsTimeline = this.l();
        object = nvsStreamingContext.seekTimeline(nvsTimeline, l13, 1, n10);
        this.h = false;
        return (boolean)object;
    }

    public void J(boolean bl2) {
        this.d = bl2;
    }

    public void i() {
        this.e = false;
        this.c = false;
    }

    public long j() {
        NvsStreamingContext nvsStreamingContext = this.a;
        NvsTimeline nvsTimeline = this.l();
        long l10 = nvsStreamingContext.getTimelineCurrentPosition(nvsTimeline);
        long l11 = d.v.v.q.h.z() - 1L;
        return Math.min(l10, l11);
    }

    public void n(long l10, long l11) {
        this.p(true, l10, l11, false);
    }

    public void o(boolean bl2, long l10, long l11) {
        this.p(bl2, l10, l11, false);
    }

    public void p(boolean bl2, long l10, long l11, boolean object) {
        this.e = object;
        object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object >= 0) {
            return;
        }
        object = 1;
        this.c = object;
        l10 = Math.max(l10, 0L);
        long l12 = d.v.v.q.h.z();
        long l13 = 1L;
        l11 = Math.min(l11, l12 -= l13);
        this.f = l10;
        this.g = l11;
        if (bl2) {
            this.D(l10, l11);
        }
    }

    public boolean q() {
        return this.d;
    }

    public boolean r() {
        int n10;
        NvsStreamingContext nvsStreamingContext = this.a;
        int n11 = nvsStreamingContext.getStreamingEngineState();
        if (n11 == (n10 = 3)) {
            n11 = 1;
        } else {
            n11 = 0;
            nvsStreamingContext = null;
        }
        return n11 != 0;
    }

    public boolean s() {
        return this.h;
    }

    public void t() {
        int n10 = d.v.v.q.h.p();
        List list = this.m().getMediaInfoList();
        int n11 = list.size();
        int n12 = -1;
        if (n10 != n12 && n10 < (n11 += -1)) {
            NvsVideoClip nvsVideoClip;
            if ((nvsVideoClip = d.v.v.q.h.W(++n10)) == null) {
                return;
            }
            long l10 = nvsVideoClip.getInPoint();
            this.u(l10);
        }
    }

    public void v() {
        int n10;
        int n11 = d.v.v.q.h.p();
        if (n11 < (n10 = 1)) {
            return;
        }
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n11 -= n10);
        if (nvsVideoClip == null) {
            return;
        }
        long l10 = nvsVideoClip.getInPoint();
        this.u(l10);
    }

    public /* synthetic */ void x(NvsTimeline nvsTimeline, long l10) {
        this.w(nvsTimeline, l10);
    }

    public /* synthetic */ void z(NvsTimeline nvsTimeline, long l10) {
        this.y(nvsTimeline, l10);
    }
}

