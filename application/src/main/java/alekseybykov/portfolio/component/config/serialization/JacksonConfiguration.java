//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.config.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-04
 */
@Configuration
public class JacksonConfiguration {
    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);
        LocalDateSerializer localDateSerializer = new LocalDateSerializer(dateTimeFormatter);

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(localDateSerializer);

        objectMapper.registerModule(simpleModule);

        return objectMapper;
    }
}
