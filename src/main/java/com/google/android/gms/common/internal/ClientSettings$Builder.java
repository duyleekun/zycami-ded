/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.view.View
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Map;

public final class ClientSettings$Builder {
    private int zabt = 0;
    private View zabu;
    private String zabv;
    private String zabw;
    private boolean zaby;
    private Map zaoc;
    private SignInOptions zaod;
    private ArraySet zaof;
    private Account zax;

    public ClientSettings$Builder() {
        SignInOptions signInOptions;
        this.zaod = signInOptions = SignInOptions.DEFAULT;
    }

    public final ClientSettings$Builder addAllRequiredScopes(Collection collection) {
        ArraySet arraySet = this.zaof;
        if (arraySet == null) {
            this.zaof = arraySet = new ArraySet();
        }
        this.zaof.addAll(collection);
        return this;
    }

    public final ClientSettings$Builder addRequiredScope(Scope scope) {
        ArraySet arraySet = this.zaof;
        if (arraySet == null) {
            this.zaof = arraySet = new ArraySet();
        }
        this.zaof.add(scope);
        return this;
    }

    public final ClientSettings build() {
        Account account = this.zax;
        ArraySet arraySet = this.zaof;
        Map map = this.zaoc;
        int n10 = this.zabt;
        View view = this.zabu;
        String string2 = this.zabv;
        String string3 = this.zabw;
        SignInOptions signInOptions = this.zaod;
        boolean bl2 = this.zaby;
        ClientSettings clientSettings = new ClientSettings(account, arraySet, map, n10, view, string2, string3, signInOptions, bl2);
        return clientSettings;
    }

    public final ClientSettings$Builder enableSignInClientDisconnectFix() {
        this.zaby = true;
        return this;
    }

    public final ClientSettings$Builder setAccount(Account account) {
        this.zax = account;
        return this;
    }

    public final ClientSettings$Builder setGravityForPopups(int n10) {
        this.zabt = n10;
        return this;
    }

    public final ClientSettings$Builder setOptionalApiSettingsMap(Map map) {
        this.zaoc = map;
        return this;
    }

    public final ClientSettings$Builder setRealClientClassName(String string2) {
        this.zabw = string2;
        return this;
    }

    public final ClientSettings$Builder setRealClientPackageName(String string2) {
        this.zabv = string2;
        return this;
    }

    public final ClientSettings$Builder setSignInOptions(SignInOptions signInOptions) {
        this.zaod = signInOptions;
        return this;
    }

    public final ClientSettings$Builder setViewForPopups(View view) {
        this.zabu = view;
        return this;
    }
}

