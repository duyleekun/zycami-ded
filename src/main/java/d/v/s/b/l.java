/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.MediaStore$Images$Media
 *  android.text.TextUtils
 */
package d.v.s.b;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.zhiyun.mediaprovider.data.ImageBean;
import com.zhiyun.mediaprovider.data.MediaBean;
import com.zhiyun.mediaprovider.data.local.MediaDatabaseCommHelp;
import com.zhiyun.mediaprovider.data.local.dao.AlbumCustomizeDao;
import com.zhiyun.mediaprovider.data.local.model.AlbumCustomizeData;
import d.v.s.b.a;
import d.v.s.b.b;
import d.v.s.b.c;
import d.v.s.b.d;
import d.v.s.b.e;
import d.v.s.b.f;
import d.v.s.b.i;
import d.v.s.b.i$a;
import d.v.s.b.l$a;
import e.a.b0;
import e.a.g0;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class l
implements i {
    private static final int o = 255;
    private final e.a.s0.a a;
    private String[] b;
    private String c;
    private boolean d;
    private String e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private String[] j;
    private i$a k;
    private boolean l;
    private final WeakReference m;
    private final AlbumCustomizeDao n;

    private l(Context object) {
        int n10;
        Context context = new e.a.s0.a();
        this.a = context;
        this.b = null;
        this.c = "date_modified";
        this.d = false;
        this.e = "_display_name";
        this.f = false;
        this.g = 0;
        this.h = n10 = -1;
        this.i = n10;
        this.m = context = new WeakReference(object);
        object = MediaDatabaseCommHelp.getInstance();
        context = (Context)context.get();
        this.n = object = ((MediaDatabaseCommHelp)object).getDataBase(context).albumCustomizeDao();
    }

    public static /* synthetic */ e.a.s0.a B(l l10) {
        return l10.a;
    }

    public static /* synthetic */ i$a C(l l10) {
        return l10.k;
    }

    public static /* synthetic */ void D(l l10) {
        l10.d0();
    }

    private String E(String[] stringArray) {
        int n10;
        String string2 = null;
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string3 : stringArray) {
                if (string3 == null) continue;
                int n11 = stringBuilder.length();
                if (n11 != 0) {
                    String string4 = " and ";
                    stringBuilder.append(string4);
                }
                stringBuilder.append(string3);
            }
            int n12 = stringBuilder.length();
            if (n12 != 0) {
                string2 = stringBuilder.toString();
            }
        }
        return string2;
    }

    private String F(int n10) {
        Uri uri = Uri.parse((String)"content://media/external/audio/albumart");
        long l10 = n10;
        return ContentUris.withAppendedId((Uri)uri, (long)l10).toString();
    }

    private z G() {
        f f10 = new f(this);
        return z.y1(f10);
    }

    private String H() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 0;
        String string2 = null;
        int n12 = 29;
        if (n10 < n12) {
            return null;
        }
        n10 = this.i;
        n12 = -1;
        if (n10 == n12 && (n10 = this.h) == n12) {
            return null;
        }
        string2 = "(";
        StringBuilder stringBuilder = new StringBuilder(string2);
        n11 = this.i;
        String string3 = "duration";
        if (n11 != n12) {
            stringBuilder.append(string3);
            string2 = " > ";
            stringBuilder.append(string2);
            n11 = this.i;
            stringBuilder.append(n11);
        }
        if ((n11 = this.h) != n12) {
            n11 = stringBuilder.length();
            if (n11 != (n12 = 1)) {
                string2 = " and ";
                stringBuilder.append(string2);
            }
            stringBuilder.append(string3);
            string2 = " < ";
            stringBuilder.append(string2);
            n11 = this.h;
            stringBuilder.append(n11);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private z I() {
        a a10 = new a(this);
        return z.y1(a10);
    }

    public static l J(Context context) {
        l l10 = new l(context);
        return l10;
    }

    private String K() {
        int n10;
        Object object = this.j;
        if (object != null && (n10 = ((String[])object).length) != 0) {
            object = new StringBuilder();
            String[] stringArray = "(";
            ((StringBuilder)object).append((String)stringArray);
            ((StringBuilder)object).append("mime_type");
            String string2 = " in ";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append((String)stringArray);
            for (String string3 : this.j) {
                String string4;
                int n11;
                int n12 = ((StringBuilder)object).length() + -1;
                if ((n12 = (int)((StringBuilder)object).charAt(n12)) != (n11 = 40)) {
                    string4 = ", ";
                    ((StringBuilder)object).append(string4);
                }
                string4 = "'";
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(string4);
            }
            ((StringBuilder)object).append("))");
            return ((StringBuilder)object).toString();
        }
        return null;
    }

    private String L() {
        CharSequence charSequence;
        int n10 = this.g;
        if (n10 > 0) {
            charSequence = new StringBuilder();
            String string2 = " LIMIT ";
            ((StringBuilder)charSequence).append(string2);
            int n11 = this.g;
            ((StringBuilder)charSequence).append(n11);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        return charSequence;
    }

    private String M() {
        int n10;
        String[] stringArray = this.b;
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 29;
            int n12 = 0;
            int n13 = 1;
            if (n10 >= n11) {
                n10 = n13;
            } else {
                n10 = 0;
                stringArray = null;
            }
            String string2 = n10 != 0 ? "relative_path" : "_data";
            StringBuilder stringBuilder = new StringBuilder("(");
            String[] stringArray2 = this.b;
            int n14 = stringArray2.length;
            while (n12 < n14) {
                CharSequence charSequence;
                String string3 = stringArray2[n12];
                int n15 = stringBuilder.length();
                if (n15 != n13) {
                    charSequence = " or ";
                    stringBuilder.append((String)charSequence);
                }
                if (n10 == 0) {
                    charSequence = new StringBuilder();
                    Object object = Environment.getExternalStorageDirectory();
                    ((StringBuilder)charSequence).append(object);
                    object = File.separator;
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(string3);
                    string3 = ((StringBuilder)charSequence).toString();
                }
                stringBuilder.append(string2);
                stringBuilder.append(" like ");
                charSequence = "'";
                stringBuilder.append((String)charSequence);
                stringBuilder.append(string3);
                string3 = "%";
                stringBuilder.append(string3);
                stringBuilder.append((String)charSequence);
                ++n12;
            }
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
        return null;
    }

    private String N() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.c;
        stringBuilder.append(string2);
        boolean bl2 = this.d;
        String string3 = " ASC";
        String string4 = " DESC";
        string2 = bl2 ? string3 : string4;
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        string2 = this.e;
        stringBuilder.append(string2);
        bl2 = this.f;
        if (!bl2) {
            string3 = string4;
        }
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    private z O() {
        b b10 = new b(this);
        return z.y1(b10);
    }

    private String P() {
        return "(media_type in (3, 1))";
    }

    private z Q() {
        d d10 = new d(this);
        return z.y1(d10);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void R(b0 var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 46[TRYBLOCK] [96 : 986->993)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1037)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void T(b0 b02) {
        boolean bl2;
        Throwable throwable2222222;
        Cursor cursor;
        block12: {
            block11: {
                block13: {
                    int n10;
                    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    Object object = new ArrayList();
                    object.add("_id");
                    String string2 = "_size";
                    object.add(string2);
                    object.add("_display_name");
                    object.add("date_added");
                    object.add("date_modified");
                    Object object2 = "mime_type";
                    object.add(object2);
                    String string3 = "width";
                    object.add(string3);
                    String string4 = "height";
                    object.add(string4);
                    int n11 = d.v.s.c.a.a();
                    if (n11 == 0) {
                        object2 = "_data";
                        object.add(object2);
                    }
                    n11 = 2;
                    object2 = new String[n11];
                    String[] stringArray = this.M();
                    Object object3 = null;
                    object2[0] = stringArray;
                    int n12 = 1;
                    String[] stringArray2 = this.K();
                    object2[n12] = stringArray2;
                    stringArray2 = this.E((String[])object2);
                    Object object4 = new String[]{};
                    object2 = this.N();
                    stringArray = this.L();
                    cursor = null;
                    WeakReference weakReference = this.m;
                    weakReference = weakReference.get();
                    weakReference = (Context)weakReference;
                    if (weakReference == null) {
                        object2 = "\u6ca1\u6709Context\u5b9e\u4f8b";
                        object = new RuntimeException((String)object2);
                        b02.onError((Throwable)object);
                        return;
                    }
                    weakReference = weakReference.getContentResolver();
                    object3 = new String[]{};
                    object = object.toArray((T[])object3);
                    object3 = object;
                    object3 = (String[])object;
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append((String)stringArray);
                    String string5 = ((StringBuilder)object).toString();
                    object = weakReference;
                    object2 = uri;
                    stringArray = object3;
                    object3 = stringArray2;
                    stringArray2 = object4;
                    object4 = string5;
                    cursor = weakReference.query(uri, stringArray, (String)object3, stringArray2, string5);
                    while (cursor != null && (n10 = cursor.moveToNext()) != 0 && (n10 = this.l) == 0) {
                        long l10;
                        long l11;
                        long l12;
                        n10 = cursor.getColumnIndex(string2);
                        if (n10 != (n11 = -1) && (n10 = (int)((l12 = (l11 = cursor.getLong(n10)) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) continue;
                        object = new ImageBean();
                        this.e0((MediaBean)object, cursor);
                        n11 = cursor.getColumnIndex(string3);
                        n11 = cursor.getInt(n11);
                        object2 = ((ImageBean)object).setWidth(n11);
                        n12 = cursor.getColumnIndex(string4);
                        n12 = cursor.getInt(n12);
                        object2 = ((ImageBean)object2).setHeight(n12);
                        n12 = 4;
                        object2 = ((MediaBean)object2).setType(n12);
                        n12 = ((MediaBean)object).getId();
                        l10 = n12;
                        stringArray = ContentUris.withAppendedId((Uri)uri, (long)l10);
                        ((MediaBean)object2).setUri((Uri)stringArray);
                        b02.onNext(object);
                    }
                    b02.onComplete();
                    if (cursor == null) break block11;
                    {
                        boolean bl3;
                        catch (Throwable throwable2222222) {
                            break block12;
                        }
                        catch (Exception exception) {}
                        {
                            b02.onError(exception);
                        }
                        if (cursor == null || (bl3 = cursor.isClosed())) break block11;
                        break block13;
                    }
                    boolean bl4 = cursor.isClosed();
                    if (bl4) break block11;
                }
                cursor.close();
            }
            return;
        }
        if (cursor != null && !(bl2 = cursor.isClosed())) {
            cursor.close();
        }
        throw throwable2222222;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void V(b0 var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 29[TRYBLOCK] [60, 61 : 728->735)] java.lang.Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1037)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void X(b0 var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 48[TRYBLOCK] [100 : 1057->1064)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1037)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private /* synthetic */ MediaBean Z(String object, MediaBean mediaBean) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            bl2 = d.v.s.c.a.a();
            if (bl2) {
                AlbumCustomizeDao albumCustomizeDao = this.n;
                int n10 = mediaBean.getId();
                object = albumCustomizeDao.queryAlbumCustomizeData((String)object, n10);
            } else {
                AlbumCustomizeDao albumCustomizeDao = this.n;
                int n11 = mediaBean.getId();
                String string2 = mediaBean.getPath();
                object = albumCustomizeDao.queryAlbumCustomizeData((String)object, n11, string2);
            }
            if (object != null) {
                object = ((AlbumCustomizeData)object).getAlbumTag();
                mediaBean.setTag((String)object);
            }
        } else {
            object = "";
            mediaBean.setTag((String)object);
        }
        return mediaBean;
    }

    public static /* synthetic */ void b0(b0 b02) {
        Exception exception = new Exception("\u5a92\u4f53\u7c7b\u578b\u9519\u8bef");
        b02.onError(exception);
    }

    private void c0(z z10, String object) {
        this.l = false;
        this.a.e();
        Object object2 = e.a.c1.b.d();
        z10 = z10.L5((h0)object2);
        object2 = e.a.c1.b.d();
        z10 = z10.i4((h0)object2);
        object2 = new e(this, (String)object);
        z10 = z10.H3((o)object2);
        object = new l$a(this);
        z10.subscribe((g0)object);
    }

    private void d0() {
        this.k = null;
    }

    private void e0(MediaBean mediaBean, Cursor object) {
        int n10 = object.getColumnIndex("_id");
        n10 = object.getInt(n10);
        Object object2 = mediaBean.setId(n10);
        int n11 = object.getColumnIndex("_size");
        long l10 = object.getLong(n11);
        object2 = ((MediaBean)object2).setSize(l10);
        n11 = object.getColumnIndex("_display_name");
        String string2 = object.getString(n11);
        object2 = ((MediaBean)object2).setDisplayName(string2);
        n11 = object.getColumnIndex("date_added");
        l10 = object.getLong(n11);
        long l11 = 1000L;
        object2 = ((MediaBean)object2).setDateAdded(l10 *= l11);
        n11 = object.getColumnIndex("date_modified");
        l10 = object.getLong(n11) * l11;
        object2 = ((MediaBean)object2).setDataModified(l10);
        n11 = object.getColumnIndex("mime_type");
        string2 = object.getString(n11);
        ((MediaBean)object2).setMime(string2);
        n10 = (int)(d.v.s.c.a.a() ? 1 : 0);
        if (n10 == 0) {
            object2 = "_data";
            n10 = object.getColumnIndex((String)object2);
            object = object.getString(n10);
            mediaBean.setPath((String)object);
        }
    }

    public void A(String string2, boolean bl2) {
        this.c = string2;
        this.d = bl2;
    }

    public /* synthetic */ void S(b0 b02) {
        this.R(b02);
    }

    public /* synthetic */ void U(b0 b02) {
        this.T(b02);
    }

    public /* synthetic */ void W(b0 b02) {
        this.V(b02);
    }

    public /* synthetic */ void Y(b0 b02) {
        this.X(b02);
    }

    public void a(int n10) {
        this.h = n10;
    }

    public /* synthetic */ MediaBean a0(String string2, MediaBean mediaBean) {
        this.Z(string2, mediaBean);
        return mediaBean;
    }

    public void c(int n10) {
        this.i = n10;
    }

    public void e(int n10) {
        this.g = n10;
    }

    public void f(String[] stringArray) {
        this.j = stringArray;
    }

    public void i(int n10, String string2) {
        int n11 = 1;
        z z10 = n10 != n11 ? (n10 != (n11 = 2) ? (n10 != (n11 = 4) ? (n10 != (n11 = 6) ? z.y1(d.v.s.b.c.a) : this.O()) : this.I()) : this.Q()) : this.G();
        this.c0(z10, string2);
    }

    public void j(boolean bl2) {
        this.c = "date_added";
        this.d = bl2;
    }

    public void o(String[] stringArray) {
        this.b = stringArray;
    }

    public void r(String string2, boolean bl2) {
        this.e = string2;
        this.f = bl2;
    }

    public void s() {
        this.l = true;
    }

    public void w(int n10) {
        this.i(n10, "");
    }

    public void x(i$a i$a) {
        this.k = i$a;
    }

    public void y(int n10, int n11) {
        this.i = n10;
        this.h = n11;
    }
}

