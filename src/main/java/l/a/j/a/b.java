/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.LayerDrawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.TypedValue
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package l.a.j.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$drawable;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import l.a.j.a.b$a;
import l.a.j.a.b$b;
import l.a.j.a.b$c;
import l.a.j.a.b$d;
import l.a.j.a.c;
import l.a.j.a.d;
import l.a.j.a.e;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class b {
    private static final String h = "b";
    private static final boolean i = false;
    private static final PorterDuff.Mode j;
    private static final String k = "appcompat_skip_skip";
    private static final String l = "android.graphics.drawable.VectorDrawable";
    private static b m;
    private static final b$b n;
    private static final int[] o;
    private static final int[] p;
    private static final int[] q;
    private static final int[] r;
    private static final int[] s;
    private static final int[] t;
    private WeakHashMap a;
    private ArrayMap b;
    private SparseArray c;
    private final Object d;
    private final WeakHashMap e;
    private TypedValue f;
    private boolean g;

    static {
        int n10;
        int n11;
        j = PorterDuff.Mode.SRC_IN;
        int n12 = 6;
        Object object = new b$b(n12);
        n = object;
        int n13 = 3;
        int[] nArray = new int[n13];
        nArray[0] = n11 = R$drawable.abc_textfield_search_default_mtrl_alpha;
        n11 = R$drawable.abc_textfield_default_mtrl_alpha;
        int n14 = 1;
        nArray[n14] = n11;
        n11 = R$drawable.abc_ab_share_pack_mtrl_alpha;
        int n15 = 2;
        nArray[n15] = n11;
        o = nArray;
        nArray = new int[7];
        nArray[0] = n11 = R$drawable.abc_ic_commit_search_api_mtrl_alpha;
        nArray[n14] = n11 = R$drawable.abc_seekbar_tick_mark_material;
        nArray[n15] = n11 = R$drawable.abc_ic_menu_share_mtrl_alpha;
        nArray[n13] = n11 = R$drawable.abc_ic_menu_copy_mtrl_am_alpha;
        n11 = R$drawable.abc_ic_menu_cut_mtrl_alpha;
        int n16 = 4;
        nArray[n16] = n11;
        nArray[5] = n11 = R$drawable.abc_ic_menu_selectall_mtrl_alpha;
        nArray[n12] = n11 = R$drawable.abc_ic_menu_paste_mtrl_am_alpha;
        p = nArray;
        int[] nArray2 = new int[n16];
        nArray2[0] = n10 = R$drawable.abc_textfield_activated_mtrl_alpha;
        nArray2[n14] = n10 = R$drawable.abc_textfield_search_activated_mtrl_alpha;
        nArray2[n15] = n10 = R$drawable.abc_cab_background_top_mtrl_alpha;
        nArray2[n13] = n10 = R$drawable.abc_text_cursor_material;
        q = nArray2;
        object = new int[n13];
        n12 = R$drawable.abc_popup_background_mtrl_mult;
        object[0] = n12;
        n12 = R$drawable.abc_cab_background_internal_bg;
        object[n14] = n12;
        n12 = R$drawable.abc_menu_hardkey_panel_mtrl_mult;
        object[n15] = n12;
        r = (int[])object;
        object = new int[n15];
        n12 = R$drawable.abc_tab_indicator_material;
        object[0] = n12;
        n12 = R$drawable.abc_textfield_search_material;
        object[n14] = n12;
        s = (int[])object;
        object = new int[n15];
        n12 = R$drawable.abc_btn_check_material;
        object[0] = n12;
        n12 = R$drawable.abc_btn_radio_material;
        object[n14] = n12;
        t = (int[])object;
    }

    public b() {
        WeakHashMap weakHashMap = new WeakHashMap();
        this.d = weakHashMap;
        this.e = weakHashMap = new WeakHashMap(0);
    }

    private void A(String string2, b$c object) {
        Object object2 = this.b;
        if (object2 != null && (object2 = ((SimpleArrayMap)object2).get(string2)) == object) {
            object = this.b;
            ((SimpleArrayMap)object).remove(string2);
        }
    }

    private static void B(Drawable drawable2, int n10, PorterDuff.Mode mode) {
        boolean bl2 = l.a.j.a.c.a(drawable2);
        if (bl2) {
            drawable2 = drawable2.mutate();
        }
        if (mode == null) {
            mode = j;
        }
        PorterDuffColorFilter porterDuffColorFilter = l.a.j.a.b.s(n10, mode);
        drawable2.setColorFilter((ColorFilter)porterDuffColorFilter);
    }

    private Drawable C(Context context, int n10, boolean bl2, Drawable drawable2) {
        Drawable drawable3;
        ColorStateList colorStateList = this.t(context, n10);
        if (colorStateList != null) {
            boolean n15 = l.a.j.a.c.a(drawable3);
            if (n15) {
                drawable3 = drawable3.mutate();
            }
            drawable3 = DrawableCompat.wrap(drawable3);
            DrawableCompat.setTintList(drawable3, colorStateList);
            context = l.a.j.a.b.v(n10);
            if (context != null) {
                DrawableCompat.setTintMode(drawable3, (PorterDuff.Mode)context);
            }
        } else {
            int n11 = R$drawable.abc_seekbar_track_material;
            int n12 = 16908301;
            int n13 = 16908303;
            int n14 = 0x1020000;
            if (n10 == n11) {
                Drawable drawable5 = drawable3;
                drawable5 = (LayerDrawable)drawable3;
                Drawable drawable6 = drawable5.findDrawableByLayerId(n14);
                n11 = R$attr.colorControlNormal;
                n14 = l.a.j.a.e.d(context, n11);
                PorterDuff.Mode mode = j;
                l.a.j.a.b.B(drawable6, n14, mode);
                drawable6 = drawable5.findDrawableByLayerId(n13);
                n11 = l.a.j.a.e.d(context, n11);
                l.a.j.a.b.B(drawable6, n11, mode);
                drawable5 = drawable5.findDrawableByLayerId(n12);
                int n15 = R$attr.colorControlActivated;
                int bl4 = l.a.j.a.e.d(context, n15);
                l.a.j.a.b.B(drawable5, bl4, mode);
            } else {
                n11 = R$drawable.abc_ratingbar_material;
                if (n10 != n11 && n10 != (n11 = R$drawable.abc_ratingbar_indicator_material) && n10 != (n11 = R$drawable.abc_ratingbar_small_material)) {
                    boolean n16 = l.a.j.a.b.D(context, n10, drawable3);
                    if (!n16 && bl2) {
                        drawable3 = null;
                    }
                } else {
                    Drawable drawable4 = drawable3;
                    drawable4 = (LayerDrawable)drawable3;
                    Drawable drawable5 = drawable4.findDrawableByLayerId(n14);
                    n11 = R$attr.colorControlNormal;
                    n11 = l.a.j.a.e.a(context, n11);
                    PorterDuff.Mode mode = j;
                    l.a.j.a.b.B(drawable5, n11, mode);
                    drawable5 = drawable4.findDrawableByLayerId(n13);
                    n11 = R$attr.colorControlActivated;
                    n13 = l.a.j.a.e.d(context, n11);
                    l.a.j.a.b.B(drawable5, n13, mode);
                    drawable4 = drawable4.findDrawableByLayerId(n12);
                    int n16 = l.a.j.a.e.d(context, n11);
                    l.a.j.a.b.B(drawable4, n16, mode);
                }
            }
        }
        return drawable3;
    }

    /*
     * Unable to fully structure code
     */
    public static boolean D(Context var0, int var1_1, Drawable var2_2) {
        block7: {
            block9: {
                block8: {
                    var3_3 = l.a.j.a.b.j;
                    var4_4 = l.a.j.a.b.o;
                    var5_5 = l.a.j.a.b.d(var4_4, var1_1);
                    var6_6 = 0x1010031;
                    var7_7 = -1;
                    var8_8 = 0.0f / 0.0f;
                    var9_9 = 1;
                    if (var5_5 != 0) {
                        var6_6 = R$attr.colorControlNormal;
lbl10:
                        // 4 sources

                        while (true) {
                            var1_1 = var7_7;
                            var10_10 = var8_8;
lbl13:
                            // 2 sources

                            while (true) {
                                var5_5 = var9_9;
                                break block7;
                                break;
                            }
                            break;
                        }
                    }
                    var4_4 = l.a.j.a.b.q;
                    var5_5 = l.a.j.a.b.d(var4_4, var1_1);
                    if (var5_5 == 0) break block8;
                    var6_6 = R$attr.colorControlActivated;
                    ** GOTO lbl10
                }
                var4_4 = l.a.j.a.b.r;
                var5_5 = l.a.j.a.b.d(var4_4, var1_1);
                if (var5_5 == 0) break block9;
                var3_3 = PorterDuff.Mode.MULTIPLY;
                ** GOTO lbl10
            }
            var5_5 = R$drawable.abc_list_divider_mtrl_alpha;
            if (var1_1 == var5_5) {
                var6_6 = 0x1010030;
                var10_11 = 40.8f;
                var1_1 = Math.round(var10_11);
                ** continue;
            }
            var5_5 = R$drawable.abc_dialog_material_background;
            if (var1_1 != var5_5) ** break;
            ** while (true)
            var1_1 = var7_7;
            var10_12 = var8_8;
            var5_5 = 0;
            var4_4 = null;
            var6_6 = 0;
        }
        if (var5_5 != 0) {
            var5_5 = l.a.j.a.c.a(var2_2);
            if (var5_5 != 0) {
                var2_2 = var2_2.mutate();
            }
            var11_13 = l.a.j.a.e.d(var0, var6_6);
            var0 = l.a.j.a.b.s(var11_13, var3_3);
            var2_2.setColorFilter((ColorFilter)var0);
            if (var1_1 != var7_7) {
                var2_2.setAlpha(var1_1);
            }
            return var9_9;
        }
        return false;
    }

    private void a(String string2, b$c b$c) {
        ArrayMap arrayMap = this.b;
        if (arrayMap == null) {
            this.b = arrayMap = new ArrayMap();
        }
        this.b.put(string2, b$c);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean b(Context object, long l10, Drawable drawable2) {
        if ((drawable2 = drawable2.getConstantState()) == null) {
            return false;
        }
        Object object2 = this.d;
        synchronized (object2) {
            Object object3 = this.e;
            object3 = ((WeakHashMap)object3).get(object);
            object3 = (LongSparseArray)object3;
            if (object3 == null) {
                object3 = new LongSparseArray();
                WeakHashMap weakHashMap = this.e;
                weakHashMap.put(object, object3);
            }
            object = new WeakReference(drawable2);
            ((LongSparseArray)object3).put(l10, object);
            return true;
        }
    }

    private void c(Context context, int n10, ColorStateList colorStateList) {
        SparseArray sparseArray = this.a;
        if (sparseArray == null) {
            sparseArray = new WeakHashMap();
            this.a = sparseArray;
        }
        if ((sparseArray = (SparseArray)this.a.get(context)) == null) {
            sparseArray = new SparseArray();
            WeakHashMap weakHashMap = this.a;
            weakHashMap.put(context, sparseArray);
        }
        sparseArray.append(n10, (Object)colorStateList);
    }

    private static boolean d(int[] nArray, int n10) {
        for (int n11 : nArray) {
            if (n11 != n10) continue;
            return true;
        }
        return false;
    }

    private void e(Context object) {
        boolean bl2;
        int n10 = this.g;
        if (n10 != 0) {
            return;
        }
        this.g = true;
        n10 = R$drawable.abc_vector_test;
        if ((object = this.q((Context)object, n10)) != null && (bl2 = l.a.j.a.b.x((Drawable)object))) {
            return;
        }
        this.g = false;
        object = new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        throw object;
    }

    private ColorStateList g(Context context) {
        return this.h(context, 0);
    }

    private ColorStateList h(Context object, int n10) {
        int n11 = 4;
        int[][] nArrayArray = new int[n11][];
        int[] nArray = new int[n11];
        int n12 = R$attr.colorControlHighlight;
        n12 = l.a.j.a.e.d(object, n12);
        int n13 = R$attr.colorButtonNormal;
        int n14 = l.a.j.a.e.a(object, n13);
        int[] nArray2 = l.a.j.a.e.b;
        nArrayArray[0] = nArray2;
        nArray[0] = n14;
        object = l.a.j.a.e.k;
        n13 = 1;
        nArrayArray[n13] = (int[])object;
        nArray[n13] = n14 = ColorUtils.compositeColors(n12, n10);
        object = l.a.j.a.e.e;
        n13 = 2;
        nArrayArray[n13] = (int[])object;
        nArray[n13] = n14 = ColorUtils.compositeColors(n12, n10);
        object = l.a.j.a.e.o;
        n12 = 3;
        nArrayArray[n12] = (int[])object;
        nArray[n12] = n10;
        object = new ColorStateList((int[][])nArrayArray, nArray);
        return object;
    }

    private static long i(TypedValue typedValue) {
        long l10 = (long)typedValue.assetCookie << 32;
        long l11 = typedValue.data;
        return l10 | l11;
    }

    private ColorStateList j(Context context) {
        int n10 = R$attr.colorAccent;
        n10 = l.a.j.a.e.d(context, n10);
        return this.h(context, n10);
    }

    private ColorStateList k(Context context) {
        int n10 = R$attr.colorButtonNormal;
        n10 = l.a.j.a.e.d(context, n10);
        return this.h(context, n10);
    }

    private Drawable l(Context context, int n10) {
        TypedValue typedValue = this.f;
        if (typedValue == null) {
            this.f = typedValue = new TypedValue();
        }
        typedValue = this.f;
        int n11 = 1;
        l.a.j.a.d.s(context, n10, typedValue, n11 != 0);
        long l10 = l.a.j.a.b.i(typedValue);
        Drawable drawable2 = this.p(context, l10);
        if (drawable2 != null) {
            return drawable2;
        }
        int n12 = R$drawable.abc_cab_background_top_material;
        if (n10 == n12) {
            Drawable drawable3;
            Drawable drawable4;
            n10 = 2;
            Drawable[] drawableArray = new Drawable[n10];
            int n13 = R$drawable.abc_cab_background_internal_bg;
            drawableArray[0] = drawable4 = this.q(context, n13);
            n12 = R$drawable.abc_cab_background_top_mtrl_alpha;
            drawableArray[n11] = drawable3 = this.q(context, n12);
            drawable2 = new LayerDrawable(drawableArray);
        }
        if (drawable2 != null) {
            n10 = typedValue.changingConfigurations;
            drawable2.setChangingConfigurations(n10);
            this.b(context, l10, drawable2);
        }
        return drawable2;
    }

    private ColorStateList m(Context object) {
        boolean bl2;
        int n10 = 3;
        int[][] nArrayArray = new int[n10][];
        int[] nArray = new int[n10];
        int n11 = R$attr.colorSwitchThumbNormal;
        Object object2 = l.a.j.a.e.f(object, n11);
        int n12 = 2;
        int n13 = 1;
        if (object2 != null && (bl2 = object2.isStateful())) {
            int n14;
            int[] nArray2 = l.a.j.a.e.b;
            nArrayArray[0] = nArray2;
            nArray2 = nArrayArray[0];
            nArray[0] = n11 = object2.getColorForState(nArray2, 0);
            nArray2 = l.a.j.a.e.l;
            nArrayArray[n13] = nArray2;
            n11 = R$attr.colorControlActivated;
            nArray[n13] = n14 = l.a.j.a.e.d(object, n11);
            object = l.a.j.a.e.o;
            nArrayArray[n12] = (int[])object;
            nArray[n12] = n14 = object2.getDefaultColor();
        } else {
            int n15;
            int n16;
            object2 = l.a.j.a.e.b;
            nArrayArray[0] = (int[])object2;
            nArray[0] = n16 = l.a.j.a.e.a(object, n11);
            object2 = l.a.j.a.e.l;
            nArrayArray[n13] = (int[])object2;
            n16 = R$attr.colorControlActivated;
            nArray[n13] = n16 = l.a.j.a.e.d(object, n16);
            object2 = l.a.j.a.e.o;
            nArrayArray[n12] = (int[])object2;
            nArray[n12] = n15 = l.a.j.a.e.d(object, n11);
        }
        object = new ColorStateList((int[][])nArrayArray, nArray);
        return object;
    }

    private static PorterDuffColorFilter n(ColorStateList colorStateList, PorterDuff.Mode mode, int[] nArray) {
        if (colorStateList != null && mode != null) {
            return l.a.j.a.b.s(colorStateList.getColorForState(nArray, 0), mode);
        }
        return null;
    }

    public static b o() {
        b b10 = m;
        if (b10 == null) {
            m = b10 = new b();
            l.a.j.a.b.w(b10);
        }
        return m;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Drawable p(Context context, long l10) {
        Object object = this.d;
        synchronized (object) {
            Object object2 = this.e;
            object2 = ((WeakHashMap)object2).get(context);
            object2 = (LongSparseArray)object2;
            if (object2 == null) {
                return null;
            }
            Object object3 = ((LongSparseArray)object2).get(l10);
            if ((object3 = (WeakReference)object3) == null) return null;
            object3 = ((Reference)object3).get();
            if ((object3 = (Drawable.ConstantState)object3) != null) {
                context = context.getResources();
                return object3.newDrawable((Resources)context);
            }
            ((LongSparseArray)object2).delete(l10);
            return null;
        }
    }

    public static PorterDuffColorFilter s(int n10, PorterDuff.Mode mode) {
        b$b b$b = n;
        PorterDuffColorFilter porterDuffColorFilter = b$b.get(n10, mode);
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(n10, mode);
            b$b.put(n10, mode, porterDuffColorFilter);
        }
        return porterDuffColorFilter;
    }

    private ColorStateList u(Context object, int n10) {
        WeakHashMap weakHashMap = this.a;
        Object object2 = null;
        if (weakHashMap != null && (object = (SparseArray)weakHashMap.get(object)) != null) {
            object2 = object = object.get(n10);
            object2 = (ColorStateList)object;
        }
        return object2;
    }

    public static PorterDuff.Mode v(int n10) {
        PorterDuff.Mode mode;
        int n11 = R$drawable.abc_switch_thumb_material;
        if (n10 == n11) {
            mode = PorterDuff.Mode.MULTIPLY;
        } else {
            n10 = 0;
            mode = null;
        }
        return mode;
    }

    private static void w(b b10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            b$c b$c = new b$d();
            b10.a("vector", b$c);
            b$c = new b$a();
            String string2 = "animated-vector";
            b10.a(string2, b$c);
        }
    }

    private static boolean x(Drawable object) {
        String string2;
        boolean bl2;
        boolean bl3 = object instanceof VectorDrawableCompat;
        if (!bl3 && !(bl2 = (string2 = l).equals(object = object.getClass().getName()))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Drawable y(Context object, int n10) {
        String string2;
        boolean bl2;
        Object object2;
        int n11;
        Object object3 = this.b;
        String string3 = null;
        if (object3 == null) return null;
        int n12 = ((SimpleArrayMap)object3).isEmpty();
        if (n12 != 0) {
            return null;
        }
        object3 = this.c;
        String string4 = k;
        if (object3 != null) {
            n11 = string4.equals(object3 = (String)object3.get(n10));
            if (n11 != 0 || object3 != null && (object3 = ((SimpleArrayMap)(object2 = this.b)).get(object3)) == null) {
                return null;
            }
        } else {
            object3 = new SparseArray();
            this.c = object3;
        }
        if ((object3 = this.f) == null) {
            object3 = new TypedValue();
            this.f = object3;
        }
        object3 = this.f;
        n11 = 1;
        l.a.j.a.d.s(object, n10, (TypedValue)object3, n11 != 0);
        long l10 = l.a.j.a.b.i((TypedValue)object3);
        Object object4 = this.p((Context)object, l10);
        if (object4 != null) {
            return object4;
        }
        CharSequence charSequence = ((TypedValue)object3).string;
        if (charSequence != null && (bl2 = ((String)(charSequence = charSequence.toString())).endsWith(string2 = ".xml"))) {
            try {
                int n13;
                int n14;
                charSequence = l.a.j.a.d.t(object, n10);
                string2 = Xml.asAttributeSet((XmlPullParser)charSequence);
                while ((n14 = charSequence.next()) != (n13 = 2) && n14 != n11) {
                }
                if (n14 != n13) {
                    object3 = "No start tag found";
                    object = new XmlPullParserException((String)object3);
                    throw object;
                }
                object2 = charSequence.getName();
                Object object5 = this.c;
                object5.append(n10, object2);
                object5 = this.b;
                object2 = ((SimpleArrayMap)object5).get(object2);
                object2 = (b$c)object2;
                if (object2 != null) {
                    string3 = object2.createFromXmlInner((Context)object, (XmlPullParser)charSequence, (AttributeSet)string2, null);
                    object4 = string3;
                }
                if (object4 != null) {
                    n12 = ((TypedValue)object3).changingConfigurations;
                    object4.setChangingConfigurations(n12);
                    this.b((Context)object, l10, (Drawable)object4);
                }
            }
            catch (Exception exception) {
                object3 = h;
                string3 = "Exception while inflating drawable";
                Log.e((String)object3, (String)string3, (Throwable)exception);
            }
        }
        if (object4 == null) {
            object = this.c;
            object.append(n10, (Object)string4);
        }
        return object4;
    }

    public void f() {
        this.e.clear();
        Object object = this.c;
        if (object != null) {
            object.clear();
        }
        if ((object = this.a) != null) {
            ((WeakHashMap)object).clear();
        }
        n.evictAll();
    }

    public Drawable q(Context context, int n10) {
        return this.r(context, n10, false);
    }

    public Drawable r(Context context, int n10, boolean bl2) {
        this.e(context);
        Drawable drawable2 = this.y(context, n10);
        if (drawable2 == null) {
            drawable2 = this.l(context, n10);
        }
        if (drawable2 == null) {
            drawable2 = l.a.j.a.d.g(context, n10);
        }
        if (drawable2 != null) {
            drawable2 = this.C(context, n10, bl2, drawable2);
        }
        if (drawable2 != null) {
            l.a.j.a.c.b(drawable2);
        }
        return drawable2;
    }

    public ColorStateList t(Context context, int n10) {
        ColorStateList colorStateList = this.u(context, n10);
        if (colorStateList == null) {
            int n11 = R$drawable.abc_edit_text_material;
            if (n10 == n11) {
                int n12 = R$color.abc_tint_edittext;
                colorStateList = l.a.j.a.d.e(context, n12);
            } else {
                n11 = R$drawable.abc_switch_track_mtrl_alpha;
                if (n10 == n11) {
                    int n13 = R$color.abc_tint_switch_track;
                    colorStateList = l.a.j.a.d.e(context, n13);
                } else {
                    n11 = R$drawable.abc_switch_thumb_material;
                    if (n10 == n11) {
                        colorStateList = this.m(context);
                    } else {
                        n11 = R$drawable.abc_btn_default_mtrl_shape;
                        if (n10 == n11) {
                            colorStateList = this.k(context);
                        } else {
                            n11 = R$drawable.abc_btn_borderless_material;
                            if (n10 == n11) {
                                colorStateList = this.g(context);
                            } else {
                                n11 = R$drawable.abc_btn_colored_material;
                                if (n10 == n11) {
                                    colorStateList = this.j(context);
                                } else {
                                    n11 = R$drawable.abc_spinner_mtrl_am_alpha;
                                    if (n10 != n11 && n10 != (n11 = R$drawable.abc_spinner_textfield_background_material)) {
                                        int[] nArray = p;
                                        n11 = (int)(l.a.j.a.b.d(nArray, n10) ? 1 : 0);
                                        if (n11 != 0) {
                                            int n14 = R$attr.colorControlNormal;
                                            colorStateList = l.a.j.a.e.f(context, n14);
                                        } else {
                                            nArray = s;
                                            n11 = (int)(l.a.j.a.b.d(nArray, n10) ? 1 : 0);
                                            if (n11 != 0) {
                                                int n15 = R$color.abc_tint_default;
                                                colorStateList = l.a.j.a.d.e(context, n15);
                                            } else {
                                                nArray = t;
                                                n11 = (int)(l.a.j.a.b.d(nArray, n10) ? 1 : 0);
                                                if (n11 != 0) {
                                                    int n16 = R$color.abc_tint_btn_checkable;
                                                    colorStateList = l.a.j.a.d.e(context, n16);
                                                } else {
                                                    n11 = R$drawable.abc_seekbar_thumb_material;
                                                    if (n10 == n11) {
                                                        int n17 = R$color.abc_tint_seek_thumb;
                                                        colorStateList = l.a.j.a.d.e(context, n17);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        int n18 = R$color.abc_tint_spinner;
                                        colorStateList = l.a.j.a.d.e(context, n18);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (colorStateList != null) {
                this.c(context, n10, colorStateList);
            }
        }
        return colorStateList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(Context object) {
        Object object2 = this.d;
        synchronized (object2) {
            WeakHashMap weakHashMap = this.e;
            object = weakHashMap.get(object);
            object = (LongSparseArray)object;
            if (object != null) {
                ((LongSparseArray)object).clear();
            }
            return;
        }
    }
}

