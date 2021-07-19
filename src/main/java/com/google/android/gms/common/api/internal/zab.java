/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.os.TransactionTooLargeException
 */
package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.zaab;
import com.google.android.gms.common.util.PlatformVersion;

public abstract class zab {
    private final int type;

    public zab(int n10) {
        this.type = n10;
    }

    private static Status zaa(RemoteException object) {
        CharSequence charSequence = new StringBuilder();
        boolean bl2 = PlatformVersion.isAtLeastIceCreamSandwichMR1();
        if (bl2 && (bl2 = object instanceof TransactionTooLargeException)) {
            String string2 = "TransactionTooLargeException: ";
            charSequence.append(string2);
        }
        object = object.getLocalizedMessage();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        object = new Status(8, (String)charSequence);
        return object;
    }

    public static /* synthetic */ Status zab(RemoteException remoteException) {
        return zab.zaa(remoteException);
    }

    public abstract void zaa(Status var1);

    public abstract void zaa(GoogleApiManager$zaa var1);

    public abstract void zaa(zaab var1, boolean var2);

    public abstract void zaa(RuntimeException var1);
}

