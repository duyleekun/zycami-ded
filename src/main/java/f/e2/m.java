/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.h2.t.f0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public final class m {
    private static final int a = 32;
    private static CharsetDecoder b;
    private static boolean c;
    private static final byte[] d;
    private static final char[] e;
    private static final ByteBuffer f;
    private static final CharBuffer g;
    private static final StringBuilder h;
    public static final m i;

    static {
        Object object = new m();
        i = object;
        int n10 = 32;
        Object object2 = new byte[n10];
        d = object2;
        object = new char[n10];
        e = (char[])object;
        object2 = ByteBuffer.wrap(object2);
        f0.o(object2, "ByteBuffer.wrap(bytes)");
        f = object2;
        object = CharBuffer.wrap((char[])object);
        f0.o(object, "CharBuffer.wrap(chars)");
        g = object;
        h = object = new StringBuilder();
    }

    private m() {
    }

    public static final /* synthetic */ CharsetDecoder a(m object) {
        object = b;
        if (object == null) {
            String string2 = "decoder";
            f0.S(string2);
        }
        return object;
    }

    public static final /* synthetic */ void b(m m10, CharsetDecoder charsetDecoder) {
        b = charsetDecoder;
    }

    private final int c() {
        ByteBuffer byteBuffer = f;
        byteBuffer.compact();
        int n10 = byteBuffer.position();
        byteBuffer.position(0);
        return n10;
    }

    private final int d(boolean bl2) {
        while (true) {
            Object object;
            Object object2;
            if ((object2 = b) == null) {
                object = "decoder";
                f0.S((String)object);
            }
            object = f;
            CharBuffer charBuffer = g;
            object2 = ((CharsetDecoder)object2).decode((ByteBuffer)object, charBuffer, bl2);
            object = "decoder.decode(byteBuf, charBuf, endOfInput)";
            f0.o(object2, (String)object);
            int n10 = ((CoderResult)object2).isError();
            if (n10 != 0) {
                this.g();
                ((CoderResult)object2).throwException();
            }
            n10 = charBuffer.position();
            char c10 = ((CoderResult)object2).isOverflow();
            if (c10 == '\u0000') {
                return n10;
            }
            object2 = h;
            char[] cArray = e;
            ((StringBuilder)object2).append(cArray, 0, n10 += -1);
            charBuffer.position(0);
            charBuffer.limit(32);
            c10 = cArray[n10];
            charBuffer.put(c10);
        }
    }

    private final int e(int n10, int n11) {
        ByteBuffer byteBuffer = f;
        byteBuffer.limit(n10);
        CharBuffer charBuffer = g;
        charBuffer.position(n11);
        n10 = this.d(true);
        CharsetDecoder charsetDecoder = b;
        if (charsetDecoder == null) {
            String string2 = "decoder";
            f0.S(string2);
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return n10;
    }

    private final void g() {
        CharsetDecoder charsetDecoder = b;
        if (charsetDecoder == null) {
            String string2 = "decoder";
            f0.S(string2);
        }
        charsetDecoder.reset();
        f.position(0);
        h.setLength(0);
    }

    private final void h() {
        StringBuilder stringBuilder = h;
        stringBuilder.setLength(32);
        stringBuilder.trimToSize();
    }

    private final void i(Charset object) {
        String string2;
        object = ((Charset)object).newDecoder();
        f0.o(object, "charset.newDecoder()");
        b = object;
        object = f;
        ((ByteBuffer)object).clear();
        CharBuffer charBuffer = g;
        charBuffer.clear();
        int n10 = 10;
        byte by2 = (byte)n10;
        ((ByteBuffer)object).put(by2);
        ((ByteBuffer)object).flip();
        CharsetDecoder charsetDecoder = b;
        if (charsetDecoder == null) {
            string2 = "decoder";
            f0.S(string2);
        }
        byte by3 = 0;
        string2 = null;
        charsetDecoder.decode((ByteBuffer)object, charBuffer, false);
        int n11 = charBuffer.position();
        by2 = 1;
        if (n11 == by2 && (n11 = (int)charBuffer.get(0)) == n10) {
            by3 = by2;
        }
        c = by3;
        this.g();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String f(InputStream object, Charset charset) {
        synchronized (this) {
            String string2;
            int n10;
            Object var2_2;
            Object object2;
            block22: {
                block21: {
                    boolean bl2;
                    object2 = "inputStream";
                    f0.p(object, (String)object2);
                    object2 = "charset";
                    f0.p(var2_2, (String)object2);
                    object2 = b;
                    n10 = 1;
                    if (object2 == null) break block21;
                    if (object2 == null) {
                        string2 = "decoder";
                        f0.S(string2);
                    }
                    if (!(bl2 = f0.g(object2 = ((CharsetDecoder)object2).charset(), var2_2) ^ n10)) break block22;
                }
                this.i(var2_2);
            }
            var2_2 = null;
            boolean bl3 = false;
            object2 = null;
            boolean bl4 = false;
            string2 = null;
            while (true) {
                int n11;
                block25: {
                    int n12;
                    int n13;
                    int n14;
                    Object object3;
                    int n15;
                    Object object4;
                    int n16;
                    int n17;
                    int n18;
                    block24: {
                        byte by2;
                        int n19;
                        int n20;
                        Object object5;
                        block23: {
                            object5 = ((InputStream)object).read();
                            n18 = 32;
                            n17 = 10;
                            n20 = -1;
                            if (object5 != n20) break block23;
                            object = h;
                            n16 = object.length();
                            if (n16 == 0) {
                                n16 = n10;
                            } else {
                                n16 = 0;
                                object = null;
                            }
                            if (n16 != 0 && n11 == 0 && n19 == 0) {
                                return null;
                            }
                            n16 = this.e(n11, n19);
                            break block24;
                        }
                        byte[] byArray = d;
                        void var14_22 = n11 + true;
                        byArray[n11] = by2 = (byte)object5;
                        if (object5 != n17 && var14_22 != n18 && (n11 = c) != 0) {
                            n11 = var14_22;
                            continue;
                        }
                        object2 = f;
                        ((ByteBuffer)object2).limit((int)var14_22);
                        Object object6 = g;
                        ((CharBuffer)object6).position(n19);
                        n19 = this.d(false);
                        if (n19 <= 0 || (object5 = (Object)(object6 = (Object)e)[n20 = n19 + -1]) != n17) break block25;
                        ((ByteBuffer)object2).position(0);
                        n16 = n19;
                    }
                    if (n16 > 0 && (object4 = (object2 = (Object)e)[n15 = n16 + -1]) == n17 && (n16 += -1) > 0 && (object3 = object2[n14 = n16 + -1]) == (n13 = 13)) {
                        n16 += -1;
                    }
                    if ((n12 = (object2 = h).length()) != 0) {
                        n10 = 0;
                        Object var17_26 = null;
                    }
                    if (n10 != 0) {
                        object2 = e;
                        return new String((char[])object2, 0, n16);
                    }
                    char[] cArray = e;
                    ((StringBuilder)object2).append(cArray, 0, n16);
                    object = ((StringBuilder)object2).toString();
                    String string3 = "sb.toString()";
                    f0.o(object, string3);
                    n10 = ((StringBuilder)object2).length();
                    if (n10 > n18) {
                        this.h();
                    }
                    ((StringBuilder)object2).setLength(0);
                    return object;
                }
                n11 = this.c();
            }
        }
    }
}

