/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaFormat
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.Surface
 */
package d.v.h0.k;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.zhiyun.vtpusher.VtDataType;
import com.zhiyun.vtpusher.VtEncoderType;
import d.v.h0.k.a;
import d.v.h0.k.b;
import d.v.h0.k.c;
import d.v.h0.k.e;
import d.v.h0.k.f$a;
import d.v.h0.k.f$b;
import d.v.h0.k.g.d;
import e.a.h0;
import e.a.v0.g;
import e.a.z;

public class f
implements b {
    private String a = "video/avc";
    private int b = 1920;
    private int c = 1080;
    private int d = 24;
    private int e = 8000000;
    private int f = 1;
    private d.v.h0.k.g.c g;
    private MediaCodec h;
    private e i;
    private c j;
    private final e.a.s0.a k;
    private final e l;

    public f() {
        Object object = new e.a.s0.a();
        this.k = object;
        this.l = object = new f$a(this);
    }

    public static /* synthetic */ boolean l(f f10) {
        return f10.p();
    }

    public static /* synthetic */ boolean m(f f10) {
        return f10.q();
    }

    public static /* synthetic */ e n(f f10) {
        return f10.i;
    }

    private void o() {
        Object object = this.a;
        int n10 = this.b;
        int n11 = this.c;
        object = MediaFormat.createVideoFormat((String)object, (int)n10, (int)n11);
        n10 = this.d;
        object.setInteger("frame-rate", n10);
        n10 = this.e;
        object.setInteger("bitrate", n10);
        n10 = this.g.j();
        String string2 = "color-format";
        object.setInteger(string2, n10);
        n11 = 1;
        object.setInteger("profile", n11);
        String string3 = "level";
        int n12 = 16;
        object.setInteger(string3, n12);
        n10 = Build.VERSION.SDK_INT;
        String string4 = "i-frame-interval";
        int n13 = 25;
        float f10 = 3.5E-44f;
        if (n10 >= n13) {
            n10 = this.f;
            float f11 = n10;
            n13 = 0x40000000;
            f10 = 2.0f;
            object.setFloat(string4, f11 /= f10);
        } else {
            n10 = this.f;
            object.setInteger(string4, n10);
        }
        string3 = MediaCodec.createEncoderByType((String)this.a);
        this.h = string3;
        string3.configure((MediaFormat)object, null, null, n11);
        object = this.g;
        string3 = this.h;
        object.i((MediaCodec)string3);
        this.g.e();
    }

    private boolean p() {
        String string2 = this.a;
        return "video/avc".equals(string2);
    }

    private boolean q() {
        String string2 = this.a;
        return "video/hevc".equals(string2);
    }

    private void r(String string2, Exception exception) {
        this.stop();
        e e10 = this.i;
        if (e10 != null) {
            e10.c(string2, exception);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void s(Bundle bundle) {
        MediaCodec mediaCodec = this.h;
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.setParameters(bundle);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public Surface a() {
        d.v.h0.k.g.c c10 = this.g;
        c10 = c10 == null ? null : c10.a();
        return c10;
    }

    public void b(e e10) {
        this.i = e10;
    }

    public void c(byte[] byArray) {
        d.v.h0.k.g.c c10 = this.g;
        if (c10 == null) {
            return;
        }
        c10.c(byArray);
    }

    public void d(VtEncoderType object) {
        object = object.getMime();
        this.a = object;
    }

    public void e(int n10) {
        if (n10 < 0) {
            return;
        }
        this.f = n10;
    }

    public void f() {
        d.v.h0.k.g.c c10 = this.g;
        if (c10 == null) {
            return;
        }
        this.o();
        c10 = this.g;
        Object object = this.l;
        try {
            c10.b((e)object);
        }
        catch (Exception exception) {
            this.j.release();
            object = "create encoder error";
            this.r((String)object, exception);
        }
    }

    public void g(int n10) {
        if (n10 <= 0) {
            return;
        }
        this.d = n10;
    }

    public void h(int n10, int n11) {
        if (n10 > 0 && n11 > 0) {
            this.b = n10 = n10 / 4 * 4;
            this.c = n11 = n11 / 4 * 4;
        }
    }

    public void i() {
        d.v.h0.k.g.c c10 = this.g;
        if (c10 == null) {
            return;
        }
        c10.d(false);
    }

    public void j(VtDataType object) {
        int[] nArray = f$b.a;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 == n11) {
                object = new d();
                this.g = object;
            }
        } else {
            object = new d.v.h0.k.g.b();
            this.g = object;
        }
        object = this.g.g();
        this.j = object;
    }

    public void k(int n10) {
        if (n10 <= 0) {
            return;
        }
        this.e = n10;
    }

    public void pause() {
        d.v.h0.k.g.c c10 = this.g;
        if (c10 == null) {
            return;
        }
        c10.d(true);
    }

    public void release() {
        d.v.h0.k.g.c c10 = this.g;
        if (c10 == null) {
            return;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            c10.release();
        }
        this.g = null;
    }

    public void start() {
        Object object;
        Object object2 = this.h;
        if (object2 == null) {
            return;
        }
        try {
            object2.start();
        }
        catch (Exception exception) {
            this.j.release();
            object = "start encoder error";
            this.r((String)object, exception);
        }
        object2 = this.h;
        if (object2 == null) {
            return;
        }
        this.k.e();
        object2 = z.t3(this.j);
        object = d.v.h0.k.a.a;
        object2 = ((z)object2).f2((g)object);
        object = e.a.c1.b.d();
        object2 = ((z)object2).L5((h0)object).a();
        this.k.b((e.a.s0.b)object2);
    }

    public void stop() {
        c c10 = this.j;
        if (c10 != null) {
            c10.n();
        }
        this.k.e();
    }
}

