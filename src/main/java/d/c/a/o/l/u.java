/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package d.c.a.o.l;

import android.net.Uri;
import android.text.TextUtils;
import d.c.a.o.f;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import java.io.File;

public class u
implements n {
    private final n a;

    public u(n n10) {
        this.a = n10;
    }

    private static Uri e(String string2) {
        String string3;
        char c10;
        char c11 = TextUtils.isEmpty((CharSequence)string2);
        if (c11 != '\u0000') {
            return null;
        }
        Uri uri = null;
        c11 = string2.charAt(0);
        string2 = c11 == (c10 = '/') ? u.f(string2) : ((string3 = (uri = Uri.parse((String)string2)).getScheme()) == null ? u.f(string2) : uri);
        return string2;
    }

    private static Uri f(String string2) {
        File file = new File(string2);
        return Uri.fromFile((File)file);
    }

    public n$a c(String string2, int n10, int n11, f f10) {
        n n12;
        boolean bl2;
        if ((string2 = u.e(string2)) != null && (bl2 = (n12 = this.a).a(string2))) {
            return this.a.b(string2, n10, n11, f10);
        }
        return null;
    }

    public boolean d(String string2) {
        return true;
    }
}

