package com.zju.mobilepaymentapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.raw;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.zju.mobilepaymentapp.data.Constants.TRANS_TYPE;
import com.zju.mobilepaymentapp.data.DummyContent;
import com.zju.mobilepaymentapp.data.DummyContent.TransDetailItem;

/**
 * A fragment representing a single Transaction detail screen. This fragment is
 * either contained in a {@link TransactionListActivity} in two-pane mode (on
 * tablets) or a {@link TransactionDetailActivity} on handsets.
 */
public class TransactionDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public TransactionDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_transaction_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			ListView list = (ListView) rootView.findViewById(R.id.transaction_listview);
			if(list == null) Log.d("Debug", "list_empty");
			SimpleAdapter adapter = new SimpleAdapter(getActivity(),getData(),R.layout.key_value_item,
					new String[]{"key","value"},
					new int[]{R.id.key_item, R.id.value_item});
			list.setAdapter(adapter);
		}

		return rootView;
	}
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		
		TransDetailItem mDetail = mItem.details;
		map = new HashMap<String, Object>();
		map.put("key", getResources().getString(R.string.transaction_title)+": ");
		map.put("value", mItem.title);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("key", getResources().getString(R.string.transaction_type)+": ");
		map.put("value", mDetail.type);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("key", getResources().getString(R.string.transaction_state)+": ");
		map.put("value", mDetail.state);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("key", getResources().getString(R.string.transaction_order_time)+": ");
		map.put("value", mItem.time);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("key", getResources().getString(R.string.transaction_seller)+": ");
		map.put("value", mDetail.seller);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("key", getResources().getString(R.string.transaction_price)+": ");
		map.put("value", mDetail.price);
		list.add(map);
		
		if(mDetail.payTime != null){
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.transaction_pay_time)+": ");
			map.put("value", mDetail.payTime);
			list.add(map);
		}
		
		if(mDetail.deliveryTime != null){
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.transaction_deliver_time)+": ");
			map.put("value", mDetail.deliveryTime);
			list.add(map);
		}
		
		if(mDetail.confirmTime != null){
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.transaction_confirm_time)+": ");
			map.put("value", mDetail.confirmTime);
			list.add(map);
		}
		
		if(mDetail.type == TRANS_TYPE.FLIGHT){
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.flight)+"\n"+getResources().getString(R.string.detail));
			map.put("value", "");
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.flight_number)+": ");
			map.put("value", mDetail.flightNumber);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.flight_company)+": ");
			map.put("value", mDetail.flightCompany);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.flight_origin_city)+": ");
			map.put("value", mDetail.originCity);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.flight_origin_airport)+": ");
			map.put("value", mDetail.originAirport);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.flight_dest_city)+": ");
			map.put("value", mDetail.destCity);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.flight_dest_airport)+": ");
			map.put("value", mDetail.destAirport);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.flight_takeoff_time)+": ");
			map.put("value", mDetail.takeoffTime);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.flight_arrival_time)+": ");
			map.put("value", mDetail.arrivalTime);
			list.add(map);
		}
		else if(mDetail.type == TRANS_TYPE.FLIGHT){
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.hotel)+"\n"+getResources().getString(R.string.detail));
			map.put("value", "");
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.hotel_name)+": ");
			map.put("value", mDetail.hotelName);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.hotel_address)+": ");
			map.put("value", mDetail.hotelAddress);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.hotel_phone)+": ");
			map.put("value", mDetail.hotelPhone);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.hotel_room_type)+": ");
			map.put("value", mDetail.roomType);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.hotel_checkin_date)+": ");
			map.put("value", mDetail.checkinDate);
			list.add(map);
			
			map = new HashMap<String, Object>();
			map.put("key", getResources().getString(R.string.hotel_checkout_date)+": ");
			map.put("value", mDetail.checkoutDate);
			list.add(map);

		}

		
		
//		for(int i=0; i<DummyContent.ITEMS.size(); i++){
//			map = new HashMap<String, Object>();
//			map.put("title", DummyContent.ITEMS.get(i).title);
//			map.put("price", DummyContent.ITEMS.get(i).price);
//			map.put("time", DummyContent.ITEMS.get(i).time);
//			map.put("state", DummyContent.ITEMS.get(i).state);
//			list.add(map);
//		}
//		map.put("title", "G1");
//		map.put("info", "google 1");
//		//map.put("img", R.drawable.i1);
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		map.put("title", "G2");
//		map.put("info", "google 2");
//		//map.put("img", R.drawable.i2);
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		map.put("title", "G3");
//		map.put("info", "google 3");
//		//map.put("img", R.drawable.i3);
//		list.add(map);
		
		return list;
	}
}
