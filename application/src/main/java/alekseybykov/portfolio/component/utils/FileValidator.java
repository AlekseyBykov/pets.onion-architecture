//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.utils;

import alekseybykov.portfolio.component.exceptions.WorkWithFilesException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import static java.util.Objects.nonNull;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Component
public class FileValidator {

    @Value("${fileservice.file.max-size}")
    private Long fileMaxSize;

    public void validate(MultipartFile file) {
        if (file.getSize() > fileMaxSize) {
            throw new WorkWithFilesException("File size exceeded");
        }

        if (nonNull(file.getOriginalFilename()) && !file.getOriginalFilename().endsWith(".docx")) {
            throw new WorkWithFilesException("Not a DOCX file");
        }
    }
}
