/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserView;

public class ActivityChooserView$ActivityChooserViewAdapter
extends BaseAdapter {
    private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
    private static final int ITEM_VIEW_TYPE_COUNT = 3;
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;
    public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
    public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
    private ActivityChooserModel mDataModel;
    private boolean mHighlightDefaultActivity;
    private int mMaxActivityCount = 4;
    private boolean mShowDefaultActivity;
    private boolean mShowFooterView;
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$ActivityChooserViewAdapter(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    public int getActivityCount() {
        return this.mDataModel.getActivityCount();
    }

    public int getCount() {
        ResolveInfo resolveInfo;
        ActivityChooserModel activityChooserModel = this.mDataModel;
        int n10 = activityChooserModel.getActivityCount();
        int n11 = this.mShowDefaultActivity;
        if (n11 == 0 && (resolveInfo = this.mDataModel.getDefaultActivity()) != null) {
            n10 += -1;
        }
        n11 = this.mMaxActivityCount;
        n10 = Math.min(n10, n11);
        n11 = this.mShowFooterView ? 1 : 0;
        if (n11 != 0) {
            ++n10;
        }
        return n10;
    }

    public ActivityChooserModel getDataModel() {
        return this.mDataModel;
    }

    public ResolveInfo getDefaultActivity() {
        return this.mDataModel.getDefaultActivity();
    }

    public int getHistorySize() {
        return this.mDataModel.getHistorySize();
    }

    public Object getItem(int n10) {
        ResolveInfo resolveInfo;
        int n11 = this.getItemViewType(n10);
        if (n11 != 0) {
            n10 = 1;
            if (n11 == n10) {
                return null;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            throw illegalArgumentException;
        }
        n11 = this.mShowDefaultActivity ? 1 : 0;
        if (n11 == 0 && (resolveInfo = this.mDataModel.getDefaultActivity()) != null) {
            ++n10;
        }
        return this.mDataModel.getActivity(n10);
    }

    public long getItemId(int n10) {
        return n10;
    }

    public int getItemViewType(int n10) {
        int n11 = this.mShowFooterView;
        if (n11 != 0) {
            n11 = this.getCount();
            int n12 = 1;
            if (n10 == (n11 -= n12)) {
                return n12;
            }
        }
        return 0;
    }

    public boolean getShowDefaultActivity() {
        return this.mShowDefaultActivity;
    }

    public View getView(int n10, View view, ViewGroup object) {
        int n11;
        int n12 = this.getItemViewType(n10);
        int n13 = 1;
        if (n12) {
            if (n12 == n13) {
                if (view == null || (n10 = view.getId()) != n13) {
                    LayoutInflater layoutInflater = LayoutInflater.from((Context)this.this$0.getContext());
                    int n14 = R$layout.abc_activity_chooser_view_list_item;
                    view = layoutInflater.inflate(n14, object, false);
                    view.setId(n13);
                    n10 = R$id.title;
                    layoutInflater = (TextView)view.findViewById(n10);
                    object = this.this$0.getContext();
                    n12 = R$string.abc_activity_chooser_view_see_all;
                    object = object.getString(n12);
                    layoutInflater.setText((CharSequence)object);
                }
                return view;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            throw illegalArgumentException;
        }
        if (view == null || (n12 = view.getId()) != (n11 = R$id.list_item)) {
            view = LayoutInflater.from((Context)this.this$0.getContext());
            n12 = R$layout.abc_activity_chooser_view_list_item;
            view = view.inflate(n12, object, false);
        }
        object = this.this$0.getContext().getPackageManager();
        n12 = R$id.icon;
        ImageView imageView = (ImageView)view.findViewById(n12);
        ResolveInfo resolveInfo = (ResolveInfo)this.getItem(n10);
        Drawable drawable2 = resolveInfo.loadIcon((PackageManager)object);
        imageView.setImageDrawable(drawable2);
        n12 = R$id.title;
        imageView = (TextView)view.findViewById(n12);
        object = resolveInfo.loadLabel((PackageManager)object);
        imageView.setText((CharSequence)object);
        boolean bl2 = this.mShowDefaultActivity;
        if (bl2 && n10 == 0 && (n10 = (int)(this.mHighlightDefaultActivity ? 1 : 0)) != 0) {
            view.setActivated(n13 != 0);
        } else {
            view.setActivated(false);
        }
        return view;
    }

    public int getViewTypeCount() {
        return 3;
    }

    public int measureContentWidth() {
        int n10 = this.mMaxActivityCount;
        this.mMaxActivityCount = -1 >>> 1;
        int n11 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n12 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n13 = this.getCount();
        int n14 = 0;
        View view = null;
        for (int i10 = 0; i10 < n13; ++i10) {
            view = this.getView(i10, view, null);
            view.measure(n11, n12);
            int n15 = view.getMeasuredWidth();
            n14 = Math.max(n14, n15);
        }
        this.mMaxActivityCount = n10;
        return n14;
    }

    public void setDataModel(ActivityChooserModel activityChooserModel) {
        boolean bl2;
        ActivityChooserView activityChooserView;
        boolean bl3;
        Object object = this.this$0.mAdapter.getDataModel();
        if (object != null && (bl3 = (activityChooserView = this.this$0).isShown())) {
            activityChooserView = this.this$0.mModelDataSetObserver;
            object.unregisterObserver(activityChooserView);
        }
        this.mDataModel = activityChooserModel;
        if (activityChooserModel != null && (bl2 = (object = this.this$0).isShown())) {
            object = this.this$0.mModelDataSetObserver;
            activityChooserModel.registerObserver(object);
        }
        this.notifyDataSetChanged();
    }

    public void setMaxActivityCount(int n10) {
        int n11 = this.mMaxActivityCount;
        if (n11 != n10) {
            this.mMaxActivityCount = n10;
            this.notifyDataSetChanged();
        }
    }

    public void setShowDefaultActivity(boolean bl2, boolean bl3) {
        boolean bl4 = this.mShowDefaultActivity;
        if (bl4 != bl2 || (bl4 = this.mHighlightDefaultActivity) != bl3) {
            this.mShowDefaultActivity = bl2;
            this.mHighlightDefaultActivity = bl3;
            this.notifyDataSetChanged();
        }
    }

    public void setShowFooterView(boolean bl2) {
        boolean bl3 = this.mShowFooterView;
        if (bl3 != bl2) {
            this.mShowFooterView = bl2;
            this.notifyDataSetChanged();
        }
    }
}

