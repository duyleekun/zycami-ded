/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.r;

import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.e.d;
import d.v.v.q.h;
import d.v.v.r.a$a;

public class a {
    private void b() {
        NvsVideoTrack nvsVideoTrack = h.h0();
        if (nvsVideoTrack == null) {
            return;
        }
        int n10 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = nvsVideoTrack.getClipByIndex(i10);
            if (object == null || (object = d.v.v.j.h.t().v(i10)) == null) continue;
            float f10 = ((d)object).O();
            this.k(i10, f10);
        }
        this.d().setGlobalVideoVolumeEnable(false);
    }

    public static a c() {
        return a$a.a();
    }

    private NvsTimelineData d() {
        return d.v.v.j.h.t().n();
    }

    private boolean g(NvsVideoClip nvsVideoClip, int n10, boolean bl2) {
        d.v.v.j.h h10 = d.v.v.j.h.t();
        d d10 = h10.v(n10);
        if (d10 == null) {
            return false;
        }
        if (bl2) {
            n10 = 0;
            float f11 = 0.0f;
            d10 = null;
            nvsVideoClip.setVolumeGain(0.0f, 0.0f);
        } else {
            float f10 = d10.O();
            int n11 = 1065353216;
            float f11 = 1.0f;
            nvsVideoClip.setVolumeGain(f10 *= f11, f10);
        }
        return true;
    }

    private boolean l(int n10, float f10) {
        NvsVideoClip nvsVideoClip = h.W(n10);
        if (nvsVideoClip == null) {
            return false;
        }
        d.v.v.j.h h10 = d.v.v.j.h.t();
        d d10 = h10.v(n10);
        if (d10 == null) {
            return false;
        }
        nvsVideoClip.setVolumeGain(f10, f10);
        return true;
    }

    public boolean a(long l10) {
        MediaType mediaType;
        int n10 = h.b0(l10);
        d d10 = d.v.v.j.h.t().v(n10);
        boolean bl2 = false;
        if (d10 == null) {
            return false;
        }
        MediaType mediaType2 = d10.f();
        if (mediaType2 != (mediaType = MediaType.IMAGE) && mediaType2 != (mediaType = MediaType.GIF) && (n10 = (int)(d10.j() ? 1 : 0)) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean e(int n10, boolean bl2) {
        NvsVideoClip nvsVideoClip = h.W(n10);
        if (nvsVideoClip == null) {
            return false;
        }
        boolean bl3 = this.g(nvsVideoClip, n10, bl2);
        if (bl3) {
            d.v.v.j.h h10 = d.v.v.j.h.t();
            d d10 = h10.v(n10);
            d10.f0(bl2);
        }
        return bl3;
    }

    public boolean f(boolean bl2) {
        NvsVideoTrack nvsVideoTrack = h.h0();
        if (nvsVideoTrack == null) {
            return false;
        }
        int n10 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
            if (nvsVideoClip == null) continue;
            this.g(nvsVideoClip, i10, bl2);
        }
        this.d().setGlobalVideoMute(bl2);
        return true;
    }

    public void h(int n10, boolean bl2) {
        d d10 = d.v.v.j.h.t().v(n10);
        NvsVideoClip nvsVideoClip = h.W(n10);
        if (d10 != null && nvsVideoClip != null) {
            float f10 = 0.0f;
            if (bl2) {
                nvsVideoClip.setVolumeGain(0.0f, 0.0f);
            } else {
                NvsTimelineData nvsTimelineData = this.d();
                boolean bl3 = nvsTimelineData.isGlobalVideoVolumeEnable();
                if (bl3) {
                    nvsTimelineData = this.d();
                    boolean bl4 = nvsTimelineData.isGlobalVideoMute();
                    if (!bl4) {
                        nvsTimelineData = this.d();
                        f10 = nvsTimelineData.getGlobalVideoVolume();
                    }
                } else {
                    boolean bl5 = d10.Q();
                    if (!bl5) {
                        f10 = d10.O();
                    }
                }
                int n11 = 1065353216;
                float f11 = 1.0f;
                nvsVideoClip.setVolumeGain(f10 *= f11, f10);
            }
        }
    }

    public boolean i(boolean bl2) {
        NvsVideoTrack nvsVideoTrack = h.h0();
        if (nvsVideoTrack == null) {
            return false;
        }
        if (bl2) {
            NvsTimelineData nvsTimelineData = this.d();
            float f10 = nvsTimelineData.getGlobalVideoVolume();
            this.j(f10);
        } else {
            this.b();
        }
        return true;
    }

    public boolean j(float f10) {
        NvsVideoTrack nvsVideoTrack = h.h0();
        if (nvsVideoTrack == null) {
            return false;
        }
        float f11 = 1.0f * f10;
        int n10 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n10; i10 += 1) {
            this.l(i10, f11);
        }
        this.d().setGlobalVideoVolume(f10);
        NvsTimelineData nvsTimelineData = this.d();
        n10 = 1;
        nvsTimelineData.setGlobalVideoVolumeEnable(n10 != 0);
        return n10 != 0;
    }

    public boolean k(int n10, float f10) {
        float f11 = 1.0f * f10;
        boolean bl2 = this.l(n10, f11);
        if (bl2) {
            d.v.v.j.h h10 = d.v.v.j.h.t();
            d d10 = h10.v(n10);
            d10.q0(f10);
        }
        return bl2;
    }
}

