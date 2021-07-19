/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import java.io.InputStream;
import java.util.List;

public final class FilteringManifestParser
implements ParsingLoadable$Parser {
    private final ParsingLoadable$Parser parser;
    private final List streamKeys;

    public FilteringManifestParser(ParsingLoadable$Parser parsingLoadable$Parser, List list) {
        this.parser = parsingLoadable$Parser;
        this.streamKeys = list;
    }

    public FilterableManifest parse(Uri object, InputStream object2) {
        boolean bl2;
        ParsingLoadable$Parser parsingLoadable$Parser = this.parser;
        object = (FilterableManifest)parsingLoadable$Parser.parse((Uri)object, (InputStream)object2);
        object2 = this.streamKeys;
        if (object2 != null && !(bl2 = object2.isEmpty())) {
            object2 = this.streamKeys;
            object = (FilterableManifest)object.copy((List)object2);
        }
        return object;
    }
}

