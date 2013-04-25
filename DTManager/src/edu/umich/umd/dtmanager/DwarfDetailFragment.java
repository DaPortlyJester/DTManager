package edu.umich.umd.dtmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.umich.umd.dtmanager.Dwarf.Dwarf;
import edu.umich.umd.dtmanager.dummy.DummyContent;

/**
 * A fragment representing a single Dwarf detail screen. This fragment is either
 * contained in a {@link DwarfListActivity} in two-pane mode (on tablets) or a
 * {@link DwarfDetailActivity} on handsets.
 */
public class DwarfDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_DWARF_ID = "dwarf_name";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private Dwarf mItem;
	
	private TextView detailView;
	private ImageView dwarfImage;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public DwarfDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
	 	super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_DWARF_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DwarfContainer.dwarf_map.get(getArguments().getString(
					ARG_DWARF_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_dwarf_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			//dwarfImage = (ImageView)rootView.findViewById(R.id.d_pic);
			//dwarfImage.setImageDrawable(getResources().getDrawable(R.drawable.dwarves));
			detailView = (TextView) rootView.findViewById(R.id.d_name);
			detailView.setText("Name: " + mItem.getName());
			detailView = (TextView) rootView.findViewById(R.id.d_sex);
			detailView.setText("Sex: " + mItem.getSex());
			detailView = (TextView) rootView.findViewById(R.id.d_age);
			detailView.setText("Age: " + mItem.getAge());
			detailView = (TextView) rootView.findViewById(R.id.d_strength);
			detailView.setText("Strength: " + mItem.getStrength());
			detailView = (TextView) rootView.findViewById(R.id.d_agility);
			detailView.setText("Agility: " + mItem.getAgility());
			detailView = (TextView) rootView.findViewById(R.id.d_toughness);
			detailView.setText("Toughness: " + mItem.getToughness());
		}

		return rootView;
	}
}
