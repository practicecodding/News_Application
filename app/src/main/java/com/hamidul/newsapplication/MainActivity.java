package com.hamidul.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    HashMap <String, String> hashMap;
    ArrayList < HashMap <String, String> > arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        newsDetails();

        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);

    }//onCreate=====================================================================================

    public class MyAdapter extends BaseAdapter {
        LayoutInflater layoutInflater;
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item,parent,false);

            LinearLayout layItem = myView.findViewById(R.id.layItem);
            ImageView itemImage = myView.findViewById(R.id.itemImage);
            TextView itemCat = myView.findViewById(R.id.itemCat);
            TextView itemTitle = myView.findViewById(R.id.itemTitle);
            TextView itemDes = myView.findViewById(R.id.itemDes);

            HashMap <String,String> hashMap1 = arrayList.get(position);
            String imageUrl = hashMap1.get("imageUrl");
            String cat = hashMap1.get("cat");
            String title = hashMap1.get("title");
            String des = hashMap1.get("des");

            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.hamidul)
                    .into(itemImage);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            itemCat.setBackgroundColor(color);

            itemCat.setText(cat);
            itemTitle.setText(title);
            itemDes.setText(des);

            layItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewsView.TITLE=title;
                    NewsView.DES=des;
                    Bitmap bitmap = ((BitmapDrawable) itemImage.getDrawable()).getBitmap();
                    NewsView.image = bitmap;

                    startActivity(new Intent(MainActivity.this,NewsView.class));
                }
            });

            return myView;
        }
    }

    private void newsDetails (){

//        hashMap = new HashMap<>();
//        hashMap.put("cat","");
//        hashMap.put("imageUrl","");
//        hashMap.put("title","");
//        hashMap.put("des","");
//        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("cat","Tech");
        hashMap.put("imageUrl","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/08/09/tech.jpg");
        hashMap.put("title","Tech trends that will shape our future");
        hashMap.put("des","Technology is integrated into our daily lives thanks to ongoing advancements and ever-changing possibilities. Whether it's quantum computing or artificial intelligence, the next ten years will be filled with exciting developments.\n\n\n AI-Powered Augmented Reality (AR)\n" +
                "AI-powered AR applications will seamlessly integrate virtual elements into our real-world surroundings enhancing our daily experiences. From education and training to entertainment and shopping, AR will offer intuitive and immersive interactions that blur the lines between the digital and physical worlds.\n" +
                "\n" +
                "The Era of Bioinformatics\n" +
                "Biotechnology, coupled with advanced data analytics, will usher in an era of personalised medicine and revolutionary therapies. By harnessing the power of big data and AI, scientists will analyse vast genetic databases, leading to more targeted treatments and improved healthcare outcomes.\n\n\n Internet of Things (IoT) Revolution\n" +
                "This is a reference to the increasing number of devices that are linked to the internet. Such gadgets continuously collect and transmit data, which accelerates the development of big data and AI. In the next decade, cities will become smarter, utilising IoT networks to optimise traffic flow, reduce energy consumption, and enhance public safety. The seamless integration of devices and data will redefine urban living and make our surroundings more responsive and efficient.\n" +
                "\n" +
                "Quantum Computing\n" +
                "Quantum computing promises to fundamentally alter how we process information and resolve challenging issues. These supercomputers will perform calculations at speeds that are unfathomable to conventional computers by utilising the power of quantum mechanics. They will transform sectors like finance, healthcare, and encryption and open the door for scientific advances that were not previously possible. From medication development to climate modelling, the quantum age will open a world of opportunities for us that will change the entire rhythm of our existence.\n" +
                "\n" +
                "Space Exploration for All\n" +
                "The next decade will see a democratisation of space exploration, as private companies and governments collaborate to make space travel more accessible. Advancements in reusable rocket technology and orbital infrastructure will lead to space tourism becoming a reality. Additionally, interplanetary missions and colonisation efforts will capture the imagination of humanity, igniting a renewed passion for space exploration.\n\n\n The next decade holds immense promise, as technology continues its relentless march forward. Quantum computing will unlock the unimaginable, while AI-powered augmented reality will blur the lines between the digital and physical worlds. The era of bioinformatics will revolutionise healthcare. Amidst these advancements, we must remain vigilant in upholding ethical practices and preserving our privacy. Embrace the unseen and be prepared to embark on an exciting journey that will shape our future for the better.");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("cat","politics");
        hashMap.put("imageUrl","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/09/24/pm_hasina.jpg?itok=4QmHHc7c&timestamp=1695529051");
        hashMap.put("title","Won't tolerate arson, terrorism before polls: PM");
        hashMap.put("des","Prime Minister Sheikh Hasina has reiterated that no mercy will be shown to those who will engage in arson, terrorism, and atrocities in the run-up to the next national election.\n\n\n\"There will be no scope left for mercy if arson terrorism or similar incidents or attacks take place before the election in the name of movement,\" she told a community reception hosted in honour of her at the Methodist Central Hall Westminster in London.\n\n\nThe premier reminded the countrymen that the BNP-Jamaat alliance carried out mayhem across the country by burning people to death, destroying public and private properties by hurling petrol bombs at public transport such as passenger buses, trains, and launches during 2013-14 in the name of movement.\n" +
                "\n" +
                "Many people including women suffered critical burns in the arson attacks and have been leading lives in inhuman conditions, she said.\n\n\n\"We have no objection with your [BNP's] movement. You had earlier killed 29 police personnel. If any such attempt is made on the lives of my distressed people, no mercy will be shown,\" she said.\n" +
                "\n" +
                "Foreign Minister Dr AK Abdul Momen and AL Publicity and Publication Secretary Dr Abdus Sobhan Golap were present on the dais.\n" +
                "\n" +
                "UK AL President Sultan Sharif presided over the function while General Secretary Syed Sajedur Rahman Faruk moderated it.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","politics");
        hashMap.put("imageUrl","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/01/14/ballot_box_4.jpg?itok=LgO9Z7VW&timestamp=1673676690");
        hashMap.put("title","Little-known Islamist parties gearing up for polls");
        hashMap.put("des","As some major Islamist parties have made the primary decision to boycott the forthcoming national election, another group of little-known Islamist parties are planning to counter the move by fielding candidates in all 300 constituencies, multiple sources have confirmed.\n\n\nIslami Andolon Bangladesh (IAB), Bangladesh Khelafat Majlish, Khilafat Andolan, Jamiat-e-Ulama-e-Islam and Bangladesh Nezami Islami Party have already said they will not join the polls, as they believe that a free and fair election is not possible under this government. Instead, they are demanding either a caretaker government or a polls-time all-party government to administer the election.\n\n\nAgainst the backdrop, the ruling Awami League is trying to bring the rest of the Islamist parties to its fold.\n" +
                "\n" +
                "These parties -- most of them little known -- have agreed to participate in the election unilaterally as they want to emerge as the \"third force\".\n\n\nAn Islamist coalition named Liberal Islamic Alliance comprising six Islamic and like-minded political parties formed on September 1 is going to announce its possible participation in the election, slated for early January, unilaterally in every constituency, according to the sources having direct knowledge of the development.\n" +
                "\n" +
                "The six Islamic parties, newly registered with the Election Commission, are Bangladesh Supreme Party led by Syed Saifuddin Ahmed Maizbhandari, Bangladesh Islami Oikya Jote led by Misbahur Rahman Chowdhury, Krishak Sramik Party led by Farhanaz Haque, Aashiqeen-e-Awlia Oikya Parishad led by Alam Noori Sureshwari, Bangladesh Janodal and National Awami Party (NAP Bhashani).\n" +
                "\n" +
                "The announcement will be made from a rally on October 21 at the south gate of Baitul Mukarram national Mosque, where the Islamist allice plans to gather over 3 lakh people, said the sources.\n" +
                "\n\n\n\nSupreme Party Chairman Syed Saifuddin Ahmed Maizbhandari said they are making preparations to contest in all 300 constituencies.\n" +
                "\n" +
                "\"People are annoyed at the two major political parties. People have become hostage of the politics of these two parties. So, we are trying to come out as a third Islamic force,\" he told The Daily Star.\n" +
                "\n" +
                "Bangladesh Islami Oikkya Jote Chairman Misbahur Rahman Chowdhury echoed his view, and said his party too will make an announcement about joining the polls unilaterally.\n" +
                "\n" +
                "Asked about the possibility of partnering with the AL, Misbahur said it would depend on the emerging political scenario.\n\n\nAt the moment, 44 political parties, 14 of them Islamist parties, are registered with the Election Commission, a mandatory condition for contesting in any election. \n" +
                "\n" +
                "The participation of some of these Islamist parties in the election will help the ruling party to portray the polls as participatory in the absence of opposition BNP and other major Islamist parties, insiders say.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","politics");
        hashMap.put("imageUrl","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/10/02/bnp.jpg?itok=ONI4P-Ab&timestamp=1696267607");
        hashMap.put("title","BNP plotting to foil next nat’l polls");
        hashMap.put("des","Alleging that the BNP is plotting to foil the upcoming national election, Awami League General Secretary Obaidul Quader yesterday reiterated that the polls would be held as per the constitution, and no evil force could obstruct it.\n\n\n\"By questioning the legitimacy of the electoral process and taking a stand against the democratic process, the BNP is trying to disrupt the country's progress. The people are united against any attempts to unconstitutionally interfere in the election,\" he said in a statement to the media.\n\n\nQuader, also the road transport and bridges minister, took a dig at BNP leaders' \"provocative statements\".\n" +
                "\n" +
                "He said, \"In 2014,the BNP was responsible for a number of arson attacks that killed and injured hundreds of innocent people. These attacks were an attempt to foil the election.\"\n\n\nLabelling the BNP as an \"illegal\" political party, Quader said, \"The party was founded by Ziaur Rahman, who seized power at gunpoint in 1975 in an unconstitutional and illegal way.\n" +
                "\n" +
                "\"The BNP has historically not prioritised the people's welfare, the establishment of people's rights, or the development of the nation. This is why the BNP's political stance appears to rely on the favour of foreign entities. Had the party placed more trust in the people and done politics for their wellbeing, there would have not been any crisis in the country's democracy.");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("cat","Tech & Startup");
        hashMap.put("imageUrl","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/09/26/chatgpt_new_feature.png");
        hashMap.put("title","ChatGPT to launch voice chat support");
        hashMap.put("des","OpenAI has announced a new update to ChatGPT in which the popular AI chatbot will be able to give responses in the form of voice and images. In this latest update, the user can directly build a conversation with ChatGPT like Apple's Siri and Amazon's Alexa. \n" +
                "\nAdditionally, ChatGPT will get new image recognition capabilities, where users can snap an image and ask the chatbot to pay attention to a particular part using a new 'drawing tool' in the app. You can also ask ChatGPT to help you come up with a meal plan just by taking a snapshot of the contents of your fridge.\n\n\nWith this new voice chat support, users can have back-and-forth voice conversations with ChatGPT. For example, users can ask ChatGPT to request a bedtime story or settle a dinner table debate. The process works similarly to Apple's Siri and Amazon's Alexa voice assistants.\n" +
                "\n" +
                "As per OpenAI, ChatGPT's voice capability is \"powered by a new text-to-speech model, capable of generating human-like audio from just text and a few seconds of sample speech\". The company also added that to create the different animated voices in the chatbot, they have collaborated with professional voice actors to create five different voices.\n\n\n\n" +
                "ChatGPT to launch voice chat support\n" +
                "ChatGPT new feature\n" +
                "With this major update, users can have back-and-forth voice conversations with ChatGPT.\n" +
                "OpenAI has announced a new update to ChatGPT in which the popular AI chatbot will be able to give responses in the form of voice and images. In this latest update, the user can directly build a conversation with ChatGPT like Apple's Siri and Amazon's Alexa. \n" +
                "\n" +
                "\n" +
                "Additionally, ChatGPT will get new image recognition capabilities, where users can snap an image and ask the chatbot to pay attention to a particular part using a new 'drawing tool' in the app. You can also ask ChatGPT to help you come up with a meal plan just by taking a snapshot of the contents of your fridge. \n" +
                "\n" +
                "For all latest news, follow The Daily Star's Google News channel.\n" +
                "With this new voice chat support, users can have back-and-forth voice conversations with ChatGPT. For example, users can ask ChatGPT to request a bedtime story or settle a dinner table debate. The process works similarly to Apple's Siri and Amazon's Alexa voice assistants.\n" +
                "\n" +
                "As per OpenAI, ChatGPT's voice capability is \"powered by a new text-to-speech model, capable of generating human-like audio from just text and a few seconds of sample speech\". The company also added that to create the different animated voices in the chatbot, they have collaborated with professional voice actors to create five different voices.\n" +
                "\n" +
                "\n" +
                "These new features are available only for ChatGPT Plus and Enterprise users. The update is expected to be released within the next two weeks.");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("cat","Tech & Startup");
        hashMap.put("imageUrl","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/10/02/team_atlas.png");
        hashMap.put("title","Team from Bangladesh wins Gold Medal at intl. invention competition");
        hashMap.put("des","Team Atlas, a robotics team from Bangladesh, has recently earned the Gold Medal in the IT & Robotics Segment at this year's World Invention Competition and Exhibition. The team won amongst 400 competing teams from 20 participating countries, including China, Indonesia, Vietnam, Malaysia, and Thailand.\n\n\nHeld this year in Malaysia from September 22 to 26, the World Invention Competition and Exhibition (WICE) 2023 is an international competition organised by the Indonesia Young Scientist Association (IYSA) in collaboration with MAHSA University (Malaysian Allied Health Sciences Academy. The competition aims to highlight young inventors and innovative technological creations from all over the world.\n\n\nTeam Atlas consisted of Sunny Jubayer (Team Leader, Brac University), Shihab Ahmed Ananto (North South University), Fahim Shahriar Eric (University of Dhaka), Mehrab Islam Fahim (Brac University), Mehran Islam Mahim (BAF Shaheen College, Dhaka), Sakibul Ahsan Teham (Brac University), and Shanzita Siddiqa (Ideal School and College). \n" +
                "\n" +
                "\"We hope that our success will inspire other young people in Bangladesh to pursue their dreams and achieve their goals,\" shared Sunny Jubayer about the team's latest achievement.\n\n\nRecently, Team Atlas has also won a Gold Medal from the International Science and Innovation Fair 2022 at Bali, Indonesia; first runner-up in Techkriti 2023 IIT at Kanpur, India; and first runner-up in World Robotics Championship 2023 at Delhi, India. \n" +
                "\n" +
                "Regarding the accomplishment, Md. Saiful Islam, Advisor of Team Atlas and Senior Lecturer at Brac University, shared, \"Team Atlas has repeatedly shown that Bangladeshi students are capable of competing with the best in the world. Their success is a source of inspiration for all of us.\"\n" +
                "\n" +
                "For the World Invention Competition and Exhibition 2023, Team Atlas participated with their own-made firefighting robot called Defender. As per Team Atlas, the Defender robot is built with advanced remote control technology, and it is capable of controlling the spread of fire by going directly into the source. It is equipped with various sensors, image processing technology, and real-time navigation tools that help it make necessary decisions automatically. The autonomous robot is also equipped with a first-aid box to help anyone injured by fire.\n\n\nTeam Atlas adds that a robot like Defender will help control fire-related incidents that have recently become quite common in Bangladesh. Since Defender can directly tackle the source of the fire, it reduces the risk for human firefighters and can help mitigate injuries and casualties caused by fire-related incidents.");
        arrayList.add(hashMap);

    }

}//AppCompatActivity================================================================================