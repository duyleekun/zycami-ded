/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer;

import com.zhiyun.protocol.constants.BoxWorkingMode;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.be;
import d.v.e0.ee$b;

public class Stabilizer$d
implements ee$b {
    public final /* synthetic */ Stabilizer a;

    public Stabilizer$d(Stabilizer stabilizer) {
        this.a = stabilizer;
    }

    public void a() {
        be.m().y(true);
    }

    public void b(BoxWorkingMode boxWorkingMode) {
        Stabilizer.K1(this.a, true);
        be.m().o(boxWorkingMode);
    }

    public void c(Integer n10) {
        be.m().n(n10);
    }

    public void d() {
        be.m().y(false);
    }

    public void e(Integer n10) {
        be.m().s(n10);
    }

    public void f(int n10) {
        be.m().v(n10);
    }

    public void g(Integer n10) {
        be.m().x(n10);
    }

    public void h(WorkingMode workingMode) {
        be.m().A(workingMode);
    }

    public void i(Integer n10) {
        be.m().r(n10);
    }

    public void j(int n10, int n11) {
    }
}

