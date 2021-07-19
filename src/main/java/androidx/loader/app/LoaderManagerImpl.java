/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 */
package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManager$LoaderCallbacks;
import androidx.loader.app.LoaderManagerImpl$LoaderInfo;
import androidx.loader.app.LoaderManagerImpl$LoaderViewModel;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public class LoaderManagerImpl
extends LoaderManager {
    public static boolean DEBUG = false;
    public static final String TAG = "LoaderManager";
    private final LifecycleOwner mLifecycleOwner;
    private final LoaderManagerImpl$LoaderViewModel mLoaderViewModel;

    public LoaderManagerImpl(LifecycleOwner object, ViewModelStore viewModelStore) {
        this.mLifecycleOwner = object;
        this.mLoaderViewModel = object = LoaderManagerImpl$LoaderViewModel.getInstance(viewModelStore);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Loader createAndInstallLoader(int n10, Bundle object, LoaderManager$LoaderCallbacks object2, Loader object3) {
        try {
            Object object4 = this.mLoaderViewModel;
            ((LoaderManagerImpl$LoaderViewModel)object4).startCreatingLoader();
            object4 = object2.onCreateLoader(n10, (Bundle)object);
            if (object4 != null) {
                Class clazz = object4.getClass();
                int n11 = clazz.isMemberClass();
                if (n11 != 0) {
                    clazz = object4.getClass();
                    n11 = clazz.getModifiers();
                    if ((n11 = (int)(Modifier.isStatic(n11) ? 1 : 0)) == 0) {
                        object = new StringBuilder();
                        object2 = "Object returned from onCreateLoader must not be a non-static inner member class: ";
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(object4);
                        object = ((StringBuilder)object).toString();
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                        throw illegalArgumentException;
                    }
                }
                clazz = new Class(n10, (Bundle)object, (Loader)object4, (Loader)object3);
                boolean bl2 = DEBUG;
                if (bl2) {
                    object = TAG;
                    object3 = new StringBuilder();
                    object4 = "  Created new loader ";
                    ((StringBuilder)object3).append((String)object4);
                    ((StringBuilder)object3).append(clazz);
                    object3 = ((StringBuilder)object3).toString();
                    Log.v((String)object, (String)object3);
                }
                object = this.mLoaderViewModel;
                ((LoaderManagerImpl$LoaderViewModel)object).putLoader(n10, (LoaderManagerImpl$LoaderInfo)((Object)clazz));
                LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
                return ((LoaderManagerImpl$LoaderInfo)((Object)clazz)).setCallback(lifecycleOwner, (LoaderManager$LoaderCallbacks)object2);
            }
            object = "Object returned from onCreateLoader must not be null";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        finally {
            this.mLoaderViewModel.finishCreatingLoader();
        }
    }

    public void destroyLoader(int n10) {
        Object object = this.mLoaderViewModel;
        boolean bl2 = ((LoaderManagerImpl$LoaderViewModel)object).isCreatingLoader();
        if (!bl2) {
            Object object2;
            object = Looper.getMainLooper();
            if (object == (object2 = Looper.myLooper())) {
                bl2 = DEBUG;
                if (bl2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("destroyLoader in ");
                    ((StringBuilder)object).append(this);
                    ((StringBuilder)object).append(" of ");
                    ((StringBuilder)object).append(n10);
                    object = ((StringBuilder)object).toString();
                    object2 = TAG;
                    Log.v((String)object2, (String)object);
                }
                if ((object = this.mLoaderViewModel.getLoader(n10)) != null) {
                    boolean bl3 = true;
                    ((LoaderManagerImpl$LoaderInfo)object).destroy(bl3);
                    object = this.mLoaderViewModel;
                    ((LoaderManagerImpl$LoaderViewModel)object).removeLoader(n10);
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("destroyLoader must be called on the main thread");
            throw illegalStateException;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Called while creating a loader");
        throw illegalStateException;
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        this.mLoaderViewModel.dump(string2, fileDescriptor, printWriter, stringArray);
    }

    public Loader getLoader(int n10) {
        LoaderManagerImpl$LoaderViewModel loaderManagerImpl$LoaderViewModel = this.mLoaderViewModel;
        boolean bl2 = loaderManagerImpl$LoaderViewModel.isCreatingLoader();
        if (!bl2) {
            loaderManagerImpl$LoaderViewModel = this.mLoaderViewModel;
            Object object = loaderManagerImpl$LoaderViewModel.getLoader(n10);
            if (object != null) {
                object = ((LoaderManagerImpl$LoaderInfo)object).getLoader();
            } else {
                n10 = 0;
                object = null;
            }
            return object;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Called while creating a loader");
        throw illegalStateException;
    }

    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    public Loader initLoader(int n10, Bundle object, LoaderManager$LoaderCallbacks loaderManager$LoaderCallbacks) {
        Object object2 = this.mLoaderViewModel;
        boolean bl2 = ((LoaderManagerImpl$LoaderViewModel)object2).isCreatingLoader();
        if (!bl2) {
            Object object3;
            object2 = Looper.getMainLooper();
            if (object2 == (object3 = Looper.myLooper())) {
                Object object4;
                object2 = this.mLoaderViewModel.getLoader(n10);
                boolean bl3 = DEBUG;
                String string2 = TAG;
                if (bl3) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("initLoader in ");
                    ((StringBuilder)object3).append(this);
                    String string3 = ": args=";
                    ((StringBuilder)object3).append(string3);
                    ((StringBuilder)object3).append(object);
                    object3 = ((StringBuilder)object3).toString();
                    Log.v((String)string2, (String)object3);
                }
                if (object2 == null) {
                    return this.createAndInstallLoader(n10, (Bundle)object, loaderManager$LoaderCallbacks, null);
                }
                n10 = (int)(DEBUG ? 1 : 0);
                if (n10 != 0) {
                    object4 = new StringBuilder();
                    object = "  Re-using existing loader ";
                    ((StringBuilder)object4).append((String)object);
                    ((StringBuilder)object4).append(object2);
                    object4 = ((StringBuilder)object4).toString();
                    Log.v((String)string2, (String)object4);
                }
                object4 = this.mLifecycleOwner;
                return ((LoaderManagerImpl$LoaderInfo)object2).setCallback((LifecycleOwner)object4, loaderManager$LoaderCallbacks);
            }
            IllegalStateException illegalStateException = new IllegalStateException("initLoader must be called on the main thread");
            throw illegalStateException;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Called while creating a loader");
        throw illegalStateException;
    }

    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    public Loader restartLoader(int n10, Bundle bundle, LoaderManager$LoaderCallbacks loaderManager$LoaderCallbacks) {
        Object object = this.mLoaderViewModel;
        boolean bl2 = ((LoaderManagerImpl$LoaderViewModel)object).isCreatingLoader();
        if (!bl2) {
            Object object2;
            object = Looper.getMainLooper();
            if (object == (object2 = Looper.myLooper())) {
                bl2 = DEBUG;
                if (bl2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("restartLoader in ");
                    ((StringBuilder)object).append(this);
                    ((StringBuilder)object).append(": args=");
                    ((StringBuilder)object).append(bundle);
                    object = ((StringBuilder)object).toString();
                    object2 = TAG;
                    Log.v((String)object2, (String)object);
                }
                object = this.mLoaderViewModel.getLoader(n10);
                object2 = null;
                if (object != null) {
                    object2 = ((LoaderManagerImpl$LoaderInfo)object).destroy(false);
                }
                return this.createAndInstallLoader(n10, bundle, loaderManager$LoaderCallbacks, (Loader)object2);
            }
            IllegalStateException illegalStateException = new IllegalStateException("restartLoader must be called on the main thread");
            throw illegalStateException;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Called while creating a loader");
        throw illegalStateException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        String string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}

