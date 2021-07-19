/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package j.a.a.i;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import j.a.a.i.e;

public class d
extends e {
    public d(Object object) {
        super(object);
    }

    public void a(int n10, String ... stringArray) {
        IllegalStateException illegalStateException = new IllegalStateException("Should never be requesting permissions on API < 23!");
        throw illegalStateException;
    }

    public Context b() {
        Object object = this.c();
        boolean bl2 = object instanceof Activity;
        if (bl2) {
            return (Context)this.c();
        }
        object = this.c();
        bl2 = object instanceof Fragment;
        if (bl2) {
            return ((Fragment)this.c()).getContext();
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Unknown host: ");
        Object object2 = this.c();
        charSequence.append(object2);
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public boolean i(String string2) {
        return false;
    }

    public void j(String object, String string2, String string3, int n10, int n11, String ... stringArray) {
        object = new IllegalStateException("Should never be requesting permissions on API < 23!");
        throw object;
    }
}

