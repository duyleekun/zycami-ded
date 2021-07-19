/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.os.Parcelable
 *  android.util.Log
 */
package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.IntentSenderRequest$Builder;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.fragment.app.FragmentManager;

public class FragmentManager$FragmentIntentSenderContract
extends ActivityResultContract {
    public Intent createIntent(Context context, IntentSenderRequest object) {
        int n10;
        String string2;
        Object object2;
        context = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
        Object object3 = ((IntentSenderRequest)object).getFillInIntent();
        if (object3 != null && (object2 = object3.getBundleExtra(string2 = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
            context.putExtra(string2, object2);
            object3.removeExtra(string2);
            int n11 = 0;
            string2 = null;
            object2 = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
            boolean bl2 = object3.getBooleanExtra((String)object2, false);
            if (bl2) {
                string2 = ((IntentSenderRequest)object).getIntentSender();
                object3 = new IntentSenderRequest$Builder((IntentSender)string2);
                string2 = null;
                object3 = ((IntentSenderRequest$Builder)object3).setFillInIntent(null);
                n11 = ((IntentSenderRequest)object).getFlagsValues();
                n10 = ((IntentSenderRequest)object).getFlagsMask();
                object = ((IntentSenderRequest$Builder)object3).setFlags(n11, n10).build();
            }
        }
        object3 = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        context.putExtra((String)object3, (Parcelable)object);
        n10 = FragmentManager.isLoggingEnabled(2);
        if (n10 != 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("CreateIntent created the following intent: ");
            ((StringBuilder)object).append(context);
            object = ((StringBuilder)object).toString();
            object3 = "FragmentManager";
            Log.v((String)object3, (String)object);
        }
        return context;
    }

    public ActivityResult parseResult(int n10, Intent intent) {
        ActivityResult activityResult = new ActivityResult(n10, intent);
        return activityResult;
    }
}

