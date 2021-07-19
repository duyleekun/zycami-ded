/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import kotlin.text.Regex;

public final class l {
    public static final Regex a;
    public static final l b;

    static {
        Object object = new l();
        b = object;
        object = new StringBuilder();
        ((StringBuilder)object).append("[eE][+-]?");
        Object object2 = "(\\p{Digit}+)";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        CharSequence charSequence = new StringBuilder();
        String string2 = "(0[xX]";
        charSequence.append(string2);
        CharSequence charSequence2 = "(\\p{XDigit}+)";
        charSequence.append((String)charSequence2);
        charSequence.append("(\\.)?)|");
        charSequence.append(string2);
        charSequence.append((String)charSequence2);
        charSequence.append("?(\\.)");
        charSequence.append((String)charSequence2);
        char c10 = ')';
        charSequence.append(c10);
        charSequence = charSequence.toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append('(');
        ((StringBuilder)charSequence2).append((String)object2);
        ((StringBuilder)charSequence2).append("(\\.)?(");
        ((StringBuilder)charSequence2).append((String)object2);
        ((StringBuilder)charSequence2).append("?)(");
        ((StringBuilder)charSequence2).append((String)object);
        String string3 = ")?)|";
        ((StringBuilder)charSequence2).append(string3);
        ((StringBuilder)charSequence2).append("(\\.(");
        ((StringBuilder)charSequence2).append((String)object2);
        ((StringBuilder)charSequence2).append(")(");
        ((StringBuilder)charSequence2).append((String)object);
        ((StringBuilder)charSequence2).append(string3);
        ((StringBuilder)charSequence2).append("((");
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append(")[pP][+-]?");
        ((StringBuilder)charSequence2).append((String)object2);
        ((StringBuilder)charSequence2).append(c10);
        object = ((StringBuilder)charSequence2).toString();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(")[fFdD]?))[\\x00-\\x20]*");
        object = ((StringBuilder)object2).toString();
        a = object2 = new Regex((String)object);
    }

    private l() {
    }
}

