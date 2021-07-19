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
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;

public abstract class ActivityResultContract {
    public abstract Intent createIntent(Context var1, Object var2);

    public ActivityResultContract$SynchronousResult getSynchronousResult(Context context, Object object) {
        return null;
    }

    public abstract Object parseResult(int var1, Intent var2);
}

