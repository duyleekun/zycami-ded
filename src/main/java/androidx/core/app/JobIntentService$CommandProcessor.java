/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.AsyncTask
 */
package androidx.core.app;

import android.content.Intent;
import android.os.AsyncTask;
import androidx.core.app.JobIntentService;

public final class JobIntentService$CommandProcessor
extends AsyncTask {
    public final /* synthetic */ JobIntentService this$0;

    public JobIntentService$CommandProcessor(JobIntentService jobIntentService) {
        this.this$0 = jobIntentService;
    }

    public Void doInBackground(Void ... object) {
        while ((object = this.this$0.dequeueWork()) != null) {
            JobIntentService jobIntentService = this.this$0;
            Intent intent = object.getIntent();
            jobIntentService.onHandleWork(intent);
            object.complete();
        }
        return null;
    }

    public void onCancelled(Void void_) {
        this.this$0.processorFinished();
    }

    public void onPostExecute(Void void_) {
        this.this$0.processorFinished();
    }
}

