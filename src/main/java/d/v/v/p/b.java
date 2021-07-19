/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.v.p;

import android.text.TextUtils;
import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoTrack;
import com.meicam.sdk.NvsVideoTransition;
import com.zhiyun.nvseditor.data.NvsAssetInfo;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.e.d;
import d.v.v.j.h;
import d.v.v.j.i;
import d.v.v.p.b$a;
import d.v.v.q.f;
import java.util.List;

public class b {
    private NvsVideoTransition b(NvsVideoTrack nvsVideoTrack, int n10, d.v.h.k.b object) {
        boolean bl2;
        object = ((d.v.h.k.b)object).b();
        if (nvsVideoTrack != null && object != null && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            return nvsVideoTrack.setBuiltinTransition(n10, (String)object);
        }
        return null;
    }

    private NvsVideoTransition c(NvsVideoTrack nvsVideoTrack, int n10, d.v.h.k.b object) {
        int n11;
        f f10;
        int n12;
        object = ((d.v.h.k.b)object).c();
        if (nvsVideoTrack != null && object != null && (n12 = TextUtils.isEmpty((CharSequence)object)) == 0 && (object = (f10 = f.d()).o((String)object)) != null && (n12 = ((NvsAssetInfo)object).getStatus()) == (n11 = 1) && (object = ((NvsAssetInfo)object).getUuid()) != null && (n12 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0)) == 0) {
            return nvsVideoTrack.setPackagedTransition(n10, (String)object);
        }
        return null;
    }

    public static b j() {
        return b$a.a();
    }

    private NvsTimeline k() {
        return i.e().f();
    }

    private NvsTimelineData l() {
        return h.t().n();
    }

    public boolean a(int n10, d.v.h.k.b b10) {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return false;
        }
        int n11 = nvsVideoTrack.getClipCount();
        int n12 = 1;
        if (n10 < (n11 -= n12) && b10 != null && (n11 = b10.e())) {
            NvsVideoTransition nvsVideoTransition;
            long l10;
            long l11 = b10.a();
            long l12 = l11 - (l10 = 0L);
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 <= 0) {
                l11 = 2000000L;
                b10.f(l11);
            }
            if ((n11 = b10.e()) != n12) {
                int n13 = 2;
                if (n11 != n13) {
                    return false;
                }
                nvsVideoTransition = this.c(nvsVideoTrack, n10, b10);
            } else {
                nvsVideoTransition = this.b(nvsVideoTrack, n10, b10);
            }
            if (nvsVideoTransition == null) {
                n12 = 0;
            }
            if (nvsVideoTransition != null) {
                l11 = nvsVideoTransition.getVideoTransitionDuration();
                nvsVideoTransition.setVideoTransitionDuration(l11, 0);
            }
            return n12;
        }
        return false;
    }

    public boolean d(int n10, long l10) {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        Object object = h.t().v(n10);
        if (object == null) {
            return false;
        }
        if ((object = ((d)object).N()) == null) {
            return false;
        }
        NvsVideoTransition nvsVideoTransition = nvsVideoTrack.getTransitionBySourceClipIndex(n10);
        if (nvsVideoTransition == null) {
            return false;
        }
        nvsVideoTransition.setVideoTransitionDuration(l10, 0);
        ((d.v.h.k.b)object).f(l10);
        return true;
    }

    public void e() {
        NvsObject nvsObject = this.k();
        nvsObject = ((NvsTimeline)nvsObject).getVideoTrackByIndex(0);
        int n10 = ((NvsTrack)nvsObject).getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            this.f(i10);
        }
    }

    public void f(int n10) {
        Object object = d.v.v.q.h.h0();
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        d d10 = h.t().v(n10);
        if (d10 != null && object != null && nvsVideoClip != null) {
            List list = this.l().getMediaInfoList();
            int n11 = list.size() + -1;
            if (n10 < n11) {
                ((NvsVideoTrack)object).getTransitionBySourceClipIndex(n10);
                object = d10.N();
                if (object != null && (n11 = ((d.v.h.k.b)object).e()) != 0) {
                    long l10 = nvsVideoClip.getOutPoint();
                    long l11 = nvsVideoClip.getInPoint();
                    l10 -= l11;
                    l11 = ((d.v.h.k.b)object).a();
                    float f10 = l11;
                    float f11 = 2.0f;
                    float f12 = l10;
                    float f13 = (f10 /= f11) - f12;
                    Object object2 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
                    if (object2 <= 0) {
                        this.a(n10, (d.v.h.k.b)object);
                    } else {
                        this.i(n10);
                        d.v.h.k.b b10 = new d.v.h.k.b();
                        d10.o0(b10);
                    }
                } else {
                    this.i(n10);
                }
            } else {
                this.i(n10);
                d.v.h.k.b b11 = new d.v.h.k.b();
                d10.o0(b11);
            }
        }
    }

    public void g(int n10) {
        Object object = d.v.v.q.h.h0();
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (object != null && nvsVideoClip != null && n10 > 0) {
            Object object2 = h.t();
            object2 = ((h)object2).v(n10 += -1);
            NvsVideoClip nvsVideoClip2 = d.v.v.q.h.W(n10);
            if (object2 != null && nvsVideoClip2 != null) {
                int n11;
                ((NvsVideoTrack)object).getTransitionBySourceClipIndex(n10);
                object = ((d)object2).N();
                if (object != null && (n11 = ((d.v.h.k.b)object).e()) != 0) {
                    long l10 = nvsVideoClip.getOutPoint();
                    long l11 = nvsVideoClip.getInPoint();
                    l10 -= l11;
                    l11 = ((d.v.h.k.b)object).a();
                    float f10 = l11;
                    float f11 = 2.0f;
                    float f12 = l10;
                    float f13 = (f10 /= f11) - f12;
                    Object object3 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
                    if (object3 <= 0) {
                        this.a(n10, (d.v.h.k.b)object);
                    } else {
                        this.i(n10);
                        d.v.h.k.b b10 = new d.v.h.k.b();
                        ((d)object2).o0(b10);
                    }
                } else {
                    this.i(n10);
                }
            }
        }
    }

    public void h(int n10) {
        this.g(n10);
        this.f(n10);
    }

    public boolean i(int n10) {
        int n11;
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack != null && n10 < (n11 = nvsVideoTrack.getClipCount())) {
            NvsVideoTransition nvsVideoTransition = nvsVideoTrack.getTransitionBySourceClipIndex(n10);
            if (nvsVideoTransition == null) {
                return false;
            }
            nvsVideoTrack.setBuiltinTransition(n10, "");
            return true;
        }
        return false;
    }
}

