/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.SpannableStringBuilder
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.StyleSpan
 *  android.text.style.TypefaceSpan
 *  android.text.style.UnderlineSpan
 */
package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.List;

public final class Tx3gDecoder
extends SimpleSubtitleDecoder {
    private static final char BOM_UTF16_BE = '\ufeff';
    private static final char BOM_UTF16_LE = '\ufffe';
    private static final int DEFAULT_COLOR = 255;
    private static final int DEFAULT_FONT_FACE = 0;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final float DEFAULT_VERTICAL_PLACEMENT = 0.85f;
    private static final int FONT_FACE_BOLD = 1;
    private static final int FONT_FACE_ITALIC = 2;
    private static final int FONT_FACE_UNDERLINE = 4;
    private static final int SIZE_ATOM_HEADER = 8;
    private static final int SIZE_BOM_UTF16 = 2;
    private static final int SIZE_SHORT = 2;
    private static final int SIZE_STYLE_RECORD = 12;
    private static final int SPAN_PRIORITY_HIGH = 0;
    private static final int SPAN_PRIORITY_LOW = 0xFF0000;
    private static final String TAG = "Tx3gDecoder";
    private static final String TX3G_SERIF = "Serif";
    private static final int TYPE_STYL = 1937013100;
    private static final int TYPE_TBOX = 1952608120;
    private final int calculatedVideoTrackHeight;
    private final boolean customVerticalPlacement;
    private final int defaultColorRgba;
    private final int defaultFontFace;
    private final String defaultFontFamily;
    private final float defaultVerticalPlacement;
    private final ParsableByteArray parsableByteArray;

    public Tx3gDecoder(List object) {
        super(TAG);
        Object object2;
        Object object3 = new ParsableByteArray();
        this.parsableByteArray = object3;
        Object object4 = object.size();
        int n10 = 1062836634;
        float f10 = 0.85f;
        String string2 = DEFAULT_FONT_FAMILY;
        int n11 = 1;
        if (object4 == n11 && ((object4 = ((Object)(object3 = (Object)((byte[])object.get(0)))).length) == (object2 = 48) || (object4 = ((Object)(object3 = (Object)((byte[])object.get(0)))).length) == (object2 = 53))) {
            object = (byte[])object.get(0);
            float f11 = 3.4E-44f;
            this.defaultFontFace = object2 = (Object)object[24];
            object4 = (object[26] & 0xFF) << 24;
            object2 = (object[27] & 0xFF) << 16;
            object4 |= object2;
            object2 = (object[28] & 0xFF) << 8;
            object4 |= object2;
            object2 = object[29] & 0xFF;
            this.defaultColorRgba = object4 |= object2;
            object4 = ((Object)object).length;
            object2 = 43;
            object4 -= object2;
            String string3 = TX3G_SERIF;
            object3 = Util.fromUtf8Bytes((byte[])object, object2, object4);
            if ((object4 = (Object)string3.equals(object3)) != 0) {
                string2 = "serif";
            }
            this.defaultFontFamily = string2;
            f11 = 3.5E-44f;
            this.calculatedVideoTrackHeight = object4 = (Object)(object[25] * 20);
            int n12 = object[0] & 0x20;
            if (n12 == 0) {
                n11 = 0;
            }
            this.customVerticalPlacement = n11;
            if (n11 != 0) {
                n10 = (object[10] & 0xFF) << 8;
                n12 = 11;
                int n13 = object[n12] & 0xFF | n10;
                float f12 = n13;
                f11 = object4;
                f12 /= f11;
                object4 = 0;
                f11 = 0.0f;
                object3 = null;
                n10 = 0x3F733333;
                f10 = 0.95f;
                this.defaultVerticalPlacement = f12 = Util.constrainValue(f12, 0.0f, f10);
            } else {
                this.defaultVerticalPlacement = f10;
            }
        } else {
            this.defaultFontFace = 0;
            int n14 = -1;
            float f13 = 0.0f / 0.0f;
            this.defaultColorRgba = n14;
            this.defaultFontFamily = string2;
            this.customVerticalPlacement = false;
            this.defaultVerticalPlacement = f10;
            this.calculatedVideoTrackHeight = n14;
        }
    }

    private void applyStyleRecord(ParsableByteArray object, SpannableStringBuilder object2) {
        Object object3;
        int n10;
        int n11 = ((ParsableByteArray)object).bytesLeft();
        int n12 = 1;
        int n13 = 12;
        n11 = n11 >= n13 ? n12 : 0;
        Tx3gDecoder.assertTrue(n11 != 0);
        n11 = ((ParsableByteArray)object).readUnsignedShort();
        n13 = ((ParsableByteArray)object).readUnsignedShort();
        ((ParsableByteArray)object).skipBytes(2);
        int n14 = ((ParsableByteArray)object).readUnsignedByte();
        ((ParsableByteArray)object).skipBytes(n12);
        int n15 = ((ParsableByteArray)object).readInt();
        n12 = object2.length();
        String string2 = ").";
        String string3 = TAG;
        if (n13 > n12) {
            n12 = object2.length();
            n10 = 68;
            StringBuilder stringBuilder = new StringBuilder(n10);
            String string4 = "Truncating styl end (";
            stringBuilder.append(string4);
            stringBuilder.append(n13);
            object3 = ") to cueText.length() (";
            stringBuilder.append((String)object3);
            stringBuilder.append(n12);
            stringBuilder.append(string2);
            String string5 = stringBuilder.toString();
            Log.w(string3, string5);
            n12 = object2.length();
        } else {
            n12 = n13;
        }
        if (n11 >= n12) {
            object2 = new StringBuilder(60);
            ((StringBuilder)object2).append("Ignoring styl with start (");
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append(") >= end (");
            ((StringBuilder)object2).append(n12);
            ((StringBuilder)object2).append(string2);
            object = ((StringBuilder)object2).toString();
            Log.w(string3, (String)object);
            return;
        }
        int n16 = this.defaultFontFace;
        object3 = object2;
        n10 = n12;
        Tx3gDecoder.attachFontFace((SpannableStringBuilder)object2, n14, n16, n11, n12, 0);
        n16 = this.defaultColorRgba;
        n14 = n15;
        Tx3gDecoder.attachColor((SpannableStringBuilder)object2, n15, n16, n11, n12, 0);
    }

    private static void assertTrue(boolean bl2) {
        if (bl2) {
            return;
        }
        SubtitleDecoderException subtitleDecoderException = new SubtitleDecoderException("Unexpected subtitle format.");
        throw subtitleDecoderException;
    }

    private static void attachColor(SpannableStringBuilder spannableStringBuilder, int n10, int n11, int n12, int n13, int n14) {
        if (n10 != n11) {
            n11 = (n10 & 0xFF) << 24;
            n10 = n10 >>> 8 | n11;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(n10);
            n10 = n14 | 0x21;
            spannableStringBuilder.setSpan((Object)foregroundColorSpan, n12, n13, n10);
        }
    }

    private static void attachFontFace(SpannableStringBuilder spannableStringBuilder, int n10, int n11, int n12, int n13, int n14) {
        if (n10 != n11) {
            UnderlineSpan underlineSpan;
            n11 = n14 | 0x21;
            n14 = n10 & 1;
            int n15 = 1;
            n14 = n14 != 0 ? n15 : 0;
            int n16 = n10 & 2;
            n16 = n16 != 0 ? n15 : 0;
            if (n14 != 0) {
                if (n16 != 0) {
                    int n17 = 3;
                    StyleSpan styleSpan = new StyleSpan(n17);
                    spannableStringBuilder.setSpan((Object)styleSpan, n12, n13, n11);
                } else {
                    StyleSpan styleSpan = new StyleSpan(n15);
                    spannableStringBuilder.setSpan((Object)styleSpan, n12, n13, n11);
                }
            } else if (n16 != 0) {
                int n18 = 2;
                StyleSpan styleSpan = new StyleSpan(n18);
                spannableStringBuilder.setSpan((Object)styleSpan, n12, n13, n11);
            }
            if ((n10 &= 4) == 0) {
                n15 = 0;
            }
            if (n15 != 0) {
                underlineSpan = new UnderlineSpan();
                spannableStringBuilder.setSpan((Object)underlineSpan, n12, n13, n11);
            }
            if (n15 == 0 && n14 == 0 && n16 == 0) {
                underlineSpan = new StyleSpan(0);
                spannableStringBuilder.setSpan((Object)underlineSpan, n12, n13, n11);
            }
        }
    }

    private static void attachFontFamily(SpannableStringBuilder spannableStringBuilder, String string2, int n10, int n11) {
        String string3 = DEFAULT_FONT_FAMILY;
        if (string2 != string3) {
            string3 = new TypefaceSpan(string2);
            int n12 = 16711713;
            spannableStringBuilder.setSpan((Object)string3, n10, n11, n12);
        }
    }

    private static String readSubtitleText(ParsableByteArray parsableByteArray) {
        int n10;
        int n11 = parsableByteArray.bytesLeft();
        n11 = n11 >= (n10 = 2) ? 1 : 0;
        Tx3gDecoder.assertTrue(n11 != 0);
        n11 = parsableByteArray.readUnsignedShort();
        if (n11 == 0) {
            return "";
        }
        int n12 = parsableByteArray.bytesLeft();
        if (n12 >= n10 && ((n10 = (int)parsableByteArray.peekChar()) == (n12 = 65279) || n10 == (n12 = (int)((char)-2)))) {
            Charset charset = Charsets.UTF_16;
            return parsableByteArray.readString(n11, charset);
        }
        Charset charset = Charsets.UTF_8;
        return parsableByteArray.readString(n11, charset);
    }

    public Subtitle decode(byte[] object, int n10, boolean n11) {
        Object object2;
        Object object3 = this.parsableByteArray;
        ((ParsableByteArray)object3).reset((byte[])object, n10);
        object = Tx3gDecoder.readSubtitleText(this.parsableByteArray);
        n10 = (int)(((String)object).isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return Tx3gSubtitle.EMPTY;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)object);
        int n12 = this.defaultFontFace;
        ParsableByteArray parsableByteArray = null;
        int n13 = 0;
        float f10 = 0.0f;
        int n14 = spannableStringBuilder.length();
        int bl2 = 0xFF0000;
        Tx3gDecoder.attachFontFace(spannableStringBuilder, n12, 0, 0, n14, bl2);
        n12 = this.defaultColorRgba;
        int n15 = -1;
        float f11 = 0.0f / 0.0f;
        n14 = spannableStringBuilder.length();
        Tx3gDecoder.attachColor(spannableStringBuilder, n12, n15, 0, n14, bl2);
        object = this.defaultFontFamily;
        n11 = spannableStringBuilder.length();
        Tx3gDecoder.attachFontFamily(spannableStringBuilder, (String)object, 0, n11);
        float f12 = this.defaultVerticalPlacement;
        while ((n11 = ((ParsableByteArray)(object3 = this.parsableByteArray)).bytesLeft()) >= (n12 = 8)) {
            object3 = this.parsableByteArray;
            n11 = ((ParsableByteArray)object3).getPosition();
            object2 = this.parsableByteArray;
            n12 = ((ParsableByteArray)object2).readInt();
            parsableByteArray = this.parsableByteArray;
            n15 = parsableByteArray.readInt();
            n13 = 1937013100;
            f10 = 1.936925E31f;
            n14 = 2;
            boolean bl3 = true;
            if (n15 == n13) {
                parsableByteArray = this.parsableByteArray;
                n15 = parsableByteArray.bytesLeft();
                if (n15 < n14) {
                    bl3 = false;
                }
                Tx3gDecoder.assertTrue(bl3);
                parsableByteArray = this.parsableByteArray;
                n15 = parsableByteArray.readUnsignedShort();
                f10 = 0.0f;
                for (n13 = 0; n13 < n15; ++n13) {
                    ParsableByteArray parsableByteArray2 = this.parsableByteArray;
                    this.applyStyleRecord(parsableByteArray2, spannableStringBuilder);
                }
            } else {
                n13 = 1952608120;
                f10 = 7.176025E31f;
                if (n15 == n13 && (n15 = (int)(this.customVerticalPlacement ? 1 : 0)) != 0) {
                    object = this.parsableByteArray;
                    int n16 = ((ParsableByteArray)object).bytesLeft();
                    if (n16 < n14) {
                        bl3 = false;
                    }
                    Tx3gDecoder.assertTrue(bl3);
                    object = this.parsableByteArray;
                    n16 = ((ParsableByteArray)object).readUnsignedShort();
                    f12 = n16;
                    f11 = this.calculatedVideoTrackHeight;
                    f12 /= f11;
                    n15 = 0;
                    f11 = 0.0f;
                    parsableByteArray = null;
                    n13 = 0x3F733333;
                    f10 = 0.95f;
                    f12 = Util.constrainValue(f12, 0.0f, f10);
                }
            }
            parsableByteArray = this.parsableByteArray;
            parsableByteArray.setPosition(n11 += n12);
        }
        object2 = new Cue$Builder();
        object = ((Cue$Builder)object2).setText((CharSequence)spannableStringBuilder).setLine(f12, 0).setLineAnchor(0).build();
        object3 = new Tx3gSubtitle((Cue)object);
        return object3;
    }
}

