/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView$ActionMenuChildView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class ActionMenuPresenter$OverflowMenuButton
extends AppCompatImageView
implements ActionMenuView$ActionMenuChildView {
    public final /* synthetic */ ActionMenuPresenter this$0;

    public ActionMenuPresenter$OverflowMenuButton(ActionMenuPresenter actionMenuPresenter, Context object) {
        this.this$0 = actionMenuPresenter;
        int n10 = R$attr.actionOverflowButtonStyle;
        super((Context)object, null, n10);
        boolean bl2 = true;
        this.setClickable(bl2);
        this.setFocusable(bl2);
        this.setVisibility(0);
        this.setEnabled(bl2);
        object = this.getContentDescription();
        TooltipCompat.setTooltipText((View)this, (CharSequence)object);
        super(this, (View)this, actionMenuPresenter);
        this.setOnTouchListener((View.OnTouchListener)object);
    }

    public boolean needsDividerAfter() {
        return false;
    }

    public boolean needsDividerBefore() {
        return false;
    }

    public boolean performClick() {
        boolean bl2 = super.performClick();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        this.playSoundEffect(0);
        this.this$0.showOverflowMenu();
        return bl3;
    }

    public boolean setFrame(int n10, int n11, int n12, int n13) {
        n10 = (int)(super.setFrame(n10, n11, n12, n13) ? 1 : 0);
        Drawable drawable2 = this.getDrawable();
        Drawable drawable3 = this.getBackground();
        if (drawable2 != null && drawable3 != null) {
            n11 = this.getWidth();
            n13 = this.getHeight();
            int n14 = Math.max(n11, n13) / 2;
            int n15 = this.getPaddingLeft();
            int n16 = this.getPaddingRight();
            n15 -= n16;
            n16 = this.getPaddingTop();
            int n17 = this.getPaddingBottom();
            n11 = (n11 + n15) / 2;
            n13 = (n13 + (n16 -= n17)) / 2;
            n15 = n11 - n14;
            n16 = n13 - n14;
            DrawableCompat.setHotspotBounds(drawable3, n15, n16, n11 += n14, n13 += n14);
        }
        return n10 != 0;
    }
}

