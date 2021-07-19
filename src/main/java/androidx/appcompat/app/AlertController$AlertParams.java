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
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.SimpleCursorAdapter
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController$AlertParams$1;
import androidx.appcompat.app.AlertController$AlertParams$2;
import androidx.appcompat.app.AlertController$AlertParams$3;
import androidx.appcompat.app.AlertController$AlertParams$4;
import androidx.appcompat.app.AlertController$AlertParams$OnPrepareListViewListener;
import androidx.appcompat.app.AlertController$CheckedItemAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

public class AlertController$AlertParams {
    public ListAdapter mAdapter;
    public boolean mCancelable;
    public int mCheckedItem = -1;
    public boolean[] mCheckedItems;
    public final Context mContext;
    public Cursor mCursor;
    public View mCustomTitleView;
    public boolean mForceInverseBackground;
    public Drawable mIcon;
    public int mIconAttrId = 0;
    public int mIconId = 0;
    public final LayoutInflater mInflater;
    public String mIsCheckedColumn;
    public boolean mIsMultiChoice;
    public boolean mIsSingleChoice;
    public CharSequence[] mItems;
    public String mLabelColumn;
    public CharSequence mMessage;
    public Drawable mNegativeButtonIcon;
    public DialogInterface.OnClickListener mNegativeButtonListener;
    public CharSequence mNegativeButtonText;
    public Drawable mNeutralButtonIcon;
    public DialogInterface.OnClickListener mNeutralButtonListener;
    public CharSequence mNeutralButtonText;
    public DialogInterface.OnCancelListener mOnCancelListener;
    public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
    public DialogInterface.OnClickListener mOnClickListener;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    public DialogInterface.OnKeyListener mOnKeyListener;
    public AlertController$AlertParams$OnPrepareListViewListener mOnPrepareListViewListener;
    public Drawable mPositiveButtonIcon;
    public DialogInterface.OnClickListener mPositiveButtonListener;
    public CharSequence mPositiveButtonText;
    public boolean mRecycleOnMeasure;
    public CharSequence mTitle;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public boolean mViewSpacingSpecified = false;
    public int mViewSpacingTop;

    public AlertController$AlertParams(Context context) {
        boolean bl2;
        this.mRecycleOnMeasure = bl2 = true;
        this.mContext = context;
        this.mCancelable = bl2;
        context = (LayoutInflater)context.getSystemService("layout_inflater");
        this.mInflater = context;
    }

