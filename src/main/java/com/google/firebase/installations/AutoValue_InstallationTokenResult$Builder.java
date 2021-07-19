/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.AutoValue_InstallationTokenResult;
import com.google.firebase.installations.AutoValue_InstallationTokenResult$1;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.installations.InstallationTokenResult$Builder;
import java.util.Objects;

public final class AutoValue_InstallationTokenResult$Builder
extends InstallationTokenResult$Builder {
    private String token;
    private Long tokenCreationTimestamp;
    private Long tokenExpirationTimestamp;

    public AutoValue_InstallationTokenResult$Builder() {
    }

    private AutoValue_InstallationTokenResult$Builder(InstallationTokenResult object) {
        Object object2 = ((InstallationTokenResult)object).getToken();
        this.token = object2;
        this.tokenExpirationTimestamp = object2 = Long.valueOf(((InstallationTokenResult)object).getTokenExpirationTimestamp());
        this.tokenCreationTimestamp = object = Long.valueOf(((InstallationTokenResult)object).getTokenCreationTimestamp());
    }

    public /* synthetic */ AutoValue_InstallationTokenResult$Builder(InstallationTokenResult installationTokenResult, AutoValue_InstallationTokenResult$1 autoValue_InstallationTokenResult$1) {
        this(installationTokenResult);
    }

    public InstallationTokenResult build() {
        boolean bl2;
        Object object = this.token;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" token");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.tokenExpirationTimestamp) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" tokenExpirationTimestamp");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.tokenCreationTimestamp) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" tokenCreationTimestamp");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            String string3 = this.token;
            long l10 = this.tokenExpirationTimestamp;
            long l11 = this.tokenCreationTimestamp;
            Object object2 = object;
            object = new AutoValue_InstallationTokenResult(string3, l10, l11, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public InstallationTokenResult$Builder setToken(String string2) {
        Objects.requireNonNull(string2, "Null token");
        this.token = string2;
        return this;
    }

    public InstallationTokenResult$Builder setTokenCreationTimestamp(long l10) {
        Long l11;
        this.tokenCreationTimestamp = l11 = Long.valueOf(l10);
        return this;
    }

    public InstallationTokenResult$Builder setTokenExpirationTimestamp(long l10) {
        Long l11;
        this.tokenExpirationTimestamp = l11 = Long.valueOf(l10);
        return this;
    }
}

