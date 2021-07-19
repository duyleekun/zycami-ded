/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Map;

public final class ParsingLoadable
implements Loader$Loadable {
    private final StatsDataSource dataSource;
    public final DataSpec dataSpec;
    public final long loadTaskId;
    private final ParsingLoadable$Parser parser;
    private volatile Object result;
    public final int type;

    public ParsingLoadable(DataSource dataSource, Uri object, int n10, ParsingLoadable$Parser parsingLoadable$Parser) {
        DataSpec$Builder dataSpec$Builder = new DataSpec$Builder();
        object = dataSpec$Builder.setUri((Uri)object).setFlags(1).build();
        this(dataSource, (DataSpec)object, n10, parsingLoadable$Parser);
    }

    public ParsingLoadable(DataSource dataSource, DataSpec dataSpec, int n10, ParsingLoadable$Parser parsingLoadable$Parser) {
        long l10;
        StatsDataSource statsDataSource;
        this.dataSource = statsDataSource = new StatsDataSource(dataSource);
        this.dataSpec = dataSpec;
        this.type = n10;
        this.parser = parsingLoadable$Parser;
        this.loadTaskId = l10 = LoadEventInfo.getNewId();
    }

    public static Object load(DataSource dataSource, ParsingLoadable$Parser parsingLoadable$Parser, Uri uri, int n10) {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, uri, n10, parsingLoadable$Parser);
        parsingLoadable.load();
        return Assertions.checkNotNull(parsingLoadable.getResult());
    }

    public static Object load(DataSource dataSource, ParsingLoadable$Parser parsingLoadable$Parser, DataSpec dataSpec, int n10) {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, dataSpec, n10, parsingLoadable$Parser);
        parsingLoadable.load();
        return Assertions.checkNotNull(parsingLoadable.getResult());
    }

    public long bytesLoaded() {
        return this.dataSource.getBytesRead();
    }

    public final void cancelLoad() {
    }

    public Map getResponseHeaders() {
        return this.dataSource.getLastResponseHeaders();
    }

    public final Object getResult() {
        return this.result;
    }

    public Uri getUri() {
        return this.dataSource.getLastOpenedUri();
    }

    public final void load() {
        this.dataSource.resetBytesRead();
        Object object = this.dataSource;
        Object object2 = this.dataSpec;
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream((DataSource)object, (DataSpec)object2);
        try {
            dataSourceInputStream.open();
            object = this.dataSource;
            object = ((StatsDataSource)object).getUri();
            object = Assertions.checkNotNull(object);
            object = (Uri)object;
            object2 = this.parser;
            this.result = object = object2.parse((Uri)object, dataSourceInputStream);
            return;
        }
        finally {
            Util.closeQuietly(dataSourceInputStream);
        }
    }
}

