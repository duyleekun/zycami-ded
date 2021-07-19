/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ShareActionProvider;

public class ShareActionProvider$ShareMenuItemOnMenuItemClickListener
implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ ShareActionProvider this$0;

    public ShareActionProvider$ShareMenuItemOnMenuItemClickListener(ShareActionProvider shareActionProvider) {
        this.this$0 = shareActionProvider;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        int n10;
        Object object = this.this$0;
        Object object2 = ((ShareActionProvider)object).mContext;
        object = ((ShareActionProvider)object).mShareHistoryFileName;
        menuItem = ((ActivityChooserModel)((Object)(object = ActivityChooserModel.get((Context)object2, (String)object)))).chooseActivity(n10 = menuItem.getItemId());
        if (menuItem != null) {
            boolean bl2;
            object2 = "android.intent.action.SEND";
            object = menuItem.getAction();
            boolean bl3 = ((String)object2).equals(object);
            if (bl3 || (bl2 = ((String)(object2 = "android.intent.action.SEND_MULTIPLE")).equals(object))) {
                object = this.this$0;
                ((ShareActionProvider)object).updateIntent((Intent)menuItem);
            }
            object = this.this$0.mContext;
            object.startActivity((Intent)menuItem);
        }
        return true;
    }
}

