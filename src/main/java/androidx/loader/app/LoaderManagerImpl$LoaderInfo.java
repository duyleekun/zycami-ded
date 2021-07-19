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
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager$LoaderCallbacks;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.app.LoaderManagerImpl$LoaderObserver;
import androidx.loader.content.Loader;
import androidx.loader.content.Loader$OnLoadCompleteListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LoaderManagerImpl$LoaderInfo
extends MutableLiveData
implements Loader$OnLoadCompleteListener {
    private final Bundle mArgs;
    private final int mId;
    private LifecycleOwner mLifecycleOwner;
    private final Loader mLoader;
    private LoaderManagerImpl$LoaderObserver mObserver;
    private Loader mPriorLoader;

    public LoaderManagerImpl$LoaderInfo(int n10, Bundle bundle, Loader loader, Loader loader2) {
        this.mId = n10;
        this.mArgs = bundle;
        this.mLoader = loader;
        this.mPriorLoader = loader2;
        loader.registerListener(n10, this);
    }

    public Loader destroy(boolean bl2) {
        Object object;
        Object object2;
        boolean bl3 = LoaderManagerImpl.DEBUG;
        if (bl3) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("  Destroying: ");
            ((StringBuilder)object2).append(this);
            object2 = ((StringBuilder)object2).toString();
            object = "LoaderManager";
            Log.v((String)object, (String)object2);
        }
        this.mLoader.cancelLoad();
        this.mLoader.abandon();
        object2 = this.mObserver;
        if (object2 != null) {
            this.removeObserver((Observer)object2);
            if (bl2) {
                ((LoaderManagerImpl$LoaderObserver)object2).reset();
            }
        }
        object = this.mLoader;
        ((Loader)object).unregisterListener(this);
        if (object2 != null && !(bl3 = ((LoaderManagerImpl$LoaderObserver)object2).hasDeliveredData()) || bl2) {
            this.mLoader.reset();
            return this.mPriorLoader;
        }
        return this.mLoader;
    }

    public void dump(String string2, FileDescriptor object, PrintWriter printWriter, String[] object2) {
        printWriter.print(string2);
        printWriter.print("mId=");
        int n10 = this.mId;
        printWriter.print(n10);
        printWriter.print(" mArgs=");
        Object object3 = this.mArgs;
        printWriter.println(object3);
        printWriter.print(string2);
        printWriter.print("mLoader=");
        object3 = this.mLoader;
        printWriter.println(object3);
        object3 = this.mLoader;
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        String string3 = "  ";
        charSequence.append(string3);
        charSequence = charSequence.toString();
        ((Loader)object3).dump((String)charSequence, (FileDescriptor)object, printWriter, (String[])object2);
        object = this.mObserver;
        if (object != null) {
            printWriter.print(string2);
            printWriter.print("mCallbacks=");
            object = this.mObserver;
            printWriter.println(object);
            object = this.mObserver;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(string3);
            object2 = ((StringBuilder)object2).toString();
            ((LoaderManagerImpl$LoaderObserver)object).dump((String)object2, printWriter);
        }
        printWriter.print(string2);
        printWriter.print("mData=");
        object = this.getLoader();
        object2 = this.getValue();
        object = ((Loader)object).dataToString(object2);
        printWriter.println((String)object);
        printWriter.print(string2);
        printWriter.print("mStarted=");
        boolean bl2 = this.hasActiveObservers();
        printWriter.println(bl2);
    }

    public Loader getLoader() {
        return this.mLoader;
    }

    public boolean isCallbackWaitingForData() {
        boolean bl2 = this.hasActiveObservers();
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        LoaderManagerImpl$LoaderObserver loaderManagerImpl$LoaderObserver = this.mObserver;
        if (loaderManagerImpl$LoaderObserver != null && !(bl2 = loaderManagerImpl$LoaderObserver.hasDeliveredData())) {
            bl3 = true;
        }
        return bl3;
    }

    public void markForRedelivery() {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        LoaderManagerImpl$LoaderObserver loaderManagerImpl$LoaderObserver = this.mObserver;
        if (lifecycleOwner != null && loaderManagerImpl$LoaderObserver != null) {
            super.removeObserver(loaderManagerImpl$LoaderObserver);
            this.observe(lifecycleOwner, loaderManagerImpl$LoaderObserver);
        }
    }

    public void onActive() {
        boolean bl2 = LoaderManagerImpl.DEBUG;
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("  Starting: ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            String string2 = "LoaderManager";
            Log.v((String)string2, (String)charSequence);
        }
        this.mLoader.startLoading();
    }

    public void onInactive() {
        boolean bl2 = LoaderManagerImpl.DEBUG;
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("  Stopping: ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            String string2 = "LoaderManager";
            Log.v((String)string2, (String)charSequence);
        }
        this.mLoader.stopLoading();
    }

    public void onLoadComplete(Loader object, Object object2) {
        Object object3;
        boolean bl2 = LoaderManagerImpl.DEBUG;
        String string2 = "LoaderManager";
        if (bl2) {
            object = new StringBuilder();
            object3 = "onLoadComplete: ";
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            Log.v((String)string2, (String)object);
        }
        if ((object = Looper.myLooper()) == (object3 = Looper.getMainLooper())) {
            this.setValue(object2);
        } else {
            bl2 = LoaderManagerImpl.DEBUG;
            if (bl2) {
                object = "onLoadComplete was incorrectly called on a background thread";
                Log.w((String)string2, (String)object);
            }
            this.postValue(object2);
        }
    }

    public void removeObserver(Observer observer) {
        super.removeObserver(observer);
        this.mLifecycleOwner = null;
        this.mObserver = null;
    }

    public Loader setCallback(LifecycleOwner lifecycleOwner, LoaderManager$LoaderCallbacks object) {
        Loader loader = this.mLoader;
        LoaderManagerImpl$LoaderObserver loaderManagerImpl$LoaderObserver = new LoaderManagerImpl$LoaderObserver(loader, (LoaderManager$LoaderCallbacks)object);
        this.observe(lifecycleOwner, loaderManagerImpl$LoaderObserver);
        object = this.mObserver;
        if (object != null) {
            this.removeObserver((Observer)object);
        }
        this.mLifecycleOwner = lifecycleOwner;
        this.mObserver = loaderManagerImpl$LoaderObserver;
        return this.mLoader;
    }

    public void setValue(Object object) {
        super.setValue(object);
        object = this.mPriorLoader;
        if (object != null) {
            ((Loader)object).reset();
            object = null;
            this.mPriorLoader = null;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        String string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" #");
        int n10 = this.mId;
        stringBuilder.append(n10);
        stringBuilder.append(" : ");
        DebugUtils.buildShortClassTag(this.mLoader, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}

