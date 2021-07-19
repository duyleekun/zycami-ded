/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteCallbackList
 *  android.os.RemoteException
 *  android.util.Log
 */
package androidx.room;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService$Stub;
import androidx.room.MultiInstanceInvalidationService;
import java.util.HashMap;

public class MultiInstanceInvalidationService$2
extends IMultiInstanceInvalidationService$Stub {
    public final /* synthetic */ MultiInstanceInvalidationService this$0;

    public MultiInstanceInvalidationService$2(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void broadcastInvalidation(int n10, String[] remoteCallbackList) {
        RemoteCallbackList remoteCallbackList2 = this.this$0.mCallbackList;
        synchronized (remoteCallbackList2) {
            Object object = this.this$0;
            object = ((MultiInstanceInvalidationService)object).mClientNames;
            Object object2 = n10;
            object = ((HashMap)object).get(object2);
            object = (String)object;
            if (object == null) {
                String string2 = "ROOM";
                remoteCallbackList = "Remote invalidation client ID not registered";
                Log.w((String)string2, (String)remoteCallbackList);
                return;
            }
            object2 = this.this$0;
            object2 = ((MultiInstanceInvalidationService)object2).mCallbackList;
            int n11 = object2.beginBroadcast();
            int n12 = 0;
            while (true) {
                if (n12 >= n11) {
                    MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
                    multiInstanceInvalidationService = multiInstanceInvalidationService.mCallbackList;
                    multiInstanceInvalidationService.finishBroadcast();
                    return;
                }
                try {
                    Object object3 = this.this$0;
                    object3 = ((MultiInstanceInvalidationService)object3).mCallbackList;
                    object3 = object3.getBroadcastCookie(n12);
                    object3 = (Integer)object3;
                    int n13 = (Integer)object3;
                    Object object4 = this.this$0;
                    object4 = object4.mClientNames;
                    Object object5 = n13;
                    object4 = ((HashMap)object4).get(object5);
                    object4 = (String)object4;
                    if (n10 != n13 && (n13 = (int)(((String)object).equals(object4) ? 1 : 0)) != 0) {
                        try {
                            object3 = this.this$0;
                            object3 = ((MultiInstanceInvalidationService)object3).mCallbackList;
                            object3 = object3.getBroadcastItem(n12);
                            object3 = (IMultiInstanceInvalidationCallback)object3;
                            object3.onInvalidation((String[])remoteCallbackList);
                        }
                        catch (RemoteException remoteException) {
                            object4 = "ROOM";
                            object5 = "Error invoking a remote callback";
                            Log.w((String)object4, (String)object5, (Throwable)remoteException);
                        }
                    }
                    ++n12;
                }
                catch (Throwable throwable) {
                    remoteCallbackList = this.this$0;
                    remoteCallbackList = remoteCallbackList.mCallbackList;
                    remoteCallbackList.finishBroadcast();
                    throw throwable;
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int registerCallback(IMultiInstanceInvalidationCallback object, String string2) {
        Integer n10 = null;
        if (string2 == null) {
            return 0;
        }
        RemoteCallbackList remoteCallbackList = this.this$0.mCallbackList;
        synchronized (remoteCallbackList) {
            int n11;
            int n12;
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            multiInstanceInvalidationService.mMaxClientId = n12 = multiInstanceInvalidationService.mMaxClientId + 1;
            multiInstanceInvalidationService = multiInstanceInvalidationService.mCallbackList;
            Integer n13 = n12;
            boolean bl2 = multiInstanceInvalidationService.register((IInterface)object, n13);
            if (bl2) {
                object = this.this$0;
                object = ((MultiInstanceInvalidationService)object).mClientNames;
                n10 = n12;
                ((HashMap)object).put(n10, string2);
                return n12;
            }
            object = this.this$0;
            ((MultiInstanceInvalidationService)object).mMaxClientId = n11 = ((MultiInstanceInvalidationService)object).mMaxClientId + -1;
            return 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterCallback(IMultiInstanceInvalidationCallback object, int n10) {
        RemoteCallbackList remoteCallbackList = this.this$0.mCallbackList;
        synchronized (remoteCallbackList) {
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            multiInstanceInvalidationService = multiInstanceInvalidationService.mCallbackList;
            multiInstanceInvalidationService.unregister((IInterface)object);
            object = this.this$0;
            object = ((MultiInstanceInvalidationService)object).mClientNames;
            Integer n11 = n10;
            ((HashMap)object).remove(n11);
            return;
        }
    }
}

