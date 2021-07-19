/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache$MethodReference;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassesInfoCache$CallbackInfo {
    public final Map mEventToHandlers;
    public final Map mHandlerToEvent;

    public ClassesInfoCache$CallbackInfo(Map object) {
        boolean bl2;
        this.mHandlerToEvent = object;
        Object object2 = new HashMap();
        this.mEventToHandlers = object2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            Lifecycle$Event lifecycle$Event = (Lifecycle$Event)((Object)object2.getValue());
            List list = (List)this.mEventToHandlers.get((Object)lifecycle$Event);
            if (list == null) {
                Map map = this.mEventToHandlers;
                map.put(lifecycle$Event, list);
            }
            object2 = object2.getKey();
            list.add(object2);
        }
    }

    private static void invokeMethodsForEvent(List list, LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event, Object object) {
        if (list != null) {
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                ClassesInfoCache$MethodReference classesInfoCache$MethodReference = (ClassesInfoCache$MethodReference)list.get(i10);
                classesInfoCache$MethodReference.invokeCallback(lifecycleOwner, lifecycle$Event, object);
            }
        }
    }

    public void invokeCallbacks(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event, Object object) {
        ClassesInfoCache$CallbackInfo.invokeMethodsForEvent((List)this.mEventToHandlers.get((Object)lifecycle$Event), lifecycleOwner, lifecycle$Event, object);
        Map map = this.mEventToHandlers;
        Lifecycle$Event lifecycle$Event2 = Lifecycle$Event.ON_ANY;
        ClassesInfoCache$CallbackInfo.invokeMethodsForEvent((List)map.get((Object)lifecycle$Event2), lifecycleOwner, lifecycle$Event, object);
    }
}

