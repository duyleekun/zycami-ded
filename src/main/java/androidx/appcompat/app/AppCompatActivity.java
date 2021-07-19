/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle$Delegate;
import androidx.appcompat.app.ActionBarDrawerToggle$DelegateProvider;
import androidx.appcompat.app.AppCompatActivity$1;
import androidx.appcompat.app.AppCompatActivity$2;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.app.TaskStackBuilder$SupportParentable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class AppCompatActivity
extends FragmentActivity
implements AppCompatCallback,
TaskStackBuilder$SupportParentable,
ActionBarDrawerToggle$DelegateProvider {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        this.initDelegate();
    }

    public AppCompatActivity(int n10) {
        super(n10);
        this.initDelegate();
    }

    private void initDelegate() {
        Object object = this.getSavedStateRegistry();
        AppCompatActivity$1 appCompatActivity$1 = new AppCompatActivity$1(this);
        ((SavedStateRegistry)object).registerSavedStateProvider(DELEGATE_TAG, appCompatActivity$1);
        object = new AppCompatActivity$2(this);
        this.addOnContextAvailableListener((OnContextAvailableListener)object);
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(this.getWindow().getDecorView(), this);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        boolean bl2;
        View view;
        Window window;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        return n10 < n11 && (n10 = (int)(keyEvent.isCtrlPressed() ? 1 : 0)) == 0 && (n10 = (int)(KeyEvent.metaStateHasNoModifiers((int)keyEvent.getMetaState()) ? 1 : 0)) == 0 && (n10 = keyEvent.getRepeatCount()) == 0 && (n10 = (int)(KeyEvent.isModifierKey((int)keyEvent.getKeyCode()) ? 1 : 0)) == 0 && (window = this.getWindow()) != null && (view = window.getDecorView()) != null && (bl2 = (window = window.getDecorView()).dispatchKeyShortcutEvent(keyEvent));
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        this.getDelegate().addContentView(view, layoutParams);
    }

    public void attachBaseContext(Context context) {
        context = this.getDelegate().attachBaseContext2(context);
        super.attachBaseContext(context);
    }

    public void closeOptionsMenu() {
        boolean bl2;
        ActionBar actionBar = this.getSupportActionBar();
        Window window = this.getWindow();
        boolean bl3 = window.hasFeature(0);
        if (bl3 && (actionBar == null || !(bl2 = actionBar.closeOptionsMenu()))) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int n10 = keyEvent.getKeyCode();
        ActionBar actionBar = this.getSupportActionBar();
        int n11 = 82;
        if (n10 == n11 && actionBar != null && (n10 = (int)(actionBar.onMenuKeyEvent(keyEvent) ? 1 : 0)) != 0) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
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

    public ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        return this.getDelegate().getDrawerToggleDelegate();
    }

    public MenuInflater getMenuInflater() {
        return this.getDelegate().getMenuInflater();
    }

    public Resources getResources() {
        boolean bl2;
        Resources resources = this.mResources;
        if (resources == null && (bl2 = VectorEnabledTintResources.shouldBeUsed())) {
            Resources resources2 = super.getResources();
            this.mResources = resources = new VectorEnabledTintResources((Context)this, resources2);
        }
        if ((resources = this.mResources) == null) {
            resources = super.getResources();
        }
        return resources;
    }

    public ActionBar getSupportActionBar() {
        return this.getDelegate().getSupportActionBar();
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public void invalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Resources resources = this.mResources;
        if (resources != null) {
            resources = super.getResources().getDisplayMetrics();
            Resources resources2 = this.mResources;
            resources2.updateConfiguration(configuration, (DisplayMetrics)resources);
        }
        this.getDelegate().onConfigurationChanged(configuration);
    }

    public void onContentChanged() {
        this.onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.getDelegate().onDestroy();
    }

    public boolean onKeyDown(int n10, KeyEvent keyEvent) {
        boolean bl2 = this.performMenuItemShortcut(keyEvent);
        if (bl2) {
            return true;
        }
        return super.onKeyDown(n10, keyEvent);
    }

    public final boolean onMenuItemSelected(int n10, MenuItem menuItem) {
        int n11;
        if ((n10 = (int)(super.onMenuItemSelected(n10, menuItem) ? 1 : 0)) != 0) {
            return true;
        }
        ActionBar actionBar = this.getSupportActionBar();
        int n12 = menuItem.getItemId();
        if (n12 == (n11 = 16908332) && actionBar != null && (n10 = actionBar.getDisplayOptions() & 4) != 0) {
            return this.onSupportNavigateUp();
        }
        return false;
    }

    public boolean onMenuOpened(int n10, Menu menu2) {
        return super.onMenuOpened(n10, menu2);
    }

    public void onNightModeChanged(int n10) {
    }

    public void onPanelClosed(int n10, Menu menu2) {
        super.onPanelClosed(n10, menu2);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.getDelegate().onPostCreate(bundle);
    }

    public void onPostResume() {
        super.onPostResume();
        this.getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    public void onStart() {
        super.onStart();
        this.getDelegate().onStart();
    }

    public void onStop() {
        super.onStop();
        this.getDelegate().onStop();
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Object object = this.getSupportParentActivityIntent();
        if (object != null) {
            boolean bl2 = this.supportShouldUpRecreateTask((Intent)object);
            if (bl2) {
                object = TaskStackBuilder.create((Context)this);
                this.onCreateSupportNavigateUpTaskStack((TaskStackBuilder)object);
                this.onPrepareSupportNavigateUpTaskStack((TaskStackBuilder)object);
                ((TaskStackBuilder)object).startActivities();
                try {
                    ActivityCompat.finishAffinity(this);
                }
                catch (IllegalStateException illegalStateException) {
                    this.finish();
                }
            } else {
                this.supportNavigateUpTo((Intent)object);
            }
            return true;
        }
        return false;
    }

    public void onTitleChanged(CharSequence charSequence, int n10) {
        super.onTitleChanged(charSequence, n10);
        this.getDelegate().setTitle(charSequence);
    }

    public ActionMode onWindowStartingSupportActionMode(ActionMode$Callback actionMode$Callback) {
        return null;
    }

    public void openOptionsMenu() {
        boolean bl2;
        ActionBar actionBar = this.getSupportActionBar();
        Window window = this.getWindow();
        boolean bl3 = window.hasFeature(0);
        if (bl3 && (actionBar == null || !(bl2 = actionBar.openOptionsMenu()))) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int n10) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(n10);
    }

    public void setContentView(View view) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        this.getDelegate().setSupportActionBar(toolbar);
    }

    public void setSupportProgress(int n10) {
    }

    public void setSupportProgressBarIndeterminate(boolean bl2) {
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean bl2) {
    }

    public void setSupportProgressBarVisibility(boolean bl2) {
    }

    public void setTheme(int n10) {
        super.setTheme(n10);
        this.getDelegate().setTheme(n10);
    }

    public ActionMode startSupportActionMode(ActionMode$Callback actionMode$Callback) {
        return this.getDelegate().startSupportActionMode(actionMode$Callback);
    }

    public void supportInvalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }

    public boolean supportRequestWindowFeature(int n10) {
        return this.getDelegate().requestWindowFeature(n10);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }
}

