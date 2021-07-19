/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.AssetDataSource$AssetDataSourceException;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource
extends BaseDataSource {
    private final AssetManager assetManager;
    private long bytesRemaining;
    private InputStream inputStream;
    private boolean opened;
    private Uri uri;

    public AssetDataSource(Context context) {
        super(false);
        context = context.getAssets();
        this.assetManager = context;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Throwable throwable2222222;
        boolean bl2 = false;
        this.uri = null;
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            inputStream.close();
        }
        this.inputStream = null;
        bl2 = this.opened;
        if (bl2) {
            this.opened = false;
            this.transferEnded();
        }
        return;
        {
            catch (Throwable throwable2222222) {
            }
            catch (IOException iOException) {}
            {
                AssetDataSource$AssetDataSourceException assetDataSource$AssetDataSourceException = new AssetDataSource$AssetDataSourceException(iOException);
                throw assetDataSource$AssetDataSourceException;
            }
        }
        this.inputStream = null;
        bl2 = this.opened;
        if (bl2) {
            this.opened = false;
            this.transferEnded();
        }
        throw throwable2222222;
    }

    public Uri getUri() {
        return this.uri;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long open(DataSpec object) {
        Object object2;
        try {
            object2 = ((DataSpec)object).uri;
            this.uri = object2;
            object2 = object2.getPath();
            object2 = Assertions.checkNotNull(object2);
            object2 = (String)object2;
            String string2 = "/android_asset/";
            int n10 = ((String)object2).startsWith(string2);
            int n11 = 1;
            if (n10 != 0) {
                n10 = 15;
                object2 = ((String)object2).substring(n10);
            } else {
                string2 = "/";
                n10 = (int)(((String)object2).startsWith(string2) ? 1 : 0);
                if (n10 != 0) {
                    object2 = ((String)object2).substring(n11);
                }
            }
            this.transferInitializing((DataSpec)object);
            string2 = this.assetManager;
            this.inputStream = object2 = string2.open((String)object2, n11);
            long l10 = ((DataSpec)object).position;
            long l11 = ((InputStream)object2).skip(l10);
            l10 = ((DataSpec)object).position;
            Object object3 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object3 >= 0) {
                l11 = ((DataSpec)object).length;
                l10 = -1;
                long l12 = l11 - l10;
                Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object4 != false) {
                    this.bytesRemaining = l11;
                } else {
                    object2 = this.inputStream;
                    object3 = ((InputStream)object2).available();
                    this.bytesRemaining = l11 = (long)object3;
                    long l13 = Integer.MAX_VALUE;
                    long l14 = l11 - l13;
                    object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object3 == false) {
                        this.bytesRemaining = l10;
                    }
                }
                this.opened = n11;
                this.transferStarted((DataSpec)object);
                return this.bytesRemaining;
            }
        }
        catch (IOException iOException) {
            object2 = new AssetDataSource$AssetDataSourceException(iOException);
            throw object2;
        }
        {
            object = new EOFException();
            throw object;
        }
    }

    public int read(byte[] object, int n10, int n11) {
        int n12;
        long l10;
        long l11;
        block11: {
            Object object2;
            if (n11 == 0) {
                return 0;
            }
            l11 = this.bytesRemaining;
            long l12 = 0L;
            Object object3 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            int n13 = -1;
            if (object3 == false) {
                return n13;
            }
            l10 = -1;
            long l13 = l11 - l10;
            object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 != false) {
                long l14 = n11;
                l11 = Math.min(l11, l14);
                n11 = (int)l11;
            }
            try {
                object2 = this.inputStream;
            }
            catch (IOException iOException) {
                AssetDataSource$AssetDataSourceException assetDataSource$AssetDataSourceException = new AssetDataSource$AssetDataSourceException(iOException);
                throw assetDataSource$AssetDataSourceException;
            }
            object2 = Util.castNonNull(object2);
            object2 = (InputStream)object2;
            n12 = ((InputStream)object2).read((byte[])object, n10, n11);
            if (n12 != n13) break block11;
            long l15 = this.bytesRemaining;
            long l16 = l15 - l10;
            n12 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
            if (n12 == 0) {
                return n13;
            }
            object = new AssetDataSource$AssetDataSourceException;
            EOFException eOFException = new EOFException();
            object(eOFException);
            throw object;
        }
        long l17 = this.bytesRemaining;
        long l18 = l17 - l10;
        Object object4 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object4 != false) {
            l11 = n12;
            this.bytesRemaining = l17 -= l11;
        }
        this.bytesTransferred(n12);
        return n12;
    }
}

