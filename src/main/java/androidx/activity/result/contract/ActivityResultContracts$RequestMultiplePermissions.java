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
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.util.Collections;
import java.util.Map;

public final class ActivityResultContracts$RequestMultiplePermissions
extends ActivityResultContract {
    public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
    public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
    public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

    public static Intent createIntent(String[] stringArray) {
        Intent intent = new Intent(ACTION_REQUEST_PERMISSIONS);
        return intent.putExtra(EXTRA_PERMISSIONS, stringArray);
    }

    public Intent createIntent(Context context, String[] stringArray) {
        return ActivityResultContracts$RequestMultiplePermissions.createIntent(stringArray);
    }

    public ActivityResultContract$SynchronousResult getSynchronousResult(Context object, String[] object2) {
        int n10;
        if (object2 != null && (n10 = ((String[])object2).length) != 0) {
            ArrayMap arrayMap = new ArrayMap();
            int n11 = ((String[])object2).length;
            int n12 = 1;
            int n13 = n12;
            for (int i10 = 0; i10 < n11; ++i10) {
                String string2 = object2[i10];
                int n14 = ContextCompat.checkSelfPermission(object, string2);
                n14 = n14 == 0 ? n12 : 0;
                Boolean bl2 = n14 != 0;
                arrayMap.put(string2, bl2);
                if (n14) continue;
                n13 = 0;
            }
            if (n13) {
                object = new ActivityResultContract$SynchronousResult(arrayMap);
                return object;
            }
            return null;
        }
        object2 = Collections.emptyMap();
        object = new ActivityResultContract$SynchronousResult(object2);
        return object;
    }

    public Map parseResult(int n10, Intent object) {
        int n11 = -1;
        if (n10 != n11) {
            return Collections.emptyMap();
        }
        if (object == null) {
            return Collections.emptyMap();
        }
        String[] stringArray = object.getStringArrayExtra(EXTRA_PERMISSIONS);
        Object object2 = EXTRA_PERMISSION_GRANT_RESULTS;
        if ((object = (Object)object.getIntArrayExtra((String)object2)) != null && stringArray != null) {
            object2 = new Object();
            int n12 = stringArray.length;
            for (int i10 = 0; i10 < n12; ++i10) {
                Boolean bl2;
                String string2 = stringArray[i10];
                Object object3 = object[i10];
                if (object3 == false) {
                    object3 = true;
                } else {
                    object3 = false;
                    bl2 = null;
                }
                bl2 = (boolean)object3;
                object2.put(string2, bl2);
            }
            return object2;
        }
        return Collections.emptyMap();
    }
}

