/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.js;
import com.xiaomi.push.jt;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class jp
extends js {
    public InputStream a;
    public OutputStream a = null;

    public jp() {
    }

    public jp(OutputStream outputStream) {
        this.a = outputStream;
    }

    public int a(byte[] object, int n10, int n11) {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            block3: {
                try {
                    int n12 = inputStream.read((byte[])object, n10, n11);
                    if (n12 < 0) break block3;
                    return n12;
                }
                catch (IOException iOException) {
                    jt jt2 = new jt(0, (Throwable)iOException);
                    throw jt2;
                }
            }
            object = new jt;
            object(4);
            throw object;
        }
        object = new jt;
        object(1, "Cannot read from null inputStream");
        throw object;
    }

    public void a(byte[] object, int n10, int n11) {
        OutputStream outputStream = this.a;
        if (outputStream != null) {
            try {
                outputStream.write((byte[])object, n10, n11);
                return;
            }
            catch (IOException iOException) {
                jt jt2 = new jt(0, (Throwable)iOException);
                throw jt2;
            }
        }
        object = new jt;
        object(1, "Cannot write to null outputStream");
        throw object;
    }
}

