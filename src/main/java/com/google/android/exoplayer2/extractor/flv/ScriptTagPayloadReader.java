/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ScriptTagPayloadReader
extends TagPayloadReader {
    private static final int AMF_TYPE_BOOLEAN = 1;
    private static final int AMF_TYPE_DATE = 11;
    private static final int AMF_TYPE_ECMA_ARRAY = 8;
    private static final int AMF_TYPE_END_MARKER = 9;
    private static final int AMF_TYPE_NUMBER = 0;
    private static final int AMF_TYPE_OBJECT = 3;
    private static final int AMF_TYPE_STRICT_ARRAY = 10;
    private static final int AMF_TYPE_STRING = 2;
    private static final String KEY_DURATION = "duration";
    private static final String KEY_FILE_POSITIONS = "filepositions";
    private static final String KEY_KEY_FRAMES = "keyframes";
    private static final String KEY_TIMES = "times";
    private static final String NAME_METADATA = "onMetaData";
    private long durationUs;
    private long[] keyFrameTagPositions;
    private long[] keyFrameTimesUs;

    public ScriptTagPayloadReader() {
        Object object = new DummyTrackOutput();
        super((TrackOutput)object);
        this.durationUs = -9223372036854775807L;
        long[] lArray = new long[]{};
        this.keyFrameTimesUs = lArray;
        object = new long[0];
        this.keyFrameTagPositions = (long[])object;
    }

    private static Boolean readAmfBoolean(ParsableByteArray parsableByteArray) {
        int n10;
        int n11 = parsableByteArray.readUnsignedByte();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    private static Object readAmfData(ParsableByteArray parsableByteArray, int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 8;
                        if (n10 != n11) {
                            n11 = 10;
                            if (n10 != n11) {
                                n11 = 11;
                                if (n10 != n11) {
                                    return null;
                                }
                                return ScriptTagPayloadReader.readAmfDate(parsableByteArray);
                            }
                            return ScriptTagPayloadReader.readAmfStrictArray(parsableByteArray);
                        }
                        return ScriptTagPayloadReader.readAmfEcmaArray(parsableByteArray);
                    }
                    return ScriptTagPayloadReader.readAmfObject(parsableByteArray);
                }
                return ScriptTagPayloadReader.readAmfString(parsableByteArray);
            }
            return ScriptTagPayloadReader.readAmfBoolean(parsableByteArray);
        }
        return ScriptTagPayloadReader.readAmfDouble(parsableByteArray);
    }

    private static Date readAmfDate(ParsableByteArray parsableByteArray) {
        long l10 = (long)ScriptTagPayloadReader.readAmfDouble(parsableByteArray).doubleValue();
        Date date = new Date(l10);
        parsableByteArray.skipBytes(2);
        return date;
    }

    private static Double readAmfDouble(ParsableByteArray parsableByteArray) {
        return Double.longBitsToDouble(parsableByteArray.readLong());
    }

    private static HashMap readAmfEcmaArray(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.readUnsignedIntToInt();
        HashMap<String, Object> hashMap = new HashMap<String, Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = ScriptTagPayloadReader.readAmfString(parsableByteArray);
            int n11 = ScriptTagPayloadReader.readAmfType(parsableByteArray);
            Object object = ScriptTagPayloadReader.readAmfData(parsableByteArray, n11);
            if (object == null) continue;
            hashMap.put(string2, object);
        }
        return hashMap;
    }

    private static HashMap readAmfObject(ParsableByteArray parsableByteArray) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        while (true) {
            int n10;
            String string2 = ScriptTagPayloadReader.readAmfString(parsableByteArray);
            int n11 = ScriptTagPayloadReader.readAmfType(parsableByteArray);
            if (n11 == (n10 = 9)) {
                return hashMap;
            }
            Object object = ScriptTagPayloadReader.readAmfData(parsableByteArray, n11);
            if (object == null) continue;
            hashMap.put(string2, object);
        }
    }

    private static ArrayList readAmfStrictArray(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.readUnsignedIntToInt();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = ScriptTagPayloadReader.readAmfType(parsableByteArray);
            Object object = ScriptTagPayloadReader.readAmfData(parsableByteArray, n11);
            if (object == null) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    private static String readAmfString(ParsableByteArray object) {
        int n10 = ((ParsableByteArray)object).readUnsignedShort();
        int n11 = ((ParsableByteArray)object).getPosition();
        ((ParsableByteArray)object).skipBytes(n10);
        object = ((ParsableByteArray)object).getData();
        String string2 = new String((byte[])object, n11, n10);
        return string2;
    }

    private static int readAmfType(ParsableByteArray parsableByteArray) {
        return parsableByteArray.readUnsignedByte();
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public long[] getKeyFrameTagPositions() {
        return this.keyFrameTagPositions;
    }

    public long[] getKeyFrameTimesUs() {
        return this.keyFrameTimesUs;
    }

    public boolean parseHeader(ParsableByteArray parsableByteArray) {
        return true;
    }

    public boolean parsePayload(ParsableByteArray object, long l10) {
        double d10;
        double d11;
        double d12;
        int n10;
        int n11 = ScriptTagPayloadReader.readAmfType((ParsableByteArray)object);
        if (n11 != (n10 = 2)) {
            return false;
        }
        String string2 = NAME_METADATA;
        Object object2 = ScriptTagPayloadReader.readAmfString((ParsableByteArray)object);
        n11 = (int)(string2.equals(object2) ? 1 : 0);
        if (n11 == 0) {
            return false;
        }
        n11 = ScriptTagPayloadReader.readAmfType((ParsableByteArray)object);
        if (n11 != (n10 = 8)) {
            return false;
        }
        object = ScriptTagPayloadReader.readAmfEcmaArray((ParsableByteArray)object);
        object2 = object.get(KEY_DURATION);
        n10 = object2 instanceof Double;
        double d13 = 1000000.0;
        if (n10 != 0 && (n11 = (int)((d12 = (d11 = ((Double)(object2 = (Double)object2)).doubleValue()) - (d10 = 0.0)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1))) > 0) {
            long l11;
            this.durationUs = l11 = (long)(d11 *= d13);
        }
        if ((n11 = (object = object.get(object2 = KEY_KEY_FRAMES)) instanceof Map) != 0) {
            object = (Map)object;
            object2 = object.get(KEY_FILE_POSITIONS);
            string2 = KEY_TIMES;
            object = object.get(string2);
            n10 = object2 instanceof List;
            if (n10 != 0 && (n10 = object instanceof List) != 0) {
                object2 = (List)object2;
                object = (List)object;
                n10 = object.size();
                long[] lArray = new long[n10];
                this.keyFrameTimesUs = lArray;
                lArray = new long[n10];
                this.keyFrameTagPositions = lArray;
                lArray = null;
                for (int i10 = 0; i10 < n10; ++i10) {
                    Object object3 = object2.get(i10);
                    Object object4 = object.get(i10);
                    boolean bl2 = object4 instanceof Double;
                    if (bl2 && (bl2 = object3 instanceof Double)) {
                        long l12;
                        long[] lArray2 = this.keyFrameTimesUs;
                        double d14 = (Double)object4 * d13;
                        lArray2[i10] = l12 = (long)d14;
                        object4 = this.keyFrameTagPositions;
                        object3 = (Double)object3;
                        long l13 = ((Double)object3).longValue();
                        object4[i10] = l13;
                        continue;
                    }
                    object = new long[0];
                    this.keyFrameTimesUs = (long[])object;
                    object = new long[0];
                    this.keyFrameTagPositions = (long[])object;
                    break;
                }
            }
        }
        return false;
    }

    public void seek() {
    }
}

