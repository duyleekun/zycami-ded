/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 */
package d.u.a;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

public class a {
    public ByteBuffer a = null;
    public MediaCodec.BufferInfo b = null;

    public a() {
    }

    public a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.a = byteBuffer;
        this.b = bufferInfo;
    }
}

