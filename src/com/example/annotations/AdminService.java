package com.example.annotations;

public class AdminService {

    @RequiresRole("ADMIN")
    public void deleteUser() {
        System.out.println("Utilisateur supprimé");
    }
}
