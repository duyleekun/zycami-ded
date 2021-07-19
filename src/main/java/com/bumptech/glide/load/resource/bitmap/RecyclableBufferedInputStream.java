/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream$InvalidMarkException;
import d.c.a.o.k.x.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream
extends FilterInputStream {
    private volatile byte[] a;
    private int b;
    private int c;
    private int d = -1;
    private int e;
    private final b f;

    public RecyclableBufferedInputStream(InputStream inputStream, b b10) {
        this(inputStream, b10, 65536);
    }

    public RecyclableBufferedInputStream(InputStream object, b b10, int n10) {
        super((InputStream)object);
        this.f = b10;
        object = (byte[])b10.c(n10, byte[].class);
        this.a = (byte[])object;
    }

    private static IOException B() {
        IOException iOException = new IOException("BufferedInputStream is closed");
        throw iOException;
    }

    private int a(InputStream inputStream, byte[] byArray) {
        int n10;
        int n11;
        int n12 = this.d;
        int n13 = -1;
        if (n12 != n13 && (n11 = this.e - n12) < (n10 = this.c)) {
            if (n12 == 0 && n10 > (n13 = byArray.length) && (n13 = this.b) == (n11 = byArray.length)) {
                n12 = byArray.length * 2;
                if (n12 <= n10) {
                    n10 = n12;
                }
                byte[] byArray2 = (byte[])this.f.c(n10, byte[].class);
                n13 = byArray.length;
                System.arraycopy(byArray, 0, byArray2, 0, n13);
                this.a = byArray2;
                b b10 = this.f;
                b10.put(byArray);
                byArray = byArray2;
            } else if (n12 > 0) {
                n13 = byArray.length - n12;
                System.arraycopy(byArray, n12, byArray, 0, n13);
            }
            n12 = this.e;
            n13 = this.d;
            this.e = n12 -= n13;
            this.d = 0;
            this.b = 0;
            n13 = byArray.length - n12;
            int n14 = inputStream.read(byArray, n12, n13);
            int n15 = this.e;
            if (n14 > 0) {
                n15 += n14;
            }
            this.b = n15;
            return n14;
        }
        int n16 = inputStream.read(byArray);
        if (n16 > 0) {
            this.d = n13;
            this.e = 0;
            this.b = n16;
        }
        return n16;
    }

    public int available() {
        synchronized (this) {
            Object object;
            block9: {
                object = this.in;
                byte[] byArray = this.a;
                if (byArray == null || object == null) break block9;
                int n10 = this.b;
                int n11 = this.e;
                n10 -= n11;
                int n12 = ((InputStream)object).available();
                return n10 += n12;
            }
            object = RecyclableBufferedInputStream.B();
            throw object;
        }
    }

    public void close() {
        Object object = this.a;
        if (object != null) {
            object = this.f;
            byte[] byArray = this.a;
            object.put(byArray);
            this.a = null;
        }
        object = this.in;
        this.in = null;
        if (object != null) {
            object.close();
        }
    }

    public void h() {
        synchronized (this) {
            byte[] byArray = this.a;
            int n10 = byArray.length;
            this.c = n10;
            return;
        }
    }

    public void mark(int n10) {
        synchronized (this) {
            int n11 = this.c;
            n10 = Math.max(n11, n10);
            this.c = n10;
            n10 = this.e;
            this.d = n10;
            return;
        }
    }

    public boolean markSupported() {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void q() {
        synchronized (this) {
            Object object = this.a;
            if (object != null) {
                object = this.f;
                byte[] byArray = this.a;
                object.put(byArray);
                object = null;
                this.a = null;
            }
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read() {
        synchronized (this) {
            byte[] byArray = this.a;
            Object object = this.in;
            if (byArray != null && object != null) {
                void var1_4;
                byte[] byArray2;
                int n10;
                int n11 = this.e;
                int n12 = this.b;
                int n13 = -1;
                if (n11 >= n12 && (n10 = this.a((InputStream)object, byArray)) == n13) {
                    return n13;
                }
                object = this.a;
                if (byArray != object && (byArray2 = this.a) == null) {
                    IOException iOException = RecyclableBufferedInputStream.B();
                    throw iOException;
                }
                n10 = this.b;
                n11 = this.e;
                if ((n10 -= n11) <= 0) return n13;
                this.e = n10 = n11 + 1;
                return var1_4[n11] & 0xFF;
            }
            IOException iOException = RecyclableBufferedInputStream.B();
            throw iOException;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read(byte[] object, int n10, int n11) {
        synchronized (this) {
            void var2_5;
            int n12;
            int n13;
            int n14;
            InputStream inputStream;
            int n15;
            byte[] byArray;
            block25: {
                byArray = this.a;
                if (byArray == null) {
                    IOException iOException = RecyclableBufferedInputStream.B();
                    throw iOException;
                }
                if (n15 == 0) {
                    return 0;
                }
                inputStream = this.in;
                if (inputStream == null) {
                    IOException iOException = RecyclableBufferedInputStream.B();
                    throw iOException;
                }
                n14 = this.e;
                n13 = this.b;
                if (n14 < n13) {
                    n12 = n13 - n14;
                    n13 = n12 >= n15 ? n15 : (n13 -= n14);
                    System.arraycopy(byArray, n14, object, (int)var2_5, n13);
                    this.e = n14 = this.e + n13;
                    if (n13 == n15) return n13;
                    n14 = inputStream.available();
                    if (n14 != 0) {
                        var2_5 += n13;
                        n14 = n15 - n13;
                        break block25;
                    } else {
                        return n13;
                    }
                }
                n14 = n15;
            }
            while (true) {
                if ((n13 = this.d) == (n12 = -1) && n14 >= (n13 = byArray.length)) {
                    n13 = inputStream.read((byte[])object, (int)var2_5, n14);
                    if (n13 == n12) {
                        if (n14 != n15) return (int)(n15 - n14);
                        return n12;
                    }
                } else {
                    n13 = this.a(inputStream, byArray);
                    if (n13 == n12) {
                        if (n14 != n15) return (int)(n15 - n14);
                        return n12;
                    }
                    byte[] byArray2 = this.a;
                    if (byArray != byArray2 && (byArray = this.a) == null) {
                        IOException iOException = RecyclableBufferedInputStream.B();
                        throw iOException;
                    }
                    n13 = this.b;
                    n12 = this.e;
                    int n16 = n13 - n12;
                    n13 = n16 >= n14 ? n14 : (n13 -= n12);
                    System.arraycopy(byArray, n12, object, (int)var2_5, n13);
                    this.e = n12 = this.e + n13;
                }
                if ((n14 -= n13) == 0) {
                    return n15;
                }
                n12 = inputStream.available();
                if (n12 == 0) {
                    return n15 -= n14;
                }
                var2_5 += n13;
            }
        }
    }

    public void reset() {
        synchronized (this) {
            block13: {
                block14: {
                    byte[] byArray = this.a;
                    if (byArray == null) break block13;
                    int n10 = -1;
                    int n11 = this.d;
                    if (n10 == n11) break block14;
                    this.e = n11;
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "Mark has been invalidated, pos: ";
                stringBuilder.append(string2);
                int n12 = this.e;
                stringBuilder.append(n12);
                string2 = " markLimit: ";
                stringBuilder.append(string2);
                n12 = this.c;
                stringBuilder.append(n12);
                String string3 = stringBuilder.toString();
                RecyclableBufferedInputStream$InvalidMarkException recyclableBufferedInputStream$InvalidMarkException = new RecyclableBufferedInputStream$InvalidMarkException(string3);
                throw recyclableBufferedInputStream$InvalidMarkException;
            }
            String string4 = "Stream is closed";
            IOException iOException = new IOException(string4);
            throw iOException;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long skip(long l10) {
        synchronized (this) {
            long l11;
            long l12 = 1L;
            long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (l13 < 0) {
                return 0L;
            }
            byte[] byArray = this.a;
            if (byArray == null) {
                IOException iOException = RecyclableBufferedInputStream.B();
                throw iOException;
            }
            InputStream inputStream = this.in;
            if (inputStream == null) {
                IOException iOException = RecyclableBufferedInputStream.B();
                throw iOException;
            }
            int n10 = this.b;
            int n11 = this.e;
            long l14 = n10 - n11;
            long l15 = l14 - l10;
            Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object >= 0) {
                l12 = (long)n11 + l10;
                l13 = (int)l12;
                this.e = (int)l13;
                return l10;
            }
            l14 = n10;
            long l16 = n11;
            l14 -= l16;
            this.e = n10;
            n10 = this.d;
            n11 = -1;
            if (n10 != n11 && (n10 = (int)((l11 = l10 - (l16 = (long)this.c)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) <= 0) {
                l13 = this.a(inputStream, byArray);
                if (l13 == n11) {
                    return l14;
                }
                l13 = this.b;
                int n12 = this.e;
                long l17 = l13 - n12;
                l16 = l10 - l14;
                long l18 = l17 - l16;
                n10 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
                if (n10 >= 0) {
                    l12 = (long)n12 + l10 - l14;
                    l13 = (int)l12;
                    this.e = (int)l13;
                    return l10;
                }
                l10 = l13;
                l14 += l10;
                l10 = n12;
                this.e = (int)l13;
                return l14 -= l10;
            }
            l10 -= l14;
            l10 = inputStream.skip(l10);
            return l14 += l10;
        }
    }
}

