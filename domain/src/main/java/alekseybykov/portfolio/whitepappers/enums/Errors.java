package alekseybykov.portfolio.whitepappers.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
@Getter
@RequiredArgsConstructor
public enum Errors {
    WHITEPAPPER_NOT_FOUND("Whitepapper not found"),
    DICTIONARY_ITEM_NOT_FOUND("Dictionary item not found");

    private final String name;
}
