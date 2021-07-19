/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$DrmConfiguration;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$Builder;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.ExoMediaDrm$Provider;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.HttpMediaDrmCallback;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.util.Map;
import java.util.UUID;

public final class DefaultDrmSessionManagerProvider
implements DrmSessionManagerProvider {
    private MediaItem$DrmConfiguration drmConfiguration;
    private HttpDataSource$Factory drmHttpDataSourceFactory;
    private final Object lock;
    private DrmSessionManager manager;
    private String userAgent;

    public DefaultDrmSessionManagerProvider() {
        Object object;
        this.lock = object = new Object();
    }

    private DrmSessionManager createManager(MediaItem$DrmConfiguration object) {
        Object object2;
        boolean bl2;
        Object object3;
        Object object4 = this.drmHttpDataSourceFactory;
        if (object4 == null) {
            object4 = new DefaultHttpDataSource$Factory();
            object3 = this.userAgent;
            object4 = ((DefaultHttpDataSource$Factory)object4).setUserAgent((String)object3);
        }
        Object object5 = ((MediaItem$DrmConfiguration)object).licenseUri;
        if (object5 == null) {
            bl2 = false;
            object5 = null;
        } else {
            object5 = object5.toString();
        }
        boolean bl3 = ((MediaItem$DrmConfiguration)object).forceDefaultLicenseUri;
        object3 = new HttpMediaDrmCallback((String)object5, bl3, (HttpDataSource$Factory)object4);
        object4 = ((MediaItem$DrmConfiguration)object).requestHeaders.entrySet().iterator();
        while (bl2 = object4.hasNext()) {
            object5 = (Map.Entry)object4.next();
            object2 = (String)object5.getKey();
            object5 = (String)object5.getValue();
            ((HttpMediaDrmCallback)object3).setKeyRequestProperty((String)object2, (String)object5);
        }
        object4 = new DefaultDrmSessionManager$Builder();
        object5 = ((MediaItem$DrmConfiguration)object).uuid;
        object2 = FrameworkMediaDrm.DEFAULT_PROVIDER;
        object4 = ((DefaultDrmSessionManager$Builder)object4).setUuidAndExoMediaDrmProvider((UUID)object5, (ExoMediaDrm$Provider)object2);
        bl2 = ((MediaItem$DrmConfiguration)object).multiSession;
        object4 = ((DefaultDrmSessionManager$Builder)object4).setMultiSession(bl2);
        bl2 = ((MediaItem$DrmConfiguration)object).playClearContentWithoutKey;
        object4 = ((DefaultDrmSessionManager$Builder)object4).setPlayClearSamplesWithoutKeys(bl2);
        object5 = Ints.toArray(((MediaItem$DrmConfiguration)object).sessionForClearTypes);
        object4 = ((DefaultDrmSessionManager$Builder)object4).setUseDrmSessionsForClearContent((int[])object5).build((MediaDrmCallback)object3);
        object = ((MediaItem$DrmConfiguration)object).getKeySetId();
        ((DefaultDrmSessionManager)object4).setMode(0, (byte[])object);
        return object4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DrmSessionManager get(MediaItem object) {
        Object object2 = ((MediaItem)object).playbackProperties;
        Assertions.checkNotNull(object2);
        object = object.playbackProperties.drmConfiguration;
        if (object == null) return DrmSessionManager.DRM_UNSUPPORTED;
        int n10 = Util.SDK_INT;
        int n11 = 18;
        if (n10 < n11) {
            return DrmSessionManager.DRM_UNSUPPORTED;
        }
        object2 = this.lock;
        synchronized (object2) {
            MediaItem$DrmConfiguration mediaItem$DrmConfiguration = this.drmConfiguration;
            n11 = (int)(Util.areEqual(object, mediaItem$DrmConfiguration) ? 1 : 0);
            if (n11 == 0) {
                this.drmConfiguration = object;
                this.manager = object = this.createManager((MediaItem$DrmConfiguration)object);
            }
            object = this.manager;
            object = Assertions.checkNotNull(object);
            return (DrmSessionManager)object;
        }
    }

    public void setDrmHttpDataSourceFactory(HttpDataSource$Factory httpDataSource$Factory) {
        this.drmHttpDataSourceFactory = httpDataSource$Factory;
    }

    public void setDrmUserAgent(String string2) {
        this.userAgent = string2;
    }
}

