/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.l;

import android.util.Log;
import d.c.a.o.a;
import d.c.a.o.f;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class c
implements a {
    private static final String a = "ByteBufferEncoder";

    public boolean c(ByteBuffer byteBuffer, File object, f object2) {
        boolean bl2;
        try {
            d.c.a.u.a.e(byteBuffer, (File)object);
            bl2 = true;
        }
        catch (IOException iOException) {
            object2 = a;
            boolean bl3 = Log.isLoggable((String)object2, (int)3);
            if (bl3) {
                object = "Failed to write data";
                Log.d((String)object2, (String)object, (Throwable)iOException);
            }
            bl2 = false;
            Object var1_3 = null;
        }
        return bl2;
    }
}

