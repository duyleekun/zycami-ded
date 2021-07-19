/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import com.mob.tools.network.BufferedByteArrayOutputStream;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.utils.Data;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;

public class ByteArrayPart
extends HTTPPart {
    private BufferedByteArrayOutputStream buffer;

    public ByteArrayPart append(byte[] byArray) {
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = this.buffer;
        if (bufferedByteArrayOutputStream == null) {
            int n10 = byArray.length;
            this.buffer = bufferedByteArrayOutputStream = new BufferedByteArrayOutputStream(n10);
        }
        this.buffer.write(byArray);
        this.buffer.flush();
        return this;
    }

    public InputStream getInputStream() {
        Closeable closeable;
        int n10;
        Object object = this.buffer;
        byte[] byArray = null;
        if (object == null) {
            byArray = new byte[]{};
            object = new ByteArrayInputStream(byArray);
            return object;
        }
        if ((object = (Object)((BufferedByteArrayOutputStream)object).getBuffer()) != null && (n10 = (closeable = this.buffer).size()) > 0) {
            int n11 = this.buffer.size();
            closeable = new ByteArrayInputStream((byte[])object, 0, n11);
            return closeable;
        }
        byArray = new byte[]{};
        object = new ByteArrayInputStream(byArray);
        return object;
    }

    public long length() {
        long l10;
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = this.buffer;
        if (bufferedByteArrayOutputStream == null) {
            l10 = 0L;
        } else {
            int n10 = bufferedByteArrayOutputStream.size();
            l10 = n10;
        }
        return l10;
    }

    public String toString() {
        Object object = this.buffer;
        if (object == null) {
            return null;
        }
        if ((object = (Object)((BufferedByteArrayOutputStream)object).getBuffer()) == null) {
            return null;
        }
        int n10 = this.buffer.size();
        return Data.byteToHex((byte[])object, 0, n10);
    }
}

