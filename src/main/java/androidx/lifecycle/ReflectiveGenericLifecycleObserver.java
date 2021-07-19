/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.ClassesInfoCache$CallbackInfo;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class ReflectiveGenericLifecycleObserver
implements LifecycleEventObserver {
    private final ClassesInfoCache$CallbackInfo mInfo;
    private final Object mWrapped;

    public ReflectiveGenericLifecycleObserver(Object object) {
        this.mWrapped = object;
        ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
        object = object.getClass();
        this.mInfo = object = classesInfoCache.getInfo((Class)object);
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        ClassesInfoCache$CallbackInfo classesInfoCache$CallbackInfo = this.mInfo;
        Object object = this.mWrapped;
        classesInfoCache$CallbackInfo.invokeCallbacks(lifecycleOwner, lifecycle$Event, object);
    }
}

