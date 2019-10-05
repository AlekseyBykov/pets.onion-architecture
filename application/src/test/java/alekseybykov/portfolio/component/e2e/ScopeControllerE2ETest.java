//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.e2e;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-05
 */
@DisplayName("Tests for scope controller")
class ScopeControllerE2ETest extends IntegrationTestsBaseClass {

    @Test
    @SneakyThrows
    @DisplayName("Get all the scopes")
    void testGetNpaItems() {
        mockMvc.perform(get("/scope")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].name", is("First scope value")))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].name", is("Second scope value")));
    }
}
