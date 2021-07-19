/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.c.a.u;

import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c
extends FilterInputStream {
    private static final String c = "ContentLengthStream";
    private static final int d = 255;
    private final long a;
    private int b;

    private c(InputStream inputStream, long l10) {
        super(inputStream);
        this.a = l10;
    }

    private static int B(String string2) {
        int n10;
        block3: {
            block4: {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) {
                    try {
                        n10 = Integer.parseInt(string2);
                        break block3;
                    }
                    catch (NumberFormatException numberFormatException) {
                        String string3 = c;
                        boolean bl3 = Log.isLoggable((String)string3, (int)3);
                        if (!bl3) break block4;
                        StringBuilder stringBuilder = new StringBuilder();
                        String string4 = "failed to parse content length header: ";
                        stringBuilder.append(string4);
                        stringBuilder.append(string2);
                        string2 = stringBuilder.toString();
                        Log.d((String)string3, (String)string2, (Throwable)numberFormatException);
                    }
                }
            }
            n10 = -1;
        }
        return n10;
    }

    private int a(int n10) {
        block4: {
            block3: {
                block2: {
                    int n11;
                    if (n10 < 0) break block2;
                    this.b = n11 = this.b + n10;
                    break block3;
                }
                long l10 = this.a;
                int n12 = this.b;
                long l11 = n12;
                long l12 = (l10 -= l11) - (l11 = 0L);
                Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object > 0) break block4;
            }
            return n10;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Failed to read all expected data, expected: ");
        long l13 = this.a;
        charSequence.append(l13);
        charSequence.append(", but read: ");
        int n13 = this.b;
        charSequence.append(n13);
        charSequence = charSequence.toString();
        IOException iOException = new IOException((String)charSequence);
        throw iOException;
    }

    public static InputStream h(InputStream inputStream, long l10) {
        c c10 = new c(inputStream, l10);
        return c10;
    }

    public static InputStream q(InputStream inputStream, String string2) {
        long l10 = d.c.a.u.c.B(string2);
        return d.c.a.u.c.h(inputStream, l10);
    }

    public int available() {
        synchronized (this) {
            long l10 = this.a;
            int n10 = this.b;
            long l11 = n10;
            l10 -= l11;
            InputStream inputStream = this.in;
            n10 = inputStream.available();
            l11 = n10;
            int n11 = (int)Math.max(l10, l11);
            return n11;
        }
    }

    public int read() {
        synchronized (this) {
            int n10 = super.read();
            int n11 = n10 >= 0 ? 1 : -1;
            this.a(n11);
            return n10;
        }
    }

    public int read(byte[] byArray) {
        int n10 = byArray.length;
        return this.read(byArray, 0, n10);
    }

    public int read(byte[] byArray, int n10, int n11) {
        synchronized (this) {
            int n12 = super.read(byArray, n10, n11);
            n12 = this.a(n12);
            return n12;
        }
    }
}

