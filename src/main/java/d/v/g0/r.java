/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.util.AttributeSet
 */
package d.v.g0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.zhiyun.ui.R$color;
import d.v.e.l.o1;
import d.v.g0.r$a;

public class r
extends AppCompatButton {
    public r(Context context) {
        super(context);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public r(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public void a(float f10, Drawable drawable2) {
        r$a r$a = new r$a(this, f10);
        this.setOutlineProvider(r$a);
        int n10 = 1;
        f10 = Float.MIN_VALUE;
        this.setClipToOutline(n10 != 0);
        r$a = drawable2.getConstantState();
        if (r$a == null) {
            return;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Object[] objectArray = new Drawable[2];
        objectArray[0] = drawable2;
        Resources resources = this.getResources();
        int n11 = R$color.zyui_btn_pressed_bg;
        int n12 = o1.c(resources, n11);
        ColorDrawable colorDrawable = new ColorDrawable(n12);
        objectArray[n10] = colorDrawable;
        colorDrawable = new LayerDrawable(objectArray);
        objectArray = new int[n10];
        objectArray[0] = (Drawable)16842919;
        stateListDrawable.addState((int[])objectArray, (Drawable)colorDrawable);
        r$a = r$a.newDrawable();
        r$a.setAlpha(102);
        int[] nArray = new int[n10];
        nArray[0] = -16842910;
        stateListDrawable.addState(nArray, (Drawable)r$a);
        nArray = new int[]{};
        stateListDrawable.addState(nArray, drawable2);
        this.setBackground((Drawable)stateListDrawable);
        this.setStateListAnimator(null);
    }
}

