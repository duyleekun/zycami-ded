/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.xmlpull.v1.XmlPullParser
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$ElementParser;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class SsManifestParser$QualityLevelParser
extends SsManifestParser$ElementParser {
    private static final String KEY_BITRATE = "Bitrate";
    private static final String KEY_CHANNELS = "Channels";
    private static final String KEY_CODEC_PRIVATE_DATA = "CodecPrivateData";
    private static final String KEY_FOUR_CC = "FourCC";
    private static final String KEY_INDEX = "Index";
    private static final String KEY_LANGUAGE = "Language";
    private static final String KEY_MAX_HEIGHT = "MaxHeight";
    private static final String KEY_MAX_WIDTH = "MaxWidth";
    private static final String KEY_NAME = "Name";
    private static final String KEY_SAMPLING_RATE = "SamplingRate";
    private static final String KEY_SUB_TYPE = "Subtype";
    private static final String KEY_TYPE = "Type";
    public static final String TAG = "QualityLevel";
    private Format format;

    public SsManifestParser$QualityLevelParser(SsManifestParser$ElementParser ssManifestParser$ElementParser, String string2) {
        super(ssManifestParser$ElementParser, string2, TAG);
    }

    private static List buildCodecSpecificData(String object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            byte[][] byArray = CodecSpecificDataUtil.splitNalUnits((byte[])(object = (Object)Util.getBytesFromHexString((String)object)));
            if (byArray == null) {
                arrayList.add(object);
            } else {
                Collections.addAll(arrayList, byArray);
            }
        }
        return arrayList;
    }

    private static String fourCCToMimeType(String string2) {
        String string3 = "H264";
        boolean bl2 = string2.equalsIgnoreCase(string3);
        if (!(bl2 || (bl2 = string2.equalsIgnoreCase(string3 = "X264")) || (bl2 = string2.equalsIgnoreCase(string3 = "AVC1")) || (bl2 = string2.equalsIgnoreCase(string3 = "DAVC")))) {
            string3 = "AAC";
            bl2 = string2.equalsIgnoreCase(string3);
            if (!(bl2 || (bl2 = string2.equalsIgnoreCase(string3 = "AACL")) || (bl2 = string2.equalsIgnoreCase(string3 = "AACH")) || (bl2 = string2.equalsIgnoreCase(string3 = "AACP")))) {
                string3 = "TTML";
                bl2 = string2.equalsIgnoreCase(string3);
                if (!bl2 && !(bl2 = string2.equalsIgnoreCase(string3 = "DFXP"))) {
                    string3 = "ac-3";
                    bl2 = string2.equalsIgnoreCase(string3);
                    if (!bl2 && !(bl2 = string2.equalsIgnoreCase(string3 = "dac3"))) {
                        string3 = "ec-3";
                        bl2 = string2.equalsIgnoreCase(string3);
                        if (!bl2 && !(bl2 = string2.equalsIgnoreCase(string3 = "dec3"))) {
                            string3 = "dtsc";
                            bl2 = string2.equalsIgnoreCase(string3);
                            if (bl2) {
                                return "audio/vnd.dts";
                            }
                            string3 = "dtsh";
                            bl2 = string2.equalsIgnoreCase(string3);
                            if (!bl2 && !(bl2 = string2.equalsIgnoreCase(string3 = "dtsl"))) {
                                string3 = "dtse";
                                bl2 = string2.equalsIgnoreCase(string3);
                                if (bl2) {
                                    return "audio/vnd.dts.hd;profile=lbr";
                                }
                                string3 = "opus";
                                boolean bl3 = string2.equalsIgnoreCase(string3);
                                if (bl3) {
                                    return "audio/opus";
                                }
                                return null;
                            }
                            return "audio/vnd.dts.hd";
                        }
                        return "audio/eac3";
                    }
                    return "audio/ac3";
                }
                return "application/ttml+xml";
            }
            return "audio/mp4a-latm";
        }
        return "video/avc";
    }

    public Object build() {
        return this.format;
    }

    public void parseStartTag(XmlPullParser object) {
        Object object2 = new Format$Builder();
        Object object3 = SsManifestParser$QualityLevelParser.fourCCToMimeType(this.parseRequiredString((XmlPullParser)object, KEY_FOUR_CC));
        Object object4 = (Integer)this.getNormalizedAttribute(KEY_TYPE);
        int n10 = (Integer)object4;
        Object object5 = KEY_CODEC_PRIVATE_DATA;
        int n11 = 2;
        if (n10 == n11) {
            object4 = SsManifestParser$QualityLevelParser.buildCodecSpecificData(object.getAttributeValue(null, (String)object5));
            object5 = ((Format$Builder)object2).setContainerMimeType("video/mp4");
            n11 = this.parseRequiredInt((XmlPullParser)object, KEY_MAX_WIDTH);
            object5 = ((Format$Builder)object5).setWidth(n11);
            String string2 = KEY_MAX_HEIGHT;
            n11 = this.parseRequiredInt((XmlPullParser)object, string2);
            object5 = ((Format$Builder)object5).setHeight(n11);
            ((Format$Builder)object5).setInitializationData((List)object4);
        } else {
            n11 = 1;
            if (n10 == n11) {
                object4 = "audio/mp4a-latm";
                if (object3 == null) {
                    object3 = object4;
                }
                String string3 = KEY_CHANNELS;
                n11 = this.parseRequiredInt((XmlPullParser)object, string3);
                String string4 = KEY_SAMPLING_RATE;
                int n12 = this.parseRequiredInt((XmlPullParser)object, string4);
                boolean bl2 = (object5 = SsManifestParser$QualityLevelParser.buildCodecSpecificData(object.getAttributeValue(null, (String)object5))).isEmpty();
                if (bl2 && (n10 = (int)(((String)object4).equals(object3) ? 1 : 0)) != 0) {
                    object4 = AacUtil.buildAacLcAudioSpecificConfig(n12, n11);
                    object5 = Collections.singletonList(object4);
                }
                object4 = ((Format$Builder)object2).setContainerMimeType("audio/mp4").setChannelCount(n11).setSampleRate(n12);
                ((Format$Builder)object4).setInitializationData((List)object5);
            } else {
                int n13 = 3;
                String string5 = "application/mp4";
                if (n10 == n13) {
                    n10 = 0;
                    object4 = null;
                    object5 = (String)this.getNormalizedAttribute(KEY_SUB_TYPE);
                    if (object5 != null) {
                        ((String)object5).hashCode();
                        String string6 = "CAPT";
                        boolean bl3 = ((String)object5).equals(string6);
                        if (!bl3) {
                            string6 = "DESC";
                            n13 = (int)(((String)object5).equals(string6) ? 1 : 0);
                            if (n13 != 0) {
                                n10 = 1024;
                            }
                        } else {
                            n10 = 64;
                        }
                    }
                    object5 = ((Format$Builder)object2).setContainerMimeType(string5);
                    ((Format$Builder)object5).setRoleFlags(n10);
                } else {
                    ((Format$Builder)object2).setContainerMimeType(string5);
                }
            }
        }
        object4 = object.getAttributeValue(null, KEY_INDEX);
        object2 = ((Format$Builder)object2).setId((String)object4);
        object4 = (String)this.getNormalizedAttribute(KEY_NAME);
        object2 = ((Format$Builder)object2).setLabel((String)object4).setSampleMimeType((String)object3);
        int n14 = this.parseRequiredInt((XmlPullParser)object, KEY_BITRATE);
        object = ((Format$Builder)object2).setAverageBitrate(n14);
        object2 = (String)this.getNormalizedAttribute(KEY_LANGUAGE);
        this.format = object = ((Format$Builder)object).setLanguage((String)object2).build();
    }
}

