/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager$LoaderCallbacks;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {
    public static void enableDebugLogging(boolean bl2) {
        LoaderManagerImpl.DEBUG = bl2;
    }

    public static LoaderManager getInstance(LifecycleOwner lifecycleOwner) {
        Object object = lifecycleOwner;
        object = ((ViewModelStoreOwner)((Object)lifecycleOwner)).getViewModelStore();
        LoaderManagerImpl loaderManagerImpl = new LoaderManagerImpl(lifecycleOwner, (ViewModelStore)object);
        return loaderManagerImpl;
    }

    public abstract void destroyLoader(int var1);

    public abstract void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public abstract Loader getLoader(int var1);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract Loader initLoader(int var1, Bundle var2, LoaderManager$LoaderCallbacks var3);

    public abstract void markForRedelivery();

    public abstract Loader restartLoader(int var1, Bundle var2, LoaderManager$LoaderCallbacks var3);
}

