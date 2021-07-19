/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss;

public class TaskCancelException
extends Exception {
    public TaskCancelException() {
    }

    public TaskCancelException(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ErrorMessage]: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        super(string2);
    }

    public TaskCancelException(Throwable throwable) {
        super(throwable);
    }
}

