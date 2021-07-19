/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseArray
 */
package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zaj$zaa;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.api.internal.zam;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zaj
extends zal {
    private final SparseArray zacw;

    private zaj(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        super();
        this.zacw = lifecycleFragment;
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zaj zaa(LifecycleActivity object) {
        String string2;
        zaj zaj2 = (zaj)(object = LifecycleCallback.getFragment((LifecycleActivity)object)).getCallbackOrNull(string2 = "AutoManageHelper", zaj.class);
        if (zaj2 != null) {
            return zaj2;
        }
        zaj2 = new zaj((LifecycleFragment)object);
        return zaj2;
    }

    private final zaj$zaa zab(int n10) {
        SparseArray sparseArray = this.zacw;
        int n11 = sparseArray.size();
        if (n11 <= n10) {
            return null;
        }
        sparseArray = this.zacw;
        n10 = sparseArray.keyAt(n10);
        return (zaj$zaa)sparseArray.get(n10);
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.zacw).size()); ++i10) {
            object = this.zab(i10);
            if (object == null) continue;
            Object object2 = printWriter.append(string2).append("GoogleApiClient #");
            int n11 = ((zaj$zaa)object).zacx;
            ((PrintWriter)object2).print(n11);
            printWriter.println(":");
            object = ((zaj$zaa)object).zacy;
            object2 = String.valueOf(string2);
            String string3 = "  ";
            object2 = ((String)object2).concat(string3);
            ((GoogleApiClient)object).dump((String)object2, fileDescriptor, printWriter, stringArray);
        }
    }

    public void onStart() {
        super.onStart();
        int n10 = this.mStarted;
        Object object = String.valueOf(this.zacw);
        int n11 = String.valueOf(object).length() + 14;
        StringBuilder stringBuilder = new StringBuilder(n11);
        String string2 = "onStart ";
        stringBuilder.append(string2);
        stringBuilder.append(n10 != 0);
        stringBuilder.append(" ");
        stringBuilder.append((String)object);
        String string3 = stringBuilder.toString();
        object = "AutoManageHelper";
        Log.d((String)object, (String)string3);
        string3 = this.zadf.get();
        if (string3 == null) {
            int n12;
            string3 = null;
            for (n10 = 0; n10 < (n12 = (object = this.zacw).size()); ++n10) {
                object = this.zab(n10);
                if (object == null) continue;
                object = ((zaj$zaa)object).zacy;
                ((GoogleApiClient)object).connect();
            }
        }
    }

    public void onStop() {
        Object object;
        int n10;
        super.onStop();
        for (int i10 = 0; i10 < (n10 = (object = this.zacw).size()); ++i10) {
            object = this.zab(i10);
            if (object == null) continue;
            object = ((zaj$zaa)object).zacy;
            ((GoogleApiClient)object).disconnect();
        }
    }

    public final void zaa(int n10) {
        zaj$zaa zaj$zaa = (zaj$zaa)this.zacw.get(n10);
        SparseArray sparseArray = this.zacw;
        sparseArray.remove(n10);
        if (zaj$zaa != null) {
            zaj$zaa.zacy.unregisterConnectionFailedListener(zaj$zaa);
            GoogleApiClient googleApiClient = zaj$zaa.zacy;
            googleApiClient.disconnect();
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void zaa(int n10, GoogleApiClient googleApiClient, GoogleApiClient$OnConnectionFailedListener object) {
        void var5_8;
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        Object object2 = this.zacw;
        int bl2 = object2.indexOfKey(n10);
        if (bl2 < 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object2 = null;
        }
        CharSequence charSequence = new StringBuilder(54);
        charSequence.append("Already managing a GoogleApiClient with id ");
        charSequence.append(n10);
        Object object3 = charSequence.toString();
        Preconditions.checkState((boolean)var5_8, object3);
        object2 = (zam)this.zadf.get();
        boolean bl5 = this.mStarted;
        charSequence = String.valueOf(object2);
        int n11 = String.valueOf(charSequence).length() + 49;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append("starting AutoManage for client ");
        stringBuilder.append(n10);
        String string2 = " ";
        stringBuilder.append(string2);
        stringBuilder.append(bl5);
        stringBuilder.append(string2);
        stringBuilder.append((String)charSequence);
        object3 = stringBuilder.toString();
        charSequence = "AutoManageHelper";
        Log.d((String)charSequence, (String)object3);
        object3 = new zaj$zaa(this, n10, googleApiClient, (GoogleApiClient$OnConnectionFailedListener)object);
        object = this.zacw;
        object.put(n10, object3);
        n10 = (int)(this.mStarted ? 1 : 0);
        if (n10 != 0 && object2 == null) {
            String string3 = String.valueOf(googleApiClient);
            int n12 = String.valueOf(string3).length() + 11;
            object2 = new StringBuilder(n12);
            object = "connecting ";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            Log.d((String)charSequence, (String)string3);
            googleApiClient.connect();
        }
    }

    public final void zaa(ConnectionResult object, int n10) {
        Object object2 = "AutoManageHelper";
        String string2 = "Unresolved error while connecting client. Stopping auto-manage.";
        Log.w((String)object2, (String)string2);
        if (n10 < 0) {
            object = new Exception();
            Log.wtf((String)object2, (String)"AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", (Throwable)object);
            return;
        }
        object2 = (zaj$zaa)this.zacw.get(n10);
        if (object2 != null) {
            this.zaa(n10);
            GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener = ((zaj$zaa)object2).zacz;
            if (googleApiClient$OnConnectionFailedListener != null) {
                googleApiClient$OnConnectionFailedListener.onConnectionFailed((ConnectionResult)object);
            }
        }
    }

    public final void zao() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.zacw).size()); ++i10) {
            object = this.zab(i10);
            if (object == null) continue;
            object = ((zaj$zaa)object).zacy;
            ((GoogleApiClient)object).connect();
        }
    }
}

