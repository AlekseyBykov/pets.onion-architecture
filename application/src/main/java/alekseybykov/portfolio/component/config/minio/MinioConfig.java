//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.config.minio;

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
    private String minioHost;

    @Value("${fileservice.storage.minio.accessKey}")
    private String minioAccessKey;

    @Value("${fileservice.storage.minio.secretKey}")
    private String minioSecretKey;

    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(minioHost, minioAccessKey, minioSecretKey);
    }
}
