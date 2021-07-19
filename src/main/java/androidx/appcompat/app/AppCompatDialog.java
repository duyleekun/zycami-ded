/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.os.Bundle
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window$Callback
 */
package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialog$1;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher$Component;

public class AppCompatDialog
extends Dialog
implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher$Component mKeyDispatcher;

    public AppCompatDialog(Context context) {
        this(context, 0);
    }

    public AppCompatDialog(Context context, int n10) {
        int n11 = AppCompatDialog.getThemeResId(context, n10);
        super(context, n11);
        Object object = new AppCompatDialog$1(this);
        this.mKeyDispatcher = object;
        object = this.getDelegate();
        int n12 = AppCompatDialog.getThemeResId(context, n10);
        ((AppCompatDelegate)object).setTheme(n12);
        ((AppCompatDelegate)object).onCreate(null);
    }

    public AppCompatDialog(Context object, boolean bl2, DialogInterface.OnCancelListener onCancelListener) {
        super(object, bl2, onCancelListener);
        super(this);
        this.mKeyDispatcher = object;
    }

    private static int getThemeResId(Context context, int n10) {
        if (n10 == 0) {
            TypedValue typedValue = new TypedValue();
            context = context.getTheme();
            int n11 = R$attr.dialogTheme;
            boolean bl2 = true;
            context.resolveAttribute(n11, typedValue, bl2);
            n10 = typedValue.resourceId;
        }
        return n10;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.getDelegate().addContentView(view, layoutParams);
    }

    public void dismiss() {
        super.dismiss();
        this.getDelegate().onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View view = this.getWindow().getDecorView();
        return KeyEventDispatcher.dispatchKeyEvent(this.mKeyDispatcher, view, (Window.Callback)this, keyEvent);
    }

    public View findViewById(int n10) {
        return this.getDelegate().findViewById(n10);
    }

    public AppCompatDelegate getDelegate() {
        AppCompatDelegate appCompatDelegate = this.mDelegate;
        if (appCompatDelegate == null) {
            this.mDelegate = appCompatDelegate = AppCompatDelegate.create(this, (AppCompatCallback)this);
        }
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return this.getDelegate().getSupportActionBar();
    }

    public void invalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    public void onCreate(Bundle bundle) {
        this.getDelegate().installViewFactory();
        super.onCreate(bundle);
        this.getDelegate().onCreate(bundle);
    }

    public void onStop() {
        super.onStop();
        this.getDelegate().onStop();
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    public ActionMode onWindowStartingSupportActionMode(ActionMode$Callback actionMode$Callback) {
        return null;
    }

    public void setContentView(int n10) {
        this.getDelegate().setContentView(n10);
    }

    public void setContentView(View view) {
        this.getDelegate().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.getDelegate().setContentView(view, layoutParams);
    }

    public void setTitle(int n10) {
        super.setTitle(n10);
        AppCompatDelegate appCompatDelegate = this.getDelegate();
        String string2 = this.getContext().getString(n10);
        appCompatDelegate.setTitle(string2);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.getDelegate().setTitle(charSequence);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int n10) {
        return this.getDelegate().requestWindowFeature(n10);
    }
}

