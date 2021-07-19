/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Layout$Alignment
 *  android.text.SpannableString
 *  android.text.SpannableStringBuilder
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.StyleSpan
 *  android.text.style.UnderlineSpan
 */
package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder$CueStyle;
import com.google.android.exoplayer2.util.Util;
import java.io.Serializable;
import java.util.List;

public final class Cea608Decoder$CueBuilder {
    private static final int BASE_ROW = 15;
    private static final int SCREEN_CHARWIDTH = 32;
    private int captionMode;
    private int captionRowCount;
    private final StringBuilder captionStringBuilder;
    private final List cueStyles;
    private int indent;
    private final List rolledUpCaptions;
    private int row;
    private int tabOffset;

    public Cea608Decoder$CueBuilder(int n10, int n11) {
        Serializable serializable;
        this.cueStyles = serializable = new Serializable();
        this.rolledUpCaptions = serializable = new Serializable();
        this.captionStringBuilder = serializable;
        this.reset(n10);
        this.captionRowCount = n11;
    }

    public static /* synthetic */ int access$002(Cea608Decoder$CueBuilder cea608Decoder$CueBuilder, int n10) {
        cea608Decoder$CueBuilder.tabOffset = n10;
        return n10;
    }

    public static /* synthetic */ int access$100(Cea608Decoder$CueBuilder cea608Decoder$CueBuilder) {
        return cea608Decoder$CueBuilder.row;
    }

    public static /* synthetic */ int access$102(Cea608Decoder$CueBuilder cea608Decoder$CueBuilder, int n10) {
        cea608Decoder$CueBuilder.row = n10;
        return n10;
    }

    public static /* synthetic */ int access$202(Cea608Decoder$CueBuilder cea608Decoder$CueBuilder, int n10) {
        cea608Decoder$CueBuilder.indent = n10;
        return n10;
    }

