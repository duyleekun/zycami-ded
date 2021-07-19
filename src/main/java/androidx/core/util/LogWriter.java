/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.core.util;

import android.util.Log;
import java.io.Writer;

public class LogWriter
extends Writer {
    private StringBuilder mBuilder;
    private final String mTag;

    public LogWriter(String string2) {
        StringBuilder stringBuilder;
        this.mBuilder = stringBuilder = new StringBuilder(128);
        this.mTag = string2;
    }

    private void flushBuilder() {
        CharSequence charSequence = this.mBuilder;
        int n10 = ((StringBuilder)charSequence).length();
        if (n10 > 0) {
            charSequence = this.mTag;
            String string2 = this.mBuilder.toString();
            Log.d((String)charSequence, (String)string2);
            charSequence = this.mBuilder;
            string2 = null;
            int n11 = ((StringBuilder)charSequence).length();
            ((StringBuilder)charSequence).delete(0, n11);
        }
    }

    public void close() {
        this.flushBuilder();
    }

    public void flush() {
        this.flushBuilder();
    }

    public void write(char[] cArray, int n10, int n11) {
        for (int i10 = 0; i10 < n11; ++i10) {
            char c10 = n10 + i10;
            char c11 = '\n';
            if ((c10 = cArray[c10]) == c11) {
                this.flushBuilder();
                continue;
            }
            StringBuilder stringBuilder = this.mBuilder;
            stringBuilder.append(c10);
        }
    }
}

