/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultDataSource
implements DataSource {
    private static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    private static final String SCHEME_ASSET = "asset";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_DATA = "data";
    private static final String SCHEME_RAW = "rawresource";
    private static final String SCHEME_RTMP = "rtmp";
    private static final String SCHEME_UDP = "udp";
    private static final String TAG = "DefaultDataSource";
    private DataSource assetDataSource;
    private final DataSource baseDataSource;
    private DataSource contentDataSource;
    private final Context context;
    private DataSource dataSchemeDataSource;
    private DataSource dataSource;
    private DataSource fileDataSource;
    private DataSource rawResourceDataSource;
    private DataSource rtmpDataSource;
    private final List transferListeners;
    private DataSource udpDataSource;

    public DefaultDataSource(Context object, DataSource dataSource) {
        this.context = object = object.getApplicationContext();
        object = (DataSource)Assertions.checkNotNull(dataSource);
        this.baseDataSource = object;
        this.transferListeners = object;
    }

    public DefaultDataSource(Context context, String object, int n10, int n11, boolean bl2) {
        DefaultHttpDataSource$Factory defaultHttpDataSource$Factory = new DefaultHttpDataSource$Factory();
        object = defaultHttpDataSource$Factory.setUserAgent((String)object).setConnectTimeoutMs(n10).setReadTimeoutMs(n11).setAllowCrossProtocolRedirects(bl2).createDataSource();
        this(context, (DataSource)object);
    }

    public DefaultDataSource(Context context, String string2, boolean bl2) {
        this(context, string2, 8000, 8000, bl2);
    }

    public DefaultDataSource(Context context, boolean bl2) {
        this(context, null, 8000, 8000, bl2);
    }

    private void addListenersToDataSource(DataSource dataSource) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.transferListeners).size()); ++i10) {
            object = (TransferListener)this.transferListeners.get(i10);
            dataSource.addTransferListener((TransferListener)object);
        }
    }

    private DataSource getAssetDataSource() {
        DataSource dataSource = this.assetDataSource;
        if (dataSource == null) {
            Context context = this.context;
            this.assetDataSource = dataSource = new AssetDataSource(context);
            this.addListenersToDataSource(dataSource);
        }
        return this.assetDataSource;
    }

    private DataSource getContentDataSource() {
        DataSource dataSource = this.contentDataSource;
        if (dataSource == null) {
            Context context = this.context;
            this.contentDataSource = dataSource = new ContentDataSource(context);
            this.addListenersToDataSource(dataSource);
        }
        return this.contentDataSource;
    }

    private DataSource getDataSchemeDataSource() {
        DataSource dataSource = this.dataSchemeDataSource;
        if (dataSource == null) {
            this.dataSchemeDataSource = dataSource = new DataSchemeDataSource();
            this.addListenersToDataSource(dataSource);
        }
        return this.dataSchemeDataSource;
    }

    private DataSource getFileDataSource() {
        DataSource dataSource = this.fileDataSource;
        if (dataSource == null) {
            this.fileDataSource = dataSource = new FileDataSource();
            this.addListenersToDataSource(dataSource);
        }
        return this.fileDataSource;
    }

    private DataSource getRawResourceDataSource() {
        DataSource dataSource = this.rawResourceDataSource;
        if (dataSource == null) {
            Context context = this.context;
            this.rawResourceDataSource = dataSource = new RawResourceDataSource(context);
            this.addListenersToDataSource(dataSource);
        }
        return this.rawResourceDataSource;
    }

    private DataSource getRtmpDataSource() {
        Object object = this.rtmpDataSource;
        if (object == null) {
            object = "com.google.android.exoplayer2.ext.rtmp.RtmpDataSource";
            object = Class.forName((String)object);
            Object[] objectArray = null;
            Class[] classArray = new Class[]{};
            object = ((Class)object).getConstructor(classArray);
            objectArray = new Object[]{};
            object = ((Constructor)object).newInstance(objectArray);
            object = (DataSource)object;
            this.rtmpDataSource = object;
            try {
                this.addListenersToDataSource((DataSource)object);
            }
            catch (Exception exception) {
                objectArray = new RuntimeException("Error instantiating RTMP extension", exception);
                throw objectArray;
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = TAG;
                objectArray = "Attempting to play RTMP stream without depending on the RTMP extension";
                Log.w((String)object, (String)objectArray);
            }
            object = this.rtmpDataSource;
            if (object == null) {
                this.rtmpDataSource = object = this.baseDataSource;
            }
        }
        return this.rtmpDataSource;
    }

    private DataSource getUdpDataSource() {
        DataSource dataSource = this.udpDataSource;
        if (dataSource == null) {
            this.udpDataSource = dataSource = new UdpDataSource();
            this.addListenersToDataSource(dataSource);
        }
        return this.udpDataSource;
    }

    private void maybeAddListenerToDataSource(DataSource dataSource, TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.addTransferListener(transferListener);
        }
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.baseDataSource.addTransferListener(transferListener);
        this.transferListeners.add(transferListener);
        DataSource dataSource = this.fileDataSource;
        this.maybeAddListenerToDataSource(dataSource, transferListener);
        dataSource = this.assetDataSource;
        this.maybeAddListenerToDataSource(dataSource, transferListener);
        dataSource = this.contentDataSource;
        this.maybeAddListenerToDataSource(dataSource, transferListener);
        dataSource = this.rtmpDataSource;
        this.maybeAddListenerToDataSource(dataSource, transferListener);
        dataSource = this.udpDataSource;
        this.maybeAddListenerToDataSource(dataSource, transferListener);
        dataSource = this.dataSchemeDataSource;
        this.maybeAddListenerToDataSource(dataSource, transferListener);
        dataSource = this.rawResourceDataSource;
        this.maybeAddListenerToDataSource(dataSource, transferListener);
    }

    public void close() {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            try {
                dataSource.close();
            }
            finally {
                this.dataSource = null;
            }
        }
    }

    public Map getResponseHeaders() {
        Object object = this.dataSource;
        object = object == null ? Collections.emptyMap() : object.getResponseHeaders();
        return object;
    }

    public Uri getUri() {
        DataSource dataSource = this.dataSource;
        dataSource = dataSource == null ? null : dataSource.getUri();
        return dataSource;
    }

    public long open(DataSpec dataSpec) {
        boolean bl2;
        Object object = this.dataSource;
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkState(bl2);
        object = dataSpec.uri.getScheme();
        Object object2 = dataSpec.uri;
        boolean bl3 = Util.isLocalFileUri((Uri)object2);
        this.dataSource = bl3 ? ((object = dataSpec.uri.getPath()) != null && (bl2 = ((String)object).startsWith((String)(object2 = "/android_asset/"))) ? (object = this.getAssetDataSource()) : (object = this.getFileDataSource())) : ((bl3 = ((String)(object2 = SCHEME_ASSET)).equals(object)) ? (object = this.getAssetDataSource()) : ((bl3 = ((String)(object2 = SCHEME_CONTENT)).equals(object)) ? (object = this.getContentDataSource()) : ((bl3 = ((String)(object2 = SCHEME_RTMP)).equals(object)) ? (object = this.getRtmpDataSource()) : ((bl3 = ((String)(object2 = SCHEME_UDP)).equals(object)) ? (object = this.getUdpDataSource()) : ((bl3 = ((String)(object2 = SCHEME_DATA)).equals(object)) ? (object = this.getDataSchemeDataSource()) : (!(bl3 = ((String)(object2 = SCHEME_RAW)).equals(object)) && !(bl2 = ((String)(object2 = SCHEME_ANDROID_RESOURCE)).equals(object)) ? (object = this.baseDataSource) : (object = this.getRawResourceDataSource())))))));
        return this.dataSource.open(dataSpec);
    }

    public int read(byte[] byArray, int n10, int n11) {
        return ((DataSource)Assertions.checkNotNull(this.dataSource)).read(byArray, n10, n11);
    }
}

