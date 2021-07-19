/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.le;

import com.zhiyun.stabilizer.net.entities.FileList$ExFile;
import d.v.e0.le.a;
import d.v.e0.le.b$a;
import d.v.e0.le.b$b;
import d.v.e0.le.b$c;
import d.v.e0.le.b$d;
import java.util.ArrayList;
import java.util.List;
import k.d;

public class b {
    public static final String a = "all";
    public static final String b = "photo";
    public static final String c = "video";
    public static final String d = "file";
    private static final String e = "cube";
    private static final String f = "3dl";
    private static final String g = "m3d";
    private static d h;

    public static /* synthetic */ d a(d d10) {
        h = d10;
        return d10;
    }

    public static /* synthetic */ List b(String string2, List list) {
        return d.v.e0.le.b.e(string2, list);
    }

    public static void c() {
        d d10 = h;
        if (d10 != null) {
            d10.cancel();
        }
    }

    public static void d(int n10, int n11, String string2, b$d b$d) {
        Object object = d;
        boolean bl2 = string2.equals(object);
        object = bl2 ? e : "";
        h = object = d.v.e0.le.a.a.d(n10, n11, string2, (String)object);
        b$b b$b = new b$b(b$d, n10, string2, n11);
        object.h(b$b);
    }

    private static List e(String string2, List list) {
        ArrayList arrayList = new ArrayList();
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 112202875: {
                String string3 = c;
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n11 = 3;
                break;
            }
            case 106642994: {
                String string4 = b;
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n11 = 2;
                break;
            }
            case 3143036: {
                String string5 = d;
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n11 = 1;
                break;
            }
            case 96673: {
                String string6 = a;
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                list = arrayList;
                break;
            }
            case 1: {
                list = d.v.e0.le.b.i(list);
                break;
            }
            case 0: {
                list = d.v.e0.le.b.j(list);
            }
            case 2: 
            case 3: 
        }
        return list;
    }

    public static void f(String object, b$c b$c) {
        object = d.v.e0.le.a.a.e((String)object);
        b$a b$a = new b$a(b$c);
        object.h(b$a);
    }

    private static String g(String string2) {
        String string3;
        int n10;
        string2 = string2 != null && (n10 = string2.lastIndexOf(string3 = ".")) > 0 ? string2.substring(++n10).toLowerCase() : null;
        return string2;
    }

    public static void h(int n10, int n11, b$d b$d) {
        d.v.e0.le.b.d(n10, n11, d, b$d);
    }

    private static List i(List object) {
        int n10;
        ArrayList<FileList$ExFile> arrayList = new ArrayList<FileList$ExFile>();
        if (object != null && (n10 = object.size()) != 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                boolean bl2;
                String string2;
                FileList$ExFile fileList$ExFile = (FileList$ExFile)object.next();
                String string3 = d.v.e0.le.b.g(fileList$ExFile.getName());
                boolean bl3 = string3.equals(string2 = e);
                if (!bl3 && !(bl3 = string3.equals(string2 = f)) && !(bl2 = string3.equals(string2 = g))) continue;
                arrayList.add(fileList$ExFile);
            }
        }
        return arrayList;
    }

    private static List j(List object) {
        int n10;
        ArrayList<FileList$ExFile> arrayList = new ArrayList<FileList$ExFile>();
        if (object != null && (n10 = object.size()) != 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                String string2;
                FileList$ExFile fileList$ExFile = (FileList$ExFile)object.next();
                String string3 = fileList$ExFile.getType();
                boolean bl2 = string3.equals(string2 = b);
                if (!bl2 && !(bl2 = (string3 = fileList$ExFile.getType()).equals(string2 = c))) continue;
                arrayList.add(fileList$ExFile);
            }
        }
        return arrayList;
    }
}

