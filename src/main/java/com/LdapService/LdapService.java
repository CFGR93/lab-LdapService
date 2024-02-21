package com.LdapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void findUser(String username) {
        try {
            List<String> results = ldapTemplate.search(
                    "dc=example,dc=org", // Base de la búsqueda, puede ser vacía para usar la base predeterminada
                    "(cn=" + username + ")", // Filtro de búsqueda
                    (AttributesMapper<String>) attrs -> attrs.get("cn").get().toString() // Mapeador de atributos
            );

            if (results.isEmpty()) {
                System.out.println("Usuario no encontrado");
            } else {
                System.out.println("Usuarios encontrados:");
                for (String result : results) {
                    System.out.println(result);
                }
            }
        }
        catch (Exception e){
            System.err.println("Error al autenticar con LDAP: " + e.getMessage());
        }
    }
}
