/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.text.Layout$Alignment
 *  android.text.SpannableString
 *  android.text.SpannableStringBuilder
 *  android.text.style.BackgroundColorSpan
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.StyleSpan
 *  android.text.style.UnderlineSpan
 */
package com.google.android.exoplayer2.text.cea;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.cea.Cea708Decoder$Cea708CueInfo;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.List;

public final class Cea708Decoder$CueInfoBuilder {
    private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
    private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
    public static final int COLOR_SOLID_BLACK = 0;
    public static final int COLOR_SOLID_WHITE = 0;
    public static final int COLOR_TRANSPARENT = 0;
    private static final int DEFAULT_PRIORITY = 4;
    private static final int DIRECTION_BOTTOM_TO_TOP = 3;
    private static final int DIRECTION_LEFT_TO_RIGHT = 0;
    private static final int DIRECTION_RIGHT_TO_LEFT = 1;
    private static final int DIRECTION_TOP_TO_BOTTOM = 2;
    private static final int HORIZONTAL_SIZE = 209;
    private static final int JUSTIFICATION_CENTER = 2;
    private static final int JUSTIFICATION_FULL = 3;
    private static final int JUSTIFICATION_LEFT = 0;
    private static final int JUSTIFICATION_RIGHT = 1;
    private static final int MAXIMUM_ROW_COUNT = 15;
    private static final int PEN_FONT_STYLE_DEFAULT = 0;
    private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
    private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
    private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
    private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
    private static final int PEN_OFFSET_NORMAL = 1;
    private static final int PEN_SIZE_STANDARD = 1;
    private static final int[] PEN_STYLE_BACKGROUND;
    private static final int[] PEN_STYLE_EDGE_TYPE;
    private static final int[] PEN_STYLE_FONT_STYLE;
    private static final int RELATIVE_CUE_SIZE = 99;
    private static final int VERTICAL_SIZE = 74;
    private static final int[] WINDOW_STYLE_FILL;
    private static final int[] WINDOW_STYLE_JUSTIFICATION;
    private static final int[] WINDOW_STYLE_PRINT_DIRECTION;
    private static final int[] WINDOW_STYLE_SCROLL_DIRECTION;
    private static final boolean[] WINDOW_STYLE_WORD_WRAP;
    private int anchorId;
    private int backgroundColor;
    private int backgroundColorStartPosition;
    private final SpannableStringBuilder captionStringBuilder;
    private boolean defined;
    private int foregroundColor;
    private int foregroundColorStartPosition;
    private int horizontalAnchor;
    private int italicsStartPosition;
    private int justification;
    private int penStyleId;
    private int priority;
    private boolean relativePositioning;
    private final List rolledUpCaptions;
    private int row;
    private int rowCount;
    private boolean rowLock;
    private int underlineStartPosition;
    private int verticalAnchor;
    private boolean visible;
    private int windowFillColor;
    private int windowStyleId;

