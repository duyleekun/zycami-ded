/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.appcompat.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;

public class AppCompatActivity$1
implements SavedStateRegistry$SavedStateProvider {
    public final /* synthetic */ AppCompatActivity this$0;

    public AppCompatActivity$1(AppCompatActivity appCompatActivity) {
        this.this$0 = appCompatActivity;
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        this.this$0.getDelegate().onSaveInstanceState(bundle);
        return bundle;
    }
}

