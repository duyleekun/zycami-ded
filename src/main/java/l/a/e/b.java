/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewParent
 */
package l.a.e;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.view.ViewCompat;
import l.a.e.g;
import l.a.e.h;
import l.a.q.a;
import l.a.q.c;
import l.a.q.c0;
import l.a.q.d0;
import l.a.q.e;
import l.a.q.e0;
import l.a.q.f;
import l.a.q.i;
import l.a.q.k;
import l.a.q.m;
import l.a.q.n;
import l.a.q.o;
import l.a.q.p;
import l.a.q.r;
import l.a.q.s;
import l.a.q.t;
import l.a.q.u;
import l.a.q.v;
import l.a.q.w;
import l.a.q.y;
import l.a.q.z;
import skin.support.appcompat.R$styleable;

public class b
implements g,
h {
    private static final String a = "SkinAppCompatViewInflater";

    public b() {
        l.a.j.a.h.b();
    }

    private View c(Context context, String string2, AttributeSet attributeSet) {
        String string3 = ".";
        int n10 = string2.contains(string3);
        z z10 = null;
        if (n10 != 0) {
            return null;
        }
        string2.hashCode();
        n10 = -1;
        int n11 = string2.hashCode();
        switch (n11) {
            default: {
                break;
            }
            case 2059813682: {
                String string4 = "ScrollView";
                boolean bl2 = string2.equals(string4);
                if (!bl2) break;
                n10 = 19;
                break;
            }
            case 2001146706: {
                String string5 = "Button";
                boolean bl3 = string2.equals(string5);
                if (!bl3) break;
                n10 = 18;
                break;
            }
            case 1969230692: {
                String string6 = "RadioGroup";
                boolean bl4 = string2.equals(string6);
                if (!bl4) break;
                n10 = 17;
                break;
            }
            case 1666676343: {
                String string7 = "EditText";
                boolean bl5 = string2.equals(string7);
                if (!bl5) break;
                n10 = 16;
                break;
            }
            case 1601505219: {
                String string8 = "CheckBox";
                boolean bl6 = string2.equals(string8);
                if (!bl6) break;
                n10 = 15;
                break;
            }
            case 1413872058: {
                String string9 = "AutoCompleteTextView";
                boolean bl7 = string2.equals(string9);
                if (!bl7) break;
                n10 = 14;
                break;
            }
            case 1310765783: {
                String string10 = "FrameLayout";
                boolean bl8 = string2.equals(string10);
                if (!bl8) break;
                n10 = 13;
                break;
            }
            case 1127291599: {
                String string11 = "LinearLayout";
                boolean bl9 = string2.equals(string11);
                if (!bl9) break;
                n10 = 12;
                break;
            }
            case 1125864064: {
                String string12 = "ImageView";
                boolean bl10 = string2.equals(string12);
                if (!bl10) break;
                n10 = 11;
                break;
            }
            case 776382189: {
                String string13 = "RadioButton";
                boolean bl11 = string2.equals(string13);
                if (!bl11) break;
                n10 = 10;
                break;
            }
            case 2666181: {
                String string14 = "View";
                boolean bl12 = string2.equals(string14);
                if (!bl12) break;
                n10 = 9;
                break;
            }
            case -339785223: {
                String string15 = "Spinner";
                boolean bl13 = string2.equals(string15);
                if (!bl13) break;
                n10 = 8;
                break;
            }
            case -443652810: {
                String string16 = "RelativeLayout";
                boolean bl14 = string2.equals(string16);
                if (!bl14) break;
                n10 = 7;
                break;
            }
            case -658531749: {
                String string17 = "SeekBar";
                boolean bl15 = string2.equals(string17);
                if (!bl15) break;
                n10 = 6;
                break;
            }
            case -937446323: {
                String string18 = "ImageButton";
                boolean bl16 = string2.equals(string18);
                if (!bl16) break;
                n10 = 5;
                break;
            }
            case -938935918: {
                String string19 = "TextView";
                boolean bl17 = string2.equals(string19);
                if (!bl17) break;
                n10 = 4;
                break;
            }
            case -1346021293: {
                String string20 = "MultiAutoCompleteTextView";
                boolean bl18 = string2.equals(string20);
                if (!bl18) break;
                n10 = 3;
                break;
            }
            case -1455429095: {
                String string21 = "CheckedTextView";
                boolean bl19 = string2.equals(string21);
                if (!bl19) break;
                n10 = 2;
                break;
            }
            case -1495589242: {
                String string22 = "ProgressBar";
                boolean bl20 = string2.equals(string22);
                if (!bl20) break;
                n10 = 1;
                break;
            }
            case -1946472170: {
                String string23 = "RatingBar";
                boolean bl21 = string2.equals(string23);
                if (!bl21) break;
                n10 = 0;
                string3 = null;
            }
        }
        switch (n10) {
            default: {
                break;
            }
            case 19: {
                z10 = new v(context, attributeSet);
                break;
            }
            case 18: {
                z10 = new c(context, attributeSet);
                break;
            }
            case 17: {
                z10 = new s(context, attributeSet);
                break;
            }
            case 16: {
                z10 = new l.a.q.h(context, attributeSet);
                break;
            }
            case 15: {
                z10 = new e(context, attributeSet);
                break;
            }
            case 14: {
                z10 = new a(context, attributeSet);
                break;
            }
            case 13: {
                z10 = new i(context, attributeSet);
                break;
            }
            case 12: {
                z10 = new n(context, attributeSet);
                break;
            }
            case 11: {
                z10 = new m(context, attributeSet);
                break;
            }
            case 10: {
                z10 = new r(context, attributeSet);
                break;
            }
            case 9: {
                z10 = new e0(context, attributeSet);
                break;
            }
            case 8: {
                z10 = new y(context, attributeSet);
                break;
            }
            case 7: {
                z10 = new u(context, attributeSet);
                break;
            }
            case 6: {
                z10 = new w(context, attributeSet);
                break;
            }
            case 5: {
                z10 = new k(context, attributeSet);
                break;
            }
            case 4: {
                z10 = new c0(context, attributeSet);
                break;
            }
            case 3: {
                z10 = new o(context, attributeSet);
                break;
            }
            case 2: {
                z10 = new f(context, attributeSet);
                break;
            }
            case 1: {
                z10 = new p(context, attributeSet);
                break;
            }
            case 0: {
                z10 = new t(context, attributeSet);
            }
        }
        return z10;
    }

    private View d(Context object, String object2, AttributeSet attributeSet) {
        ((String)object2).hashCode();
        String string2 = "androidx.appcompat.widget.Toolbar";
        boolean bl2 = ((String)object2).equals(string2);
        if (!bl2) {
            object = null;
        } else {
            object2 = new d0((Context)object, attributeSet);
            object = object2;
        }
        return object;
    }

    private boolean e(Context context, ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        boolean bl2 = context instanceof Activity;
        if (bl2) {
            context = ((Activity)context).getWindow().getDecorView();
            while (true) {
                if (viewParent == null) {
                    return true;
                }
                if (viewParent == context || !(bl2 = viewParent instanceof View)) break;
                ViewParent viewParent2 = viewParent;
                viewParent2 = (View)viewParent;
                bl2 = ViewCompat.isAttachedToWindow((View)viewParent2);
                if (bl2) break;
                viewParent = viewParent.getParent();
            }
        }
        return false;
    }

    private static Context f(Context object, AttributeSet object2, boolean n10, boolean bl2) {
        block7: {
            block8: {
                Object object3 = R$styleable.View;
                object2 = object.obtainStyledAttributes(object2, object3, 0, 0);
                if (n10 != 0) {
                    n10 = R$styleable.View_android_theme;
                    n10 = object2.getResourceId(n10, 0);
                } else {
                    n10 = 0;
                }
                if (bl2 && n10 == 0) {
                    n10 = R$styleable.View_theme;
                    if ((n10 = object2.getResourceId(n10, 0)) != 0) {
                        String string2 = a;
                        object3 = "app:theme is now deprecated. Please move to using android:theme instead.";
                        l.a.o.f.b(string2, (String)object3);
                    }
                }
                object2.recycle();
                if (n10 == 0) break block7;
                int n11 = object instanceof ContextThemeWrapper;
                if (n11 == 0) break block8;
                object2 = object;
                object2 = (ContextThemeWrapper)((Object)object);
                n11 = object2.getThemeResId();
                if (n11 == n10) break block7;
            }
            object2 = new ContextThemeWrapper((Context)object, n10);
            object = object2;
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public Context a(Context context, View view, AttributeSet attributeSet) {
        void var4_7;
        int bl2 = Build.VERSION.SDK_INT;
        boolean bl3 = false;
        boolean bl4 = true;
        int n10 = 21;
        if (bl2 < n10) {
            boolean bl5 = bl4;
        } else {
            boolean bl6 = false;
        }
        if (var4_7 != false) {
            View view2 = view;
            view2 = (ViewParent)view;
            boolean bl7 = this.e(context, (ViewParent)view2);
            if (bl7) {
                bl3 = bl4;
            }
        }
        if (bl3 && view != null) {
            context = view.getContext();
        }
        boolean bl8 = VectorEnabledTintResources.shouldBeUsed();
        if (bl3 && view != null) {
            context = view.getContext();
        }
        context = b.f(context, attributeSet, (boolean)var4_7, bl4);
        if (bl8) {
            context = TintContextWrapper.wrap(context);
        }
        return context;
    }

    public View b(Context context, String string2, AttributeSet attributeSet) {
        View view = this.c(context, string2, attributeSet);
        if (view == null) {
            view = this.d(context, string2, attributeSet);
        }
        return view;
    }
}

