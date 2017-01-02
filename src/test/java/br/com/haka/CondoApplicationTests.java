package br.com.haka;

import br.com.haka.domain.entity.ApartmentManager;
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
@Rollback//coloco isso para que as transações sejam canceladas
public class CondoApplicationTests {

    @Autowired
    private ApartmentManagerService apartmentManagerService;


    private ApartmentManagerToken apartmentManager;


    private ApartmentManagerRegisterService createApartmentManager;

    @Autowired
    private Meetings meetings;

    @Test
    public void testeDoRepositorio(){
        boolean b = meetings.create(null, null, null, null);
        Assert.assertNotNull(b);
        Assert.assertFalse(b);
    }


	@Test
	public void agendarAssembleia() {
        apartmentManager = ApartmentManagerToken.createApartmentManager("usuario", "senha");
        createApartmentManager.create(apartmentManager, "test");
        Assert.assertNotNull(apartmentManager);
        //sindico -> agendar assembleias
        String tema = "Tema para Teste APENAS!!";
        String local = "Rua das Camelias Azuis, 89765, Bairro Barro, Cidade do Estado";
        Date data = Calendar.getInstance().getTime(); // fazer estudo sobre a diferença de date e calendar
        Assert.assertNotNull(apartmentManagerService.scheduleMeeting(apartmentManager, data, local, tema));
        Assert.assertTrue(apartmentManagerService.scheduleMeeting(apartmentManager, data, local, tema));
       // Assert.assertFalse(apartmentManagerService.scheduleMeeting(apartmentManager, data, local, tema));

        // Validação das Rotas
        //String pathPararedirecionamento = servicoDeSindicos.agendarAssembleia(sindico, data, local, tema);
        //Assert.assertEquals(pathPararedirecionamento, "/paginaOuTemplate.html");

    }

}
