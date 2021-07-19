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
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.core.content.ContextCompat;

public final class ActivityResultContracts$RequestPermission
extends ActivityResultContract {
    public Intent createIntent(Context stringArray, String string2) {
        stringArray = new String[]{string2};
        return ActivityResultContracts$RequestMultiplePermissions.createIntent(stringArray);
    }

    public ActivityResultContract$SynchronousResult getSynchronousResult(Context object, String object2) {
        if (object2 == null) {
            object2 = Boolean.FALSE;
            object = new ActivityResultContract$SynchronousResult(object2);
            return object;
        }
        int n10 = ContextCompat.checkSelfPermission(object, (String)object2);
        if (n10 == 0) {
            object2 = Boolean.TRUE;
            object = new ActivityResultContract$SynchronousResult(object2);
            return object;
        }
        return null;
    }

    public Boolean parseResult(int n10, Intent intent) {
        boolean bl2;
        int[] nArray;
        int n11;
        Boolean bl3 = Boolean.FALSE;
        if (intent != null && n10 == (n11 = -1) && (nArray = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS")) != null && (bl2 = nArray.length)) {
            bl2 = false;
            intent = null;
            n10 = nArray[0];
            if (n10 == 0) {
                bl2 = true;
            }
            return bl2;
        }
        return bl3;
    }
}

