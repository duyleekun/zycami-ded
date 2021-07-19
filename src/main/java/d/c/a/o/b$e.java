/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import d.c.a.o.b$f;
import d.c.a.o.j.m;
import d.c.a.o.k.x.b;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b$e
implements b$f {
    public final /* synthetic */ m a;
    public final /* synthetic */ b b;

    public b$e(m m10, b b10) {
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
    public int a(ImageHeaderParser imageHeaderParser) {
        void var1_4;
        block9: {
            int n10;
            block8: {
                Object object;
                block10: {
                    object = null;
                    Object object2 = this.a;
                    object2 = ((m)object2).d();
                    object2 = object2.getFileDescriptor();
                    FileInputStream fileInputStream = new FileInputStream((FileDescriptor)object2);
                    object2 = this.b;
                    RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(fileInputStream, (b)object2);
                    object = this.b;
                    n10 = imageHeaderParser.d(recyclableBufferedInputStream, (b)object);
                    try {
                        ((InputStream)recyclableBufferedInputStream).close();
                        break block8;
                    }
                    catch (IOException iOException) {}
                    catch (Throwable throwable) {
                        object = recyclableBufferedInputStream;
                    }
                    break block10;
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) break block9;
                try {
                    ((InputStream)object).close();
                    break block9;
                }
                catch (IOException iOException) {}
            }
            this.a.d();
            return n10;
        }
        this.a.d();
        throw var1_4;
    }
}

