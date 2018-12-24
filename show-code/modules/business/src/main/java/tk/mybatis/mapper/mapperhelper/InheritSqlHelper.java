package tk.mybatis.mapper.mapperhelper;

import com.masuguar.foolish.dialect.InheritDialect;
import tk.mybatis.mapper.entity.EntityTable;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.session.Configuration;

import java.util.ArrayList;
import java.util.List;

public class InheritSqlHelper {
    public static final String INHERIT_KEY_SUFFIX = "!inheritTableStatement";

    public static void newInheritTableStatement(MappedStatement ms, Class<?> entityClass, EntityTable entityTable){
        String keyId = ms.getId() + InheritSqlHelper.INHERIT_KEY_SUFFIX;
        if (ms.getConfiguration().hasKeyGenerator(keyId)) {
            return;
        }
        //defaults
        Configuration configuration = ms.getConfiguration();
        KeyGenerator keyGenerator;
        String sql = InheritDialect.POSTGRESSQL.getQueryTableStatement();
        if (sql.equalsIgnoreCase("JDBC")) {
            keyGenerator = new Jdbc3KeyGenerator();
        } else {
            SqlSource sqlSource = new RawSqlSource(configuration, sql, entityClass);

            MappedStatement.Builder statementBuilder = new MappedStatement.Builder(configuration, keyId, sqlSource, SqlCommandType.SELECT);
            statementBuilder.resource(ms.getResource());
            statementBuilder.fetchSize(null);
            statementBuilder.statementType(StatementType.PREPARED);
            statementBuilder.keyGenerator(new NoKeyGenerator());
            statementBuilder.keyProperty(entityTable.getSplitKey());
            statementBuilder.keyColumn(null);
            statementBuilder.databaseId(null);
            statementBuilder.lang(configuration.getDefaultScriptingLanuageInstance());
            statementBuilder.resultOrdered(false);
            statementBuilder.resulSets(null);
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

            statementBuilder.flushCacheRequired(false);
            statementBuilder.useCache(false);
            statementBuilder.cache(null);

            MappedStatement statement = statementBuilder.build();
            try {
                configuration.addMappedStatement(statement);
            } catch (Exception e) {
                //ignore
            }
           // MappedStatement keyStatement = configuration.getMappedStatement(keyId, false);
            //如果单独设置了 order，使用 column 提供的，否则使用全局的
            //keyGenerator = new SelectKeyGenerator(keyStatement, column.getOrder() != ORDER.DEFAULT ? (column.getOrder() == ORDER.BEFORE) : true);
            try {
                //configuration.addKeyGenerator(keyId, keyGenerator);
            } catch (Exception e) {
                //ignore
            }
        }
        //keyGenerator
/*        try {
            MetaObject msObject = MetaObjectUtil.forObject(ms);
            msObject.setValue("keyGenerator", keyGenerator);
            msObject.setValue("keyProperties", column.getTable().getKeyProperties());
            msObject.setValue("keyColumns", column.getTable().getKeyColumns());
        } catch (Exception e) {
            //ignore
        }*/
    }
}
