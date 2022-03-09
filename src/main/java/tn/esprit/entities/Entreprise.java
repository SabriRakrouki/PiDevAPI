package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Entreprise extends User implements Serializable {
private int resgistrationNumber;
private String name;
private int Capacity;
	
@OneToMany(mappedBy = "entreprise")
@JsonIgnore
private Set<Employee> employees;

@OneToMany(mappedBy = "entreprise")
private Set<Complaint> complaints;





//@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//private Set<Domain> domains;


//@OneToMany(cascade = CascadeType.ALL)
//private Set<FeedBack> feedBacks;



}
