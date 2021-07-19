/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.h;
import f.e2.h$a;
import f.e2.h$b$a;
import f.e2.h$b$b;
import f.e2.h$b$c;
import f.e2.h$c;
import f.e2.i;
import f.h2.t.f0;
import f.x1.b;
import java.io.File;
import java.util.ArrayDeque;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.FileWalkDirection;

public final class h$b
extends b {
    private final ArrayDeque c;
    public final /* synthetic */ h d;

    public h$b(h object) {
        ArrayDeque<Object> arrayDeque;
        this.d = object;
        this.c = arrayDeque = new ArrayDeque<Object>();
        Object object2 = h.h((h)object);
        boolean bl2 = ((File)object2).isDirectory();
        if (bl2) {
            object = h.h((h)object);
            object = this.g((File)object);
            arrayDeque.push(object);
        } else {
            object2 = h.h((h)object);
            bl2 = ((File)object2).isFile();
            if (bl2) {
                object = h.h((h)object);
                object2 = new h$b$b(this, (File)object);
                arrayDeque.push(object2);
            } else {
                this.c();
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private final h$a g(File serializable) {
        void var2_6;
        FileWalkDirection fileWalkDirection = h.c(this.d);
        int[] nArray = i.a;
        int n10 = fileWalkDirection.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) == n11) {
            h$b$c h$b$c = new h$b$c(this, (File)serializable);
            return var2_6;
        }
        n11 = 2;
        if (n10 == n11) {
            h$b$a h$b$a = new h$b$a(this, (File)serializable);
            return var2_6;
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }

    private final File h() {
        Object object;
        while ((object = (h$c)this.c.peek()) != null) {
            h h10;
            int n10;
            Object object2 = ((h$c)object).b();
            if (object2 == null) {
                object = this.c;
                ((ArrayDeque)object).pop();
                continue;
            }
            int n11 = f0.g(object2, object = ((h$c)object).a());
            if (n11 == 0 && (n11 = ((File)object2).isDirectory()) != 0 && (n11 = ((ArrayDeque)(object = this.c)).size()) < (n10 = h.d(h10 = this.d))) {
                object = this.c;
                object2 = this.g((File)object2);
                ((ArrayDeque)object).push(object2);
                continue;
            }
            return object2;
        }
        return null;
    }

    public void b() {
        File file = this.h();
        if (file != null) {
            this.e(file);
        } else {
            this.c();
        }
    }
}