    private void createListView(AlertController alertController) {
        Object object;
        Object object2;
        Object object3 = this.mInflater;
        int n10 = alertController.mListLayout;
        int n11 = 0;
        object3 = (AlertController$RecycleListView)object3.inflate(n10, null);
        n10 = this.mIsMultiChoice ? 1 : 0;
        int n12 = 1;
        if (n10 != 0) {
            object2 = this.mCursor;
            if (object2 == null) {
                Context context = this.mContext;
                int n13 = alertController.mMultiChoiceItemLayout;
                int n14 = 16908308;
                CharSequence[] charSequenceArray = this.mItems;
                object2 = object;
                object = new AlertController$AlertParams$1(this, context, n13, n14, charSequenceArray, (AlertController$RecycleListView)((Object)object3));
            } else {
                Context context = this.mContext;
                Cursor cursor = this.mCursor;
                boolean bl2 = false;
                Object var13_20 = null;
                object2 = object;
                Object object4 = object3;
                object = new AlertController$AlertParams$2(this, context, cursor, false, (AlertController$RecycleListView)((Object)object3), alertController);
            }
        } else {
            n10 = this.mIsSingleChoice ? 1 : 0;
            n10 = n10 != 0 ? alertController.mSingleChoiceItemLayout : alertController.mListItemLayout;
            int n15 = n10;
            object2 = this.mCursor;
            n11 = 16908308;
            if (object2 != null) {
                Context context = this.mContext;
                Cursor cursor = this.mCursor;
                String[] stringArray = new String[n12];
                object2 = this.mLabelColumn;
                stringArray[0] = object2;
                object2 = new int[n12];
                object2[0] = (Cursor)n11;
                object = new SimpleCursorAdapter(context, n10, cursor, stringArray, (int[])object2);
            } else {
                object = this.mAdapter;
                if (object == null) {
                    object2 = this.mContext;
                    CharSequence[] charSequenceArray = this.mItems;
                    object = new AlertController$CheckedItemAdapter((Context)object2, n10, n11, charSequenceArray);
                }
            }
        }
        object2 = this.mOnPrepareListViewListener;
        if (object2 != null) {
            object2.onPrepareListView((ListView)object3);
        }
        alertController.mAdapter = object;
        alertController.mCheckedItem = n10 = this.mCheckedItem;
        object2 = this.mOnClickListener;
        if (object2 != null) {
            object2 = new AlertController$AlertParams$3(this, alertController);
            object3.setOnItemClickListener((AdapterView.OnItemClickListener)object2);
        } else {
            object2 = this.mOnCheckboxClickListener;
            if (object2 != null) {
                object2 = new AlertController$AlertParams$4(this, (AlertController$RecycleListView)((Object)object3), alertController);
                object3.setOnItemClickListener((AdapterView.OnItemClickListener)object2);
            }
        }
        object2 = this.mOnItemSelectedListener;
        if (object2 != null) {
            object3.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)object2);
        }
        if ((n10 = (int)(this.mIsSingleChoice ? 1 : 0)) != 0) {
            object3.setChoiceMode(n12);
        } else {
            n10 = this.mIsMultiChoice ? 1 : 0;
            if (n10 != 0) {
                n10 = 2;
                object3.setChoiceMode(n10);
            }
        }
        alertController.mListView = object3;
    }

    public void apply(AlertController alertController) {
        int n10;
        CharSequence charSequence;
        CharSequence charSequence2;
        Drawable drawable2;
        int n11;
        DialogInterface.OnClickListener onClickListener;
        CharSequence charSequence3;
        int n12;
        Object object = this.mCustomTitleView;
        if (object != null) {
            alertController.setCustomTitle((View)object);
        } else {
            object = this.mTitle;
            if (object != null) {
                alertController.setTitle((CharSequence)object);
            }
            if ((object = this.mIcon) != null) {
                alertController.setIcon((Drawable)object);
            }
            if ((n12 = this.mIconId) != 0) {
                alertController.setIcon(n12);
            }
            if ((n12 = this.mIconAttrId) != 0) {
                n12 = alertController.getIconAttributeResId(n12);
                alertController.setIcon(n12);
            }
        }
        object = this.mMessage;
        if (object != null) {
            alertController.setMessage((CharSequence)object);
        }
        if ((charSequence3 = this.mPositiveButtonText) != null || (object = this.mPositiveButtonIcon) != null) {
            int n13 = -1;
            onClickListener = this.mPositiveButtonListener;
            n11 = 0;
            drawable2 = null;
            Drawable drawable3 = this.mPositiveButtonIcon;
            alertController.setButton(n13, charSequence3, onClickListener, null, drawable3);
        }
        if ((charSequence2 = this.mNegativeButtonText) != null || (object = this.mNegativeButtonIcon) != null) {
            int n14 = -2;
            DialogInterface.OnClickListener onClickListener2 = this.mNegativeButtonListener;
            Drawable drawable4 = this.mNegativeButtonIcon;
            alertController.setButton(n14, charSequence2, onClickListener2, null, drawable4);
        }
        if ((charSequence = this.mNeutralButtonText) != null || (object = this.mNeutralButtonIcon) != null) {
            int n15 = -3;
            charSequence3 = this.mNeutralButtonListener;
            n10 = 0;
            onClickListener = null;
            drawable2 = this.mNeutralButtonIcon;
            object = alertController;
            alertController.setButton(n15, charSequence, (DialogInterface.OnClickListener)charSequence3, null, drawable2);
        }
        if ((object = this.mItems) != null || (object = this.mCursor) != null || (object = this.mAdapter) != null) {
            this.createListView(alertController);
        }
        if ((charSequence = this.mView) != null) {
            n12 = this.mViewSpacingSpecified ? 1 : 0;
            if (n12 != 0) {
                int n16 = this.mViewSpacingLeft;
                n10 = this.mViewSpacingTop;
                n11 = this.mViewSpacingRight;
                int n17 = this.mViewSpacingBottom;
                alertController.setView((View)charSequence, n16, n10, n11, n17);
            } else {
                alertController.setView((View)charSequence);
            }
        } else {
            n12 = this.mViewLayoutResId;
            if (n12 != 0) {
                alertController.setView(n12);
            }
        }
    }
}

