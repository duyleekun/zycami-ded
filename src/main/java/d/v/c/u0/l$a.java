/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.u0;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import d.v.c.u0.l;
import d.v.e.i.h;
import d.v.e.l.a2;
import d.v.e.l.s1;
import d.v.h.c.b$a;

public class l$a
implements b$a {
    public final /* synthetic */ l a;

    public l$a(l l10) {
        this.a = l10;
    }

    public void a(Exception object, String object2) {
        this.a.m();
        h.g(l.b(this.a), object);
        this.a.k();
        object = l.c(this.a);
        object2 = 3;
        h.e((MutableLiveData)object, object2);
    }

    public void b(int n10) {
        MutableLiveData mutableLiveData = l.d(this.a);
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }

    public void c(String object) {
        Object object2 = this.a;
        int n10 = l.e((l)object2);
        if (n10 == 0) {
            object2 = l.f(this.a);
            String string2 = s1.H((String)object);
            a2.f((Context)object2, string2);
            h.g(l.g(this.a), object);
            object = l.c(this.a);
            n10 = 2;
            object2 = n10;
            h.e((MutableLiveData)object, object2);
        }
    }
}

