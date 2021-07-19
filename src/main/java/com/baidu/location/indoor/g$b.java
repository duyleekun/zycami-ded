/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.indoor.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class g$b {
    public String a = null;
    public int b = 0;
    public String c = null;
    public final /* synthetic */ g d;
    private ArrayList e = null;
    private ArrayList f = null;
    private Map g = null;
    private int h = 0;
    private Map i = null;

    public g$b(g cloneable) {
        this.d = cloneable;
        this.e = cloneable = new Cloneable();
        this.f = cloneable = new Cloneable();
        this.i = cloneable;
    }

    /*
     * Exception decompiling
     */
    private int a(BDLocation var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [97[UNCONDITIONALDOLOOP]], but top level block is 34[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static /* synthetic */ int a(g$b g$b, BDLocation bDLocation) {
        return g$b.a(bDLocation);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int a(String object) {
        Object object2;
        int n10;
        block5: {
            Map map = this.i;
            n10 = map.containsKey(object);
            if (n10 != 0) {
                map = this.i;
                object = (Integer)map.get(object);
                return (Integer)object;
            }
            n10 = 1000;
            object2 = "F";
            try {
                boolean bl2 = ((String)object).startsWith((String)object2);
                int n11 = 1;
                if (!bl2 && !(bl2 = ((String)object).startsWith((String)(object2 = "f")))) {
                    object2 = "B";
                    bl2 = ((String)object).startsWith((String)object2);
                    if (bl2 || (bl2 = ((String)object).startsWith((String)(object2 = "b")))) {
                        object2 = ((String)object).substring(n11);
                        n10 = -Integer.parseInt((String)object2);
                    }
                    break block5;
                }
                object2 = ((String)object).substring(n11);
                n10 = Integer.parseInt((String)object2) - n11;
            }
            catch (Exception exception) {}
        }
        object2 = this.i;
        Integer n12 = n10;
        object2.put(object, n12);
        return n10;
    }

    public static /* synthetic */ String a(g$b g$b) {
        return g$b.b();
    }

    private ArrayList a(ArrayList object) {
        boolean bl2;
        double d10;
        boolean bl3;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        double d11 = 0.0;
        Double d12 = d11;
        Object object2 = ((ArrayList)object).iterator();
        while (bl3 = object2.hasNext()) {
            Double d13 = (Double)object2.next();
            d10 = d12;
            double d14 = d13;
            d12 = d10 += d14;
        }
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            double d15 = (Double)object.next();
            d10 = d12;
            object2 = d15 /= d10;
            arrayList.add(object2);
        }
        return arrayList;
    }

    private ArrayList a(ArrayList object, String object2) {
        int n10;
        double[] dArray;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n11 = 3;
        double[] dArray2 = dArray = new double[n11];
        dArray[0] = 180.0;
        dArray2[1] = 10.0;
        dArray2[2] = 1.0;
        int n12 = this.a((String)object2);
        int n13 = 1000;
        int n14 = 2;
        object = ((ArrayList)object).iterator();
        if (n12 == n13) {
            while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                double d10;
                Object object3 = (String)object.next();
                n12 = (int)(((String)object3).equals(object2) ? 1 : 0);
                if (n12 != 0) {
                    n12 = 0;
                    object3 = null;
                    d10 = dArray[0];
                } else {
                    d10 = dArray[n14];
                }
                object3 = d10;
                arrayList.add(object3);
            }
            return arrayList;
        }
        while ((n10 = object.hasNext()) != 0) {
            object2 = (String)object.next();
            n10 = this.a((String)object2);
            n10 = n10 == n13 ? n14 : (n12 > n10 ? n12 - n10 : (n10 -= n12));
            if (n10 > n14) {
                n10 = n14;
            }
            double d11 = dArray[n10];
            object2 = d11;
            arrayList.add(object2);
        }
        return arrayList;
    }

    private void a() {
        this.e.clear();
        this.f.clear();
        this.i.clear();
    }

    private int b(String stringArray) {
        int n10 = 1;
        String string2 = ";";
        stringArray = stringArray.split(string2);
        int n11 = stringArray.length;
        if (n11 <= n10) {
            return n10;
        }
        n11 = 0;
        string2 = null;
        HashMap hashMap = stringArray[0];
        int n12 = Integer.parseInt((String)((Object)hashMap));
        this.h = n12;
        hashMap = new HashMap();
        try {
            this.g = hashMap;
            n12 = n10;
        }
        catch (Exception exception) {
            return n10;
        }
        while (true) {
            int n13 = stringArray.length;
            if (n12 >= n13) break;
            Object object = stringArray[n12];
            Object object2 = ":";
            object = object.split((String)object2);
            object2 = this.g;
            String string3 = object[0];
            object = object[n10];
            double d10 = Double.parseDouble((String)object);
            object = d10;
            object2.put(string3, object);
            ++n12;
            continue;
            break;
        }
        return 0;
    }

    private String b() {
        return this.a;
    }
}

