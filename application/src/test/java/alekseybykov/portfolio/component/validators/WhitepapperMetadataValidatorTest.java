//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.validators;

import alekseybykov.portfolio.component.entities.WhitePapperMetadata;
import alekseybykov.portfolio.component.registries.WhitepapperMetadataRegistry;
import alekseybykov.portfolio.component.services.validator.Action;
import alekseybykov.portfolio.component.services.validator.ValidationException;
import alekseybykov.portfolio.component.services.validator.WhitepapperMetadataValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@DisplayName("Tests for metadata validation")
class WhitepapperMetadataValidatorTest {

    private final WhitepapperMetadataRegistry registry = mock(WhitepapperMetadataRegistry.class);
    private WhitepapperMetadataValidator validator = new WhitepapperMetadataValidator(registry);

    private final String validatorCanonicalName = WhitepapperMetadataValidator.class.getCanonicalName();

    @Test
    @DisplayName("Upload file without metadata")
    void testValidateNullMetadata() {
        WhitePapperMetadata metadata = null;
        ValidationException thrown = assertThrows(ValidationException.class,
                () -> validator.validate(metadata, Action.CREATE));

        assertEquals(thrown.getMessage(), format("%s: [%s]", validatorCanonicalName,
                "Metadata must be presented"));
    }
}
