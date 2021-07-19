/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service$1;
import com.google.common.util.concurrent.Service$State$1;
import com.google.common.util.concurrent.Service$State$2;
import com.google.common.util.concurrent.Service$State$3;
import com.google.common.util.concurrent.Service$State$4;
import com.google.common.util.concurrent.Service$State$5;
import com.google.common.util.concurrent.Service$State$6;

public abstract class Service$State
extends Enum {
    private static final /* synthetic */ Service$State[] $VALUES;
    public static final /* enum */ Service$State FAILED;
    public static final /* enum */ Service$State NEW;
    public static final /* enum */ Service$State RUNNING;
    public static final /* enum */ Service$State STARTING;
    public static final /* enum */ Service$State STOPPING;
    public static final /* enum */ Service$State TERMINATED;

    static {
        Service$State$1 service$State$1 = new Service$State$1();
        NEW = service$State$1;
        int n10 = 1;
        Service$State$2 service$State$2 = new Service$State$2();
        STARTING = service$State$2;
        int n11 = 2;
        Service$State$3 service$State$3 = new Service$State$3();
        RUNNING = service$State$3;
        int n12 = 3;
        Service$State$4 service$State$4 = new Service$State$4();
        STOPPING = service$State$4;
        int n13 = 4;
        Service$State$5 service$State$5 = new Service$State$5();
        TERMINATED = service$State$5;
        int n14 = 5;
        Service$State$6 service$State$6 = new Service$State$6();
        FAILED = service$State$6;
        Service$State[] service$StateArray = new Service$State[6];
        service$StateArray[0] = service$State$1;
        service$StateArray[n10] = service$State$2;
        service$StateArray[n11] = service$State$3;
        service$StateArray[n12] = service$State$4;
        service$StateArray[n13] = service$State$5;
        service$StateArray[n14] = service$State$6;
        $VALUES = service$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Service$State() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ Service$State(Service$1 service$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static Service$State valueOf(String string2) {
        return Enum.valueOf(Service$State.class, string2);
    }

    public static Service$State[] values() {
        return (Service$State[])$VALUES.clone();
    }

    public abstract boolean isTerminal();
}

