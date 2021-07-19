/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class WebvttCssStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    private static final int OFF = 0;
    private static final int ON = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = 255;
    private int backgroundColor;
    private int bold;
    private boolean combineUpright;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private int fontSizeUnit;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private int italic;
    private int linethrough;
    private int rubyPosition;
    private Set targetClasses;
    private String targetId;
    private String targetTag;
    private String targetVoice;
    private int underline;

    public WebvttCssStyle() {
        int n10;
        Set set;
        String string2;
        this.targetId = string2 = "";
        this.targetTag = string2;
        this.targetClasses = set = Collections.emptySet();
        this.targetVoice = string2;
        this.fontFamily = null;
        this.hasFontColor = false;
        this.hasBackgroundColor = false;
        this.linethrough = n10 = -1;
        this.underline = n10;
        this.bold = n10;
        this.italic = n10;
        this.fontSizeUnit = n10;
        this.rubyPosition = n10;
        this.combineUpright = false;
    }

    private static int updateScoreForMatch(int n10, String string2, String string3, int n11) {
        int n12 = string2.isEmpty();
        if (n12 == 0 && n10 != (n12 = -1)) {
            boolean bl2 = string2.equals(string3);
            if (bl2) {
                n12 = n10 + n11;
            }
            return n12;
        }
        return n10;
    }

    public int getBackgroundColor() {
        boolean bl2 = this.hasBackgroundColor;
        if (bl2) {
            return this.backgroundColor;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Background color not defined.");
        throw illegalStateException;
    }

    public boolean getCombineUpright() {
        return this.combineUpright;
    }

    public int getFontColor() {
        boolean bl2 = this.hasFontColor;
        if (bl2) {
            return this.fontColor;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Font color not defined");
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

    public int getRubyPosition() {
        return this.rubyPosition;
    }

    public int getSpecificityScore(String string2, String object, Set set, String string3) {
        int n10;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        Object object2 = this.targetId;
        boolean n11 = ((String)object2).isEmpty();
        if (n11 && (bl4 = ((String)(object2 = this.targetTag)).isEmpty()) && (bl3 = (object2 = this.targetClasses).isEmpty()) && (bl2 = ((String)(object2 = this.targetVoice)).isEmpty())) {
            return (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        }
        object2 = this.targetId;
        int n12 = WebvttCssStyle.updateScoreForMatch(0, (String)object2, string2, 0x40000000);
        object2 = this.targetTag;
        int n13 = 2;
        n12 = WebvttCssStyle.updateScoreForMatch(n12, (String)object2, (String)object, n13);
        object = this.targetVoice;
        int n14 = 4;
        if ((n12 = WebvttCssStyle.updateScoreForMatch(n12, (String)object, string3, n14)) != (n10 = -1) && (n10 = (int)(set.containsAll((Collection<?>)(object = this.targetClasses)) ? 1 : 0)) != 0) {
            n10 = this.targetClasses.size() * n14;
            return n12 + n10;
        }
        return 0;
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

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public boolean hasFontColor() {
        return this.hasFontColor;
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

    public WebvttCssStyle setBackgroundColor(int n10) {
        this.backgroundColor = n10;
        this.hasBackgroundColor = true;
        return this;
    }

    public WebvttCssStyle setBold(boolean bl2) {
        this.bold = (int)(bl2 ? 1 : 0);
        return this;
    }

    public WebvttCssStyle setCombineUpright(boolean bl2) {
        this.combineUpright = bl2;
        return this;
    }

    public WebvttCssStyle setFontColor(int n10) {
        this.fontColor = n10;
        this.hasFontColor = true;
        return this;
    }

    public WebvttCssStyle setFontFamily(String string2) {
        this.fontFamily = string2 = Util.toLowerInvariant(string2);
        return this;
    }

    public WebvttCssStyle setFontSize(float f10) {
        this.fontSize = f10;
        return this;
    }

    public WebvttCssStyle setFontSizeUnit(short s10) {
        this.fontSizeUnit = s10;
        return this;
    }

    public WebvttCssStyle setItalic(boolean bl2) {
        this.italic = (int)(bl2 ? 1 : 0);
        return this;
    }

    public WebvttCssStyle setLinethrough(boolean bl2) {
        this.linethrough = (int)(bl2 ? 1 : 0);
        return this;
    }

    public WebvttCssStyle setRubyPosition(int n10) {
        this.rubyPosition = n10;
        return this;
    }

    public void setTargetClasses(String[] object) {
        HashSet hashSet;
        object = Arrays.asList(object);
        this.targetClasses = hashSet = new HashSet(object);
    }

    public void setTargetId(String string2) {
        this.targetId = string2;
    }

    public void setTargetTagName(String string2) {
        this.targetTag = string2;
    }

    public void setTargetVoice(String string2) {
        this.targetVoice = string2;
    }

    public WebvttCssStyle setUnderline(boolean bl2) {
        this.underline = (int)(bl2 ? 1 : 0);
        return this;
    }
}

