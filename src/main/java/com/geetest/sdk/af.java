/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.af$a;
import com.geetest.sdk.al;
import com.geetest.sdk.aq;

public class af {
    public af$a a;
    public aq b;
    public al c;

    public boolean a() {
        boolean bl2;
        af$a af$a;
        Object object = this.a;
        if (object != null && (object == (af$a = af$a.SEND) && (object = this.c) != null && (bl2 = ((al)object).a()) || (object = this.a) == (af$a = af$a.WRITE) && (object = this.b) != null && (bl2 = ((aq)object).a()) || (object = this.a) == (af$a = af$a.FLUSH) || object == (af$a = af$a.OTHER))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

