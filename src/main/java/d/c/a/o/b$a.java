/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d.c.a.o.b$g;
import java.io.InputStream;

public class b$a
implements b$g {
    public final /* synthetic */ InputStream a;

    public b$a(InputStream inputStream) {
        this.a = inputStream;
    }

    public ImageHeaderParser$ImageType a(ImageHeaderParser object) {
        try {
            InputStream inputStream = this.a;
            object = object.c(inputStream);
            return object;
        }
        finally {
            this.a.reset();
        }
    }
}

