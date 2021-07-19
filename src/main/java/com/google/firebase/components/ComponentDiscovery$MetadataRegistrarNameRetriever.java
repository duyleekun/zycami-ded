/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ServiceInfo
 *  android.os.Bundle
 *  android.util.Log
 */
package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.components.ComponentDiscovery$1;
import com.google.firebase.components.ComponentDiscovery$RegistrarNameRetriever;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComponentDiscovery$MetadataRegistrarNameRetriever
implements ComponentDiscovery$RegistrarNameRetriever {
    private final Class discoveryService;

    private ComponentDiscovery$MetadataRegistrarNameRetriever(Class clazz) {
        this.discoveryService = clazz;
    }

    public /* synthetic */ ComponentDiscovery$MetadataRegistrarNameRetriever(Class clazz, ComponentDiscovery$1 componentDiscovery$1) {
        this(clazz);
    }

    private Bundle getMetadata(Context object) {
        block14: {
            Object object2;
            String string2;
            block13: {
                string2 = "ComponentDiscovery";
                try {
                    object2 = object.getPackageManager();
                    if (object2 != null) break block13;
                    object = "Context has no PackageManager.";
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    Log.w((String)string2, (String)"Application info not found.");
                    return null;
                }
                Log.w((String)string2, (String)object);
                return null;
            }
            Class clazz = this.discoveryService;
            ComponentName componentName = new ComponentName((Context)object, clazz);
            int n10 = 128;
            object = object2.getServiceInfo(componentName, n10);
            if (object != null) break block14;
            object = new StringBuilder();
            object2 = this.discoveryService;
            ((StringBuilder)object).append(object2);
            object2 = " has no service info.";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            Log.w((String)string2, (String)object);
            return null;
        }
        return ((ServiceInfo)object).metaData;
    }

    public List retrieve(Context context) {
        boolean bl2;
        if ((context = this.getMetadata(context)) == null) {
            Log.w((String)"ComponentDiscovery", (String)"Could not retrieve metadata, returning empty list of registrars.");
            return Collections.emptyList();
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator iterator2 = context.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = "com.google.firebase.components.ComponentRegistrar";
            String string3 = (String)iterator2.next();
            Object object = context.get(string3);
            int n10 = string2.equals(object);
            if (n10 == 0 || (n10 = string3.startsWith((String)(object = "com.google.firebase.components:"))) == 0) continue;
            n10 = 31;
            string3 = string3.substring(n10);
            arrayList.add(string3);
        }
        return arrayList;
    }
}

