/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.AccountPicker$AccountChooserOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;

public final class AccountPicker {
    private AccountPicker() {
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList arrayList, String[] stringArray, boolean bl2, String string2, String string3, String[] stringArray2, Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", (Serializable)arrayList);
        intent.putExtra("allowableAccountTypes", stringArray);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", (Parcelable)account);
        intent.putExtra("alwaysPromptForAccount", bl2);
        intent.putExtra("descriptionTextOverride", string2);
        intent.putExtra("authTokenType", string3);
        intent.putExtra("addAccountRequiredFeatures", stringArray2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", null);
        return intent;
    }

    public static Intent newChooseAccountIntent(AccountPicker$AccountChooserOptions object) {
        boolean bl2;
        Object object2;
        Object object3;
        Intent intent = new Intent();
        int n10 = AccountPicker$AccountChooserOptions.zza((AccountPicker$AccountChooserOptions)object);
        int n11 = 1;
        int n12 = 0;
        Object object4 = null;
        if (n10 == 0) {
            object3 = AccountPicker$AccountChooserOptions.zzb((AccountPicker$AccountChooserOptions)object);
            if (object3 == null) {
                n10 = n11;
            } else {
                n10 = 0;
                object3 = null;
            }
            object2 = "We only support hostedDomain filter for account chip styled account picker";
            Preconditions.checkArgument(n10 != 0, object2);
            object3 = AccountPicker$AccountChooserOptions.zzc((AccountPicker$AccountChooserOptions)object);
            if (object3 == null) {
                n10 = n11;
            } else {
                n10 = 0;
                object3 = null;
            }
            object2 = "Consent is only valid for account chip styled account picker";
            Preconditions.checkArgument(n10 != 0, object2);
        }
        object3 = (n10 = AccountPicker$AccountChooserOptions.zza((AccountPicker$AccountChooserOptions)object)) != 0 ? "com.google.android.gms.common.account.CHOOSE_ACCOUNT_USERTILE" : "com.google.android.gms.common.account.CHOOSE_ACCOUNT";
        intent.setAction((String)object3);
        intent.setPackage("com.google.android.gms");
        object3 = AccountPicker$AccountChooserOptions.zzd((AccountPicker$AccountChooserOptions)object);
        object2 = "allowableAccounts";
        intent.putExtra((String)object2, (Serializable)object3);
        object3 = AccountPicker$AccountChooserOptions.zze((AccountPicker$AccountChooserOptions)object);
        if (object3 != null) {
            object3 = AccountPicker$AccountChooserOptions.zze((AccountPicker$AccountChooserOptions)object);
            object2 = new String[]{};
            object3 = object3.toArray((T[])object2);
            object2 = "allowableAccountTypes";
            intent.putExtra((String)object2, (String[])object3);
        }
        object3 = AccountPicker$AccountChooserOptions.zzf((AccountPicker$AccountChooserOptions)object);
        intent.putExtra("addAccountOptions", (Bundle)object3);
        object3 = AccountPicker$AccountChooserOptions.zzg((AccountPicker$AccountChooserOptions)object);
        intent.putExtra("selectedAccount", (Parcelable)object3);
        n10 = AccountPicker$AccountChooserOptions.zzh((AccountPicker$AccountChooserOptions)object);
        intent.putExtra("alwaysPromptForAccount", n10 != 0);
        object3 = AccountPicker$AccountChooserOptions.zzi((AccountPicker$AccountChooserOptions)object);
        intent.putExtra("descriptionTextOverride", (String)object3);
        n10 = AccountPicker$AccountChooserOptions.zzj((AccountPicker$AccountChooserOptions)object);
        intent.putExtra("setGmsCoreAccount", n10 != 0);
        object3 = AccountPicker$AccountChooserOptions.zzk((AccountPicker$AccountChooserOptions)object);
        intent.putExtra("realClientPackage", (String)object3);
        n10 = AccountPicker$AccountChooserOptions.zzl((AccountPicker$AccountChooserOptions)object);
        object2 = "overrideTheme";
        intent.putExtra((String)object2, n10);
        n10 = (int)(AccountPicker$AccountChooserOptions.zza((AccountPicker$AccountChooserOptions)object) ? 1 : 0);
        if (n10 != 0) {
            n12 = 2;
        }
        intent.putExtra("overrideCustomTheme", n12);
        object3 = AccountPicker$AccountChooserOptions.zzb((AccountPicker$AccountChooserOptions)object);
        object4 = "hostedDomainFilter";
        intent.putExtra((String)object4, (String)object3);
        object3 = new Bundle();
        n12 = (int)(AccountPicker$AccountChooserOptions.zza((AccountPicker$AccountChooserOptions)object) ? 1 : 0);
        if (n12 != 0 && (n12 = (int)(TextUtils.isEmpty((CharSequence)(object4 = AccountPicker$AccountChooserOptions.zzi((AccountPicker$AccountChooserOptions)object))) ? 1 : 0)) == 0) {
            object4 = AccountPicker$AccountChooserOptions.zzi((AccountPicker$AccountChooserOptions)object);
            object2 = "title";
            object3.putString((String)object2, (String)object4);
        }
        if ((object4 = AccountPicker$AccountChooserOptions.zzc((AccountPicker$AccountChooserOptions)object)) != null) {
            object3.putBoolean("should_show_consent", n11 != 0);
            object2 = null;
            object3.putString("privacy_policy_url", null);
            object4 = "terms_of_service_url";
            object3.putString((String)object4, null);
        }
        if (bl2 = AccountPicker$AccountChooserOptions.zzm((AccountPicker$AccountChooserOptions)object)) {
            object = "exclude_add_account";
            object3.putBoolean((String)object, n11 != 0);
        }
        if (!(bl2 = object3.isEmpty())) {
            object = "first_party_options_bundle";
            intent.putExtra((String)object, (Bundle)object3);
        }
        return intent;
    }
}

