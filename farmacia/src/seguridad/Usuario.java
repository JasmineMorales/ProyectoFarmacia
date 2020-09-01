/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad;

/**
 *Clase de tipo usuario utilizado para el manejo de acceso en el programa
 * @author aliciarroyave
 */
public class Usuario {
    private int nivelAcceso, userId;//almacena el codigo de nivel de acceso
    private String UserName, tipoUser, direccion;//almacena nombre y tipo de usuario
    private float salario, prestaciones;

    public Usuario(int nivelAcceso, int userId, String UserName, String tipoUser, String direccion, float salario, float prestaciones) {
        this.nivelAcceso = nivelAcceso;
        this.userId = userId;
        this.UserName = UserName;
        this.tipoUser = tipoUser;
        this.direccion = direccion;
        this.salario = salario;
        this.prestaciones = prestaciones;
    }
    
    public Usuario(int nivelAcceso, int userId, String UserName, String tipoUser) {
        this.nivelAcceso = nivelAcceso;
        this.userId = userId;
        this.UserName = UserName;
        this.tipoUser = tipoUser;
    }

    public String getDireccion() {
        return direccion;
    }

    public float getSalario() {
        return salario;
    }

    public float getPrestaciones() {
        return prestaciones;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setPrestaciones(float prestaciones) {
        this.prestaciones = prestaciones;
    }
    

    

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public String getUserName() {
        return UserName;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public int getUserId() {
        return userId;
    }
    
}
