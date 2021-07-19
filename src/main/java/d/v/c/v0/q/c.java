/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q;

import androidx.databinding.BaseObservable;
import com.zhiyun.cama.data.api.entity.FileResourceUrlBean$DataBean;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import d.v.c.v0.q.c$a;

public abstract class c
extends BaseObservable {
    private FileResourceUrlBean$DataBean a;
    private boolean b;
    private int c;
    private EditConfig$ResourceType d;
    private String e;

    public c A(FileResourceUrlBean$DataBean fileResourceUrlBean$DataBean) {
        this.a = fileResourceUrlBean$DataBean;
        return this;
    }

    public c B(boolean bl2) {
        this.b = bl2;
        this.notifyPropertyChanged(42);
        return this;
    }

    public c C(int n10) {
        this.c = n10;
        this.notifyPropertyChanged(43);
        return this;
    }

    public c D(String string2) {
        this.e = string2;
        return this;
    }

    public c E(EditConfig$ResourceType editConfig$ResourceType) {
        this.d = editConfig$ResourceType;
        return this;
    }

    public EditConfig$ResourceType F() {
        Object object = c$a.a;
        EditConfig$ResourceType editConfig$ResourceType = this.d;
        int n10 = editConfig$ResourceType.ordinal();
        int n11 = object[n10];
        switch (n11) {
            default: {
                n11 = 0;
                object = null;
                break;
            }
            case 1: {
                object = EditConfig$ResourceType.MUSIC;
            }
            case 2: {
                object = EditConfig$ResourceType.RECORD;
            }
            case 3: {
                object = EditConfig$ResourceType.FILTER;
            }
            case 4: {
                object = EditConfig$ResourceType.FONT;
            }
            case 5: {
                object = EditConfig$ResourceType.CAPTION;
            }
            case 6: {
                object = EditConfig$ResourceType.STICKER;
            }
            case 7: {
                object = EditConfig$ResourceType.TRANSITION;
            }
        }
        return object;
    }

    public FileResourceUrlBean$DataBean s() {
        return this.a;
    }

    public int t() {
        return this.c;
    }

    public String u() {
        return this.e;
    }

    public String v() {
        return null;
    }

    public String w() {
        return null;
    }

    public abstract long x();

    public EditConfig$ResourceType y() {
        return this.d;
    }

    public boolean z() {
        return this.b;
    }
}

