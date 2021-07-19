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
import d.c.a.o.j.d$a;
import d.c.a.o.l.f$d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class f$c
implements d {
    private final File a;
    private final f$d b;
    private Object c;

    public f$c(File file, f$d f$d) {
        this.a = file;
        this.b = f$d;
    }

    public Class a() {
        return this.b.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object = this.c;
        if (object == null) return;
        try {
            f$d f$d = this.b;
            f$d.b(object);
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public void cancel() {
    }

    public void d(Priority object, d$a d$a) {
        Object object2;
        try {
            object = this.b;
        }
        catch (FileNotFoundException fileNotFoundException) {
            String string2 = "FileLoader";
            boolean bl2 = Log.isLoggable((String)string2, (int)3);
            if (bl2) {
                object2 = "Failed to open file";
                Log.d((String)string2, (String)object2, (Throwable)fileNotFoundException);
            }
            d$a.c(fileNotFoundException);
            return;
        }
        object2 = this.a;
        object = object.c((File)object2);
        this.c = object;
        d$a.e(object);
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

