/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 */
package com.zhishen.imagetool;

import android.media.MediaCodec;
import com.zhishen.imagetool.ImagePixelBuffer;
import com.zhishen.imagetool.ImageStitcher;
import com.zhishen.imagetool.ImageStitcher$a;
import d.u.a.a;
import d.u.a.b$a;
import d.u.a.c;
import java.nio.ByteBuffer;

public class ImageStitcher$a$a
implements b$a {
    public final /* synthetic */ ImageStitcher a;
    public final /* synthetic */ c b;
    public final /* synthetic */ ImageStitcher$a c;

    public ImageStitcher$a$a(ImageStitcher$a imageStitcher$a, ImageStitcher imageStitcher, c c10) {
        this.c = imageStitcher$a;
        this.a = imageStitcher;
        this.b = c10;
    }

    public int a() {
        return 1;
    }

    public void b(ByteBuffer byteBuffer, int n10, long l10, int n11) {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.set(0, n10, l10, n11);
        a a10 = new a(byteBuffer, bufferInfo);
        this.b.f(a10);
    }

    public boolean c(ByteBuffer byteBuffer, int n10, int n11, int n12, int n13, long l10) {
        return false;
    }

    public void d() {
    }

    public boolean e(byte[] object, int n10, int n11, int n12, int n13, long l10) {
        ImageStitcher imageStitcher = this.a;
        int n14 = 4369;
        object = imageStitcher.u((byte[])object, n10, n11, n12, n13, n14);
        n10 = 1;
        n11 = 0;
        if (object != null) {
            long l11 = 1000L;
            object.f = l10 /= l11;
            c c10 = this.b;
            boolean bl2 = c10.g((ImagePixelBuffer)object, false);
            if (!bl2) {
                return n10 != 0;
            }
        } else {
            object = this.a;
            int n15 = ImageStitcher.b((ImageStitcher)object);
            if (n15 >= (n12 = 5)) {
                return n10 != 0;
            }
            object = this.a;
            ImageStitcher.c((ImageStitcher)object);
        }
        return false;
    }

    public void f() {
        this.b.g(null, true);
    }
}

