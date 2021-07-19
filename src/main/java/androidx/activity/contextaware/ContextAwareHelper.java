/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.activity.contextaware;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ContextAwareHelper {
    private volatile Context mContext;
    private final Set mListeners;

    public ContextAwareHelper() {
        CopyOnWriteArraySet copyOnWriteArraySet;
        this.mListeners = copyOnWriteArraySet = new CopyOnWriteArraySet();
    }

    public void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        Context context = this.mContext;
        if (context != null) {
            context = this.mContext;
            onContextAvailableListener.onContextAvailable(context);
        }
        this.mListeners.add(onContextAvailableListener);
    }

    public void clearAvailableContext() {
        this.mContext = null;
    }

    public void dispatchOnContextAvailable(Context context) {
        boolean bl2;
        this.mContext = context;
        Iterator iterator2 = this.mListeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            OnContextAvailableListener onContextAvailableListener = (OnContextAvailableListener)iterator2.next();
            onContextAvailableListener.onContextAvailable(context);
        }
    }

    public Context peekAvailableContext() {
        return this.mContext;
    }

    public void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mListeners.remove(onContextAvailableListener);
    }
}

