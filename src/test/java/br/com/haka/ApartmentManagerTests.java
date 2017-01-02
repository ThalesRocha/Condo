package br.com.haka;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Users;
import br.com.haka.domain.service.ApartmentManagerService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentManagerTests {

    @Autowired
    private Users users;

    @Autowired
    private ApartmentManagerService apartmentManagerService;




    @Test //Eu como síndico devo ser capaz de remover usuários
    public void testeRemoverUsuario(){
        //Manda remover um usuario que nao existe
        Boolean removed = apartmentManagerService.removeUser("sindico", "usuario@email.com.br");
        Assert.assertNotNull(removed);
        Assert.assertFalse(removed);

        //cria um novo usuario
        User user = apartmentManagerService.createUser("usuario@email.com.br", "123", "chico_serra", false);
        Assert.assertNotNull(user);

        //buscar no repositorio para validar a persistencia
        user = users.findByLogin(user.getLogin());
        Assert.assertNotNull(removed);

        //mando remover e ele tem que ser removido
        removed = apartmentManagerService.removeUser("sindico", "usuario@email.com.br");
        Assert.assertNotNull(removed);
        Assert.assertTrue(removed);

        //busco o usuario removido e ele nao pode ser encontrado
        user = users.findByLogin(user.getLogin());
        Assert.assertNull(user);
    }


}
