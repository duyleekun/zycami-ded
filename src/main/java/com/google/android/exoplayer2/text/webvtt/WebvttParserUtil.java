/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttParserUtil {
    private static final Pattern COMMENT = Pattern.compile("^NOTE([ \t].*)?$");
    private static final String WEBVTT_HEADER = "WEBVTT";

    private WebvttParserUtil() {
    }

    public static Matcher findNextCueHeader(ParsableByteArray parsableByteArray) {
        Object object;
        while ((object = parsableByteArray.readLine()) != null) {
            Object object2 = COMMENT.matcher((CharSequence)object);
            boolean bl2 = ((Matcher)object2).matches();
            if (bl2) {
                boolean bl3;
                while ((object = parsableByteArray.readLine()) != null && !(bl3 = ((String)object).isEmpty())) {
                }
                continue;
            }
            object2 = WebvttCueParser.CUE_HEADER_PATTERN;
            bl2 = ((Matcher)(object = ((Pattern)object2).matcher((CharSequence)object))).matches();
            if (!bl2) continue;
            return object;
        }
        return null;
    }

    public static boolean isWebvttHeaderLine(ParsableByteArray object) {
        String string2;
        boolean bl2;
        if ((object = ((ParsableByteArray)object).readLine()) != null && (bl2 = ((String)object).startsWith(string2 = WEBVTT_HEADER))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static float parsePercentage(String object) {
        String string2 = "%";
        boolean bl2 = ((String)object).endsWith(string2);
        if (bl2) {
            int n10 = ((String)object).length() + -1;
            return Float.parseFloat(((String)object).substring(0, n10)) / 100.0f;
        }
        object = new NumberFormatException("Percentages must end with %");
        throw object;
    }

    public static long parseTimestampUs(String object) {
        long l10;
        object = Util.splitAtFirst((String)object, "\\.");
        String[] stringArray = object[0];
        String string2 = ":";
        stringArray = Util.split((String)stringArray, string2);
        int n10 = stringArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = stringArray[i10];
            long l12 = 60;
            l11 *= l12;
            l10 = Long.parseLong(string3);
            l11 += l10;
        }
        long l13 = 1000L;
        l11 *= l13;
        n10 = ((String[])object).length;
        int n11 = 2;
        if (n10 == n11) {
            n10 = 1;
            object = object[n10];
            l10 = Long.parseLong((String)object);
            l11 += l10;
        }
        return l11 * l13;
    }

    public static void validateWebvttHeaderLine(ParsableByteArray object) {
        int n10 = ((ParsableByteArray)object).getPosition();
        boolean bl2 = WebvttParserUtil.isWebvttHeaderLine((ParsableByteArray)object);
        if (!bl2) {
            ((ParsableByteArray)object).setPosition(n10);
            String string2 = "Expected WEBVTT. Got ";
            object = String.valueOf(((ParsableByteArray)object).readLine());
            int n11 = ((String)object).length();
            object = n11 != 0 ? string2.concat((String)object) : new String(string2);
            ParserException parserException = new ParserException((String)object);
            throw parserException;
        }
    }
}

