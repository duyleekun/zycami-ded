/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.loader.app;

import android.util.Log;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager$LoaderCallbacks;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.Loader;
import java.io.PrintWriter;

public class LoaderManagerImpl$LoaderObserver
implements Observer {
    private final LoaderManager$LoaderCallbacks mCallback;
    private boolean mDeliveredData = false;
    private final Loader mLoader;

    public LoaderManagerImpl$LoaderObserver(Loader loader, LoaderManager$LoaderCallbacks loaderManager$LoaderCallbacks) {
        this.mLoader = loader;
        this.mCallback = loaderManager$LoaderCallbacks;
    }

    public void dump(String string2, PrintWriter printWriter) {
        printWriter.print(string2);
        printWriter.print("mDeliveredData=");
        boolean bl2 = this.mDeliveredData;
        printWriter.println(bl2);
    }

    public boolean hasDeliveredData() {
        return this.mDeliveredData;
    }

    public void onChanged(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = LoaderManagerImpl.DEBUG;
        if (bl2) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("  onLoadFinished in ");
            object2 = this.mLoader;
            ((StringBuilder)object3).append(object2);
            ((StringBuilder)object3).append(": ");
            object2 = this.mLoader.dataToString(object);
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            object2 = "LoaderManager";
            Log.v((String)object2, (String)object3);
        }
        object3 = this.mCallback;
        object2 = this.mLoader;
        object3.onLoadFinished((Loader)object2, object);
        this.mDeliveredData = true;
    }

    public void reset() {
        boolean bl2 = this.mDeliveredData;
        if (bl2) {
            Object object;
            Object object2;
            bl2 = LoaderManagerImpl.DEBUG;
            if (bl2) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("  Resetting: ");
                object = this.mLoader;
                ((StringBuilder)object2).append(object);
                object2 = ((StringBuilder)object2).toString();
                object = "LoaderManager";
                Log.v((String)object, (String)object2);
            }
            object2 = this.mCallback;
            object = this.mLoader;
            object2.onLoaderReset((Loader)object);
        }
    }

    public String toString() {
        return this.mCallback.toString();
    }
}

