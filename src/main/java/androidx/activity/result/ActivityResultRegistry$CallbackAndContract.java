/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity.result;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;

public class ActivityResultRegistry$CallbackAndContract {
    public final ActivityResultCallback mCallback;
    public final ActivityResultContract mContract;

    public ActivityResultRegistry$CallbackAndContract(ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
        this.mCallback = activityResultCallback;
        this.mContract = activityResultContract;
    }
}

