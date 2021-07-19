/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  org.xmlpull.v1.XmlPullParser
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.util.Base64;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$ProtectionElement;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$ElementParser;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

public class SsManifestParser$ProtectionParser
extends SsManifestParser$ElementParser {
    private static final int INITIALIZATION_VECTOR_SIZE = 8;
    public static final String KEY_SYSTEM_ID = "SystemID";
    public static final String TAG = "Protection";
    public static final String TAG_PROTECTION_HEADER = "ProtectionHeader";
    private boolean inProtectionHeader;
    private byte[] initData;
    private UUID uuid;

    public SsManifestParser$ProtectionParser(SsManifestParser$ElementParser ssManifestParser$ElementParser, String string2) {
        super(ssManifestParser$ElementParser, string2, TAG);
    }

    private static TrackEncryptionBox[] buildTrackEncryptionBoxes(byte[] byArray) {
        TrackEncryptionBox trackEncryptionBox;
        TrackEncryptionBox[] trackEncryptionBoxArray = new TrackEncryptionBox[1];
        byte[] byArray2 = SsManifestParser$ProtectionParser.getProtectionElementKeyId(byArray);
        trackEncryptionBoxArray[0] = trackEncryptionBox = new TrackEncryptionBox(true, null, 8, byArray2, 0, 0, null);
        return trackEncryptionBoxArray;
    }

    private static byte[] getProtectionElementKeyId(byte[] object) {
        int n10;
        int n11;
        StringBuilder stringBuilder = new StringBuilder();
        for (n11 = 0; n11 < (n10 = ((byte[])object).length); n11 += 2) {
            n10 = (char)object[n11];
            stringBuilder.append((char)n10);
        }
        object = stringBuilder.toString();
        int n12 = object.indexOf("<KID>");
        n11 = 5;
        n10 = object.indexOf("</KID>");
        object = Base64.decode((String)object.substring(n12 += n11, n10), (int)0);
        SsManifestParser$ProtectionParser.swap(object, 0, 3);
        SsManifestParser$ProtectionParser.swap(object, 1, 2);
        SsManifestParser$ProtectionParser.swap(object, 4, n11);
        SsManifestParser$ProtectionParser.swap(object, 6, 7);
        return object;
    }

    private static String stripCurlyBraces(String string2) {
        int n10;
        int n11 = string2.charAt(0);
        if (n11 == (n10 = 123)) {
            int n12;
            n11 = string2.length();
            n10 = 1;
            n11 -= n10;
            if ((n11 = (int)string2.charAt(n11)) == (n12 = 125)) {
                n11 = string2.length() - n10;
                string2 = string2.substring(n10, n11);
            }
        }
        return string2;
    }

    private static void swap(byte[] byArray, int n10, int n11) {
        byte by2;
        byte by3 = byArray[n10];
        byArray[n10] = by2 = byArray[n11];
        byArray[n11] = by3;
    }

    public Object build() {
        UUID uUID = this.uuid;
        byte[] byArray = this.initData;
        byArray = PsshAtomUtil.buildPsshAtom(uUID, byArray);
        TrackEncryptionBox[] trackEncryptionBoxArray = SsManifestParser$ProtectionParser.buildTrackEncryptionBoxes(this.initData);
        SsManifest$ProtectionElement ssManifest$ProtectionElement = new SsManifest$ProtectionElement(uUID, byArray, trackEncryptionBoxArray);
        return ssManifest$ProtectionElement;
    }

    public boolean handleChildInline(String string2) {
        return TAG_PROTECTION_HEADER.equals(string2);
    }

    public void parseEndTag(XmlPullParser object) {
        String string2 = TAG_PROTECTION_HEADER;
        boolean bl2 = string2.equals(object = object.getName());
        if (bl2) {
            bl2 = false;
            object = null;
            this.inProtectionHeader = false;
        }
    }

    public void parseStartTag(XmlPullParser object) {
        String string2 = TAG_PROTECTION_HEADER;
        String string3 = object.getName();
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            this.inProtectionHeader = true;
            bl2 = false;
            string3 = null;
            string2 = KEY_SYSTEM_ID;
            object = UUID.fromString(SsManifestParser$ProtectionParser.stripCurlyBraces(object.getAttributeValue(null, string2)));
            this.uuid = object;
        }
    }

    public void parseText(XmlPullParser object) {
        boolean bl2 = this.inProtectionHeader;
        if (bl2) {
            object = object.getText();
            bl2 = false;
            object = Base64.decode((String)object, (int)0);
            this.initData = (byte[])object;
        }
    }
}

