package edu.umich.umd.dtmanager.Dwarf;

import android.os.Parcel;
import android.os.Parcelable;

public class Dwarf implements Parcelable{
	
	public Dwarf(){}
	
	public Dwarf(Parcel in) {
		readFromParcel(in);
	}
	
	private void readFromParcel(Parcel in) {

		name = in.readString();
		nickName = in.readString();
		sex = in.readString();
		age = in.readInt();
		
		strength = in.readInt();
		agility = in.readInt();
		toughness = in.readInt();
		endurance = in.readInt();
		recuperation = in.readInt();
		diseaseResistance = in.readInt();
		
		analyticalAbility = in.readInt();
		focus = in.readInt();
		willpower = in.readInt();
		creativity = in.readInt();
		intuition = in.readInt();
		patience = in.readInt();
		memory = in.readInt();
		linguisticAbility = in.readInt();
		spatialSense = in.readInt();
		musicality = in.readInt();
		kinaestheticSense = in.readInt();
		empathy = in.readInt();
		socialAwareness = in.readInt();

		
	}

	private String name;
	private String nickName;
	private String sex;
	private int age;
	
	private int strength;
	private int agility;
	private int toughness;
	private int endurance;
	private int recuperation;
	private int diseaseResistance;
	
	private int analyticalAbility;
	private int focus;
	private int willpower;
	private int creativity;
	private int intuition;
	private int patience;
	private int memory;
	private int linguisticAbility;
	private int spatialSense;
	private int musicality;
	private int kinaestheticSense;
	private int empathy;
	private int socialAwareness;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getToughness() {
		return toughness;
	}
	public void setToughness(int toughness) {
		this.toughness = toughness;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public int getRecuperation() {
		return recuperation;
	}
	public void setRecuperation(int recuperation) {
		this.recuperation = recuperation;
	}
	public int getDiseaseResistance() {
		return diseaseResistance;
	}
	public void setDiseaseResistance(int diseaseResistance) {
		this.diseaseResistance = diseaseResistance;
	}
	public int getAnalyticalAbility() {
		return analyticalAbility;
	}
	public void setAnalyticalAbility(int analyticalAbility) {
		this.analyticalAbility = analyticalAbility;
	}
	public int getFocus() {
		return focus;
	}
	public void setFocus(int focus) {
		this.focus = focus;
	}
	public int getWillpower() {
		return willpower;
	}
	public void setWillpower(int willpower) {
		this.willpower = willpower;
	}
	public int getCreativity() {
		return creativity;
	}
	public void setCreativity(int creativity) {
		this.creativity = creativity;
	}
	public int getIntuition() {
		return intuition;
	}
	public void setIntuition(int intuition) {
		this.intuition = intuition;
	}
	public int getPatience() {
		return patience;
	}
	public void setPatience(int patience) {
		this.patience = patience;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public int getLinguisticAbility() {
		return linguisticAbility;
	}
	public void setLinguisticAbility(int linguisticAbility) {
		this.linguisticAbility = linguisticAbility;
	}
	public int getSpatialSense() {
		return spatialSense;
	}
	public void setSpatialSense(int spatialSense) {
		this.spatialSense = spatialSense;
	}
	public int getMusicality() {
		return musicality;
	}
	public void setMusicality(int musicality) {
		this.musicality = musicality;
	}
	public int getKinaestheticSense() {
		return kinaestheticSense;
	}
	public void setKinaestheticSense(int kinaestheicSense) {
		this.kinaestheticSense = kinaestheicSense;
	}
	public int getEmpathy() {
		return empathy;
	}
	public void setEmpathy(int empathy) {
		this.empathy = empathy;
	}
	public int getSocialAwareness() {
		return socialAwareness;
	}
	public void setSocialAwareness(int socialAwareness) {
		this.socialAwareness = socialAwareness;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static final Parcelable.Creator<Dwarf> Creator = new Parcelable.Creator<Dwarf>() {
		
		public Dwarf createFromParcel(Parcel in){
			return new Dwarf(in);
		}
		
		public Dwarf[] newArray(int size){
			return new Dwarf[size];
		}
		
	};
	
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		 dest.writeString(name);
		 dest.writeString(nickName);
		 dest.writeString(sex);
		 dest.writeInt(age);
		
		 dest.writeInt(strength);
		 dest.writeInt(agility);
		 dest.writeInt(toughness);
		 dest.writeInt(endurance);
		 dest.writeInt(recuperation);
		 dest.writeInt(diseaseResistance);
		
		 dest.writeInt(analyticalAbility);
		 dest.writeInt(focus);
		 dest.writeInt(willpower);
		 dest.writeInt(creativity);
		 dest.writeInt(intuition);
		 dest.writeInt(patience);
		 dest.writeInt(memory);
		 dest.writeInt(linguisticAbility);
		 dest.writeInt(spatialSense);
		 dest.writeInt(musicality);
		 dest.writeInt(kinaestheticSense);
		 dest.writeInt(empathy);
		 dest.writeInt(socialAwareness);
		
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	


}
