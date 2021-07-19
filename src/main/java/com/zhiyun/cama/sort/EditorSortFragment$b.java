/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.sort;

import androidx.core.util.Pair;
import com.zhiyun.cama.sort.EditorSortFragment;
import d.v.c.q0.d;
import d.v.c.q0.d$a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.a.a;

public class EditorSortFragment$b
extends d$a {
    public int c;
    public List d;
    public final /* synthetic */ EditorSortFragment e;

    public EditorSortFragment$b(EditorSortFragment arrayList) {
        this.e = arrayList;
        super((d)((Object)arrayList));
        this.c = -1;
        this.d = arrayList = new ArrayList();
    }

    private void h(int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("fromIndex:");
        charSequence.append(n10);
        charSequence.append(" toIndex:");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.x((String)charSequence, objectArray);
        EditorSortFragment.B(this.e).T(n10, n11, false);
    }

    public void d() {
        int n10;
        super.d();
        Iterator iterator2 = this.d.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object = (Pair)iterator2.next();
            Integer n11 = (Integer)((Pair)object).first;
            int n12 = n11;
            object = (Integer)((Pair)object).second;
            n10 = (Integer)object;
            this.h(n12, n10);
        }
        EditorSortFragment.y(this.e).h0();
        EditorSortFragment.z(this.e, 256L);
        EditorSortFragment.A(this.e).Z2(0);
    }

    public void i(int n10) {
        this.c = n10;
    }

    public void j(int n10) {
        int n11 = this.c;
        if (n10 != n11) {
            List list = this.d;
            Integer n12 = n11;
            Integer n13 = n10;
            Pair pair = new Pair(n12, n13);
            list.add(pair);
        }
    }
}

