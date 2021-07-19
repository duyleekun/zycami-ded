/*
 * Decompiled with CFR 0.151.
 */
package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.ReplayRelay$ReplayDisposable;

public interface ReplayRelay$a {
    public void add(Object var1);

    public Object getValue();

    public Object[] getValues(Object[] var1);

    public void replay(ReplayRelay.ReplayDisposable var1);

    public int size();

    public void trimHead();
}

