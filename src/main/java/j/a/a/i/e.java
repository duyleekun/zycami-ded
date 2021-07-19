/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package j.a.a.i;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import j.a.a.i.a;
import j.a.a.i.b;
import j.a.a.i.d;
import j.a.a.i.f;
import java.util.List;

public abstract class e {
    private Object a;

    public e(Object object) {
        this.a = object;
    }

    public static e d(Activity activity) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 < n11) {
            d d10 = new d(activity);
            return d10;
        }
        n10 = activity instanceof AppCompatActivity;
        if (n10 != 0) {
            activity = (AppCompatActivity)activity;
            b b10 = new b((AppCompatActivity)activity);
            return b10;
        }
        a a10 = new a(activity);
        return a10;
    }

    public static e e(Fragment fragment) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 < n11) {
            d d10 = new d(fragment);
            return d10;
        }
        f f10 = new f(fragment);
        return f10;
    }

    private boolean h(String ... stringArray) {
        for (String string2 : stringArray) {
            boolean bl2 = this.i(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public abstract void a(int var1, String ... var2);

    public abstract Context b();

    public Object c() {
        return this.a;
    }

    public boolean f(String string2) {
        return this.i(string2) ^ true;
    }

    public void g(String string2, String string3, String string4, int n10, int n11, String ... stringArray) {
        boolean bl2 = this.h(stringArray);
        if (bl2) {
            this.j(string2, string3, string4, n10, n11, stringArray);
        } else {
            this.a(n11, stringArray);
        }
    }

    public abstract boolean i(String var1);

    public abstract void j(String var1, String var2, String var3, int var4, int var5, String ... var6);

    public boolean k(String ... stringArray) {
        return this.h(stringArray);
    }

    public boolean l(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            bl2 = this.f(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }
}

