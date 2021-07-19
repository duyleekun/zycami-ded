/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 */
package com.google.android.exoplayer2.ui;

import android.app.Notification;

public interface PlayerNotificationManager$NotificationListener {
    default public void onNotificationCancelled(int n10) {
    }

    default public void onNotificationCancelled(int n10, boolean bl2) {
    }

    default public void onNotificationPosted(int n10, Notification notification, boolean bl2) {
    }

    default public void onNotificationStarted(int n10, Notification notification) {
    }
}

