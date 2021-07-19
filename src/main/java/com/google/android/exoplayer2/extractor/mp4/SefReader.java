/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp4.SefReader$DataReference;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.List;

public final class SefReader {
    private static final Splitter ASTERISK_SPLITTER;
    private static final Splitter COLON_SPLITTER;
    private static final int LENGTH_OF_ONE_SDR = 12;
    private static final int SAMSUNG_TAIL_SIGNATURE = 1397048916;
    private static final int STATE_CHECKING_FOR_SEF = 1;
    private static final int STATE_READING_SDRS = 2;
    private static final int STATE_READING_SEF_DATA = 3;
    private static final int STATE_SHOULD_CHECK_FOR_SEF = 0;
    private static final String TAG = "SefReader";
    private static final int TAIL_FOOTER_LENGTH = 8;
    private static final int TAIL_HEADER_LENGTH = 12;
    private static final int TYPE_SLOW_MOTION_DATA = 2192;
    private static final int TYPE_SUPER_SLOW_DEFLICKERING_ON = 2820;
    private static final int TYPE_SUPER_SLOW_MOTION_BGM = 2817;
    private static final int TYPE_SUPER_SLOW_MOTION_DATA = 2816;
    private static final int TYPE_SUPER_SLOW_MOTION_EDIT_DATA = 2819;
    private final List dataReferences;
    private int readerState;
    private int tailLength;

    static {
        COLON_SPLITTER = Splitter.on(':');
        ASTERISK_SPLITTER = Splitter.on('*');
    }

    public SefReader() {
        ArrayList arrayList;
        this.dataReferences = arrayList = new ArrayList();
        this.readerState = 0;
    }

    private void checkForSefData(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int n10;
        int n11 = 8;
        ParsableByteArray parsableByteArray = new ParsableByteArray(n11);
        byte[] byArray = parsableByteArray.getData();
        extractorInput.readFully(byArray, 0, n11);
        this.tailLength = n10 = parsableByteArray.readLittleEndianInt() + n11;
        int n12 = parsableByteArray.readInt();
        n11 = 1397048916;
        if (n12 != n11) {
            positionHolder.position = 0L;
            return;
        }
        long l10 = extractorInput.getPosition();
        long l11 = this.tailLength + -12;
        positionHolder.position = l10 -= l11;
        this.readerState = 2;
    }

