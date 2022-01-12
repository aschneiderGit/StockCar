package esiea.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import esiea.api.VoitureAPI;
import esiea.dao.VoitureDAO;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
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


// @RunWith(SpringRunner.class)
// @SpringBootTest
// @WebAppConfiguration
// @ContextConfiguration(initializers = VoitureDAOITest.Initializer.class)
// @AutoConfigureMockMvc

class VoitureDAOITest {
    // @Mock
    // private MockMvc mock;
    // @Mock private Connection mockConnection = mock(Connection.class);
    // @Mock private PreparedStatement mockStatement = mock(PreparedStatement.class);
    // @Mock private ResultSet resultSet = mock(ResultSet.class);

    // private static JdbcDatabase postgreSQLContainer;

    // @Before
    // public void setUp() throws Exception {
    //     postgreSQLContainer.start();
    //     mockStatic(DriverManager.class);
    //     when(DriverManager.getConnection(anyString(), anyString(), null)).thenReturn(mockConnection);
    // }
    // @ClassRule
    // public static PostgreSQLContainer PGSQL_CONTAINER= (postgreSQLContainer) new PostgreSQLContainer("postgres:12-alpine")
    //         .withDatabaseName("stockcar_test")
    //         .withUsername("root")
    //         .withPassword("root");


    // static class Initializer
    //     implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    //     public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
    //         // setup (postgreSQLContainer.getJdbcUrl()) as "hibernate.connection.url" here...
    //     }
    // }



}