    static {
        Object[] objectArray;
        int n10;
        int n11;
        int n12 = 2;
        COLOR_SOLID_WHITE = Cea708Decoder$CueInfoBuilder.getArgbColorFromCeaColor(n12, n12, n12, 0);
        COLOR_SOLID_BLACK = n11 = Cea708Decoder$CueInfoBuilder.getArgbColorFromCeaColor(0, 0, 0, 0);
        int n13 = 3;
        COLOR_TRANSPARENT = n10 = Cea708Decoder$CueInfoBuilder.getArgbColorFromCeaColor(0, 0, 0, n13);
        int n14 = 7;
        int[] nArray = objectArray = new int[n14];
        int[] nArray2 = objectArray;
        nArray[0] = 0;
        nArray2[1] = 0;
        nArray[2] = 0;
        nArray2[3] = 0;
        nArray[4] = 0;
        nArray2[5] = 2;
        nArray2[6] = 0;
        WINDOW_STYLE_JUSTIFICATION = objectArray;
        int[] nArray3 = objectArray = new int[n14];
        int[] nArray4 = objectArray;
        nArray3[0] = 0;
        nArray4[1] = 0;
        nArray3[2] = 0;
        nArray4[3] = 0;
        nArray3[4] = 0;
        nArray4[5] = 0;
        nArray4[6] = 2;
        WINDOW_STYLE_PRINT_DIRECTION = objectArray;
        int[] nArray5 = objectArray = new int[n14];
        int[] nArray6 = objectArray;
        nArray5[0] = 3;
        nArray6[1] = 3;
        nArray5[2] = 3;
        nArray6[3] = 3;
        nArray5[4] = 3;
        nArray6[5] = 3;
        nArray6[6] = 1;
        WINDOW_STYLE_SCROLL_DIRECTION = objectArray;
        Object[] objectArray2 = objectArray = (Object[])new boolean[n14];
        Object[] objectArray3 = objectArray;
        objectArray2[0] = 0;
        objectArray3[1] = 0;
        objectArray2[2] = 0;
        objectArray3[3] = 1;
        objectArray2[4] = 1;
        objectArray3[5] = 1;
        objectArray3[6] = 0;
        WINDOW_STYLE_WORD_WRAP = (boolean[])objectArray;
        objectArray = new int[n14];
        objectArray[0] = n11;
        int n15 = 1;
        objectArray[n15] = n10;
        objectArray[n12] = n11;
        objectArray[n13] = n11;
        int n16 = 4;
        objectArray[n16] = n10;
        int n17 = 5;
        objectArray[n17] = n11;
        int n18 = 6;
        objectArray[n18] = n11;
        WINDOW_STYLE_FILL = objectArray;
        Object[] objectArray4 = objectArray = new int[n14];
        Object[] objectArray5 = objectArray;
        objectArray4[0] = 0;
        objectArray5[1] = 1;
        objectArray4[2] = 2;
        objectArray5[3] = 3;
        objectArray4[4] = 4;
        objectArray5[5] = 3;
        objectArray5[6] = 4;
        PEN_STYLE_FONT_STYLE = objectArray;
        Object[] objectArray6 = objectArray = new int[n14];
        Object[] objectArray7 = objectArray;
        objectArray6[0] = 0;
        objectArray7[1] = 0;
        objectArray6[2] = 0;
        objectArray7[3] = 0;
        objectArray6[4] = 0;
        objectArray7[5] = 3;
        objectArray7[6] = 3;
        PEN_STYLE_EDGE_TYPE = objectArray;
        int[] nArray7 = new int[n14];
        nArray7[0] = n11;
        nArray7[n15] = n11;
        nArray7[n12] = n11;
        nArray7[n13] = n11;
        nArray7[n16] = n11;
        nArray7[n17] = n10;
        nArray7[n18] = n10;
        PEN_STYLE_BACKGROUND = nArray7;
    }

    public Cea708Decoder$CueInfoBuilder() {
        SpannableStringBuilder spannableStringBuilder;
        this.rolledUpCaptions = spannableStringBuilder = new ArrayList();
        this.captionStringBuilder = spannableStringBuilder = new SpannableStringBuilder();
        this.reset();
    }

    public static int getArgbColorFromCeaColor(int n10, int n11, int n12) {
        return Cea708Decoder$CueInfoBuilder.getArgbColorFromCeaColor(n10, n11, n12, 0);
    }

    public static int getArgbColorFromCeaColor(int n10, int n11, int n12, int n13) {
        int n14;
        int n15;
        int n16;
        block3: {
            block1: {
                block2: {
                    n16 = 0;
                    n15 = 4;
                    Assertions.checkIndex(n10, 0, n15);
                    Assertions.checkIndex(n11, 0, n15);
                    Assertions.checkIndex(n12, 0, n15);
                    Assertions.checkIndex(n13, 0, n15);
                    n15 = 1;
                    n14 = 255;
                    if (n13 == 0 || n13 == n15) break block1;
                    int n17 = 2;
                    if (n13 == n17) break block2;
                    n17 = 3;
                    if (n13 != n17) break block1;
                    n13 = 0;
                    break block3;
                }
                n13 = 127;
                break block3;
            }
            n13 = n14;
        }
        n10 = n10 > n15 ? n14 : 0;
        n11 = n11 > n15 ? n14 : 0;
        if (n12 > n15) {
            n16 = n14;
        }
        return Color.argb((int)n13, (int)n10, (int)n11, (int)n16);
    }

