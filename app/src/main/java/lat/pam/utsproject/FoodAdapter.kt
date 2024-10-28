package lat.pam.utsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FoodAdapter(private val foodList: List<Food>, private val onItemClick: (Food) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.bind(food)
        // Set the click listener to handle item clicks
        holder.itemView.setOnClickListener { onItemClick(food) }
    }

    override fun getItemCount(): Int = foodList.size

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foodName: TextView = itemView.findViewById(R.id.foodName)
        private val foodDescription: TextView = itemView.findViewById(R.id.foodDescription)
        private val foodImage: ImageView = itemView.findViewById(R.id.foodImage)

        fun bind(food: Food) {
            foodName.text = food.name
            foodDescription.text = food.description
            foodImage.setImageResource(food.imageResourceId)
        }
    }
}