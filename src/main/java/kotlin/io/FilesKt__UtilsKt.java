/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import f.e2.a;
import f.e2.b;
import f.e2.g;
import f.e2.h;
import f.e2.k;
import f.e2.l;
import f.h2.s.p;
import f.h2.t.f0;
import f.q2.u;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.FileAlreadyExistsException;
import kotlin.io.FileSystemException;
import kotlin.io.FilesKt__UtilsKt$copyRecursively$1;
import kotlin.io.FilesKt__UtilsKt$copyRecursively$2;
import kotlin.io.NoSuchFileException;
import kotlin.io.OnErrorAction;
import kotlin.io.TerminateException;
import kotlin.text.StringsKt__StringsKt;

public class FilesKt__UtilsKt
extends l {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final boolean N(File object, File object2, boolean bl2, p p10) {
        f0.p(object, "$this$copyRecursively");
        f0.p(object2, "target");
        Object object3 = "onError";
        f0.p(p10, (String)object3);
        boolean bl3 = object.exists();
        boolean bl4 = true;
        if (!bl3) {
            Object var7_7 = null;
            int n10 = 2;
            boolean bl5 = false;
            String string2 = "The source file doesn't exist.";
            Object object4 = object2;
            File file = object;
            object2 = new NoSuchFileException((File)object, null, string2, n10, null);
            if ((object = (OnErrorAction)((Object)p10.invoke(object, object2))) == (object2 = OnErrorAction.TERMINATE)) return false;
            return bl4;
        }
        try {
            boolean bl6;
            object3 = l.M(object);
            Object object5 = new FilesKt__UtilsKt$copyRecursively$2(p10);
            object3 = ((h)object3).k((p)object5);
            object3 = ((h)object3).iterator();
            while (bl6 = object3.hasNext()) {
                long l10;
                Object object6;
                Object object7;
                int n11;
                String string3;
                String string4;
                object5 = object3.next();
                Object object8 = ((File)(object5 = (File)object5)).exists();
                if (!object8) {
                    NoSuchFileException noSuchFileException;
                    string4 = null;
                    string3 = "The source file doesn't exist.";
                    n11 = 2;
                    object7 = noSuchFileException;
                    object6 = object5;
                    noSuchFileException = new NoSuchFileException((File)object5, null, string3, n11, null);
                    object5 = p10.invoke(object5, noSuchFileException);
                    object7 = OnErrorAction.TERMINATE;
                    if ((object5 = (OnErrorAction)((Object)object5)) != object7) continue;
                    return false;
                }
                object7 = FilesKt__UtilsKt.n0((File)object5, object);
                object6 = new File((File)object2, (String)object7);
                object8 = ((File)object6).exists();
                if (!(!object8 || (object8 = ((File)object5).isDirectory()) && (object8 = ((File)object6).isDirectory()))) {
                    if (!bl2 || ((object8 = ((File)object6).isDirectory()) ? !(object8 = FilesKt__UtilsKt.V((File)object6)) : !(object8 = ((File)object6).delete()))) {
                        object8 = bl4;
                    } else {
                        object8 = false;
                        object7 = null;
                    }
                    if (object8) {
                        string4 = "The destination file already exists.";
                        object7 = new FileAlreadyExistsException((File)object5, (File)object6, string4);
                        object5 = p10.invoke(object6, object7);
                        object7 = OnErrorAction.TERMINATE;
                        if ((object5 = (OnErrorAction)((Object)object5)) != object7) continue;
                        return false;
                    }
                }
                object8 = ((File)object5).isDirectory();
                if (object8) {
                    ((File)object6).mkdirs();
                    continue;
                }
                boolean bl7 = false;
                string3 = null;
                n11 = 4;
                object7 = object5;
                object7 = FilesKt__UtilsKt.Q((File)object5, (File)object6, bl2, 0, n11, null);
                long l11 = ((File)object7).length();
                long l12 = l11 - (l10 = ((File)object5).length());
                object8 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (!object8) continue;
                object6 = "Source file wasn't copied completely, length of destination file differs.";
                object7 = new IOException((String)object6);
                object5 = p10.invoke(object5, object7);
                object7 = OnErrorAction.TERMINATE;
                if ((object5 = (OnErrorAction)((Object)object5)) == object7) return false;
            }
            return bl4;
        }
        catch (TerminateException terminateException) {
            return false;
        }
    }

    public static /* synthetic */ boolean O(File file, File file2, boolean bl2, p p10, int n10, Object object) {
        int n11 = n10 & 2;
        if (n11 != 0) {
            bl2 = false;
        }
        if ((n10 &= 4) != 0) {
            p10 = FilesKt__UtilsKt$copyRecursively$1.INSTANCE;
        }
        return FilesKt__UtilsKt.N(file, file2, bl2, p10);
    }

    /*
     * Loose catch block
     */
    public static final File P(File object, File serializable, boolean bl2, int n10) {
        f0.p(object, "$this$copyTo");
        Object object2 = "target";
        f0.p(serializable, (String)object2);
        boolean bl3 = ((File)object).exists();
        if (bl3) {
            Object object3;
            bl3 = ((File)serializable).exists();
            if (bl3) {
                if (bl2) {
                    bl2 = ((File)serializable).delete();
                    if (!bl2) {
                        FileAlreadyExistsException fileAlreadyExistsException = new FileAlreadyExistsException((File)object, (File)serializable, "Tried to overwrite the destination, but failed to delete it.");
                        throw fileAlreadyExistsException;
                    }
                } else {
                    FileAlreadyExistsException fileAlreadyExistsException = new FileAlreadyExistsException((File)object, (File)serializable, "The destination file already exists.");
                    throw fileAlreadyExistsException;
                }
            }
            if (bl2 = ((File)object).isDirectory()) {
                bl2 = ((File)serializable).mkdirs();
                if (!bl2) {
                    FileSystemException fileSystemException = new FileSystemException((File)object, (File)serializable, "Failed to create target directory.");
                    throw fileSystemException;
                }
            } else {
                object3 = ((File)serializable).getParentFile();
                if (object3 != null) {
                    ((File)object3).mkdirs();
                }
                object3 = new FileInputStream((File)object);
                object = new FileOutputStream((File)serializable);
                a.k((InputStream)object3, (OutputStream)object, n10);
                n10 = 0;
                Object var7_13 = null;
                b.a((Closeable)object, null);
                b.a((Closeable)object3, null);
            }
            return serializable;
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    try {
                        b.a((Closeable)object, throwable);
                        throw throwable2;
                    }
                    catch (Throwable throwable3) {
                        try {
                            throw throwable3;
                        }
                        catch (Throwable throwable4) {
                            b.a((Closeable)object3, throwable3);
                            throw throwable4;
                        }
                    }
                }
            }
        }
        object2 = serializable;
        serializable = new NoSuchFileException((File)object, null, "The source file doesn't exist.", 2, null);
        throw serializable;
    }

    public static /* synthetic */ File Q(File file, File file2, boolean bl2, int n10, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            bl2 = false;
        }
        if ((n11 &= 4) != 0) {
            n10 = 8192;
        }
        return FilesKt__UtilsKt.P(file, file2, bl2, n10);
    }

    public static final File R(String object, String object2, File comparable) {
        String string2 = "prefix";
        f0.p(object, string2);
        object = File.createTempFile((String)object, (String)object2, (File)comparable);
        ((File)object).delete();
        boolean bl2 = ((File)object).mkdir();
        if (bl2) {
            f0.o(object, "dir");
            return object;
        }
        comparable = new Comparable<File>();
        ((StringBuilder)comparable).append("Unable to create temporary directory ");
        ((StringBuilder)comparable).append(object);
        ((StringBuilder)comparable).append('.');
        object = ((StringBuilder)comparable).toString();
        object2 = new IOException((String)object);
        throw object2;
    }

    public static /* synthetic */ File S(String string2, String string3, File file, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            string2 = "tmp";
        }
        if ((n11 = n10 & 2) != 0) {
            string3 = null;
        }
        if ((n10 &= 4) != 0) {
            file = null;
        }
        return FilesKt__UtilsKt.R(string2, string3, file);
    }

    public static final File T(String object, String string2, File file) {
        f0.p(object, "prefix");
        object = File.createTempFile((String)object, string2, file);
        f0.o(object, "File.createTempFile(prefix, suffix, directory)");
        return object;
    }

    public static /* synthetic */ File U(String string2, String string3, File file, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            string2 = "tmp";
        }
        if ((n11 = n10 & 2) != 0) {
            string3 = null;
        }
        if ((n10 &= 4) != 0) {
            file = null;
        }
        return FilesKt__UtilsKt.T(string2, string3, file);
    }

    public static final boolean V(File object) {
        boolean bl2;
        String string2 = "$this$deleteRecursively";
        f0.p(object, string2);
        object = l.L((File)object).iterator();
        boolean bl3 = true;
        block0: while (true) {
            boolean bl4;
            bl2 = bl3;
            while (bl4 = object.hasNext()) {
                File file = (File)object.next();
                boolean bl5 = file.delete();
                if ((bl5 || !(bl4 = file.exists())) && bl2) continue block0;
                bl2 = false;
            }
            break;
        }
        return bl2;
    }

    public static final boolean W(File object, File object2) {
        f0.p(object, "$this$endsWith");
        f0.p(object2, "other");
        g g10 = k.f((File)object);
        g g11 = k.f((File)object2);
        boolean bl2 = g11.i();
        if (bl2) {
            return f0.g(object, object2);
        }
        int n10 = g10.h();
        int n11 = g11.h();
        if ((n10 -= n11) < 0) {
            n10 = 0;
            object = null;
        } else {
            object2 = g10.g();
            int n12 = g10.h();
            object = object2.subList(n10, n12);
            object2 = g11.g();
            n10 = (int)(object.equals(object2) ? 1 : 0);
        }
        return n10 != 0;
    }

    public static final boolean X(File file, String string2) {
        f0.p(file, "$this$endsWith");
        f0.p(string2, "other");
        File file2 = new File(string2);
        return FilesKt__UtilsKt.W(file, file2);
    }

    public static final String Y(File object) {
        f0.p(object, "$this$extension");
        object = ((File)object).getName();
        f0.o(object, "name");
        return StringsKt__StringsKt.d5((String)object, '.', "");
    }

    public static final String Z(File object) {
        String string2 = "$this$invariantSeparatorsPath";
        f0.p(object, string2);
        char c10 = File.separatorChar;
        String string3 = "path";
        char c11 = '/';
        if (c10 != c11) {
            String string4 = ((File)object).getPath();
            f0.o(string4, string3);
            char c12 = File.separatorChar;
            char c13 = '/';
            int n10 = 4;
            object = u.f2(string4, c12, c13, false, n10, null);
        } else {
            object = ((File)object).getPath();
            f0.o(object, string3);
        }
        return object;
    }

    public static final String a0(File object) {
        f0.p(object, "$this$nameWithoutExtension");
        object = ((File)object).getName();
        f0.o(object, "name");
        return StringsKt__StringsKt.o5((String)object, ".", null, 2, null);
    }

    public static final File b0(File object) {
        f0.p(object, "$this$normalize");
        object = k.f((File)object);
        File file = ((g)object).e();
        List list = FilesKt__UtilsKt.c0(((g)object).g());
        String string2 = File.separator;
        f0.o(string2, "File.separator");
        object = CollectionsKt___CollectionsKt.X2(list, string2, null, null, 0, null, null, 62, null);
        return FilesKt__UtilsKt.i0(file, (String)object);
    }

    private static final List c0(List object) {
        int n10 = object.size();
        ArrayList<File> arrayList = new ArrayList<File>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            File file = (File)object.next();
            String string2 = file.getName();
            if (string2 != null) {
                String string3;
                boolean bl2;
                int n11;
                int n12 = string2.hashCode();
                if (n12 != (n11 = 46)) {
                    n11 = 1472;
                    if (n12 == n11 && (bl2 = string2.equals(string3 = ".."))) {
                        bl2 = arrayList.isEmpty();
                        if (!bl2 && (bl2 = f0.g(string2 = ((File)CollectionsKt___CollectionsKt.a3(arrayList)).getName(), string3) ^ true)) {
                            n10 = arrayList.size() + -1;
                            arrayList.remove(n10);
                            continue;
                        }
                        arrayList.add(file);
                        continue;
                    }
                } else {
                    string3 = ".";
                    bl2 = string2.equals(string3);
                    if (bl2) continue;
                }
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    private static final g d0(g object) {
        File file = ((g)object).e();
        object = FilesKt__UtilsKt.c0(((g)object).g());
        g g10 = new g(file, (List)object);
        return g10;
    }

    public static final File e0(File object, File file) {
        f0.p(object, "$this$relativeTo");
        f0.p(file, "base");
        object = FilesKt__UtilsKt.n0((File)object, file);
        File file2 = new File((String)object);
        return file2;
    }

    public static final File f0(File object, File file) {
        f0.p(object, "$this$relativeToOrNull");
        String string2 = "base";
        f0.p(file, string2);
        object = FilesKt__UtilsKt.o0((File)object, file);
        file = object != null ? new File((String)object) : null;
        return file;
    }

    public static final File g0(File file, File object) {
        f0.p(file, "$this$relativeToOrSelf");
        String string2 = "base";
        f0.p(object, string2);
        object = FilesKt__UtilsKt.o0(file, (File)object);
        if (object != null) {
            file = new File((String)object);
        }
        return file;
    }

    /*
     * WARNING - void declaration
     */
    public static final File h0(File object, File file) {
        int n10;
        char c10;
        boolean bl2;
        void var3_7;
        f0.p(object, "$this$resolve");
        Object object2 = "relative";
        f0.p(file, (String)object2);
        boolean bl3 = k.d(file);
        if (bl3) {
            return file;
        }
        object = ((File)object).toString();
        object2 = "this.toString()";
        f0.o(object, (String)object2);
        int n11 = object.length();
        StringBuilder stringBuilder = null;
        if (n11 == 0) {
            boolean bl4 = true;
        } else {
            boolean bl5 = false;
            object2 = null;
        }
        if (var3_7 == false && !(bl2 = StringsKt__StringsKt.S2((CharSequence)object, c10 = File.separatorChar, false, n10 = 2, null))) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            char c11 = File.separatorChar;
            stringBuilder.append(c11);
            stringBuilder.append(file);
            object = stringBuilder.toString();
            object2 = new File((String)object);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(file);
            object = stringBuilder.toString();
            object2 = new File((String)object);
        }
        return object2;
    }

    public static final File i0(File file, String string2) {
        f0.p(file, "$this$resolve");
        f0.p(string2, "relative");
        File file2 = new File(string2);
        return FilesKt__UtilsKt.h0(file, file2);
    }

    public static final File j0(File object, File file) {
        f0.p(object, "$this$resolveSibling");
        Object object2 = "relative";
        f0.p(file, (String)object2);
        object = k.f((File)object);
        int n10 = ((g)object).h();
        if (n10 == 0) {
            String string2 = "..";
            object2 = new File(string2);
        } else {
            n10 = 0;
            int n11 = ((g)object).h() + -1;
            object2 = ((g)object).j(0, n11);
        }
        return FilesKt__UtilsKt.h0(FilesKt__UtilsKt.h0(((g)object).e(), (File)object2), file);
    }

    public static final File k0(File file, String string2) {
        f0.p(file, "$this$resolveSibling");
        f0.p(string2, "relative");
        File file2 = new File(string2);
        return FilesKt__UtilsKt.j0(file, file2);
    }

    public static final boolean l0(File list, File object) {
        int n10;
        f0.p(list, "$this$startsWith");
        f0.p(object, "other");
        list = k.f((File)((Object)list));
        object = k.f((File)object);
        File file = ((g)((Object)list)).e();
        File file2 = ((g)object).e();
        int n11 = f0.g(file, file2) ^ 1;
        boolean bl2 = false;
        file2 = null;
        if (n11 != 0) {
            return false;
        }
        n11 = ((g)((Object)list)).h();
        if (n11 >= (n10 = ((g)object).h())) {
            list = ((g)((Object)list)).g();
            n11 = ((g)object).h();
            list = list.subList(0, n11);
            object = ((g)object).g();
            bl2 = ((Object)list).equals(object);
        }
        return bl2;
    }

    public static final boolean m0(File file, String string2) {
        f0.p(file, "$this$startsWith");
        f0.p(string2, "other");
        File file2 = new File(string2);
        return FilesKt__UtilsKt.l0(file, file2);
    }

    public static final String n0(File object, File file) {
        f0.p(object, "$this$toRelativeString");
        f0.p(file, "base");
        Object object2 = FilesKt__UtilsKt.o0((File)object, file);
        if (object2 != null) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("this and base files have different roots: ");
        stringBuilder.append(object);
        stringBuilder.append(" and ");
        stringBuilder.append(file);
        stringBuilder.append('.');
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    private static final String o0(File file, File file2) {
        String string2;
        Object object;
        Object object2;
        int n10;
        int n11;
        Object object3 = FilesKt__UtilsKt.d0(k.f(file));
        g g10 = FilesKt__UtilsKt.d0(k.f(file2));
        File file3 = ((g)object3).e();
        File file4 = g10.e();
        int n12 = f0.g(file3, file4) ^ 1;
        file4 = null;
        if (n12 != 0) {
            return null;
        }
        n12 = g10.h();
        int n13 = ((g)object3).h();
        int n14 = Math.min(n13, n12);
        for (n11 = 0; n11 < n14 && (n10 = (int)(f0.g(object2 = (File)((g)object3).g().get(n11), object = (File)g10.g().get(n11)) ? 1 : 0)) != 0; ++n11) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        n10 = n12 + -1;
        if (n10 >= n11) {
            while (true) {
                char c10;
                if ((c10 = f0.g(object = ((File)g10.g().get(n10)).getName(), string2 = "..")) != '\u0000') {
                    return null;
                }
                stringBuilder.append(string2);
                if (n10 != n11) {
                    c10 = File.separatorChar;
                    stringBuilder.append(c10);
                }
                if (n10 == n11) break;
                n10 += -1;
            }
        }
        if (n11 < n13) {
            if (n11 < n12) {
                char c11 = File.separatorChar;
                stringBuilder.append(c11);
            }
            object2 = CollectionsKt___CollectionsKt.P1(((g)object3).g(), n11);
            string2 = File.separator;
            object3 = "File.separator";
            f0.o(string2, (String)object3);
            int n15 = 124;
            object = stringBuilder;
            CollectionsKt___CollectionsKt.V2((Iterable)object2, stringBuilder, string2, null, null, 0, null, null, n15, null);
        }
        return stringBuilder.toString();
    }
}

