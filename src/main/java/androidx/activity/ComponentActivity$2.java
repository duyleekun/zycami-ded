/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.ComponentActivity;
import androidx.activity.ComponentActivity$2$1;
import androidx.activity.ComponentActivity$2$2;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

public class ComponentActivity$2
extends ActivityResultRegistry {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$2(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public void onLaunch(int n10, ActivityResultContract object, Object object2, ActivityOptionsCompat object3) {
        int n11;
        ComponentActivity componentActivity = this.this$0;
        Object object4 = ((ActivityResultContract)object).getSynchronousResult((Context)componentActivity, object2);
        if (object4 != null) {
            object2 = Looper.getMainLooper();
            object = new Handler((Looper)object2);
            object2 = new ComponentActivity$2$1(this, n10, (ActivityResultContract$SynchronousResult)object4);
            object.post((Runnable)object2);
            return;
        }
        object = ((ActivityResultContract)object).createIntent((Context)componentActivity, object2);
        boolean bl2 = false;
        object2 = null;
        object4 = object.getExtras();
        if (object4 != null && (object4 = object.getExtras().getClassLoader()) == null) {
            object4 = componentActivity.getClassLoader();
            object.setExtrasClassLoader((ClassLoader)object4);
        }
        if ((n11 = object.hasExtra((String)(object4 = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE"))) != 0) {
            object2 = object.getBundleExtra((String)object4);
            object.removeExtra((String)object4);
        } else if (object3 != null) {
            object2 = ((ActivityOptionsCompat)object3).toBundle();
        }
        Object object5 = object2;
        object2 = object.getAction();
        object3 = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        bl2 = ((String)object3).equals(object2);
        if (bl2) {
            object2 = "androidx.activity.result.contract.extra.PERMISSIONS";
            if ((object = object.getStringArrayExtra((String)object2)) == null) {
                object = new String[]{};
            }
            ActivityCompat.requestPermissions(componentActivity, (String[])object, n10);
        } else {
            object3 = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
            object2 = object.getAction();
            bl2 = ((String)object3).equals(object2);
            if (bl2) {
                object2 = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
                object = (IntentSenderRequest)object.getParcelableExtra((String)object2);
                object4 = ((IntentSenderRequest)object).getIntentSender();
                Intent intent = ((IntentSenderRequest)object).getFillInIntent();
                int n12 = ((IntentSenderRequest)object).getFlagsMask();
                int n13 = ((IntentSenderRequest)object).getFlagsValues();
                n11 = n10;
                try {
                    ActivityCompat.startIntentSenderForResult(componentActivity, (IntentSender)object4, n10, intent, n12, n13, 0, (Bundle)object5);
                }
                catch (IntentSender.SendIntentException sendIntentException) {
                    object3 = Looper.getMainLooper();
                    object2 = new Handler((Looper)object3);
                    object3 = new ComponentActivity$2$2(this, n10, sendIntentException);
                    object2.post((Runnable)object3);
                }
            } else {
                ActivityCompat.startActivityForResult(componentActivity, (Intent)object, n10, (Bundle)object5);
            }
        }
    }
}

