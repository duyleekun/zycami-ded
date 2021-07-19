/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.fundation;

import com.zhiyun.editorsdk.fundation.EditorUseCase$1;
import com.zhiyun.editorsdk.fundation.EditorUseCase$OnTimeUpdateListener;
import com.zhiyun.editorsdk.fundation.IEditorUseCaseEditor;
import d.v.h.e.b;
import java.util.ArrayList;
import java.util.List;
import m.a.a;

public class EditorUseCase {
    private IEditorUseCaseEditor a;
    private b b;
    private final List c;
    private long d;
    private long e;

    public EditorUseCase(IEditorUseCaseEditor arrayList) {
        long l10;
        this.d = l10 = (long)-1;
        this.e = l10;
        this.a = arrayList;
        this.c = arrayList = new ArrayList();
        this.j();
    }

    public static /* synthetic */ long a(EditorUseCase editorUseCase) {
        return editorUseCase.e;
    }

    public static /* synthetic */ long b(EditorUseCase editorUseCase, long l10) {
        editorUseCase.e = l10;
        return l10;
    }

    public static /* synthetic */ long c(EditorUseCase editorUseCase, long l10, boolean bl2) {
        return editorUseCase.o(l10, bl2);
    }

    public static /* synthetic */ long d(EditorUseCase editorUseCase) {
        return editorUseCase.d;
    }

    public static /* synthetic */ long e(EditorUseCase editorUseCase, long l10) {
        editorUseCase.d = l10;
        return l10;
    }

    public static /* synthetic */ long f(EditorUseCase editorUseCase, long l10, boolean bl2) {
        return editorUseCase.q(l10, bl2);
    }

    private void g() {
        b b10 = this.b;
        if (b10 != null) {
            IEditorUseCaseEditor iEditorUseCaseEditor = this.a;
            iEditorUseCaseEditor.I(b10);
        }
    }

    private void j() {
        EditorUseCase$1 editorUseCase$1 = new EditorUseCase$1(this);
        this.b = editorUseCase$1;
        this.g();
    }

    private void l() {
        b b10 = this.b;
        if (b10 != null) {
            IEditorUseCaseEditor iEditorUseCaseEditor = this.a;
            iEditorUseCaseEditor.b(b10);
            b10 = null;
            this.b = null;
        }
    }

    private long o(long l10, boolean bl2) {
        long l11;
        block7: {
            block6: {
                Object object;
                block5: {
                    object = this.a;
                    if (object != null) break block5;
                    bl2 = false;
                    Object[] objectArray = new Object[]{};
                    object = "\u5f53\u524d\u4e0d\u5e94\u6267\u884c\u6b64\u64cd\u4f5c!\u56e0\u4e3a mEditor = null";
                    m.a.a.e((String)object, objectArray);
                    break block6;
                }
                l11 = object.i();
                long l12 = l10 - l11;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 != false || bl2) break block7;
            }
            return l10;
        }
        Object object = this.c;
        if (object != null) {
            boolean bl3;
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                EditorUseCase$OnTimeUpdateListener editorUseCase$OnTimeUpdateListener = (EditorUseCase$OnTimeUpdateListener)object.next();
                editorUseCase$OnTimeUpdateListener.a(l11);
            }
        }
        return l11;
    }

    private long q(long l10, boolean bl2) {
        long l11;
        block7: {
            block6: {
                Object object;
                block5: {
                    object = this.a;
                    if (object != null) break block5;
                    bl2 = false;
                    Object[] objectArray = new Object[]{};
                    object = "\u5f53\u524d\u4e0d\u5e94\u6267\u884c\u6b64\u64cd\u4f5c!\u56e0\u4e3a mEditor = null";
                    m.a.a.e((String)object, objectArray);
                    break block6;
                }
                l11 = object.A();
                long l12 = l10 - l11;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 != false || bl2) break block7;
            }
            return l10;
        }
        Object object = this.c;
        if (object != null) {
            boolean bl3;
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                EditorUseCase$OnTimeUpdateListener editorUseCase$OnTimeUpdateListener = (EditorUseCase$OnTimeUpdateListener)object.next();
                editorUseCase$OnTimeUpdateListener.b(l11);
            }
        }
        return l11;
    }

    public void h(EditorUseCase$OnTimeUpdateListener editorUseCase$OnTimeUpdateListener) {
        if (editorUseCase$OnTimeUpdateListener != null) {
            long l10;
            long l11;
            List list = this.c;
            list.add(editorUseCase$OnTimeUpdateListener);
            long l12 = this.d;
            long l13 = -1;
            long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (l14 != false) {
                editorUseCase$OnTimeUpdateListener.b(l12);
            }
            if ((l11 = (l10 = (l12 = this.e) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                editorUseCase$OnTimeUpdateListener.a(l12);
            }
        }
    }

    public void i() {
        this.k();
    }

    public void k() {
        this.c.clear();
        this.l();
    }

    public void m(EditorUseCase$OnTimeUpdateListener editorUseCase$OnTimeUpdateListener) {
        if (editorUseCase$OnTimeUpdateListener != null) {
            List list = this.c;
            list.remove(editorUseCase$OnTimeUpdateListener);
        }
    }

    public void n() {
        this.o(0L, true);
    }

    public void p() {
        this.q(0L, true);
    }
}

