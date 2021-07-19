/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.SearchEvent
 *  android.view.View
 *  android.view.Window$Callback
 *  android.view.WindowManager$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class WindowCallbackWrapper
implements Window.Callback {
    public final Window.Callback mWrapped;

    public WindowCallbackWrapper(Window.Callback object) {
        if (object != null) {
            this.mWrapped = object;
            return;
        }
        super("Window callback may not be null");
        throw object;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mWrapped.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mWrapped.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mWrapped.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mWrapped.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mWrapped.dispatchTrackballEvent(motionEvent);
    }

    public final Window.Callback getWrapped() {
        return this.mWrapped;
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.mWrapped.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.mWrapped.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.mWrapped.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.mWrapped.onContentChanged();
    }

    public boolean onCreatePanelMenu(int n10, Menu menu2) {
        return this.mWrapped.onCreatePanelMenu(n10, menu2);
    }

    public View onCreatePanelView(int n10) {
        return this.mWrapped.onCreatePanelView(n10);
    }

    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int n10, MenuItem menuItem) {
        return this.mWrapped.onMenuItemSelected(n10, menuItem);
    }

    public boolean onMenuOpened(int n10, Menu menu2) {
        return this.mWrapped.onMenuOpened(n10, menu2);
    }

    public void onPanelClosed(int n10, Menu menu2) {
        this.mWrapped.onPanelClosed(n10, menu2);
    }

    public void onPointerCaptureChanged(boolean bl2) {
        this.mWrapped.onPointerCaptureChanged(bl2);
    }

    public boolean onPreparePanel(int n10, View view, Menu menu2) {
        return this.mWrapped.onPreparePanel(n10, view, menu2);
    }

    public void onProvideKeyboardShortcuts(List list, Menu menu2, int n10) {
        this.mWrapped.onProvideKeyboardShortcuts(list, menu2, n10);
    }

    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.mWrapped.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mWrapped.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean bl2) {
        this.mWrapped.onWindowFocusChanged(bl2);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.mWrapped.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int n10) {
        return this.mWrapped.onWindowStartingActionMode(callback, n10);
    }
}

