/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.AutoValue_InstallationTokenResult$1;
import com.google.firebase.installations.AutoValue_InstallationTokenResult$Builder;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.installations.InstallationTokenResult$Builder;

public final class AutoValue_InstallationTokenResult
extends InstallationTokenResult {
    private final String token;
    private final long tokenCreationTimestamp;
    private final long tokenExpirationTimestamp;

    private AutoValue_InstallationTokenResult(String string2, long l10, long l11) {
        this.token = string2;
        this.tokenExpirationTimestamp = l10;
        this.tokenCreationTimestamp = l11;
    }

    public /* synthetic */ AutoValue_InstallationTokenResult(String string2, long l10, long l11, AutoValue_InstallationTokenResult$1 autoValue_InstallationTokenResult$1) {
        this(string2, l10, l11);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof InstallationTokenResult;
        if (bl3) {
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            String string2 = this.token;
            String string3 = ((InstallationTokenResult)(object = (InstallationTokenResult)object)).getToken();
            bl3 = string2.equals(string3);
            if (!bl3 || (bl3 = (l14 = (l13 = this.tokenExpirationTimestamp) - (l12 = ((InstallationTokenResult)object).getTokenExpirationTimestamp())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) || (l11 = (l10 = (l13 = this.tokenCreationTimestamp) - (l12 = ((InstallationTokenResult)object).getTokenCreationTimestamp())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getToken() {
        return this.token;
    }

    public long getTokenCreationTimestamp() {
        return this.tokenCreationTimestamp;
    }

    public long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    public int hashCode() {
        int n10 = this.token.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        long l10 = this.tokenExpirationTimestamp;
        int n12 = 32;
        long l11 = l10 >>> n12;
        int n13 = (int)(l10 ^ l11);
        n10 = (n10 ^ n13) * n11;
        long l12 = this.tokenCreationTimestamp;
        long l13 = l12 >>> n12;
        n11 = (int)(l12 ^ l13);
        return n10 ^ n11;
    }

    public InstallationTokenResult$Builder toBuilder() {
        AutoValue_InstallationTokenResult$Builder autoValue_InstallationTokenResult$Builder = new AutoValue_InstallationTokenResult$Builder(this, null);
        return autoValue_InstallationTokenResult$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InstallationTokenResult{token=");
        String string2 = this.token;
        stringBuilder.append(string2);
        stringBuilder.append(", tokenExpirationTimestamp=");
        long l10 = this.tokenExpirationTimestamp;
        stringBuilder.append(l10);
        stringBuilder.append(", tokenCreationTimestamp=");
        l10 = this.tokenCreationTimestamp;
        stringBuilder.append(l10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

