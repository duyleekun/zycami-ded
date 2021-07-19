/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom;
import com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom;
import com.google.android.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator;
import com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData;
import com.google.android.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox;
import com.google.android.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox;
import com.google.android.exoplayer2.extractor.mp4.AtomParsers$TkhdData;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results;
import com.google.android.exoplayer2.extractor.mp4.MetadataUtil;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.extractor.mp4.TrackSampleTable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private AtomParsers() {
    }

    private static boolean canApplyEditWithGaplessInfo(long[] lArray, long l10, long l11, long l12) {
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        int n10 = lArray.length;
        int n11 = 1;
        int n12 = 4;
        int n13 = Util.constrainValue(n12, 0, n10 -= n11);
        int n14 = lArray.length - n12;
        n10 = Util.constrainValue(n14, 0, n10);
        long l18 = lArray[0];
        long l19 = l18 - l11;
        n12 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
        if (n12 > 0 || (l17 = (l16 = l11 - (l15 = lArray[n13])) == 0L ? 0 : (l16 < 0L ? -1 : 1)) >= 0 || (l14 = (l13 = (l11 = lArray[n10]) - l12) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0 || (l14 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) > 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int n10, int n11) {
        int n12;
        int n13 = parsableByteArray.getPosition();
        while ((n12 = n13 - n10) < n11) {
            parsableByteArray.setPosition(n13);
            n12 = parsableByteArray.readInt();
            int n14 = n12 > 0 ? 1 : 0;
            String string2 = "childAtomSize should be positive";
            Assertions.checkState(n14 != 0, string2);
            n14 = parsableByteArray.readInt();
            int n15 = 1702061171;
            if (n14 == n15) {
                return n13;
            }
            n13 += n12;
        }
        return -1;
    }

    private static int getTrackTypeForHdlr(int n10) {
        int n11 = 1936684398;
        if (n10 == n11) {
            return 1;
        }
        n11 = 1986618469;
        if (n10 == n11) {
            return 2;
        }
        n11 = 1952807028;
        if (n10 != n11 && n10 != (n11 = 1935832172) && n10 != (n11 = 1937072756) && n10 != (n11 = 1668047728)) {
            n11 = 1835365473;
            if (n10 == n11) {
                return 5;
            }
            return -1;
        }
        return 3;
    }

    public static void maybeSkipRemainingMetaAtomHeaderBytes(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        int n11 = parsableByteArray.readInt();
        int n12 = 1751411826;
        if (n11 != n12) {
            n10 += 4;
        }
        parsableByteArray.setPosition(n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static void parseAudioSampleEntry(ParsableByteArray var0, int var1_1, int var2_2, int var3_3, int var4_4, String var5_5, boolean var6_6, DrmInitData var7_7, AtomParsers$StsdData var8_8, int var9_9) {
        block23: {
            block27: {
                block31: {
                    block33: {
                        block38: {
                            block37: {
                                block36: {
                                    block35: {
                                        block34: {
                                            block32: {
                                                block30: {
                                                    block29: {
                                                        block28: {
                                                            block26: {
                                                                block25: {
                                                                    block24: {
                                                                        var10_10 = var0;
                                                                        var11_11 = var2_2;
                                                                        var12_12 = var3_3;
                                                                        var13_13 = var4_4;
                                                                        var14_14 = var5_5;
                                                                        var15_15 /* !! */  = var7_7;
                                                                        var16_16 = var8_8;
                                                                        var17_17 = var2_2 + 8;
                                                                        var18_18 = 8;
                                                                        var0.setPosition(var17_17 += var18_18);
                                                                        var17_17 = 6;
                                                                        if (var6_6) {
                                                                            var18_18 = var0.readUnsignedShort();
                                                                            var0.skipBytes(var17_17);
                                                                        } else {
                                                                            var0.skipBytes(var18_18);
                                                                            var18_18 = 0;
                                                                            var19_19 = null;
                                                                        }
                                                                        var20_20 = 16;
                                                                        var21_21 = 2;
                                                                        var22_22 = 1;
                                                                        if (var18_18 == 0 || var18_18 == var22_22) ** GOTO lbl33
                                                                        if (var18_18 == var21_21) {
                                                                            var10_10.skipBytes(var20_20);
                                                                            var23_23 = var0.readDouble();
                                                                            var25_24 = Math.round(var23_23);
                                                                            var17_17 = (int)var25_24;
                                                                            var18_18 = var0.readUnsignedIntToInt();
                                                                            var20_20 = 20;
                                                                            var10_10.skipBytes(var20_20);
                                                                        } else {
                                                                            return;
lbl33:
                                                                            // 1 sources

                                                                            var27_25 = var0.readUnsignedShort();
                                                                            var10_10.skipBytes(var17_17);
                                                                            var17_17 = var0.readUnsignedFixedPoint1616();
                                                                            if (var18_18 == var22_22) {
                                                                                var10_10.skipBytes(var20_20);
                                                                            }
                                                                            var18_18 = var27_25;
                                                                        }
                                                                        var20_20 = var0.getPosition();
                                                                        var27_25 = 1701733217;
                                                                        var28_26 = var1_1;
                                                                        if (var1_1 == var27_25) {
                                                                            var29_27 /* !! */  = AtomParsers.parseSampleEntryEncryptionData((ParsableByteArray)var10_10, var11_11, var12_12);
                                                                            if (var29_27 /* !! */  != null) {
                                                                                var30_28 = (Integer)var29_27 /* !! */ .first;
                                                                                var28_26 = var30_28.intValue();
                                                                                if (var15_15 /* !! */  == null) {
                                                                                    var31_29 /* !! */  = null;
                                                                                } else {
                                                                                    var31_29 /* !! */  = ((TrackEncryptionBox)var29_27 /* !! */ .second).schemeType;
                                                                                    var31_29 /* !! */  = var15_15 /* !! */  = var15_15 /* !! */ .copyWithSchemeType((String)var31_29 /* !! */ );
                                                                                }
                                                                                var15_15 /* !! */  = var16_16.trackEncryptionBoxes;
                                                                                var29_27 /* !! */  = (TrackEncryptionBox)var29_27 /* !! */ .second;
                                                                                var15_15 /* !! */ [var9_9] = var29_27 /* !! */ ;
                                                                            } else {
                                                                                var31_29 /* !! */  = var15_15 /* !! */ ;
                                                                            }
                                                                            var10_10.setPosition(var20_20);
                                                                        } else {
                                                                            var31_29 /* !! */  = var15_15 /* !! */ ;
                                                                        }
                                                                        var32_30 = 1633889587;
                                                                        var27_25 = 1634492771;
                                                                        var33_31 = "audio/raw";
                                                                        if (var28_26 == var32_30) {
                                                                            var33_31 = "audio/ac3";
lbl65:
                                                                            // 14 sources

                                                                            while (true) {
                                                                                var32_30 = -1;
                                                                                break block23;
                                                                                break;
                                                                            }
                                                                        }
                                                                        var32_30 = 1700998451;
                                                                        if (var28_26 != var32_30) break block24;
                                                                        var33_31 = "audio/eac3";
                                                                        ** GOTO lbl65
                                                                    }
                                                                    var32_30 = 1633889588;
                                                                    if (var28_26 != var32_30) break block25;
                                                                    var33_31 = "audio/ac4";
                                                                    ** GOTO lbl65
                                                                }
                                                                var32_30 = 1685353315;
                                                                if (var28_26 != var32_30) break block26;
                                                                var33_31 = "audio/vnd.dts";
                                                                ** GOTO lbl65
                                                            }
                                                            var32_30 = 1685353320;
                                                            if (var28_26 == var32_30 || var28_26 == (var32_30 = 1685353324)) break block27;
                                                            var32_30 = 1685353317;
                                                            if (var28_26 != var32_30) break block28;
                                                            var33_31 = "audio/vnd.dts.hd;profile=lbr";
                                                            ** GOTO lbl65
                                                        }
                                                        var32_30 = 1935764850;
                                                        if (var28_26 != var32_30) break block29;
                                                        var33_31 = "audio/3gpp";
                                                        ** GOTO lbl65
                                                    }
                                                    var32_30 = 1935767394;
                                                    if (var28_26 != var32_30) break block30;
                                                    var33_31 = "audio/amr-wb";
                                                    ** GOTO lbl65
                                                }
                                                var32_30 = 1819304813;
                                                if (var28_26 == var32_30 || var28_26 == (var32_30 = 1936684916)) break block31;
                                                var32_30 = 1953984371;
                                                if (var28_26 != var32_30) break block32;
                                                var32_30 = 0x10000000;
                                                break block23;
                                            }
                                            var32_30 = 778924082;
                                            if (var28_26 == var32_30 || var28_26 == (var32_30 = 778924083)) break block33;
                                            if (var28_26 != var27_25) break block34;
                                            var33_31 = "audio/alac";
                                            ** GOTO lbl65
                                        }
                                        var32_30 = 1634492791;
                                        if (var28_26 != var32_30) break block35;
                                        var33_31 = "audio/g711-alaw";
                                        ** GOTO lbl65
                                    }
                                    var32_30 = 1970037111;
                                    if (var28_26 != var32_30) break block36;
                                    var33_31 = "audio/g711-mlaw";
                                    ** GOTO lbl65
                                }
                                var32_30 = 1332770163;
                                if (var28_26 != var32_30) break block37;
                                var33_31 = "audio/opus";
                                ** GOTO lbl65
                            }
                            var32_30 = 1716281667;
                            if (var28_26 != var32_30) break block38;
                            var33_31 = "audio/flac";
                            ** GOTO lbl65
                        }
                        var32_30 = -1;
                        var33_31 = null;
                        break block23;
                    }
                    var33_31 = "audio/mpeg";
                    ** GOTO lbl65
                }
                var32_30 = 2;
                break block23;
            }
            var33_31 = "audio/vnd.dts.hd";
            ** while (true)
        }
        var34_32 = var33_31;
        var28_26 = 0;
        var30_28 = null;
        var35_33 /* !! */  = null;
        while ((var27_25 = var20_20 - var11_11) < var12_12) {
            block46: {
                block41: {
                    block39: {
                        block47: {
                            block45: {
                                block44: {
                                    block43: {
                                        block42: {
                                            block40: {
                                                var10_10.setPosition(var20_20);
                                                var27_25 = var0.readInt();
                                                if (var27_25 <= 0) {
                                                    var22_22 = 0;
                                                    var36_34 = null;
                                                }
                                                var37_35 = "childAtomSize should be positive";
                                                Assertions.checkState((boolean)var22_22, var37_35);
                                                var38_36 = var0.readInt();
                                                var22_22 = 1702061171;
                                                if (var38_36 == var22_22) break block39;
                                                if (!var6_6 || var38_36 != (var22_22 = 2002876005)) break block40;
                                                var11_11 = 1702061171;
                                                var12_12 = 0;
                                                var39_37 = null;
                                                var22_22 = 1;
                                                var40_38 = 2;
                                                break block41;
                                            }
                                            var22_22 = 1684103987;
                                            if (var38_36 != var22_22) break block42;
                                            var38_36 = var20_20 + 8;
                                            var10_10.setPosition(var38_36);
                                            var37_35 = Integer.toString(var4_4);
                                            var16_16.format = var37_35 = Ac3Util.parseAc3AnnexFFormat((ParsableByteArray)var10_10, (String)var37_35, var14_14, (DrmInitData)var31_29 /* !! */ );
lbl175:
                                            // 4 sources

                                            while (true) {
                                                var11_11 = 1634492771;
                                                var38_36 = 0;
                                                var37_35 = null;
                                                var22_22 = 1;
                                                var40_38 = 2;
                                                ** GOTO lbl263
                                                break;
                                            }
                                        }
                                        var22_22 = 1684366131;
                                        if (var38_36 != var22_22) break block43;
                                        var38_36 = var20_20 + 8;
                                        var10_10.setPosition(var38_36);
                                        var37_35 = Integer.toString(var4_4);
                                        var16_16.format = var37_35 = Ac3Util.parseEAc3AnnexFFormat((ParsableByteArray)var10_10, (String)var37_35, var14_14, (DrmInitData)var31_29 /* !! */ );
                                        ** GOTO lbl175
                                    }
                                    var22_22 = 1684103988;
                                    if (var38_36 != var22_22) break block44;
                                    var38_36 = var20_20 + 8;
                                    var10_10.setPosition(var38_36);
                                    var37_35 = Integer.toString(var4_4);
                                    var16_16.format = var37_35 = Ac4Util.parseAc4AnnexEFormat((ParsableByteArray)var10_10, (String)var37_35, var14_14, (DrmInitData)var31_29 /* !! */ );
                                    ** GOTO lbl175
                                }
                                var22_22 = 1684305011;
                                if (var38_36 == var22_22) {
                                    var37_35 = new Format$Builder();
                                    var16_16.format = var37_35 = var37_35.setId(var13_13).setSampleMimeType(var34_32).setChannelCount(var18_18).setSampleRate(var17_17).setDrmInitData((DrmInitData)var31_29 /* !! */ ).setLanguage(var14_14).build();
                                    ** continue;
                                }
                                var22_22 = 1682927731;
                                if (var38_36 != var22_22) break block45;
                                var38_36 = var27_25 + -8;
                                var36_34 = AtomParsers.opusMagic;
                                var11_11 = var36_34.length + var38_36;
                                var41_39 /* !! */  = (Pair)Arrays.copyOf(var36_34, var11_11);
                                var12_12 = var20_20 + 8;
                                var10_10.setPosition(var12_12);
                                var12_12 = var36_34.length;
                                var10_10.readBytes((byte[])var41_39 /* !! */ , var12_12, var38_36);
                                var35_33 /* !! */  = var41_39 /* !! */  = OpusUtil.buildInitializationData((byte[])var41_39 /* !! */ );
                                var38_36 = -1;
                                var22_22 = 1;
                                var40_38 = 2;
                                break block46;
                            }
                            var11_11 = 1684425825;
                            if (var38_36 != var11_11) break block47;
                            var11_11 = var27_25 + -12;
                            var12_12 = var11_11 + 4;
                            var39_37 = new byte[var12_12];
                            var36_34 = null;
                            var39_37[0] = 102;
                            var22_22 = 1;
                            var39_37[var22_22] = 76;
                            var40_38 = 2;
                            var39_37[var40_38] = 97;
                            var42_40 = 67;
                            var39_37[3] = var42_40;
                            var38_36 = var20_20 + 12;
                            var10_10.setPosition(var38_36);
                            var38_36 = 4;
                            var10_10.readBytes((byte[])var39_37, var38_36, var11_11);
                            var35_33 /* !! */  = var41_39 /* !! */  = ImmutableList.of(var39_37);
                            ** GOTO lbl263
                        }
                        var11_11 = 1634492771;
                        var22_22 = 1;
                        var40_38 = 2;
                        if (var38_36 == var11_11) {
                            var12_12 = var27_25 + -12;
                            var43_41 /* !! */  = new byte[var12_12];
                            var18_18 = var20_20 + 12;
                            var10_10.setPosition(var18_18);
                            var37_35 = null;
                            var10_10.readBytes(var43_41 /* !! */ , 0, var12_12);
                            var39_37 = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(var43_41 /* !! */ );
                            var19_19 = (Integer)var39_37.first;
                            var18_18 = var19_19;
                            var39_37 = (Integer)var39_37.second;
                            var12_12 = var39_37.intValue();
                            var43_41 /* !! */  = (byte[])ImmutableList.of((Object)var43_41 /* !! */ );
                            var35_33 /* !! */  = (Pair)var43_41 /* !! */ ;
                            var17_17 = var18_18;
                            var38_36 = -1;
                            var18_18 = var12_12;
                        } else {
                            var38_36 = 0;
                            var37_35 = null;
lbl263:
                            // 3 sources

                            var38_36 = -1;
                        }
                        break block46;
                    }
                    var12_12 = 0;
                    var39_37 = null;
                    var22_22 = 1;
                    var40_38 = 2;
                    var11_11 = 1702061171;
                }
                var11_11 = var38_36 == var11_11 ? var20_20 : AtomParsers.findEsdsPosition((ParsableByteArray)var10_10, var20_20, var27_25);
                var38_36 = -1;
                if (var11_11 != var38_36) {
                    var41_39 /* !! */  = AtomParsers.parseEsdsFromParent((ParsableByteArray)var10_10, var11_11);
                    var34_32 = (String)var41_39 /* !! */ .first;
                    var41_39 /* !! */  = (Pair)((byte[])var41_39 /* !! */ .second);
                    if (var41_39 /* !! */  != null) {
                        var39_37 = "audio/mp4a-latm";
                        var12_12 = (int)var39_37.equals(var34_32);
                        if (var12_12 != 0) {
                            var39_37 = AacUtil.parseAudioSpecificConfig((byte[])var41_39 /* !! */ );
                            var17_17 = var39_37.sampleRateHz;
                            var18_18 = var39_37.channelCount;
                            var30_28 = var39_37.codecs;
                        }
                        var35_33 /* !! */  = ImmutableList.of(var41_39 /* !! */ );
                    }
                }
            }
            var20_20 += var27_25;
            var11_11 = var2_2;
            var12_12 = var3_3;
        }
        var10_10 = var16_16.format;
        if (var10_10 == null && var34_32 != null) {
            var10_10 = new Format$Builder();
            var10_10 = var10_10.setId(var13_13).setSampleMimeType(var34_32).setCodecs((String)var30_28).setChannelCount(var18_18).setSampleRate(var17_17).setPcmEncoding(var32_30);
            var41_39 /* !! */  = var35_33 /* !! */ ;
            var16_16.format = var10_10 = var10_10.setInitializationData((List)var35_33 /* !! */ ).setDrmInitData((DrmInitData)var31_29 /* !! */ ).setLanguage(var14_14).build();
        }
    }

    public static Pair parseCommonEncryptionSinfFromParent(ParsableByteArray object, int n10, int n11) {
        int n12;
        int n13 = n10 + 8;
        boolean bl2 = false;
        int n14 = -1;
        int n15 = 0;
        int n16 = n14;
        int n17 = 0;
        String string2 = null;
        int n18 = 0;
        Integer n19 = null;
        while ((n12 = n13 - n10) < n11) {
            ((ParsableByteArray)object).setPosition(n13);
            n12 = ((ParsableByteArray)object).readInt();
            int n20 = ((ParsableByteArray)object).readInt();
            int n21 = 1718775137;
            if (n20 == n21) {
                n18 = ((ParsableByteArray)object).readInt();
                n19 = n18;
            } else {
                n21 = 1935894637;
                if (n20 == n21) {
                    n17 = 4;
                    ((ParsableByteArray)object).skipBytes(n17);
                    string2 = ((ParsableByteArray)object).readString(n17);
                } else {
                    n21 = 1935894633;
                    if (n20 == n21) {
                        n16 = n13;
                        n15 = n12;
                    }
                }
            }
            n13 += n12;
        }
        String string3 = "cenc";
        n10 = (int)(string3.equals(string2) ? 1 : 0);
        if (n10 == 0 && (n10 = (int)((string3 = "cbc1").equals(string2) ? 1 : 0)) == 0 && (n10 = (int)((string3 = "cens").equals(string2) ? 1 : 0)) == 0 && (n10 = (int)((string3 = "cbcs").equals(string2) ? 1 : 0)) == 0) {
            return null;
        }
        string3 = "frma atom is mandatory";
        Assertions.checkStateNotNull(n19, string3);
        if (n16 != n14) {
            bl2 = true;
        }
        Assertions.checkState(bl2, "schi atom is mandatory");
        object = (TrackEncryptionBox)Assertions.checkStateNotNull(AtomParsers.parseSchiFromParent((ParsableByteArray)object, n16, n15, string2), "tenc atom is mandatory");
        return Pair.create((Object)n19, (Object)object);
    }

    private static Pair parseEdts(Atom$ContainerAtom object) {
        int n10 = 1701606260;
        if ((object = ((Atom$ContainerAtom)object).getLeafAtomOfType(n10)) == null) {
            return null;
        }
        object = ((Atom$LeafAtom)object).data;
        ((ParsableByteArray)object).setPosition(8);
        n10 = Atom.parseFullAtomVersion(((ParsableByteArray)object).readInt());
        int n11 = ((ParsableByteArray)object).readUnsignedIntToInt();
        long[] lArray = new long[n11];
        long[] lArray2 = new long[n11];
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            int n13 = 1;
            long l10 = n10 == n13 ? ((ParsableByteArray)object).readUnsignedLongToLong() : ((ParsableByteArray)object).readUnsignedInt();
            lArray[i10] = l10;
            if (n10 == n13) {
                l10 = ((ParsableByteArray)object).readLong();
            } else {
                n12 = ((ParsableByteArray)object).readInt();
                l10 = n12;
            }
            lArray2[i10] = l10;
            n12 = ((ParsableByteArray)object).readShort();
            if (n12 == n13) {
                n13 = 2;
                ((ParsableByteArray)object).skipBytes(n13);
                continue;
            }
            object = new IllegalArgumentException("Unsupported media rate.");
            throw object;
        }
        return Pair.create((Object)lArray, (Object)lArray2);
    }

    private static Pair parseEsdsFromParent(ParsableByteArray parsableByteArray, int n10) {
        n10 = n10 + 8 + 4;
        parsableByteArray.setPosition(n10);
        n10 = 1;
        parsableByteArray.skipBytes(n10);
        AtomParsers.parseExpandableClassSize(parsableByteArray);
        int n11 = 2;
        parsableByteArray.skipBytes(n11);
        int n12 = parsableByteArray.readUnsignedByte();
        int n13 = n12 & 0x80;
        if (n13 != 0) {
            parsableByteArray.skipBytes(n11);
        }
        if ((n13 = n12 & 0x40) != 0) {
            n13 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(n13);
        }
        if ((n12 &= 0x20) != 0) {
            parsableByteArray.skipBytes(n11);
        }
        parsableByteArray.skipBytes(n10);
        AtomParsers.parseExpandableClassSize(parsableByteArray);
        n11 = parsableByteArray.readUnsignedByte();
        String string2 = MimeTypes.getMimeTypeFromMp4ObjectType(n11);
        Object object = "audio/mpeg";
        n12 = (int)(((String)object).equals(string2) ? 1 : 0);
        if (n12 == 0 && (n12 = (int)(((String)(object = "audio/vnd.dts")).equals(string2) ? 1 : 0)) == 0 && (n12 = (int)(((String)(object = "audio/vnd.dts.hd")).equals(string2) ? 1 : 0)) == 0) {
            parsableByteArray.skipBytes(12);
            parsableByteArray.skipBytes(n10);
            n10 = AtomParsers.parseExpandableClassSize(parsableByteArray);
            object = new byte[n10];
            parsableByteArray.readBytes((byte[])object, 0, n10);
            return Pair.create((Object)string2, (Object)object);
        }
        return Pair.create((Object)string2, null);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int n10;
        int n11 = parsableByteArray.readUnsignedByte();
        int n12 = n11 & 0x7F;
        while ((n11 &= (n10 = 128)) == n10) {
            n11 = parsableByteArray.readUnsignedByte();
            n12 <<= 7;
            n10 = n11 & 0x7F;
            n12 |= n10;
        }
        return n12;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Metadata parseIlst(ParsableByteArray object, int n10) {
        int n11;
        int n12 = 8;
        ((ParsableByteArray)object).skipBytes(n12);
        ArrayList<Metadata$Entry> arrayList = new ArrayList<Metadata$Entry>();
        while ((n11 = ((ParsableByteArray)object).getPosition()) < n10) {
            Metadata$Entry metadata$Entry = MetadataUtil.parseIlstElement((ParsableByteArray)object);
            if (metadata$Entry == null) continue;
            arrayList.add(metadata$Entry);
        }
        boolean bl2 = arrayList.isEmpty();
        if (bl2) {
            bl2 = false;
            object = null;
        } else {
            object = new Metadata(arrayList);
        }
        return object;
    }

    private static Pair parseMdhd(ParsableByteArray object) {
        char c10 = '\b';
        ((ParsableByteArray)object).setPosition(c10);
        int c11 = Atom.parseFullAtomVersion(((ParsableByteArray)object).readInt());
        char c12 = c11 == 0 ? c10 : (char)'\u0010';
        ((ParsableByteArray)object).skipBytes(c12);
        long l10 = ((ParsableByteArray)object).readUnsignedInt();
        if (c11 == 0) {
            c10 = '\u0004';
        }
        ((ParsableByteArray)object).skipBytes(c10);
        int n10 = ((ParsableByteArray)object).readUnsignedShort();
        c10 = (char)((n10 >> 10 & 0x1F) + 96);
        char c13 = (char)((n10 >> 5 & 0x1F) + 96);
        char c14 = (char)((n10 & 0x1F) + 96);
        StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append(c10);
        stringBuilder.append(c13);
        stringBuilder.append(c14);
        object = stringBuilder.toString();
        return Pair.create((Object)l10, (Object)object);
    }

    public static Metadata parseMdtaFromMeta(Atom$ContainerAtom object) {
        int n10;
        int n11 = 1751411826;
        ArrayList<Object> arrayList = ((Atom$ContainerAtom)object).getLeafAtomOfType(n11);
        int n12 = 1801812339;
        Atom$LeafAtom atom$LeafAtom = ((Atom$ContainerAtom)object).getLeafAtomOfType(n12);
        object = ((Atom$ContainerAtom)object).getLeafAtomOfType(1768715124);
        Metadata metadata = null;
        if (arrayList != null && atom$LeafAtom != null && object != null && (n11 = AtomParsers.parseHdlr((ParsableByteArray)((Object)(arrayList = ((Atom$LeafAtom)arrayList).data)))) == (n10 = 1835299937)) {
            int n13;
            int n14;
            int n15;
            arrayList = atom$LeafAtom.data;
            ((ParsableByteArray)((Object)arrayList)).setPosition(12);
            n12 = ((ParsableByteArray)((Object)arrayList)).readInt();
            String[] stringArray = new String[n12];
            int n16 = 0;
            while (true) {
                String string2;
                n15 = 8;
                if (n16 >= n12) break;
                n14 = ((ParsableByteArray)((Object)arrayList)).readInt();
                n13 = 4;
                ((ParsableByteArray)((Object)arrayList)).skipBytes(n13);
                stringArray[n16] = string2 = ((ParsableByteArray)((Object)arrayList)).readString(n14 -= n15);
                ++n16;
            }
            object = ((Atom$LeafAtom)object).data;
            ((ParsableByteArray)object).setPosition(n15);
            arrayList = new ArrayList<Object>();
            while ((n16 = ((ParsableByteArray)object).bytesLeft()) > n15) {
                int n17;
                Object object2;
                n16 = ((ParsableByteArray)object).getPosition();
                n14 = ((ParsableByteArray)object).readInt();
                n13 = ((ParsableByteArray)object).readInt() + -1;
                if (n13 >= 0 && n13 < n12) {
                    object2 = stringArray[n13];
                    n17 = n16 + n14;
                    if ((object2 = MetadataUtil.parseMdtaMetadataEntryFromIlst((ParsableByteArray)object, n17, (String)object2)) != null) {
                        arrayList.add(object2);
                    }
                } else {
                    n17 = 52;
                    StringBuilder stringBuilder = new StringBuilder(n17);
                    stringBuilder.append("Skipped metadata with unknown key index: ");
                    stringBuilder.append(n13);
                    object2 = stringBuilder.toString();
                    String string3 = TAG;
                    Log.w(string3, (String)object2);
                }
                ((ParsableByteArray)object).setPosition(n16 += n14);
            }
            boolean bl2 = arrayList.isEmpty();
            if (!bl2) {
                metadata = new Metadata(arrayList);
            }
        }
        return metadata;
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray object, int n10, int n11, int n12, AtomParsers$StsdData atomParsers$StsdData) {
        n11 = n11 + 8 + 8;
        ((ParsableByteArray)object).setPosition(n11);
        n11 = 1835365492;
        if (n10 == n11) {
            ((ParsableByteArray)object).readNullTerminatedString();
            object = ((ParsableByteArray)object).readNullTerminatedString();
            if (object != null) {
                Format$Builder format$Builder = new Format$Builder();
                format$Builder = format$Builder.setId(n12);
                atomParsers$StsdData.format = object = format$Builder.setSampleMimeType((String)object).build();
            }
        }
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int n10 = 8;
        parsableByteArray.setPosition(n10);
        int n11 = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (n11 != 0) {
            n10 = 16;
        }
        parsableByteArray.skipBytes(n10);
        return parsableByteArray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int n10) {
        parsableByteArray.setPosition(n10 += 8);
        n10 = parsableByteArray.readUnsignedIntToInt();
        int n11 = parsableByteArray.readUnsignedIntToInt();
        float f10 = n10;
        float f11 = n11;
        return f10 / f11;
    }

    private static byte[] parseProjFromParent(ParsableByteArray object, int n10, int n11) {
        int n12;
        int n13 = n10 + 8;
        while ((n12 = n13 - n10) < n11) {
            ((ParsableByteArray)object).setPosition(n13);
            n12 = ((ParsableByteArray)object).readInt();
            int n14 = ((ParsableByteArray)object).readInt();
            int n15 = 1886547818;
            if (n14 == n15) {
                object = ((ParsableByteArray)object).getData();
                return Arrays.copyOfRange((byte[])object, n13, n12 += n13);
            }
            n13 += n12;
        }
        return null;
    }

    private static Pair parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int n10, int n11) {
        int n12;
        int n13 = parsableByteArray.getPosition();
        while ((n12 = n13 - n10) < n11) {
            Pair pair;
            int n14;
            parsableByteArray.setPosition(n13);
            n12 = parsableByteArray.readInt();
            if (n12 > 0) {
                n14 = 1;
            } else {
                n14 = 0;
                pair = null;
            }
            String string2 = "childAtomSize should be positive";
            Assertions.checkState(n14 != 0, string2);
            n14 = parsableByteArray.readInt();
            int n15 = 1936289382;
            if (n14 == n15 && (pair = AtomParsers.parseCommonEncryptionSinfFromParent(parsableByteArray, n13, n12)) != null) {
                return pair;
            }
            n13 += n12;
        }
        return null;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray object, int n10, int n11, String string2) {
        int n12 = n10 + 8;
        while (true) {
            int n13 = n12 - n10;
            byte[] byArray = null;
            if (n13 >= n11) break;
            ((ParsableByteArray)object).setPosition(n12);
            n13 = ((ParsableByteArray)object).readInt();
            int n14 = ((ParsableByteArray)object).readInt();
            int n15 = 1952804451;
            if (n14 == n15) {
                int n16;
                int n17;
                n10 = Atom.parseFullAtomVersion(((ParsableByteArray)object).readInt());
                n11 = 1;
                ((ParsableByteArray)object).skipBytes(n11);
                n12 = 0;
                if (n10 == 0) {
                    ((ParsableByteArray)object).skipBytes(n11);
                    n17 = 0;
                    n16 = 0;
                } else {
                    n10 = ((ParsableByteArray)object).readUnsignedByte();
                    n13 = (n10 & 0xF0) >> 4;
                    n16 = n10 &= 0xF;
                    n17 = n13;
                }
                n10 = ((ParsableByteArray)object).readUnsignedByte();
                n15 = n10 == n11 ? n11 : 0;
                int n18 = ((ParsableByteArray)object).readUnsignedByte();
                n10 = 16;
                byte[] byArray2 = new byte[n10];
                ((ParsableByteArray)object).readBytes(byArray2, 0, n10);
                if (n15 != 0 && n18 == 0) {
                    n10 = ((ParsableByteArray)object).readUnsignedByte();
                    byArray = new byte[n10];
                    ((ParsableByteArray)object).readBytes(byArray, 0, n10);
                }
                object = new TrackEncryptionBox(n15 != 0, string2, n18, byArray2, n17, n16, byArray);
                return object;
            }
            n12 += n13;
        }
        return null;
    }

    private static Metadata parseSmta(ParsableByteArray parsableByteArray, int n10) {
        int n11;
        int n12 = 12;
        parsableByteArray.skipBytes(n12);
        while ((n11 = parsableByteArray.getPosition()) < n10) {
            int n13;
            n11 = parsableByteArray.getPosition();
            int n14 = parsableByteArray.readInt();
            int n15 = parsableByteArray.readInt();
            if (n15 == (n13 = 1935766900)) {
                n10 = 14;
                float f10 = 2.0E-44f;
                if (n14 < n10) {
                    return null;
                }
                f10 = 7.0E-45f;
                parsableByteArray.skipBytes(5);
                n10 = parsableByteArray.readUnsignedByte();
                if (n10 != n12 && n10 != (n11 = 13)) {
                    return null;
                }
                if (n10 == n12) {
                    n10 = 1131413504;
                    f10 = 240.0f;
                } else {
                    n10 = 1123024896;
                    f10 = 120.0f;
                }
                n12 = 1;
                parsableByteArray.skipBytes(n12);
                int n16 = parsableByteArray.readUnsignedByte();
                Metadata$Entry[] metadata$EntryArray = new Metadata$Entry[n12];
                SmtaMetadataEntry smtaMetadataEntry = new SmtaMetadataEntry(f10, n16);
                metadata$EntryArray[0] = smtaMetadataEntry;
                Metadata metadata = new Metadata(metadata$EntryArray);
                return metadata;
            }
            parsableByteArray.setPosition(n11 += n14);
        }
        return null;
    }

    private static TrackSampleTable parseStbl(Track track, Atom$ContainerAtom object, GaplessInfoHolder object2) {
        Object object3;
        block56: {
            Object object4;
            long l10;
            int n10;
            Object object5;
            Object object6;
            long l11;
            int n11;
            long l12;
            Object object7;
            long l13;
            long l14;
            long l15;
            long l16;
            long l17;
            long l18;
            Object object8;
            int n12;
            Object object9;
            Object object10;
            Object object11;
            long l19;
            Object object12;
            long l20;
            long l21;
            long l22;
            Object object13;
            Object object14;
            int n13;
            int n14;
            Object object15;
            Object object16;
            Object object17;
            Object object18;
            int n15;
            Object object19;
            Object object20;
            Object object21;
            int n16;
            Object object22;
            int n17;
            Object object23;
            int n18;
            Object object24;
            Object object25;
            float f10;
            int n19;
            int n20;
            Object object26;
            Object object27;
            Object object28;
            Object object29;
            Object object30;
            Object object31;
            block64: {
                block63: {
                    block62: {
                        long l23;
                        long l24;
                        long l25;
                        block58: {
                            block61: {
                                int n21;
                                int n22;
                                String string2;
                                block60: {
                                    int n23;
                                    block59: {
                                        block53: {
                                            block52: {
                                                int n24;
                                                block57: {
                                                    block55: {
                                                        block54: {
                                                            object31 = track;
                                                            object3 = object;
                                                            object30 = object2;
                                                            object29 = 1937011578;
                                                            object28 = ((Atom$ContainerAtom)object).getLeafAtomOfType((int)object29);
                                                            if (object28 == null) break block54;
                                                            object27 = track.format;
                                                            object26 = new AtomParsers$StszSampleSizeBox((Atom$LeafAtom)object28, (Format)object27);
                                                            break block55;
                                                        }
                                                        object29 = 1937013298;
                                                        object28 = ((Atom$ContainerAtom)object).getLeafAtomOfType((int)object29);
                                                        if (object28 == null) break block56;
                                                        object26 = new AtomParsers$Stz2SampleSizeBox((Atom$LeafAtom)object28);
                                                    }
                                                    object29 = object26.getSampleCount();
                                                    n20 = 0;
                                                    object27 = null;
                                                    if (object29 == 0) {
                                                        TrackSampleTable trackSampleTable;
                                                        object30 = new long[0];
                                                        object28 = new int[0];
                                                        Object[] objectArray = new long[]{};
                                                        int[] nArray = new int[]{};
                                                        object3 = trackSampleTable;
                                                        object31 = track;
                                                        object27 = objectArray;
                                                        objectArray = nArray;
                                                        long l26 = 0L;
                                                        trackSampleTable = new TrackSampleTable(track, (long[])object30, (int[])object28, 0, (long[])object27, nArray, l26);
                                                        return trackSampleTable;
                                                    }
                                                    n19 = 1937007471;
                                                    f10 = 1.9362445E31f;
                                                    object25 = ((Atom$ContainerAtom)object3).getLeafAtomOfType(n19);
                                                    object24 = 1;
                                                    if (object25 == null) {
                                                        n19 = 1668232756;
                                                        f10 = 4.4126776E21f;
                                                        object25 = (Atom$LeafAtom)Assertions.checkNotNull(((Atom$ContainerAtom)object3).getLeafAtomOfType(n19));
                                                        n18 = object24;
                                                    } else {
                                                        n18 = 0;
                                                        object23 = null;
                                                    }
                                                    object25 = ((Atom$LeafAtom)object25).data;
                                                    n17 = 1937011555;
                                                    object22 = ((Atom$LeafAtom)Assertions.checkNotNull((Object)object3.getLeafAtomOfType((int)n17))).data;
                                                    n16 = 0x73747473;
                                                    object21 = ((Atom$LeafAtom)Assertions.checkNotNull((Object)object3.getLeafAtomOfType((int)n16))).data;
                                                    object20 = 0x73747373;
                                                    object19 = ((Atom$ContainerAtom)object3).getLeafAtomOfType((int)object20);
                                                    if (object19 != null) {
                                                        object19 = ((Atom$LeafAtom)object19).data;
                                                    } else {
                                                        object20 = 0;
                                                        object19 = null;
                                                    }
                                                    n15 = 1668576371;
                                                    object3 = ((Atom$ContainerAtom)object3).getLeafAtomOfType(n15);
                                                    if (object3 != null) {
                                                        object3 = ((Atom$LeafAtom)object3).data;
                                                    } else {
                                                        object18 = 0;
                                                        object3 = null;
                                                    }
                                                    object17 = new AtomParsers$ChunkIterator((ParsableByteArray)object22, (ParsableByteArray)object25, n18 != 0);
                                                    n19 = 12;
                                                    f10 = 1.7E-44f;
                                                    ((ParsableByteArray)object21).setPosition(n19);
                                                    n18 = ((ParsableByteArray)object21).readUnsignedIntToInt() - object24;
                                                    n17 = ((ParsableByteArray)object21).readUnsignedIntToInt();
                                                    object16 = ((ParsableByteArray)object21).readUnsignedIntToInt();
                                                    if (object3 != null) {
                                                        ((ParsableByteArray)object3).setPosition(n19);
                                                        object15 = ((ParsableByteArray)object3).readUnsignedIntToInt();
                                                    } else {
                                                        object15 = 0;
                                                        string2 = null;
                                                    }
                                                    n14 = -1;
                                                    if (object19 != null) {
                                                        ((ParsableByteArray)object19).setPosition(n19);
                                                        n19 = ((ParsableByteArray)object19).readUnsignedIntToInt();
                                                        if (n19 > 0) {
                                                            n13 = ((ParsableByteArray)object19).readUnsignedIntToInt() + -1;
                                                        } else {
                                                            n13 = n14;
                                                            object20 = 0;
                                                            object19 = null;
                                                        }
                                                    } else {
                                                        n19 = 0;
                                                        object25 = null;
                                                        f10 = 0.0f;
                                                        n13 = n14;
                                                    }
                                                    n20 = object26.getFixedSampleSize();
                                                    object14 = object31.format.sampleMimeType;
                                                    if (n20 != n14 && ((n14 = (int)(((String)(object13 = "audio/raw")).equals(object14) ? 1 : 0)) != 0 || (n14 = (int)(((String)(object13 = "audio/g711-mlaw")).equals(object14) ? 1 : 0)) != 0 || (object24 = (Object)((String)(object13 = "audio/g711-alaw")).equals(object14)) != 0) && n18 == 0 && object15 == 0 && n19 == 0) {
                                                        n22 = n18;
                                                        n14 = n17;
                                                        object24 = 1;
                                                    } else {
                                                        n22 = n18;
                                                        n14 = n17;
                                                        object24 = 0;
                                                        object14 = null;
                                                    }
                                                    if (object24 == 0) break block57;
                                                    object18 = ((AtomParsers$ChunkIterator)object17).length;
                                                    object26 = new long[object18];
                                                    object3 = new int[object18];
                                                    while ((n19 = (int)(((AtomParsers$ChunkIterator)object17).moveNext() ? 1 : 0)) != 0) {
                                                        n19 = ((AtomParsers$ChunkIterator)object17).index;
                                                        l22 = ((AtomParsers$ChunkIterator)object17).offset;
                                                        object26[n19] = l22;
                                                        object24 = ((AtomParsers$ChunkIterator)object17).numSamples;
                                                        object3[n19] = object24;
                                                    }
                                                    l21 = object16;
                                                    object3 = FixedSampleSizeRechunker.rechunk(n20, (long[])object26, (int[])object3, l21);
                                                    object26 = ((FixedSampleSizeRechunker$Results)object3).offsets;
                                                    object27 = ((FixedSampleSizeRechunker$Results)object3).sizes;
                                                    n19 = ((FixedSampleSizeRechunker$Results)object3).maximumSize;
                                                    object14 = ((FixedSampleSizeRechunker$Results)object3).timestamps;
                                                    object21 = ((FixedSampleSizeRechunker$Results)object3).flags;
                                                    l20 = ((FixedSampleSizeRechunker$Results)object3).duration;
                                                    object18 = object29;
                                                    object30 = object26;
                                                    object28 = object27;
                                                    object27 = object14;
                                                    object12 = object21;
                                                    l19 = l20;
                                                    object26 = object31;
                                                    break block58;
                                                }
                                                object27 = new long[object29];
                                                object14 = new int[object29];
                                                object23 = new long[object29];
                                                object22 = new int[object29];
                                                object11 = object21;
                                                object10 = n13;
                                                object9 = 0;
                                                object31 = null;
                                                n16 = 0;
                                                object21 = null;
                                                n12 = 0;
                                                object8 = null;
                                                int n25 = 0;
                                                n23 = 0;
                                                l25 = 0L;
                                                l24 = 0L;
                                                n13 = object15;
                                                object15 = object16;
                                                object16 = n14;
                                                while (true) {
                                                    int n26;
                                                    object13 = TAG;
                                                    if (object9 >= object29) break;
                                                    l18 = l24;
                                                    int n27 = n12;
                                                    n12 = 1;
                                                    while (n27 == 0 && (n12 = (int)(((AtomParsers$ChunkIterator)object17).moveNext() ? 1 : 0)) != 0) {
                                                        n21 = object16;
                                                        n26 = object15;
                                                        l17 = ((AtomParsers$ChunkIterator)object17).offset;
                                                        n24 = object29;
                                                        n27 = ((AtomParsers$ChunkIterator)object17).numSamples;
                                                        l18 = l17;
                                                        object29 = n24;
                                                    }
                                                    n24 = object29;
                                                    n21 = object16;
                                                    n26 = object15;
                                                    if (n12 == 0) {
                                                        object30 = "Unexpected end of chunk data";
                                                        Log.w((String)object13, (String)object30);
                                                        object27 = Arrays.copyOf((long[])object27, object9);
                                                        object14 = Arrays.copyOf((int[])object14, object9);
                                                        object23 = Arrays.copyOf((long[])object23, object9);
                                                        object22 = Arrays.copyOf((int[])object22, object9);
                                                        object29 = object9;
                                                        object10 = n25;
                                                        object9 = n27;
                                                        break block52;
                                                    }
                                                    if (object3 != null) {
                                                        while (n23 == 0 && n13 > 0) {
                                                            n23 = ((ParsableByteArray)object3).readUnsignedIntToInt();
                                                            n25 = ((ParsableByteArray)object3).readInt();
                                                            n13 += -1;
                                                        }
                                                        n23 += -1;
                                                    }
                                                    object29 = n25;
                                                    object27[object9] = l18;
                                                    n14 = object26.readNextSampleSize();
                                                    object14[object9] = n14;
                                                    n14 = (int)object14[object9];
                                                    if (n14 > n16) {
                                                        n16 = (int)object14[object9];
                                                    }
                                                    l17 = object29;
                                                    object23[object9] = l17 = l25 + l17;
                                                    if (object19 == null) {
                                                        n14 = 1;
                                                    } else {
                                                        n14 = 0;
                                                        object13 = null;
                                                    }
                                                    object22[object9] = n14;
                                                    if (object9 == object10) {
                                                        n14 = 1;
                                                        object22[object9] = n14;
                                                        if ((n19 += -1) > 0) {
                                                            object30 = (ParsableByteArray)Assertions.checkNotNull(object19);
                                                            object10 = ((ParsableByteArray)object30).readUnsignedIntToInt() - n14;
                                                        }
                                                    }
                                                    object15 = object10;
                                                    n14 = object29;
                                                    object16 = n26;
                                                    l16 = n26;
                                                    l25 += l16;
                                                    object10 = n21 + -1;
                                                    if (object10 == 0 && n22 > 0) {
                                                        object10 = ((ParsableByteArray)object11).readUnsignedIntToInt();
                                                        object29 = ((ParsableByteArray)object11).readInt();
                                                        object16 = n22 + -1;
                                                    } else {
                                                        object29 = object16;
                                                        object16 = n22;
                                                    }
                                                    n22 = object10;
                                                    object10 = object14[object9];
                                                    n12 = object29;
                                                    l16 = object10;
                                                    l16 = l18 + l16;
                                                    n25 = n27 + -1;
                                                    ++object9;
                                                    l24 = l16;
                                                    object10 = object15;
                                                    object15 = object29;
                                                    n12 = n25;
                                                    object29 = n24;
                                                    n25 = n14;
                                                    int n28 = object16;
                                                    object16 = n22;
                                                    n22 = n28;
                                                }
                                                n24 = object29;
                                                n21 = object16;
                                                object9 = n12;
                                                object10 = n25;
                                            }
                                            l15 = object10;
                                            l15 = l25 + l15;
                                            if (object3 != null) {
                                                while (n13 > 0) {
                                                    object10 = ((ParsableByteArray)object3).readUnsignedIntToInt();
                                                    if (object10 != 0) {
                                                        object18 = 0;
                                                        object3 = null;
                                                        break block53;
                                                    }
                                                    ((ParsableByteArray)object3).readInt();
                                                    n13 += -1;
                                                }
                                            }
                                            object18 = 1;
                                        }
                                        if (n19 != 0 || n21 != 0 || object9 != 0 || n22 != 0) break block59;
                                        object10 = n23;
                                        if (n23 != 0 || object18 == 0) break block60;
                                        object26 = track;
                                        n13 = object29;
                                        break block61;
                                    }
                                    object10 = n23;
                                }
                                object26 = track;
                                object20 = track.id;
                                object3 = object18 == 0 ? ", ctts invalid" : "";
                                object15 = ((String)object3).length() + 262;
                                n13 = object29;
                                object28 = new StringBuilder((int)object15);
                                string2 = "Inconsistent stbl box for track ";
                                ((StringBuilder)object28).append(string2);
                                ((StringBuilder)object28).append((int)object20);
                                object19 = ": remainingSynchronizationSamples ";
                                ((StringBuilder)object28).append((String)object19);
                                ((StringBuilder)object28).append(n19);
                                ((StringBuilder)object28).append(", remainingSamplesAtTimestampDelta ");
                                n19 = n21;
                                ((StringBuilder)object28).append(n21);
                                object25 = ", remainingSamplesInChunk ";
                                ((StringBuilder)object28).append((String)object25);
                                ((StringBuilder)object28).append((int)object9);
                                ((StringBuilder)object28).append(", remainingTimestampDeltaChanges ");
                                object9 = n22;
                                ((StringBuilder)object28).append(n22);
                                object31 = ", remainingSamplesAtTimestampOffset ";
                                ((StringBuilder)object28).append((String)object31);
                                ((StringBuilder)object28).append((int)object10);
                                ((StringBuilder)object28).append((String)object3);
                                object3 = ((StringBuilder)object28).toString();
                                Log.w((String)object13, (String)object3);
                            }
                            object30 = object27;
                            object28 = object14;
                            object27 = object23;
                            n19 = n16;
                            object18 = n13;
                            l19 = l15;
                            object12 = object22;
                        }
                        l14 = 1000000L;
                        l20 = ((Track)object26).timescale;
                        l13 = l19;
                        l13 = Util.scaleLargeTimestamp(l19, l14, l20);
                        object31 = ((Track)object26).editListDurations;
                        long l27 = 1000000L;
                        if (object31 == null) {
                            long l28 = ((Track)object26).timescale;
                            Util.scaleLargeTimestampsInPlace((long[])object27, l27, l28);
                            object3 = object22;
                            object31 = track;
                            object25 = object12;
                            object22 = new TrackSampleTable(track, (long[])object30, (int[])object28, n19, (long[])object27, (int[])object12, l13);
                            return object22;
                        }
                        object9 = ((Object)object31).length;
                        object24 = 1;
                        if (object9 != object24 || (object9 = ((Track)object26).type) != object24 || (object9 = ((Object)object27).length) < (object24 = 2)) break block62;
                        object31 = (long[])Assertions.checkNotNull(((Track)object26).editListMediaTimes);
                        object7 = object31[0];
                        object31 = ((Track)object26).editListDurations;
                        l12 = (long)object31[0];
                        l13 = ((Track)object26).timescale;
                        l14 = ((Track)object26).movieTimescale;
                        l25 = l13;
                        l24 = l14;
                        l13 = Util.scaleLargeTimestamp(l12, l13, l14);
                        l12 = (long)(object7 + l13);
                        object14 = object27;
                        long l29 = l19;
                        l22 = (long)object7;
                        n11 = object18;
                        l11 = l27;
                        l27 = l12;
                        object24 = AtomParsers.canApplyEditWithGaplessInfo((long[])object27, l19, (long)object7, l12);
                        if (object24 == 0) break block63;
                        l29 = l19 - l12;
                        l22 = (long)object27[0];
                        object6 = object7 - l22;
                        l22 = object26.format.sampleRate;
                        l27 = ((Track)object26).timescale;
                        l18 = l22;
                        l27 = Util.scaleLargeTimestamp((long)object6, l22, l27);
                        object14 = ((Track)object26).format;
                        object24 = ((Format)object14).sampleRate;
                        l22 = object24;
                        l11 = ((Track)object26).timescale;
                        object = object12;
                        l12 = l19;
                        l17 = l27;
                        l27 = l11;
                        l11 = Util.scaleLargeTimestamp(l29, l22, l11);
                        l13 = 0L;
                        long l30 = l17 - l13;
                        n17 = (int)(l30 == 0L ? 0 : (l30 < 0L ? -1 : 1));
                        if ((n17 != 0 || (n17 = (int)(l11 == l13 ? 0 : (l11 < l13 ? -1 : 1))) != 0) && (n17 = (int)((l23 = l17 - (l13 = Integer.MAX_VALUE)) == 0L ? 0 : (l23 < 0L ? -1 : 1))) <= 0 && (object24 = (Object)(l11 == l13 ? 0 : (l11 < l13 ? -1 : 1))) <= 0) {
                            object24 = (int)l17;
                            object23 = object2;
                            ((GaplessInfoHolder)object2).encoderDelay = object24;
                            ((GaplessInfoHolder)object2).encoderPadding = object18 = (int)l11;
                            l11 = ((Track)object26).timescale;
                            Util.scaleLargeTimestampsInPlace((long[])object27, 1000000L, l11);
                            l13 = ((Track)object26).editListDurations[0];
                            l20 = ((Track)object26).movieTimescale;
                            l13 = Util.scaleLargeTimestamp(l13, 1000000L, l20);
                            object3 = object22;
                            object31 = track;
                            object25 = object;
                            object22 = new TrackSampleTable(track, (long[])object30, (int[])object28, n19, (long[])object27, (int[])object, l13);
                            return object22;
                        }
                        break block64;
                    }
                    n11 = object18;
                }
                object = object12;
                l12 = l19;
            }
            if ((object9 = ((Object)(object3 = (Object)((Track)object26).editListDurations)).length) == (object24 = 1)) {
                object9 = 0;
                object31 = null;
                l13 = (long)object3[0];
                l14 = 0L;
                long l31 = l13 - l14;
                object24 = l31 == 0L ? 0 : (l31 < 0L ? -1 : 1);
                if (object24 == 0) {
                    l13 = ((long[])Assertions.checkNotNull(((Track)object26).editListMediaTimes))[0];
                    object3 = null;
                    for (object18 = 0; object18 < (object9 = ((Object)object27).length); ++object18) {
                        l20 = (long)(object27[object18] - l13);
                        l15 = 1000000L;
                        l19 = l14 = ((Track)object26).timescale;
                        l14 = Util.scaleLargeTimestamp(l20, l15, l14);
                        object27[object18] = l14;
                    }
                    l14 = l12 - l13;
                    l15 = ((Track)object26).timescale;
                    l13 = Util.scaleLargeTimestamp(l14, 1000000L, l15);
                    object3 = object22;
                    object31 = track;
                    object25 = object;
                    object22 = new TrackSampleTable(track, (long[])object30, (int[])object28, n19, (long[])object27, (int[])object, l13);
                    return object22;
                }
            }
            if ((object9 = ((Track)object26).type) == (object24 = 1)) {
                n14 = 1;
            } else {
                n14 = 0;
                object13 = null;
            }
            object9 = ((Object)object3).length;
            object31 = new int[object9];
            object18 = ((Object)object3).length;
            object3 = new int[object18];
            object14 = (long[])Assertions.checkNotNull(((Track)object26).editListMediaTimes);
            object23 = null;
            n17 = 0;
            object22 = null;
            n16 = 0;
            object21 = null;
            object20 = 0;
            object19 = null;
            for (n18 = 0; n18 < (object16 = ((Object)(object17 = (Object)((Track)object26).editListDurations)).length); ++n18) {
                l17 = (long)object14[n18];
                object7 = (long)-1;
                long l32 = l17 - object7;
                n13 = (int)(l32 == 0L ? 0 : (l32 < 0L ? -1 : 1));
                if (n13 != 0) {
                    object6 = object17[n18];
                    n15 = n19;
                    object2 = object14;
                    l21 = ((Track)object26).timescale;
                    object5 = object30;
                    object8 = object28;
                    l16 = ((Track)object26).movieTimescale;
                    l18 = l21;
                    l16 = Util.scaleLargeTimestamp((long)object6, l21, l16);
                    n19 = 1;
                    f10 = Float.MIN_VALUE;
                    object24 = Util.binarySearchFloor((long[])object27, l17, n19 != 0, n19 != 0);
                    object31[n18] = object24;
                    object10 = 0;
                    object30 = null;
                    object29 = Util.binarySearchCeil((long[])object27, l17 += l16, n14 != 0, false);
                    object3[n18] = object29;
                    while ((object29 = (Object)object31[n18]) < (object24 = (Object)object3[n18])) {
                        object29 = object31[n18];
                        if ((object29 = object[object29] & n19) != 0) break;
                        object29 = object31[n18] + n19;
                        object31[n18] = object29;
                    }
                    object29 = object3[n18];
                    object24 = object31[n18];
                    n16 += (object29 -= object24);
                    object29 = object31[n18];
                    if (object20 != object29) {
                        object29 = n19;
                    } else {
                        object29 = 0;
                        object28 = null;
                    }
                    object24 = object3[n18];
                    n17 = object29 |= n17;
                    object20 = object24;
                } else {
                    object5 = object30;
                    object8 = object28;
                    n15 = n19;
                    object2 = object14;
                    object10 = 0;
                    object30 = null;
                    n19 = 1;
                    f10 = Float.MIN_VALUE;
                }
                object14 = object2;
                n19 = n15;
                object30 = object5;
                object28 = object8;
            }
            object5 = object30;
            object8 = object28;
            n15 = n19;
            object29 = n11;
            object10 = 0;
            object30 = null;
            n19 = 1;
            f10 = Float.MIN_VALUE;
            if (n16 != n11) {
                object24 = n19;
            } else {
                object24 = 0;
                object14 = null;
            }
            object29 = n17 | object24;
            object25 = object29 != 0 ? (Object)new long[n16] : object5;
            object14 = object29 != 0 ? (Object)new int[n16] : object8;
            if (object29 != 0) {
                n15 = 0;
                object17 = null;
            }
            object23 = object29 != 0 ? (Object)new int[n16] : (Object)object;
            object22 = new long[n16];
            n16 = 0;
            object21 = null;
            l20 = 0L;
            while (object10 < (object16 = ((Object)(object12 = (Object)((Track)object26).editListDurations)).length)) {
                long l33;
                long l34;
                Object object32;
                Object object33;
                object12 = ((Track)object26).editListMediaTimes;
                Object object34 = object12[object10];
                object16 = object31[object10];
                object15 = object3[object10];
                Object object35 = object3;
                if (object29 != 0) {
                    object18 = object15 - object16;
                    object33 = object31;
                    object31 = object5;
                    System.arraycopy(object5, object16, object25, n16, object18);
                    object31 = object8;
                    System.arraycopy(object8, object16, object14, n16, object18);
                    n10 = n15;
                    object17 = object;
                    System.arraycopy(object, object16, object23, n16, object18);
                } else {
                    object33 = object31;
                    n10 = n15;
                    object31 = object8;
                    object17 = object;
                }
                object18 = n10;
                while (object16 < object15) {
                    long l35 = 1000000L;
                    object32 = object31;
                    n12 = object10;
                    l34 = ((Track)object26).movieTimescale;
                    l10 = l20;
                    object6 = l34;
                    l34 = Util.scaleLargeTimestamp(l20, l35, l34);
                    l10 = (long)object27[object16];
                    object11 = object27;
                    object4 = object25;
                    l33 = l10 - object34;
                    l10 = l20;
                    l20 = 0L;
                    long l36 = Math.max(l20, l33);
                    long l37 = 1000000L;
                    l33 = ((Track)object26).timescale;
                    l33 = Util.scaleLargeTimestamp(l36, l37, l33);
                    object22[n16] = l34 += l33;
                    if (object29 != 0 && (object9 = (Object)object14[n16]) > object18) {
                        object18 = object31[object16];
                    }
                    ++n16;
                    ++object16;
                    object10 = n12;
                    l20 = l10;
                    object27 = object11;
                    object31 = object32;
                    object25 = object4;
                }
                object32 = object31;
                n12 = object10;
                object11 = object27;
                object4 = object25;
                l10 = l20;
                l33 = ((Track)object26).editListDurations[object10];
                l34 = l20 + l33;
                n20 = object10 + 1;
                l20 = l34;
                object10 = n20;
                object = object17;
                object31 = object33;
                object8 = object32;
                n15 = object18;
                object3 = object35;
            }
            object4 = object25;
            l10 = l20;
            n10 = n15;
            l11 = ((Track)object26).movieTimescale;
            object6 = l11;
            l22 = Util.scaleLargeTimestamp(l20, 1000000L, l11);
            object3 = object13;
            object31 = track;
            object30 = object25;
            object28 = object14;
            object27 = object22;
            object25 = object23;
            l13 = l22;
            object13 = new TrackSampleTable(track, (long[])object4, (int[])object14, n15, (long[])object22, (int[])object23, l22);
            return object13;
        }
        object3 = new ParserException("Track has no sample table size information");
        throw object3;
    }

    private static AtomParsers$StsdData parseStsd(ParsableByteArray parsableByteArray, int n10, int n11, String string2, DrmInitData drmInitData, boolean bl2) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int n12 = n10;
        int n13 = 12;
        parsableByteArray.setPosition(n13);
        int n14 = parsableByteArray.readInt();
        AtomParsers$StsdData atomParsers$StsdData = new AtomParsers$StsdData(n14);
        for (int i10 = 0; i10 < n14; ++i10) {
            int n15;
            int n16;
            Object object;
            int n17 = parsableByteArray.getPosition();
            int n18 = parsableByteArray.readInt();
            if (n18 > 0) {
                n13 = 1;
            } else {
                n13 = 0;
                object = null;
            }
            String string3 = "childAtomSize should be positive";
            Assertions.checkState(n13 != 0, string3);
            int n19 = parsableByteArray.readInt();
            n13 = 1635148593;
            if (n19 != n13 && n19 != (n13 = 1635148595) && n19 != (n13 = 1701733238) && n19 != (n13 = 1831958048) && n19 != (n13 = 1836070006) && n19 != (n13 = 1752589105) && n19 != (n13 = 1751479857) && n19 != (n13 = 1932670515) && n19 != (n13 = 1987063864) && n19 != (n13 = 1987063865) && n19 != (n13 = 1635135537) && n19 != (n13 = 1685479798) && n19 != (n13 = 1685479729) && n19 != (n13 = 1685481573) && n19 != (n13 = 1685481521)) {
                n13 = 1836069985;
                if (n19 != n13 && n19 != (n13 = 1701733217) && n19 != (n13 = 1633889587) && n19 != (n13 = 1700998451) && n19 != (n13 = 1633889588) && n19 != (n13 = 1685353315) && n19 != (n13 = 1685353317) && n19 != (n13 = 1685353320) && n19 != (n13 = 1685353324) && n19 != (n13 = 1935764850) && n19 != (n13 = 1935767394) && n19 != (n13 = 1819304813) && n19 != (n13 = 1936684916) && n19 != (n13 = 1953984371) && n19 != (n13 = 778924082) && n19 != (n13 = 778924083) && n19 != (n13 = 1634492771) && n19 != (n13 = 1634492791) && n19 != (n13 = 1970037111) && n19 != (n13 = 1332770163) && n19 != (n13 = 1716281667)) {
                    n13 = 1414810956;
                    if (n19 != n13 && n19 != (n13 = 1954034535) && n19 != (n13 = 0x77767474) && n19 != (n13 = 1937010800) && n19 != (n13 = 1664495672)) {
                        n13 = 1835365492;
                        if (n19 == n13) {
                            AtomParsers.parseMetaDataSampleEntry(parsableByteArray2, n19, n17, n12, atomParsers$StsdData);
                        } else {
                            n13 = 1667329389;
                            if (n19 == n13) {
                                object = new Format$Builder();
                                object = ((Format$Builder)object).setId(n12);
                                string3 = "application/x-camera-motion";
                                atomParsers$StsdData.format = object = ((Format$Builder)object).setSampleMimeType(string3).build();
                            }
                        }
                    } else {
                        object = parsableByteArray;
                        n16 = n17;
                        AtomParsers.parseTextSampleEntry(parsableByteArray, n19, n17, n18, n10, string2, atomParsers$StsdData);
                    }
                    n15 = n17;
                } else {
                    object = parsableByteArray;
                    n16 = n17;
                    n15 = n17;
                    n17 = i10;
                    AtomParsers.parseAudioSampleEntry(parsableByteArray, n19, n16, n18, n10, string2, bl2, drmInitData, atomParsers$StsdData, i10);
                }
            } else {
                n15 = n17;
                object = parsableByteArray;
                n16 = n17;
                AtomParsers.parseVideoSampleEntry(parsableByteArray, n19, n17, n18, n10, n11, drmInitData, atomParsers$StsdData, i10);
            }
            n17 = n15 + n18;
            parsableByteArray2.setPosition(n17);
        }
        return atomParsers$StsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray object, int n10, int n11, int n12, int n13, String string2, AtomParsers$StsdData atomParsers$StsdData) {
        block6: {
            long l10;
            ImmutableList immutableList;
            String string3;
            block2: {
                int n14;
                block5: {
                    block4: {
                        block3: {
                            n11 = n11 + 8 + 8;
                            ((ParsableByteArray)object).setPosition(n11);
                            string3 = "application/ttml+xml";
                            immutableList = null;
                            l10 = Long.MAX_VALUE;
                            int n15 = 1414810956;
                            if (n10 == n15) break block2;
                            n15 = 1954034535;
                            if (n10 != n15) break block3;
                            n12 = n12 + -8 + -8;
                            byte[] byArray = new byte[n12];
                            n11 = 0;
                            ((ParsableByteArray)object).readBytes(byArray, 0, n12);
                            immutableList = ImmutableList.of((Object)byArray);
                            string3 = "application/x-quicktime-tx3g";
                            break block2;
                        }
                        n14 = 0x77767474;
                        if (n10 != n14) break block4;
                        string3 = "application/x-mp4-vtt";
                        break block2;
                    }
                    n14 = 1937010800;
                    if (n10 != n14) break block5;
                    l10 = 0L;
                    break block2;
                }
                n14 = 1664495672;
                if (n10 != n14) break block6;
                atomParsers$StsdData.requiredSampleTransformation = n14 = 1;
                string3 = "application/x-mp4-cea-608";
            }
            object = new Format$Builder();
            atomParsers$StsdData.format = object = ((Format$Builder)object).setId(n13).setSampleMimeType(string3).setLanguage(string2).setSubsampleOffsetUs(l10).setInitializationData(immutableList).build();
            return;
        }
        object = new IllegalStateException();
        throw object;
    }

    private static AtomParsers$TkhdData parseTkhd(ParsableByteArray object) {
        int n10;
        int n11;
        float f10;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        block10: {
            n16 = 8;
            ((ParsableByteArray)object).setPosition(n16);
            n15 = Atom.parseFullAtomVersion(((ParsableByteArray)object).readInt());
            n14 = 16;
            n13 = n15 == 0 ? n16 : n14;
            ((ParsableByteArray)object).skipBytes(n13);
            n13 = ((ParsableByteArray)object).readInt();
            n12 = 4;
            f10 = 5.6E-45f;
            ((ParsableByteArray)object).skipBytes(n12);
            n11 = ((ParsableByteArray)object).getPosition();
            if (n15 == 0) {
                n16 = n12;
            }
            n10 = 0;
            for (int i10 = 0; i10 < n16; ++i10) {
                byte[] byArray = ((ParsableByteArray)object).getData();
                int n17 = n11 + i10;
                byte by2 = byArray[n17];
                if (by2 == (n17 = -1)) continue;
                n11 = 0;
                break block10;
            }
            n11 = 1;
        }
        long l10 = -9223372036854775807L;
        if (n11 != 0) {
            ((ParsableByteArray)object).skipBytes(n16);
        } else {
            long l11;
            long l12 = n15 == 0 ? ((ParsableByteArray)object).readUnsignedInt() : ((ParsableByteArray)object).readUnsignedLongToLong();
            long l13 = l12 - (l11 = 0L);
            n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n11 != 0) {
                l10 = l12;
            }
        }
        ((ParsableByteArray)object).skipBytes(n14);
        n16 = ((ParsableByteArray)object).readInt();
        n15 = ((ParsableByteArray)object).readInt();
        ((ParsableByteArray)object).skipBytes(n12);
        n14 = ((ParsableByteArray)object).readInt();
        int n18 = ((ParsableByteArray)object).readInt();
        n12 = 65536;
        f10 = 9.18355E-41f;
        n11 = -65536;
        if (n16 == 0 && n15 == n12 && n14 == n11 && n18 == 0) {
            n10 = 90;
        } else if (n16 == 0 && n15 == n11 && n14 == n12 && n18 == 0) {
            n10 = 270;
        } else if (n16 == n11 && n15 == 0 && n14 == 0 && n18 == n11) {
            n10 = 180;
        }
        object = new AtomParsers$TkhdData(n13, l10, n10);
        return object;
    }

    private static Track parseTrak(Atom$ContainerAtom atom$ContainerAtom, Atom$LeafAtom atom$LeafAtom, long l10, DrmInitData drmInitData, boolean bl2, boolean bl3) {
        Object object;
        long l11;
        Object object2;
        long l12;
        Object object3 = atom$ContainerAtom;
        int n10 = 1835297121;
        Object object4 = (Atom$ContainerAtom)Assertions.checkNotNull(atom$ContainerAtom.getContainerAtomOfType(n10));
        int n11 = AtomParsers.getTrackTypeForHdlr(AtomParsers.parseHdlr(((Atom$LeafAtom)Assertions.checkNotNull((Object)object4.getLeafAtomOfType((int)1751411826))).data));
        Track track = null;
        int n12 = -1;
        if (n11 == n12) {
            return null;
        }
        n12 = 1953196132;
        Object object5 = AtomParsers.parseTkhd(((Atom$LeafAtom)Assertions.checkNotNull((Object)atom$ContainerAtom.getLeafAtomOfType((int)n12))).data);
        long l13 = -9223372036854775807L;
        long l14 = l10 - l13;
        Object object6 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object6 == false) {
            l12 = AtomParsers$TkhdData.access$000((AtomParsers$TkhdData)object5);
            object2 = atom$LeafAtom;
            l11 = l12;
        } else {
            object2 = atom$LeafAtom;
            l11 = l10;
        }
        object2 = ((Atom$LeafAtom)object2).data;
        l12 = AtomParsers.parseMvhd((ParsableByteArray)object2);
        object6 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
        if (object6 != false) {
            long l15 = 1000000L;
            l13 = Util.scaleLargeTimestamp(l11, l15, l12);
        }
        l11 = l13;
        object6 = 1835626086;
        object2 = (Atom$ContainerAtom)Assertions.checkNotNull(((Atom$ContainerAtom)Assertions.checkNotNull(((Atom$ContainerAtom)object4).getContainerAtomOfType((int)object6))).getContainerAtomOfType(1937007212));
        object4 = AtomParsers.parseMdhd(((Atom$LeafAtom)Assertions.checkNotNull((Object)object4.getLeafAtomOfType((int)1835296868))).data);
        int n13 = 1937011556;
        Object object7 = ((Atom$LeafAtom)Assertions.checkNotNull((Object)object2.getLeafAtomOfType((int)n13))).data;
        int n14 = AtomParsers$TkhdData.access$100((AtomParsers$TkhdData)object5);
        int n15 = AtomParsers$TkhdData.access$200((AtomParsers$TkhdData)object5);
        Object object8 = object2 = ((Pair)object4).second;
        object8 = (String)object2;
        Object object9 = drmInitData;
        object2 = AtomParsers.parseStsd((ParsableByteArray)object7, n14, n15, (String)object8, drmInitData, bl3);
        if (!bl2 && (object3 = ((Atom$ContainerAtom)object3).getContainerAtomOfType(n13 = 1701082227)) != null && (object3 = AtomParsers.parseEdts((Atom$ContainerAtom)object3)) != null) {
            long[] lArray = (long[])((Pair)object3).first;
            object = object3 = (Object)((long[])((Pair)object3).second);
            object9 = lArray;
        } else {
            object9 = null;
            object = null;
        }
        object3 = ((AtomParsers$StsdData)object2).format;
        if (object3 != null) {
            int n16 = AtomParsers$TkhdData.access$100((AtomParsers$TkhdData)object5);
            object4 = (Long)((Pair)object4).first;
            l13 = (Long)object4;
            object7 = ((AtomParsers$StsdData)object2).format;
            n14 = ((AtomParsers$StsdData)object2).requiredSampleTransformation;
            TrackEncryptionBox[] trackEncryptionBoxArray = ((AtomParsers$StsdData)object2).trackEncryptionBoxes;
            int n17 = ((AtomParsers$StsdData)object2).nalUnitLengthFieldLength;
            object5 = track;
            object6 = n16;
            track = new Track(n16, n11, l13, l12, l11, (Format)object7, n14, trackEncryptionBoxArray, n17, (long[])object9, (long[])object);
        }
        return track;
    }

    public static List parseTraks(Atom$ContainerAtom atom$ContainerAtom, GaplessInfoHolder gaplessInfoHolder, long l10, DrmInitData drmInitData, boolean bl2, boolean bl3, Function function) {
        Object object;
        int n10;
        Atom$ContainerAtom atom$ContainerAtom2 = atom$ContainerAtom;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = (object = atom$ContainerAtom2.containerChildren).size()); ++i10) {
            Object object2;
            Object object3;
            object = (Atom$ContainerAtom)atom$ContainerAtom2.containerChildren.get(i10);
            int n11 = ((Atom)object).type;
            int n12 = 1953653099;
            if (n11 != n12) {
                object3 = function;
                continue;
            }
            n11 = 1836476516;
            object3 = object2 = Assertions.checkNotNull(atom$ContainerAtom.getLeafAtomOfType(n11));
            object3 = (Atom$LeafAtom)object2;
            object2 = object;
            object2 = AtomParsers.parseTrak((Atom$ContainerAtom)object, (Atom$LeafAtom)object3, l10, drmInitData, bl2, bl3);
            object3 = function;
            if ((object2 = (Track)function.apply(object2)) == null) continue;
            object = (Atom$ContainerAtom)Assertions.checkNotNull(((Atom$ContainerAtom)Assertions.checkNotNull(((Atom$ContainerAtom)object).getContainerAtomOfType(1835297121))).getContainerAtomOfType(1835626086));
            int n13 = 1937007212;
            object = (Atom$ContainerAtom)Assertions.checkNotNull(((Atom$ContainerAtom)object).getContainerAtomOfType(n13));
            object = AtomParsers.parseStbl((Track)object2, (Atom$ContainerAtom)object, gaplessInfoHolder);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static Pair parseUdta(Atom$LeafAtom object) {
        int n10;
        object = ((Atom$LeafAtom)object).data;
        int n11 = 8;
        ((ParsableByteArray)object).setPosition(n11);
        int n12 = 0;
        Metadata metadata = null;
        int n13 = 0;
        Metadata metadata2 = null;
        while ((n10 = ((ParsableByteArray)object).bytesLeft()) >= n11) {
            int n14;
            n10 = ((ParsableByteArray)object).getPosition();
            int n15 = ((ParsableByteArray)object).readInt();
            int n16 = ((ParsableByteArray)object).readInt();
            if (n16 == (n14 = 1835365473)) {
                ((ParsableByteArray)object).setPosition(n10);
                n12 = n10 + n15;
                metadata = AtomParsers.parseUdtaMeta((ParsableByteArray)object, n12);
            } else {
                n14 = 1936553057;
                if (n16 == n14) {
                    ((ParsableByteArray)object).setPosition(n10);
                    n13 = n10 + n15;
                    metadata2 = AtomParsers.parseSmta((ParsableByteArray)object, n13);
                }
            }
            ((ParsableByteArray)object).setPosition(n10 += n15);
        }
        return Pair.create(metadata, metadata2);
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int n10) {
        int n11 = 8;
        parsableByteArray.skipBytes(n11);
        AtomParsers.maybeSkipRemainingMetaAtomHeaderBytes(parsableByteArray);
        while ((n11 = parsableByteArray.getPosition()) < n10) {
            int n12;
            n11 = parsableByteArray.getPosition();
            int n13 = parsableByteArray.readInt();
            int n14 = parsableByteArray.readInt();
            if (n14 == (n12 = 1768715124)) {
                parsableByteArray.setPosition(n11);
                return AtomParsers.parseIlst(parsableByteArray, n11 += n13);
            }
            parsableByteArray.setPosition(n11 += n13);
        }
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int n10, int n11, int n12, int n13, int n14, DrmInitData drmInitData, AtomParsers$StsdData atomParsers$StsdData, int n15) {
        void var21_35;
        void var18_19;
        void var30_77;
        void var33_84;
        float f10;
        int n16;
        int n17;
        int n18;
        DrmInitData drmInitData2;
        int n19;
        Object object;
        block29: {
            void var24_42;
            int n20;
            void var21_33;
            int n21;
            object = parsableByteArray;
            n19 = n11;
            int n22 = n12;
            drmInitData2 = drmInitData;
            AtomParsers$StsdData atomParsers$StsdData2 = atomParsers$StsdData;
            n18 = n11 + 8 + 8;
            parsableByteArray.setPosition(n18);
            parsableByteArray.skipBytes(16);
            n18 = parsableByteArray.readUnsignedShort();
            n17 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(50);
            int n23 = parsableByteArray.getPosition();
            int n24 = 0;
            Object var18_18 = null;
            int n25 = 1701733238;
            int n26 = n10;
            if (n10 == n25) {
                Pair pair = AtomParsers.parseSampleEntryEncryptionData(parsableByteArray, n11, n12);
                if (pair != null) {
                    TrackEncryptionBox trackEncryptionBox;
                    Integer n27 = (Integer)pair.first;
                    n26 = n27;
                    if (drmInitData == null) {
                        n21 = 0;
                        drmInitData2 = null;
                    } else {
                        String string2 = ((TrackEncryptionBox)pair.second).schemeType;
                        drmInitData2 = drmInitData.copyWithSchemeType(string2);
                    }
                    TrackEncryptionBox[] trackEncryptionBoxArray = atomParsers$StsdData2.trackEncryptionBoxes;
                    trackEncryptionBoxArray[n15] = trackEncryptionBox = (TrackEncryptionBox)pair.second;
                }
                ((ParsableByteArray)object).setPosition(n23);
            }
            if (n26 == (n25 = 1831958048)) {
                String string3 = "video/mpeg";
            } else {
                n25 = 0;
                Object var21_32 = null;
            }
            float f11 = 1.0f;
            n16 = -1;
            f10 = f11;
            boolean bl2 = false;
            int n28 = 0;
            Object var24_41 = null;
            void var30_76 = var21_33;
            n25 = 0;
            Object var21_34 = null;
            while ((n20 = n23 - n19) < n22) {
                block33: {
                    block42: {
                        Object object2;
                        block34: {
                            block43: {
                                block44: {
                                    block45: {
                                        block41: {
                                            block40: {
                                                float f12;
                                                block39: {
                                                    Object object3;
                                                    block38: {
                                                        block36: {
                                                            block37: {
                                                                block35: {
                                                                    block32: {
                                                                        void var18_22;
                                                                        block31: {
                                                                            block30: {
                                                                                ((ParsableByteArray)object).setPosition(n23);
                                                                                n20 = parsableByteArray.getPosition();
                                                                                drmInitData = drmInitData2;
                                                                                n21 = parsableByteArray.readInt();
                                                                                if (n21 == 0) {
                                                                                    int n29 = parsableByteArray.getPosition();
                                                                                    var33_84 = var24_42;
                                                                                    n28 = n29 - n19;
                                                                                    if (n28 == n22) {
                                                                                        break block29;
                                                                                    }
                                                                                } else {
                                                                                    var33_84 = var24_42;
                                                                                }
                                                                                if (n21 > 0) {
                                                                                    n28 = 1;
                                                                                } else {
                                                                                    n28 = 0;
                                                                                    Object var24_43 = null;
                                                                                }
                                                                                object2 = "childAtomSize should be positive";
                                                                                Assertions.checkState(n28 != 0, object2);
                                                                                n19 = parsableByteArray.readInt();
                                                                                n28 = 1635148611;
                                                                                n22 = 3;
                                                                                if (n19 != n28) break block30;
                                                                                if (var30_77 == null) {
                                                                                    n28 = 1;
                                                                                } else {
                                                                                    n28 = 0;
                                                                                    Object var24_45 = null;
                                                                                }
                                                                                Assertions.checkState(n28 != 0);
                                                                                ((ParsableByteArray)object).setPosition(n20 += 8);
                                                                                object2 = AvcConfig.parse(parsableByteArray);
                                                                                object3 = ((AvcConfig)object2).initializationData;
                                                                                atomParsers$StsdData2.nalUnitLengthFieldLength = n24 = ((AvcConfig)object2).nalUnitLengthFieldLength;
                                                                                if (!bl2) {
                                                                                    f10 = ((AvcConfig)object2).pixelWidthAspectRatio;
                                                                                }
                                                                                object2 = ((AvcConfig)object2).codecs;
                                                                                String string4 = "video/avc";
                                                                                break block31;
                                                                            }
                                                                            n28 = 1752589123;
                                                                            if (n19 != n28) break block32;
                                                                            if (var30_77 == null) {
                                                                                n28 = 1;
                                                                            } else {
                                                                                n28 = 0;
                                                                                Object var24_47 = null;
                                                                            }
                                                                            Assertions.checkState(n28 != 0);
                                                                            ((ParsableByteArray)object).setPosition(n20 += 8);
                                                                            object2 = HevcConfig.parse(parsableByteArray);
                                                                            object3 = ((HevcConfig)object2).initializationData;
                                                                            atomParsers$StsdData2.nalUnitLengthFieldLength = n24 = ((HevcConfig)object2).nalUnitLengthFieldLength;
                                                                            object2 = ((HevcConfig)object2).codecs;
                                                                            String string5 = "video/hevc";
                                                                        }
                                                                        List list = object3;
                                                                        void var30_78 = var18_22;
                                                                        Object object4 = object2;
                                                                        break block33;
                                                                    }
                                                                    n28 = 1685480259;
                                                                    if (n19 == n28 || n19 == (n28 = 1685485123)) break block34;
                                                                    n28 = 1987076931;
                                                                    if (n19 != n28) break block35;
                                                                    if (var30_77 == null) {
                                                                        n28 = 1;
                                                                    } else {
                                                                        n28 = 0;
                                                                        Object var24_51 = null;
                                                                    }
                                                                    Assertions.checkState(n28 != 0);
                                                                    n19 = 1987063864;
                                                                    f12 = 1.21789965E33f;
                                                                    object2 = n26 == n19 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                                                    break block36;
                                                                }
                                                                n28 = 1635135811;
                                                                if (n19 != n28) break block37;
                                                                if (var30_77 == null) {
                                                                    n28 = 1;
                                                                } else {
                                                                    n28 = 0;
                                                                    Object var24_53 = null;
                                                                }
                                                                Assertions.checkState(n28 != 0);
                                                                object2 = "video/av01";
                                                                break block36;
                                                            }
                                                            n28 = 1681012275;
                                                            if (n19 != n28) break block38;
                                                            if (var30_77 == null) {
                                                                n28 = 1;
                                                            } else {
                                                                n28 = 0;
                                                                Object var24_57 = null;
                                                            }
                                                            Assertions.checkState(n28 != 0);
                                                            object2 = "video/3gpp";
                                                        }
                                                        void var24_56 = var33_84;
                                                        Object object5 = object2;
                                                        break block33;
                                                    }
                                                    n28 = 1702061171;
                                                    if (n19 != n28) break block39;
                                                    if (var30_77 == null) {
                                                        n28 = 1;
                                                    } else {
                                                        n28 = 0;
                                                        Object var24_59 = null;
                                                    }
                                                    Assertions.checkState(n28 != 0);
                                                    object2 = AtomParsers.parseEsdsFromParent((ParsableByteArray)object, n20);
                                                    object3 = (String)((Pair)object2).first;
                                                    object2 = (byte[])((Pair)object2).second;
                                                    if (object2 != null) {
                                                        ImmutableList immutableList = ImmutableList.of(object2);
                                                    } else {
                                                        void var24_62 = var33_84;
                                                    }
                                                    Object object6 = object3;
                                                    break block33;
                                                }
                                                n28 = 1885434736;
                                                if (n19 != n28) break block40;
                                                f12 = AtomParsers.parsePaspFromParent((ParsableByteArray)object, n20);
                                                void var24_64 = var33_84;
                                                f10 = f12;
                                                bl2 = true;
                                                break block33;
                                            }
                                            n28 = 1937126244;
                                            if (n19 != n28) break block41;
                                            object2 = AtomParsers.parseProjFromParent((ParsableByteArray)object, n20, n21);
                                            void var24_65 = var33_84;
                                            Object object7 = object2;
                                            break block33;
                                        }
                                        n28 = 1936995172;
                                        if (n19 != n28) break block42;
                                        n19 = parsableByteArray.readUnsignedByte();
                                        ((ParsableByteArray)object).skipBytes(n22);
                                        if (n19 != 0) break block42;
                                        n19 = parsableByteArray.readUnsignedByte();
                                        if (n19 == 0) break block43;
                                        n28 = 1;
                                        if (n19 == n28) break block44;
                                        n20 = 2;
                                        if (n19 == n20) break block45;
                                        if (n19 != n22) break block42;
                                        void var24_66 = var33_84;
                                        n16 = n22;
                                        break block33;
                                    }
                                    void var24_67 = var33_84;
                                    n16 = n20;
                                    break block33;
                                }
                                n16 = n28;
                                break block42;
                            }
                            void var24_68 = var33_84;
                            n16 = 0;
                            break block33;
                        }
                        object2 = DolbyVisionConfig.parse(parsableByteArray);
                        if (object2 != null) {
                            String string6 = ((DolbyVisionConfig)object2).codecs;
                            String string7 = "video/dolby-vision";
                        }
                    }
                    void var24_69 = var33_84;
                }
                n23 += n21;
                n19 = n11;
                n22 = n12;
                drmInitData2 = drmInitData;
            }
            drmInitData = drmInitData2;
            var33_84 = var24_42;
        }
        if (var30_77 == null) {
            return;
        }
        object = new Format$Builder();
        n19 = n13;
        object = ((Format$Builder)object).setId(n13).setSampleMimeType((String)var30_77).setCodecs((String)var18_19).setWidth(n18).setHeight(n17).setPixelWidthHeightRatio(f10);
        n19 = n14;
        object = ((Format$Builder)object).setRotationDegrees(n14).setProjectionData((byte[])var21_35).setStereoMode(n16);
        void var18_25 = var33_84;
        object = ((Format$Builder)object).setInitializationData((List)var33_84);
        drmInitData2 = drmInitData;
        atomParsers$StsdData2.format = object = ((Format$Builder)object).setDrmInitData(drmInitData).build();
    }
}

