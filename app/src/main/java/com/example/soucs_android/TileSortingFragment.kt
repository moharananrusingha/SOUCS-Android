package com.example.soucs_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.soucs_android.adapters.TilesAdapter
import com.example.soucs_android.utils.RecyclerViewDragDetector
import com.example.soucs_android.viewmodels.TileListViewModel
import com.google.android.material.button.MaterialButton
import com.example.soucs_android.data.Tile
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TileSortingFragment : Fragment() {

    private val viewModel: TileListViewModel by viewModels()
    private lateinit var adapter: TilesAdapter
    private var tileList: MutableList<Tile> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_tile_sorting,container,false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.tiles_rcv)
        ItemTouchHelper(object : RecyclerViewDragDetector() {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                tileList[viewHolder.adapterPosition] = tileList[target.adapterPosition].also {
                    tileList[target.adapterPosition] = tileList[viewHolder.adapterPosition] }
                tileList[viewHolder.adapterPosition].sortId = tileList[target.adapterPosition].also {
                    tileList[target.adapterPosition].sortId = tileList[viewHolder.adapterPosition].sortId }.sortId
                adapter.notifyItemMoved(viewHolder.adapterPosition, target.adapterPosition)

                return true
            }
            override fun isLongPressDragEnabled(): Boolean {
                return true
            }
        }).attachToRecyclerView(recyclerView)
        adapter = TilesAdapter()
        recyclerView.adapter = adapter
        viewModel.tiles.observe(viewLifecycleOwner){
            it?.let { tileList = it as MutableList<Tile>
                adapter.submitList(it)
            }
        }
        view.findViewById<MaterialButton>(R.id.btn_show_result).setOnClickListener {
            val grade = (0..4).random()
            val action = TileSortingFragmentDirections.actionTileSortingFragmentToResultFragment(grade)
            it.findNavController().navigate(action)
        }
        return view
    }
}