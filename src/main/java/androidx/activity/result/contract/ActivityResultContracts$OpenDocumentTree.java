/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContract$SynchronousResult;

public class ActivityResultContracts$OpenDocumentTree
extends ActivityResultContract {
    public Intent createIntent(Context context, Uri uri) {
        String string2 = "android.intent.action.OPEN_DOCUMENT_TREE";
        context = new Intent(string2);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11 && uri != null) {
            string2 = "android.provider.extra.INITIAL_URI";
            context.putExtra(string2, (Parcelable)uri);
        }
        return context;
    }

    public final ActivityResultContract$SynchronousResult getSynchronousResult(Context context, Uri uri) {
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

