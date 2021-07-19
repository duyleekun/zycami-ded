/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import com.google.android.exoplayer2.source.dash.DashMediaSource$1;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class DashMediaSource$XsDateTimeParser
implements ParsingLoadable$Parser {
    private DashMediaSource$XsDateTimeParser() {
    }

    public /* synthetic */ DashMediaSource$XsDateTimeParser(DashMediaSource$1 dashMediaSource$1) {
        this();
    }

    public Long parse(Uri object, InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        object = new BufferedReader(inputStreamReader);
        return Util.parseXsDateTime(((BufferedReader)object).readLine());
    }
}