    public void append(char n10) {
        int n11 = 10;
        if (n10 == n11) {
            List list = this.rolledUpCaptions;
            SpannableString spannableString = this.buildSpannableString();
            list.add(spannableString);
            list = this.captionStringBuilder;
            list.clear();
            n10 = this.italicsStartPosition;
            n11 = -1;
            if (n10 != n11) {
                this.italicsStartPosition = 0;
            }
            if ((n10 = this.underlineStartPosition) != n11) {
                this.underlineStartPosition = 0;
            }
            if ((n10 = this.foregroundColorStartPosition) != n11) {
                this.foregroundColorStartPosition = 0;
            }
            if ((n10 = this.backgroundColorStartPosition) != n11) {
                this.backgroundColorStartPosition = 0;
            }
            while ((n10 = (int)(this.rowLock ? 1 : 0)) != 0 && (n10 = (list = this.rolledUpCaptions).size()) >= (n11 = this.rowCount) || (n10 = (list = this.rolledUpCaptions).size()) >= (n11 = 15)) {
                list = this.rolledUpCaptions;
                list.remove(0);
            }
        } else {
            SpannableStringBuilder spannableStringBuilder = this.captionStringBuilder;
            spannableStringBuilder.append((char)n10);
        }
    }

    public void backspace() {
        SpannableStringBuilder spannableStringBuilder = this.captionStringBuilder;
        int n10 = spannableStringBuilder.length();
        if (n10 > 0) {
            SpannableStringBuilder spannableStringBuilder2 = this.captionStringBuilder;
            int n11 = n10 + -1;
            spannableStringBuilder2.delete(n11, n10);
        }
    }

    public Cea708Decoder$Cea708CueInfo build() {
        Cea708Decoder$Cea708CueInfo cea708Decoder$Cea708CueInfo;
        float f10;
        int n10;
        float f11;
        int n11;
        float f12;
        int n12;
        float f13;
        int n13;
        float f14;
        Object object;
        int n14;
        int n15;
        float f15;
        Object object2;
        float f16;
        SpannableStringBuilder spannableStringBuilder;
        int n16;
        block17: {
            block14: {
                block15: {
                    block16: {
                        n16 = this.isEmpty();
                        if (n16 != 0) {
                            return null;
                        }
                        spannableStringBuilder = new SpannableStringBuilder();
                        n16 = 0;
                        f16 = 0.0f;
                        IllegalArgumentException illegalArgumentException = null;
                        object2 = null;
                        f15 = 0.0f;
                        for (n15 = 0; n15 < (n14 = (object = this.rolledUpCaptions).size()); ++n15) {
                            object = (CharSequence)this.rolledUpCaptions.get(n15);
                            spannableStringBuilder.append((CharSequence)object);
                            n14 = 10;
                            f14 = 1.4E-44f;
                            spannableStringBuilder.append((char)n14);
                        }
                        object2 = this.buildSpannableString();
                        spannableStringBuilder.append((CharSequence)object2);
                        n15 = this.justification;
                        n14 = 2;
                        f14 = 2.8E-45f;
                        n13 = 3;
                        f13 = 4.2E-45f;
                        n12 = 1;
                        f12 = Float.MIN_VALUE;
                        if (n15 == 0) break block14;
                        if (n15 == n12) break block15;
                        if (n15 == n14) break block16;
                        if (n15 != n13) {
                            n15 = this.justification;
                            object = new StringBuilder(43);
                            ((StringBuilder)object).append("Unexpected justification value: ");
                            ((StringBuilder)object).append(n15);
                            object2 = ((StringBuilder)object).toString();
                            illegalArgumentException = new IllegalArgumentException((String)object2);
                            throw illegalArgumentException;
                        }
                        break block14;
                    }
                    object2 = Layout.Alignment.ALIGN_CENTER;
                    break block17;
                }
                object2 = Layout.Alignment.ALIGN_OPPOSITE;
                break block17;
            }
            object2 = Layout.Alignment.ALIGN_NORMAL;
        }
        SpannableString spannableString = object2;
        n15 = (int)(this.relativePositioning ? 1 : 0);
        if (n15 != 0) {
            n15 = this.horizontalAnchor;
            f15 = n15;
            n11 = 1120272384;
            f11 = 99.0f;
            f15 /= f11;
            n10 = this.verticalAnchor;
            f10 = (float)n10 / f11;
        } else {
            n15 = this.horizontalAnchor;
            f15 = (float)n15 / 209.0f;
            n11 = this.verticalAnchor;
            f11 = n11;
            n10 = 1116995584;
            f10 = f11 / 74.0f;
        }
        n11 = 0x3F666666;
        f11 = 0.9f;
        int n17 = 1028443341;
        float f17 = 0.05f;
        float f18 = (f15 *= f11) + f17;
        f10 *= f11;
        f11 = f10 + f17;
        n15 = this.anchorId;
        n10 = n15 / 3;
        if (n10 == 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            n10 = n15 / 3;
            if (n10 == n12) {
                n10 = n12;
                f10 = f12;
            } else {
                n10 = n14;
                f10 = f14;
            }
        }
        n17 = n15 % 3;
        if (n17 == 0) {
            n17 = 0;
            f17 = 0.0f;
        } else if ((n15 %= n13) == n12) {
            n17 = n12;
            f17 = f12;
        } else {
            n17 = n14;
            f17 = f14;
        }
        int n18 = this.windowFillColor;
        n15 = COLOR_SOLID_BLACK;
        if (n18 != n15) {
            n16 = n12;
            f16 = f12;
        }
        int n19 = this.priority;
        object2 = cea708Decoder$Cea708CueInfo;
        object = spannableString;
        f13 = f11;
        int n20 = n10;
        f11 = f18;
        n10 = n17;
        f10 = f17;
        n17 = -8388609;
        f17 = -3.4028235E38f;
        f18 = f16;
        cea708Decoder$Cea708CueInfo = new Cea708Decoder$Cea708CueInfo((CharSequence)spannableStringBuilder, (Layout.Alignment)spannableString, f13, 0, n20, f11, n10, f17, n16 != 0, n18, n19);
        return cea708Decoder$Cea708CueInfo;
    }

