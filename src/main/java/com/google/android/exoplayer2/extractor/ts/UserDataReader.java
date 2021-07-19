/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class UserDataReader {
    private static final int USER_DATA_START_CODE = 434;
    private final List closedCaptionFormats;
    private final TrackOutput[] outputs;

    public UserDataReader(List trackOutputArray) {
        this.closedCaptionFormats = trackOutputArray;
        trackOutputArray = new TrackOutput[trackOutputArray.size()];
        this.outputs = trackOutputArray;
    }

    public void consume(long l10, ParsableByteArray parsableByteArray) {
        int n10;
        int n11 = parsableByteArray.bytesLeft();
        if (n11 < (n10 = 9)) {
            return;
        }
        n11 = parsableByteArray.readInt();
        n10 = parsableByteArray.readInt();
        int n12 = parsableByteArray.readUnsignedByte();
        int n13 = 434;
        if (n11 == n13 && n10 == (n11 = 1195456820) && n12 == (n11 = 3)) {
            TrackOutput[] trackOutputArray = this.outputs;
            CeaUtil.consumeCcData(l10, parsableByteArray, trackOutputArray);
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((TrackOutput[])(object = this.outputs)).length); ++i10) {
            tsPayloadReader$TrackIdGenerator.generateNewId();
            n10 = tsPayloadReader$TrackIdGenerator.getTrackId();
            int n11 = 3;
            object = extractorOutput.track(n10, n11);
            TrackOutput[] trackOutputArray = (Format)this.closedCaptionFormats.get(i10);
            Object object2 = trackOutputArray.sampleMimeType;
            Object object3 = "application/cea-608";
            int n12 = ((String)object3).equals(object2);
            if (n12 == 0 && (n12 = ((String)(object3 = "application/cea-708")).equals(object2)) == 0) {
                n12 = 0;
                object3 = null;
            } else {
                n12 = 1;
            }
            String string2 = "Invalid closed caption mime type provided: ";
            String string3 = String.valueOf(object2);
            int n13 = string3.length();
            string2 = n13 != 0 ? string2.concat(string3) : (string3 = new String(string2));
            Assertions.checkArgument(n12 != 0, string2);
            object3 = new Format$Builder();
            string2 = tsPayloadReader$TrackIdGenerator.getFormatId();
            object2 = ((Format$Builder)object3).setId(string2).setSampleMimeType((String)object2);
            n12 = trackOutputArray.selectionFlags;
            object2 = ((Format$Builder)object2).setSelectionFlags(n12);
            object3 = trackOutputArray.language;
            object2 = ((Format$Builder)object2).setLanguage((String)object3);
            n12 = trackOutputArray.accessibilityChannel;
            object2 = ((Format$Builder)object2).setAccessibilityChannel(n12);
            trackOutputArray = trackOutputArray.initializationData;
            trackOutputArray = ((Format$Builder)object2).setInitializationData((List)trackOutputArray).build();
            object.format((Format)trackOutputArray);
            trackOutputArray = this.outputs;
            trackOutputArray[i10] = object;
        }
    }
}

