/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.loader.content.ModernAsyncTask;

public class ModernAsyncTask$InternalHandler
extends Handler {
    public ModernAsyncTask$InternalHandler() {
        Looper looper = Looper.getMainLooper();
        super(looper);
    }

    public void handleMessage(Message object) {
        Object[] objectArray = (Object[])((Message)object).obj;
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 == n11) {
                object = objectArray.mTask;
                objectArray = objectArray.mData;
                ((ModernAsyncTask)object).onProgressUpdate(objectArray);
            }
        } else {
            object = objectArray.mTask;
            objectArray = objectArray.mData;
            n11 = 0;
            objectArray = objectArray[0];
            ((ModernAsyncTask)object).finish(objectArray);
        }
    }
}

