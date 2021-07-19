/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.zhiyun.device.active;

import android.util.Base64;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.active.ActivationViewModel;
import com.zhiyun.device.data.remote.entity.ActivationEntity;
import com.zhiyun.net.BaseEntity;
import d.v.e.i.h;
import d.v.y.d.k;
import k.d;
import k.f;
import k.r;

public class ActivationViewModel$c
implements f {
    public final /* synthetic */ ActivationViewModel a;

    public ActivationViewModel$c(ActivationViewModel activationViewModel) {
        this.a = activationViewModel;
    }

    public void onFailure(d object, Throwable serializable) {
        object = this.a;
        Object[] objectArray = new Object[]{};
        ActivationViewModel.f((ActivationViewModel)object, "\u83b7\u53d6\u6fc0\u6d3b\u7801\u5931\u8d25", serializable, objectArray);
        object = ActivationViewModel.r(this.a);
        serializable = Integer.valueOf(20301);
        h.g((MutableLiveData)object, serializable);
        object = ActivationViewModel.d(this.a);
        serializable = Integer.valueOf(-1);
        h.g((MutableLiveData)object, serializable);
    }

    public void onResponse(d object, r objectArray) {
        object = (BaseEntity)objectArray.a();
        int n10 = 20400;
        Object object2 = n10;
        int n11 = -1;
        Integer n12 = n11;
        String string2 = null;
        if (object != null) {
            int n13 = ((BaseEntity)object).errcode;
            objectArray = (ActivationEntity)objectArray.a();
            if (n13 != 0) {
                int n14 = 10006;
                if (n13 != n14) {
                    n14 = 10016;
                    if (n13 != n14) {
                        n14 = 10017;
                        if (n13 != n14) {
                            objectArray = this.a;
                            n10 = 1;
                            object2 = new Object[n10];
                            Integer n15 = n13;
                            object2[0] = n15;
                            string2 = "\u83b7\u53d6\u6fc0\u6d3b\u7801\u63a5\u53e3code\u8fd4\u56de\u4e0d\u5728\u5b9a\u4e49\u8303\u56f4\uff0ccode = %s";
                            ActivationViewModel.p((ActivationViewModel)objectArray, string2, object2);
                            objectArray = ActivationViewModel.r(this.a);
                            object = n13;
                            h.g((MutableLiveData)objectArray, object);
                            object = ActivationViewModel.d(this.a);
                            h.g((MutableLiveData)object, n12);
                        } else {
                            objectArray = ActivationViewModel.r(this.a);
                            object = n13;
                            h.g((MutableLiveData)objectArray, object);
                            object = ActivationViewModel.d(this.a);
                            n14 = -4;
                            objectArray = n14;
                            h.g((MutableLiveData)object, objectArray);
                        }
                    } else {
                        objectArray = ActivationViewModel.r(this.a);
                        object = n13;
                        h.g((MutableLiveData)objectArray, object);
                        object = ActivationViewModel.d(this.a);
                        n14 = -3;
                        objectArray = n14;
                        h.g((MutableLiveData)object, objectArray);
                    }
                } else {
                    objectArray = ActivationViewModel.r(this.a);
                    object = n13;
                    h.g((MutableLiveData)objectArray, object);
                    object = ActivationViewModel.d(this.a);
                    n14 = -2;
                    objectArray = n14;
                    h.g((MutableLiveData)object, objectArray);
                }
            } else if (objectArray != null && (object = objectArray.getActiveCode()) != null) {
                object = objectArray.getActiveCode();
                object2 = ActivationViewModel.o(this.a);
                h.g((MutableLiveData)object2, object);
                int n16 = objectArray.getCodeType();
                n10 = 2;
                if (n16 == n10) {
                    try {
                        object = Base64.decode((String)object, (int)0);
                    }
                    catch (Exception exception) {
                        object = this.a;
                        objectArray = new Object[]{};
                        object2 = "\u6fc0\u6d3b\u7801Base64\u89e3\u7801\u5931\u8d25";
                        ActivationViewModel.p((ActivationViewModel)object, (String)object2, objectArray);
                        n13 = 0;
                        object = null;
                    }
                } else {
                    object = k.h((String)object);
                }
                if (object == null) {
                    object = ActivationViewModel.r(this.a);
                    n16 = 20401;
                    objectArray = n16;
                    h.g((MutableLiveData)object, objectArray);
                    object = ActivationViewModel.d(this.a);
                    h.g((MutableLiveData)object, n12);
                } else {
                    objectArray = this.a;
                    ActivationViewModel.e((ActivationViewModel)objectArray, (byte[])object);
                }
            } else {
                h.g(ActivationViewModel.r(this.a), object2);
                object = ActivationViewModel.d(this.a);
                h.g((MutableLiveData)object, n12);
            }
        } else {
            object = this.a;
            objectArray = new Object[]{};
            string2 = "\u83b7\u53d6\u6fc0\u6d3b\u7801\u63a5\u53e3\u8fd4\u56denull";
            ActivationViewModel.p((ActivationViewModel)object, string2, objectArray);
            h.g(ActivationViewModel.r(this.a), object2);
            object = ActivationViewModel.d(this.a);
            h.g((MutableLiveData)object, n12);
        }
    }
}

