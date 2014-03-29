package com.thirdageopen.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "CARD")
public class Card {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "CARD_TYPE", joinColumns = { @JoinColumn(name = "card_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "type_id", referencedColumnName = "id") })
	private List<Type> types;

	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "CARD_FACTION", joinColumns = { @JoinColumn(name = "card_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "faction_id", referencedColumnName = "id") })
	private List<Faction> factions;

	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "CARD_SUBTYPE", joinColumns = { @JoinColumn(name = "card_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "subtype_id", referencedColumnName = "id") })
	private List<Subtype> subtypes;

	@Column(name = "cost")
	private String cose;

	@Column(name = "ability")
	private String ability;

	@Column(name = "flavor")
	private String flavor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public List<Faction> getFactions() {
		return factions;
	}

	public void setFactions(List<Faction> factions) {
		this.factions = factions;
	}

	public List<Subtype> getSubtypes() {
		return subtypes;
	}

	public void setSubtypes(List<Subtype> subtypes) {
		this.subtypes = subtypes;
	}

	public String getCose() {
		return cose;
	}

	public void setCose(String cose) {
		this.cose = cose;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	
}