    private static int nameToDataType(String object) {
        ((String)object).hashCode();
        int n10 = ((String)object).hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 1760745220: {
                String string2 = "Super_SlowMotion_BGM";
                boolean bl2 = ((String)object).equals(string2);
                if (!bl2) break;
                n11 = 4;
                break;
            }
            case -830665521: {
                String string3 = "Super_SlowMotion_Deflickering_On";
                boolean bl3 = ((String)object).equals(string3);
                if (!bl3) break;
                n11 = 3;
                break;
            }
            case -1251387154: {
                String string4 = "Super_SlowMotion_Data";
                boolean bl4 = ((String)object).equals(string4);
                if (!bl4) break;
                n11 = 2;
                break;
            }
            case -1332107749: {
                String string5 = "Super_SlowMotion_Edit_Data";
                boolean bl5 = ((String)object).equals(string5);
                if (!bl5) break;
                n11 = 1;
                break;
            }
            case -1711564334: {
                String string6 = "SlowMotion_Data";
                boolean bl6 = ((String)object).equals(string6);
                if (!bl6) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                object = new ParserException("Invalid SEF name");
                throw object;
            }
            case 4: {
                return 2817;
            }
            case 3: {
                return 2820;
            }
            case 2: {
                return 2816;
            }
            case 1: {
                return 2819;
            }
            case 0: 
        }
        return 2192;
    }

    private void readSdrs(ExtractorInput object, PositionHolder positionHolder) {
        int n10;
        int n11;
        long l10 = object.getLength();
        int n12 = this.tailLength + -12;
        int n13 = 8;
        ParsableByteArray parsableByteArray = new ParsableByteArray(n12 -= n13);
        byte[] byArray = parsableByteArray.getData();
        object.readFully(byArray, 0, n12);
        object = null;
        for (n11 = 0; n11 < (n10 = n12 / 12); ++n11) {
            parsableByteArray.skipBytes(2);
            n10 = parsableByteArray.readLittleEndianShort();
            int n14 = 2192;
            if (n10 != n14 && n10 != (n14 = 2816) && n10 != (n14 = 2817) && n10 != (n14 = 2819) && n10 != (n14 = 2820)) {
                parsableByteArray.skipBytes(n13);
                continue;
            }
            n14 = this.tailLength;
            long l11 = n14;
            l11 = l10 - l11;
            long l12 = parsableByteArray.readLittleEndianInt();
            int n15 = parsableByteArray.readLittleEndianInt();
            List list = this.dataReferences;
            SefReader$DataReference sefReader$DataReference = new SefReader$DataReference(n10, l11 -= l12, n15);
            list.add(sefReader$DataReference);
        }
        object = this.dataReferences;
        n11 = (int)(object.isEmpty() ? 1 : 0);
        if (n11 != 0) {
            positionHolder.position = 0L;
            return;
        }
        this.readerState = 3;
        positionHolder.position = l10 = ((SefReader$DataReference)this.dataReferences.get((int)0)).startOffset;
    }

    private void readSefData(ExtractorInput object, List list) {
        int n10;
        long l10 = object.getPosition();
        long l11 = object.getLength();
        long l12 = object.getPosition();
        l11 -= l12;
        int n11 = this.tailLength;
        l12 = n11;
        int n12 = (int)(l11 -= l12);
        ParsableByteArray parsableByteArray = new ParsableByteArray(n12);
        Object object2 = parsableByteArray.getData();
        object.readFully((byte[])object2, 0, n12);
        for (int i10 = 0; i10 < (n10 = (object = this.dataReferences).size()); ++i10) {
            object = (SefReader$DataReference)this.dataReferences.get(i10);
            long l13 = ((SefReader$DataReference)object).startOffset - l10;
            n12 = (int)l13;
            parsableByteArray.setPosition(n12);
            parsableByteArray.skipBytes(4);
            n12 = parsableByteArray.readLittleEndianInt();
            object2 = parsableByteArray.readString(n12);
            n11 = SefReader.nameToDataType((String)object2);
            n10 = ((SefReader$DataReference)object).size;
            n10 -= (n12 += 8);
            n12 = 2192;
            if (n11 != n12) {
                n10 = 2816;
                if (n11 == n10 || n11 == (n10 = 2817) || n11 == (n10 = 2819) || n11 == (n10 = 2820)) continue;
                object = new IllegalStateException();
                throw object;
            }
            object = SefReader.readSlowMotionData(parsableByteArray, n10);
            list.add(object);
        }
    }

    private static SlowMotionData readSlowMotionData(ParsableByteArray object, int n10) {
        int n11;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = ((ParsableByteArray)object).readString(n10);
        object = ASTERISK_SPLITTER.splitToList((CharSequence)object);
        n10 = 0;
        ParserException parserException = null;
        for (int i10 = 0; i10 < (n11 = object.size()); ++i10) {
            int n12;
            Object object2 = COLON_SPLITTER;
            CharSequence charSequence = (CharSequence)object.get(i10);
            int n13 = (object2 = ((Splitter)object2).splitToList(charSequence)).size();
            if (n13 == (n12 = 3)) {
                try {
                    charSequence = object2.get(0);
                }
                catch (NumberFormatException numberFormatException) {
                    parserException = new ParserException(numberFormatException);
                    throw parserException;
                }
                charSequence = (String)charSequence;
                long l10 = Long.parseLong((String)charSequence);
                n13 = 1;
                Object object3 = object2.get(n13);
                object3 = (String)object3;
                long l11 = Long.parseLong(object3);
                n12 = 2;
                object2 = object2.get(n12);
                object2 = (String)object2;
                n11 = Integer.parseInt((String)object2) - n13;
                int n14 = n13 << n11;
                object3 = object2;
                object2 = new SlowMotionData$Segment(l10, l11, n14);
                arrayList.add(object2);
                continue;
            }
            object = new ParserException();
            throw object;
        }
        object = new SlowMotionData(arrayList);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int read(ExtractorInput object, PositionHolder positionHolder, List list) {
        long l10;
        long l11;
        long l12;
        int n10 = this.readerState;
        long l13 = 0L;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 == n11) {
                this.checkForSefData((ExtractorInput)object, positionHolder);
                return n11;
            }
            int n12 = 2;
            if (n10 == n12) {
                this.readSdrs((ExtractorInput)object, positionHolder);
                return n11;
            }
            n12 = 3;
            if (n10 == n12) {
                this.readSefData((ExtractorInput)object, list);
                positionHolder.position = l13;
                return n11;
            }
            object = new IllegalStateException();
            throw object;
        }
        long l14 = object.getLength();
        long l15 = l14 - (l12 = (long)-1);
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 != false && (l11 = (l10 = l14 - (l12 = (long)8)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) >= 0) {
            l13 = l14 - l12;
        }
        positionHolder.position = l13;
        this.readerState = n11;
        return n11;
    }

    public void reset() {
        this.dataReferences.clear();
        this.readerState = 0;
    }
}

