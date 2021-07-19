/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.Closure$IClosure1V;
import com.mob.tools.java8.CoworkerThread$Builder2;

public class CoworkerThread$Builder {
    private Closure$IClosure producer;

    public CoworkerThread$Builder(Closure$IClosure closure$IClosure) {
        this.producer = closure$IClosure;
    }

    public CoworkerThread$Builder2 consumeWork(Closure$IClosure1V closure$IClosure1V) {
        Closure$IClosure closure$IClosure = this.producer;
        CoworkerThread$Builder2 coworkerThread$Builder2 = new CoworkerThread$Builder2(closure$IClosure, closure$IClosure1V);
        return coworkerThread$Builder2;
    }
}

