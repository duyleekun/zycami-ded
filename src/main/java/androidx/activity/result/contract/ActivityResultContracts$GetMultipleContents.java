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
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class ActivityResultContracts$GetMultipleContents
extends ActivityResultContract {
    public static List getClipDataUris(Intent object) {
        int n10;
        LinkedHashSet<Uri> linkedHashSet = new LinkedHashSet<Uri>();
        Uri uri = object.getData();
        if (uri != null) {
            uri = object.getData();
            linkedHashSet.add(uri);
        }
        if ((object = object.getClipData()) == null && (n10 = linkedHashSet.isEmpty()) != 0) {
            return Collections.emptyList();
        }
        if (object != null) {
            int n11;
            uri = null;
            for (n10 = 0; n10 < (n11 = object.getItemCount()); ++n10) {
                Uri uri2 = object.getItemAt(n10).getUri();
                if (uri2 == null) continue;
                linkedHashSet.add(uri2);
            }
        }
        object = new ArrayList(linkedHashSet);
        return object;
    }

    public Intent createIntent(Context context, String string2) {
        context = new Intent("android.intent.action.GET_CONTENT");
        return context.addCategory("android.intent.category.OPENABLE").setType(string2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    }

    public final ActivityResultContract$SynchronousResult getSynchronousResult(Context context, String string2) {
        return null;
    }

    public final List parseResult(int n10, Intent intent) {
        int n11;
        if (intent != null && n10 == (n11 = -1)) {
            return ActivityResultContracts$GetMultipleContents.getClipDataUris(intent);
        }
        return Collections.emptyList();
    }
}

