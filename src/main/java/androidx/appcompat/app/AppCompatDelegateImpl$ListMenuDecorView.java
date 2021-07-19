/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 */
package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ContentFrameLayout;

public class AppCompatDelegateImpl$ListMenuDecorView
extends ContentFrameLayout {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$ListMenuDecorView(AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
        this.this$0 = appCompatDelegateImpl;
        super(context);
    }

    private boolean isOutOfBounds(int n10, int n11) {
        int n12 = -5;
        n10 = n10 >= n12 && n11 >= n12 && n10 <= (n12 = this.getWidth() + 5) && n11 <= (n10 = this.getHeight() + 5) ? 0 : 1;
        return n10 != 0;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl2;
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        boolean bl3 = appCompatDelegateImpl.dispatchKeyEvent(keyEvent);
        if (!bl3 && !(bl2 = super.dispatchKeyEvent(keyEvent))) {
            bl2 = false;
            keyEvent = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        if (n10 == 0) {
            float f10 = motionEvent.getX();
            n10 = (int)f10;
            float f11 = motionEvent.getY();
            int n11 = (int)f11;
            if ((n10 = (int)(this.isOutOfBounds(n10, n11) ? 1 : 0)) != 0) {
                this.this$0.closePanel(0);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setBackgroundResource(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.getContext(), n10);
        this.setBackgroundDrawable(drawable2);
    }
}

