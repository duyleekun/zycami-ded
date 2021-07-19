/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.accounts.AccountManager
 *  android.accounts.AuthenticatorException
 *  android.accounts.OperationCanceledException
 *  android.content.Context
 */
package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgf;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzam
extends zzgf {
    private long zza;
    private String zzb;
    private AccountManager zzc;
    private Boolean zzd;
    private long zze;

    public zzam(zzfl zzfl2) {
        super(zzfl2);
    }

    public final boolean zza() {
        long l10;
        Object object = Calendar.getInstance();
        Object object2 = TimeUnit.MINUTES;
        int n10 = ((Calendar)object).get(15);
        int n11 = ((Calendar)object).get(16);
        long l11 = n10 + n11;
        object = TimeUnit.MILLISECONDS;
        this.zza = l10 = ((TimeUnit)((Object)object2)).convert(l11, (TimeUnit)((Object)object));
        object = Locale.getDefault();
        object2 = ((Locale)object).getLanguage();
        Locale locale = Locale.ENGLISH;
        object2 = ((String)object2).toLowerCase(locale);
        object = ((Locale)object).getCountry().toLowerCase(locale);
        n10 = String.valueOf(object2).length();
        int n12 = String.valueOf(object).length();
        n10 = n10 + 1 + n12;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append((String)object2);
        stringBuilder.append("-");
        stringBuilder.append((String)object);
        this.zzb = object = stringBuilder.toString();
        return false;
    }

    public final long zzb() {
        this.zzv();
        return this.zza;
    }

    public final String zzc() {
        this.zzv();
        return this.zzb;
    }

    public final long zzd() {
        this.zzg();
        return this.zze;
    }

    public final void zze() {
        this.zzg();
        this.zzd = null;
        this.zze = 0L;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean zzf() {
        AccountManager accountManager;
        Boolean bl2 = Boolean.TRUE;
        Account[] accountArray = "com.google";
        Boolean bl3 = Boolean.FALSE;
        this.zzg();
        Clock clock = this.zzx.zzax();
        long l10 = clock.currentTimeMillis();
        long l11 = this.zze;
        l11 = l10 - l11;
        long l12 = 86400000L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 > 0) {
            this.zzd = null;
        }
        if ((accountManager = this.zzd) == null) {
            block24: {
                void var1_5;
                boolean bl4;
                block23: {
                    accountManager = this.zzx.zzaw();
                    l13 = ContextCompat.checkSelfPermission((Context)accountManager, "android.permission.GET_ACCOUNTS");
                    if (l13 != false) {
                        this.zzx.zzat().zzf().zza("Permission error checking for dasher/unicorn accounts");
                        this.zze = l10;
                        this.zzd = bl3;
                        return false;
                    }
                    accountManager = this.zzc;
                    if (accountManager == null) {
                        this.zzc = accountManager = AccountManager.get((Context)this.zzx.zzaw());
                    }
                    accountManager = this.zzc;
                    String[] stringArray = "service_HOSTED";
                    stringArray = new String[]{stringArray};
                    accountManager = accountManager.getAccountsByTypeAndFeatures((String)accountArray, stringArray, null, null);
                    accountManager = accountManager.getResult();
                    accountManager = accountManager;
                    bl4 = true;
                    if (accountManager == null) break block23;
                    l13 = ((Account[])accountManager).length;
                    if (l13 <= 0) break block23;
                    this.zzd = bl2;
                    this.zze = l10;
                    return bl4;
                }
                accountManager = this.zzc;
                String[] stringArray = "service_uca";
                stringArray = new String[]{stringArray};
                accountArray = accountManager.getAccountsByTypeAndFeatures((String)accountArray, stringArray, null, null);
                accountArray = accountArray.getResult();
                accountArray = accountArray;
                if (accountArray == null) break block24;
                int n10 = accountArray.length;
                if (n10 <= 0) break block24;
                this.zzd = bl2;
                try {
                    this.zze = l10;
                    return bl4;
                }
                catch (OperationCanceledException operationCanceledException) {
                }
                catch (IOException iOException) {
                }
                catch (AuthenticatorException authenticatorException) {
                    // empty catch block
                }
                accountArray = this.zzx.zzat().zzc();
                accountManager = "Exception checking account types";
                accountArray.zzb((String)accountManager, var1_5);
            }
            this.zze = l10;
            this.zzd = bl3;
            return false;
        }
        return accountManager.booleanValue();
    }
}

