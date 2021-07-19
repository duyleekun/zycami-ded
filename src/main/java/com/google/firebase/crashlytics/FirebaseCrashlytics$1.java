/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;

public class FirebaseCrashlytics$1
implements Continuation {
    public Object then(Task object) {
        boolean bl2 = ((Task)object).isSuccessful();
        if (!bl2) {
            Logger logger = Logger.getLogger();
            object = ((Task)object).getException();
            String string2 = "Error fetching settings.";
            logger.e(string2, (Throwable)object);
        }
        return null;
    }
}

