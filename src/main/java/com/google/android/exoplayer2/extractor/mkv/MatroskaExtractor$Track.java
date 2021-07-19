/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.extractor.mkv;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$1;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$TrueHdSampleRechunker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class MatroskaExtractor$Track {
    private static final int DEFAULT_MAX_CLL = 1000;
    private static final int DEFAULT_MAX_FALL = 200;
    private static final int DISPLAY_UNIT_PIXELS = 0;
    private static final int MAX_CHROMATICITY = 50000;
    public int audioBitDepth;
    private int blockAddIdType;
    public int channelCount;
    public long codecDelayNs;
    public String codecId;
    public byte[] codecPrivate;
    public int colorRange;
    public int colorSpace;
    public int colorTransfer;
    public TrackOutput$CryptoData cryptoData;
    public int defaultSampleDurationNs;
    public int displayHeight;
    public int displayUnit;
    public int displayWidth;
    public byte[] dolbyVisionConfigBytes;
    public DrmInitData drmInitData;
    public boolean flagDefault;
    public boolean flagForced;
    public boolean hasColorInfo;
    public boolean hasContentEncryption;
    public int height;
    private String language;
    public int maxBlockAdditionId;
    public int maxContentLuminance;
    public int maxFrameAverageLuminance;
    public float maxMasteringLuminance;
    public float minMasteringLuminance;
    public int nalUnitLengthFieldLength;
    public String name;
    public int number;
    public TrackOutput output;
    public float primaryBChromaticityX;
    public float primaryBChromaticityY;
    public float primaryGChromaticityX;
    public float primaryGChromaticityY;
    public float primaryRChromaticityX;
    public float primaryRChromaticityY;
    public byte[] projectionData;
    public float projectionPosePitch;
    public float projectionPoseRoll;
    public float projectionPoseYaw;
    public int projectionType;
    public int sampleRate;
    public byte[] sampleStrippedBytes;
    public long seekPreRollNs;
    public int stereoMode;
    public MatroskaExtractor$TrueHdSampleRechunker trueHdSampleRechunker;
    public int type;
    public float whitePointChromaticityX;
    public float whitePointChromaticityY;
    public int width;

    private MatroskaExtractor$Track() {
        long l10;
        int n10;
        float f10;
        int n11;
        this.width = n11 = -1;
        this.height = n11;
        this.displayWidth = n11;
        this.displayHeight = n11;
        this.displayUnit = 0;
        this.projectionType = n11;
        this.projectionPoseYaw = 0.0f;
        this.projectionPosePitch = 0.0f;
        this.projectionPoseRoll = 0.0f;
        this.projectionData = null;
        this.stereoMode = n11;
        this.hasColorInfo = false;
        this.colorSpace = n11;
        this.colorTransfer = n11;
        this.colorRange = n11;
        this.maxContentLuminance = 1000;
        this.maxFrameAverageLuminance = 200;
        this.primaryRChromaticityX = f10 = -1.0f;
        this.primaryRChromaticityY = f10;
        this.primaryGChromaticityX = f10;
        this.primaryGChromaticityY = f10;
        this.primaryBChromaticityX = f10;
        this.primaryBChromaticityY = f10;
        this.whitePointChromaticityX = f10;
        this.whitePointChromaticityY = f10;
        this.maxMasteringLuminance = f10;
        this.minMasteringLuminance = f10;
        this.channelCount = n10 = 1;
        this.audioBitDepth = n11;
        this.sampleRate = 8000;
        this.codecDelayNs = l10 = 0L;
        this.seekPreRollNs = l10;
        this.flagDefault = n10;
        this.language = "eng";
    }

    public /* synthetic */ MatroskaExtractor$Track(MatroskaExtractor$1 matroskaExtractor$1) {
        this();
    }

    public static /* synthetic */ void access$100(MatroskaExtractor$Track matroskaExtractor$Track) {
        matroskaExtractor$Track.assertOutputInitialized();
    }

    public static /* synthetic */ int access$300(MatroskaExtractor$Track matroskaExtractor$Track) {
        return matroskaExtractor$Track.blockAddIdType;
    }

    public static /* synthetic */ int access$302(MatroskaExtractor$Track matroskaExtractor$Track, int n10) {
        matroskaExtractor$Track.blockAddIdType = n10;
        return n10;
    }

    public static /* synthetic */ String access$402(MatroskaExtractor$Track matroskaExtractor$Track, String string2) {
        matroskaExtractor$Track.language = string2;
        return string2;
    }

    private void assertOutputInitialized() {
        Assertions.checkNotNull(this.output);
    }

    private byte[] getCodecPrivate(String string2) {
        Object object = this.codecPrivate;
        if (object == null) {
            object = new ParserException;
            String string3 = "Missing CodecPrivate for codec ";
            int n10 = (string2 = String.valueOf(string2)).length();
            string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
            object(string2);
            throw object;
        }
        return object;
    }

    private byte[] getHdrStaticInfo() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19 = this.primaryRChromaticityX;
        float f20 = -1.0f;
        float f21 = f19 - f20;
        Object object = f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1);
        if (object != false && (object = (f18 = (f19 = this.primaryRChromaticityY) - f20) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1)) != false && (object = (f17 = (f19 = this.primaryGChromaticityX) - f20) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1)) != false && (object = (f16 = (f19 = this.primaryGChromaticityY) - f20) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) != false && (object = (f15 = (f19 = this.primaryBChromaticityX) - f20) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) != false && (object = (f14 = (f19 = this.primaryBChromaticityY) - f20) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) != false && (object = (f13 = (f19 = this.whitePointChromaticityX) - f20) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) != false && (object = (f12 = (f19 = this.whitePointChromaticityY) - f20) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) != false && (object = (f11 = (f19 = this.maxMasteringLuminance) - f20) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false && (object = (f10 = (f19 = this.minMasteringLuminance) - f20) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) != false) {
            byte[] byArray = new byte[25];
            ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBuffer = byteBuffer.order(byteOrder);
            byteBuffer.put((byte)0);
            float f22 = this.primaryRChromaticityX;
            float f23 = 50000.0f;
            float f24 = 0.5f;
            short s10 = (short)((f22 *= f23) + f24);
            byteBuffer.putShort(s10);
            s10 = (short)(this.primaryRChromaticityY * f23 + f24);
            byteBuffer.putShort(s10);
            s10 = (short)(this.primaryGChromaticityX * f23 + f24);
            byteBuffer.putShort(s10);
            s10 = (short)(this.primaryGChromaticityY * f23 + f24);
            byteBuffer.putShort(s10);
            s10 = (short)(this.primaryBChromaticityX * f23 + f24);
            byteBuffer.putShort(s10);
            s10 = (short)(this.primaryBChromaticityY * f23 + f24);
            byteBuffer.putShort(s10);
            s10 = (short)(this.whitePointChromaticityX * f23 + f24);
            byteBuffer.putShort(s10);
            s10 = (short)(this.whitePointChromaticityY * f23 + f24);
            byteBuffer.putShort(s10);
            s10 = (short)(this.maxMasteringLuminance + f24);
            byteBuffer.putShort(s10);
            s10 = (short)(this.minMasteringLuminance + f24);
            byteBuffer.putShort(s10);
            s10 = (short)this.maxContentLuminance;
            byteBuffer.putShort(s10);
            s10 = (short)this.maxFrameAverageLuminance;
            byteBuffer.putShort(s10);
            return byArray;
        }
        return null;
    }

    private static Pair parseFourCcPrivate(ParsableByteArray list) {
        Object object;
        long l10;
        int n10;
        block25: {
            n10 = 16;
            ((ParsableByteArray)((Object)list)).skipBytes(n10);
            l10 = ((ParsableByteArray)((Object)list)).readLittleEndianUnsignedInt();
            long l11 = 1482049860L;
            object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object != false) break block25;
            String string2 = "video/divx";
            try {
                list = new List<Object>((Object)string2, null);
                return list;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                list = new List<Object>("Error parsing FourCC private data");
                throw list;
            }
        }
        long l12 = 859189832L;
        long l13 = l10 - l12;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            String string3 = "video/3gpp";
            list = new List<Object>((Object)string3, null);
            return list;
        }
        l12 = 826496599L;
        long l14 = l10 - l12;
        n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n10 == 0) {
            n10 = ((ParsableByteArray)((Object)list)).getPosition() + 20;
            list = (List<Object>)((ParsableByteArray)((Object)list)).getData();
            while (true) {
                block26: {
                    Object object2 = ((Object)list).length + -4;
                    if (n10 >= object2) break;
                    object2 = list[n10];
                    if (object2 != 0) break block26;
                    object2 = n10 + 1;
                    object2 = list[object2];
                    if (object2 != 0) break block26;
                    object2 = n10 + 2;
                    object2 = list[object2];
                    object = 1;
                    if (object2 == object) {
                        object2 = n10 + 3;
                        object2 = list[object2];
                        object = 15;
                        if (object2 == object) {
                            object2 = ((Object)list).length;
                            list = (List<Object>)Arrays.copyOfRange((byte[])list, n10, object2);
                            String string4 = "video/wvc1";
                            list = Collections.singletonList(list);
                            Pair pair = new Pair((Object)string4, list);
                            return pair;
                        }
                    }
                }
                ++n10;
            }
            String string5 = "Failed to find FourCC VC1 initialization data";
            list = new List<Object>(string5);
            throw list;
        }
        Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
        list = new List<Object>((Object)"video/x-unknown", null);
        return list;
    }

    private static boolean parseMsAcmCodecPrivate(ParsableByteArray object) {
        int n10;
        int n11;
        block10: {
            try {
                n11 = ((ParsableByteArray)object).readLittleEndianUnsignedShort();
                n10 = 1;
                if (n11 != n10) break block10;
                return n10;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                object = new ParserException("Error parsing MS/ACM codec private");
                throw object;
            }
        }
        int n12 = -2;
        if (n11 == n12) {
            block11: {
                n11 = 24;
                ((ParsableByteArray)object).setPosition(n11);
                long l10 = ((ParsableByteArray)object).readLong();
                UUID uUID = MatroskaExtractor.access$700();
                long l11 = uUID.getMostSignificantBits();
                n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n11 == 0) {
                    l10 = ((ParsableByteArray)object).readLong();
                    object = MatroskaExtractor.access$700();
                    l11 = ((UUID)object).getLeastSignificantBits();
                    long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (l12 == false) break block11;
                }
                n10 = 0;
            }
            return n10;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List parseVorbisCodecPrivate(byte[] object) {
        String string2 = "Error parsing vorbis codec private";
        try {
            Object object2 = object[0];
            int n10 = 2;
            if (object2 == n10) {
                Object object3;
                int n11;
                Object object4;
                object2 = true;
                Object object5 = 0;
                Object object6 = object2;
                while (true) {
                    object4 = object[object6];
                    n11 = 255;
                    if ((object4 = (Object)(object4 & n11)) != n11) break;
                    object5 += 255;
                    ++object6;
                }
                object4 = object6 + true;
                object6 = object[object6] & n11;
                object5 += object6;
                object6 = false;
                byte[] byArray = null;
                while ((object3 = object[object4] & n11) == n11) {
                    object6 += 255;
                    ++object4;
                }
                object3 = object4 + true;
                object4 = object[object4] & n11;
                object6 += object4;
                object4 = object[object3];
                if (object4 == object2) {
                    byte[] byArray2 = new byte[object5];
                    System.arraycopy(object, object3, byArray2, 0, object5);
                    object3 += object5;
                    object5 = object[object3];
                    object4 = 3;
                    if (object5 == object4) {
                        object5 = 5;
                        if ((object6 = object[object3 += object6]) == object5) {
                            object6 = ((Object)object).length - object3;
                            byArray = new byte[object6];
                            object5 = ((Object)object).length - object3;
                            System.arraycopy(object, object3, byArray, 0, object5);
                            object = new ArrayList(n10);
                            object.add(byArray2);
                            object.add(byArray);
                            return object;
                        }
                        object = new ParserException(string2);
                        throw object;
                    }
                    object = new ParserException(string2);
                    throw object;
                }
                object = new ParserException(string2);
                throw object;
            }
            object = new ParserException(string2);
            throw object;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
        object = new ParserException(string2);
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    public void initializeOutput(ExtractorOutput var1_1, int var2_2) {
        block89: {
            block90: {
                block92: {
                    block91: {
                        block94: {
                            block93: {
                                block88: {
                                    block87: {
                                        var3_3 = this;
                                        var4_4 = this.codecId;
                                        var4_4.hashCode();
                                        var5_5 = var4_4.hashCode();
                                        var6_6 = 16;
                                        var7_7 = 8;
                                        var8_8 = 4;
                                        var9_9 = 3;
                                        var10_10 = 4.2E-45f;
                                        var11_11 = 0;
                                        var12_12 = 0.0f;
                                        switch (var5_5) lbl-1000:
                                        // 33 sources

                                        {
                                            default: {
                                                var13_13 = -1;
                                                break;
                                            }
                                            case 1951062397: {
                                                var14_14 = "A_OPUS";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 31;
                                                break;
                                            }
                                            case 1950789798: {
                                                var14_14 = "A_FLAC";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 30;
                                                break;
                                            }
                                            case 1950749482: {
                                                var14_14 = "A_EAC3";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 29;
                                                break;
                                            }
                                            case 1809237540: {
                                                var14_14 = "V_MPEG2";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 28;
                                                break;
                                            }
                                            case 1422270023: {
                                                var14_14 = "S_TEXT/UTF8";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 27;
                                                break;
                                            }
                                            case 855502857: {
                                                var14_14 = "V_MPEGH/ISO/HEVC";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 26;
                                                break;
                                            }
                                            case 738597099: {
                                                var14_14 = "S_TEXT/ASS";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 25;
                                                break;
                                            }
                                            case 725957860: {
                                                var14_14 = "A_PCM/INT/LIT";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 24;
                                                break;
                                            }
                                            case 725948237: {
                                                var14_14 = "A_PCM/INT/BIG";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 23;
                                                break;
                                            }
                                            case 635596514: {
                                                var14_14 = "A_PCM/FLOAT/IEEE";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 22;
                                                break;
                                            }
                                            case 542569478: {
                                                var14_14 = "A_DTS/EXPRESS";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 21;
                                                break;
                                            }
                                            case 444813526: {
                                                var14_14 = "V_THEORA";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 20;
                                                break;
                                            }
                                            case 99146302: {
                                                var14_14 = "S_HDMV/PGS";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 19;
                                                break;
                                            }
                                            case 82338134: {
                                                var14_14 = "V_VP9";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 18;
                                                break;
                                            }
                                            case 82338133: {
                                                var14_14 = "V_VP8";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 17;
                                                break;
                                            }
                                            case 82318131: {
                                                var14_14 = "V_AV1";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = var6_6;
                                                break;
                                            }
                                            case 62927045: {
                                                var14_14 = "A_DTS";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 15;
                                                break;
                                            }
                                            case 62923603: {
                                                var14_14 = "A_AC3";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 14;
                                                break;
                                            }
                                            case 62923557: {
                                                var14_14 = "A_AAC";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 13;
                                                break;
                                            }
                                            case -356037306: {
                                                var14_14 = "A_DTS/LOSSLESS";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 12;
                                                break;
                                            }
                                            case -425012669: {
                                                var14_14 = "S_VOBSUB";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 11;
                                                break;
                                            }
                                            case -538363109: {
                                                var14_14 = "V_MPEG4/ISO/AVC";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 10;
                                                break;
                                            }
                                            case -538363189: {
                                                var14_14 = "V_MPEG4/ISO/ASP";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 9;
                                                break;
                                            }
                                            case -933872740: {
                                                var14_14 = "S_DVBSUB";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = var7_7;
                                                break;
                                            }
                                            case -1373388978: {
                                                var14_14 = "V_MS/VFW/FOURCC";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 7;
                                                break;
                                            }
                                            case -1482641357: {
                                                var14_14 = "A_MPEG/L3";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 6;
                                                break;
                                            }
                                            case -1482641358: {
                                                var14_14 = "A_MPEG/L2";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 5;
                                                break;
                                            }
                                            case -1730367663: {
                                                var14_14 = "A_VORBIS";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = var8_8;
                                                break;
                                            }
                                            case -1784763192: {
                                                var14_14 = "A_TRUEHD";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = var9_9;
                                                break;
                                            }
                                            case -1985379776: {
                                                var14_14 = "A_MS/ACM";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 2;
                                                break;
                                            }
                                            case -2095575984: {
                                                var14_14 = "V_MPEG4/ISO/SP";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 1;
                                                break;
                                            }
                                            case -2095576542: {
                                                var14_14 = "V_MPEG4/ISO/AP";
                                                var13_13 = (int)var4_4.equals(var14_14);
                                                if (var13_13 == 0) ** GOTO lbl-1000
                                                var13_13 = 0;
                                                var4_4 = null;
                                            }
                                        }
                                        var14_14 = "application/dvbsubs";
                                        var15_15 = "application/pgs";
                                        var16_16 = "application/vobsub";
                                        var17_17 = "text/x-ssa";
                                        var18_18 = "application/x-subrip";
                                        var19_19 = ". Setting mimeType to ";
                                        var20_20 = "audio/raw";
                                        var21_21 = "MatroskaExtractor";
                                        var22_22 = "audio/x-unknown";
                                        switch (var13_13) {
                                            default: {
                                                var4_4 = new ParserException("Unrecognized codec identifier.");
                                                throw var4_4;
                                            }
                                            case 31: {
                                                var23_23 = 5760;
                                                var4_4 = new ArrayList(var9_9);
                                                var24_24 = var3_3.codecId;
                                                var24_24 = var3_3.getCodecPrivate((String)var24_24);
                                                var4_4.add(var24_24);
                                                var24_24 = ByteBuffer.allocate(var7_7);
                                                var19_19 = ByteOrder.LITTLE_ENDIAN;
                                                var24_24 = var24_24.order((ByteOrder)var19_19);
                                                var25_25 = var15_15;
                                                var26_26 = var3_3.codecDelayNs;
                                                var24_24 = var24_24.putLong(var26_26).array();
                                                var4_4.add(var24_24);
                                                var24_24 = ByteBuffer.allocate(var7_7).order((ByteOrder)var19_19);
                                                var28_27 = var3_3.seekPreRollNs;
                                                var24_24 = var24_24.putLong(var28_27).array();
                                                var4_4.add(var24_24);
                                                var20_20 = "audio/opus";
                                                ** GOTO lbl469
                                            }
                                            case 30: {
                                                var25_25 = var15_15;
                                                var4_4 = var3_3.codecId;
                                                var4_4 = Collections.singletonList(var3_3.getCodecPrivate((String)var4_4));
                                                var20_20 = "audio/flac";
                                                ** GOTO lbl445
                                            }
                                            case 29: {
                                                var25_25 = var15_15;
                                                var20_20 = "audio/eac3";
                                                ** GOTO lbl370
                                            }
                                            case 28: {
                                                var25_25 = var15_15;
                                                var20_20 = "video/mpeg2";
                                                ** GOTO lbl370
                                            }
                                            case 27: {
                                                var25_25 = var15_15;
                                                var20_20 = var18_18;
                                                ** GOTO lbl370
                                            }
                                            case 26: {
                                                var25_25 = var15_15;
                                                var24_24 = var3_3.codecId;
                                                var24_24 = var3_3.getCodecPrivate((String)var24_24);
                                                var4_4 = new ParsableByteArray((byte[])var24_24);
                                                var4_4 = HevcConfig.parse((ParsableByteArray)var4_4);
                                                var24_24 = var4_4.initializationData;
                                                var3_3.nalUnitLengthFieldLength = var30_28 = var4_4.nalUnitLengthFieldLength;
                                                var4_4 = var4_4.codecs;
                                                var20_20 = "video/hevc";
                                                ** GOTO lbl421
                                            }
                                            case 25: {
                                                var25_25 = var15_15;
                                                var4_4 = MatroskaExtractor.access$500();
                                                var24_24 = var3_3.codecId;
                                                var24_24 = var3_3.getCodecPrivate((String)var24_24);
                                                var4_4 = ImmutableList.of(var4_4, var24_24);
                                                var20_20 = var17_17;
                                                ** GOTO lbl445
                                            }
                                            case 24: {
                                                var25_25 = var15_15;
                                                var13_13 = var3_3.audioBitDepth;
                                                var8_8 = Util.getPcmEncoding(var13_13);
                                                if (var8_8 != 0) ** GOTO lbl303
                                                var13_13 = var3_3.audioBitDepth;
                                                var6_6 = var22_22.length() + 74;
                                                var31_31 = new StringBuilder(var6_6);
                                                var24_24 = "Unsupported little endian PCM bit depth: ";
                                                var31_31.append((String)var24_24);
                                                var31_31.append(var13_13);
                                                var31_31.append((String)var19_19);
                                                var31_31.append(var22_22);
                                                var4_4 = var31_31.toString();
                                                Log.w((String)var21_21, (String)var4_4);
lbl300:
                                                // 5 sources

                                                while (true) {
                                                    var20_20 = var22_22;
                                                    ** GOTO lbl370
                                                    break;
                                                }
lbl303:
                                                // 5 sources

                                                while (true) {
                                                    var13_13 = 0;
                                                    var4_4 = null;
                                                    var6_6 = 0;
                                                    var24_24 = null;
                                                    ** GOTO lbl377
                                                    break;
                                                }
                                            }
                                            case 23: {
                                                var25_25 = var15_15;
                                                var13_13 = var3_3.audioBitDepth;
                                                if (var13_13 != var7_7) ** GOTO lbl315
                                                var8_8 = var9_9;
                                                ** GOTO lbl303
lbl315:
                                                // 1 sources

                                                if (var13_13 != var6_6) ** GOTO lbl318
                                                var8_8 = 0x10000000;
                                                ** GOTO lbl303
lbl318:
                                                // 1 sources

                                                var6_6 = var22_22.length() + 71;
                                                var31_31 = new StringBuilder(var6_6);
                                                var24_24 = "Unsupported big endian PCM bit depth: ";
                                                var31_31.append((String)var24_24);
                                                var31_31.append(var13_13);
                                                var31_31.append((String)var19_19);
                                                var31_31.append(var22_22);
                                                var4_4 = var31_31.toString();
                                                Log.w((String)var21_21, (String)var4_4);
                                                ** GOTO lbl300
                                            }
                                            case 22: {
                                                var25_25 = var15_15;
                                                var13_13 = var3_3.audioBitDepth;
                                                var6_6 = 32;
                                                if (var13_13 == var6_6) ** GOTO lbl303
                                                var6_6 = var22_22.length() + 75;
                                                var31_31 = new StringBuilder(var6_6);
                                                var24_24 = "Unsupported floating point PCM bit depth: ";
                                                var31_31.append((String)var24_24);
                                                var31_31.append(var13_13);
                                                var31_31.append((String)var19_19);
                                                var31_31.append(var22_22);
                                                var4_4 = var31_31.toString();
                                                Log.w((String)var21_21, (String)var4_4);
                                                ** GOTO lbl300
                                            }
                                            case 20: {
                                                var25_25 = var15_15;
                                                var20_20 = "video/x-unknown";
                                                ** GOTO lbl370
                                            }
                                            case 19: {
                                                var25_25 = var15_15;
                                                var13_13 = 0;
                                                var4_4 = null;
                                                var6_6 = 0;
                                                var24_24 = null;
                                                var20_20 = var15_15;
                                                ** GOTO lbl375
                                            }
                                            case 18: {
                                                var25_25 = var15_15;
                                                var20_20 = "video/x-vnd.on2.vp9";
                                                ** GOTO lbl370
                                            }
                                            case 17: {
                                                var25_25 = var15_15;
                                                var20_20 = "video/x-vnd.on2.vp8";
lbl370:
                                                // 12 sources

                                                while (true) {
                                                    var13_13 = 0;
                                                    var4_4 = null;
                                                    var6_6 = 0;
                                                    var24_24 = null;
lbl375:
                                                    // 4 sources

                                                    while (true) {
                                                        var8_8 = -1;
lbl377:
                                                        // 2 sources

                                                        var23_23 = -1;
                                                        break block87;
                                                        break;
                                                    }
                                                    break;
                                                }
                                            }
                                            case 16: {
                                                var25_25 = var15_15;
                                                var20_20 = "video/av01";
                                                ** GOTO lbl370
                                            }
                                            case 15: 
                                            case 21: {
                                                var25_25 = var15_15;
                                                var20_20 = "audio/vnd.dts";
                                                ** GOTO lbl370
                                            }
                                            case 14: {
                                                var25_25 = var15_15;
                                                var20_20 = "audio/ac3";
                                                ** GOTO lbl370
                                            }
                                            case 13: {
                                                var25_25 = var15_15;
                                                var4_4 = var3_3.codecId;
                                                var4_4 = Collections.singletonList(var3_3.getCodecPrivate((String)var4_4));
                                                var24_24 = AacUtil.parseAudioSpecificConfig(var3_3.codecPrivate);
                                                var3_3.sampleRate = var30_29 = var24_24.sampleRateHz;
                                                var3_3.channelCount = var30_29 = var24_24.channelCount;
                                                var24_24 = var24_24.codecs;
                                                var20_20 = "audio/mp4a-latm";
                                                ** GOTO lbl375
                                            }
                                            case 12: {
                                                var25_25 = var15_15;
                                                var20_20 = "audio/vnd.dts.hd";
                                                ** GOTO lbl370
                                            }
                                            case 11: {
                                                var25_25 = var15_15;
                                                var4_4 = var3_3.codecId;
                                                var4_4 = ImmutableList.of((Object)var3_3.getCodecPrivate((String)var4_4));
                                                var20_20 = var16_16;
                                                ** GOTO lbl445
                                            }
                                            case 10: {
                                                var25_25 = var15_15;
                                                var24_24 = var3_3.codecId;
                                                var24_24 = var3_3.getCodecPrivate((String)var24_24);
                                                var4_4 = new ParsableByteArray((byte[])var24_24);
                                                var4_4 = AvcConfig.parse((ParsableByteArray)var4_4);
                                                var24_24 = var4_4.initializationData;
                                                var3_3.nalUnitLengthFieldLength = var30_30 = var4_4.nalUnitLengthFieldLength;
                                                var4_4 = var4_4.codecs;
                                                var20_20 = "video/avc";
lbl421:
                                                // 2 sources

                                                var8_8 = -1;
                                                var23_23 = -1;
                                                var32_32 = var24_24;
                                                var24_24 = var4_4;
                                                var4_4 = var32_32;
                                                break block87;
                                            }
                                            case 8: {
                                                var25_25 = var15_15;
                                                var4_4 = new byte[var8_8];
                                                var24_24 = var3_3.codecId;
                                                var24_24 = var3_3.getCodecPrivate((String)var24_24);
                                                System.arraycopy(var24_24, 0, var4_4, 0, var8_8);
                                                var4_4 = ImmutableList.of(var4_4);
                                                var20_20 = var14_14;
                                                ** GOTO lbl445
                                            }
                                            case 7: {
                                                var25_25 = var15_15;
                                                var24_24 = var3_3.codecId;
                                                var24_24 = var3_3.getCodecPrivate((String)var24_24);
                                                var4_4 = new ParsableByteArray((byte[])var24_24);
                                                var4_4 = MatroskaExtractor$Track.parseFourCcPrivate((ParsableByteArray)var4_4);
                                                var20_20 = var24_24 = var4_4.first;
                                                var20_20 = (String)var24_24;
                                                var4_4 = (List)var4_4.second;
lbl445:
                                                // 6 sources

                                                while (true) {
                                                    var6_6 = 0;
                                                    var24_24 = null;
                                                    ** continue;
                                                    break;
                                                }
                                            }
                                            case 6: {
                                                var25_25 = var15_15;
                                                var20_20 = "audio/mpeg";
                                                ** GOTO lbl456
                                            }
                                            case 5: {
                                                var25_25 = var15_15;
                                                var20_20 = "audio/mpeg-L2";
lbl456:
                                                // 2 sources

                                                var13_13 = 0;
                                                var4_4 = null;
                                                var6_6 = 0;
                                                var24_24 = null;
                                                var8_8 = -1;
                                                var23_23 = 4096;
                                                break block87;
                                            }
                                            case 4: {
                                                var25_25 = var15_15;
                                                var23_23 = 8192;
                                                var4_4 = var3_3.codecId;
                                                var4_4 = MatroskaExtractor$Track.parseVorbisCodecPrivate(var3_3.getCodecPrivate((String)var4_4));
                                                var20_20 = "audio/vorbis";
lbl469:
                                                // 2 sources

                                                var6_6 = 0;
                                                var24_24 = null;
                                                var8_8 = -1;
                                                break block87;
                                            }
                                            case 3: {
                                                var25_25 = var15_15;
                                                var3_3.trueHdSampleRechunker = var4_4 = new MatroskaExtractor$TrueHdSampleRechunker();
                                                var20_20 = "audio/true-hd";
                                                ** continue;
                                            }
                                            case 2: {
                                                var25_25 = var15_15;
                                                var24_24 = var3_3.codecId;
                                                var24_24 = var3_3.getCodecPrivate((String)var24_24);
                                                var4_4 = new ParsableByteArray((byte[])var24_24);
                                                var13_13 = (int)MatroskaExtractor$Track.parseMsAcmCodecPrivate((ParsableByteArray)var4_4);
                                                if (var13_13 == 0) ** GOTO lbl504
                                                var13_13 = var3_3.audioBitDepth;
                                                var8_8 = Util.getPcmEncoding(var13_13);
                                                if (var8_8 == 0) ** break;
                                                ** continue;
                                                var13_13 = var3_3.audioBitDepth;
                                                var6_6 = var22_22.length() + 60;
                                                var31_31 = new StringBuilder(var6_6);
                                                var24_24 = "Unsupported PCM bit depth: ";
                                                var31_31.append((String)var24_24);
                                                var31_31.append(var13_13);
                                                var31_31.append((String)var19_19);
                                                var31_31.append(var22_22);
                                                var4_4 = var31_31.toString();
                                                Log.w((String)var21_21, (String)var4_4);
                                                ** GOTO lbl300
lbl504:
                                                // 1 sources

                                                var4_4 = "Non-PCM MS/ACM is unsupported. Setting mimeType to ";
                                                var6_6 = var22_22.length();
                                                var4_4 = var6_6 != 0 ? var4_4.concat(var22_22) : (var24_24 = new String((String)var4_4));
                                                Log.w((String)var21_21, (String)var4_4);
                                                ** continue;
                                            }
                                            case 0: 
                                            case 1: 
                                            case 9: 
                                        }
                                        var25_25 = var15_15;
                                        var4_4 = var3_3.codecPrivate;
                                        if (var4_4 == null) {
                                            var13_13 = 0;
                                            var4_4 = null;
                                        } else {
                                            var4_4 = Collections.singletonList(var4_4);
                                        }
                                        var20_20 = "video/mp4v-es";
                                        ** while (true)
                                    }
                                    var19_19 = var3_3.dolbyVisionConfigBytes;
                                    if (var19_19 != null && (var19_19 = DolbyVisionConfig.parse((ParsableByteArray)(var21_21 = new ParsableByteArray((byte[])var19_19)))) != null) {
                                        var24_24 = var19_19.codecs;
                                        var20_20 = "video/dolby-vision";
                                    }
                                    var19_19 = var20_20;
                                    var33_33 = var3_3.flagDefault | 0;
                                    var7_7 = (int)var3_3.flagForced;
                                    if (var7_7 != 0) {
                                        var7_7 = 2;
                                    } else {
                                        var7_7 = 0;
                                        var31_31 = null;
                                    }
                                    var33_33 |= var7_7;
                                    var31_31 = new Format$Builder();
                                    var34_34 = MimeTypes.isAudio((String)var19_19);
                                    if (var34_34 == 0) break block88;
                                    var5_5 = var3_3.channelCount;
                                    var14_14 = var31_31.setChannelCount(var5_5);
                                    var9_9 = var3_3.sampleRate;
                                    var14_14 = var14_14.setSampleRate(var9_9);
                                    var14_14.setPcmEncoding(var8_8);
                                    var9_9 = 1;
                                    var10_10 = 1.4E-45f;
                                    break block89;
                                }
                                var8_8 = (int)MimeTypes.isVideo((String)var19_19);
                                if (var8_8 == 0) break block90;
                                var5_5 = var3_3.displayUnit;
                                if (var5_5 == 0) {
                                    var5_5 = var3_3.displayWidth;
                                    var8_8 = -1;
                                    if (var5_5 == var8_8) {
                                        var5_5 = var3_3.width;
                                    }
                                    var3_3.displayWidth = var5_5;
                                    var5_5 = var3_3.displayHeight;
                                    if (var5_5 == var8_8) {
                                        var5_5 = var3_3.height;
                                    }
                                    var3_3.displayHeight = var5_5;
                                } else {
                                    var8_8 = -1;
                                }
                                var5_5 = -1082130432;
                                var35_35 = -1.0f;
                                var9_9 = var3_3.displayWidth;
                                if (var9_9 != var8_8 && (var34_34 = var3_3.displayHeight) != var8_8) {
                                    var5_5 = var3_3.height * var9_9;
                                    var35_35 = var5_5;
                                    var9_9 = var3_3.width * var34_34;
                                    var10_10 = var9_9;
                                    var35_35 /= var10_10;
                                }
                                if ((var9_9 = (int)var3_3.hasColorInfo) != 0) {
                                    var36_36 = this.getHdrStaticInfo();
                                    var38_38 = var3_3.colorSpace;
                                    var39_39 = var3_3.colorRange;
                                    var40_40 = var3_3.colorTransfer;
                                    var37_37 = new ColorInfo(var38_38, var39_39, var40_40, (byte[])var36_36);
                                } else {
                                    var34_34 = 0;
                                    var37_37 = null;
                                }
                                var36_36 = var3_3.name;
                                if (var36_36 != null && (var9_9 = (int)(var36_36 = (Object)MatroskaExtractor.access$600()).containsKey(var15_15 = var3_3.name)) != 0) {
                                    var41_41 = MatroskaExtractor.access$600();
                                    var36_36 = var3_3.name;
                                    var41_41 = (Integer)var41_41.get(var36_36);
                                    var8_8 = var41_41.intValue();
                                }
                                if ((var9_9 = var3_3.projectionType) != 0) break block91;
                                var10_10 = var3_3.projectionPoseYaw;
                                var38_38 = 0;
                                var15_15 = null;
                                var9_9 = Float.compare(var10_10, 0.0f);
                                if (var9_9 != 0 || (var9_9 = Float.compare(var10_10 = var3_3.projectionPosePitch, 0.0f)) != 0) break block91;
                                var10_10 = var3_3.projectionPoseRoll;
                                var9_9 = Float.compare(var10_10, 0.0f);
                                if (var9_9 == 0) break block92;
                                var10_10 = var3_3.projectionPosePitch;
                                var11_11 = 1119092736;
                                var12_12 = 90.0f;
                                var9_9 = Float.compare(var10_10, var12_12);
                                if (var9_9 != 0) break block93;
                                var11_11 = 90;
                                var12_12 = 1.26E-43f;
                                break block92;
                            }
                            var10_10 = var3_3.projectionPosePitch;
                            var11_11 = -1020002304;
                            var12_12 = -180.0f;
                            var9_9 = Float.compare(var10_10, var12_12);
                            if (var9_9 == 0) break block94;
                            var10_10 = var3_3.projectionPosePitch;
                            var11_11 = 0x43340000;
                            var12_12 = 180.0f;
                            var9_9 = Float.compare(var10_10, var12_12);
                            if (var9_9 == 0) break block94;
                            var10_10 = var3_3.projectionPosePitch;
                            var11_11 = -1028390912;
                            var12_12 = -90.0f;
                            var9_9 = Float.compare(var10_10, var12_12);
                            if (var9_9 != 0) break block91;
                            var11_11 = 270;
                            var12_12 = 3.78E-43f;
                            break block92;
                        }
                        var11_11 = 180;
                        var12_12 = 2.52E-43f;
                        break block92;
                    }
                    var11_11 = var8_8;
                }
                var8_8 = var3_3.width;
                var41_41 = var31_31.setWidth(var8_8);
                var9_9 = var3_3.height;
                var14_14 = var41_41.setHeight(var9_9).setPixelWidthHeightRatio(var35_35).setRotationDegrees(var11_11);
                var41_41 = var3_3.projectionData;
                var14_14 = var14_14.setProjectionData((byte[])var41_41);
                var8_8 = var3_3.stereoMode;
                var14_14 = var14_14.setStereoMode(var8_8);
                var14_14.setColorInfo(var37_37);
                var9_9 = 2;
                var10_10 = 2.8E-45f;
                break block89;
            }
            var8_8 = (int)var18_18.equals(var19_19);
            if (var8_8 == 0 && (var8_8 = (int)var17_17.equals(var19_19)) == 0 && (var8_8 = (int)var16_16.equals(var19_19)) == 0) {
                var41_41 = var25_25;
                var8_8 = (int)var25_25.equals(var19_19);
                if (var8_8 == 0 && (var5_5 = (int)var14_14.equals(var19_19)) == 0) {
                    var4_4 = new ParserException("Unexpected MIME type.");
                    throw var4_4;
                }
            }
        }
        var14_14 = var3_3.name;
        if (var14_14 != null && (var5_5 = (int)(var14_14 = MatroskaExtractor.access$600()).containsKey(var41_41 = var3_3.name)) == 0) {
            var14_14 = var3_3.name;
            var31_31.setLabel((String)var14_14);
        }
        var5_5 = var2_2;
        var14_14 = var31_31.setId(var2_2).setSampleMimeType((String)var19_19).setMaxInputSize(var23_23);
        var19_19 = var3_3.language;
        var4_4 = var14_14.setLanguage((String)var19_19).setSelectionFlags(var33_33).setInitializationData((List)var4_4).setCodecs((String)var24_24);
        var14_14 = var3_3.drmInitData;
        var4_4 = var4_4.setDrmInitData((DrmInitData)var14_14).build();
        var5_5 = var3_3.number;
        var24_24 = var1_1;
        var3_3.output = var14_14 = var1_1.track(var5_5, var9_9);
        var14_14.format((Format)var4_4);
    }

    public void outputPendingSampleMetadata() {
        MatroskaExtractor$TrueHdSampleRechunker matroskaExtractor$TrueHdSampleRechunker = this.trueHdSampleRechunker;
        if (matroskaExtractor$TrueHdSampleRechunker != null) {
            matroskaExtractor$TrueHdSampleRechunker.outputPendingSampleMetadata(this);
        }
    }

    public void reset() {
        MatroskaExtractor$TrueHdSampleRechunker matroskaExtractor$TrueHdSampleRechunker = this.trueHdSampleRechunker;
        if (matroskaExtractor$TrueHdSampleRechunker != null) {
            matroskaExtractor$TrueHdSampleRechunker.reset();
        }
    }
}

