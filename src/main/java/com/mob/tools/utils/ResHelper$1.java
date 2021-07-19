/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 */
package com.mob.tools.utils;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.mob.tools.utils.ResHelper;

public final class ResHelper$1
implements MediaScannerConnection.OnScanCompletedListener {
    public final /* synthetic */ Object val$object;

    public ResHelper$1(Object object) {
        this.val$object = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onScanCompleted(String object, Uri object2) {
        ResHelper.access$002((Uri)object2);
        object = this.val$object;
        synchronized (object) {
            object2 = this.val$object;
            object2.notifyAll();
            return;
        }
    }
}

