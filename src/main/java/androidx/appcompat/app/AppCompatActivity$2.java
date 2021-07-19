/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class AppCompatActivity$2
implements OnContextAvailableListener {
    public final /* synthetic */ AppCompatActivity this$0;

    public AppCompatActivity$2(AppCompatActivity appCompatActivity) {
        this.this$0 = appCompatActivity;
    }

    public void onContextAvailable(Context object) {
        object = this.this$0.getDelegate();
        ((AppCompatDelegate)object).installViewFactory();
        Bundle bundle = this.this$0.getSavedStateRegistry().consumeRestoredStateForKey("androidx:appcompat");
        ((AppCompatDelegate)object).onCreate(bundle);
    }
}

