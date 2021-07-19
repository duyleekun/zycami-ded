/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 */
package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;

public class ProxyBillingActivity
extends Activity {
    private ResultReceiver a;

    public void onActivityResult(int n10, int n11, Intent object) {
        super.onActivityResult(n10, n11, (Intent)object);
        String string2 = "ProxyBillingActivity";
        int n12 = 100;
        if (n10 == n12) {
            Object object2;
            n10 = zzb.zza((Intent)object, string2);
            n12 = -1;
            if (n11 != n12 || n10 != 0) {
                n12 = 85;
                StringBuilder stringBuilder = new StringBuilder(n12);
                String string3 = "Activity finished with resultCode ";
                stringBuilder.append(string3);
                stringBuilder.append(n11);
                stringBuilder.append(" and billing's responseCode: ");
                stringBuilder.append(n10);
                object2 = stringBuilder.toString();
                zzb.zzb(string2, (String)object2);
            }
            object2 = this.a;
            object = object == null ? null : object.getExtras();
            object2.send(n10, (Bundle)object);
        } else {
            n11 = 69;
            object = new StringBuilder(n11);
            String string4 = "Got onActivityResult with wrong requestCode: ";
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append("; skipping...");
            String string5 = ((StringBuilder)object).toString();
            zzb.zzb(string2, string5);
        }
        this.finish();
    }

    public void onCreate(Bundle object) {
        super.onCreate(object);
        String string2 = "result_receiver";
        String string3 = "ProxyBillingActivity";
        if (object == null) {
            Object object2;
            int n10;
            IntentSender intentSender;
            zzb.zza(string3, "Launching Play Store billing flow");
            object = (ResultReceiver)this.getIntent().getParcelableExtra(string2);
            this.a = object;
            object = this.getIntent();
            string2 = "BUY_INTENT";
            boolean bl2 = object.hasExtra(string2);
            if (bl2) {
                object = (PendingIntent)this.getIntent().getParcelableExtra(string2);
            } else {
                object = this.getIntent();
                bl2 = object.hasExtra(string2 = "SUBS_MANAGEMENT_INTENT");
                if (bl2) {
                    object = (PendingIntent)this.getIntent().getParcelableExtra(string2);
                } else {
                    bl2 = false;
                    object = null;
                }
            }
            try {
                intentSender = object.getIntentSender();
                n10 = 100;
            }
            catch (IntentSender.SendIntentException sendIntentException) {
                object = String.valueOf((Object)sendIntentException);
                int n11 = String.valueOf(object).length() + 53;
                object2 = new StringBuilder(n11);
                ((StringBuilder)object2).append("Got exception while trying to start a purchase flow: ");
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                zzb.zzb(string3, (String)object);
                this.a.send(6, null);
                this.finish();
                return;
            }
            Intent intent = new Intent();
            object2 = this;
            this.startIntentSenderForResult(intentSender, n10, intent, 0, 0, 0);
            return;
        }
        zzb.zza(string3, "Launching Play Store billing flow from savedInstanceState");
        object = (ResultReceiver)object.getParcelable(string2);
        this.a = object;
    }

    public void onSaveInstanceState(Bundle bundle) {
        ResultReceiver resultReceiver = this.a;
        bundle.putParcelable("result_receiver", (Parcelable)resultReceiver);
    }
}

