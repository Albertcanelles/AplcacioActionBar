package com.iesebre.DAM2.aplicaciocasa;

import java.util.Locale;


import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {
	
	 
	    public boolean onCreateOptionsMenu1(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;   
	    }
	    
	    @Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		        case R.id.menu_new:
		            Log.i("ActionBar", "Nuevo!");
		            return true;
		        case R.id.menu_save:
		            Log.i("ActionBar", "Guardar!");;
		            return true;
		        case R.id.menu_settings:
		            Log.i("ActionBar", "Settings!");;
		            return true;
		        default:
		            return super.onOptionsItemSelected(item);
		    }
		}

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
		
		Intent i = getIntent();
        int obrir = i.getIntExtra(Principal.identificadorIntent, -1);
        switch(obrir){
        case 1:
                mViewPager.setCurrentItem(0);
                break;
        case 2:
                mViewPager.setCurrentItem(1);
                break;
        case 3:
                mViewPager.setCurrentItem(2);
                break;

        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Fragment fragment2 = new DummySectionFragment2();
			Fragment fragment3 = new DummySectionFragment3();
			Fragment fragment4 = new DummySectionFragment4();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			args.putInt(DummySectionFragment2.ARG_SECTION_NUMBER, position + 2);
			args.putInt(DummySectionFragment3.ARG_SECTION_NUMBER, position + 3);
			args.putInt(DummySectionFragment4.ARG_SECTION_NUMBER, position + 4);
			fragment.setArguments(args);
			fragment2.setArguments(args);
			fragment4.setArguments(args);
			fragment4.setArguments(args);
			switch (position) {
			case 0:	
				
				return fragment;
			case 1:
			
				return fragment2;
			case 2:
				return fragment3;
			case 3:
				return fragment4;
			}
			return null;
		}

		@Override
		public int getCount() {
			// Show 4 total pages.
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}
			
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			
			return rootView;
		}
	}
	 public static class DummySectionFragment2 extends Fragment {
	        /**
	         * The fragment argument representing the section number for this
	         * fragment.
	         */
	        public static final String ARG_SECTION_NUMBER = "section_number";

	        public DummySectionFragment2() {
	        }

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                                 Bundle savedInstanceState) {
	            View rootView2 = inflater.inflate(R.layout.fragmented_main_dummy2, container, false);

	            return rootView2;
	        }
	    }
	 public static class DummySectionFragment3 extends Fragment {
	        /**
	         * The fragment argument representing the section number for this
	         * fragment.
	         */
	        public static final String ARG_SECTION_NUMBER = "section_number_3";

	        public DummySectionFragment3() {
	        }

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                                 Bundle savedInstanceState) {
	            View rootView3 = inflater.inflate(R.layout.fragmented_main_dummy3, container, false);

	            return rootView3;
	        }
	    }
	 
	 public static class DummySectionFragment4 extends Fragment {
	        /**
	         * The fragment argument representing the section number for this
	         * fragment.
	         */
	        public static final String ARG_SECTION_NUMBER = "section_number_4";

	        public DummySectionFragment4() {
	        }

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                                 Bundle savedInstanceState) {
	            View rootView4 = inflater.inflate(R.layout.fragmented_main_dummy4, container, false);

	            return rootView4;
	        }
	    }
	 
}
