/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Matrix
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package l.a.j.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import l.a.c;
import l.a.j.a.a;
import l.a.o.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    private static final String i = "SkinCompatUserThemeManager";
    private static final String j = "type";
    private static final String k = "color";
    private static final String l = "drawable";
    private static final String m = "drawableName";
    private static final String n = "drawablePathAndAngle";
    private static f o;
    private final HashMap a;
    private final Object b;
    private final WeakHashMap c;
    private boolean d;
    private final HashMap e;
    private final Object f;
    private final WeakHashMap g;
    private boolean h;

    static {
        f f10;
        o = f10 = new f();
    }

    private f() {
        block2: {
            WeakHashMap weakHashMap = new WeakHashMap();
            this.a = weakHashMap;
            weakHashMap = new WeakHashMap();
            this.b = weakHashMap;
            weakHashMap = new WeakHashMap();
            this.c = weakHashMap;
            this.e = weakHashMap;
            weakHashMap = new WeakHashMap();
            this.f = weakHashMap;
            this.g = weakHashMap = new WeakHashMap();
            try {
                this.E();
            }
            catch (JSONException jSONException) {
                this.a.clear();
                Object object = this.e;
                ((HashMap)object).clear();
                boolean bl2 = l.a.o.f.a;
                if (!bl2) break block2;
                super();
                String string2 = "startLoadFromSharedPreferences error: ";
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append((Object)jSONException);
                String string3 = ((StringBuilder)object).toString();
                object = i;
                l.a.o.f.b((String)object, string3);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void C(int n10) {
        Object object = this.f;
        synchronized (object) {
            WeakHashMap weakHashMap = this.g;
            Integer n11 = n10;
            weakHashMap.remove(n11);
            return;
        }
    }

    private void E() {
        int n10;
        CharSequence charSequence = l.a.o.e.b().e();
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl2) {
            String string2;
            JSONArray jSONArray = new JSONArray((String)charSequence);
            n10 = l.a.o.f.a;
            if (n10 != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("startLoadFromSharedPreferences: ");
                string2 = jSONArray.toString();
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                string2 = i;
                l.a.o.f.b(string2, (String)charSequence);
            }
            n10 = jSONArray.length();
            string2 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object;
                Object object2 = jSONArray.getJSONObject(i10);
                boolean bl3 = object2.has((String)(object = j));
                if (!bl3) continue;
                Object object3 = k;
                bl3 = ((String)object3).equals(object = object2.getString((String)object));
                if (bl3) {
                    if ((object2 = l.a.j.a.a.b(object2)) == null) continue;
                    object = this.a;
                    object3 = object2.b;
                    ((HashMap)object).put(object3, object2);
                    continue;
                }
                object3 = l;
                boolean bl4 = ((String)object3).equals(object);
                if (!bl4) continue;
                object = object2.getString(m);
                object3 = n;
                object2 = object2.getString((String)object3);
                bl3 = TextUtils.isEmpty((CharSequence)object);
                if (bl3 || (bl3 = TextUtils.isEmpty((CharSequence)object2))) continue;
                object3 = this.e;
                ((HashMap)object3).put(object, object2);
            }
        }
        this.d = n10 = this.a.isEmpty();
        n10 = this.e.isEmpty();
        this.h = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(int n10, ColorStateList colorStateList) {
        if (colorStateList == null) return;
        Object object = this.b;
        synchronized (object) {
            WeakHashMap weakHashMap = this.c;
            Integer n11 = n10;
            WeakReference<ColorStateList> weakReference = new WeakReference<ColorStateList>(colorStateList);
            weakHashMap.put(n11, weakReference);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f(int n10, Drawable drawable2) {
        if (drawable2 == null) return;
        Object object = this.f;
        synchronized (object) {
            WeakHashMap weakHashMap = this.g;
            Integer n11 = n10;
            WeakReference<Drawable> weakReference = new WeakReference<Drawable>(drawable2);
            weakHashMap.put(n11, weakReference);
            return;
        }
    }

    private static boolean h(String string2) {
        File file;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (bl2 = (file = new File(string2)).exists())) {
            bl2 = true;
        } else {
            bl2 = false;
            file = null;
        }
        boolean bl3 = l.a.o.f.a;
        if (bl3 && !bl2) {
            CharSequence charSequence = new StringBuilder();
            String string3 = "Invalid drawable path : ";
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = charSequence.toString();
            charSequence = i;
            l.a.o.f.b((String)charSequence, string2);
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        Object object = this.b;
        synchronized (object) {
            WeakHashMap weakHashMap = this.c;
            weakHashMap.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void l() {
        Object object = this.f;
        synchronized (object) {
            WeakHashMap weakHashMap = this.g;
            weakHashMap.clear();
            return;
        }
    }

    public static f n() {
        return o;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ColorStateList o(int n10) {
        Object object = this.b;
        synchronized (object) {
            Object object2 = this.c;
            Integer n11 = n10;
            object2 = ((WeakHashMap)object2).get(n11);
            object2 = (WeakReference)object2;
            if (object2 != null) {
                object2 = ((Reference)object2).get();
                if ((object2 = (ColorStateList)object2) != null) {
                    return object2;
                }
                object2 = this.c;
                Integer n12 = n10;
                ((WeakHashMap)object2).remove(n12);
            }
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Drawable p(int n10) {
        Object object = this.f;
        synchronized (object) {
            Object object2 = this.g;
            Integer n11 = n10;
            object2 = ((WeakHashMap)object2).get(n11);
            object2 = (WeakReference)object2;
            if (object2 != null) {
                object2 = ((Reference)object2).get();
                if ((object2 = (Drawable)object2) != null) {
                    return object2;
                }
                object2 = this.g;
                Integer n12 = n10;
                ((WeakHashMap)object2).remove(n12);
            }
            return null;
        }
    }

    private String w(int n10, String string2) {
        Context context = l.a.c.r().n();
        String string3 = context.getResources().getResourceTypeName(n10);
        boolean bl2 = string2.equalsIgnoreCase(string3);
        if (bl2) {
            return context.getResources().getResourceEntryName(n10);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void z(int n10) {
        Object object = this.b;
        synchronized (object) {
            WeakHashMap weakHashMap = this.c;
            Integer n11 = n10;
            weakHashMap.remove(n11);
            return;
        }
    }

    public void A(int n10) {
        String string2 = this.w(n10, k);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            HashMap hashMap = this.a;
            hashMap.remove(string2);
            this.z(n10);
            HashMap hashMap2 = this.a;
            n10 = (int)(hashMap2.isEmpty() ? 1 : 0);
            this.d = n10;
        }
    }

    public void B(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            boolean bl3;
            HashMap hashMap = this.a;
            hashMap.remove(object);
            object = this.a;
            this.d = bl3 = ((HashMap)object).isEmpty();
        }
    }

    public void D(int n10) {
        String string2 = this.w(n10, l);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            HashMap hashMap = this.e;
            hashMap.remove(string2);
            this.C(n10);
            HashMap hashMap2 = this.e;
            n10 = (int)(hashMap2.isEmpty() ? 1 : 0);
            this.h = n10;
        }
    }

    public void a(int n10, String string2) {
        String string3 = "colorDefault";
        boolean bl2 = l.a.j.a.a.a(string3, string2);
        if (!bl2) {
            return;
        }
        string3 = this.w(n10, k);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) {
            HashMap hashMap = this.a;
            a a10 = new a(string3, string2);
            hashMap.put(string3, a10);
            this.z(n10);
            n10 = 0;
            this.d = false;
        }
    }

    public void b(int n10, a a10) {
        String string2 = this.w(n10, k);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && a10 != null) {
            a10.b = string2;
            HashMap hashMap = this.a;
            hashMap.put(string2, a10);
            this.z(n10);
            n10 = 0;
            this.d = false;
        }
    }

    public void d(int n10, String string2) {
        boolean bl2 = l.a.j.a.f.h(string2);
        if (!bl2) {
            return;
        }
        String string3 = this.w(n10, l);
        int n11 = TextUtils.isEmpty((CharSequence)string3);
        if (n11 == 0) {
            n11 = l.a.o.a.a(string2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(":");
            string2 = String.valueOf(n11);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            HashMap hashMap = this.e;
            hashMap.put(string3, string2);
            this.C(n10);
            n10 = 0;
            this.h = false;
        }
    }

    public void e(int n10, String string2, int n11) {
        boolean bl2 = l.a.j.a.f.h(string2);
        if (!bl2) {
            return;
        }
        String string3 = this.w(n10, l);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(":");
            string2 = String.valueOf(n11);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            HashMap hashMap = this.e;
            hashMap.put(string3, string2);
            this.C(n10);
            n10 = 0;
            this.h = false;
        }
    }

    public void g() {
        Object object;
        Object object2;
        String string2;
        boolean bl2;
        Object object3 = new JSONArray();
        Object object4 = this.a.keySet().iterator();
        while (true) {
            bl2 = object4.hasNext();
            string2 = j;
            if (!bl2) break;
            object2 = (String)object4.next();
            object = this.a;
            if ((object2 = (a)((HashMap)object).get(object2)) == null) continue;
            object2 = l.a.j.a.a.t((a)object2);
            object = k;
            object2 = object2.putOpt(string2, object);
            try {
                object3.put(object2);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
        object4 = this.e.keySet().iterator();
        while (bl2 = object4.hasNext()) {
            object2 = (String)object4.next();
            object = new JSONObject();
            String string3 = l;
            object = object.putOpt(string2, (Object)string3);
            string3 = m;
            object = object.putOpt(string3, object2);
            string3 = n;
            HashMap hashMap = this.e;
            object2 = hashMap.get(object2);
            object2 = object.putOpt(string3, object2);
            try {
                object3.put(object2);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
        boolean bl3 = l.a.o.f.a;
        if (bl3) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("Apply user theme: ");
            object2 = object3.toString();
            ((StringBuilder)object4).append((String)object2);
            object4 = ((StringBuilder)object4).toString();
            object2 = i;
            l.a.o.f.b((String)object2, (String)object4);
        }
        object4 = l.a.o.e.b();
        object3 = object3.toString();
        ((e)object4).i((String)object3).a();
        l.a.c.r().e();
    }

    public void i() {
        this.j();
        this.l();
    }

    public void k() {
        this.a.clear();
        this.j();
        this.d = true;
        this.g();
    }

    public void m() {
        this.e.clear();
        this.l();
        this.h = true;
        this.g();
    }

    public a q(int n10) {
        String string2 = k;
        String string3 = this.w(n10, string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            return (a)this.a.get(string3);
        }
        return null;
    }

    public a r(String string2) {
        return (a)this.a.get(string2);
    }

    public ColorStateList s(int n10) {
        HashMap hashMap;
        Object object;
        boolean bl2;
        ColorStateList colorStateList = this.o(n10);
        if (colorStateList == null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.w(n10, k)))) && (object = (a)(hashMap = this.a).get(object)) != null && (colorStateList = ((a)object).r()) != null) {
            this.c(n10, colorStateList);
        }
        return colorStateList;
    }

    public Drawable t(int n10) {
        HashMap hashMap;
        Object object;
        int n11;
        Object object2 = this.p(n10);
        if (object2 == null && (n11 = TextUtils.isEmpty((CharSequence)(object = this.w(n10, l)))) == 0 && (n11 = TextUtils.isEmpty((CharSequence)(object = (String)(hashMap = this.e).get(object)))) == 0) {
            boolean bl2;
            object = ((String)object).split(":");
            n11 = 0;
            hashMap = null;
            String string2 = object[0];
            int n12 = ((String[])object).length;
            int n13 = 2;
            if (n12 == n13) {
                object = Integer.valueOf(object[1]);
                n11 = (Integer)object;
            }
            if (bl2 = l.a.j.a.f.h(string2)) {
                if (n11 == 0) {
                    object2 = Drawable.createFromPath((String)string2);
                } else {
                    Matrix matrix = new Matrix();
                    float f10 = n11;
                    matrix.postRotate(f10);
                    object = BitmapFactory.decodeFile((String)string2);
                    string2 = null;
                    n12 = object.getWidth();
                    n13 = object.getHeight();
                    boolean bl3 = true;
                    object2 = Bitmap.createBitmap((Bitmap)object, (int)0, (int)0, (int)n12, (int)n13, (Matrix)matrix, (boolean)bl3);
                    n11 = 0;
                    hashMap = null;
                    object = new BitmapDrawable(null, (Bitmap)object2);
                    object2 = object;
                }
                if (object2 != null) {
                    this.f(n10, (Drawable)object2);
                }
            }
        }
        return object2;
    }

    public int u(String stringArray) {
        int n10;
        Object object = this.e;
        int n11 = TextUtils.isEmpty((CharSequence)(stringArray = (String)((HashMap)object).get(stringArray)));
        if (n11 == 0 && (n11 = (stringArray = stringArray.split((String)(object = ":"))).length) == (n10 = 2)) {
            return Integer.valueOf(stringArray[1]);
        }
        return 0;
    }

    public String v(String string2) {
        HashMap hashMap = this.e;
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = (String)hashMap.get(string2)));
        if (!bl2) {
            return string2.split(":")[0];
        }
        return "";
    }

    public boolean x() {
        return this.d;
    }

    public boolean y() {
        return this.h;
    }
}

