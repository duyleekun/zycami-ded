/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Utf8;
import com.google.protobuf.Utf8$DecodeUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public abstract class Utf8$Processor {
    private static int partialIsValidUtf8(ByteBuffer byteBuffer, int n10, int n11) {
        int n12 = Utf8.access$200(byteBuffer, n10, n11);
        n10 += n12;
        while (true) {
            block11: {
                int n13;
                block14: {
                    int n14;
                    int n15;
                    block12: {
                        block13: {
                            if (n10 >= n11) {
                                return 0;
                            }
                            n12 = n10 + 1;
                            if ((n10 = (int)byteBuffer.get(n10)) >= 0) break block11;
                            n15 = -32;
                            n13 = -1;
                            n14 = -65;
                            if (n10 >= n15) break block12;
                            if (n12 >= n11) {
                                return n10;
                            }
                            n15 = -62;
                            if (n10 < n15 || (n10 = (int)byteBuffer.get(n12)) > n14) break block13;
                            ++n12;
                            break block11;
                        }
                        return n13;
                    }
                    int n16 = -16;
                    if (n10 < n16) {
                        n16 = n11 + -1;
                        if (n12 >= n16) {
                            return Utf8.access$300(byteBuffer, n10, n12, n11 -= n12);
                        }
                        n16 = n12 + 1;
                        if ((n12 = (int)byteBuffer.get(n12)) <= n14) {
                            int n17 = -96;
                            if (!(n10 == n15 && n12 < n17 || n10 == (n15 = -19) && n12 >= n17 || (n10 = (int)byteBuffer.get(n16)) > n14)) {
                                n10 = ++n16;
                                continue;
                            }
                        }
                        return n13;
                    }
                    n15 = n11 + -2;
                    if (n12 >= n15) {
                        return Utf8.access$300(byteBuffer, n10, n12, n11 -= n12);
                    }
                    n15 = n12 + 1;
                    if ((n12 = (int)byteBuffer.get(n12)) > n14) break block14;
                    n10 <<= 28;
                    if ((n10 = n10 + (n12 += 112) >> 30) != 0) break block14;
                    n10 = n15 + 1;
                    n12 = byteBuffer.get(n15);
                    if (n12 > n14) break block14;
                    n12 = n10 + 1;
                    if ((n10 = (int)byteBuffer.get(n10)) <= n14) break block11;
                }
                return n13;
            }
            n10 = n12;
        }
    }

    public final String decodeUtf8(ByteBuffer object, int n10, int n11) {
        boolean n12 = ((ByteBuffer)object).hasArray();
        if (n12) {
            int n13 = ((ByteBuffer)object).arrayOffset();
            object = ((ByteBuffer)object).array();
            int n14 = n13 + n10;
            return this.decodeUtf8((byte[])object, n14, n11);
        }
        boolean bl2 = ((ByteBuffer)object).isDirect();
        if (bl2) {
            return this.decodeUtf8Direct((ByteBuffer)object, n10, n11);
        }
        return this.decodeUtf8Default((ByteBuffer)object, n10, n11);
    }

    public abstract String decodeUtf8(byte[] var1, int var2, int var3);

    public final String decodeUtf8Default(ByteBuffer object, int n10, int n11) {
        int n12 = n10 | n11;
        int n13 = ((Buffer)object).limit() - n10 - n11;
        n12 |= n13;
        n13 = 0;
        int n14 = 1;
        if (n12 >= 0) {
            int n15;
            int n16;
            n12 = n10 + n11;
            char[] cArray = new char[n11];
            int n17 = 0;
            Object var9_9 = null;
            while (n10 < n12 && (n16 = Utf8$DecodeUtil.access$400((byte)(n15 = ((ByteBuffer)object).get(n10)))) != 0) {
                ++n10;
                n16 = n17 + 1;
                Utf8$DecodeUtil.access$500((byte)n15, cArray, n17);
                n17 = n16;
            }
            int n18 = n17;
            while (n10 < n12) {
                int n19;
                n17 = n10 + 1;
                n15 = (int)(Utf8$DecodeUtil.access$400((byte)(n10 = (int)((ByteBuffer)object).get(n10))) ? 1 : 0);
                if (n15 != 0) {
                    n15 = n18 + 1;
                    Utf8$DecodeUtil.access$500((byte)n10, cArray, n18);
                    while (n17 < n12 && (n16 = (int)(Utf8$DecodeUtil.access$400((byte)(n10 = (int)((ByteBuffer)object).get(n17))) ? 1 : 0)) != 0) {
                        ++n17;
                        n16 = n15 + 1;
                        Utf8$DecodeUtil.access$500((byte)n10, cArray, n15);
                        n15 = n16;
                    }
                    n10 = n17;
                    n18 = n15;
                    continue;
                }
                n15 = (int)(Utf8$DecodeUtil.access$600((byte)n10) ? 1 : 0);
                if (n15 != 0) {
                    if (n17 < n12) {
                        n15 = n17 + 1;
                        n17 = ((ByteBuffer)object).get(n17);
                        n16 = n18 + 1;
                        Utf8$DecodeUtil.access$700((byte)n10, (byte)n17, cArray, n18);
                        n10 = n15;
                        n18 = n16;
                        continue;
                    }
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                n15 = (int)(Utf8$DecodeUtil.access$800((byte)n10) ? 1 : 0);
                if (n15 != 0) {
                    n15 = n12 + -1;
                    if (n17 < n15) {
                        n15 = n17 + 1;
                        n17 = ((ByteBuffer)object).get(n17);
                        n16 = n15 + 1;
                        n15 = ((ByteBuffer)object).get(n15);
                        n19 = n18 + 1;
                        Utf8$DecodeUtil.access$900((byte)n10, (byte)n17, (byte)n15, cArray, n18);
                        n10 = n16;
                        n18 = n19;
                        continue;
                    }
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                n15 = n12 + -2;
                if (n17 < n15) {
                    n15 = n17 + 1;
                    n16 = ((ByteBuffer)object).get(n17);
                    n17 = n15 + 1;
                    n19 = ((ByteBuffer)object).get(n15);
                    int n20 = n17 + 1;
                    byte by2 = ((ByteBuffer)object).get(n17);
                    int n21 = n18 + 1;
                    n17 = n10;
                    n15 = n16;
                    n16 = n19;
                    n19 = by2;
                    Utf8$DecodeUtil.access$1000((byte)n10, (byte)n15, (byte)n16, by2, cArray, n18);
                    n10 = n20;
                    n18 = n21 += n14;
                    continue;
                }
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            object = new String(cArray, 0, n18);
            return object;
        }
        Object[] objectArray = new Object[3];
        objectArray[0] = object = Integer.valueOf(((Buffer)object).limit());
        objectArray[n14] = object = Integer.valueOf(n10);
        objectArray[2] = object = Integer.valueOf(n11);
        object = String.format("buffer limit=%d, index=%d, limit=%d", objectArray);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException((String)object);
        throw arrayIndexOutOfBoundsException;
    }

    public abstract String decodeUtf8Direct(ByteBuffer var1, int var2, int var3);

    public abstract int encodeUtf8(CharSequence var1, byte[] var2, int var3, int var4);

    public final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        int n10 = byteBuffer.hasArray();
        if (n10 != 0) {
            n10 = byteBuffer.arrayOffset();
            byte[] byArray = byteBuffer.array();
            int n11 = byteBuffer.position() + n10;
            int n12 = byteBuffer.remaining();
            int n13 = Utf8.encode(charSequence, byArray, n11, n12) - n10;
            byteBuffer.position(n13);
        } else {
            n10 = (int)(byteBuffer.isDirect() ? 1 : 0);
            if (n10 != 0) {
                this.encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                this.encodeUtf8Default(charSequence, byteBuffer);
            }
        }
    }

    /*
     * Exception decompiling
     */
    public final void encodeUtf8Default(CharSequence var1_1, ByteBuffer var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 16[TRYBLOCK] [17 : 460->466)] java.lang.IndexOutOfBoundsException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public abstract void encodeUtf8Direct(CharSequence var1, ByteBuffer var2);

    public final boolean isValidUtf8(ByteBuffer byteBuffer, int n10, int n11) {
        boolean bl2 = false;
        int n12 = this.partialIsValidUtf8(0, byteBuffer, n10, n11);
        if (n12 == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public final boolean isValidUtf8(byte[] byArray, int n10, int n11) {
        boolean bl2 = false;
        int n12 = this.partialIsValidUtf8(0, byArray, n10, n11);
        if (n12 == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public final int partialIsValidUtf8(int n10, ByteBuffer object, int n11, int n12) {
        boolean n13 = ((ByteBuffer)object).hasArray();
        if (n13) {
            int n14 = ((ByteBuffer)object).arrayOffset();
            object = ((ByteBuffer)object).array();
            int n15 = n14 + n12;
            return this.partialIsValidUtf8(n10, (byte[])object, n11 += n14, n15);
        }
        boolean bl2 = ((ByteBuffer)object).isDirect();
        if (bl2) {
            return this.partialIsValidUtf8Direct(n10, (ByteBuffer)object, n11, n12);
        }
        return this.partialIsValidUtf8Default(n10, (ByteBuffer)object, n11, n12);
    }

    public abstract int partialIsValidUtf8(int var1, byte[] var2, int var3, int var4);

    /*
     * Enabled aggressive block sorting
     */
    public final int partialIsValidUtf8Default(int n10, ByteBuffer byteBuffer, int n11, int n12) {
        int n13;
        block19: {
            block17: {
                int n14;
                int n15;
                int n16;
                int n17;
                block18: {
                    block16: {
                        if (n10 == 0) return Utf8$Processor.partialIsValidUtf8(byteBuffer, n11, n12);
                        if (n11 >= n12) {
                            return n10;
                        }
                        n17 = n10;
                        n16 = -32;
                        n13 = -1;
                        n15 = -65;
                        if (n17 >= n16) break block16;
                        n10 = -62;
                        if (n17 < n10) return n13;
                        n10 = n11 + 1;
                        if ((n11 = (int)byteBuffer.get(n11)) > n15) {
                            return n13;
                        }
                        break block17;
                    }
                    n14 = -16;
                    if (n17 >= n14) break block18;
                    if ((n10 = (int)((byte)(~(n10 >> 8)))) == 0) {
                        n10 = n11 + 1;
                        n11 = byteBuffer.get(n11);
                        if (n10 >= n12) {
                            return Utf8.access$000(n17, n11);
                        }
                        int n18 = n11;
                        n11 = n10;
                        n10 = n18;
                    }
                    if (n10 > n15) return n13;
                    n14 = -96;
                    if (n17 == n16) {
                        if (n10 < n14) return n13;
                    }
                    if (n17 == (n16 = -19)) {
                        if (n10 >= n14) return n13;
                    }
                    n10 = n11 + 1;
                    if ((n11 = (int)byteBuffer.get(n11)) > n15) {
                        return n13;
                    }
                    break block17;
                }
                n16 = (byte)(~(n10 >> 8));
                n14 = 0;
                if (n16 == 0) {
                    n10 = n11 + 1;
                    n16 = byteBuffer.get(n11);
                    if (n10 >= n12) {
                        return Utf8.access$000(n17, n16);
                    }
                    n11 = n10;
                } else {
                    n14 = (byte)(n10 >>= 16);
                }
                if (n14 == 0) {
                    n10 = n11 + 1;
                    n14 = byteBuffer.get(n11);
                    if (n10 >= n12) {
                        return Utf8.access$100(n17, n16, n14);
                    }
                    n11 = n10;
                }
                if (n16 > n15) return n13;
                n10 = n17 << 28;
                if ((n10 = n10 + (n16 += 112) >> 30) != 0) return n13;
                if (n14 > n15) return n13;
                n10 = n11 + 1;
                if ((n11 = (int)byteBuffer.get(n11)) > n15) break block19;
            }
            n11 = n10;
            return Utf8$Processor.partialIsValidUtf8(byteBuffer, n11, n12);
        }
        return n13;
    }

    public abstract int partialIsValidUtf8Direct(int var1, ByteBuffer var2, int var3, int var4);
}

