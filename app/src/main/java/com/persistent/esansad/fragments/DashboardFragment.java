package com.persistent.esansad.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.persistent.esansad.CustomCard;
import com.persistent.esansad.R;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by ashwin_valento on 03-Feb-15.
 */
public class DashboardFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nav_section_1_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

       // super.onViewCreated(view, savedInstanceState);
        ArrayList<Card> cards = new ArrayList<>();

        for (int i=0;i<10;i++) {
            //Create a Card
            CustomCard card = new CustomCard(getActivity());

            //Create a CardHeader
            CardHeader header = new CardHeader(getActivity());
            //Add Header to card
            header.setTitle("Proposal "+i );
            card.addCardHeader(header);

            cards.add(card);
        }
        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(),cards);

        CardListView listView = (CardListView) getActivity().findViewById(R.id.myList);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);
        }
    }
}
