/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 */
package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.SectionPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$DvbSubtitleInfo;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$EsInfo;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TsExtractor$PmtReader
implements SectionPayloadReader {
    private static final int TS_PMT_DESC_AC3 = 106;
    private static final int TS_PMT_DESC_AIT = 111;
    private static final int TS_PMT_DESC_DTS = 123;
    private static final int TS_PMT_DESC_DVBSUBS = 89;
    private static final int TS_PMT_DESC_DVB_EXT = 127;
    private static final int TS_PMT_DESC_DVB_EXT_AC4 = 21;
    private static final int TS_PMT_DESC_EAC3 = 122;
    private static final int TS_PMT_DESC_ISO639_LANG = 10;
    private static final int TS_PMT_DESC_REGISTRATION = 5;
    private final int pid;
    private final ParsableBitArray pmtScratch;
    public final /* synthetic */ TsExtractor this$0;
    private final SparseIntArray trackIdToPidScratch;
    private final SparseArray trackIdToReaderScratch;

    public TsExtractor$PmtReader(TsExtractor object, int n10) {
        this.this$0 = object;
        byte[] byArray = new byte[5];
        this.pmtScratch = object = new ParsableBitArray(byArray);
        object = new SparseArray();
        this.trackIdToReaderScratch = object;
        object = new SparseIntArray();
        this.trackIdToPidScratch = object;
        this.pid = n10;
    }

    /*
     * Enabled aggressive block sorting
     */
    private TsPayloadReader$EsInfo readEsInfo(ParsableByteArray object, int n10) {
        int n11;
        int n12 = ((ParsableByteArray)object).getPosition();
        String string2 = null;
        int n13 = -1;
        ArrayList<TsPayloadReader$DvbSubtitleInfo> arrayList = null;
        while ((n11 = ((ParsableByteArray)object).getPosition()) < (n10 += n12)) {
            block16: {
                int n14;
                int n15;
                int n16;
                int n17;
                int n18;
                block19: {
                    block15: {
                        block18: {
                            int n19;
                            block14: {
                                block17: {
                                    block13: {
                                        block12: {
                                            long l10;
                                            n11 = ((ParsableByteArray)object).readUnsignedByte();
                                            n18 = ((ParsableByteArray)object).readUnsignedByte();
                                            n17 = ((ParsableByteArray)object).getPosition() + n18;
                                            if (n17 > n10) break;
                                            n18 = 5;
                                            n16 = 89;
                                            n15 = 172;
                                            n19 = 135;
                                            n14 = 129;
                                            if (n11 != n18) break block12;
                                            long l11 = ((ParsableByteArray)object).readUnsignedInt();
                                            long l12 = l11 - (l10 = 1094921523L);
                                            n16 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                                            if (n16 == 0) break block13;
                                            long l13 = 1161904947L;
                                            long l14 = l11 - l13;
                                            n16 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                                            if (n16 == 0) break block14;
                                            long l15 = 1094921524L;
                                            long l16 = l11 - l15;
                                            n16 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                                            if (n16 == 0) break block15;
                                            long l17 = 1212503619L;
                                            long l18 = l11 - l17;
                                            n11 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
                                            if (n11 == 0) {
                                                n13 = 36;
                                            }
                                            break block16;
                                        }
                                        n18 = 106;
                                        if (n11 != n18) break block17;
                                    }
                                    n13 = n14;
                                    break block16;
                                }
                                n18 = 122;
                                if (n11 != n18) break block18;
                            }
                            n13 = n19;
                            break block16;
                        }
                        n18 = 127;
                        if (n11 != n18) break block19;
                        n11 = ((ParsableByteArray)object).readUnsignedByte();
                        if (n11 != (n18 = 21)) break block16;
                    }
                    n13 = n15;
                    break block16;
                }
                n18 = 123;
                if (n11 == n18) {
                    n13 = 138;
                } else {
                    n18 = 10;
                    n15 = 3;
                    if (n11 == n18) {
                        string2 = ((ParsableByteArray)object).readString(n15).trim();
                    } else if (n11 == n16) {
                        arrayList = new ArrayList<TsPayloadReader$DvbSubtitleInfo>();
                        while ((n13 = ((ParsableByteArray)object).getPosition()) < n17) {
                            String string3 = ((ParsableByteArray)object).readString(n15).trim();
                            n11 = ((ParsableByteArray)object).readUnsignedByte();
                            n18 = 4;
                            byte[] byArray = new byte[n18];
                            n14 = 0;
                            ((ParsableByteArray)object).readBytes(byArray, 0, n18);
                            TsPayloadReader$DvbSubtitleInfo tsPayloadReader$DvbSubtitleInfo = new TsPayloadReader$DvbSubtitleInfo(string3, n11, byArray);
                            arrayList.add(tsPayloadReader$DvbSubtitleInfo);
                        }
                        n13 = n16;
                    } else {
                        n18 = 111;
                        if (n11 == n18) {
                            n13 = 257;
                        }
                    }
                }
            }
            n11 = ((ParsableByteArray)object).getPosition();
            ((ParsableByteArray)object).skipBytes(n17 -= n11);
        }
        ((ParsableByteArray)object).setPosition(n10);
        object = Arrays.copyOfRange(((ParsableByteArray)object).getData(), n12, n10);
        return new TsPayloadReader$EsInfo(n13, string2, arrayList, (byte[])object);
    }

    public void consume(ParsableByteArray parsableByteArray) {
        Object object;
        Object object2;
        int n10;
        Object object3;
        int n11;
        TsExtractor$PmtReader tsExtractor$PmtReader = this;
        Object object4 = parsableByteArray;
        int n12 = parsableByteArray.readUnsignedByte();
        if (n12 != (n11 = 2)) {
            return;
        }
        Object object5 = this.this$0;
        n12 = TsExtractor.access$200((TsExtractor)object5);
        int n13 = 0;
        TsPayloadReader tsPayloadReader = null;
        int n14 = 1;
        if (n12 != n14 && (n12 = TsExtractor.access$200((TsExtractor)(object5 = this.this$0))) != n11 && (n12 = TsExtractor.access$100((TsExtractor)(object5 = this.this$0))) != n14) {
            long l10 = ((TimestampAdjuster)TsExtractor.access$300(this.this$0).get(0)).getFirstSampleTimestampUs();
            object5 = new TimestampAdjuster(l10);
            List list = TsExtractor.access$300(this.this$0);
            list.add(object5);
        } else {
            object5 = (TimestampAdjuster)TsExtractor.access$300(tsExtractor$PmtReader.this$0).get(0);
        }
        int n15 = parsableByteArray.readUnsignedByte() & 0x80;
        if (n15 == 0) {
            return;
        }
        ((ParsableByteArray)object4).skipBytes(n14);
        n15 = parsableByteArray.readUnsignedShort();
        int n16 = 3;
        ((ParsableByteArray)object4).skipBytes(n16);
        Object object6 = tsExtractor$PmtReader.pmtScratch;
        ((ParsableByteArray)object4).readBytes((ParsableBitArray)object6, n11);
        tsExtractor$PmtReader.pmtScratch.skipBits(n16);
        object6 = tsExtractor$PmtReader.this$0;
        Object object7 = tsExtractor$PmtReader.pmtScratch;
        int n17 = 13;
        int n18 = ((ParsableBitArray)object7).readBits(n17);
        TsExtractor.access$402((TsExtractor)object6, n18);
        object6 = tsExtractor$PmtReader.pmtScratch;
        ((ParsableByteArray)object4).readBytes((ParsableBitArray)object6, n11);
        object6 = tsExtractor$PmtReader.pmtScratch;
        n18 = 4;
        ((ParsableBitArray)object6).skipBits(n18);
        object6 = tsExtractor$PmtReader.pmtScratch;
        int n19 = 12;
        int n20 = ((ParsableBitArray)object6).readBits(n19);
        ((ParsableByteArray)object4).skipBytes(n20);
        object6 = tsExtractor$PmtReader.this$0;
        n20 = TsExtractor.access$200((TsExtractor)object6);
        int n21 = 8192;
        int n22 = 21;
        if (n20 == n11 && (object6 = TsExtractor.access$500(tsExtractor$PmtReader.this$0)) == null) {
            object3 = Util.EMPTY_BYTE_ARRAY;
            n10 = 0;
            object6 = new TsPayloadReader$EsInfo(n22, null, null, (byte[])object3);
            object3 = tsExtractor$PmtReader.this$0;
            object6 = TsExtractor.access$600((TsExtractor)object3).createPayloadReader(n22, (TsPayloadReader$EsInfo)object6);
            TsExtractor.access$502((TsExtractor)object3, (TsPayloadReader)object6);
            object6 = TsExtractor.access$500(tsExtractor$PmtReader.this$0);
            object3 = TsExtractor.access$700(tsExtractor$PmtReader.this$0);
            TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator = new TsPayloadReader$TrackIdGenerator(n15, n22, n21);
            object6.init((TimestampAdjuster)object5, (ExtractorOutput)object3, tsPayloadReader$TrackIdGenerator);
        }
        tsExtractor$PmtReader.trackIdToReaderScratch.clear();
        object6 = tsExtractor$PmtReader.trackIdToPidScratch;
        object6.clear();
        n20 = parsableByteArray.bytesLeft();
        while (n20 > 0) {
            object3 = tsExtractor$PmtReader.pmtScratch;
            n10 = 5;
            ((ParsableByteArray)object4).readBytes((ParsableBitArray)object3, n10);
            n13 = tsExtractor$PmtReader.pmtScratch.readBits(8);
            tsExtractor$PmtReader.pmtScratch.skipBits(n16);
            object3 = tsExtractor$PmtReader.pmtScratch;
            int n23 = ((ParsableBitArray)object3).readBits(n17);
            tsExtractor$PmtReader.pmtScratch.skipBits(n18);
            object2 = tsExtractor$PmtReader.pmtScratch;
            n16 = ((ParsableBitArray)object2).readBits(n19);
            object7 = tsExtractor$PmtReader.readEsInfo((ParsableByteArray)object4, n16);
            n17 = 6;
            if (n13 == n17 || n13 == n10) {
                n13 = ((TsPayloadReader$EsInfo)object7).streamType;
            }
            n20 -= (n16 += 5);
            object2 = tsExtractor$PmtReader.this$0;
            n16 = TsExtractor.access$200((TsExtractor)object2);
            n16 = n16 == n11 ? n13 : n23;
            object = TsExtractor.access$800(tsExtractor$PmtReader.this$0);
            n17 = (int)(object.get(n16) ? 1 : 0);
            if (n17 == 0) {
                object = tsExtractor$PmtReader.this$0;
                n17 = TsExtractor.access$200((TsExtractor)object);
                if (n17 == n11 && n13 == n22) {
                    tsPayloadReader = TsExtractor.access$500(tsExtractor$PmtReader.this$0);
                } else {
                    object = TsExtractor.access$600(tsExtractor$PmtReader.this$0);
                    tsPayloadReader = object.createPayloadReader(n13, (TsPayloadReader$EsInfo)object7);
                }
                object7 = tsExtractor$PmtReader.this$0;
                n18 = TsExtractor.access$200((TsExtractor)object7);
                if (n18 != n11 || n23 < (n18 = (object7 = tsExtractor$PmtReader.trackIdToPidScratch).get(n16, n21))) {
                    tsExtractor$PmtReader.trackIdToPidScratch.put(n16, n23);
                    object7 = tsExtractor$PmtReader.trackIdToReaderScratch;
                    object7.put(n16, (Object)tsPayloadReader);
                }
            }
            n13 = 0;
            tsPayloadReader = null;
            n16 = 3;
            n18 = 4;
            n17 = 13;
        }
        object4 = tsExtractor$PmtReader.trackIdToPidScratch;
        int n24 = object4.size();
        tsPayloadReader = null;
        for (n13 = 0; n13 < n24; ++n13) {
            object2 = tsExtractor$PmtReader.trackIdToPidScratch;
            n16 = object2.keyAt(n13);
            object6 = tsExtractor$PmtReader.trackIdToPidScratch;
            n20 = object6.valueAt(n13);
            TsExtractor.access$800(tsExtractor$PmtReader.this$0).put(n16, n14 != 0);
            TsExtractor.access$900(tsExtractor$PmtReader.this$0).put(n20, n14 != 0);
            object7 = (TsPayloadReader)tsExtractor$PmtReader.trackIdToReaderScratch.valueAt(n13);
            if (object7 == null) continue;
            object = TsExtractor.access$500(tsExtractor$PmtReader.this$0);
            if (object7 != object) {
                object = TsExtractor.access$700(tsExtractor$PmtReader.this$0);
                TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator = new TsPayloadReader$TrackIdGenerator(n15, n16, n21);
                object7.init((TimestampAdjuster)object5, (ExtractorOutput)object, tsPayloadReader$TrackIdGenerator);
            }
            object2 = TsExtractor.access$000(tsExtractor$PmtReader.this$0);
            object2.put(n20, object7);
        }
        object4 = tsExtractor$PmtReader.this$0;
        n24 = TsExtractor.access$200((TsExtractor)object4);
        if (n24 == n11) {
            object4 = tsExtractor$PmtReader.this$0;
            n24 = (int)(TsExtractor.access$1000((TsExtractor)object4) ? 1 : 0);
            if (n24 == 0) {
                TsExtractor.access$700(tsExtractor$PmtReader.this$0).endTracks();
                object4 = tsExtractor$PmtReader.this$0;
                n12 = 0;
                object5 = null;
                TsExtractor.access$102((TsExtractor)object4, 0);
                object4 = tsExtractor$PmtReader.this$0;
                TsExtractor.access$1002((TsExtractor)object4, n14 != 0);
            }
        } else {
            n12 = 0;
            object5 = null;
            object4 = TsExtractor.access$000(tsExtractor$PmtReader.this$0);
            n11 = tsExtractor$PmtReader.pid;
            object4.remove(n11);
            object4 = tsExtractor$PmtReader.this$0;
            n11 = TsExtractor.access$200((TsExtractor)object4);
            if (n11 == n14) {
                n13 = 0;
                tsPayloadReader = null;
            } else {
                object5 = tsExtractor$PmtReader.this$0;
                n12 = TsExtractor.access$100((TsExtractor)object5);
                n13 = n12 + -1;
            }
            TsExtractor.access$102((TsExtractor)object4, n13);
            object4 = tsExtractor$PmtReader.this$0;
            n24 = TsExtractor.access$100((TsExtractor)object4);
            if (n24 == 0) {
                TsExtractor.access$700(tsExtractor$PmtReader.this$0).endTracks();
                object4 = tsExtractor$PmtReader.this$0;
                TsExtractor.access$1002((TsExtractor)object4, n14 != 0);
            }
        }
    }

    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
    }
}

