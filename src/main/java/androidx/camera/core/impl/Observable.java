/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable$Observer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public interface Observable {
    public void addObserver(Executor var1, Observable$Observer var2);

    public ListenableFuture fetchData();

    public void removeObserver(Observable$Observer var1);
}

