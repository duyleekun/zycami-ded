/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.text.Layout$Alignment
 *  android.text.SpannableString
 *  android.text.style.ForegroundColorSpan
 */
package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.ssa.SsaDialogueFormat;
import com.google.android.exoplayer2.text.ssa.SsaStyle;
import com.google.android.exoplayer2.text.ssa.SsaStyle$Format;
import com.google.android.exoplayer2.text.ssa.SsaStyle$Overrides;
import com.google.android.exoplayer2.text.ssa.SsaSubtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SsaDecoder
extends SimpleSubtitleDecoder {
    private static final float DEFAULT_MARGIN = 0.05f;
    private static final String DIALOGUE_LINE_PREFIX = "Dialogue:";
    public static final String FORMAT_LINE_PREFIX = "Format:";
    private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public static final String STYLE_LINE_PREFIX = "Style:";
    private static final String TAG = "SsaDecoder";
    private final SsaDialogueFormat dialogueFormatFromInitializationData;
    private final boolean haveInitializationData;
    private float screenHeight;
    private float screenWidth;
    private Map styles;

    public SsaDecoder() {
        this((List)null);
    }

    public SsaDecoder(List object) {
        super(TAG);
        int n10;
        float f10;
        this.screenWidth = f10 = -3.4028235E38f;
        this.screenHeight = f10;
        f10 = 0.0f;
        Object object2 = null;
        if (object != null && (n10 = object.isEmpty()) == 0) {
            n10 = 1;
            this.haveInitializationData = n10;
            object2 = Util.fromUtf8Bytes((byte[])object.get(0));
            String string2 = FORMAT_LINE_PREFIX;
            boolean bl2 = ((String)object2).startsWith(string2);
            Assertions.checkArgument(bl2);
            this.dialogueFormatFromInitializationData = object2 = (SsaDialogueFormat)Assertions.checkNotNull(SsaDialogueFormat.fromFormatLine((String)object2));
            object = (byte[])object.get(n10);
            object2 = new ParsableByteArray((byte[])object);
            this.parseHeader((ParsableByteArray)object2);
        } else {
            this.haveInitializationData = false;
            object = null;
            this.dialogueFormatFromInitializationData = null;
        }
    }

    private static int addCuePlacerholderByTime(long l10, List list, List list2) {
        int n10;
        block4: {
            for (n10 = list.size() + -1; n10 >= 0; n10 += -1) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                long l13 = l12 - l10;
                Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object == false) {
                    return n10;
                }
                l11 = (Long)list.get(n10);
                l12 = l11;
                long l14 = l12 - l10;
                object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object >= 0) continue;
                ++n10;
                break block4;
            }
            n10 = 0;
        }
        Serializable serializable = l10;
        list.add(n10, serializable);
        if (n10 == 0) {
            serializable = new ArrayList();
        } else {
            int n11 = n10 + -1;
            Collection collection = (Collection)list2.get(n11);
            serializable = new ArrayList(collection);
        }
        list2.add(n10, serializable);
        return n10;
    }

    private static float computeDefaultLineOrPosition(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return -3.4028235E38f;
                }
                return 0.95f;
            }
            return 0.5f;
        }
        return 0.05f;
    }

    private static Cue createCue(String object, SsaStyle object2, SsaStyle$Overrides ssaStyle$Overrides, float f10, float f11) {
        float f12;
        float f13;
        int n10;
        SpannableString spannableString = new SpannableString((CharSequence)object);
        object = new Cue$Builder();
        object = ((Cue$Builder)object).setText((CharSequence)spannableString);
        float f14 = -3.4028235E38f;
        if (object2 != null) {
            float f15;
            Integer n11 = ((SsaStyle)object2).primaryColor;
            if (n11 != null) {
                Integer n12 = ((SsaStyle)object2).primaryColor;
                int n13 = n12;
                n11 = new ForegroundColorSpan(n13);
                n13 = spannableString.length();
                int n14 = 33;
                spannableString.setSpan((Object)n11, 0, n13, n14);
            }
            if ((n10 = (int)((f15 = (f13 = ((SsaStyle)object2).fontSize) - f14) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1))) != 0 && (n10 = (int)(f11 == f14 ? 0 : (f11 > f14 ? 1 : -1))) != 0) {
                n10 = 1;
                f12 = Float.MIN_VALUE;
                ((Cue$Builder)object).setTextSize(f13 /= f11, n10);
            }
        }
        int n15 = ssaStyle$Overrides.alignment;
        n10 = -1;
        f12 = 0.0f / 0.0f;
        if (n15 == n10) {
            if (object2 != null) {
                n15 = ((SsaStyle)object2).alignment;
            } else {
                n15 = n10;
                f13 = f12;
            }
        }
        object2 = SsaDecoder.toTextAlignment(n15);
        object2 = ((Cue$Builder)object).setTextAlignment((Layout.Alignment)object2);
        n10 = SsaDecoder.toPositionAnchor(n15);
        object2 = ((Cue$Builder)object2).setPositionAnchor(n10);
        n15 = SsaDecoder.toLineAnchor(n15);
        ((Cue$Builder)object2).setLineAnchor(n15);
        object2 = ssaStyle$Overrides.position;
        if (object2 != null && (n15 = (int)(f11 == f14 ? 0 : (f11 > f14 ? 1 : -1))) != 0 && (n15 = (int)(f10 == f14 ? 0 : (f10 > f14 ? 1 : -1))) != 0) {
            float f16 = ((PointF)object2).x / f10;
            ((Cue$Builder)object).setPosition(f16);
            object2 = ssaStyle$Overrides.position;
            f16 = ((PointF)object2).y / f11;
            ((Cue$Builder)object).setLine(f16, 0);
        } else {
            float f17 = SsaDecoder.computeDefaultLineOrPosition(((Cue$Builder)object).getPositionAnchor());
            ((Cue$Builder)object).setPosition(f17);
            int n16 = ((Cue$Builder)object).getLineAnchor();
            f17 = SsaDecoder.computeDefaultLineOrPosition(n16);
            ((Cue$Builder)object).setLine(f17, 0);
        }
        return ((Cue$Builder)object).build();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void parseDialogueLine(String var1_1, SsaDialogueFormat var2_2, List var3_3, List var4_4) {
        Assertions.checkArgument(var1_1.startsWith("Dialogue:"));
        var5_5 = 9;
        var6_6 = var1_1.substring(var5_5);
        var7_7 = var2_2.length;
        var8_8 = ",";
        var6_6 = var6_6.split(var8_8, var7_7);
        var7_7 = ((String[])var6_6).length;
        var9_9 = var2_2.length;
        var10_10 = "SsaDecoder";
        if (var7_7 != var9_9) {
            var2_2 = "Skipping dialogue line with fewer columns than format: ";
            var11_11 = (var1_1 = String.valueOf(var1_1)).length();
            var1_1 = var11_11 != 0 ? var2_2.concat((String)var1_1) : new String((String)var2_2);
            Log.w(var10_10, (String)var1_1);
            return;
        }
        var7_7 = var2_2.startTimeIndex;
        var12_12 = var6_6[var7_7];
        var13_13 = SsaDecoder.parseTimecodeUs(var12_12);
        var15_14 = -9223372036854775807L;
        var17_15 = var13_13 == var15_14 ? 0 : (var13_13 < var15_14 ? -1 : 1);
        var18_16 = "Skipping invalid timing: ";
        if (var17_15 == false) {
            var19_17 = (var1_1 = String.valueOf(var1_1)).length();
            var1_1 = var19_17 != 0 ? var18_16.concat((String)var1_1) : new String(var18_16);
            Log.w(var10_10, (String)var1_1);
            return;
        }
        var17_15 = var2_2.endTimeIndex;
        var20_20 = var6_6[var17_15];
        var21_21 = SsaDecoder.parseTimecodeUs(var20_20);
        cfr_temp_0 = var21_21 - var15_14;
        var23_22 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
        if (var23_22 /* !! */  == false) {
            var19_18 = (var1_1 = String.valueOf(var1_1)).length();
            var1_1 = var19_18 != 0 ? var18_16.concat((String)var1_1) : new String(var18_16);
            Log.w(var10_10, (String)var1_1);
            return;
        }
        var1_1 = this.styles;
        if (var1_1 == null) ** GOTO lbl-1000
        var24_23 = var2_2.styleIndex;
        var23_22 /* !! */  = -1;
        var25_24 = 0.0f / 0.0f;
        if (var24_23 != var23_22 /* !! */ ) {
            var10_10 = var6_6[var24_23].trim();
            var1_1 = (SsaStyle)var1_1.get(var10_10);
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = null;
        }
        var19_19 = var2_2.textIndex;
        var2_2 = var6_6[var19_19];
        var6_6 = SsaStyle$Overrides.parseFromDialogue((String)var2_2);
        var2_2 = SsaStyle$Overrides.stripStyleOverrides((String)var2_2);
        var26_25 = "\n";
        var2_2 = var2_2.replace("\\N", var26_25).replace("\\n", var26_25);
        var10_10 = "\\h";
        var26_25 = "\u00a0";
        var2_2 = var2_2.replace(var10_10, var26_25);
        var27_26 = this.screenWidth;
        var25_24 = this.screenHeight;
        var1_1 = SsaDecoder.createCue((String)var2_2, (SsaStyle)var1_1, (SsaStyle$Overrides)var6_6, var27_26, var25_24);
        var28_27 = SsaDecoder.addCuePlacerholderByTime(var21_21, var4_4, var3_3);
        for (var19_19 = SsaDecoder.addCuePlacerholderByTime(var13_13, var4_4, var3_3); var19_19 < var28_27; ++var19_19) {
            var6_6 = (List)var3_3.get(var19_19);
            var6_6.add(var1_1);
        }
    }

    private void parseEventBody(ParsableByteArray parsableByteArray, List list, List list2) {
        String string2;
        SsaDialogueFormat ssaDialogueFormat;
        boolean bl2 = this.haveInitializationData;
        if (bl2) {
            ssaDialogueFormat = this.dialogueFormatFromInitializationData;
        } else {
            bl2 = false;
            ssaDialogueFormat = null;
        }
        while ((string2 = parsableByteArray.readLine()) != null) {
            String string3 = FORMAT_LINE_PREFIX;
            boolean bl3 = string2.startsWith(string3);
            if (bl3) {
                ssaDialogueFormat = SsaDialogueFormat.fromFormatLine(string2);
                continue;
            }
            string3 = DIALOGUE_LINE_PREFIX;
            bl3 = string2.startsWith(string3);
            if (!bl3) continue;
            if (ssaDialogueFormat == null) {
                string3 = "Skipping dialogue line before complete format: ";
                int n10 = (string2 = String.valueOf(string2)).length();
                string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
                string3 = TAG;
                Log.w(string3, string2);
                continue;
            }
            this.parseDialogueLine(string2, ssaDialogueFormat, list, list2);
        }
    }

    private void parseHeader(ParsableByteArray parsableByteArray) {
        Object object;
        while ((object = parsableByteArray.readLine()) != null) {
            String string2 = "[Script Info]";
            boolean bl2 = string2.equalsIgnoreCase((String)object);
            if (bl2) {
                this.parseScriptInfo(parsableByteArray);
                continue;
            }
            string2 = "[V4+ Styles]";
            bl2 = string2.equalsIgnoreCase((String)object);
            if (bl2) {
                this.styles = object = SsaDecoder.parseStyles(parsableByteArray);
                continue;
            }
            string2 = "[V4 Styles]";
            bl2 = string2.equalsIgnoreCase((String)object);
            if (bl2) {
                object = TAG;
                string2 = "[V4 Styles] are not supported";
                Log.i((String)object, string2);
                continue;
            }
            string2 = "[Events]";
            boolean bl3 = string2.equalsIgnoreCase((String)object);
            if (!bl3) continue;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void parseScriptInfo(ParsableByteArray parsableByteArray) {
        int n10;
        int n11;
        Object object;
        while (!((object = parsableByteArray.readLine()) == null || (n11 = parsableByteArray.bytesLeft()) != 0 && (n11 = parsableByteArray.peekUnsignedByte()) == (n10 = 91))) {
            float f10;
            String string2 = ":";
            n11 = ((String[])(object = ((String)object).split(string2))).length;
            if (n11 != (n10 = 2)) continue;
            n11 = 0;
            string2 = Util.toLowerInvariant(object[0].trim());
            string2.hashCode();
            String string3 = "playresx";
            n10 = (int)(string2.equals(string3) ? 1 : 0);
            int n12 = 1;
            if (n10 == 0) {
                string3 = "playresy";
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) continue;
                object = object[n12];
                object = ((String)object).trim();
                f10 = Float.parseFloat((String)object);
                this.screenHeight = f10;
                continue;
            }
            try {
                object = object[n12];
            }
            catch (NumberFormatException numberFormatException) {
                continue;
            }
            object = ((String)object).trim();
            f10 = Float.parseFloat((String)object);
            this.screenWidth = f10;
        }
    }

    private static Map parseStyles(ParsableByteArray parsableByteArray) {
        int n10;
        int n11;
        Object object;
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        SsaStyle$Format ssaStyle$Format = null;
        while ((object = parsableByteArray.readLine()) != null && ((n11 = parsableByteArray.bytesLeft()) == 0 || (n11 = parsableByteArray.peekUnsignedByte()) != (n10 = 91))) {
            String string2 = FORMAT_LINE_PREFIX;
            n11 = (int)(((String)object).startsWith(string2) ? 1 : 0);
            if (n11 != 0) {
                ssaStyle$Format = SsaStyle$Format.fromFormatLine((String)object);
                continue;
            }
            string2 = STYLE_LINE_PREFIX;
            n11 = (int)(((String)object).startsWith(string2) ? 1 : 0);
            if (n11 == 0) continue;
            if (ssaStyle$Format == null) {
                string2 = "Skipping 'Style:' line before 'Format:' line: ";
                n10 = ((String)(object = String.valueOf(object))).length();
                object = n10 != 0 ? string2.concat((String)object) : new String(string2);
                string2 = TAG;
                Log.w(string2, (String)object);
                continue;
            }
            if ((object = SsaStyle.fromStyleLine((String)object, ssaStyle$Format)) == null) continue;
            string2 = ((SsaStyle)object).name;
            linkedHashMap.put(string2, object);
        }
        return linkedHashMap;
    }

    private static long parseTimecodeUs(String object) {
        Pattern pattern = SSA_TIMECODE_PATTERN;
        object = ((String)object).trim();
        boolean bl2 = ((Matcher)(object = pattern.matcher((CharSequence)object))).matches();
        if (!bl2) {
            return -9223372036854775807L;
        }
        long l10 = Long.parseLong((String)Util.castNonNull(((Matcher)object).group(1)));
        long l11 = 60;
        l10 = l10 * l11 * l11;
        long l12 = 1000000L;
        l10 *= l12;
        long l13 = Long.parseLong((String)Util.castNonNull(((Matcher)object).group(2))) * l11 * l12;
        l10 += l13;
        l11 = Long.parseLong((String)Util.castNonNull(((Matcher)object).group(3))) * l12;
        l10 += l11;
        l11 = Long.parseLong((String)Util.castNonNull(((Matcher)object).group(4))) * 10000L;
        return l10 + l11;
    }

    private static int toLineAnchor(int n10) {
        int n11 = -1 << -1;
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder(30);
                stringBuilder.append("Unknown alignment: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                Log.w(TAG, string2);
                return n11;
            }
            case 7: 
            case 8: 
            case 9: {
                return 0;
            }
            case 4: 
            case 5: 
            case 6: {
                return 1;
            }
            case 1: 
            case 2: 
            case 3: {
                return 2;
            }
            case -1: 
        }
        return n11;
    }

    private static int toPositionAnchor(int n10) {
        int n11 = -1 << -1;
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder(30);
                stringBuilder.append("Unknown alignment: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                Log.w(TAG, string2);
                return n11;
            }
            case 3: 
            case 6: 
            case 9: {
                return 2;
            }
            case 2: 
            case 5: 
            case 8: {
                return 1;
            }
            case 1: 
            case 4: 
            case 7: {
                return 0;
            }
            case -1: 
        }
        return n11;
    }

    private static Layout.Alignment toTextAlignment(int n10) {
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder(30);
                stringBuilder.append("Unknown alignment: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                Log.w(TAG, string2);
                return null;
            }
            case 3: 
            case 6: 
            case 9: {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            case 2: 
            case 5: 
            case 8: {
                return Layout.Alignment.ALIGN_CENTER;
            }
            case 1: 
            case 4: 
            case 7: {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            case -1: 
        }
        return null;
    }

    public Subtitle decode(byte[] object, int n10, boolean bl2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[])object, n10);
        boolean bl3 = this.haveInitializationData;
        if (!bl3) {
            this.parseHeader(parsableByteArray);
        }
        this.parseEventBody(parsableByteArray, arrayList, arrayList2);
        object = new SsaSubtitle;
        object(arrayList, arrayList2);
        return object;
    }
}

