/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 */
package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment$1;
import androidx.fragment.app.DialogFragment$2;
import androidx.fragment.app.DialogFragment$3;
import androidx.fragment.app.DialogFragment$4;
import androidx.fragment.app.DialogFragment$5;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class DialogFragment
extends Fragment
implements DialogInterface.OnCancelListener,
DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId;
    private boolean mCancelable;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDialogCreated;
    private Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private Observer mObserver;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;

    public DialogFragment() {
        boolean bl2;
        Object object = new DialogFragment$1(this);
        this.mDismissRunnable = object;
        object = new DialogFragment$2(this);
        this.mOnCancelListener = object;
        object = new DialogFragment$3(this);
        this.mOnDismissListener = object;
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = bl2 = true;
        this.mShowsDialog = bl2;
        this.mBackStackId = -1;
        DialogFragment$4 dialogFragment$4 = new DialogFragment$4(this);
        this.mObserver = dialogFragment$4;
        this.mDialogCreated = false;
    }

    public DialogFragment(int n10) {
        super(n10);
        boolean bl2;
        Object object = new DialogFragment$1(this);
        this.mDismissRunnable = object;
        object = new DialogFragment$2(this);
        this.mOnCancelListener = object;
        object = new DialogFragment$3(this);
        this.mOnDismissListener = object;
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = bl2 = true;
        this.mShowsDialog = bl2;
        this.mBackStackId = -1;
        DialogFragment$4 dialogFragment$4 = new DialogFragment$4(this);
        this.mObserver = dialogFragment$4;
        this.mDialogCreated = false;
    }

    public static /* synthetic */ Dialog access$000(DialogFragment dialogFragment) {
        return dialogFragment.mDialog;
    }

    public static /* synthetic */ DialogInterface.OnDismissListener access$100(DialogFragment dialogFragment) {
        return dialogFragment.mOnDismissListener;
    }

    public static /* synthetic */ boolean access$200(DialogFragment dialogFragment) {
        return dialogFragment.mShowsDialog;
    }

    private void dismissInternal(boolean bl2, boolean n10) {
        Object object;
        int n11;
        int n12 = (int)(this.mDismissed ? 1 : 0);
        if (n12 != 0) {
            return;
        }
        n12 = 1;
        this.mDismissed = n12;
        this.mShownByMe = false;
        Object object2 = this.mDialog;
        if (object2 != null) {
            object2.setOnDismissListener(null);
            object2 = this.mDialog;
            object2.dismiss();
            if (n11 == 0) {
                object = Looper.myLooper();
                if (object == (object2 = this.mHandler.getLooper())) {
                    object = this.mDialog;
                    this.onDismiss((DialogInterface)object);
                } else {
                    object = this.mHandler;
                    object2 = this.mDismissRunnable;
                    object.post((Runnable)object2);
                }
            }
        }
        this.mViewDestroyed = n12;
        n11 = this.mBackStackId;
        if (n11 >= 0) {
            int n13;
            FragmentManager fragmentManager = this.getParentFragmentManager();
            n11 = this.mBackStackId;
            fragmentManager.popBackStack(n11, n12);
            this.mBackStackId = n13 = -1;
        } else {
            object = this.getParentFragmentManager().beginTransaction();
            ((FragmentTransaction)object).remove(this);
            if (bl2) {
                ((FragmentTransaction)object).commitAllowingStateLoss();
            } else {
                ((FragmentTransaction)object).commit();
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void prepareDialog(Bundle var1_1) {
        block20: {
            block19: {
                var2_3 = this.mShowsDialog;
                if (!var2_3) {
                    return;
                }
                var2_3 = this.mDialogCreated;
                if (var2_3) break block20;
                var2_3 = false;
                var3_4 = true;
                this.mCreatingDialog = var3_4;
                var1_1 = this.onCreateDialog(var1_1);
                this.mDialog = var1_1;
                var4_5 = this.mShowsDialog;
                if (!var4_5) break block19;
                var4_5 = this.mStyle;
                this.setupDialog((Dialog)var1_1, (int)var4_5);
                var1_1 = this.getContext();
                var4_5 = var1_1 instanceof Activity;
                if (!var4_5) ** GOTO lbl29
                var5_6 = this.mDialog;
                var1_1 = (Activity)var1_1;
                var5_6.setOwnerActivity((Activity)var1_1);
lbl29:
                // 2 sources

                var1_1 = this.mDialog;
                var4_5 = this.mCancelable;
                var1_1.setCancelable(var4_5);
                var1_1 = this.mDialog;
                var5_6 = this.mOnCancelListener;
                var1_1.setOnCancelListener((DialogInterface.OnCancelListener)var5_6);
                var1_1 = this.mDialog;
                var5_6 = this.mOnDismissListener;
                var1_1.setOnDismissListener((DialogInterface.OnDismissListener)var5_6);
                this.mDialogCreated = var3_4;
                break block20;
            }
            var1_1 = null;
            try {
                this.mDialog = null;
            }
            finally {
                this.mCreatingDialog = false;
            }
        }
    }

    public FragmentContainer createFragmentContainer() {
        FragmentContainer fragmentContainer = super.createFragmentContainer();
        DialogFragment$5 dialogFragment$5 = new DialogFragment$5(this, fragmentContainer);
        return dialogFragment$5;
    }

    public void dismiss() {
        this.dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        this.dismissInternal(true, false);
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = this.getViewLifecycleOwnerLiveData();
        Observer observer = this.mObserver;
        ((LiveData)object).observeForever(observer);
        boolean bl2 = this.mShownByMe;
        if (!bl2) {
            bl2 = false;
            object = null;
            this.mDismissed = false;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onCreate(Bundle bundle) {
        Object object;
        super.onCreate(bundle);
        this.mHandler = object = new Handler();
        int n10 = this.mContainerId;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        this.mShowsDialog = n10;
        if (bundle != null) {
            int n12;
            this.mStyle = n10 = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = n10 = bundle.getInt(SAVED_THEME, 0);
            object = SAVED_CANCELABLE;
            this.mCancelable = n10 = bundle.getBoolean((String)object, n11 != 0);
            n10 = this.mShowsDialog;
            this.mShowsDialog = n10 = bundle.getBoolean(SAVED_SHOWS_DIALOG, n10 != 0);
            n10 = -1;
            String string2 = SAVED_BACK_STACK_ID;
            this.mBackStackId = n12 = bundle.getInt(string2, n10);
        }
    }

    public Dialog onCreateDialog(Bundle object) {
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onCreateDialog called for DialogFragment ");
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            object2 = "FragmentManager";
            Log.d((String)object2, (String)object);
        }
        object2 = this.requireContext();
        int n10 = this.getTheme();
        object = new Dialog(object2, n10);
        return object;
    }

    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            dialog = this.mDialog;
            dialog.dismiss();
            boolean bl2 = this.mDismissed;
            if (!bl2) {
                dialog = this.mDialog;
                this.onDismiss((DialogInterface)dialog);
            }
            this.mDialog = null;
            bl2 = false;
            dialog = null;
            this.mDialogCreated = false;
        }
    }

    public void onDetach() {
        super.onDetach();
        boolean bl2 = this.mShownByMe;
        if (!bl2 && !(bl2 = this.mDismissed)) {
            this.mDismissed = bl2 = true;
        }
        LiveData liveData = this.getViewLifecycleOwnerLiveData();
        Observer observer = this.mObserver;
        liveData.removeObserver(observer);
    }

    public void onDismiss(DialogInterface object) {
        boolean bl2 = this.mViewDestroyed;
        if (!bl2) {
            bl2 = FragmentManager.isLoggingEnabled(3);
            if (bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("onDismiss called for DialogFragment ");
                ((StringBuilder)object).append(this);
                object = ((StringBuilder)object).toString();
                String string2 = "FragmentManager";
                Log.d((String)string2, (String)object);
            }
            bl2 = true;
            this.dismissInternal(bl2, bl2);
        }
    }

    public View onFindViewById(int n10) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(n10);
        }
        return null;
    }

    public LayoutInflater onGetLayoutInflater(Bundle object) {
        LayoutInflater layoutInflater = super.onGetLayoutInflater((Bundle)object);
        boolean bl2 = this.mShowsDialog;
        int n10 = 2;
        String string2 = "FragmentManager";
        if (bl2 && !(bl2 = this.mCreatingDialog)) {
            this.prepareDialog((Bundle)object);
            boolean bl3 = FragmentManager.isLoggingEnabled(n10);
            if (bl3) {
                object = new StringBuilder();
                ((StringBuilder)object).append("get layout inflater for DialogFragment ");
                ((StringBuilder)object).append(this);
                String string3 = " from dialog context";
                ((StringBuilder)object).append(string3);
                object = ((StringBuilder)object).toString();
                Log.d((String)string2, (String)object);
            }
            if ((object = this.mDialog) != null) {
                object = object.getContext();
                layoutInflater = layoutInflater.cloneInContext((Context)object);
            }
            return layoutInflater;
        }
        boolean bl4 = FragmentManager.isLoggingEnabled(n10);
        if (bl4) {
            object = new StringBuilder();
            CharSequence charSequence = "getting layout inflater for DialogFragment ";
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            bl2 = this.mShowsDialog;
            if (!bl2) {
                charSequence = new StringBuilder();
                String string4 = "mShowsDialog = false: ";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                Log.d((String)string2, (String)object);
            } else {
                charSequence = new StringBuilder();
                String string5 = "mCreatingDialog = true: ";
                ((StringBuilder)charSequence).append(string5);
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                Log.d((String)string2, (String)object);
            }
        }
        return layoutInflater;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    public void onSaveInstanceState(Bundle bundle) {
        int n10;
        String string2;
        int n11;
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog = dialog.onSaveInstanceState();
            n11 = 0;
            String string3 = SAVED_INTERNAL_DIALOG_SHOWING;
            dialog.putBoolean(string3, false);
            string2 = SAVED_DIALOG_STATE_TAG;
            bundle.putBundle(string2, (Bundle)dialog);
        }
        if ((n10 = this.mStyle) != 0) {
            string2 = SAVED_STYLE;
            bundle.putInt(string2, n10);
        }
        if ((n10 = this.mTheme) != 0) {
            string2 = SAVED_THEME;
            bundle.putInt(string2, n10);
        }
        if ((n10 = (int)(this.mCancelable ? 1 : 0)) == 0) {
            string2 = SAVED_CANCELABLE;
            bundle.putBoolean(string2, n10 != 0);
        }
        if ((n10 = (int)(this.mShowsDialog ? 1 : 0)) == 0) {
            string2 = SAVED_SHOWS_DIALOG;
            bundle.putBoolean(string2, n10 != 0);
        }
        if ((n10 = this.mBackStackId) != (n11 = -1)) {
            string2 = SAVED_BACK_STACK_ID;
            bundle.putInt(string2, n10);
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            dialog = this.mDialog.getWindow().getDecorView();
            ViewTreeLifecycleOwner.set((View)dialog, this);
            ViewTreeViewModelStoreOwner.set((View)dialog, this);
            ViewTreeSavedStateRegistryOwner.set((View)dialog, this);
        }
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        Object object = this.mDialog;
        if (object != null && bundle != null && (bundle = bundle.getBundle((String)(object = SAVED_DIALOG_STATE_TAG))) != null) {
            object = this.mDialog;
            object.onRestoreInstanceState(bundle);
        }
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.performCreateView(layoutInflater, viewGroup, bundle);
        layoutInflater = this.mView;
        if (layoutInflater == null && (layoutInflater = this.mDialog) != null && bundle != null && (layoutInflater = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            viewGroup = this.mDialog;
            viewGroup.onRestoreInstanceState((Bundle)layoutInflater);
        }
    }

    public final Dialog requireDialog() {
        Object object = this.getDialog();
        if (object != null) {
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("DialogFragment ");
        charSequence.append(this);
        charSequence.append(" does not have a Dialog.");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public void setCancelable(boolean bl2) {
        this.mCancelable = bl2;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(bl2);
        }
    }

    public void setShowsDialog(boolean bl2) {
        this.mShowsDialog = bl2;
    }

    public void setStyle(int n10, int n11) {
        int n12 = 2;
        boolean bl2 = FragmentManager.isLoggingEnabled(n12);
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Setting style and theme for DialogFragment ");
            charSequence.append(this);
            charSequence.append(" to ");
            charSequence.append(n10);
            charSequence.append(", ");
            charSequence.append(n11);
            charSequence = charSequence.toString();
            String string2 = "FragmentManager";
            Log.d((String)string2, (String)charSequence);
        }
        this.mStyle = n10;
        if (n10 == n12 || n10 == (n12 = 3)) {
            this.mTheme = n10 = 16973913;
        }
        if (n11 != 0) {
            this.mTheme = n11;
        }
    }

    public void setupDialog(Dialog dialog, int n10) {
        block5: {
            int n11;
            block4: {
                int n12;
                n11 = 1;
                if (n10 == n11 || n10 == (n12 = 2)) break block4;
                n12 = 3;
                if (n10 != n12) break block5;
                Window window = dialog.getWindow();
                if (window != null) {
                    n12 = 24;
                    window.addFlags(n12);
                }
            }
            dialog.requestWindowFeature(n11);
        }
    }

    public int show(FragmentTransaction fragmentTransaction, String string2) {
        int n10;
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentTransaction.add(this, string2);
        this.mViewDestroyed = false;
        this.mBackStackId = n10 = fragmentTransaction.commit();
        return n10;
    }

    public void show(FragmentManager object, String string2) {
        this.mDismissed = false;
        this.mShownByMe = true;
        object = ((FragmentManager)object).beginTransaction();
        ((FragmentTransaction)object).add(this, string2);
        ((FragmentTransaction)object).commit();
    }

    public void showNow(FragmentManager object, String string2) {
        this.mDismissed = false;
        this.mShownByMe = true;
        object = ((FragmentManager)object).beginTransaction();
        ((FragmentTransaction)object).add(this, string2);
        ((FragmentTransaction)object).commitNow();
    }
}

