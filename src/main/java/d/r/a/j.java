/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.text.TextUtils
 */
package d.r.a;

import android.content.Intent;
import android.text.TextUtils;
import d.r.a.b;
import d.r.a.h$j;
import d.r.a.h$k;
import d.r.a.h$l;
import d.r.a.h$m;
import d.r.a.h$n;
import d.r.a.h$o;
import d.r.a.h$p;
import d.r.a.h$q;
import d.r.a.h$r;
import d.r.a.h$s;
import d.r.a.h$u;
import d.r.a.h$v;
import d.r.a.i.d;
import d.r.a.i.f;
import d.r.a.i.g;
import d.r.a.i.h;
import d.r.a.i.i;
import d.r.a.i.k;
import d.r.a.i.l;
import d.r.a.i.m;
import d.r.a.i.n;
import d.r.a.i.o;
import d.r.a.i.p;
import d.r.a.i.q;
import d.r.a.i.r;
import d.r.a.i.s;

public final class j
implements b {
    private s a;

    public j() {
        s s10;
        this.a = s10 = new s();
    }

    public final d.r.a.o a(Intent object) {
        Object object2;
        Object object3;
        block18: {
            block16: {
                block17: {
                    object3 = "command";
                    int n10 = -1;
                    int n11 = object.getIntExtra((String)object3, n10);
                    if (n11 < 0) {
                        object3 = "method";
                        n11 = object.getIntExtra((String)object3, n10);
                    }
                    if (n11 == (n10 = 20)) break block16;
                    n10 = 2016;
                    if (n11 == n10) break block17;
                    switch (n11) {
                        default: {
                            n11 = 0;
                            object3 = null;
                            break block18;
                        }
                        case 12: {
                            object3 = new h$k();
                            break block18;
                        }
                        case 10: 
                        case 11: {
                            object2 = new h$j(n11);
                            break;
                        }
                        case 9: {
                            object3 = new h$l();
                            break block18;
                        }
                        case 8: {
                            object3 = new h$n();
                            break block18;
                        }
                        case 7: {
                            object3 = new h$o();
                            break block18;
                        }
                        case 6: {
                            object3 = new h$s();
                            break block18;
                        }
                        case 5: {
                            object3 = new h$q();
                            break block18;
                        }
                        case 4: {
                            object3 = new h$r();
                            break block18;
                        }
                        case 3: {
                            object3 = new h$p();
                            break block18;
                        }
                        case 1: 
                        case 2: {
                            object2 = new h$u(n11);
                        }
                    }
                    object3 = object2;
                    break block18;
                }
                object3 = new h$m();
                break block18;
            }
            object3 = new h$v();
        }
        if (object3 != null) {
            if ((object = d.r.a.g.a((Intent)object)) == null) {
                object = "PushCommand";
                object2 = "bundleWapper is null";
                d.r.a.u.s.h((String)object, (String)object2);
            } else {
                object2 = ((d.r.a.g)object).b;
                boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                ((d.r.a.o)object3).b = !bl2 ? object2 : (object2 = ((d.r.a.g)object).b("client_pkgname"));
                ((d.r.a.o)object3).e((d.r.a.g)object);
            }
        }
        return object3;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final o b(d.r.a.o object) {
        void var4_15;
        int n10 = ((d.r.a.o)object).a;
        int n11 = 20;
        if (n10 != n11) {
            n11 = 2016;
            if (n10 != n11) {
                switch (n10) {
                    default: {
                        return null;
                    }
                    case 11: {
                        q q10 = new q((d.r.a.o)object);
                        return var4_15;
                    }
                    case 10: {
                        d d10 = new d((d.r.a.o)object);
                        return var4_15;
                    }
                    case 9: {
                        f f10 = new f((d.r.a.o)object);
                        return var4_15;
                    }
                    case 8: {
                        i i10 = new i((d.r.a.o)object);
                        return var4_15;
                    }
                    case 7: {
                        d.r.a.i.j j10 = new d.r.a.i.j((d.r.a.o)object);
                        return var4_15;
                    }
                    case 6: {
                        n n12 = new n((d.r.a.o)object);
                        return var4_15;
                    }
                    case 5: {
                        m m10 = new m((d.r.a.o)object);
                        return var4_15;
                    }
                    case 4: {
                        l l10 = new l((d.r.a.o)object);
                        return var4_15;
                    }
                    case 3: {
                        k k10 = new k((d.r.a.o)object);
                        return var4_15;
                    }
                    case 2: {
                        g g10 = new g((d.r.a.o)object);
                        return var4_15;
                    }
                    case 1: {
                        p p10 = new p((d.r.a.o)object);
                    }
                }
                return var4_15;
            }
            h h10 = new h((d.r.a.o)object);
            return var4_15;
        }
        r r10 = new r((d.r.a.o)object);
        return var4_15;
    }

    /*
     * Exception decompiling
     */
    public final d.r.a.m c(d.r.a.o var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 15[SWITCH]
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
}

