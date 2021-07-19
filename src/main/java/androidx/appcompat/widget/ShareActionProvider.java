/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.TypedValue
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserModel$OnChooseActivityListener;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ShareActionProvider$OnShareTargetSelectedListener;
import androidx.appcompat.widget.ShareActionProvider$ShareActivityChooserModelPolicy;
import androidx.appcompat.widget.ShareActionProvider$ShareMenuItemOnMenuItemClickListener;
import androidx.core.view.ActionProvider;

public class ShareActionProvider
extends ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    public final Context mContext;
    private int mMaxShownActivityCount = 4;
    private ActivityChooserModel$OnChooseActivityListener mOnChooseActivityListener;
    private final ShareActionProvider$ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    public ShareActionProvider$OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    public String mShareHistoryFileName;

    public ShareActionProvider(Context context) {
        super(context);
        ShareActionProvider$ShareMenuItemOnMenuItemClickListener shareActionProvider$ShareMenuItemOnMenuItemClickListener;
        this.mOnMenuItemClickListener = shareActionProvider$ShareMenuItemOnMenuItemClickListener = new ShareActionProvider$ShareMenuItemOnMenuItemClickListener(this);
        this.mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = context;
    }

    private void setActivityChooserPolicyIfNeeded() {
        Object object = this.mOnShareTargetSelectedListener;
        if (object == null) {
            return;
        }
        object = this.mOnChooseActivityListener;
        if (object == null) {
            this.mOnChooseActivityListener = object = new ShareActionProvider$ShareActivityChooserModelPolicy(this);
        }
        object = this.mContext;
        Object object2 = this.mShareHistoryFileName;
        object = ActivityChooserModel.get((Context)object, (String)object2);
        object2 = this.mOnChooseActivityListener;
        ((ActivityChooserModel)((Object)object)).setOnChooseActivityListener((ActivityChooserModel$OnChooseActivityListener)object2);
    }

    public boolean hasSubMenu() {
        return true;
    }

    public View onCreateActionView() {
        String string2;
        Object object = this.mContext;
        ActivityChooserView activityChooserView = new ActivityChooserView((Context)object);
        int n10 = activityChooserView.isInEditMode();
        if (n10 == 0) {
            object = this.mContext;
            string2 = this.mShareHistoryFileName;
            object = ActivityChooserModel.get(object, string2);
            activityChooserView.setActivityChooserModel((ActivityChooserModel)((Object)object));
        }
        object = new TypedValue();
        string2 = this.mContext.getTheme();
        int n11 = R$attr.actionModeShareDrawable;
        string2.resolveAttribute(n11, (TypedValue)object, true);
        string2 = this.mContext;
        n10 = object.resourceId;
        object = AppCompatResources.getDrawable((Context)string2, n10);
        activityChooserView.setExpandActivityOverflowButtonDrawable((Drawable)object);
        activityChooserView.setProvider(this);
        n10 = R$string.abc_shareactionprovider_share_with_application;
        activityChooserView.setDefaultActionButtonContentDescription(n10);
        n10 = R$string.abc_shareactionprovider_share_with;
        activityChooserView.setExpandActivityOverflowButtonContentDescription(n10);
        return activityChooserView;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        Object object;
        subMenu.clear();
        Object object2 = this.mContext;
        String string2 = this.mShareHistoryFileName;
        object2 = ActivityChooserModel.get((Context)object2, string2);
        string2 = this.mContext.getPackageManager();
        int n10 = ((ActivityChooserModel)((Object)object2)).getActivityCount();
        int n11 = this.mMaxShownActivityCount;
        n11 = Math.min(n10, n11);
        Object object3 = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            object = ((ActivityChooserModel)((Object)object2)).getActivity(i10);
            Object object4 = object.loadLabel((PackageManager)string2);
            object4 = subMenu.add(0, i10, i10, (CharSequence)object4);
            object = object.loadIcon((PackageManager)string2);
            object = object4.setIcon((Drawable)object);
            object4 = this.mOnMenuItemClickListener;
            object.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)object4);
        }
        if (n11 < n10) {
            object3 = this.mContext;
            int n12 = R$string.abc_activity_chooser_view_see_all;
            object3 = object3.getString(n12);
            subMenu = subMenu.addSubMenu(0, n11, n11, (CharSequence)object3);
            for (n11 = 0; n11 < n10; ++n11) {
                object3 = ((ActivityChooserModel)((Object)object2)).getActivity(n11);
                object = object3.loadLabel((PackageManager)string2);
                object = subMenu.add(0, n11, n11, (CharSequence)object);
                object3 = object3.loadIcon((PackageManager)string2);
                object3 = object.setIcon((Drawable)object3);
                object = this.mOnMenuItemClickListener;
                object3.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)object);
            }
        }
    }

    public void setOnShareTargetSelectedListener(ShareActionProvider$OnShareTargetSelectedListener shareActionProvider$OnShareTargetSelectedListener) {
        this.mOnShareTargetSelectedListener = shareActionProvider$OnShareTargetSelectedListener;
        this.setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String string2) {
        this.mShareHistoryFileName = string2;
        this.setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent intent) {
        boolean bl2;
        String string2;
        String string3;
        boolean bl3;
        if (intent != null && ((bl3 = (string3 = "android.intent.action.SEND").equals(string2 = intent.getAction())) || (bl2 = (string3 = "android.intent.action.SEND_MULTIPLE").equals(string2)))) {
            this.updateIntent(intent);
        }
        string2 = this.mContext;
        string3 = this.mShareHistoryFileName;
        ActivityChooserModel.get((Context)string2, string3).setIntent(intent);
    }

    public void updateIntent(Intent intent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            n10 = 0x8080000;
            intent.addFlags(n10);
        } else {
            n10 = 524288;
            intent.addFlags(n10);
        }
    }
}

