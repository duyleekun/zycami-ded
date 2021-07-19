/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.draft.withdraw;

import com.zhiyun.editorsdk.draft.withdraw.LimitQueue;
import com.zhiyun.editorsdk.draft.withdraw.LimitQueue$OnSizeChangeListener;
import d.v.i.b.k.b1;
import d.v.j.e.g.a0;
import java.util.Optional;

public class WithdrawUseCase {
    private static final LimitQueue a;

    static {
        LimitQueue limitQueue;
        a = limitQueue = new LimitQueue(21);
    }

    private long e(long l10) {
        long l11 = 1L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        long l13 = 2;
        if (l12 != false) {
            Object object = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
            l11 = object == false ? l13 : (long)-1;
        }
        return l11;
    }

    public static /* synthetic */ void h(a0 a02, a0 a03) {
        long l10 = a02.b();
        a03.d(l10);
    }

    public boolean a() {
        int n10;
        LimitQueue limitQueue = a;
        int n11 = limitQueue.g();
        if (n11 != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            limitQueue = null;
        }
        return n11 != 0;
    }

    public boolean b() {
        int n10;
        LimitQueue limitQueue = a;
        int n11 = limitQueue.i();
        if (n11 != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            limitQueue = null;
        }
        return n11 != 0;
    }

    public void c() {
        a.a();
    }

    public Optional d() {
        return a.e();
    }

    public Optional f() {
        return a.f();
    }

    public Optional g() {
        return a.h();
    }

    public boolean i() {
        int n10;
        LimitQueue limitQueue = a;
        int n11 = limitQueue.w();
        int n12 = 1;
        if (n11 != 0 && (n10 = limitQueue.w()) != n12) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public void j(a0 a02) {
        Object object = a;
        ((LimitQueue)object).t();
        ((LimitQueue)object).s(a02);
        int n10 = ((LimitQueue)object).d();
        int n11 = 1;
        if (n10 != n11) {
            return;
        }
        object = ((LimitQueue)object).b(0);
        b1 b12 = new b1(a02);
        ((Optional)object).ifPresent(b12);
    }

    public void k(LimitQueue$OnSizeChangeListener limitQueue$OnSizeChangeListener) {
        a.v(limitQueue$OnSizeChangeListener);
    }
}

