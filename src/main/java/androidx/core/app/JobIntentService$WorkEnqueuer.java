/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 */
package androidx.core.app;

import android.content.ComponentName;
import android.content.Intent;

public abstract class JobIntentService$WorkEnqueuer {
    public final ComponentName mComponentName;
    public boolean mHasJobId;
    public int mJobId;

    public JobIntentService$WorkEnqueuer(ComponentName componentName) {
        this.mComponentName = componentName;
    }

    public abstract void enqueueWork(Intent var1);

    public void ensureJobId(int n10) {
        block4: {
            block3: {
                int n11;
                block2: {
                    n11 = this.mHasJobId;
                    if (n11 != 0) break block2;
                    n11 = 1;
                    this.mHasJobId = n11;
                    this.mJobId = n10;
                    break block3;
                }
                n11 = this.mJobId;
                if (n11 != n10) break block4;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Given job ID ");
        stringBuilder.append(n10);
        stringBuilder.append(" is different than previous ");
        n10 = this.mJobId;
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void serviceProcessingFinished() {
    }

    public void serviceProcessingStarted() {
    }

    public void serviceStartReceived() {
    }
}

