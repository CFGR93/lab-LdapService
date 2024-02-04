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
            ldapTemplate.list("");
            System.out.println("Conexión LDAP exitosa.");
        } catch (Exception e) {
            System.err.println("Error al conectar con LDAP: " + e.getMessage());
        }
    }
}
