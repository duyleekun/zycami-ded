/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.ui.SpannedToHtmlConverter$1;
import java.util.Map;

public class SpannedToHtmlConverter$HtmlAndCss {
    public final Map cssRuleSets;
    public final String html;

    private SpannedToHtmlConverter$HtmlAndCss(String string2, Map map) {
        this.html = string2;
        this.cssRuleSets = map;
    }

    public /* synthetic */ SpannedToHtmlConverter$HtmlAndCss(String string2, Map map, SpannedToHtmlConverter$1 spannedToHtmlConverter$1) {
        this(string2, map);
    }
}

