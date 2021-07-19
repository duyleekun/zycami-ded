/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package l.a.k.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import l.a.k.d.b;
import l.a.k.d.c;
import l.a.k.d.d;
import l.a.k.d.e;
import l.a.k.d.f;
import l.a.k.d.g;
import l.a.k.d.h;
import l.a.k.d.i;
import l.a.q.z;

public class a
implements l.a.e.g {
    /*
     * WARNING - void declaration
     */
    public View b(Context context, String object, AttributeSet attributeSet) {
        void var5_16;
        String string2 = "androidx.coordinatorlayout.widget.CoordinatorLayout";
        boolean n10 = string2.equals(object);
        if (n10) {
            object = new d(context, attributeSet);
            return object;
        }
        string2 = "com.google.android.material.";
        boolean bl2 = ((String)object).startsWith(string2);
        z z10 = null;
        if (!bl2) {
            return null;
        }
        ((String)object).hashCode();
        int n11 = -1;
        int n12 = ((String)object).hashCode();
        switch (n12) {
            default: {
                break;
            }
            case 1949496211: {
                String string3 = "com.google.android.material.bottomnavigation.BottomNavigationView";
                boolean bl3 = ((String)object).equals(string3);
                if (!bl3) break;
                int n13 = 7;
                break;
            }
            case 1634834867: {
                String string4 = "com.google.android.material.textfield.TextInputEditText";
                boolean bl4 = ((String)object).equals(string4);
                if (!bl4) break;
                int n14 = 6;
                break;
            }
            case 1589750150: {
                String string5 = "com.google.android.material.textfield.TextInputLayout";
                boolean bl5 = ((String)object).equals(string5);
                if (!bl5) break;
                int n15 = 5;
                break;
            }
            case 827811731: {
                String string6 = "com.google.android.material.navigation.NavigationView";
                boolean bl6 = ((String)object).equals(string6);
                if (!bl6) break;
                int n16 = 4;
                break;
            }
            case 391764942: {
                String string7 = "com.google.android.material.floatingactionbutton.FloatingActionButton";
                boolean bl7 = ((String)object).equals(string7);
                if (!bl7) break;
                int n17 = 3;
                break;
            }
            case -204374977: {
                String string8 = "com.google.android.material.appbar.CollapsingToolbarLayout";
                boolean bl8 = ((String)object).equals(string8);
                if (!bl8) break;
                int n18 = 2;
                break;
            }
            case -533274696: {
                String string9 = "com.google.android.material.appbar.AppBarLayout";
                boolean bl9 = ((String)object).equals(string9);
                if (!bl9) break;
                boolean bl10 = true;
                break;
            }
            case -2119513329: {
                String string10 = "com.google.android.material.tabs.TabLayout";
                boolean bl11 = ((String)object).equals(string10);
                if (!bl11) break;
                boolean bl12 = false;
                string2 = null;
            }
        }
        switch (var5_16) {
            default: {
                break;
            }
            case 7: {
                z10 = new b(context, attributeSet);
                break;
            }
            case 6: {
                z10 = new h(context, attributeSet);
                break;
            }
            case 5: {
                z10 = new i(context, attributeSet);
                break;
            }
            case 4: {
                z10 = new f(context, attributeSet);
                break;
            }
            case 3: {
                z10 = new e(context, attributeSet);
                break;
            }
            case 2: {
                z10 = new c(context, attributeSet);
                break;
            }
            case 1: {
                z10 = new l.a.k.d.a(context, attributeSet);
                break;
            }
            case 0: {
                z10 = new g(context, attributeSet);
            }
        }
        return z10;
    }
}

