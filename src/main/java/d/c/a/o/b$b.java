/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d.c.a.o.b$g;
import java.nio.ByteBuffer;

public class b$b
implements b$g {
    public final /* synthetic */ ByteBuffer a;

    public b$b(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    public ImageHeaderParser$ImageType a(ImageHeaderParser imageHeaderParser) {
        ByteBuffer byteBuffer = this.a;
        return imageHeaderParser.a(byteBuffer);
    }
}

