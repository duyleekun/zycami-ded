/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.opengl;

import java.io.IOException;

public class d
extends IOException {
    private static final long serialVersionUID = 2723743254380545567L;
    private final int mErrorCode;
    private final String mErrorMessage;

    public d(int n10) {
        this(n10, null);
    }

    public d(int n10, String string2) {
        this.mErrorCode = n10;
        this.mErrorMessage = string2;
    }

    public String getMessage() {
        CharSequence charSequence = this.mErrorMessage;
        String string2 = "EGL error code: ";
        if (charSequence != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            int n10 = this.mErrorCode;
            ((StringBuilder)charSequence).append(n10);
            string2 = this.mErrorMessage;
            ((StringBuilder)charSequence).append(string2);
            return ((StringBuilder)charSequence).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        int n11 = this.mErrorCode;
        ((StringBuilder)charSequence).append(n11);
        return ((StringBuilder)charSequence).toString();
    }
}

