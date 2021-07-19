/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.view.View
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient$Builder;
import com.google.android.gms.common.internal.ClientSettings$OptionalApiSettings;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class ClientSettings {
    public static final String KEY_CLIENT_SESSION_ID = "com.google.android.gms.common.internal.ClientSettings.sessionId";
    private final Set zabr;
    private final int zabt;
    private final View zabu;
    private final String zabv;
    private final String zabw;
    private final boolean zaby;
    private final Set zaob;
    private final Map zaoc;
    private final SignInOptions zaod;
    private Integer zaoe;
    private final Account zax;

    public ClientSettings(Account account, Set set, Map map, int n10, View view, String string2, String string3, SignInOptions signInOptions) {
        this(account, set, map, n10, view, string2, string3, signInOptions, false);
    }

    public ClientSettings(Account object, Set set, Map object2, int n10, View view, String string2, String string3, SignInOptions signInOptions, boolean bl2) {
        boolean bl3;
        this.zax = object;
        object = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.zabr = object;
        if (object2 == null) {
            object2 = Collections.EMPTY_MAP;
        }
        this.zaoc = object2;
        this.zabu = view;
        this.zabt = n10;
        this.zabv = string2;
        this.zabw = string3;
        this.zaod = signInOptions;
        this.zaby = bl2;
        super(object);
        object = object2.values().iterator();
        while (bl3 = object.hasNext()) {
            object2 = ((ClientSettings$OptionalApiSettings)object.next()).mScopes;
            set.addAll(object2);
        }
        this.zaob = object = Collections.unmodifiableSet(set);
    }

    public static ClientSettings createDefault(Context context) {
        GoogleApiClient$Builder googleApiClient$Builder = new GoogleApiClient$Builder(context);
        return googleApiClient$Builder.buildClientSettings();
    }

    public final Account getAccount() {
        return this.zax;
    }

    public final String getAccountName() {
        Account account = this.zax;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public final Account getAccountOrDefault() {
        Account account = this.zax;
        if (account != null) {
            return account;
        }
        account = new Account("<<default account>>", "com.google");
        return account;
    }

    public final Set getAllRequestedScopes() {
        return this.zaob;
    }

    public final Set getApplicableScopes(Api object) {
        boolean bl2;
        Object object2 = this.zaoc;
        if ((object = (ClientSettings$OptionalApiSettings)object2.get(object)) != null && !(bl2 = (object2 = ((ClientSettings$OptionalApiSettings)object).mScopes).isEmpty())) {
            Set set = this.zabr;
            object2 = new Object(set);
            object = ((ClientSettings$OptionalApiSettings)object).mScopes;
            object2.addAll(object);
            return object2;
        }
        return this.zabr;
    }

    public final Integer getClientSessionId() {
        return this.zaoe;
    }

    public final int getGravityForPopups() {
        return this.zabt;
    }

    public final Map getOptionalApiSettings() {
        return this.zaoc;
    }

    public final String getRealClientClassName() {
        return this.zabw;
    }

    public final String getRealClientPackageName() {
        return this.zabv;
    }

    public final Set getRequiredScopes() {
        return this.zabr;
    }

    public final SignInOptions getSignInOptions() {
        return this.zaod;
    }

    public final View getViewForPopups() {
        return this.zabu;
    }

    public final boolean isSignInClientDisconnectFixEnabled() {
        return this.zaby;
    }

    public final void setClientSessionId(Integer n10) {
        this.zaoe = n10;
    }
}

