/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem$1;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class MediaItem$DrmConfiguration {
    public final boolean forceDefaultLicenseUri;
    private final byte[] keySetId;
    public final Uri licenseUri;
    public final boolean multiSession;
    public final boolean playClearContentWithoutKey;
    public final Map requestHeaders;
    public final List sessionForClearTypes;
    public final UUID uuid;

    private MediaItem$DrmConfiguration(UUID object, Uri uri, Map map, boolean bl2, boolean bl3, boolean bl4, List list, byte[] byArray) {
        boolean bl5 = !bl3 || uri != null;
        Assertions.checkArgument(bl5);
        this.uuid = object;
        this.licenseUri = uri;
        this.requestHeaders = map;
        this.multiSession = bl2;
        this.forceDefaultLicenseUri = bl3;
        this.playClearContentWithoutKey = bl4;
        this.sessionForClearTypes = list;
        if (byArray != null) {
            int n10 = byArray.length;
            object = Arrays.copyOf(byArray, n10);
        } else {
            boolean bl6 = false;
            object = null;
        }
        this.keySetId = (byte[])object;
    }

    public /* synthetic */ MediaItem$DrmConfiguration(UUID uUID, Uri uri, Map map, boolean bl2, boolean bl3, boolean bl4, List list, byte[] byArray, MediaItem$1 mediaItem$1) {
        this(uUID, uri, map, bl2, bl3, bl4, list, byArray);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = true;
        if (this == object) {
            return bl4;
        }
        boolean bl5 = object instanceof MediaItem$DrmConfiguration;
        if (!bl5) {
            return false;
        }
        object = (MediaItem$DrmConfiguration)object;
        Object object2 = this.uuid;
        Object object3 = ((MediaItem$DrmConfiguration)object).uuid;
        bl5 = ((UUID)object2).equals(object3);
        if (!(bl5 && (bl5 = Util.areEqual(object2 = this.licenseUri, object3 = ((MediaItem$DrmConfiguration)object).licenseUri)) && (bl5 = Util.areEqual(object2 = this.requestHeaders, object3 = ((MediaItem$DrmConfiguration)object).requestHeaders)) && (bl5 = this.multiSession) == (bl3 = ((MediaItem$DrmConfiguration)object).multiSession) && (bl5 = this.forceDefaultLicenseUri) == (bl3 = ((MediaItem$DrmConfiguration)object).forceDefaultLicenseUri) && (bl5 = this.playClearContentWithoutKey) == (bl3 = ((MediaItem$DrmConfiguration)object).playClearContentWithoutKey) && (bl5 = (object2 = this.sessionForClearTypes).equals(object3 = ((MediaItem$DrmConfiguration)object).sessionForClearTypes)) && (bl2 = Arrays.equals((byte[])(object2 = (Object)this.keySetId), (byte[])(object = (Object)((MediaItem$DrmConfiguration)object).keySetId))))) {
            bl4 = false;
        }
        return bl4;
    }

    public byte[] getKeySetId() {
        byte[] byArray = this.keySetId;
        if (byArray != null) {
            int n10 = byArray.length;
            byArray = Arrays.copyOf(byArray, n10);
        } else {
            byArray = null;
        }
        return byArray;
    }

    public int hashCode() {
        int n10;
        UUID uUID = this.uuid;
        int n11 = uUID.hashCode() * 31;
        Uri uri = this.licenseUri;
        if (uri != null) {
            n10 = uri.hashCode();
        } else {
            n10 = 0;
            uri = null;
        }
        n11 = (n11 + n10) * 31;
        n10 = this.requestHeaders.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = (int)(this.multiSession ? 1 : 0);
        n11 = (n11 + n10) * 31;
        n10 = (int)(this.forceDefaultLicenseUri ? 1 : 0);
        n11 = (n11 + n10) * 31;
        n10 = (int)(this.playClearContentWithoutKey ? 1 : 0);
        n11 = (n11 + n10) * 31;
        n10 = this.sessionForClearTypes.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = Arrays.hashCode(this.keySetId);
        return n11 + n10;
    }
}

