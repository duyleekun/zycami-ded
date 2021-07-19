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
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.OptionsBundle;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public final class MutableOptionsBundle
extends OptionsBundle
implements MutableConfig {
    private static final Config$OptionPriority DEFAULT_PRIORITY = Config$OptionPriority.OPTIONAL;

    private MutableOptionsBundle(TreeMap treeMap) {
        super(treeMap);
    }

    public static MutableOptionsBundle create() {
        Comparator comparator = OptionsBundle.ID_COMPARE;
        TreeMap treeMap = new TreeMap(comparator);
        MutableOptionsBundle mutableOptionsBundle = new MutableOptionsBundle(treeMap);
        return mutableOptionsBundle;
    }

    public static MutableOptionsBundle from(Config config) {
        boolean bl2;
        Object object = OptionsBundle.ID_COMPARE;
        TreeMap<Config$Option, ArrayMap> treeMap = new TreeMap<Config$Option, ArrayMap>((Comparator<Config$Option>)object);
        object = config.listOptions().iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            Config$Option config$Option = (Config$Option)object.next();
            Object object2 = config.getPriorities(config$Option);
            ArrayMap arrayMap = new ArrayMap();
            object2 = object2.iterator();
            while (bl3 = object2.hasNext()) {
                Config$OptionPriority config$OptionPriority = (Config$OptionPriority)((Object)object2.next());
                Object object3 = config.retrieveOptionWithPriority(config$Option, config$OptionPriority);
                arrayMap.put(config$OptionPriority, object3);
            }
            treeMap.put(config$Option, arrayMap);
        }
        config = new MutableOptionsBundle(treeMap);
        return config;
    }

    public void insertOption(Config$Option object, Config$OptionPriority config$OptionPriority, Object object2) {
        Map map = (Map)this.mOptions.get(object);
        if (map == null) {
            map = new ArrayMap();
            this.mOptions.put(object, map);
            map.put(config$OptionPriority, object2);
            return;
        }
        Config$OptionPriority config$OptionPriority2 = (Config$OptionPriority)((Object)Collections.min(map.keySet()));
        Object object3 = map.get((Object)config$OptionPriority2);
        boolean bl2 = object3.equals(object2);
        if (!bl2 && (bl2 = Config.hasConflict(config$OptionPriority2, config$OptionPriority))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Option values conflicts: ");
            object = ((Config$Option)object).getId();
            stringBuilder.append((String)object);
            stringBuilder.append(", existing value (");
            stringBuilder.append((Object)config$OptionPriority2);
            object = ")=";
            stringBuilder.append((String)object);
            map = map.get((Object)config$OptionPriority2);
            stringBuilder.append(map);
            stringBuilder.append(", conflicting (");
            stringBuilder.append((Object)config$OptionPriority);
            stringBuilder.append((String)object);
            stringBuilder.append(object2);
            object = stringBuilder.toString();
            object3 = new Object((String)object);
            throw object3;
        }
        map.put(config$OptionPriority, object2);
    }

    public void insertOption(Config$Option config$Option, Object object) {
        Config$OptionPriority config$OptionPriority = DEFAULT_PRIORITY;
        this.insertOption(config$Option, config$OptionPriority, object);
    }

    public Object removeOption(Config$Option config$Option) {
        return this.mOptions.remove(config$Option);
    }
}

