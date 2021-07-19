/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.z1;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.cama.watermark.WaterMarkBean;
import com.zhiyun.cama.watermark.WaterMarkBean$WaterMarkDataInfo;
import com.zhiyun.editortemplate.TemEditorConfig;
import d.v.c.m0;
import d.v.c.z1.a;
import d.v.c.z1.b;
import d.v.c.z1.c;
import d.v.c.z1.e$a;
import d.v.e.i.h;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class e
extends ViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;

    public e() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData = new MutableLiveData();
    }

    public static /* synthetic */ void g(WaterMarkBean$WaterMarkDataInfo waterMarkBean$WaterMarkDataInfo) {
        Object object = ResConfig$AppResType.WATERMARK;
        String string2 = waterMarkBean$WaterMarkDataInfo.getPath();
        string2 = TemEditorConfig.c((d.v.e.j.a)object, string2);
        String string3 = waterMarkBean$WaterMarkDataInfo.getThumbnail();
        object = TemEditorConfig.c((d.v.e.j.a)object, string3);
        waterMarkBean$WaterMarkDataInfo.setThumbnail((String)object);
        waterMarkBean$WaterMarkDataInfo.setPath(string2);
        waterMarkBean$WaterMarkDataInfo.setDefault(false);
    }

    public static /* synthetic */ boolean i(String string2, WaterMarkBean$WaterMarkDataInfo object) {
        object = ((WaterMarkBean$WaterMarkDataInfo)object).getPath();
        return Objects.equals(string2, object);
    }

    public static /* synthetic */ WaterMarkBean$WaterMarkDataInfo j(String string2, List list) {
        WaterMarkBean$WaterMarkDataInfo waterMarkBean$WaterMarkDataInfo = new WaterMarkBean$WaterMarkDataInfo(-1000L, string2);
        waterMarkBean$WaterMarkDataInfo.setThumbnail(string2);
        int n10 = 1;
        waterMarkBean$WaterMarkDataInfo.setDefault(n10 != 0);
        list.add(n10, waterMarkBean$WaterMarkDataInfo);
        return waterMarkBean$WaterMarkDataInfo;
    }

    public void b(String object) {
        Object object2 = (List)this.c.getValue();
        int n10 = TextUtils.isEmpty((CharSequence)object);
        int n11 = 0;
        if (n10 == 0 && (n10 = d.v.j.b.f((List)object2)) == 0) {
            int n12;
            for (n10 = 0; n10 < (n12 = object2.size()); ++n10) {
                String string2;
                Object object3 = (WaterMarkBean$WaterMarkDataInfo)object2.get(n10);
                if (object3 == null || (string2 = ((WaterMarkBean$WaterMarkDataInfo)object3).getPath()) == null || (n12 = (int)(((String)(object3 = ((WaterMarkBean$WaterMarkDataInfo)object3).getPath())).equals(object) ? 1 : 0)) == 0) continue;
                n11 = n10;
                break;
            }
            object = this.a;
            object2 = n11;
            ((MutableLiveData)object).setValue(object2);
            return;
        }
        object = this.a;
        object2 = 0;
        ((MutableLiveData)object).setValue(object2);
    }

    public List c(String string2) {
        Object object = m0.n();
        Object object2 = new e$a(this);
        if ((object = (WaterMarkBean)d.v.e.l.q2.c.d((String)object, (Type)(object2 = ((TypeToken)object2).getType()))) == null) {
            return Collections.emptyList();
        }
        boolean bl2 = d.v.j.b.f((List)(object = ((WaterMarkBean)object).getList()));
        if (bl2) {
            return Collections.emptyList();
        }
        object2 = d.v.c.z1.b.a;
        object.forEach(object2);
        long l10 = -1;
        object2 = new WaterMarkBean$WaterMarkDataInfo(l10, null);
        Object object3 = m0.i();
        ((WaterMarkBean$WaterMarkDataInfo)object2).setThumbnail((String)object3);
        object3 = null;
        object.add(0, object2);
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            object2 = object.stream();
            object3 = new a(string2);
            object2 = object2.filter(object3).findFirst();
            object3 = new c(string2, (List)object);
            ((Optional)object2).orElseGet(object3);
        }
        h.g(this.c, object);
        return object;
    }

    public LiveData d() {
        return this.a;
    }

    public MutableLiveData e() {
        return this.b;
    }

    public void f(int n10, WaterMarkBean$WaterMarkDataInfo waterMarkBean$WaterMarkDataInfo) {
        this.b.setValue(waterMarkBean$WaterMarkDataInfo);
    }
}

