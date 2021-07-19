/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package d.v.g.f.b.e;

import android.app.Application;
import android.content.Context;
import d.v.e.d;
import d.v.e.f;
import d.v.e.l.d1;
import d.v.g.f.b.e.b$a;
import java.util.List;

public class b
extends d {
    private static final String b = "firmware_version_preference";
    private static final String c = "firmware_version_";
    private static final String d = "app_version_";
    private static String e;
    private Context a;

    public b() {
        Application application = f.a().b();
        this.a = application;
        int n10 = d1.f(f.a().c());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(n10);
        stringBuilder.append(c);
        e = stringBuilder.toString();
    }

    public static b A() {
        return b$a.a();
    }

    public void B(float f10, String string2) {
        List list = this.z(f10);
        list.remove(string2);
        string2 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = e;
        stringBuilder.append(string3);
        stringBuilder.append(f10);
        String string4 = stringBuilder.toString();
        this.p((Context)string2, b, string4, list);
    }

    public void C(float f10, String string2) {
        List list = this.z(f10);
        boolean bl2 = list.contains(string2);
        if (!bl2) {
            list.add(string2);
            string2 = this.a;
            CharSequence charSequence = new StringBuilder();
            String string3 = e;
            charSequence.append(string3);
            charSequence.append(f10);
            String string4 = charSequence.toString();
            charSequence = b;
            this.p((Context)string2, (String)charSequence, string4, list);
        }
    }

    public List z(float f10) {
        Context context = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = e;
        stringBuilder.append(string2);
        stringBuilder.append(f10);
        String string3 = stringBuilder.toString();
        return this.k(context, b, string3);
    }
}

