package br.com.haka.domain.entity;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: Tiago Magalhães
 * Date: 12/12/16
 * Time: 11:05 PM
 * <p/>
 * Responsabilidade:
 */

public class ApartmentManager {
    private String name;
    private ApartmentManagerToken token;

    private ApartmentManager() {
    }

    public static ApartmentManager createApartmentManager() {
        return new ApartmentManager();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApartmentManagerToken getToken() {
        return token;
    }

    public void setToken(ApartmentManagerToken token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj instanceof String ){
            return this.getToken().equals((String) obj);
        }

        return super.equals(obj);
    }
}
