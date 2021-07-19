/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.dvb.DvbDecoder;
import com.google.android.exoplayer2.text.pgs.PgsDecoder;
import com.google.android.exoplayer2.text.ssa.SsaDecoder;
import com.google.android.exoplayer2.text.subrip.SubripDecoder;
import com.google.android.exoplayer2.text.ttml.TtmlDecoder;
import com.google.android.exoplayer2.text.tx3g.Tx3gDecoder;
import com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder;
import com.google.android.exoplayer2.text.webvtt.WebvttDecoder;
import java.util.List;

public class SubtitleDecoderFactory$1
implements SubtitleDecoderFactory {
    public SubtitleDecoder createDecoder(Format object) {
        Object object2;
        int n10;
        Object object3 = ((Format)object).sampleMimeType;
        if (object3 != null) {
            ((String)object3).hashCode();
            int n11 = -1;
            n10 = ((String)object3).hashCode();
            switch (n10) {
                default: {
                    break;
                }
                case 1693976202: {
                    String string2 = "application/ttml+xml";
                    n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 10;
                    break;
                }
                case 1668750253: {
                    String string3 = "application/x-subrip";
                    n10 = (int)(((String)object3).equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 9;
                    break;
                }
                case 1566016562: {
                    String string4 = "application/cea-708";
                    n10 = (int)(((String)object3).equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 8;
                    break;
                }
                case 1566015601: {
                    String string5 = "application/cea-608";
                    n10 = (int)(((String)object3).equals(string5) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 7;
                    break;
                }
                case 930165504: {
                    String string6 = "application/x-mp4-cea-608";
                    n10 = (int)(((String)object3).equals(string6) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 6;
                    break;
                }
                case 822864842: {
                    String string7 = "text/x-ssa";
                    n10 = (int)(((String)object3).equals(string7) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 5;
                    break;
                }
                case 691401887: {
                    String string8 = "application/x-quicktime-tx3g";
                    n10 = (int)(((String)object3).equals(string8) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 4;
                    break;
                }
                case -1004728940: {
                    String string9 = "text/vtt";
                    n10 = (int)(((String)object3).equals(string9) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 3;
                    break;
                }
                case -1026075066: {
                    String string10 = "application/x-mp4-vtt";
                    n10 = (int)(((String)object3).equals(string10) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 2;
                    break;
                }
                case -1248334819: {
                    String string11 = "application/pgs";
                    n10 = (int)(((String)object3).equals(string11) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 1;
                    break;
                }
                case -1351681404: {
                    String string12 = "application/dvbsubs";
                    n10 = (int)(((String)object3).equals(string12) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 0;
                    object2 = null;
                }
            }
            switch (n11) {
                default: {
                    break;
                }
                case 10: {
                    object = new TtmlDecoder();
                    return object;
                }
                case 9: {
                    object = new SubripDecoder();
                    return object;
                }
                case 8: {
                    n11 = ((Format)object).accessibilityChannel;
                    object = ((Format)object).initializationData;
                    object3 = new Cea708Decoder(n11, (List)object);
                    return object3;
                }
                case 6: 
                case 7: {
                    int n12 = ((Format)object).accessibilityChannel;
                    object2 = new Cea608Decoder((String)object3, n12, 16000L);
                    return object2;
                }
                case 5: {
                    object = ((Format)object).initializationData;
                    object3 = new SsaDecoder((List)object);
                    return object3;
                }
                case 4: {
                    object = ((Format)object).initializationData;
                    object3 = new Tx3gDecoder((List)object);
                    return object3;
                }
                case 3: {
                    object = new WebvttDecoder();
                    return object;
                }
                case 2: {
                    object = new Mp4WebvttDecoder();
                    return object;
                }
                case 1: {
                    object = new PgsDecoder();
                    return object;
                }
                case 0: {
                    object = ((Format)object).initializationData;
                    object3 = new DvbDecoder((List)object);
                    return object3;
                }
            }
        }
        object2 = "Attempted to create decoder for unsupported MIME type: ";
        n10 = ((String)(object3 = String.valueOf(object3))).length();
        object3 = n10 != 0 ? ((String)object2).concat((String)object3) : new String((String)object2);
        object = new IllegalArgumentException((String)object3);
        throw object;
    }

    public boolean supportsFormat(Format object) {
        boolean bl2;
        String string2 = "text/vtt";
        object = ((Format)object).sampleMimeType;
        boolean bl3 = string2.equals(object);
        if (!(bl3 || (bl3 = (string2 = "text/x-ssa").equals(object)) || (bl3 = (string2 = "application/ttml+xml").equals(object)) || (bl3 = (string2 = "application/x-mp4-vtt").equals(object)) || (bl3 = (string2 = "application/x-subrip").equals(object)) || (bl3 = (string2 = "application/x-quicktime-tx3g").equals(object)) || (bl3 = (string2 = "application/cea-608").equals(object)) || (bl3 = (string2 = "application/x-mp4-cea-608").equals(object)) || (bl3 = (string2 = "application/cea-708").equals(object)) || (bl3 = (string2 = "application/dvbsubs").equals(object)) || (bl2 = (string2 = "application/pgs").equals(object)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

