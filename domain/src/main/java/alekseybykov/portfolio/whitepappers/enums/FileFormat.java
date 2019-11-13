package alekseybykov.portfolio.whitepappers.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FileFormat {
    DOCX("docx"),
    CSV("csv"),
    XLS("xls");

    private final String name;
}
