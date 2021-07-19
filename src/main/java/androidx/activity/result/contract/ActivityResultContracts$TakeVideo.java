/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Parcelable
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;

public class ActivityResultContracts$TakeVideo
extends ActivityResultContract {
    public Intent createIntent(Context context, Uri uri) {
        context = new Intent("android.media.action.VIDEO_CAPTURE");
        return context.putExtra("output", (Parcelable)uri);
    }

    public final ActivityResultContract$SynchronousResult getSynchronousResult(Context context, Uri uri) {
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

