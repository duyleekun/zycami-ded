/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$1;
import com.google.android.exoplayer2.MediaItem$AdsConfiguration;
import com.google.android.exoplayer2.MediaItem$ClippingProperties;
import com.google.android.exoplayer2.MediaItem$DrmConfiguration;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.MediaMetadata$Builder;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class MediaItem$Builder {
    private Uri adTagUri;
    private Object adsId;
    private long clipEndPositionMs = Long.MIN_VALUE;
    private boolean clipRelativeToDefaultPosition;
    private boolean clipRelativeToLiveWindow;
    private long clipStartPositionMs;
    private boolean clipStartsAtKeyFrame;
    private String customCacheKey;
    private boolean drmForceDefaultLicenseUri;
    private byte[] drmKeySetId;
    private Map drmLicenseRequestHeaders;
    private Uri drmLicenseUri;
    private boolean drmMultiSession;
    private boolean drmPlayClearContentWithoutKey;
    private List drmSessionForClearTypes;
    private UUID drmUuid;
    private long liveMaxOffsetMs;
    private float liveMaxPlaybackSpeed;
    private long liveMinOffsetMs;
    private float liveMinPlaybackSpeed;
    private long liveTargetOffsetMs;
    private String mediaId;
    private MediaMetadata mediaMetadata;
    private String mimeType;
    private List streamKeys;
    private List subtitles;
    private Object tag;
    private Uri uri;

    public MediaItem$Builder() {
        float f10;
        long l10;
        List list = Collections.emptyList();
        this.drmSessionForClearTypes = list;
        list = Collections.emptyMap();
        this.drmLicenseRequestHeaders = list;
        this.streamKeys = list = Collections.emptyList();
        this.subtitles = list = Collections.emptyList();
        this.liveTargetOffsetMs = l10 = -9223372036854775807L;
        this.liveMinOffsetMs = l10;
        this.liveMaxOffsetMs = l10;
        this.liveMinPlaybackSpeed = f10 = -3.4028235E38f;
        this.liveMaxPlaybackSpeed = f10;
    }

    private MediaItem$Builder(MediaItem object) {
        this();
        float f10;
        float f11;
        boolean bl2;
        boolean bl3;
        long l10;
        Object object2 = ((MediaItem)object).clippingProperties;
        this.clipEndPositionMs = l10 = ((MediaItem$ClippingProperties)object2).endPositionMs;
        this.clipRelativeToLiveWindow = bl3 = ((MediaItem$ClippingProperties)object2).relativeToLiveWindow;
        this.clipRelativeToDefaultPosition = bl3 = ((MediaItem$ClippingProperties)object2).relativeToDefaultPosition;
        this.clipStartPositionMs = l10 = ((MediaItem$ClippingProperties)object2).startPositionMs;
        this.clipStartsAtKeyFrame = bl2 = ((MediaItem$ClippingProperties)object2).startsAtKeyFrame;
        this.mediaId = object2 = ((MediaItem)object).mediaId;
        this.mediaMetadata = object2 = ((MediaItem)object).mediaMetadata;
        object2 = ((MediaItem)object).liveConfiguration;
        this.liveTargetOffsetMs = l10 = ((MediaItem$LiveConfiguration)object2).targetOffsetMs;
        this.liveMinOffsetMs = l10 = ((MediaItem$LiveConfiguration)object2).minOffsetMs;
        this.liveMaxOffsetMs = l10 = ((MediaItem$LiveConfiguration)object2).maxOffsetMs;
        this.liveMinPlaybackSpeed = f11 = ((MediaItem$LiveConfiguration)object2).minPlaybackSpeed;
        this.liveMaxPlaybackSpeed = f10 = ((MediaItem$LiveConfiguration)object2).maxPlaybackSpeed;
        object = ((MediaItem)object).playbackProperties;
        if (object != null) {
            this.customCacheKey = object2 = ((MediaItem$PlaybackProperties)object).customCacheKey;
            this.mimeType = object2 = ((MediaItem$PlaybackProperties)object).mimeType;
            object2 = ((MediaItem$PlaybackProperties)object).uri;
            this.uri = object2;
            this.streamKeys = object2 = ((MediaItem$PlaybackProperties)object).streamKeys;
            this.subtitles = object2 = ((MediaItem$PlaybackProperties)object).subtitles;
            this.tag = object2 = ((MediaItem$PlaybackProperties)object).tag;
            object2 = ((MediaItem$PlaybackProperties)object).drmConfiguration;
            if (object2 != null) {
                Object object3;
                this.drmLicenseUri = object3 = ((MediaItem$DrmConfiguration)object2).licenseUri;
                object3 = ((MediaItem$DrmConfiguration)object2).requestHeaders;
                this.drmLicenseRequestHeaders = object3;
                this.drmMultiSession = bl3 = ((MediaItem$DrmConfiguration)object2).multiSession;
                this.drmForceDefaultLicenseUri = bl3 = ((MediaItem$DrmConfiguration)object2).forceDefaultLicenseUri;
                this.drmPlayClearContentWithoutKey = bl3 = ((MediaItem$DrmConfiguration)object2).playClearContentWithoutKey;
                object3 = ((MediaItem$DrmConfiguration)object2).sessionForClearTypes;
                this.drmSessionForClearTypes = object3;
                object3 = ((MediaItem$DrmConfiguration)object2).uuid;
                this.drmUuid = object3;
                object2 = ((MediaItem$DrmConfiguration)object2).getKeySetId();
                this.drmKeySetId = (byte[])object2;
            }
            if ((object = ((MediaItem$PlaybackProperties)object).adsConfiguration) != null) {
                object2 = ((MediaItem$AdsConfiguration)object).adTagUri;
                this.adTagUri = object2;
                this.adsId = object = ((MediaItem$AdsConfiguration)object).adsId;
            }
        }
    }

    public /* synthetic */ MediaItem$Builder(MediaItem mediaItem, MediaItem$1 mediaItem$1) {
        this(mediaItem);
    }

    public MediaItem build() {
        Object object;
        Object object2;
        Object object3;
        MediaItem$DrmConfiguration mediaItem$DrmConfiguration;
        Object object4;
        Uri uri;
        Object object5;
        boolean bl2;
        MediaItem$Builder mediaItem$Builder = this;
        Object object6 = this.drmLicenseUri;
        if (object6 != null && (object6 = this.drmUuid) == null) {
            bl2 = false;
            object6 = null;
        } else {
            bl2 = true;
        }
        Assertions.checkState(bl2);
        object6 = mediaItem$Builder.uri;
        Object object7 = null;
        if (object6 != null) {
            MediaItem$PlaybackProperties mediaItem$PlaybackProperties;
            Object object8;
            List list;
            boolean bl3;
            object5 = mediaItem$Builder.mimeType;
            UUID uUID = mediaItem$Builder.drmUuid;
            if (uUID != null) {
                uri = mediaItem$Builder.drmLicenseUri;
                object4 = mediaItem$Builder.drmLicenseRequestHeaders;
                bl3 = mediaItem$Builder.drmMultiSession;
                boolean bl4 = mediaItem$Builder.drmForceDefaultLicenseUri;
                boolean bl5 = mediaItem$Builder.drmPlayClearContentWithoutKey;
                list = mediaItem$Builder.drmSessionForClearTypes;
                object8 = mediaItem$Builder.drmKeySetId;
                mediaItem$DrmConfiguration = new MediaItem$DrmConfiguration(uUID, uri, (Map)object4, bl3, bl4, bl5, list, (byte[])object8, null);
                object4 = mediaItem$DrmConfiguration;
            } else {
                object4 = null;
            }
            mediaItem$DrmConfiguration = mediaItem$Builder.adTagUri;
            if (mediaItem$DrmConfiguration != null) {
                object3 = mediaItem$Builder.adsId;
                object2 = new MediaItem$AdsConfiguration((Uri)mediaItem$DrmConfiguration, object3, null);
            } else {
                bl3 = false;
                object2 = null;
            }
            object3 = mediaItem$Builder.streamKeys;
            object = mediaItem$Builder.customCacheKey;
            list = mediaItem$Builder.subtitles;
            object8 = mediaItem$Builder.tag;
            object7 = mediaItem$PlaybackProperties;
            mediaItem$DrmConfiguration = object6;
            mediaItem$PlaybackProperties = new MediaItem$PlaybackProperties((Uri)object6, (String)object5, (MediaItem$DrmConfiguration)object4, (MediaItem$AdsConfiguration)object2, (List)object3, (String)object, list, object8, null);
            object7 = mediaItem$Builder.mediaId;
            if (object7 == null) {
                object7 = object6.toString();
            }
            mediaItem$Builder.mediaId = object7;
            object2 = mediaItem$PlaybackProperties;
        } else {
            boolean bl6 = false;
            object2 = null;
        }
        object5 = object7 = Assertions.checkNotNull(mediaItem$Builder.mediaId);
        object5 = (String)object7;
        long l10 = mediaItem$Builder.clipStartPositionMs;
        long l11 = mediaItem$Builder.clipEndPositionMs;
        boolean bl7 = mediaItem$Builder.clipRelativeToLiveWindow;
        boolean bl8 = mediaItem$Builder.clipRelativeToDefaultPosition;
        boolean bl9 = mediaItem$Builder.clipStartsAtKeyFrame;
        uri = null;
        object3 = object4;
        object4 = new MediaItem$ClippingProperties(l10, l11, bl7, bl8, bl9, null);
        long l12 = mediaItem$Builder.liveTargetOffsetMs;
        l10 = mediaItem$Builder.liveMinOffsetMs;
        l11 = mediaItem$Builder.liveMaxOffsetMs;
        float f10 = mediaItem$Builder.liveMinPlaybackSpeed;
        float f11 = mediaItem$Builder.liveMaxPlaybackSpeed;
        object3 = new MediaItem$LiveConfiguration(l12, l10, l11, f10, f11);
        object7 = mediaItem$Builder.mediaMetadata;
        if (object7 == null) {
            object7 = new MediaMetadata$Builder();
            object7 = ((MediaMetadata$Builder)object7).build();
        }
        object = object7;
        mediaItem$DrmConfiguration = object6;
        object6 = new MediaItem((String)object5, (MediaItem$ClippingProperties)object4, (MediaItem$PlaybackProperties)object2, (MediaItem$LiveConfiguration)object3, (MediaMetadata)object7, null);
        return object6;
    }

    public MediaItem$Builder setAdTagUri(Uri uri) {
        return this.setAdTagUri(uri, null);
    }

    public MediaItem$Builder setAdTagUri(Uri uri, Object object) {
        this.adTagUri = uri;
        this.adsId = object;
        return this;
    }

    public MediaItem$Builder setAdTagUri(String string2) {
        string2 = string2 != null ? Uri.parse((String)string2) : null;
        return this.setAdTagUri((Uri)string2);
    }

    public MediaItem$Builder setClipEndPositionMs(long l10) {
        long l11;
        long l12 = Long.MIN_VALUE;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object != false && (object = (l11 = l10 - (l12 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0 ? (Object)0 : (Object)1;
        Assertions.checkArgument((boolean)object);
        this.clipEndPositionMs = l10;
        return this;
    }

    public MediaItem$Builder setClipRelativeToDefaultPosition(boolean bl2) {
        this.clipRelativeToDefaultPosition = bl2;
        return this;
    }

    public MediaItem$Builder setClipRelativeToLiveWindow(boolean bl2) {
        this.clipRelativeToLiveWindow = bl2;
        return this;
    }

    public MediaItem$Builder setClipStartPositionMs(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        Assertions.checkArgument((boolean)object);
        this.clipStartPositionMs = l10;
        return this;
    }

    public MediaItem$Builder setClipStartsAtKeyFrame(boolean bl2) {
        this.clipStartsAtKeyFrame = bl2;
        return this;
    }

    public MediaItem$Builder setCustomCacheKey(String string2) {
        this.customCacheKey = string2;
        return this;
    }

    public MediaItem$Builder setDrmForceDefaultLicenseUri(boolean bl2) {
        this.drmForceDefaultLicenseUri = bl2;
        return this;
    }

    public MediaItem$Builder setDrmKeySetId(byte[] byArray) {
        if (byArray != null) {
            int n10 = byArray.length;
            byArray = Arrays.copyOf(byArray, n10);
        } else {
            byArray = null;
        }
        this.drmKeySetId = byArray;
        return this;
    }

    public MediaItem$Builder setDrmLicenseRequestHeaders(Map map) {
        boolean bl2;
        if (map != null && !(bl2 = map.isEmpty())) {
            HashMap hashMap = new HashMap(map);
            map = Collections.unmodifiableMap(hashMap);
        } else {
            map = Collections.emptyMap();
        }
        this.drmLicenseRequestHeaders = map;
        return this;
    }

    public MediaItem$Builder setDrmLicenseUri(Uri uri) {
        this.drmLicenseUri = uri;
        return this;
    }

    public MediaItem$Builder setDrmLicenseUri(String string2) {
        string2 = string2 == null ? null : Uri.parse((String)string2);
        this.drmLicenseUri = string2;
        return this;
    }

    public MediaItem$Builder setDrmMultiSession(boolean bl2) {
        this.drmMultiSession = bl2;
        return this;
    }

    public MediaItem$Builder setDrmPlayClearContentWithoutKey(boolean bl2) {
        this.drmPlayClearContentWithoutKey = bl2;
        return this;
    }

    public MediaItem$Builder setDrmSessionForClearPeriods(boolean bl2) {
        List<Integer> list;
        if (bl2) {
            Integer n10;
            int n11 = 2;
            Integer[] integerArray = new Integer[n11];
            list = n11;
            integerArray[0] = list;
            int n12 = 1;
            integerArray[n12] = n10 = Integer.valueOf(n12);
            list = Arrays.asList(integerArray);
        } else {
            list = Collections.emptyList();
        }
        this.setDrmSessionForClearTypes(list);
        return this;
    }

    public MediaItem$Builder setDrmSessionForClearTypes(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            ArrayList arrayList = new ArrayList(list);
            list = Collections.unmodifiableList(arrayList);
        } else {
            list = Collections.emptyList();
        }
        this.drmSessionForClearTypes = list;
        return this;
    }

    public MediaItem$Builder setDrmUuid(UUID uUID) {
        this.drmUuid = uUID;
        return this;
    }

    public MediaItem$Builder setLiveMaxOffsetMs(long l10) {
        this.liveMaxOffsetMs = l10;
        return this;
    }

    public MediaItem$Builder setLiveMaxPlaybackSpeed(float f10) {
        this.liveMaxPlaybackSpeed = f10;
        return this;
    }

    public MediaItem$Builder setLiveMinOffsetMs(long l10) {
        this.liveMinOffsetMs = l10;
        return this;
    }

    public MediaItem$Builder setLiveMinPlaybackSpeed(float f10) {
        this.liveMinPlaybackSpeed = f10;
        return this;
    }

    public MediaItem$Builder setLiveTargetOffsetMs(long l10) {
        this.liveTargetOffsetMs = l10;
        return this;
    }

    public MediaItem$Builder setMediaId(String string2) {
        this.mediaId = string2;
        return this;
    }

    public MediaItem$Builder setMediaMetadata(MediaMetadata mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
        return this;
    }

    public MediaItem$Builder setMimeType(String string2) {
        this.mimeType = string2;
        return this;
    }

    public MediaItem$Builder setStreamKeys(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            ArrayList arrayList = new ArrayList(list);
            list = Collections.unmodifiableList(arrayList);
        } else {
            list = Collections.emptyList();
        }
        this.streamKeys = list;
        return this;
    }

    public MediaItem$Builder setSubtitles(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            ArrayList arrayList = new ArrayList(list);
            list = Collections.unmodifiableList(arrayList);
        } else {
            list = Collections.emptyList();
        }
        this.subtitles = list;
        return this;
    }

    public MediaItem$Builder setTag(Object object) {
        this.tag = object;
        return this;
    }

    public MediaItem$Builder setUri(Uri uri) {
        this.uri = uri;
        return this;
    }

    public MediaItem$Builder setUri(String string2) {
        string2 = string2 == null ? null : Uri.parse((String)string2);
        return this.setUri((Uri)string2);
    }
}

