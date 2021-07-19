/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.Mp4WebvttSubtitle;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Mp4WebvttDecoder
extends SimpleSubtitleDecoder {
    private static final int BOX_HEADER_SIZE = 8;
    private static final int TYPE_payl = 1885436268;
    private static final int TYPE_sttg = 1937011815;
    private static final int TYPE_vttc = 1987343459;
    private final ParsableByteArray sampleData;

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        ParsableByteArray parsableByteArray;
        this.sampleData = parsableByteArray = new ParsableByteArray();
    }

    private static Cue parseVttCueBox(ParsableByteArray object, int n10) {
        String string2 = null;
        Cue$Builder cue$Builder = null;
        while (n10 > 0) {
            int n11 = 8;
            if (n10 >= n11) {
                int n12 = ((ParsableByteArray)object).readInt();
                int n13 = ((ParsableByteArray)object).readInt();
                n10 += -8;
                Object object2 = ((ParsableByteArray)object).getData();
                int n14 = ((ParsableByteArray)object).getPosition();
                object2 = Util.fromUtf8Bytes((byte[])object2, n14, n12 -= n11);
                ((ParsableByteArray)object).skipBytes(n12);
                n10 -= n12;
                n12 = 1937011815;
                if (n13 == n12) {
                    cue$Builder = WebvttCueParser.parseCueSettingsList((String)object2);
                    continue;
                }
                n12 = 1885436268;
                if (n13 != n12) continue;
                string2 = ((String)object2).trim();
                object2 = Collections.emptyList();
                string2 = WebvttCueParser.parseCueText(null, string2, (List)object2);
                continue;
            }
            object = new SubtitleDecoderException("Incomplete vtt cue box header found.");
            throw object;
        }
        if (string2 == null) {
            string2 = "";
        }
        object = cue$Builder != null ? cue$Builder.setText(string2).build() : WebvttCueParser.newCueForText(string2);
        return object;
    }

    public Subtitle decode(byte[] object, int n10, boolean n11) {
        Object object2;
        ParsableByteArray parsableByteArray = this.sampleData;
        parsableByteArray.reset((byte[])object, n10);
        object = new ArrayList;
        ((ArrayList)object)();
        while ((n10 = ((ParsableByteArray)(object2 = this.sampleData)).bytesLeft()) > 0) {
            object2 = this.sampleData;
            n10 = ((ParsableByteArray)object2).bytesLeft();
            if (n10 >= (n11 = 8)) {
                int n12;
                object2 = this.sampleData;
                n10 = ((ParsableByteArray)object2).readInt();
                parsableByteArray = this.sampleData;
                n11 = parsableByteArray.readInt();
                if (n11 == (n12 = 1987343459)) {
                    parsableByteArray = this.sampleData;
                    object2 = Mp4WebvttDecoder.parseVttCueBox(parsableByteArray, n10 += -8);
                    object.add(object2);
                    continue;
                }
                parsableByteArray = this.sampleData;
                parsableByteArray.skipBytes(n10 += -8);
                continue;
            }
            object = new SubtitleDecoderException;
            ((SubtitleDecoderException)object)("Incomplete Mp4Webvtt Top Level box header found.");
            throw object;
        }
        object2 = new Mp4WebvttSubtitle((List)object);
        return object2;
    }
}

