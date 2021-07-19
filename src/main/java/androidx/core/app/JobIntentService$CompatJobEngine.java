/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 */
package androidx.core.app;

import android.os.IBinder;
import androidx.core.app.JobIntentService$GenericWorkItem;

public interface JobIntentService$CompatJobEngine {
    public IBinder compatGetBinder();

    public JobIntentService$GenericWorkItem dequeueWork();
}

