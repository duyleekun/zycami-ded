/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$ManifestExpiryEventInfo;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerEmsgCallback;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Util;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class PlayerEmsgHandler
implements Handler.Callback {
    private static final int EMSG_MANIFEST_EXPIRED = 1;
    private final Allocator allocator;
    private boolean chunkLoadedCompletedSinceLastManifestRefreshRequest;
    private final EventMessageDecoder decoder;
    private long expiredManifestPublishTimeUs;
    private final Handler handler;
    private boolean isWaitingForManifestRefresh;
    private DashManifest manifest;
    private final TreeMap manifestPublishTimeToExpiryTimeUs;
    private final PlayerEmsgHandler$PlayerEmsgCallback playerEmsgCallback;
    private boolean released;

    public PlayerEmsgHandler(DashManifest object, PlayerEmsgHandler$PlayerEmsgCallback playerEmsgHandler$PlayerEmsgCallback, Allocator allocator) {
        this.manifest = object;
        this.playerEmsgCallback = playerEmsgHandler$PlayerEmsgCallback;
        this.allocator = allocator;
        this.manifestPublishTimeToExpiryTimeUs = object = new TreeMap();
        this.handler = object = Util.createHandlerForCurrentLooper(this);
        this.decoder = object;
    }

    public static /* synthetic */ EventMessageDecoder access$000(PlayerEmsgHandler playerEmsgHandler) {
        return playerEmsgHandler.decoder;
    }

    public static /* synthetic */ boolean access$100(String string2, String string3) {
        return PlayerEmsgHandler.isPlayerEmsgEvent(string2, string3);
    }

    public static /* synthetic */ long access$200(EventMessage eventMessage) {
        return PlayerEmsgHandler.getManifestPublishTimeMsInEmsg(eventMessage);
    }

    public static /* synthetic */ Handler access$300(PlayerEmsgHandler playerEmsgHandler) {
        return playerEmsgHandler.handler;
    }

    private Map.Entry ceilingExpiryEntryForPublishTime(long l10) {
        TreeMap treeMap = this.manifestPublishTimeToExpiryTimeUs;
        Long l11 = l10;
        return treeMap.ceilingEntry(l11);
    }

    private static long getManifestPublishTimeMsInEmsg(EventMessage object) {
        try {
            object = ((EventMessage)object).messageData;
        }
        catch (ParserException parserException) {
            return -9223372036854775807L;
        }
        object = Util.fromUtf8Bytes((byte[])object);
        return Util.parseXsDateTime((String)object);
    }

    private void handleManifestExpiredMessage(long l10, long l11) {
        Serializable serializable = this.manifestPublishTimeToExpiryTimeUs;
        Long l12 = l11;
        if ((serializable = (Long)((TreeMap)serializable).get(l12)) == null) {
            serializable = this.manifestPublishTimeToExpiryTimeUs;
            Long l13 = l11;
            Long l14 = l10;
            ((TreeMap)serializable).put(l13, l14);
        } else {
            long l15 = (Long)serializable;
            long l16 = l15 - l10;
            Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object > 0) {
                serializable = this.manifestPublishTimeToExpiryTimeUs;
                Long l17 = l11;
                Long l18 = l10;
                ((TreeMap)serializable).put(l17, l18);
            }
        }
    }

    private static boolean isPlayerEmsgEvent(String string2, String string3) {
        String string4 = "urn:mpeg:dash:event:2012";
        boolean bl2 = string4.equals(string2);
        if (bl2 && ((bl2 = (string2 = "1").equals(string3)) || (bl2 = (string2 = "2").equals(string3)) || (bl2 = (string2 = "3").equals(string3)))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private void maybeNotifyDashManifestRefreshNeeded() {
        boolean bl2 = this.chunkLoadedCompletedSinceLastManifestRefreshRequest;
        if (!bl2) {
            return;
        }
        this.isWaitingForManifestRefresh = true;
        this.chunkLoadedCompletedSinceLastManifestRefreshRequest = false;
        this.playerEmsgCallback.onDashManifestRefreshRequested();
    }

    private void notifyManifestPublishTimeExpired() {
        PlayerEmsgHandler$PlayerEmsgCallback playerEmsgHandler$PlayerEmsgCallback = this.playerEmsgCallback;
        long l10 = this.expiredManifestPublishTimeUs;
        playerEmsgHandler$PlayerEmsgCallback.onDashManifestPublishTimeExpired(l10);
    }

    private void removePreviouslyExpiredManifestPublishTimeValues() {
        Object object;
        Iterator iterator2 = this.manifestPublishTimeToExpiryTimeUs.entrySet().iterator();
        while ((object = iterator2.hasNext()) != 0) {
            Long l10 = (Long)iterator2.next().getKey();
            long l11 = l10;
            DashManifest dashManifest = this.manifest;
            long l12 = dashManifest.publishTimeMs;
            long l13 = l11 - l12;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object >= 0) continue;
            iterator2.remove();
        }
    }

    public boolean handleMessage(Message object) {
        int n10 = this.released;
        int n11 = 1;
        if (n10) {
            return n11 != 0;
        }
        n10 = object.what;
        if (n10 != n11) {
            return false;
        }
        object = (PlayerEmsgHandler$ManifestExpiryEventInfo)object.obj;
        long l10 = object.eventTimeUs;
        long l11 = object.manifestPublishTimeMsInEmsg;
        this.handleManifestExpiredMessage(l10, l11);
        return n11 != 0;
    }

    public boolean maybeRefreshManifestBeforeLoadingNextChunk(long l10) {
        Long l11;
        long l12;
        long l13;
        long l14;
        Object object = this.manifest;
        boolean bl2 = ((DashManifest)object).dynamic;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        bl2 = this.isWaitingForManifestRefresh;
        boolean bl4 = true;
        if (bl2) {
            return bl4;
        }
        long l15 = ((DashManifest)object).publishTimeMs;
        object = this.ceilingExpiryEntryForPublishTime(l15);
        if (object != null && (l14 = (l13 = (l12 = (l11 = (Long)object.getValue()).longValue()) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
            Long l16 = (Long)object.getKey();
            this.expiredManifestPublishTimeUs = l10 = l16.longValue();
            this.notifyManifestPublishTimeExpired();
            bl3 = bl4;
        }
        if (bl3) {
            this.maybeNotifyDashManifestRefreshNeeded();
        }
        return bl3;
    }

    public PlayerEmsgHandler$PlayerTrackEmsgHandler newPlayerTrackEmsgHandler() {
        Allocator allocator = this.allocator;
        PlayerEmsgHandler$PlayerTrackEmsgHandler playerEmsgHandler$PlayerTrackEmsgHandler = new PlayerEmsgHandler$PlayerTrackEmsgHandler(this, allocator);
        return playerEmsgHandler$PlayerTrackEmsgHandler;
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        this.chunkLoadedCompletedSinceLastManifestRefreshRequest = true;
    }

    public boolean onChunkLoadError(boolean bl2) {
        DashManifest dashManifest = this.manifest;
        boolean bl3 = dashManifest.dynamic;
        if (!bl3) {
            return false;
        }
        bl3 = this.isWaitingForManifestRefresh;
        boolean bl4 = true;
        if (bl3) {
            return bl4;
        }
        if (bl2) {
            this.maybeNotifyDashManifestRefreshNeeded();
            return bl4;
        }
        return false;
    }

    public void release() {
        this.released = true;
        this.handler.removeCallbacksAndMessages(null);
    }

    public void updateManifest(DashManifest dashManifest) {
        this.isWaitingForManifestRefresh = false;
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.manifest = dashManifest;
        this.removePreviouslyExpiredManifestPublishTimeValues();
    }
}

