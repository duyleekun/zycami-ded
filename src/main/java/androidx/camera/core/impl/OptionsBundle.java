/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 */
package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionMatcher;
import androidx.camera.core.impl.Config$OptionPriority;
import b.a.b.w1.l;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class OptionsBundle
implements Config {
    private static final OptionsBundle EMPTY_BUNDLE;
    public static final Comparator ID_COMPARE;
    public final TreeMap mOptions;

    static {
        OptionsBundle optionsBundle;
        l l10 = l.a;
        ID_COMPARE = l10;
        TreeMap treeMap = new TreeMap(l10);
        EMPTY_BUNDLE = optionsBundle = new OptionsBundle(treeMap);
    }

    public OptionsBundle(TreeMap treeMap) {
        this.mOptions = treeMap;
    }

    public static /* synthetic */ int a(Config$Option object, Config$Option object2) {
        object = ((Config$Option)object).getId();
        object2 = ((Config$Option)object2).getId();
        return ((String)object).compareTo((String)object2);
    }

    public static OptionsBundle emptyBundle() {
        return EMPTY_BUNDLE;
    }

    public static OptionsBundle from(Config config) {
        boolean bl2;
        Object object = OptionsBundle.class;
        Object object2 = config.getClass();
        boolean bl3 = object.equals(object2);
        if (bl3) {
            return (OptionsBundle)config;
        }
        object2 = ID_COMPARE;
        object = new Object(object2);
        object2 = config.listOptions().iterator();
        while (bl2 = object2.hasNext()) {
            boolean bl4;
            Config$Option config$Option = (Config$Option)object2.next();
            Object object3 = config.getPriorities(config$Option);
            ArrayMap arrayMap = new ArrayMap();
            object3 = object3.iterator();
            while (bl4 = object3.hasNext()) {
                Config$OptionPriority config$OptionPriority = (Config$OptionPriority)((Object)object3.next());
                Object object4 = config.retrieveOptionWithPriority(config$Option, config$OptionPriority);
                arrayMap.put(config$OptionPriority, object4);
            }
            ((TreeMap)object).put(config$Option, arrayMap);
        }
        config = new OptionsBundle((TreeMap)object);
        return config;
    }

    public boolean containsOption(Config$Option config$Option) {
        return this.mOptions.containsKey(config$Option);
    }

    public void findOptions(String string2, Config$OptionMatcher config$OptionMatcher) {
        String string3;
        boolean bl2;
        boolean bl3;
        Object object = Config$Option.create(string2, Void.class);
        Object object2 = this.mOptions;
        object = ((TreeMap)object2).tailMap(object).entrySet().iterator();
        while ((bl3 = object.hasNext()) && (bl2 = (string3 = ((Config$Option)(object2 = (Map.Entry)object.next()).getKey()).getId()).startsWith(string2)) && (bl3 = config$OptionMatcher.onOptionMatched((Config$Option)(object2 = (Config$Option)object2.getKey())))) {
        }
    }

    public Config$OptionPriority getOptionPriority(Config$Option object) {
        Object object2 = (Map)this.mOptions.get(object);
        if (object2 != null) {
            return (Config$OptionPriority)((Object)Collections.min(object2.keySet()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Option does not exist: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public Set getPriorities(Config$Option object) {
        TreeMap treeMap = this.mOptions;
        if ((object = (Map)treeMap.get(object)) == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(object.keySet());
    }

    public Set listOptions() {
        return Collections.unmodifiableSet(this.mOptions.keySet());
    }

    public Object retrieveOption(Config$Option object) {
        Object object2 = (Map)this.mOptions.get(object);
        if (object2 != null) {
            object = (Config$OptionPriority)((Object)Collections.min(object2.keySet()));
            return object2.get(object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Option does not exist: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public Object retrieveOption(Config$Option config$Option, Object object) {
        try {
            return this.retrieveOption(config$Option);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return object;
        }
    }

    public Object retrieveOptionWithPriority(Config$Option object, Config$OptionPriority object2) {
        Object object3 = (Map)this.mOptions.get(object);
        String string2 = "Option does not exist: ";
        if (object3 != null) {
            boolean bl2 = object3.containsKey(object2);
            if (bl2) {
                return object3.get(object2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(object);
            stringBuilder.append(" with priority=");
            stringBuilder.append(object2);
            object = stringBuilder.toString();
            object3 = new IllegalArgumentException((String)object);
            throw object3;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append(object);
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }
}

