/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

public class RunnableEnhance
implements Runnable {
    public static final String TRANCELOGO = " -->";
    private String parentName;
    private Runnable proxy;

    public RunnableEnhance(Runnable runnable) {
        String string2;
        this.parentName = string2 = Thread.currentThread().getName();
        this.proxy = runnable;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void run() {
        this.proxy.run();
    }
}

