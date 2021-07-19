/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.util.Log
 *  android.util.SparseArray
 */
package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver
extends BroadcastReceiver {
    private static final String EXTRA_WAKE_LOCK_ID = "androidx.contentpager.content.wakelockid";
    private static int mNextId;
    private static final SparseArray sActiveWakeLocks;

    static {
        SparseArray sparseArray;
        sActiveWakeLocks = sparseArray = new SparseArray();
        mNextId = 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean completeWakefulIntent(Intent object) {
        String string2 = EXTRA_WAKE_LOCK_ID;
        Object object2 = null;
        int n10 = object.getIntExtra(string2, 0);
        if (n10 == 0) {
            return false;
        }
        string2 = sActiveWakeLocks;
        synchronized (string2) {
            object2 = string2.get(n10);
            object2 = (PowerManager.WakeLock)object2;
            boolean bl2 = true;
            if (object2 != null) {
                object2.release();
                string2.remove(n10);
                return bl2;
            }
            object2 = "WakefulBroadcastReceiv.";
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "No active wake lock id #";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            object = stringBuilder.toString();
            Log.w((String)object2, (String)object);
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ComponentName startWakefulService(Context object, Intent intent) {
        SparseArray sparseArray = sActiveWakeLocks;
        synchronized (sparseArray) {
            int n10;
            int n11 = mNextId;
            mNextId = n10 = n11 + 1;
            int n12 = 1;
            if (n10 <= 0) {
                mNextId = n12;
            }
            CharSequence charSequence = EXTRA_WAKE_LOCK_ID;
            intent.putExtra((String)charSequence, n11);
            intent = object.startService(intent);
            if (intent == null) {
                return null;
            }
            charSequence = "power";
            object = object.getSystemService((String)charSequence);
            object = (PowerManager)object;
            charSequence = new StringBuilder();
            String string2 = "androidx.core:wake:";
            ((StringBuilder)charSequence).append(string2);
            string2 = intent.flattenToShortString();
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            object = object.newWakeLock(n12, (String)charSequence);
            n10 = 0;
            charSequence = null;
            object.setReferenceCounted(false);
            long l10 = 60000L;
            object.acquire(l10);
            sparseArray.put(n11, object);
            return intent;
        }
    }
}

