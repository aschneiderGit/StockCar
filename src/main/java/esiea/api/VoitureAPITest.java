package esiea.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc

class VoitureAPITest {

    @Mock
    private MockMvc mockMvc;


    @Test
    void databaseConnection() throws Exception {

    }

    @Test
    public void ajouterVoiture() throws Exception {
        VoitureAPI voitureApi = new VoitureAPI();
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(voitureApi);
        mockMvc.perform(MockMvcRequestBuilders.post("/voiture/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(result)
                )
                .andExpect(status().isOk());

    }


}
