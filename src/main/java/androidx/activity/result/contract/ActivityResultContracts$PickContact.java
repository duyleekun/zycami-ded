/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;

public final class ActivityResultContracts$PickContact
extends ActivityResultContract {
    public Intent createIntent(Context context, Void void_) {
        context = new Intent("android.intent.action.PICK");
        return context.setType("vnd.android.cursor.dir/contact");
    }

    public Uri parseResult(int n10, Intent intent) {
        int n11;
        if (intent != null && n10 == (n11 = -1)) {
            return intent.getData();
        }
        return null;
    }
}

