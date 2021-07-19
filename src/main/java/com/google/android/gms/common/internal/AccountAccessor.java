/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Binder
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor$Stub;
import com.google.android.gms.common.internal.Preconditions;

public class AccountAccessor
extends IAccountAccessor$Stub {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Account getAccountBinderSafe(IAccountAccessor object) {
        block6: {
            if (object != null) {
                Throwable throwable2222222;
                long l10;
                block5: {
                    l10 = Binder.clearCallingIdentity();
                    object = object.zza();
                    {
                        catch (Throwable throwable2222222) {
                            break block5;
                        }
                        catch (RemoteException remoteException) {}
                        object = "AccountAccessor";
                        String string2 = "Remote account accessor probably died";
                        {
                            Log.w((String)object, (String)string2);
                        }
                        Binder.restoreCallingIdentity((long)l10);
                        break block6;
                    }
                    Binder.restoreCallingIdentity((long)l10);
                    return (Account)Preconditions.checkNotNull(object);
                }
                Binder.restoreCallingIdentity((long)l10);
                throw throwable2222222;
            }
        }
        object = null;
        return (Account)Preconditions.checkNotNull(object);
    }

    public boolean equals(Object object) {
        object = new NoSuchMethodError();
        throw object;
    }

    public final Account zza() {
        NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
        throw noSuchMethodError;
    }
}

