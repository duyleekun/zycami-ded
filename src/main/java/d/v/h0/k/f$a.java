/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 */
package d.v.h0.k;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.core.util.Pair;
import d.v.h0.k.d;
import d.v.h0.k.e;
import d.v.h0.k.f;
import d.v.y.d.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class f$a
implements e {
    public boolean a;
    public Pair b = null;
    public boolean c;
    public byte[] d = null;
    public boolean e;
    public final /* synthetic */ f f;

    public f$a(f f10) {
        this.f = f10;
    }

    private void f() {
        this.a = false;
        this.b = null;
        this.c = false;
        this.d = null;
        this.e = false;
    }

    public void a(ByteBuffer object, MediaCodec.BufferInfo bufferInfo) {
        Object object2 = d.v.h0.k.f.n(this.f);
        if (object2 != null) {
            object2 = d.v.h0.k.f.n(this.f);
            object2.a((ByteBuffer)object, bufferInfo);
        }
        int n10 = ((Buffer)object).remaining();
        Object object3 = new byte[n10];
        ((ByteBuffer)object).get((byte[])object3, 0, n10);
        int n11 = bufferInfo.flags;
        n10 = 1;
        if (n11 == n10) {
            boolean bl2;
            n11 = (int)(this.a ? 1 : 0);
            if (n11 == 0) {
                this.a = n10;
                object = this.f;
                n11 = (int)(d.v.h0.k.f.l((f)object) ? 1 : 0);
                if (n11 != 0 && (n11 = (int)(d.v.h0.k.d.c(object3) ? 1 : 0)) != 0) {
                    n11 = n10;
                } else {
                    n11 = 0;
                    object = null;
                }
                this.c = n11;
                object = this.f;
                n11 = (int)(d.v.h0.k.f.m((f)object) ? 1 : 0);
                if (n11 != 0 && (n11 = (int)(d.v.h0.k.d.d(object3) ? 1 : 0)) != 0) {
                    n11 = n10;
                } else {
                    n11 = 0;
                    object = null;
                }
                this.e = n11;
            }
            if ((n11 = (int)(d.v.h0.k.f.l((f)(object = this.f)) ? 1 : 0)) != 0 && (object = this.b) != null && !(bl2 = this.c)) {
                byte[] byArray = (byte[])((Pair)object).first;
                int n12 = 2;
                byte[][] byArrayArray = new byte[n12][];
                object = (byte[])((Pair)object).second;
                byArrayArray[0] = (byte[])object;
                byArrayArray[n10] = object3;
                object = d.v.y.d.a.a(byArray, byArrayArray);
                object3 = object;
            }
            if ((n11 = (int)(d.v.h0.k.f.m((f)(object = this.f)) ? 1 : 0)) != 0 && (object = (Object)this.d) != null && !(bl2 = this.e)) {
                object2 = new byte[n10][];
                object2[0] = object3;
                object3 = d.v.y.d.a.a((byte[])object, (byte[][])object2);
            }
        }
        if ((object = d.v.h0.k.f.n(this.f)) != null) {
            object = d.v.h0.k.f.n(this.f);
            object.b((byte[])object3, bufferInfo);
        }
    }

    public void c(String string2, Exception exception) {
        this.f();
        e e10 = d.v.h0.k.f.n(this.f);
        if (e10 != null) {
            e10 = d.v.h0.k.f.n(this.f);
            e10.c(string2, exception);
        }
    }

    public void d(MediaFormat mediaFormat) {
        this.f();
        Object object = this.f;
        boolean bl2 = d.v.h0.k.f.l((f)object);
        byte[] byArray = null;
        if (bl2) {
            object = d.v.h0.k.d.a(mediaFormat);
        } else {
            bl2 = false;
            object = null;
        }
        this.b = object;
        object = this.f;
        bl2 = d.v.h0.k.f.m((f)object);
        if (bl2) {
            byArray = d.v.h0.k.d.b(mediaFormat);
        }
        this.d = byArray;
        object = d.v.h0.k.f.n(this.f);
        if (object != null) {
            object = d.v.h0.k.f.n(this.f);
            object.d(mediaFormat);
        }
    }

    public void e() {
        this.f();
        e e10 = d.v.h0.k.f.n(this.f);
        if (e10 != null) {
            e10 = d.v.h0.k.f.n(this.f);
            e10.e();
        }
    }
}

