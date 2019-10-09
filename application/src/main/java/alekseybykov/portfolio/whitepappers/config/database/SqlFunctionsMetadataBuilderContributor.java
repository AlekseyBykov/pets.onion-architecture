//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.config.database;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.ZonedDateTimeType;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-04
 */
public class SqlFunctionsMetadataBuilderContributor implements MetadataBuilderContributor {
    @Override
    public void contribute(MetadataBuilder metadataBuilder) {
        metadataBuilder.applySqlFunction(
            "truncate_for_minutes",
            new SQLFunctionTemplate(ZonedDateTimeType.INSTANCE, "date_trunc('minute', ?1)")
        );
    }
}
