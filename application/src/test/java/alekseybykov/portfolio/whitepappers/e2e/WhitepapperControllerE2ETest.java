package alekseybykov.portfolio.whitepappers.e2e;

import alekseybykov.portfolio.whitepappers.e2e.base.IntegrationTestsBaseClass;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Tests for whitepappers controller")
class WhitepapperControllerE2ETest extends IntegrationTestsBaseClass {

    private static String filesPath;

    @Value("${fileservice.storage.local.path}")
    void setPath(String path) {
        filesPath = path;
    }

    @AfterAll
    static void clearAll() {
        try {
            FileUtils.cleanDirectory(Paths.get(filesPath).toAbsolutePath().toFile());
        } catch (IOException e) {
            throw new RuntimeException("Error while cleaning the directory " + e);
        }
    }

    @Test
    @SneakyThrows
    @DisplayName("Upload file with metadata")
    @Transactional
    void testUploadFileWithMetadata() {
        MockMultipartFile mockMultipartFile = buildMockMultipartFile("file-sample_100kB.docx");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .multipart("/white-pappers/upload")
                .file(mockMultipartFile)
                .param("name", "Some test name")
                .param("type", "Some test type")
                .param("registrationNumber", "Some registration number")
                .param("registrationDate", LocalDate.now().toString())
                .param("dictItemId", "1")
                .param("dictItemName", "Some item name");

        mockMvc.perform(builder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", Matchers.notNullValue()));
    }

    @SneakyThrows
    private MockMultipartFile buildMockMultipartFile(String... fileNames) {
        String fileName = fileNames.length > 0 ? fileNames[0]: "file-sample_100kB.docx";
        InputStream is = new FileInputStream(Paths.get("tmp", fileName).toAbsolutePath().toString());
        return new MockMultipartFile(
            "file",
            fileName,
            "multipart/form-data",
            IOUtils.toByteArray(is)
        );
    }
}
