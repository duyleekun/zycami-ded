/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.SystemClock
 */
package com.xiaomi.push;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fc$a;
import com.xiaomi.push.fy;
import com.xiaomi.push.service.XMJobService;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class fe
implements fc$a {
    public JobScheduler a;
    public Context a;
    private boolean a = false;

    public fe(Context context) {
        this.a = context;
        context = (JobScheduler)context.getSystemService("jobscheduler");
        this.a = context;
    }

    public void a() {
        this.a = false;
        this.a.cancel(1);
    }

    public void a(long l10) {
        CharSequence charSequence = this.a.getPackageName();
        String string2 = XMJobService.class.getName();
        ComponentName componentName = new ComponentName((String)charSequence, string2);
        int n10 = 1;
        JobInfo.Builder builder = new JobInfo.Builder(n10, componentName);
        builder.setMinimumLatency(l10);
        builder.setOverrideDeadline(l10);
        builder.setRequiredNetworkType(n10);
        builder.setPersisted(false);
        componentName = builder.build();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("schedule Job = ");
        int n11 = componentName.getId();
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append(" in ");
        ((StringBuilder)charSequence).append(l10);
        b.c(((StringBuilder)charSequence).toString());
        JobScheduler jobScheduler = this.a;
        JobInfo jobInfo = builder.build();
        jobScheduler.schedule(jobInfo);
    }

    public void a(boolean bl2) {
        int n10;
        if (!bl2 && (n10 = (int)(this.a ? 1 : 0)) == 0) {
            return;
        }
        n10 = fy.b();
        long l10 = n10;
        if (bl2) {
            this.a();
            long l11 = SystemClock.elapsedRealtime() % l10;
            l10 -= l11;
        }
        this.a = true;
        this.a(l10);
    }

    public boolean a() {
        return this.a;
    }
}

