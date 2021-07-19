/*
 * Decompiled with CFR 0.151.
 */
package okio;

import f.h2.t.f0;
import f.x1.n;
import h.i0;
import h.j;
import h.m;
import h.q0.e;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;

public final class SegmentedByteString
extends ByteString {
    private final transient byte[][] c;
    private final transient int[] d;

    public SegmentedByteString(byte[][] byArray, int[] nArray) {
        f0.p(byArray, "segments");
        f0.p(nArray, "directory");
        byte[] byArray2 = ByteString.EMPTY.getData$okio();
        super(byArray2);
        this.c = byArray;
        this.d = nArray;
    }

    private final ByteString a() {
        byte[] byArray = this.toByteArray();
        ByteString byteString = new ByteString(byArray);
        return byteString;
    }

    private final Object writeReplace() {
        ByteString byteString = this.a();
        Objects.requireNonNull(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(this.toByteArray()).asReadOnlyBuffer();
        f0.o(byteBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return byteBuffer;
    }

    public String base64() {
        return this.a().base64();
    }

    public String base64Url() {
        return this.a().base64Url();
    }

    public ByteString digest$okio(String object) {
        f0.p(object, "algorithm");
        object = MessageDigest.getInstance((String)object);
        Object object2 = this.getSegments$okio();
        int n10 = ((byte[][])object2).length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int[] nArray = this.getDirectory$okio();
            int n12 = n10 + i10;
            int n13 = nArray[n12];
            int[] nArray2 = this.getDirectory$okio();
            n12 = nArray2[i10];
            byte[] byArray = this.getSegments$okio()[i10];
            n11 = n12 - n11;
            ((MessageDigest)object).update(byArray, n13, n11);
            n11 = n12;
        }
        object2 = new ByteString;
        object = ((MessageDigest)object).digest();
        f0.o(object, "digest.digest()");
        object2((byte[])object);
        return object2;
    }

    public boolean equals(Object object) {
        boolean bl2;
        int n10;
        int n11;
        boolean bl3 = true;
        if (!(object == this || (n11 = object instanceof ByteString) != 0 && (n11 = ((ByteString)(object = (ByteString)object)).size()) == (n10 = this.size()) && (bl2 = this.rangeEquals(0, (ByteString)object, 0, n11 = this.size())))) {
            bl3 = false;
        }
        return bl3;
    }

    public final int[] getDirectory$okio() {
        return this.d;
    }

    public final byte[][] getSegments$okio() {
        return this.c;
    }

    public int getSize$okio() {
        int[] nArray = this.getDirectory$okio();
        int n10 = this.getSegments$okio().length + -1;
        return nArray[n10];
    }

    public int hashCode() {
        int n10 = this.getHashCode$okio();
        if (n10 == 0) {
            byte[][] byArray = this.getSegments$okio();
            n10 = byArray.length;
            int n11 = 1;
            int n12 = 0;
            for (int i10 = 0; i10 < n10; ++i10) {
                int[] nArray = this.getDirectory$okio();
                int n13 = n10 + i10;
                int n14 = nArray[n13];
                int[] nArray2 = this.getDirectory$okio();
                n13 = nArray2[i10];
                byte[] byArray2 = this.getSegments$okio()[i10];
                n12 = n13 - n12 + n14;
                while (n14 < n12) {
                    n11 *= 31;
                    byte by2 = byArray2[n14];
                    n11 += by2;
                    ++n14;
                }
                n12 = n13;
            }
            this.setHashCode$okio(n11);
            n10 = n11;
        }
        return n10;
    }

    public String hex() {
        return this.a().hex();
    }

    public ByteString hmac$okio(String object, ByteString object2) {
        f0.p(object, "algorithm");
        Object object3 = "key";
        f0.p(object2, (String)object3);
        object3 = Mac.getInstance((String)object);
        object2 = ((ByteString)object2).toByteArray();
        SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])object2, (String)object);
        ((Mac)object3).init(secretKeySpec);
        object = this.getSegments$okio();
        int n10 = ((Object)object).length;
        object2 = null;
        int n11 = 0;
        secretKeySpec = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int[] nArray = this.getDirectory$okio();
            int n12 = n10 + i10;
            int n13 = nArray[n12];
            int[] nArray2 = this.getDirectory$okio();
            n12 = nArray2[i10];
            Object object4 = this.getSegments$okio();
            object4 = object4[i10];
            n11 = n12 - n11;
            ((Mac)object3).update((byte[])object4, n13, n11);
            n11 = n12;
            continue;
        }
        try {
            object2 = ((Mac)object3).doFinal();
            object3 = "mac.doFinal()";
        }
        catch (InvalidKeyException invalidKeyException) {
            object2 = new IllegalArgumentException(invalidKeyException);
            throw object2;
        }
        f0.o(object2, (String)object3);
        object = new ByteString((byte[])object2);
        return object;
    }

    public int indexOf(byte[] byArray, int n10) {
        f0.p(byArray, "other");
        return this.a().indexOf(byArray, n10);
    }

    public byte[] internalArray$okio() {
        return this.toByteArray();
    }

    public byte internalGet$okio(int n10) {
        int n11;
        Object[] objectArray = this.getDirectory$okio();
        Object object = this.getSegments$okio();
        Object object2 = ((byte[][])object).length + -1;
        long l10 = objectArray[object2];
        long l11 = n10;
        long l12 = 1L;
        j.e(l10, l11, l12);
        int n12 = e.n(this, n10);
        if (n12 == 0) {
            object2 = 0;
            object = null;
        } else {
            object = this.getDirectory$okio();
            n11 = n12 + -1;
            object2 = object[n11];
        }
        int[] nArray = this.getDirectory$okio();
        int n13 = this.getSegments$okio().length + n12;
        n11 = nArray[n13];
        objectArray = this.getSegments$okio()[n12];
        n10 = n10 - object2 + n11;
        return objectArray[n10];
    }

    public int lastIndexOf(byte[] byArray, int n10) {
        f0.p(byArray, "other");
        return this.a().lastIndexOf(byArray, n10);
    }

    public boolean rangeEquals(int n10, ByteString byteString, int n11, int n12) {
        boolean bl2;
        block5: {
            int n13;
            f0.p(byteString, "other");
            bl2 = false;
            if (n10 >= 0 && n10 <= (n13 = this.size() - n12)) {
                n12 += n10;
                n13 = e.n(this, n10);
                while (n10 < n12) {
                    int n14;
                    Object[] objectArray;
                    int n15;
                    if (n13 == 0) {
                        n15 = 0;
                        objectArray = null;
                    } else {
                        objectArray = this.getDirectory$okio();
                        n14 = n13 + -1;
                        n15 = objectArray[n14];
                    }
                    int[] nArray = this.getDirectory$okio();
                    n14 = nArray[n13] - n15;
                    int[] nArray2 = this.getDirectory$okio();
                    byte[][] byArray = this.getSegments$okio();
                    int n16 = byArray.length + n13;
                    int n17 = nArray2[n16];
                    n14 += n15;
                    n14 = Math.min(n12, n14) - n10;
                    n15 = n10 - n15;
                    n17 += n15;
                    objectArray = this.getSegments$okio()[n13];
                    n15 = (int)(byteString.rangeEquals(n11, (byte[])objectArray, n17, n14) ? 1 : 0);
                    if (n15 != 0) {
                        n11 += n14;
                        n10 += n14;
                        ++n13;
                        continue;
                    }
                    break block5;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    public boolean rangeEquals(int n10, byte[] byArray, int n11, int n12) {
        boolean bl2;
        block5: {
            int n13;
            f0.p(byArray, "other");
            bl2 = false;
            if (n10 >= 0 && n10 <= (n13 = this.size() - n12) && n11 >= 0 && n11 <= (n13 = byArray.length - n12)) {
                n12 += n10;
                n13 = e.n(this, n10);
                while (n10 < n12) {
                    int n14;
                    Object[] objectArray;
                    int n15;
                    if (n13 == 0) {
                        n15 = 0;
                        objectArray = null;
                    } else {
                        objectArray = this.getDirectory$okio();
                        n14 = n13 + -1;
                        n15 = objectArray[n14];
                    }
                    int[] nArray = this.getDirectory$okio();
                    n14 = nArray[n13] - n15;
                    int[] nArray2 = this.getDirectory$okio();
                    byte[][] byArray2 = this.getSegments$okio();
                    int n16 = byArray2.length + n13;
                    int n17 = nArray2[n16];
                    n14 += n15;
                    n14 = Math.min(n12, n14) - n10;
                    n15 = n10 - n15;
                    n17 += n15;
                    objectArray = this.getSegments$okio()[n13];
                    n15 = (int)(j.d((byte[])objectArray, n17, byArray, n11, n14) ? 1 : 0);
                    if (n15 != 0) {
                        n11 += n14;
                        n10 += n14;
                        ++n13;
                        continue;
                    }
                    break block5;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    public String string(Charset charset) {
        f0.p(charset, "charset");
        return this.a().string(charset);
    }

    public ByteString substring(int n10, int n11) {
        int n12 = 0;
        StringBuilder stringBuilder = null;
        int n13 = 1;
        int n14 = n10 >= 0 ? n13 : 0;
        if (n14 != 0) {
            n14 = this.size();
            n14 = n11 <= n14 ? n13 : 0;
            String string2 = "endIndex=";
            if (n14 != 0) {
                byte[][] byArray;
                int n15;
                n14 = n11 - n10;
                if (n14 >= 0) {
                    n15 = n13;
                } else {
                    n15 = 0;
                    byArray = null;
                }
                if (n15 != 0) {
                    ByteString byteString;
                    int n16;
                    if (n10 == 0 && n11 == (n16 = this.size())) {
                        byteString = this;
                    } else if (n10 == n11) {
                        byteString = ByteString.EMPTY;
                    } else {
                        n16 = e.n(this, n10);
                        n11 -= n13;
                        n11 = e.n(this, n11);
                        byArray = this.getSegments$okio();
                        int n17 = n11 + 1;
                        byArray = (byte[][])n.M1((Object[])byArray, n16, n17);
                        n17 = byArray.length * 2;
                        int[] nArray = new int[n17];
                        if (n16 <= n11) {
                            int n18 = 0;
                            int n19 = n16;
                            while (true) {
                                int n20;
                                int[] nArray2 = this.getDirectory$okio();
                                nArray[n18] = n20 = Math.min(nArray2[n19] - n10, n14);
                                n20 = n18 + 1;
                                int n21 = byArray.length;
                                n18 += n21;
                                int[] nArray3 = this.getDirectory$okio();
                                byte[][] byArray2 = this.getSegments$okio();
                                int n22 = byArray2.length + n19;
                                nArray[n18] = n21 = nArray3[n22];
                                if (n19 == n11) break;
                                ++n19;
                                n18 = n20;
                            }
                        }
                        if (n16 != 0) {
                            int[] nArray4 = this.getDirectory$okio();
                            n12 = nArray4[n16 -= n13];
                        }
                        n11 = byArray.length;
                        n13 = nArray[n11];
                        nArray[n11] = n13 += (n10 -= n12);
                        byteString = new SegmentedByteString(byArray, nArray);
                    }
                    return byteString;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(n11);
                stringBuilder.append(" < beginIndex=");
                stringBuilder.append(n10);
                String string3 = stringBuilder.toString();
                string3 = string3.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
                throw illegalArgumentException;
            }
            CharSequence charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n11);
            ((StringBuilder)charSequence).append(" > length(");
            n11 = this.size();
            ((StringBuilder)charSequence).append(n11);
            ((StringBuilder)charSequence).append(')');
            charSequence = ((StringBuilder)charSequence).toString();
            charSequence = ((Object)charSequence).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        Serializable serializable = new StringBuilder();
        serializable.append("beginIndex=");
        serializable.append(n10);
        serializable.append(" < 0");
        String string4 = serializable.toString();
        string4 = string4.toString();
        serializable = new IllegalArgumentException(string4);
        throw serializable;
    }

    public ByteString toAsciiLowercase() {
        return this.a().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return this.a().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        int n10 = this.size();
        byte[] byArray = new byte[n10];
        byte[][] byArray2 = this.getSegments$okio();
        int n11 = byArray2.length;
        int n12 = 0;
        int n13 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            int[] nArray = this.getDirectory$okio();
            int n14 = n11 + i10;
            int n15 = nArray[n14];
            int[] nArray2 = this.getDirectory$okio();
            n14 = nArray2[i10];
            byte[] byArray3 = this.getSegments$okio()[i10];
            n12 = n14 - n12;
            int n16 = n15 + n12;
            n.W0(byArray3, byArray, n13, n15, n16);
            n13 += n12;
            n12 = n14;
        }
        return byArray;
    }

    public String toString() {
        return this.a().toString();
    }

    public void write(OutputStream outputStream) {
        f0.p(outputStream, "out");
        byte[][] byArray = this.getSegments$okio();
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int[] nArray = this.getDirectory$okio();
            int n12 = n10 + i10;
            int n13 = nArray[n12];
            int[] nArray2 = this.getDirectory$okio();
            n12 = nArray2[i10];
            byte[] byArray2 = this.getSegments$okio()[i10];
            n11 = n12 - n11;
            outputStream.write(byArray2, n13, n11);
            n11 = n12;
        }
    }

    public void write$okio(m m10, int n10, int n11) {
        String string2 = "buffer";
        f0.p(m10, string2);
        n11 += n10;
        int n12 = e.n(this, n10);
        while (n10 < n11) {
            int n13;
            Object object;
            int n14;
            if (n12 == 0) {
                n14 = 0;
                object = null;
            } else {
                object = this.getDirectory$okio();
                n13 = n12 + -1;
                n14 = object[n13];
            }
            int[] nArray = this.getDirectory$okio();
            n13 = nArray[n12] - n14;
            Object object2 = this.getDirectory$okio();
            int n15 = this.getSegments$okio().length + n12;
            int n16 = object2[n15];
            n13 += n14;
            n13 = Math.min(n11, n13) - n10;
            n14 = n10 - n14;
            int n17 = n16 + n14;
            byte[] byArray = this.getSegments$okio()[n12];
            object = new i0;
            int n18 = n17 + n13;
            boolean bl2 = true;
            object(byArray, n17, n18, bl2, false);
            object2 = m10.a;
            if (object2 == null) {
                object.g = object;
                object.f = object;
                m10.a = object;
            } else {
                f0.m(object2);
                object2 = ((i0)object2).g;
                f0.m(object2);
                ((i0)object2).c((i0)object);
            }
            n10 += n13;
            ++n12;
        }
        long l10 = m10.S0();
        long l11 = this.size();
        m10.O0(l10 += l11);
    }
}

