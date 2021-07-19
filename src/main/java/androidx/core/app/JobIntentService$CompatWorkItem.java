/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package androidx.core.app;

import android.content.Intent;
import androidx.core.app.JobIntentService;
import androidx.core.app.JobIntentService$GenericWorkItem;

public final class JobIntentService$CompatWorkItem
implements JobIntentService$GenericWorkItem {
    public final Intent mIntent;
    public final int mStartId;
    public final /* synthetic */ JobIntentService this$0;

    public JobIntentService$CompatWorkItem(JobIntentService jobIntentService, Intent intent, int n10) {
        this.this$0 = jobIntentService;
        this.mIntent = intent;
        this.mStartId = n10;
    }

    public void complete() {
        JobIntentService jobIntentService = this.this$0;
        int n10 = this.mStartId;
        jobIntentService.stopSelf(n10);
    }

    public Intent getIntent() {
        return this.mIntent;
    }
}

