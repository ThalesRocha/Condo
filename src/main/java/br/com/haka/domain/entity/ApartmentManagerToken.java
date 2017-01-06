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
    private String user;
    private String password;

    private ApartmentManagerToken(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static ApartmentManagerToken createApartmentManager(String user, String password) {
        return new ApartmentManagerToken(user, password);
    }
/*
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String){
            return this.token.equals((String) obj);
        }
        return super.equals(obj);
    }*/




}
