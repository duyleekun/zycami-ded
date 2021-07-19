/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDataSource
 */
package d.c.a.o.m.d;

import android.media.MediaDataSource;
import d.c.a.o.m.d.g0$d;
import java.nio.ByteBuffer;

public class g0$d$a
extends MediaDataSource {
    public final /* synthetic */ ByteBuffer a;
    public final /* synthetic */ g0.d b;

    public g0$d$a(g0.d d10, ByteBuffer byteBuffer) {
        this.b = d10;
        this.a = byteBuffer;
    }

    public void close() {
    }

    public long getSize() {
        return this.a.limit();
    }

    public int readAt(long l10, byte[] byArray, int n10, int n11) {
        ByteBuffer byteBuffer = this.a;
        long l11 = byteBuffer.limit();
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            return -1;
        }
        byteBuffer = this.a;
        int n12 = (int)l10;
        byteBuffer.position(n12);
        n12 = this.a.remaining();
        n12 = Math.min(n11, n12);
        this.a.get(byArray, n10, n12);
        return n12;
    }
}

