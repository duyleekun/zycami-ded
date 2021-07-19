/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import d.c.a.o.b$g;
import d.c.a.o.j.m;
import d.c.a.o.k.x.b;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b$c
implements b$g {
    public final /* synthetic */ m a;
    public final /* synthetic */ b b;

    public b$c(m m10, b b10) {
        this.a = m10;
        this.b = b10;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImageHeaderParser$ImageType a(ImageHeaderParser object) {
        void var1_4;
        block10: {
            block8: {
                InputStream inputStream;
                block9: {
                    inputStream = null;
                    Object object2 = this.a;
                    object2 = ((m)object2).d();
                    object2 = object2.getFileDescriptor();
                    FileInputStream fileInputStream = new FileInputStream((FileDescriptor)object2);
                    object2 = this.b;
                    RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(fileInputStream, (b)object2);
                    try {
                        object /* !! */  = object /* !! */ .c(recyclableBufferedInputStream);
                    }
                    catch (Throwable throwable) {
                        inputStream = recyclableBufferedInputStream;
                        break block9;
                    }
                    try {
                        ((InputStream)recyclableBufferedInputStream).close();
                        break block8;
                    }
                    catch (IOException iOException) {}
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (inputStream == null) break block10;
                try {
                    inputStream.close();
                    break block10;
                }
                catch (IOException iOException) {}
            }
            this.a.d();
            return object /* !! */ ;
        }
        this.a.d();
        throw var1_4;
    }
}

