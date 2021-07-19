/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.s0.i7;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import d.v.c.s0.i7.k;
import d.v.c.s0.i7.k$d;

public class k$a
implements Handler.Callback {
    public final /* synthetic */ k a;

    public k$a(k k10) {
        this.a = k10;
    }

    public boolean handleMessage(Message object) {
        ViewGroup viewGroup;
        object = (k$d)object.obj;
        Object object2 = object.d;
        if (object2 == null) {
            object2 = this.a.b;
            int n10 = object.c;
            ViewGroup viewGroup2 = object.b;
            viewGroup = null;
            object2 = object2.inflate(n10, viewGroup2, false);
            object.d = object2;
        }
        object2 = object.e;
        View view = object.d;
        int n11 = object.c;
        viewGroup = object.b;
        object2.onInflateFinished(view, n11, viewGroup);
        this.a.e((k$d)object);
        return true;
    }
}

