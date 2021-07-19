/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.IntentSender$SendIntentException
 */
package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.ComponentActivity$2;
import java.io.Serializable;

public class ComponentActivity$2$2
implements Runnable {
    public final /* synthetic */ ComponentActivity$2 this$1;
    public final /* synthetic */ IntentSender.SendIntentException val$e;
    public final /* synthetic */ int val$requestCode;

    public ComponentActivity$2$2(ComponentActivity$2 componentActivity$2, int n10, IntentSender.SendIntentException sendIntentException) {
        this.this$1 = componentActivity$2;
        this.val$requestCode = n10;
        this.val$e = sendIntentException;
    }

    public void run() {
        ComponentActivity$2 componentActivity$2 = this.this$1;
        int n10 = this.val$requestCode;
        Intent intent = new Intent();
        intent = intent.setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
        IntentSender.SendIntentException sendIntentException = this.val$e;
        intent = intent.putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (Serializable)sendIntentException);
        componentActivity$2.dispatchResult(n10, 0, intent);
    }
}