    private SpannableString buildCurrentLine() {
        Object object;
        int n10;
        StringBuilder stringBuilder = this.captionStringBuilder;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)stringBuilder);
        int n11 = spannableStringBuilder.length();
        int n12 = -1;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = n12;
        int n17 = n12;
        int n18 = n12;
        int n19 = n12;
        while (n13 < (n10 = (object = this.cueStyles).size())) {
            object = (Cea608Decoder$CueBuilder$CueStyle)this.cueStyles.get(n13);
            boolean bl2 = ((Cea608Decoder$CueBuilder$CueStyle)object).underline;
            int n20 = ((Cea608Decoder$CueBuilder$CueStyle)object).style;
            int n21 = 8;
            if (n20 != n21) {
                n15 = 7;
                n21 = n20 == n15 ? 1 : 0;
                if (n20 != n15) {
                    int[] nArray = Cea608Decoder.access$300();
                    n19 = nArray[n20];
                }
                n15 = n21;
            }
            n10 = ((Cea608Decoder$CueBuilder$CueStyle)object).start;
            Object object2 = this.cueStyles;
            n20 = object2.size();
            if (++n13 < n20) {
                object2 = (Cea608Decoder$CueBuilder$CueStyle)this.cueStyles.get(n13);
                n20 = ((Cea608Decoder$CueBuilder$CueStyle)object2).start;
            } else {
                n20 = n11;
            }
            if (n10 == n20) continue;
            if (n16 != n12 && !bl2) {
                Cea608Decoder$CueBuilder.setUnderlineSpan(spannableStringBuilder, n16, n10);
                n16 = n12;
            } else if (n16 == n12 && bl2) {
                n16 = n10;
            }
            if (n17 != n12 && n15 == 0) {
                Cea608Decoder$CueBuilder.setItalicSpan(spannableStringBuilder, n17, n10);
                n17 = n12;
            } else if (n17 == n12 && n15 != 0) {
                n17 = n10;
            }
            if (n19 == n18) continue;
            Cea608Decoder$CueBuilder.setColorSpan(spannableStringBuilder, n14, n10, n18);
            n18 = n19;
            n14 = n10;
        }
        if (n16 != n12 && n16 != n11) {
            Cea608Decoder$CueBuilder.setUnderlineSpan(spannableStringBuilder, n16, n11);
        }
        if (n17 != n12 && n17 != n11) {
            Cea608Decoder$CueBuilder.setItalicSpan(spannableStringBuilder, n17, n11);
        }
        if (n14 != n11) {
            Cea608Decoder$CueBuilder.setColorSpan(spannableStringBuilder, n14, n11, n18);
        }
        stringBuilder = new SpannableString((CharSequence)spannableStringBuilder);
        return stringBuilder;
    }

    private static void setColorSpan(SpannableStringBuilder spannableStringBuilder, int n10, int n11, int n12) {
        int n13 = -1;
        if (n12 == n13) {
            return;
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(n12);
        spannableStringBuilder.setSpan((Object)foregroundColorSpan, n10, n11, 33);
    }

    private static void setItalicSpan(SpannableStringBuilder spannableStringBuilder, int n10, int n11) {
        StyleSpan styleSpan = new StyleSpan(2);
        spannableStringBuilder.setSpan((Object)styleSpan, n10, n11, 33);
    }

    private static void setUnderlineSpan(SpannableStringBuilder spannableStringBuilder, int n10, int n11) {
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableStringBuilder.setSpan((Object)underlineSpan, n10, n11, 33);
    }

    public void append(char c10) {
        int n10;
        StringBuilder stringBuilder = this.captionStringBuilder;
        int n11 = stringBuilder.length();
        if (n11 < (n10 = 32)) {
            stringBuilder = this.captionStringBuilder;
            stringBuilder.append(c10);
        }
    }

    public void backspace() {
        StringBuilder stringBuilder = this.captionStringBuilder;
        int n10 = stringBuilder.length();
        if (n10 > 0) {
            Object object = this.captionStringBuilder;
            int n11 = n10 + -1;
            ((StringBuilder)object).delete(n11, n10);
            object = this.cueStyles;
            for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
                Cea608Decoder$CueBuilder$CueStyle cea608Decoder$CueBuilder$CueStyle = (Cea608Decoder$CueBuilder$CueStyle)this.cueStyles.get(i10);
                int n12 = cea608Decoder$CueBuilder$CueStyle.start;
                if (n12 != n10) break;
                cea608Decoder$CueBuilder$CueStyle.start = n12 += -1;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public Cue build(int var1_1) {
        block10: {
            var2_2 = this.indent;
            var3_3 = this.tabOffset;
            var2_2 += var3_3;
            var3_3 = 32 - var2_2;
            var4_4 = new SpannableStringBuilder();
            var5_5 = 0;
            var6_6 = 0.0f;
            var7_7 = null;
            var9_9 = null;
            var10_10 = 0.0f;
            for (var8_8 = 0; var8_8 < (var12_12 = (var11_11 = this.rolledUpCaptions).size()); ++var8_8) {
                var11_11 = Util.truncateAscii((CharSequence)this.rolledUpCaptions.get(var8_8), var3_3);
                var4_4.append((CharSequence)var11_11);
                var12_12 = 10;
                var13_13 = 1.4E-44f;
                var4_4.append((char)var12_12);
            }
            var9_9 = Util.truncateAscii((CharSequence)this.buildCurrentLine(), var3_3);
            var4_4.append(var9_9);
            var8_8 = var4_4.length();
            if (var8_8 == 0) {
                return null;
            }
            var8_8 = var4_4.length();
            var3_3 -= var8_8;
            var8_8 = var2_2 - var3_3;
            var12_12 = -1 << -1;
            var13_13 = -0.0f;
            var14_14 = 2;
            var15_15 = 1;
            if (var1_1 != var12_12) break block10;
            var1_1 = this.captionMode;
            if (var1_1 != var14_14) ** GOTO lbl-1000
            var1_1 = Math.abs(var8_8);
            var12_12 = 3;
            var13_13 = 4.2E-45f;
            if (var1_1 < var12_12 || var3_3 < 0) {
                var1_1 = var15_15;
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = (var1_1 = this.captionMode) == var14_14 && var8_8 > 0 ? var14_14 : 0;
            }
        }
        if (var1_1 == var15_15) ** GOTO lbl57
        var5_5 = 0x3DCCCCCD;
        var6_6 = 0.1f;
        var8_8 = 1061997773;
        var10_10 = 0.8f;
        var12_12 = 0x42000000;
        var13_13 = 32.0f;
        if (var1_1 != var14_14) lbl-1000:
        // 2 sources

        {
            while (true) {
                var16_16 = (float)var2_2 / var13_13 * var10_10 + var6_6;
                break;
            }
        } else {
            var2_2 = 32 - var3_3;
            ** continue;
lbl57:
            // 1 sources

            var2_2 = 0x3F000000;
            var16_16 = 0.5f;
        }
        var3_3 = this.row;
        var5_5 = 7;
        var6_6 = 9.8E-45f;
        if (var3_3 > var5_5) {
            var3_3 = var3_3 + -15 + -2;
        } else {
            var5_5 = this.captionMode;
            if (var5_5 == var15_15) {
                var5_5 = this.captionRowCount - var15_15;
                var3_3 -= var5_5;
            }
        }
        var7_7 = new Cue$Builder();
        var4_4 = var7_7.setText((CharSequence)var4_4);
        var7_7 = Layout.Alignment.ALIGN_NORMAL;
        var4_4 = var4_4.setTextAlignment((Layout.Alignment)var7_7);
        var17_17 = var3_3;
        return var4_4.setLine(var17_17, var15_15).setPosition(var16_16).setPositionAnchor(var1_1).build();
    }

    public boolean isEmpty() {
        Object object = this.cueStyles;
        int n10 = object.isEmpty();
        if (n10 != 0 && (n10 = (object = this.rolledUpCaptions).isEmpty()) != 0 && (n10 = ((StringBuilder)(object = this.captionStringBuilder)).length()) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public void reset(int n10) {
        this.captionMode = n10;
        this.cueStyles.clear();
        this.rolledUpCaptions.clear();
        this.captionStringBuilder.setLength(0);
        this.row = 15;
        this.indent = 0;
        this.tabOffset = 0;
    }

    public void rollUp() {
        List list;
        Object object = this.rolledUpCaptions;
        SpannableString spannableString = this.buildCurrentLine();
        object.add(spannableString);
        object = this.captionStringBuilder;
        spannableString = null;
        ((StringBuilder)object).setLength(0);
        object = this.cueStyles;
        object.clear();
        int n10 = this.captionRowCount;
        int n11 = this.row;
        n10 = Math.min(n10, n11);
        while ((n11 = (list = this.rolledUpCaptions).size()) >= n10) {
            list = this.rolledUpCaptions;
            list.remove(0);
        }
    }

    public void setCaptionMode(int n10) {
        this.captionMode = n10;
    }

    public void setCaptionRowCount(int n10) {
        this.captionRowCount = n10;
    }

    public void setStyle(int n10, boolean bl2) {
        List list = this.cueStyles;
        int n11 = this.captionStringBuilder.length();
        Cea608Decoder$CueBuilder$CueStyle cea608Decoder$CueBuilder$CueStyle = new Cea608Decoder$CueBuilder$CueStyle(n10, bl2, n11);
        list.add(cea608Decoder$CueBuilder$CueStyle);
    }
}

