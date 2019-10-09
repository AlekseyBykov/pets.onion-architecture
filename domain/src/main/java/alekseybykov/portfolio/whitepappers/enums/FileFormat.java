//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-06
 */
@Getter
@RequiredArgsConstructor
public enum FileFormat {
    DOCX("docx"),
    CSV("csv"),
    XLS("xls");

    private final String name;
}
