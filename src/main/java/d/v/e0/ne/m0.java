/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class m0 {
    private final ByteArrayOutputStream a;

    public m0() {
        ByteArrayOutputStream byteArrayOutputStream;
        this.a = byteArrayOutputStream = new ByteArrayOutputStream();
    }

    public byte[] a(int n10) {
        synchronized (this) {
            Object object;
            Object object2;
            block10: {
                object2 = this.a;
                object2 = ((ByteArrayOutputStream)object2).toByteArray();
                object = this.a;
                ((ByteArrayOutputStream)object).reset();
                int n11 = this.d();
                if (n11 > n10) break block10;
                return object2;
            }
            object = Arrays.copyOf((byte[])object2, n10);
            int n12 = ((Object)object2).length;
            byte[] byArray = Arrays.copyOfRange((byte[])object2, n10, n12);
            this.c(byArray);
            return object;
        }
    }

    public boolean b() {
        int n10 = this.d();
        n10 = n10 <= 0 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(byte[] byArray) {
        synchronized (this) {
            Throwable throwable2;
            block5: {
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = this.a;
                        byteArrayOutputStream.write(byArray);
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                return;
            }
            throw throwable2;
        }
    }

    public int d() {
        return this.a.size();
    }
}

