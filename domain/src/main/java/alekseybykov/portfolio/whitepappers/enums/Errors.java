package alekseybykov.portfolio.whitepappers.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Errors {
    WHITEPAPPER_NOT_FOUND("Whitepapper not found"),
    DICTIONARY_ITEM_NOT_FOUND("Dictionary item not found");

    private final String name;
}
