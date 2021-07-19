/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.p0.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import d.v.c.p0.p.g$a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class g
extends RecyclerView$Adapter {
    private List a;

    public g() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public g(List list) {
        this();
        this.a(list);
    }

    public g(Object ... objectArray) {
        this();
        this.b(objectArray);
    }

    public g a(List list) {
        int n10;
        if (list != null && (n10 = list.size()) > 0) {
            List list2 = this.a;
            list2.addAll(list);
        }
        return this;
    }

    public g b(Object ... objectArray) {
        int n10;
        if (objectArray != null && (n10 = objectArray.length) > 0) {
            for (Object object : objectArray) {
                List list = this.a;
                list.add(object);
            }
        }
        return this;
    }

    public g c(List object) {
        int n10;
        if (object != null && (n10 = object.size()) > 0) {
            boolean bl2;
            HashSet<List> hashSet = new HashSet<List>();
            List list = this.a;
            hashSet.addAll(list);
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                List list2;
                list = object.next();
                boolean bl3 = hashSet.add(list);
                if (bl3) {
                    list2 = this.a;
                    list2.add(list);
                    continue;
                }
                list2 = this.a;
                int n11 = list2.indexOf(list);
                list2.set(n11, list);
            }
        }
        return this;
    }

    public g d(Object object) {
        if (object != null) {
            List list = this.a;
            list.add(object);
        }
        return this;
    }

    public g e(Object object, int n10) {
        List list;
        int n11;
        if (object != null && n10 >= 0 && n10 < (n11 = (list = this.a).size())) {
            list = this.a;
            list.add(n10, object);
        } else if (object != null && n10 >= 0 && n10 >= (n11 = (list = this.a).size())) {
            List list2 = this.a;
            list2.add(object);
        }
        return this;
    }

    public List f() {
        return this.a;
    }

    public abstract int g(int var1);

    public Object getItem(int n10) {
        List list;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (list = this.a).size())) {
            return this.a.get(n10);
        }
        return null;
    }

    public int getItemCount() {
        return this.a.size();
    }

    public abstract View h(int var1, Context var2);

    public int i(Object object) {
        if (object != null) {
            return this.a.indexOf(object);
        }
        return -1;
    }

    public g$a j(ViewGroup object, int n10) {
        Context context = object.getContext();
        if ((context = this.h(n10, context)) == null) {
            object = LayoutInflater.from((Context)object.getContext());
            n10 = this.g(n10);
            context = object.inflate(n10, null, false);
        }
        object = new g$a((View)context);
        return object;
    }

    public Object k(int n10) {
        List list;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (list = this.a).size())) {
            return this.a.remove(n10);
        }
        return null;
    }

    public g l() {
        this.a.clear();
        return this;
    }

    public g m(List list) {
        if (list != null) {
            List list2 = this.a;
            list2.removeAll(list);
        }
        return this;
    }
}

