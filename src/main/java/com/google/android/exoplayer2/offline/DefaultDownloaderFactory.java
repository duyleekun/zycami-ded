/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.util.SparseArray;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.DownloaderFactory;
import com.google.android.exoplayer2.offline.ProgressiveDownloader;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.k0.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.util.List;
import java.util.concurrent.Executor;

public class DefaultDownloaderFactory
implements DownloaderFactory {
    private static final SparseArray CONSTRUCTORS = DefaultDownloaderFactory.createDownloaderConstructors();
    private final CacheDataSource$Factory cacheDataSourceFactory;
    private final Executor executor;

    public DefaultDownloaderFactory(CacheDataSource$Factory cacheDataSource$Factory) {
        m m10 = m.a;
        this(cacheDataSource$Factory, m10);
    }

    public DefaultDownloaderFactory(CacheDataSource$Factory object, Executor executor) {
        object = (CacheDataSource$Factory)Assertions.checkNotNull(object);
        this.cacheDataSourceFactory = object;
        this.executor = object = (Executor)Assertions.checkNotNull(executor);
    }

    private Downloader createDownloader(DownloadRequest object, int n10) {
        Constructor constructor = (Constructor)CONSTRUCTORS.get(n10);
        if (constructor != null) {
            Object object2 = new MediaItem$Builder();
            Object object3 = ((DownloadRequest)object).uri;
            object2 = ((MediaItem$Builder)object2).setUri((Uri)object3);
            object3 = ((DownloadRequest)object).streamKeys;
            object2 = ((MediaItem$Builder)object2).setStreamKeys((List)object3);
            object3 = ((DownloadRequest)object).customCacheKey;
            object2 = ((MediaItem$Builder)object2).setCustomCacheKey((String)object3);
            object = ((DownloadRequest)object).keySetId;
            object = ((MediaItem$Builder)object2).setDrmKeySetId((byte[])object).build();
            int n11 = 3;
            try {
                object2 = new Object[n11];
                object3 = null;
            }
            catch (Exception exception) {
                object2 = new StringBuilder(61);
                ((StringBuilder)object2).append("Failed to instantiate downloader for content type ");
                ((StringBuilder)object2).append(n10);
                String string2 = ((StringBuilder)object2).toString();
                object = new IllegalStateException(string2);
                throw object;
            }
            object2[0] = object;
            int n12 = 1;
            object3 = this.cacheDataSourceFactory;
            object2[n12] = object3;
            n12 = 2;
            object3 = this.executor;
            object2[n12] = object3;
            object = constructor.newInstance((Object[])object2);
            return (Downloader)object;
        }
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("Module missing for content type ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static SparseArray createDownloaderConstructors() {
        SparseArray sparseArray = new SparseArray();
        int n10 = 0;
        GenericDeclaration genericDeclaration = "com.google.android.exoplayer2.source.dash.offline.DashDownloader";
        try {
            genericDeclaration = Class.forName((String)((Object)genericDeclaration));
            genericDeclaration = DefaultDownloaderFactory.getDownloaderConstructor(genericDeclaration);
            sparseArray.put(0, (Object)genericDeclaration);
        }
        catch (ClassNotFoundException classNotFoundException) {}
        n10 = 2;
        genericDeclaration = "com.google.android.exoplayer2.source.hls.offline.HlsDownloader";
        try {
            genericDeclaration = Class.forName((String)((Object)genericDeclaration));
            genericDeclaration = DefaultDownloaderFactory.getDownloaderConstructor(genericDeclaration);
            sparseArray.put(n10, (Object)genericDeclaration);
        }
        catch (ClassNotFoundException classNotFoundException) {}
        n10 = 1;
        genericDeclaration = "com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader";
        try {
            genericDeclaration = Class.forName((String)((Object)genericDeclaration));
            genericDeclaration = DefaultDownloaderFactory.getDownloaderConstructor(genericDeclaration);
            sparseArray.put(n10, genericDeclaration);
            return sparseArray;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return sparseArray;
        }
    }

    private static Constructor getDownloaderConstructor(Class clazz) {
        int n10;
        Class[] classArray = Downloader.class;
        try {
            clazz = clazz.asSubclass(classArray);
            n10 = 3;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            classArray = new IllegalStateException("Downloader constructor missing", noSuchMethodException);
            throw classArray;
        }
        classArray = new Class[n10];
        int n11 = 0;
        Class clazz2 = MediaItem.class;
        classArray[0] = clazz2;
        n11 = 1;
        clazz2 = CacheDataSource$Factory.class;
        classArray[n11] = clazz2;
        n11 = 2;
        clazz2 = Executor.class;
        classArray[n11] = clazz2;
        return clazz.getConstructor(classArray);
    }

    public Downloader createDownloader(DownloadRequest object) {
        int n10;
        Object object2 = ((DownloadRequest)object).uri;
        Object object3 = ((DownloadRequest)object).mimeType;
        int n11 = Util.inferContentTypeForUriAndMimeType(object2, (String)object3);
        if (n11 != 0 && n11 != (n10 = 1) && n11 != (n10 = 2)) {
            n10 = 3;
            if (n11 == n10) {
                object3 = new MediaItem$Builder();
                Object object4 = ((DownloadRequest)object).uri;
                object3 = ((MediaItem$Builder)object3).setUri((Uri)object4);
                object = ((DownloadRequest)object).customCacheKey;
                object = ((MediaItem$Builder)object3).setCustomCacheKey((String)object).build();
                object3 = this.cacheDataSourceFactory;
                object4 = this.executor;
                object2 = new ProgressiveDownloader((MediaItem)object, (CacheDataSource$Factory)object3, (Executor)object4);
                return object2;
            }
            StringBuilder stringBuilder = new StringBuilder(29);
            stringBuilder.append("Unsupported type: ");
            stringBuilder.append(n11);
            object2 = stringBuilder.toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        return this.createDownloader((DownloadRequest)object, n11);
    }
}

