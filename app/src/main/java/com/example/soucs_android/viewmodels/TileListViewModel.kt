package com.example.soucs_android.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.soucs_android.data.Tile
import com.example.soucs_android.data.TileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * The ViewModel for [TilesSortingActivity].
 */
@HiltViewModel
class TileListViewModel @Inject constructor(tileRepository: TileRepository): ViewModel(), LifecycleObserver {

    val tiles: LiveData<List<Tile>> = tileRepository.getTiles().asLiveData()
}