/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.widget.ListAdapter
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup;

public class AppCompatSpinner$DialogPopup
implements AppCompatSpinner$SpinnerPopup,
DialogInterface.OnClickListener {
    private ListAdapter mListAdapter;
    public AlertDialog mPopup;
    private CharSequence mPrompt;
    public final /* synthetic */ AppCompatSpinner this$0;

    public AppCompatSpinner$DialogPopup(AppCompatSpinner appCompatSpinner) {
        this.this$0 = appCompatSpinner;
    }

    public void dismiss() {
        AlertDialog alertDialog = this.mPopup;
        if (alertDialog != null) {
            alertDialog.dismiss();
            alertDialog = null;
            this.mPopup = null;
        }
    }

    public Drawable getBackground() {
        return null;
    }

    public CharSequence getHintText() {
        return this.mPrompt;
    }

    public int getHorizontalOffset() {
        return 0;
    }

    public int getHorizontalOriginalOffset() {
        return 0;
    }

    public int getVerticalOffset() {
        return 0;
    }

    public boolean isShowing() {
        boolean bl2;
        AlertDialog alertDialog = this.mPopup;
        if (alertDialog != null) {
            bl2 = alertDialog.isShowing();
        } else {
            bl2 = false;
            alertDialog = null;
        }
        return bl2;
    }

    public void onClick(DialogInterface object, int n10) {
        this.this$0.setSelection(n10);
        object = this.this$0.getOnItemClickListener();
        if (object != null) {
            object = this.this$0;
            ListAdapter listAdapter = this.mListAdapter;
            long l10 = listAdapter.getItemId(n10);
            object.performItemClick(null, n10, l10);
        }
        this.dismiss();
    }

    public void setAdapter(ListAdapter listAdapter) {
        this.mListAdapter = listAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        Log.e((String)"AppCompatSpinner", (String)"Cannot set popup background for MODE_DIALOG, ignoring");
    }

    public void setHorizontalOffset(int n10) {
        Log.e((String)"AppCompatSpinner", (String)"Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    public void setHorizontalOriginalOffset(int n10) {
        Log.e((String)"AppCompatSpinner", (String)"Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    public void setPromptText(CharSequence charSequence) {
        this.mPrompt = charSequence;
    }

    public void setVerticalOffset(int n10) {
        Log.e((String)"AppCompatSpinner", (String)"Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    public void show(int n10, int n11) {
        Object object = this.mListAdapter;
        if (object == null) {
            return;
        }
        Object object2 = this.this$0.getPopupContext();
        object = new AlertDialog$Builder((Context)object2);
        object2 = this.mPrompt;
        if (object2 != null) {
            ((AlertDialog$Builder)object).setTitle((CharSequence)object2);
        }
        object2 = this.mListAdapter;
        AppCompatSpinner appCompatSpinner = this.this$0;
        int n12 = appCompatSpinner.getSelectedItemPosition();
        this.mPopup = object = ((AlertDialog$Builder)object).setSingleChoiceItems((ListAdapter)object2, n12, (DialogInterface.OnClickListener)this).create();
        object = ((AlertDialog)object).getListView();
        int n13 = Build.VERSION.SDK_INT;
        n12 = 17;
        if (n13 >= n12) {
            object.setTextDirection(n10);
            object.setTextAlignment(n11);
        }
        this.mPopup.show();
    }
}

