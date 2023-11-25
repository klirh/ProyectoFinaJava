package models;

public class Genero {

        private Login id;
        private String nombre;
        public Genero(Login id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
        public Login getId() {
            return id;
        }
        public void setId(Login id) {
            this.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }





    
} 
