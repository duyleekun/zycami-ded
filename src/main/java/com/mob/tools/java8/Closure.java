/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$1;
import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.Closure$IClosureV;
import com.mob.tools.java8.Closure$Result;

public class Closure {
    public static void asyncCall(Closure$IClosureV closure$IClosureV) {
        Closure$1 closure$1 = new Closure$1(closure$IClosureV);
        closure$1.start();
    }

    public static Closure$Result call(Closure$IClosure object) {
        Closure$Result closure$Result = new Closure$Result();
        object = object.call();
        try {
            Closure$Result.access$002(closure$Result, object);
        }
        catch (Throwable throwable) {
            Closure$Result.access$102(closure$Result, throwable);
        }
        return closure$Result;
    }

    public static Closure$Result call(Closure$IClosureV closure$IClosureV) {
        Closure$Result closure$Result = new Closure$Result();
        try {
            closure$IClosureV.call();
        }
        catch (Throwable throwable) {
            Closure$Result.access$102(closure$Result, throwable);
        }
        return closure$Result;
    }

    public static Object uncheck(Closure$IClosure closure$IClosure) {
        try {
            return closure$IClosure.call();
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void uncheck(Closure$IClosureV closure$IClosureV) {
        try {
            closure$IClosureV.call();
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }
}

