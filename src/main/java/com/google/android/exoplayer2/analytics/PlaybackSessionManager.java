/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;

public interface PlaybackSessionManager {
    public boolean belongsToSession(AnalyticsListener$EventTime var1, String var2);

    public void finishAllSessions(AnalyticsListener$EventTime var1);

    public String getSessionForMediaPeriodId(Timeline var1, MediaSource$MediaPeriodId var2);

    public void setListener(PlaybackSessionManager$Listener var1);

    public void updateSessions(AnalyticsListener$EventTime var1);

    public void updateSessionsWithDiscontinuity(AnalyticsListener$EventTime var1, int var2);

    public void updateSessionsWithTimelineChange(AnalyticsListener$EventTime var1);
}

