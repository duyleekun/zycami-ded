/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.graphics.Rect
 *  android.os.IBinder
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

public class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame;

    public TooltipPopup(Context object) {
        int n10;
        Object object2;
        WindowManager.LayoutParams layoutParams;
        this.mLayoutParams = layoutParams = new WindowManager.LayoutParams();
        this.mTmpDisplayFrame = object2 = new Rect();
        int n11 = 2;
        int[] nArray = new int[n11];
        this.mTmpAnchorPos = nArray;
        object2 = new int[n11];
        this.mTmpAppPos = (int[])object2;
        this.mContext = object;
        object2 = LayoutInflater.from((Context)object);
        int n12 = R$layout.abc_tooltip;
        object2 = object2.inflate(n12, null);
        this.mContentView = object2;
        n12 = R$id.message;
        object2 = (TextView)object2.findViewById(n12);
        this.mMessageView = object2;
        object2 = this.getClass().getSimpleName();
        layoutParams.setTitle((CharSequence)object2);
        object = object.getPackageName();
        layoutParams.packageName = object;
        layoutParams.type = 1002;
        layoutParams.width = n10 = -2;
        layoutParams.height = n10;
        layoutParams.format = -3;
        layoutParams.windowAnimations = n10 = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void computePosition(View object, int n10, int n11, boolean bl2, WindowManager.LayoutParams layoutParams) {
        int n12;
        reference var20_22;
        Object object2;
        Object object3;
        Rect rect;
        IBinder iBinder;
        layoutParams.token = iBinder = object.getApplicationWindowToken();
        iBinder = this.mContext.getResources();
        int n122 = R$dimen.tooltip_precise_anchor_threshold;
        int n13 = iBinder.getDimensionPixelOffset(n122);
        n122 = object.getWidth();
        if (n122 < n13) {
            n10 = object.getWidth() / 2;
        }
        n122 = object.getHeight();
        int n14 = 0;
        if (n122 >= n13) {
            iBinder = this.mContext.getResources();
            n122 = R$dimen.tooltip_precise_anchor_extra_offset;
            n13 = iBinder.getDimensionPixelOffset(n122);
            n122 = n11 + n13;
            n11 -= n13;
        } else {
            n122 = object.getHeight();
            n11 = 0;
            rect = null;
        }
        layoutParams.gravity = n13 = 49;
        iBinder = this.mContext.getResources();
        int n15 = bl2 ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch;
        n13 = iBinder.getDimensionPixelOffset(n15);
        View view = TooltipPopup.getAppRootView(object);
        if (view == null) {
            Log.e((String)TAG, (String)"Cannot find app view");
            return;
        }
        Object object4 = this.mTmpDisplayFrame;
        view.getWindowVisibleDisplayFrame(object4);
        object4 = this.mTmpDisplayFrame;
        Object object5 = object4.left;
        if (object5 < 0 && (object3 = object4.top) < 0) {
            String string2;
            String string3;
            object4 = this.mContext.getResources();
            object5 = object4.getIdentifier((String)(object2 = "status_bar_height"), string3 = "dimen", string2 = "android");
            if (object5 != 0) {
                object5 = object4.getDimensionPixelSize(object5);
            } else {
                object5 = 0;
                object2 = null;
            }
            object4 = object4.getDisplayMetrics();
            string3 = this.mTmpDisplayFrame;
            int n16 = object4.widthPixels;
            object3 = object4.heightPixels;
            string3.set(0, object5, n16, object3);
        }
        object4 = this.mTmpAppPos;
        view.getLocationOnScreen((int[])object4);
        object4 = this.mTmpAnchorPos;
        object.getLocationOnScreen((int[])object4);
        object = this.mTmpAnchorPos;
        object3 = object[0];
        object2 = this.mTmpAppPos;
        Object object6 = object2[0];
        object[0] = (View)(object3 -= object6);
        object3 = 1;
        View view2 = object[object3];
        object5 = object2[object3];
        object[object3] = var20_22 = view2 - object5;
        reference var21_23 = object[0] + n10;
        n10 = view.getWidth() / 2;
        reference var21_24 = var21_23 - n10;
        layoutParams.x = (int)var21_24;
        int n16 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        this.mContentView.measure(n16, n16);
        object = this.mContentView;
        int n17 = object.getMeasuredHeight();
        int[] nArray = this.mTmpAnchorPos;
        n14 = nArray[object3] + n11 - n13 - n17;
        n10 = nArray[object3] + n122 + n13;
        layoutParams.y = bl2 ? (n14 >= 0 ? n14 : n10) : ((n12 = n17 + n10) <= (n11 = (rect = this.mTmpDisplayFrame).height()) ? n10 : n14);
    }

    private static View getAppRootView(View view) {
        int n10;
        View view2 = view.getRootView();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        int n11 = layoutParams instanceof WindowManager.LayoutParams;
        if (n11 != 0) {
            layoutParams = (WindowManager.LayoutParams)layoutParams;
            n10 = layoutParams.type;
            n11 = 2;
            if (n10 == n11) {
                return view2;
            }
        }
        view = view.getContext();
        while ((n10 = view instanceof ContextWrapper) != 0) {
            n10 = view instanceof Activity;
            if (n10 != 0) {
                return ((Activity)view).getWindow().getDecorView();
            }
            view = ((ContextWrapper)view).getBaseContext();
        }
        return view2;
    }

    public void hide() {
        boolean bl2 = this.isShowing();
        if (!bl2) {
            return;
        }
        WindowManager windowManager = (WindowManager)this.mContext.getSystemService("window");
        View view = this.mContentView;
        windowManager.removeView(view);
    }

    public boolean isShowing() {
        boolean bl2;
        ViewParent viewParent = this.mContentView.getParent();
        if (viewParent != null) {
            bl2 = true;
        } else {
            bl2 = false;
            viewParent = null;
        }
        return bl2;
    }

    public void show(View view, int n10, int n11, boolean bl2, CharSequence charSequence) {
        boolean bl3 = this.isShowing();
        if (bl3) {
            this.hide();
        }
        this.mMessageView.setText(charSequence);
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        this.computePosition(view, n10, n11, bl2, layoutParams);
        view = (WindowManager)this.mContext.getSystemService("window");
        View view2 = this.mContentView;
        WindowManager.LayoutParams layoutParams2 = this.mLayoutParams;
        view.addView(view2, (ViewGroup.LayoutParams)layoutParams2);
    }
}

