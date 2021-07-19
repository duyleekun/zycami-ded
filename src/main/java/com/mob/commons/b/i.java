/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package com.mob.commons.b;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.mob.commons.b.c;
import com.mob.commons.b.f;
import com.mob.commons.b.f$c;
import com.mob.commons.k;

public class i
extends f {
    private Uri c;

    public i(Context context) {
        super(context);
        context = Uri.parse((String)k.a(118));
        this.c = context;
    }

    private String a(String string2, String string3) {
        boolean bl2 = this.a((Bundle)(string2 = this.b(string2, string3)));
        if (bl2) {
            string3 = k.a(122);
            return string2.getString(string3);
        }
        if (string2 != null) {
            string3 = k.a(123);
            return string2.getString(string3);
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(Bundle bundle) {
        int n10;
        String string2;
        boolean bl2 = false;
        if (bundle == null) return bl2;
        int n11 = 119;
        try {
            string2 = k.a(n11);
            n10 = -1;
        }
        catch (Throwable throwable) {
            return bl2;
        }
        int n12 = bundle.getInt(string2, n10);
        if (n12 != 0) return bl2;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Bundle b(String string2, String object) {
        Bundle bundle = null;
        try {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 17;
            if (n10 < n11) {
                n11 = 11;
                if (n10 < n11) return bundle;
                Context context = this.a;
                context = context.getContentResolver();
                Uri uri = this.c;
                return context.call(uri, string2, (String)object, null);
            }
            Context context = this.a;
            context = context.getContentResolver();
            Uri uri = this.c;
            context = context.acquireUnstableContentProviderClient(uri);
            bundle = context.call(string2, (String)object, null);
            if (context == null) return bundle;
            int n12 = 24;
            if (n10 >= n12) {
                context.close();
                return bundle;
            }
            context.release();
            return bundle;
        }
        catch (Throwable throwable) {
            object = com.mob.commons.b.c.a();
            ((c)object).a(throwable);
        }
        return bundle;
    }

    private boolean j() {
        int n10 = 120;
        String string2 = k.a(n10);
        String string3 = null;
        boolean bl2 = this.a((Bundle)(string2 = this.b(string2, null)));
        if (bl2) {
            string3 = k.a(121);
            return string2.getBoolean(string3, true);
        }
        return false;
    }

    public f$c c() {
        boolean bl2;
        f$c f$c = new f$c();
        f$c.a = bl2 = this.j();
        String string2 = k.a(102);
        String string3 = this.b;
        f$c.c = string2 = this.a(string2, string3);
        string2 = k.a(100);
        f$c.b = string2 = this.a(string2, null);
        string2 = k.a(101);
        string3 = this.b;
        f$c.e = string2 = this.a(string2, string3);
        return f$c;
    }
}

