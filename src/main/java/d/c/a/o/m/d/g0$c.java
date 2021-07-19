/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.media.MediaMetadataRetriever
 */
package d.c.a.o.m.d;

import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import d.c.a.o.m.d.g0$a;
import d.c.a.o.m.d.g0$f;
import java.io.FileDescriptor;

public final class g0$c
implements g0$f {
    private g0$c() {
    }

    public /* synthetic */ g0$c(g0$a g0$a) {
        this();
    }

    public void b(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
        FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();
        long l10 = assetFileDescriptor.getStartOffset();
        long l11 = assetFileDescriptor.getLength();
        mediaMetadataRetriever.setDataSource(fileDescriptor, l10, l11);
    }
}

