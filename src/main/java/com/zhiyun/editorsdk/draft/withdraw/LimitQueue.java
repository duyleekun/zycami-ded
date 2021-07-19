/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.draft.withdraw;

import com.zhiyun.editorsdk.draft.withdraw.LimitQueue$OnSizeChangeListener;
import d.v.i.b.k.c;
import d.v.i.b.k.d;
import java.util.LinkedList;
import java.util.Optional;

public class LimitQueue {
    private final int a;
    private int b = -1;
    private final LinkedList c;
    private LimitQueue$OnSizeChangeListener d;

    public LimitQueue(int n10) {
        LinkedList linkedList;
        this.a = n10;
        this.c = linkedList = new LinkedList();
    }

    private /* synthetic */ void o(Object object) {
        int n10;
        this.b = n10 = this.b + 1;
    }

    private /* synthetic */ void q(Object object) {
        int n10;
        this.b = n10 = this.b + -1;
    }

    private void u() {
        LimitQueue$OnSizeChangeListener limitQueue$OnSizeChangeListener = this.d;
        if (limitQueue$OnSizeChangeListener != null) {
            limitQueue$OnSizeChangeListener.a();
        }
    }

    public void a() {
        this.c.clear();
        this.b = -1;
        this.u();
        this.d = null;
    }

    public Optional b(int n10) {
        Optional<Object> optional;
        LinkedList linkedList = this.c;
        int n11 = linkedList.isEmpty();
        if (n11 == 0 && n10 >= 0 && n10 <= (n11 = (linkedList = this.c).size() + -1)) {
            linkedList = this.c;
            optional = Optional.of(linkedList.get(n10));
        } else {
            optional = Optional.empty();
        }
        return optional;
    }

    public Object c() {
        LinkedList linkedList = this.c;
        int n10 = this.b;
        return linkedList.get(n10);
    }

    public int d() {
        return this.b;
    }

    public Optional e() {
        int n10 = this.b;
        return this.b(n10);
    }

    public Optional f() {
        int n10 = this.g();
        Optional optional = this.b(n10);
        c c10 = new c(this);
        optional.ifPresent(c10);
        return optional;
    }

    public int g() {
        int n10 = this.b;
        int n11 = this.w() + -1;
        n10 = n10 == n11 ? -1 : this.b + 1;
        return n10;
    }

    public Optional h() {
        int n10 = this.i();
        Optional optional = this.b(n10);
        d d10 = new d(this);
        optional.ifPresent(d10);
        return optional;
    }

    public int i() {
        int n10 = this.b;
        n10 = n10 == 0 ? -1 : (n10 += -1);
        return n10;
    }

    public Object j() {
        return this.c.getFirst();
    }

    public Optional k() {
        return Optional.of(this.c.getFirst());
    }

    public Object l() {
        return this.c.getLast();
    }

    public Optional m() {
        return Optional.of(this.c.getLast());
    }

    public int n() {
        return this.a;
    }

    public /* synthetic */ void p(Object object) {
        this.o(object);
    }

    public /* synthetic */ void r(Object object) {
        this.q(object);
    }

    public void s(Object object) {
        int n10;
        LinkedList linkedList;
        int n11;
        if (object == null) {
            return;
        }
        int n12 = this.w();
        if (n12 >= (n11 = this.a)) {
            linkedList = this.c;
            linkedList.poll();
        }
        linkedList = this.c;
        linkedList.offer(object);
        this.b = n10 = this.b + 1;
        n12 = this.a;
        if (n10 >= n12) {
            this.b = n12 += -1;
        }
        this.u();
    }

    public void t() {
        int n10;
        LinkedList linkedList = this.c;
        int n11 = linkedList.isEmpty();
        if (n11 == 0 && (n11 = this.g()) != (n10 = -1)) {
            while ((n11 = this.w()) != (n10 = this.b + 1)) {
                linkedList = this.c;
                n10 = this.w() + -1;
                linkedList.remove(n10);
            }
            this.u();
        }
    }

    public void v(LimitQueue$OnSizeChangeListener limitQueue$OnSizeChangeListener) {
        this.d = limitQueue$OnSizeChangeListener;
    }

    public int w() {
        return this.c.size();
    }
}

