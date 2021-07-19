/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

public final class DashMediaPeriod$TrackGroupInfo {
    private static final int CATEGORY_EMBEDDED = 1;
    private static final int CATEGORY_MANIFEST_EVENTS = 2;
    private static final int CATEGORY_PRIMARY;
    public final int[] adaptationSetIndices;
    public final int embeddedClosedCaptionTrackGroupIndex;
    public final int embeddedEventMessageTrackGroupIndex;
    public final int eventStreamGroupIndex;
    public final int primaryTrackGroupIndex;
    public final int trackGroupCategory;
    public final int trackType;

    private DashMediaPeriod$TrackGroupInfo(int n10, int n11, int[] nArray, int n12, int n13, int n14, int n15) {
        this.trackType = n10;
        this.adaptationSetIndices = nArray;
        this.trackGroupCategory = n11;
        this.primaryTrackGroupIndex = n12;
        this.embeddedEventMessageTrackGroupIndex = n13;
        this.embeddedClosedCaptionTrackGroupIndex = n14;
        this.eventStreamGroupIndex = n15;
    }

    public static DashMediaPeriod$TrackGroupInfo embeddedClosedCaptionTrack(int[] nArray, int n10) {
        DashMediaPeriod$TrackGroupInfo dashMediaPeriod$TrackGroupInfo = new DashMediaPeriod$TrackGroupInfo(3, 1, nArray, n10, -1, -1, -1);
        return dashMediaPeriod$TrackGroupInfo;
    }

    public static DashMediaPeriod$TrackGroupInfo embeddedEmsgTrack(int[] nArray, int n10) {
        DashMediaPeriod$TrackGroupInfo dashMediaPeriod$TrackGroupInfo = new DashMediaPeriod$TrackGroupInfo(5, 1, nArray, n10, -1, -1, -1);
        return dashMediaPeriod$TrackGroupInfo;
    }

    public static DashMediaPeriod$TrackGroupInfo mpdEventTrack(int n10) {
        int[] nArray = new int[]{};
        DashMediaPeriod$TrackGroupInfo dashMediaPeriod$TrackGroupInfo = new DashMediaPeriod$TrackGroupInfo(5, 2, nArray, -1, -1, -1, n10);
        return dashMediaPeriod$TrackGroupInfo;
    }

    public static DashMediaPeriod$TrackGroupInfo primaryTrack(int n10, int[] nArray, int n11, int n12, int n13) {
        DashMediaPeriod$TrackGroupInfo dashMediaPeriod$TrackGroupInfo = new DashMediaPeriod$TrackGroupInfo(n10, 0, nArray, n11, n12, n13, -1);
        return dashMediaPeriod$TrackGroupInfo;
    }
}

