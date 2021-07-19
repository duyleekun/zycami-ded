/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzft;
import com.google.android.gms.internal.clearcut.zzfz;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzfs {
    private final ByteBuffer zzgd;
    private zzbn zzrh;
    private int zzri;

    private zzfs(ByteBuffer byteBuffer) {
        this.zzgd = byteBuffer;
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order(byteOrder);
    }

    private zzfs(byte[] object, int n10, int n11) {
        object = ByteBuffer.wrap(object, n10, n11);
        this((ByteBuffer)object);
    }

    private static int zza(CharSequence object) {
        int n10;
        int n11;
        int n12;
        int n13 = object.length();
        int n14 = 0;
        StringBuilder stringBuilder = null;
        for (n12 = 0; n12 < n13 && (n11 = (int)object.charAt(n12)) < (n10 = 128); ++n12) {
        }
        n11 = n13;
        while (n12 < n13) {
            int n15;
            n10 = object.charAt(n12);
            if (n10 < (n15 = 2048)) {
                n10 = 127 - n10 >>> 31;
                n11 += n10;
                ++n12;
                continue;
            }
            n10 = object.length();
            while (n12 < n10) {
                int n16 = object.charAt(n12);
                if (n16 < n15) {
                    n16 = 127 - n16 >>> 31;
                    n14 += n16;
                } else {
                    n14 += 2;
                    int n17 = 55296;
                    if (n17 <= n16 && n16 <= (n17 = 57343)) {
                        n16 = Character.codePointAt((CharSequence)object, n12);
                        if (n16 >= (n17 = 65536)) {
                            ++n12;
                        } else {
                            stringBuilder = new StringBuilder(39);
                            stringBuilder.append("Unpaired surrogate at index ");
                            stringBuilder.append(n12);
                            String string2 = stringBuilder.toString();
                            object = new IllegalArgumentException(string2);
                            throw object;
                        }
                    }
                }
                ++n12;
            }
            n11 += n14;
            break;
        }
        if (n11 >= n13) {
            return n11;
        }
        long l10 = (long)n11 + 0x100000000L;
        StringBuilder stringBuilder2 = new StringBuilder(54);
        stringBuilder2.append("UTF-8 length does not fit in int: ");
        stringBuilder2.append(l10);
        String string3 = stringBuilder2.toString();
        object = new IllegalArgumentException(string3);
        throw object;
    }

    private final void zzao(int n10) {
        n10 = (byte)n10;
        ByteBuffer byteBuffer = this.zzgd;
        int n11 = byteBuffer.hasRemaining();
        if (n11 != 0) {
            this.zzgd.put((byte)n10);
            return;
        }
        n11 = this.zzgd.position();
        int n12 = this.zzgd.limit();
        zzft zzft2 = new zzft(n11, n12);
        throw zzft2;
    }

    private final void zzap(int n10) {
        while (true) {
            int n11;
            if ((n11 = n10 & 0xFFFFFF80) == 0) {
                this.zzao(n10);
                return;
            }
            n11 = n10 & 0x7F | 0x80;
            this.zzao(n11);
            n10 >>>= 7;
        }
    }

    public static int zzb(int n10, zzfz zzfz2) {
        n10 = zzfs.zzr(n10);
        int n11 = zzfz2.zzas();
        int n12 = zzfs.zzz(n11) + n11;
        return n10 + n12;
    }

    public static int zzb(int n10, String string2) {
        n10 = zzfs.zzr(n10);
        int n11 = zzfs.zzh(string2);
        return n10 + n11;
    }

    public static int zzb(int n10, byte[] byArray) {
        n10 = zzfs.zzr(n10);
        int n11 = zzfs.zzh(byArray);
        return n10 + n11;
    }

    public static int zzd(int n10, long l10) {
        n10 = zzfs.zzr(n10);
        int n11 = zzfs.zzo(l10);
        return n10 + n11;
    }

    /*
     * Exception decompiling
     */
    private static void zzd(CharSequence var0, ByteBuffer var1_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [38[WHILELOOP]], but top level block is 34[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
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

    public static zzfs zzg(byte[] byArray) {
        int n10 = byArray.length;
        return zzfs.zzh(byArray, 0, n10);
    }

    public static int zzh(String string2) {
        int n10 = zzfs.zza(string2);
        return zzfs.zzz(n10) + n10;
    }

    public static int zzh(byte[] byArray) {
        int n10 = zzfs.zzz(byArray.length);
        int n11 = byArray.length;
        return n10 + n11;
    }

    public static zzfs zzh(byte[] byArray, int n10, int n11) {
        zzfs zzfs2 = new zzfs(byArray, 0, n11);
        return zzfs2;
    }

    public static long zzj(long l10) {
        long l11 = l10 << 1;
        return l10 >> 63 ^ l11;
    }

    public static int zzo(long l10) {
        long l11 = (long)-128 & l10;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return 1;
        }
        l11 = 0xFFFFFFFFFFFFC000L & l10;
        long l14 = l11 - l12;
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return 2;
        }
        l11 = 0xFFE00000L & l10;
        long l15 = l11 - l12;
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false) {
            return 3;
        }
        l11 = 0xF0000000L & l10;
        long l16 = l11 - l12;
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object == false) {
            return 4;
        }
        l11 = 0xFFFFFFF800000000L & l10;
        long l17 = l11 - l12;
        object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object == false) {
            return 5;
        }
        l11 = 0xFFFFFC0000000000L & l10;
        long l18 = l11 - l12;
        object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object == false) {
            return 6;
        }
        l11 = 0xFFFE000000000000L & l10;
        long l19 = l11 - l12;
        object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (object == false) {
            return 7;
        }
        l11 = 0xFF00000000000000L & l10;
        long l20 = l11 - l12;
        object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
        if (object == false) {
            return 8;
        }
        l11 = Long.MIN_VALUE;
        long l21 = (l10 &= l11) - l12;
        Object object2 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
        if (object2 == false) {
            return 9;
        }
        return 10;
    }

    public static int zzr(int n10) {
        return zzfs.zzz(n10 << 3);
    }

    public static int zzs(int n10) {
        if (n10 >= 0) {
            return zzfs.zzz(n10);
        }
        return 10;
    }

    private static int zzz(int n10) {
        int n11 = n10 & 0xFFFFFF80;
        if (n11 == 0) {
            return 1;
        }
        n11 = n10 & 0xFFFFC000;
        if (n11 == 0) {
            return 2;
        }
        n11 = 0xFFE00000 & n10;
        if (n11 == 0) {
            return 3;
        }
        n11 = -268435456;
        if ((n10 &= n11) == 0) {
            return 4;
        }
        return 5;
    }

    public final void zza(int n10, zzfz zzfz2) {
        int n11 = 2;
        this.zzb(n10, n11);
        n10 = zzfz2.zzrs;
        if (n10 < 0) {
            zzfz2.zzas();
        }
        n10 = zzfz2.zzrs;
        this.zzap(n10);
        zzfz2.zza(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(int n10, String object) {
        int n11;
        int n12 = 2;
        this.zzb(n10, n12);
        try {
            n10 = ((String)object).length();
            n10 = zzfs.zzz(n10);
            n12 = ((String)object).length() * 3;
            n12 = zzfs.zzz(n12);
            if (n10 == n12) {
                ByteBuffer byteBuffer = this.zzgd;
                n12 = byteBuffer.position();
                ByteBuffer byteBuffer2 = this.zzgd;
                n11 = byteBuffer2.remaining();
                if (n11 >= n10) {
                    byteBuffer2 = this.zzgd;
                    int n13 = n12 + n10;
                    byteBuffer2.position(n13);
                    byteBuffer2 = this.zzgd;
                    zzfs.zzd((CharSequence)object, byteBuffer2);
                    object = this.zzgd;
                    int n14 = ((Buffer)object).position();
                    byteBuffer2 = this.zzgd;
                    byteBuffer2.position(n12);
                    n12 = n14 - n12 - n10;
                    this.zzap(n12);
                    ByteBuffer byteBuffer3 = this.zzgd;
                    byteBuffer3.position(n14);
                    return;
                }
                n12 += n10;
                ByteBuffer byteBuffer4 = this.zzgd;
                n10 = byteBuffer4.limit();
                object = new zzft(n12, n10);
                throw object;
            }
            n10 = zzfs.zza((CharSequence)object);
            this.zzap(n10);
            ByteBuffer byteBuffer = this.zzgd;
            zzfs.zzd((CharSequence)object, byteBuffer);
            return;
        }
        catch (BufferOverflowException bufferOverflowException) {
            n12 = this.zzgd.position();
            n11 = this.zzgd.limit();
            object = new zzft(n12, n11);
            ((Throwable)object).initCause(bufferOverflowException);
            throw object;
        }
    }

    public final void zza(int n10, byte[] byArray) {
        this.zzb(n10, 2);
        n10 = byArray.length;
        this.zzap(n10);
        n10 = byArray.length;
        ByteBuffer byteBuffer = this.zzgd;
        int n11 = byteBuffer.remaining();
        if (n11 >= n10) {
            this.zzgd.put(byArray, 0, n10);
            return;
        }
        int n12 = this.zzgd.position();
        n11 = this.zzgd.limit();
        zzft zzft2 = new zzft(n12, n11);
        throw zzft2;
    }

    public final void zzb(int n10, int n11) {
        n10 = n10 << 3 | n11;
        this.zzap(n10);
    }

    public final void zzb(int n10, boolean bl2) {
        int n11 = 0;
        this.zzb(25, 0);
        n10 = (byte)(bl2 ? 1 : 0);
        ByteBuffer byteBuffer = this.zzgd;
        boolean bl3 = byteBuffer.hasRemaining();
        if (bl3) {
            this.zzgd.put((byte)n10);
            return;
        }
        int n12 = this.zzgd.position();
        n11 = this.zzgd.limit();
        zzft zzft2 = new zzft(n12, n11);
        throw zzft2;
    }

    public final void zzc(int n10, int n11) {
        this.zzb(n10, 0);
        if (n11 >= 0) {
            this.zzap(n11);
            return;
        }
        long l10 = n11;
        this.zzn(l10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void zze(int n10, zzdo zzdo2) {
        Object object;
        block4: {
            int n11;
            block3: {
                block2: {
                    object = this.zzrh;
                    if (object != null) break block2;
                    object = zzbn.zza(this.zzgd);
                    this.zzrh = object;
                    break block3;
                }
                n11 = this.zzri;
                Object object2 = this.zzgd;
                int n12 = ((Buffer)object2).position();
                if (n11 == n12) break block4;
                object = this.zzrh;
                object2 = this.zzgd.array();
                int n13 = this.zzri;
                ByteBuffer byteBuffer = this.zzgd;
                int n14 = byteBuffer.position();
                int n15 = this.zzri;
                ((zzbn)object).write((byte[])object2, n13, n14 -= n15);
            }
            object = this.zzgd;
            this.zzri = n11 = ((Buffer)object).position();
        }
        object = this.zzrh;
        ((zzbn)object).zza(n10, zzdo2);
        ((zzbn)object).flush();
        this.zzri = n10 = this.zzgd.position();
    }

    public final void zzem() {
        Object object = this.zzgd;
        int n10 = ((Buffer)object).remaining();
        if (n10 == 0) {
            return;
        }
        Object object2 = new Object[1];
        Integer n11 = this.zzgd.remaining();
        object2[0] = n11;
        object2 = String.format("Did not write as much data as expected, %s bytes remaining.", object2);
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public final void zzi(int n10, long l10) {
        this.zzb(n10, 0);
        this.zzn(l10);
    }

    public final void zzn(long l10) {
        while (true) {
            long l11;
            long l12;
            long l13;
            long l14;
            if ((l14 = (l13 = (l12 = (long)-128 & l10) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
                int n10 = (int)l10;
                this.zzao(n10);
                return;
            }
            l14 = (int)l10 & 0x7F | 0x80;
            this.zzao((int)l14);
            l14 = 7;
            l10 >>>= l14;
        }
    }
}

