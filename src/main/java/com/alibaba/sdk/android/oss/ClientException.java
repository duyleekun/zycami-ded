/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss;

import com.alibaba.sdk.android.oss.common.OSSLog;
import java.io.Serializable;

public class ClientException
extends Exception {
    private Boolean canceled;

    public ClientException() {
        Boolean bl2;
        this.canceled = bl2 = Boolean.FALSE;
    }

    public ClientException(String object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ErrorMessage]: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        super((String)object);
        this.canceled = object = Boolean.FALSE;
    }

    public ClientException(String string2, Throwable throwable) {
        Boolean bl2 = Boolean.FALSE;
        this(string2, throwable, bl2);
    }

    public ClientException(String object, Throwable throwable, Boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ErrorMessage]: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        super((String)object, throwable);
        this.canceled = object = Boolean.FALSE;
        this.canceled = bl2;
        OSSLog.logThrowable2Local(this);
    }

    public ClientException(Throwable serializable) {
        super((Throwable)serializable);
        serializable = Boolean.FALSE;
        this.canceled = serializable;
    }

    public String getMessage() {
        String string2 = super.getMessage();
        Serializable serializable = this.getCause();
        if (serializable != null) {
            serializable = new StringBuilder();
            String string3 = this.getCause().getMessage();
            ((StringBuilder)serializable).append(string3);
            string3 = "\n";
            ((StringBuilder)serializable).append(string3);
            ((StringBuilder)serializable).append(string2);
            string2 = ((StringBuilder)serializable).toString();
        }
        return string2;
    }

    public Boolean isCanceledException() {
        return this.canceled;
    }
}

