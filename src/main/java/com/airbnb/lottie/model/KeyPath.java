/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model;

import com.airbnb.lottie.model.KeyPathElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPath {
    public static final KeyPath COMPOSITION;
    private final List keys;
    private KeyPathElement resolvedElement;

    static {
        KeyPath keyPath;
        String[] stringArray = new String[]{"COMPOSITION"};
        COMPOSITION = keyPath = new KeyPath(stringArray);
    }

    private KeyPath(KeyPath object) {
        ArrayList arrayList;
        List list = ((KeyPath)object).keys;
        this.keys = arrayList = new ArrayList(list);
        this.resolvedElement = object = ((KeyPath)object).resolvedElement;
    }

    public KeyPath(String ... object) {
        this.keys = object = Arrays.asList(object);
    }

    private boolean endsWithGlobstar() {
        List list = this.keys;
        int n10 = list.size() + -1;
        return ((String)list.get(n10)).equals("**");
    }

    private boolean isContainer(String string2) {
        return "__container".equals(string2);
    }

    public KeyPath addKey(String string2) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add(string2);
        return keyPath;
    }

    /*
     * Unable to fully structure code
     */
    public boolean fullyResolvesTo(String var1_1, int var2_2) {
        var3_3 = this.keys;
        var4_4 = var3_3.size();
        var5_5 = 0;
        if (var2_2 >= var4_4) {
            return false;
        }
        var3_3 = this.keys;
        var4_4 = var3_3.size();
        var6_6 = 1;
        if (var2_2 == (var4_4 -= var6_6)) {
            var4_4 = var6_6;
        } else {
            var4_4 = 0;
            var3_3 = null;
        }
        var7_7 = (String)this.keys.get(var2_2);
        var8_8 = "**";
        var9_9 = var7_7.equals(var8_8);
        if (var9_9 == 0) {
            var10_10 = var7_7.equals(var1_1);
            if (var10_10 == 0 && (var10_10 = (int)var7_7.equals(var1_1 = "*")) == 0) {
                var10_10 = 0;
                var1_1 = null;
            } else {
                var10_10 = var6_6;
            }
            if ((var4_4 != 0 || var2_2 == (var4_4 = (var3_3 = this.keys).size() + -2) && (var2_2 = (int)this.endsWithGlobstar()) != 0) && var10_10 != 0) {
                var5_5 = var6_6;
            }
            return (boolean)var5_5;
        }
        if (var4_4 != 0) ** GOTO lbl-1000
        var7_7 = this.keys;
        var9_9 = var2_2 + 1;
        var11_12 = (var7_7 = (String)var7_7.get(var9_9)).equals(var1_1);
        if (var11_12 != 0) {
            var11_12 = var6_6;
        } else lbl-1000:
        // 2 sources

        {
            var11_12 = 0;
            var7_7 = null;
        }
        if (var11_12 != 0) {
            var1_1 = this.keys;
            var10_11 = var1_1.size() + -2;
            if (var2_2 == var10_11 || var2_2 == (var10_11 = (var1_1 = this.keys).size() + -3) && (var10_11 = (int)this.endsWithGlobstar()) != 0) {
                var5_5 = var6_6;
            }
            return (boolean)var5_5;
        }
        if (var4_4 != 0) {
            return (boolean)var6_6;
        }
        var3_3 = this.keys;
        var4_4 = var3_3.size() - var6_6;
        if ((var2_2 += var6_6) < var4_4) {
            return false;
        }
        return ((String)this.keys.get(var2_2)).equals(var1_1);
    }

    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    public int incrementDepthBy(String string2, int n10) {
        boolean n11 = this.isContainer(string2);
        if (n11) {
            return 0;
        }
        Object object = (String)this.keys.get(n10);
        String string3 = "**";
        boolean bl2 = ((String)object).equals(string3);
        int n12 = 1;
        if (!bl2) {
            return n12;
        }
        object = this.keys;
        int n13 = object.size() - n12;
        if (n10 == n13) {
            return 0;
        }
        object = this.keys;
        String string4 = (String)object.get(n10 += n12);
        boolean bl3 = string4.equals(string2);
        if (bl3) {
            return 2;
        }
        return 0;
    }

    public String keysToString() {
        return this.keys.toString();
    }

    public boolean matches(String string2, int n10) {
        String string3;
        int n11 = this.isContainer(string2);
        boolean bl2 = true;
        if (n11 != 0) {
            return bl2;
        }
        Object object = this.keys;
        n11 = object.size();
        if (n10 >= n11) {
            return false;
        }
        object = (String)this.keys.get(n10);
        boolean bl3 = ((String)object).equals(string2);
        if (!(bl3 || (bl3 = (string2 = (String)this.keys.get(n10)).equals(object = "**")) || (bl3 = (string2 = (String)this.keys.get(n10)).equals(string3 = "*")))) {
            return false;
        }
        return bl2;
    }

    public boolean propagateToChildren(String object, int n10) {
        String string2;
        String string3 = "__container";
        int n11 = string3.equals(object);
        int n12 = 1;
        if (n11 != 0) {
            return n12 != 0;
        }
        object = this.keys;
        n11 = object.size() - n12;
        if (n10 >= n11 && (n11 = (int)(((String)(object = (String)this.keys.get(n10))).equals(string2 = "**") ? 1 : 0)) == 0) {
            n12 = 0;
            string3 = null;
        }
        return n12 != 0;
    }

    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public String toString() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KeyPath{keys=");
        Object object = this.keys;
        stringBuilder.append(object);
        stringBuilder.append(",resolved=");
        object = this.resolvedElement;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        stringBuilder.append(bl2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

