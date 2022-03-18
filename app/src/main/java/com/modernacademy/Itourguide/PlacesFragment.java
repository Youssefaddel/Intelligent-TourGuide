package com.modernacademy.Itourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlacesFragment extends Fragment {

    View view;
    ListAdapter listAdapter;
    ListView listView;

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.list, container, false);
        final ArrayList<List> places = new ArrayList<>();
        places.add(new List(R.drawable.pyramids1, R.string.item_1, R.string.item_1_1));
        places.add(new List(R.drawable.sphinx, R.string.item_2, R.string.item_2_2));
        places.add(new List(R.drawable.egyptianmuseum, R.string.item_3, R.string.item_3_3));
        places.add(new List(R.drawable.abusimbel, R.string.item_4, R.string.item_4_4));
        places.add(new List(R.drawable.karnak,R.string.item_5, R.string.item_5_5));
        places.add(new List(R.drawable.alexlibrary,R.string.item_6, R.string.item_6_6));
        places.add(new List(R.drawable.qaitbay,  R.string.item_7, R.string.item_7_7));
        places.add(new List(R.drawable.vallyofkings,R.string.item_8, R.string.item_8_8));
        places.add(new List(R.drawable.rasmuhammed,R.string.item_9, R.string.item_9_9));
        places.add(new List(R.drawable.stcatherines,R.string.item_10, R.string.item_10_10));

        listAdapter = new ListAdapter(getActivity(), places);
        listView = (ListView) view.findViewById(R.id.places_list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    double latitude =29.979235;
                    double longitude =31.134201;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }
                else if(position==1){

                    double latitude =30.060480;
                    double longitude =31.208590;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }
                else if(position==2){

                    double latitude =24.039250;
                    double longitude =32.888750;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }                else if(position==3){

                    double latitude =22.351680;
                    double longitude =31.610230;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }                else if(position==4){

                    double latitude =30.993139;
                    double longitude =29.837030;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }                else if(position==5){

                    double latitude =31.197730;
                    double longitude =29.892540;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }                else if(position==6){

                    double latitude =30.045150;
                    double longitude =31.273260;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }                else if(position==7){

                    double latitude =29.997730;
                    double longitude =32.492430;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }                else if(position==8){

                    double latitude =27.793950;
                    double longitude =34.176920;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }
                else if(position==9){

                    double latitude =28.556260;
                    double longitude =33.974820;
                    String label = "I'm Here!";
                    String uriBegin = "geo:" + latitude + "," + longitude;
                    String query = latitude + "," + longitude + "(" + label + ")";
                    String encodedQuery = Uri.encode(query);
                    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                    Uri uri = Uri.parse(uriString);
                    Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(mapIntent);
                }
            }
        });
        return view;

    }
}
