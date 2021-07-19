/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class GoogleSignInOptions$Builder {
    private Set mScopes;
    private boolean zaaa;
    private String zaab;
    private String zaac;
    private Map zaag;
    private Account zax;
    private boolean zay;
    private boolean zaz;

    public GoogleSignInOptions$Builder() {
        Cloneable cloneable;
        this.mScopes = cloneable = new Cloneable();
        this.zaag = cloneable;
    }

    public GoogleSignInOptions$Builder(GoogleSignInOptions object) {
        boolean bl2;
        Object object2 = new HashSet();
        this.mScopes = object2;
        this.zaag = object2;
        Preconditions.checkNotNull(object);
        ArrayList arrayList = GoogleSignInOptions.zaa((GoogleSignInOptions)object);
        object2 = new HashSet(arrayList);
        this.mScopes = object2;
        this.zaz = bl2 = GoogleSignInOptions.zab((GoogleSignInOptions)object);
        this.zaaa = bl2 = GoogleSignInOptions.zac((GoogleSignInOptions)object);
        this.zay = bl2 = GoogleSignInOptions.zad((GoogleSignInOptions)object);
        this.zaab = object2 = GoogleSignInOptions.zae((GoogleSignInOptions)object);
        object2 = GoogleSignInOptions.zaf((GoogleSignInOptions)object);
        this.zax = object2;
        this.zaac = object2 = GoogleSignInOptions.zag((GoogleSignInOptions)object);
        this.zaag = object = GoogleSignInOptions.zab(GoogleSignInOptions.zah((GoogleSignInOptions)object));
    }

    private final String zac(String string2) {
        boolean bl2;
        Preconditions.checkNotEmpty(string2);
        String string3 = this.zaab;
        if (string3 != null && !(bl2 = string3.equals(string2))) {
            bl2 = false;
            string3 = null;
        } else {
            bl2 = true;
        }
        Preconditions.checkArgument(bl2, "two different server client ids provided");
        return string2;
    }

    public final GoogleSignInOptions$Builder addExtension(GoogleSignInOptionsExtension object) {
        Object object2 = this.zaag;
        int n10 = object.getExtensionType();
        Object object3 = n10;
        boolean bl2 = object2.containsKey(object3);
        if (!bl2) {
            object2 = object.getImpliedScopes();
            if (object2 != null) {
                object2 = this.mScopes;
                object3 = object.getImpliedScopes();
                object2.addAll(object3);
            }
            object2 = this.zaag;
            object3 = object.getExtensionType();
            GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = new GoogleSignInOptionsExtensionParcelable((GoogleSignInOptionsExtension)object);
            object2.put(object3, googleSignInOptionsExtensionParcelable);
            return this;
        }
        object = new IllegalStateException("Only one extension per type may be added");
        throw object;
    }

    public final GoogleSignInOptions build() {
        Object object = this.mScopes;
        Object object2 = GoogleSignInOptions.zav;
        boolean bl2 = object.contains(object2);
        if (bl2 && (bl2 = (object = this.mScopes).contains(object2 = GoogleSignInOptions.zau))) {
            object = this.mScopes;
            object.remove(object2);
        }
        if ((bl2 = this.zay) && ((object = this.zax) == null || !(bl2 = (object = this.mScopes).isEmpty()))) {
            this.requestId();
        }
        object2 = this.mScopes;
        ArrayList arrayList = new ArrayList(object2);
        Account account = this.zax;
        boolean bl3 = this.zay;
        boolean bl4 = this.zaz;
        boolean bl5 = this.zaaa;
        String string2 = this.zaab;
        String string3 = this.zaac;
        Map map = this.zaag;
        object2 = object;
        object = new GoogleSignInOptions(3, arrayList, account, bl3, bl4, bl5, string2, string3, map, null);
        return object;
    }

    public final GoogleSignInOptions$Builder requestEmail() {
        Set set = this.mScopes;
        Scope scope = GoogleSignInOptions.zas;
        set.add(scope);
        return this;
    }

    public final GoogleSignInOptions$Builder requestId() {
        Set set = this.mScopes;
        Scope scope = GoogleSignInOptions.zat;
        set.add(scope);
        return this;
    }

    public final GoogleSignInOptions$Builder requestIdToken(String string2) {
        this.zay = true;
        this.zaab = string2 = this.zac(string2);
        return this;
    }

    public final GoogleSignInOptions$Builder requestProfile() {
        Set set = this.mScopes;
        Scope scope = GoogleSignInOptions.zar;
        set.add(scope);
        return this;
    }

    public final GoogleSignInOptions$Builder requestScopes(Scope object, Scope ... object2) {
        this.mScopes.add(object);
        object = this.mScopes;
        object2 = Arrays.asList(object2);
        object.addAll(object2);
        return this;
    }

    public final GoogleSignInOptions$Builder requestServerAuthCode(String string2) {
        return this.requestServerAuthCode(string2, false);
    }

    public final GoogleSignInOptions$Builder requestServerAuthCode(String string2, boolean bl2) {
        this.zaz = true;
        this.zaab = string2 = this.zac(string2);
        this.zaaa = bl2;
        return this;
    }

    public final GoogleSignInOptions$Builder setAccountName(String string2) {
        Account account;
        string2 = Preconditions.checkNotEmpty(string2);
        this.zax = account = new Account(string2, "com.google");
        return this;
    }

    public final GoogleSignInOptions$Builder setHostedDomain(String string2) {
        this.zaac = string2 = Preconditions.checkNotEmpty(string2);
        return this;
    }
}

