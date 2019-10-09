//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.validator;

import alekseybykov.portfolio.component.entities.Whitepapper;
import alekseybykov.portfolio.component.entities.WhitepapperMetadata;
import alekseybykov.portfolio.component.registries.WhitepapperMetadataRegistry;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Collection;

import static java.util.Objects.isNull;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Component
@RequiredArgsConstructor
public class WhitepapperMetadataValidator extends AbstractValidator<WhitepapperMetadata> {

    private final WhitepapperMetadataRegistry whitepapperMetadataRegistry;

    @Override
    protected void validate(WhitepapperMetadata metadata, Action action, Collection<String> errors) {

        final int MAX_NAME_SIZE = 500;
        final int MAX_REG_NUMBER_SIZE = 50;
        final int MAX_TYPE_SIZE = 100;

        if (isNull(metadata)) {
            errors.add("Metadata must be presented");
        } else {
            String name = metadata.getName();
            String type = metadata.getType();
            String regNumber = metadata.getRegistrationNumber();

            if (StringUtils.isEmpty(StringUtils.trimWhitespace(name))) {
                errors.add("The name is mandatory field");
            } else if (name.length() > MAX_NAME_SIZE) {
                errors.add("The name cannot contain more than 500 characters");
            }

            if (StringUtils.isEmpty(StringUtils.trimWhitespace(regNumber))) {
                errors.add("The registration number is mandatory field");
            } else if (regNumber.length() > MAX_REG_NUMBER_SIZE) {
                errors.add("The registration number cannot contain more than 500 characters");
            }

            if (StringUtils.isEmpty(StringUtils.trimWhitespace(type))) {
                errors.add("The type is mandatory field");
            } else if (type.length() > MAX_TYPE_SIZE) {
                errors.add("The type cannot contain more than 100 characters");
            }

            validateLocalDate(metadata.getRegistrationDate(), errors);
            validateForExistingWhitepapper(metadata, errors);
        }
    }

    private void validateLocalDate(LocalDate date, Collection<String> errors) {
        if (isNull(date)) {
            errors.add("The data is mandatory field");
        } else {
            if (date.isAfter(LocalDate.now())) {
                errors.add("The presented date must not exceed the current date");
            }
        }
    }

    private void validateForExistingWhitepapper(WhitepapperMetadata metadata, Collection<String> errors) {
        Whitepapper whitepapper = metadata.getWhitepapper();
        Long id = isNull(whitepapper) ? NumberUtils.LONG_MINUS_ONE : whitepapper.getId();
        whitepapperMetadataRegistry
                .findExistingWhitepapperMetadata(id, metadata.getRegistrationNumber(), metadata.getRegistrationDate())
                .ifPresent(e -> errors.add(
                        "White paper already exists. Check data and upload new one."));
    }
}
