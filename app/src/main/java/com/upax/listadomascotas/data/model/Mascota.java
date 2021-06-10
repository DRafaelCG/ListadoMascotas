package com.upax.listadomascotas.data.model;

/**
 * Creamos nuestro pojo mascota
 */
public class Mascota {
    int id;
    String name;
    String origin;
    String reference_image_id;
    String temperament;

    /* Creamos el constructor vacio para instanciar nuestra clase*/
    /*No creamps el constructor con parámetros porque no se va a utilizar*/
    public Mascota() {
    }

    /*Creamos los getters y los setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getReference_image_id() {
        return reference_image_id;
    }

    public void setReference_image_id(String reference_image_id) {
        this.reference_image_id = reference_image_id;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }
}