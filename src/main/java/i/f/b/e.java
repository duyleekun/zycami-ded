/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 */
package i.f.b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import i.f.b.e$a;
import i.f.b.e$b;
import i.f.b.e$c;
import i.f.b.e$d;
import i.f.b.e$e;
import i.f.b.e$f;
import i.f.b.i;
import i.f.c.z;
import java.util.Iterator;
import java.util.List;
import org.opencv.R$styleable;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

public abstract class e
extends SurfaceView
implements SurfaceHolder.Callback {
    private static final String p = "CameraBridge";
    public static final int q = 255;
    private static final int r = 0;
    private static final int s = 1;
    public static final int t = 255;
    public static final int u = 99;
    public static final int v = 98;
    public static final int w = 1;
    public static final int x = 2;
    private int a;
    private Bitmap b;
    private e$c c;
    private boolean d;
    private final Object e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public i o;

    public e(Context context, int n10) {
        super(context);
        int n11;
        Object object;
        this.a = 0;
        this.e = object = new Object();
        this.j = 0.0f;
        this.k = 1;
        this.l = n11 = -1;
        this.n = false;
        this.o = null;
        this.l = n10;
        this.getHolder().addCallback((SurfaceHolder.Callback)this);
        this.i = n11;
        this.h = n11;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        Object object;
        context = null;
        this.a = 0;
        this.e = object = new Object();
        object = null;
        this.j = 0.0f;
        this.k = 1;
        this.l = n10 = -1;
        this.n = false;
        this.o = null;
        int n11 = attributeSet.getAttributeCount();
        Object object2 = new StringBuilder();
        String string2 = "Attr count: ";
        ((StringBuilder)object2).append(string2);
        Object object3 = n11;
        ((StringBuilder)object2).append(object3);
        object3 = ((StringBuilder)object2).toString();
        Log.d((String)p, (String)object3);
        object3 = this.getContext();
        object2 = R$styleable.CameraBridgeViewBase;
        attributeSet = object3.obtainStyledAttributes(attributeSet, (int[])object2);
        n11 = R$styleable.CameraBridgeViewBase_show_fps;
        int n12 = attributeSet.getBoolean(n11, false);
        if (n12 != 0) {
            this.j();
        }
        n12 = R$styleable.CameraBridgeViewBase_camera_id;
        this.l = n12 = attributeSet.getInt(n12, n10);
        this.getHolder().addCallback((SurfaceHolder.Callback)this);
        this.i = n10;
        this.h = n10;
        attributeSet.recycle();
    }

    private void d() {
        String string2 = p;
        String string3 = "call checkCurrentState";
        Log.d((String)string2, (String)string3);
        int n10 = this.m;
        if (n10 != 0 && (n10 = this.n) != 0 && (n10 = this.d) != 0 && (n10 = this.getVisibility()) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        int n11 = this.a;
        if (n10 != n11) {
            this.q(n11);
            this.a = n10;
            this.p(n10);
        }
    }

    private void l() {
        String string2 = p;
        String string3 = "call onEnterStartedState";
        Log.d((String)string2, (String)string3);
        int n10 = this.getWidth();
        int n11 = this.getHeight();
        n10 = (int)(this.e(n10, n11) ? 1 : 0);
        if (n10 == 0) {
            string3 = this.getContext();
            string2 = new AlertDialog.Builder((Context)string3);
            string2 = string2.create();
            string2.setCancelable(false);
            string3 = "It seems that you device does not support camera (or it is locked). Application will be closed.";
            string2.setMessage((CharSequence)string3);
            n11 = -3;
            e$a e$a = new e$a(this);
            String string4 = "OK";
            string2.setButton(n11, (CharSequence)string4, (DialogInterface.OnClickListener)e$a);
            string2.show();
        }
    }

    private void m() {
    }

    private void n() {
        this.i();
        Bitmap bitmap = this.b;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    private void o() {
    }

    private void p(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("call processEnterState: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = p;
        Log.d((String)string2, (String)charSequence);
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                this.l();
                e$c e$c = this.c;
                if (e$c != null) {
                    n11 = this.f;
                    int n12 = this.g;
                    e$c.b(n11, n12);
                }
            }
        } else {
            this.m();
            e$c e$c = this.c;
            if (e$c != null) {
                e$c.a();
            }
        }
    }

    private void q(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("call processExitState: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = p;
        Log.d((String)string2, (String)charSequence);
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                this.n();
            }
        } else {
            this.o();
        }
    }

    public void a() {
        Bitmap bitmap;
        int n10 = this.f;
        int n11 = this.g;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        this.b = bitmap = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
    }

    public void b(int n10) {
        this.k = n10;
        e$c e$c = this.c;
        boolean bl2 = e$c instanceof e$e;
        if (bl2) {
            e$c = (e$e)e$c;
            ((e$e)e$c).d(n10);
        }
    }

    public z c(List object, e$f e$f, int n10, int n11) {
        String string2;
        int n12 = this.i;
        int n13 = -1;
        if (n12 != n13 && n12 < n10) {
            n10 = n12;
        }
        if ((n12 = this.h) != n13 && n12 < n11) {
            n11 = n12;
        }
        Iterator iterator2 = object.iterator();
        n13 = 0;
        int n14 = 0;
        int n15 = 0;
        while (true) {
            int n16 = iterator2.hasNext();
            string2 = p;
            if (n16 == 0) break;
            Object e10 = iterator2.next();
            int n17 = e$f.b(e10);
            n16 = e$f.a(e10);
            CharSequence charSequence = new StringBuilder();
            charSequence.append("trying size: ");
            charSequence.append(n17);
            String string3 = "x";
            charSequence.append(string3);
            charSequence.append(n16);
            charSequence = charSequence.toString();
            Log.d((String)string2, (String)charSequence);
            if (n17 > n10 || n16 > n11 || n17 < n14 || n16 < n15) continue;
            n15 = n16;
            n14 = n17;
        }
        if ((n14 == 0 || n15 == 0) && (n10 = object.size()) > 0) {
            String string4 = "fallback to the first frame size";
            Log.i((String)string2, (String)string4);
            object = object.get(0);
            n14 = e$f.b(object);
            n15 = e$f.a(object);
        }
        double d10 = n14;
        double d11 = n15;
        object = new z(d10, d11);
        return object;
    }

    public abstract boolean e(int var1, int var2);

    public void f(e$b object) {
        Object object2;
        Object object3;
        Object object4 = this.c;
        object = object4 != null ? object4.c((e$b)object) : object.b();
        boolean bl2 = true;
        float f10 = Float.MIN_VALUE;
        float f11 = 0.0f;
        Rect rect = null;
        if (object != null) {
            object3 = this.b;
            try {
                Utils.g((Mat)object, (Bitmap)object3);
            }
            catch (Exception exception) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Mat type: ");
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                object3 = "CameraBridge";
                Log.e((String)object3, (String)object);
                object = new StringBuilder();
                ((StringBuilder)object).append("Bitmap type: ");
                int n10 = this.b.getWidth();
                ((StringBuilder)object).append(n10);
                ((StringBuilder)object).append("*");
                n10 = this.b.getHeight();
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                Log.e((String)object3, (String)object);
                object = new StringBuilder();
                object2 = "Utils.matToBitmap() throws an exception: ";
                ((StringBuilder)object).append((String)object2);
                object4 = exception.getMessage();
                ((StringBuilder)object).append((String)object4);
                object = ((StringBuilder)object).toString();
                Log.e((String)object3, (String)object);
                bl2 = false;
                object4 = null;
                f10 = 0.0f;
            }
        }
        if (bl2 && (object = this.b) != null && (object = this.getHolder().lockCanvas()) != null) {
            object4 = PorterDuff.Mode.CLEAR;
            object.drawColor(0, (PorterDuff.Mode)object4);
            f10 = this.j;
            float f12 = f10 - 0.0f;
            bl2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            float f13 = 0.0f;
            object3 = null;
            if (bl2) {
                object4 = this.b;
                Bitmap bitmap = this.b;
                int n11 = bitmap.getWidth();
                Bitmap bitmap2 = this.b;
                int n12 = bitmap2.getHeight();
                object2 = new Rect(0, 0, n11, n12);
                float f14 = object.getWidth();
                float f15 = this.j;
                Bitmap bitmap3 = this.b;
                float f16 = bitmap3.getWidth();
                f14 -= (f15 *= f16);
                f15 = 2.0f;
                n11 = (int)(f14 /= f15);
                f16 = object.getHeight();
                float f17 = this.j;
                Bitmap bitmap4 = this.b;
                float f18 = bitmap4.getHeight();
                f16 = (f16 - (f17 *= f18)) / f15;
                int n13 = (int)f16;
                f17 = object.getWidth();
                f18 = this.j;
                float f19 = this.b.getWidth();
                f17 = (f17 - (f18 *= f19)) / f15;
                f18 = this.j;
                f19 = this.b.getWidth();
                int n14 = (int)(f17 += (f18 *= f19));
                int n15 = object.getHeight();
                f18 = n15;
                f19 = this.j;
                Bitmap bitmap5 = this.b;
                int n16 = bitmap5.getHeight();
                float f20 = n16;
                f18 = (f18 - (f19 *= f20)) / f15;
                f15 = this.j;
                Bitmap bitmap6 = this.b;
                int n17 = bitmap6.getHeight();
                f19 = n17;
                n12 = (int)(f18 += (f15 *= f19));
                rect = new Rect(n11, n13, n14, n12);
                object.drawBitmap((Bitmap)object4, object2, rect, null);
            } else {
                object4 = this.b;
                Bitmap bitmap = this.b;
                int n18 = bitmap.getWidth();
                int n19 = this.b.getHeight();
                object2 = new Rect(0, 0, n18, n19);
                n18 = object.getWidth();
                Bitmap bitmap7 = this.b;
                n19 = bitmap7.getWidth();
                n18 = (n18 - n19) / 2;
                n19 = object.getHeight();
                Bitmap bitmap8 = this.b;
                int n20 = bitmap8.getHeight();
                n19 = (n19 - n20) / 2;
                n20 = object.getWidth();
                int n21 = this.b.getWidth();
                n20 = (n20 - n21) / 2;
                Bitmap bitmap9 = this.b;
                n21 = bitmap9.getWidth();
                n20 += n21;
                n21 = object.getHeight();
                int n22 = this.b.getHeight();
                n21 = (n21 - n22) / 2;
                Bitmap bitmap10 = this.b;
                n22 = bitmap10.getHeight();
                rect = new Rect(n18, n19, n20, n21 += n22);
                object.drawBitmap((Bitmap)object4, object2, rect, null);
            }
            object4 = this.o;
            if (object4 != null) {
                ((i)object4).c();
                object4 = this.o;
                f11 = 20.0f;
                f13 = 30.0f;
                ((i)object4).a((Canvas)object, f11, f13);
            }
            object4 = this.getHolder();
            object4.unlockCanvasAndPost((Canvas)object);
        }
    }

    public void g() {
        this.o = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h() {
        Object object = this.e;
        synchronized (object) {
            Object var2_2 = null;
            this.m = false;
            this.d();
            return;
        }
    }

    public abstract void i();

    public void j() {
        i i10 = this.o;
        if (i10 == null) {
            this.o = i10 = new i();
            int n10 = this.f;
            int n11 = this.g;
            i10.d(n10, n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void k() {
        Object object = this.e;
        synchronized (object) {
            boolean bl2;
            this.m = bl2 = true;
            this.d();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void r() {
        Object object = this.e;
        synchronized (object) {
            boolean bl2;
            this.n = bl2 = true;
            this.d();
            return;
        }
    }

    public void s(int n10, int n11) {
        this.i = n10;
        this.h = n11;
    }

    public void setCameraIndex(int n10) {
        this.l = n10;
    }

    public void setCvCameraViewListener(e$c e$c) {
        this.c = e$c;
    }

    public void setCvCameraViewListener(e$d e$d) {
        e$e e$e = new e$e(this, e$d);
        int n10 = this.k;
        e$e.d(n10);
        this.c = e$e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void surfaceChanged(SurfaceHolder object, int n10, int n11, int n12) {
        String string2 = "call surfaceChanged event";
        Log.d((String)"CameraBridge", (String)string2);
        object = this.e;
        synchronized (object) {
            n10 = (int)(this.d ? 1 : 0);
            n11 = 1;
            if (n10 == 0) {
                this.d = n11;
                this.d();
            } else {
                n10 = 0;
                string2 = null;
                this.d = false;
                this.d();
                this.d = n11;
                this.d();
            }
            return;
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void surfaceDestroyed(SurfaceHolder object) {
        object = this.e;
        synchronized (object) {
            Object var2_2 = null;
            this.d = false;
            this.d();
            return;
        }
    }
}

