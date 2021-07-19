/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure;
import com.mob.tools.java8.Closure$IClosureV;

public final class Closure$1
extends Thread {
    public final /* synthetic */ Closure.IClosureV val$c;

    public Closure$1(Closure.IClosureV iClosureV) {
        this.val$c = iClosureV;
    }

    public void run() {
        Closure.uncheck(this.val$c);
    }
}

