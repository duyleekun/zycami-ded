/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.t.f0;
import f.l2.q;
import f.n2.m;
import f.q2.k;
import f.x1.t;
import f.x1.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.Regex$Serialized;
import kotlin.text.Regex$a;
import kotlin.text.Regex$findAll$1;
import kotlin.text.Regex$findAll$2;
import kotlin.text.Regex$fromInt$$inlined$apply$lambda$1;
import kotlin.text.RegexKt;
import kotlin.text.RegexOption;

public final class Regex
implements Serializable {
    public static final Regex$a Companion;
    private Set _options;
    private final Pattern nativePattern;

    static {
        Regex$a regex$a;
        Companion = regex$a = new Regex$a(null);
    }

    public Regex(String object) {
        f0.p(object, "pattern");
        object = Pattern.compile((String)object);
        f0.o(object, "Pattern.compile(pattern)");
        this((Pattern)object);
    }

    public Regex(String object, Set set) {
        f0.p(object, "pattern");
        f0.p(set, "options");
        Regex$a regex$a = Companion;
        int n10 = RegexKt.f(set);
        n10 = Regex$a.a(regex$a, n10);
        object = Pattern.compile((String)object, n10);
        f0.o(object, "Pattern.compile(pattern,\u2026odeCase(options.toInt()))");
        this((Pattern)object);
    }

    public Regex(String object, RegexOption regexOption) {
        f0.p(object, "pattern");
        f0.p(regexOption, "option");
        Regex$a regex$a = Companion;
        int n10 = regexOption.getValue();
        n10 = Regex$a.a(regex$a, n10);
        object = Pattern.compile((String)object, n10);
        f0.o(object, "Pattern.compile(pattern,\u2026nicodeCase(option.value))");
        this((Pattern)object);
    }

    public Regex(Pattern pattern) {
        f0.p(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ k find$default(Regex regex, CharSequence charSequence, int n10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            n10 = 0;
        }
        return regex.find(charSequence, n10);
    }

    public static /* synthetic */ m findAll$default(Regex regex, CharSequence charSequence, int n10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            n10 = 0;
        }
        return regex.findAll(charSequence, n10);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int n10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            n10 = 0;
        }
        return regex.split(charSequence, n10);
    }

    private final Object writeReplace() {
        String string2 = this.nativePattern.pattern();
        f0.o(string2, "nativePattern.pattern()");
        int n10 = this.nativePattern.flags();
        Regex$Serialized regex$Serialized = new Regex$Serialized(string2, n10);
        return regex$Serialized;
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        f0.p(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public final k find(CharSequence charSequence, int n10) {
        f0.p(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        f0.o(matcher, "nativePattern.matcher(input)");
        return RegexKt.a(matcher, n10, charSequence);
    }

    public final m findAll(CharSequence object, int n10) {
        int n11;
        Object object2 = "input";
        f0.p(object, (String)object2);
        if (n10 >= 0 && n10 <= (n11 = object.length())) {
            object2 = new Regex$findAll$1(this, (CharSequence)object, n10);
            object = Regex$findAll$2.INSTANCE;
            return SequencesKt__SequencesKt.q((a)object2, (l)object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Start index out of bounds: ");
        stringBuilder.append(n10);
        stringBuilder.append(", input length: ");
        int n12 = object.length();
        stringBuilder.append(n12);
        object = stringBuilder.toString();
        object2 = new IndexOutOfBoundsException((String)object);
        throw object2;
    }

    public final Set getOptions() {
        Set<RegexOption> set = this._options;
        if (set == null) {
            int n10 = this.nativePattern.flags();
            Object object = EnumSet.allOf(RegexOption.class);
            Regex$fromInt$$inlined$apply$lambda$1 regex$fromInt$$inlined$apply$lambda$1 = new Regex$fromInt$$inlined$apply$lambda$1(n10);
            y.P0(object, regex$fromInt$$inlined$apply$lambda$1);
            set = Collections.unmodifiableSet(object);
            object = "Collections.unmodifiable\u2026mask == it.value }\n    })";
            f0.o(set, (String)object);
            this._options = set;
        }
        return set;
    }

    public final String getPattern() {
        String string2 = this.nativePattern.pattern();
        f0.o(string2, "nativePattern.pattern()");
        return string2;
    }

    public final k matchEntire(CharSequence charSequence) {
        f0.p(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        f0.o(matcher, "nativePattern.matcher(input)");
        return RegexKt.c(matcher, charSequence);
    }

    public final boolean matches(CharSequence charSequence) {
        f0.p(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final String replace(CharSequence charSequence, l l10) {
        f0.p(charSequence, "input");
        f0.p(l10, "transform");
        int n10 = 0;
        Object object = null;
        int n11 = 2;
        int n12 = 0;
        k k10 = Regex.find$default(this, charSequence, 0, n11, null);
        if (k10 != null) {
            n12 = charSequence.length();
            StringBuilder stringBuilder = new StringBuilder(n12);
            do {
                f0.m(k10);
                Integer n13 = k10.c().l();
                int n14 = n13;
                stringBuilder.append(charSequence, n10, n14);
                object = (CharSequence)l10.invoke(k10);
                stringBuilder.append((CharSequence)object);
                object = k10.c().k();
                n10 = (Integer)object + 1;
                k10 = k10.next();
            } while (n10 < n12 && k10 != null);
            if (n10 < n12) {
                stringBuilder.append(charSequence, n10, n12);
            }
            charSequence = stringBuilder.toString();
            f0.o(charSequence, "sb.toString()");
            return charSequence;
        }
        return ((Object)charSequence).toString();
    }

    public final String replace(CharSequence charSequence, String string2) {
        f0.p(charSequence, "input");
        f0.p(string2, "replacement");
        charSequence = this.nativePattern.matcher(charSequence).replaceAll(string2);
        f0.o(charSequence, "nativePattern.matcher(in\u2026).replaceAll(replacement)");
        return charSequence;
    }

    public final String replaceFirst(CharSequence charSequence, String string2) {
        f0.p(charSequence, "input");
        f0.p(string2, "replacement");
        charSequence = this.nativePattern.matcher(charSequence).replaceFirst(string2);
        f0.o(charSequence, "nativePattern.matcher(in\u2026replaceFirst(replacement)");
        return charSequence;
    }

    public final List split(CharSequence charSequence, int n10) {
        Matcher matcher;
        int n11;
        f0.p(charSequence, "input");
        int n12 = 0;
        String string2 = null;
        int n13 = 1;
        if (n10 >= 0) {
            n11 = n13;
        } else {
            n11 = 0;
            matcher = null;
        }
        if (n11 != 0) {
            matcher = this.nativePattern.matcher(charSequence);
            boolean bl2 = matcher.find();
            if (bl2 && n10 != n13) {
                int n14 = 10;
                if (n10 > 0) {
                    n14 = q.u(n10, n14);
                }
                ArrayList<CharSequence> arrayList = new ArrayList<CharSequence>(n14);
                n10 -= n13;
                do {
                    n13 = matcher.start();
                    string2 = ((Object)charSequence.subSequence(n12, n13)).toString();
                    arrayList.add(string2);
                    n12 = matcher.end();
                } while ((n10 < 0 || (n13 = arrayList.size()) != n10) && (n13 = (int)(matcher.find() ? 1 : 0)) != 0);
                n10 = charSequence.length();
                charSequence = ((Object)charSequence.subSequence(n12, n10)).toString();
                arrayList.add(charSequence);
                return arrayList;
            }
            return t.k(((Object)charSequence).toString());
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Limit must be non-negative, but was ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append('.');
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string2 = this.nativePattern.toString();
        f0.o(string2, "nativePattern.toString()");
        return string2;
    }
}

