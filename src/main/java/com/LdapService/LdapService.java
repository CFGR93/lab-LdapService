package com.LdapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

@Service
public class LdapService {

    @Autowired
    private LdapTemplate ldapTemplate;

    public void cnnLdapConnection() {
        try {
            var lst = ldapTemplate.list("dc=example,dc=org");
            System.out.println(lst);
            System.out.println("Conexión LDAP exitosa.");
        } catch (Exception e) {
            System.err.println("Error al conectar con LDAP: " + e.getMessage());
        }
    }

    public void auth() {
        try {
            var result = ldapTemplate.authenticate("cn=test 1,ou=users,dc=example,dc=org", "objectClass=*", "Test789");
            System.out.println("Autenticación LDAP: "+ result);
        }
        catch (Exception e){
            System.err.println("Error al autenticar con LDAP: " + e.getMessage());
        }
    }
}