    public SpannableString buildSpannableString() {
        SpannableStringBuilder spannableStringBuilder = this.captionStringBuilder;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder((CharSequence)spannableStringBuilder);
        int n10 = spannableStringBuilder2.length();
        if (n10 > 0) {
            int n11;
            StyleSpan styleSpan;
            int n12 = this.italicsStartPosition;
            int n13 = 33;
            int n14 = -1;
            if (n12 != n14) {
                styleSpan = new StyleSpan(2);
                n11 = this.italicsStartPosition;
                spannableStringBuilder2.setSpan((Object)styleSpan, n11, n10, n13);
            }
            if ((n12 = this.underlineStartPosition) != n14) {
                styleSpan = new UnderlineSpan();
                n11 = this.underlineStartPosition;
                spannableStringBuilder2.setSpan((Object)styleSpan, n11, n10, n13);
            }
            if ((n12 = this.foregroundColorStartPosition) != n14) {
                n11 = this.foregroundColor;
                styleSpan = new ForegroundColorSpan(n11);
                n11 = this.foregroundColorStartPosition;
                spannableStringBuilder2.setSpan((Object)styleSpan, n11, n10, n13);
            }
            if ((n12 = this.backgroundColorStartPosition) != n14) {
                n14 = this.backgroundColor;
                styleSpan = new BackgroundColorSpan(n14);
                n14 = this.backgroundColorStartPosition;
                spannableStringBuilder2.setSpan((Object)styleSpan, n14, n10, n13);
            }
        }
        spannableStringBuilder = new SpannableString((CharSequence)spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void clear() {
        int n10;
        this.rolledUpCaptions.clear();
        this.captionStringBuilder.clear();
        this.italicsStartPosition = n10 = -1;
        this.underlineStartPosition = n10;
        this.foregroundColorStartPosition = n10;
        this.backgroundColorStartPosition = n10;
        this.row = 0;
    }

    /*
     * WARNING - void declaration
     */
    public void defineWindow(boolean n10, boolean n11, boolean bl2, int n12, boolean bl3, int n13, int n14, int n15, int n16, int n17, int n18, int n19) {
        int n20;
        int[] nArray;
        int[] nArray2;
        int n21;
        int[] nArray3;
        boolean[] blArray;
        List list;
        int n22;
        void var10_12;
        int n23;
        int n24;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        void var12_14;
        void var11_13;
        Cea708Decoder$CueInfoBuilder cea708Decoder$CueInfoBuilder = this;
        int n25 = n11;
        int n26 = var11_13;
        int n27 = var12_14;
        this.defined = bl6 = true;
        boolean bl7 = n10;
        this.visible = n10;
        this.rowLock = n11;
        bl7 = bl5;
        this.priority = bl5;
        bl7 = bl4;
        this.relativePositioning = bl4;
        bl7 = n24;
        this.verticalAnchor = n24;
        bl7 = n23;
        this.horizontalAnchor = n23;
        bl7 = var10_12;
        this.anchorId = var10_12;
        bl7 = this.rowCount;
        boolean bl8 = n22 + true;
        if (bl7 != bl8) {
            this.rowCount = bl8;
            while (n25 != 0 && (bl7 = (list = cea708Decoder$CueInfoBuilder.rolledUpCaptions).size()) >= (bl8 = cea708Decoder$CueInfoBuilder.rowCount) || (bl7 = (list = cea708Decoder$CueInfoBuilder.rolledUpCaptions).size()) >= (bl8 = 15 != 0)) {
                list = cea708Decoder$CueInfoBuilder.rolledUpCaptions;
                bl8 = false;
                blArray = null;
                list.remove(0);
            }
        }
        if (n26 != 0 && (n25 = cea708Decoder$CueInfoBuilder.windowStyleId) != n26) {
            cea708Decoder$CueInfoBuilder.windowStyleId = n26;
            n25 = n26 + -1;
            nArray3 = WINDOW_STYLE_FILL;
            n26 = nArray3[n25];
            bl7 = COLOR_TRANSPARENT;
            blArray = WINDOW_STYLE_WORD_WRAP;
            bl8 = blArray[n25];
            n21 = 0;
            nArray2 = null;
            nArray = WINDOW_STYLE_PRINT_DIRECTION;
            n20 = nArray[n25];
            int[] nArray4 = WINDOW_STYLE_SCROLL_DIRECTION;
            int n28 = nArray4[n25];
            int[] nArray5 = WINDOW_STYLE_JUSTIFICATION;
            n25 = nArray5[n25];
            n11 = n26;
            boolean bl9 = bl7;
            bl5 = bl8;
            bl4 = false;
            n24 = n20;
            n23 = n28;
            n22 = n25;
            this.setWindowAttributes(n26, (int)(bl7 ? 1 : 0), bl8, 0, n20, n28, n25);
        }
        if (n27 != 0 && (n25 = cea708Decoder$CueInfoBuilder.penStyleId) != n27) {
            cea708Decoder$CueInfoBuilder.penStyleId = n27;
            n25 = n27 + -1;
            nArray3 = null;
            bl6 = true;
            bl7 = false;
            list = null;
            bl8 = false;
            blArray = null;
            nArray2 = PEN_STYLE_EDGE_TYPE;
            n21 = nArray2[n25];
            nArray = PEN_STYLE_FONT_STYLE;
            n20 = nArray[n25];
            n11 = 0;
            int n29 = 1;
            bl5 = bl6;
            bl4 = false;
            n24 = 0;
            n23 = n21;
            n22 = n20;
            this.setPenAttributes(0, n29, (int)(bl6 ? 1 : 0), false, false, n21, n20);
            n26 = COLOR_SOLID_WHITE;
            int[] nArray6 = PEN_STYLE_BACKGROUND;
            n25 = nArray6[n25];
            n27 = COLOR_SOLID_BLACK;
            this.setPenColor(n26, n25, n27);
        }
    }

    public boolean isDefined() {
        return this.defined;
    }

    public boolean isEmpty() {
        List list;
        int n10 = this.isDefined();
        if (n10 != 0 && ((n10 = (list = this.rolledUpCaptions).isEmpty()) == 0 || (n10 = (list = this.captionStringBuilder).length()) != 0)) {
            n10 = 0;
            list = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void reset() {
        int n10;
        int n11;
        this.clear();
        this.defined = false;
        this.visible = false;
        this.priority = 4;
        this.relativePositioning = false;
        this.verticalAnchor = 0;
        this.horizontalAnchor = 0;
        this.anchorId = 0;
        this.rowCount = 15;
        this.rowLock = true;
        this.justification = 0;
        this.windowStyleId = 0;
        this.penStyleId = 0;
        this.windowFillColor = n11 = COLOR_SOLID_BLACK;
        this.foregroundColor = n10 = COLOR_SOLID_WHITE;
        this.backgroundColor = n11;
    }

    public void setPenAttributes(int n10, int n11, int n12, boolean bl2, boolean bl3, int n13, int n14) {
        int n15;
        StyleSpan styleSpan;
        SpannableStringBuilder spannableStringBuilder;
        n10 = this.italicsStartPosition;
        n11 = 33;
        n12 = -1;
        if (n10 != n12) {
            if (!bl2) {
                spannableStringBuilder = this.captionStringBuilder;
                styleSpan = new StyleSpan(2);
                n15 = this.italicsStartPosition;
                SpannableStringBuilder spannableStringBuilder2 = this.captionStringBuilder;
                int n16 = spannableStringBuilder2.length();
                spannableStringBuilder.setSpan((Object)styleSpan, n15, n16, n11);
                this.italicsStartPosition = n12;
            }
        } else if (bl2) {
            spannableStringBuilder = this.captionStringBuilder;
            this.italicsStartPosition = n10 = spannableStringBuilder.length();
        }
        if ((n10 = this.underlineStartPosition) != n12) {
            if (!bl3) {
                spannableStringBuilder = this.captionStringBuilder;
                styleSpan = new UnderlineSpan();
                int n17 = this.underlineStartPosition;
                SpannableStringBuilder spannableStringBuilder3 = this.captionStringBuilder;
                n15 = spannableStringBuilder3.length();
                spannableStringBuilder.setSpan((Object)styleSpan, n17, n15, n11);
                this.underlineStartPosition = n12;
            }
        } else if (bl3) {
            spannableStringBuilder = this.captionStringBuilder;
            this.underlineStartPosition = n10 = spannableStringBuilder.length();
        }
    }

    public void setPenColor(int n10, int n11, int n12) {
        SpannableStringBuilder spannableStringBuilder;
        ForegroundColorSpan foregroundColorSpan;
        SpannableStringBuilder spannableStringBuilder2;
        n12 = this.foregroundColorStartPosition;
        int n13 = 33;
        int n14 = -1;
        if (n12 != n14 && (n12 = this.foregroundColor) != n10) {
            spannableStringBuilder2 = this.captionStringBuilder;
            int n15 = this.foregroundColor;
            foregroundColorSpan = new ForegroundColorSpan(n15);
            n15 = this.foregroundColorStartPosition;
            SpannableStringBuilder spannableStringBuilder3 = this.captionStringBuilder;
            int n16 = spannableStringBuilder3.length();
            spannableStringBuilder2.setSpan((Object)foregroundColorSpan, n15, n16, n13);
        }
        if (n10 != (n12 = COLOR_SOLID_WHITE)) {
            spannableStringBuilder2 = this.captionStringBuilder;
            this.foregroundColorStartPosition = n12 = spannableStringBuilder2.length();
            this.foregroundColor = n10;
        }
        if ((n10 = this.backgroundColorStartPosition) != n14 && (n10 = this.backgroundColor) != n11) {
            spannableStringBuilder = this.captionStringBuilder;
            n14 = this.backgroundColor;
            spannableStringBuilder2 = new BackgroundColorSpan(n14);
            n14 = this.backgroundColorStartPosition;
            foregroundColorSpan = this.captionStringBuilder;
            int n17 = foregroundColorSpan.length();
            spannableStringBuilder.setSpan((Object)spannableStringBuilder2, n14, n17, n13);
        }
        if (n11 != (n10 = COLOR_SOLID_BLACK)) {
            spannableStringBuilder = this.captionStringBuilder;
            this.backgroundColorStartPosition = n10 = spannableStringBuilder.length();
            this.backgroundColor = n11;
        }
    }

    public void setPenLocation(int n10, int n11) {
        n11 = this.row;
        if (n11 != n10) {
            n11 = 10;
            this.append((char)n11);
        }
        this.row = n10;
    }

    public void setVisibility(boolean bl2) {
        this.visible = bl2;
    }

    public void setWindowAttributes(int n10, int n11, boolean bl2, int n12, int n13, int n14, int n15) {
        this.windowFillColor = n10;
        this.justification = n15;
    }
}

