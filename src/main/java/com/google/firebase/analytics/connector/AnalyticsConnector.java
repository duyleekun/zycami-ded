/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.AnalyticsConnector$ConditionalUserProperty;
import java.util.List;
import java.util.Map;

public interface AnalyticsConnector {
    public void clearConditionalUserProperty(String var1, String var2, Bundle var3);

    public List getConditionalUserProperties(String var1, String var2);

    public int getMaxUserProperties(String var1);

    public Map getUserProperties(boolean var1);

    public void logEvent(String var1, String var2, Bundle var3);

    public AnalyticsConnector$AnalyticsConnectorHandle registerAnalyticsConnectorListener(String var1, AnalyticsConnector$AnalyticsConnectorListener var2);

    public void setConditionalUserProperty(AnalyticsConnector$ConditionalUserProperty var1);

    public void setUserProperty(String var1, String var2, Object var3);
}

