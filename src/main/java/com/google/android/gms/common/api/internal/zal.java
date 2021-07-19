/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zam;
import com.google.android.gms.common.api.internal.zan;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zal
extends LifecycleCallback
implements DialogInterface.OnCancelListener {
    public volatile boolean mStarted;
    public final GoogleApiAvailability zacd;
    public final AtomicReference zadf;
    private final Handler zadg;

    public zal(LifecycleFragment lifecycleFragment) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        this(lifecycleFragment, googleApiAvailability);
    }

    private zal(LifecycleFragment object, GoogleApiAvailability googleApiAvailability) {
        super((LifecycleFragment)object);
        this.zadf = object = new Object(null);
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.zadg = object;
        this.zacd = googleApiAvailability;
    }

    private static int zaa(zam zam2) {
        if (zam2 == null) {
            return -1;
        }
        return zam2.zar();
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        Object object2;
        int n12;
        Object object3;
        block13: {
            block12: {
                block11: {
                    int n13;
                    object3 = (zam)this.zadf.get();
                    n12 = 1;
                    if (n10 == n12) break block11;
                    n11 = 2;
                    if (n10 != n11) break block12;
                    object2 = this.zacd;
                    Object object4 = this.getActivity();
                    n10 = ((GoogleApiAvailability)object2).isGooglePlayServicesAvailable((Context)object4);
                    if (n10 != 0) {
                        n12 = 0;
                    }
                    if (object3 == null) {
                        return;
                    }
                    object4 = ((zam)object3).getConnectionResult();
                    n11 = ((ConnectionResult)object4).getErrorCode();
                    if (n11 == (n13 = 18) && n10 == n13) {
                        return;
                    }
                    break block13;
                }
                n10 = -1;
                if (n11 == n10) break block13;
                if (n11 == 0) {
                    Object object5;
                    n10 = 13;
                    if (object != null) {
                        object5 = "<<ResolutionFailureErrorDetail>>";
                        n10 = object.getIntExtra((String)object5, n10);
                    }
                    n12 = 0;
                    object = new ConnectionResult(n10, null);
                    n10 = zal.zaa((zam)object3);
                    object5 = new zam((ConnectionResult)object, n10);
                    object2 = this.zadf;
                    ((AtomicReference)object2).set(object5);
                    object3 = object5;
                }
            }
            n12 = 0;
        }
        if (n12 != 0) {
            this.zaq();
            return;
        }
        if (object3 != null) {
            object2 = ((zam)object3).getConnectionResult();
            n11 = ((zam)object3).zar();
            this.zaa((ConnectionResult)object2, n11);
        }
    }

    public void onCancel(DialogInterface object) {
        object = new ConnectionResult(13, null);
        int n10 = zal.zaa((zam)this.zadf.get());
        this.zaa((ConnectionResult)object, n10);
        this.zaq();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            AtomicReference atomicReference = this.zadf;
            ConnectionResult connectionResult = null;
            Object object = "resolving_error";
            boolean bl2 = bundle.getBoolean((String)object, false);
            if (bl2) {
                int n10 = bundle.getInt("failed_status");
                Object object2 = (PendingIntent)bundle.getParcelable("failed_resolution");
                connectionResult = new ConnectionResult(n10, (PendingIntent)object2);
                n10 = -1;
                object2 = "failed_client_id";
                int n11 = bundle.getInt((String)object2, n10);
                object = new zam(connectionResult, n11);
            } else {
                boolean bl3 = false;
                object = null;
            }
            atomicReference.set(object);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zam2 = (zam)this.zadf.get();
        if (zam2 != null) {
            bundle.putBoolean("resolving_error", true);
            int n10 = zam2.zar();
            bundle.putInt("failed_client_id", n10);
            n10 = zam2.getConnectionResult().getErrorCode();
            String string2 = "failed_status";
            bundle.putInt(string2, n10);
            zam2 = zam2.getConnectionResult().getResolution();
            String string3 = "failed_resolution";
            bundle.putParcelable(string3, (Parcelable)zam2);
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    public abstract void zaa(ConnectionResult var1, int var2);

    public final void zab(ConnectionResult object, int n10) {
        zam zam2 = new zam((ConnectionResult)object, n10);
        object = this.zadf;
        n10 = 0;
        zan zan2 = null;
        boolean bl2 = ((AtomicReference)object).compareAndSet(null, zam2);
        if (bl2) {
            object = this.zadg;
            zan2 = new zan(this, zam2);
            object.post((Runnable)zan2);
        }
    }

    public abstract void zao();

    public final void zaq() {
        this.zadf.set(null);
        this.zao();
    }
}

