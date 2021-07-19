/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.j.g.d0;

import android.text.TextUtils;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.api.entity.template.FileDataBaseBean;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;
import com.zhiyun.editortemplate.data.database.model.FileDataItem;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import d.v.e.l.c1;
import d.v.e.l.s1;
import d.v.j.e.i.a1;
import d.v.j.e.i.d1;
import d.v.j.e.i.z0;
import d.v.j.g.d0.a;
import d.v.j.g.d0.b;
import d.v.j.g.d0.c;
import d.v.j.g.d0.f$a;
import d.v.j.g.d0.f$b;
import d.v.j.g.d0.f$c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class f
extends c {
    public a1 d;

    public f() {
        d.v.j.e.i.c1 c12 = d.v.j.e.c.a();
        this.d = c12;
    }

    public static String E() {
        return TemEditorConfig.e();
    }

    public static String F(FileData object) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = ((FileData)object).getName();
        stringBuilder.append(string2);
        stringBuilder.append(".");
        object = s1.y(((FileData)object).getUrl(), "");
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public static String G(FileExt object) {
        if (object != null) {
            StringBuilder stringBuilder = new StringBuilder();
            object = ((FileExt)object).getLicenseName();
            stringBuilder.append((String)object);
            stringBuilder.append(".lic");
            object = stringBuilder.toString();
        } else {
            object = null;
        }
        return object;
    }

    public static f H() {
        return f$c.a();
    }

    private /* synthetic */ void I(EditorProtocol editorProtocol, TemplatePOJO templatePOJO, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        List list = this.D(editorProtocol);
        List list2 = this.Q(list);
        int n10 = list2.size();
        if (n10 > 0) {
            DownLoadHelper downLoadHelper = DownLoadHelper.getInstance();
            f$b f$b = new f$b(this, list2, templatePOJO, editorProtocol, list);
            editorProtocol = null;
            downLoadHelper.startThreadPoolDownLoadAnyFail(list2, f$b, downLoadHelper$CancelControl, false);
        } else {
            downLoadHelper$CancelControl = null;
            this.A(templatePOJO, editorProtocol, null);
        }
    }

    private /* synthetic */ void K(List list, FileDataItem fileDataItem) {
        FileDataBaseBean fileDataBaseBean = fileDataItem.entity;
        boolean bl2 = fileDataItem.enable;
        this.y(list, fileDataBaseBean, bl2);
    }

    public static f M() {
        f f10 = new f();
        return f10;
    }

    public void A(TemplatePOJO templatePOJO, EditorProtocol editorProtocol, List object) {
        object = f.E();
        boolean bl2 = this.P(templatePOJO, (String)object, editorProtocol);
        if (bl2) {
            this.m(templatePOJO);
        } else {
            this.j(templatePOJO);
        }
    }

    public void B(TemplatePOJO templatePOJO, EditorProtocol editorProtocol, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        Executor executor = c1.b().a();
        a a10 = new a(this, editorProtocol, templatePOJO, downLoadHelper$CancelControl);
        executor.execute(a10);
    }

    public Long C(TemplatePOJO templatePOJO) {
        return templatePOJO.getTemplate().getId();
    }

    public List D(EditorProtocol editorProtocol) {
        ArrayList arrayList = new ArrayList();
        z0 z02 = this.d.d();
        b b10 = new b(this, arrayList);
        z02.j(editorProtocol, b10);
        return arrayList;
    }

    public /* synthetic */ void J(EditorProtocol editorProtocol, TemplatePOJO templatePOJO, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.I(editorProtocol, templatePOJO, downLoadHelper$CancelControl);
    }

    public /* synthetic */ void L(List list, FileDataItem fileDataItem) {
        this.K(list, fileDataItem);
    }

    public void N(TemplatePOJO templatePOJO, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        Object object = templatePOJO.getTemplateData();
        Object object2 = templatePOJO.getTemplate();
        long l10 = ((Template)object2).getReferenceId();
        boolean bl2 = ((TemplateData)object).isFileTemplate();
        if (bl2) {
            object = this.d.i().a();
            int n10 = (int)l10;
            object = object.i(n10);
            object2 = new f$a(this, templatePOJO, downLoadHelper$CancelControl);
            object.h((k.f)object2);
        } else {
            this.i(templatePOJO);
        }
    }

    public EditorProtocol O(TemplateInfoData object) {
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((TemplateInfoData)object).getEditorNameJson())))) {
            Class<EditorProtocol> clazz = EditorProtocol.class;
            object = (EditorProtocol)d.v.e.l.q2.c.a(clazz, (String)object);
        } else {
            object = null;
        }
        return object;
    }

    public boolean P(TemplatePOJO templatePOJO, String string2, EditorProtocol editorProtocol) {
        editorProtocol.setResPath(string2);
        return this.d.d().l0(templatePOJO, editorProtocol);
    }

    public List Q(List object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            FileDataBaseBean fileDataBaseBean = (FileDataBaseBean)object.next();
            Object object2 = fileDataBaseBean.getFile().getUrl();
            String string2 = f.E();
            String string3 = f.F(fileDataBaseBean.getFile());
            Object object3 = new DownloadEntity((String)object2, string2, string3, fileDataBaseBean);
            arrayList.add(object3);
            object3 = fileDataBaseBean.getFile().getExt();
            if (object3 == null || (bl3 = TextUtils.isEmpty((CharSequence)(object2 = ((FileExt)object3).getLicenseUrl())))) continue;
            string2 = ((FileExt)object3).getLicenseUrl();
            string3 = f.E();
            object3 = f.G((FileExt)object3);
            object2 = new DownloadEntity(string2, string3, (String)object3, fileDataBaseBean);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public boolean y(List object, FileDataBaseBean fileDataBaseBean, boolean bl2) {
        if (fileDataBaseBean != null) {
            Object object2;
            FileData fileData = fileDataBaseBean.getFile();
            if (bl2 && !(bl2 = fileDataBaseBean.isLocalSource()) && fileData != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = fileData.getUrl()))) && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = fileData.getHash())))) {
                object2 = this.d.d();
                CharSequence charSequence = fileData.getHash();
                if ((object2 = ((d1)object2).l((String)charSequence)) == null) {
                    boolean bl3;
                    object2 = f.F(fileData);
                    fileDataBaseBean.setName((String)object2);
                    charSequence = new StringBuilder();
                    CharSequence charSequence2 = f.E();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append((String)object2);
                    object2 = ((StringBuilder)charSequence).toString();
                    fileData.setPath((String)object2);
                    object2 = fileData.getExt();
                    charSequence = f.G((FileExt)object2);
                    charSequence2 = new StringBuilder();
                    String string2 = f.E();
                    ((StringBuilder)charSequence2).append(string2);
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    charSequence = ((StringBuilder)charSequence2).toString();
                    if (object2 != null && !(bl3 = TextUtils.isEmpty((CharSequence)(charSequence2 = ((FileExt)object2).getLicenseName())))) {
                        charSequence2 = ((FileExt)object2).getLicenseUrl();
                        object2 = ((FileExt)object2).getLicenseName();
                        object2 = FileExt.create((String)charSequence2, (String)object2, (String)charSequence);
                        fileData.setExt((FileExt)object2);
                    } else {
                        bl2 = false;
                        object2 = null;
                        fileData.setExt(null);
                    }
                    object.add(fileDataBaseBean);
                } else {
                    object = s1.D(((FileData)object2).getPath());
                    fileDataBaseBean.setName((String)object);
                    fileDataBaseBean.setFile((FileData)object2);
                }
                return true;
            }
        }
        return false;
    }

    public boolean z(TemplatePOJO object) {
        boolean bl2;
        boolean bl3 = super.e(object);
        if (!bl3 && !(bl2 = ((TemplateData)(object = ((TemplatePOJO)object).getTemplateData())).isDownloadFinished())) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

