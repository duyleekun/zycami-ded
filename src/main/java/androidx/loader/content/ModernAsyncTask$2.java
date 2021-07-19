/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Process
 */
package androidx.loader.content;

import android.os.Binder;
import android.os.Process;
import androidx.loader.content.ModernAsyncTask;
import androidx.loader.content.ModernAsyncTask$WorkerRunnable;
import java.util.concurrent.atomic.AtomicBoolean;

public class ModernAsyncTask$2
extends ModernAsyncTask$WorkerRunnable {
    public final /* synthetic */ ModernAsyncTask this$0;

    public ModernAsyncTask$2(ModernAsyncTask modernAsyncTask) {
        this.this$0 = modernAsyncTask;
    }

    public Object call() {
        Object[] objectArray;
        Object object = this.this$0.mTaskInvoked;
        boolean bl2 = true;
        ((AtomicBoolean)object).set(bl2);
        int n10 = 10;
        Object object2 = null;
        try {
            Process.setThreadPriority((int)n10);
            object = this.this$0;
        }
        catch (Throwable throwable) {
            try {
                objectArray = this.this$0;
            }
            catch (Throwable throwable2) {
                this.this$0.postResult(object2);
                throw throwable2;
            }
            objectArray = objectArray.mCancelled;
            objectArray.set(bl2);
            throw throwable;
        }
        objectArray = this.mParams;
        object2 = ((ModernAsyncTask)object).doInBackground(objectArray);
        Binder.flushPendingCommands();
        this.this$0.postResult(object2);
        return object2;
    }
}

