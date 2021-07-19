/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.VorbisBitArray;
import com.google.android.exoplayer2.extractor.VorbisUtil$CodeBook;
import com.google.android.exoplayer2.extractor.VorbisUtil$CommentHeader;
import com.google.android.exoplayer2.extractor.VorbisUtil$Mode;
import com.google.android.exoplayer2.extractor.VorbisUtil$VorbisIdHeader;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

public final class VorbisUtil {
    private static final String TAG = "VorbisUtil";

    private VorbisUtil() {
    }

    public static int iLog(int n10) {
        int n11 = 0;
        while (n10 > 0) {
            ++n11;
            n10 >>>= 1;
        }
        return n11;
    }

    private static long mapType1QuantValues(long l10, long l11) {
        double d10 = l10;
        double d11 = l11;
        double d12 = 1.0 / d11;
        return (long)Math.floor(Math.pow(d10, d12));
    }

    /*
     * WARNING - void declaration
     */
    private static VorbisUtil$CodeBook readBook(VorbisBitArray object) {
        int n10;
        int n11 = 24;
        int n12 = ((VorbisBitArray)object).readBits(n11);
        if (n12 == (n10 = 5653314)) {
            int n13;
            n12 = 16;
            int n14 = ((VorbisBitArray)object).readBits(n12);
            int n15 = ((VorbisBitArray)object).readBits(n11);
            long[] lArray = new long[n15];
            boolean bl2 = ((VorbisBitArray)object).readBit();
            long l10 = 0L;
            Object object2 = null;
            int n16 = 5;
            int n17 = 1;
            if (!bl2) {
                boolean n132 = ((VorbisBitArray)object).readBit();
                for (n10 = 0; n10 < n15; ++n10) {
                    long l11;
                    int n18;
                    if (n132) {
                        n18 = ((VorbisBitArray)object).readBit();
                        if (n18 != 0) {
                            n18 = ((VorbisBitArray)object).readBits(n16) + n17;
                            lArray[n10] = l11 = (long)n18;
                            continue;
                        }
                        lArray[n10] = l10;
                        continue;
                    }
                    n18 = ((VorbisBitArray)object).readBits(n16) + n17;
                    lArray[n10] = l11 = (long)n18;
                }
            } else {
                void var13_15;
                n16 = ((VorbisBitArray)object).readBits(n16) + n17;
                boolean bl3 = false;
                while (var13_15 < n15) {
                    int n19 = VorbisUtil.iLog(n15 - var13_15);
                    n19 = ((VorbisBitArray)object).readBits(n19);
                    for (int i10 = 0; i10 < n19 && ++var13_15 < n15; ++i10) {
                        long l12;
                        lArray[var13_15] = l12 = (long)n16;
                    }
                    ++n16;
                }
            }
            if ((n16 = ((VorbisBitArray)object).readBits(n10 = 4)) <= (n13 = 2)) {
                if (n16 == n17 || n16 == n13) {
                    long l13;
                    int n20 = 32;
                    ((VorbisBitArray)object).skipBits(n20);
                    ((VorbisBitArray)object).skipBits(n20);
                    n10 = ((VorbisBitArray)object).readBits(n10) + n17;
                    ((VorbisBitArray)object).skipBits(n17);
                    if (n16 == n17) {
                        if (n14 != 0) {
                            l10 = n15;
                            l13 = n14;
                            l10 = VorbisUtil.mapType1QuantValues(l10, l13);
                        }
                    } else {
                        l10 = n15;
                        l13 = n14;
                        l10 *= l13;
                    }
                    l13 = n10;
                    n11 = (int)(l10 *= l13);
                    ((VorbisBitArray)object).skipBits(n11);
                }
                object2 = object;
                object = new VorbisUtil$CodeBook(n14, n15, lArray, n16, bl2);
                return object;
            }
            StringBuilder stringBuilder = new StringBuilder(53);
            stringBuilder.append("lookup type greater than 2 not decodable: ");
            stringBuilder.append(n16);
            String string2 = stringBuilder.toString();
            object = new ParserException(string2);
            throw object;
        }
        int n21 = ((VorbisBitArray)object).getPosition();
        StringBuilder stringBuilder = new StringBuilder(66);
        stringBuilder.append("expected code book to start with [0x56, 0x43, 0x42] at ");
        stringBuilder.append(n21);
        object = stringBuilder.toString();
        ParserException parserException = new ParserException((String)object);
        throw parserException;
    }

