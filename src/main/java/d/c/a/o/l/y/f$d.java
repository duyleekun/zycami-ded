/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Environment
 *  android.provider.MediaStore
 *  android.text.TextUtils
 */
package d.c.a.o.l.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import java.io.File;
import java.io.FileNotFoundException;

public final class f$d
implements d {
    private static final String[] k = new String[]{"_data"};
    private final Context a;
    private final n b;
    private final n c;
    private final Uri d;
    private final int e;
    private final int f;
    private final f g;
    private final Class h;
    private volatile boolean i;
    private volatile d j;

    public f$d(Context context, n n10, n n11, Uri uri, int n12, int n13, f f10, Class clazz) {
        this.a = context = context.getApplicationContext();
        this.b = n10;
        this.c = n11;
        this.d = uri;
        this.e = n12;
        this.f = n13;
        this.g = f10;
        this.h = clazz;
    }

    private n$a c() {
        boolean bl2 = Environment.isExternalStorageLegacy();
        if (bl2) {
            n n10 = this.b;
            Object object = this.d;
            object = this.g((Uri)object);
            int n11 = this.e;
            int n12 = this.f;
            f f10 = this.g;
            return n10.b(object, n11, n12, f10);
        }
        bl2 = this.f();
        Uri uri = bl2 ? MediaStore.setRequireOriginal((Uri)this.d) : this.d;
        n n13 = this.c;
        int n14 = this.e;
        int n15 = this.f;
        f f11 = this.g;
        return n13.b(uri, n14, n15, f11);
    }

    private d e() {
        Object object = this.c();
        object = object != null ? ((n$a)object).c : null;
        return object;
    }

    private boolean f() {
        Context context = this.a;
        String string2 = "android.permission.ACCESS_MEDIA_LOCATION";
        int n10 = context.checkSelfPermission(string2);
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    private File g(Uri object) {
        Object object2;
        Object object3;
        Object object4;
        Cursor cursor;
        block25: {
            cursor = null;
            object4 = this.a;
            object3 = object4.getContentResolver();
            String[] stringArray = k;
            object2 = object;
            cursor = object3.query(object, stringArray, null, null, null);
            if (cursor == null) break block25;
            int n10 = cursor.moveToFirst();
            if (n10 == 0) break block25;
            object4 = "_data";
            n10 = cursor.getColumnIndexOrThrow((String)object4);
            object4 = cursor.getString(n10);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object4);
            if (!bl2) {
                object = new File((String)object4);
                return object;
            }
            object3 = new StringBuilder();
            object2 = "File path was empty in media store for: ";
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(object);
            object = ((StringBuilder)object3).toString();
            object4 = new FileNotFoundException((String)object);
            throw object4;
        }
        object3 = new StringBuilder();
        object2 = "Failed to media store entry for: ";
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(object);
        object = ((StringBuilder)object3).toString();
        try {
            object4 = new FileNotFoundException((String)object);
            throw object4;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public Class a() {
        return this.h;
    }

    public void b() {
        d d10 = this.j;
        if (d10 != null) {
            d10.b();
        }
    }

    public void cancel() {
        boolean bl2;
        this.i = bl2 = true;
        d d10 = this.j;
        if (d10 != null) {
            d10.cancel();
        }
    }

    public void d(Priority object, d$a d$a) {
        Object object2;
        block13: {
            block12: {
                object2 = this.e();
                if (object2 != null) break block12;
                object2 = new StringBuilder();
                String string2 = "Failed to build fetcher for: ";
                ((StringBuilder)object2).append(string2);
                string2 = this.d;
                ((StringBuilder)object2).append((Object)string2);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException((String)object2);
                d$a.c((Exception)object);
                return;
            }
            this.j = object2;
            boolean bl2 = this.i;
            if (!bl2) break block13;
            this.cancel();
        }
        try {
            object2.d((Priority)((Object)object), d$a);
        }
        catch (FileNotFoundException fileNotFoundException) {
            d$a.c(fileNotFoundException);
        }
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

