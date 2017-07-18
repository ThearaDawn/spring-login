package com.springdb.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by t.daun on 7/17/2017.
 */
@Entity
@Table(name = "tbluser")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sec_usr_id")
    private Long id;

    @NotNull
    @Column(name="sec_usr_login")
    private String username;

    @NotNull
    @Column(name="sec_usr_desc")
    private String name;

    @Column(name="sec_usr_email")
    private String email;

    @Type(type = "text")
    @Column(name="sec_usr_pwd")
    private String sec_usr_pwd;

    @NotNull
    @Column(name="dt_cre")
    private Date dt_cre;

    @NotNull
    @Column(name="usr_cre")
    private String usr_cre;

    @NotNull
    @Column(name="dt_upd")
    private Date dt_upd;

    @NotNull
    @Column(name="usr_upd")
    private String usr_upd;

    @NotNull
    @Column(name="status")
    private boolean status;

    // roles
    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "tbluser_role", joinColumns = {@JoinColumn(name = "sec_usr_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    @Override
    public String getPassword() {
        return sec_usr_pwd;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassowrd = passwordEncoder.encode(password.trim());
        this.sec_usr_pwd = hashedPassowrd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDt_cre() {
        return dt_cre;
    }

    public void setDt_cre(Date dt_cre) {
        this.dt_cre = dt_cre;
    }

    public String getUsr_cre() {
        return usr_cre;
    }

    public void setUsr_cre(String usr_cre) {
        this.usr_cre = usr_cre;
    }

    public Date getDt_upd() {
        return dt_upd;
    }

    public void setDt_upd(Date dt_upd) {
        this.dt_upd = dt_upd;
    }

    public String getUsr_upd() {
        return usr_upd;
    }

    public void setUsr_upd(String usr_upd) {
        this.usr_upd = usr_upd;
    }

}

