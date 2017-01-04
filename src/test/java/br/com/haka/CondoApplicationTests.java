package br.com.haka;

import br.com.haka.domain.entity.ApartmentManagerToken;
import br.com.haka.domain.repository.Meetings;
import br.com.haka.domain.service.ApartmentManagerRegisterService;
import br.com.haka.domain.service.ApartmentManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback//Used this for cancel transaction
public class CondoApplicationTests {

    @Autowired
    private ApartmentManagerService apartmentManagerService;


    @Autowired
    private ApartmentManagerRegisterService createApartmentManager;

    @Autowired
    private Meetings meetings;

    @Test
    public void testeDoRepositorio() {
        boolean b = meetings.create(null, null, null, null);
        Assert.assertNotNull(b);
        Assert.assertFalse(b);
    }


    @Test
    public void bookaMeeting() {
        ApartmentManagerToken apartmentManagerToken = ApartmentManagerToken.createApartmentManager("usuario", "senha");
        createApartmentManager.create(apartmentManagerToken, "test");
        Assert.assertNotNull(apartmentManagerToken);

        //I'm as a apartment manager need booking a meeting
        String tema = "Tema para Teste APENAS!!";
        String local = "Rua das Camelias Azuis, 89765, Bairro Barro, Cidade do Estado";
        Date data = Calendar.getInstance().getTime(); //TODO fazer estudo sobre a diferença de date e calendar
        Assert.assertNotNull(apartmentManagerService.scheduleMeeting(apartmentManagerToken, data, local, tema));
        Assert.assertTrue(apartmentManagerService.scheduleMeeting(apartmentManagerToken, data, local, tema));


        // Validação das Rotas
        //String pathPararedirecionamento = servicoDeSindicos.agendarAssembleia(sindico, data, local, tema);
        //Assert.assertEquals(pathPararedirecionamento, "/paginaOuTemplate.html");

    }

}
