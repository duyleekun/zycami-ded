/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

public abstract class FileDownloadListener {
    private boolean isCanceled = false;

    public void cancel() {
        this.isCanceled = true;
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public abstract void onProgress(int var1, long var2, long var4);
}

