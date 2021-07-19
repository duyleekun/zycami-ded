/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.z6;

import androidx.lifecycle.MutableLiveData;
import d.v.e0.yd;
import java.util.LinkedList;

public final class c {
    private final LinkedList a;
    public final MutableLiveData b;

    public c() {
        Object object = new LinkedList();
        this.a = object;
        this.b = object = new MutableLiveData();
    }

    public void a(yd object) {
        this.a.addLast(object);
        object = this.b;
        LinkedList linkedList = this.a;
        ((MutableLiveData)object).setValue(linkedList);
    }

    public void b() {
        this.a.clear();
        MutableLiveData mutableLiveData = this.b;
        LinkedList linkedList = this.a;
        mutableLiveData.setValue(linkedList);
    }

    public yd c() {
        LinkedList linkedList = this.a;
        boolean bl2 = linkedList.isEmpty();
        if (!bl2) {
            return (yd)this.a.getLast();
        }
        return null;
    }

    public void d() {
        this.a.removeLast();
        MutableLiveData mutableLiveData = this.b;
        LinkedList linkedList = this.a;
        mutableLiveData.setValue(linkedList);
    }

    public int e() {
        return this.a.size();
    }
}

