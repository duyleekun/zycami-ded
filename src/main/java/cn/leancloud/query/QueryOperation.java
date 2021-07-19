/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.query;

import java.util.HashMap;

public class QueryOperation {
    public static final String AND_OP = "$and";
    public static final String EQUAL_OP = "__eq";
    public static final String OR_OP = "$or";
    private String key;
    private String op;
    private Object value;

    public QueryOperation(String string2, String string3, Object object) {
        this.key = string2;
        this.op = string3;
        this.value = object;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        Object object2;
        boolean bl4 = true;
        if (this == object) {
            return bl4;
        }
        if (object == null) {
            return false;
        }
        Object object3 = this.getClass();
        if (object3 != (object2 = object.getClass())) {
            return false;
        }
        object = (QueryOperation)object;
        object3 = this.key;
        if (object3 == null ? (object3 = ((QueryOperation)object).key) != null : !(bl3 = ((String)object3).equals(object2 = ((QueryOperation)object).key))) {
            return false;
        }
        object3 = this.op;
        if (object3 == null ? (object3 = ((QueryOperation)object).op) != null : !(bl3 = ((String)object3).equals(object2 = ((QueryOperation)object).op))) {
            return false;
        }
        object3 = this.value;
        if (object3 == null ? (object = ((QueryOperation)object).value) != null : !(bl2 = object3.equals(object = ((QueryOperation)object).value))) {
            return false;
        }
        return bl4;
    }

    public String getKey() {
        return this.key;
    }

    public String getOp() {
        return this.op;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.key;
        int n12 = 0;
        if (string2 == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = string2.hashCode();
        }
        int n13 = 31;
        n11 = (n11 + n13) * n13;
        String string3 = this.op;
        if (string3 == null) {
            n10 = 0;
            string3 = null;
        } else {
            n10 = string3.hashCode();
        }
        n11 = (n11 + n10) * n13;
        Object object = this.value;
        if (object != null) {
            n12 = object.hashCode();
        }
        return n11 + n12;
    }

    public boolean sameOp(QueryOperation object) {
        block8: {
            boolean bl2;
            String string2;
            String string3;
            block7: {
                block6: {
                    if (object == null) {
                        return false;
                    }
                    string3 = this.key;
                    if (string3 == null || (string2 = ((QueryOperation)object).key) == null) break block6;
                    boolean bl3 = string3.equals(string2);
                    if (!bl3) {
                        return false;
                    }
                    break block7;
                }
                if (string3 != null || (string3 = ((QueryOperation)object).key) != null) break block8;
            }
            return !((string3 = this.op) != null && (string2 = ((QueryOperation)object).op) != null ? !(bl2 = string3.equals(string2)) : string3 != null || (object = ((QueryOperation)object).op) != null);
        }
        return false;
    }

    public Object toResult() {
        String string2;
        boolean bl2;
        Object object = this.op;
        if (object != null && !(bl2 = ((String)object).equals(string2 = EQUAL_OP)) && !(bl2 = ((String)(object = this.op)).equals(string2 = OR_OP))) {
            object = new Object();
            string2 = this.op;
            Object object2 = this.value;
            object.put(string2, object2);
            return object;
        }
        return this.value;
    }

    public Object toResult(String string2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object = this.toResult();
        hashMap.put(string2, object);
        return hashMap;
    }
}

