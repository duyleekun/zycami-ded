/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

import com.zhiyun.cama.data.PagingRequestHelper$RequestType;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import java.util.Arrays;

public final class PagingRequestHelper$f {
    public final PagingRequestHelper$Status a;
    public final PagingRequestHelper$Status b;
    public final PagingRequestHelper$Status c;
    private final Throwable[] d;
    private int e;
    private String f;

    public PagingRequestHelper$f(PagingRequestHelper$Status pagingRequestHelper$Status, PagingRequestHelper$Status pagingRequestHelper$Status2, PagingRequestHelper$Status pagingRequestHelper$Status3, Throwable[] throwableArray) {
        this.a = pagingRequestHelper$Status;
        this.b = pagingRequestHelper$Status2;
        this.c = pagingRequestHelper$Status3;
        this.d = throwableArray;
    }

    public int a() {
        return this.e;
    }

    public Throwable b(PagingRequestHelper$RequestType pagingRequestHelper$RequestType) {
        Throwable[] throwableArray = this.d;
        int n10 = pagingRequestHelper$RequestType.ordinal();
        return throwableArray[n10];
    }

    public String c() {
        return this.f;
    }

    public boolean d() {
        boolean bl2;
        PagingRequestHelper$Status pagingRequestHelper$Status = this.a;
        PagingRequestHelper$Status pagingRequestHelper$Status2 = PagingRequestHelper$Status.FAILED;
        if (pagingRequestHelper$Status != pagingRequestHelper$Status2 && (pagingRequestHelper$Status = this.b) != pagingRequestHelper$Status2 && (pagingRequestHelper$Status = this.c) != pagingRequestHelper$Status2) {
            bl2 = false;
            pagingRequestHelper$Status = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean e() {
        boolean bl2;
        PagingRequestHelper$Status pagingRequestHelper$Status = this.a;
        PagingRequestHelper$Status pagingRequestHelper$Status2 = PagingRequestHelper$Status.RUNNING;
        if (pagingRequestHelper$Status != pagingRequestHelper$Status2 && (pagingRequestHelper$Status = this.b) != pagingRequestHelper$Status2 && (pagingRequestHelper$Status = this.c) != pagingRequestHelper$Status2) {
            bl2 = false;
            pagingRequestHelper$Status = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean equals(Object objectArray) {
        Object object;
        Object object2;
        if (this == objectArray) {
            return true;
        }
        Object[] objectArray2 = null;
        if (objectArray != null && (object2 = PagingRequestHelper$f.class) == (object = objectArray.getClass())) {
            objectArray = (PagingRequestHelper$f)objectArray;
            object2 = this.a;
            object = objectArray.a;
            if (object2 != object) {
                return false;
            }
            object2 = this.b;
            object = objectArray.b;
            if (object2 != object) {
                return false;
            }
            object2 = this.c;
            object = objectArray.c;
            if (object2 != object) {
                return false;
            }
            objectArray2 = this.d;
            objectArray = objectArray.d;
            return Arrays.equals(objectArray2, objectArray);
        }
        return false;
    }

    public void f(int n10) {
        this.e = n10;
    }

    public void g(String string2) {
        this.f = string2;
    }

    public int hashCode() {
        int n10 = this.a.hashCode() * 31;
        int n11 = this.b.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.c.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = Arrays.hashCode(this.d);
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StatusReport{initial=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", before=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(", after=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", mErrors=");
        object = Arrays.toString(this.d);
        stringBuilder.append((String)object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

