/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity.result;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;

public interface ActivityResultCaller {
    public ActivityResultLauncher registerForActivityResult(ActivityResultContract var1, ActivityResultCallback var2);

    public ActivityResultLauncher registerForActivityResult(ActivityResultContract var1, ActivityResultRegistry var2, ActivityResultCallback var3);
}

