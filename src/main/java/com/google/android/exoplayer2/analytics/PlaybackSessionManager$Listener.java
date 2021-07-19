/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;

public interface PlaybackSessionManager$Listener {
    public void onAdPlaybackStarted(AnalyticsListener$EventTime var1, String var2, String var3);

    public void onSessionActive(AnalyticsListener$EventTime var1, String var2);

    public void onSessionCreated(AnalyticsListener$EventTime var1, String var2);

    public void onSessionFinished(AnalyticsListener$EventTime var1, String var2, boolean var3);
}