    private static void readFloors(VorbisBitArray object) {
        int n10 = 6;
        int n11 = ((VorbisBitArray)object).readBits(n10);
        int n12 = 1;
        for (int i10 = 0; i10 < (n11 += n12); ++i10) {
            int n13 = 16;
            int n14 = ((VorbisBitArray)object).readBits(n13);
            int n15 = 4;
            int n16 = 8;
            if (n14 != 0) {
                if (n14 == n12) {
                    int n17;
                    int n18;
                    n13 = ((VorbisBitArray)object).readBits(5);
                    n14 = -1;
                    int[] nArray = new int[n13];
                    int[] nArray2 = null;
                    for (int i11 = 0; i11 < n13; ++i11) {
                        nArray[i11] = n18 = ((VorbisBitArray)object).readBits(n15);
                        n18 = nArray[i11];
                        if (n18 <= n14) continue;
                        n14 = nArray[i11];
                    }
                    nArray2 = new int[++n14];
                    n18 = 0;
                    while (true) {
                        int n19;
                        int n20;
                        n17 = 2;
                        if (n18 >= n14) break;
                        nArray2[n18] = n20 = ((VorbisBitArray)object).readBits(3) + n12;
                        if ((n17 = ((VorbisBitArray)object).readBits(n17)) > 0) {
                            ((VorbisBitArray)object).skipBits(n16);
                        }
                        for (n20 = 0; n20 < (n19 = n12 << n17); ++n20) {
                            ((VorbisBitArray)object).skipBits(n16);
                        }
                        ++n18;
                    }
                    ((VorbisBitArray)object).skipBits(n17);
                    n14 = ((VorbisBitArray)object).readBits(n15);
                    n16 = 0;
                    n18 = 0;
                    for (n15 = 0; n15 < n13; ++n15) {
                        n17 = nArray[n15];
                        n17 = nArray2[n17];
                        while (n18 < (n16 += n17)) {
                            ((VorbisBitArray)object).skipBits(n14);
                            ++n18;
                        }
                    }
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder(52);
                stringBuilder.append("floor type greater than 1 not decodable: ");
                stringBuilder.append(n14);
                String string2 = stringBuilder.toString();
                object = new ParserException(string2);
                throw object;
            }
            ((VorbisBitArray)object).skipBits(n16);
            ((VorbisBitArray)object).skipBits(n13);
            ((VorbisBitArray)object).skipBits(n13);
            ((VorbisBitArray)object).skipBits(n10);
            ((VorbisBitArray)object).skipBits(n16);
            n13 = ((VorbisBitArray)object).readBits(n15) + n12;
            for (n14 = 0; n14 < n13; ++n14) {
                ((VorbisBitArray)object).skipBits(n16);
            }
        }
    }

    private static void readMappings(int n10, VorbisBitArray vorbisBitArray) {
        int n11 = vorbisBitArray.readBits(6);
        int n12 = 1;
        for (int i10 = 0; i10 < (n11 += n12); ++i10) {
            String string2;
            StringBuilder stringBuilder;
            int n13;
            int n14 = vorbisBitArray.readBits(16);
            if (n14 != 0) {
                n13 = 52;
                stringBuilder = new StringBuilder(n13);
                stringBuilder.append("mapping type other than 0 not supported: ");
                stringBuilder.append(n14);
                String string3 = stringBuilder.toString();
                string2 = TAG;
                Log.e(string2, string3);
                continue;
            }
            n14 = (int)(vorbisBitArray.readBit() ? 1 : 0);
            n13 = 4;
            n14 = n14 != 0 ? vorbisBitArray.readBits(n13) + n12 : n12;
            int n15 = vorbisBitArray.readBit();
            int n16 = 8;
            if (n15 != 0) {
                n15 = vorbisBitArray.readBits(n16) + n12;
                for (int i11 = 0; i11 < n15; ++i11) {
                    int n17 = n10 + -1;
                    int n18 = VorbisUtil.iLog(n17);
                    vorbisBitArray.skipBits(n18);
                    n17 = VorbisUtil.iLog(n17);
                    vorbisBitArray.skipBits(n17);
                }
            }
            if ((n15 = vorbisBitArray.readBits(2)) == 0) {
                if (n14 > n12) {
                    stringBuilder = null;
                    for (n15 = 0; n15 < n10; ++n15) {
                        vorbisBitArray.skipBits(n13);
                    }
                }
                string2 = null;
                for (n13 = 0; n13 < n14; ++n13) {
                    vorbisBitArray.skipBits(n16);
                    vorbisBitArray.skipBits(n16);
                    vorbisBitArray.skipBits(n16);
                }
                continue;
            }
            ParserException parserException = new ParserException("to reserved bits must be zero after mapping coupling steps");
            throw parserException;
        }
    }

    private static VorbisUtil$Mode[] readModes(VorbisBitArray vorbisBitArray) {
        int n10 = vorbisBitArray.readBits(6) + 1;
        VorbisUtil$Mode[] vorbisUtil$ModeArray = new VorbisUtil$Mode[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            VorbisUtil$Mode vorbisUtil$Mode;
            boolean bl2 = vorbisBitArray.readBit();
            int n11 = 16;
            int n12 = vorbisBitArray.readBits(n11);
            n11 = vorbisBitArray.readBits(n11);
            int n13 = vorbisBitArray.readBits(8);
            vorbisUtil$ModeArray[i10] = vorbisUtil$Mode = new VorbisUtil$Mode(bl2, n12, n11, n13);
        }
        return vorbisUtil$ModeArray;
    }

    private static void readResidues(VorbisBitArray object) {
        int n10 = 6;
        int n11 = ((VorbisBitArray)object).readBits(n10);
        int n12 = 1;
        for (int i10 = 0; i10 < (n11 += n12); ++i10) {
            int n13;
            int n14 = ((VorbisBitArray)object).readBits(16);
            if (n14 <= (n13 = 2)) {
                int n15;
                int n16;
                int n17;
                n14 = 24;
                ((VorbisBitArray)object).skipBits(n14);
                ((VorbisBitArray)object).skipBits(n14);
                ((VorbisBitArray)object).skipBits(n14);
                n14 = ((VorbisBitArray)object).readBits(n10) + n12;
                n13 = 8;
                ((VorbisBitArray)object).skipBits(n13);
                int[] nArray = new int[n14];
                for (n17 = 0; n17 < n14; ++n17) {
                    n16 = ((VorbisBitArray)object).readBits(3);
                    int n15 = ((VorbisBitArray)object).readBit();
                    n15 = n15 != 0 ? ((VorbisBitArray)object).readBits(5) : 0;
                    nArray[n17] = n15 = n15 * n13 + n16;
                }
                for (n17 = 0; n17 < n14; ++n17) {
                    for (n16 = 0; n16 < n13; ++n16) {
                        n15 = nArray[n17];
                        int n18 = n12 << n16;
                        if ((n15 &= n18) == 0) continue;
                        ((VorbisBitArray)object).skipBits(n13);
                    }
                }
                continue;
            }
            object = new ParserException("residueType greater than 2 is not decodable");
            throw object;
        }
    }

    public static VorbisUtil$CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) {
        boolean bl2 = true;
        return VorbisUtil.readVorbisCommentHeader(parsableByteArray, bl2, bl2);
    }

