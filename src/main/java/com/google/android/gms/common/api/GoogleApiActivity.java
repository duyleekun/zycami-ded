/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 */
package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.GoogleApiManager;

public class GoogleApiActivity
extends Activity
implements DialogInterface.OnCancelListener {
    private int zabp = 0;

    public static PendingIntent zaa(Context context, PendingIntent pendingIntent, int n10) {
        pendingIntent = GoogleApiActivity.zaa(context, pendingIntent, n10, true);
        return PendingIntent.getActivity((Context)context, (int)0, (Intent)pendingIntent, (int)0x8000000);
    }

    public static Intent zaa(Context context, PendingIntent pendingIntent, int n10, boolean bl2) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", (Parcelable)pendingIntent);
        intent.putExtra("failing_client_id", n10);
        intent.putExtra("notify_manager", bl2);
        return intent;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        int n12 = 0;
        Intent intent2 = null;
        int n13 = 1;
        if (n10 == n13) {
            Object object = this.getIntent();
            String string2 = "notify_manager";
            n10 = (int)(object.getBooleanExtra(string2, n13 != 0) ? 1 : 0);
            this.zabp = 0;
            this.setResult(n11, intent);
            if (n10 != 0) {
                object = GoogleApiManager.zab((Context)this);
                int n14 = -1;
                if (n11 != n14) {
                    if (n11 == 0) {
                        n12 = 13;
                        n13 = 0;
                        ConnectionResult connectionResult = new ConnectionResult(n12, null);
                        intent2 = this.getIntent();
                        String string3 = "failing_client_id";
                        n14 = intent2.getIntExtra(string3, n14);
                        ((GoogleApiManager)object).zaa(connectionResult, n14);
                    }
                } else {
                    ((GoogleApiManager)object).zao();
                }
            }
        } else {
            n13 = 2;
            if (n10 == n13) {
                this.zabp = 0;
                this.setResult(n11, intent);
            }
        }
        this.finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.zabp = 0;
        this.setResult(0);
        this.finish();
    }

    public void onCreate(Bundle object) {
        int n10;
        int n11;
        super.onCreate((Bundle)object);
        if (object != null) {
            String string2 = "resolution";
            this.zabp = n11 = object.getInt(string2);
        }
        if ((n11 = this.zabp) != (n10 = 1)) {
            object = this.getIntent().getExtras();
            Object object2 = "GoogleApiActivity";
            if (object == null) {
                Log.e((String)object2, (String)"Activity started without extras");
                this.finish();
                return;
            }
            Object object3 = (PendingIntent)object.get("pending_intent");
            String string3 = "error_code";
            object = (Integer)object.get(string3);
            if (object3 == null && object == null) {
                Log.e((String)object2, (String)"Activity started without resolution");
                this.finish();
                return;
            }
            if (object3 != null) {
                int n12;
                try {
                    string3 = object3.getIntentSender();
                    n12 = 1;
                    object3 = this;
                }
                catch (IntentSender.SendIntentException sendIntentException) {
                    Log.e((String)object2, (String)"Failed to launch pendingIntent", (Throwable)sendIntentException);
                    this.finish();
                    return;
                }
                this.startIntentSenderForResult((IntentSender)string3, n12, null, 0, 0, 0);
                this.zabp = n10;
                return;
            }
            object2 = GoogleApiAvailability.getInstance();
            n11 = (Integer)object;
            int n13 = 2;
            ((GoogleApiAvailability)object2).showErrorDialogFragment(this, n11, n13, this);
            this.zabp = n10;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        int n10 = this.zabp;
        bundle.putInt("resolution", n10);
        super.onSaveInstanceState(bundle);
    }
}

