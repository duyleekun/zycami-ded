/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaMuxer
 *  android.os.ParcelFileDescriptor
 */
package com.google.android.exoplayer2.transformer;

import android.media.MediaMuxer;
import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.transformer.FrameworkMuxer;
import com.google.android.exoplayer2.transformer.Muxer$Factory;
import java.io.FileDescriptor;

public final class FrameworkMuxer$Factory
implements Muxer$Factory {
    public FrameworkMuxer create(ParcelFileDescriptor object, String string2) {
        object = object.getFileDescriptor();
        int n10 = FrameworkMuxer.access$000(string2);
        MediaMuxer mediaMuxer = new MediaMuxer((FileDescriptor)object, n10);
        object = new FrameworkMuxer(mediaMuxer, string2, null);
        return object;
    }

    public FrameworkMuxer create(String object, String string2) {
        int n10 = FrameworkMuxer.access$000(string2);
        MediaMuxer mediaMuxer = new MediaMuxer((String)object, n10);
        object = new FrameworkMuxer(mediaMuxer, string2, null);
        return object;
    }

    public boolean supportsOutputMimeType(String string2) {
        try {
            FrameworkMuxer.access$000(string2);
            return true;
        }
        catch (IllegalStateException illegalStateException) {
            return false;
        }
    }
}

