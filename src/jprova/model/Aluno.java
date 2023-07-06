/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jprova.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "aluno")
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findById", query = "SELECT a FROM Aluno a WHERE a.id = :id"),
    @NamedQuery(name = "Aluno.findByCurso", query = "SELECT a FROM Aluno a WHERE a.curso = :curso"),
    @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
    @NamedQuery(name = "Aluno.findByTelefone", query = "SELECT a FROM Aluno a WHERE a.telefone = :telefone")})
    @SequenceGenerator(name = "aluno_seq",
            sequenceName = "aluno_seq", allocationSize = 20)
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue (strategy= GenerationType.AUTO, generator="SEQ_STORE")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "curso")
    private String curso;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;

    public Aluno() {
    }

    public Aluno(Integer id) {
        this.id = id;
    }

    public Aluno(Integer id, String nome, String telefone, String curso) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.curso = curso;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jprova.model.Aluno[ id=" + id + " ]";
    }
    
}
