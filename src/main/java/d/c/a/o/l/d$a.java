/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.l;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.j.d;
import d.c.a.u.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class d$a
implements d {
    private final File a;

    public d$a(File file) {
        this.a = file;
    }

    public Class a() {
        return ByteBuffer.class;
    }

    public void b() {
    }

    public void cancel() {
    }

    public void d(Priority object, d.c.a.o.j.d$a d$a) {
        try {
            object = this.a;
        }
        catch (IOException iOException) {
            String string2 = "ByteBufferFileLoader";
            boolean bl2 = Log.isLoggable((String)string2, (int)3);
            if (bl2) {
                String string3 = "Failed to obtain ByteBuffer for file";
                Log.d((String)string2, (String)string3, (Throwable)iOException);
            }
            d$a.c(iOException);
            return;
        }
        object = d.c.a.u.a.a((File)object);
        d$a.e(object);
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

