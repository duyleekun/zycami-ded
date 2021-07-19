/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Layout$Alignment
 */
package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;

public final class TtmlStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    private static final int OFF = 0;
    private static final int ON = 1;
    public static final int RUBY_TYPE_BASE = 2;
    public static final int RUBY_TYPE_CONTAINER = 1;
    public static final int RUBY_TYPE_DELIMITER = 4;
    public static final int RUBY_TYPE_TEXT = 3;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = 255;
    private int backgroundColor;
    private int bold;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private int fontSizeUnit;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private String id;
    private int italic;
    private int linethrough;
    private int rubyPosition;
    private int rubyType;
    private Layout.Alignment textAlign;
    private int textCombine;
    private int underline;

    public TtmlStyle() {
        int n10;
        this.linethrough = n10 = -1;
        this.underline = n10;
        this.bold = n10;
        this.italic = n10;
        this.fontSizeUnit = n10;
        this.rubyType = n10;
        this.rubyPosition = n10;
        this.textCombine = n10;
    }

    private TtmlStyle inherit(TtmlStyle ttmlStyle, boolean n10) {
        if (ttmlStyle != null) {
            int n11;
            String string2;
            int n12;
            int n13 = this.hasFontColor;
            if (n13 == 0 && (n13 = ttmlStyle.hasFontColor) != 0) {
                n13 = ttmlStyle.fontColor;
                this.setFontColor(n13);
            }
            if ((n13 = this.bold) == (n12 = -1)) {
                this.bold = n13 = ttmlStyle.bold;
            }
            if ((n13 = this.italic) == n12) {
                this.italic = n13 = ttmlStyle.italic;
            }
            if ((string2 = this.fontFamily) == null && (string2 = ttmlStyle.fontFamily) != null) {
                this.fontFamily = string2;
            }
            if ((n13 = this.linethrough) == n12) {
                this.linethrough = n13 = ttmlStyle.linethrough;
            }
            if ((n13 = this.underline) == n12) {
                this.underline = n13 = ttmlStyle.underline;
            }
            if ((n13 = this.rubyPosition) == n12) {
                this.rubyPosition = n13 = ttmlStyle.rubyPosition;
            }
            if ((string2 = this.textAlign) == null && (string2 = ttmlStyle.textAlign) != null) {
                this.textAlign = string2;
            }
            if ((n13 = this.textCombine) == n12) {
                this.textCombine = n13 = ttmlStyle.textCombine;
            }
            if ((n13 = this.fontSizeUnit) == n12) {
                float f10;
                this.fontSizeUnit = n13 = ttmlStyle.fontSizeUnit;
                this.fontSize = f10 = ttmlStyle.fontSize;
            }
            if (n10 != 0 && (n13 = (int)(this.hasBackgroundColor ? 1 : 0)) == 0 && (n13 = (int)(ttmlStyle.hasBackgroundColor ? 1 : 0)) != 0) {
                n13 = ttmlStyle.backgroundColor;
                this.setBackgroundColor(n13);
            }
            if (n10 != 0 && (n10 = this.rubyType) == n12 && (n11 = ttmlStyle.rubyType) != n12) {
                this.rubyType = n11;
            }
        }
        return this;
    }

    public TtmlStyle chain(TtmlStyle ttmlStyle) {
        return this.inherit(ttmlStyle, true);
    }

    public int getBackgroundColor() {
        boolean bl2 = this.hasBackgroundColor;
        if (bl2) {
            return this.backgroundColor;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Background color has not been defined.");
        throw illegalStateException;
    }

    public int getFontColor() {
        boolean bl2 = this.hasFontColor;
        if (bl2) {
            return this.fontColor;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Font color has not been defined.");
        throw illegalStateException;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public String getId() {
        return this.id;
    }

    public int getRubyPosition() {
        return this.rubyPosition;
    }

    public int getRubyType() {
        return this.rubyType;
    }

    public int getStyle() {
        int n10;
        int n11 = this.bold;
        int n12 = -1;
        if (n11 == n12 && (n10 = this.italic) == n12) {
            return n12;
        }
        n12 = 0;
        n10 = 1;
        n11 = n11 == n10 ? n10 : 0;
        int n13 = this.italic;
        if (n13 == n10) {
            n12 = 2;
        }
        return n11 | n12;
    }

    public Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public boolean getTextCombine() {
        int n10 = this.textCombine;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public boolean hasFontColor() {
        return this.hasFontColor;
    }

    public TtmlStyle inherit(TtmlStyle ttmlStyle) {
        return this.inherit(ttmlStyle, false);
    }

    public boolean isLinethrough() {
        int n10 = this.linethrough;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isUnderline() {
        int n10 = this.underline;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public TtmlStyle setBackgroundColor(int n10) {
        this.backgroundColor = n10;
        this.hasBackgroundColor = true;
        return this;
    }

    public TtmlStyle setBold(boolean bl2) {
        this.bold = (int)(bl2 ? 1 : 0);
        return this;
    }

    public TtmlStyle setFontColor(int n10) {
        this.fontColor = n10;
        this.hasFontColor = true;
        return this;
    }

    public TtmlStyle setFontFamily(String string2) {
        this.fontFamily = string2;
        return this;
    }

    public TtmlStyle setFontSize(float f10) {
        this.fontSize = f10;
        return this;
    }

    public TtmlStyle setFontSizeUnit(int n10) {
        this.fontSizeUnit = n10;
        return this;
    }

    public TtmlStyle setId(String string2) {
        this.id = string2;
        return this;
    }

    public TtmlStyle setItalic(boolean bl2) {
        this.italic = (int)(bl2 ? 1 : 0);
        return this;
    }

    public TtmlStyle setLinethrough(boolean bl2) {
        this.linethrough = (int)(bl2 ? 1 : 0);
        return this;
    }

    public TtmlStyle setRubyPosition(int n10) {
        this.rubyPosition = n10;
        return this;
    }

    public TtmlStyle setRubyType(int n10) {
        this.rubyType = n10;
        return this;
    }

    public TtmlStyle setTextAlign(Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    public TtmlStyle setTextCombine(boolean bl2) {
        this.textCombine = (int)(bl2 ? 1 : 0);
        return this;
    }

    public TtmlStyle setUnderline(boolean bl2) {
        this.underline = (int)(bl2 ? 1 : 0);
        return this;
    }
}

