/*
 * Decompiled with CFR 0.151.
 */
package okio;

import f.h2.t.f0;
import f.q2.u;
import f.x1.n;
import h.a;
import h.i;
import h.j;
import h.m;
import h.q0.b;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString$a;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ByteString
implements Serializable,
Comparable {
    public static final ByteString$a Companion;
    public static final ByteString EMPTY;
    private static final long serialVersionUID = 1L;
    private transient int a;
    private transient String b;
    private final byte[] data;

    static {
        Object object = new ByteString$a(null);
        Companion = object;
        byte[] byArray = new byte[]{};
        EMPTY = object = new ByteString(byArray);
    }

    public ByteString(byte[] byArray) {
        f0.p(byArray, "data");
        this.data = byArray;
    }

    public static final ByteString decodeBase64(String string2) {
        return Companion.h(string2);
    }

    public static final ByteString decodeHex(String string2) {
        return Companion.i(string2);
    }

    public static final ByteString encodeString(String string2, Charset charset) {
        return Companion.j(string2, charset);
    }

    public static final ByteString encodeUtf8(String string2) {
        return Companion.l(string2);
    }

    public static /* synthetic */ int indexOf$default(ByteString serializable, ByteString byteString, int n10, int n11, Object object) {
        if (object == null) {
            if ((n11 &= 2) != 0) {
                n10 = 0;
            }
            return ((ByteString)serializable).indexOf(byteString, n10);
        }
        serializable = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        throw serializable;
    }

    public static /* synthetic */ int indexOf$default(ByteString serializable, byte[] byArray, int n10, int n11, Object object) {
        if (object == null) {
            if ((n11 &= 2) != 0) {
                n10 = 0;
            }
            return ((ByteString)serializable).indexOf(byArray, n10);
        }
        serializable = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        throw serializable;
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString serializable, ByteString byteString, int n10, int n11, Object object) {
        if (object == null) {
            if ((n11 &= 2) != 0) {
                n10 = ((ByteString)serializable).size();
            }
            return ((ByteString)serializable).lastIndexOf(byteString, n10);
        }
        serializable = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        throw serializable;
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString serializable, byte[] byArray, int n10, int n11, Object object) {
        if (object == null) {
            if ((n11 &= 2) != 0) {
                n10 = ((ByteString)serializable).size();
            }
            return ((ByteString)serializable).lastIndexOf(byArray, n10);
        }
        serializable = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        throw serializable;
    }

    public static final ByteString of(ByteBuffer byteBuffer) {
        return Companion.m(byteBuffer);
    }

    public static final ByteString of(byte ... byArray) {
        return Companion.n(byArray);
    }

    public static final ByteString of(byte[] byArray, int n10, int n11) {
        return Companion.o(byArray, n10, n11);
    }

    public static final ByteString read(InputStream inputStream, int n10) {
        return Companion.q(inputStream, n10);
    }

    private final void readObject(ObjectInputStream object) {
        int n10 = ((ObjectInputStream)object).readInt();
        object = Companion.q((InputStream)object, n10);
        Field field = ByteString.class.getDeclaredField("data");
        f0.o(field, "field");
        field.setAccessible(true);
        object = ((ByteString)object).data;
        field.set(this, object);
    }

    public static /* synthetic */ ByteString substring$default(ByteString serializable, int n10, int n11, int n12, Object object) {
        if (object == null) {
            int n13 = n12 & 1;
            if (n13 != 0) {
                n10 = 0;
            }
            if ((n12 &= 2) != 0) {
                n11 = ((ByteString)serializable).size();
            }
            return ((ByteString)serializable).substring(n10, n11);
        }
        serializable = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        throw serializable;
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) {
        int n10 = this.data.length;
        objectOutputStream.writeInt(n10);
        byte[] byArray = this.data;
        objectOutputStream.write(byArray);
    }

    public final byte -deprecated_getByte(int n10) {
        return this.getByte(n10);
    }

    public final int -deprecated_size() {
        return this.size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        f0.o(byteBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return byteBuffer;
    }

    public String base64() {
        return h.a.c(this.getData$okio(), null, 1, null);
    }

    public String base64Url() {
        byte[] byArray = this.getData$okio();
        byte[] byArray2 = h.a.e();
        return h.a.b(byArray, byArray2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int compareTo(ByteString byteString) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        block1: {
            int n15;
            int n16;
            String string2 = "other";
            f0.p(byteString, string2);
            n14 = this.size();
            n13 = byteString.size();
            int n17 = Math.min(n14, n13);
            n12 = 0;
            int n18 = 0;
            while (true) {
                n11 = -1;
                n10 = 1;
                if (n18 >= n17) break block1;
                n16 = this.getByte(n18) & 0xFF;
                if (n16 != (n15 = byteString.getByte(n18) & 0xFF)) break;
                ++n18;
            }
            if (n16 >= n15) return n10;
            return n11;
        }
        if (n14 == n13) return n12;
        if (n14 >= n13) return n10;
        return n11;
    }

    public ByteString digest$okio(String object) {
        f0.p(object, "algorithm");
        object = MessageDigest.getInstance((String)object);
        byte[] byArray = this.data;
        object = ((MessageDigest)object).digest(byArray);
        f0.o(object, "MessageDigest.getInstance(algorithm).digest(data)");
        ByteString byteString = new ByteString((byte[])object);
        return byteString;
    }

    public final boolean endsWith(ByteString byteString) {
        f0.p(byteString, "suffix");
        int n10 = this.size();
        int n11 = byteString.size();
        n10 -= n11;
        n11 = byteString.size();
        return this.rangeEquals(n10, byteString, 0, n11);
    }

    public final boolean endsWith(byte[] byArray) {
        f0.p(byArray, "suffix");
        int n10 = this.size();
        int n11 = byArray.length;
        n10 -= n11;
        n11 = byArray.length;
        return this.rangeEquals(n10, byArray, 0, n11);
    }

    public boolean equals(Object object) {
        byte[] byArray;
        boolean bl2;
        byte[] byArray2;
        int n10;
        int n11;
        boolean bl3 = true;
        if (!(object == this || (n11 = object instanceof ByteString) != 0 && (n11 = ((ByteString)(object = (ByteString)object)).size()) == (n10 = (byArray2 = this.getData$okio()).length) && (bl2 = ((ByteString)object).rangeEquals(0, byArray = this.getData$okio(), 0, n10 = (byArray2 = this.getData$okio()).length)))) {
            bl3 = false;
        }
        return bl3;
    }

    public final byte getByte(int n10) {
        return this.internalGet$okio(n10);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.a;
    }

    public int getSize$okio() {
        return this.getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.b;
    }

    public int hashCode() {
        int n10 = this.getHashCode$okio();
        if (n10 == 0) {
            byte[] byArray = this.getData$okio();
            n10 = Arrays.hashCode(byArray);
            this.setHashCode$okio(n10);
        }
        return n10;
    }

    public String hex() {
        int n10 = this.getData$okio().length * 2;
        char[] cArray = new char[n10];
        Object object = this.getData$okio();
        int n11 = ((byte[])object).length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            char c10;
            int n13 = object[i10];
            int n14 = n12 + 1;
            char[] cArray2 = h.q0.b.I();
            int n15 = n13 >> 4 & 0xF;
            cArray[n12] = c10 = cArray2[n15];
            n12 = n14 + 1;
            cArray2 = h.q0.b.I();
            n13 &= 0xF;
            cArray[n14] = n13 = cArray2[n13];
        }
        object = new String;
        object(cArray);
        return object;
    }

    public ByteString hmac$okio(String object, ByteString object2) {
        f0.p(object, "algorithm");
        Object object3 = "key";
        f0.p(object2, (String)object3);
        try {
            object3 = Mac.getInstance((String)object);
        }
        catch (InvalidKeyException invalidKeyException) {
            object2 = new IllegalArgumentException(invalidKeyException);
            throw object2;
        }
        object2 = ((ByteString)object2).toByteArray();
        SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])object2, (String)object);
        ((Mac)object3).init(secretKeySpec);
        object2 = this.data;
        object2 = ((Mac)object3).doFinal((byte[])object2);
        object3 = "mac.doFinal(data)";
        f0.o(object2, (String)object3);
        object = new ByteString((byte[])object2);
        return object;
    }

    public ByteString hmacSha1(ByteString byteString) {
        f0.p(byteString, "key");
        return this.hmac$okio("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        f0.p(byteString, "key");
        return this.hmac$okio("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        f0.p(byteString, "key");
        return this.hmac$okio("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return ByteString.indexOf$default(this, byteString, 0, 2, null);
    }

    public final int indexOf(ByteString object, int n10) {
        f0.p(object, "other");
        object = ((ByteString)object).internalArray$okio();
        return this.indexOf((byte[])object, n10);
    }

    public final int indexOf(byte[] byArray) {
        return ByteString.indexOf$default(this, byArray, 0, 2, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int indexOf(byte[] byArray, int n10) {
        int n11;
        byte[] byArray2;
        boolean bl2;
        f0.p(byArray, "other");
        byte[] byArray3 = this.getData$okio();
        int n12 = byArray3.length;
        int n13 = byArray.length;
        n12 -= n13;
        n13 = 0;
        n10 = Math.max(n10, 0);
        if (n10 > n12) return -1;
        while (!(bl2 = j.d(byArray2 = this.getData$okio(), n10, byArray, 0, n11 = byArray.length))) {
            if (n10 == n12) return -1;
            ++n10;
        }
        return n10;
    }

    public byte[] internalArray$okio() {
        return this.getData$okio();
    }

    public byte internalGet$okio(int n10) {
        return this.getData$okio()[n10];
    }

    public final int lastIndexOf(ByteString byteString) {
        return ByteString.lastIndexOf$default(this, byteString, 0, 2, null);
    }

    public final int lastIndexOf(ByteString object, int n10) {
        f0.p(object, "other");
        object = ((ByteString)object).internalArray$okio();
        return this.lastIndexOf((byte[])object, n10);
    }

    public final int lastIndexOf(byte[] byArray) {
        return ByteString.lastIndexOf$default(this, byArray, 0, 2, null);
    }

    public int lastIndexOf(byte[] byArray, int n10) {
        block2: {
            f0.p(byArray, "other");
            byte[] byArray2 = this.getData$okio();
            int n11 = byArray2.length;
            int n12 = byArray.length;
            for (n10 = Math.min(n10, n11 -= n12); n10 >= 0; n10 += -1) {
                byArray2 = this.getData$okio();
                n12 = 0;
                int n13 = byArray.length;
                n11 = (int)(j.d(byArray2, n10, byArray, 0, n13) ? 1 : 0);
                if (n11 == 0) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    public ByteString md5() {
        return this.digest$okio("MD5");
    }

    public boolean rangeEquals(int n10, ByteString byteString, int n11, int n12) {
        f0.p(byteString, "other");
        byte[] byArray = this.getData$okio();
        return byteString.rangeEquals(n11, byArray, n10, n12);
    }

    public boolean rangeEquals(int n10, byte[] byArray, int n11, int n12) {
        int n13;
        Object object = "other";
        f0.p(byArray, (String)object);
        n10 = n10 >= 0 && n10 <= (n13 = ((Object)(object = (Object)this.getData$okio())).length - n12) && n11 >= 0 && n11 <= (n13 = byArray.length - n12) && (n10 = (int)(j.d((byte[])(object = (Object)this.getData$okio()), n10, byArray, n11, n12) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public final void setHashCode$okio(int n10) {
        this.a = n10;
    }

    public final void setUtf8$okio(String string2) {
        this.b = string2;
    }

    public ByteString sha1() {
        return this.digest$okio("SHA-1");
    }

    public ByteString sha256() {
        return this.digest$okio("SHA-256");
    }

    public ByteString sha512() {
        return this.digest$okio("SHA-512");
    }

    public final int size() {
        return this.getSize$okio();
    }

    public final boolean startsWith(ByteString byteString) {
        f0.p(byteString, "prefix");
        int n10 = byteString.size();
        return this.rangeEquals(0, byteString, 0, n10);
    }

    public final boolean startsWith(byte[] byArray) {
        f0.p(byArray, "prefix");
        int n10 = byArray.length;
        return this.rangeEquals(0, byArray, 0, n10);
    }

    public String string(Charset charset) {
        f0.p(charset, "charset");
        byte[] byArray = this.data;
        String string2 = new String(byArray, charset);
        return string2;
    }

    public final ByteString substring() {
        return ByteString.substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int n10) {
        return ByteString.substring$default(this, n10, 0, 2, null);
    }

    public ByteString substring(int n10, int n11) {
        byte[] byArray;
        int n12;
        int n13 = 1;
        byte[] byArray2 = null;
        if (n10 >= 0) {
            n12 = n13;
        } else {
            n12 = 0;
            byArray = null;
        }
        if (n12 != 0) {
            byArray = this.getData$okio();
            n12 = byArray.length;
            if (n11 <= n12) {
                n12 = n13;
            } else {
                n12 = 0;
                byArray = null;
            }
            if (n12 != 0) {
                Object object;
                n12 = n11 - n10;
                if (n12 < 0) {
                    n13 = 0;
                    object = null;
                }
                if (n13 != 0) {
                    if (n10 == 0 && n11 == (n13 = ((Object)(object = (Object)this.getData$okio())).length)) {
                        object = this;
                    } else {
                        byArray2 = this.getData$okio();
                        byte[] byArray3 = n.G1(byArray2, n10, n11);
                        object = new ByteString(byArray3);
                    }
                    return object;
                }
                String string2 = "endIndex < beginIndex".toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                throw illegalArgumentException;
            }
            CharSequence charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("endIndex > length(");
            n11 = this.getData$okio().length;
            ((StringBuilder)charSequence).append(n11);
            ((StringBuilder)charSequence).append(')');
            charSequence = ((StringBuilder)charSequence).toString();
            charSequence = ((Object)charSequence).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        String string3 = "beginIndex < 0".toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public ByteString toAsciiLowercase() {
        ByteString byteString;
        block2: {
            byte[] byArray;
            int n10;
            byteString = null;
            for (int i10 = 0; i10 < (n10 = (byArray = this.getData$okio()).length); ++i10) {
                byte by2;
                byte by3;
                byArray = this.getData$okio();
                n10 = byArray[i10];
                if (n10 < (by3 = (byte)65) || n10 > (by2 = (byte)90)) continue;
                byte[] byArray2 = this.getData$okio();
                int n11 = byArray2.length;
                byArray2 = Arrays.copyOf(byArray2, n11);
                String string2 = "java.util.Arrays.copyOf(this, size)";
                f0.o(byArray2, string2);
                byArray2[i10] = n10 = (int)((byte)(n10 + 32));
                for (n11 = i10 + 1; n11 < (i10 = byArray2.length); ++n11) {
                    i10 = byArray2[n11];
                    if (i10 < by3 || i10 > by2) continue;
                    byArray2[n11] = i10 = (int)((byte)(i10 + 32));
                }
                byteString = new ByteString(byArray2);
                break block2;
            }
            byteString = this;
        }
        return byteString;
    }

    public ByteString toAsciiUppercase() {
        ByteString byteString;
        block2: {
            byte[] byArray;
            int n10;
            byteString = null;
            for (int i10 = 0; i10 < (n10 = (byArray = this.getData$okio()).length); ++i10) {
                byte by2;
                byte by3;
                byArray = this.getData$okio();
                n10 = byArray[i10];
                if (n10 < (by3 = (byte)97) || n10 > (by2 = (byte)122)) continue;
                byte[] byArray2 = this.getData$okio();
                int n11 = byArray2.length;
                byArray2 = Arrays.copyOf(byArray2, n11);
                String string2 = "java.util.Arrays.copyOf(this, size)";
                f0.o(byArray2, string2);
                byArray2[i10] = n10 = (int)((byte)(n10 + -32));
                for (n11 = i10 + 1; n11 < (i10 = byArray2.length); ++n11) {
                    i10 = byArray2[n11];
                    if (i10 < by3 || i10 > by2) continue;
                    byArray2[n11] = i10 = (int)((byte)(i10 + -32));
                }
                byteString = new ByteString(byArray2);
                break block2;
            }
            byteString = this;
        }
        return byteString;
    }

    public byte[] toByteArray() {
        byte[] byArray = this.getData$okio();
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        return byArray;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public String toString() {
        void var1_18;
        byte[] byArray = this.getData$okio();
        int n10 = byArray.length;
        int n11 = 1;
        Object object = null;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            Object var1_2 = null;
        }
        if (n10 != 0) {
            return var1_18;
        }
        byte[] byArray2 = this.getData$okio();
        int n12 = 64;
        n10 = h.q0.b.a(byArray2, n12);
        int n13 = -1;
        String string2 = "\u2026]";
        char c10 = ']';
        String string3 = "[size=";
        if (n10 == n13) {
            void var10_32;
            byte[] byArray3 = this.getData$okio();
            n10 = byArray3.length;
            if (n10 <= n12) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[hex=");
                String string4 = this.hex();
                stringBuilder.append(string4);
                stringBuilder.append(c10);
                String string5 = stringBuilder.toString();
                return var1_18;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            n13 = this.getData$okio().length;
            stringBuilder.append(n13);
            stringBuilder.append(" hex=");
            byte[] byArray4 = this.getData$okio();
            n13 = byArray4.length;
            if (n12 > n13) {
                n11 = 0;
                Object var10_28 = null;
            }
            if (n11 == 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("endIndex > length(");
                n11 = this.getData$okio().length;
                stringBuilder2.append(n11);
                stringBuilder2.append(')');
                String string7 = stringBuilder2.toString();
                string7 = string7.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string7);
                throw illegalArgumentException;
            }
            byte[] byArray5 = this.getData$okio();
            n11 = byArray5.length;
            if (n12 == n11) {
                ByteString byteString = this;
            } else {
                byArray4 = this.getData$okio();
                object = n.G1(byArray4, 0, n12);
                ByteString byteString = new ByteString((byte[])object);
            }
            String string8 = var10_32.hex();
            stringBuilder.append(string8);
            stringBuilder.append(string2);
            String string9 = stringBuilder.toString();
            return var1_18;
        }
        String string10 = this.utf8();
        String string11 = "null cannot be cast to non-null type java.lang.String";
        Objects.requireNonNull(string10, string11);
        String string12 = string10.substring(0, n10);
        f0.o(string12, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        int n14 = 4;
        String string13 = u.g2(string12, "\\", "\\\\", false, n14, null);
        int n15 = 4;
        String string14 = "\n";
        String string15 = "\\n";
        string12 = u.g2(string13, string14, string15, false, n15, null);
        String string16 = "\r";
        String string17 = "\\r";
        object = u.g2(string12, string16, string17, false, n14, null);
        n11 = string10.length();
        if (n10 < n11) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            n11 = this.getData$okio().length;
            stringBuilder.append(n11);
            String string18 = " text=";
            stringBuilder.append(string18);
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            String string19 = stringBuilder.toString();
            return var1_18;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string20 = "[text=";
        stringBuilder.append(string20);
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        String string21 = stringBuilder.toString();
        return var1_18;
    }

    public String utf8() {
        String string2 = this.getUtf8$okio();
        if (string2 == null) {
            string2 = i.c(this.internalArray$okio());
            this.setUtf8$okio(string2);
        }
        return string2;
    }

    public void write(OutputStream outputStream) {
        f0.p(outputStream, "out");
        byte[] byArray = this.data;
        outputStream.write(byArray);
    }

    public void write$okio(m m10, int n10, int n11) {
        f0.p(m10, "buffer");
        h.q0.b.G(this, m10, n10, n11);
    }
}

