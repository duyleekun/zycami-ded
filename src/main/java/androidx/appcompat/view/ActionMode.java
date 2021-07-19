/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.View
 */
package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public abstract class ActionMode {
    private Object mTag;
    private boolean mTitleOptionalHint;

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public Object getTag() {
        return this.mTag;
    }

    public abstract CharSequence getTitle();

    public boolean getTitleOptionalHint() {
        return this.mTitleOptionalHint;
    }

    public abstract void invalidate();

    public boolean isTitleOptional() {
        return false;
    }

    public boolean isUiFocusable() {
        return true;
    }

    public abstract void setCustomView(View var1);

    public abstract void setSubtitle(int var1);

    public abstract void setSubtitle(CharSequence var1);

    public void setTag(Object object) {
        this.mTag = object;
    }

    public abstract void setTitle(int var1);

    public abstract void setTitle(CharSequence var1);

    public void setTitleOptionalHint(boolean bl2) {
        this.mTitleOptionalHint = bl2;
    }
}

