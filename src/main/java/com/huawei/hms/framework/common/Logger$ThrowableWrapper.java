/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 */
package com.huawei.hms.framework.common;

import com.huawei.hms.framework.common.Logger$1;
import com.huawei.hms.framework.common.StringUtils;
import java.io.IOException;
import java.util.Arrays;
import org.json.JSONException;

public class Logger$ThrowableWrapper
extends Throwable {
    private static final long serialVersionUID = 7129050843360571879L;
    private String message;
    private Throwable ownerThrowable;
    private Throwable thisCause;

    private Logger$ThrowableWrapper(Throwable object) {
        this.ownerThrowable = object;
        StackTraceElement[] stackTraceElementArray = ((Throwable)object).getStackTrace();
        int n10 = object instanceof IOException;
        n10 = n10 == 0 && (n10 = object instanceof JSONException) == 0 ? 20 : 8;
        int n11 = stackTraceElementArray.length;
        if (n11 > n10) {
            stackTraceElementArray = Arrays.copyOf(stackTraceElementArray, n10);
            this.setStackTrace(stackTraceElementArray);
        } else {
            this.setStackTrace(stackTraceElementArray);
        }
        object = StringUtils.anonymizeMessage(((Throwable)object).getMessage());
        this.setMessage((String)object);
    }

    public /* synthetic */ Logger$ThrowableWrapper(Throwable throwable, Logger$1 logger$1) {
        this(throwable);
    }

    public static /* synthetic */ void access$100(Logger$ThrowableWrapper logger$ThrowableWrapper, Throwable throwable) {
        logger$ThrowableWrapper.setCause(throwable);
    }

    private void setCause(Throwable throwable) {
        this.thisCause = throwable;
    }

    public Throwable getCause() {
        Throwable throwable = this.thisCause;
        if (throwable == this) {
            throwable = null;
        }
        return throwable;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String string2) {
        this.message = string2;
    }

    public String toString() {
        Object object = this.ownerThrowable;
        if (object == null) {
            return "";
        }
        object = object.getClass().getName();
        CharSequence charSequence = this.message;
        if (charSequence != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(": ");
            object = ((StringBuilder)charSequence).toString();
            charSequence = this.message;
            boolean bl2 = ((String)charSequence).startsWith((String)object);
            if (bl2) {
                return this.message;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            object = this.message;
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
        }
        return object;
    }
}

