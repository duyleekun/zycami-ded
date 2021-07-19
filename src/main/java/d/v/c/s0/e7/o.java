/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.s0.e7;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.zhiyun.common.util.Windows;
import d.v.e.l.d1;
import m.a.a;

public class o {
    public Context a;
    public WindowManager b;
    public View c;
    public WindowManager.LayoutParams d;
    public boolean e;
    public int f = 17;
    public Point g;
    public boolean h;
    public Handler i;

    public o(Context context) {
        Point point;
        this.g = point = new Point(0, 0);
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.i = point;
        this.a = context;
        context = (WindowManager)context.getApplicationContext().getSystemService("window");
        this.b = context;
    }

    private WindowManager.LayoutParams a(boolean n10) {
        String string2;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        layoutParams.type = n11 >= n12 ? (n12 = 2038) : (n12 = 2002);
        layoutParams.packageName = string2 = d1.d();
        layoutParams.flags = n12 = layoutParams.flags | 0x1000000;
        layoutParams.flags = n12 |= 0x28;
        int n13 = -2;
        if (n10 != 0) {
            n10 = 28;
            if (n11 >= n10) {
                layoutParams.layoutInDisplayCutoutMode = n10 = 1;
            }
            layoutParams.flags = n10 = 0x10700 | n12;
            Display display = this.b.getDefaultDisplay();
            Point point = new Point();
            display.getRealSize(point);
            layoutParams.width = n10 = point.x;
            n10 = point.y;
            point = this.a;
            n11 = Windows.h((Context)point);
            layoutParams.height = n10 += n11;
        } else {
            layoutParams.flags = n10 = 0x10300 | n12;
            layoutParams.width = n13;
            layoutParams.height = n13;
        }
        layoutParams.format = n13;
        return layoutParams;
    }

    public void b() {
        View view = this.c;
        if (view != null) {
            int n10 = 8;
            view.setVisibility(n10);
        }
    }

    public void c(int n10) {
        View view;
        this.c = view = View.inflate((Context)this.a, (int)n10, null);
    }

    public void d(View view) {
        this.c = view;
    }

    public boolean e() {
        boolean bl2;
        View view = this.c;
        if (view != null && !(bl2 = view.getVisibility())) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public void f() {
        WindowManager windowManager;
        View view = this.c;
        if (view != null && (windowManager = this.b) != null) {
            boolean bl2 = view.isAttachedToWindow();
            if (bl2) {
                view = this.b;
                windowManager = this.c;
                view.removeView((View)windowManager);
            }
            bl2 = false;
            view = null;
            this.h = false;
        }
        if ((view = this.i) != null) {
            windowManager = null;
            view.removeCallbacksAndMessages(null);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void g() {
        synchronized (this) {
            block20: {
                View view;
                int n10;
                int n11;
                WindowManager.LayoutParams layoutParams;
                boolean bl2;
                Object[] objectArray;
                block21: {
                    View view2 = this.c;
                    if (view2 == null) break block20;
                    objectArray = null;
                    view2.setVisibility(0);
                    bl2 = this.h;
                    if (!bl2) break block21;
                    return;
                }
                bl2 = this.e;
                this.d = layoutParams = this.a(bl2);
                layoutParams.gravity = n11 = this.f;
                Point point = this.g;
                layoutParams.x = n10 = point.x;
                layoutParams.y = n11 = point.y;
                try {
                    point = this.b;
                    view = this.c;
                }
                catch (Exception exception) {
                    String string2 = "\u6dfb\u52a0\u60ac\u6d6e\u7a97\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u60ac\u6d6e\u7a97\u6743\u9650";
                    objectArray = new Object[]{};
                    m.a.a.e(string2, objectArray);
                    return;
                }
                point.addView(view, (ViewGroup.LayoutParams)layoutParams);
                this.h = bl2 = true;
                return;
            }
            String string3 = "\u60ac\u6d6e\u7a97View\u4e3anull\uff0c\u8c03\u7528inflate()";
            IllegalStateException illegalStateException = new IllegalStateException(string3);
            throw illegalStateException;
        }
    }

    public void h(int n10, int n11) {
        View view = this.c;
        if (view != null) {
            view = this.g;
            view.set(n10, n11);
            boolean bl2 = this.h;
            if (!bl2) {
                this.g();
            }
            this.c.setVisibility(0);
            view = this.d;
            view.x = n10;
            view.y = n11;
            WindowManager windowManager = this.b;
            View view2 = this.c;
            windowManager.updateViewLayout(view2, (ViewGroup.LayoutParams)view);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("\u60ac\u6d6e\u7a97View\u4e3anull\uff0c\u8c03\u7528inflate()");
        throw illegalStateException;
    }
}

