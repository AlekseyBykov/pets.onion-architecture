package alekseybykov.portfolio.whitepappers.utils;

import alekseybykov.portfolio.whitepappers.exceptions.WorkWithFilesException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import static java.util.Objects.nonNull;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
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
