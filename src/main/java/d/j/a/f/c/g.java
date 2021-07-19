/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.text.TextUtils
 */
package d.j.a.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import d.j.a.f.c.c;
import d.j.a.f.c.d;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class g
implements c {
    private final Context a;
    private final String b;

    public g(Context context, String string2) {
        this.a = context;
        this.b = string2;
    }

    private static String b(String object) {
        String string2 = "";
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "agc_";
        stringBuilder.append(string3);
        string3 = "UTF-8";
        object = ((String)object).getBytes(string3);
        object = g.c((byte[])object);
        object = d.a((byte[])object);
        try {
            stringBuilder.append((String)object);
            return stringBuilder.toString();
        }
        catch (UnsupportedEncodingException | NoSuchAlgorithmException exception) {
            return string2;
        }
    }

    private static byte[] c(byte[] byArray) {
        return MessageDigest.getInstance("SHA-256").digest(byArray);
    }

    public String a(String string2, String string3) {
        String string4;
        String string5;
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = g.b(string2)));
        if (bl2) {
            return string3;
        }
        Resources resources = this.a.getResources();
        int n10 = resources.getIdentifier(string2, string5 = "string", string4 = this.b);
        if (n10 == 0) {
            return string3;
        }
        try {
            resources = this.a;
        }
        catch (Resources.NotFoundException notFoundException) {
            return string3;
        }
        resources = resources.getResources();
        return resources.getString(n10);
    }
}

