/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class DefaultDataSourceFactory
implements DataSource$Factory {
    private final DataSource$Factory baseDataSourceFactory;
    private final Context context;
    private final TransferListener listener;

    public DefaultDataSourceFactory(Context context) {
        this(context, (String)null, (TransferListener)null);
    }

    public DefaultDataSourceFactory(Context context, DataSource$Factory dataSource$Factory) {
        this(context, null, dataSource$Factory);
    }

    public DefaultDataSourceFactory(Context context, TransferListener transferListener, DataSource$Factory dataSource$Factory) {
        this.context = context = context.getApplicationContext();
        this.listener = transferListener;
        this.baseDataSourceFactory = dataSource$Factory;
    }

    public DefaultDataSourceFactory(Context context, String string2) {
        this(context, string2, null);
    }

    public DefaultDataSourceFactory(Context context, String object, TransferListener transferListener) {
        DefaultHttpDataSource$Factory defaultHttpDataSource$Factory = new DefaultHttpDataSource$Factory();
        object = defaultHttpDataSource$Factory.setUserAgent((String)object);
        this(context, transferListener, (DataSource$Factory)object);
    }

    public DefaultDataSource createDataSource() {
        Object object = this.context;
        DataSource dataSource = this.baseDataSourceFactory.createDataSource();
        DefaultDataSource defaultDataSource = new DefaultDataSource((Context)object, dataSource);
        object = this.listener;
        if (object != null) {
            defaultDataSource.addTransferListener((TransferListener)object);
        }
        return defaultDataSource;
    }
}

