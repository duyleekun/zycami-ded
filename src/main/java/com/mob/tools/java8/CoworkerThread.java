/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.CoworkerThread$Builder;

public class CoworkerThread {
    public static CoworkerThread$Builder produceWork(Closure$IClosure closure$IClosure) {
        CoworkerThread$Builder coworkerThread$Builder = new CoworkerThread$Builder(closure$IClosure);
        return coworkerThread$Builder;
    }
}

