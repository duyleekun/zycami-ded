/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.analytics.connector;

import java.util.Set;

public interface AnalyticsConnector$AnalyticsConnectorHandle {
    public void registerEventNames(Set var1);

    public void unregister();

    public void unregisterEventNames();
}

