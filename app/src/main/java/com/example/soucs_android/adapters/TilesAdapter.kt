package com.example.soucs_android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.soucs_android.R
import com.example.soucs_android.data.Tile

class TilesAdapter : ListAdapter<Tile, TilesAdapter.MenuItemViewHolder>(TilesDiffCallback()){

    inner class MenuItemViewHolder(private val tilesItemView: View):
        RecyclerView.ViewHolder(tilesItemView){
        fun bind(tile: Tile){
            tilesItemView.findViewById<ImageView>(R.id.tile_item_image).scaleType = ImageView.ScaleType.CENTER_CROP
            tilesItemView.findViewById<TextView>(R.id.tile_item_name).text = tile.name
            tilesItemView.findViewById<TextView>(R.id.tile_item_desc).text = tile.description
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder =
        MenuItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tiles_item_view,parent,false)
        )
    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) = holder.bind(getItem(position))

}
private class TilesDiffCallback: DiffUtil.ItemCallback<Tile>() {
    override fun areItemsTheSame(oldItem: Tile, newItem: Tile): Boolean {
        return oldItem.tileId == newItem.tileId
    }

    override fun areContentsTheSame(oldItem: Tile, newItem: Tile): Boolean {
        return oldItem == newItem
    }

}