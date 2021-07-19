/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.net.Uri$Builder
 */
package com.huawei.hms.availableupdate;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.utils.Checker;
import java.io.File;
import java.io.IOException;

public class l {
    public Context a;
    public String b;

    public static File a(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalFile();
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public static String b(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public Uri a(File object, String string2) {
        object = l.b((File)object);
        Uri.Builder builder = null;
        if (object == null) {
            return null;
        }
        if ((object = this.b((String)object)) == null) {
            return null;
        }
        builder = new Uri.Builder();
        return builder.scheme("content").authority(string2).encodedPath((String)object).build();
    }

    public File a(Uri object) {
        object = object.getEncodedPath();
        File file = null;
        if (object == null) {
            return null;
        }
        if ((object = this.c((String)object)) == null) {
            return null;
        }
        file = new File((String)object);
        return l.a(file);
    }

    public File a(String string2) {
        String string3 = this.a();
        if (string3 == null) {
            return null;
        }
        File file = new File(string3, string2);
        return l.a(file);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String a() {
        Object object = this.a;
        Object object2 = "mContext is null, call setContext first.";
        object = (Context)Checker.assertNonNull(object, (String)object2);
        synchronized (this) {
            object2 = this.b;
            if (object2 != null) return this.b;
            object2 = object.getExternalCacheDir();
            if (object2 != null) {
                object = object.getExternalCacheDir();
                object = l.b((File)object);
                this.b = object;
                return this.b;
            } else {
                object = object.getFilesDir();
                object = l.b((File)object);
                this.b = object;
            }
            return this.b;
        }
    }

    public void a(Context context) {
        Object object = this.a;
        if (object == null) {
            object = "context must not be null.";
            Checker.checkNonNull(context, (String)object);
            this.a = context;
        }
    }

    public final String b(String string2) {
        String string3 = this.a();
        boolean bl2 = false;
        CharSequence charSequence = null;
        if (string3 == null) {
            return null;
        }
        boolean bl3 = string2.startsWith(string3);
        if (!bl3) {
            return null;
        }
        charSequence = "/";
        bl2 = string3.endsWith((String)charSequence);
        int n10 = bl2 ? string3.length() : string3.length() + 1;
        charSequence = new StringBuilder();
        String string4 = Uri.encode((String)"ContentUriHelper");
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append('/');
        string2 = string2.substring(n10);
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    public final String c(String string2) {
        String string3 = this.a();
        if (string3 == null) {
            return null;
        }
        int n10 = 1;
        int n11 = string2.indexOf(47, n10);
        if (n11 < 0) {
            return null;
        }
        String string4 = "ContentUriHelper";
        Object object = Uri.decode((String)string2.substring(n10, n11));
        boolean bl2 = string4.equals(object);
        if (!bl2) {
            return null;
        }
        string2 = Uri.decode((String)string2.substring(n11 += n10));
        object = new File(string3, string2);
        if ((string2 = l.b((File)object)) == null) {
            return null;
        }
        boolean bl3 = string2.startsWith(string3);
        if (!bl3) {
            return null;
        }
        return string2;
    }
}

