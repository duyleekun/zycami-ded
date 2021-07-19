/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaFormat
 *  android.view.Surface
 */
package d.v.d.g.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import d.v.d.g.f.e$a;
import d.v.d.g.f.e$b;
import d.v.d.h.f;

public class e {
    private int a;
    private int b;
    private int c;
    private int d;
    private float e = 30.0f;
    private boolean f;
    private MediaCodec g;
    private Surface h;
    private e$b i;
    private final Runnable j;

    public e() {
        e$a e$a = new e$a(this);
        this.j = e$a;
    }

    public static /* synthetic */ boolean a(e e10) {
        return e10.f;
    }

    public static /* synthetic */ MediaCodec b(e e10) {
        return e10.g;
    }

    public static /* synthetic */ MediaCodec c(e e10, MediaCodec mediaCodec) {
        e10.g = mediaCodec;
        return mediaCodec;
    }

    public static /* synthetic */ int d(e e10) {
        return e10.c;
    }

    public static /* synthetic */ float e(e e10) {
        return e10.e;
    }

    public static /* synthetic */ e$b f(e e10) {
        return e10.i;
    }

    public static /* synthetic */ Surface g(e e10) {
        return e10.h;
    }

    public static /* synthetic */ Surface h(e e10, Surface surface) {
        e10.h = surface;
        return surface;
    }

    public Surface i() {
        Object object = this.h;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("\u5fc5\u987b\u5728 prepare \u65b9\u6cd5\u540e\u8c03\u7528");
        throw object;
    }

    public void j() {
        int n10 = this.a;
        if (n10 > 0 && (n10 = this.b) > 0 && (n10 = this.c) > 0 && (n10 = this.d) > 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("prepare mFps=");
            int n11 = this.c;
            charSequence.append(n11);
            charSequence.append(",mCaptureRate=");
            float f10 = this.e;
            charSequence.append(f10);
            charSequence.append(",mBitRate=");
            n11 = this.d;
            charSequence.append(n11);
            charSequence.append(",size=");
            n11 = this.a;
            charSequence.append(n11);
            charSequence.append("x");
            n11 = this.b;
            charSequence.append(n11);
            d.v.d.h.f.a(charSequence.toString());
            charSequence = "video/avc";
            n11 = this.a;
            int n12 = this.b;
            MediaFormat mediaFormat = MediaFormat.createVideoFormat((String)charSequence, (int)n11, (int)n12);
            mediaFormat.setInteger("color-format", 2130708361);
            n12 = this.c;
            String string2 = "frame-rate";
            mediaFormat.setInteger(string2, n12);
            int n13 = 1;
            mediaFormat.setInteger("i-frame-interval", n13);
            n12 = this.d;
            mediaFormat.setInteger("bitrate", n12);
            float f11 = this.e;
            String string3 = "capture-rate";
            mediaFormat.setFloat(string3, f11);
            n12 = 0;
            f11 = 0.0f;
            charSequence = MediaCodec.createEncoderByType((String)charSequence);
            this.g = charSequence;
            charSequence.configure(mediaFormat, null, null, n13);
            charSequence = this.g;
            charSequence = charSequence.createInputSurface();
            try {
                this.h = charSequence;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                charSequence = this.g;
                charSequence.release();
                this.g = null;
            }
            return;
        }
        d.v.d.h.f.a("prepare failed ,invalid parameter ,return");
    }

    public void k(int n10) {
        this.d = n10;
    }

    public void l(e$b e$b) {
        this.i = e$b;
    }

    public void m(float f10) {
        this.e = f10;
    }

    public void n(int n10) {
        this.c = n10;
    }

    public void o(int n10, int n11) {
        this.a = n10;
        this.b = n11;
    }

    public void p() {
        d.v.d.h.f.a("start video encoder");
        this.f = true;
        this.g.start();
        Runnable runnable = this.j;
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void q() {
        d.v.d.h.f.a("stop video encoder");
        this.f = false;
    }
}

