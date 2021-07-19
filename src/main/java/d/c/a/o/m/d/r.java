/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.d;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d.c.a.o.k.x.b;
import d.c.a.u.a;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class r
implements ImageHeaderParser {
    public ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public int b(ByteBuffer object, b b10) {
        object = a.f((ByteBuffer)object);
        return this.d((InputStream)object, b10);
    }

    public ImageHeaderParser$ImageType c(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public int d(InputStream object, b object2) {
        object2 = new ExifInterface((InputStream)object);
        int n10 = 1;
        int n11 = ((ExifInterface)object2).getAttributeInt((String)(object = "Orientation"), n10);
        if (n11 == 0) {
            n11 = -1;
        }
        return n11;
    }
}

