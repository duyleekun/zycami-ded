/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder$Id3Header;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.j0.a.a;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public final class Id3Decoder
extends SimpleMetadataDecoder {
    private static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    private static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    private static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    private static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    private static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    private static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    private static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    private static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = 0x494433;
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    public static final Id3Decoder$FramePredicate NO_FRAMES_PREDICATE = a.a;
    private static final String TAG = "Id3Decoder";
    private final Id3Decoder$FramePredicate framePredicate;

    public Id3Decoder() {
        this(null);
    }

    public Id3Decoder(Id3Decoder$FramePredicate id3Decoder$FramePredicate) {
        this.framePredicate = id3Decoder$FramePredicate;
    }

    public static /* synthetic */ boolean a(int n10, int n11, int n12, int n13, int n14) {
        return false;
    }

    private static byte[] copyOfRangeIfValid(byte[] byArray, int n10, int n11) {
        if (n11 <= n10) {
            return Util.EMPTY_BYTE_ARRAY;
        }
        return Arrays.copyOfRange(byArray, n10, n11);
    }

    /*
     * Unable to fully structure code
     */
    private static ApicFrame decodeApicFrame(ParsableByteArray var0, int var1_1, int var2_2) {
        block4: {
            block3: {
                var3_3 = var0.readUnsignedByte();
                var4_4 = Id3Decoder.getCharsetName(var3_3);
                var5_5 = new byte[var1_1 += -1];
                var6_6 = 0;
                var7_7 = null;
                var0.readBytes(var5_5, 0, var1_1);
                var0 = "image/";
                var8_8 = "ISO-8859-1";
                var9_9 = 2;
                if (var2_2 != var9_9) break block3;
                var11_11 = 3;
                var10_10 = new String(var5_5, 0, var11_11, var8_8);
                var10_10 = "image/jpg";
                var6_6 = (var10_10 = String.valueOf(Util.toLowerInvariant((String)var10_10))).length();
                var0 = var6_6 != 0 ? var0.concat((String)var10_10) : (var10_10 = new String((String)var0));
                var2_2 = (int)var10_10.equals(var0);
                if (var2_2 != 0) {
                    var0 = "image/jpeg";
                }
                var2_2 = var9_9;
                break block4;
            }
            var2_2 = Id3Decoder.indexOfZeroByte(var5_5, 0);
            var12_12 = new String(var5_5, 0, var2_2, var8_8);
            var7_7 = Util.toLowerInvariant(var12_12);
            var13_13 = var7_7.indexOf(47);
            if (var13_13 != (var11_11 = -1)) ** GOTO lbl32
            var13_13 = (var7_7 = String.valueOf(var7_7)).length();
            if (var13_13 != 0) {
                var0 = var0.concat(var7_7);
            } else {
                var7_7 = new String((String)var0);
lbl32:
                // 2 sources

                var0 = var7_7;
            }
        }
        var6_6 = var2_2 + 1;
        var6_6 = var5_5[var6_6] & 255;
        var13_13 = Id3Decoder.indexOfEos(var5_5, var2_2 += var9_9, var3_3);
        var11_11 = var13_13 - var2_2;
        var14_14 = new String(var5_5, var2_2, var11_11, var4_4);
        var2_2 = Id3Decoder.delimiterLength(var3_3);
        var15_15 = Id3Decoder.copyOfRangeIfValid(var5_5, var13_13 += var2_2, var1_1);
        var10_10 = new ApicFrame((String)var0, var14_14, var6_6, var15_15);
        return var10_10;
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray object, int n10, String string2) {
        byte[] byArray = new byte[n10];
        ((ParsableByteArray)object).readBytes(byArray, 0, n10);
        object = new BinaryFrame(string2, byArray);
        return object;
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray id3FrameArray, int n10, int n11, boolean bl2, int n12, Id3Decoder$FramePredicate id3FrameArray2) {
        Id3Frame[] id3FrameArray3;
        int n13;
        Object object = id3FrameArray;
        int n14 = id3FrameArray.getPosition();
        Object object2 = id3FrameArray.getData();
        int n15 = Id3Decoder.indexOfZeroByte((byte[])object2, n14);
        Object object3 = id3FrameArray.getData();
        int n16 = n15 - n14;
        String string2 = "ISO-8859-1";
        String string3 = new String((byte[])object3, n14, n16, string2);
        id3FrameArray.setPosition(++n15);
        n16 = id3FrameArray.readInt();
        int n17 = id3FrameArray.readInt();
        long l10 = id3FrameArray.readUnsignedInt();
        long l11 = 0xFFFFFFFFL;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        long l13 = -1;
        long l14 = l12 == false ? l13 : l10;
        l10 = id3FrameArray.readUnsignedInt();
        long l15 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        long l16 = l15 == false ? l13 : l10;
        object2 = new ArrayList;
        ((ArrayList)object2)();
        while ((n13 = id3FrameArray.getPosition()) < (n14 += n10)) {
            n13 = n11;
            l15 = (long)bl2;
            id3FrameArray3 = id3FrameArray2;
            Id3Frame id3Frame = Id3Decoder.decodeFrame(n11, (ParsableByteArray)id3FrameArray, bl2, n12, (Id3Decoder$FramePredicate)id3FrameArray2);
            if (id3Frame == null) continue;
            ((ArrayList)object2).add(id3Frame);
        }
        object = new Id3Frame[]{};
        id3FrameArray3 = object = ((ArrayList)object2).toArray((T[])object);
        id3FrameArray3 = object;
        object3 = object;
        l11 = l14;
        object = new ChapterFrame(string3, n16, n17, l14, l16, id3FrameArray3);
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray object, int n10, int n11, boolean bl2, int n12, Id3Decoder$FramePredicate id3FrameArray) {
        ChapterTocFrame chapterTocFrame;
        Id3Frame[] id3FrameArray2;
        int n13;
        Object object2;
        int n14;
        Id3Frame[] id3FrameArray3 = object;
        int n15 = ((ParsableByteArray)object).getPosition();
        byte[] byArray = ((ParsableByteArray)object).getData();
        int n16 = Id3Decoder.indexOfZeroByte(byArray, n15);
        Object object3 = ((ParsableByteArray)object).getData();
        int n17 = n16 - n15;
        String string2 = "ISO-8859-1";
        String string3 = new String((byte[])object3, n15, n17, string2);
        int n18 = 1;
        float f10 = Float.MIN_VALUE;
        ((ParsableByteArray)object).setPosition(n16 += n18);
        n16 = ((ParsableByteArray)object).readUnsignedByte();
        n17 = n16 & 2;
        n17 = n17 != 0 ? n18 : 0;
        if ((n16 &= n18) != 0) {
            n16 = n18;
        } else {
            n16 = 0;
            byArray = null;
        }
        int n19 = ((ParsableByteArray)object).readUnsignedByte();
        String[] stringArray = new String[n19];
        for (n14 = 0; n14 < n19; ++n14) {
            String string4;
            int n20 = ((ParsableByteArray)object).getPosition();
            object2 = ((ParsableByteArray)object).getData();
            int n21 = Id3Decoder.indexOfZeroByte(object2, n20);
            byte[] byArray2 = ((ParsableByteArray)object).getData();
            int n22 = n21 - n20;
            stringArray[n14] = string4 = new String(byArray2, n20, n22, string2);
            id3FrameArray3.setPosition(n21 += n18);
        }
        object3 = new ArrayList;
        ((ArrayList)object3)();
        while ((n13 = ((ParsableByteArray)object).getPosition()) < (n15 += n10)) {
            void var4_5;
            n13 = n11;
            n19 = (int)(bl2 ? 1 : 0);
            n14 = var4_5;
            object2 = Id3Decoder.decodeFrame(n11, (ParsableByteArray)id3FrameArray3, bl2, (int)var4_5, (Id3Decoder$FramePredicate)id3FrameArray2);
            if (object2 == null) continue;
            ((ArrayList)object3).add(object2);
        }
        id3FrameArray3 = new Id3Frame[]{};
        id3FrameArray3 = ((ArrayList)object3).toArray(id3FrameArray3);
        object = chapterTocFrame;
        n11 = n17;
        int n23 = n16;
        id3FrameArray2 = id3FrameArray3;
        chapterTocFrame = new ChapterTocFrame(string3, n17 != 0, n16 != 0, stringArray, id3FrameArray3);
        return chapterTocFrame;
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray object, int n10) {
        int n11 = 4;
        if (n10 < n11) {
            return null;
        }
        int n12 = ((ParsableByteArray)object).readUnsignedByte();
        String string2 = Id3Decoder.getCharsetName(n12);
        int n13 = 3;
        byte[] byArray = new byte[n13];
        ((ParsableByteArray)object).readBytes(byArray, 0, n13);
        String string3 = new String(byArray, 0, n13);
        Object object2 = new byte[n10 -= n11];
        ((ParsableByteArray)object).readBytes((byte[])object2, 0, n10);
        int n14 = Id3Decoder.indexOfEos(object2, 0, n12);
        String string4 = new String((byte[])object2, 0, n14, string2);
        n13 = Id3Decoder.delimiterLength(n12);
        n12 = Id3Decoder.indexOfEos(object2, n14 += n13, n12);
        object = Id3Decoder.decodeStringIfValid(object2, n14, n12, string2);
        object2 = new CommentFrame;
        object2(string3, string4, (String)object);
        return object2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Id3Frame decodeFrame(int var0, ParsableByteArray var1_1, boolean var2_2, int var3_3, Id3Decoder$FramePredicate var4_4) {
        block50: {
            block49: {
                block46: {
                    block47: {
                        block48: {
                            var5_5 = var0;
                            var6_6 = var1_1;
                            var7_7 = var1_1.readUnsignedByte();
                            var8_8 = var1_1.readUnsignedByte();
                            var9_9 = var1_1.readUnsignedByte();
                            var10_10 = 3;
                            var12_12 = var0 >= var10_10 ? (var11_11 = var1_1.readUnsignedByte()) : 0;
                            var13_13 = 4;
                            if (var5_5 == var13_13) {
                                var11_11 = var1_1.readUnsignedIntToInt();
                                if (!var2_2) {
                                    var14_14 = var11_11 & 255;
                                    var15_15 = (var11_11 >> 8 & 255) << 7;
                                    var14_14 |= var15_15;
                                    var15_15 = (var11_11 >> 16 & 255) << 14;
                                    var11_11 = (var11_11 >> 24 & 255) << 21 | (var14_14 |= var15_15);
                                }
lbl17:
                                // 5 sources

                                while (true) {
                                    var16_16 = var11_11;
                                    if (var5_5 < var10_10) break block46;
                                    break block47;
                                    break;
                                }
                            }
                            if (var5_5 != var10_10) break block48;
                            var11_11 = var1_1.readUnsignedIntToInt();
                            ** GOTO lbl17
                        }
                        var11_11 = var1_1.readUnsignedInt24();
                        ** while (true)
                    }
                    var17_17 = var11_11 = var1_1.readUnsignedShort();
                    break block49;
                }
                var17_17 = 0;
            }
            if (var7_7 == 0 && var8_8 == 0 && var9_9 == 0 && var12_12 == 0 && var16_16 == 0 && var17_17 == 0) {
                var5_5 = var1_1.limit();
                var6_6.setPosition(var5_5);
                return null;
            }
            var18_18 = var1_1.getPosition() + var16_16;
            var11_11 = var1_1.limit();
            var19_19 = "Id3Decoder";
            if (var18_18 > var11_11) {
                Log.w(var19_19, "Frame size exceeds remaining tag data");
                var5_5 = var1_1.limit();
                var6_6.setPosition(var5_5);
                return null;
            }
            if (var4_4 != null) {
                var20_20 = var4_4;
                var14_14 = var0;
                var15_15 = var7_7;
                var21_21 = var19_19;
                var22_22 = var8_8;
                var13_13 = var18_18;
                var18_18 = var9_9;
                var23_23 = var17_17;
                var17_17 = var12_12;
                var11_11 = (int)var4_4.evaluate(var0, var7_7, var8_8, var9_9, var12_12);
                if (var11_11 == 0) {
                    var6_6.setPosition(var13_13);
                    return null;
                }
            } else {
                var21_21 = var19_19;
                var13_13 = var18_18;
                var23_23 = var17_17;
            }
            var11_11 = 1;
            var24_24 = 1.4E-45f;
            if (var5_5 == var10_10) {
                var14_14 = var23_23;
                var15_15 = var23_23 & 128;
                if (var15_15 != 0) {
                    var15_15 = var11_11;
                    var25_25 = var24_24;
                } else {
                    var15_15 = 0;
                    var25_25 = 0.0f;
                    var26_26 = null;
                }
                var22_22 = var14_14 & 64;
                if (var22_22 != 0) {
                    var22_22 = var11_11;
                    var27_27 = var24_24;
                } else {
                    var22_22 = 0;
                    var27_27 = 0.0f;
                    var19_19 = null;
                }
                if ((var14_14 &= 32) != 0) {
                    var14_14 = var11_11;
                } else {
                    var14_14 = 0;
                    var28_28 = null;
                }
                var29_29 = var15_15;
                var30_30 = var25_25;
                var17_17 = 0;
            } else {
                var14_14 = var23_23;
                var15_15 = 4;
                var25_25 = 5.6E-45f;
                if (var5_5 == var15_15) {
                    var15_15 = var23_23 & 64;
                    if (var15_15 != 0) {
                        var15_15 = var11_11;
                        var25_25 = var24_24;
                    } else {
                        var15_15 = 0;
                        var25_25 = 0.0f;
                        var26_26 = null;
                    }
                    var22_22 = var14_14 & 8;
                    if (var22_22 != 0) {
                        var22_22 = var11_11;
                        var27_27 = var24_24;
                    } else {
                        var22_22 = 0;
                        var27_27 = 0.0f;
                        var19_19 = null;
                    }
                    var18_18 = var14_14 & 4;
                    if (var18_18 != 0) {
                        var18_18 = var11_11;
                        var31_33 = var24_24;
                    } else {
                        var18_18 = 0;
                        var31_33 = 0.0f;
                    }
                    var17_17 = var14_14 & 2;
                    var17_17 = var17_17 != 0 ? var11_11 : 0;
                    if ((var14_14 &= var11_11) != 0) {
                        var29_29 = var11_11;
                        var30_31 = var24_24;
                    } else {
                        var29_29 = 0;
                        var30_31 = 0.0f;
                    }
                    var14_14 = var15_15;
                    var15_15 = var29_29;
                    var25_25 = var30_31;
                    var29_29 = var22_22;
                    var30_31 = var27_27;
                    var22_22 = var18_18;
                    var27_27 = var31_33;
                } else {
                    var14_14 = 0;
                    var28_28 = null;
                    var15_15 = 0;
                    var25_25 = 0.0f;
                    var26_26 = null;
                    var22_22 = 0;
                    var27_27 = 0.0f;
                    var19_19 = null;
                    var17_17 = 0;
                    var29_29 = 0;
                    var30_32 = 0.0f;
                }
            }
            if (var29_29 != 0 || var22_22 != 0) break block50;
            if (var14_14 != 0) {
                var16_16 += -1;
                var6_6.skipBytes(var11_11);
            }
            if (var15_15 != 0) {
                var16_16 += -4;
                var11_11 = 4;
                var24_24 = 5.6E-45f;
                var6_6.skipBytes(var11_11);
            }
            if (var17_17 != 0) {
                var16_16 = Id3Decoder.removeUnsynchronization(var6_6, var16_16);
            }
            var11_11 = 84;
            var24_24 = 1.18E-43f;
            var14_14 = 2;
            var15_15 = 88;
            var25_25 = 1.23E-43f;
            if (var7_7 != var11_11 || var8_8 != var15_15 || var9_9 != var15_15 || var5_5 != var14_14 && var12_12 != var15_15) ** GOTO lbl166
            var20_20 = Id3Decoder.decodeTxxxFrame(var6_6, var16_16);
            ** GOTO lbl241
lbl166:
            // 1 sources

            if (var7_7 != var11_11) ** GOTO lbl172
            var20_20 = Id3Decoder.getFrameId(var5_5, var7_7, var8_8, var9_9, var12_12);
            var20_20 = Id3Decoder.decodeTextInformationFrame(var6_6, var16_16, (String)var20_20);
            ** GOTO lbl241
            {
                block52: {
                    block54: {
                        block53: {
                            block51: {
                                catch (Throwable var32_34) {
                                }
lbl172:
                                // 1 sources

                                var22_22 = 87;
                                var27_27 = 1.22E-43f;
                                if (var7_7 != var22_22 || var8_8 != var15_15 || var9_9 != var15_15 || var5_5 != var14_14 && var12_12 != var15_15) break block51;
                                var20_20 = Id3Decoder.decodeWxxxFrame(var6_6, var16_16);
                                break block52;
                            }
                            if (var7_7 != var22_22) break block53;
                            var20_20 = Id3Decoder.getFrameId(var5_5, var7_7, var8_8, var9_9, var12_12);
                            var20_20 = Id3Decoder.decodeUrlLinkFrame(var6_6, var16_16, (String)var20_20);
                            break block52;
                        }
                        var15_15 = 73;
                        var25_25 = 1.02E-43f;
                        var22_22 = 80;
                        var27_27 = 1.12E-43f;
                        if (var7_7 != var22_22) break block54;
                        var18_18 = 82;
                        var31_33 = 1.15E-43f;
                        if (var8_8 != var18_18 || var9_9 != var15_15) break block54;
                        var18_18 = 86;
                        var31_33 = 1.2E-43f;
                        if (var12_12 != var18_18) break block54;
                        var20_20 = Id3Decoder.decodePrivFrame(var6_6, var16_16);
                        break block52;
                    }
                    var18_18 = 71;
                    var31_33 = 1.0E-43f;
                    var17_17 = 79;
                    if (var7_7 != var18_18) ** GOTO lbl-1000
                    var18_18 = 69;
                    var31_33 = 9.7E-44f;
                    if (var8_8 != var18_18 || var9_9 != var17_17) ** GOTO lbl-1000
                    var18_18 = 66;
                    var31_33 = 9.2E-44f;
                    if (var12_12 == var18_18 || var5_5 == var14_14) {
                        var20_20 = Id3Decoder.decodeGeobFrame(var6_6, var16_16);
                    } else lbl-1000:
                    // 3 sources

                    {
                        var18_18 = 65;
                        var31_33 = 9.1E-44f;
                        var10_10 = 67;
                        if (var5_5 == var14_14 ? var7_7 == var22_22 && var8_8 == var15_15 && var9_9 == var10_10 : var7_7 == var18_18 && var8_8 == var22_22 && var9_9 == var15_15 && var12_12 == var10_10) {
                            var20_20 = Id3Decoder.decodeApicFrame(var6_6, var16_16, var5_5);
                        } else {
                            var15_15 = 77;
                            var25_25 = 1.08E-43f;
                            if (var7_7 == var10_10 && var8_8 == var17_17 && var9_9 == var15_15 && (var12_12 == var15_15 || var5_5 == var14_14)) {
                                var20_20 = Id3Decoder.decodeCommentFrame(var6_6, var16_16);
                            } else if (var7_7 == var10_10 && var8_8 == (var14_14 = 72) && var9_9 == var18_18 && var12_12 == var22_22) {
                                var20_20 = var1_1;
                                var14_14 = var16_16;
                                var15_15 = var0;
                                var22_22 = (int)var2_2;
                                var18_18 = var3_3;
                                var20_20 = Id3Decoder.decodeChapterFrame(var1_1, var16_16, var0, var2_2, var3_3, var4_4);
                            } else if (var7_7 == var10_10 && var8_8 == var11_11 && var9_9 == var17_17 && var12_12 == var10_10) {
                                var20_20 = var1_1;
                                var14_14 = var16_16;
                                var15_15 = var0;
                                var22_22 = (int)var2_2;
                                var18_18 = var3_3;
                                var20_20 = Id3Decoder.decodeChapterTOCFrame(var1_1, var16_16, var0, var2_2, var3_3, var4_4);
                            } else if (var7_7 == var15_15 && var8_8 == (var14_14 = 76) && var9_9 == var14_14 && var12_12 == var11_11) {
                                var20_20 = Id3Decoder.decodeMlltFrame(var6_6, var16_16);
                            } else {
                                var20_20 = Id3Decoder.getFrameId(var5_5, var7_7, var8_8, var9_9, var12_12);
                                var20_20 = Id3Decoder.decodeBinaryFrame(var6_6, var16_16, (String)var20_20);
                            }
                        }
                    }
                }
                if (var20_20 == null) {
                    var32_35 = Id3Decoder.getFrameId(var5_5, var7_7, var8_8, var9_9, var12_12);
                    var28_28 = String.valueOf(var32_35);
                    var14_14 = var28_28.length() + 50;
                    var26_26 = new StringBuilder(var14_14);
                    var28_28 = "Failed to decode frame: id=";
                    var26_26.append(var28_28);
                    var26_26.append(var32_35);
                    var32_35 = ", frameSize=";
                    var26_26.append(var32_35);
                    var26_26.append(var16_16);
                    var32_35 = var26_26.toString();
                    Log.w(var21_21, var32_35);
                }
                var6_6.setPosition(var13_13);
                return var20_20;
                catch (UnsupportedEncodingException v0) {}
                var32_36 = "Unsupported character encoding";
                {
                    Log.w(var21_21, var32_36);
                    var6_6.setPosition(var13_13);
                    return null;
                }
            }
            var6_6.setPosition(var13_13);
            throw var32_34;
        }
        Log.w(var21_21, "Skipping unsupported compressed or encrypted frame");
        var6_6.setPosition(var13_13);
        return null;
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray object, int n10) {
        int n11 = ((ParsableByteArray)object).readUnsignedByte();
        String string2 = Id3Decoder.getCharsetName(n11);
        byte[] byArray = new byte[n10 += -1];
        ((ParsableByteArray)object).readBytes(byArray, 0, n10);
        int n12 = Id3Decoder.indexOfZeroByte(byArray, 0);
        String string3 = new String(byArray, 0, n12, "ISO-8859-1");
        int n13 = Id3Decoder.indexOfEos(byArray, ++n12, n11);
        object = Id3Decoder.decodeStringIfValid(byArray, n12, n13, string2);
        int n14 = Id3Decoder.delimiterLength(n11);
        n13 += n14;
        n14 = Id3Decoder.indexOfEos(byArray, n13, n11);
        string2 = Id3Decoder.decodeStringIfValid(byArray, n13, n14, string2);
        n11 = Id3Decoder.delimiterLength(n11);
        byte[] byArray2 = Id3Decoder.copyOfRangeIfValid(byArray, n14 += n11, n10);
        GeobFrame geobFrame = new GeobFrame(string3, (String)object, string2, byArray2);
        return geobFrame;
    }

    private static Id3Decoder$Id3Header decodeHeader(ParsableByteArray object) {
        String string2;
        int n10;
        block18: {
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            block16: {
                int n17;
                block17: {
                    int n18;
                    block15: {
                        n10 = ((ParsableByteArray)object).bytesLeft();
                        n17 = 0;
                        string2 = TAG;
                        n16 = 10;
                        if (n10 < n16) {
                            Log.w(string2, "Data too short to be an ID3 tag");
                            return null;
                        }
                        n10 = ((ParsableByteArray)object).readUnsignedInt24();
                        n16 = 0x494433;
                        n15 = 0;
                        n14 = 1;
                        if (n10 != n16) {
                            Object object2;
                            object = "Unexpected first three bytes of ID3 tag header: 0x";
                            Object[] objectArray = new Object[n14];
                            objectArray[0] = object2 = Integer.valueOf(n10);
                            object2 = String.valueOf(String.format("%06X", objectArray));
                            n16 = ((String)object2).length();
                            object = n16 != 0 ? ((String)object).concat((String)object2) : (object2 = new String((String)object));
                            Log.w(string2, (String)object);
                            return null;
                        }
                        n10 = ((ParsableByteArray)object).readUnsignedByte();
                        ((ParsableByteArray)object).skipBytes(n14);
                        n16 = ((ParsableByteArray)object).readUnsignedByte();
                        n13 = ((ParsableByteArray)object).readSynchSafeInt();
                        n18 = 2;
                        n12 = 4;
                        if (n10 != n18) break block15;
                        n11 = n16 & 0x40;
                        if (n11 != 0) {
                            n11 = n14;
                        } else {
                            n11 = 0;
                            object = null;
                        }
                        if (n11 != 0) {
                            Log.w(string2, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                            return null;
                        }
                        break block16;
                    }
                    n18 = 3;
                    if (n10 != n18) break block17;
                    n17 = n16 & 0x40;
                    n17 = n17 != 0 ? n14 : 0;
                    if (n17 != 0) {
                        n17 = ((ParsableByteArray)object).readInt();
                        ((ParsableByteArray)object).skipBytes(n17);
                        n13 -= (n17 += n12);
                    }
                    break block16;
                }
                if (n10 != n12) break block18;
                n17 = n16 & 0x40;
                n17 = n17 != 0 ? n14 : 0;
                if (n17 != 0) {
                    n17 = ((ParsableByteArray)object).readSynchSafeInt();
                    int n19 = n17 + -4;
                    ((ParsableByteArray)object).skipBytes(n19);
                    n13 -= n17;
                }
                if ((n11 = n16 & 0x10) != 0) {
                    n11 = n14;
                } else {
                    n11 = 0;
                    object = null;
                }
                if (n11 != 0) {
                    n13 += -10;
                }
            }
            if (n10 < n12 && (n11 = n16 & 0x80) != 0) {
                n15 = n14;
            }
            object = new Id3Decoder$Id3Header(n10, n15 != 0, n13);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder(57);
        stringBuilder.append("Skipped ID3 tag with unsupported majorVersion=");
        stringBuilder.append(n10);
        object = stringBuilder.toString();
        Log.w(string2, (String)object);
        return null;
    }

    private static MlltFrame decodeMlltFrame(ParsableByteArray object, int n10) {
        int n11 = ((ParsableByteArray)object).readUnsignedShort();
        int n12 = ((ParsableByteArray)object).readUnsignedInt24();
        int n13 = ((ParsableByteArray)object).readUnsignedInt24();
        int n14 = ((ParsableByteArray)object).readUnsignedByte();
        int n15 = ((ParsableByteArray)object).readUnsignedByte();
        Object object2 = new ParsableBitArray();
        ((ParsableBitArray)object2).reset((ParsableByteArray)object);
        n10 = (n10 + -10) * 8;
        int n16 = n14 + n15;
        object = new int[n10 /= n16];
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n17 = ((ParsableBitArray)object2).readBits(n14);
            int n18 = ((ParsableBitArray)object2).readBits(n15);
            object[i10] = n17;
            nArray[i10] = n18;
        }
        object2 = nArray;
        MlltFrame mlltFrame = new MlltFrame(n11, n12, n13, (int[])object, nArray);
        return mlltFrame;
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray object, int n10) {
        byte[] byArray = new byte[n10];
        ((ParsableByteArray)object).readBytes(byArray, 0, n10);
        int n11 = Id3Decoder.indexOfZeroByte(byArray, 0);
        String string2 = new String(byArray, 0, n11, "ISO-8859-1");
        object = Id3Decoder.copyOfRangeIfValid(byArray, ++n11, n10);
        PrivFrame privFrame = new PrivFrame(string2, (byte[])object);
        return privFrame;
    }

    private static String decodeStringIfValid(byte[] byArray, int n10, int n11, String string2) {
        int n12;
        if (n11 > n10 && n11 <= (n12 = byArray.length)) {
            String string3 = new String(byArray, n10, n11 -= n10, string2);
            return string3;
        }
        return "";
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray object, int n10, String string2) {
        int n11 = 1;
        if (n10 < n11) {
            return null;
        }
        int n12 = ((ParsableByteArray)object).readUnsignedByte();
        String string3 = Id3Decoder.getCharsetName(n12);
        byte[] byArray = new byte[n10 -= n11];
        ((ParsableByteArray)object).readBytes(byArray, 0, n10);
        int n13 = Id3Decoder.indexOfEos(byArray, 0, n12);
        String string4 = new String(byArray, 0, n13, string3);
        object = new TextInformationFrame(string2, null, string4);
        return object;
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray object, int n10) {
        int n11 = 1;
        if (n10 < n11) {
            return null;
        }
        int n12 = ((ParsableByteArray)object).readUnsignedByte();
        String string2 = Id3Decoder.getCharsetName(n12);
        Object object2 = new byte[n10 -= n11];
        ((ParsableByteArray)object).readBytes((byte[])object2, 0, n10);
        int n13 = Id3Decoder.indexOfEos(object2, 0, n12);
        String string3 = new String((byte[])object2, 0, n13, string2);
        int n14 = Id3Decoder.delimiterLength(n12);
        n12 = Id3Decoder.indexOfEos(object2, n13 += n14, n12);
        object = Id3Decoder.decodeStringIfValid(object2, n13, n12, string2);
        object2 = new TextInformationFrame;
        object2("TXXX", string3, (String)object);
        return object2;
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray object, int n10, String string2) {
        byte[] byArray = new byte[n10];
        ((ParsableByteArray)object).readBytes(byArray, 0, n10);
        int n11 = Id3Decoder.indexOfZeroByte(byArray, 0);
        String string3 = new String(byArray, 0, n11, "ISO-8859-1");
        object = new UrlLinkFrame(string2, null, string3);
        return object;
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray object, int n10) {
        int n11 = 1;
        if (n10 < n11) {
            return null;
        }
        int n12 = ((ParsableByteArray)object).readUnsignedByte();
        String string2 = Id3Decoder.getCharsetName(n12);
        Object object2 = new byte[n10 -= n11];
        ((ParsableByteArray)object).readBytes((byte[])object2, 0, n10);
        int n13 = Id3Decoder.indexOfEos(object2, 0, n12);
        String string3 = new String((byte[])object2, 0, n13, string2);
        n12 = Id3Decoder.delimiterLength(n12);
        n13 += n12;
        n12 = Id3Decoder.indexOfZeroByte(object2, n13);
        object = Id3Decoder.decodeStringIfValid(object2, n13, n12, "ISO-8859-1");
        object2 = new UrlLinkFrame;
        object2("WXXX", string3, (String)object);
        return object2;
    }

    private static int delimiterLength(int n10) {
        int n11;
        n10 = n10 != 0 && n10 != (n11 = 3) ? 2 : 1;
        return n10;
    }

    private static String getCharsetName(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return "ISO-8859-1";
                }
                return "UTF-8";
            }
            return "UTF-16BE";
        }
        return "UTF-16";
    }

    private static String getFrameId(int n10, int n11, int n12, int n13, int n14) {
        Object object;
        int n15 = 3;
        int n16 = 1;
        int n17 = 2;
        if (n10 == n17) {
            Object object2;
            object = Locale.US;
            Object[] objectArray = new Object[n15];
            objectArray[0] = object2 = Integer.valueOf(n11);
            objectArray[n16] = object2 = Integer.valueOf(n12);
            objectArray[n17] = object2 = Integer.valueOf(n13);
            object2 = "%c%c%c";
            object = String.format((Locale)object, (String)object2, objectArray);
        } else {
            Object object3;
            object = Locale.US;
            int n18 = 4;
            Object[] objectArray = new Object[n18];
            objectArray[0] = object3 = Integer.valueOf(n11);
            objectArray[n16] = object3 = Integer.valueOf(n12);
            objectArray[n17] = object3 = Integer.valueOf(n13);
            objectArray[n15] = object3 = Integer.valueOf(n14);
            object3 = "%c%c%c%c";
            object = String.format((Locale)object, (String)object3, objectArray);
        }
        return object;
    }

    private static int indexOfEos(byte[] byArray, int n10, int n11) {
        int n12;
        n10 = Id3Decoder.indexOfZeroByte(byArray, n10);
        if (n11 != 0 && n11 != (n12 = 3)) {
            while (n10 < (n11 = byArray.length + -1)) {
                n11 = n10 % 2;
                if (n11 == 0) {
                    n11 = n10 + 1;
                    if ((n11 = byArray[n11]) == 0) {
                        return n10;
                    }
                }
                ++n10;
                n10 = Id3Decoder.indexOfZeroByte(byArray, n10);
            }
            return byArray.length;
        }
        return n10;
    }

    private static int indexOfZeroByte(byte[] byArray, int n10) {
        int n11;
        while (n10 < (n11 = byArray.length)) {
            n11 = byArray[n10];
            if (n11 == 0) {
                return n10;
            }
            ++n10;
        }
        return byArray.length;
    }

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray, int n10) {
        int n11;
        int n12;
        int n13;
        byte[] byArray = parsableByteArray.getData();
        int n14 = n13 = parsableByteArray.getPosition();
        while ((n12 = n14 + 1) < (n11 = n13 + n10)) {
            n11 = byArray[n14];
            int n15 = 255;
            if ((n11 &= n15) == n15 && (n11 = byArray[n12]) == 0) {
                n11 = n14 - n13;
                n11 = n10 - n11 + -2;
                System.arraycopy(byArray, n14 += 2, byArray, n12, n11);
                n10 += -1;
            }
            n14 = n12;
        }
        return n10;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean validateFrames(ParsableByteArray parsableByteArray, int n10, int n11, boolean bl2) {
        int n12;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int n13 = n10;
        int n14 = parsableByteArray.getPosition();
        while (true) {
            long l10;
            long l11;
            long l12;
            int n15;
            block17: {
                block18: {
                    block16: {
                        int n16;
                        int n17;
                        block15: {
                            block14: {
                                n15 = parsableByteArray.bytesLeft();
                                n12 = 1;
                                if (n15 < n11) break;
                                n15 = 3;
                                if (n13 >= n15) {
                                    n17 = parsableByteArray.readInt();
                                    l12 = parsableByteArray.readUnsignedInt();
                                    n16 = parsableByteArray.readUnsignedShort();
                                    break block14;
                                }
                                n17 = parsableByteArray.readUnsignedInt24();
                                int n18 = parsableByteArray.readUnsignedInt24();
                                l12 = n18;
                                n16 = 0;
                            }
                            long l13 = 0L;
                            if (n17 == 0 && (n17 = (int)(l12 == l13 ? 0 : (l12 < l13 ? -1 : 1))) == 0 && n16 == 0) {
                                parsableByteArray2.setPosition(n14);
                                return n12 != 0;
                            }
                            n17 = 4;
                            if (n13 == n17 && !bl2) {
                                long l14 = 0x808080L & l12;
                                long l15 = l14 - l13;
                                Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                                if (object != false) {
                                    parsableByteArray2.setPosition(n14);
                                    return false;
                                }
                                l13 = 255L;
                                l14 = l12 & l13;
                                long l16 = (l12 >> 8 & l13) << 7;
                                l14 |= l16;
                                l16 = l12 >> 16 & l13;
                                int n19 = 14;
                                int n20 = 24;
                                l12 = l12 >> n20 & l13;
                                object = 21;
                                l12 = l12 << object | (l14 |= (l16 <<= n19));
                            }
                            if (n13 != n17) break block15;
                            n15 = n16 & 0x40;
                            n15 = n15 != 0 ? n12 : 0;
                            n17 = n16 & 1;
                            if (n17 == 0) break block16;
                            break block17;
                        }
                        if (n13 != n15) break block18;
                        n15 = n16 & 0x20;
                        n15 = n15 != 0 ? n12 : 0;
                        n17 = n16 & 0x80;
                        if (n17 != 0) break block17;
                    }
                    n12 = 0;
                    break block17;
                }
                n15 = 0;
                n12 = 0;
            }
            if (n12 != 0) {
                n15 += 4;
            }
            if ((n15 = (int)((l11 = l12 - (l10 = (long)n15)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) < 0) {
                parsableByteArray2.setPosition(n14);
                return false;
            }
            l10 = parsableByteArray.bytesLeft();
            n15 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1));
            if (n15 < 0) {
                parsableByteArray2.setPosition(n14);
                return false;
            }
            n15 = (int)l12;
            parsableByteArray2.skipBytes(n15);
            continue;
            break;
        }
        parsableByteArray2.setPosition(n14);
        return n12 != 0;
        catch (Throwable throwable) {
            parsableByteArray2.setPosition(n14);
            throw throwable;
        }
    }

    public Metadata decode(MetadataInputBuffer object, ByteBuffer byteBuffer) {
        object = byteBuffer.array();
        int n10 = byteBuffer.limit();
        return this.decode((byte[])object, n10);
    }

    public Metadata decode(byte[] object, int n10) {
        int n11;
        ArrayList<Id3Frame> arrayList = new ArrayList<Id3Frame>();
        Object object2 = new ParsableByteArray((byte[])object, n10);
        object = Id3Decoder.decodeHeader((ParsableByteArray)object2);
        n10 = 0;
        Id3Frame id3Frame = null;
        if (object == null) {
            return null;
        }
        int n12 = ((ParsableByteArray)object2).getPosition();
        int n13 = Id3Decoder$Id3Header.access$000((Id3Decoder$Id3Header)object);
        n13 = n13 == (n11 = 2) ? 6 : 10;
        n11 = Id3Decoder$Id3Header.access$100((Id3Decoder$Id3Header)object);
        boolean bl2 = Id3Decoder$Id3Header.access$200((Id3Decoder$Id3Header)object);
        if (bl2) {
            n11 = Id3Decoder$Id3Header.access$100((Id3Decoder$Id3Header)object);
            n11 = Id3Decoder.removeUnsynchronization((ParsableByteArray)object2, n11);
        }
        ((ParsableByteArray)object2).setLimit(n12 += n11);
        n12 = Id3Decoder$Id3Header.access$000((Id3Decoder$Id3Header)object);
        n11 = 0;
        n12 = (int)(Id3Decoder.validateFrames((ParsableByteArray)object2, n12, n13, false) ? 1 : 0);
        bl2 = true;
        if (n12 == 0) {
            n12 = Id3Decoder$Id3Header.access$000((Id3Decoder$Id3Header)object);
            if (n12 == (n11 = 4) && (n12 = (int)(Id3Decoder.validateFrames((ParsableByteArray)object2, n11, n13, bl2) ? 1 : 0)) != 0) {
                n11 = (int)(bl2 ? 1 : 0);
            } else {
                int n14 = Id3Decoder$Id3Header.access$000((Id3Decoder$Id3Header)object);
                object2 = new StringBuilder(56);
                ((StringBuilder)object2).append("Failed to validate ID3 tag with majorVersion=");
                ((StringBuilder)object2).append(n14);
                object = ((StringBuilder)object2).toString();
                Log.w(TAG, (String)object);
                return null;
            }
        }
        while ((n10 = ((ParsableByteArray)object2).bytesLeft()) >= n13) {
            Id3Decoder$FramePredicate id3Decoder$FramePredicate;
            n10 = Id3Decoder$Id3Header.access$000((Id3Decoder$Id3Header)object);
            id3Frame = Id3Decoder.decodeFrame(n10, (ParsableByteArray)object2, n11 != 0, n13, id3Decoder$FramePredicate = this.framePredicate);
            if (id3Frame == null) continue;
            arrayList.add(id3Frame);
        }
        object = new Metadata;
        object(arrayList);
        return object;
    }
}

