/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.g;

import com.meicam.sdk.NvsStreamingContext$PlaybackCallback;
import com.meicam.sdk.NvsTimeline;
import d.v.v.g.h;
import d.v.v.j.g;

public class h$a
implements NvsStreamingContext$PlaybackCallback {
    public final /* synthetic */ h a;

    public h$a(h h10) {
        this.a = h10;
    }

    public void onPlaybackEOF(NvsTimeline object) {
        long l10;
        long l11;
        int n10;
        int n11 = d.v.v.q.h.p();
        if (n11 == (n10 = -1)) {
            return;
        }
        Object object2 = this.a;
        long l12 = ((h)object2).j();
        h h10 = this.a;
        Object object3 = h.b(h10);
        if (object3 != 0) {
            h10 = this.a;
            l11 = h.c(h10);
            h h11 = this.a;
            l10 = h.d(h11);
        } else {
            h10 = this.a;
            object3 = h.e(h10);
            if (object3 == 0) {
                l11 = d.v.v.q.h.g0(n11);
                l10 = d.v.v.q.h.a0(n11);
            } else {
                l11 = 0L;
                l10 = d.v.v.q.h.z();
            }
        }
        h h12 = this.a;
        boolean bl2 = h.f(h12);
        if (bl2) {
            h12 = this.a;
            h12.H(l11);
        } else {
            long l13;
            l11 = Math.abs(l10 - l12);
            long l14 = l11 - (l13 = 40000L);
            object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 <= 0) {
                h10 = this.a;
                l13 = l10 - 1L;
                h10.H(l13);
            }
        }
        l10 -= l12;
        l12 = Math.abs(l10);
        l11 = 40001L;
        n10 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1));
        if (n10 <= 0 && (n10 = (int)(h.b((h)(object2 = this.a)) ? 1 : 0)) == 0) {
            h.a(this.a).o(n11);
            object2 = h.g(this.a).getMediaInfoList();
            n10 = object2.size() + -1;
            if (n11 == n10) {
                object = h.a(this.a);
                ((g)object).e();
            }
        }
    }

    public void onPlaybackPreloadingCompletion(NvsTimeline nvsTimeline) {
        h.a(this.a).s();
    }

    public void onPlaybackStopped(NvsTimeline nvsTimeline) {
        h.a(this.a).q();
    }
}

