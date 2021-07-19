/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ActivityChooserView$ActivityChooserViewAdapter;
import androidx.core.view.ActionProvider;

public class ActivityChooserView$Callbacks
implements AdapterView.OnItemClickListener,
View.OnClickListener,
View.OnLongClickListener,
PopupWindow.OnDismissListener {
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$Callbacks(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    private void notifyOnDismissListener() {
        PopupWindow.OnDismissListener onDismissListener = this.this$0.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void onClick(View object) {
        block7: {
            block6: {
                FrameLayout frameLayout;
                Object object2;
                block5: {
                    object2 = this.this$0;
                    frameLayout = ((ActivityChooserView)object2).mDefaultActivityButton;
                    if (object != frameLayout) break block5;
                    ((ActivityChooserView)object2).dismissPopup();
                    object = this.this$0.mAdapter.getDefaultActivity();
                    int n10 = this.this$0.mAdapter.getDataModel().getActivityIndex((ResolveInfo)object);
                    object2 = this.this$0.mAdapter.getDataModel();
                    object = ((ActivityChooserModel)((Object)object2)).chooseActivity(n10);
                    if (object != null) {
                        int n11 = 524288;
                        object.addFlags(n11);
                        object2 = this.this$0.getContext();
                        object2.startActivity((Intent)object);
                    }
                    break block6;
                }
                frameLayout = ((ActivityChooserView)object2).mExpandActivityOverflowButton;
                if (object != frameLayout) break block7;
                object = null;
                ((ActivityChooserView)object2).mIsSelectingDefaultActivity = false;
                int n12 = ((ActivityChooserView)object2).mInitialActivityCount;
                ((ActivityChooserView)object2).showPopupUnchecked(n12);
            }
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public void onDismiss() {
        this.notifyOnDismissListener();
        ActionProvider actionProvider = this.this$0.mProvider;
        if (actionProvider != null) {
            actionProvider.subUiVisibilityChanged(false);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public void onItemClick(AdapterView object, View view, int n10, long l10) {
        void var3_10;
        ActivityChooserView$ActivityChooserViewAdapter activityChooserView$ActivityChooserViewAdapter = (ActivityChooserView$ActivityChooserViewAdapter)object.getAdapter();
        int n11 = activityChooserView$ActivityChooserViewAdapter.getItemViewType((int)var3_10);
        if (n11 != 0) {
            int n12 = 1;
            if (n11 == n12) {
                ActivityChooserView activityChooserView = this.this$0;
                n12 = -1 >>> 1;
                activityChooserView.showPopupUnchecked(n12);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            throw illegalArgumentException;
        }
        this.this$0.dismissPopup();
        ActivityChooserView activityChooserView = this.this$0;
        int n13 = activityChooserView.mIsSelectingDefaultActivity;
        if (n13 != 0) {
            if (var3_10 <= 0) return;
            ActivityChooserModel activityChooserModel = activityChooserView.mAdapter.getDataModel();
            activityChooserModel.setDefaultActivity((int)var3_10);
            return;
        }
        ActivityChooserView$ActivityChooserViewAdapter activityChooserView$ActivityChooserViewAdapter2 = activityChooserView.mAdapter;
        n11 = activityChooserView$ActivityChooserViewAdapter2.getShowDefaultActivity() ? 1 : 0;
        if (n11 != 0) {
            // empty if block
        }
        Intent intent = this.this$0.mAdapter.getDataModel().chooseActivity((int)(++var3_10));
        if (intent == null) return;
        n13 = 524288;
        intent.addFlags(n13);
        Context context = this.this$0.getContext();
        context.startActivity(intent);
    }

    public boolean onLongClick(View object) {
        ActivityChooserView activityChooserView = this.this$0;
        FrameLayout frameLayout = activityChooserView.mDefaultActivityButton;
        if (object == frameLayout) {
            object = activityChooserView.mAdapter;
            int n10 = ((ActivityChooserView$ActivityChooserViewAdapter)((Object)object)).getCount();
            boolean bl2 = true;
            if (n10 > 0) {
                object = this.this$0;
                ((ActivityChooserView)object).mIsSelectingDefaultActivity = bl2;
                int n11 = ((ActivityChooserView)object).mInitialActivityCount;
                ((ActivityChooserView)object).showPopupUnchecked(n11);
            }
            return bl2;
        }
        object = new IllegalArgumentException();
        throw object;
    }
}

