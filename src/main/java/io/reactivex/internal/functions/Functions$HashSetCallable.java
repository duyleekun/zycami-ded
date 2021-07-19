/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public final class Functions$HashSetCallable
extends Enum
implements Callable {
    public static final /* enum */ Functions$HashSetCallable INSTANCE;
    private static final /* synthetic */ Functions$HashSetCallable[] a;

    static {
        Functions$HashSetCallable functions$HashSetCallable;
        INSTANCE = functions$HashSetCallable = new Functions$HashSetCallable("INSTANCE", 0);
        Functions$HashSetCallable[] functions$HashSetCallableArray = new Functions$HashSetCallable[]{functions$HashSetCallable};
        a = functions$HashSetCallableArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Functions$HashSetCallable() {
        void var2_-1;
        void var1_-1;
    }

    public static Functions$HashSetCallable valueOf(String string2) {
        return Enum.valueOf(Functions$HashSetCallable.class, string2);
    }

    public static Functions$HashSetCallable[] values() {
        return (Functions$HashSetCallable[])a.clone();
    }

    public Set call() {
        HashSet hashSet = new HashSet();
        return hashSet;
    }
}

