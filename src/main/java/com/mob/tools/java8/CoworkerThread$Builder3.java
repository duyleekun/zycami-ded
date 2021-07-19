/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.Closure$IClosure1V;
import com.mob.tools.java8.CoworkerThread$Builder3$1;

public class CoworkerThread$Builder3 {
    private Closure$IClosure1V consumer;
    private int finished;
    private Closure$IClosure producer;
    private Throwable t;
    private int threadCount;

    public CoworkerThread$Builder3(Closure$IClosure closure$IClosure, Closure$IClosure1V closure$IClosure1V, int n10) {
        this.producer = closure$IClosure;
        this.consumer = closure$IClosure1V;
        this.threadCount = n10;
    }

    public static /* synthetic */ Throwable access$000(CoworkerThread$Builder3 coworkerThread$Builder3) {
        return coworkerThread$Builder3.t;
    }

    public static /* synthetic */ Throwable access$002(CoworkerThread$Builder3 coworkerThread$Builder3, Throwable throwable) {
        coworkerThread$Builder3.t = throwable;
        return throwable;
    }

    public static /* synthetic */ Closure$IClosure access$100(CoworkerThread$Builder3 coworkerThread$Builder3) {
        return coworkerThread$Builder3.producer;
    }

    public static /* synthetic */ Closure$IClosure1V access$200(CoworkerThread$Builder3 coworkerThread$Builder3) {
        return coworkerThread$Builder3.consumer;
    }

    public static /* synthetic */ int access$300(CoworkerThread$Builder3 coworkerThread$Builder3) {
        return coworkerThread$Builder3.finished;
    }

    public static /* synthetic */ int access$308(CoworkerThread$Builder3 coworkerThread$Builder3) {
        int n10;
        int n11 = coworkerThread$Builder3.finished;
        coworkerThread$Builder3.finished = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ int access$400(CoworkerThread$Builder3 coworkerThread$Builder3) {
        return coworkerThread$Builder3.threadCount;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void start() {
        synchronized (this) {
            Object object = this.producer;
            if (object != null && (object = this.consumer) != null) {
                StackTraceElement[] stackTraceElementArray;
                int n10;
                int n11 = 0;
                object = null;
                this.finished = 0;
                StackTraceElement[] stackTraceElementArray2 = null;
                for (int i10 = 0; i10 < (n10 = this.threadCount); ++i10) {
                    stackTraceElementArray = new CoworkerThread$Builder3$1(this);
                    stackTraceElementArray.start();
                }
                this.wait();
                stackTraceElementArray2 = this.t;
                if (stackTraceElementArray2 != null) {
                    stackTraceElementArray2 = Thread.currentThread();
                    stackTraceElementArray2 = stackTraceElementArray2.getStackTrace();
                    stackTraceElementArray = this.t;
                    stackTraceElementArray = stackTraceElementArray.getStackTrace();
                    int n12 = stackTraceElementArray2.length;
                    int n13 = stackTraceElementArray.length;
                    n12 += n13;
                    n13 = 2;
                    StackTraceElement[] stackTraceElementArray3 = new StackTraceElement[n12 -= n13];
                    int n14 = stackTraceElementArray.length;
                    System.arraycopy(stackTraceElementArray, 0, stackTraceElementArray3, 0, n14);
                    n11 = stackTraceElementArray.length;
                    n10 = stackTraceElementArray2.length - n13;
                    System.arraycopy(stackTraceElementArray2, n13, stackTraceElementArray3, n11, n10);
                    object = this.t;
                    ((Throwable)object).setStackTrace(stackTraceElementArray3);
                    object = this.t;
                    throw object;
                }
            }
            return;
        }
    }
}

