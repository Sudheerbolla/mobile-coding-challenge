package com.audiobookstask.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.audiobookstask.data.model.PodcastsModel
import com.audiobookstask.data.model.PodcastsResponse
import com.audiobookstask.data.repo.PodCastRepository
import kotlinx.coroutines.launch

class PodcastsViewModel() : ViewModel() {
    private val repository = PodCastRepository()

    private val _podCasts = MutableLiveData<PodcastsResponse>()
    val podCasts: LiveData<PodcastsResponse> = _podCasts

    fun fetchPodCasts() {
        viewModelScope.launch {
            try {
                val cards = repository.getPodCasts(5)
                _podCasts.value = cards
            } catch (e: Exception) {
                // Handle error
                Log.e("Podcasts", e.message.toString());
            }
        }
    }

    fun getSelectedPodCastItem(id: String): PodcastsModel {
        return podCasts.value!!.podcasts.first {
            it.id == id
        }
    }

}