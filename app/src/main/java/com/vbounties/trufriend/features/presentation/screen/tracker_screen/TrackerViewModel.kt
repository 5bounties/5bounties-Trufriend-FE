package com.vbounties.trufriend.features.presentation.screen.tracker_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vbounties.trufriend.features.domain.model.JournalModel
import com.vbounties.trufriend.features.domain.repository.JournalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackerViewModel @Inject constructor(
    private val repository: JournalRepository
): ViewModel() {
    fun postJournal(request: JournalModel){
        viewModelScope.launch {
            repository.postStoreJournal(request).collect{

            }
        }
    }

    fun getAllJournal(){
        viewModelScope.launch {
            repository.getJournals().collect {

            }
        }
    }

}