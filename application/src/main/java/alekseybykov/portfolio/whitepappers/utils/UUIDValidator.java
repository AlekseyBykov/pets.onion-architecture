//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.nonNull;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UUIDValidator {

    public static final String UUID_PATTERN =
            "^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$";

    private static final Pattern COMPILED_UUID_PATTERN =
            Pattern.compile(UUID_PATTERN.replaceAll("((^[\\^\\s]+)|([\\$\\s]+$))", StringUtils.EMPTY));

    public static boolean isValidUuid(Serializable uuid) {
        return nonNull(uuid) && COMPILED_UUID_PATTERN.matcher((String)uuid).matches();
    }

    public static String extractUuid(String string) {
        String uuid = StringUtils.EMPTY;
        Matcher matcher = COMPILED_UUID_PATTERN.matcher(string);
        while (matcher.find()) {
            uuid = matcher.group(NumberUtils.INTEGER_ZERO);
        }
        return uuid;
    }

    public static String removeUuid(String string) {
        String result = StringUtils.EMPTY;
        Matcher matcher = COMPILED_UUID_PATTERN.matcher(string);
        while (matcher.find()) {
            String uuid = matcher.group(NumberUtils.INTEGER_ZERO);
            if (StringUtils.isNotBlank(uuid)) {
                result = string.replaceAll(uuid, StringUtils.EMPTY);
            }
        }
        return result;
    }
}
