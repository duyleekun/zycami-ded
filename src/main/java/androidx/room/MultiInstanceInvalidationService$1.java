/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteCallbackList
 */
package androidx.room;

import android.os.RemoteCallbackList;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.MultiInstanceInvalidationService;
import java.util.HashMap;

public class MultiInstanceInvalidationService$1
extends RemoteCallbackList {
    public final /* synthetic */ MultiInstanceInvalidationService this$0;

    public MultiInstanceInvalidationService$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    public void onCallbackDied(IMultiInstanceInvalidationCallback object, Object object2) {
        object = this.this$0.mClientNames;
        object2 = (int)((Integer)object2);
        ((HashMap)object).remove(object2);
    }
}

