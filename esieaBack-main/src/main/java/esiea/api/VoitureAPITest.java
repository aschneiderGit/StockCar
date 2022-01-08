package esiea.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration()

class VoitureAPITest {
    @Mock
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
       // this.mockMvc = MockMvcBuilders.webAppContextSetup()
    }
    @Test
    void databaseConnection() throws Exception {

    }

    @Test
    public void ajouterVoiture() throws Exception {
        VoitureAPI voitureApi = new VoitureAPI();
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(voitureApi);
        mockMvc
                .perform(MockMvcRequestBuilders.post("/voiture/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(result)
                )
                .andExpect(status().isOk());

    }

}