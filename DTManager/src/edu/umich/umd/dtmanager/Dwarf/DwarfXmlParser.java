package edu.umich.umd.dtmanager.Dwarf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class DwarfXmlParser {
	
	private static final String ns = null;
	
	public ArrayList<Dwarf> parse(InputStream in) throws XmlPullParserException, IOException {
		
		try{
			XmlPullParser dwarfParser = Xml.newPullParser();
			dwarfParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			dwarfParser.setInput(in, null);
			dwarfParser.nextTag();
			return readDwarfFile(dwarfParser);
		} finally {
			in.close();
		}
		
	}
	
	private ArrayList<Dwarf> readDwarfFile(XmlPullParser p)throws XmlPullParserException, IOException
	{
		ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
		
		p.require(XmlPullParser.START_TAG,ns,"Creatures");
		
		while(p.next() != XmlPullParser.END_TAG) {
			if(p.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = p.getName();
			if(name.equals("Creature")) {
				dwarves.add(readDwarf(p));
			} else {
				skip(p);
			}
		}
		return dwarves;
	}
	
	private Dwarf readDwarf(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Creature");
		
		Dwarf newDwarf = new Dwarf();
		
		while(p.next() != XmlPullParser.END_TAG) {
			if(p.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = p.getName();
			
			if(name.equals("Name")){
				newDwarf.setName(readName(p));
			} else if(name.equals("NickName")){
				newDwarf.setNickName(readNickname(p));
			} else if(name.equals("Sex")) {
				newDwarf.setSex(readSex(p));
			} else if (name.equals("Age")) {
				newDwarf.setAge(readAge(p));
			} else if(name.equals("Attributes")) {
				newDwarf = readAttributes(p,newDwarf);
			} else {
				skip(p);
			}
		}
		
		return newDwarf;
		
		
	}

	private void skip(XmlPullParser p) throws XmlPullParserException, IOException {
		if (p.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (p.next()) {
            case XmlPullParser.END_TAG:
                    depth--;
                    break;
            case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
		
	}

	private Dwarf readAttributes(XmlPullParser p, Dwarf newDwarf) throws XmlPullParserException, IOException {
		
		p.require(XmlPullParser.START_TAG, ns, "Attributes");
		
		while(p.next() != XmlPullParser.END_TAG) {
			if(p.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = p.getName();
			
			if(name.equals("Strength")){
				newDwarf.setStrength(readStrength(p));
			} else if(name.equals("Agility")){
				newDwarf.setAgility(readAgility(p));
			} else if(name.equals("Toughness")) {
				newDwarf.setToughness(readToughness(p));
			} else if (name.equals("Endurance")) {
				newDwarf.setEndurance(readEndurance(p));
			} else if(name.equals("Recuperation")) {
				newDwarf.setRecuperation(readRecuperation(p));
			} else if(name.equals("DiseaseResistance")){
				newDwarf.setDiseaseResistance(readDiseaseResistance(p));
			} else if(name.equals("AnalyticalAbility")) {
				newDwarf.setAnalyticalAbility(readAnalyticalAbility(p));
			} else if (name.equals("Focus")) {
				newDwarf.setFocus(readFocus(p));
			} else if(name.equals("Willpower")) {
				newDwarf.setWillpower(readWillPower(p));
			} else if(name.equals("Creativity")){
				newDwarf.setCreativity(readCreativity(p));
			} else if(name.equals("Intuition")) {
				newDwarf.setIntuition(readIntuition(p));
			} else if(name.equals("Patience")) {
				newDwarf.setPatience(readPatience(p));
			} else if (name.equals("Memory")) {
				newDwarf.setMemory(readMemory(p));
			} else if(name.equals("LinguisticAbility")) {
				newDwarf.setLinguisticAbility(readLinguisticAbility(p));
			} else if(name.equals("SpatialSense")){
				newDwarf.setSpatialSense(readSpatialSense(p));
			} else if(name.equals("Musicality")) {
				newDwarf.setMusicality(readMusicality(p));
			} else if (name.equals("KinaestheticSense")) {
				newDwarf.setKinaestheticSense(readKinaestheticSense(p));
			} else if(name.equals("Empathy")) {
				newDwarf.setEmpathy(readEmpathy(p));
			} else if(name.equals("SocialAwareness")) {
				newDwarf.setSocialAwareness(readSocialAwareness(p));
			} else {
				skip(p);
			}
		}
		
		return newDwarf;
	}

	private int readIntuition(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Intuition");
		String intuition = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Intuition");
		return Integer.parseInt(intuition);
	}

	private int readStrength(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Strength");
		String strength = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Strength");
		return Integer.parseInt(strength);
	}

	private int readAgility(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Agility");
		String agility = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Agility");
		return Integer.parseInt(agility);
	}

	private int readToughness(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Toughness");
		String toughness = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Toughness");
		return Integer.parseInt(toughness);
	}

	private int readEndurance(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Endurance");
		String endurance = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Endurance");
		return Integer.parseInt(endurance);
	}

	private int readRecuperation(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Recuperation");
		String recuperation = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Recuperation");
		return Integer.parseInt(recuperation);
	}

	private int readDiseaseResistance(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "DiseaseResistance");
		String diseaseResistance = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "DiseaseResistance");
		return Integer.parseInt(diseaseResistance);
	}

	private int readAnalyticalAbility(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "AnalyticalAbility");
		String analyticalAbility = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "AnalyticalAbility");
		return Integer.parseInt(analyticalAbility);
	}

	private int readFocus(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Focus");
		String focus = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Focus");
		return Integer.parseInt(focus);
	}

	private int readWillPower(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Willpower");
		String willpower = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Willpower");
		return Integer.parseInt(willpower);
	}

	private int readCreativity(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Creativity");
		String creativity = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "creativity");
		return Integer.parseInt(creativity);
	}

	private int readPatience(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Patience");
		String patience = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Patience");
		return Integer.parseInt(patience);
	}

	private int readMemory(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Memory");
		String memory = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Memory");
		return Integer.parseInt(memory);
	}

	private int readLinguisticAbility(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "LinguisticAbility");
		String linguisticAbility = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "LinguisticAbility");
		return Integer.parseInt(linguisticAbility);
	}

	private int readSpatialSense(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "SpatialSense");
		String spatialSense = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "SpatialSense");
		return Integer.parseInt(spatialSense);
	}

	private int readMusicality(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Musicality");
		String musicality = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Musicality");
		return Integer.parseInt(musicality);
	}

	private int readKinaestheticSense(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "KinaestheticSense");
		String kinaestheticSense = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "KinaestheticSense");
		return Integer.parseInt(kinaestheticSense);
	}

	private int readEmpathy(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Empathy");
		String empathy = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Empathy");
		return Integer.parseInt(empathy);
	}

	private int readSocialAwareness(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "SocialAwareness");
		String socialAwareness = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "SocialAwareness");
		return Integer.parseInt(socialAwareness);
	}

	private int readAge(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Age");
		String age = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Age");
		return Integer.parseInt(age);
	}

	private String readSex(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Sex");
		String sex = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Sex");
		return sex;
	}

	private String readNickname(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Nickname");
		String nickname = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Nickname");
		return nickname;
	}

	private String readName(XmlPullParser p) throws XmlPullParserException, IOException {
		p.require(XmlPullParser.START_TAG, ns, "Name");
		String name = readText(p);
		p.require(XmlPullParser.END_TAG, ns, "Name");
		return name;
	}

	private String readText(XmlPullParser p) throws XmlPullParserException, IOException {
		String result = "";
        if (p.next() == XmlPullParser.TEXT) {
            result = p.getText();
            p.nextTag();
        }
        return result;
	}

}
