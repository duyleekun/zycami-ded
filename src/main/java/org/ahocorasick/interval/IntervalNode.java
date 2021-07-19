/*
 * Decompiled with CFR 0.151.
 */
package org.ahocorasick.interval;

import i.a.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.ahocorasick.interval.IntervalNode$Direction;
import org.ahocorasick.interval.IntervalNode$a;

public class IntervalNode {
    private IntervalNode a = null;
    private IntervalNode b = null;
    private int c;
    private List d;

    public IntervalNode(List object) {
        boolean bl2;
        int n10;
        ArrayList<c> arrayList;
        this.d = arrayList = new ArrayList<c>();
        this.c = n10 = this.e((List)object);
        arrayList = new ArrayList<c>();
        ArrayList<c> arrayList2 = new ArrayList<c>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            int n11;
            c c10 = (c)object.next();
            int n12 = c10.getEnd();
            if (n12 < (n11 = this.c)) {
                arrayList.add(c10);
                continue;
            }
            n12 = c10.getStart();
            if (n12 > (n11 = this.c)) {
                arrayList2.add(c10);
                continue;
            }
            List list = this.d;
            list.add(c10);
        }
        int n13 = arrayList.size();
        if (n13 > 0) {
            this.a = object = new IntervalNode(arrayList);
        }
        if ((n13 = arrayList2.size()) > 0) {
            this.b = object = new IntervalNode(arrayList2);
        }
    }

    public void a(c c10, List list, List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            c c11 = (c)object.next();
            boolean bl3 = c11.equals(c10);
            if (bl3) continue;
            list.add(c11);
        }
    }

    public List b(c c10, IntervalNode$Direction intervalNode$Direction) {
        boolean bl2;
        ArrayList<c> arrayList = new ArrayList<c>();
        Iterator iterator2 = this.d.iterator();
        while (bl2 = iterator2.hasNext()) {
            c c11 = (c)iterator2.next();
            int[] nArray = IntervalNode$a.a;
            int n10 = intervalNode$Direction.ordinal();
            int n11 = nArray[n10];
            if (n11 != (n10 = 1)) {
                n10 = 2;
                if (n11 != n10 || (n11 = c11.getEnd()) < (n10 = c10.getStart())) continue;
                arrayList.add(c11);
                continue;
            }
            n11 = c11.getStart();
            if (n11 > (n10 = c10.getEnd())) continue;
            arrayList.add(c11);
        }
        return arrayList;
    }

    public List c(c c10) {
        IntervalNode$Direction intervalNode$Direction = IntervalNode$Direction.LEFT;
        return this.b(c10, intervalNode$Direction);
    }

    public List d(c c10) {
        IntervalNode$Direction intervalNode$Direction = IntervalNode$Direction.RIGHT;
        return this.b(c10, intervalNode$Direction);
    }

    public int e(List object) {
        int n10;
        int n11;
        object = object.iterator();
        int n12 = n11 = -1;
        int n13 = n11;
        while ((n10 = object.hasNext()) != 0) {
            c c10 = (c)object.next();
            int n14 = c10.getStart();
            n10 = c10.getEnd();
            if (n12 == n11 || n14 < n12) {
                n12 = n14;
            }
            if (n13 != n11 && n10 <= n13) continue;
            n13 = n10;
        }
        return (n12 + n13) / 2;
    }

    public List f(IntervalNode intervalNode, c c10) {
        if (intervalNode != null) {
            return intervalNode.g(c10);
        }
        return Collections.emptyList();
    }

    public List g(c c10) {
        ArrayList arrayList = new ArrayList();
        int n10 = this.c;
        int n11 = c10.getStart();
        if (n10 < n11) {
            Object object = this.b;
            object = this.f((IntervalNode)object, c10);
            this.a(c10, arrayList, (List)object);
            object = this.d(c10);
            this.a(c10, arrayList, (List)object);
        } else {
            n10 = this.c;
            n11 = c10.getEnd();
            if (n10 > n11) {
                Object object = this.a;
                object = this.f((IntervalNode)object, c10);
                this.a(c10, arrayList, (List)object);
                object = this.c(c10);
                this.a(c10, arrayList, (List)object);
            } else {
                Object object = this.d;
                this.a(c10, arrayList, (List)object);
                object = this.a;
                object = this.f((IntervalNode)object, c10);
                this.a(c10, arrayList, (List)object);
                object = this.b;
                object = this.f((IntervalNode)object, c10);
                this.a(c10, arrayList, (List)object);
            }
        }
        return arrayList;
    }
}

