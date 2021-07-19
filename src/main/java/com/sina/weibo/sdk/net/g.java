/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.net;

import com.sina.weibo.sdk.net.f;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class g
implements f {
    private int code;
    private InputStream q;

    public g(int n10, InputStream inputStream) {
        this.code = n10;
        this.q = inputStream;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n10 = 1024;
        Object object = new byte[n10];
        while (true) {
            int n11;
            InputStream inputStream;
            int n12;
            if ((n12 = (inputStream = this.q).read((byte[])object)) == (n11 = -1)) {
                object = byteArrayOutputStream.toString();
                byteArrayOutputStream.close();
                return object;
            }
            n11 = 0;
            byteArrayOutputStream.write((byte[])object, 0, n12);
        }
    }
}

