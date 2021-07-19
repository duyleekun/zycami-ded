/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.loader.content;

import android.content.Context;
import androidx.core.util.DebugUtils;
import androidx.loader.content.Loader$OnLoadCanceledListener;
import androidx.loader.content.Loader$OnLoadCompleteListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader {
    public boolean mAbandoned = false;
    public boolean mContentChanged = false;
    public Context mContext;
    public int mId;
    public Loader$OnLoadCompleteListener mListener;
    public Loader$OnLoadCanceledListener mOnLoadCanceledListener;
    public boolean mProcessingChange = false;
    public boolean mReset = true;
    public boolean mStarted = false;

    public Loader(Context context) {
        this.mContext = context = context.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        this.onAbandon();
    }

    public boolean cancelLoad() {
        return this.onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(Object object) {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.buildShortClassTag(object, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void deliverCancellation() {
        Loader$OnLoadCanceledListener loader$OnLoadCanceledListener = this.mOnLoadCanceledListener;
        if (loader$OnLoadCanceledListener != null) {
            loader$OnLoadCanceledListener.onLoadCanceled(this);
        }
    }

    public void deliverResult(Object object) {
        Loader$OnLoadCompleteListener loader$OnLoadCompleteListener = this.mListener;
        if (loader$OnLoadCompleteListener != null) {
            loader$OnLoadCompleteListener.onLoadComplete(this, object);
        }
    }

    public void dump(String string2, FileDescriptor object, PrintWriter printWriter, String[] stringArray) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        printWriter.print(string2);
        printWriter.print("mId=");
        int bl22 = this.mId;
        printWriter.print(bl22);
        printWriter.print(" mListener=");
        object = this.mListener;
        printWriter.println(object);
        boolean bl6 = this.mStarted;
        if (bl6 || (bl5 = this.mContentChanged) || (bl4 = this.mProcessingChange)) {
            printWriter.print(string2);
            printWriter.print("mStarted=");
            boolean bl7 = this.mStarted;
            printWriter.print(bl7);
            printWriter.print(" mContentChanged=");
            boolean bl8 = this.mContentChanged;
            printWriter.print(bl8);
            object = " mProcessingChange=";
            printWriter.print((String)object);
            boolean bl9 = this.mProcessingChange;
            printWriter.println(bl9);
        }
        if ((bl3 = this.mAbandoned) || (bl2 = this.mReset)) {
            printWriter.print(string2);
            printWriter.print("mAbandoned=");
            boolean bl10 = this.mAbandoned;
            printWriter.print(bl10);
            string2 = " mReset=";
            printWriter.print(string2);
            bl10 = this.mReset;
            printWriter.println(bl10);
        }
    }

    public void forceLoad() {
        this.onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void onAbandon() {
    }

    public boolean onCancelLoad() {
        return false;
    }

    public void onContentChanged() {
        boolean bl2 = this.mStarted;
        if (bl2) {
            this.forceLoad();
        } else {
            this.mContentChanged = bl2 = true;
        }
    }

    public void onForceLoad() {
    }

    public void onReset() {
    }

    public void onStartLoading() {
    }

    public void onStopLoading() {
    }

    public void registerListener(int n10, Loader$OnLoadCompleteListener loader$OnLoadCompleteListener) {
        Loader$OnLoadCompleteListener loader$OnLoadCompleteListener2 = this.mListener;
        if (loader$OnLoadCompleteListener2 == null) {
            this.mListener = loader$OnLoadCompleteListener;
            this.mId = n10;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("There is already a listener registered");
        throw illegalStateException;
    }

    public void registerOnLoadCanceledListener(Loader$OnLoadCanceledListener object) {
        Loader$OnLoadCanceledListener loader$OnLoadCanceledListener = this.mOnLoadCanceledListener;
        if (loader$OnLoadCanceledListener == null) {
            this.mOnLoadCanceledListener = object;
            return;
        }
        object = new IllegalStateException("There is already a listener registered");
        throw object;
    }

    public void reset() {
        this.onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        boolean bl2 = this.mProcessingChange;
        if (bl2) {
            this.onContentChanged();
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        this.onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        this.onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean bl2;
        boolean bl3 = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange = bl2 = this.mProcessingChange | bl3;
        return bl3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, stringBuilder);
        stringBuilder.append(" id=");
        int n10 = this.mId;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void unregisterListener(Loader$OnLoadCompleteListener object) {
        Loader$OnLoadCompleteListener loader$OnLoadCompleteListener = this.mListener;
        if (loader$OnLoadCompleteListener != null) {
            if (loader$OnLoadCompleteListener == object) {
                this.mListener = null;
                return;
            }
            object = new IllegalArgumentException("Attempting to unregister the wrong listener");
            throw object;
        }
        object = new IllegalStateException("No listener register");
        throw object;
    }

    public void unregisterOnLoadCanceledListener(Loader$OnLoadCanceledListener object) {
        Loader$OnLoadCanceledListener loader$OnLoadCanceledListener = this.mOnLoadCanceledListener;
        if (loader$OnLoadCanceledListener != null) {
            if (loader$OnLoadCanceledListener == object) {
                this.mOnLoadCanceledListener = null;
                return;
            }
            object = new IllegalArgumentException("Attempting to unregister the wrong listener");
            throw object;
        }
        object = new IllegalStateException("No listener register");
        throw object;
    }
}

