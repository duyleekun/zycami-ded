/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

public class AppCompatDelegateImpl$ActionModeCallbackWrapperV9
implements ActionMode$Callback {
    private ActionMode$Callback mWrapped;
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$ActionModeCallbackWrapperV9(AppCompatDelegateImpl appCompatDelegateImpl, ActionMode$Callback actionMode$Callback) {
        this.this$0 = appCompatDelegateImpl;
        this.mWrapped = actionMode$Callback;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mWrapped.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu2) {
        return this.mWrapped.onCreateActionMode(actionMode, menu2);
    }

    public void onDestroyActionMode(ActionMode object) {
        this.mWrapped.onDestroyActionMode((ActionMode)object);
        object = this.this$0;
        Object object2 = ((AppCompatDelegateImpl)object).mActionModePopup;
        if (object2 != null) {
            object = ((AppCompatDelegateImpl)object).mWindow.getDecorView();
            object2 = this.this$0.mShowActionModePopup;
            object.removeCallbacks((Runnable)object2);
        }
        object = this.this$0;
        object2 = ((AppCompatDelegateImpl)object).mActionModeView;
        if (object2 != null) {
            ((AppCompatDelegateImpl)object).endOnGoingFadeAnimation();
            object = this.this$0;
            object2 = ViewCompat.animate((View)((AppCompatDelegateImpl)object).mActionModeView).alpha(0.0f);
            ((AppCompatDelegateImpl)object).mFadeAnim = object2;
            object = this.this$0.mFadeAnim;
            object2 = new AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1(this);
            ((ViewPropertyAnimatorCompat)object).setListener((ViewPropertyAnimatorListener)object2);
        }
        object = this.this$0;
        object2 = ((AppCompatDelegateImpl)object).mAppCompatCallback;
        if (object2 != null) {
            object = ((AppCompatDelegateImpl)object).mActionMode;
            object2.onSupportActionModeFinished((ActionMode)object);
        }
        object = this.this$0;
        ((AppCompatDelegateImpl)object).mActionMode = null;
        ViewCompat.requestApplyInsets((View)((AppCompatDelegateImpl)object).mSubDecor);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu2) {
        ViewCompat.requestApplyInsets((View)this.this$0.mSubDecor);
        return this.mWrapped.onPrepareActionMode(actionMode, menu2);
    }
}

