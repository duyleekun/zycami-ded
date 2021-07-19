/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import java.io.Writer;

public class TXCGLSurfaceViewBase$l
extends Writer {
    private StringBuilder a;

    public TXCGLSurfaceViewBase$l() {
        StringBuilder stringBuilder;
        this.a = stringBuilder = new StringBuilder();
    }

    private void a() {
        CharSequence charSequence = this.a;
        int n10 = ((StringBuilder)charSequence).length();
        if (n10 > 0) {
            charSequence = this.a.toString();
            TXCLog.v("TXCGLSurfaceViewBase", (String)charSequence);
            charSequence = this.a;
            int n11 = ((StringBuilder)charSequence).length();
            ((StringBuilder)charSequence).delete(0, n11);
        }
    }

    public void close() {
        this.a();
    }

    public void flush() {
        this.a();
    }

    public void write(char[] cArray, int n10, int n11) {
        for (int i10 = 0; i10 < n11; ++i10) {
            char c10 = n10 + i10;
            char c11 = '\n';
            if ((c10 = cArray[c10]) == c11) {
                this.a();
                continue;
            }
            StringBuilder stringBuilder = this.a;
            stringBuilder.append(c10);
        }
    }
}

