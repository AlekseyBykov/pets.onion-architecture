package alekseybykov.portfolio.whitepappers.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileTransferObject {
    private String fileName;
    private InputStream stream;
}
