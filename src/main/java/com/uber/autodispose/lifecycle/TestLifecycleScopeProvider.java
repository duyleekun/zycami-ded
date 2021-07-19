/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$TestLifecycle;
import com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$a;
import d.q.a.h0.d;
import d.q.a.h0.e;
import d.q.a.h0.f;
import d.q.a.h0.g;
import e.a.d1.a;
import e.a.z;

public final class TestLifecycleScopeProvider
implements f {
    private final a b;

    private TestLifecycleScopeProvider(TestLifecycleScopeProvider$TestLifecycle object) {
        if (object == null) {
            object = a.n8();
            this.b = object;
        } else {
            object = a.o8(object);
            this.b = object;
        }
    }

    public static TestLifecycleScopeProvider e() {
        TestLifecycleScopeProvider testLifecycleScopeProvider = new TestLifecycleScopeProvider(null);
        return testLifecycleScopeProvider;
    }

    public static TestLifecycleScopeProvider f(TestLifecycleScopeProvider$TestLifecycle testLifecycleScopeProvider$TestLifecycle) {
        TestLifecycleScopeProvider testLifecycleScopeProvider = new TestLifecycleScopeProvider(testLifecycleScopeProvider$TestLifecycle);
        return testLifecycleScopeProvider;
    }

    public static /* synthetic */ TestLifecycleScopeProvider$TestLifecycle g(TestLifecycleScopeProvider$TestLifecycle object) {
        int[] nArray = TestLifecycleScopeProvider$a.a;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                object = new IllegalStateException("Unknown lifecycle event.");
                throw object;
            }
            object = new LifecycleEndedException();
            throw object;
        }
        return TestLifecycleScopeProvider$TestLifecycle.STOPPED;
    }

    public e.a.g a() {
        return g.c(this);
    }

    public z b() {
        return this.b.j3();
    }

    public e d() {
        return d.a;
    }

    public TestLifecycleScopeProvider$TestLifecycle h() {
        return (TestLifecycleScopeProvider$TestLifecycle)((Object)this.b.p8());
    }

    public void i() {
        a a10 = this.b;
        TestLifecycleScopeProvider$TestLifecycle testLifecycleScopeProvider$TestLifecycle = TestLifecycleScopeProvider$TestLifecycle.STARTED;
        a10.onNext((Object)testLifecycleScopeProvider$TestLifecycle);
    }

    public void j() {
        TestLifecycleScopeProvider$TestLifecycle testLifecycleScopeProvider$TestLifecycle;
        Object object = this.b.p8();
        if (object == (testLifecycleScopeProvider$TestLifecycle = TestLifecycleScopeProvider$TestLifecycle.STARTED)) {
            object = this.b;
            testLifecycleScopeProvider$TestLifecycle = TestLifecycleScopeProvider$TestLifecycle.STOPPED;
            ((a)object).onNext((Object)testLifecycleScopeProvider$TestLifecycle);
            return;
        }
        object = new IllegalStateException("Attempting to stop lifecycle before starting it.");
        throw object;
    }
}

