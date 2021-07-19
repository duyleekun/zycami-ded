/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.bb$a;
import java.util.LinkedList;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bb {
    private LinkedList a;

    public bb() {
        LinkedList linkedList;
        this.a = linkedList = new LinkedList();
    }

    public static bb a() {
        return bb$a.a();
    }

    private void a() {
        int n10;
        LinkedList linkedList = this.a;
        int n11 = linkedList.size();
        if (n11 > (n10 = 100)) {
            linkedList = this.a;
            linkedList.removeFirst();
        }
    }

    public int a() {
        synchronized (this) {
            LinkedList linkedList = this.a;
            int n10 = linkedList.size();
            return n10;
        }
    }

    public LinkedList a() {
        synchronized (this) {
            LinkedList linkedList = this.a;
            LinkedList linkedList2 = new LinkedList();
            this.a = linkedList2;
            return linkedList;
        }
    }

    public void a(Object object) {
        synchronized (this) {
            LinkedList linkedList = this.a;
            bb$a bb$a = new bb$a(0, object);
            linkedList.add(bb$a);
            this.a();
            return;
        }
    }
}

