package alekseybykov.portfolio.whitepappers.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aleksey Bykov
 * @since 06.10.2019
 */
@Getter
@RequiredArgsConstructor
public enum FileFormat {
    DOCX("docx"),
    CSV("csv"),
    XLS("xls");

    private final String name;
}
