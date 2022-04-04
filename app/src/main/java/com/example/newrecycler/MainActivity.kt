package com.example.newrecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newrecycler.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnCarItemClickListner{

    lateinit var binding: ActivityMainBinding
    lateinit var carlist: ArrayList<Cars>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        carlist = ArrayList()
        addCars()

        carRecycler.layoutManager = LinearLayoutManager(this)
        carRecycler.addItemDecoration(DividerItemDecoration(this,1))
        carRecycler.adapter = CarAdapter(carlist,this)
    }

    fun addCars(){
        carlist.add(Cars("Tata","Tata Motors Limited is an Indian multinational automotive manufacturing company, headquartered in the city of Mumbai, India which is part of Tata Group. The company produces passenger cars, trucks, vans, coaches, buses, luxury cars, sports cars, construction equipment.", R.drawable.tatamotors) )
        carlist.add(Cars("Toyota","Toyota Motor Corporation is a Japanese multinational automotive manufacturer headquartered in Toyota City, Aichi, Japan. It was founded by Kiichiro Toyoda and incorporated on August 28, 1937. Toyota is one of the largest automobile manufacturers in the world, producing about 10 million vehicles per year.", R.drawable.toyota) )
        carlist.add(Cars("Hyundai","Hyundai Motor Company, often abbreviated to Hyundai Motors and commonly known as Hyundai, is a South Korean multinational automotive manufacturer headquartered in Seoul, South Korea. Hyundai Motor Company was founded in 1967.", R.drawable.hyundai) )
        carlist.add(Cars("Marcedese","Mercedes-Benz, commonly referred to as Mercedes, is a German luxury automotive brand. Both Mercedes-Benz and Mercedes-Benz AG are headquartered in Stuttgart, Baden-Württemberg, Germany. Mercedes-Benz produces consumer luxury vehicles and commercial vehicles", R.drawable.marcedese) )
        carlist.add(Cars("Bentley","Bentley Motors Limited is a British manufacturer and marketer of luxury cars and SUVs, and a subsidiary of the Volkswagen Group since 1998. Headquartered in Crewe, England, the company was founded as Bentley Motors Limited by W. O", R.drawable.bentley) )
        carlist.add(Cars("Nissan"," Nissan Motor Co., Ltd. is a Japanese multinational automobile manufacturer headquartered in Nishi-ku, Yokohama, Japan. The company sells its vehicles under the Nissan, Infiniti, and Datsun brands, with in-house performance tuning products labelled Nismo.  ", R.drawable.nissan) )
        carlist.add(Cars("Ford","Ford Motor Company is an American multinational automobile manufacturer headquartered in Dearborn, Michigan, United States. It was founded by Henry Ford and incorporated on June 16, 1903. The company sells automobiles and commercial vehicles under the Ford brand, and luxury cars under its Lincoln luxury brand.", R.drawable.ford) )
        carlist.add(Cars("kia","Kia Corporation, commonly known as Kia (Korean: 기아; Hanja: 起亞; RR: Gia; MR: Kia, IPA: [ki.a]; formerly known as Kyungsung Precision Industry and Kia Motors Corporation, and stylized as KIΛ), is a South Korean multinational automobile manufacturer headquartered in Seoul, South Korea. It is South Korea's second largest automobile manufacturer .", R.drawable.kia) )
        carlist.add(Cars("Bajaj","Bajaj Auto Limited is an Indian multinational automotive manufacturing company based in Pune. It manufactures motorcycles, scooters and auto rickshaws. Bajaj Auto is a part of the Bajaj Group. It was founded by Jamnalal Bajaj in Rajasthan in the 1940s. The company has plants in Chakan, Waluj and Pantnagar..", R.drawable.bajaj) )


    }

    override fun onItemClick(item: Cars, position: Int) {
//        Toast.makeText(this, item.name , Toast.LENGTH_SHORT).show()
         val intent = Intent(this, CarDetailsActivity::class.java)
         intent.putExtra("CARNAME", item.name)
        intent.putExtra("CARDESC", item.description)
        intent.putExtra("CARLOGO", item.logo.toString())
        startActivity(intent)


    }
}
