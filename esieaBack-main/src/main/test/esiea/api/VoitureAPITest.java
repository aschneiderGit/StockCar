/*
package esiea.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import esiea.api.VoitureAPI;
import esiea.dao.VoitureDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration()

class VoitureAPITest {
    @Mock
    private MockMvc mock;
    @Mock private Connection mockConnection = mock(Connection.class);
    @Mock private PreparedStatement mockStatement = mock(PreparedStatement.class);
    @Mock private ResultSet resultSet = mock(ResultSet.class);
    @InjectMocks
    private static VoitureDAO voitureDAO = new VoitureDAO("test_url", "test_username");


    @Before
    public void setUp() throws Exception {
        mockStatic(DriverManager.class);
        when(DriverManager.getConnection(anyString(), anyString(), null)).thenReturn(mockConnection);
    }

    @Test
    void testQueryDatabase() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(resultSet);
        when(resultSet.getInt(Mockito.anyInt())).thenReturn(1);
        when(resultSet.getString(anyInt())).thenReturn("john smith");

        final Map<Integer, String> useridToUser = new HashMap<>();
        voitureDAO.modifierVoiture(1,voi);
        System.out.println(useridToUser);
    }
  */
/*  @Test
    public void ajouterVoiture() throws Exception {
        VoitureAPI voitureApi = new VoitureAPI();
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(voitureApi);
        mock
                .perform(MockMvcRequestBuilders.post("/voiture/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(result)
                )
                .andExpect(status().isOk());

    }*//*


}
*/
