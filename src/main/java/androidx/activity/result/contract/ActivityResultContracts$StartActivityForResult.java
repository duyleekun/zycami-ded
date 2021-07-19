/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContract;

public final class ActivityResultContracts$StartActivityForResult
extends ActivityResultContract {
    public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

    public Intent createIntent(Context context, Intent intent) {
        return intent;
    }

    public ActivityResult parseResult(int n10, Intent intent) {
        ActivityResult activityResult = new ActivityResult(n10, intent);
        return activityResult;
    }
}

