/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window$Callback
 */
package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ComponentActivity$ExtraData;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;

public class ComponentActivity
extends Activity
implements LifecycleOwner,
KeyEventDispatcher$Component {
    private SimpleArrayMap mExtraDataMap;
    private LifecycleRegistry mLifecycleRegistry;

    public ComponentActivity() {
        Object object = new SimpleArrayMap();
        this.mExtraDataMap = object;
        this.mLifecycleRegistry = object = new LifecycleRegistry(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl2;
        View view = this.getWindow().getDecorView();
        if (view != null && (bl2 = KeyEventDispatcher.dispatchBeforeHierarchy(view, keyEvent))) {
            return true;
        }
        return KeyEventDispatcher.dispatchKeyEvent(this, view, (Window.Callback)this, keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        boolean bl2;
        View view = this.getWindow().getDecorView();
        if (view != null && (bl2 = KeyEventDispatcher.dispatchBeforeHierarchy(view, keyEvent))) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public ComponentActivity$ExtraData getExtraData(Class clazz) {
        return (ComponentActivity$ExtraData)this.mExtraDataMap.get(clazz);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        Lifecycle$State lifecycle$State = Lifecycle$State.CREATED;
        lifecycleRegistry.markState(lifecycle$State);
        super.onSaveInstanceState(bundle);
    }

    public void putExtraData(ComponentActivity$ExtraData componentActivity$ExtraData) {
        SimpleArrayMap simpleArrayMap = this.mExtraDataMap;
        Class<?> clazz = componentActivity$ExtraData.getClass();
        simpleArrayMap.put(clazz, componentActivity$ExtraData);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}

