/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.loader.content;

import android.util.Log;
import androidx.loader.content.ModernAsyncTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ModernAsyncTask$3
extends FutureTask {
    public final /* synthetic */ ModernAsyncTask this$0;

    public ModernAsyncTask$3(ModernAsyncTask modernAsyncTask, Callable callable) {
        this.this$0 = modernAsyncTask;
        super(callable);
    }

    public void done() {
        Object object = "An error occurred while executing doInBackground()";
        Object object2 = this.get();
        Object object3 = this.this$0;
        try {
            ((ModernAsyncTask)object3).postResultIfNotInvoked(object2);
        }
        catch (Throwable throwable) {
            object3 = new RuntimeException((String)object, throwable);
            throw object3;
        }
        catch (CancellationException cancellationException) {
            object = this.this$0;
            object2 = null;
            ((ModernAsyncTask)object).postResultIfNotInvoked(null);
        }
        catch (ExecutionException executionException) {
            Throwable throwable = executionException.getCause();
            object3 = new RuntimeException((String)object, throwable);
            throw object3;
        }
        catch (InterruptedException interruptedException) {
            object2 = "AsyncTask";
            Log.w(object2, (Throwable)interruptedException);
        }
    }
}

