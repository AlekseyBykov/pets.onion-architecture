//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.e2e;

import alekseybykov.portfolio.component.e2e.base.IntegrationTestsBaseClass;
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
@DisplayName("Tests for dictionary controller")
class SomeDictionaryControllerE2ETest extends IntegrationTestsBaseClass {

    @Test
    @SneakyThrows
    @DisplayName("Get all the dictionary items")
    void getAllDictionaryItems() {
        mockMvc.perform(get("/some-dictionary")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].name", is("item 001")))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].name", is("item 002")))
                .andExpect(jsonPath("$.[2].id", is(3)))
                .andExpect(jsonPath("$.[2].name", is("item 003")))
                .andExpect(jsonPath("$.[3].id", is(4)))
                .andExpect(jsonPath("$.[3].name", is("item 004")))
                .andExpect(jsonPath("$.[4].id", is(5)))
                .andExpect(jsonPath("$.[4].name", is("item 005")))
                .andExpect(jsonPath("$.[5].id", is(6)))
                .andExpect(jsonPath("$.[5].name", is("item 006")))
                .andExpect(jsonPath("$.[6].id", is(7)))
                .andExpect(jsonPath("$.[6].name", is("item 007")))
                .andExpect(jsonPath("$.[7].id", is(8)))
                .andExpect(jsonPath("$.[7].name", is("item 008")))
                .andExpect(jsonPath("$.[8].id", is(9)))
                .andExpect(jsonPath("$.[8].name", is("item 009")))
                .andExpect(jsonPath("$.[9].id", is(10)))
                .andExpect(jsonPath("$.[9].name", is("item 010")));
    }
}
