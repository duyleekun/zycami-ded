/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.widget.TextView
 */
package cn.sharesdk.sina.weibo.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
import cn.sharesdk.sina.weibo.sdk.LoadingBar$1;

public class LoadingBar
extends TextView {
    private int a;
    private int b;
    private Paint c;
    private Handler d;
    private Runnable e;

    public LoadingBar(Context context) {
        super(context);
        LoadingBar$1 loadingBar$1 = new LoadingBar$1(this);
        this.e = loadingBar$1;
        this.a(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a(context);
    }

    public static /* synthetic */ int a(LoadingBar loadingBar) {
        return loadingBar.a;
    }

    public static /* synthetic */ int a(LoadingBar loadingBar, int n10) {
        loadingBar.a = n10;
        return n10;
    }

    private void a(Context context) {
        context = new Handler();
        this.d = context;
        context = new Paint();
        this.c = context;
        this.a();
    }

    private Rect b() {
        int n10 = this.getLeft();
        int n11 = this.getTop();
        int n12 = this.getLeft();
        int n13 = this.getRight();
        int n14 = this.getLeft();
        n13 -= n14;
        n14 = this.a;
        n13 = n13 * n14 / 100;
        n12 += n13;
        n13 = this.getBottom();
        Rect rect = new Rect(0, 0, n12 -= n10, n13 -= n11);
        return rect;
    }

    public void a() {
        this.b = -11693826;
    }

    public void a(int n10) {
        int n11 = 7;
        if (n10 < n11) {
            Handler handler = this.d;
            Runnable runnable = this.e;
            long l10 = 70;
            handler.postDelayed(runnable, l10);
        } else {
            Handler handler = this.d;
            Runnable runnable = this.e;
            handler.removeCallbacks(runnable);
            this.a = n10;
        }
        this.invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = this.c;
        int n10 = this.b;
        paint.setColor(n10);
        paint = this.b();
        Paint paint2 = this.c;
        canvas.drawRect((Rect)paint, paint2);
    }
}

