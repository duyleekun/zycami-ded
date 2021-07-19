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
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;

public class ActivityResultContracts$GetContent
extends ActivityResultContract {
    public Intent createIntent(Context context, String string2) {
        context = new Intent("android.intent.action.GET_CONTENT");
        return context.addCategory("android.intent.category.OPENABLE").setType(string2);
    }

    public final ActivityResultContract$SynchronousResult getSynchronousResult(Context context, String string2) {
        return null;
    }

    public final Uri parseResult(int n10, Intent intent) {
        int n11;
        if (intent != null && n10 == (n11 = -1)) {
            return intent.getData();
        }
        return null;
    }
}

