/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.d.i.f;

import android.content.Context;
import d.v.d.h.d;
import d.v.d.h.f;
import d.v.d.i.f.a;
import d.v.d.i.f.b;
import java.util.ArrayList;
import java.util.List;

public class l
extends d.v.d.i.a.a {
    public static final int l = 1;
    public static final int m;
    private Context h;
    private final List i;
    private final List j;
    private final List k;

    public l(Context context) {
        ArrayList arrayList;
        this.h = context;
        this.i = arrayList = new ArrayList();
        this.j = arrayList = new ArrayList();
        this.k = arrayList = new ArrayList();
        this.q(context);
    }

    private void q(Context object) {
        this.a = object = Integer.valueOf(d.v.d.h.d.b(object.getApplicationContext()));
        object = new StringBuilder();
        ((StringBuilder)object).append("init preview id start,read camera id=");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = (Integer)this.a;
        int n10 = (Integer)object;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 0;
            this.a = object = Integer.valueOf(0);
        }
    }

    public static /* synthetic */ void w(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Support back id=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
    }

    public static /* synthetic */ void x(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Support front id=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
    }

    public void A(List object, List object2) {
        this.i.clear();
        this.i.addAll(object2);
        this.i.addAll(object);
        this.j.clear();
        List list = this.j;
        list.addAll(object);
        this.k.clear();
        this.k.addAll(object2);
        object = this.k;
        object2 = d.v.d.i.f.a.a;
        object.forEach(object2);
        object = this.j;
        object2 = d.v.d.i.f.b.a;
        object.forEach(object2);
        object = new StringBuilder();
        ((StringBuilder)object).append("setSupportAll mT=");
        object2 = this.a;
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.i;
        object2 = this.a;
        boolean bl2 = object.contains(object2);
        if (!bl2) {
            object = this.k;
            object2 = null;
            this.a = object = object.get(0);
        }
    }

    public void B() {
        Object e10 = this.k.get(1);
        super.set(e10);
    }

    public void b() {
        super.b();
        this.h = null;
    }

    public List n() {
        return this.i;
    }

    public List o() {
        return this.k;
    }

    public List p() {
        return this.j;
    }

    public boolean r() {
        List list = this.k;
        Object object = this.a;
        return list.contains(object);
    }

    public boolean s() {
        List list = this.j;
        Object object = this.a;
        return list.contains(object);
    }

    /*
     * WARNING - void declaration
     */
    public boolean t() {
        void var3_6;
        List list = this.k;
        Object object = this.a;
        int bl2 = list.indexOf(object);
        object = new StringBuilder();
        String string2 = "is normal index=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        if (bl2 == 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            list = null;
        }
        return (boolean)var3_6;
    }

    public boolean u() {
        int n10;
        List list = this.k;
        int n11 = list.size();
        if (n11 <= (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean v() {
        int n10;
        List list = this.k;
        Object object = this.a;
        int n11 = list.indexOf(object);
        if (n11 != (n10 = 1)) {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public void y(Integer n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("preview ID set integer=");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(",last ID=");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = n10.equals(object);
        if (bl2) {
            d.v.d.h.f.a("id is not change , return");
            return;
        }
        object = this.i;
        bl2 = object.contains(n10);
        if (!bl2) {
            d.v.d.h.f.a("current is not support id , return");
            return;
        }
        super.set(n10);
        bl2 = this.v();
        if (bl2) {
            return;
        }
        object = this.h.getApplicationContext();
        int n11 = n10;
        d.v.d.h.d.e((Context)object, n11);
    }

    public void z() {
        Object e10 = this.k.get(0);
        super.set(e10);
    }
}

