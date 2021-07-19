/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package d.v.c.n1;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import d.v.c.n1.l2$a;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.s.b.i;
import d.v.s.b.i$a;
import d.v.s.b.l;

public class l2
extends AndroidViewModel {
    private static final String[] g = new String[]{"video/quicktime", "video/mp4", "image/x-canon-cr2", "image/jpeg", "image/png"};
    private final i a;
    private j b;
    private final MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private final i$a f;

    public l2(Application object) {
        super((Application)object);
        Object object2 = new j();
        this.b = object2;
        super();
        this.c = object2;
        super();
        this.d = object2;
        super();
        this.e = object2;
        this.f = object2 = new l2$a(this);
        object = l.J((Context)object);
        this.a = object;
    }

    public static /* synthetic */ j b(l2 l22) {
        return l22.b;
    }

    public static /* synthetic */ MutableLiveData c(l2 l22) {
        return l22.c;
    }

    public static /* synthetic */ MutableLiveData d(l2 l22) {
        return l22.d;
    }

    public static /* synthetic */ MutableLiveData e(l2 l22) {
        return l22.e;
    }

    public MutableLiveData f() {
        return this.c;
    }

    public MutableLiveData g() {
        return this.d;
    }

    public MutableLiveData i() {
        return this.e;
    }

    public j j() {
        return this.b;
    }

    public void k(int n10) {
        Object object = this.c;
        Object object2 = Boolean.TRUE;
        h.g((MutableLiveData)object, object2);
        int n11 = 2;
        if (n10 == n11) {
            object = this.a;
            int n12 = 500;
            object.c(n12);
        }
        object = this.a;
        object2 = g;
        object.f((String[])object2);
        object = this.a;
        object2 = this.f;
        object.x((i$a)object2);
        this.a.w(n10);
    }

    public void l() {
        this.a.s();
    }

    public void onCleared() {
        super.onCleared();
        this.a.s();
    }
}

