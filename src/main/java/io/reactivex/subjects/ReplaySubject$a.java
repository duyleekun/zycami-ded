/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import io.reactivex.subjects.ReplaySubject$ReplayDisposable;

public interface ReplaySubject$a {
    public void add(Object var1);

    public void addFinal(Object var1);

    public boolean compareAndSet(Object var1, Object var2);

    public Object get();

    public Object getValue();

    public Object[] getValues(Object[] var1);

    public void replay(ReplaySubject.ReplayDisposable var1);

    public int size();

    public void trimHead();
}

