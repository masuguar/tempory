package tk.mybatis.mapper.entity;

import com.masuguar.foolish.format.Formatter;
import net.sourceforge.plantuml.StringUtils;
import tk.mybatis.mapper.mapperhelper.EntityHelper;

public class InheritTableHelper {
    public static String getInheritTableName(Object parameter, EntityTable entityTable) throws InstantiationException, IllegalAccessException {
        Formatter formatter = entityTable.getFormatter().newInstance();
        StringBuilder sb = new StringBuilder(16);
        String preffix = formatter.preffix(parameter);
        if(StringUtils.isNotEmpty( preffix )){
            sb.append( preffix ).append(entityTable.getSplitKey());
        }
        sb.append(entityTable.getName());
        String suffix = formatter.suffix(parameter);
        if( StringUtils.isNotEmpty(suffix) ){
            sb.append(entityTable.getSplitKey())
                    .append(suffix);
        }
        return sb.toString().toLowerCase();
    }

    public static String getInheritTableName( Object parameter ) throws IllegalAccessException, InstantiationException {
        EntityTable entityTable = EntityHelper.getEntityTable(parameter.getClass());
        return getInheritTableName(parameter,entityTable);
    }
}
