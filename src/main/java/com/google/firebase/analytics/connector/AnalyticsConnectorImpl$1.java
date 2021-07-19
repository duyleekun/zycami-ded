/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.analytics.connector;

import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.analytics.connector.internal.zza;
import java.util.Set;

public class AnalyticsConnectorImpl$1
implements AnalyticsConnector$AnalyticsConnectorHandle {
    public final /* synthetic */ String zza;
    public final /* synthetic */ AnalyticsConnectorImpl zzb;

    public AnalyticsConnectorImpl$1(AnalyticsConnectorImpl analyticsConnectorImpl, String string2) {
        this.zzb = analyticsConnectorImpl;
        this.zza = string2;
    }

    public void registerEventNames(Set set) {
        Object object = this.zzb;
        String string2 = this.zza;
        boolean bl2 = AnalyticsConnectorImpl.zzb((AnalyticsConnectorImpl)object, string2);
        if (bl2 && (bl2 = ((String)(object = this.zza)).equals(string2 = "fiam")) && set != null && !(bl2 = set.isEmpty())) {
            object = this.zzb.zzb;
            string2 = this.zza;
            object = (zza)object.get(string2);
            object.zzb(set);
        }
    }

    public final void unregister() {
        Object object = this.zzb;
        String string2 = this.zza;
        boolean bl2 = AnalyticsConnectorImpl.zzb((AnalyticsConnectorImpl)object, string2);
        if (!bl2) {
            return;
        }
        object = this.zzb.zzb;
        string2 = this.zza;
        if ((object = ((zza)object.get(string2)).zza()) != null) {
            string2 = null;
            object.onMessageTriggered(0, null);
        }
        object = this.zzb.zzb;
        string2 = this.zza;
        object.remove(string2);
    }

    public void unregisterEventNames() {
        Object object = this.zzb;
        String string2 = this.zza;
        boolean bl2 = AnalyticsConnectorImpl.zzb((AnalyticsConnectorImpl)object, string2);
        if (bl2 && (bl2 = ((String)(object = this.zza)).equals(string2 = "fiam"))) {
            object = this.zzb.zzb;
            string2 = this.zza;
            object = (zza)object.get(string2);
            object.zzc();
        }
    }
}

