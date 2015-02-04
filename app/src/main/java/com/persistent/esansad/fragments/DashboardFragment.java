package com.persistent.esansad.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.Legend;
import com.persistent.esansad.CustomCard;
import com.persistent.esansad.R;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardViewNative;

/**
 * Created by ashwin_valento on 03-Feb-15.
 */
public class DashboardFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        displayMPCard();
        initPieChart();
        displayCards();
       // super.onViewCreated(view, savedInstanceState);

    }

    private void displayMPCard() {

        //Create a Card
        MPHeaderCard card = new MPHeaderCard(getActivity());
        CardExpand expand = new CardExpand(getActivity());
        //Set inner title in Expand Area
        expand.setTitle("MP card information");
        //Add expand to a card
        card.addCardExpand(expand);



        card.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                if(card.isExpanded()) {
                    card.doCollapse();
                }else{
                    card.doExpand();
                }
            }
        });




        //Set card in the cardView
        CardViewNative cardView = (CardViewNative) getActivity().findViewById(R.id.mp_header);

        cardView.setCard(card);

    }


    private void displayCards(){
        ArrayList<Card> cards = new ArrayList<>();

        String proposaldescription = "this is a multi line description " +
                "this is a multi line description " +
                "this is a multi line description " +
                "this is a multi line description " +
                "this is a multi line description " +
                "this is a multi line description " +
                "this is a multi line description " +
                "this is a multi line description " +
                "this is a multi line description";

        for (int i=0;i<10;i++) {
            //Create a Card
            CustomCard card = new CustomCard(getActivity());

            //CARD ID = PROPOSAL ID
            card.setId(String.valueOf(i));

            CardExpand expand = new CardExpand(getActivity());

            //Set inner title in Expand Area
            expand.setTitle(i+ " " + proposaldescription);

            //Add expand to a card
            card.addCardExpand(expand);
            //Create a CardHeader
            CardHeader header = new CardHeader(getActivity());
            header.setButtonExpandVisible(true);
            //Add Header to card
            header.setTitle("Proposal "+i );
            card.addCardHeader(header);
            card.setSwipeable(true);
            cards.add(card);
        }
        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(),cards);

        mCardArrayAdapter.setEnableUndo(true);

        CardListView listView = (CardListView) getActivity().findViewById(R.id.myList);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);
        }
    }

    private void initPieChart(){


        PieChart chart = (PieChart) getActivity().findViewById(R.id.chart);

        chart.setDescription("Money Utilization");
        chart.setDrawYValues(true);

        ArrayList<Entry> valsComp1 = new ArrayList<Entry>();
        //ArrayList<Entry> valsComp2 = new ArrayList<Entry>();

        Entry c1e1 = new Entry(10.000f, 0); // 0 == quarter 1
        valsComp1.add(c1e1);
        Entry c1e2 = new Entry(50.000f, 1); // 1 == quarter 2 ...
        valsComp1.add(c1e2);
        Entry c2e1 = new Entry(20.000f, 2); // 0 == quarter 1
        valsComp1.add(c2e1);
        Entry c2e2 = new Entry(30.000f, 3); // 1 == quarter 2 ...
        valsComp1.add(c2e2);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("10");
        xVals.add("20");
        xVals.add("30");
        xVals.add("40");

        PieDataSet setComp1 = new PieDataSet(valsComp1, "Money");
        PieData data = new PieData(xVals, setComp1);
        chart.setData(data);
        //PieDataSet setComp2 = new PieDataSet(valsComp2, "Company 2");

        setComp1.setColors(new int[] { R.color.blue,R.color.red,R.color.green,R.color.darkorange }, getActivity());
        // sets colors for the dataset, resolution of the resource name to a "real" color is done internally
        //chart.setData(data);
        chart.setHoleColor(Color.rgb(235, 235, 235));
        chart.setHoleRadius(60f);
        chart.setDescription("Money Utilization");
        chart.setDrawYValues(true);
        chart.setDrawCenterText(true);
        chart.setDrawHoleEnabled(true);
        chart.setRotationAngle(0);
        // draws the corresponding description value into the slice
        chart.setDrawXValues(true);
        // enable rotation of the chart by touch
        chart.setRotationEnabled(true);
        // display percentage values
        chart.setUsePercentValues(true);
        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);
        // add a selection listener
        // mChart.setTouchEnabled(false);

        chart.setCenterText("Money Utilization");
        chart.animateXY(1500, 1500);
        // mChart.spin(2000, 0, 360);

        Legend l = chart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
    }

    class MPHeaderCard extends Card {
        protected TextView title;
        protected TextView description;
        protected ImageView profileImage;


        public MPHeaderCard(Context context) {
            this(context, R.layout.mp_header_layout);
        }

        public MPHeaderCard(Context context, int innerLayout) {
            super(context, innerLayout);
            init();
        }


        private void init(){

        }

        @Override
        public void setupInnerViewElements(ViewGroup parent, View view) {

            //Retrieve elements
            title = (TextView) parent.findViewById(R.id.text_mp_title);
            description = (TextView) parent.findViewById(R.id.text_mp_info);
            profileImage = (ImageView) parent.findViewById(R.id.image_mp_photo);

            if (title!=null)
                title.setText("This is the name of the MP");

            if (description!=null)
                description.setText("This is the description for MP");

            if (profileImage!=null)
                profileImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_rudsonlive));


        }
    }



}