    /*
     * WARNING - void declaration
     */
    public static VorbisUtil$CommentHeader readVorbisCommentHeader(ParsableByteArray object, boolean bl2, boolean bl3) {
        int n10;
        void var2_4;
        long l10;
        long l11;
        long l12;
        int n11 = 0;
        if (bl2) {
            int n12 = 3;
            VorbisUtil.verifyVorbisHeaderCapturePattern(n12, (ParsableByteArray)object, false);
        }
        long l13 = ((ParsableByteArray)object).readLittleEndianUnsignedInt();
        int n13 = (int)l13;
        String string2 = ((ParsableByteArray)object).readString(n13);
        int n14 = string2.length();
        int n15 = 11 + n14;
        long l14 = ((ParsableByteArray)object).readLittleEndianUnsignedInt();
        int n16 = (int)l14;
        String[] stringArray = new String[n16];
        n15 += 4;
        while ((l12 = (l11 = (l10 = (long)n11) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            String string3;
            l10 = ((ParsableByteArray)object).readLittleEndianUnsignedInt();
            l12 = (int)l10;
            n15 += 4;
            stringArray[n11] = string3 = ((ParsableByteArray)object).readString((int)l12);
            string3 = stringArray[n11];
            l12 = string3.length();
            n15 += l12;
            ++n11;
        }
        if (var2_4 != false && (n10 = ((ParsableByteArray)object).readUnsignedByte() & 1) == 0) {
            object = new ParserException("framing bit expected to be set");
            throw object;
        }
        object = new VorbisUtil$CommentHeader(string2, stringArray, ++n15);
        return object;
    }

    public static VorbisUtil$VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) {
        int n10;
        int n11;
        int n12 = 1;
        Object object = null;
        VorbisUtil.verifyVorbisHeaderCapturePattern(n12, parsableByteArray, false);
        int n13 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int n14 = parsableByteArray.readUnsignedByte();
        int n15 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int n16 = parsableByteArray.readLittleEndianInt();
        int n17 = -1;
        if (n16 <= 0) {
            n16 = n17;
        }
        if ((n11 = parsableByteArray.readLittleEndianInt()) <= 0) {
            n11 = n17;
        }
        if ((n10 = parsableByteArray.readLittleEndianInt()) <= 0) {
            n10 = n17;
        }
        n17 = parsableByteArray.readUnsignedByte();
        double d10 = n17 & 0xF;
        double d11 = 2.0;
        d10 = Math.pow(d11, d10);
        int n18 = (int)d10;
        double d12 = (n17 & 0xF0) >> 4;
        double d13 = Math.pow(d11, d12);
        int n19 = (int)d13;
        n17 = parsableByteArray.readUnsignedByte() & n12;
        if (n17 <= 0) {
            n12 = 0;
        }
        object = parsableByteArray.getData();
        int n20 = parsableByteArray.limit();
        byte[] byArray = Arrays.copyOf(object, n20);
        object = new VorbisUtil$VorbisIdHeader;
        n17 = n11;
        n11 = n10;
        n10 = n18;
        n18 = n19;
        n19 = n12;
        object(n13, n14, n15, n16, n17, n11, n10, n18, n12 != 0, byArray);
        return object;
    }

    public static VorbisUtil$Mode[] readVorbisModes(ParsableByteArray object, int n10) {
        int n11 = 0;
        VorbisUtil.verifyVorbisHeaderCapturePattern(5, (ParsableByteArray)object, false);
        int n12 = object.readUnsignedByte() + 1;
        byte[] byArray = object.getData();
        VorbisBitArray vorbisBitArray = new VorbisBitArray(byArray);
        int n13 = object.getPosition() * 8;
        vorbisBitArray.skipBits(n13);
        object = null;
        for (n13 = 0; n13 < n12; ++n13) {
            VorbisUtil.readBook(vorbisBitArray);
        }
        n13 = vorbisBitArray.readBits(6) + 1;
        while (n11 < n13) {
            n12 = vorbisBitArray.readBits(16);
            if (n12 == 0) {
                ++n11;
                continue;
            }
            object = new ParserException("placeholder of time domain transforms not zeroed out");
            throw object;
        }
        VorbisUtil.readFloors(vorbisBitArray);
        VorbisUtil.readResidues(vorbisBitArray);
        VorbisUtil.readMappings(n10, vorbisBitArray);
        object = VorbisUtil.readModes(vorbisBitArray);
        n10 = (int)(vorbisBitArray.readBit() ? 1 : 0);
        if (n10 != 0) {
            return object;
        }
        object = new ParserException("framing bit after modes not set as expected");
        throw object;
    }

    public static boolean verifyVorbisHeaderCapturePattern(int n10, ParsableByteArray object, boolean bl2) {
        int n11;
        int n12;
        int n13 = ((ParsableByteArray)object).bytesLeft();
        if (n13 < (n12 = 7)) {
            if (bl2) {
                return false;
            }
            int n14 = ((ParsableByteArray)object).bytesLeft();
            StringBuilder stringBuilder = new StringBuilder(29);
            stringBuilder.append("too short header: ");
            stringBuilder.append(n14);
            object = stringBuilder.toString();
            ParserException parserException = new ParserException((String)object);
            throw parserException;
        }
        n13 = ((ParsableByteArray)object).readUnsignedByte();
        if (n13 != n10) {
            if (bl2) {
                return false;
            }
            String string2 = "expected header type ";
            String string3 = String.valueOf(Integer.toHexString(n10));
            n13 = string3.length();
            string3 = n13 != 0 ? string2.concat(string3) : new String(string2);
            object = new ParserException(string3);
            throw object;
        }
        n10 = ((ParsableByteArray)object).readUnsignedByte();
        if (n10 == (n13 = 118) && (n10 = ((ParsableByteArray)object).readUnsignedByte()) == (n13 = 111) && (n10 = ((ParsableByteArray)object).readUnsignedByte()) == (n13 = 114) && (n10 = ((ParsableByteArray)object).readUnsignedByte()) == (n13 = 98) && (n10 = ((ParsableByteArray)object).readUnsignedByte()) == (n13 = 105) && (n10 = ((ParsableByteArray)object).readUnsignedByte()) == (n11 = 115)) {
            return true;
        }
        if (bl2) {
            return false;
        }
        ParserException parserException = new ParserException("expected characters 'vorbis'");
        throw parserException;
    }
}

