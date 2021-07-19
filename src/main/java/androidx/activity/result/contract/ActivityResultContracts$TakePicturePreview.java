/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;

public class ActivityResultContracts$TakePicturePreview
extends ActivityResultContract {
    public Intent createIntent(Context context, Void void_) {
        context = new Intent("android.media.action.IMAGE_CAPTURE");
        return context;
    }

    public final ActivityResultContract$SynchronousResult getSynchronousResult(Context context, Void void_) {
        return null;
    }

    public final Bitmap parseResult(int n10, Intent intent) {
        int n11;
        if (intent != null && n10 == (n11 = -1)) {
            return (Bitmap)intent.getParcelableExtra("data");
        }
        return null;
    }
}

