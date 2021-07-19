/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.common.base.Charsets;
import j$.util.DesugarTimeZone;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DashMediaSource$Iso8601Parser
implements ParsingLoadable$Parser {
    private static final Pattern TIMESTAMP_WITH_TIMEZONE_PATTERN = Pattern.compile("(.+?)(Z|((\\+|-|\u2212)(\\d\\d)(:?(\\d\\d))?))");

    public Long parse(Uri object, InputStream object2) {
        long l10;
        block32: {
            long l11;
            long l12;
            block34: {
                block33: {
                    Object object3;
                    Object object4;
                    block29: {
                        block31: {
                            block30: {
                                object4 = Charsets.UTF_8;
                                object3 = new InputStreamReader((InputStream)object2, (Charset)object4);
                                object = new BufferedReader((Reader)object3);
                                object = ((BufferedReader)object).readLine();
                                try {
                                    object2 = TIMESTAMP_WITH_TIMEZONE_PATTERN;
                                }
                                catch (ParseException parseException) {
                                    object2 = new ParserException(parseException);
                                    throw object2;
                                }
                                object2 = ((Pattern)object2).matcher((CharSequence)object);
                                boolean bl2 = ((Matcher)object2).matches();
                                if (bl2) break block29;
                                object3 = "Couldn't parse timestamp: ";
                                object = String.valueOf(object);
                                int n10 = ((String)object).length();
                                if (n10 == 0) break block30;
                                object = ((String)object3).concat((String)object);
                                break block31;
                            }
                            object = new String((String)object3);
                        }
                        object2 = new ParserException((String)object);
                        throw object2;
                    }
                    int n11 = 1;
                    object = ((Matcher)object2).group(n11);
                    object4 = "yyyy-MM-dd'T'HH:mm:ss";
                    Object object5 = Locale.US;
                    object3 = new SimpleDateFormat((String)object4, (Locale)object5);
                    object4 = "UTC";
                    object4 = DesugarTimeZone.getTimeZone((String)object4);
                    ((DateFormat)object3).setTimeZone((TimeZone)object4);
                    object = ((DateFormat)object3).parse((String)object);
                    l10 = ((Date)object).getTime();
                    n11 = 2;
                    object = ((Matcher)object2).group(n11);
                    object5 = "Z";
                    n11 = (int)(((String)object5).equals(object) ? 1 : 0);
                    if (n11 != 0) break block32;
                    object = "+";
                    int n12 = 4;
                    object5 = ((Matcher)object2).group(n12);
                    n11 = (int)(((String)object).equals(object5) ? 1 : 0);
                    long l13 = n11 != 0 ? 1L : (long)-1;
                    n11 = 5;
                    object = ((Matcher)object2).group(n11);
                    l12 = Long.parseLong((String)object);
                    n11 = 7;
                    object = ((Matcher)object2).group(n11);
                    boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                    if (!bl3) break block33;
                    l11 = 0L;
                    break block34;
                }
                l11 = Long.parseLong((String)object);
            }
            long l14 = 60;
            l12 = (l12 * l14 + l11) * l14;
            l11 = 1000L;
            l10 -= (l13 *= (l12 *= l11));
        }
        return l10;
    }
}

