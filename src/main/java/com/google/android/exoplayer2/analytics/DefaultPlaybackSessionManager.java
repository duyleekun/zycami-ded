/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.google.android.exoplayer2.analytics;

import android.util.Base64;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import d.h.a.a.e0.f1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public final class DefaultPlaybackSessionManager
implements PlaybackSessionManager {
    public static final Supplier DEFAULT_SESSION_ID_GENERATOR;
    private static final Random RANDOM;
    private static final int SESSION_ID_LENGTH = 12;
    private String currentSessionId;
    private Timeline currentTimeline;
    private PlaybackSessionManager$Listener listener;
    private final Timeline$Period period;
    private final Supplier sessionIdGenerator;
    private final HashMap sessions;
    private final Timeline$Window window;

    static {
        Random random;
        DEFAULT_SESSION_ID_GENERATOR = f1.a;
        RANDOM = random = new Random();
    }

    public DefaultPlaybackSessionManager() {
        Supplier supplier = DEFAULT_SESSION_ID_GENERATOR;
        this(supplier);
    }

    public DefaultPlaybackSessionManager(Supplier object) {
        this.sessionIdGenerator = object;
        this.window = object = new Timeline$Window();
        this.period = object = new Timeline$Period();
        object = new HashMap();
        this.sessions = object;
        this.currentTimeline = object = Timeline.EMPTY;
    }

    public static /* synthetic */ String a() {
        return DefaultPlaybackSessionManager.generateDefaultSessionId();
    }

    public static /* synthetic */ Timeline$Window access$600(DefaultPlaybackSessionManager defaultPlaybackSessionManager) {
        return defaultPlaybackSessionManager.window;
    }

    public static /* synthetic */ Timeline$Period access$700(DefaultPlaybackSessionManager defaultPlaybackSessionManager) {
        return defaultPlaybackSessionManager.period;
    }

    private static String generateDefaultSessionId() {
        byte[] byArray = new byte[12];
        RANDOM.nextBytes(byArray);
        return Base64.encodeToString((byte[])byArray, (int)10);
    }

    private DefaultPlaybackSessionManager$SessionDescriptor getOrAddSession(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        boolean bl2;
        Object object = this.sessions.values().iterator();
        DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor = null;
        long l10 = Long.MAX_VALUE;
        while (bl2 = object.hasNext()) {
            long l11;
            DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor2 = (DefaultPlaybackSessionManager$SessionDescriptor)object.next();
            defaultPlaybackSessionManager$SessionDescriptor2.maybeSetWindowSequenceNumber(n10, mediaSource$MediaPeriodId);
            boolean bl3 = defaultPlaybackSessionManager$SessionDescriptor2.belongsToSession(n10, mediaSource$MediaPeriodId);
            if (!bl3) continue;
            long l12 = DefaultPlaybackSessionManager$SessionDescriptor.access$100(defaultPlaybackSessionManager$SessionDescriptor2);
            long l13 = l12 - (l11 = (long)-1);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 != false && (object2 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) >= 0) {
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId2;
                if (object2 != false || (mediaSource$MediaPeriodId2 = DefaultPlaybackSessionManager$SessionDescriptor.access$500((DefaultPlaybackSessionManager$SessionDescriptor)Util.castNonNull(defaultPlaybackSessionManager$SessionDescriptor))) == null || (mediaSource$MediaPeriodId2 = DefaultPlaybackSessionManager$SessionDescriptor.access$500(defaultPlaybackSessionManager$SessionDescriptor2)) == null) continue;
                defaultPlaybackSessionManager$SessionDescriptor = defaultPlaybackSessionManager$SessionDescriptor2;
                continue;
            }
            defaultPlaybackSessionManager$SessionDescriptor = defaultPlaybackSessionManager$SessionDescriptor2;
            l10 = l12;
        }
        if (defaultPlaybackSessionManager$SessionDescriptor == null) {
            object = (String)this.sessionIdGenerator.get();
            defaultPlaybackSessionManager$SessionDescriptor = new DefaultPlaybackSessionManager$SessionDescriptor(this, (String)object, n10, mediaSource$MediaPeriodId);
            HashMap hashMap = this.sessions;
            hashMap.put(object, defaultPlaybackSessionManager$SessionDescriptor);
        }
        return defaultPlaybackSessionManager$SessionDescriptor;
    }

    public boolean belongsToSession(AnalyticsListener$EventTime object, String object2) {
        synchronized (this) {
            block11: {
                HashMap hashMap = this.sessions;
                object2 = hashMap.get(object2);
                object2 = (DefaultPlaybackSessionManager$SessionDescriptor)object2;
                if (object2 != null) break block11;
                return false;
            }
            int n10 = ((AnalyticsListener$EventTime)object).windowIndex;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = ((AnalyticsListener$EventTime)object).mediaPeriodId;
            ((DefaultPlaybackSessionManager$SessionDescriptor)object2).maybeSetWindowSequenceNumber(n10, mediaSource$MediaPeriodId);
            n10 = ((AnalyticsListener$EventTime)object).windowIndex;
            object = ((AnalyticsListener$EventTime)object).mediaPeriodId;
            boolean bl2 = ((DefaultPlaybackSessionManager$SessionDescriptor)object2).belongsToSession(n10, (MediaSource$MediaPeriodId)object);
            return bl2;
        }
    }

    public void finishAllSessions(AnalyticsListener$EventTime analyticsListener$EventTime) {
        boolean bl2;
        this.currentSessionId = null;
        Iterator iterator2 = this.sessions.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            PlaybackSessionManager$Listener playbackSessionManager$Listener;
            Object object = (DefaultPlaybackSessionManager$SessionDescriptor)iterator2.next();
            iterator2.remove();
            boolean bl3 = DefaultPlaybackSessionManager$SessionDescriptor.access$300((DefaultPlaybackSessionManager$SessionDescriptor)object);
            if (!bl3 || (playbackSessionManager$Listener = this.listener) == null) continue;
            object = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)object);
            playbackSessionManager$Listener.onSessionFinished(analyticsListener$EventTime, (String)object, false);
        }
    }

    public String getSessionForMediaPeriodId(Timeline object, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        synchronized (this) {
            Object object2 = mediaSource$MediaPeriodId.periodUid;
            Timeline$Period timeline$Period = this.period;
            object = ((Timeline)object).getPeriodByUid(object2, timeline$Period);
            int n10 = ((Timeline$Period)object).windowIndex;
            object = this.getOrAddSession(n10, mediaSource$MediaPeriodId);
            object = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)object);
            return object;
        }
    }

    public void setListener(PlaybackSessionManager$Listener playbackSessionManager$Listener) {
        this.listener = playbackSessionManager$Listener;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void updateSessions(AnalyticsListener$EventTime var1_1) {
        var2_2 = this;
        var3_3 = var1_1;
        synchronized (this) {
            block73: {
                block72: {
                    block71: {
                        block70: {
                            block69: {
                                var4_5 = this.listener;
                                Assertions.checkNotNull(var4_5);
                                var4_5 = this.sessions;
                                var5_6 = this.currentSessionId;
                                var4_5 = var4_5.get(var5_6);
                                var4_5 = (DefaultPlaybackSessionManager$SessionDescriptor)var4_5;
                                var5_6 = var1_1.mediaPeriodId;
                                var6_7 = true;
                                if (var5_6 == null || var4_5 == null) break block69;
                                var7_8 = DefaultPlaybackSessionManager$SessionDescriptor.access$100((DefaultPlaybackSessionManager$SessionDescriptor)var4_5);
                                var9_9 = -1;
                                var11_10 = var7_8 == var9_9 ? 0 : (var7_8 < var9_9 ? -1 : 1);
                                var12_11 = false;
                                var13_12 = null;
                                if (var11_10 == false) {
                                    var14_13 = DefaultPlaybackSessionManager$SessionDescriptor.access$200((DefaultPlaybackSessionManager$SessionDescriptor)var4_5);
                                    var11_10 = var1_1.windowIndex;
                                    ** if (var14_13 == var11_10) goto lbl35
lbl-1000:
                                    // 2 sources

                                    {
                                        while (true) {
                                            var12_11 = var6_7;
                                            break;
                                        }
                                    }
lbl35:
                                    // 1 sources

                                } else {
                                    var5_6 = var1_1.mediaPeriodId;
                                    var15_14 = var5_6.windowSequenceNumber;
                                    ** try [egrp 11[TRYBLOCK] [12 : 134->139)] { 
lbl41:
                                    // 1 sources

                                    if ((var14_13 = (boolean)((cfr_temp_0 = var15_14 - (var17_15 = DefaultPlaybackSessionManager$SessionDescriptor.access$100((DefaultPlaybackSessionManager$SessionDescriptor)var4_5))) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) < false) ** continue;
                                }
                                if (var12_11) {
                                    return;
                                }
                            }
                            var14_13 = var3_3.windowIndex;
                            var5_6 = var3_3.mediaPeriodId;
                            var4_5 = var2_2.getOrAddSession((int)var14_13, (MediaSource$MediaPeriodId)var5_6);
                            var5_6 = var2_2.currentSessionId;
                            if (var5_6 != null) ** GOTO lbl60
                            var5_6 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)var4_5);
                            var2_2.currentSessionId = var5_6;
lbl60:
                            // 2 sources

                            if ((var5_6 = var3_3.mediaPeriodId) == null) break block70;
                            var11_10 = (long)var5_6.isAd();
                            if (var11_10 == false) break block70;
                            var5_6 = var3_3.mediaPeriodId;
                            var13_12 = var5_6.periodUid;
                            var15_14 = var5_6.windowSequenceNumber;
                            var11_10 = var5_6.adGroupIndex;
                            var19_16 = new MediaSource$MediaPeriodId(var13_12, var15_14, (int)var11_10);
                            var11_10 = var3_3.windowIndex;
                            var5_6 = var2_2.getOrAddSession((int)var11_10, var19_16);
                            var12_11 = DefaultPlaybackSessionManager$SessionDescriptor.access$300((DefaultPlaybackSessionManager$SessionDescriptor)var5_6);
                            if (var12_11) break block70;
                            DefaultPlaybackSessionManager$SessionDescriptor.access$302((DefaultPlaybackSessionManager$SessionDescriptor)var5_6, var6_7);
                            var13_12 = var3_3.timeline;
                            var20_17 = var3_3.mediaPeriodId;
                            var20_17 = var20_17.periodUid;
                            var21_18 = var2_2.period;
                            var13_12.getPeriodByUid(var20_17, var21_18);
                            var13_12 = var2_2.period;
                            var20_17 = var3_3.mediaPeriodId;
                            var22_19 = var20_17.adGroupIndex;
                            var7_8 = var13_12.getAdGroupTimeUs(var22_19);
                            var7_8 = C.usToMs(var7_8);
                            var21_18 = var2_2.period;
                            var9_9 = var21_18.getPositionInWindowMs();
                            var7_8 += var9_9;
                            var9_9 = 0L;
                            var23_20 = Math.max(var9_9, var7_8);
                            var15_14 = var3_3.realtimeMs;
                            var26_22 = var3_3.timeline;
                            var27_23 = var3_3.windowIndex;
                            var28_24 = var3_3.currentTimeline;
                            var29_25 = var3_3.currentWindowIndex;
                            var30_26 = var13_12 = var3_3.currentMediaPeriodId;
                            var31_27 = var3_3.currentPlaybackPositionMs;
                            var33_28 = var4_5;
                            var17_15 = var3_3.totalBufferedDurationMs;
                            var34_29 = var13_12;
                            var13_12 = var25_21;
                            var3_3 = var25_21;
                            var25_21 = var30_26;
                            var13_12(var15_14, var26_22, var27_23, var19_16, var23_20, var28_24, var29_25, (MediaSource$MediaPeriodId)var30_26, var31_27, var17_15);
                            var4_5 = var2_2.listener;
                            var5_6 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)var5_6);
                            var4_5.onSessionCreated((AnalyticsListener$EventTime)var13_12, (String)var5_6);
                            break block71;
                        }
                        var33_28 = var4_5;
                    }
                    var35_30 = DefaultPlaybackSessionManager$SessionDescriptor.access$300((DefaultPlaybackSessionManager$SessionDescriptor)var33_28);
                    if (var35_30) break block72;
                    var3_3 = var33_28;
                    var14_13 = true;
                    DefaultPlaybackSessionManager$SessionDescriptor.access$302((DefaultPlaybackSessionManager$SessionDescriptor)var33_28, var14_13);
                    var4_5 = var2_2.listener;
                    var5_6 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)var33_28);
                    var34_29 = var1_1;
                    var4_5.onSessionCreated(var1_1, (String)var5_6);
                    break block73;
                }
                var34_29 = var1_1;
                var3_3 = var33_28;
            }
            var4_5 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)var3_3);
            var5_6 = var2_2.currentSessionId;
            var14_13 = var4_5.equals(var5_6);
            if (!var14_13) ** GOTO lbl180
            var14_13 = DefaultPlaybackSessionManager$SessionDescriptor.access$400((DefaultPlaybackSessionManager$SessionDescriptor)var3_3);
            if (var14_13) ** GOTO lbl180
            var14_13 = true;
            DefaultPlaybackSessionManager$SessionDescriptor.access$402((DefaultPlaybackSessionManager$SessionDescriptor)var3_3, var14_13);
            var4_5 = var2_2.listener;
            var3_3 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)var3_3);
            var4_5.onSessionActive((AnalyticsListener$EventTime)var34_29, (String)var3_3);
