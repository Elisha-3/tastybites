package com.nyati.tastybites

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
// This is an Adapter that Creates The data to Put in Our Recycler View.
class RecyclerAdapter(var context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    // Array of Food titles    
    private val titles = arrayOf("Yummy Breakfast","Pizza", "Steak", "Chicken Fry", "Nigerian cuisine", "Fried Sauce Meat", "African Stew", "Omellete", "Fried egg", "Barbeque")
    // Array of Food Details  
    private val details = arrayOf(
        "A delightful start to the day, a yummy breakfast can include a mix of fluffy pancakes drizzled with maple syrup, crispy bacon, perfectly scrambled eggs, and fresh fruit. The combination of sweet and savory, along with a steaming cup of coffee or tea, makes it an irresistible morning treat.",
        "A beloved classic, pizza features a crispy crust topped with a rich tomato sauce, melted mozzarella cheese, and a variety of toppings like pepperoni, bell peppers, and olives. Each slice offers a symphony of flavors and textures, perfect for sharing or enjoying solo, whether hot from the oven or cold from the fridge.",
        "Juicy and tender, a perfectly cooked steak is a carnivore's dream. Grilled to your desired doneness, it boasts a flavorful crust and a succulent, pink interior. Often seasoned with salt and pepper, it can be complemented by a side of creamy mashed potatoes, sautéed vegetables, or a rich red wine sauce.",
        "Golden and crispy, fried chicken is a comfort food favorite. The chicken is marinated, seasoned, and deep-fried to perfection, resulting in a crunchy exterior that gives way to tender, juicy meat. Often served with sides like coleslaw, biscuits, or fries, it’s a hearty meal that satisfies every craving.",
        "Rich and diverse, Nigerian cuisine showcases a vibrant array of flavors and ingredients. Staples like jollof rice, pounded yam, and egusi soup reflect the country’s culinary heritage. Meals are often accompanied by spicy stews and grilled meats, making every dish a celebration of culture and tradition.",
        "A savory dish, fried sauce meat features tender pieces of meat (often beef or chicken) cooked until golden and then simmered in a rich, spicy tomato sauce. This dish is typically served with rice or fufu, allowing the flavors to meld beautifully in every bite.",
        "Hearty and aromatic, African stew varies by region but often includes a medley of meats, vegetables, and spices simmered to perfection. Common ingredients like tomatoes, onions, and peppers create a thick, flavorful base that pairs wonderfully with rice, bread, or plantains.",
        "Fluffy and versatile, an omelette is a breakfast staple made from beaten eggs cooked until set, then filled with a variety of ingredients like cheese, vegetables, and meats. Whether topped with herbs or served plain, it’s a quick and satisfying meal any time of day.",
        "Simple yet delicious, a fried egg features a golden yolk encased in a tender white. Cooked sunny-side up or over-easy, it’s often served alongside toast or incorporated into dishes like rice and beans, adding richness and flavor with each bite.",
        "A celebration of smoky flavors, barbeque involves slow-cooked meats like ribs, brisket, or chicken, often slathered in tangy sauce. The grilling process imparts a charred, caramelized crust that enhances the savory taste, making it a favorite for gatherings and outdoor feasts."
    )
    // Array of Food costs
    private val cost = arrayOf("KES 600", "KES 2200", "KES 2000", "KES 800", "KES 1500", "KES 1200", "KES 1000", "KES 1100", "KES 300", "KES 200")

    // Array of Food images  
    private val images = intArrayOf(
        R.drawable.food,
        R.drawable.pizza,
        R.drawable.steak,
        R.drawable.chicken_fry,
        R.drawable.food5,
        R.drawable.friedsauce,
        R.drawable.africanstew,
        R.drawable.omellete,
        R.drawable.friedegg,
        R.drawable.barbeque,

    )

    // Access the Single item XML Layout
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.singleitem, viewGroup, false)
        return ViewHolder(v)
    }
    
    //View Holder that does find Views in single item XML, 1 ImageView, 3 TextView    
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemCost: TextView

        init {
            itemImage= itemView.findViewById(R.id.item_image)
            itemTitle= itemView.findViewById(R.id.item_title)
            itemDetail= itemView.findViewById(R.id.item_description)
            itemCost= itemView.findViewById(R.id.item_cost)


        

        }
    }

    //Set Items from Arrays and Put/Bind them in respectives Views    
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemCost.text = cost[i]
        
        //Below to be Done At the End to demonstrate how to move to Next Page on Item Click
        viewHolder.itemView.setOnClickListener {

            val intent = Intent(context, SingleItemActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)


      }
    }

    // Get how many items the array have, All arrays must have equal sizes
    override fun getItemCount(): Int {
        return titles.size
    }
}