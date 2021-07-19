/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataDecoderFactory;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTableDecoder;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.icy.IcyDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder;

public class MetadataDecoderFactory$1
implements MetadataDecoderFactory {
    public MetadataDecoder createDecoder(Format object) {
        IllegalArgumentException illegalArgumentException;
        String string2;
        object = ((Format)object).sampleMimeType;
        if (object != null) {
            ((String)object).hashCode();
            int n10 = -1;
            int n11 = ((String)object).hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 1652648887: {
                    string2 = "application/x-scte35";
                    n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n11 == 0) break;
                    n10 = 4;
                    break;
                }
                case 1154383568: {
                    string2 = "application/x-emsg";
                    n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n11 == 0) break;
                    n10 = 3;
                    break;
                }
                case -1248341703: {
                    string2 = "application/id3";
                    n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n11 == 0) break;
                    n10 = 2;
                    break;
                }
                case -1348231605: {
                    string2 = "application/x-icy";
                    n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n11 == 0) break;
                    n10 = 1;
                    break;
                }
                case -1354451219: {
                    string2 = "application/vnd.dvb.ait";
                    n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n11 == 0) break;
                    n10 = 0;
                    illegalArgumentException = null;
                }
            }
            switch (n10) {
                default: {
                    break;
                }
                case 4: {
                    object = new SpliceInfoDecoder();
                    return object;
                }
                case 3: {
                    object = new EventMessageDecoder();
                    return object;
                }
                case 2: {
                    object = new Id3Decoder();
                    return object;
                }
                case 1: {
                    object = new IcyDecoder();
                    return object;
                }
                case 0: {
                    object = new AppInfoTableDecoder();
                    return object;
                }
            }
        }
        string2 = "Attempted to create decoder for unsupported MIME type: ";
        int n12 = ((String)(object = String.valueOf(object))).length();
        object = n12 != 0 ? string2.concat((String)object) : new String(string2);
        illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public boolean supportsFormat(Format object) {
        boolean bl2;
        String string2 = "application/id3";
        object = ((Format)object).sampleMimeType;
        boolean bl3 = string2.equals(object);
        if (!(bl3 || (bl3 = (string2 = "application/x-emsg").equals(object)) || (bl3 = (string2 = "application/x-scte35").equals(object)) || (bl3 = (string2 = "application/x-icy").equals(object)) || (bl2 = (string2 = "application/vnd.dvb.ait").equals(object)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

