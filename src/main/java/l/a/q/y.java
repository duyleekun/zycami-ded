/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 */
package l.a.q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatSpinner;
import l.a.j.a.h;
import l.a.q.b;
import l.a.q.j;
import l.a.q.z;
import skin.support.appcompat.R$attr;
import skin.support.appcompat.R$styleable;

public class y
extends AppCompatSpinner
implements z {
    private static final String c = y.class.getSimpleName();
    private static final int[] d;
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 255;
    private b a;
    private int b;

    static {
        int[] nArray = new int[]{16843505};
        d = nArray;
    }

    public y(Context context) {
        this(context, null);
    }

    public y(Context context, int n10) {
        int n11 = R$attr.spinnerStyle;
        this(context, null, n11, n10);
    }

    public y(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.spinnerStyle;
        this(context, attributeSet, n10);
    }

    public y(Context context, AttributeSet attributeSet, int n10) {
        this(context, attributeSet, n10, -1);
    }

    public y(Context context, AttributeSet attributeSet, int n10, int n11) {
        this(context, attributeSet, n10, n11, null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public y(Context var1_1, AttributeSet var2_4, int var3_5, int var4_6, Resources.Theme var5_7) {
        block13: {
            block11: {
                super((Context)var1_1, var2_4, var3_5, var4_6, var5_7);
                var5_7 = null;
                this.b = 0;
                var6_8 /* !! */  = R$styleable.Spinner;
                var6_8 /* !! */  = (int[])var1_1.obtainStyledAttributes(var2_4, var6_8 /* !! */ , var3_5, 0);
                var7_9 = this.getPopupContext();
                if (var7_9 == null) break block13;
                var8_10 = -1;
                var9_11 = 1;
                if (var4_6 == var8_10) {
                    block12: {
                        var8_10 = Build.VERSION.SDK_INT;
                        var10_12 = 11;
                        if (var8_10 >= var10_12) {
                            var8_10 = 0;
                            var7_9 = null;
                            var11_13 = y.d;
                            var7_9 = var1_1.obtainStyledAttributes(var2_4, var11_13, var3_5, 0);
                            var12_15 = var7_9.hasValue(0);
                            if (var12_15) {
                                var4_6 = var7_9.getInt(0, 0);
                            }
                            if (var7_9 == null) break block11;
                            break block12;
                        }
                        var4_6 = var9_11;
                        break block11;
                    }
lbl27:
                    // 2 sources

                    while (true) {
                        var7_9.recycle();
                        break block11;
                        break;
                    }
                    {
                        catch (Throwable var1_2) {
                        }
                        catch (Exception var1_3) {}
                        {
                            var11_14 = y.c;
                            var13_16 = "Could not read android:spinnerMode";
                            Log.i((String)var11_14, (String)var13_16, (Throwable)var1_3);
                            if (var7_9 != null) {
                                ** continue;
                            }
                            break block11;
                        }
                    }
                    if (var7_9 != null) {
                        var7_9.recycle();
                    }
                    throw var1_2;
                }
            }
            if (var4_6 == var9_11) {
                var1_1 = this.getPopupContext();
                var14_17 = R$styleable.Spinner;
                var1_1 = var1_1.obtainStyledAttributes(var2_4, var14_17, var3_5, 0);
                var4_6 = R$styleable.Spinner_android_popupBackground;
                this.b = var4_6 = var1_1.getResourceId(var4_6, 0);
                var1_1.recycle();
            }
        }
        var6_8 /* !! */ .recycle();
        this.a = var1_1 = new b((View)this);
        var1_1.c(var2_4, var3_5);
    }

    private void a() {
        int n10;
        this.b = n10 = j.b(this.b);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.b;
            context = h.a(context, n11);
            this.setPopupBackgroundDrawable((Drawable)context);
        }
    }

    public void e() {
        b b10 = this.a;
        if (b10 != null) {
            b10.a();
        }
        this.a();
    }

    public void setPopupBackgroundResource(int n10) {
        super.setPopupBackgroundResource(n10);
        this.b = n10;
        this.a();
    }
}

