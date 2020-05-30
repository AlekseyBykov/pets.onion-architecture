package alekseybykov.portfolio.whitepappers.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileTransferObject {
    private String fileName;
    private InputStream stream;
}
