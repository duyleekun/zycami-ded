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
import androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents;
import java.util.Collections;
import java.util.List;

public class ActivityResultContracts$OpenMultipleDocuments
extends ActivityResultContract {
    public Intent createIntent(Context context, String[] stringArray) {
        context = new Intent("android.intent.action.OPEN_DOCUMENT");
        return context.putExtra("android.intent.extra.MIME_TYPES", stringArray).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
    }

    public final ActivityResultContract$SynchronousResult getSynchronousResult(Context context, String[] stringArray) {
        return null;
    }

    public final List parseResult(int n10, Intent intent) {
        int n11 = -1;
        if (n10 == n11 && intent != null) {
            return ActivityResultContracts$GetMultipleContents.getClipDataUris(intent);
        }
        return Collections.emptyList();
    }
}

