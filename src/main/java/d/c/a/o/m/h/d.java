/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.m.h;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import d.c.a.o.f;
import d.c.a.o.h;
import d.c.a.o.k.s;
import d.c.a.o.m.h.c;
import d.c.a.u.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class d
implements h {
    private static final String a = "GifEncoder";

    public EncodeStrategy b(f f10) {
        return EncodeStrategy.SOURCE;
    }

    public boolean c(s object, File object2, f object3) {
        boolean bl2;
        object = (c)object.get();
        object = ((c)object).c();
        try {
            d.c.a.u.a.e((ByteBuffer)object, (File)object2);
            bl2 = true;
        }
        catch (IOException iOException) {
            object3 = a;
            boolean bl3 = Log.isLoggable((String)object3, (int)5);
            if (bl3) {
                object2 = "Failed to encode GIF drawable data";
                Log.w((String)object3, (String)object2, (Throwable)iOException);
            }
            bl2 = false;
            Object var1_3 = null;
        }
        return bl2;
    }
}

