/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.ComponentCallbacks
 *  android.content.ComponentCallbacks2
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.View
 */
package d.c.a;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.GeneratedAppGlideModule;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import d.c.a.o.f;
import d.c.a.o.h;
import d.c.a.o.j.e$a;
import d.c.a.o.k.a0.d$a;
import d.c.a.o.k.i;
import d.c.a.o.k.x.b;
import d.c.a.o.k.x.e;
import d.c.a.o.k.y.j;
import d.c.a.o.l.a$b;
import d.c.a.o.l.a$c;
import d.c.a.o.l.b$a;
import d.c.a.o.l.b$d;
import d.c.a.o.l.d$b;
import d.c.a.o.l.e$c;
import d.c.a.o.l.f$b;
import d.c.a.o.l.f$e;
import d.c.a.o.l.g;
import d.c.a.o.l.o;
import d.c.a.o.l.s$b;
import d.c.a.o.l.s$c;
import d.c.a.o.l.t;
import d.c.a.o.l.u$a;
import d.c.a.o.l.u$b;
import d.c.a.o.l.u$c;
import d.c.a.o.l.v$a;
import d.c.a.o.l.w$d;
import d.c.a.o.l.y.c$a;
import d.c.a.o.l.y.f$c;
import d.c.a.o.m.d.c0;
import d.c.a.o.m.d.e0;
import d.c.a.o.m.d.g0;
import d.c.a.o.m.d.r;
import d.c.a.o.m.d.w;
import d.c.a.o.m.d.y;
import d.c.a.o.m.d.z;
import d.c.a.o.m.g.a;
import d.c.a.p.k$b;
import d.c.a.q.d;
import d.c.a.s.j.k;
import d.c.a.s.j.p;
import d.c.a.u.m;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
implements ComponentCallbacks2 {
    private static final String m = "image_manager_disk_cache";
    private static final String n = "Glide";
    private static volatile c o;
    private static volatile boolean p;
    private final i a;
    private final e b;
    private final j c;
    private final d.c.a.e d;
    private final Registry e;
    private final b f;
    private final d.c.a.p.k g;
    private final d.c.a.p.d h;
    private final List i;
    private final d.c.a.c$a j;
    private MemoryCategory k;
    private d.c.a.o.k.a0.b l;

    public c(Context context, i i10, j j10, e e10, b b10, d.c.a.p.k k10, d.c.a.p.d d10, int n10, d.c.a.c$a c$a, Map map, List list, boolean bl2, boolean bl3) {
        int n11;
        Object object;
        Registry registry;
        Object object2;
        Object object3 = this;
        Object object4 = context;
        Object object5 = e10;
        b b11 = b10;
        Object object6 = d.c.a.m.a.class;
        Object object7 = String.class;
        Object object8 = Integer.class;
        Object object9 = byte[].class;
        this.i = object2 = new Object();
        object2 = MemoryCategory.NORMAL;
        this.k = object2;
        Object object10 = i10;
        this.a = i10;
        this.b = e10;
        this.f = b10;
        object2 = j10;
        this.c = j10;
        object2 = k10;
        this.g = k10;
        object2 = d10;
        this.h = d10;
        object2 = c$a;
        this.j = c$a;
        Resources resources = context.getResources();
        this.e = registry = new Registry();
        Object object11 = new DefaultImageHeaderParser();
        registry.t((ImageHeaderParser)object11);
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 27;
        if (n12 >= n13) {
            object = new r();
            registry.t((ImageHeaderParser)object);
        }
        object = registry.g();
        d.c.a.o.m.h.a a10 = new d.c.a.o.m.h.a((Context)object4, (List)object, (e)object5, b11);
        d.c.a.o.g g10 = g0.h(e10);
        object10 = registry.g();
        object3 = resources.getDisplayMetrics();
        super((List)object10, (DisplayMetrics)object3, (e)object5, b11);
        if (bl3 && n12 >= (n11 = 28)) {
            object3 = new w();
            object10 = new d.c.a.o.m.d.k();
        } else {
            object10 = new d.c.a.o.m.d.j((d.c.a.o.m.d.o)object2);
            object3 = new c0((d.c.a.o.m.d.o)object2, b11);
        }
        Class<byte[]> clazz = object9;
        object9 = new d.c.a.o.m.f.e((Context)object4);
        int n14 = n12;
        object11 = new s$c(resources);
        super(resources);
        Class<String> clazz2 = object7;
        object7 = new s$b(resources);
        k10 = object4;
        super(resources);
        d10 = object4;
        super(b11);
        ContentResolver contentResolver = object8;
        object8 = new d.c.a.o.m.i.a();
        Class<InputStream> clazz3 = object8;
        object8 = new d.c.a.o.m.i.d();
        Class<InputStream> clazz4 = object8;
        ContentResolver contentResolver2 = context.getContentResolver();
        Class<ParcelFileDescriptor> clazz5 = object7;
        object7 = new d.c.a.o.l.c();
        object7 = registry.a(ByteBuffer.class, (d.c.a.o.a)object7);
        Class<Bitmap> clazz6 = object11;
        object11 = new t(b11);
        object7 = ((Registry)object7).a(InputStream.class, (d.c.a.o.a)object11);
        ContentResolver contentResolver3 = object9;
        object9 = "Bitmap";
        object7 = ((Registry)object7).e((String)object9, ByteBuffer.class, Bitmap.class, (d.c.a.o.g)object10);
        object8 = InputStream.class;
        object11 = Bitmap.class;
        ((Registry)object7).e((String)object9, (Class)object8, (Class)object11, (d.c.a.o.g)object3);
        boolean bl4 = d.c.a.o.j.m.c();
        if (bl4) {
            object7 = ParcelFileDescriptor.class;
            object8 = Bitmap.class;
            object11 = new y((d.c.a.o.m.d.o)object2);
            registry.e((String)object9, (Class)object7, (Class)object8, (d.c.a.o.g)object11);
        }
        object7 = registry.e((String)object9, ParcelFileDescriptor.class, Bitmap.class, g10);
        object11 = g0.c(e10);
        object7 = ((Registry)object7).e((String)object9, AssetFileDescriptor.class, Bitmap.class, (d.c.a.o.g)object11);
        object11 = v$a.b();
        object7 = ((Registry)object7).d(Bitmap.class, Bitmap.class, (o)object11);
        object11 = new e0();
        object7 = ((Registry)object7).e((String)object9, Bitmap.class, Bitmap.class, (d.c.a.o.g)object11).b(Bitmap.class, (h)object4);
        object11 = new d.c.a.o.m.d.a(resources, (d.c.a.o.g)object10);
        object10 = "BitmapDrawable";
        object7 = ((Registry)object7).e((String)object10, ByteBuffer.class, BitmapDrawable.class, (d.c.a.o.g)object11);
        object11 = new d.c.a.o.m.d.a(resources, (d.c.a.o.g)object3);
        object3 = ((Registry)object7).e((String)object10, InputStream.class, BitmapDrawable.class, (d.c.a.o.g)object11);
        super(resources, g10);
        object3 = ((Registry)object3).e((String)object10, ParcelFileDescriptor.class, BitmapDrawable.class, (d.c.a.o.g)object2);
        object8 = new d.c.a.o.m.d.b((e)object5, (h)object4);
        object3 = ((Registry)object3).b(BitmapDrawable.class, (h)object8);
        object8 = new d.c.a.o.m.h.j((List)object, a10, b11);
        object2 = "Gif";
        object3 = ((Registry)object3).e((String)object2, InputStream.class, d.c.a.o.m.h.c.class, (d.c.a.o.g)object8).e((String)object2, ByteBuffer.class, d.c.a.o.m.h.c.class, a10);
        object7 = new d.c.a.o.m.h.d();
        object3 = ((Registry)object3).b(d.c.a.o.m.h.c.class, (h)object7);
        object4 = v$a.b();
        object3 = ((Registry)object3).d((Class)object6, (Class)object6, (o)object4);
        object7 = new d.c.a.o.m.h.h((e)object5);
        object3 = ((Registry)object3).e((String)object9, (Class)object6, Bitmap.class, (d.c.a.o.g)object7);
        object7 = contentResolver3;
        object3 = ((Registry)object3).c(Uri.class, Drawable.class, (d.c.a.o.g)contentResolver3);
        object8 = new z((d.c.a.o.m.f.e)contentResolver3, (e)object5);
        object3 = ((Registry)object3).c(Uri.class, Bitmap.class, (d.c.a.o.g)object8);
        super();
        object3 = ((Registry)object3).u((e$a)object4);
        object7 = new d$b();
        object3 = ((Registry)object3).d(File.class, ByteBuffer.class, (o)object7);
        object7 = new f$e();
        object3 = ((Registry)object3).d(File.class, InputStream.class, (o)object7);
        object7 = new a();
        object3 = ((Registry)object3).c(File.class, File.class, (d.c.a.o.g)object7);
        object7 = new f$b();
        object3 = ((Registry)object3).d(File.class, ParcelFileDescriptor.class, (o)object7);
        object6 = File.class;
        object7 = v$a.b();
        object3 = ((Registry)object3).d(File.class, (Class)object6, (o)object7);
        super(b11);
        ((Registry)object3).u((e$a)object4);
        n11 = (int)(d.c.a.o.j.m.c() ? 1 : 0);
        if (n11 != 0) {
            super();
            registry.u((e$a)object3);
        }
        object3 = Integer.TYPE;
        object6 = clazz6;
        object4 = registry.d((Class)object3, InputStream.class, (o)((Object)clazz6));
        object8 = clazz5;
        object4 = ((Registry)object4).d((Class)object3, ParcelFileDescriptor.class, (o)((Object)clazz5));
        object9 = contentResolver;
        object4 = ((Registry)object4).d((Class)contentResolver, InputStream.class, (o)((Object)clazz6)).d((Class)contentResolver, ParcelFileDescriptor.class, (o)((Object)clazz5));
        object7 = k10;
        object4 = ((Registry)object4).d((Class)contentResolver, Uri.class, (o)((Object)k10));
        object8 = d10;
        object3 = ((Registry)object4).d((Class)object3, AssetFileDescriptor.class, (o)((Object)d10)).d((Class)contentResolver, AssetFileDescriptor.class, (o)((Object)d10)).d((Class)object3, Uri.class, (o)((Object)k10));
        object6 = new e$c();
        object7 = clazz2;
        object3 = ((Registry)object3).d(clazz2, InputStream.class, (o)object6);
        object8 = new e$c();
        object3 = ((Registry)object3).d(Uri.class, InputStream.class, (o)object8);
        object6 = new u$c();
        object3 = ((Registry)object3).d(clazz2, InputStream.class, (o)object6);
        object6 = new u$b();
        object3 = ((Registry)object3).d(clazz2, ParcelFileDescriptor.class, (o)object6);
        object6 = new u$a();
        object3 = ((Registry)object3).d(clazz2, AssetFileDescriptor.class, (o)object6);
        object7 = new c$a();
        object3 = ((Registry)object3).d(Uri.class, InputStream.class, (o)object7);
        object8 = context.getAssets();
        object7 = new a$c((AssetManager)object8);
        object3 = ((Registry)object3).d(Uri.class, InputStream.class, (o)object7);
        object8 = context.getAssets();
        object7 = new a$b((AssetManager)object8);
        object3 = ((Registry)object3).d(Uri.class, ParcelFileDescriptor.class, (o)object7);
        object8 = context;
        object7 = new d.c.a.o.l.y.d$a(context);
        object3 = ((Registry)object3).d(Uri.class, InputStream.class, (o)object7);
        object4 = Uri.class;
        object6 = InputStream.class;
        object7 = new d.c.a.o.l.y.e$a(context);
        ((Registry)object3).d((Class)object4, (Class)object6, (o)object7);
        n11 = 29;
        int n15 = n14;
        if (n14 >= n11) {
            object7 = new f$c(context);
            registry.d(Uri.class, InputStream.class, (o)object7);
            object3 = Uri.class;
            object6 = ParcelFileDescriptor.class;
            object7 = new d.c.a.o.l.y.f$b(context);
            registry.d((Class)object3, (Class)object6, (o)object7);
        }
        object9 = contentResolver2;
        object7 = new w$d(contentResolver2);
        object3 = registry.d(Uri.class, InputStream.class, (o)object7);
        super(contentResolver2);
        object3 = ((Registry)object3).d(Uri.class, ParcelFileDescriptor.class, (o)object2);
        super(contentResolver2);
        object3 = ((Registry)object3).d(Uri.class, AssetFileDescriptor.class, (o)object2);
        super();
        object3 = ((Registry)object3).d(Uri.class, InputStream.class, (o)object9);
        super();
        object3 = ((Registry)object3).d(URL.class, InputStream.class, (o)object9);
        super((Context)object8);
        object3 = ((Registry)object3).d(Uri.class, File.class, (o)object9);
        super();
        object3 = ((Registry)object3).d(g.class, InputStream.class, (o)object9);
        object7 = new b$a();
        object9 = clazz;
        object3 = ((Registry)object3).d(clazz, ByteBuffer.class, (o)object7);
        object7 = new b$d();
        object3 = ((Registry)object3).d(clazz, InputStream.class, (o)object7);
        object2 = v$a.b();
        object3 = ((Registry)object3).d(Uri.class, Uri.class, (o)object2);
        object2 = v$a.b();
        object3 = ((Registry)object3).d(Drawable.class, Drawable.class, (o)object2);
        super();
        object3 = ((Registry)object3).c(Drawable.class, Drawable.class, (d.c.a.o.g)object2);
        super(resources);
        object3 = ((Registry)object3).x(Bitmap.class, BitmapDrawable.class, (d.c.a.o.m.i.e)object2);
        object7 = clazz3;
        object3 = ((Registry)object3).x(Bitmap.class, clazz, (d.c.a.o.m.i.e)((Object)clazz3));
        object10 = clazz4;
        super((e)object5, (d.c.a.o.m.i.e)((Object)clazz3), (d.c.a.o.m.i.e)((Object)clazz4));
        object3 = ((Registry)object3).x(Drawable.class, clazz, (d.c.a.o.m.i.e)object2);
        object6 = d.c.a.o.m.h.c.class;
        ((Registry)object3).x((Class)object6, clazz, (d.c.a.o.m.i.e)((Object)clazz4));
        n11 = 23;
        if (n15 >= n11) {
            object3 = g0.d(e10);
            registry.c(ByteBuffer.class, Bitmap.class, (d.c.a.o.g)object3);
            object5 = ByteBuffer.class;
            object4 = BitmapDrawable.class;
            object6 = new d.c.a.o.m.d.a(resources, (d.c.a.o.g)object3);
            registry.c((Class)object5, (Class)object4, (d.c.a.o.g)object6);
        }
        object7 = new k();
        object5 = object3;
        object4 = context;
        b11 = b10;
        object6 = registry;
        object8 = c$a;
        object9 = map;
        object2 = list;
        object10 = i10;
        object3 = new d.c.a.e(context, b10, registry, (k)object7, c$a, map, list, i10, bl2, n10);
        object5 = this;
        this.d = object3;
    }

    public static d.c.a.i B(Activity activity) {
        return d.c.a.c.o((Context)activity).i(activity);
    }

    public static d.c.a.i C(Fragment fragment) {
        return d.c.a.c.o((Context)fragment.getActivity()).j(fragment);
    }

    public static d.c.a.i D(Context context) {
        return d.c.a.c.o(context).k(context);
    }

    public static d.c.a.i E(View view) {
        return d.c.a.c.o(view.getContext()).l(view);
    }

    public static d.c.a.i F(androidx.fragment.app.Fragment fragment) {
        return d.c.a.c.o(fragment.getContext()).m(fragment);
    }

    public static d.c.a.i G(FragmentActivity fragmentActivity) {
        return d.c.a.c.o((Context)fragmentActivity).n(fragmentActivity);
    }

    private static void a(Context object, GeneratedAppGlideModule generatedAppGlideModule) {
        boolean bl2 = p;
        if (!bl2) {
            p = true;
            d.c.a.c.r(object, generatedAppGlideModule);
            p = false;
            return;
        }
        object = new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c d(Context context) {
        Object object = o;
        if (object != null) return o;
        object = d.c.a.c.e(context.getApplicationContext());
        Class<c> clazz = c.class;
        synchronized (clazz) {
            c c10 = o;
            if (c10 != null) return o;
            d.c.a.c.a(context, (GeneratedAppGlideModule)object);
            return o;
        }
    }

    private static GeneratedAppGlideModule e(Context object) {
        block14: {
            boolean bl2;
            block15: {
                Constructor constructor = "com.bumptech.glide.GeneratedAppGlideModuleImpl";
                constructor = Class.forName((String)((Object)constructor));
                int n10 = 1;
                Class[] classArray = new Class[n10];
                Class<Context> clazz = Context.class;
                classArray[0] = clazz;
                constructor = ((Class)((Object)constructor)).getDeclaredConstructor(classArray);
                Object[] objectArray = new Object[n10];
                object = object.getApplicationContext();
                objectArray[0] = object;
                object = constructor.newInstance(objectArray);
                try {
                    object = (GeneratedAppGlideModule)object;
                    break block14;
                }
                catch (InvocationTargetException invocationTargetException) {
                    d.c.a.c.y(invocationTargetException);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    d.c.a.c.y(noSuchMethodException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    d.c.a.c.y(illegalAccessException);
                }
                catch (InstantiationException instantiationException) {
                    d.c.a.c.y(instantiationException);
                }
                catch (ClassNotFoundException classNotFoundException) {
                    constructor = n;
                    bl2 = Log.isLoggable((String)((Object)constructor), (int)5);
                    if (!bl2) break block15;
                    object = "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored";
                    Log.w((String)((Object)constructor), (String)object);
                }
            }
            bl2 = false;
            object = null;
        }
        return object;
    }

    public static File k(Context context) {
        return d.c.a.c.l(context, m);
    }

    public static File l(Context object, String string2) {
        if ((object = object.getCacheDir()) != null) {
            File file = new File((File)object, string2);
            boolean bl2 = file.mkdirs();
            if (!(bl2 || (bl2 = file.exists()) && (bl2 = file.isDirectory()))) {
                return null;
            }
            return file;
        }
        string2 = n;
        boolean bl3 = Log.isLoggable((String)string2, (int)6);
        if (bl3) {
            object = "default disk cache dir is null";
            Log.e((String)string2, (String)object);
        }
        return null;
    }

    private static d.c.a.p.k o(Context context) {
        d.c.a.u.k.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return d.c.a.c.d(context).n();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void p(Context context, d.c.a.d d10) {
        GeneratedAppGlideModule generatedAppGlideModule = d.c.a.c.e(context);
        Class<c> clazz = c.class;
        synchronized (clazz) {
            c c10 = o;
            if (c10 != null) {
                d.c.a.c.x();
            }
            d.c.a.c.s(context, d10, generatedAppGlideModule);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void q(c c10) {
        Class<c> clazz = c.class;
        synchronized (clazz) {
            c c11 = o;
            if (c11 != null) {
                d.c.a.c.x();
            }
            o = c10;
            return;
        }
    }

    private static void r(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        d.c.a.d d10 = new d.c.a.d();
        d.c.a.c.s(context, d10, generatedAppGlideModule);
    }

    private static void s(Context context, d.c.a.d object, GeneratedAppGlideModule object2) {
        boolean bl2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        boolean bl3;
        int n10;
        context = context.getApplicationContext();
        Object object7 = Collections.emptyList();
        if (object2 == null || (n10 = ((d.c.a.q.a)object2).c()) != 0) {
            object7 = new d.c.a.q.e(context);
            object7 = ((d.c.a.q.e)object7).a();
        }
        n10 = 3;
        Object object8 = n;
        if (object2 != null && !(bl3 = (object6 = ((GeneratedAppGlideModule)object2).d()).isEmpty())) {
            boolean bl4;
            object6 = ((GeneratedAppGlideModule)object2).d();
            object5 = object7.iterator();
            while (bl4 = object5.hasNext()) {
                object4 = (d.c.a.q.c)object5.next();
                Serializable serializable = object4.getClass();
                boolean bl5 = object6.contains(serializable);
                if (!bl5) continue;
                bl5 = Log.isLoggable((String)object8, (int)n10);
                if (bl5) {
                    serializable = new StringBuilder();
                    String string2 = "AppGlideModule excludes manifest GlideModule: ";
                    ((StringBuilder)serializable).append(string2);
                    ((StringBuilder)serializable).append(object4);
                    object4 = ((StringBuilder)serializable).toString();
                    Log.d((String)object8, (String)object4);
                }
                object5.remove();
            }
        }
        if ((n10 = (int)(Log.isLoggable((String)object8, (int)n10) ? 1 : 0)) != 0) {
            object3 = object7.iterator();
            while (bl3 = object3.hasNext()) {
                object6 = (d.c.a.q.c)object3.next();
                object5 = new StringBuilder();
                object4 = "Discovered GlideModule from manifest: ";
                ((StringBuilder)object5).append((String)object4);
                object6 = object6.getClass();
                ((StringBuilder)object5).append(object6);
                object6 = ((StringBuilder)object5).toString();
                Log.d((String)object8, (String)object6);
            }
        }
        if (object2 != null) {
            object3 = ((GeneratedAppGlideModule)object2).e();
        } else {
            n10 = 0;
            object3 = null;
        }
        ((d.c.a.d)object).t((k$b)object3);
        object3 = object7.iterator();
        while (bl2 = object3.hasNext()) {
            object8 = (d.c.a.q.c)object3.next();
            object8.a(context, (d.c.a.d)object);
        }
        if (object2 != null) {
            ((d.c.a.q.a)object2).a(context, (d.c.a.d)object);
        }
        object = ((d.c.a.d)object).b(context);
        object7 = object7.iterator();
        while ((n10 = (int)(object7.hasNext() ? 1 : 0)) != 0) {
            object3 = (d.c.a.q.c)object7.next();
            try {
                object8 = ((c)object).e;
            }
            catch (AbstractMethodError abstractMethodError) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                object7 = object3.getClass().getName();
                ((StringBuilder)object2).append((String)object7);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalStateException((String)object2, abstractMethodError);
                throw object;
            }
            object3.b(context, (c)object, (Registry)object8);
        }
        if (object2 != null) {
            object7 = ((c)object).e;
            ((d)object2).b(context, (c)object, (Registry)object7);
        }
        context.registerComponentCallbacks((ComponentCallbacks)object);
        o = object;
    }

    public static void x() {
        Class<c> clazz = c.class;
        synchronized (clazz) {
            Object object;
            block11: {
                object = o;
                if (object == null) break block11;
                object = o;
                object = ((c)object).i();
                object = object.getApplicationContext();
                c c10 = o;
                object.unregisterComponentCallbacks((ComponentCallbacks)c10);
                object = o;
                object = ((c)object).a;
                ((i)object).m();
            }
            object = null;
            o = null;
            return;
        }
    }

    private static void y(Exception exception) {
        IllegalStateException illegalStateException = new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exception);
        throw illegalStateException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(d.c.a.i object) {
        List list = this.i;
        synchronized (list) {
            Object object2 = this.i;
            boolean bl2 = object2.contains(object);
            if (bl2) {
                object2 = this.i;
                object2.remove(object);
                return;
            }
            object2 = "Cannot unregister not yet registered manager";
            object = new IllegalStateException((String)object2);
            throw object;
        }
    }

    public void b() {
        d.c.a.u.m.a();
        this.a.e();
    }

    public void c() {
        d.c.a.u.m.b();
        this.c.b();
        this.b.b();
        this.f.b();
    }

    public b f() {
        return this.f;
    }

    public e g() {
        return this.b;
    }

    public d.c.a.p.d h() {
        return this.h;
    }

    public Context i() {
        return this.d.getBaseContext();
    }

    public d.c.a.e j() {
        return this.d;
    }

    public Registry m() {
        return this.e;
    }

    public d.c.a.p.k n() {
        return this.g;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        this.c();
    }

    public void onTrimMemory(int n10) {
        this.z(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void t(d$a ... d$aArray) {
        synchronized (this) {
            d.c.a.o.k.a0.b b10 = this.l;
            if (b10 == null) {
                d.c.a.c$a c$a = this.j;
                d.c.a.s.g g10 = c$a.build();
                f f10 = g10.N();
                Object object = d.c.a.o.m.d.o.g;
                Object object2 = f10.c((d.c.a.o.e)object);
                DecodeFormat decodeFormat = (DecodeFormat)((Object)object2);
                j j10 = this.c;
                e e10 = this.b;
                this.l = object = new d.c.a.o.k.a0.b(j10, e10, decodeFormat);
            }
            d.c.a.o.k.a0.b b11 = this.l;
            b11.c(d$aArray);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void u(d.c.a.i object) {
        List list = this.i;
        synchronized (list) {
            Object object2 = this.i;
            boolean bl2 = object2.contains(object);
            if (!bl2) {
                object2 = this.i;
                object2.add(object);
                return;
            }
            object2 = "Cannot register already registered manager";
            object = new IllegalStateException((String)object2);
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean v(p p10) {
        List list = this.i;
        synchronized (list) {
            Object object;
            boolean bl2;
            Object object2 = this.i;
            object2 = object2.iterator();
            do {
                if (!(bl2 = object2.hasNext())) {
                    return false;
                }
                object = object2.next();
            } while (!(bl2 = ((d.c.a.i)(object = (d.c.a.i)object)).Z(p10)));
            return true;
        }
    }

    public MemoryCategory w(MemoryCategory memoryCategory) {
        d.c.a.u.m.b();
        Object object = this.c;
        float f10 = memoryCategory.getMultiplier();
        object.c(f10);
        object = this.b;
        f10 = memoryCategory.getMultiplier();
        object.c(f10);
        object = this.k;
        this.k = memoryCategory;
        return object;
    }

    public void z(int n10) {
        boolean bl2;
        d.c.a.u.m.b();
        Iterator iterator2 = this.i.iterator();
        while (bl2 = iterator2.hasNext()) {
            d.c.a.i i10 = (d.c.a.i)iterator2.next();
            i10.onTrimMemory(n10);
        }
        this.c.a(n10);
        this.b.a(n10);
        this.f.a(n10);
    }
}

