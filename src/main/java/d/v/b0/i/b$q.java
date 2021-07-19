/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.b0.i;

import android.content.Context;
import d.v.b0.i.b;
import d.v.b0.i.b$q$a;

public class b$q
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ b b;

    public b$q(b b10, String string2) {
        this.b = b10;
        this.a = string2;
    }

    public void run() {
        int n10;
        Object[] objectArray = this.a;
        objectArray.hashCode();
        Object object = "boy/";
        int n11 = objectArray.equals(object);
        if (n11 == 0) {
            object = "girl/";
            boolean bl2 = objectArray.equals(object);
            if (!bl2) {
                bl2 = false;
                objectArray = null;
            } else {
                objectArray = d.v.b0.i.b.c0();
            }
        } else {
            objectArray = d.v.b0.i.b.d0();
        }
        if (objectArray == null) {
            return;
        }
        n11 = objectArray.length;
        object = new int[n11];
        b$q$a b$q$a = null;
        for (int i10 = 0; i10 < (n10 = objectArray.length); ++i10) {
            Context context = d.v.b0.i.b.a0(this.b);
            CharSequence charSequence = new StringBuilder();
            charSequence.append("pta/");
            String string2 = this.a;
            charSequence.append(string2);
            string2 = objectArray[i10];
            charSequence.append(string2);
            charSequence = charSequence.toString();
            n10 = d.v.b0.i.b.m0(context, (String)charSequence);
            object[i10] = n10;
        }
        objectArray = d.v.b0.i.b.R0(this.b, (int[])object);
        object = this.b;
        b$q$a = new b$q$a(this, (int[])objectArray);
        ((b)object).F1(b$q$a);
    }
}

