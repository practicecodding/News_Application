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
        hashMap.put("cat","Technology");
        hashMap.put("imageUrl","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/08/28/ezgif.com-webp-to-jpg.jpg");
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
        hashMap.put("cat","nothing");
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

    }

}//AppCompatActivity================================================================================