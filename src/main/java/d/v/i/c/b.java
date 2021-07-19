/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.c;

import com.zhiyun.editorsdk.template.StickerBean;
import com.zhiyun.editorsdk.template.TemplateUseCase;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import java.util.function.Predicate;

public final class b
implements Predicate {
    public final /* synthetic */ TemplateSticker a;

    public /* synthetic */ b(TemplateSticker templateSticker) {
        this.a = templateSticker;
    }

    public final boolean test(Object object) {
        TemplateSticker templateSticker = this.a;
        object = (StickerBean)object;
        return TemplateUseCase.F(templateSticker, (StickerBean)object);
    }
}

