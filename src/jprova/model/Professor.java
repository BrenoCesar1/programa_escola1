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
@Table(name = "professor")
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT a FROM Professor a"),
    @NamedQuery(name = "Professor.findById", query = "SELECT a FROM Professor a WHERE a.id = :id"),
    @NamedQuery(name = "Professor.findByDisciplina", query = "SELECT a FROM Professor a WHERE a.disciplina = :disciplina"),
    @NamedQuery(name = "Professor.findByNome", query = "SELECT a FROM Professor a WHERE a.nome = :nome"),
    @NamedQuery(name = "Professor.findByTelefone", query = "SELECT a FROM Professor a WHERE a.telefone = :telefone")})
    @SequenceGenerator(name = "professor_seq",
            sequenceName = "professor_seq", allocationSize = 20)
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue (strategy= GenerationType.AUTO, generator="SEQ_STORE")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "disciplina")
    private String disciplina;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;

    public Professor() {
    }

    public Professor(Integer id, String nome, String telefone, String disciplina) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.disciplina = disciplina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
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
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jprova.model.Professor[ id=" + id + " ]";
    }
    
}
