/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package androidx.appcompat.widget;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserModel$OnChooseActivityListener;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.ShareActionProvider$OnShareTargetSelectedListener;

public class ShareActionProvider$ShareActivityChooserModelPolicy
implements ActivityChooserModel$OnChooseActivityListener {
    public final /* synthetic */ ShareActionProvider this$0;

    public ShareActionProvider$ShareActivityChooserModelPolicy(ShareActionProvider shareActionProvider) {
        this.this$0 = shareActionProvider;
    }

    public boolean onChooseActivity(ActivityChooserModel object, Intent intent) {
        object = this.this$0;
        ShareActionProvider$OnShareTargetSelectedListener shareActionProvider$OnShareTargetSelectedListener = ((ShareActionProvider)object).mOnShareTargetSelectedListener;
        if (shareActionProvider$OnShareTargetSelectedListener != null) {
            shareActionProvider$OnShareTargetSelectedListener.onShareTargetSelected((ShareActionProvider)object, intent);
        }
        return false;
    }
}

