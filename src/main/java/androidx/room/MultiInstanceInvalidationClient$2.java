/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package androidx.room;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.room.IMultiInstanceInvalidationService$Stub;
import androidx.room.MultiInstanceInvalidationClient;
import java.util.concurrent.Executor;

public class MultiInstanceInvalidationClient$2
implements ServiceConnection {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$2(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onServiceConnected(ComponentName object, IBinder object2) {
        object = this.this$0;
        object2 = IMultiInstanceInvalidationService$Stub.asInterface((IBinder)object2);
        object.mService = object2;
        object = this.this$0;
        object2 = object.mExecutor;
        object = object.mSetUpRunnable;
        object2.execute((Runnable)object);
    }

    public void onServiceDisconnected(ComponentName object) {
        object = this.this$0;
        Executor executor = object.mExecutor;
        object = object.mRemoveObserverRunnable;
        executor.execute((Runnable)object);
        this.this$0.mService = null;
    }
}

