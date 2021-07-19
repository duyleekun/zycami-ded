/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 */
package d.v.d.g.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import d.v.d.g.f.d;
import d.v.d.g.f.e$b;
import d.v.d.h.f;
import java.nio.ByteBuffer;

public class d$b
implements e$b {
    public final /* synthetic */ d a;

    public d$b(d d10) {
        this.a = d10;
    }

    public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        d d10 = this.a;
        boolean bl2 = d.f(d10);
        if (bl2 && (bl2 = d.d(d10 = this.a))) {
            d10 = d.e(this.a);
            d d11 = this.a;
            int n10 = d.h(d11);
            d10.writeSampleData(n10, byteBuffer, bufferInfo);
        }
    }

    public void b(MediaFormat object) {
        d d10 = this.a;
        int n10 = d.c(d10, (MediaFormat)object);
        d.i(d10, n10);
        object = new StringBuilder();
        ((StringBuilder)object).append("onAddFormat mVideoTrackId=");
        d10 = this.a;
        int bl2 = d.h(d10);
        ((StringBuilder)object).append(bl2);
        f.a(((StringBuilder)object).toString());
        object = this.a;
        n10 = (int)(d.d((d)object) ? 1 : 0);
        if (n10 != 0) {
            d.e(this.a).start();
            object = this.a;
            boolean bl3 = true;
            d.g((d)object, bl3);
        }
    }
}

