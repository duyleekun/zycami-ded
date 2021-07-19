/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.util.Log
 */
package d.c.a.o.j.p;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.j.d$a;
import d.c.a.o.j.g;
import d.c.a.o.j.p.c$a;
import d.c.a.o.j.p.c$b;
import d.c.a.o.j.p.d;
import d.c.a.o.j.p.e;
import d.c.a.o.k.x.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class c
implements d.c.a.o.j.d {
    private static final String d = "MediaStoreThumbFetcher";
    private final Uri a;
    private final e b;
    private InputStream c;

    public c(Uri uri, e e10) {
        this.a = uri;
        this.b = e10;
    }

    private static c c(Context object, Uri uri, d d10) {
        b b10 = d.c.a.c.d(object).f();
        List list = d.c.a.c.d(object).m().g();
        object = object.getContentResolver();
        e e10 = new e(list, d10, b10, (ContentResolver)object);
        object = new c(uri, e10);
        return object;
    }

    public static c e(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        c$a c$a = new c$a(contentResolver);
        return d.c.a.o.j.p.c.c(context, uri, c$a);
    }

    public static c f(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        c$b c$b = new c$b(contentResolver);
        return d.c.a.o.j.p.c.c(context, uri, c$b);
    }

    private InputStream g() {
        int n10;
        Object object = this.b;
        Object object2 = this.a;
        object = ((e)object).d((Uri)object2);
        int n11 = -1;
        if (object != null) {
            e e10 = this.b;
            Uri uri = this.a;
            n10 = e10.a(uri);
        } else {
            n10 = n11;
        }
        if (n10 != n11) {
            object2 = new g((InputStream)object, n10);
            object = object2;
        }
        return object;
    }

    public Class a() {
        return InputStream.class;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        InputStream inputStream = this.c;
        if (inputStream == null) return;
        try {
            inputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public void cancel() {
    }

    public void d(Priority object, d$a d$a) {
        try {
            object = this.g();
        }
        catch (FileNotFoundException fileNotFoundException) {
            String string2 = d;
            boolean bl2 = Log.isLoggable((String)string2, (int)3);
            if (bl2) {
                String string3 = "Failed to find thumbnail file";
                Log.d((String)string2, (String)string3, (Throwable)fileNotFoundException);
            }
            d$a.c(fileNotFoundException);
            return;
        }
        this.c = object;
        d$a.e(object);
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

