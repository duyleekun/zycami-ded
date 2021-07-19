/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.h$b;
import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.f0;
import f.h2.t.u;
import f.n2.m;
import java.io.File;
import java.util.Iterator;
import kotlin.io.FileWalkDirection;

public final class h
implements m {
    private final File a;
    private final FileWalkDirection b;
    private final l c;
    private final l d;
    private final p e;
    private final int f;

    public h(File file, FileWalkDirection fileWalkDirection) {
        f0.p(file, "start");
        f0.p((Object)fileWalkDirection, "direction");
        this(file, fileWalkDirection, null, null, null, 0, 32, null);
    }

    public /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, int n10, u u10) {
        if ((n10 &= 2) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        this(file, fileWalkDirection);
    }

    private h(File file, FileWalkDirection fileWalkDirection, l l10, l l11, p p10, int n10) {
        this.a = file;
        this.b = fileWalkDirection;
        this.c = l10;
        this.d = l11;
        this.e = p10;
        this.f = n10;
    }

    public /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, l l10, l l11, p p10, int n10, int n11, u u10) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        FileWalkDirection fileWalkDirection2 = fileWalkDirection;
        int n13 = n11 & 0x20;
        if (n13 != 0) {
            n10 = -1 >>> 1;
        }
        this(file, fileWalkDirection2, l10, l11, p10, n10);
    }

    public static final /* synthetic */ FileWalkDirection c(h h10) {
        return h10.b;
    }

    public static final /* synthetic */ int d(h h10) {
        return h10.f;
    }

    public static final /* synthetic */ l e(h h10) {
        return h10.c;
    }

    public static final /* synthetic */ p f(h h10) {
        return h10.e;
    }

    public static final /* synthetic */ l g(h h10) {
        return h10.d;
    }

    public static final /* synthetic */ File h(h h10) {
        return h10.a;
    }

    public final h i(int n10) {
        if (n10 > 0) {
            h h10;
            File file = this.a;
            FileWalkDirection fileWalkDirection = this.b;
            l l10 = this.c;
            l l11 = this.d;
            p p10 = this.e;
            h h11 = h10;
            h10 = new h(file, fileWalkDirection, l10, l11, p10, n10);
            return h10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("depth must be positive, but was ");
        stringBuilder.append(n10);
        stringBuilder.append('.');
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public Iterator iterator() {
        h$b h$b = new h$b(this);
        return h$b;
    }

    public final h j(l l10) {
        f0.p(l10, "function");
        File file = this.a;
        FileWalkDirection fileWalkDirection = this.b;
        l l11 = this.d;
        p p10 = this.e;
        int n10 = this.f;
        h h10 = new h(file, fileWalkDirection, l10, l11, p10, n10);
        return h10;
    }

    public final h k(p p10) {
        f0.p(p10, "function");
        File file = this.a;
        FileWalkDirection fileWalkDirection = this.b;
        l l10 = this.c;
        l l11 = this.d;
        int n10 = this.f;
        h h10 = new h(file, fileWalkDirection, l10, l11, p10, n10);
        return h10;
    }

    public final h l(l l10) {
        f0.p(l10, "function");
        File file = this.a;
        FileWalkDirection fileWalkDirection = this.b;
        l l11 = this.c;
        p p10 = this.e;
        int n10 = this.f;
        h h10 = new h(file, fileWalkDirection, l11, l10, p10, n10);
        return h10;
    }
}

