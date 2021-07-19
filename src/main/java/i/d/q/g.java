/*
 * Decompiled with CFR 0.151.
 */
package i.d.q;

import i.d.q.c;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class g
implements c {
    private byte[] a;
    private TreeMap b;

    public g() {
        TreeMap treeMap;
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.b = treeMap = new TreeMap(comparator);
    }

    public void a(String string2, String string3) {
        this.b.put(string2, string3);
    }

    public boolean d(String string2) {
        return this.b.containsKey(string2);
    }

    public Iterator e() {
        return Collections.unmodifiableSet(this.b.keySet()).iterator();
    }

    public byte[] getContent() {
        return this.a;
    }

    public void i(byte[] byArray) {
        this.a = byArray;
    }

    public String j(String string2) {
        TreeMap treeMap = this.b;
        if ((string2 = (String)treeMap.get(string2)) == null) {
            string2 = "";
        }
        return string2;
    }
}

