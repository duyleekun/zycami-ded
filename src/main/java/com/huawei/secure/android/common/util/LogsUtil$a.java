/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.secure.android.common.util;

public class LogsUtil$a
extends Throwable {
    private static final long serialVersionUID = 7129050843360571879L;
    private String n;
    private Throwable o;
    private Throwable p;

    public LogsUtil$a(Throwable throwable) {
        this.p = throwable;
    }

    public void b(Throwable throwable) {
        this.o = throwable;
    }

    public Throwable getCause() {
        Throwable throwable = this.o;
        if (throwable == this) {
            throwable = null;
        }
        return throwable;
    }

    public String getMessage() {
        return this.n;
    }

    public void setMessage(String string2) {
        this.n = string2;
    }

    public String toString() {
        Object object = this.p;
        if (object == null) {
            return "";
        }
        object = object.getClass().getName();
        CharSequence charSequence = this.n;
        if (charSequence != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(": ");
            object = ((StringBuilder)charSequence).toString();
            charSequence = this.n;
            boolean bl2 = ((String)charSequence).startsWith((String)object);
            if (bl2) {
                return this.n;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            object = this.n;
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
        }
        return object;
    }
}

