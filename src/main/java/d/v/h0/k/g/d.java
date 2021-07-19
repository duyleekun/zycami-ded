/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.os.Build$VERSION
 *  android.view.Surface
 */
package d.v.h0.k.g;

import android.media.MediaCodec;
import android.os.Build;
import android.view.Surface;
import com.zhiyun.vtpusher.VtDataType;
import d.v.h0.k.c;
import d.v.h0.k.e;
import d.v.h0.k.g.a;
import d.v.h0.k.g.d$b;

public class d
extends a {
    private MediaCodec b;
    private e c;
    private Surface d;

    public static /* synthetic */ MediaCodec k(d d10) {
        return d10.b;
    }

    public static /* synthetic */ MediaCodec l(d d10, MediaCodec mediaCodec) {
        d10.b = mediaCodec;
        return mediaCodec;
    }

    public static /* synthetic */ e m(d d10) {
        return d10.c;
    }

    public static /* synthetic */ Surface n(d d10) {
        return d10.d;
    }

    public static /* synthetic */ Surface o(d d10, Surface surface) {
        d10.d = surface;
        return surface;
    }

    private void p() {
        Surface surface = this.d;
        if (surface == null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 23;
            this.d = n10 >= n11 ? (surface = MediaCodec.createPersistentInputSurface()) : (surface = this.b.createInputSurface());
        }
    }

    public Surface a() {
        MediaCodec mediaCodec = this.b;
        if (mediaCodec == null) {
            return null;
        }
        this.p();
        return this.d;
    }

    public void b(e e10) {
        this.c = e10;
    }

    public void e() {
        MediaCodec mediaCodec = this.b;
        if (mediaCodec == null) {
            return;
        }
        this.p();
        mediaCodec = this.b;
        Surface surface = this.d;
        mediaCodec.setInputSurface(surface);
    }

    public c g() {
        d$b d$b = new d$b(this, null);
        return d$b;
    }

    public VtDataType h() {
        return VtDataType.SurfaceType;
    }

    public void i(MediaCodec mediaCodec) {
        this.b = mediaCodec;
    }

    public int j() {
        return 2130708361;
    }

    public void release() {
        Surface surface = this.d;
        if (surface != null) {
            surface.release();
            surface = null;
            this.d = null;
        }
    }
}

