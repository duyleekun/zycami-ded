/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.escape.Escaper;
import com.google.common.net.PercentEscaper;

public final class UrlEscapers {
    private static final Escaper URL_FORM_PARAMETER_ESCAPER;
    public static final String URL_FORM_PARAMETER_OTHER_SAFE_CHARS = "-_.*";
    private static final Escaper URL_FRAGMENT_ESCAPER;
    public static final String URL_PATH_OTHER_SAFE_CHARS_LACKING_PLUS = "-._~!$'()*,;&=@:";
    private static final Escaper URL_PATH_SEGMENT_ESCAPER;

    static {
        PercentEscaper percentEscaper = new PercentEscaper(URL_FORM_PARAMETER_OTHER_SAFE_CHARS, true);
        URL_FORM_PARAMETER_ESCAPER = percentEscaper;
        percentEscaper = new PercentEscaper("-._~!$'()*,;&=@:+", false);
        URL_PATH_SEGMENT_ESCAPER = percentEscaper;
        percentEscaper = new PercentEscaper("-._~!$'()*,;&=@:+/?", false);
        URL_FRAGMENT_ESCAPER = percentEscaper;
    }

    private UrlEscapers() {
    }

    public static Escaper urlFormParameterEscaper() {
        return URL_FORM_PARAMETER_ESCAPER;
    }

    public static Escaper urlFragmentEscaper() {
        return URL_FRAGMENT_ESCAPER;
    }

    public static Escaper urlPathSegmentEscaper() {
        return URL_PATH_SEGMENT_ESCAPER;
    }
}