lbl180:
            // 3 sources

            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updateSessionsWithDiscontinuity(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        synchronized (this) {
            block11: {
                long l10;
                Object object;
                Object object2;
                Object object3;
                Object object4;
                Object object5;
                block12: {
                    Object object6;
                    boolean bl2;
                    int n11;
                    int n12;
                    object5 = this.listener;
                    Assertions.checkNotNull(object5);
                    int n13 = 0;
                    object5 = null;
                    object4 = 1;
                    if (n12 != 0 && n12 != (n11 = 3)) {
                        n12 = 0;
                        object3 = null;
                    } else {
                        n12 = object4;
                    }
                    object2 = this.sessions;
                    object2 = ((HashMap)object2).values();
                    object2 = object2.iterator();
                    while (bl2 = object2.hasNext()) {
                        int n14;
                        object6 = object2.next();
                        boolean bl3 = ((DefaultPlaybackSessionManager$SessionDescriptor)(object6 = (DefaultPlaybackSessionManager$SessionDescriptor)object6)).isFinishedAtEventTime(analyticsListener$EventTime);
                        if (!bl3) continue;
                        object2.remove();
                        bl3 = DefaultPlaybackSessionManager$SessionDescriptor.access$300((DefaultPlaybackSessionManager$SessionDescriptor)object6);
                        if (!bl3) continue;
                        Object object7 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)object6);
                        String string2 = this.currentSessionId;
                        bl3 = ((String)object7).equals(string2);
                        if (n12 != 0 && bl3 && (n14 = DefaultPlaybackSessionManager$SessionDescriptor.access$400((DefaultPlaybackSessionManager$SessionDescriptor)object6)) != 0) {
                            n14 = object4;
                        } else {
                            n14 = 0;
                            string2 = null;
                        }
                        if (bl3) {
                            bl3 = false;
                            object7 = null;
                            this.currentSessionId = null;
                        }
                        object7 = this.listener;
                        object6 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)object6);
                        object7.onSessionFinished(analyticsListener$EventTime, (String)object6, n14 != 0);
                    }
                    object3 = this.sessions;
                    object5 = this.currentSessionId;
                    object3 = ((HashMap)object3).get(object5);
                    object3 = (DefaultPlaybackSessionManager$SessionDescriptor)object3;
                    n13 = analyticsListener$EventTime.windowIndex;
                    object = analyticsListener$EventTime.mediaPeriodId;
                    object5 = this.getOrAddSession(n13, (MediaSource$MediaPeriodId)object);
                    this.currentSessionId = object = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)object5);
                    this.updateSessions(analyticsListener$EventTime);
                    object = analyticsListener$EventTime.mediaPeriodId;
                    if (object == null || (object4 = (Object)((MediaPeriodId)object).isAd()) == 0) break block11;
                    if (object3 == null) break block12;
                    long l11 = DefaultPlaybackSessionManager$SessionDescriptor.access$100((DefaultPlaybackSessionManager$SessionDescriptor)object3);
                    object6 = analyticsListener$EventTime.mediaPeriodId;
                    l10 = ((MediaPeriodId)object6).windowSequenceNumber;
                    long l12 = l11 - l10;
                    object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object4 != 0 || (object = DefaultPlaybackSessionManager$SessionDescriptor.access$500((DefaultPlaybackSessionManager$SessionDescriptor)object3)) == null) break block12;
                    object = DefaultPlaybackSessionManager$SessionDescriptor.access$500((DefaultPlaybackSessionManager$SessionDescriptor)object3);
                    object4 = ((MediaPeriodId)object).adGroupIndex;
                    object2 = analyticsListener$EventTime.mediaPeriodId;
                    n11 = ((MediaPeriodId)object2).adGroupIndex;
                    if (object4 != n11) break block12;
                    object3 = DefaultPlaybackSessionManager$SessionDescriptor.access$500((DefaultPlaybackSessionManager$SessionDescriptor)object3);
                    n12 = ((MediaPeriodId)object3).adIndexInAdGroup;
                    object = analyticsListener$EventTime.mediaPeriodId;
                    object4 = ((MediaPeriodId)object).adIndexInAdGroup;
                    if (n12 == object4) break block11;
                }
                object = analyticsListener$EventTime.mediaPeriodId;
                object2 = ((MediaPeriodId)object).periodUid;
                l10 = ((MediaPeriodId)object).windowSequenceNumber;
                object3 = new MediaSource$MediaPeriodId(object2, l10);
                object4 = analyticsListener$EventTime.windowIndex;
                object3 = this.getOrAddSession((int)object4, (MediaSource$MediaPeriodId)object3);
                object = this.listener;
                object3 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)object3);
                object5 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)object5);
                object.onAdPlaybackStarted(analyticsListener$EventTime, (String)object3, (String)object5);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updateSessionsWithTimelineChange(AnalyticsListener$EventTime analyticsListener$EventTime) {
        synchronized (this) {
            Object object = this.listener;
            Assertions.checkNotNull(object);
            object = this.currentTimeline;
            Object object2 = analyticsListener$EventTime.timeline;
            this.currentTimeline = object2;
            object2 = this.sessions;
            object2 = ((HashMap)object2).values();
            object2 = object2.iterator();
            while (true) {
                String string2;
                boolean bl2;
                if (!(bl2 = object2.hasNext())) {
                    int n10 = 4;
                    this.updateSessionsWithDiscontinuity(analyticsListener$EventTime, n10);
                    return;
                }
                Object object3 = object2.next();
                Object object4 = this.currentTimeline;
                boolean bl3 = ((DefaultPlaybackSessionManager$SessionDescriptor)(object3 = (DefaultPlaybackSessionManager$SessionDescriptor)object3)).tryResolvingToNewTimeline((Timeline)object, (Timeline)object4);
                if (bl3) continue;
                object2.remove();
                bl3 = DefaultPlaybackSessionManager$SessionDescriptor.access$300((DefaultPlaybackSessionManager$SessionDescriptor)object3);
                if (!bl3) continue;
                object4 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)object3);
                bl3 = ((String)object4).equals(string2 = this.currentSessionId);
                if (bl3) {
                    bl3 = false;
                    object4 = null;
                    this.currentSessionId = null;
                }
                object4 = this.listener;
                object3 = DefaultPlaybackSessionManager$SessionDescriptor.access$000((DefaultPlaybackSessionManager$SessionDescriptor)object3);
                string2 = null;
                object4.onSessionFinished(analyticsListener$EventTime, (String)object3, false);
            }
        }
    }
}

