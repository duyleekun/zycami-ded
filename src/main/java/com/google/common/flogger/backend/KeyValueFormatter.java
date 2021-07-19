/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.KeyValueHandler;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class KeyValueFormatter
implements KeyValueHandler {
    private static final Set FUNDAMENTAL_TYPES;
    private static final int NEWLINE_LIMIT = 1000;
    private boolean haveSeenValues;
    private final StringBuilder out;
    private final String prefix;
    private final String suffix;

    static {
        HashSet hashSet;
        FUNDAMENTAL_TYPES = hashSet = new HashSet();
    }

    public KeyValueFormatter(String string2, String string3, StringBuilder stringBuilder) {
        Set set = FUNDAMENTAL_TYPES;
        set.add(Boolean.class);
        set.add(Byte.class);
        set.add(Short.class);
        set.add(Integer.class);
        set.add(Long.class);
        set.add(Float.class);
        set.add(Double.class);
        this.haveSeenValues = false;
        this.prefix = string2;
        this.suffix = string3;
        this.out = stringBuilder;
    }

    private static void appendEscaped(StringBuilder stringBuilder, String string2) {
        char c10;
        char c11;
        int n10 = 0;
        while ((c11 = KeyValueFormatter.nextEscapableChar(string2, n10)) != (c10 = '\uffffffff')) {
            stringBuilder.append(string2, n10, (int)c11);
            n10 = c11 + 1;
            c11 = string2.charAt(c11);
            c10 = '\t';
            if (c11 != c10) {
                c10 = '\n';
                if (c11 != c10) {
                    c10 = '\r';
                    if (c11 != c10) {
                        c10 = '\"';
                        if (c11 != c10 && c11 != (c10 = '\\')) {
                            c11 = (char)-3;
                            stringBuilder.append(c11);
                            continue;
                        }
                    } else {
                        c11 = 'r';
                    }
                } else {
                    c11 = 'n';
                }
            } else {
                c11 = 't';
            }
            String string3 = "\\";
            stringBuilder.append(string3);
            stringBuilder.append(c11);
        }
        c11 = string2.length();
        stringBuilder.append(string2, n10, (int)c11);
    }

    private static int nextEscapableChar(String string2, int n10) {
        int n11;
        while (n10 < (n11 = string2.length())) {
            int n12;
            n11 = string2.charAt(n10);
            if (n11 >= (n12 = 32) && n11 != (n12 = 34) && n11 != (n12 = 92)) {
                ++n10;
                continue;
            }
            return n10;
        }
        return -1;
    }

    public void done() {
        boolean bl2 = this.haveSeenValues;
        if (bl2) {
            StringBuilder stringBuilder = this.out;
            String string2 = this.suffix;
            stringBuilder.append(string2);
        }
    }

    public KeyValueFormatter handle(String object, Object object2) {
        Serializable serializable;
        int n10 = this.haveSeenValues;
        boolean bl2 = true;
        char c10 = ' ';
        if (n10 != 0) {
            serializable = this.out;
            serializable.append(c10);
        } else {
            serializable = this.out;
            n10 = serializable.length();
            if (n10 > 0) {
                String string2;
                StringBuilder stringBuilder;
                int n11;
                serializable = this.out;
                int n12 = serializable.length();
                if (n12 > (n11 = 1000) || (n12 = (stringBuilder = this.out).indexOf(string2 = "\n")) != (n11 = -1)) {
                    c10 = '\n';
                }
                serializable.append(c10);
            }
            serializable = this.out;
            String string3 = this.prefix;
            serializable.append(string3);
            this.haveSeenValues = bl2;
        }
        serializable = this.out;
        serializable.append((String)object);
        char c11 = '=';
        serializable.append(c11);
        if (object2 == null) {
            object = this.out;
            ((StringBuilder)object).append(bl2);
        } else {
            object = FUNDAMENTAL_TYPES;
            serializable = object2.getClass();
            c11 = (char)(object.contains(serializable) ? 1 : 0);
            if (c11 != '\u0000') {
                object = this.out;
                ((StringBuilder)object).append(object2);
            } else {
                object = this.out;
                n10 = 34;
                ((StringBuilder)object).append((char)n10);
                object = this.out;
                object2 = object2.toString();
                KeyValueFormatter.appendEscaped((StringBuilder)object, (String)object2);
                object = this.out;
                ((StringBuilder)object).append((char)n10);
            }
        }
        return this;
    }
}

