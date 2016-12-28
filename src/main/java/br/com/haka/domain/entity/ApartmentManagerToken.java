package br.com.haka.domain.entity;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: Tiago Magalhães
 * Date: 12/12/16
 * Time: 11:35 PM
 * <p/>
 * Responsabilidade:
 */
public class ApartmentManagerToken {
    private String token;

    private ApartmentManagerToken() {
    }

    public static ApartmentManagerToken createApartmentManager(String usuario, String senha) {
        return new ApartmentManagerToken();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String){
            return this.token.equals((String) obj);
        }
        return super.equals(obj);
    }
}
