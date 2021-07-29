package com.apply.Models;
<<<<<<< Updated upstream

import javax.persistence.Column;
=======
>>>>>>> Stashed changes
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< Updated upstream
@Entity
@Table(name = "roles")
public class Role {



    
    
public Role() {
    }

@Column(name = "role_id")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(name = "role")
private String role;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}
    

}
=======
@Table(name = "role")
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}

>>>>>>> Stashed changes
