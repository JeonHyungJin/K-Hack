package com.example.qpdjg.all_for.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qpdjg.all_for.Adater.CategoryDetailAdapter;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Item.CategoryDetailItem;
import com.example.qpdjg.all_for.R;

import java.util.ArrayList;
import java.util.*;

public class CategoryDetailFragment extends Fragment {
    String toCall;
    TextView detail;
    ListView detail_list;
    CustomViewPager viewPager;
    TextView detail_explain;
    CategoryDetailAdapter categoryDetailAdapter;
    Locale lang;
    ArrayList<CategoryDetailItem> data  = new ArrayList<CategoryDetailItem>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_cataory_detail, container, false);
        detail = (TextView)linearLayout.findViewById(R.id.detail);
        detail_list = (ListView)linearLayout.findViewById(R.id.detail_list);
        categoryDetailAdapter = new CategoryDetailAdapter(getContext(),R.layout.item_detail,data,viewPager);
        detail_explain = (TextView)linearLayout.findViewById(R.id.detail_explain);
        detail_list.setAdapter(categoryDetailAdapter);
        return linearLayout;
    }

    public void setToCall(String toCall) {

        this.toCall = toCall;
        detail.setText(toCall);

        Locale systemLocale = getResources().getConfiguration().locale;
        String strLanguage = systemLocale.getLanguage();
        if(toCall == "transport"){
            if(strLanguage == "ko"){
                detail_explain.setText("한국의 대중교통을 이용하는데 도움을 주는 앱 들이다.");
            }else if(strLanguage == "en") {
                detail_explain.setText("It helps you to use public transportation in Korea.");
            }else if (strLanguage == "ja"){
                detail_explain.setText("韓国の大衆交通を利用するのに役をするアプリである。");
            }else if (strLanguage == "zh"){
                detail_explain.setText("这个应用程序可以帮助您在韩国使用公共交通。");
            }
        }else if(toCall == "restaurant"){
            if(strLanguage == "ko"){
                detail_explain.setText("사용자에게 맛있고 유명한 식당을 추천하거나, 사용자가 원하는 메뉴 또는 해당 지역의 유명하고 맛있는 음식점을 추천해 준다. 또한 가고자 하는 식당을 방문했던 사람들의 평가도 확인 할 수 있다.");
            }else if(strLanguage == "en") {
                detail_explain.setText("Recommend a delicious and famous restaurant to the user, or recommend the menu or the famous and delicious restaurant in your area. You can also check the ratings of the people who visited the restaurant you want to go to.");
            }else if (strLanguage == "ja"){
                detail_explain.setText("使用者においしくて有名なレストランを推薦したり、使用者が望むメニューまたは該当地域の有名したり、おいしい飲食店を薦めてくれる。 また、行こうとする食堂を訪問した人々の評価も確認することができる。");
            }else if (strLanguage == "zh"){
                detail_explain.setText("为了用户推荐美味而著名的餐厅，以及推荐有用户想要的饮食的餐厅或者您所在地区的著名美味的餐厅。您还可以查看访问过您要去的餐厅的人的评分。");
            }
        }else if(toCall == "delivery"){
            if(strLanguage == "ko"){
                detail_explain.setText("한국의 독특한 문화로써 전화나 앱을 사용하여 음식을 주문하면  음식을 원하는 장소로 가져다준다. 또한 늦은 밤까지도 배달이 가능하며 앱 자체 내에서 할인을 받을 수 있다.");
            }else if(strLanguage == "en") {
                detail_explain.setText("As a unique Korean culture, when you order food using a phone or app, bring the food to the place where you want. You can also deliver it late into the night and get a discount within the app itself.");
            }else if (strLanguage == "ja"){
                detail_explain.setText("韓国の独特な文化として電話やアプリを使用し、料理を注文すると、食べ物を望む場所にもたらす。 また、遅い夜まで配達が可能で、アプリ自体内で割引を受けることができる。");
            }else if (strLanguage == "zh"){
                detail_explain.setText("送餐是一种独特的韩国文化，用电话或应用程序订购食物，那把食物带到您想要的地方，并且您也可以将它送到甚至在深夜。还有在应用程序上可以获得折扣。");
            }
        }else if(toCall == "property"){
            if(strLanguage == "ko"){
                detail_explain.setText("장기간 생활이나 일정기간동안 생활하려는 방들을 알아보는데 도움을 주는 앱으로써 부동산을 가지 않아도 구하고자 하는 방의 가격, 특징을 미리 비교 할 수 있다.");
            }else if(strLanguage == "en") {
                detail_explain.setText("You can compare the price and features of the room you want to save without having to make a real estate as an app that will help you to find rooms to live for a long time or for a certain period of time");
            }else if (strLanguage == "ja"){
                detail_explain.setText("장기간 생활이나 일정기간동안 생활하려는 방들을 알아보는데 도움을 주는 앱으로써 부동산을 가지 않아도 구하고자 하는 방의 가격, 특징을 미리 비교 할 수 있다.");
            }else if (strLanguage == "zh"){
                detail_explain.setText("这应用程序是一种帮助您决定仅存在于韩国的住处. 您可以预先比要借房子的价格和特点。");
            }
        }else if(toCall == "travel"){
            if(strLanguage == "ko"){
                detail_explain.setText("한국에 있는 유명 관광지들을 소개 및 안내 해주는 앱으로써 사용자가 특정 지역의 관광지를 알아보려하면 관광코스를 추천해 줄 뿐 만 아니라 이미 다녀갔던 사람들의 리뷰, 주요 먹거리 등을 확인 할 수 있다.");
            }else if(strLanguage == "en") {
                detail_explain.setText("As an app that introduces and shows famous tourist attractions in Korea, users can check out sightseeing places in a specific area, as well as reviews and main food items of people who have already visited.");
            }else if (strLanguage == "ja"){
                detail_explain.setText("한국에 있는 유명 관광지들을 소개 및 안내 해주는 앱으로써 사용자가 특정 지역의 관광지를 알아보려하면 관광코스를 추천해 줄 뿐 만 아니라 이미 다녀갔던 사람들의 리뷰, 주요 먹거리 등을 확인 할 수 있다.");
            }else if (strLanguage == "zh"){
                detail_explain.setText("这应用程序介绍和展示韩国著名旅游景点，用户可以查看特定区域的观光景点和已经访问过的人的评论和吃过的食品");
            }
        }
        categoryDetailAdapter.setData(data);
        categoryDetailAdapter.notifyDataSetChanged();
    }
    public void setViewPager(CustomViewPager viewPager) {
        this.viewPager = viewPager;
    }

}
