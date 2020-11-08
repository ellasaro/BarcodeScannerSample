package com.blackfrogweb.barcodescannersample

import androidx.lifecycle.*
import androidx.navigation.NavDirections
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.ConnectException

class ScanBarcodeViewModel : ViewModel() {

    val progressState: LiveData<Boolean> get() = _progressState
    private val _progressState = MutableLiveData<Boolean>()

    val navigation: LiveData<NavDirections?> get() = _navigation
    private val _navigation = MutableLiveData<NavDirections?>()

    init {
        _progressState.value = false
    }

    fun searchBarcode(barcode: String) {
        _progressState.value = true
        viewModelScope.launch {
            delay(1000)
            _navigation.value = ScanBarcodeFragmentDirections.scanDestinationToSuccessDestination(barcode)
            _progressState.value = false
        }
    }

    fun doneNavigating() {
        _navigation.value = null
    }
}