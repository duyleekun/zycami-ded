/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnMultiChoiceClickListener
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.View
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.ListAdapter
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController$AlertParams;
import androidx.appcompat.app.AlertDialog;

public class AlertDialog$Builder {
    private final AlertController$AlertParams P;
    private final int mTheme;

    public AlertDialog$Builder(Context context) {
        int n10 = AlertDialog.resolveDialogTheme(context, 0);
        this(context, n10);
    }

    public AlertDialog$Builder(Context context, int n10) {
        AlertController$AlertParams alertController$AlertParams;
        int n11 = AlertDialog.resolveDialogTheme(context, n10);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, n11);
        this.P = alertController$AlertParams = new AlertController$AlertParams((Context)contextThemeWrapper);
        this.mTheme = n10;
    }

    public AlertDialog create() {
        Object object = this.P.mContext;
        int n10 = this.mTheme;
        AlertDialog alertDialog = new AlertDialog((Context)object, n10);
        object = this.P;
        AlertController alertController = alertDialog.mAlert;
        ((AlertController$AlertParams)object).apply(alertController);
        boolean bl2 = this.P.mCancelable;
        alertDialog.setCancelable(bl2);
        object = this.P;
        bl2 = ((AlertController$AlertParams)object).mCancelable;
        if (bl2) {
            bl2 = true;
            alertDialog.setCanceledOnTouchOutside(bl2);
        }
        object = this.P.mOnCancelListener;
        alertDialog.setOnCancelListener((DialogInterface.OnCancelListener)object);
        object = this.P.mOnDismissListener;
        alertDialog.setOnDismissListener((DialogInterface.OnDismissListener)object);
        object = this.P.mOnKeyListener;
        if (object != null) {
            alertDialog.setOnKeyListener((DialogInterface.OnKeyListener)object);
        }
        return alertDialog;
    }

    public Context getContext() {
        return this.P.mContext;
    }

    public AlertDialog$Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mAdapter = listAdapter;
        alertController$AlertParams.mOnClickListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setCancelable(boolean bl2) {
        this.P.mCancelable = bl2;
        return this;
    }

    public AlertDialog$Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String string2) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mCursor = cursor;
        alertController$AlertParams.mLabelColumn = string2;
        alertController$AlertParams.mOnClickListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setCustomTitle(View view) {
        this.P.mCustomTitleView = view;
        return this;
    }

    public AlertDialog$Builder setIcon(int n10) {
        this.P.mIconId = n10;
        return this;
    }

    public AlertDialog$Builder setIcon(Drawable drawable2) {
        this.P.mIcon = drawable2;
        return this;
    }

    public AlertDialog$Builder setIconAttribute(int n10) {
        int n11;
        TypedValue typedValue = new TypedValue();
        this.P.mContext.getTheme().resolveAttribute(n10, typedValue, true);
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mIconId = n11 = typedValue.resourceId;
        return this;
    }

    public AlertDialog$Builder setInverseBackgroundForced(boolean bl2) {
        this.P.mForceInverseBackground = bl2;
        return this;
    }

    public AlertDialog$Builder setItems(int n10, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        CharSequence[] charSequenceArray = alertController$AlertParams.mContext.getResources().getTextArray(n10);
        alertController$AlertParams.mItems = charSequenceArray;
        this.P.mOnClickListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setItems(CharSequence[] charSequenceArray, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mItems = charSequenceArray;
        alertController$AlertParams.mOnClickListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setMessage(int n10) {
        CharSequence charSequence;
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mMessage = charSequence = alertController$AlertParams.mContext.getText(n10);
        return this;
    }

    public AlertDialog$Builder setMessage(CharSequence charSequence) {
        this.P.mMessage = charSequence;
        return this;
    }

    public AlertDialog$Builder setMultiChoiceItems(int n10, boolean[] blArray, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        Object object = alertController$AlertParams.mContext.getResources().getTextArray(n10);
        alertController$AlertParams.mItems = object;
        object = this.P;
        object.mOnCheckboxClickListener = onMultiChoiceClickListener;
        object.mCheckedItems = blArray;
        object.mIsMultiChoice = true;
        return this;
    }

    public AlertDialog$Builder setMultiChoiceItems(Cursor cursor, String string2, String string3, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mCursor = cursor;
        alertController$AlertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
        alertController$AlertParams.mIsCheckedColumn = string2;
        alertController$AlertParams.mLabelColumn = string3;
        alertController$AlertParams.mIsMultiChoice = true;
        return this;
    }

    public AlertDialog$Builder setMultiChoiceItems(CharSequence[] charSequenceArray, boolean[] blArray, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mItems = charSequenceArray;
        alertController$AlertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
        alertController$AlertParams.mCheckedItems = blArray;
        alertController$AlertParams.mIsMultiChoice = true;
        return this;
    }

    public AlertDialog$Builder setNegativeButton(int n10, DialogInterface.OnClickListener onClickListener) {
        CharSequence charSequence;
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mNegativeButtonText = charSequence = alertController$AlertParams.mContext.getText(n10);
        this.P.mNegativeButtonListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mNegativeButtonText = charSequence;
        alertController$AlertParams.mNegativeButtonListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setNegativeButtonIcon(Drawable drawable2) {
        this.P.mNegativeButtonIcon = drawable2;
        return this;
    }

    public AlertDialog$Builder setNeutralButton(int n10, DialogInterface.OnClickListener onClickListener) {
        CharSequence charSequence;
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mNeutralButtonText = charSequence = alertController$AlertParams.mContext.getText(n10);
        this.P.mNeutralButtonListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mNeutralButtonText = charSequence;
        alertController$AlertParams.mNeutralButtonListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setNeutralButtonIcon(Drawable drawable2) {
        this.P.mNeutralButtonIcon = drawable2;
        return this;
    }

    public AlertDialog$Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.P.mOnCancelListener = onCancelListener;
        return this;
    }

    public AlertDialog$Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.P.mOnDismissListener = onDismissListener;
        return this;
    }

    public AlertDialog$Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.P.mOnItemSelectedListener = onItemSelectedListener;
        return this;
    }

    public AlertDialog$Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.P.mOnKeyListener = onKeyListener;
        return this;
    }

    public AlertDialog$Builder setPositiveButton(int n10, DialogInterface.OnClickListener onClickListener) {
        CharSequence charSequence;
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mPositiveButtonText = charSequence = alertController$AlertParams.mContext.getText(n10);
        this.P.mPositiveButtonListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mPositiveButtonText = charSequence;
        alertController$AlertParams.mPositiveButtonListener = onClickListener;
        return this;
    }

    public AlertDialog$Builder setPositiveButtonIcon(Drawable drawable2) {
        this.P.mPositiveButtonIcon = drawable2;
        return this;
    }

    public AlertDialog$Builder setRecycleOnMeasureEnabled(boolean bl2) {
        this.P.mRecycleOnMeasure = bl2;
        return this;
    }

    public AlertDialog$Builder setSingleChoiceItems(int n10, int n11, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        Object object = alertController$AlertParams.mContext.getResources().getTextArray(n10);
        alertController$AlertParams.mItems = object;
        object = this.P;
        object.mOnClickListener = onClickListener;
        object.mCheckedItem = n11;
        object.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog$Builder setSingleChoiceItems(Cursor cursor, int n10, String string2, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mCursor = cursor;
        alertController$AlertParams.mOnClickListener = onClickListener;
        alertController$AlertParams.mCheckedItem = n10;
        alertController$AlertParams.mLabelColumn = string2;
        alertController$AlertParams.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog$Builder setSingleChoiceItems(ListAdapter listAdapter, int n10, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mAdapter = listAdapter;
        alertController$AlertParams.mOnClickListener = onClickListener;
        alertController$AlertParams.mCheckedItem = n10;
        alertController$AlertParams.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog$Builder setSingleChoiceItems(CharSequence[] charSequenceArray, int n10, DialogInterface.OnClickListener onClickListener) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mItems = charSequenceArray;
        alertController$AlertParams.mOnClickListener = onClickListener;
        alertController$AlertParams.mCheckedItem = n10;
        alertController$AlertParams.mIsSingleChoice = true;
        return this;
    }

    public AlertDialog$Builder setTitle(int n10) {
        CharSequence charSequence;
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mTitle = charSequence = alertController$AlertParams.mContext.getText(n10);
        return this;
    }

    public AlertDialog$Builder setTitle(CharSequence charSequence) {
        this.P.mTitle = charSequence;
        return this;
    }

    public AlertDialog$Builder setView(int n10) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mView = null;
        alertController$AlertParams.mViewLayoutResId = n10;
        alertController$AlertParams.mViewSpacingSpecified = false;
        return this;
    }

    public AlertDialog$Builder setView(View view) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mView = view;
        alertController$AlertParams.mViewLayoutResId = 0;
        alertController$AlertParams.mViewSpacingSpecified = false;
        return this;
    }

    public AlertDialog$Builder setView(View view, int n10, int n11, int n12, int n13) {
        AlertController$AlertParams alertController$AlertParams = this.P;
        alertController$AlertParams.mView = view;
        alertController$AlertParams.mViewLayoutResId = 0;
        alertController$AlertParams.mViewSpacingSpecified = true;
        alertController$AlertParams.mViewSpacingLeft = n10;
        alertController$AlertParams.mViewSpacingTop = n11;
        alertController$AlertParams.mViewSpacingRight = n12;
        alertController$AlertParams.mViewSpacingBottom = n13;
        return this;
    }

    public AlertDialog show() {
        AlertDialog alertDialog = this.create();
        alertDialog.show();
        return alertDialog;
    }
}

