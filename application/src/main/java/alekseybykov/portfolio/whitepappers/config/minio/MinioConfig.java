//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.config.minio;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-04
 */
@Configuration
public class MinioConfig {

    @Value("${fileservice.storage.minio.host}")
    private String host;

    @Value("${fileservice.storage.minio.login}")
    private String login;

    @Value("${fileservice.storage.minio.password}")
    private String password;

    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(host, login, password);
    }
}
