/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.net.Uri
 */
package d.c.a.o.m.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.m.f.a;
import d.c.a.o.m.f.d;

public class e
implements g {
    private static final String b = "android";
    private static final int c = 0;
    private static final int d = 2;
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 1;
    private static final int h;
    private final Context a;

    public e(Context context) {
        this.a = context = context.getApplicationContext();
    }

    private Context d(Uri object, String object2) {
        CharSequence charSequence;
        String string2 = this.a.getPackageName();
        boolean bl2 = ((String)object2).equals(string2);
        if (bl2) {
            return this.a;
        }
        try {
            string2 = this.a;
            charSequence = null;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            charSequence = this.a.getPackageName();
            boolean bl3 = ((String)object2).contains(charSequence);
            if (bl3) {
                return this.a;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Failed to obtain context or unrecognized Uri format for: ");
            ((StringBuilder)charSequence).append(object);
            object = ((StringBuilder)charSequence).toString();
            object2 = new IllegalArgumentException((String)object, nameNotFoundException);
            throw object2;
        }
        return string2.createPackageContext((String)object2, 0);
    }

    private int e(Uri object) {
        Object object2 = object.getPathSegments();
        IllegalArgumentException illegalArgumentException = null;
        try {
            object2 = object2.get(0);
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unrecognized Uri format: ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            illegalArgumentException = new IllegalArgumentException((String)object, numberFormatException);
            throw illegalArgumentException;
        }
        object2 = (String)object2;
        return Integer.parseInt((String)object2);
    }

    private int f(Context object, Uri object2) {
        Object object3 = object2.getPathSegments();
        String string2 = object2.getAuthority();
        String string3 = (String)object3.get(0);
        int n10 = 1;
        object3 = (String)object3.get(n10);
        int n11 = (object = object.getResources()).getIdentifier((String)object3, string3, string2);
        if (n11 == 0) {
            object = Resources.getSystem();
            string2 = b;
            n11 = object.getIdentifier((String)object3, string3, string2);
        }
        if (n11 != 0) {
            return n11;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Failed to find resource id for: ");
        ((StringBuilder)object3).append(object2);
        object2 = ((StringBuilder)object3).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    private int g(Context object, Uri object2) {
        int n10;
        int n11;
        Object object3 = object2.getPathSegments();
        int n12 = object3.size();
        if (n12 == (n11 = 2)) {
            return this.f((Context)object, (Uri)object2);
        }
        int n13 = object3.size();
        if (n13 == (n10 = 1)) {
            return this.e((Uri)object2);
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Unrecognized Uri format: ");
        ((StringBuilder)object3).append(object2);
        object2 = ((StringBuilder)object3).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public s c(Uri uri, int n10, int n11, f f10) {
        String string2 = uri.getAuthority();
        string2 = this.d(uri, string2);
        int n12 = this.g((Context)string2, uri);
        return d.c.a.o.m.f.d.d(d.c.a.o.m.f.a.b(this.a, (Context)string2, n12));
    }

    public boolean h(Uri uri, f f10) {
        return uri.getScheme().equals("android.resource");
    }
}

