package com.apply.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
import javax.persistence.ManyToMany;
>>>>>>> Stashed changes
=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of 9a9f669 (apply .71)
=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of b411413 (apply .67)
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "empleados")
public class Empleado  implements Serializable{

private static final long serialVersionUID= 1L;






@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String nombre;

@NotEmpty
private String apellido;


private String password;


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< Updated upstream
@OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
@JoinTable(name = "empleado_role", joinColumns = @JoinColumn(name = "empleado_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles;
=======
private List<Role> roles;
=======
private String role;
>>>>>>> parent of b411413 (apply .67)
=======
private String role;
>>>>>>> parent of b411413 (apply .67)

private boolean enabled;

<<<<<<< HEAD
<<<<<<< HEAD
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "autorities_empleados", joinColumns = @JoinColumn(name = "empleado_id"), inverseJoinColumns = @JoinColumn(name ="authority_id"))
private Set<Authority> authority;

public boolean isEnabled() {
    return enabled;
}
=======
private String role;

@OneToOne
private OrdenCompra ordenCompra;
=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of b411413 (apply .67)

>>>>>>> parent of b411413 (apply .67)

public void setEnabled(boolean enabled) {
    this.enabled = enabled;
}

<<<<<<< HEAD
<<<<<<< HEAD

<<<<<<< HEAD
>>>>>>> Stashed changes
=======
private String role;
>>>>>>> parent of b411413 (apply .67)
=======
@OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
@JoinTable(name = "empleado_role", joinColumns = @JoinColumn(name = "empleado_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles;
>>>>>>> parent of 9a9f669 (apply .71)

@OneToOne
private OrdenCompra ordenCompra;




=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of b411413 (apply .67)
public OrdenCompra getOrdenCompra() {
    return ordenCompra;
}

public void setOrdenCompra(OrdenCompra ordenCompra) {
    this.ordenCompra = ordenCompra;
}

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
=======
=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of b411413 (apply .67)
public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of 9a9f669 (apply .71)
=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of b411413 (apply .67)
=======
>>>>>>> parent of b411413 (apply .67)



@Column(unique = true)
@Email
private String correo;

@Column(name = "licencia_365")
private String licencia365;


private String  clasificacion;
@Column(name = "equipado", columnDefinition = "boolean default false")
private boolean  equipado = false;

/** */
@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
private List<Equipo> equipos;

@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Asignacion> asignaciones;

@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Factura> facturas;






public List<Factura> getFacturas() {
    return facturas;
}

public void setFacturas(List<Factura> facturas) {
    this.facturas = facturas;
}

public void addAsignacion(Asignacion asignacion){
    asignaciones.add(asignacion);
}

public List<Asignacion> getAsignaciones() {
    return asignaciones;
}

public void setAsignaciones(List<Asignacion> asignaciones) {
    this.asignaciones = asignaciones;
}

public List<Equipo> getEquipos() {
    return equipos;
}









public void setEquipos(List<Equipo> equipos) {
    this.equipos = equipos;
}



@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
private List<Ticket> tickets;



@PrePersist
public void prePersist(){

    
}








public Empleado(){
    tickets = new ArrayList<Ticket>();
    equipos = new ArrayList<Equipo>();
    asignaciones = new ArrayList<Asignacion>()  ;
}
    
    public Empleado(Long id, @NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty String password,
            @Email String correo, String licencia365, String clasificacion, @NotEmpty boolean equipado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.correo = correo;
        this.licencia365 = licencia365;
        this.clasificacion = clasificacion;
        this.equipado = equipado;
    }
    


public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}


public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellido() {
    return apellido;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getCorreo() {
    return correo;
}

public void setCorreo(String correo) {
    this.correo = correo;
}

public String getLicencia365() {
    return licencia365;
}

public void setLicencia365(String licencia365) {
    this.licencia365 = licencia365;
}

public String getClasificacion() {
    return clasificacion;
}

public void setClasificacion(String clasificacion) {
    this.clasificacion = clasificacion;
}

public boolean isEquipado() {
    return equipado;
}

public void setEquipado(boolean equipado) {
    this.equipado = equipado;
}

public List<Ticket> getTickets() {
    return tickets;
}

public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
}



public void addTicket(Ticket ticket){

    tickets.add(ticket);

}


public void addEquipo(Equipo equipo){

    equipos.add(equipo);
}

public void addOrdenCompra(OrdenCompra orden){

    this.ordenCompra = orden;

}


}

