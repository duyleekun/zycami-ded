/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 *  android.util.Log
 */
package d.c.a.o.j;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l
implements d {
    private static final String d = "LocalUriFetcher";
    private final Uri a;
    private final ContentResolver b;
    private Object c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.a = uri;
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
            this.c(object);
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public abstract void c(Object var1);

    public void cancel() {
    }

    public final void d(Priority object, d$a d$a) {
        Object object2;
        try {
            object = this.a;
        }
        catch (FileNotFoundException fileNotFoundException) {
            String string2 = "LocalUriFetcher";
            boolean bl2 = Log.isLoggable((String)string2, (int)3);
            if (bl2) {
                object2 = "Failed to open Uri";
                Log.d((String)string2, (String)object2, (Throwable)fileNotFoundException);
            }
            d$a.c(fileNotFoundException);
            return;
        }
        object2 = this.b;
        object = this.e((Uri)object, (ContentResolver)object2);
        this.c = object;
        d$a.e(object);
    }

    public abstract Object e(Uri var1, ContentResolver var2);

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

