/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 */
package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.ViewModel;

public class AndroidViewModel
extends ViewModel {
    private Application mApplication;

    public AndroidViewModel(Application application) {
        this.mApplication = application;
    }

    public Application getApplication() {
        return this.mApplication;
    }
}

