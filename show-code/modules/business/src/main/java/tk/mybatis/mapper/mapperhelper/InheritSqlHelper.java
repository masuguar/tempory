package tk.mybatis.mapper.mapperhelper;

import com.masuguar.foolish.dialect.InheritCreateDialect;
import com.masuguar.foolish.dialect.InheritQueryDialect;
import com.masuguar.foolish.entity.InheritTableInfo;
import tk.mybatis.mapper.entity.EntityTable;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.ArrayList;
import java.util.List;

public class InheritSqlHelper {
    private static final XMLLanguageDriver languageDriver = new XMLLanguageDriver();

    public static final String INHERIT_QUERY_SUFFIX = "!inheritQueryTableStatement";
    public static final String INHERIT_CREATE_SUFFIX = "!inheritCreateTableStatement";

    public static void newCreateInheritTableStatement( MappedStatement ms, Class<?> entityClass, EntityTable entityTable  ){
        String keyId = ms.getId() + InheritSqlHelper.INHERIT_CREATE_SUFFIX;
        if (ms.getConfiguration().hasKeyGenerator(keyId)) {
            return;
        }
        String sql = InheritCreateDialect.POSTGRESSQL.getCreateTableStatement();
        SqlSource sqlSource = languageDriver.createSqlSource(ms.getConfiguration(), "<script>\n\t" + sql + "</script>", InheritTableInfo.class);
        newInheritStatement(ms, entityClass, entityTable, keyId, sqlSource);
    }

    public static void newQueryInheritTableStatement(MappedStatement ms, Class<?> entityClass, EntityTable entityTable){
        String keyId = ms.getId() + InheritSqlHelper.INHERIT_QUERY_SUFFIX;
        if (ms.getConfiguration().hasKeyGenerator(keyId)) {
            return;
        }
        //defaults
        String sql = InheritQueryDialect.POSTGRESSQL.getQueryTableStatement();
        SqlSource sqlSource = new RawSqlSource(ms.getConfiguration(), sql, String.class);
        newInheritStatement(ms,entityClass,entityTable,keyId,sqlSource);
    }
    private static void newInheritStatement(MappedStatement ms, Class<?> entityClass, EntityTable entityTable, String keyId, SqlSource sqlSource) {
        Configuration configuration = ms.getConfiguration();
        MappedStatement.Builder statementBuilder = new MappedStatement.Builder(configuration, keyId, sqlSource, SqlCommandType.SELECT);
        statementBuilder.statementType(StatementType.PREPARED);
        statementBuilder.resource(ms.getResource());
        statementBuilder.fetchSize(null);
        statementBuilder.keyProperty(entityTable.getSplitKey());
        statementBuilder.keyGenerator(new NoKeyGenerator());
        statementBuilder.databaseId(null);
        statementBuilder.keyColumn(null);
        statementBuilder.resultOrdered(false);
        statementBuilder.resulSets(null);
        statementBuilder.lang(configuration.getDefaultScriptingLanuageInstance());
        statementBuilder.timeout(configuration.getDefaultStatementTimeout());

        List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();
        ParameterMap.Builder inlineParameterMapBuilder = new ParameterMap.Builder(
                configuration,
                statementBuilder.id() + "-Inline",
                entityClass,
                parameterMappings);
        statementBuilder.parameterMap(inlineParameterMapBuilder.build());

        List<ResultMap> resultMaps = new ArrayList<ResultMap>();
        ResultMap.Builder inlineResultMapBuilder = new ResultMap.Builder(
                configuration,
                statementBuilder.id() + "-Inline",
                Integer.class,
                new ArrayList<ResultMapping>(),
                null);
        resultMaps.add(inlineResultMapBuilder.build());
        statementBuilder.resultMaps(resultMaps);
        statementBuilder.resultSetType(null);

        statementBuilder.useCache(false);
        statementBuilder.flushCacheRequired(false);
        statementBuilder.cache(null);

        MappedStatement statement = statementBuilder.build();
        try {
            configuration.addMappedStatement(statement);
        } catch (Exception e) {
            //ignore
        }
    }

}
