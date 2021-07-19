/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.Closure$IClosure1V;
import com.mob.tools.java8.CoworkerThread$Builder3;

public class CoworkerThread$Builder2 {
    private Closure$IClosure1V consumer;
    private Closure$IClosure producer;

    public CoworkerThread$Builder2(Closure$IClosure closure$IClosure, Closure$IClosure1V closure$IClosure1V) {
        this.producer = closure$IClosure;
        this.consumer = closure$IClosure1V;
    }

    public void start() {
        Closure$IClosure closure$IClosure = this.producer;
        Closure$IClosure1V closure$IClosure1V = this.consumer;
        CoworkerThread$Builder3 coworkerThread$Builder3 = new CoworkerThread$Builder3(closure$IClosure, closure$IClosure1V, 5);
        coworkerThread$Builder3.start();
    }

    public CoworkerThread$Builder3 threadCount(int n10) {
        Closure$IClosure closure$IClosure = this.producer;
        Closure$IClosure1V closure$IClosure1V = this.consumer;
        CoworkerThread$Builder3 coworkerThread$Builder3 = new CoworkerThread$Builder3(closure$IClosure, closure$IClosure1V, n10);
        return coworkerThread$Builder3;
    }
}

