/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.ArrayMap
 *  android.util.SparseArray
 *  android.webkit.URLUtil
 */
package d.v.g.g;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.webkit.URLUtil;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import d.v.e.l.k2;
import d.v.g.g.a;
import d.v.g.g.a1;
import d.v.g.g.b1;
import d.v.g.g.d1$a;
import d.v.g.g.d1$b;
import d.v.g.g.d1$c;
import d.v.g.g.l;
import d.v.g.g.m;
import d.v.g.g.n;
import d.v.g.g.o;
import d.v.g.g.p;
import d.v.g.g.q;
import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class d1 {
    private ArrayMap a;
    private String b;

    private d1() {
        Object object;
        this.a = object = new ArrayMap();
        object = k2.K().getAbsolutePath();
        this.b = object;
    }

    public /* synthetic */ d1(d1$a d1$a) {
        this();
    }

    private void c(String string2) {
        d1$b d1$b = (d1$b)this.a.get((Object)string2);
        if (d1$b != null) {
            d1$b.onComplete();
        }
        this.a.remove((Object)string2);
    }

    private void d(String string2, Exception exception) {
        d1$b d1$b = (d1$b)this.a.get((Object)string2);
        if (d1$b != null) {
            d1$b.a(exception);
        }
        this.a.remove((Object)string2);
    }

    private void e(String object, int n10) {
        ArrayMap arrayMap = this.a;
        if ((object = (d1$b)arrayMap.get(object)) != null) {
            object.onProgress(n10);
        }
    }

    private boolean g(FirmwareInfo firmwareInfo) {
        long l10;
        String string2 = URLUtil.guessFileName((String)firmwareInfo.getUrl(), null, null);
        String string3 = k2.K().getAbsolutePath();
        File file = new File(string3, string2);
        boolean bl2 = file.exists();
        boolean bl3 = true;
        if (!bl2) {
            return bl3;
        }
        long l11 = file.length();
        long l12 = l11 - (l10 = firmwareInfo.getFilesize());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            bl3 = false;
            string3 = null;
        }
        return bl3;
    }

    public static d1 i() {
        return d1$c.a();
    }

    public static /* synthetic */ boolean j(String string2) {
        return TextUtils.isEmpty((CharSequence)string2) ^ true;
    }

    private /* synthetic */ boolean k(String string2) {
        return this.a.containsKey((Object)string2) ^ true;
    }

    private /* synthetic */ void m(String object) {
        object = (d1$b)this.a.put(object, null);
    }

    public static /* synthetic */ void o(Map.Entry object) {
        object = object.setValue(null);
    }

    public static /* synthetic */ boolean p(d1 d12, FirmwareInfo firmwareInfo) {
        return d12.g(firmwareInfo);
    }

    public static /* synthetic */ void q(d1 d12, String string2) {
        d12.r(string2);
    }

    /*
     * Exception decompiling
     */
    private void r(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [29[UNCONDITIONALDOLOOP]], but top level block is 11[TRYBLOCK]
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

    public void a(SparseArray object) {
        int n10 = object.size();
        Object object2 = IntStream.range(0, n10);
        object.getClass();
        a a10 = new a((SparseArray)object);
        object = object2.mapToObj(a10);
        object2 = new o(this);
        object = object.filter(object2);
        object2 = a1.a;
        object = object.map(object2);
        object2 = m.a;
        object = object.filter(object2);
        object2 = new l(this);
        object = object.filter(object2);
        object2 = new n(this);
        object = object.peek(object2);
        object2 = new q(this);
        object.forEach(object2);
    }

    public void b(String string2, d1$b d1$b) {
        this.a.put((Object)string2, (Object)d1$b);
    }

    public void f() {
        Stream stream = this.a.entrySet().stream();
        Object object = b1.a;
        stream = stream.filter(object);
        object = p.a;
        stream.forEach(object);
    }

    public Set h() {
        return this.a.keySet();
    }

    public /* synthetic */ boolean l(String string2) {
        return this.k(string2);
    }

    public /* synthetic */ void n(String string2) {
        this.m(string2);
    }
}

