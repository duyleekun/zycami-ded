/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 */
package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.appcompat.app.ActionBar$TabListener;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ScrollingTabContainerView;

public class WindowDecorActionBar$TabImpl
extends ActionBar$Tab {
    private ActionBar$TabListener mCallback;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private int mPosition = -1;
    private Object mTag;
    private CharSequence mText;
    public final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$TabImpl(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public ActionBar$TabListener getCallback() {
        return this.mCallback;
    }

    public CharSequence getContentDescription() {
        return this.mContentDesc;
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public Object getTag() {
        return this.mTag;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public void select() {
        this.this$0.selectTab(this);
    }

    public ActionBar$Tab setContentDescription(int n10) {
        CharSequence charSequence = this.this$0.mContext.getResources().getText(n10);
        return this.setContentDescription(charSequence);
    }

    public ActionBar$Tab setContentDescription(CharSequence charSequence) {
        this.mContentDesc = charSequence;
        int n10 = this.mPosition;
        if (n10 >= 0) {
            ScrollingTabContainerView scrollingTabContainerView = this.this$0.mTabScrollView;
            scrollingTabContainerView.updateTab(n10);
        }
        return this;
    }

    public ActionBar$Tab setCustomView(int n10) {
        View view = LayoutInflater.from((Context)this.this$0.getThemedContext()).inflate(n10, null);
        return this.setCustomView(view);
    }

    public ActionBar$Tab setCustomView(View view) {
        this.mCustomView = view;
        int n10 = this.mPosition;
        if (n10 >= 0) {
            ScrollingTabContainerView scrollingTabContainerView = this.this$0.mTabScrollView;
            scrollingTabContainerView.updateTab(n10);
        }
        return this;
    }

    public ActionBar$Tab setIcon(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.this$0.mContext, n10);
        return this.setIcon(drawable2);
    }

    public ActionBar$Tab setIcon(Drawable drawable2) {
        this.mIcon = drawable2;
        int n10 = this.mPosition;
        if (n10 >= 0) {
            ScrollingTabContainerView scrollingTabContainerView = this.this$0.mTabScrollView;
            scrollingTabContainerView.updateTab(n10);
        }
        return this;
    }

    public void setPosition(int n10) {
        this.mPosition = n10;
    }

    public ActionBar$Tab setTabListener(ActionBar$TabListener actionBar$TabListener) {
        this.mCallback = actionBar$TabListener;
        return this;
    }

    public ActionBar$Tab setTag(Object object) {
        this.mTag = object;
        return this;
    }

    public ActionBar$Tab setText(int n10) {
        CharSequence charSequence = this.this$0.mContext.getResources().getText(n10);
        return this.setText(charSequence);
    }

    public ActionBar$Tab setText(CharSequence charSequence) {
        this.mText = charSequence;
        int n10 = this.mPosition;
        if (n10 >= 0) {
            ScrollingTabContainerView scrollingTabContainerView = this.this$0.mTabScrollView;
            scrollingTabContainerView.updateTab(n10);
        }
        return this;
    }
}

