/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaMetadataRetriever
 *  android.os.ParcelFileDescriptor
 */
package d.c.a.o.m.d;

import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import d.c.a.o.m.d.g0$f;
import java.io.FileDescriptor;

public final class g0$g
implements g0$f {
    public void b(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor object) {
        object = object.getFileDescriptor();
        mediaMetadataRetriever.setDataSource((FileDescriptor)object);
    }
}

