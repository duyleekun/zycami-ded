/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Intent
 *  android.content.IntentSender
 */
package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.result.IntentSenderRequest;

public final class IntentSenderRequest$Builder {
    private Intent mFillInIntent;
    private int mFlagsMask;
    private int mFlagsValues;
    private IntentSender mIntentSender;

    public IntentSenderRequest$Builder(PendingIntent pendingIntent) {
        pendingIntent = pendingIntent.getIntentSender();
        this((IntentSender)pendingIntent);
    }

    public IntentSenderRequest$Builder(IntentSender intentSender) {
        this.mIntentSender = intentSender;
    }

    public IntentSenderRequest build() {
        IntentSender intentSender = this.mIntentSender;
        Intent intent = this.mFillInIntent;
        int n10 = this.mFlagsMask;
        int n11 = this.mFlagsValues;
        IntentSenderRequest intentSenderRequest = new IntentSenderRequest(intentSender, intent, n10, n11);
        return intentSenderRequest;
    }

    public IntentSenderRequest$Builder setFillInIntent(Intent intent) {
        this.mFillInIntent = intent;
        return this;
    }

    public IntentSenderRequest$Builder setFlags(int n10, int n11) {
        this.mFlagsValues = n10;
        this.mFlagsMask = n11;
        return this;
    }
}

