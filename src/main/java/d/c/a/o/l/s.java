/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.net.Uri
 *  android.util.Log
 */
package d.c.a.o.l;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import d.c.a.o.f;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;

public class s
implements n {
    private static final String c = "ResourceLoader";
    private final n a;
    private final Resources b;

    public s(Resources resources, n n10) {
        this.b = resources;
        this.a = n10;
    }

    private Uri d(Integer object) {
        char c10;
        String string2;
        CharSequence charSequence;
        CharSequence charSequence2;
        try {
            charSequence2 = new StringBuilder();
            charSequence = "android.resource://";
        }
        catch (Resources.NotFoundException notFoundException) {
            string2 = c;
            c10 = Log.isLoggable((String)string2, (int)5);
            if (c10 != '\u0000') {
                charSequence = new StringBuilder();
                String string3 = "Received invalid resource id: ";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(object);
                object = ((StringBuilder)charSequence).toString();
                Log.w((String)string2, (String)object, (Throwable)notFoundException);
            }
            return null;
        }
        charSequence2.append((String)charSequence);
        charSequence = this.b;
        int n10 = (Integer)object;
        charSequence = charSequence.getResourcePackageName(n10);
        charSequence2.append((String)charSequence);
        c10 = '/';
        charSequence2.append(c10);
        string2 = this.b;
        int n11 = (Integer)object;
        string2 = string2.getResourceTypeName(n11);
        charSequence2.append(string2);
        charSequence2.append(c10);
        charSequence = this.b;
        n10 = (Integer)object;
        charSequence = charSequence.getResourceEntryName(n10);
        charSequence2.append((String)charSequence);
        charSequence2 = charSequence2.toString();
        return Uri.parse((String)charSequence2);
    }

    public n$a c(Integer object, int n10, int n11, f f10) {
        if ((object = this.d((Integer)object)) == null) {
            object = null;
        } else {
            n n12 = this.a;
            object = n12.b(object, n10, n11, f10);
        }
        return object;
    }

    public boolean e(Integer n10) {
        return true;
    }
}

