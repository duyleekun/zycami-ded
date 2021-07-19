/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  android.text.TextUtils
 */
package com.mob.commons.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.mob.commons.b.c;
import com.mob.commons.b.f;
import com.mob.commons.b.f$c;

public class k
extends f {
    public k(Context context) {
        super(context);
    }

    public Intent a() {
        Intent intent = new Intent();
        String string2 = com.mob.commons.k.a(115);
        String string3 = com.mob.commons.k.a(116);
        intent.setClassName(string2, string3);
        return intent;
    }

    public f$c a(IBinder iBinder) {
        Object object;
        int n10;
        String string2;
        int n11;
        int n12;
        block9: {
            block8: {
                n12 = 1;
                n11 = 117;
                if (iBinder != null) {
                    string2 = com.mob.commons.k.a(n11);
                    try {
                        string2 = iBinder.queryLocalInterface(string2);
                        if (string2 == null) break block8;
                        n10 = n12;
                        break block9;
                    }
                    catch (Throwable throwable) {
                        object = c.a();
                        ((c)object).a(throwable);
                    }
                }
            }
            n10 = 0;
            string2 = null;
        }
        object = new f$c();
        ((f$c)object).a = n10;
        string2 = this.b;
        n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0 && (string2 = this.a) != null) {
            this.b = string2 = string2.getPackageName();
        }
        Object object2 = com.mob.commons.k.a(69);
        String string3 = com.mob.commons.k.a(n11);
        int n13 = 1;
        String[] stringArray = new String[]{};
        Object object3 = this;
        Object object4 = iBinder;
        ((f$c)object).b = string2 = this.a((String)object2, iBinder, string3, n13, stringArray);
        string2 = this.b;
        n10 = TextUtils.isEmpty((CharSequence)string2);
        object3 = null;
        if (n10 != 0) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = 70;
            object4 = com.mob.commons.k.a(n10);
            String string4 = com.mob.commons.k.a(n11);
            int n14 = 2;
            String[] stringArray2 = new String[n12];
            stringArray2[0] = string2 = this.b;
            object2 = this;
            string3 = iBinder;
            string2 = this.a((String)object4, iBinder, string4, n14, stringArray2);
        }
        ((f$c)object).e = string2;
        string2 = this.b;
        n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n10 == 0) {
            String string5;
            n10 = 75;
            object2 = com.mob.commons.k.a(n10);
            string3 = com.mob.commons.k.a(n11);
            n13 = 3;
            stringArray = new String[n12];
            stringArray[0] = string5 = this.b;
            object3 = this;
            object4 = iBinder;
            object3 = this.a((String)object2, iBinder, string3, n13, stringArray);
        }
        ((f$c)object).c = object3;
        return object;
    }
}

