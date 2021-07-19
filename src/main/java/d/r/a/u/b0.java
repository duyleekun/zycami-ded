/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package d.r.a.u;

import android.content.Context;
import android.content.SharedPreferences;
import d.r.a.u.f;
import d.r.a.u.h;
import d.r.a.u.s;

public final class b0
implements h {
    public static String b = "SpCache";
    private static String c = "com.vivo.push.cache";
    public SharedPreferences a;

    public final String a(String string2, String string3) {
        string3 = this.a.getString(string2, string3);
        String string4 = b;
        StringBuilder stringBuilder = new StringBuilder("getString ");
        stringBuilder.append(string2);
        stringBuilder.append(" is ");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        s.m(string4, string2);
        return string3;
    }

    public final boolean a(Context context) {
        Object object = this.a;
        if (object == null) {
            object = c;
            context = context.getSharedPreferences((String)object, 0);
            this.a = context;
        }
        return true;
    }

    public final void b(String string2, String string3) {
        Object object = this.a.edit();
        if (object != null) {
            object.putString(string2, string3);
            f.d((SharedPreferences.Editor)object);
            string3 = b;
            object = new StringBuilder("putString by ");
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            s.m(string3, string2);
            return;
        }
        string3 = b;
        object = new StringBuilder("putString error by ");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        s.h(string3, string2);
    }
}

