/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDataSource
 *  android.media.MediaMetadataRetriever
 */
package d.c.a.o.m.d;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import d.c.a.o.m.d.g0$d$a;
import d.c.a.o.m.d.g0$f;
import java.nio.ByteBuffer;

public final class g0$d
implements g0$f {
    public void b(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
        g0$d$a g0$d$a = new g0$d$a(this, byteBuffer);
        mediaMetadataRetriever.setDataSource((MediaDataSource)g0$d$a);
    }
}

