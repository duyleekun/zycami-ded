/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.ts.Ac3Reader;
import com.google.android.exoplayer2.extractor.ts.Ac4Reader;
import com.google.android.exoplayer2.extractor.ts.AdtsReader;
import com.google.android.exoplayer2.extractor.ts.DtsReader;
import com.google.android.exoplayer2.extractor.ts.DvbSubtitleReader;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.extractor.ts.H263Reader;
import com.google.android.exoplayer2.extractor.ts.H264Reader;
import com.google.android.exoplayer2.extractor.ts.H265Reader;
import com.google.android.exoplayer2.extractor.ts.Id3Reader;
import com.google.android.exoplayer2.extractor.ts.LatmReader;
import com.google.android.exoplayer2.extractor.ts.MpegAudioReader;
import com.google.android.exoplayer2.extractor.ts.PassthroughSectionPayloadReader;
import com.google.android.exoplayer2.extractor.ts.PesReader;
import com.google.android.exoplayer2.extractor.ts.SectionPayloadReader;
import com.google.android.exoplayer2.extractor.ts.SectionReader;
import com.google.android.exoplayer2.extractor.ts.SeiReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$EsInfo;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$Factory;
import com.google.android.exoplayer2.extractor.ts.UserDataReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class DefaultTsPayloadReaderFactory
implements TsPayloadReader$Factory {
    private static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 134;
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_ENABLE_HDMV_DTS_AUDIO_STREAMS = 64;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    private final List closedCaptionFormats;
    private final int flags;

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    public DefaultTsPayloadReaderFactory(int n10) {
        ImmutableList immutableList = ImmutableList.of();
        this(n10, immutableList);
    }

    public DefaultTsPayloadReaderFactory(int n10, List list) {
        this.flags = n10;
        this.closedCaptionFormats = list;
    }

    private SeiReader buildSeiReader(TsPayloadReader$EsInfo object) {
        object = this.getClosedCaptionFormats((TsPayloadReader$EsInfo)object);
        SeiReader seiReader = new SeiReader((List)object);
        return seiReader;
    }

    private UserDataReader buildUserDataReader(TsPayloadReader$EsInfo object) {
        object = this.getClosedCaptionFormats((TsPayloadReader$EsInfo)object);
        UserDataReader userDataReader = new UserDataReader((List)object);
        return userDataReader;
    }

    private List getClosedCaptionFormats(TsPayloadReader$EsInfo arrayList) {
        int n10;
        boolean bl2 = this.isSet(32);
        if (bl2) {
            return this.closedCaptionFormats;
        }
        arrayList = (ArrayList<Object>)((TsPayloadReader$EsInfo)arrayList).descriptorBytes;
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[])arrayList);
        arrayList = this.closedCaptionFormats;
        while ((n10 = parsableByteArray.bytesLeft()) > 0) {
            n10 = parsableByteArray.readUnsignedByte();
            int n11 = parsableByteArray.readUnsignedByte();
            int n12 = parsableByteArray.getPosition() + n11;
            n11 = 134;
            if (n10 == n11) {
                arrayList = new ArrayList<Object>();
                n10 = parsableByteArray.readUnsignedByte() & 0x1F;
                n11 = 0;
                for (int i10 = 0; i10 < n10; ++i10) {
                    String string2;
                    Format$Builder format$Builder;
                    int n13 = 3;
                    Object object = parsableByteArray.readString(n13);
                    int n14 = parsableByteArray.readUnsignedByte();
                    boolean bl3 = n14 & 0x80;
                    boolean bl4 = true;
                    if (bl3) {
                        bl3 = bl4;
                    } else {
                        bl3 = false;
                        format$Builder = null;
                    }
                    if (bl3) {
                        n14 &= 0x3F;
                        string2 = "application/cea-708";
                    } else {
                        string2 = "application/cea-608";
                        n14 = bl4;
                    }
                    byte by2 = (byte)parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes((int)(bl4 ? 1 : 0));
                    List list = null;
                    if (bl3) {
                        bl3 = by2 & 0x40;
                        if (!bl3) {
                            bl4 = false;
                        }
                        list = CodecSpecificDataUtil.buildCea708InitializationData(bl4);
                    }
                    format$Builder = new Format$Builder();
                    format$Builder = format$Builder.setSampleMimeType(string2);
                    object = format$Builder.setLanguage((String)object).setAccessibilityChannel(n14).setInitializationData(list).build();
                    arrayList.add(object);
                }
            }
            parsableByteArray.setPosition(n12);
        }
        return arrayList;
    }

    private boolean isSet(int n10) {
        int n11 = this.flags;
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public SparseArray createInitialPayloadReaders() {
        SparseArray sparseArray = new SparseArray();
        return sparseArray;
    }

    public TsPayloadReader createPayloadReader(int n10, TsPayloadReader$EsInfo object) {
        block11: {
            block12: {
                block13: {
                    TsPayloadReader tsPayloadReader;
                    int n11;
                    int n12;
                    block14: {
                        block15: {
                            block16: {
                                block17: {
                                    block18: {
                                        block19: {
                                            block20: {
                                                block21: {
                                                    block22: {
                                                        n12 = 2;
                                                        if (n10 == n12) break block11;
                                                        n11 = 3;
                                                        if (n10 == n11 || n10 == (n11 = 4)) break block12;
                                                        int n13 = 21;
                                                        if (n10 == n13) break block13;
                                                        n13 = 27;
                                                        tsPayloadReader = null;
                                                        if (n10 == n13) break block14;
                                                        n11 = 36;
                                                        if (n10 == n11) break block15;
                                                        n11 = 89;
                                                        if (n10 == n11) break block16;
                                                        n11 = 138;
                                                        if (n10 == n11) break block17;
                                                        n11 = 172;
                                                        if (n10 == n11) break block18;
                                                        n11 = 257;
                                                        if (n10 == n11) break block19;
                                                        n11 = 129;
                                                        if (n10 == n11) break block20;
                                                        n11 = 130;
                                                        if (n10 == n11) break block21;
                                                        n11 = 134;
                                                        if (n10 == n11) break block22;
                                                        n11 = 135;
                                                        if (n10 != n11) {
                                                            switch (n10) {
                                                                default: {
                                                                    return null;
                                                                }
                                                                case 17: {
                                                                    n10 = (int)(this.isSet(n12) ? 1 : 0);
                                                                    if (n10 == 0) {
                                                                        object = ((TsPayloadReader$EsInfo)object).language;
                                                                        LatmReader latmReader = new LatmReader((String)object);
                                                                        tsPayloadReader = new PesReader(latmReader);
                                                                    }
                                                                    return tsPayloadReader;
                                                                }
                                                                case 16: {
                                                                    object = this.buildUserDataReader((TsPayloadReader$EsInfo)object);
                                                                    H263Reader h263Reader = new H263Reader((UserDataReader)object);
                                                                    PesReader pesReader = new PesReader(h263Reader);
                                                                    return pesReader;
                                                                }
                                                                case 15: 
                                                            }
                                                            n10 = (int)(this.isSet(n12) ? 1 : 0);
                                                            if (n10 == 0) {
                                                                n12 = 0;
                                                                Object var8_22 = null;
                                                                object = ((TsPayloadReader$EsInfo)object).language;
                                                                AdtsReader adtsReader = new AdtsReader(false, (String)object);
                                                                tsPayloadReader = new PesReader(adtsReader);
                                                            }
                                                            return tsPayloadReader;
                                                        }
                                                        break block20;
                                                    }
                                                    n10 = (int)(this.isSet(16) ? 1 : 0);
                                                    if (n10 == 0) {
                                                        object = "application/x-scte35";
                                                        PassthroughSectionPayloadReader passthroughSectionPayloadReader = new PassthroughSectionPayloadReader((String)object);
                                                        tsPayloadReader = new SectionReader(passthroughSectionPayloadReader);
                                                    }
                                                    return tsPayloadReader;
                                                }
                                                n10 = (int)(this.isSet(64) ? 1 : 0);
                                                if (n10 == 0) {
                                                    return null;
                                                }
                                                break block17;
                                            }
                                            object = ((TsPayloadReader$EsInfo)object).language;
                                            Ac3Reader ac3Reader = new Ac3Reader((String)object);
                                            PesReader pesReader = new PesReader(ac3Reader);
                                            return pesReader;
                                        }
                                        object = new PassthroughSectionPayloadReader("application/vnd.dvb.ait");
                                        SectionReader sectionReader = new SectionReader((SectionPayloadReader)object);
                                        return sectionReader;
                                    }
                                    object = ((TsPayloadReader$EsInfo)object).language;
                                    Ac4Reader ac4Reader = new Ac4Reader((String)object);
                                    PesReader pesReader = new PesReader(ac4Reader);
                                    return pesReader;
                                }
                                object = ((TsPayloadReader$EsInfo)object).language;
                                DtsReader dtsReader = new DtsReader((String)object);
                                PesReader pesReader = new PesReader(dtsReader);
                                return pesReader;
                            }
                            object = ((TsPayloadReader$EsInfo)object).dvbSubtitleInfos;
                            DvbSubtitleReader dvbSubtitleReader = new DvbSubtitleReader((List)object);
                            PesReader pesReader = new PesReader(dvbSubtitleReader);
                            return pesReader;
                        }
                        object = this.buildSeiReader((TsPayloadReader$EsInfo)object);
                        H265Reader h265Reader = new H265Reader((SeiReader)object);
                        PesReader pesReader = new PesReader(h265Reader);
                        return pesReader;
                    }
                    n10 = (int)(this.isSet(n11) ? 1 : 0);
                    if (n10 == 0) {
                        object = this.buildSeiReader((TsPayloadReader$EsInfo)object);
                        n12 = (int)(this.isSet(1) ? 1 : 0);
                        n11 = (int)(this.isSet(8) ? 1 : 0);
                        H264Reader h264Reader = new H264Reader((SeiReader)object, n12 != 0, n11 != 0);
                        tsPayloadReader = new PesReader(h264Reader);
                    }
                    return tsPayloadReader;
                }
                object = new Id3Reader();
                PesReader pesReader = new PesReader((ElementaryStreamReader)object);
                return pesReader;
            }
            object = ((TsPayloadReader$EsInfo)object).language;
            MpegAudioReader mpegAudioReader = new MpegAudioReader((String)object);
            PesReader pesReader = new PesReader(mpegAudioReader);
            return pesReader;
        }
        object = this.buildUserDataReader((TsPayloadReader$EsInfo)object);
        H262Reader h262Reader = new H262Reader((UserDataReader)object);
        PesReader pesReader = new PesReader(h262Reader);
        return pesReader;
    }
}

