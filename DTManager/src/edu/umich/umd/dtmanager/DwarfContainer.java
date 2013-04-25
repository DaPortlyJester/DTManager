package edu.umich.umd.dtmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.umich.umd.dtmanager.Dwarf.Dwarf;

public class DwarfContainer {
	
	public static ArrayList<Dwarf> dwarf_list;
	public static Map<String,Dwarf> dwarf_map = new HashMap<String,Dwarf>();
	
	
	public static void genNameList() {
		
		for(Dwarf d: dwarf_list){
			dwarf_map.put(d.getName(),d);
		}
		
	}

}
