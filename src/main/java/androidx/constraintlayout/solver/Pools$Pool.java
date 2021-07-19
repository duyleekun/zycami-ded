/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

public interface Pools$Pool {
    public Object acquire();

    public boolean release(Object var1);

    public void releaseAll(Object[] var1, int var2);
}

