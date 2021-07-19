/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package d.j.d.a;

import android.app.Activity;
import d.j.d.a.d;
import d.j.d.a.f;
import d.j.d.a.g;
import d.j.d.a.h;
import d.j.d.a.i;
import d.j.d.a.j;
import java.util.concurrent.Executor;

public abstract class k {
    public k a(Activity object, f f10) {
        object = new UnsupportedOperationException("addOnCanceledListener is not implemented.");
        throw object;
    }

    public k b(f object) {
        object = new UnsupportedOperationException("addOnCanceledListener is not implemented.");
        throw object;
    }

    public k c(Executor object, f f10) {
        object = new UnsupportedOperationException("addOnCanceledListener is not implemented.");
        throw object;
    }

    public k d(Activity object, g g10) {
        object = new UnsupportedOperationException("addOnCompleteListener is not implemented");
        throw object;
    }

    public k e(g object) {
        object = new UnsupportedOperationException("addOnCompleteListener is not implemented");
        throw object;
    }

    public k f(Executor object, g g10) {
        object = new UnsupportedOperationException("addOnCompleteListener is not implemented");
        throw object;
    }

    public abstract k g(Activity var1, h var2);

    public abstract k h(h var1);

    public abstract k i(Executor var1, h var2);

    public abstract k j(Activity var1, i var2);

    public abstract k k(i var1);

    public abstract k l(Executor var1, i var2);

    public k m(d object) {
        object = new UnsupportedOperationException("continueWith is not implemented");
        throw object;
    }

    public k n(Executor object, d d10) {
        object = new UnsupportedOperationException("continueWith is not implemented");
        throw object;
    }

    public k o(d object) {
        object = new UnsupportedOperationException("continueWithTask is not implemented");
        throw object;
    }

    public k p(Executor object, d d10) {
        object = new UnsupportedOperationException("continueWithTask is not implemented");
        throw object;
    }

    public abstract Exception q();

    public abstract Object r();

    public abstract Object s(Class var1);

    public abstract boolean t();

    public abstract boolean u();

    public abstract boolean v();

    public k w(j object) {
        object = new UnsupportedOperationException("onSuccessTask is not implemented");
        throw object;
    }

    public k x(Executor object, j j10) {
        object = new UnsupportedOperationException("onSuccessTask is not implemented");
        throw object;
    }
}

