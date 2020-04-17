/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musica.newpackage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Javi
 */
@Entity
@Table(name = "MUSICA")
@NamedQueries({
    @NamedQuery(name = "Musica_1.findAll", query = "SELECT m FROM Musica_1 m"),
    @NamedQuery(name = "Musica_1.findById", query = "SELECT m FROM Musica_1 m WHERE m.id = :id"),
    @NamedQuery(name = "Musica_1.findByAlbum", query = "SELECT m FROM Musica_1 m WHERE m.album = :album"),
    @NamedQuery(name = "Musica_1.findByCantante", query = "SELECT m FROM Musica_1 m WHERE m.cantante = :cantante"),
    @NamedQuery(name = "Musica_1.findByFechaLanzamiento", query = "SELECT m FROM Musica_1 m WHERE m.fechaLanzamiento = :fechaLanzamiento"),
    @NamedQuery(name = "Musica_1.findByPrecio", query = "SELECT m FROM Musica_1 m WHERE m.precio = :precio"),
    @NamedQuery(name = "Musica_1.findByFavorito", query = "SELECT m FROM Musica_1 m WHERE m.favorito = :favorito"),
    @NamedQuery(name = "Musica_1.findByFoto", query = "SELECT m FROM Musica_1 m WHERE m.foto = :foto")})
public class Musica_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ALBUM")
    private String album;
    @Column(name = "CANTANTE")
    private String cantante;
    @Column(name = "FECHA_LANZAMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaLanzamiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Column(name = "FAVORITO")
    private Boolean favorito;
    @Column(name = "FOTO")
    private String foto;
    @JoinColumn(name = "GENERO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Genero genero;

    public Musica_1() {
    }

    public Musica_1(Integer id) {
        this.id = id;
    }

    public Musica_1(Integer id, String album) {
        this.id = id;
        this.album = album;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musica_1)) {
            return false;
        }
        Musica_1 other = (Musica_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.musica.newpackage.Musica_1[ id=" + id + " ]";
    }
    
}
