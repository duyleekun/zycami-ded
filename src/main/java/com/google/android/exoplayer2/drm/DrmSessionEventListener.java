/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;

public interface DrmSessionEventListener {
    default public void onDrmKeysLoaded(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
    }

    default public void onDrmKeysRemoved(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
    }

    default public void onDrmKeysRestored(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
    }

    default public void onDrmSessionAcquired(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
    }

    default public void onDrmSessionManagerError(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Exception exception) {
    }

    default public void onDrmSessionReleased(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
    }
}

